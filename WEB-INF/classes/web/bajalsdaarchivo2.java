package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class bajalsdaarchivo2 extends GXProcedure
{
   public bajalsdaarchivo2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( bajalsdaarchivo2.class ), "" );
   }

   public bajalsdaarchivo2( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             long aP4 ,
                             String[] aP5 )
   {
      bajalsdaarchivo2.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        long aP4 ,
                        String[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             long aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      bajalsdaarchivo2.this.AV62CliCod = aP0;
      bajalsdaarchivo2.this.AV85EmpCod = aP1;
      bajalsdaarchivo2.this.AV122LSDSec = aP2;
      bajalsdaarchivo2.this.AV118LSD1LiqPeriodo = aP3;
      bajalsdaarchivo2.this.AV164LSD2cuilEmpleado_3_11 = aP4;
      bajalsdaarchivo2.this.aP5 = aP5;
      bajalsdaarchivo2.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_dtime1 = AV165ahora ;
      GXv_dtime2[0] = GXt_dtime1 ;
      new web.getahora(remoteHandle, context).execute( AV62CliCod, GXv_dtime2) ;
      bajalsdaarchivo2.this.GXt_dtime1 = GXv_dtime2[0] ;
      AV165ahora = GXt_dtime1 ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV62CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV85EmpCod, 4, 0))+httpContext.getMessage( " &LSD1LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV118LSD1LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LSDSec ", "")+GXutil.trim( GXutil.str( AV122LSDSec, 8, 0))) ;
      GXv_char3[0] = AV140rutaAplicacion ;
      new web.getdefaultpath(remoteHandle, context).execute( GXv_char3) ;
      bajalsdaarchivo2.this.AV140rutaAplicacion = GXv_char3[0] ;
      AV140rutaAplicacion += httpContext.getMessage( "/TempArchivos", "") ;
      AV95folder.setSource( AV140rutaAplicacion );
      if ( ! AV95folder.exists() )
      {
         AV95folder.create();
      }
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV122LSDSec) ,
                                           AV118LSD1LiqPeriodo ,
                                           Integer.valueOf(A1649LSDSec) ,
                                           A1734LSD1LiqPeriodo ,
                                           Integer.valueOf(AV62CliCod) ,
                                           Short.valueOf(AV85EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.DATE, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P01Q32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV62CliCod), Short.valueOf(AV85EmpCod), Integer.valueOf(AV122LSDSec), AV118LSD1LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1649LSDSec = P01Q32_A1649LSDSec[0] ;
         A1EmpCod = P01Q32_A1EmpCod[0] ;
         A3CliCod = P01Q32_A3CliCod[0] ;
         A1734LSD1LiqPeriodo = P01Q32_A1734LSD1LiqPeriodo[0] ;
         A1733LSD1LiqNro = P01Q32_A1733LSD1LiqNro[0] ;
         A1650LSD1CuitEmpl_3_11 = P01Q32_A1650LSD1CuitEmpl_3_11[0] ;
         A1651LSD1IdentificacionEnvio_14_2 = P01Q32_A1651LSD1IdentificacionEnvio_14_2[0] ;
         A1652LSD1periodoLiquidacion_16_6 = P01Q32_A1652LSD1periodoLiquidacion_16_6[0] ;
         A1653LSD1tipoLiquidacion_22_1 = P01Q32_A1653LSD1tipoLiquidacion_22_1[0] ;
         A1654LSD1numeroLiquidacion_23_5 = P01Q32_A1654LSD1numeroLiquidacion_23_5[0] ;
         A1655LSD1diasBase_28_2 = P01Q32_A1655LSD1diasBase_28_2[0] ;
         A1656LSD1cantidadRegistrosTipo04_30 = P01Q32_A1656LSD1cantidadRegistrosTipo04_30[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "entra LSDSec ", "")+GXutil.trim( GXutil.str( A1649LSDSec, 8, 0))) ;
         AV114LiqNro = A1733LSD1LiqNro ;
         /* Execute user subroutine: 'ABRIR ARCHIVO' */
         S111 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_char3[0] = "" ;
         GXv_int4[0] = AV86EmpCUIT ;
         GXv_char5[0] = "" ;
         GXv_char6[0] = "" ;
         GXv_char7[0] = "" ;
         GXv_char8[0] = "" ;
         GXv_char9[0] = "" ;
         GXv_char10[0] = "" ;
         new web.getdatosempresa(remoteHandle, context).execute( AV62CliCod, AV85EmpCod, GXv_char3, GXv_int4, GXv_char5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10) ;
         bajalsdaarchivo2.this.AV86EmpCUIT = GXv_int4[0] ;
         AV14Archivo.appendAllText("01", "");
         AV14Archivo.appendAllText(GXutil.padr( GXutil.trim( GXutil.str( A1650LSD1CuitEmpl_3_11, 11, 0)), 11, " "), "");
         AV14Archivo.appendAllText(GXutil.trim( A1651LSD1IdentificacionEnvio_14_2), "");
         AV11AnioMes = (int)(GXutil.year( AV117LiqPeriodo)*100+GXutil.month( AV117LiqPeriodo)) ;
         AV14Archivo.appendAllText(GXutil.trim( GXutil.str( A1652LSD1periodoLiquidacion_16_6, 6, 0)), "");
         AV156TipoEnvio = A1651LSD1IdentificacionEnvio_14_2 ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "tipoenvio ", "")+GXutil.trim( AV156TipoEnvio)) ;
         if ( GXutil.strcmp(AV156TipoEnvio, "SJ") == 0 )
         {
            AV14Archivo.appendAllText(GXutil.trim( A1653LSD1tipoLiquidacion_22_1), "");
            if ( GXutil.len( GXutil.trim( GXutil.str( A1654LSD1numeroLiquidacion_23_5, 5, 0))) <= 5 )
            {
               AV116LiqNroSTR = GXutil.trim( GXutil.str( A1654LSD1numeroLiquidacion_23_5, 5, 0)) ;
            }
            else
            {
               AV116LiqNroSTR = GXutil.substring( GXutil.trim( GXutil.str( A1654LSD1numeroLiquidacion_23_5, 5, 0)), 1, 5) ;
            }
            AV116LiqNroSTR = GXutil.padl( AV116LiqNroSTR, (short)(5), "0") ;
            AV14Archivo.appendAllText(GXutil.trim( AV116LiqNroSTR), "");
         }
         else
         {
            AV14Archivo.appendAllText(AV111libre, "");
            AV14Archivo.appendAllText(GXutil.padr( AV111libre, 5, " "), "");
         }
         AV14Archivo.appendAllText(GXutil.padr( GXutil.trim( GXutil.str( A1655LSD1diasBase_28_2, 2, 0)), 2, " "), "");
         AV53CantEmpLiqSTR = GXutil.padl( GXutil.trim( GXutil.str( A1656LSD1cantidadRegistrosTipo04_30, 6, 0)), (short)(6), "0") ;
         AV14Archivo.appendAllText(AV53CantEmpLiqSTR, "");
         /* Execute user subroutine: 'ESCRIBIR ENTER' */
         S121 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(AV156TipoEnvio, "SJ") == 0 )
         {
            pr_default.dynParam(1, new Object[]{ new Object[]{
                                                 Long.valueOf(AV164LSD2cuilEmpleado_3_11) ,
                                                 Long.valueOf(A1658LSD2cuilEmpleado_3_11) ,
                                                 Integer.valueOf(A3CliCod) ,
                                                 Short.valueOf(A1EmpCod) ,
                                                 Integer.valueOf(A1649LSDSec) } ,
                                                 new int[]{
                                                 TypeConstants.LONG, TypeConstants.LONG, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                                 }
            });
            /* Using cursor P01Q33 */
            pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Long.valueOf(AV164LSD2cuilEmpleado_3_11)});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1657LSD2Sec = P01Q33_A1657LSD2Sec[0] ;
               A1658LSD2cuilEmpleado_3_11 = P01Q33_A1658LSD2cuilEmpleado_3_11[0] ;
               A1659LSD2legajoEmpleado_14_10 = P01Q33_A1659LSD2legajoEmpleado_14_10[0] ;
               A1660LSD2dependenciaRevista_24_50 = P01Q33_A1660LSD2dependenciaRevista_24_50[0] ;
               A1661LSD2cbuEmpleado_74_22 = P01Q33_A1661LSD2cbuEmpleado_74_22[0] ;
               A1662LSD2diasLiquidados_96_3 = P01Q33_A1662LSD2diasLiquidados_96_3[0] ;
               A1663LSD2fechaPago_99_8 = P01Q33_A1663LSD2fechaPago_99_8[0] ;
               A1664LSD2fechaRubrica_107_8 = P01Q33_A1664LSD2fechaRubrica_107_8[0] ;
               A1665LSD2formaPago_115_1 = P01Q33_A1665LSD2formaPago_115_1[0] ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "LSD_reg2 LSD2Sec ", "")+GXutil.trim( GXutil.str( A1657LSD2Sec, 8, 0))) ;
               AV14Archivo.appendAllText("02", "");
               AV14Archivo.appendAllText(GXutil.padr( GXutil.trim( GXutil.str( A1658LSD2cuilEmpleado_3_11, 11, 0)), 11, " "), "");
               AV108Legajo = GXutil.padl( GXutil.trim( A1659LSD2legajoEmpleado_14_10), (short)(10), " ") ;
               AV14Archivo.appendAllText(AV108Legajo, "");
               AV14Archivo.appendAllText(GXutil.padr( A1660LSD2dependenciaRevista_24_50, 50, " "), "");
               AV14Archivo.appendAllText(GXutil.padr( A1661LSD2cbuEmpleado_74_22, 22, " "), "");
               AV80DiasLiquidados = GXutil.padl( GXutil.trim( GXutil.str( A1662LSD2diasLiquidados_96_3, 3, 0)), (short)(3), "0") ;
               AV14Archivo.appendAllText(AV80DiasLiquidados, "");
               if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1663LSD2fechaPago_99_8)) )
               {
                  AV94FechaSTR = GXutil.trim( GXutil.str( GXutil.year( A1663LSD2fechaPago_99_8), 10, 0)) + GXutil.padl( GXutil.trim( GXutil.str( GXutil.month( A1663LSD2fechaPago_99_8), 10, 0)), (short)(2), "0") + GXutil.padl( GXutil.trim( GXutil.str( GXutil.day( A1663LSD2fechaPago_99_8), 10, 0)), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV94FechaSTR, "");
               }
               else
               {
                  AV14Archivo.appendAllText("        ", "");
               }
               if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1664LSD2fechaRubrica_107_8)) )
               {
                  AV94FechaSTR = GXutil.trim( GXutil.str( GXutil.year( A1664LSD2fechaRubrica_107_8), 10, 0)) + GXutil.padl( GXutil.trim( GXutil.str( GXutil.month( A1664LSD2fechaRubrica_107_8), 10, 0)), (short)(2), "0") + GXutil.padl( GXutil.trim( GXutil.str( GXutil.day( A1664LSD2fechaRubrica_107_8), 10, 0)), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV94FechaSTR, "");
               }
               else
               {
                  AV14Archivo.appendAllText("        ", "");
               }
               AV14Archivo.appendAllText(A1665LSD2formaPago_115_1, "");
               /* Execute user subroutine: 'ESCRIBIR ENTER' */
               S121 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               /* Using cursor P01Q34 */
               pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
               while ( (pr_default.getStatus(2) != 101) )
               {
                  A1667LSD3cuilEmpleado_3_11 = P01Q34_A1667LSD3cuilEmpleado_3_11[0] ;
                  A1668LSD3codigoConcepto_14_10 = P01Q34_A1668LSD3codigoConcepto_14_10[0] ;
                  A1669LSD3cantidadConcepto_24_5 = P01Q34_A1669LSD3cantidadConcepto_24_5[0] ;
                  A1670LSD3unidadesConcepto_29_1 = P01Q34_A1670LSD3unidadesConcepto_29_1[0] ;
                  A1671LSD3importeConcepto_30_15 = P01Q34_A1671LSD3importeConcepto_30_15[0] ;
                  A1672LSD3debitoCredito_45_1 = P01Q34_A1672LSD3debitoCredito_45_1[0] ;
                  A1673LSD3periodoAjuste_46_6 = P01Q34_A1673LSD3periodoAjuste_46_6[0] ;
                  A1666LSD3Sec = P01Q34_A1666LSD3Sec[0] ;
                  AV14Archivo.appendAllText("03", "");
                  AV14Archivo.appendAllText(GXutil.padr( GXutil.trim( GXutil.str( A1667LSD3cuilEmpleado_3_11, 11, 0)), 11, " "), "");
                  AV70Concepto = GXutil.padl( GXutil.trim( A1668LSD3codigoConcepto_14_10), (short)(10), " ") ;
                  AV14Archivo.appendAllText(AV70Concepto, "");
                  AV56Cantidad = GXutil.trim( GXutil.str( A1669LSD3cantidadConcepto_24_5, 6, 2)) ;
                  AV56Cantidad = GXutil.strReplace( AV56Cantidad, ",", "") ;
                  AV56Cantidad = GXutil.strReplace( AV56Cantidad, ".", "") ;
                  AV56Cantidad = GXutil.padl( AV56Cantidad, (short)(5), "0") ;
                  AV14Archivo.appendAllText(AV56Cantidad, "");
                  AV14Archivo.appendAllText(A1670LSD3unidadesConcepto_29_1, "");
                  AV105ImporteSTR = GXutil.trim( GXutil.str( A1671LSD3importeConcepto_30_15, 16, 2)) ;
                  AV105ImporteSTR = GXutil.strReplace( AV105ImporteSTR, ",", "") ;
                  AV105ImporteSTR = GXutil.strReplace( AV105ImporteSTR, ".", "") ;
                  AV105ImporteSTR = GXutil.padl( AV105ImporteSTR, (short)(15), "0") ;
                  AV14Archivo.appendAllText(AV105ImporteSTR, "");
                  AV14Archivo.appendAllText(A1672LSD3debitoCredito_45_1, "");
                  if ( A1673LSD3periodoAjuste_46_6 == 0 )
                  {
                     AV14Archivo.appendAllText("      ", "");
                  }
                  else
                  {
                     AV14Archivo.appendAllText(GXutil.trim( GXutil.str( A1673LSD3periodoAjuste_46_6, 6, 0)), "");
                  }
                  /* Execute user subroutine: 'ESCRIBIR ENTER' */
                  S121 ();
                  if ( returnInSub )
                  {
                     pr_default.close(2);
                     pr_default.close(1);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  pr_default.readNext(2);
               }
               pr_default.close(2);
               /* Using cursor P01Q35 */
               pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A1649LSDSec), Integer.valueOf(A1657LSD2Sec)});
               while ( (pr_default.getStatus(3) != 101) )
               {
                  A1675LSD4CUIL_3_11 = P01Q35_A1675LSD4CUIL_3_11[0] ;
                  A1676LSD4Conyuge_14_1 = P01Q35_A1676LSD4Conyuge_14_1[0] ;
                  A1677LSD4CantidadHijos_15_2 = P01Q35_A1677LSD4CantidadHijos_15_2[0] ;
                  A1678LSD4MarcaCCT_17_1 = P01Q35_A1678LSD4MarcaCCT_17_1[0] ;
                  A1679LSD4MarcaSCVO_18_1 = P01Q35_A1679LSD4MarcaSCVO_18_1[0] ;
                  A1680LSD4MarcaReduccion_19_1 = P01Q35_A1680LSD4MarcaReduccion_19_1[0] ;
                  A1681LSD4TipoEmpresa_20_1 = P01Q35_A1681LSD4TipoEmpresa_20_1[0] ;
                  A1682LSD4TipoOperacion_21_1 = P01Q35_A1682LSD4TipoOperacion_21_1[0] ;
                  A1683LSD4CodigoSituacion_22_2 = P01Q35_A1683LSD4CodigoSituacion_22_2[0] ;
                  A1684LSD4CodigoCondicion_24_2 = P01Q35_A1684LSD4CodigoCondicion_24_2[0] ;
                  A1685LSD4CodigoActividad_26_3 = P01Q35_A1685LSD4CodigoActividad_26_3[0] ;
                  A1686LSD4CodigoModalidadContratacio = P01Q35_A1686LSD4CodigoModalidadContratacio[0] ;
                  A1687LSD4CodigoSiniestrado_32_2 = P01Q35_A1687LSD4CodigoSiniestrado_32_2[0] ;
                  A1688LSD4CodigoLocalidad_34_2 = P01Q35_A1688LSD4CodigoLocalidad_34_2[0] ;
                  A1689LSD4SituacionRevista1_36_2 = P01Q35_A1689LSD4SituacionRevista1_36_2[0] ;
                  A1690LSD4DiaInicioSituacionRevista1 = P01Q35_A1690LSD4DiaInicioSituacionRevista1[0] ;
                  A1691LSD4SituacionRevista2_40_2 = P01Q35_A1691LSD4SituacionRevista2_40_2[0] ;
                  A1692LSD4DiaInicioSituacionRevista2 = P01Q35_A1692LSD4DiaInicioSituacionRevista2[0] ;
                  A1693LSD4SituacionRevista3_44_2 = P01Q35_A1693LSD4SituacionRevista3_44_2[0] ;
                  A1694LSD4DiaInicioSituacionRevista3 = P01Q35_A1694LSD4DiaInicioSituacionRevista3[0] ;
                  A1695LSD4CantidadDiasTrabajados_48_ = P01Q35_A1695LSD4CantidadDiasTrabajados_48_[0] ;
                  A1696LSD4HorasTrabajadas_50_3 = P01Q35_A1696LSD4HorasTrabajadas_50_3[0] ;
                  A1697LSD4PorcentajeAporteAdicionalS = P01Q35_A1697LSD4PorcentajeAporteAdicionalS[0] ;
                  A1698LSD4ContribucionTareaDiferenci = P01Q35_A1698LSD4ContribucionTareaDiferenci[0] ;
                  A1699LSD4CodigoObraSocial_63_6 = P01Q35_A1699LSD4CodigoObraSocial_63_6[0] ;
                  A1700LSD4CantidadAdherentes_69_2 = P01Q35_A1700LSD4CantidadAdherentes_69_2[0] ;
                  A1701LSD4AporteAdicionalOS_71_15 = P01Q35_A1701LSD4AporteAdicionalOS_71_15[0] ;
                  A1702LSD4ContribucionAdicionalOS_86 = P01Q35_A1702LSD4ContribucionAdicionalOS_86[0] ;
                  A1703LSD4BaseCalculoDiferencialApor = P01Q35_A1703LSD4BaseCalculoDiferencialApor[0] ;
                  A1704LSD4BaseCalculoDiferencialOSyF = P01Q35_A1704LSD4BaseCalculoDiferencialOSyF[0] ;
                  A1705LSD4BaseCalculoDiferencialLRT_ = P01Q35_A1705LSD4BaseCalculoDiferencialLRT_[0] ;
                  A1706LSD4RemuneracionMaternidadANSe = P01Q35_A1706LSD4RemuneracionMaternidadANSe[0] ;
                  A1707LSD4RemuneracionBruta_161_15 = P01Q35_A1707LSD4RemuneracionBruta_161_15[0] ;
                  A1708LSD4BaseImponible1_176_15 = P01Q35_A1708LSD4BaseImponible1_176_15[0] ;
                  A1709LSD4BaseImponible2_191_15 = P01Q35_A1709LSD4BaseImponible2_191_15[0] ;
                  A1710LSD4BaseImponible3_206_15 = P01Q35_A1710LSD4BaseImponible3_206_15[0] ;
                  A1711LSD4BaseImponible4_221_15 = P01Q35_A1711LSD4BaseImponible4_221_15[0] ;
                  A1712LSD4BaseImponible5_236_15 = P01Q35_A1712LSD4BaseImponible5_236_15[0] ;
                  A1713LSD4BaseImponible6_251_15 = P01Q35_A1713LSD4BaseImponible6_251_15[0] ;
                  A1714LSD4BaseImponible7_266_15 = P01Q35_A1714LSD4BaseImponible7_266_15[0] ;
                  A1715LSD4BaseImponible8_281_15 = P01Q35_A1715LSD4BaseImponible8_281_15[0] ;
                  A1716LSD4BaseImponible9_296_15 = P01Q35_A1716LSD4BaseImponible9_296_15[0] ;
                  A1717LSD4BaseDifApoSegSoc_311_15 = P01Q35_A1717LSD4BaseDifApoSegSoc_311_15[0] ;
                  A1718LSD4BaseDifContSegSoc_326_15 = P01Q35_A1718LSD4BaseDifContSegSoc_326_15[0] ;
                  A1719LSD4BaseImponible10_341_15 = P01Q35_A1719LSD4BaseImponible10_341_15[0] ;
                  A1720LSD4ImporteADetraer_356_15 = P01Q35_A1720LSD4ImporteADetraer_356_15[0] ;
                  A1674LSD4Sec = P01Q35_A1674LSD4Sec[0] ;
                  AV14Archivo.appendAllText("04", "");
                  AV14Archivo.appendAllText(GXutil.padr( GXutil.trim( GXutil.str( A1675LSD4CUIL_3_11, 11, 0)), 11, " "), "");
                  AV14Archivo.appendAllText(A1676LSD4Conyuge_14_1, "");
                  AV55CantHijosSTR = GXutil.padl( GXutil.trim( GXutil.str( A1677LSD4CantidadHijos_15_2, 2, 0)), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV55CantHijosSTR, "");
                  AV14Archivo.appendAllText(A1678LSD4MarcaCCT_17_1, "");
                  AV14Archivo.appendAllText(A1679LSD4MarcaSCVO_18_1, "");
                  AV14Archivo.appendAllText(A1680LSD4MarcaReduccion_19_1, "");
                  AV14Archivo.appendAllText(A1681LSD4TipoEmpresa_20_1, "");
                  AV14Archivo.appendAllText(A1682LSD4TipoOperacion_21_1, "");
                  AV67CodigoSituacion = GXutil.padl( GXutil.trim( A1683LSD4CodigoSituacion_22_2), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV67CodigoSituacion, "");
                  AV64CodigoCondicion = GXutil.padl( GXutil.trim( A1684LSD4CodigoCondicion_24_2), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV64CodigoCondicion, "");
                  AV63CodigoActividad = GXutil.padl( GXutil.trim( A1685LSD4CodigoActividad_26_3), (short)(3), "0") ;
                  AV14Archivo.appendAllText(AV63CodigoActividad, "");
                  AV125ModalPromovida = GXutil.padl( GXutil.trim( A1686LSD4CodigoModalidadContratacio), (short)(3), "0") ;
                  AV14Archivo.appendAllText(AV125ModalPromovida, "");
                  AV66CodigoSiniestrado = GXutil.padl( GXutil.trim( A1687LSD4CodigoSiniestrado_32_2), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV66CodigoSiniestrado, "");
                  AV14Archivo.appendAllText(GXutil.padr( A1688LSD4CodigoLocalidad_34_2, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1689LSD4SituacionRevista1_36_2, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1690LSD4DiaInicioSituacionRevista1, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1691LSD4SituacionRevista2_40_2, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1692LSD4DiaInicioSituacionRevista2, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1693LSD4SituacionRevista3_44_2, 2, " "), "");
                  AV14Archivo.appendAllText(GXutil.padr( A1694LSD4DiaInicioSituacionRevista3, 2, " "), "");
                  AV57CantidadDiasTrabajados = GXutil.padl( GXutil.trim( GXutil.str( A1695LSD4CantidadDiasTrabajados_48_, 2, 0)), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV57CantidadDiasTrabajados, "");
                  AV59CantidadHorasTrabajadas = GXutil.padl( GXutil.trim( GXutil.str( A1696LSD4HorasTrabajadas_50_3, 3, 0)), (short)(3), "0") ;
                  AV14Archivo.appendAllText(AV59CantidadHorasTrabajadas, "");
                  AV151STR = GXutil.trim( GXutil.str( A1697LSD4PorcentajeAporteAdicionalS, 8, 2)) ;
                  AV151STR = GXutil.strReplace( AV151STR, ",", "") ;
                  AV151STR = GXutil.strReplace( AV151STR, ".", "") ;
                  AV151STR = GXutil.padl( AV151STR, (short)(5), "0") ;
                  AV14Archivo.appendAllText(AV151STR, "");
                  AV151STR = GXutil.trim( GXutil.str( A1698LSD4ContribucionTareaDiferenci, 6, 2)) ;
                  AV151STR = GXutil.strReplace( AV151STR, ",", "") ;
                  AV151STR = GXutil.strReplace( AV151STR, ".", "") ;
                  AV151STR = GXutil.padl( AV151STR, (short)(5), "0") ;
                  AV14Archivo.appendAllText(AV151STR, "");
                  AV65CodigoObraSocial = GXutil.padl( GXutil.trim( A1699LSD4CodigoObraSocial_63_6), (short)(6), " ") ;
                  AV14Archivo.appendAllText(GXutil.padr( A1699LSD4CodigoObraSocial_63_6, 6, " "), "");
                  AV50CantAderentesSTR = GXutil.padl( GXutil.trim( GXutil.str( A1700LSD4CantidadAdherentes_69_2, 2, 0)), (short)(2), "0") ;
                  AV14Archivo.appendAllText(AV50CantAderentesSTR, "");
                  AV102ImporteAdicionalOSSTR = GXutil.trim( GXutil.str( A1701LSD4AporteAdicionalOS_71_15, 16, 2)) ;
                  AV102ImporteAdicionalOSSTR = GXutil.strReplace( AV102ImporteAdicionalOSSTR, ",", "") ;
                  AV102ImporteAdicionalOSSTR = GXutil.strReplace( AV102ImporteAdicionalOSSTR, ".", "") ;
                  AV102ImporteAdicionalOSSTR = GXutil.padl( AV102ImporteAdicionalOSSTR, (short)(15), "0") ;
                  AV14Archivo.appendAllText(GXutil.padl( AV102ImporteAdicionalOSSTR, (short)(15), "0"), "");
                  AV13AporteAdicionalOSSTR = GXutil.trim( GXutil.str( A1702LSD4ContribucionAdicionalOS_86, 16, 2)) ;
                  AV13AporteAdicionalOSSTR = GXutil.strReplace( AV13AporteAdicionalOSSTR, ",", "") ;
                  AV13AporteAdicionalOSSTR = GXutil.strReplace( AV13AporteAdicionalOSSTR, ".", "") ;
                  AV13AporteAdicionalOSSTR = GXutil.padl( AV13AporteAdicionalOSSTR, (short)(15), "0") ;
                  AV14Archivo.appendAllText(GXutil.padl( AV13AporteAdicionalOSSTR, (short)(15), "0"), "");
                  GXt_char11 = AV26BaseDifeObraSocialyFSR ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1703LSD4BaseCalculoDiferencialApor, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV26BaseDifeObraSocialyFSR = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV26BaseDifeObraSocialyFSR, (short)(15), "0"), "");
                  GXt_char11 = AV24BaseDifeContribOSyFSR ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1704LSD4BaseCalculoDiferencialOSyF, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV24BaseDifeContribOSyFSR = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV24BaseDifeContribOSyFSR, (short)(15), "0"), "");
                  GXt_char11 = AV25BaseDifeLeyRiesTrab ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1705LSD4BaseCalculoDiferencialLRT_, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV25BaseDifeLeyRiesTrab = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV25BaseDifeLeyRiesTrab, (short)(15), "0"), "");
                  AV104ImporteMaternidadSTR = GXutil.trim( GXutil.str( A1706LSD4RemuneracionMaternidadANSe, 16, 2)) ;
                  AV104ImporteMaternidadSTR = GXutil.strReplace( AV104ImporteMaternidadSTR, ",", "") ;
                  AV104ImporteMaternidadSTR = GXutil.strReplace( AV104ImporteMaternidadSTR, ".", "") ;
                  AV104ImporteMaternidadSTR = GXutil.padl( AV104ImporteMaternidadSTR, (short)(15), "0") ;
                  AV14Archivo.appendAllText(GXutil.padl( AV104ImporteMaternidadSTR, (short)(15), "0"), "");
                  AV153SueldoBrutoSTR = GXutil.trim( GXutil.str( A1707LSD4RemuneracionBruta_161_15, 16, 2)) ;
                  AV153SueldoBrutoSTR = GXutil.strReplace( AV153SueldoBrutoSTR, ",", "") ;
                  AV153SueldoBrutoSTR = GXutil.strReplace( AV153SueldoBrutoSTR, ".", "") ;
                  AV153SueldoBrutoSTR = GXutil.padl( AV153SueldoBrutoSTR, (short)(15), "0") ;
                  AV14Archivo.appendAllText(GXutil.padl( AV153SueldoBrutoSTR, (short)(15), "0"), "");
                  GXt_char11 = AV28BaseImponible1 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1708LSD4BaseImponible1_176_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV28BaseImponible1 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV28BaseImponible1, (short)(15), "0"), "");
                  GXt_char11 = AV33BaseImponible2 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1709LSD4BaseImponible2_191_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV33BaseImponible2 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV33BaseImponible2, (short)(15), "0"), "");
                  GXt_char11 = AV35BaseImponible3 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1710LSD4BaseImponible3_206_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV35BaseImponible3 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV35BaseImponible3, (short)(15), "0"), "");
                  GXt_char11 = AV37BaseImponible4 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1711LSD4BaseImponible4_221_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV37BaseImponible4 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV37BaseImponible4, (short)(15), "0"), "");
                  GXt_char11 = AV39BaseImponible5 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1712LSD4BaseImponible5_236_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV39BaseImponible5 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV39BaseImponible5, (short)(15), "0"), "");
                  GXt_char11 = AV41BaseImponible6 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1713LSD4BaseImponible6_251_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV41BaseImponible6 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV41BaseImponible6, (short)(15), "0"), "");
                  GXt_char11 = AV43BaseImponible7 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1714LSD4BaseImponible7_266_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV43BaseImponible7 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV43BaseImponible7, (short)(15), "0"), "");
                  GXt_char11 = AV45BaseImponible8 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1715LSD4BaseImponible8_281_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV45BaseImponible8 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV45BaseImponible8, (short)(15), "0"), "");
                  GXt_char11 = AV47BaseImponible9 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1716LSD4BaseImponible9_296_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV47BaseImponible9 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV47BaseImponible9, (short)(15), "0"), "");
                  GXt_char11 = AV19BaseDifApoSS ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1717LSD4BaseDifApoSegSoc_311_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV19BaseDifApoSS = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV19BaseDifApoSS, (short)(15), "0"), "");
                  GXt_char11 = AV22BaseDifContrSS ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1718LSD4BaseDifContSegSoc_326_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV22BaseDifContrSS = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV22BaseDifContrSS, (short)(15), "0"), "");
                  GXt_char11 = AV31BaseImponible10 ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1719LSD4BaseImponible10_341_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV31BaseImponible10 = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV31BaseImponible10, (short)(15), "0"), "");
                  GXt_char11 = AV99ImporteADetraer ;
                  GXv_char10[0] = GXt_char11 ;
                  new web.sacarpuntosycomas(remoteHandle, context).execute( A1720LSD4ImporteADetraer_356_15, GXv_char10) ;
                  bajalsdaarchivo2.this.GXt_char11 = GXv_char10[0] ;
                  AV99ImporteADetraer = GXt_char11 ;
                  AV14Archivo.appendAllText(GXutil.padl( AV99ImporteADetraer, (short)(15), "0"), "");
                  /* Execute user subroutine: 'ESCRIBIR ENTER' */
                  S121 ();
                  if ( returnInSub )
                  {
                     pr_default.close(3);
                     pr_default.close(1);
                     pr_default.close(0);
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  pr_default.readNext(3);
               }
               pr_default.close(3);
               pr_default.readNext(1);
            }
            pr_default.close(1);
         }
         AV14Archivo.close();
         new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "&archivoAbsolute ", "")+AV15archivoAbsolute+httpContext.getMessage( " &NombreArchivo ", "")+AV126NombreArchivo) ;
         AV16archivos.add(AV15archivoAbsolute, 0);
         AV17archivosNombres.add(GXutil.trim( AV126NombreArchivo), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "archivos.Count ", "")+GXutil.trim( GXutil.str( AV16archivos.size(), 9, 0))) ;
      if ( AV16archivos.size() > 1 )
      {
         AV138Random = GXutil.format( "%1%2%3%4%5%6", GXutil.ltrimstr( GXutil.year( AV165ahora), 9, 0), GXutil.ltrimstr( GXutil.month( AV165ahora), 9, 0), GXutil.ltrimstr( GXutil.day( AV165ahora), 9, 0), GXutil.ltrimstr( GXutil.hour( AV165ahora), 9, 0), GXutil.ltrimstr( GXutil.minute( AV165ahora), 9, 0), GXutil.ltrimstr( GXutil.second( AV165ahora), 9, 0), "", "", "") ;
         AV126NombreArchivo = httpContext.getMessage( "LSD_", "") + GXutil.trim( AV138Random) + httpContext.getMessage( ".zip", "") ;
         AV15archivoAbsolute = GXutil.trim( AV140rutaAplicacion) + "/" + GXutil.trim( AV126NombreArchivo) ;
         AV160zipFile.setSource( GXutil.trim( AV15archivoAbsolute) );
         if ( AV160zipFile.exists() )
         {
            AV160zipFile.delete();
         }
         AV87errorN = (short)(AV159Zip.crear(AV15archivoAbsolute)) ;
         if ( AV87errorN != 0 )
         {
            AV8error = httpContext.getMessage( "ERROR AL CREAR EL ARCHIVO ZIP \"", "") + GXutil.trim( AV15archivoAbsolute) + "\" (" + GXutil.trim( GXutil.str( AV87errorN, 4, 0)) + ")" ;
            httpContext.GX_msglist.addItem(AV8error);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, AV8error) ;
         }
         else
         {
            AV98i = (short)(1) ;
            while ( AV98i <= AV16archivos.size() )
            {
               AV161zipNombre = GXutil.trim( (String)AV17archivosNombres.elementAt(-1+AV98i)) ;
               AV162zipRuta = GXutil.trim( (String)AV16archivos.elementAt(-1+AV98i)) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, httpContext.getMessage( "&!!!zipRuta ", "")+GXutil.trim( AV162zipRuta)+httpContext.getMessage( " &zipNombre ", "")+GXutil.trim( AV161zipNombre)) ;
               AV87errorN = (short)(AV159Zip.agregararchivo(GXutil.trim( AV162zipRuta), GXutil.trim( AV161zipNombre))) ;
               if ( AV87errorN != 0 )
               {
                  AV8error = httpContext.getMessage( "ERROR AL AGREGAR ARCHIVO AL ZIP \"", "") + GXutil.trim( AV162zipRuta) + "\" (" + GXutil.trim( GXutil.str( AV87errorN, 4, 0)) + ")" ;
                  httpContext.GX_msglist.addItem(AV8error);
                  new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, AV8error) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV98i = (short)(AV98i+1) ;
            }
            AV87errorN = (short)(AV159Zip.cerrar()) ;
            if ( AV87errorN != 0 )
            {
               AV8error = httpContext.getMessage( "ERROR AL CERRAR EL ARCHIVO ZIP \"", "") + GXutil.trim( AV15archivoAbsolute) + "\" (" + GXutil.trim( GXutil.str( AV87errorN, 4, 0)) + ")" ;
               httpContext.GX_msglist.addItem(AV8error);
               new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, AV8error) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'ABRIR ARCHIVO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV62CliCod, AV168Pgmname, AV140rutaAplicacion+"/"+AV126NombreArchivo) ;
      AV126NombreArchivo = httpContext.getMessage( "LSD_", "") + GXutil.trim( GXutil.str( AV114LiqNro, 8, 0)) + httpContext.getMessage( ".txt", "") ;
      AV14Archivo.setSource( AV140rutaAplicacion+"/"+AV126NombreArchivo );
      if ( AV14Archivo.exists() )
      {
         AV14Archivo.delete();
      }
      AV146SeparadorCampo = "" ;
      AV147SeparadorTexto = "" ;
      AV10Agregar = (short)(0) ;
      AV111libre = " " ;
      AV15archivoAbsolute = AV140rutaAplicacion + "/" + AV126NombreArchivo ;
      AV14Archivo.openWrite("");
   }

   public void S121( )
   {
      /* 'ESCRIBIR ENTER' Routine */
      returnInSub = false ;
      AV14Archivo.appendAllText(GXutil.chr( (short)(13)), "");
      AV14Archivo.appendAllText(GXutil.chr( (short)(10)), "");
   }

   protected void cleanup( )
   {
      this.aP5[0] = bajalsdaarchivo2.this.AV15archivoAbsolute;
      this.aP6[0] = bajalsdaarchivo2.this.AV126NombreArchivo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15archivoAbsolute = "" ;
      AV126NombreArchivo = "" ;
      AV165ahora = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime1 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime2 = new java.util.Date[1] ;
      AV168Pgmname = "" ;
      AV140rutaAplicacion = "" ;
      AV95folder = new com.genexus.util.GXDirectory();
      scmdbuf = "" ;
      A1734LSD1LiqPeriodo = GXutil.nullDate() ;
      P01Q32_A1649LSDSec = new int[1] ;
      P01Q32_A1EmpCod = new short[1] ;
      P01Q32_A3CliCod = new int[1] ;
      P01Q32_A1734LSD1LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01Q32_A1733LSD1LiqNro = new int[1] ;
      P01Q32_A1650LSD1CuitEmpl_3_11 = new long[1] ;
      P01Q32_A1651LSD1IdentificacionEnvio_14_2 = new String[] {""} ;
      P01Q32_A1652LSD1periodoLiquidacion_16_6 = new int[1] ;
      P01Q32_A1653LSD1tipoLiquidacion_22_1 = new String[] {""} ;
      P01Q32_A1654LSD1numeroLiquidacion_23_5 = new int[1] ;
      P01Q32_A1655LSD1diasBase_28_2 = new byte[1] ;
      P01Q32_A1656LSD1cantidadRegistrosTipo04_30 = new int[1] ;
      A1651LSD1IdentificacionEnvio_14_2 = "" ;
      A1653LSD1tipoLiquidacion_22_1 = "" ;
      GXv_char3 = new String[1] ;
      GXv_int4 = new long[1] ;
      GXv_char5 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      AV14Archivo = new com.genexus.util.GXFile();
      AV117LiqPeriodo = GXutil.nullDate() ;
      AV156TipoEnvio = "" ;
      AV116LiqNroSTR = "" ;
      AV111libre = "" ;
      AV53CantEmpLiqSTR = "" ;
      P01Q33_A3CliCod = new int[1] ;
      P01Q33_A1EmpCod = new short[1] ;
      P01Q33_A1649LSDSec = new int[1] ;
      P01Q33_A1657LSD2Sec = new int[1] ;
      P01Q33_A1658LSD2cuilEmpleado_3_11 = new long[1] ;
      P01Q33_A1659LSD2legajoEmpleado_14_10 = new String[] {""} ;
      P01Q33_A1660LSD2dependenciaRevista_24_50 = new String[] {""} ;
      P01Q33_A1661LSD2cbuEmpleado_74_22 = new String[] {""} ;
      P01Q33_A1662LSD2diasLiquidados_96_3 = new short[1] ;
      P01Q33_A1663LSD2fechaPago_99_8 = new java.util.Date[] {GXutil.nullDate()} ;
      P01Q33_A1664LSD2fechaRubrica_107_8 = new java.util.Date[] {GXutil.nullDate()} ;
      P01Q33_A1665LSD2formaPago_115_1 = new String[] {""} ;
      A1659LSD2legajoEmpleado_14_10 = "" ;
      A1660LSD2dependenciaRevista_24_50 = "" ;
      A1661LSD2cbuEmpleado_74_22 = "" ;
      A1663LSD2fechaPago_99_8 = GXutil.nullDate() ;
      A1664LSD2fechaRubrica_107_8 = GXutil.nullDate() ;
      A1665LSD2formaPago_115_1 = "" ;
      AV108Legajo = "" ;
      AV80DiasLiquidados = "" ;
      AV94FechaSTR = "" ;
      P01Q34_A3CliCod = new int[1] ;
      P01Q34_A1EmpCod = new short[1] ;
      P01Q34_A1649LSDSec = new int[1] ;
      P01Q34_A1657LSD2Sec = new int[1] ;
      P01Q34_A1667LSD3cuilEmpleado_3_11 = new long[1] ;
      P01Q34_A1668LSD3codigoConcepto_14_10 = new String[] {""} ;
      P01Q34_A1669LSD3cantidadConcepto_24_5 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q34_A1670LSD3unidadesConcepto_29_1 = new String[] {""} ;
      P01Q34_A1671LSD3importeConcepto_30_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q34_A1672LSD3debitoCredito_45_1 = new String[] {""} ;
      P01Q34_A1673LSD3periodoAjuste_46_6 = new int[1] ;
      P01Q34_A1666LSD3Sec = new short[1] ;
      A1668LSD3codigoConcepto_14_10 = "" ;
      A1669LSD3cantidadConcepto_24_5 = DecimalUtil.ZERO ;
      A1670LSD3unidadesConcepto_29_1 = "" ;
      A1671LSD3importeConcepto_30_15 = DecimalUtil.ZERO ;
      A1672LSD3debitoCredito_45_1 = "" ;
      AV70Concepto = "" ;
      AV56Cantidad = "" ;
      AV105ImporteSTR = "" ;
      P01Q35_A3CliCod = new int[1] ;
      P01Q35_A1EmpCod = new short[1] ;
      P01Q35_A1649LSDSec = new int[1] ;
      P01Q35_A1657LSD2Sec = new int[1] ;
      P01Q35_A1675LSD4CUIL_3_11 = new long[1] ;
      P01Q35_A1676LSD4Conyuge_14_1 = new String[] {""} ;
      P01Q35_A1677LSD4CantidadHijos_15_2 = new byte[1] ;
      P01Q35_A1678LSD4MarcaCCT_17_1 = new String[] {""} ;
      P01Q35_A1679LSD4MarcaSCVO_18_1 = new String[] {""} ;
      P01Q35_A1680LSD4MarcaReduccion_19_1 = new String[] {""} ;
      P01Q35_A1681LSD4TipoEmpresa_20_1 = new String[] {""} ;
      P01Q35_A1682LSD4TipoOperacion_21_1 = new String[] {""} ;
      P01Q35_A1683LSD4CodigoSituacion_22_2 = new String[] {""} ;
      P01Q35_A1684LSD4CodigoCondicion_24_2 = new String[] {""} ;
      P01Q35_A1685LSD4CodigoActividad_26_3 = new String[] {""} ;
      P01Q35_A1686LSD4CodigoModalidadContratacio = new String[] {""} ;
      P01Q35_A1687LSD4CodigoSiniestrado_32_2 = new String[] {""} ;
      P01Q35_A1688LSD4CodigoLocalidad_34_2 = new String[] {""} ;
      P01Q35_A1689LSD4SituacionRevista1_36_2 = new String[] {""} ;
      P01Q35_A1690LSD4DiaInicioSituacionRevista1 = new String[] {""} ;
      P01Q35_A1691LSD4SituacionRevista2_40_2 = new String[] {""} ;
      P01Q35_A1692LSD4DiaInicioSituacionRevista2 = new String[] {""} ;
      P01Q35_A1693LSD4SituacionRevista3_44_2 = new String[] {""} ;
      P01Q35_A1694LSD4DiaInicioSituacionRevista3 = new String[] {""} ;
      P01Q35_A1695LSD4CantidadDiasTrabajados_48_ = new byte[1] ;
      P01Q35_A1696LSD4HorasTrabajadas_50_3 = new short[1] ;
      P01Q35_A1697LSD4PorcentajeAporteAdicionalS = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1698LSD4ContribucionTareaDiferenci = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1699LSD4CodigoObraSocial_63_6 = new String[] {""} ;
      P01Q35_A1700LSD4CantidadAdherentes_69_2 = new byte[1] ;
      P01Q35_A1701LSD4AporteAdicionalOS_71_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1702LSD4ContribucionAdicionalOS_86 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1703LSD4BaseCalculoDiferencialApor = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1704LSD4BaseCalculoDiferencialOSyF = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1705LSD4BaseCalculoDiferencialLRT_ = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1706LSD4RemuneracionMaternidadANSe = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1707LSD4RemuneracionBruta_161_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1708LSD4BaseImponible1_176_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1709LSD4BaseImponible2_191_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1710LSD4BaseImponible3_206_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1711LSD4BaseImponible4_221_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1712LSD4BaseImponible5_236_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1713LSD4BaseImponible6_251_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1714LSD4BaseImponible7_266_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1715LSD4BaseImponible8_281_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1716LSD4BaseImponible9_296_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1717LSD4BaseDifApoSegSoc_311_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1718LSD4BaseDifContSegSoc_326_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1719LSD4BaseImponible10_341_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1720LSD4ImporteADetraer_356_15 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01Q35_A1674LSD4Sec = new short[1] ;
      A1676LSD4Conyuge_14_1 = "" ;
      A1678LSD4MarcaCCT_17_1 = "" ;
      A1679LSD4MarcaSCVO_18_1 = "" ;
      A1680LSD4MarcaReduccion_19_1 = "" ;
      A1681LSD4TipoEmpresa_20_1 = "" ;
      A1682LSD4TipoOperacion_21_1 = "" ;
      A1683LSD4CodigoSituacion_22_2 = "" ;
      A1684LSD4CodigoCondicion_24_2 = "" ;
      A1685LSD4CodigoActividad_26_3 = "" ;
      A1686LSD4CodigoModalidadContratacio = "" ;
      A1687LSD4CodigoSiniestrado_32_2 = "" ;
      A1688LSD4CodigoLocalidad_34_2 = "" ;
      A1689LSD4SituacionRevista1_36_2 = "" ;
      A1690LSD4DiaInicioSituacionRevista1 = "" ;
      A1691LSD4SituacionRevista2_40_2 = "" ;
      A1692LSD4DiaInicioSituacionRevista2 = "" ;
      A1693LSD4SituacionRevista3_44_2 = "" ;
      A1694LSD4DiaInicioSituacionRevista3 = "" ;
      A1697LSD4PorcentajeAporteAdicionalS = DecimalUtil.ZERO ;
      A1698LSD4ContribucionTareaDiferenci = DecimalUtil.ZERO ;
      A1699LSD4CodigoObraSocial_63_6 = "" ;
      A1701LSD4AporteAdicionalOS_71_15 = DecimalUtil.ZERO ;
      A1702LSD4ContribucionAdicionalOS_86 = DecimalUtil.ZERO ;
      A1703LSD4BaseCalculoDiferencialApor = DecimalUtil.ZERO ;
      A1704LSD4BaseCalculoDiferencialOSyF = DecimalUtil.ZERO ;
      A1705LSD4BaseCalculoDiferencialLRT_ = DecimalUtil.ZERO ;
      A1706LSD4RemuneracionMaternidadANSe = DecimalUtil.ZERO ;
      A1707LSD4RemuneracionBruta_161_15 = DecimalUtil.ZERO ;
      A1708LSD4BaseImponible1_176_15 = DecimalUtil.ZERO ;
      A1709LSD4BaseImponible2_191_15 = DecimalUtil.ZERO ;
      A1710LSD4BaseImponible3_206_15 = DecimalUtil.ZERO ;
      A1711LSD4BaseImponible4_221_15 = DecimalUtil.ZERO ;
      A1712LSD4BaseImponible5_236_15 = DecimalUtil.ZERO ;
      A1713LSD4BaseImponible6_251_15 = DecimalUtil.ZERO ;
      A1714LSD4BaseImponible7_266_15 = DecimalUtil.ZERO ;
      A1715LSD4BaseImponible8_281_15 = DecimalUtil.ZERO ;
      A1716LSD4BaseImponible9_296_15 = DecimalUtil.ZERO ;
      A1717LSD4BaseDifApoSegSoc_311_15 = DecimalUtil.ZERO ;
      A1718LSD4BaseDifContSegSoc_326_15 = DecimalUtil.ZERO ;
      A1719LSD4BaseImponible10_341_15 = DecimalUtil.ZERO ;
      A1720LSD4ImporteADetraer_356_15 = DecimalUtil.ZERO ;
      AV55CantHijosSTR = "" ;
      AV67CodigoSituacion = "" ;
      AV64CodigoCondicion = "" ;
      AV63CodigoActividad = "" ;
      AV125ModalPromovida = "" ;
      AV66CodigoSiniestrado = "" ;
      AV57CantidadDiasTrabajados = "" ;
      AV59CantidadHorasTrabajadas = "" ;
      AV151STR = "" ;
      AV65CodigoObraSocial = "" ;
      AV50CantAderentesSTR = "" ;
      AV102ImporteAdicionalOSSTR = "" ;
      AV13AporteAdicionalOSSTR = "" ;
      AV26BaseDifeObraSocialyFSR = "" ;
      AV24BaseDifeContribOSyFSR = "" ;
      AV25BaseDifeLeyRiesTrab = "" ;
      AV104ImporteMaternidadSTR = "" ;
      AV153SueldoBrutoSTR = "" ;
      AV28BaseImponible1 = "" ;
      AV33BaseImponible2 = "" ;
      AV35BaseImponible3 = "" ;
      AV37BaseImponible4 = "" ;
      AV39BaseImponible5 = "" ;
      AV41BaseImponible6 = "" ;
      AV43BaseImponible7 = "" ;
      AV45BaseImponible8 = "" ;
      AV47BaseImponible9 = "" ;
      AV19BaseDifApoSS = "" ;
      AV22BaseDifContrSS = "" ;
      AV31BaseImponible10 = "" ;
      AV99ImporteADetraer = "" ;
      GXt_char11 = "" ;
      GXv_char10 = new String[1] ;
      AV16archivos = new GXSimpleCollection<String>(String.class, "internal", "");
      AV17archivosNombres = new GXSimpleCollection<String>(String.class, "internal", "");
      AV138Random = "" ;
      AV160zipFile = new com.genexus.util.GXFile();
      AV159Zip = new web.SdtZip(remoteHandle, context);
      AV8error = "" ;
      AV161zipNombre = "" ;
      AV162zipRuta = "" ;
      AV146SeparadorCampo = "" ;
      AV147SeparadorTexto = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.bajalsdaarchivo2__default(),
         new Object[] {
             new Object[] {
            P01Q32_A1649LSDSec, P01Q32_A1EmpCod, P01Q32_A3CliCod, P01Q32_A1734LSD1LiqPeriodo, P01Q32_A1733LSD1LiqNro, P01Q32_A1650LSD1CuitEmpl_3_11, P01Q32_A1651LSD1IdentificacionEnvio_14_2, P01Q32_A1652LSD1periodoLiquidacion_16_6, P01Q32_A1653LSD1tipoLiquidacion_22_1, P01Q32_A1654LSD1numeroLiquidacion_23_5,
            P01Q32_A1655LSD1diasBase_28_2, P01Q32_A1656LSD1cantidadRegistrosTipo04_30
            }
            , new Object[] {
            P01Q33_A3CliCod, P01Q33_A1EmpCod, P01Q33_A1649LSDSec, P01Q33_A1657LSD2Sec, P01Q33_A1658LSD2cuilEmpleado_3_11, P01Q33_A1659LSD2legajoEmpleado_14_10, P01Q33_A1660LSD2dependenciaRevista_24_50, P01Q33_A1661LSD2cbuEmpleado_74_22, P01Q33_A1662LSD2diasLiquidados_96_3, P01Q33_A1663LSD2fechaPago_99_8,
            P01Q33_A1664LSD2fechaRubrica_107_8, P01Q33_A1665LSD2formaPago_115_1
            }
            , new Object[] {
            P01Q34_A3CliCod, P01Q34_A1EmpCod, P01Q34_A1649LSDSec, P01Q34_A1657LSD2Sec, P01Q34_A1667LSD3cuilEmpleado_3_11, P01Q34_A1668LSD3codigoConcepto_14_10, P01Q34_A1669LSD3cantidadConcepto_24_5, P01Q34_A1670LSD3unidadesConcepto_29_1, P01Q34_A1671LSD3importeConcepto_30_15, P01Q34_A1672LSD3debitoCredito_45_1,
            P01Q34_A1673LSD3periodoAjuste_46_6, P01Q34_A1666LSD3Sec
            }
            , new Object[] {
            P01Q35_A3CliCod, P01Q35_A1EmpCod, P01Q35_A1649LSDSec, P01Q35_A1657LSD2Sec, P01Q35_A1675LSD4CUIL_3_11, P01Q35_A1676LSD4Conyuge_14_1, P01Q35_A1677LSD4CantidadHijos_15_2, P01Q35_A1678LSD4MarcaCCT_17_1, P01Q35_A1679LSD4MarcaSCVO_18_1, P01Q35_A1680LSD4MarcaReduccion_19_1,
            P01Q35_A1681LSD4TipoEmpresa_20_1, P01Q35_A1682LSD4TipoOperacion_21_1, P01Q35_A1683LSD4CodigoSituacion_22_2, P01Q35_A1684LSD4CodigoCondicion_24_2, P01Q35_A1685LSD4CodigoActividad_26_3, P01Q35_A1686LSD4CodigoModalidadContratacio, P01Q35_A1687LSD4CodigoSiniestrado_32_2, P01Q35_A1688LSD4CodigoLocalidad_34_2, P01Q35_A1689LSD4SituacionRevista1_36_2, P01Q35_A1690LSD4DiaInicioSituacionRevista1,
            P01Q35_A1691LSD4SituacionRevista2_40_2, P01Q35_A1692LSD4DiaInicioSituacionRevista2, P01Q35_A1693LSD4SituacionRevista3_44_2, P01Q35_A1694LSD4DiaInicioSituacionRevista3, P01Q35_A1695LSD4CantidadDiasTrabajados_48_, P01Q35_A1696LSD4HorasTrabajadas_50_3, P01Q35_A1697LSD4PorcentajeAporteAdicionalS, P01Q35_A1698LSD4ContribucionTareaDiferenci, P01Q35_A1699LSD4CodigoObraSocial_63_6, P01Q35_A1700LSD4CantidadAdherentes_69_2,
            P01Q35_A1701LSD4AporteAdicionalOS_71_15, P01Q35_A1702LSD4ContribucionAdicionalOS_86, P01Q35_A1703LSD4BaseCalculoDiferencialApor, P01Q35_A1704LSD4BaseCalculoDiferencialOSyF, P01Q35_A1705LSD4BaseCalculoDiferencialLRT_, P01Q35_A1706LSD4RemuneracionMaternidadANSe, P01Q35_A1707LSD4RemuneracionBruta_161_15, P01Q35_A1708LSD4BaseImponible1_176_15, P01Q35_A1709LSD4BaseImponible2_191_15, P01Q35_A1710LSD4BaseImponible3_206_15,
            P01Q35_A1711LSD4BaseImponible4_221_15, P01Q35_A1712LSD4BaseImponible5_236_15, P01Q35_A1713LSD4BaseImponible6_251_15, P01Q35_A1714LSD4BaseImponible7_266_15, P01Q35_A1715LSD4BaseImponible8_281_15, P01Q35_A1716LSD4BaseImponible9_296_15, P01Q35_A1717LSD4BaseDifApoSegSoc_311_15, P01Q35_A1718LSD4BaseDifContSegSoc_326_15, P01Q35_A1719LSD4BaseImponible10_341_15, P01Q35_A1720LSD4ImporteADetraer_356_15,
            P01Q35_A1674LSD4Sec
            }
         }
      );
      AV168Pgmname = "bajaLSDAArchivo2" ;
      /* GeneXus formulas. */
      AV168Pgmname = "bajaLSDAArchivo2" ;
      Gx_err = (short)(0) ;
   }

   private byte A1655LSD1diasBase_28_2 ;
   private byte A1677LSD4CantidadHijos_15_2 ;
   private byte A1695LSD4CantidadDiasTrabajados_48_ ;
   private byte A1700LSD4CantidadAdherentes_69_2 ;
   private short AV85EmpCod ;
   private short A1EmpCod ;
   private short A1662LSD2diasLiquidados_96_3 ;
   private short A1666LSD3Sec ;
   private short A1696LSD4HorasTrabajadas_50_3 ;
   private short A1674LSD4Sec ;
   private short AV87errorN ;
   private short AV98i ;
   private short AV10Agregar ;
   private short Gx_err ;
   private int AV62CliCod ;
   private int AV122LSDSec ;
   private int A1649LSDSec ;
   private int A3CliCod ;
   private int A1733LSD1LiqNro ;
   private int A1652LSD1periodoLiquidacion_16_6 ;
   private int A1654LSD1numeroLiquidacion_23_5 ;
   private int A1656LSD1cantidadRegistrosTipo04_30 ;
   private int AV114LiqNro ;
   private int AV11AnioMes ;
   private int A1657LSD2Sec ;
   private int A1673LSD3periodoAjuste_46_6 ;
   private long AV164LSD2cuilEmpleado_3_11 ;
   private long A1650LSD1CuitEmpl_3_11 ;
   private long AV86EmpCUIT ;
   private long GXv_int4[] ;
   private long A1658LSD2cuilEmpleado_3_11 ;
   private long A1667LSD3cuilEmpleado_3_11 ;
   private long A1675LSD4CUIL_3_11 ;
   private java.math.BigDecimal A1669LSD3cantidadConcepto_24_5 ;
   private java.math.BigDecimal A1671LSD3importeConcepto_30_15 ;
   private java.math.BigDecimal A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal A1698LSD4ContribucionTareaDiferenci ;
   private java.math.BigDecimal A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal A1720LSD4ImporteADetraer_356_15 ;
   private String AV168Pgmname ;
   private String scmdbuf ;
   private String A1651LSD1IdentificacionEnvio_14_2 ;
   private String A1653LSD1tipoLiquidacion_22_1 ;
   private String GXv_char3[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String AV156TipoEnvio ;
   private String AV116LiqNroSTR ;
   private String AV111libre ;
   private String AV53CantEmpLiqSTR ;
   private String A1659LSD2legajoEmpleado_14_10 ;
   private String A1660LSD2dependenciaRevista_24_50 ;
   private String A1661LSD2cbuEmpleado_74_22 ;
   private String A1665LSD2formaPago_115_1 ;
   private String AV108Legajo ;
   private String AV80DiasLiquidados ;
   private String AV94FechaSTR ;
   private String A1668LSD3codigoConcepto_14_10 ;
   private String A1670LSD3unidadesConcepto_29_1 ;
   private String A1672LSD3debitoCredito_45_1 ;
   private String AV70Concepto ;
   private String AV56Cantidad ;
   private String AV105ImporteSTR ;
   private String A1676LSD4Conyuge_14_1 ;
   private String A1678LSD4MarcaCCT_17_1 ;
   private String A1679LSD4MarcaSCVO_18_1 ;
   private String A1680LSD4MarcaReduccion_19_1 ;
   private String A1681LSD4TipoEmpresa_20_1 ;
   private String A1682LSD4TipoOperacion_21_1 ;
   private String A1683LSD4CodigoSituacion_22_2 ;
   private String A1684LSD4CodigoCondicion_24_2 ;
   private String A1685LSD4CodigoActividad_26_3 ;
   private String A1686LSD4CodigoModalidadContratacio ;
   private String A1687LSD4CodigoSiniestrado_32_2 ;
   private String A1688LSD4CodigoLocalidad_34_2 ;
   private String A1689LSD4SituacionRevista1_36_2 ;
   private String A1690LSD4DiaInicioSituacionRevista1 ;
   private String A1691LSD4SituacionRevista2_40_2 ;
   private String A1692LSD4DiaInicioSituacionRevista2 ;
   private String A1693LSD4SituacionRevista3_44_2 ;
   private String A1694LSD4DiaInicioSituacionRevista3 ;
   private String A1699LSD4CodigoObraSocial_63_6 ;
   private String AV55CantHijosSTR ;
   private String AV67CodigoSituacion ;
   private String AV64CodigoCondicion ;
   private String AV63CodigoActividad ;
   private String AV125ModalPromovida ;
   private String AV66CodigoSiniestrado ;
   private String AV57CantidadDiasTrabajados ;
   private String AV59CantidadHorasTrabajadas ;
   private String AV151STR ;
   private String AV65CodigoObraSocial ;
   private String AV50CantAderentesSTR ;
   private String AV102ImporteAdicionalOSSTR ;
   private String AV13AporteAdicionalOSSTR ;
   private String AV26BaseDifeObraSocialyFSR ;
   private String AV24BaseDifeContribOSyFSR ;
   private String AV25BaseDifeLeyRiesTrab ;
   private String AV104ImporteMaternidadSTR ;
   private String AV153SueldoBrutoSTR ;
   private String AV28BaseImponible1 ;
   private String AV33BaseImponible2 ;
   private String AV35BaseImponible3 ;
   private String AV37BaseImponible4 ;
   private String AV39BaseImponible5 ;
   private String AV41BaseImponible6 ;
   private String AV43BaseImponible7 ;
   private String AV45BaseImponible8 ;
   private String AV47BaseImponible9 ;
   private String AV19BaseDifApoSS ;
   private String AV22BaseDifContrSS ;
   private String AV31BaseImponible10 ;
   private String AV99ImporteADetraer ;
   private String GXt_char11 ;
   private String GXv_char10[] ;
   private String AV146SeparadorCampo ;
   private String AV147SeparadorTexto ;
   private java.util.Date AV165ahora ;
   private java.util.Date GXt_dtime1 ;
   private java.util.Date GXv_dtime2[] ;
   private java.util.Date AV118LSD1LiqPeriodo ;
   private java.util.Date A1734LSD1LiqPeriodo ;
   private java.util.Date AV117LiqPeriodo ;
   private java.util.Date A1663LSD2fechaPago_99_8 ;
   private java.util.Date A1664LSD2fechaRubrica_107_8 ;
   private boolean returnInSub ;
   private String AV15archivoAbsolute ;
   private String AV126NombreArchivo ;
   private String AV140rutaAplicacion ;
   private String AV138Random ;
   private String AV8error ;
   private String AV161zipNombre ;
   private String AV162zipRuta ;
   private com.genexus.util.GXFile AV160zipFile ;
   private com.genexus.util.GXDirectory AV95folder ;
   private web.SdtZip AV159Zip ;
   private String[] aP6 ;
   private String[] aP5 ;
   private IDataStoreProvider pr_default ;
   private int[] P01Q32_A1649LSDSec ;
   private short[] P01Q32_A1EmpCod ;
   private int[] P01Q32_A3CliCod ;
   private java.util.Date[] P01Q32_A1734LSD1LiqPeriodo ;
   private int[] P01Q32_A1733LSD1LiqNro ;
   private long[] P01Q32_A1650LSD1CuitEmpl_3_11 ;
   private String[] P01Q32_A1651LSD1IdentificacionEnvio_14_2 ;
   private int[] P01Q32_A1652LSD1periodoLiquidacion_16_6 ;
   private String[] P01Q32_A1653LSD1tipoLiquidacion_22_1 ;
   private int[] P01Q32_A1654LSD1numeroLiquidacion_23_5 ;
   private byte[] P01Q32_A1655LSD1diasBase_28_2 ;
   private int[] P01Q32_A1656LSD1cantidadRegistrosTipo04_30 ;
   private int[] P01Q33_A3CliCod ;
   private short[] P01Q33_A1EmpCod ;
   private int[] P01Q33_A1649LSDSec ;
   private int[] P01Q33_A1657LSD2Sec ;
   private long[] P01Q33_A1658LSD2cuilEmpleado_3_11 ;
   private String[] P01Q33_A1659LSD2legajoEmpleado_14_10 ;
   private String[] P01Q33_A1660LSD2dependenciaRevista_24_50 ;
   private String[] P01Q33_A1661LSD2cbuEmpleado_74_22 ;
   private short[] P01Q33_A1662LSD2diasLiquidados_96_3 ;
   private java.util.Date[] P01Q33_A1663LSD2fechaPago_99_8 ;
   private java.util.Date[] P01Q33_A1664LSD2fechaRubrica_107_8 ;
   private String[] P01Q33_A1665LSD2formaPago_115_1 ;
   private int[] P01Q34_A3CliCod ;
   private short[] P01Q34_A1EmpCod ;
   private int[] P01Q34_A1649LSDSec ;
   private int[] P01Q34_A1657LSD2Sec ;
   private long[] P01Q34_A1667LSD3cuilEmpleado_3_11 ;
   private String[] P01Q34_A1668LSD3codigoConcepto_14_10 ;
   private java.math.BigDecimal[] P01Q34_A1669LSD3cantidadConcepto_24_5 ;
   private String[] P01Q34_A1670LSD3unidadesConcepto_29_1 ;
   private java.math.BigDecimal[] P01Q34_A1671LSD3importeConcepto_30_15 ;
   private String[] P01Q34_A1672LSD3debitoCredito_45_1 ;
   private int[] P01Q34_A1673LSD3periodoAjuste_46_6 ;
   private short[] P01Q34_A1666LSD3Sec ;
   private int[] P01Q35_A3CliCod ;
   private short[] P01Q35_A1EmpCod ;
   private int[] P01Q35_A1649LSDSec ;
   private int[] P01Q35_A1657LSD2Sec ;
   private long[] P01Q35_A1675LSD4CUIL_3_11 ;
   private String[] P01Q35_A1676LSD4Conyuge_14_1 ;
   private byte[] P01Q35_A1677LSD4CantidadHijos_15_2 ;
   private String[] P01Q35_A1678LSD4MarcaCCT_17_1 ;
   private String[] P01Q35_A1679LSD4MarcaSCVO_18_1 ;
   private String[] P01Q35_A1680LSD4MarcaReduccion_19_1 ;
   private String[] P01Q35_A1681LSD4TipoEmpresa_20_1 ;
   private String[] P01Q35_A1682LSD4TipoOperacion_21_1 ;
   private String[] P01Q35_A1683LSD4CodigoSituacion_22_2 ;
   private String[] P01Q35_A1684LSD4CodigoCondicion_24_2 ;
   private String[] P01Q35_A1685LSD4CodigoActividad_26_3 ;
   private String[] P01Q35_A1686LSD4CodigoModalidadContratacio ;
   private String[] P01Q35_A1687LSD4CodigoSiniestrado_32_2 ;
   private String[] P01Q35_A1688LSD4CodigoLocalidad_34_2 ;
   private String[] P01Q35_A1689LSD4SituacionRevista1_36_2 ;
   private String[] P01Q35_A1690LSD4DiaInicioSituacionRevista1 ;
   private String[] P01Q35_A1691LSD4SituacionRevista2_40_2 ;
   private String[] P01Q35_A1692LSD4DiaInicioSituacionRevista2 ;
   private String[] P01Q35_A1693LSD4SituacionRevista3_44_2 ;
   private String[] P01Q35_A1694LSD4DiaInicioSituacionRevista3 ;
   private byte[] P01Q35_A1695LSD4CantidadDiasTrabajados_48_ ;
   private short[] P01Q35_A1696LSD4HorasTrabajadas_50_3 ;
   private java.math.BigDecimal[] P01Q35_A1697LSD4PorcentajeAporteAdicionalS ;
   private java.math.BigDecimal[] P01Q35_A1698LSD4ContribucionTareaDiferenci ;
   private String[] P01Q35_A1699LSD4CodigoObraSocial_63_6 ;
   private byte[] P01Q35_A1700LSD4CantidadAdherentes_69_2 ;
   private java.math.BigDecimal[] P01Q35_A1701LSD4AporteAdicionalOS_71_15 ;
   private java.math.BigDecimal[] P01Q35_A1702LSD4ContribucionAdicionalOS_86 ;
   private java.math.BigDecimal[] P01Q35_A1703LSD4BaseCalculoDiferencialApor ;
   private java.math.BigDecimal[] P01Q35_A1704LSD4BaseCalculoDiferencialOSyF ;
   private java.math.BigDecimal[] P01Q35_A1705LSD4BaseCalculoDiferencialLRT_ ;
   private java.math.BigDecimal[] P01Q35_A1706LSD4RemuneracionMaternidadANSe ;
   private java.math.BigDecimal[] P01Q35_A1707LSD4RemuneracionBruta_161_15 ;
   private java.math.BigDecimal[] P01Q35_A1708LSD4BaseImponible1_176_15 ;
   private java.math.BigDecimal[] P01Q35_A1709LSD4BaseImponible2_191_15 ;
   private java.math.BigDecimal[] P01Q35_A1710LSD4BaseImponible3_206_15 ;
   private java.math.BigDecimal[] P01Q35_A1711LSD4BaseImponible4_221_15 ;
   private java.math.BigDecimal[] P01Q35_A1712LSD4BaseImponible5_236_15 ;
   private java.math.BigDecimal[] P01Q35_A1713LSD4BaseImponible6_251_15 ;
   private java.math.BigDecimal[] P01Q35_A1714LSD4BaseImponible7_266_15 ;
   private java.math.BigDecimal[] P01Q35_A1715LSD4BaseImponible8_281_15 ;
   private java.math.BigDecimal[] P01Q35_A1716LSD4BaseImponible9_296_15 ;
   private java.math.BigDecimal[] P01Q35_A1717LSD4BaseDifApoSegSoc_311_15 ;
   private java.math.BigDecimal[] P01Q35_A1718LSD4BaseDifContSegSoc_326_15 ;
   private java.math.BigDecimal[] P01Q35_A1719LSD4BaseImponible10_341_15 ;
   private java.math.BigDecimal[] P01Q35_A1720LSD4ImporteADetraer_356_15 ;
   private short[] P01Q35_A1674LSD4Sec ;
   private com.genexus.util.GXFile AV14Archivo ;
   private GXSimpleCollection<String> AV16archivos ;
   private GXSimpleCollection<String> AV17archivosNombres ;
}

