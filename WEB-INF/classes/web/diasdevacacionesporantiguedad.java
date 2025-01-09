package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class diasdevacacionesporantiguedad extends GXProcedure
{
   public diasdevacacionesporantiguedad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( diasdevacacionesporantiguedad.class ), "" );
   }

   public diasdevacacionesporantiguedad( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             short aP6 ,
                             short aP7 ,
                             short aP8 ,
                             java.util.Date aP9 ,
                             short[] aP10 )
   {
      diasdevacacionesporantiguedad.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        short aP5 ,
                        short aP6 ,
                        short aP7 ,
                        short aP8 ,
                        java.util.Date aP9 ,
                        short[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             short aP5 ,
                             short aP6 ,
                             short aP7 ,
                             short aP8 ,
                             java.util.Date aP9 ,
                             short[] aP10 ,
                             String[] aP11 )
   {
      diasdevacacionesporantiguedad.this.AV8CliCod = aP0;
      diasdevacacionesporantiguedad.this.AV18EmpCod = aP1;
      diasdevacacionesporantiguedad.this.AV17LegNumero = aP2;
      diasdevacacionesporantiguedad.this.AV25LiqPeriodo = aP3;
      diasdevacacionesporantiguedad.this.AV16LegFecIngreso = aP4;
      diasdevacacionesporantiguedad.this.AV14aniosAntiguedad = aP5;
      diasdevacacionesporantiguedad.this.AV29mesesAntiguedad = aP6;
      diasdevacacionesporantiguedad.this.AV20jornadasTrabajadas = aP7;
      diasdevacacionesporantiguedad.this.AV21Limite = aP8;
      diasdevacacionesporantiguedad.this.AV12Date = aP9;
      diasdevacacionesporantiguedad.this.aP10 = aP10;
      diasdevacacionesporantiguedad.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV9PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      diasdevacacionesporantiguedad.this.GXt_int1 = GXv_int2[0] ;
      AV9PaiCod = GXt_int1 ;
      GXv_char3[0] = AV10ConveCodigo ;
      new web.empleadogetconvenio(remoteHandle, context).execute( AV8CliCod, AV18EmpCod, AV17LegNumero, GXv_char3) ;
      diasdevacacionesporantiguedad.this.AV10ConveCodigo = GXv_char3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "convenio default ", "")+GXutil.trim( AV10ConveCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "fe1  &LegLicCntDias", "")+GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0))) ;
      if ( (GXutil.strcmp("", AV10ConveCodigo)==0) )
      {
         AV33GXLvl10 = (byte)(0) ;
         /* Using cursor P01402 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV9PaiCod)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A46PaiCod = P01402_A46PaiCod[0] ;
            A1764PaiMinMesesVac = P01402_A1764PaiMinMesesVac[0] ;
            A1765PaiInterDiasJor = P01402_A1765PaiInterDiasJor[0] ;
            AV33GXLvl10 = (byte)(1) ;
            AV11ConveMinMesesVac = (byte)(A1764PaiMinMesesVac-1) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0))+httpContext.getMessage( " &limite ", "")+GXutil.trim( GXutil.str( AV21Limite, 4, 0))+httpContext.getMessage( " &LegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV16LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            if ( AV29mesesAntiguedad <= AV21Limite )
            {
               if ( A1765PaiInterDiasJor > 0 )
               {
                  AV13LegLicCntDias = (short)(DecimalUtil.decToDouble(GXutil.truncDecimal( DecimalUtil.doubleToDec(AV20jornadasTrabajadas/ (double) (A1765PaiInterDiasJor)), 0))) ;
                  AV27LiqDLog = httpContext.getMessage( "Corresponden ", "") + GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0)) + httpContext.getMessage( " días (", "") + GXutil.trim( GXutil.str( AV20jornadasTrabajadas, 4, 0)) + httpContext.getMessage( " jornadas trabajadas / ", "") + GXutil.trim( GXutil.str( A1765PaiInterDiasJor, 3, 0)) + httpContext.getMessage( ") definido por país", "") ;
               }
               else
               {
                  AV27LiqDLog = httpContext.getMessage( "No está configurado el parámetro de intervalo de jornadas trabajadas para días de vacaciones en país", "") ;
               }
            }
            else if ( AV29mesesAntiguedad > AV21Limite )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "5") ;
               /* Execute user subroutine: 'POR TABLA PAIS' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               AV27LiqDLog = httpContext.getMessage( "No hay jornadas trabajadas y los años de antiguedad son menores a ", "") + GXutil.trim( GXutil.str( AV28ConveVacHastaAnti, 2, 0)) ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         if ( AV33GXLvl10 == 0 )
         {
            AV27LiqDLog = httpContext.getMessage( "No existe país ", "") + GXutil.trim( GXutil.str( AV9PaiCod, 4, 0)) + httpContext.getMessage( " para buscar correspondencia de días", "") ;
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&PaiCod ", "")+GXutil.trim( GXutil.str( AV9PaiCod, 4, 0))) ;
         GXv_int4[0] = AV24CliConveVer ;
         new web.getversiondelegajo(remoteHandle, context).execute( AV8CliCod, AV18EmpCod, AV17LegNumero, GXv_int4) ;
         diasdevacacionesporantiguedad.this.AV24CliConveVer = GXv_int4[0] ;
         AV34GXLvl57 = (byte)(0) ;
         /* Using cursor P01403 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV24CliConveVer), Short.valueOf(AV9PaiCod), AV10ConveCodigo, AV25LiqPeriodo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01403_A3CliCod[0] ;
            A1564CliPaiConve = P01403_A1564CliPaiConve[0] ;
            A1565CliConvenio = P01403_A1565CliConvenio[0] ;
            A1575CliConveVig = P01403_A1575CliConveVig[0] ;
            A1046ConveMinMesesVac = P01403_A1046ConveMinMesesVac[0] ;
            A1043ConveInterDiasJor = P01403_A1043ConveInterDiasJor[0] ;
            AV34GXLvl57 = (byte)(1) ;
            AV11ConveMinMesesVac = (byte)(A1046ConveMinMesesVac-1) ;
            AV23ingresoMas6Meses = GXutil.addmth( AV16LegFecIngreso, AV11ConveMinMesesVac) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0))+httpContext.getMessage( " &ConveVacHastaAnti ", "")+GXutil.trim( GXutil.str( AV28ConveVacHastaAnti, 2, 0))+httpContext.getMessage( " &LegFecIngreso ", "")+GXutil.trim( localUtil.dtoc( AV16LegFecIngreso, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
            if ( AV29mesesAntiguedad <= AV21Limite )
            {
               if ( A1043ConveInterDiasJor > 0 )
               {
                  AV13LegLicCntDias = (short)(DecimalUtil.decToDouble(GXutil.truncDecimal( DecimalUtil.doubleToDec(AV20jornadasTrabajadas/ (double) (A1043ConveInterDiasJor)), 0))) ;
                  AV27LiqDLog = httpContext.getMessage( "Corresponden ", "") + GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0)) + httpContext.getMessage( " días (", "") + GXutil.trim( GXutil.str( AV20jornadasTrabajadas, 4, 0)) + httpContext.getMessage( " jornadas trabajadas / ", "") + GXutil.trim( GXutil.str( A1043ConveInterDiasJor, 3, 0)) + httpContext.getMessage( ") definido por convenio", "") ;
               }
               else
               {
                  AV27LiqDLog = httpContext.getMessage( "No está configurado el parámetro de intervalo de jornadas trabajadas para días de vacaciones en cnnvenio", "") ;
               }
            }
            else if ( AV29mesesAntiguedad > AV21Limite )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, "5") ;
               AV26CliConveVig = A1575CliConveVig ;
               /* Execute user subroutine: 'POR TABLA' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            else
            {
               AV27LiqDLog = httpContext.getMessage( "No hay jornadas trabajadas y los años de antiguedad son menores a ", "") + GXutil.trim( GXutil.str( AV28ConveVacHastaAnti, 2, 0)) + httpContext.getMessage( " para empleado en convenio", "") ;
            }
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV34GXLvl57 == 0 )
         {
            AV27LiqDLog = httpContext.getMessage( "No existe registro de configuración de vacaciones en convenio.", "") ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "fe2  &LegLicCntDias", "")+GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0))) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'POR TABLA' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "6 &aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0))) ;
      AV35GXLvl123 = (byte)(0) ;
      /* Using cursor P01404 */
      pr_default.execute(2, new Object[] {Short.valueOf(AV14aniosAntiguedad), Short.valueOf(AV14aniosAntiguedad), Short.valueOf(AV9PaiCod), AV10ConveCodigo, AV26CliConveVig});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1762CliConveVacHasAnt = P01404_A1762CliConveVacHasAnt[0] ;
         A1761CliConveVacDesAnt = P01404_A1761CliConveVacDesAnt[0] ;
         A1575CliConveVig = P01404_A1575CliConveVig[0] ;
         A1565CliConvenio = P01404_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01404_A1564CliPaiConve[0] ;
         A1763CliConveVacDias = P01404_A1763CliConveVacDias[0] ;
         A3CliCod = P01404_A3CliCod[0] ;
         AV35GXLvl123 = (byte)(1) ;
         AV13LegLicCntDias = A1763CliConveVacDias ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "7 &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0))) ;
         AV27LiqDLog = httpContext.getMessage( "Corresponden ", "") + GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0)) + httpContext.getMessage( " días por ", "") ;
         if ( AV29mesesAntiguedad < 12 )
         {
            AV27LiqDLog += GXutil.trim( GXutil.str( AV29mesesAntiguedad, 4, 0)) + httpContext.getMessage( " mes", "") ;
            if ( AV29mesesAntiguedad > 1 )
            {
               AV27LiqDLog += httpContext.getMessage( "es", "") ;
            }
         }
         else
         {
            AV27LiqDLog += GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0)) + httpContext.getMessage( " año", "") ;
            if ( AV14aniosAntiguedad > 1 )
            {
               AV27LiqDLog += httpContext.getMessage( "s", "") ;
            }
         }
         AV27LiqDLog += httpContext.getMessage( " de antiguedad", "") ;
         AV27LiqDLog += httpContext.getMessage( " definido por convenio", "") ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV35GXLvl123 == 0 )
      {
         AV27LiqDLog = httpContext.getMessage( "No hay registro de rangos desde hasta para ", "") + GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0)) + httpContext.getMessage( " años de antiguedad para vacaciones en convenio", "") ;
      }
   }

   public void S121( )
   {
      /* 'POR TABLA PAIS' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "paicod &aniosAntiguedad ", "")+GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0))) ;
      AV36GXLvl159 = (byte)(0) ;
      /* Using cursor P01405 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV9PaiCod), Short.valueOf(AV14aniosAntiguedad), Short.valueOf(AV14aniosAntiguedad)});
      while ( (pr_default.getStatus(3) != 101) )
      {
         A1767PaiVacHasAnt = P01405_A1767PaiVacHasAnt[0] ;
         A1766PaiVacDesAnt = P01405_A1766PaiVacDesAnt[0] ;
         A46PaiCod = P01405_A46PaiCod[0] ;
         A1768PaiVacDias = P01405_A1768PaiVacDias[0] ;
         AV36GXLvl159 = (byte)(1) ;
         AV13LegLicCntDias = A1768PaiVacDias ;
         AV27LiqDLog = httpContext.getMessage( "Corresponden ", "") + GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0)) + httpContext.getMessage( " días por ", "") ;
         if ( AV29mesesAntiguedad < 12 )
         {
            AV27LiqDLog += GXutil.trim( GXutil.str( AV29mesesAntiguedad, 4, 0)) + httpContext.getMessage( " mes", "") ;
            if ( AV29mesesAntiguedad > 1 )
            {
               AV27LiqDLog += httpContext.getMessage( "es", "") ;
            }
         }
         else
         {
            AV27LiqDLog += GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0)) + httpContext.getMessage( " año", "") ;
            if ( AV14aniosAntiguedad > 1 )
            {
               AV27LiqDLog += httpContext.getMessage( "s", "") ;
            }
         }
         AV27LiqDLog += httpContext.getMessage( " de antiguedad", "") ;
         AV27LiqDLog += httpContext.getMessage( " definido por país", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "7 &LegLicCntDias ", "")+GXutil.trim( GXutil.str( AV13LegLicCntDias, 4, 0))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(3);
      }
      pr_default.close(3);
      if ( AV36GXLvl159 == 0 )
      {
         AV27LiqDLog = httpContext.getMessage( "No hay registro de rangos desde hasta para ", "") + GXutil.trim( GXutil.str( AV14aniosAntiguedad, 4, 0)) + httpContext.getMessage( " años de antiguedad para vacaciones en país", "") ;
      }
   }

   protected void cleanup( )
   {
      this.aP10[0] = diasdevacacionesporantiguedad.this.AV13LegLicCntDias;
      this.aP11[0] = diasdevacacionesporantiguedad.this.AV27LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27LiqDLog = "" ;
      GXv_int2 = new short[1] ;
      AV10ConveCodigo = "" ;
      GXv_char3 = new String[1] ;
      AV32Pgmname = "" ;
      scmdbuf = "" ;
      P01402_A46PaiCod = new short[1] ;
      P01402_A1764PaiMinMesesVac = new byte[1] ;
      P01402_A1765PaiInterDiasJor = new short[1] ;
      GXv_int4 = new int[1] ;
      P01403_A3CliCod = new int[1] ;
      P01403_A1564CliPaiConve = new short[1] ;
      P01403_A1565CliConvenio = new String[] {""} ;
      P01403_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01403_A1046ConveMinMesesVac = new byte[1] ;
      P01403_A1043ConveInterDiasJor = new short[1] ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      AV23ingresoMas6Meses = GXutil.nullDate() ;
      AV26CliConveVig = GXutil.nullDate() ;
      P01404_A1762CliConveVacHasAnt = new byte[1] ;
      P01404_A1761CliConveVacDesAnt = new byte[1] ;
      P01404_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      P01404_A1565CliConvenio = new String[] {""} ;
      P01404_A1564CliPaiConve = new short[1] ;
      P01404_A1763CliConveVacDias = new byte[1] ;
      P01404_A3CliCod = new int[1] ;
      P01405_A1767PaiVacHasAnt = new byte[1] ;
      P01405_A1766PaiVacDesAnt = new byte[1] ;
      P01405_A46PaiCod = new short[1] ;
      P01405_A1768PaiVacDias = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.diasdevacacionesporantiguedad__default(),
         new Object[] {
             new Object[] {
            P01402_A46PaiCod, P01402_A1764PaiMinMesesVac, P01402_A1765PaiInterDiasJor
            }
            , new Object[] {
            P01403_A3CliCod, P01403_A1564CliPaiConve, P01403_A1565CliConvenio, P01403_A1575CliConveVig, P01403_A1046ConveMinMesesVac, P01403_A1043ConveInterDiasJor
            }
            , new Object[] {
            P01404_A1762CliConveVacHasAnt, P01404_A1761CliConveVacDesAnt, P01404_A1575CliConveVig, P01404_A1565CliConvenio, P01404_A1564CliPaiConve, P01404_A1763CliConveVacDias, P01404_A3CliCod
            }
            , new Object[] {
            P01405_A1767PaiVacHasAnt, P01405_A1766PaiVacDesAnt, P01405_A46PaiCod, P01405_A1768PaiVacDias
            }
         }
      );
      AV32Pgmname = "DiasDeVacacionesPorAntiguedad" ;
      /* GeneXus formulas. */
      AV32Pgmname = "DiasDeVacacionesPorAntiguedad" ;
      Gx_err = (short)(0) ;
   }

   private byte AV33GXLvl10 ;
   private byte A1764PaiMinMesesVac ;
   private byte AV11ConveMinMesesVac ;
   private byte AV28ConveVacHastaAnti ;
   private byte AV34GXLvl57 ;
   private byte A1046ConveMinMesesVac ;
   private byte A1763CliConveVacDias ;
   private byte AV35GXLvl123 ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1768PaiVacDias ;
   private byte AV36GXLvl159 ;
   private byte A1767PaiVacHasAnt ;
   private byte A1766PaiVacDesAnt ;
   private short AV18EmpCod ;
   private short AV14aniosAntiguedad ;
   private short AV29mesesAntiguedad ;
   private short AV20jornadasTrabajadas ;
   private short AV21Limite ;
   private short AV13LegLicCntDias ;
   private short AV9PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A46PaiCod ;
   private short A1765PaiInterDiasJor ;
   private short A1564CliPaiConve ;
   private short A1043ConveInterDiasJor ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17LegNumero ;
   private int AV24CliConveVer ;
   private int GXv_int4[] ;
   private int A3CliCod ;
   private String AV10ConveCodigo ;
   private String GXv_char3[] ;
   private String AV32Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private java.util.Date AV25LiqPeriodo ;
   private java.util.Date AV16LegFecIngreso ;
   private java.util.Date AV12Date ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV23ingresoMas6Meses ;
   private java.util.Date AV26CliConveVig ;
   private boolean returnInSub ;
   private String AV27LiqDLog ;
   private String[] aP11 ;
   private short[] aP10 ;
   private IDataStoreProvider pr_default ;
   private short[] P01402_A46PaiCod ;
   private byte[] P01402_A1764PaiMinMesesVac ;
   private short[] P01402_A1765PaiInterDiasJor ;
   private int[] P01403_A3CliCod ;
   private short[] P01403_A1564CliPaiConve ;
   private String[] P01403_A1565CliConvenio ;
   private java.util.Date[] P01403_A1575CliConveVig ;
   private byte[] P01403_A1046ConveMinMesesVac ;
   private short[] P01403_A1043ConveInterDiasJor ;
   private byte[] P01404_A1762CliConveVacHasAnt ;
   private byte[] P01404_A1761CliConveVacDesAnt ;
   private java.util.Date[] P01404_A1575CliConveVig ;
   private String[] P01404_A1565CliConvenio ;
   private short[] P01404_A1564CliPaiConve ;
   private byte[] P01404_A1763CliConveVacDias ;
   private int[] P01404_A3CliCod ;
   private byte[] P01405_A1767PaiVacHasAnt ;
   private byte[] P01405_A1766PaiVacDesAnt ;
   private short[] P01405_A46PaiCod ;
   private byte[] P01405_A1768PaiVacDias ;
}

final  class diasdevacacionesporantiguedad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01402", "SELECT PaiCod, PaiMinMesesVac, PaiInterDiasJor FROM Pais WHERE PaiCod = ? ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01403", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveMinMesesVac, ConveInterDiasJor FROM ClienteConvenio_Particularidades WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CliConveVig <= ? ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01404", "SELECT CliConveVacHasAnt, CliConveVacDesAnt, CliConveVig, CliConvenio, CliPaiConve, CliConveVacDias, CliCod FROM ClienteConvenio_ParticularidadesVacacion WHERE (CliConveVacDesAnt <= ?) AND (CliConveVacHasAnt >= ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) AND (CliConveVig = ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01405", "SELECT PaiVacHasAnt, PaiVacDesAnt, PaiCod, PaiVacDias FROM PaisVacaciones WHERE (PaiCod = ?) AND (PaiVacHasAnt >= ?) AND (PaiVacDesAnt <= ?) ORDER BY PaiCod  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
      }
   }

}

