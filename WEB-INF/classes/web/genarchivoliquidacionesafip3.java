package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class genarchivoliquidacionesafip3 extends GXProcedure
{
   public genarchivoliquidacionesafip3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( genarchivoliquidacionesafip3.class ), "" );
   }

   public genarchivoliquidacionesafip3( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          java.util.Date aP2 ,
                          int aP3 ,
                          String aP4 ,
                          int aP5 )
   {
      genarchivoliquidacionesafip3.this.aP6 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        int aP3 ,
                        String aP4 ,
                        int aP5 ,
                        int[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             int aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int[] aP6 )
   {
      genarchivoliquidacionesafip3.this.AV58CliCod = aP0;
      genarchivoliquidacionesafip3.this.AV77EmpCod = aP1;
      genarchivoliquidacionesafip3.this.AV102LiqPeriodo = aP2;
      genarchivoliquidacionesafip3.this.AV108parmLegNumero = aP3;
      genarchivoliquidacionesafip3.this.AV124TipoEnvio = aP4;
      genarchivoliquidacionesafip3.this.AV162parmLiqNro = aP5;
      genarchivoliquidacionesafip3.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV58CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV77EmpCod, 4, 0))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV102LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      GXt_char1 = AV115sacProporcionalConCodigo ;
      GXt_char2 = AV115sacProporcionalConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char2, GXv_char4) ;
      genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char4[0] ;
      AV115sacProporcionalConCodigo = GXt_char1 ;
      GXt_char2 = AV126vacacionesConCodigo ;
      GXt_char1 = AV126vacacionesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char3) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char3[0] ;
      AV126vacacionesConCodigo = GXt_char2 ;
      AV179GXLvl17 = (byte)(0) ;
      /* Using cursor P01JF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01JF2_A3CliCod[0] ;
         A1EmpCod = P01JF2_A1EmpCod[0] ;
         A1649LSDSec = P01JF2_A1649LSDSec[0] ;
         AV179GXLvl17 = (byte)(1) ;
         AV158LSDSec = A1649LSDSec ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV179GXLvl17 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "none1", "")) ;
      }
      AV180GXLvl27 = (byte)(0) ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           Integer.valueOf(AV162parmLiqNro) ,
                                           Integer.valueOf(A1733LSD1LiqNro) ,
                                           A1734LSD1LiqPeriodo ,
                                           AV102LiqPeriodo ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV77EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01JF3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), AV102LiqPeriodo, Integer.valueOf(AV162parmLiqNro)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1733LSD1LiqNro = P01JF3_A1733LSD1LiqNro[0] ;
         A1734LSD1LiqPeriodo = P01JF3_A1734LSD1LiqPeriodo[0] ;
         A1EmpCod = P01JF3_A1EmpCod[0] ;
         A3CliCod = P01JF3_A3CliCod[0] ;
         A1649LSDSec = P01JF3_A1649LSDSec[0] ;
         AV180GXLvl27 = (byte)(1) ;
         AV168existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      if ( AV180GXLvl27 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "none2", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "1 &parmLiqNro ", "")+GXutil.trim( GXutil.str( AV162parmLiqNro, 8, 0))+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV168existe))+httpContext.getMessage( " &LSDSec ", "")+GXutil.trim( GXutil.str( AV158LSDSec, 8, 0))) ;
      if ( ! AV168existe )
      {
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              Integer.valueOf(AV162parmLiqNro) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              A283LiqPeriodo ,
                                              AV102LiqPeriodo ,
                                              Integer.valueOf(AV58CliCod) ,
                                              Short.valueOf(AV77EmpCod) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) } ,
                                              new int[]{
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P01JF4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), AV102LiqPeriodo, Integer.valueOf(AV162parmLiqNro)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            brk1JF4 = false ;
            A281LiqLegImpTotal = P01JF4_A281LiqLegImpTotal[0] ;
            A6LegNumero = P01JF4_A6LegNumero[0] ;
            A31LiqNro = P01JF4_A31LiqNro[0] ;
            A1EmpCod = P01JF4_A1EmpCod[0] ;
            A3CliCod = P01JF4_A3CliCod[0] ;
            A283LiqPeriodo = P01JF4_A283LiqPeriodo[0] ;
            A2414LiqFrecPag = P01JF4_A2414LiqFrecPag[0] ;
            A32TLiqCod = P01JF4_A32TLiqCod[0] ;
            n32TLiqCod = P01JF4_n32TLiqCod[0] ;
            A2414LiqFrecPag = P01JF4_A2414LiqFrecPag[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "Legnumero ", "")+GXutil.trim( GXutil.str( A6LegNumero, 8, 0))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
            AV175LiqFrecPag = A2414LiqFrecPag ;
            AV99LiqNro = A31LiqNro ;
            AV125TLiqCod = A32TLiqCod ;
            AV49CantEmpLiq = 0 ;
            while ( (pr_default.getStatus(2) != 101) && ( P01JF4_A3CliCod[0] == A3CliCod ) && ( P01JF4_A1EmpCod[0] == A1EmpCod ) && ( P01JF4_A31LiqNro[0] == A31LiqNro ) )
            {
               brk1JF4 = false ;
               A281LiqLegImpTotal = P01JF4_A281LiqLegImpTotal[0] ;
               A6LegNumero = P01JF4_A6LegNumero[0] ;
               if ( A3CliCod == AV58CliCod )
               {
                  if ( A1EmpCod == AV77EmpCod )
                  {
                     if ( A31LiqNro == AV99LiqNro )
                     {
                        if ( A281LiqLegImpTotal.doubleValue() != 0 )
                        {
                           if ( (0==AV108parmLegNumero) || ( ( A6LegNumero == AV108parmLegNumero ) ) )
                           {
                              AV49CantEmpLiq = (int)(AV49CantEmpLiq+1) ;
                           }
                        }
                     }
                  }
               }
               brk1JF4 = true ;
               pr_default.readNext(2);
            }
            AV166LSD1LiqNro = A31LiqNro ;
            AV165LSD1LiqPeriodo = A283LiqPeriodo ;
            /* Execute user subroutine: 'GENERAREGISTRO01' */
            S111 ();
            if ( returnInSub )
            {
               pr_default.close(2);
               pr_default.close(2);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( GXutil.strcmp(AV124TipoEnvio, "SJ") == 0 )
            {
               /* Execute user subroutine: 'GENERAREGISTRO02' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(2);
                  pr_default.close(2);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
            if ( ! brk1JF4 )
            {
               brk1JF4 = true ;
               pr_default.readNext(2);
            }
         }
         pr_default.close(2);
      }
      if ( ! (0==AV158LSDSec) )
      {
         AV170nuevo_LSDSec = AV158LSDSec ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "asigna ", "")+GXutil.trim( GXutil.str( AV170nuevo_LSDSec, 8, 0))) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "vacio", "")) ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'GENERAREGISTRO01' Routine */
      returnInSub = false ;
      AV158LSDSec = (int)(AV158LSDSec+1) ;
      /*
         INSERT RECORD ON TABLE LSD_reg1

      */
      A3CliCod = AV58CliCod ;
      A1EmpCod = AV77EmpCod ;
      A1649LSDSec = AV158LSDSec ;
      GXv_char4[0] = "" ;
      GXv_int5[0] = AV78EmpCUIT ;
      GXv_char3[0] = "" ;
      GXv_char6[0] = "" ;
      GXv_char7[0] = "" ;
      GXv_char8[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_char10[0] = "" ;
      new web.getdatosempresa(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, GXv_char4, GXv_int5, GXv_char3, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10) ;
      genarchivoliquidacionesafip3.this.AV78EmpCUIT = GXv_int5[0] ;
      A1650LSD1CuitEmpl_3_11 = AV78EmpCUIT ;
      A1651LSD1IdentificacionEnvio_14_2 = AV124TipoEnvio ;
      AV11AnioMes = (int)(GXutil.year( AV102LiqPeriodo)*100+GXutil.month( AV102LiqPeriodo)) ;
      A1652LSD1periodoLiquidacion_16_6 = AV11AnioMes ;
      new web.msgdebug(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "&TipoEnvio ", "")+AV124TipoEnvio) ;
      if ( GXutil.strcmp(AV124TipoEnvio, "SJ") == 0 )
      {
         if ( AV175LiqFrecPag == 1 )
         {
            A1653LSD1tipoLiquidacion_22_1 = httpContext.getMessage( "M", "") ;
         }
         else
         {
            A1653LSD1tipoLiquidacion_22_1 = httpContext.getMessage( "Q", "") ;
         }
         A1654LSD1numeroLiquidacion_23_5 = AV99LiqNro ;
      }
      else
      {
         A1653LSD1tipoLiquidacion_22_1 = " " ;
         A1654LSD1numeroLiquidacion_23_5 = 0 ;
      }
      A1655LSD1diasBase_28_2 = (byte)(30) ;
      A1656LSD1cantidadRegistrosTipo04_30 = AV49CantEmpLiq ;
      new web.msgdebug(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "&Result = DFWNext()", "")) ;
      A1733LSD1LiqNro = AV166LSD1LiqNro ;
      A1734LSD1LiqPeriodo = AV165LSD1LiqPeriodo ;
      /* Using cursor P01JF5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Long.valueOf(A1650LSD1CuitEmpl_3_11), A1651LSD1IdentificacionEnvio_14_2, Integer.valueOf(A1652LSD1periodoLiquidacion_16_6), A1653LSD1tipoLiquidacion_22_1, Integer.valueOf(A1654LSD1numeroLiquidacion_23_5), Byte.valueOf(A1655LSD1diasBase_28_2), Integer.valueOf(A1656LSD1cantidadRegistrosTipo04_30), Integer.valueOf(A1733LSD1LiqNro), A1734LSD1LiqPeriodo});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg1");
      if ( (pr_default.getStatus(3) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
   }

   public void S121( )
   {
      /* 'GENERAREGISTRO02' Routine */
      returnInSub = false ;
      AV159LSD2Sec = 0 ;
      pr_default.dynParam(4, new Object[]{ new Object[]{
                                           Integer.valueOf(AV108parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV77EmpCod) ,
                                           Integer.valueOf(AV99LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01JF6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), Integer.valueOf(AV99LiqNro), Integer.valueOf(AV108parmLegNumero)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A6LegNumero = P01JF6_A6LegNumero[0] ;
         A93LegId = P01JF6_A93LegId[0] ;
         n93LegId = P01JF6_n93LegId[0] ;
         A234LegCBU = P01JF6_A234LegCBU[0] ;
         n234LegCBU = P01JF6_n234LegCBU[0] ;
         A248LegFormaPago = P01JF6_A248LegFormaPago[0] ;
         A280LiqFecPago = P01JF6_A280LiqFecPago[0] ;
         A31LiqNro = P01JF6_A31LiqNro[0] ;
         A1EmpCod = P01JF6_A1EmpCod[0] ;
         A3CliCod = P01JF6_A3CliCod[0] ;
         A93LegId = P01JF6_A93LegId[0] ;
         n93LegId = P01JF6_n93LegId[0] ;
         A234LegCBU = P01JF6_A234LegCBU[0] ;
         n234LegCBU = P01JF6_n234LegCBU[0] ;
         A248LegFormaPago = P01JF6_A248LegFormaPago[0] ;
         A280LiqFecPago = P01JF6_A280LiqFecPago[0] ;
         W3CliCod = A3CliCod ;
         W1EmpCod = A1EmpCod ;
         AV163auxLegNumero = A6LegNumero ;
         AV159LSD2Sec = (int)(AV159LSD2Sec+1) ;
         /*
            INSERT RECORD ON TABLE LSD_reg2

         */
         W3CliCod = A3CliCod ;
         W1EmpCod = A1EmpCod ;
         A3CliCod = AV58CliCod ;
         A1EmpCod = AV77EmpCod ;
         A1649LSDSec = AV158LSDSec ;
         A1657LSD2Sec = AV159LSD2Sec ;
         AV96legNumero = A6LegNumero ;
         GXt_int11 = AV95LegCUIL ;
         GXv_int5[0] = GXt_int11 ;
         new web.obtcuillegajo(remoteHandle, context).execute( A3CliCod, A1EmpCod, A6LegNumero, GXv_int5) ;
         genarchivoliquidacionesafip3.this.GXt_int11 = GXv_int5[0] ;
         AV95LegCUIL = GXt_int11 ;
         A1658LSD2cuilEmpleado_3_11 = AV95LegCUIL ;
         AV94Legajo = GXutil.strReplace( A93LegId, " ", "") ;
         AV94Legajo = GXutil.str( CommonUtil.decimalVal( AV94Legajo, "."), 10, 0) ;
         AV94Legajo = GXutil.substring( AV94Legajo, 1, 10) ;
         AV94Legajo = GXutil.padl( AV94Legajo, (short)(10), "0") ;
         A1659LSD2legajoEmpleado_14_10 = AV94Legajo ;
         GXv_char10[0] = "" ;
         GXv_char9[0] = AV171SecDescrip ;
         new web.getlegajoarea(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV96legNumero, GXv_char10, GXv_char9) ;
         genarchivoliquidacionesafip3.this.AV171SecDescrip = GXv_char9[0] ;
         AV171SecDescrip = GXutil.substring( GXutil.trim( AV171SecDescrip), 1, 50) ;
         A1660LSD2dependenciaRevista_24_50 = GXutil.padl( AV171SecDescrip, (short)(50), " ") ;
         if ( ( A248LegFormaPago == 3 ) && ! (GXutil.strcmp("", A234LegCBU)==0) )
         {
            AV57CBU = GXutil.trim( A234LegCBU) ;
         }
         else
         {
            AV57CBU = "" ;
         }
         A1661LSD2cbuEmpleado_74_22 = GXutil.substring( AV57CBU, 1, 22) ;
         GXt_char2 = AV151DiasPropTopeSueldoConCodigo ;
         GXt_char1 = AV151DiasPropTopeSueldoConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV151DiasPropTopeSueldoConCodigo = GXt_char2 ;
         GXv_decimal12[0] = DecimalUtil.doubleToDec(AV140numCant) ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV151DiasPropTopeSueldoConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV140numCant = (short)(DecimalUtil.decToDouble(GXv_decimal12[0])) ;
         AV74DiasLiquidados = GXutil.padl( GXutil.trim( GXutil.str( AV140numCant, 4, 0)), (short)(3), "0") ;
         A1662LSD2diasLiquidados_96_3 = AV140numCant ;
         A1663LSD2fechaPago_99_8 = A280LiqFecPago ;
         A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
         AV85FormaPago = GXutil.trim( GXutil.str( A248LegFormaPago, 1, 0)) ;
         A1665LSD2formaPago_115_1 = AV85FormaPago ;
         /* Using cursor P01JF7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Long.valueOf(A1658LSD2cuilEmpleado_3_11), A1659LSD2legajoEmpleado_14_10, A1660LSD2dependenciaRevista_24_50, A1661LSD2cbuEmpleado_74_22, Short.valueOf(A1662LSD2diasLiquidados_96_3), A1663LSD2fechaPago_99_8, A1664LSD2fechaRubrica_107_8, A1665LSD2formaPago_115_1});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg2");
         if ( (pr_default.getStatus(5) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A3CliCod = W3CliCod ;
         A1EmpCod = W1EmpCod ;
         /* End Insert */
         /* Execute user subroutine: 'GENERAREGISTRO03' */
         S137 ();
         if ( returnInSub )
         {
            pr_default.close(4);
            pr_default.close(4);
            pr_default.close(4);
            returnInSub = true;
            if (true) return;
         }
         /* Execute user subroutine: 'GENERAREGISTRO04' */
         S147 ();
         if ( returnInSub )
         {
            pr_default.close(4);
            pr_default.close(4);
            pr_default.close(4);
            returnInSub = true;
            if (true) return;
         }
         A3CliCod = W3CliCod ;
         A1EmpCod = W1EmpCod ;
         pr_default.readNext(4);
      }
      pr_default.close(4);
   }

   public void S137( )
   {
      /* 'GENERAREGISTRO03' Routine */
      returnInSub = false ;
      AV160LSD3Sec = (short)(0) ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           Integer.valueOf(AV108parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV163auxLegNumero) ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV77EmpCod) ,
                                           Integer.valueOf(AV99LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01JF8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), Integer.valueOf(AV99LiqNro), Integer.valueOf(AV108parmLegNumero), Integer.valueOf(AV163auxLegNumero)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A6LegNumero = P01JF8_A6LegNumero[0] ;
         A31LiqNro = P01JF8_A31LiqNro[0] ;
         A1EmpCod = P01JF8_A1EmpCod[0] ;
         A3CliCod = P01JF8_A3CliCod[0] ;
         W3CliCod = A3CliCod ;
         W1EmpCod = A1EmpCod ;
         AV96legNumero = A6LegNumero ;
         /* Using cursor P01JF9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero)});
         while ( (pr_default.getStatus(7) != 101) )
         {
            A502LiqDMostrar = P01JF9_A502LiqDMostrar[0] ;
            A394DConCodigo = P01JF9_A394DConCodigo[0] ;
            A269LiqDCanti = P01JF9_A269LiqDCanti[0] ;
            n269LiqDCanti = P01JF9_n269LiqDCanti[0] ;
            A764LiqDImpReCalcu = P01JF9_A764LiqDImpReCalcu[0] ;
            A464DTipoConCod = P01JF9_A464DTipoConCod[0] ;
            A471DConOrden = P01JF9_A471DConOrden[0] ;
            A81LiqDSecuencial = P01JF9_A81LiqDSecuencial[0] ;
            W3CliCod = A3CliCod ;
            W1EmpCod = A1EmpCod ;
            AV160LSD3Sec = (short)(AV160LSD3Sec+1) ;
            /*
               INSERT RECORD ON TABLE LSD_reg3

            */
            W3CliCod = A3CliCod ;
            W1EmpCod = A1EmpCod ;
            A3CliCod = AV58CliCod ;
            A1EmpCod = AV77EmpCod ;
            A1649LSDSec = AV158LSDSec ;
            A1657LSD2Sec = AV159LSD2Sec ;
            A1666LSD3Sec = AV160LSD3Sec ;
            A1667LSD3cuilEmpleado_3_11 = AV95LegCUIL ;
            A1668LSD3codigoConcepto_14_10 = GXutil.trim( A394DConCodigo) ;
            if ( ( GXutil.strcmp(A394DConCodigo, AV115sacProporcionalConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV126vacacionesConCodigo) == 0 ) )
            {
               AV167LSD3cantidadConcepto_24_5 = DecimalUtil.doubleToDec(0) ;
            }
            else
            {
               AV167LSD3cantidadConcepto_24_5 = A269LiqDCanti ;
            }
            A1669LSD3cantidadConcepto_24_5 = AV167LSD3cantidadConcepto_24_5 ;
            A1670LSD3unidadesConcepto_29_1 = " " ;
            if ( A764LiqDImpReCalcu.doubleValue() < 0 )
            {
               AV150LiqDImpCalcu = A764LiqDImpReCalcu.multiply(DecimalUtil.doubleToDec(-1)) ;
            }
            else
            {
               AV150LiqDImpCalcu = A764LiqDImpReCalcu ;
            }
            A1671LSD3importeConcepto_30_15 = AV150LiqDImpCalcu ;
            if ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") == 0 )
            {
               if ( A764LiqDImpReCalcu.doubleValue() >= 0 )
               {
                  AV71DebCred = httpContext.getMessage( "D", "") ;
               }
               else
               {
                  AV71DebCred = httpContext.getMessage( "C", "") ;
               }
            }
            else
            {
               if ( A764LiqDImpReCalcu.doubleValue() >= 0 )
               {
                  AV71DebCred = httpContext.getMessage( "C", "") ;
               }
               else
               {
                  AV71DebCred = httpContext.getMessage( "D", "") ;
               }
            }
            A1672LSD3debitoCredito_45_1 = AV71DebCred ;
            A1673LSD3periodoAjuste_46_6 = 0 ;
            /* Using cursor P01JF10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1666LSD3Sec), Long.valueOf(A1667LSD3cuilEmpleado_3_11), A1668LSD3codigoConcepto_14_10, A1669LSD3cantidadConcepto_24_5, A1670LSD3unidadesConcepto_29_1, A1671LSD3importeConcepto_30_15, A1672LSD3debitoCredito_45_1, Integer.valueOf(A1673LSD3periodoAjuste_46_6)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg3");
            if ( (pr_default.getStatus(8) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            A3CliCod = W3CliCod ;
            A1EmpCod = W1EmpCod ;
            /* End Insert */
            A3CliCod = W3CliCod ;
            A1EmpCod = W1EmpCod ;
            pr_default.readNext(7);
         }
         pr_default.close(7);
         A3CliCod = W3CliCod ;
         A1EmpCod = W1EmpCod ;
         pr_default.readNext(6);
      }
      pr_default.close(6);
   }

   public void S147( )
   {
      /* 'GENERAREGISTRO04' Routine */
      returnInSub = false ;
      AV161LSD4Sec = (short)(0) ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           Integer.valueOf(AV108parmLegNumero) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Integer.valueOf(AV163auxLegNumero) ,
                                           Integer.valueOf(AV58CliCod) ,
                                           Short.valueOf(AV77EmpCod) ,
                                           Integer.valueOf(AV99LiqNro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01JF11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), Integer.valueOf(AV99LiqNro), Integer.valueOf(AV108parmLegNumero), Integer.valueOf(AV163auxLegNumero)});
      while ( (pr_default.getStatus(9) != 101) )
      {
         A235LegClase = P01JF11_A235LegClase[0] ;
         A6LegNumero = P01JF11_A6LegNumero[0] ;
         A237LegConvenio = P01JF11_A237LegConvenio[0] ;
         A45TipEmpleCod = P01JF11_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P01JF11_n45TipEmpleCod[0] ;
         A18MprCod = P01JF11_A18MprCod[0] ;
         n18MprCod = P01JF11_n18MprCod[0] ;
         A283LiqPeriodo = P01JF11_A283LiqPeriodo[0] ;
         A19SinieCodigo = P01JF11_A19SinieCodigo[0] ;
         n19SinieCodigo = P01JF11_n19SinieCodigo[0] ;
         A20ZonCod = P01JF11_A20ZonCod[0] ;
         n20ZonCod = P01JF11_n20ZonCod[0] ;
         A1580LegOsoCod = P01JF11_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01JF11_n1580LegOsoCod[0] ;
         A31LiqNro = P01JF11_A31LiqNro[0] ;
         A1EmpCod = P01JF11_A1EmpCod[0] ;
         A3CliCod = P01JF11_A3CliCod[0] ;
         A45TipEmpleCod = P01JF11_A45TipEmpleCod[0] ;
         n45TipEmpleCod = P01JF11_n45TipEmpleCod[0] ;
         A235LegClase = P01JF11_A235LegClase[0] ;
         A237LegConvenio = P01JF11_A237LegConvenio[0] ;
         A18MprCod = P01JF11_A18MprCod[0] ;
         n18MprCod = P01JF11_n18MprCod[0] ;
         A19SinieCodigo = P01JF11_A19SinieCodigo[0] ;
         n19SinieCodigo = P01JF11_n19SinieCodigo[0] ;
         A20ZonCod = P01JF11_A20ZonCod[0] ;
         n20ZonCod = P01JF11_n20ZonCod[0] ;
         A1580LegOsoCod = P01JF11_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P01JF11_n1580LegOsoCod[0] ;
         W3CliCod = A3CliCod ;
         W1EmpCod = A1EmpCod ;
         AV161LSD4Sec = (short)(AV161LSD4Sec+1) ;
         /*
            INSERT RECORD ON TABLE LSD_reg4

         */
         W3CliCod = A3CliCod ;
         W1EmpCod = A1EmpCod ;
         A3CliCod = AV58CliCod ;
         A1EmpCod = AV77EmpCod ;
         A1649LSDSec = AV158LSDSec ;
         A1657LSD2Sec = AV159LSD2Sec ;
         A1674LSD4Sec = AV161LSD4Sec ;
         AV138LegClase = A235LegClase ;
         A1675LSD4CUIL_3_11 = AV95LegCUIL ;
         AV96legNumero = A6LegNumero ;
         /* Execute user subroutine: 'DATOSFAMILIA' */
         S1513 ();
         if ( returnInSub )
         {
            pr_default.close(9);
            pr_default.close(9);
            pr_default.close(9);
            returnInSub = true;
            if (true) return;
         }
         A1676LSD4Conyuge_14_1 = AV122TieneConyuge ;
         A1677LSD4CantidadHijos_15_2 = (byte)(AV51CantHijos) ;
         AV103MarcaConvenio = (A237LegConvenio ? "1" : "0") ;
         A1678LSD4MarcaCCT_17_1 = AV103MarcaConvenio ;
         A1679LSD4MarcaSCVO_18_1 = "1" ;
         GXv_decimal12[0] = AV172ZonPorcAumenDed ;
         new web.getaumentoporzona(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV96legNumero, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV172ZonPorcAumenDed = GXv_decimal12[0] ;
         if ( AV172ZonPorcAumenDed.doubleValue() == 1 )
         {
            AV112ReduccionSN = "0" ;
         }
         else
         {
            AV112ReduccionSN = "1" ;
         }
         A1680LSD4MarcaReduccion_19_1 = AV112ReduccionSN ;
         AV123TipoEmpleador = GXutil.trim( A45TipEmpleCod) ;
         A1681LSD4TipoEmpresa_20_1 = AV123TipoEmpleador ;
         AV64CodigoTipoOperacion = "0" ;
         A1682LSD4TipoOperacion_21_1 = AV64CodigoTipoOperacion ;
         GXt_int13 = AV154CondiCodigo ;
         GXv_int14[0] = GXt_int13 ;
         new web.getafipcondicion(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV96legNumero, GXv_int14) ;
         genarchivoliquidacionesafip3.this.GXt_int13 = GXv_int14[0] ;
         AV154CondiCodigo = GXt_int13 ;
         AV60CodigoCondicion = GXutil.padl( GXutil.trim( GXutil.str( AV154CondiCodigo, 4, 0)), (short)(2), "0") ;
         A1684LSD4CodigoCondicion_24_2 = AV60CodigoCondicion ;
         GXt_char2 = AV155LegActCodigo ;
         GXt_char1 = AV155LegActCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.actividad_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV155LegActCodigo = GXt_char2 ;
         AV59CodigoActividad = GXutil.padl( GXutil.trim( AV155LegActCodigo), (short)(3), "0") ;
         A1685LSD4CodigoActividad_26_3 = AV59CodigoActividad ;
         AV104ModalPromovida = GXutil.padl( GXutil.trim( A18MprCod), (short)(3), "0") ;
         A1686LSD4CodigoModalidadContratacio = AV104ModalPromovida ;
         GXv_objcol_char15[0] = AV129situaciones ;
         GXv_objcol_char16[0] = AV128fechas ;
         GXv_char10[0] = AV157EstadoSinieCodigo ;
         new web.getsituacionesrevistaparalsd(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, A6LegNumero, A283LiqPeriodo, GXv_objcol_char15, GXv_objcol_char16, GXv_char10) ;
         AV129situaciones = GXv_objcol_char15[0] ;
         AV128fechas = GXv_objcol_char16[0] ;
         genarchivoliquidacionesafip3.this.AV157EstadoSinieCodigo = GXv_char10[0] ;
         if ( ! (GXutil.strcmp("", A19SinieCodigo)==0) )
         {
            AV156SinieCodigo = A19SinieCodigo ;
         }
         else
         {
            if ( ! (GXutil.strcmp("", AV157EstadoSinieCodigo)==0) )
            {
               AV156SinieCodigo = AV157EstadoSinieCodigo ;
            }
            else
            {
               GXt_char2 = AV156SinieCodigo ;
               GXv_char10[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV58CliCod, httpContext.getMessage( "SINIE_DEF", ""), GXv_char10) ;
               genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
               AV156SinieCodigo = GXt_char2 ;
            }
         }
         AV62CodigoSiniestrado = GXutil.padl( GXutil.trim( AV156SinieCodigo), (short)(2), "0") ;
         A1687LSD4CodigoSiniestrado_32_2 = AV62CodigoSiniestrado ;
         AV127zona = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(A20ZonCod," ")) ;
         if ( AV127zona.size() <= 1 )
         {
            AV65CodigoZona = GXutil.padl( GXutil.trim( A20ZonCod), (short)(2), "0") ;
         }
         else
         {
            AV65CodigoZona = GXutil.padl( GXutil.trim( (String)AV127zona.elementAt(-1+1)), (short)(2), "0") ;
         }
         A1688LSD4CodigoLocalidad_34_2 = AV65CodigoZona ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV178Pgmname, httpContext.getMessage( "&situaciones ", "")+AV129situaciones.toJSonString(false)) ;
         AV130s = (short)(1) ;
         while ( AV130s <= AV129situaciones.size() )
         {
            if ( ! (GXutil.strcmp("", (String)AV129situaciones.elementAt(-1+AV130s))==0) )
            {
               AV63CodigoSituacion = GXutil.padl( (String)AV129situaciones.elementAt(-1+AV130s), (short)(2), "0") ;
            }
            else
            {
               AV63CodigoSituacion = "  " ;
            }
            AV73DesdeDia = (String)AV128fechas.elementAt(-1+AV130s) ;
            if ( AV130s == 1 )
            {
               A1683LSD4CodigoSituacion_22_2 = AV63CodigoSituacion ;
               A1689LSD4SituacionRevista1_36_2 = AV63CodigoSituacion ;
               A1690LSD4DiaInicioSituacionRevista1 = AV73DesdeDia ;
            }
            else if ( AV130s == 2 )
            {
               A1691LSD4SituacionRevista2_40_2 = AV63CodigoSituacion ;
               A1692LSD4DiaInicioSituacionRevista2 = AV73DesdeDia ;
            }
            else if ( AV130s == 3 )
            {
               A1693LSD4SituacionRevista3_44_2 = AV63CodigoSituacion ;
               A1694LSD4DiaInicioSituacionRevista3 = AV73DesdeDia ;
            }
            AV130s = (short)(AV130s+1) ;
         }
         /* Execute user subroutine: 'OBTIENEDIASHORASTRABAJADAS' */
         S1613 ();
         if ( returnInSub )
         {
            pr_default.close(9);
            pr_default.close(9);
            pr_default.close(9);
            returnInSub = true;
            if (true) return;
         }
         A1695LSD4CantidadDiasTrabajados_48_ = (byte)(AV75DiasTrabajados) ;
         A1696LSD4HorasTrabajadas_50_3 = AV86HorasTrabajadas ;
         A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.doubleToDec(0) ;
         A1698LSD4ContribucionTareaDiferenci = DecimalUtil.doubleToDec(0) ;
         GXv_char10[0] = AV173OsoC3992 ;
         new web.getobrasocialafip(remoteHandle, context).execute( AV58CliCod, A1580LegOsoCod, GXv_char10) ;
         genarchivoliquidacionesafip3.this.AV173OsoC3992 = GXv_char10[0] ;
         AV61CodigoObraSocial = GXutil.padl( GXutil.trim( AV173OsoC3992), (short)(6), " ") ;
         A1699LSD4CodigoObraSocial_63_6 = AV61CodigoObraSocial ;
         /* Execute user subroutine: 'OBTIENEADHERENTESOBRASOCIAL' */
         S1713 ();
         if ( returnInSub )
         {
            pr_default.close(9);
            pr_default.close(9);
            pr_default.close(9);
            returnInSub = true;
            if (true) return;
         }
         /* Execute user subroutine: 'OBTIENEBRUTO E IMPONIBLES' */
         S1813 ();
         if ( returnInSub )
         {
            pr_default.close(9);
            pr_default.close(9);
            pr_default.close(9);
            returnInSub = true;
            if (true) return;
         }
         A1700LSD4CantidadAdherentes_69_2 = (byte)(AV48CantAdherentes) ;
         A1701LSD4AporteAdicionalOS_71_15 = AV89ImporteAdicionalOS ;
         A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.doubleToDec(0) ;
         A1703LSD4BaseCalculoDiferencialApor = AV16BaseDifApoOSFSR_Num ;
         A1704LSD4BaseCalculoDiferencialOSyF = AV19BaseDifContrOSFSR_Num ;
         A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.doubleToDec(AV25BaseDifLRT_Num) ;
         /* Execute user subroutine: 'OBTIENEIMPORTEMATERNIDAD' */
         S1913 ();
         if ( returnInSub )
         {
            pr_default.close(9);
            pr_default.close(9);
            pr_default.close(9);
            returnInSub = true;
            if (true) return;
         }
         A1706LSD4RemuneracionMaternidadANSe = AV91ImporteMaternidad ;
         A1707LSD4RemuneracionBruta_161_15 = AV120SueldoBruto ;
         A1708LSD4BaseImponible1_176_15 = AV27BaseImponible1_Num ;
         A1709LSD4BaseImponible2_191_15 = AV32BaseImponible2_Num ;
         A1710LSD4BaseImponible3_206_15 = AV34BaseImponible3_Num ;
         A1711LSD4BaseImponible4_221_15 = AV36BaseImponible4_Num ;
         A1712LSD4BaseImponible5_236_15 = AV38BaseImponible5_Num ;
         A1713LSD4BaseImponible6_251_15 = AV40BaseImponible6_Num ;
         A1714LSD4BaseImponible7_266_15 = AV42BaseImponible7_Num ;
         A1715LSD4BaseImponible8_281_15 = AV44BaseImponible8_Num ;
         A1716LSD4BaseImponible9_296_15 = AV46BaseImponible9_Num ;
         A1717LSD4BaseDifApoSegSoc_311_15 = AV18BaseDifApoSS_Num ;
         A1718LSD4BaseDifContSegSoc_326_15 = AV21BaseDifContrSS_Num ;
         A1719LSD4BaseImponible10_341_15 = AV30BaseImponible10_Num ;
         A1720LSD4ImporteADetraer_356_15 = AV88ImporteADetraer_Num ;
         /* Using cursor P01JF12 */
         pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec), Short.valueOf(A1674LSD4Sec), Long.valueOf(A1675LSD4CUIL_3_11), A1676LSD4Conyuge_14_1, Byte.valueOf(A1677LSD4CantidadHijos_15_2), A1678LSD4MarcaCCT_17_1, A1679LSD4MarcaSCVO_18_1, A1680LSD4MarcaReduccion_19_1, A1681LSD4TipoEmpresa_20_1, A1682LSD4TipoOperacion_21_1, A1683LSD4CodigoSituacion_22_2, A1684LSD4CodigoCondicion_24_2, A1685LSD4CodigoActividad_26_3, A1686LSD4CodigoModalidadContratacio, A1687LSD4CodigoSiniestrado_32_2, A1688LSD4CodigoLocalidad_34_2, A1689LSD4SituacionRevista1_36_2, A1690LSD4DiaInicioSituacionRevista1, A1691LSD4SituacionRevista2_40_2, A1692LSD4DiaInicioSituacionRevista2, A1693LSD4SituacionRevista3_44_2, A1694LSD4DiaInicioSituacionRevista3, Byte.valueOf(A1695LSD4CantidadDiasTrabajados_48_), Short.valueOf(A1696LSD4HorasTrabajadas_50_3), A1697LSD4PorcentajeAporteAdicionalS, A1698LSD4ContribucionTareaDiferenci, A1699LSD4CodigoObraSocial_63_6, Byte.valueOf(A1700LSD4CantidadAdherentes_69_2), A1701LSD4AporteAdicionalOS_71_15, A1702LSD4ContribucionAdicionalOS_86, A1703LSD4BaseCalculoDiferencialApor, A1704LSD4BaseCalculoDiferencialOSyF, A1705LSD4BaseCalculoDiferencialLRT_, A1706LSD4RemuneracionMaternidadANSe, A1707LSD4RemuneracionBruta_161_15, A1708LSD4BaseImponible1_176_15, A1709LSD4BaseImponible2_191_15, A1710LSD4BaseImponible3_206_15, A1711LSD4BaseImponible4_221_15, A1712LSD4BaseImponible5_236_15, A1713LSD4BaseImponible6_251_15, A1714LSD4BaseImponible7_266_15, A1715LSD4BaseImponible8_281_15, A1716LSD4BaseImponible9_296_15, A1717LSD4BaseDifApoSegSoc_311_15, A1718LSD4BaseDifContSegSoc_326_15, A1719LSD4BaseImponible10_341_15, A1720LSD4ImporteADetraer_356_15});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("LSD_reg4");
         if ( (pr_default.getStatus(10) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         A3CliCod = W3CliCod ;
         A1EmpCod = W1EmpCod ;
         /* End Insert */
         A3CliCod = W3CliCod ;
         A1EmpCod = W1EmpCod ;
         pr_default.readNext(9);
      }
      pr_default.close(9);
   }

   public void S1813( )
   {
      /* 'OBTIENEBRUTO E IMPONIBLES' Routine */
      returnInSub = false ;
      AV120SueldoBruto = DecimalUtil.ZERO ;
      GXt_char2 = AV70DConCodigo ;
      GXt_char1 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sueldobruto_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV120SueldoBruto ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV120SueldoBruto = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible1(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV27BaseImponible1_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV27BaseImponible1_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible2(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV32BaseImponible2_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV32BaseImponible2_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible3(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV34BaseImponible3_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV34BaseImponible3_Num = GXv_decimal12[0] ;
      GXv_char10[0] = AV70DConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).executeUdp( ), GXv_char10) ;
      genarchivoliquidacionesafip3.this.AV70DConCodigo = GXv_char10[0] ;
      GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
      GXv_boolean17[0] = AV168existe ;
      GXv_int18[0] = (byte)(0) ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, AV96legNumero, AV70DConCodigo, AV153ProcesoLiquidacion, false, GXv_decimal12, GXv_boolean17, GXv_int18) ;
      genarchivoliquidacionesafip3.this.AV168existe = GXv_boolean17[0] ;
      if ( ! AV168existe )
      {
         GXt_char2 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char2 ;
         new web.concepto_lsd_baseimponible4(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV36BaseImponible4_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV36BaseImponible4_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char2 ;
         new web.concepto_lsd_baseimponible8(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV44BaseImponible8_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV44BaseImponible8_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV16BaseDifApoOSFSR_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV16BaseDifApoOSFSR_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV19BaseDifContrOSFSR_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV19BaseDifContrOSFSR_Num = GXv_decimal12[0] ;
      }
      else
      {
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV36BaseImponible4_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV36BaseImponible4_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV44BaseImponible8_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV44BaseImponible8_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV16BaseDifApoOSFSR_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV16BaseDifApoOSFSR_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char2 ;
         new web.concepto_lsd_baseimponible4(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV150LiqDImpCalcu ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV150LiqDImpCalcu = GXv_decimal12[0] ;
         AV16BaseDifApoOSFSR_Num = AV16BaseDifApoOSFSR_Num.subtract(AV150LiqDImpCalcu) ;
         GXt_char2 = AV70DConCodigo ;
         GXt_char1 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV19BaseDifContrOSFSR_Num ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV19BaseDifContrOSFSR_Num = GXv_decimal12[0] ;
         GXt_char2 = AV70DConCodigo ;
         GXv_char10[0] = GXt_char2 ;
         new web.concepto_lsd_baseimponible4(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
         AV70DConCodigo = GXt_char2 ;
         GXv_decimal12[0] = AV150LiqDImpCalcu ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV150LiqDImpCalcu = GXv_decimal12[0] ;
         AV19BaseDifContrOSFSR_Num = AV19BaseDifContrOSFSR_Num.subtract(AV150LiqDImpCalcu) ;
      }
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible5(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV38BaseImponible5_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV38BaseImponible5_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible6(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV40BaseImponible6_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV40BaseImponible6_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible7(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV42BaseImponible7_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV42BaseImponible7_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible9(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV46BaseImponible9_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV46BaseImponible9_Num = GXv_decimal12[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_lsd_baseimponible10(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV30BaseImponible10_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV30BaseImponible10_Num = GXv_decimal12[0] ;
      AV153ProcesoLiquidacion = "Calculo" ;
      AV135OpeCliId = "[base_imp_min]" ;
      GXv_char10[0] = AV106OpeCliValor ;
      new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV58CliCod, AV135OpeCliId, AV102LiqPeriodo, AV153ProcesoLiquidacion, GXv_char10) ;
      genarchivoliquidacionesafip3.this.AV106OpeCliValor = GXv_char10[0] ;
      AV134baseImponibleMinima = CommonUtil.decimalVal( AV106OpeCliValor, ".") ;
      if ( DecimalUtil.compareTo(AV27BaseImponible1_Num, AV134baseImponibleMinima) < 0 )
      {
         AV18BaseDifApoSS_Num = AV134baseImponibleMinima.subtract(AV27BaseImponible1_Num) ;
      }
      if ( DecimalUtil.compareTo(AV32BaseImponible2_Num, AV134baseImponibleMinima) < 0 )
      {
         AV21BaseDifContrSS_Num = AV134baseImponibleMinima.subtract(AV32BaseImponible2_Num) ;
      }
      GXt_char2 = AV70DConCodigo ;
      GXt_char1 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_importeadetraer(remoteHandle, context).execute( GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
      AV70DConCodigo = GXt_char2 ;
      GXv_decimal12[0] = AV88ImporteADetraer_Num ;
      new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, false, AV125TLiqCod, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV88ImporteADetraer_Num = GXv_decimal12[0] ;
      if ( DecimalUtil.compareTo(AV46BaseImponible9_Num, AV134baseImponibleMinima) < 0 )
      {
         AV25BaseDifLRT_Num = (short)(DecimalUtil.decToDouble(AV134baseImponibleMinima.subtract(AV46BaseImponible9_Num))) ;
      }
   }

   public void S1613( )
   {
      /* 'OBTIENEDIASHORASTRABAJADAS' Routine */
      returnInSub = false ;
      AV75DiasTrabajados = (short)(0) ;
      AV86HorasTrabajadas = (short)(0) ;
      if ( AV138LegClase == 1 )
      {
         GXt_char2 = AV152dtmConCodigo ;
         GXt_char1 = AV152dtmConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         genarchivoliquidacionesafip3.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV58CliCod, GXt_char1, GXv_char9) ;
         genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char9[0] ;
         AV152dtmConCodigo = GXt_char2 ;
         GXv_decimal12[0] = DecimalUtil.doubleToDec(AV75DiasTrabajados) ;
         new web.getliqdimpcalcu_hastaliq(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, 0, AV96legNumero, AV102LiqPeriodo, AV152dtmConCodigo, true, AV125TLiqCod, GXv_decimal12) ;
         genarchivoliquidacionesafip3.this.AV75DiasTrabajados = (short)(DecimalUtil.decToDouble(GXv_decimal12[0])) ;
      }
      else
      {
         /* Execute user subroutine: 'BUSCOHORAS' */
         S201 ();
         if (returnInSub) return;
      }
   }

   public void S1713( )
   {
      /* 'OBTIENEADHERENTESOBRASOCIAL' Routine */
      returnInSub = false ;
      AV48CantAdherentes = (short)(0) ;
      AV89ImporteAdicionalOS = DecimalUtil.ZERO ;
      AV12AporteAdicionalOS = DecimalUtil.ZERO ;
      GXv_int14[0] = AV48CantAdherentes ;
      new web.cantidaddeadherentes(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV96legNumero, GXv_int14) ;
      genarchivoliquidacionesafip3.this.AV48CantAdherentes = GXv_int14[0] ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_aporteadicionalobrasocial(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      /* Optimized group. */
      /* Using cursor P01JF13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), Integer.valueOf(AV99LiqNro), Integer.valueOf(AV96legNumero), AV70DConCodigo});
      c764LiqDImpReCalcu = P01JF13_A764LiqDImpReCalcu[0] ;
      pr_default.close(11);
      AV89ImporteAdicionalOS = AV89ImporteAdicionalOS.add(c764LiqDImpReCalcu) ;
      /* End optimized group. */
   }

   public void S1913( )
   {
      /* 'OBTIENEIMPORTEMATERNIDAD' Routine */
      returnInSub = false ;
      GXt_char2 = AV70DConCodigo ;
      GXv_char10[0] = GXt_char2 ;
      new web.concepto_licenciapormaternidad(remoteHandle, context).execute( AV58CliCod, GXv_char10) ;
      genarchivoliquidacionesafip3.this.GXt_char2 = GXv_char10[0] ;
      AV70DConCodigo = GXt_char2 ;
      AV91ImporteMaternidad = DecimalUtil.ZERO ;
      /* Using cursor P01JF14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV58CliCod), Short.valueOf(AV77EmpCod), Integer.valueOf(AV99LiqNro), Integer.valueOf(AV96legNumero), AV70DConCodigo});
      while ( (pr_default.getStatus(12) != 101) )
      {
         A394DConCodigo = P01JF14_A394DConCodigo[0] ;
         A6LegNumero = P01JF14_A6LegNumero[0] ;
         A31LiqNro = P01JF14_A31LiqNro[0] ;
         A1EmpCod = P01JF14_A1EmpCod[0] ;
         A3CliCod = P01JF14_A3CliCod[0] ;
         A764LiqDImpReCalcu = P01JF14_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P01JF14_A81LiqDSecuencial[0] ;
         AV91ImporteMaternidad = A764LiqDImpReCalcu ;
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void S201( )
   {
      /* 'BUSCOHORAS' Routine */
      returnInSub = false ;
      GXv_char10[0] = AV70DConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV58CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char10) ;
      genarchivoliquidacionesafip3.this.AV70DConCodigo = GXv_char10[0] ;
      GXv_decimal12[0] = DecimalUtil.doubleToDec(AV86HorasTrabajadas) ;
      new web.getliqdcanti_liqant(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV99LiqNro, AV96legNumero, AV102LiqPeriodo, AV70DConCodigo, GXv_decimal12) ;
      genarchivoliquidacionesafip3.this.AV86HorasTrabajadas = (short)(DecimalUtil.decToDouble(GXv_decimal12[0])) ;
   }

   public void S1513( )
   {
      /* 'DATOSFAMILIA' Routine */
      returnInSub = false ;
      GXv_boolean17[0] = AV8conyugeHay ;
      GXv_int14[0] = AV51CantHijos ;
      new web.legajogetfamilia(remoteHandle, context).execute( AV58CliCod, AV77EmpCod, AV96legNumero, GXv_boolean17, GXv_int14) ;
      genarchivoliquidacionesafip3.this.AV8conyugeHay = GXv_boolean17[0] ;
      genarchivoliquidacionesafip3.this.AV51CantHijos = GXv_int14[0] ;
      if ( AV8conyugeHay )
      {
         AV122TieneConyuge = "1" ;
      }
      else
      {
         AV122TieneConyuge = "0" ;
      }
   }

   protected void cleanup( )
   {
      this.aP6[0] = genarchivoliquidacionesafip3.this.AV170nuevo_LSDSec;
      Application.commitDataStores(context, remoteHandle, pr_default, "genarchivoliquidacionesafip3");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV178Pgmname = "" ;
      AV115sacProporcionalConCodigo = "" ;
      AV126vacacionesConCodigo = "" ;
      scmdbuf = "" ;
      P01JF2_A3CliCod = new int[1] ;
      P01JF2_A1EmpCod = new short[1] ;
      P01JF2_A1649LSDSec = new int[1] ;
      A1734LSD1LiqPeriodo = GXutil.nullDate() ;
      P01JF3_A1733LSD1LiqNro = new int[1] ;
      P01JF3_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01JF3_A1EmpCod = new short[1] ;
      P01JF3_A3CliCod = new int[1] ;
      P01JF3_A1649LSDSec = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P01JF4_A281LiqLegImpTotal = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JF4_A6LegNumero = new int[1] ;
      P01JF4_A31LiqNro = new int[1] ;
      P01JF4_A1EmpCod = new short[1] ;
      P01JF4_A3CliCod = new int[1] ;
      P01JF4_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01JF4_A2414LiqFrecPag = new byte[1] ;
      P01JF4_A32TLiqCod = new String[] {""} ;
      P01JF4_n32TLiqCod = new boolean[] {false} ;
      A281LiqLegImpTotal = DecimalUtil.ZERO ;
      A32TLiqCod = "" ;
      AV125TLiqCod = "" ;
      AV165LSD1LiqPeriodo = GXutil.nullDate() ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_char8 = new String[1] ;
      A1651LSD1IdentificacionEnvio_14_2 = "" ;
      A1653LSD1tipoLiquidacion_22_1 = "" ;
      Gx_emsg = "" ;
      A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      P01JF6_A6LegNumero = new int[1] ;
      P01JF6_A93LegId = new String[] {""} ;
      P01JF6_n93LegId = new boolean[] {false} ;
      P01JF6_A234LegCBU = new String[] {""} ;
      P01JF6_n234LegCBU = new boolean[] {false} ;
      P01JF6_A248LegFormaPago = new byte[1] ;
      P01JF6_A280LiqFecPago = new java.util.Date[] {GXutil.nullDate()} ;
      P01JF6_A31LiqNro = new int[1] ;
      P01JF6_A1EmpCod = new short[1] ;
      P01JF6_A3CliCod = new int[1] ;
      A93LegId = "" ;
      A234LegCBU = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      GXv_int5 = new long[1] ;
      AV94Legajo = "" ;
      A1659LSD2legajoEmpleado_14_10 = "" ;
      AV171SecDescrip = "" ;
      A1660LSD2dependenciaRevista_24_50 = "" ;
      AV57CBU = "" ;
      A1661LSD2cbuEmpleado_74_22 = "" ;
      AV151DiasPropTopeSueldoConCodigo = "" ;
      AV74DiasLiquidados = "" ;
      A1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      AV85FormaPago = "" ;
      A1665LSD2formaPago_115_1 = "" ;
      P01JF8_A6LegNumero = new int[1] ;
      P01JF8_A31LiqNro = new int[1] ;
      P01JF8_A1EmpCod = new short[1] ;
      P01JF8_A3CliCod = new int[1] ;
      P01JF9_A3CliCod = new int[1] ;
      P01JF9_A1EmpCod = new short[1] ;
      P01JF9_A31LiqNro = new int[1] ;
      P01JF9_A6LegNumero = new int[1] ;
      P01JF9_A502LiqDMostrar = new byte[1] ;
      P01JF9_A394DConCodigo = new String[] {""} ;
      P01JF9_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JF9_n269LiqDCanti = new boolean[] {false} ;
      P01JF9_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JF9_A464DTipoConCod = new String[] {""} ;
      P01JF9_A471DConOrden = new int[1] ;
      P01JF9_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      A1668LSD3codigoConcepto_14_10 = "" ;
      AV167LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      A1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      A1670LSD3unidadesConcepto_29_1 = "" ;
      AV150LiqDImpCalcu = DecimalUtil.ZERO ;
      A1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      AV71DebCred = "" ;
      A1672LSD3debitoCredito_45_1 = "" ;
      P01JF11_A235LegClase = new byte[1] ;
      P01JF11_A6LegNumero = new int[1] ;
      P01JF11_A237LegConvenio = new boolean[] {false} ;
      P01JF11_A45TipEmpleCod = new String[] {""} ;
      P01JF11_n45TipEmpleCod = new boolean[] {false} ;
      P01JF11_A18MprCod = new String[] {""} ;
      P01JF11_n18MprCod = new boolean[] {false} ;
      P01JF11_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01JF11_A19SinieCodigo = new String[] {""} ;
      P01JF11_n19SinieCodigo = new boolean[] {false} ;
      P01JF11_A20ZonCod = new String[] {""} ;
      P01JF11_n20ZonCod = new boolean[] {false} ;
      P01JF11_A1580LegOsoCod = new String[] {""} ;
      P01JF11_n1580LegOsoCod = new boolean[] {false} ;
      P01JF11_A31LiqNro = new int[1] ;
      P01JF11_A1EmpCod = new short[1] ;
      P01JF11_A3CliCod = new int[1] ;
      A45TipEmpleCod = "" ;
      A18MprCod = "" ;
      A19SinieCodigo = "" ;
      A20ZonCod = "" ;
      A1580LegOsoCod = "" ;
      A1676LSD4Conyuge_14_1 = "" ;
      AV122TieneConyuge = "" ;
      AV103MarcaConvenio = "" ;
      A1678LSD4MarcaCCT_17_1 = "" ;
      A1679LSD4MarcaSCVO_18_1 = "" ;
      AV172ZonPorcAumenDed = DecimalUtil.ZERO ;
      AV112ReduccionSN = "" ;
      A1680LSD4MarcaReduccion_19_1 = "" ;
      AV123TipoEmpleador = "" ;
      A1681LSD4TipoEmpresa_20_1 = "" ;
      AV64CodigoTipoOperacion = "" ;
      A1682LSD4TipoOperacion_21_1 = "" ;
      AV60CodigoCondicion = "" ;
      A1684LSD4CodigoCondicion_24_2 = "" ;
      AV155LegActCodigo = "" ;
      AV59CodigoActividad = "" ;
      A1685LSD4CodigoActividad_26_3 = "" ;
      AV104ModalPromovida = "" ;
      A1686LSD4CodigoModalidadContratacio = "" ;
      AV129situaciones = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char15 = new GXSimpleCollection[1] ;
      AV128fechas = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char16 = new GXSimpleCollection[1] ;
      AV157EstadoSinieCodigo = "" ;
      AV156SinieCodigo = "" ;
      AV62CodigoSiniestrado = "" ;
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      AV127zona = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65CodigoZona = "" ;
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      AV63CodigoSituacion = "" ;
      AV73DesdeDia = "" ;
      A1683LSD4CodigoSituacion_22_2 = "" ;
      A1689LSD4SituacionRevista1_36_2 = "" ;
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      A1691LSD4SituacionRevista2_40_2 = "" ;
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      A1693LSD4SituacionRevista3_44_2 = "" ;
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      AV173OsoC3992 = "" ;
      AV61CodigoObraSocial = "" ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      AV89ImporteAdicionalOS = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      AV16BaseDifApoOSFSR_Num = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      AV19BaseDifContrOSFSR_Num = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      AV91ImporteMaternidad = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      AV120SueldoBruto = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      AV27BaseImponible1_Num = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      AV32BaseImponible2_Num = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      AV34BaseImponible3_Num = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      AV36BaseImponible4_Num = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      AV38BaseImponible5_Num = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      AV40BaseImponible6_Num = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      AV42BaseImponible7_Num = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      AV44BaseImponible8_Num = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      AV46BaseImponible9_Num = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      AV18BaseDifApoSS_Num = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      AV21BaseDifContrSS_Num = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      AV30BaseImponible10_Num = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      AV88ImporteADetraer_Num = DecimalUtil.ZERO ;
      AV70DConCodigo = "" ;
      AV153ProcesoLiquidacion = "" ;
      GXv_int18 = new byte[1] ;
      AV135OpeCliId = "" ;
      AV106OpeCliValor = "" ;
      AV134baseImponibleMinima = DecimalUtil.ZERO ;
      AV152dtmConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char9 = new String[1] ;
      AV12AporteAdicionalOS = DecimalUtil.ZERO ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      P01JF13_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      GXt_char2 = "" ;
      P01JF14_A394DConCodigo = new String[] {""} ;
      P01JF14_A6LegNumero = new int[1] ;
      P01JF14_A31LiqNro = new int[1] ;
      P01JF14_A1EmpCod = new short[1] ;
      P01JF14_A3CliCod = new int[1] ;
      P01JF14_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01JF14_A81LiqDSecuencial = new int[1] ;
      GXv_char10 = new String[1] ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_boolean17 = new boolean[1] ;
      GXv_int14 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.genarchivoliquidacionesafip3__default(),
         new Object[] {
             new Object[] {
            P01JF2_A3CliCod, P01JF2_A1EmpCod, P01JF2_A1649LSDSec
            }
            , new Object[] {
            P01JF3_A1733LSD1LiqNro, P01JF3_A1734LSD1LiqPeriodo, P01JF3_A1EmpCod, P01JF3_A3CliCod, P01JF3_A1649LSDSec
            }
            , new Object[] {
            P01JF4_A281LiqLegImpTotal, P01JF4_A6LegNumero, P01JF4_A31LiqNro, P01JF4_A1EmpCod, P01JF4_A3CliCod, P01JF4_A283LiqPeriodo, P01JF4_A2414LiqFrecPag, P01JF4_A32TLiqCod, P01JF4_n32TLiqCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01JF6_A6LegNumero, P01JF6_A93LegId, P01JF6_n93LegId, P01JF6_A234LegCBU, P01JF6_n234LegCBU, P01JF6_A248LegFormaPago, P01JF6_A280LiqFecPago, P01JF6_A31LiqNro, P01JF6_A1EmpCod, P01JF6_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01JF8_A6LegNumero, P01JF8_A31LiqNro, P01JF8_A1EmpCod, P01JF8_A3CliCod
            }
            , new Object[] {
            P01JF9_A3CliCod, P01JF9_A1EmpCod, P01JF9_A31LiqNro, P01JF9_A6LegNumero, P01JF9_A502LiqDMostrar, P01JF9_A394DConCodigo, P01JF9_A269LiqDCanti, P01JF9_n269LiqDCanti, P01JF9_A764LiqDImpReCalcu, P01JF9_A464DTipoConCod,
            P01JF9_A471DConOrden, P01JF9_A81LiqDSecuencial
            }
            , new Object[] {
            }
            , new Object[] {
            P01JF11_A235LegClase, P01JF11_A6LegNumero, P01JF11_A237LegConvenio, P01JF11_A45TipEmpleCod, P01JF11_n45TipEmpleCod, P01JF11_A18MprCod, P01JF11_n18MprCod, P01JF11_A283LiqPeriodo, P01JF11_A19SinieCodigo, P01JF11_n19SinieCodigo,
            P01JF11_A20ZonCod, P01JF11_n20ZonCod, P01JF11_A1580LegOsoCod, P01JF11_n1580LegOsoCod, P01JF11_A31LiqNro, P01JF11_A1EmpCod, P01JF11_A3CliCod
            }
            , new Object[] {
            }
            , new Object[] {
            P01JF13_A764LiqDImpReCalcu
            }
            , new Object[] {
            P01JF14_A394DConCodigo, P01JF14_A6LegNumero, P01JF14_A31LiqNro, P01JF14_A1EmpCod, P01JF14_A3CliCod, P01JF14_A764LiqDImpReCalcu, P01JF14_A81LiqDSecuencial
            }
         }
      );
      AV178Pgmname = "GenArchivoLiquidacionesAFIP3" ;
      /* GeneXus formulas. */
      AV178Pgmname = "GenArchivoLiquidacionesAFIP3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV179GXLvl17 ;
   private byte AV180GXLvl27 ;
   private byte A2414LiqFrecPag ;
   private byte AV175LiqFrecPag ;
   private byte A1655LSD1diasBase_28_2 ;
   private byte A248LegFormaPago ;
   private byte A502LiqDMostrar ;
   private byte A235LegClase ;
   private byte AV138LegClase ;
   private byte A1677LSD4CantidadHijos_15_2 ;
   private byte A1695LSD4CantidadDiasTrabajados_48_ ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
   private byte GXv_int18[] ;
   private short AV77EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private short W1EmpCod ;
   private short AV140numCant ;
   private short A1662LSD2diasLiquidados_96_3 ;
   private short AV160LSD3Sec ;
   private short A1666LSD3Sec ;
   private short AV161LSD4Sec ;
   private short A1674LSD4Sec ;
   private short AV51CantHijos ;
   private short AV154CondiCodigo ;
   private short GXt_int13 ;
   private short AV130s ;
   private short AV75DiasTrabajados ;
   private short A1696LSD4HorasTrabajadas_50_3 ;
   private short AV86HorasTrabajadas ;
   private short AV48CantAdherentes ;
   private short AV25BaseDifLRT_Num ;
   private short GXv_int14[] ;
   private int AV58CliCod ;
   private int AV108parmLegNumero ;
   private int AV162parmLiqNro ;
   private int AV170nuevo_LSDSec ;
   private int A3CliCod ;
   private int A1649LSDSec ;
   private int AV158LSDSec ;
   private int A1733LSD1LiqNro ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int AV99LiqNro ;
   private int AV49CantEmpLiq ;
   private int AV166LSD1LiqNro ;
   private int GX_INS226 ;
   private int AV11AnioMes ;
   private int A1652LSD1periodoLiquidacion_16_6 ;
   private int A1654LSD1numeroLiquidacion_23_5 ;
   private int A1656LSD1cantidadRegistrosTipo04_30 ;
   private int AV159LSD2Sec ;
   private int W3CliCod ;
   private int AV163auxLegNumero ;
   private int GX_INS227 ;
   private int A1657LSD2Sec ;
   private int AV96legNumero ;
   private int A471DConOrden ;
   private int A81LiqDSecuencial ;
   private int GX_INS231 ;
   private int A1673LSD3periodoAjuste_46_6 ;
   private int GX_INS232 ;
   private long AV78EmpCUIT ;
   private long A1650LSD1CuitEmpl_3_11 ;
   private long AV95LegCUIL ;
   private long GXt_int11 ;
   private long GXv_int5[] ;
   private long A1658LSD2cuilEmpleado_3_11 ;
   private long A1667LSD3cuilEmpleado_3_11 ;
   private long A1675LSD4CUIL_3_11 ;
   private java.math.BigDecimal A281LiqLegImpTotal ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV167LSD3cantidadConcepto_24_5 ;
   private java.math.BigDecimal A1669LSD3cantidadConcepto_24_5 ;
   private java.math.BigDecimal AV150LiqDImpCalcu ;
   private java.math.BigDecimal A1671LSD3importeConcepto_30_15 ;
   private java.math.BigDecimal AV172ZonPorcAumenDed ;
   private java.math.BigDecimal A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal AV89ImporteAdicionalOS ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal AV16BaseDifApoOSFSR_Num ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal AV19BaseDifContrOSFSR_Num ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal AV91ImporteMaternidad ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal AV120SueldoBruto ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal AV27BaseImponible1_Num ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal AV32BaseImponible2_Num ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal AV34BaseImponible3_Num ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal AV36BaseImponible4_Num ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal AV38BaseImponible5_Num ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal AV40BaseImponible6_Num ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal AV42BaseImponible7_Num ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal AV44BaseImponible8_Num ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal AV46BaseImponible9_Num ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal AV18BaseDifApoSS_Num ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal AV21BaseDifContrSS_Num ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal AV30BaseImponible10_Num ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
   private java.math.BigDecimal AV88ImporteADetraer_Num ;
   private java.math.BigDecimal AV134baseImponibleMinima ;
   private java.math.BigDecimal AV12AporteAdicionalOS ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private String AV124TipoEnvio ;
   private String AV178Pgmname ;
   private String AV115sacProporcionalConCodigo ;
   private String AV126vacacionesConCodigo ;
   private String scmdbuf ;
   private String A32TLiqCod ;
   private String AV125TLiqCod ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String A1651LSD1IdentificacionEnvio_14_2 ;
   private String A1653LSD1tipoLiquidacion_22_1 ;
   private String Gx_emsg ;
   private String A93LegId ;
   private String AV94Legajo ;
   private String A1659LSD2legajoEmpleado_14_10 ;
   private String A1660LSD2dependenciaRevista_24_50 ;
   private String AV57CBU ;
   private String A1661LSD2cbuEmpleado_74_22 ;
   private String AV151DiasPropTopeSueldoConCodigo ;
   private String AV74DiasLiquidados ;
   private String AV85FormaPago ;
   private String A1665LSD2formaPago_115_1 ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A1668LSD3codigoConcepto_14_10 ;
   private String A1670LSD3unidadesConcepto_29_1 ;
   private String AV71DebCred ;
   private String A1672LSD3debitoCredito_45_1 ;
   private String A45TipEmpleCod ;
   private String A18MprCod ;
   private String A19SinieCodigo ;
   private String A20ZonCod ;
   private String A1580LegOsoCod ;
   private String A1676LSD4Conyuge_14_1 ;
   private String AV122TieneConyuge ;
   private String AV103MarcaConvenio ;
   private String A1678LSD4MarcaCCT_17_1 ;
   private String A1679LSD4MarcaSCVO_18_1 ;
   private String AV112ReduccionSN ;
   private String A1680LSD4MarcaReduccion_19_1 ;
   private String AV123TipoEmpleador ;
   private String A1681LSD4TipoEmpresa_20_1 ;
   private String AV64CodigoTipoOperacion ;
   private String A1682LSD4TipoOperacion_21_1 ;
   private String AV60CodigoCondicion ;
   private String A1684LSD4CodigoCondicion_24_2 ;
   private String AV155LegActCodigo ;
   private String AV59CodigoActividad ;
   private String A1685LSD4CodigoActividad_26_3 ;
   private String AV104ModalPromovida ;
   private String A1686LSD4CodigoModalidadContratacio ;
   private String AV157EstadoSinieCodigo ;
   private String AV156SinieCodigo ;
   private String AV62CodigoSiniestrado ;
   private String A1687LSD4CodigoSiniestrado_32_2 ;
   private String AV65CodigoZona ;
   private String A1688LSD4CodigoLocalidad_34_2 ;
   private String AV63CodigoSituacion ;
   private String AV73DesdeDia ;
   private String A1683LSD4CodigoSituacion_22_2 ;
   private String A1689LSD4SituacionRevista1_36_2 ;
   private String A1690LSD4DiaInicioSituacionRevista1 ;
   private String A1691LSD4SituacionRevista2_40_2 ;
   private String A1692LSD4DiaInicioSituacionRevista2 ;
   private String A1693LSD4SituacionRevista3_44_2 ;
   private String A1694LSD4DiaInicioSituacionRevista3 ;
   private String AV173OsoC3992 ;
   private String AV61CodigoObraSocial ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private String AV70DConCodigo ;
   private String AV153ProcesoLiquidacion ;
   private String AV135OpeCliId ;
   private String AV152dtmConCodigo ;
   private String GXt_char1 ;
   private String GXv_char9[] ;
   private String GXt_char2 ;
   private String GXv_char10[] ;
   private java.util.Date AV102LiqPeriodo ;
   private java.util.Date A1734LSD1LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV165LSD1LiqPeriodo ;
   private java.util.Date A1664LSD2fechaRubrica_107_8 ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A1663LSD2fechaPago_99_8 ;
   private boolean AV168existe ;
   private boolean brk1JF4 ;
   private boolean n32TLiqCod ;
   private boolean returnInSub ;
   private boolean n93LegId ;
   private boolean n234LegCBU ;
   private boolean n269LiqDCanti ;
   private boolean A237LegConvenio ;
   private boolean n45TipEmpleCod ;
   private boolean n18MprCod ;
   private boolean n19SinieCodigo ;
   private boolean n20ZonCod ;
   private boolean n1580LegOsoCod ;
   private boolean AV8conyugeHay ;
   private boolean GXv_boolean17[] ;
   private String AV106OpeCliValor ;
   private String A234LegCBU ;
   private String AV171SecDescrip ;
   private int[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P01JF2_A3CliCod ;
   private short[] P01JF2_A1EmpCod ;
   private int[] P01JF2_A1649LSDSec ;
   private int[] P01JF3_A1733LSD1LiqNro ;
   private java.util.Date[] P01JF3_A1734LSD1LiqPeriodo ;
   private short[] P01JF3_A1EmpCod ;
   private int[] P01JF3_A3CliCod ;
   private int[] P01JF3_A1649LSDSec ;
   private java.math.BigDecimal[] P01JF4_A281LiqLegImpTotal ;
   private int[] P01JF4_A6LegNumero ;
   private int[] P01JF4_A31LiqNro ;
   private short[] P01JF4_A1EmpCod ;
   private int[] P01JF4_A3CliCod ;
   private java.util.Date[] P01JF4_A283LiqPeriodo ;
   private byte[] P01JF4_A2414LiqFrecPag ;
   private String[] P01JF4_A32TLiqCod ;
   private boolean[] P01JF4_n32TLiqCod ;
   private int[] P01JF6_A6LegNumero ;
   private String[] P01JF6_A93LegId ;
   private boolean[] P01JF6_n93LegId ;
   private String[] P01JF6_A234LegCBU ;
   private boolean[] P01JF6_n234LegCBU ;
   private byte[] P01JF6_A248LegFormaPago ;
   private java.util.Date[] P01JF6_A280LiqFecPago ;
   private int[] P01JF6_A31LiqNro ;
   private short[] P01JF6_A1EmpCod ;
   private int[] P01JF6_A3CliCod ;
   private int[] P01JF8_A6LegNumero ;
   private int[] P01JF8_A31LiqNro ;
   private short[] P01JF8_A1EmpCod ;
   private int[] P01JF8_A3CliCod ;
   private int[] P01JF9_A3CliCod ;
   private short[] P01JF9_A1EmpCod ;
   private int[] P01JF9_A31LiqNro ;
   private int[] P01JF9_A6LegNumero ;
   private byte[] P01JF9_A502LiqDMostrar ;
   private String[] P01JF9_A394DConCodigo ;
   private java.math.BigDecimal[] P01JF9_A269LiqDCanti ;
   private boolean[] P01JF9_n269LiqDCanti ;
   private java.math.BigDecimal[] P01JF9_A764LiqDImpReCalcu ;
   private String[] P01JF9_A464DTipoConCod ;
   private int[] P01JF9_A471DConOrden ;
   private int[] P01JF9_A81LiqDSecuencial ;
   private byte[] P01JF11_A235LegClase ;
   private int[] P01JF11_A6LegNumero ;
   private boolean[] P01JF11_A237LegConvenio ;
   private String[] P01JF11_A45TipEmpleCod ;
   private boolean[] P01JF11_n45TipEmpleCod ;
   private String[] P01JF11_A18MprCod ;
   private boolean[] P01JF11_n18MprCod ;
   private java.util.Date[] P01JF11_A283LiqPeriodo ;
   private String[] P01JF11_A19SinieCodigo ;
   private boolean[] P01JF11_n19SinieCodigo ;
   private String[] P01JF11_A20ZonCod ;
   private boolean[] P01JF11_n20ZonCod ;
   private String[] P01JF11_A1580LegOsoCod ;
   private boolean[] P01JF11_n1580LegOsoCod ;
   private int[] P01JF11_A31LiqNro ;
   private short[] P01JF11_A1EmpCod ;
   private int[] P01JF11_A3CliCod ;
   private java.math.BigDecimal[] P01JF13_A764LiqDImpReCalcu ;
   private String[] P01JF14_A394DConCodigo ;
   private int[] P01JF14_A6LegNumero ;
   private int[] P01JF14_A31LiqNro ;
   private short[] P01JF14_A1EmpCod ;
   private int[] P01JF14_A3CliCod ;
   private java.math.BigDecimal[] P01JF14_A764LiqDImpReCalcu ;
   private int[] P01JF14_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV129situaciones ;
   private GXSimpleCollection<String> GXv_objcol_char15[] ;
   private GXSimpleCollection<String> AV128fechas ;
   private GXSimpleCollection<String> GXv_objcol_char16[] ;
   private GXSimpleCollection<String> AV127zona ;
}

final  class genarchivoliquidacionesafip3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01JF3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV162parmLiqNro ,
                                          int A1733LSD1LiqNro ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          java.util.Date AV102LiqPeriodo ,
                                          int AV58CliCod ,
                                          short AV77EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int19 = new byte[4];
      Object[] GXv_Object20 = new Object[2];
      scmdbuf = "SELECT LSD1LiqNro, LSD1LiqPeriodo, EmpCod, CliCod, LSDSec FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      if ( ! (0==AV162parmLiqNro) )
      {
         addWhere(sWhereString, "(LSD1LiqNro = ?)");
      }
      else
      {
         GXv_int19[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object20[0] = scmdbuf ;
      GXv_Object20[1] = GXv_int19 ;
      return GXv_Object20 ;
   }

   protected Object[] conditional_P01JF4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV162parmLiqNro ,
                                          int A31LiqNro ,
                                          java.util.Date A283LiqPeriodo ,
                                          java.util.Date AV102LiqPeriodo ,
                                          int AV58CliCod ,
                                          short AV77EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int21 = new byte[4];
      Object[] GXv_Object22 = new Object[2];
      scmdbuf = "SELECT T1.LiqLegImpTotal, T1.LegNumero, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LiqPeriodo, T2.LiqFrecPag, T1.TLiqCod FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion" ;
      scmdbuf += " T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "(T1.LiqPeriodo = ?)");
      if ( ! (0==AV162parmLiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro = ?)");
      }
      else
      {
         GXv_int21[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro" ;
      GXv_Object22[0] = scmdbuf ;
      GXv_Object22[1] = GXv_int21 ;
      return GXv_Object22 ;
   }

   protected Object[] conditional_P01JF6( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV108parmLegNumero ,
                                          int A6LegNumero ,
                                          int AV58CliCod ,
                                          short AV77EmpCod ,
                                          int AV99LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int23 = new byte[4];
      Object[] GXv_Object24 = new Object[2];
      scmdbuf = "SELECT T1.LegNumero, T2.LegId, T2.LegCBU, T2.LegFormaPago, T3.LiqFecPago, T1.LiqNro, T1.EmpCod, T1.CliCod FROM ((LiquidacionLegajo T1 INNER JOIN Legajo T2 ON T2.CliCod" ;
      scmdbuf += " = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LegNumero = T1.LegNumero) INNER JOIN Liquidacion T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod = T1.EmpCod AND T3.LiqNro" ;
      scmdbuf += " = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?)");
      if ( ! (0==AV108parmLegNumero) )
      {
         addWhere(sWhereString, "(T1.LegNumero = ?)");
      }
      else
      {
         GXv_int23[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro" ;
      GXv_Object24[0] = scmdbuf ;
      GXv_Object24[1] = GXv_int23 ;
      return GXv_Object24 ;
   }

   protected Object[] conditional_P01JF8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV108parmLegNumero ,
                                          int A6LegNumero ,
                                          int AV163auxLegNumero ,
                                          int AV58CliCod ,
                                          short AV77EmpCod ,
                                          int AV99LiqNro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int25 = new byte[5];
      Object[] GXv_Object26 = new Object[2];
      scmdbuf = "SELECT LegNumero, LiqNro, EmpCod, CliCod FROM LiquidacionLegajo" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      if ( ! (0==AV108parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int25[3] = (byte)(1) ;
      }
      if ( (0==AV108parmLegNumero) )
      {
         addWhere(sWhereString, "(LegNumero = ?)");
      }
      else
      {
         GXv_int25[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro" ;
      GXv_Object26[0] = scmdbuf ;
      GXv_Object26[1] = GXv_int25 ;
      return GXv_Object26 ;
   }

   protected Object[] conditional_P01JF11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV108parmLegNumero ,
                                           int A6LegNumero ,
                                           int AV163auxLegNumero ,
                                           int AV58CliCod ,
                                           short AV77EmpCod ,
                                           int AV99LiqNro ,
                                           int A3CliCod ,
                                           short A1EmpCod ,
                                           int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[5];
      Object[] GXv_Object28 = new Object[2];
      scmdbuf = "SELECT T3.LegClase, T1.LegNumero, T3.LegConvenio, T2.TipEmpleCod, T3.MprCod, T1.LiqPeriodo, T3.SinieCodigo, T3.ZonCod, T3.LegOsoCod, T1.LiqNro, T1.EmpCod, T1.CliCod" ;
      scmdbuf += " FROM ((LiquidacionLegajo T1 INNER JOIN Empresa T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod) INNER JOIN Legajo T3 ON T3.CliCod = T1.CliCod AND T3.EmpCod" ;
      scmdbuf += " = T1.EmpCod AND T3.LegNumero = T1.LegNumero)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ?)");
      if ( ! (0==AV108parmLegNumero) )
      {
         addWhere(sWhereString, "(T1.LegNumero = ?)");
      }
      else
      {
         GXv_int27[3] = (byte)(1) ;
      }
      if ( (0==AV108parmLegNumero) )
      {
         addWhere(sWhereString, "(T1.LegNumero = ?)");
      }
      else
      {
         GXv_int27[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro" ;
      GXv_Object28[0] = scmdbuf ;
      GXv_Object28[1] = GXv_int27 ;
      return GXv_Object28 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P01JF3(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
            case 2 :
                  return conditional_P01JF4(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
            case 4 :
                  return conditional_P01JF6(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() );
            case 6 :
                  return conditional_P01JF8(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() );
            case 9 :
                  return conditional_P01JF11(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01JF2", "SELECT CliCod, EmpCod, LSDSec FROM LSD_reg1 WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, LSDSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JF3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01JF4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01JF5", "SAVEPOINT gxupdate;INSERT INTO LSD_reg1(CliCod, EmpCod, LSDSec, LSD1CuitEmpl_3_11, LSD1IdentificacionEnvio_14_2, LSD1periodoLiquidacion_16_6, LSD1tipoLiquidacion_22_1, LSD1numeroLiquidacion_23_5, LSD1diasBase_28_2, LSD1cantidadRegistrosTipo04_30, LSD1LiqNro, LSD1LiqPeriodo) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01JF6", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01JF7", "SAVEPOINT gxupdate;INSERT INTO LSD_reg2(CliCod, EmpCod, LSDSec, LSD2Sec, LSD2cuilEmpleado_3_11, LSD2legajoEmpleado_14_10, LSD2dependenciaRevista_24_50, LSD2cbuEmpleado_74_22, LSD2diasLiquidados_96_3, LSD2fechaPago_99_8, LSD2fechaRubrica_107_8, LSD2formaPago_115_1) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01JF8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JF9", "SELECT CliCod, EmpCod, LiqNro, LegNumero, LiqDMostrar, DConCodigo, LiqDCanti, LiqDImpReCalcu, DTipoConCod, DConOrden, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (LiqDMostrar = 3) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConOrden ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01JF10", "SAVEPOINT gxupdate;INSERT INTO LSD_reg3(CliCod, EmpCod, LSDSec, LSD2Sec, LSD3Sec, LSD3cuilEmpleado_3_11, LSD3codigoConcepto_14_10, LSD3cantidadConcepto_24_5, LSD3unidadesConcepto_29_1, LSD3importeConcepto_30_15, LSD3debitoCredito_45_1, LSD3periodoAjuste_46_6) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01JF11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01JF12", "SAVEPOINT gxupdate;INSERT INTO LSD_reg4(CliCod, EmpCod, LSDSec, LSD2Sec, LSD4Sec, LSD4CUIL_3_11, LSD4Conyuge_14_1, LSD4CantidadHijos_15_2, LSD4MarcaCCT_17_1, LSD4MarcaSCVO_18_1, LSD4MarcaReduccion_19_1, LSD4TipoEmpresa_20_1, LSD4TipoOperacion_21_1, LSD4CodigoSituacion_22_2, LSD4CodigoCondicion_24_2, LSD4CodigoActividad_26_3, LSD4CodigoModalidadContratacio, LSD4CodigoSiniestrado_32_2, LSD4CodigoLocalidad_34_2, LSD4SituacionRevista1_36_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista3, LSD4CantidadDiasTrabajados_48_, LSD4HorasTrabajadas_50_3, LSD4PorcentajeAporteAdicionalS, LSD4ContribucionTareaDiferenci, LSD4CodigoObraSocial_63_6, LSD4CantidadAdherentes_69_2, LSD4AporteAdicionalOS_71_15, LSD4ContribucionAdicionalOS_86, LSD4BaseCalculoDiferencialApor, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialLRT_, LSD4RemuneracionMaternidadANSe, LSD4RemuneracionBruta_161_15, LSD4BaseImponible1_176_15, LSD4BaseImponible2_191_15, LSD4BaseImponible3_206_15, LSD4BaseImponible4_221_15, LSD4BaseImponible5_236_15, LSD4BaseImponible6_251_15, LSD4BaseImponible7_266_15, LSD4BaseImponible8_281_15, LSD4BaseImponible9_296_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseImponible10_341_15, LSD4ImporteADetraer_356_15) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P01JF13", "SELECT SUM(LiqDImpReCalcu) FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01JF14", "SELECT DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDSecuencial FROM LiquidacionDetalle WHERE CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 2 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[5])[0] = rslt.getGXDate(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((byte[]) buf[5])[0] = rslt.getByte(4);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((short[]) buf[8])[0] = rslt.getShort(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getString(9, 20);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 9 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 4);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((int[]) buf[14])[0] = rslt.getInt(10);
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((int[]) buf[16])[0] = rslt.getInt(12);
               return;
            case 11 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,2);
               ((int[]) buf[6])[0] = rslt.getInt(7);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[6]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[6]);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setString(5, (String)parms[4], 2);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 1);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setInt(11, ((Number) parms[10]).intValue());
               stmt.setDate(12, (java.util.Date)parms[11]);
               return;
            case 4 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setLong(5, ((Number) parms[4]).longValue());
               stmt.setString(6, (String)parms[5], 10);
               stmt.setString(7, (String)parms[6], 50);
               stmt.setString(8, (String)parms[7], 22);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 1);
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setString(7, (String)parms[6], 10);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setString(9, (String)parms[8], 1);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setInt(12, ((Number) parms[11]).intValue());
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setLong(6, ((Number) parms[5]).longValue());
               stmt.setString(7, (String)parms[6], 1);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setString(9, (String)parms[8], 1);
               stmt.setString(10, (String)parms[9], 1);
               stmt.setString(11, (String)parms[10], 1);
               stmt.setString(12, (String)parms[11], 1);
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 2);
               stmt.setString(15, (String)parms[14], 2);
               stmt.setString(16, (String)parms[15], 3);
               stmt.setString(17, (String)parms[16], 3);
               stmt.setString(18, (String)parms[17], 2);
               stmt.setString(19, (String)parms[18], 2);
               stmt.setString(20, (String)parms[19], 2);
               stmt.setString(21, (String)parms[20], 2);
               stmt.setString(22, (String)parms[21], 2);
               stmt.setString(23, (String)parms[22], 2);
               stmt.setString(24, (String)parms[23], 2);
               stmt.setString(25, (String)parms[24], 2);
               stmt.setByte(26, ((Number) parms[25]).byteValue());
               stmt.setShort(27, ((Number) parms[26]).shortValue());
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[28], 2);
               stmt.setString(30, (String)parms[29], 6);
               stmt.setByte(31, ((Number) parms[30]).byteValue());
               stmt.setBigDecimal(32, (java.math.BigDecimal)parms[31], 2);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[32], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[33], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[35], 2);
               stmt.setBigDecimal(37, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(38, (java.math.BigDecimal)parms[37], 2);
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[38], 2);
               stmt.setBigDecimal(40, (java.math.BigDecimal)parms[39], 2);
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[40], 2);
               stmt.setBigDecimal(42, (java.math.BigDecimal)parms[41], 2);
               stmt.setBigDecimal(43, (java.math.BigDecimal)parms[42], 2);
               stmt.setBigDecimal(44, (java.math.BigDecimal)parms[43], 2);
               stmt.setBigDecimal(45, (java.math.BigDecimal)parms[44], 2);
               stmt.setBigDecimal(46, (java.math.BigDecimal)parms[45], 2);
               stmt.setBigDecimal(47, (java.math.BigDecimal)parms[46], 2);
               stmt.setBigDecimal(48, (java.math.BigDecimal)parms[47], 2);
               stmt.setBigDecimal(49, (java.math.BigDecimal)parms[48], 2);
               stmt.setBigDecimal(50, (java.math.BigDecimal)parms[49], 2);
               stmt.setBigDecimal(51, (java.math.BigDecimal)parms[50], 2);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               return;
      }
   }

}