final  class bajalsdaarchivo2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01Q32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV122LSDSec ,
                                          java.util.Date AV118LSD1LiqPeriodo ,
                                          int A1649LSDSec ,
                                          java.util.Date A1734LSD1LiqPeriodo ,
                                          int AV62CliCod ,
                                          short AV85EmpCod ,
                                          int A3CliCod ,
                                          short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int12 = new byte[4];
      Object[] GXv_Object13 = new Object[2];
      scmdbuf = "SELECT LSDSec, EmpCod, CliCod, LSD1LiqPeriodo, LSD1LiqNro, LSD1CuitEmpl_3_11, LSD1IdentificacionEnvio_14_2, LSD1periodoLiquidacion_16_6, LSD1tipoLiquidacion_22_1," ;
      scmdbuf += " LSD1numeroLiquidacion_23_5, LSD1diasBase_28_2, LSD1cantidadRegistrosTipo04_30 FROM LSD_reg1" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV122LSDSec) )
      {
         addWhere(sWhereString, "(LSDSec = ?)");
      }
      else
      {
         GXv_int12[2] = (byte)(1) ;
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV118LSD1LiqPeriodo)) )
      {
         addWhere(sWhereString, "(LSD1LiqPeriodo = ?)");
      }
      else
      {
         GXv_int12[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod" ;
      GXv_Object13[0] = scmdbuf ;
      GXv_Object13[1] = GXv_int12 ;
      return GXv_Object13 ;
   }

   protected Object[] conditional_P01Q33( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          long AV164LSD2cuilEmpleado_3_11 ,
                                          long A1658LSD2cuilEmpleado_3_11 ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A1649LSDSec )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD2cuilEmpleado_3_11, LSD2legajoEmpleado_14_10, LSD2dependenciaRevista_24_50, LSD2cbuEmpleado_74_22, LSD2diasLiquidados_96_3," ;
      scmdbuf += " LSD2fechaPago_99_8, LSD2fechaRubrica_107_8, LSD2formaPago_115_1 FROM LSD_reg2" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LSDSec = ?)");
      if ( ! (0==AV164LSD2cuilEmpleado_3_11) )
      {
         addWhere(sWhereString, "(LSD2cuilEmpleado_3_11 = ?)");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LSDSec" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P01Q32(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (java.util.Date)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , (java.util.Date)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() );
            case 1 :
                  return conditional_P01Q33(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).longValue() , ((Number) dynConstraints[1]).longValue() , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01Q32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01Q33", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01Q34", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD3cuilEmpleado_3_11, LSD3codigoConcepto_14_10, LSD3cantidadConcepto_24_5, LSD3unidadesConcepto_29_1, LSD3importeConcepto_30_15, LSD3debitoCredito_45_1, LSD3periodoAjuste_46_6, LSD3Sec FROM LSD_reg3 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01Q35", "SELECT CliCod, EmpCod, LSDSec, LSD2Sec, LSD4CUIL_3_11, LSD4Conyuge_14_1, LSD4CantidadHijos_15_2, LSD4MarcaCCT_17_1, LSD4MarcaSCVO_18_1, LSD4MarcaReduccion_19_1, LSD4TipoEmpresa_20_1, LSD4TipoOperacion_21_1, LSD4CodigoSituacion_22_2, LSD4CodigoCondicion_24_2, LSD4CodigoActividad_26_3, LSD4CodigoModalidadContratacio, LSD4CodigoSiniestrado_32_2, LSD4CodigoLocalidad_34_2, LSD4SituacionRevista1_36_2, LSD4DiaInicioSituacionRevista1, LSD4SituacionRevista2_40_2, LSD4DiaInicioSituacionRevista2, LSD4SituacionRevista3_44_2, LSD4DiaInicioSituacionRevista3, LSD4CantidadDiasTrabajados_48_, LSD4HorasTrabajadas_50_3, LSD4PorcentajeAporteAdicionalS, LSD4ContribucionTareaDiferenci, LSD4CodigoObraSocial_63_6, LSD4CantidadAdherentes_69_2, LSD4AporteAdicionalOS_71_15, LSD4ContribucionAdicionalOS_86, LSD4BaseCalculoDiferencialApor, LSD4BaseCalculoDiferencialOSyF, LSD4BaseCalculoDiferencialLRT_, LSD4RemuneracionMaternidadANSe, LSD4RemuneracionBruta_161_15, LSD4BaseImponible1_176_15, LSD4BaseImponible2_191_15, LSD4BaseImponible3_206_15, LSD4BaseImponible4_221_15, LSD4BaseImponible5_236_15, LSD4BaseImponible6_251_15, LSD4BaseImponible7_266_15, LSD4BaseImponible8_281_15, LSD4BaseImponible9_296_15, LSD4BaseDifApoSegSoc_311_15, LSD4BaseDifContSegSoc_326_15, LSD4BaseImponible10_341_15, LSD4ImporteADetraer_356_15, LSD4Sec FROM LSD_reg4 WHERE CliCod = ? and EmpCod = ? and LSDSec = ? and LSD2Sec = ? ORDER BY CliCod, EmpCod, LSDSec, LSD2Sec ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((long[]) buf[5])[0] = rslt.getLong(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((byte[]) buf[10])[0] = rslt.getByte(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getString(7, 50);
               ((String[]) buf[7])[0] = rslt.getString(8, 22);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(11);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((short[]) buf[11])[0] = rslt.getShort(12);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((long[]) buf[4])[0] = rslt.getLong(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 1);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((String[]) buf[7])[0] = rslt.getString(8, 1);
               ((String[]) buf[8])[0] = rslt.getString(9, 1);
               ((String[]) buf[9])[0] = rslt.getString(10, 1);
               ((String[]) buf[10])[0] = rslt.getString(11, 1);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               ((String[]) buf[12])[0] = rslt.getString(13, 2);
               ((String[]) buf[13])[0] = rslt.getString(14, 2);
               ((String[]) buf[14])[0] = rslt.getString(15, 3);
               ((String[]) buf[15])[0] = rslt.getString(16, 3);
               ((String[]) buf[16])[0] = rslt.getString(17, 2);
               ((String[]) buf[17])[0] = rslt.getString(18, 2);
               ((String[]) buf[18])[0] = rslt.getString(19, 2);
               ((String[]) buf[19])[0] = rslt.getString(20, 2);
               ((String[]) buf[20])[0] = rslt.getString(21, 2);
               ((String[]) buf[21])[0] = rslt.getString(22, 2);
               ((String[]) buf[22])[0] = rslt.getString(23, 2);
               ((String[]) buf[23])[0] = rslt.getString(24, 2);
               ((byte[]) buf[24])[0] = rslt.getByte(25);
               ((short[]) buf[25])[0] = rslt.getShort(26);
               ((java.math.BigDecimal[]) buf[26])[0] = rslt.getBigDecimal(27,2);
               ((java.math.BigDecimal[]) buf[27])[0] = rslt.getBigDecimal(28,2);
               ((String[]) buf[28])[0] = rslt.getString(29, 6);
               ((byte[]) buf[29])[0] = rslt.getByte(30);
               ((java.math.BigDecimal[]) buf[30])[0] = rslt.getBigDecimal(31,2);
               ((java.math.BigDecimal[]) buf[31])[0] = rslt.getBigDecimal(32,2);
               ((java.math.BigDecimal[]) buf[32])[0] = rslt.getBigDecimal(33,2);
               ((java.math.BigDecimal[]) buf[33])[0] = rslt.getBigDecimal(34,2);
               ((java.math.BigDecimal[]) buf[34])[0] = rslt.getBigDecimal(35,2);
               ((java.math.BigDecimal[]) buf[35])[0] = rslt.getBigDecimal(36,2);
               ((java.math.BigDecimal[]) buf[36])[0] = rslt.getBigDecimal(37,2);
               ((java.math.BigDecimal[]) buf[37])[0] = rslt.getBigDecimal(38,2);
               ((java.math.BigDecimal[]) buf[38])[0] = rslt.getBigDecimal(39,2);
               ((java.math.BigDecimal[]) buf[39])[0] = rslt.getBigDecimal(40,2);
               ((java.math.BigDecimal[]) buf[40])[0] = rslt.getBigDecimal(41,2);
               ((java.math.BigDecimal[]) buf[41])[0] = rslt.getBigDecimal(42,2);
               ((java.math.BigDecimal[]) buf[42])[0] = rslt.getBigDecimal(43,2);
               ((java.math.BigDecimal[]) buf[43])[0] = rslt.getBigDecimal(44,2);
               ((java.math.BigDecimal[]) buf[44])[0] = rslt.getBigDecimal(45,2);
               ((java.math.BigDecimal[]) buf[45])[0] = rslt.getBigDecimal(46,2);
               ((java.math.BigDecimal[]) buf[46])[0] = rslt.getBigDecimal(47,2);
               ((java.math.BigDecimal[]) buf[47])[0] = rslt.getBigDecimal(48,2);
               ((java.math.BigDecimal[]) buf[48])[0] = rslt.getBigDecimal(49,2);
               ((java.math.BigDecimal[]) buf[49])[0] = rslt.getBigDecimal(50,2);
               ((short[]) buf[50])[0] = rslt.getShort(51);
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
                  stmt.setDate(sIdx, (java.util.Date)parms[7]);
               }
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setLong(sIdx, ((Number) parms[7]).longValue());
               }
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
               return;
      }
   }

}

