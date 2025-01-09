package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class eliminaliquidacion extends GXProcedure
{
   public eliminaliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( eliminaliquidacion.class ), "" );
   }

   public eliminaliquidacion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      eliminaliquidacion.this.AV10CliCod = aP0;
      eliminaliquidacion.this.AV8EmpCod = aP1;
      eliminaliquidacion.this.AV9LiqNro = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV10CliCod, AV40Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV10CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))) ;
      GXv_boolean1[0] = AV23procesandoHay ;
      GXv_int2[0] = AV22procesandoLiqNro ;
      GXv_char3[0] = AV24procesandoError ;
      new web.hayalgunaliquidacionprocesando(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV9LiqNro, AV31collectionLegnumero, GXv_boolean1, GXv_int2, GXv_char3) ;
      eliminaliquidacion.this.AV23procesandoHay = GXv_boolean1[0] ;
      eliminaliquidacion.this.AV22procesandoLiqNro = GXv_int2[0] ;
      eliminaliquidacion.this.AV24procesandoError = GXv_char3[0] ;
      if ( AV23procesandoHay )
      {
         new web.alert(remoteHandle, context).execute( "error", GXutil.trim( AV24procesandoError)+" "+GXutil.trim( GXutil.str( AV22procesandoLiqNro, 8, 0))) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXv_char3[0] = AV12error ;
      new web.resetearecibos(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV9LiqNro, 0, GXv_char3) ;
      eliminaliquidacion.this.AV12error = GXv_char3[0] ;
      if ( ! (GXutil.strcmp("", AV12error)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Error al eliminar recibo. ", "")+GXutil.trim( AV12error)) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char4 = AV26egresoTLiqCod ;
      GXt_char5 = AV26egresoTLiqCod ;
      GXv_char3[0] = GXt_char5 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      eliminaliquidacion.this.GXt_char5 = GXv_char3[0] ;
      GXv_char6[0] = GXt_char4 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char5, GXv_char6) ;
      eliminaliquidacion.this.GXt_char4 = GXv_char6[0] ;
      AV26egresoTLiqCod = GXt_char4 ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1649LSDSec = P004K2_A1649LSDSec[0] ;
         A1EmpCod = P004K2_A1EmpCod[0] ;
         A3CliCod = P004K2_A3CliCod[0] ;
         A1733LSD1LiqNro = P004K2_A1733LSD1LiqNro[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "1") ;
         /* Using cursor P004K3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A1657LSD2Sec = P004K3_A1657LSD2Sec[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "2") ;
            /* Using cursor P004K4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1666LSD3Sec = P004K4_A1666LSD3Sec[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "3") ;
               /* Using cursor P004K5 */
               pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
               pr_default.readNext(2);
            }
            pr_default.close(2);
            /* Using cursor P004K6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            while ( (pr_default.getStatus(4) != 101) )
            {
               A1674LSD4Sec = P004K6_A1674LSD4Sec[0] ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "4") ;
               /* Using cursor P004K7 */
               pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
               pr_default.readNext(4);
            }
            pr_default.close(4);
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "5") ;
            /* Using cursor P004K8 */
            pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
            pr_default.readNext(1);
         }
         pr_default.close(1);
         /* Using cursor P004K9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A1721LSD5Sec = P004K9_A1721LSD5Sec[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "6") ;
            /* Using cursor P004K10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1721LSD5Sec)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg5");
            pr_default.readNext(7);
         }
         pr_default.close(7);
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "7") ;
         /* Using cursor P004K11 */
         pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg1");
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "8") ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "9") ;
      pr_default.dynParam(10, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A31LiqNro = P004K12_A31LiqNro[0] ;
         A1EmpCod = P004K12_A1EmpCod[0] ;
         A3CliCod = P004K12_A3CliCod[0] ;
         A1129LiqExAnio = P004K12_A1129LiqExAnio[0] ;
         A6LegNumero = P004K12_A6LegNumero[0] ;
         A1127LiqExenConCodigo = P004K12_A1127LiqExenConCodigo[0] ;
         A1128LiqExAplIIGG = P004K12_A1128LiqExAplIIGG[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "10") ;
         /* Using cursor P004K13 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1129LiqExAnio), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), A1127LiqExenConCodigo, Short.valueOf(A1128LiqExAplIIGG)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacion_exencion");
         new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, "11") ;
         pr_default.readNext(10);
      }
      pr_default.close(10);
      pr_default.dynParam(12, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         A31LiqNro = P004K14_A31LiqNro[0] ;
         A1EmpCod = P004K14_A1EmpCod[0] ;
         A3CliCod = P004K14_A3CliCod[0] ;
         A269LiqDCanti = P004K14_A269LiqDCanti[0] ;
         n269LiqDCanti = P004K14_n269LiqDCanti[0] ;
         A6LegNumero = P004K14_A6LegNumero[0] ;
         A81LiqDSecuencial = P004K14_A81LiqDSecuencial[0] ;
         /* Using cursor P004K15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
         pr_default.readNext(12);
      }
      pr_default.close(12);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "!LegLinkS3Html 1", "")) ;
      pr_default.dynParam(14, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         A31LiqNro = P004K16_A31LiqNro[0] ;
         A1EmpCod = P004K16_A1EmpCod[0] ;
         A3CliCod = P004K16_A3CliCod[0] ;
         A2278LegLinkS3Html = P004K16_A2278LegLinkS3Html[0] ;
         A2285LinkLegNumero = P004K16_A2285LinkLegNumero[0] ;
         A2277LegLinkTiporec = P004K16_A2277LegLinkTiporec[0] ;
         /* Using cursor P004K17 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A2285LinkLegNumero), A2277LegLinkTiporec});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajoLinkPdf");
         pr_default.readNext(14);
      }
      pr_default.close(14);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "LegLinkS3Html 2", "")) ;
      pr_default.dynParam(16, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A2371LiqBatchLiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(16) != 101) )
      {
         A2373LiqBatchSeccion = P004K18_A2373LiqBatchSeccion[0] ;
         A2372LiqBatchCod = P004K18_A2372LiqBatchCod[0] ;
         A2371LiqBatchLiqNro = P004K18_A2371LiqBatchLiqNro[0] ;
         A1EmpCod = P004K18_A1EmpCod[0] ;
         A3CliCod = P004K18_A3CliCod[0] ;
         /* Optimized DELETE. */
         /* Using cursor P004K19 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A2371LiqBatchLiqNro), A2372LiqBatchCod, A2373LiqBatchSeccion});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3Leg");
         /* End optimized DELETE. */
         /* Using cursor P004K20 */
         pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A2371LiqBatchLiqNro), A2372LiqBatchCod, A2373LiqBatchSeccion});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLotes3");
         pr_default.readNext(16);
      }
      pr_default.close(16);
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "LegLinkS3Html 3", "")) ;
      pr_default.dynParam(19, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(19) != 101) )
      {
         A31LiqNro = P004K21_A31LiqNro[0] ;
         A1EmpCod = P004K21_A1EmpCod[0] ;
         A3CliCod = P004K21_A3CliCod[0] ;
         A281LiqLegImpTotal = P004K21_A281LiqLegImpTotal[0] ;
         A6LegNumero = P004K21_A6LegNumero[0] ;
         AV27LegNumero = A6LegNumero ;
         AV20auxLiqNro = A31LiqNro ;
         AV18LiqAltaNro = A31LiqNro ;
         AV19LiqNuevaNro = A31LiqNro ;
         /* Execute user subroutine: 'DELETE LIQUIDACIONCALCULO' */
         S121 ();
         if ( returnInSub )
         {
            pr_default.close(19);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'DELETE LIQLEGCONCEPTOCUENTA' */
         S131 ();
         if ( returnInSub )
         {
            pr_default.close(19);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'DELETE LIQLEGOBLIGACIONCUENTA' */
         S141 ();
         if ( returnInSub )
         {
            pr_default.close(19);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'DESVINCULAR NOVEDADES' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(19);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXt_char5 = AV25TLiqCod ;
         GXv_char6[0] = GXt_char5 ;
         new web.gettipoliq(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, A31LiqNro, GXv_char6) ;
         eliminaliquidacion.this.GXt_char5 = GXv_char6[0] ;
         AV25TLiqCod = GXt_char5 ;
         if ( GXutil.strcmp(AV25TLiqCod, AV26egresoTLiqCod) == 0 )
         {
            new web.actualizarlegajoactivo(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, A6LegNumero, (byte)(1)) ;
            new web.desasignarliqpermanencia(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, A6LegNumero, A31LiqNro) ;
            new web.desasignarconsumoslicegr(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, A31LiqNro, A6LegNumero) ;
         }
         AV34coll_LegNumero.add((int)(A6LegNumero), 0);
         /* Using cursor P004K22 */
         pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionLegajo");
         pr_default.readNext(19);
      }
      pr_default.close(19);
      if ( GXutil.strcmp(AV25TLiqCod, AV26egresoTLiqCod) == 0 )
      {
         AV35i = (short)(1) ;
         while ( AV35i <= AV34coll_LegNumero.size() )
         {
            new web.inicializarperiodoscclic(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, ((Number) AV34coll_LegNumero.elementAt(-1+AV35i)).intValue(), (short)(0)) ;
            AV35i = (short)(AV35i+1) ;
         }
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminaliquidacion");
      pr_default.dynParam(21, new Object[]{ new Object[]{
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(AV10CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P004K23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
      while ( (pr_default.getStatus(21) != 101) )
      {
         A31LiqNro = P004K23_A31LiqNro[0] ;
         A1EmpCod = P004K23_A1EmpCod[0] ;
         A3CliCod = P004K23_A3CliCod[0] ;
         A98LiqFecha = P004K23_A98LiqFecha[0] ;
         AV36retroLiqNro.add((int)(A31LiqNro), 0);
         pr_default.readNext(21);
      }
      pr_default.close(21);
      AV37r = (short)(1) ;
      while ( AV37r <= AV36retroLiqNro.size() )
      {
         AV20auxLiqNro = ((Number) AV36retroLiqNro.elementAt(-1+AV37r)).intValue() ;
         /* Execute user subroutine: 'ELIMINAR RETROACTIVAS' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV37r = (short)(AV37r+1) ;
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminaliquidacion");
      if ( ! (0==AV9LiqNro) )
      {
         /* Optimized DELETE. */
         /* Using cursor P004K24 */
         pr_default.execute(22, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* End optimized DELETE. */
      }
      else
      {
         /* Optimized DELETE. */
         /* Using cursor P004K25 */
         pr_default.execute(23, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
         /* End optimized DELETE. */
      }
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminaliquidacion");
      cleanup();
   }

   public void S111( )
   {
      /* 'DESVINCULAR NOVEDADES' Routine */
      returnInSub = false ;
      /* Optimized UPDATE. */
      /* Using cursor P004K26 */
      pr_default.execute(24, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV27LegNumero), Integer.valueOf(AV20auxLiqNro)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("AgendaNovedades");
      /* End optimized UPDATE. */
   }

   public void S121( )
   {
      /* 'DELETE LIQUIDACIONCALCULO' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P004K27 */
      pr_default.execute(25, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV20auxLiqNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("liquidacionLegajoCalculos");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P004K28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV20auxLiqNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqDetForOperandos");
      /* End optimized DELETE. */
   }

   public void S131( )
   {
      /* 'DELETE LIQLEGCONCEPTOCUENTA' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P004K29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV19LiqNuevaNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P004K30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV18LiqAltaNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegConceptoCuenta");
      /* End optimized DELETE. */
   }

   public void S141( )
   {
      /* 'DELETE LIQLEGOBLIGACIONCUENTA' Routine */
      returnInSub = false ;
      /* Optimized DELETE. */
      /* Using cursor P004K31 */
      pr_default.execute(29, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV19LiqNuevaNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
      /* End optimized DELETE. */
      /* Optimized DELETE. */
      /* Using cursor P004K32 */
      pr_default.execute(30, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV18LiqAltaNro), Integer.valueOf(AV27LegNumero)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LiqLegObligacionCuenta");
      /* End optimized DELETE. */
   }

   public void S151( )
   {
      /* 'ELIMINAR RETROACTIVAS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV40Pgmname, httpContext.getMessage( "eliminar retroactivas ", "")+GXutil.trim( GXutil.str( AV20auxLiqNro, 8, 0))) ;
      new web.eliminarliquisretroactivas(remoteHandle, context).execute( AV10CliCod, AV8EmpCod, AV20auxLiqNro) ;
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "eliminaliquidacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV40Pgmname = "" ;
      AV31collectionLegnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_boolean1 = new boolean[1] ;
      GXv_int2 = new int[1] ;
      AV24procesandoError = "" ;
      AV12error = "" ;
      AV26egresoTLiqCod = "" ;
      GXt_char4 = "" ;
      GXv_char3 = new String[1] ;
      scmdbuf = "" ;
      P004K2_A1649LSDSec = new int[1] ;
      P004K2_A1EmpCod = new short[1] ;
      P004K2_A3CliCod = new int[1] ;
      P004K2_A1733LSD1LiqNro = new int[1] ;
      P004K3_A3CliCod = new int[1] ;
      P004K3_A1EmpCod = new short[1] ;
      P004K3_A1649LSDSec = new int[1] ;
      P004K3_A1657LSD2Sec = new int[1] ;
      P004K4_A3CliCod = new int[1] ;
      P004K4_A1EmpCod = new short[1] ;
      P004K4_A1649LSDSec = new int[1] ;
      P004K4_A1657LSD2Sec = new int[1] ;
      P004K4_A1666LSD3Sec = new short[1] ;
      P004K6_A3CliCod = new int[1] ;
      P004K6_A1EmpCod = new short[1] ;
      P004K6_A1649LSDSec = new int[1] ;
      P004K6_A1657LSD2Sec = new int[1] ;
      P004K6_A1674LSD4Sec = new short[1] ;
      P004K9_A3CliCod = new int[1] ;
      P004K9_A1EmpCod = new short[1] ;
      P004K9_A1649LSDSec = new int[1] ;
      P004K9_A1721LSD5Sec = new int[1] ;
      P004K12_A31LiqNro = new int[1] ;
      P004K12_A1EmpCod = new short[1] ;
      P004K12_A3CliCod = new int[1] ;
      P004K12_A1129LiqExAnio = new short[1] ;
      P004K12_A6LegNumero = new int[1] ;
      P004K12_A1127LiqExenConCodigo = new String[] {""} ;
      P004K12_A1128LiqExAplIIGG = new short[1] ;
      A1127LiqExenConCodigo = "" ;
      P004K14_A31LiqNro = new int[1] ;
      P004K14_A1EmpCod = new short[1] ;
      P004K14_A3CliCod = new int[1] ;
      P004K14_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004K14_n269LiqDCanti = new boolean[] {false} ;
      P004K14_A6LegNumero = new int[1] ;
      P004K14_A81LiqDSecuencial = new int[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      P004K16_A31LiqNro = new int[1] ;
      P004K16_A1EmpCod = new short[1] ;
      P004K16_A3CliCod = new int[1] ;
      P004K16_A2278LegLinkS3Html = new String[] {""} ;
      P004K16_A2285LinkLegNumero = new int[1] ;
      P004K16_A2277LegLinkTiporec = new String[] {""} ;
      A2278LegLinkS3Html = "" ;
      A2277LegLinkTiporec = "" ;
      P004K18_A2373LiqBatchSeccion = new String[] {""} ;
      P004K18_A2372LiqBatchCod = new String[] {""} ;
      P004K18_A2371LiqBatchLiqNro = new int[1] ;
      P004K18_A1EmpCod = new short[1] ;
      P004K18_A3CliCod = new int[1] ;
      A2373LiqBatchSeccion = "" ;
      A2372LiqBatchCod = "" ;
      P004K21_A31LiqNro = new int[1] ;
      P004K21_A1EmpCod = new short[1] ;
      P004K21_A3CliCod = new int[1] ;
      P004K21_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P004K21_A6LegNumero = new int[1] ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      AV25TLiqCod = "" ;
      GXt_char5 = "" ;
      GXv_char6 = new String[1] ;
      AV34coll_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      P004K23_A31LiqNro = new int[1] ;
      P004K23_A1EmpCod = new short[1] ;
      P004K23_A3CliCod = new int[1] ;
      P004K23_A98LiqFecha = new java.util.Date[] {GXutil.nullDate()} ;
      A98LiqFecha = GXutil.nullDate() ;
      AV36retroLiqNro = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.eliminaliquidacion__default(),
         new Object[] {
             new Object[] {
            P004K2_A1649LSDSec, P004K2_A1EmpCod, P004K2_A3CliCod, P004K2_A1733LSD1LiqNro
            }
            , new Object[] {
            P004K3_A3CliCod, P004K3_A1EmpCod, P004K3_A1649LSDSec, P004K3_A1657LSD2Sec
            }
            , new Object[] {
            P004K4_A3CliCod, P004K4_A1EmpCod, P004K4_A1649LSDSec, P004K4_A1657LSD2Sec, P004K4_A1666LSD3Sec
            }
            , new Object[] {
            }
            , new Object[] {
            P004K6_A3CliCod, P004K6_A1EmpCod, P004K6_A1649LSDSec, P004K6_A1657LSD2Sec, P004K6_A1674LSD4Sec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P004K9_A3CliCod, P004K9_A1EmpCod, P004K9_A1649LSDSec, P004K9_A1721LSD5Sec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P004K12_A31LiqNro, P004K12_A1EmpCod, P004K12_A3CliCod, P004K12_A1129LiqExAnio, P004K12_A6LegNumero, P004K12_A1127LiqExenConCodigo, P004K12_A1128LiqExAplIIGG
            }
            , new Object[] {
            }
            , new Object[] {
            P004K14_A31LiqNro, P004K14_A1EmpCod, P004K14_A3CliCod, P004K14_A269LiqDCanti, P004K14_n269LiqDCanti, P004K14_A6LegNumero, P004K14_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            P004K16_A31LiqNro, P004K16_A1EmpCod, P004K16_A3CliCod, P004K16_A2278LegLinkS3Html, P004K16_A2285LinkLegNumero, P004K16_A2277LegLinkTiporec
            }
            , new Object[] {
            }
            , new Object[] {
            P004K18_A2373LiqBatchSeccion, P004K18_A2372LiqBatchCod, P004K18_A2371LiqBatchLiqNro, P004K18_A1EmpCod, P004K18_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P004K21_A31LiqNro, P004K21_A1EmpCod, P004K21_A3CliCod, P004K21_A281LiqLegImpTotal, P004K21_A6LegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            P004K23_A31LiqNro, P004K23_A1EmpCod, P004K23_A3CliCod, P004K23_A98LiqFecha
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV40Pgmname = "EliminaLiquidacion" ;
      /* GeneXus formulas. */
      AV40Pgmname = "EliminaLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A1666LSD3Sec ;
   private short A1674LSD4Sec ;
   private short A1129LiqExAnio ;
   private short A1128LiqExAplIIGG ;
   private short AV35i ;
   private short AV37r ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV9LiqNro ;
   private int AV22procesandoLiqNro ;
   private int GXv_int2[] ;
   private int A1733LSD1LiqNro ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int A1657LSD2Sec ;
   private int A1721LSD5Sec ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int A2285LinkLegNumero ;
   private int A2371LiqBatchLiqNro ;
   private int AV27LegNumero ;
   private int AV20auxLiqNro ;
   private int AV18LiqAltaNro ;
   private int AV19LiqNuevaNro ;
   private int A1254AgeLiqNro ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private String AV40Pgmname ;
   private String AV26egresoTLiqCod ;
   private String GXt_char4 ;
   private String GXv_char3[] ;
   private String scmdbuf ;
   private String A1127LiqExenConCodigo ;
   private String A2277LegLinkTiporec ;
   private String A2373LiqBatchSeccion ;
   private String AV25TLiqCod ;
   private String GXt_char5 ;
   private String GXv_char6[] ;
   private java.util.Date A98LiqFecha ;
   private boolean AV23procesandoHay ;
   private boolean GXv_boolean1[] ;
   private boolean returnInSub ;
   private boolean n269LiqDCanti ;
   private String AV24procesandoError ;
   private String AV12error ;
   private String A2278LegLinkS3Html ;
   private String A2372LiqBatchCod ;
   private GXSimpleCollection<Integer> AV31collectionLegnumero ;
   private GXSimpleCollection<Integer> AV34coll_LegNumero ;
   private GXSimpleCollection<Integer> AV36retroLiqNro ;
   private IDataStoreProvider pr_default ;
   private int[] P004K2_A1649LSDSec ;
   private short[] P004K2_A1EmpCod ;
   private int[] P004K2_A3CliCod ;
   private int[] P004K2_A1733LSD1LiqNro ;
   private int[] P004K3_A3CliCod ;
   private short[] P004K3_A1EmpCod ;
   private int[] P004K3_A1649LSDSec ;
   private int[] P004K3_A1657LSD2Sec ;
   private int[] P004K4_A3CliCod ;
   private short[] P004K4_A1EmpCod ;
   private int[] P004K4_A1649LSDSec ;
   private int[] P004K4_A1657LSD2Sec ;
   private short[] P004K4_A1666LSD3Sec ;
   private int[] P004K6_A3CliCod ;
   private short[] P004K6_A1EmpCod ;
   private int[] P004K6_A1649LSDSec ;
   private int[] P004K6_A1657LSD2Sec ;
   private short[] P004K6_A1674LSD4Sec ;
   private int[] P004K9_A3CliCod ;
   private short[] P004K9_A1EmpCod ;
   private int[] P004K9_A1649LSDSec ;
   private int[] P004K9_A1721LSD5Sec ;
   private int[] P004K12_A31LiqNro ;
   private short[] P004K12_A1EmpCod ;
   private int[] P004K12_A3CliCod ;
   private short[] P004K12_A1129LiqExAnio ;
   private int[] P004K12_A6LegNumero ;
   private String[] P004K12_A1127LiqExenConCodigo ;
   private short[] P004K12_A1128LiqExAplIIGG ;
   private int[] P004K14_A31LiqNro ;
   private short[] P004K14_A1EmpCod ;
   private int[] P004K14_A3CliCod ;
   private java.math.BigDecimal[] P004K14_A269LiqDCanti ;
   private boolean[] P004K14_n269LiqDCanti ;
   private int[] P004K14_A6LegNumero ;
   private int[] P004K14_A81LiqDSecuencial ;
   private int[] P004K16_A31LiqNro ;
   private short[] P004K16_A1EmpCod ;
   private int[] P004K16_A3CliCod ;
   private String[] P004K16_A2278LegLinkS3Html ;
   private int[] P004K16_A2285LinkLegNumero ;
   private String[] P004K16_A2277LegLinkTiporec ;
   private String[] P004K18_A2373LiqBatchSeccion ;
   private String[] P004K18_A2372LiqBatchCod ;
   private int[] P004K18_A2371LiqBatchLiqNro ;
   private short[] P004K18_A1EmpCod ;
   private int[] P004K18_A3CliCod ;
   private int[] P004K21_A31LiqNro ;
   private short[] P004K21_A1EmpCod ;
   private int[] P004K21_A3CliCod ;
   private java.math.BigDecimal[] P004K21_A281LiqLegImpTotal ;
   private int[] P004K21_A6LegNumero ;
   private int[] P004K23_A31LiqNro ;
   private short[] P004K23_A1EmpCod ;
   private int[] P004K23_A3CliCod ;
   private java.util.Date[] P004K23_A98LiqFecha ;
}

final  class eliminaliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P004K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV9LiqNro ,
                                          int A1733LSD1LiqNro ,
                                          int AV10CliCod ,
                                          short AV8EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[3];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT LSDSec, EmpCod, CliCod, LSD1LiqNro FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LSD_reg1" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   protected Object[] conditional_P004K12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A31LiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int9 = new byte[3];
      Object[] GXv_Object10 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LiqExAnio, LegNumero, LiqExenConCodigo, LiqExAplIIGG FROM liquidacion_exencion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int9[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF liquidacion_exencion" ;
      GXv_Object10[0] = scmdbuf ;
      GXv_Object10[1] = GXv_int9 ;
      return GXv_Object10 ;
   }

   protected Object[] conditional_P004K14( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A31LiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LiqDCanti, LegNumero, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionDetalle" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P004K16( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A31LiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int13 = new byte[3];
      Object[] GXv_Object14 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LegLinkS3Html, LinkLegNumero, LegLinkTiporec FROM LiquidacionLegajoLinkPdf" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int13[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLegajoLinkPdf" ;
      GXv_Object14[0] = scmdbuf ;
      GXv_Object14[1] = GXv_int13 ;
      return GXv_Object14 ;
   }

   protected Object[] conditional_P004K18( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A2371LiqBatchLiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int15 = new byte[3];
      Object[] GXv_Object16 = new Object[2];
      scmdbuf = "SELECT LiqBatchSeccion, LiqBatchCod, LiqBatchLiqNro, EmpCod, CliCod FROM LiquidacionLotes3" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqBatchLiqNro = ?)");
      }
      else
      {
         GXv_int15[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLotes3" ;
      GXv_Object16[0] = scmdbuf ;
      GXv_Object16[1] = GXv_int15 ;
      return GXv_Object16 ;
   }

   protected Object[] conditional_P004K21( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A31LiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[3];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LiqLegImpTotal, LegNumero FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      scmdbuf += " FOR UPDATE OF LiquidacionLegajo" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   protected Object[] conditional_P004K23( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV9LiqNro ,
                                           int A31LiqNro ,
                                           int AV10CliCod ,
                                           short AV8EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[3];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT LiqNro, EmpCod, CliCod, LiqFecha FROM Liquidacion" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(LiqNro = ?)");
      }
      else
      {
         GXv_int19[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P004K2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 10 :
                  return conditional_P004K12(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 12 :
                  return conditional_P004K14(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 14 :
                  return conditional_P004K16(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 16 :
                  return conditional_P004K18(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 19 :
                  return conditional_P004K21(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
            case 21 :
                  return conditional_P004K23(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P004K2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P004K3", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec FROM LSD_reg2 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? ORDER BY CliCod, EmpCod, LSDSec  FOR UPDATE OF LSD_reg2",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P004K4", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec FROM LSD_reg3 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec  FOR UPDATE OF LSD_reg3",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K5", "SAVEPOINT gxupdate;DELETE FROM LSD_reg3  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD3Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K6", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec FROM LSD_reg4 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec  FOR UPDATE OF LSD_reg4",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K7", "SAVEPOINT gxupdate;DELETE FROM LSD_reg4  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ? AND LSD4Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K8", "SAVEPOINT gxupdate;DELETE FROM LSD_reg2  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD2Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K9", "SELECT CliCod, EmpCod, LSDSec, LSD5Sec FROM LSD_reg5 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? ORDER BY CliCod, EmpCod, LSDSec  FOR UPDATE OF LSD_reg5",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K10", "SAVEPOINT gxupdate;DELETE FROM LSD_reg5  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ? AND LSD5Sec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K11", "SAVEPOINT gxupdate;DELETE FROM LSD_reg1  WHERE CliCod = ? AND EmpCod = ? AND LSDSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K12", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K13", "SAVEPOINT gxupdate;DELETE FROM liquidacion_exencion  WHERE CliCod = ? AND EmpCod = ? AND LiqExAnio = ? AND LiqNro = ? AND LegNumero = ? AND LiqExenConCodigo = ? AND LiqExAplIIGG = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K14", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K15", "SAVEPOINT gxupdate;DELETE FROM LiquidacionDetalle  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K16", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K17", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajoLinkPdf  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LinkLegNumero = ? AND LegLinkTiporec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K18", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K19", "DELETE FROM LiquidacionLotes3Leg  WHERE CliCod = ? and EmpCod = ? and LiqBatchLiqNro = ? and LiqBatchCod = ( ?) and LiqBatchSeccion = ( ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K20", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLotes3  WHERE CliCod = ? AND EmpCod = ? AND LiqBatchLiqNro = ? AND LiqBatchCod = ? AND LiqBatchSeccion = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K21", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K22", "SAVEPOINT gxupdate;DELETE FROM LiquidacionLegajo  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P004K23", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P004K24", "DELETE FROM Liquidacion  WHERE CliCod = ? and EmpCod = ? and LiqNro = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K25", "DELETE FROM Liquidacion  WHERE CliCod = ? and EmpCod = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K26", "UPDATE AgendaNovedades SET AgeLiqNro=NULL  WHERE (CliCod = ? and EmpCod = ? and LegNumero = ?) AND (AgeLiqNro = ?)", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K27", "DELETE FROM liquidacionLegajoCalculos  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K28", "DELETE FROM LiqDetForOperandos  WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K29", "DELETE FROM LiqLegConceptoCuenta  WHERE CliCod = ? and EmpCod = ? and LiqNuevaNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K30", "DELETE FROM LiqLegConceptoCuenta  WHERE CliCod = ? and EmpCod = ? and LiqAltaNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K31", "DELETE FROM LiqLegObligacionCuenta  WHERE CliCod = ? and EmpCod = ? and LiqOblNuevaNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P004K32", "DELETE FROM LiqLegObligacionCuenta  WHERE CliCod = ? and EmpCod = ? and LiqOblAltaNro = ? and LegNumero = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 16 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 10 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
            case 12 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 14 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 16 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 19 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 21 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 30 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
      }
   }

}

