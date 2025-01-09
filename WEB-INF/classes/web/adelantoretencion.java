package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class adelantoretencion extends GXProcedure
{
   public adelantoretencion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( adelantoretencion.class ), "" );
   }

   public adelantoretencion( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 )
   {
      adelantoretencion.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        String[] aP9 ,
                        byte[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             String[] aP9 ,
                             byte[] aP10 ,
                             String[] aP11 )
   {
      adelantoretencion.this.AV8CliCod = aP0;
      adelantoretencion.this.AV12EmpCod = aP1;
      adelantoretencion.this.AV15LiqNro = aP2;
      adelantoretencion.this.AV86LiqRelNro = aP3;
      adelantoretencion.this.AV14LegNumero = aP4;
      adelantoretencion.this.AV11LiqPeriodo = aP5;
      adelantoretencion.this.AV72ProcesoLiquidacion = aP6;
      adelantoretencion.this.AV73insertandoConceptos = aP7;
      adelantoretencion.this.aP8 = aP8;
      adelantoretencion.this.aP9 = aP9;
      adelantoretencion.this.aP10 = aP10;
      adelantoretencion.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV17LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV83auxConCodigo ;
      GXt_char2 = AV83auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      adelantoretencion.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      adelantoretencion.this.GXt_char1 = GXv_char4[0] ;
      AV83auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = DecimalUtil.doubleToDec(AV18alcanzaGanancias) ;
      GXv_boolean6[0] = AV85existe ;
      GXv_int7[0] = AV84auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV83auxConCodigo, AV72ProcesoLiquidacion, AV73insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      adelantoretencion.this.AV18alcanzaGanancias = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
      adelantoretencion.this.AV85existe = GXv_boolean6[0] ;
      adelantoretencion.this.AV84auxLiqDCalculado = GXv_int7[0] ;
      if ( ( AV84auxLiqDCalculado == 0 ) && ( AV85existe ) )
      {
         AV17LiqDCalculado = (byte)(0) ;
         AV56error = httpContext.getMessage( "Falta calcular si alcanza ganancias", "") ;
         AV58LiqDLog = GXutil.trim( AV56error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV18alcanzaGanancias > 0 )
      {
         AV58LiqDLog = httpContext.getMessage( "No liquida adelanto de retención porque la liquidación ya se encuentra alcanzada por ganancias", "") ;
      }
      else
      {
         GXv_boolean6[0] = AV19LegAgenReten ;
         new web.getlegagenreten(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, GXv_boolean6) ;
         adelantoretencion.this.AV19LegAgenReten = GXv_boolean6[0] ;
         if ( AV19LegAgenReten )
         {
            GXv_char4[0] = AV77OpeCliValor ;
            GXv_char3[0] = AV88auxLiqDLog ;
            GXv_char8[0] = AV87auxError ;
            new web.getmnisegunestadocivilehijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, AV11LiqPeriodo, AV72ProcesoLiquidacion, true, GXv_char4, GXv_char3, GXv_char8) ;
            adelantoretencion.this.AV77OpeCliValor = GXv_char4[0] ;
            adelantoretencion.this.AV88auxLiqDLog = GXv_char3[0] ;
            adelantoretencion.this.AV87auxError = GXv_char8[0] ;
            if ( ! (GXutil.strcmp("", AV87auxError)==0) )
            {
               AV17LiqDCalculado = (byte)(0) ;
               AV56error = GXutil.trim( AV87auxError) ;
               AV58LiqDLog = GXutil.trim( AV56error) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV58LiqDLog += ". " + GXutil.trim( AV88auxLiqDLog) ;
            AV76pisoGananciasImportes = CommonUtil.decimalVal( AV77OpeCliValor, ".") ;
            GXv_char8[0] = AV92tipo_tarifa ;
            new web.gettipodetarifa(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, (short)(0), "", "", GXv_char8) ;
            adelantoretencion.this.AV92tipo_tarifa = GXv_char8[0] ;
            if ( GXutil.strcmp(AV92tipo_tarifa, "H") == 0 )
            {
               GXv_char8[0] = AV56error ;
               GXv_decimal5[0] = AV29valorHora ;
               new web.obtbasicovalorhora(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV11LiqPeriodo, httpContext.getMessage( "TOTAL", ""), GXv_char8, GXv_decimal5) ;
               adelantoretencion.this.AV56error = GXv_char8[0] ;
               adelantoretencion.this.AV29valorHora = GXv_decimal5[0] ;
               GXv_decimal5[0] = AV79horasSemana ;
               new web.gethorassemananormalporlegajo(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, GXv_decimal5) ;
               adelantoretencion.this.AV79horasSemana = GXv_decimal5[0] ;
               AV75brutoEstimaImportes = AV29valorHora.multiply(AV79horasSemana).multiply(DecimalUtil.doubleToDec(4)) ;
            }
            else
            {
               GXv_char8[0] = "" ;
               GXv_decimal5[0] = AV75brutoEstimaImportes ;
               GXv_char4[0] = AV89LegSuelTipo ;
               GXv_char3[0] = "" ;
               new web.obtsueldobasicomensual(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, AV15LiqNro, AV11LiqPeriodo, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char8, GXv_decimal5, GXv_char4, GXv_char3) ;
               adelantoretencion.this.AV75brutoEstimaImportes = GXv_decimal5[0] ;
               adelantoretencion.this.AV89LegSuelTipo = GXv_char4[0] ;
            }
            if ( DecimalUtil.compareTo(AV75brutoEstimaImportes, AV76pisoGananciasImportes) >= 0 )
            {
               GXt_char2 = AV60retencionGananciaConCodigo ;
               GXt_char1 = AV60retencionGananciaConCodigo ;
               GXv_char8[0] = GXt_char1 ;
               new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char8) ;
               adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
               GXv_char4[0] = GXt_char2 ;
               new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
               adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
               AV60retencionGananciaConCodigo = GXt_char2 ;
               GXv_decimal5[0] = AV61retGanLiqDImpCalcu ;
               GXv_boolean6[0] = AV85existe ;
               GXv_int7[0] = AV62retGanLiqDCalculado ;
               new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV60retencionGananciaConCodigo, AV72ProcesoLiquidacion, AV73insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
               adelantoretencion.this.AV61retGanLiqDImpCalcu = GXv_decimal5[0] ;
               adelantoretencion.this.AV85existe = GXv_boolean6[0] ;
               adelantoretencion.this.AV62retGanLiqDCalculado = GXv_int7[0] ;
               if ( ( AV62retGanLiqDCalculado == 0 ) && ( AV85existe ) )
               {
                  AV17LiqDCalculado = (byte)(0) ;
                  AV56error = httpContext.getMessage( "Falta calcular concepto \"Retención ganancias\"", "") ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               if ( AV61retGanLiqDImpCalcu.doubleValue() != 0 )
               {
               }
               else
               {
                  AV13collection_LegNumero.add((int)(AV14LegNumero), 0);
                  GXv_char8[0] = AV24TLiqCod ;
                  new web.gettipoliq(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, GXv_char8) ;
                  adelantoretencion.this.AV24TLiqCod = GXv_char8[0] ;
                  GXt_char2 = AV25adelantoVacacionesTLiqCod ;
                  GXt_char1 = AV25adelantoVacacionesTLiqCod ;
                  GXv_char8[0] = GXt_char1 ;
                  new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                  adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                  GXv_char4[0] = GXt_char2 ;
                  new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                  adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                  AV25adelantoVacacionesTLiqCod = GXt_char2 ;
                  if ( GXutil.strcmp(AV24TLiqCod, AV25adelantoVacacionesTLiqCod) == 0 )
                  {
                     AV26AdelantoTipo = (byte)(1) ;
                  }
                  else
                  {
                     GXt_char2 = AV27quincenaTLiqCod ;
                     GXt_char1 = AV27quincenaTLiqCod ;
                     GXv_char8[0] = GXt_char1 ;
                     new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                     adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                     adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                     AV27quincenaTLiqCod = GXt_char2 ;
                     if ( GXutil.strcmp(AV24TLiqCod, AV27quincenaTLiqCod) == 0 )
                     {
                        AV26AdelantoTipo = (byte)(2) ;
                     }
                     else
                     {
                        GXt_char2 = AV66sacTLiqCod ;
                        GXt_char1 = AV66sacTLiqCod ;
                        GXv_char8[0] = GXt_char1 ;
                        new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                        adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                        GXv_char4[0] = GXt_char2 ;
                        new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                        adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                        AV66sacTLiqCod = GXt_char2 ;
                        if ( GXutil.strcmp(AV24TLiqCod, AV66sacTLiqCod) == 0 )
                        {
                           AV26AdelantoTipo = (byte)(3) ;
                        }
                        else
                        {
                           AV17LiqDCalculado = (byte)(0) ;
                           AV56error = httpContext.getMessage( "Adelanto de vacaciones solo puede liquidarse para quincena, mes, o aguinaldo", "") ;
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                     }
                  }
                  if ( ! (0==AV26AdelantoTipo) )
                  {
                     GXv_char8[0] = AV56error ;
                     GXv_decimal5[0] = AV38basico ;
                     GXv_char4[0] = AV89LegSuelTipo ;
                     GXv_char3[0] = "" ;
                     new web.obtsueldobasicomensual(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, AV15LiqNro, AV11LiqPeriodo, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char8, GXv_decimal5, GXv_char4, GXv_char3) ;
                     adelantoretencion.this.AV56error = GXv_char8[0] ;
                     adelantoretencion.this.AV38basico = GXv_decimal5[0] ;
                     adelantoretencion.this.AV89LegSuelTipo = GXv_char4[0] ;
                     if ( ! (GXutil.strcmp("", AV56error)==0) )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     GXt_char2 = AV64anticipoDeSacConCodigo ;
                     GXt_char1 = AV64anticipoDeSacConCodigo ;
                     GXv_char8[0] = GXt_char1 ;
                     new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                     adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                     adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                     AV64anticipoDeSacConCodigo = GXt_char2 ;
                     GXv_decimal5[0] = AV37AnticipoDeSac ;
                     GXv_boolean6[0] = AV85existe ;
                     GXv_int7[0] = AV65anticipoSacLiqDCalculado ;
                     new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV64anticipoDeSacConCodigo, AV72ProcesoLiquidacion, AV73insertandoConceptos, GXv_decimal5, GXv_boolean6, GXv_int7) ;
                     adelantoretencion.this.AV37AnticipoDeSac = GXv_decimal5[0] ;
                     adelantoretencion.this.AV85existe = GXv_boolean6[0] ;
                     adelantoretencion.this.AV65anticipoSacLiqDCalculado = GXv_int7[0] ;
                     if ( ( AV65anticipoSacLiqDCalculado == 0 ) && ( AV85existe ) )
                     {
                        AV17LiqDCalculado = (byte)(0) ;
                        AV56error = httpContext.getMessage( "Falta calcular anticipo de SAC", "") ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     if ( AV26AdelantoTipo == 2 )
                     {
                        GXt_char2 = AV48BasicoConCodigo ;
                        GXt_char1 = AV48BasicoConCodigo ;
                        GXv_char8[0] = GXt_char1 ;
                        new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                        adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                        GXv_char4[0] = GXt_char2 ;
                        new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                        adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                        AV48BasicoConCodigo = GXt_char2 ;
                        if ( ! (GXutil.strcmp("", AV56error)==0) )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        GXt_char2 = AV51mesTLiqCod ;
                        GXt_char1 = AV51mesTLiqCod ;
                        GXv_char8[0] = GXt_char1 ;
                        new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                        adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                        GXv_char4[0] = GXt_char2 ;
                        new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                        adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                        AV51mesTLiqCod = GXt_char2 ;
                        GXv_date9[0] = AV46AgeFecDes ;
                        GXv_date10[0] = AV47AgeFecHas ;
                        new web.getrangoperiodos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV51mesTLiqCod, (byte)(2), AV11LiqPeriodo, false, GXv_date9, GXv_date10) ;
                        adelantoretencion.this.AV46AgeFecDes = GXv_date9[0] ;
                        adelantoretencion.this.AV47AgeFecHas = GXv_date10[0] ;
                        GXv_decimal5[0] = DecimalUtil.doubleToDec(AV30horasSegundaQuincena) ;
                        GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_boolean6[0] = false ;
                        new web.getagendavalor(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV11LiqPeriodo, AV47AgeFecHas, AV46AgeFecDes, AV48BasicoConCodigo, false, GXv_decimal5, GXv_decimal11, GXv_decimal12, GXv_boolean6) ;
                        adelantoretencion.this.AV30horasSegundaQuincena = (short)(DecimalUtil.decToDouble(GXv_decimal5[0])) ;
                        if ( (0==AV30horasSegundaQuincena) )
                        {
                           GXv_decimal12[0] = DecimalUtil.doubleToDec(AV30horasSegundaQuincena) ;
                           new web.horasdefaultquincena(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV14LegNumero, AV11LiqPeriodo, (short)(2), GXv_decimal12) ;
                           adelantoretencion.this.AV30horasSegundaQuincena = (short)(DecimalUtil.decToDouble(GXv_decimal12[0])) ;
                        }
                        else
                        {
                        }
                        AV28remuBrutaEstimada = DecimalUtil.doubleToDec(AV30horasSegundaQuincena).multiply(AV29valorHora) ;
                        AV45cantidadEstimada = AV30horasSegundaQuincena ;
                        AV58LiqDLog += httpContext.getMessage( "Se estima remuneración ", "") + GXutil.trim( GXutil.str( AV28remuBrutaEstimada, 14, 2)) + httpContext.getMessage( " para la segunda quincena, producto de las ", "") + GXutil.trim( GXutil.str( AV30horasSegundaQuincena, 4, 0)) + httpContext.getMessage( " horas estimadas para la segunda quincena, multiplicadas por el valor hora ", "") + GXutil.trim( GXutil.str( AV29valorHora, 14, 2)) ;
                        GXv_date10[0] = AV46AgeFecDes ;
                        GXv_date9[0] = AV47AgeFecHas ;
                        new web.getrangoperiodos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV27quincenaTLiqCod, (byte)(2), AV11LiqPeriodo, false, GXv_date10, GXv_date9) ;
                        adelantoretencion.this.AV46AgeFecDes = GXv_date10[0] ;
                        adelantoretencion.this.AV47AgeFecHas = GXv_date9[0] ;
                        GXv_decimal12[0] = DecimalUtil.doubleToDec(AV44cantidadActual) ;
                        GXv_decimal11[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_boolean6[0] = false ;
                        new web.getagendavalor(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV11LiqPeriodo, AV47AgeFecHas, AV46AgeFecDes, AV48BasicoConCodigo, false, GXv_decimal12, GXv_decimal11, GXv_decimal5, GXv_boolean6) ;
                        adelantoretencion.this.AV44cantidadActual = (int)(DecimalUtil.decToDouble(GXv_decimal12[0])) ;
                     }
                     else if ( AV26AdelantoTipo == 1 )
                     {
                        AV31diasTrabajadosMesPalabra = "[dias_trabajados_mes]" ;
                        GXv_int13[0] = AV32diasATrabajar ;
                        GXv_int7[0] = (byte)(0) ;
                        GXv_char8[0] = AV56error ;
                        GXv_char4[0] = "" ;
                        new web.obtvalformuladtmydts(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV86LiqRelNro, AV14LegNumero, AV31diasTrabajadosMesPalabra, AV11LiqPeriodo, false, false, false, AV72ProcesoLiquidacion, AV73insertandoConceptos, GXv_int13, GXv_int7, GXv_char8, GXv_char4) ;
                        adelantoretencion.this.AV32diasATrabajar = (short)((short)(GXv_int13[0])) ;
                        adelantoretencion.this.AV56error = GXv_char8[0] ;
                        if ( ! (GXutil.strcmp("", AV56error)==0) )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        GXv_char8[0] = AV56error ;
                        GXv_decimal12[0] = AV33valorDia ;
                        new web.valordia(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, AV14LegNumero, AV11LiqPeriodo, false, GXv_char8, GXv_decimal12) ;
                        adelantoretencion.this.AV56error = GXv_char8[0] ;
                        adelantoretencion.this.AV33valorDia = GXv_decimal12[0] ;
                        if ( ! (GXutil.strcmp("", AV56error)==0) )
                        {
                           returnInSub = true;
                           cleanup();
                           if (true) return;
                        }
                        AV28remuBrutaEstimada = DecimalUtil.doubleToDec(AV32diasATrabajar).multiply(AV33valorDia) ;
                        AV45cantidadEstimada = AV32diasATrabajar ;
                        GXv_int14[0] = (short)(AV44cantidadActual) ;
                        GXv_date10[0] = AV57date ;
                        GXv_date9[0] = AV57date ;
                        new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV15LiqNro, "", AV14LegNumero, AV11LiqPeriodo, false, false, httpContext.getMessage( "TODOS", ""), true, false, GXv_int14, GXv_date10, GXv_date9) ;
                        adelantoretencion.this.AV44cantidadActual = GXv_int14[0] ;
                        adelantoretencion.this.AV57date = GXv_date10[0] ;
                        adelantoretencion.this.AV57date = GXv_date9[0] ;
                     }
                     AV41OpeCliId = "[base_imp_max]" ;
                     GXv_char8[0] = AV77OpeCliValor ;
                     GXv_char4[0] = AV87auxError ;
                     new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV41OpeCliId, AV11LiqPeriodo, AV72ProcesoLiquidacion, GXv_char8, GXv_char4) ;
                     adelantoretencion.this.AV77OpeCliValor = GXv_char8[0] ;
                     adelantoretencion.this.AV87auxError = GXv_char4[0] ;
                     AV40maximoImponible = CommonUtil.decimalVal( AV77OpeCliValor, ".") ;
                     if ( ! (GXutil.strcmp("", AV87auxError)==0) )
                     {
                        AV17LiqDCalculado = (byte)(0) ;
                        AV56error = GXutil.trim( AV87auxError) ;
                        AV58LiqDLog = GXutil.trim( AV56error) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     if ( ( AV45cantidadEstimada + AV44cantidadActual ) > 0 )
                     {
                        AV35proporcion = DecimalUtil.doubleToDec(AV44cantidadActual/ (double) ((AV45cantidadEstimada+AV44cantidadActual))) ;
                        AV40maximoImponible = AV40maximoImponible.multiply(AV35proporcion) ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV95Pgmname, httpContext.getMessage( "maximoimponible ", "")+GXutil.trim( GXutil.str( AV40maximoImponible, 14, 2))+httpContext.getMessage( " proporcion ", "")+GXutil.trim( GXutil.str( AV35proporcion, 14, 2))+httpContext.getMessage( " cant estimada ", "")+GXutil.trim( GXutil.str( AV45cantidadEstimada, 4, 0))+httpContext.getMessage( " &cant actual ", "")+GXutil.trim( GXutil.str( AV44cantidadActual, 8, 0))) ;
                     AV43remuBrutaEstimadaConAnticipoDeSac = AV28remuBrutaEstimada ;
                     if ( ( GXutil.month( AV11LiqPeriodo) != 12 ) && ( GXutil.month( AV11LiqPeriodo) != 6 ) )
                     {
                        AV43remuBrutaEstimadaConAnticipoDeSac = AV43remuBrutaEstimadaConAnticipoDeSac.add(AV37AnticipoDeSac) ;
                     }
                     GXv_decimal12[0] = AV42descuentoDeBruto ;
                     GXv_char8[0] = "" ;
                     new web.descuentosobreimponible(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV11LiqPeriodo, AV14LegNumero, true, DecimalUtil.doubleToDec(0), AV43remuBrutaEstimadaConAnticipoDeSac, AV40maximoImponible, AV37AnticipoDeSac, DecimalUtil.stringToDec("0.17"), "", GXv_decimal12, GXv_char8) ;
                     adelantoretencion.this.AV42descuentoDeBruto = GXv_decimal12[0] ;
                     AV36remuBrutaEstimadaConDescuento = AV43remuBrutaEstimadaConAnticipoDeSac.subtract(AV42descuentoDeBruto) ;
                     GXv_decimal12[0] = AV21F1357LCDeterminado ;
                     GXv_decimal11[0] = AV22F1357LCRetenido ;
                     GXv_int7[0] = AV63f1357LiqDCalculado ;
                     GXv_decimal5[0] = AV34remBrutaLiqActual ;
                     GXv_char8[0] = AV70f1357LiqDLog ;
                     new web.f1357(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV13collection_LegNumero.toJSonString(false), AV11LiqPeriodo, (byte)(3), true, AV15LiqNro, AV26AdelantoTipo, AV36remuBrutaEstimadaConDescuento, AV28remuBrutaEstimada, AV72ProcesoLiquidacion, GXv_decimal12, GXv_decimal11, GXv_int7, GXv_decimal5, GXv_char8) ;
                     adelantoretencion.this.AV21F1357LCDeterminado = GXv_decimal12[0] ;
                     adelantoretencion.this.AV22F1357LCRetenido = GXv_decimal11[0] ;
                     adelantoretencion.this.AV63f1357LiqDCalculado = GXv_int7[0] ;
                     adelantoretencion.this.AV34remBrutaLiqActual = GXv_decimal5[0] ;
                     adelantoretencion.this.AV70f1357LiqDLog = GXv_char8[0] ;
                     if ( AV63f1357LiqDCalculado == 0 )
                     {
                        AV17LiqDCalculado = (byte)(0) ;
                        AV56error = httpContext.getMessage( "No se pudo calcular IIGG", "") ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV10LiqDImpCalcu = AV21F1357LCDeterminado.subtract(AV22F1357LCRetenido) ;
                     if ( AV10LiqDImpCalcu.doubleValue() < 0 )
                     {
                        AV58LiqDLog = httpContext.getMessage( "Se inicializa valor en cero por ser el impuesto retenido ", "") + GXutil.trim( GXutil.str( AV22F1357LCRetenido, 16, 2)) + httpContext.getMessage( " mayor que el determinado ", "") + GXutil.trim( GXutil.str( AV21F1357LCDeterminado, 16, 2)) ;
                        AV10LiqDImpCalcu = DecimalUtil.doubleToDec(0) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV58LiqDLog += httpContext.getMessage( ". Se inicializa el valor de IIGG estimado para el periodo en ", "") + GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " resultado de la diferencia del impuesto determinado ", "") + GXutil.trim( GXutil.str( AV21F1357LCDeterminado, 16, 2)) + httpContext.getMessage( " menos el retenido ", "") + GXutil.trim( GXutil.str( AV22F1357LCRetenido, 16, 2)) ;
                     AV59remTotalEstimadaImportes = AV28remuBrutaEstimada.add(AV34remBrutaLiqActual) ;
                     AV35proporcion = AV34remBrutaLiqActual.divide(AV59remTotalEstimadaImportes, 18, java.math.RoundingMode.DOWN) ;
                     AV58LiqDLog += httpContext.getMessage( ". La remuneración bruta de la liquidación actual es ", "") + GXutil.trim( GXutil.str( AV34remBrutaLiqActual, 14, 2)) ;
                     AV58LiqDLog += httpContext.getMessage( ". Se multiplica el ", "") + GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2)) + httpContext.getMessage( " por ", "") + GXutil.trim( GXutil.str( AV35proporcion, 14, 2)) + httpContext.getMessage( " que se calcula como la remuneración bruta actual divida la remuneración total estimada para el periodo ", "") + GXutil.trim( GXutil.str( AV59remTotalEstimadaImportes, 14, 2)) ;
                     AV10LiqDImpCalcu = AV10LiqDImpCalcu.multiply(AV35proporcion) ;
                     AV58LiqDLog += httpContext.getMessage( ", quedando en ", "") + GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2)) ;
                     GXt_char2 = AV50redondeoStr ;
                     GXt_char1 = AV50redondeoStr ;
                     GXv_char8[0] = GXt_char1 ;
                     new web.defaultredondeoestimacion_codigoparam(remoteHandle, context).execute( GXv_char8) ;
                     adelantoretencion.this.GXt_char1 = GXv_char8[0] ;
                     GXv_char4[0] = GXt_char2 ;
                     new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char4) ;
                     adelantoretencion.this.GXt_char2 = GXv_char4[0] ;
                     AV50redondeoStr = GXt_char2 ;
                     AV49redondeo = CommonUtil.decimalVal( AV50redondeoStr, ".") ;
                     if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV49redondeo)==0) )
                     {
                        AV49redondeo = DecimalUtil.doubleToDec(1) ;
                     }
                     AV10LiqDImpCalcu = AV10LiqDImpCalcu.divide(AV49redondeo, 18, java.math.RoundingMode.DOWN) ;
                     AV10LiqDImpCalcu = AV10LiqDImpCalcu.subtract(DecimalUtil.stringToDec("0.02")) ;
                     AV10LiqDImpCalcu = GXutil.roundDecimal( AV10LiqDImpCalcu, 0) ;
                     AV10LiqDImpCalcu = AV10LiqDImpCalcu.multiply(AV49redondeo) ;
                     if ( AV49redondeo.doubleValue() != 1 )
                     {
                        AV58LiqDLog += httpContext.getMessage( ". Se redondea a ", "") + GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2)) ;
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV95Pgmname, httpContext.getMessage( " &basico ", "")+GXutil.trim( GXutil.str( AV38basico, 14, 2))+httpContext.getMessage( " &F1357LCDeterminado ", "")+GXutil.trim( GXutil.str( AV21F1357LCDeterminado, 16, 2))+httpContext.getMessage( " &&&LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &F1357LCRetenido ", "")+GXutil.trim( GXutil.str( AV22F1357LCRetenido, 16, 2))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV10LiqDImpCalcu, 14, 2))+httpContext.getMessage( " rembrutaactual ", "")+GXutil.trim( GXutil.str( AV34remBrutaLiqActual, 14, 2))+httpContext.getMessage( " rembrutaestim ", "")+GXutil.trim( GXutil.str( AV28remuBrutaEstimada, 14, 2))+httpContext.getMessage( " proporcion ", "")+GXutil.trim( GXutil.str( AV35proporcion, 14, 2))+httpContext.getMessage( " horassegundaquincena ", "")+GXutil.trim( GXutil.str( AV30horasSegundaQuincena, 4, 0))+httpContext.getMessage( " valor hora ", "")+GXutil.trim( GXutil.str( AV29valorHora, 14, 2))+httpContext.getMessage( " diasatrabajar ", "")+GXutil.trim( GXutil.str( AV32diasATrabajar, 4, 0))+httpContext.getMessage( " !valordia ", "")+GXutil.trim( GXutil.str( AV33valorDia, 14, 2))+httpContext.getMessage( " &remuBrutaEstimadaConDescuento ", "")+GXutil.trim( GXutil.str( AV36remuBrutaEstimadaConDescuento, 14, 2))+httpContext.getMessage( " &AnticipoDeSac ", "")+GXutil.trim( GXutil.str( AV37AnticipoDeSac, 14, 2))+httpContext.getMessage( " &sacConDescuento ", "")+GXutil.trim( GXutil.str( AV39sacConDescuento, 14, 2))+httpContext.getMessage( " &maximoImponible ", "")+GXutil.trim( GXutil.str( AV40maximoImponible, 14, 2))+httpContext.getMessage( " &descuentoDeBruto ", "")+GXutil.trim( GXutil.str( AV42descuentoDeBruto, 14, 2))+httpContext.getMessage( " redondeo ", "")+GXutil.trim( GXutil.str( AV49redondeo, 14, 2))) ;
                  }
               }
            }
            else
            {
               AV58LiqDLog = httpContext.getMessage( "No se realiza adelanto de retención porque la estimación del bruto ", "") + GXutil.trim( GXutil.str( AV75brutoEstimaImportes, 14, 2)) + httpContext.getMessage( " está por debajo del piso de ganancias ", "") + GXutil.trim( GXutil.str( AV76pisoGananciasImportes, 14, 2)) ;
            }
         }
         else
         {
            AV58LiqDLog = httpContext.getMessage( "No se realiza adelanto de retención porque el empleador no actúa como agente de retención", "") ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = adelantoretencion.this.AV10LiqDImpCalcu;
      this.aP9[0] = adelantoretencion.this.AV56error;
      this.aP10[0] = adelantoretencion.this.AV17LiqDCalculado;
      this.aP11[0] = adelantoretencion.this.AV58LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10LiqDImpCalcu = DecimalUtil.ZERO ;
      AV56error = "" ;
      AV58LiqDLog = "" ;
      AV83auxConCodigo = "" ;
      AV77OpeCliValor = "" ;
      AV88auxLiqDLog = "" ;
      AV87auxError = "" ;
      AV76pisoGananciasImportes = DecimalUtil.ZERO ;
      AV92tipo_tarifa = "" ;
      AV29valorHora = DecimalUtil.ZERO ;
      AV79horasSemana = DecimalUtil.ZERO ;
      AV75brutoEstimaImportes = DecimalUtil.ZERO ;
      AV89LegSuelTipo = "" ;
      AV60retencionGananciaConCodigo = "" ;
      AV61retGanLiqDImpCalcu = DecimalUtil.ZERO ;
      AV13collection_LegNumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV24TLiqCod = "" ;
      AV25adelantoVacacionesTLiqCod = "" ;
      AV27quincenaTLiqCod = "" ;
      AV66sacTLiqCod = "" ;
      AV38basico = DecimalUtil.ZERO ;
      GXv_char3 = new String[1] ;
      AV64anticipoDeSacConCodigo = "" ;
      AV37AnticipoDeSac = DecimalUtil.ZERO ;
      AV48BasicoConCodigo = "" ;
      AV51mesTLiqCod = "" ;
      AV46AgeFecDes = GXutil.nullDate() ;
      AV47AgeFecHas = GXutil.nullDate() ;
      AV28remuBrutaEstimada = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      AV31diasTrabajadosMesPalabra = "" ;
      GXv_int13 = new int[1] ;
      AV33valorDia = DecimalUtil.ZERO ;
      GXv_int14 = new short[1] ;
      AV57date = GXutil.nullDate() ;
      GXv_date10 = new java.util.Date[1] ;
      GXv_date9 = new java.util.Date[1] ;
      AV41OpeCliId = "" ;
      AV40maximoImponible = DecimalUtil.ZERO ;
      AV35proporcion = DecimalUtil.ZERO ;
      AV95Pgmname = "" ;
      AV43remuBrutaEstimadaConAnticipoDeSac = DecimalUtil.ZERO ;
      AV42descuentoDeBruto = DecimalUtil.ZERO ;
      AV36remuBrutaEstimadaConDescuento = DecimalUtil.ZERO ;
      AV21F1357LCDeterminado = DecimalUtil.ZERO ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      AV22F1357LCRetenido = DecimalUtil.ZERO ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      GXv_int7 = new byte[1] ;
      AV34remBrutaLiqActual = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV70f1357LiqDLog = "" ;
      AV59remTotalEstimadaImportes = DecimalUtil.ZERO ;
      AV50redondeoStr = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV49redondeo = DecimalUtil.ZERO ;
      AV39sacConDescuento = DecimalUtil.ZERO ;
      AV95Pgmname = "adelantoRetencion" ;
      /* GeneXus formulas. */
      AV95Pgmname = "adelantoRetencion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV17LiqDCalculado ;
   private byte AV84auxLiqDCalculado ;
   private byte AV62retGanLiqDCalculado ;
   private byte AV26AdelantoTipo ;
   private byte AV65anticipoSacLiqDCalculado ;
   private byte AV63f1357LiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV12EmpCod ;
   private short AV18alcanzaGanancias ;
   private short AV30horasSegundaQuincena ;
   private short AV45cantidadEstimada ;
   private short AV32diasATrabajar ;
   private short GXv_int14[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV15LiqNro ;
   private int AV86LiqRelNro ;
   private int AV14LegNumero ;
   private int AV44cantidadActual ;
   private int GXv_int13[] ;
   private java.math.BigDecimal AV10LiqDImpCalcu ;
   private java.math.BigDecimal AV76pisoGananciasImportes ;
   private java.math.BigDecimal AV29valorHora ;
   private java.math.BigDecimal AV79horasSemana ;
   private java.math.BigDecimal AV75brutoEstimaImportes ;
   private java.math.BigDecimal AV61retGanLiqDImpCalcu ;
   private java.math.BigDecimal AV38basico ;
   private java.math.BigDecimal AV37AnticipoDeSac ;
   private java.math.BigDecimal AV28remuBrutaEstimada ;
   private java.math.BigDecimal AV33valorDia ;
   private java.math.BigDecimal AV40maximoImponible ;
   private java.math.BigDecimal AV35proporcion ;
   private java.math.BigDecimal AV43remuBrutaEstimadaConAnticipoDeSac ;
   private java.math.BigDecimal AV42descuentoDeBruto ;
   private java.math.BigDecimal AV36remuBrutaEstimadaConDescuento ;
   private java.math.BigDecimal AV21F1357LCDeterminado ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal AV22F1357LCRetenido ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private java.math.BigDecimal AV34remBrutaLiqActual ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV59remTotalEstimadaImportes ;
   private java.math.BigDecimal AV49redondeo ;
   private java.math.BigDecimal AV39sacConDescuento ;
   private String AV72ProcesoLiquidacion ;
   private String AV83auxConCodigo ;
   private String AV92tipo_tarifa ;
   private String AV89LegSuelTipo ;
   private String AV60retencionGananciaConCodigo ;
   private String AV24TLiqCod ;
   private String AV25adelantoVacacionesTLiqCod ;
   private String AV27quincenaTLiqCod ;
   private String AV66sacTLiqCod ;
   private String GXv_char3[] ;
   private String AV64anticipoDeSacConCodigo ;
   private String AV48BasicoConCodigo ;
   private String AV51mesTLiqCod ;
   private String AV31diasTrabajadosMesPalabra ;
   private String AV41OpeCliId ;
   private String AV95Pgmname ;
   private String AV50redondeoStr ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char8[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11LiqPeriodo ;
   private java.util.Date AV46AgeFecDes ;
   private java.util.Date AV47AgeFecHas ;
   private java.util.Date AV57date ;
   private java.util.Date GXv_date10[] ;
   private java.util.Date GXv_date9[] ;
   private boolean AV73insertandoConceptos ;
   private boolean AV85existe ;
   private boolean returnInSub ;
   private boolean AV19LegAgenReten ;
   private boolean GXv_boolean6[] ;
   private String AV58LiqDLog ;
   private String AV77OpeCliValor ;
   private String AV88auxLiqDLog ;
   private String AV70f1357LiqDLog ;
   private String AV56error ;
   private String AV87auxError ;
   private GXSimpleCollection<Integer> AV13collection_LegNumero ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private String[] aP9 ;
   private byte[] aP10 ;
}

