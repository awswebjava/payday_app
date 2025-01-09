package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class resuelveoperando extends GXProcedure
{
   public resuelveoperando( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( resuelveoperando.class ), "" );
   }

   public resuelveoperando( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              int aP4 ,
                              String aP5 ,
                              int aP6 ,
                              String aP7 ,
                              String aP8 ,
                              String aP9 ,
                              String aP10 ,
                              String aP11 ,
                              boolean aP12 ,
                              boolean aP13 ,
                              web.SdtSDTOperandosFormula[] aP14 ,
                              java.util.Date aP15 ,
                              java.util.Date aP16 ,
                              java.math.BigDecimal aP17 ,
                              java.util.Date aP18 ,
                              boolean[] aP19 ,
                              String[] aP20 ,
                              java.math.BigDecimal[] aP21 ,
                              boolean[] aP22 ,
                              java.math.BigDecimal[] aP23 ,
                              java.math.BigDecimal[] aP24 ,
                              boolean[] aP25 ,
                              String[] aP26 ,
                              java.math.BigDecimal[] aP27 )
   {
      resuelveoperando.this.aP28 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28);
      return aP28[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        int aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        boolean aP12 ,
                        boolean aP13 ,
                        web.SdtSDTOperandosFormula[] aP14 ,
                        java.util.Date aP15 ,
                        java.util.Date aP16 ,
                        java.math.BigDecimal aP17 ,
                        java.util.Date aP18 ,
                        boolean[] aP19 ,
                        String[] aP20 ,
                        java.math.BigDecimal[] aP21 ,
                        boolean[] aP22 ,
                        java.math.BigDecimal[] aP23 ,
                        java.math.BigDecimal[] aP24 ,
                        boolean[] aP25 ,
                        String[] aP26 ,
                        java.math.BigDecimal[] aP27 ,
                        boolean[] aP28 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             boolean aP12 ,
                             boolean aP13 ,
                             web.SdtSDTOperandosFormula[] aP14 ,
                             java.util.Date aP15 ,
                             java.util.Date aP16 ,
                             java.math.BigDecimal aP17 ,
                             java.util.Date aP18 ,
                             boolean[] aP19 ,
                             String[] aP20 ,
                             java.math.BigDecimal[] aP21 ,
                             boolean[] aP22 ,
                             java.math.BigDecimal[] aP23 ,
                             java.math.BigDecimal[] aP24 ,
                             boolean[] aP25 ,
                             String[] aP26 ,
                             java.math.BigDecimal[] aP27 ,
                             boolean[] aP28 )
   {
      resuelveoperando.this.AV24CliCod = aP0;
      resuelveoperando.this.AV53EmpCod = aP1;
      resuelveoperando.this.AV83LiqNro = aP2;
      resuelveoperando.this.AV227LiqRelNro = aP3;
      resuelveoperando.this.AV78LegNumero = aP4;
      resuelveoperando.this.AV128TLiqCod = aP5;
      resuelveoperando.this.AV148ActualLiqNro = aP6;
      resuelveoperando.this.AV29ConCodigo = aP7;
      resuelveoperando.this.AV93Operando = aP8;
      resuelveoperando.this.AV116primeraPalabra = aP9;
      resuelveoperando.this.AV144ProcesoLiquidacion = aP10;
      resuelveoperando.this.AV216llamador = aP11;
      resuelveoperando.this.AV146insertandoConceptos = aP12;
      resuelveoperando.this.AV167simulacionEs = aP13;
      resuelveoperando.this.AV122SDTOperandosItem = aP14[0];
      this.aP14 = aP14;
      resuelveoperando.this.AV84LiqPeriodo = aP15;
      resuelveoperando.this.AV147ActualLiqPeriodo = aP16;
      resuelveoperando.this.AV170LiqDCanti = aP17;
      resuelveoperando.this.AV206DAgeFecDes = aP18;
      resuelveoperando.this.aP19 = aP19;
      resuelveoperando.this.aP20 = aP20;
      resuelveoperando.this.aP21 = aP21;
      resuelveoperando.this.aP22 = aP22;
      resuelveoperando.this.aP23 = aP23;
      resuelveoperando.this.aP24 = aP24;
      resuelveoperando.this.aP25 = aP25;
      resuelveoperando.this.aP26 = aP26;
      resuelveoperando.this.aP27 = aP27;
      resuelveoperando.this.aP28 = aP28;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV215dependenciaConceptoEs = false ;
      AV94OperandoNuevo = "" ;
      AV149OperandoNuevo2 = "" ;
      AV40Descripcion = "" ;
      AV151Nombre = "" ;
      AV38dependenciaResuelta = true ;
      GXt_int1 = AV102PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.empresagetpais(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_int2) ;
      resuelveoperando.this.GXt_int1 = GXv_int2[0] ;
      AV102PaiCod = GXt_int1 ;
      GXv_char3[0] = AV40Descripcion ;
      GXv_char4[0] = AV151Nombre ;
      GXv_boolean5[0] = AV154cantidadEs ;
      GXv_char6[0] = AV94OperandoNuevo ;
      GXv_char7[0] = AV149OperandoNuevo2 ;
      GXv_char8[0] = AV57idOperando ;
      GXv_char9[0] = AV92OpeCliId ;
      GXv_boolean10[0] = AV157doResuelveOperando ;
      GXv_char11[0] = AV158OperandoTipo ;
      GXv_char12[0] = "" ;
      GXv_boolean13[0] = AV204alicuotaEs ;
      GXv_char14[0] = AV54error ;
      new web.clasificaroperando(remoteHandle, context).execute( AV24CliCod, AV78LegNumero, AV29ConCodigo, AV93Operando, AV116primeraPalabra, AV84LiqPeriodo, false, GXv_char3, GXv_char4, GXv_boolean5, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_boolean10, GXv_char11, GXv_char12, GXv_boolean13, GXv_char14) ;
      resuelveoperando.this.AV40Descripcion = GXv_char3[0] ;
      resuelveoperando.this.AV151Nombre = GXv_char4[0] ;
      resuelveoperando.this.AV154cantidadEs = GXv_boolean5[0] ;
      resuelveoperando.this.AV94OperandoNuevo = GXv_char6[0] ;
      resuelveoperando.this.AV149OperandoNuevo2 = GXv_char7[0] ;
      resuelveoperando.this.AV57idOperando = GXv_char8[0] ;
      resuelveoperando.this.AV92OpeCliId = GXv_char9[0] ;
      resuelveoperando.this.AV157doResuelveOperando = GXv_boolean10[0] ;
      resuelveoperando.this.AV158OperandoTipo = GXv_char11[0] ;
      resuelveoperando.this.AV204alicuotaEs = GXv_boolean13[0] ;
      resuelveoperando.this.AV54error = GXv_char14[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "alicuotaes ", "")+GXutil.trim( GXutil.booltostr( AV204alicuotaEs))+httpContext.getMessage( "&Operando ", "")+AV93Operando+httpContext.getMessage( " &primeraPalabra ", "")+AV116primeraPalabra+httpContext.getMessage( " &doResuelveOperando ", "")+GXutil.booltostr( AV157doResuelveOperando)+httpContext.getMessage( " &idOperando ", "")+AV57idOperando) ;
      if ( AV157doResuelveOperando )
      {
         /* Execute user subroutine: 'RESUELVE OPERANDO' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( AV154cantidadEs )
      {
         AV152ConOpeEsCant = CommonUtil.decimalVal( AV94OperandoNuevo, ".") ;
         if ( AV204alicuotaEs )
         {
            AV152ConOpeEsCant = AV152ConOpeEsCant.multiply(DecimalUtil.doubleToDec(100)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "por 100 &ConOpeEsCant ", "")+GXutil.trim( GXutil.str( AV152ConOpeEsCant, 14, 2))) ;
         }
      }
      if ( AV38dependenciaResuelta )
      {
         if ( AV154cantidadEs && (DecimalUtil.compareTo(DecimalUtil.ZERO, AV152ConOpeEsCant)==0) )
         {
            AV152ConOpeEsCant = CommonUtil.decimalVal( AV94OperandoNuevo, ".") ;
         }
         AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( AV94OperandoNuevo );
         AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( AV149OperandoNuevo2 );
         if ( GXutil.strcmp(AV29ConCodigo, httpContext.getMessage( "CAL043", "")) == 0 )
         {
         }
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, GXutil.trim( AV29ConCodigo)+httpContext.getMessage( " no resuelve ", "")+AV122SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal()) ;
         if ( ! (0==AV78LegNumero) )
         {
         }
         else
         {
            AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado( "1" );
            AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Operandocambiado2( "1" );
         }
      }
      AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Descripcion( GXutil.trim( AV40Descripcion) );
      AV122SDTOperandosItem.setgxTv_SdtSDTOperandosFormula_Nombre( GXutil.trim( AV151Nombre) );
      new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV54error)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'RESUELVE OPERANDO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "&primeraPalabra \"", "")+AV116primeraPalabra+httpContext.getMessage( "\" &&valorGenMismoConcepto \"", "")+AV136valorGenMismoConcepto+httpContext.getMessage( "\" operando ", "")+AV93Operando+httpContext.getMessage( " &idOperando ", "")+AV57idOperando+httpContext.getMessage( " opecliid ", "")+GXutil.trim( AV92OpeCliId)+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV78LegNumero, 8, 0))) ;
      if ( ! (0==AV78LegNumero) )
      {
         if ( GXutil.strcmp(AV57idOperando, "{redondeo}") == 0 )
         {
            GXv_decimal15[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.redondeo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV29ConCodigo, AV144ProcesoLiquidacion, DecimalUtil.doubleToDec(0), GXv_decimal15, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal15[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.str( AV58Importe, 14, 2) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{fondo_cese}") == 0 )
         {
            GXv_decimal15[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            new web.fondo_cese(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal15, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal15[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.str( AV58Importe, 14, 2) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "{sac}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{sac_proporcional}") == 0 ) )
         {
            AV169palabra = AV57idOperando ;
            GXv_decimal15[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_decimal17[0] = AV161cantidadCalculada ;
            new web.sac(remoteHandle, context).execute( AV169palabra, AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal15, GXv_char14, GXv_int16, GXv_char12, GXv_decimal17) ;
            resuelveoperando.this.AV58Importe = GXv_decimal15[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[antiguedad_importe]") == 0 )
         {
            GXv_char14[0] = AV241tipo_tarifa ;
            new web.gettipodetarifa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, (short)(0), "", "", GXv_char14) ;
            resuelveoperando.this.AV241tipo_tarifa = GXv_char14[0] ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            new web.antiguedad_importe(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV241tipo_tarifa, AV29ConCodigo, AV144ProcesoLiquidacion, AV216llamador, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16, GXv_int2) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[presentismo_importe]") == 0 )
         {
            GXv_char14[0] = AV241tipo_tarifa ;
            new web.gettipodetarifa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, (short)(0), "", "", GXv_char14) ;
            resuelveoperando.this.AV241tipo_tarifa = GXv_char14[0] ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.presentismo_importe2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV241tipo_tarifa, AV29ConCodigo, AV144ProcesoLiquidacion, AV216llamador, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[beneficio_guarderia]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.beneficio_guarderia(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.str( AV58Importe, 14, 2) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[reintegro_guarderia]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.reintegro_guarderia(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.str( AV58Importe, 14, 2) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[proporcion_antiguedad_motivo]") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "!operandos.proporcionMotivoAntiguedad", "")) ;
            GXv_boolean13[0] = false ;
            GXv_decimal17[0] = AV114porUnaje ;
            new web.conceptoaplicamotegr(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV29ConCodigo, GXv_boolean13, GXv_decimal17) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[indemnizacion_antiguedad]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.indemnizacion_antiguedad(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV84LiqPeriodo, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = GXutil.rtrim( localUtil.format( AV94OperandoNuevo, "")) ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dia_fecha_egreso]") == 0 )
         {
            GXv_char14[0] = "" ;
            GXv_date18[0] = AV200LegFecEgreso ;
            new web.empleadogetegreso(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14, GXv_date18) ;
            resuelveoperando.this.AV200LegFecEgreso = GXv_date18[0] ;
            AV94OperandoNuevo = GXutil.str( GXutil.day( AV200LegFecEgreso), 10, 0) ;
            AV149OperandoNuevo2 = GXutil.rtrim( localUtil.format( AV94OperandoNuevo, "")) ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[ultimo_dia_mes]") == 0 )
         {
            AV94OperandoNuevo = GXutil.trim( GXutil.str( GXutil.day( GXutil.eomdate( AV84LiqPeriodo)), 10, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[ultimo_dia_mes_egreso]") == 0 )
         {
            GXv_char14[0] = "" ;
            GXv_date18[0] = AV200LegFecEgreso ;
            new web.empleadogetegreso(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14, GXv_date18) ;
            resuelveoperando.this.AV200LegFecEgreso = GXv_date18[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( GXutil.day( GXutil.eomdate( AV200LegFecEgreso)), 10, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[hora_normal]") == 0 )
         {
            GXv_int16[0] = AV76LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16) ;
            resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
            GXv_char14[0] = AV241tipo_tarifa ;
            new web.gettipodetarifa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, (short)(0), "", "", GXv_char14) ;
            resuelveoperando.this.AV241tipo_tarifa = GXv_char14[0] ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.hora_normal4(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV102PaiCod, AV78LegNumero, AV84LiqPeriodo, AV76LegClase, AV241tipo_tarifa, AV170LiqDCanti, AV144ProcesoLiquidacion, AV216llamador, AV128TLiqCod, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[plus_vacacional]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{plus_licencia}") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[plus_vacacional]") == 0 )
            {
               AV207vacacionesEs = true ;
            }
            else
            {
               AV207vacacionesEs = false ;
            }
            GXv_decimal17[0] = AV58Importe ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.plus_vacacional(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV207vacacionesEs, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_int2, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[liquidar_sac]") == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "operandos.liquidar_sac &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV84LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " mes ", "")+localUtil.cmonth( AV84LiqPeriodo, httpContext.getLanguage( ))+httpContext.getMessage( " nro ", "")+GXutil.trim( GXutil.str( GXutil.month( AV84LiqPeriodo), 10, 0))) ;
            GXv_int16[0] = (byte)(AV145numero) ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.liquidar_sac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV128TLiqCod, AV84LiqPeriodo, GXv_int16, GXv_char14) ;
            resuelveoperando.this.AV145numero = GXv_int16[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV145numero, 4, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV145numero), "ZZZ9") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[extra]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[recargo]") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[extra]") == 0 )
            {
               AV194extraORecPalabra = httpContext.getMessage( "extra", "") ;
            }
            else
            {
               AV194extraORecPalabra = httpContext.getMessage( "recargo", "") ;
            }
            GXv_char14[0] = AV141buscaPalabra ;
            GXv_char12[0] = AV164busca2Palabra ;
            GXv_char11[0] = AV193busca3Palabra ;
            GXv_char9[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV93Operando, GXv_char14, GXv_char12, GXv_char11, GXv_char9) ;
            resuelveoperando.this.AV141buscaPalabra = GXv_char14[0] ;
            resuelveoperando.this.AV164busca2Palabra = GXv_char12[0] ;
            resuelveoperando.this.AV193busca3Palabra = GXv_char11[0] ;
            GXv_decimal17[0] = AV114porUnaje ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = "" ;
            GXv_char11[0] = AV54error ;
            new web.extra(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV102PaiCod, AV141buscaPalabra, AV164busca2Palabra, GXutil.trim( AV193busca3Palabra), AV194extraORecPalabra, GXv_decimal17, GXv_char14, GXv_char12, GXv_char11) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char11[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
            AV188LiqDPlus = AV114porUnaje ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[obligacion]") == 0 )
         {
            GXv_char14[0] = AV141buscaPalabra ;
            GXv_char12[0] = "" ;
            GXv_char11[0] = "" ;
            GXv_char9[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV93Operando, GXv_char14, GXv_char12, GXv_char11, GXv_char9) ;
            resuelveoperando.this.AV141buscaPalabra = GXv_char14[0] ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.descuento_obligacion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV141buscaPalabra, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{leg_prop_adi}") == 0 )
         {
            GXv_char14[0] = AV141buscaPalabra ;
            GXv_char12[0] = "" ;
            GXv_char11[0] = "" ;
            GXv_char9[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV93Operando, GXv_char14, GXv_char12, GXv_char11, GXv_char9) ;
            resuelveoperando.this.AV141buscaPalabra = GXv_char14[0] ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.descuento_obligacion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV141buscaPalabra, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            GXv_boolean13[0] = AV233valorBoolean ;
            GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char14[0] = "" ;
            GXv_date18[0] = AV234nadaFecha ;
            new web.getvalorpropadi(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV141buscaPalabra, GXv_boolean13, GXv_decimal17, GXv_char14, GXv_date18) ;
            resuelveoperando.this.AV233valorBoolean = GXv_boolean13[0] ;
            resuelveoperando.this.AV234nadaFecha = GXv_date18[0] ;
            if ( AV233valorBoolean )
            {
               AV58Importe = DecimalUtil.doubleToDec(1) ;
            }
            else
            {
               AV58Importe = DecimalUtil.doubleToDec(0) ;
            }
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{ded_art_30}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.deducciones_art_30(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{gan_neta_topes}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.ganancia_neta_tope(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{sueldo_bruto_menos_ley}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.sueldo_bruto_menos_ley(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{gan_neta}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.ganancia_neta(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{importe_iigg}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.importe_a_retener(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{sueldo_bruto_ganancias}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.sueldo_bruto_ganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{gnsi_sin_dei}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.gnsi_sin_dei(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{calculo_iigg_neto}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.calculo_retencion_ganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{alcanza_ganancias}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.alcanza_ganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV84LiqPeriodo, AV78LegNumero, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{gnsi}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.gnsi(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{ded_gen_men}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.deducciones_generales_mensuales(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV128TLiqCod, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{ded_gen_anu}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.deducciones_generales_anuales(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV128TLiqCod, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{rem_gravada_gan}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.remuneracion_gravada(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[contr_FSR_ali]") == 0 )
         {
            GXv_decimal17[0] = AV114porUnaje ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.getporcentajeobrasocialcont(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, httpContext.getMessage( "FSR", ""), GXv_decimal17, GXv_char14, GXv_int16) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[contr_OS_ali]") == 0 )
         {
            GXv_decimal17[0] = AV114porUnaje ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.getporcentajeobrasocialcont(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, httpContext.getMessage( "OS", ""), GXv_decimal17, GXv_char14, GXv_int16) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[asistencia_perfecta]") == 0 )
         {
            GXv_int2[0] = AV145numero ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.asistencia_perfecta(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, GXv_int2, GXv_char14) ;
            resuelveoperando.this.AV145numero = GXv_int2[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV145numero, 4, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV145numero), "ZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[empresa_antiguedad]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            new web.getantiguedadporempresa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_decimal17) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[empresa_presentismo]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            new web.getpresentismoporempresa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_decimal17) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[retencion_ganancias]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.retencion_ganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{devolucion_ganancias}") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.devolucion_ganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[total_exentos_sin_sac]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.total_exentos_sin_sac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV29ConCodigo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_char14, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[calculo_iigg]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.calculoiigg(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[sac_estimado]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.calculo_sac_proximo_estimado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[deduccion]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[exento_concepto]") == 0 ) )
         {
            AV179LiqDImpCalcu = DecimalUtil.doubleToDec(0) ;
            if ( GXutil.strcmp(AV57idOperando, "[deduccion]") == 0 )
            {
               AV180principalConCodigo = AV29ConCodigo ;
            }
            else
            {
               GXt_char19 = AV180principalConCodigo ;
               GXv_char14[0] = GXt_char19 ;
               new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
               resuelveoperando.this.GXt_char19 = GXv_char14[0] ;
               AV180principalConCodigo = GXt_char19 ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "&idOperando ", "")+GXutil.trim( AV57idOperando)+httpContext.getMessage( " &principalConCodigo ", "")+GXutil.trim( AV180principalConCodigo)+httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV144ProcesoLiquidacion)) ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_decimal15[0] = DecimalUtil.doubleToDec(0) ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_boolean13[0] = false ;
            new web.concepto_exento_v2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV180principalConCodigo, AV29ConCodigo, (short)(0), AV144ProcesoLiquidacion, AV146insertandoConceptos, AV57idOperando, AV179LiqDImpCalcu, GXv_decimal17, GXv_decimal15, GXv_char14, GXv_int16, GXv_char12, GXv_boolean13) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[es_primera_quincena]") == 0 )
         {
            GXv_int16[0] = AV76LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16) ;
            resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
            GXv_int16[0] = (byte)(AV19Cantidad) ;
            new web.esprimeraquincena(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV76LegClase, GXv_int16) ;
            resuelveoperando.this.AV19Cantidad = GXv_int16[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[anticipo_sac]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.anticipo_de_sac_v2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[haberes_sac]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            new web.haberes_sac2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[remuneracion_descuento]") == 0 )
         {
            GXv_int16[0] = AV76LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16) ;
            resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
            GXv_char14[0] = AV232CondicionLiquidacion ;
            GXv_char12[0] = "" ;
            new web.getconceptocondicion(remoteHandle, context).execute( AV24CliCod, AV29ConCodigo, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV232CondicionLiquidacion = GXv_char14[0] ;
            if ( ( GXutil.strcmp(AV232CondicionLiquidacion, "AI") != 0 ) && ( GXutil.strcmp(AV232CondicionLiquidacion, "MI") != 0 ) )
            {
               AV232CondicionLiquidacion = "B7" ;
            }
            GXv_decimal17[0] = AV58Importe ;
            GXv_decimal15[0] = AV161cantidadCalculada ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.remuneracion_sin_goce(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV232CondicionLiquidacion, "[remuneracion_descuento]", DecimalUtil.doubleToDec(0), AV84LiqPeriodo, AV84LiqPeriodo, AV128TLiqCod, AV76LegClase, AV144ProcesoLiquidacion, AV216llamador, AV146insertandoConceptos, false, GXv_decimal17, GXv_decimal15, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal15[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[sueldo_basico]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{sueldo}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{sueldo_adicional}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{egreso_descuento}") == 0 ) )
         {
            AV190cambiarSigno = false ;
            AV210auxLiqDCanti = AV170LiqDCanti ;
            if ( GXutil.strcmp(AV57idOperando, "[sueldo_basico]") == 0 )
            {
               AV163quePalabra = httpContext.getMessage( "BASICO", "") ;
               AV165restarLicencias = false ;
               AV156restarFeriados = false ;
            }
            else
            {
               if ( GXutil.strcmp(AV57idOperando, "{sueldo_adicional}") == 0 )
               {
                  AV163quePalabra = httpContext.getMessage( "ADICIONAL", "") ;
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV210auxLiqDCanti)==0) )
                  {
                     GXt_char19 = AV211horasNormalesConCodigo ;
                     GXt_char20 = AV211horasNormalesConCodigo ;
                     GXv_char14[0] = GXt_char20 ;
                     new web.concepto_sueldojornal_codigoparam(remoteHandle, context).execute( GXv_char14) ;
                     resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
                     GXv_char12[0] = GXt_char19 ;
                     new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char20, GXv_char12) ;
                     resuelveoperando.this.GXt_char19 = GXv_char12[0] ;
                     AV211horasNormalesConCodigo = GXt_char19 ;
                     GXv_decimal17[0] = AV210auxLiqDCanti ;
                     GXv_boolean13[0] = false ;
                     GXv_int16[0] = (byte)(0) ;
                     new web.getliqdcantidad(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV211horasNormalesConCodigo, GXv_decimal17, GXv_boolean13, GXv_int16) ;
                     resuelveoperando.this.AV210auxLiqDCanti = GXv_decimal17[0] ;
                  }
               }
               else
               {
                  GXt_char20 = AV213ParmValue ;
                  GXt_char19 = AV213ParmValue ;
                  GXv_char14[0] = GXt_char19 ;
                  new web.desglosaradicional_codigoparam(remoteHandle, context).execute( GXv_char14) ;
                  resuelveoperando.this.GXt_char19 = GXv_char14[0] ;
                  GXv_char12[0] = GXt_char20 ;
                  new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char19, GXv_char12) ;
                  resuelveoperando.this.GXt_char20 = GXv_char12[0] ;
                  AV213ParmValue = GXt_char20 ;
                  AV212desglosa = GXutil.boolval( AV213ParmValue) ;
                  if ( AV212desglosa )
                  {
                     AV163quePalabra = httpContext.getMessage( "BASICO", "") ;
                  }
                  else
                  {
                     AV163quePalabra = httpContext.getMessage( "TOTAL", "") ;
                  }
               }
               AV165restarLicencias = true ;
               AV156restarFeriados = true ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, GXutil.trim( AV57idOperando)+httpContext.getMessage( " &auxLiqDCanti ", "")+GXutil.trim( GXutil.str( AV210auxLiqDCanti, 14, 2))) ;
            GXv_decimal17[0] = AV58Importe ;
            GXv_decimal15[0] = AV171baseImportes ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.sueldo_basico(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV83LiqNro, AV227LiqRelNro, AV84LiqPeriodo, DecimalUtil.doubleToDec(0), AV29ConCodigo, AV128TLiqCod, AV163quePalabra, AV165restarLicencias, AV156restarFeriados, AV210auxLiqDCanti, false, AV144ProcesoLiquidacion, AV146insertandoConceptos, AV190cambiarSigno, AV167simulacionEs, GXv_decimal17, GXv_decimal15, GXv_int2, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV171baseImportes = GXv_decimal15[0] ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[adelanto_retencion]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.adelantoretencion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[tope_indemnizatorio]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = "" ;
            new web.tope_indemnizatorio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, GXv_decimal17, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[os_apo_adic]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            new web.aporteadicionalos(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_decimal17) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[horas_mes]") == 0 )
         {
            GXv_decimal17[0] = DecimalUtil.doubleToDec(AV19Cantidad) ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            new web.horasmes(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, GXv_decimal17, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV19Cantidad = (int)(DecimalUtil.decToDouble(GXv_decimal17[0])) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[horas_jornal]") == 0 )
         {
            GXv_decimal17[0] = AV192PaiDiaHoras ;
            new web.gethorasdianormal(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_decimal17) ;
            resuelveoperando.this.AV192PaiDiaHoras = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV192PaiDiaHoras, 3, 1)) ;
            AV149OperandoNuevo2 = localUtil.format( AV192PaiDiaHoras, "9.9") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[mni_zona]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[ded_hijo_zona]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[ded_hijo_incap_zona]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[ded_cony_zona]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[ded_especial_zona]") == 0 ) )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, AV57idOperando, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[prorrateables]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.prorrateables(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[cuotas_prorrateo]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.devuelveimportecuota(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV84LiqPeriodo, AV78LegNumero, true, AV128TLiqCod, GXv_decimal17, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[os_cantidad_adherentes]") == 0 )
         {
            GXv_int2[0] = (short)(AV19Cantidad) ;
            new web.cantidaddeadherentes(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int2) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[obra_social_adherentes]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal15[0] = AV161cantidadCalculada ;
            new web.obra_social_adherentes(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16, GXv_decimal15) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal15[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[f1357_saldo]") == 0 )
         {
            GXv_decimal17[0] = AV58Importe ;
            new web.saldof1357(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, GXv_decimal17) ;
            resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[agente_retencion]") == 0 )
         {
            GXv_char14[0] = AV94OperandoNuevo ;
            new web.getlegajoagente(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.AV94OperandoNuevo = GXv_char14[0] ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[gan_cuotas]") == 0 )
         {
            GXv_int2[0] = AV17cant ;
            new web.getgancuotas(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, GXv_int2) ;
            resuelveoperando.this.AV17cant = GXv_int2[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV17cant, 4, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[jubilacion]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[obra_social]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[ley_19032]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[cuota_sindical]") == 0 ) )
         {
            GXv_char14[0] = AV197baseConCodigo ;
            GXv_char12[0] = AV199auxOpeCliId ;
            GXv_boolean13[0] = AV205cuotaSindicalEs ;
            new web.getdesculeydatos(remoteHandle, context).execute( AV24CliCod, AV57idOperando, GXv_char14, GXv_char12, GXv_boolean13) ;
            resuelveoperando.this.AV197baseConCodigo = GXv_char14[0] ;
            resuelveoperando.this.AV199auxOpeCliId = GXv_char12[0] ;
            resuelveoperando.this.AV205cuotaSindicalEs = GXv_boolean13[0] ;
            GXv_int16[0] = AV76LegClase ;
            GXv_char14[0] = AV240LegModTra ;
            new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16, GXv_char14) ;
            resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
            resuelveoperando.this.AV240LegModTra = GXv_char14[0] ;
            GXv_decimal17[0] = AV236base_imp_min ;
            GXv_decimal15[0] = AV237base_imp_max ;
            GXv_char14[0] = AV54error ;
            new web.getbaseimpmaxymin(remoteHandle, context).execute( AV24CliCod, AV84LiqPeriodo, AV144ProcesoLiquidacion, false, GXv_decimal17, GXv_decimal15, GXv_char14) ;
            resuelveoperando.this.AV236base_imp_min = GXv_decimal17[0] ;
            resuelveoperando.this.AV237base_imp_max = GXv_decimal15[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            if ( ! (GXutil.strcmp("", AV54error)==0) )
            {
               AV38dependenciaResuelta = false ;
            }
            else
            {
               GXv_int2[0] = AV235cantDiasMes ;
               new web.diasmes(remoteHandle, context).execute( AV24CliCod, AV84LiqPeriodo, GXv_int2) ;
               resuelveoperando.this.AV235cantDiasMes = (byte)((byte)(GXv_int2[0])) ;
               GXv_decimal17[0] = AV58Importe ;
               GXv_decimal15[0] = AV171baseImportes ;
               GXv_char14[0] = AV54error ;
               GXv_char12[0] = AV173LiqDLog ;
               GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
               GXv_decimal21[0] = AV161cantidadCalculada ;
               new web.descuento_de_ley(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV76LegClase, AV240LegModTra, "", AV29ConCodigo, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, AV197baseConCodigo, AV199auxOpeCliId, AV205cuotaSindicalEs, DecimalUtil.doubleToDec(0), (short)(0), (short)(0), AV237base_imp_max, AV236base_imp_min, AV235cantDiasMes, GXv_decimal17, GXv_decimal15, GXv_char14, GXv_char12, GXv_int16, GXv_decimal21) ;
               resuelveoperando.this.AV58Importe = GXv_decimal17[0] ;
               resuelveoperando.this.AV171baseImportes = GXv_decimal15[0] ;
               resuelveoperando.this.AV54error = GXv_char14[0] ;
               resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
               resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
               resuelveoperando.this.AV161cantidadCalculada = GXv_decimal21[0] ;
               AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
               AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
            }
         }
         else if ( GXutil.strcmp(AV57idOperando, "[adicional_convenio]") == 0 )
         {
            GXv_char14[0] = AV141buscaPalabra ;
            GXv_char12[0] = AV164busca2Palabra ;
            GXv_char11[0] = "" ;
            GXv_char9[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV93Operando, GXv_char14, GXv_char12, GXv_char11, GXv_char9) ;
            resuelveoperando.this.AV141buscaPalabra = GXv_char14[0] ;
            resuelveoperando.this.AV164busca2Palabra = GXv_char12[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "adicional &&buscaPalabra ", "")+AV141buscaPalabra+httpContext.getMessage( " &busca2Palabra ", "")+AV164busca2Palabra) ;
            GXv_decimal21[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.conveniogetadicional2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, AV141buscaPalabra, AV164busca2Palabra, AV144ProcesoLiquidacion, GXv_decimal21, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{grossing_up}") == 0 )
         {
            GXv_decimal21[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.grossing_up(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV83LiqNro, AV128TLiqCod, AV144ProcesoLiquidacion, AV84LiqPeriodo, GXv_decimal21, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[valor_categoria]") == 0 )
         {
            GXv_char14[0] = AV141buscaPalabra ;
            GXv_char12[0] = AV164busca2Palabra ;
            GXv_char11[0] = "" ;
            GXv_char9[0] = "" ;
            new web.legoperandogetvalores(remoteHandle, context).execute( AV93Operando, GXv_char14, GXv_char12, GXv_char11, GXv_char9) ;
            resuelveoperando.this.AV141buscaPalabra = GXv_char14[0] ;
            resuelveoperando.this.AV164busca2Palabra = GXv_char12[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "categoria sueldo  &&buscaPalabra ", "")+AV141buscaPalabra+httpContext.getMessage( " &busca2Palabra ", "")+AV164busca2Palabra) ;
            if ( (0==AV78LegNumero) )
            {
               GXv_int22[0] = AV202CliConveVer ;
               new web.getversiondeconvenio(remoteHandle, context).execute( AV24CliCod, AV102PaiCod, GXutil.trim( AV141buscaPalabra), GXv_int22) ;
               resuelveoperando.this.AV202CliConveVer = GXv_int22[0] ;
            }
            else
            {
               GXv_int22[0] = AV202CliConveVer ;
               new web.getversiondelegajo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int22) ;
               resuelveoperando.this.AV202CliConveVer = GXv_int22[0] ;
            }
            GXv_int2[0] = AV244CliPaiConve ;
            new web.getpaisdeconvenio(remoteHandle, context).execute( GXutil.trim( AV141buscaPalabra), AV102PaiCod, GXv_int2) ;
            resuelveoperando.this.AV244CliPaiConve = GXv_int2[0] ;
            GXv_boolean13[0] = false ;
            GXv_char14[0] = AV54error ;
            GXv_decimal21[0] = AV58Importe ;
            new web.getescalasalarialvigente3(remoteHandle, context).execute( AV202CliConveVer, AV244CliPaiConve, GXutil.trim( AV141buscaPalabra), GXutil.trim( AV164busca2Palabra), AV84LiqPeriodo, (byte)(1), httpContext.getMessage( "TOTAL", ""), GXv_boolean13, GXv_char14, GXv_decimal21) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            AV173LiqDLog = AV54error ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[ART_ali]") == 0 )
         {
            GXv_decimal21[0] = AV114porUnaje ;
            new web.empresagetpctart(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_decimal21) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal21[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[ART_fijo]") == 0 )
         {
            GXv_decimal21[0] = AV58Importe ;
            new web.empresaget_art_fijo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV84LiqPeriodo, GXv_decimal21) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[basico_mensual]") == 0 )
         {
            GXv_char14[0] = AV54error ;
            GXv_decimal21[0] = AV58Importe ;
            GXv_char12[0] = AV238LegSuelTipo ;
            GXv_char11[0] = AV173LiqDLog ;
            new web.obtsueldobasicomensual(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV83LiqNro, AV84LiqPeriodo, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char14, GXv_decimal21, GXv_char12, GXv_char11) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV238LegSuelTipo = GXv_char12[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char11[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "BasicoMensual devuelve error ", "")+GXutil.trim( AV54error)) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[hora_basica]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{hora_completa}") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[hora_basica]") == 0 )
            {
               AV163quePalabra = httpContext.getMessage( "BASICO", "") ;
            }
            else
            {
               AV163quePalabra = httpContext.getMessage( "TOTAL", "") ;
            }
            GXv_char14[0] = "" ;
            GXv_decimal21[0] = AV58Importe ;
            new web.obtbasicovalorhora(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV163quePalabra, GXv_char14, GXv_decimal21) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[monto_siradig]") == 0 )
         {
            GXv_boolean13[0] = false ;
            GXv_decimal21[0] = AV58Importe ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV57idOperando, AV84LiqPeriodo, AV29ConCodigo, false, (byte)(0), "", false, GXv_boolean13, GXv_decimal21) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[deduce_conyuge]") == 0 )
         {
            GXv_char14[0] = AV94OperandoNuevo ;
            new web.deduceconyuge(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.AV94OperandoNuevo = GXv_char14[0] ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[prc_ded_hijos]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[prc_ded_hijos_incap]") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[prc_ded_hijos]") == 0 )
            {
               GXv_decimal21[0] = AV114porUnaje ;
               new web.porcentajededuccionhijos(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, false, AV84LiqPeriodo, GXv_decimal21) ;
               resuelveoperando.this.AV114porUnaje = GXv_decimal21[0] ;
            }
            else
            {
               GXv_decimal21[0] = AV114porUnaje ;
               new web.porcentajededuccionhijos(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, true, AV84LiqPeriodo, GXv_decimal21) ;
               resuelveoperando.this.AV114porUnaje = GXv_decimal21[0] ;
            }
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[cant_hijos]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[cant_hijos_incap]") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[cant_hijos]") == 0 )
            {
               GXv_int2[0] = AV17cant ;
               new web.cantidadhijos(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, false, AV84LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(0), GXv_int2) ;
               resuelveoperando.this.AV17cant = GXv_int2[0] ;
            }
            else
            {
               GXv_int2[0] = AV17cant ;
               new web.cantidadhijos(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, true, AV84LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(0), GXv_int2) ;
               resuelveoperando.this.AV17cant = GXv_int2[0] ;
            }
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV17cant, 4, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "{retroactivo}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{concepto}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[novedad_cantidad]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[novedad_importe]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{retroactivo}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{conceptos}") == 0 ) )
         {
            GXt_char20 = AV133totalPalabra ;
            GXv_char14[0] = GXt_char20 ;
            new web.totalpalabra(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV133totalPalabra = GXt_char20 ;
            GXt_char20 = AV21cantidadPalabra ;
            GXv_char14[0] = GXt_char20 ;
            new web.cantidadpalabra(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV21cantidadPalabra = GXt_char20 ;
            if ( ( GXutil.strcmp(AV57idOperando, "{concepto}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{retroactivo}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{conceptos}") == 0 ) )
            {
               if ( (0==AV83LiqNro) )
               {
                  GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23[0] = AV224cal_par_valores ;
                  GXv_char14[0] = AV54error ;
                  new web.devuelveparametroscc4(remoteHandle, context).execute( AV24CliCod, AV57idOperando, AV93Operando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23, GXv_char14) ;
                  AV224cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23[0] ;
                  resuelveoperando.this.AV54error = GXv_char14[0] ;
               }
               else
               {
                  AV228ConOpeId = AV57idOperando ;
                  GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23[0] = AV224cal_par_valores ;
                  GXv_char14[0] = AV54error ;
                  new web.devuelveparametrosgrabados(remoteHandle, context).execute( AV24CliCod, AV29ConCodigo, AV228ConOpeId, AV93Operando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23, GXv_char14) ;
                  AV224cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23[0] ;
                  resuelveoperando.this.AV54error = GXv_char14[0] ;
               }
               if ( (GXutil.strcmp("", AV54error)==0) )
               {
                  GXv_int22[0] = AV221periodoNum6 ;
                  GXv_char14[0] = AV36CriterioBusqueda ;
                  GXv_char12[0] = AV41Devolver ;
                  GXv_char11[0] = AV220Calculo ;
                  GXv_char9[0] = AV222busquedaTLiqCod ;
                  GXv_boolean13[0] = AV55esLiqAnt ;
                  GXv_char8[0] = AV27ConceptoPar ;
                  GXv_char7[0] = AV223TipoConCod ;
                  GXv_char6[0] = AV225retroCatCodigo ;
                  GXv_decimal21[0] = AV226retroSueldoBasico ;
                  new web.recuperaparametrosdeconcepto(remoteHandle, context).execute( AV24CliCod, AV102PaiCod, AV57idOperando, AV224cal_par_valores, GXv_int22, GXv_char14, GXv_char12, GXv_char11, GXv_char9, GXv_boolean13, GXv_char8, GXv_char7, GXv_char6, GXv_decimal21) ;
                  resuelveoperando.this.AV221periodoNum6 = GXv_int22[0] ;
                  resuelveoperando.this.AV36CriterioBusqueda = GXv_char14[0] ;
                  resuelveoperando.this.AV41Devolver = GXv_char12[0] ;
                  resuelveoperando.this.AV220Calculo = GXv_char11[0] ;
                  resuelveoperando.this.AV222busquedaTLiqCod = GXv_char9[0] ;
                  resuelveoperando.this.AV55esLiqAnt = GXv_boolean13[0] ;
                  resuelveoperando.this.AV27ConceptoPar = GXv_char8[0] ;
                  resuelveoperando.this.AV223TipoConCod = GXv_char7[0] ;
                  resuelveoperando.this.AV225retroCatCodigo = GXv_char6[0] ;
                  resuelveoperando.this.AV226retroSueldoBasico = GXv_decimal21[0] ;
               }
            }
            else
            {
               AV54error = "" ;
               AV55esLiqAnt = false ;
               AV27ConceptoPar = AV29ConCodigo ;
               if ( GXutil.strcmp(AV57idOperando, "[novedad_cantidad]") == 0 )
               {
                  AV41Devolver = AV21cantidadPalabra ;
               }
               else if ( GXutil.strcmp(AV57idOperando, "[novedad_importe]") == 0 )
               {
                  AV41Devolver = AV61importePalabra ;
               }
               GXt_char20 = AV220Calculo ;
               GXv_char14[0] = GXt_char20 ;
               new web.sumapalabra(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
               resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
               AV220Calculo = GXt_char20 ;
               AV36CriterioBusqueda = "" ;
               AV221periodoNum6 = 0 ;
               AV222busquedaTLiqCod = "" ;
               AV223TipoConCod = "" ;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "1 &error ", "")+GXutil.trim( AV54error)+httpContext.getMessage( " &devuelve ", "")+AV41Devolver) ;
            if ( (GXutil.strcmp("", AV54error)==0) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, "2") ;
               if ( ! (0==AV83LiqNro) || ( AV55esLiqAnt ) )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "3 &LiqRelNro ", "")+GXutil.trim( GXutil.str( AV227LiqRelNro, 8, 0))) ;
                  if ( GXutil.strcmp(AV57idOperando, "{retroactivo}") == 0 )
                  {
                     GXv_decimal21[0] = AV59Importe4dec ;
                     GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
                     GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
                     GXv_char14[0] = AV173LiqDLog ;
                     new web.obtvalformulaccoretroactivo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV221periodoNum6, AV83LiqNro, AV78LegNumero, AV29ConCodigo, AV27ConceptoPar, AV223TipoConCod, AV222busquedaTLiqCod, AV146insertandoConceptos, AV21cantidadPalabra, AV61importePalabra, AV139valorUniPalabra, AV137valorGenPalabra, AV133totalPalabra, AV41Devolver, AV144ProcesoLiquidacion, GXv_decimal21, GXv_int16, GXv_int2, GXv_char14) ;
                     resuelveoperando.this.AV59Importe4dec = GXv_decimal21[0] ;
                     resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
                     resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
                     resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "retro &conceptoResuelto ", "")+GXutil.trim( GXutil.booltostr( AV28conceptoResuelto))) ;
                     AV38dependenciaResuelta = AV28conceptoResuelto ;
                  }
                  else
                  {
                     if ( AV55esLiqAnt )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "&periodoNum6 ", "")+GXutil.trim( GXutil.str( AV221periodoNum6, 6, 0))+httpContext.getMessage( " &busquedaTLiqCod ", "")+AV222busquedaTLiqCod) ;
                        GXv_decimal21[0] = AV59Importe4dec ;
                        GXv_boolean13[0] = AV28conceptoResuelto ;
                        GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
                        GXv_char14[0] = AV54error ;
                        GXv_char12[0] = AV173LiqDLog ;
                        new web.obtvalformulacc2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV29ConCodigo, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV78LegNumero, AV27ConceptoPar, AV223TipoConCod, AV128TLiqCod, AV146insertandoConceptos, AV21cantidadPalabra, AV133totalPalabra, AV41Devolver, AV93Operando, AV36CriterioBusqueda, AV220Calculo, AV221periodoNum6, AV222busquedaTLiqCod, GXv_decimal21, GXv_boolean13, GXv_int2, GXv_char14, GXv_char12) ;
                        resuelveoperando.this.AV59Importe4dec = GXv_decimal21[0] ;
                        resuelveoperando.this.AV28conceptoResuelto = GXv_boolean13[0] ;
                        resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
                        resuelveoperando.this.AV54error = GXv_char14[0] ;
                        resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
                        AV38dependenciaResuelta = AV28conceptoResuelto ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "error ", "")+GXutil.trim( AV54error)+httpContext.getMessage( "depen ", "")+GXutil.trim( GXutil.booltostr( AV38dependenciaResuelta))) ;
                     }
                     else
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, "5") ;
                        GXv_decimal21[0] = AV59Importe4dec ;
                        GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
                        GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
                        GXv_char14[0] = AV173LiqDLog ;
                        new web.obtvalformulaccoptimizado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV29ConCodigo, AV27ConceptoPar, AV223TipoConCod, AV146insertandoConceptos, AV21cantidadPalabra, AV61importePalabra, AV139valorUniPalabra, AV137valorGenPalabra, AV133totalPalabra, AV41Devolver, AV144ProcesoLiquidacion, GXv_decimal21, GXv_int16, GXv_int2, GXv_char14) ;
                        resuelveoperando.this.AV59Importe4dec = GXv_decimal21[0] ;
                        resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
                        resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
                        resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "6 &conceptoResuelto ", "")+GXutil.trim( GXutil.booltostr( AV28conceptoResuelto))) ;
                        AV38dependenciaResuelta = AV28conceptoResuelto ;
                     }
                  }
               }
               else
               {
                  AV173LiqDLog = httpContext.getMessage( "busca en agenda ", "") + GXutil.trim( AV27ConceptoPar) ;
                  GXv_decimal21[0] = AV161cantidadCalculada ;
                  GXv_decimal17[0] = DecimalUtil.doubleToDec(0) ;
                  GXv_decimal15[0] = AV59Importe4dec ;
                  GXv_boolean13[0] = AV181existe ;
                  new web.getagendavalor(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, 0, AV78LegNumero, AV84LiqPeriodo, AV84LiqPeriodo, GXutil.eomdate( AV84LiqPeriodo), AV27ConceptoPar, false, GXv_decimal21, GXv_decimal17, GXv_decimal15, GXv_boolean13) ;
                  resuelveoperando.this.AV161cantidadCalculada = GXv_decimal21[0] ;
                  resuelveoperando.this.AV59Importe4dec = GXv_decimal15[0] ;
                  resuelveoperando.this.AV181existe = GXv_boolean13[0] ;
                  AV173LiqDLog += httpContext.getMessage( " &simulacionEs ", "") + GXutil.trim( GXutil.booltostr( AV167simulacionEs)) + httpContext.getMessage( " &Importe4dec ", "") + GXutil.trim( GXutil.str( AV59Importe4dec, 14, 4)) + httpContext.getMessage( " existe ", "") + GXutil.trim( GXutil.booltostr( AV181existe)) ;
                  AV173LiqDLog += httpContext.getMessage( " legnum ", "") + GXutil.trim( GXutil.str( AV78LegNumero, 8, 0)) + httpContext.getMessage( " &liqperiodo ", "") + GXutil.trim( localUtil.dtoc( AV84LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " concod ", "") + GXutil.trim( AV27ConceptoPar) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad ", "")+GXutil.trim( AV173LiqDLog)) ;
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Importe4dec)==0) )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 1", "")) ;
                     if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV161cantidadCalculada)==0) )
                     {
                        AV183AgeCanti = AV161cantidadCalculada ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 2", "")) ;
                     }
                     else
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 3 &LegClase", "")) ;
                        GXv_int16[0] = AV76LegClase ;
                        GXv_char14[0] = AV240LegModTra ;
                        new web.getlegajoclaseymodtra(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16, GXv_char14) ;
                        resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
                        resuelveoperando.this.AV240LegModTra = GXv_char14[0] ;
                        GXv_char14[0] = AV241tipo_tarifa ;
                        new web.gettipodetarifa(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, (short)(0), "", "", GXv_char14) ;
                        resuelveoperando.this.AV241tipo_tarifa = GXv_char14[0] ;
                        if ( GXutil.strcmp(AV241tipo_tarifa, "H") == 0 )
                        {
                           GXv_char14[0] = AV184basicoConCodigo ;
                           new web.getparametro(remoteHandle, context).execute( AV24CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char14) ;
                           resuelveoperando.this.AV184basicoConCodigo = GXv_char14[0] ;
                           new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 4", "")) ;
                           if ( GXutil.strcmp(AV27ConceptoPar, AV184basicoConCodigo) == 0 )
                           {
                              GXv_decimal21[0] = DecimalUtil.doubleToDec(AV185horas_mes) ;
                              GXv_char14[0] = "" ;
                              GXv_char12[0] = "" ;
                              new web.horasmes(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, GXv_decimal21, GXv_char14, GXv_char12) ;
                              resuelveoperando.this.AV185horas_mes = (short)(DecimalUtil.decToDouble(GXv_decimal21[0])) ;
                              AV183AgeCanti = DecimalUtil.doubleToDec(AV185horas_mes/ (double) (2)) ;
                           }
                           else
                           {
                              AV183AgeCanti = DecimalUtil.doubleToDec(1) ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 5", "")) ;
                           }
                        }
                        else
                        {
                           AV183AgeCanti = DecimalUtil.doubleToDec(1) ;
                        }
                     }
                     new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 6", "")) ;
                     if ( ( GXutil.strcmp(AV29ConCodigo, AV27ConceptoPar) != 0 ) && ! (GXutil.strcmp("", AV27ConceptoPar)==0) )
                     {
                        GXv_decimal21[0] = DecimalUtil.doubleToDec(0) ;
                        GXv_char14[0] = "" ;
                        GXv_decimal17[0] = AV239auxImportes ;
                        GXv_char12[0] = AV182importeStr ;
                        new web.previsualizacionnovedad(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV27ConceptoPar, AV183AgeCanti, DecimalUtil.doubleToDec(0), AV84LiqPeriodo, GXutil.eomdate( AV84LiqPeriodo), true, GXv_decimal21, GXv_char14, GXv_decimal17, GXv_char12) ;
                        resuelveoperando.this.AV239auxImportes = GXv_decimal17[0] ;
                        resuelveoperando.this.AV182importeStr = GXv_char12[0] ;
                        AV59Importe4dec = AV239auxImportes ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 7", "")) ;
                        if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV59Importe4dec)==0) )
                        {
                           AV38dependenciaResuelta = false ;
                           AV173LiqDLog += httpContext.getMessage( " previ en cero", "") ;
                           new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 8", "")) ;
                        }
                     }
                     else
                     {
                        AV59Importe4dec = AV183AgeCanti ;
                     }
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, AV173LiqDLog) ;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "novedad 9 &Importe4dec ", "")+GXutil.trim( GXutil.str( AV59Importe4dec, 14, 4))) ;
               AV94OperandoNuevo = GXutil.trim( GXutil.str( AV59Importe4dec, 14, 4)) ;
               AV149OperandoNuevo2 = localUtil.format( AV59Importe4dec, "ZZZ,ZZZ,ZZ9.9999") ;
               GXt_char20 = AV40Descripcion ;
               GXv_char14[0] = GXt_char20 ;
               new web.conceptogetdescri(remoteHandle, context).execute( AV24CliCod, AV27ConceptoPar, GXv_char14) ;
               resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
               AV40Descripcion = GXt_char20 ;
               AV151Nombre = GXutil.trim( AV40Descripcion) ;
            }
            else
            {
               AV38dependenciaResuelta = false ;
            }
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dias_vacaciones]") == 0 )
         {
            GXv_int2[0] = (short)(AV19Cantidad) ;
            GXv_date18[0] = AV175date ;
            GXv_date24[0] = AV175date ;
            new web.getdiaslicenciaperiodo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, "", AV78LegNumero, AV84LiqPeriodo, false, false, httpContext.getMessage( "CUENTAN COMO TRABAJADOS", ""), true, false, GXv_int2, GXv_date18, GXv_date24) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            resuelveoperando.this.AV175date = GXv_date18[0] ;
            resuelveoperando.this.AV175date = GXv_date24[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[feriados_no_trabajados]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[no_laborables]") == 0 ) )
         {
            GXv_int2[0] = AV102PaiCod ;
            new web.empresagetpais(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_int2) ;
            resuelveoperando.this.AV102PaiCod = GXv_int2[0] ;
            GXv_char14[0] = AV35ConveCodigo ;
            new web.empleadogetconvenio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.AV35ConveCodigo = GXv_char14[0] ;
            GXv_int16[0] = AV76LegClase ;
            new web.getlegajoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16) ;
            resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
            if ( GXutil.strcmp(AV57idOperando, "[feriados_no_trabajados]") == 0 )
            {
               GXt_char20 = AV195codigo1_palabra ;
               GXv_char14[0] = GXt_char20 ;
               new web.palabracod1feriadoobligatorio(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
               resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
               AV195codigo1_palabra = GXt_char20 ;
               AV196FerTipo = "" ;
            }
            else
            {
               GXt_char20 = AV195codigo1_palabra ;
               GXv_char14[0] = GXt_char20 ;
               new web.palabracod1nolaborableopcional(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
               resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
               AV195codigo1_palabra = GXt_char20 ;
               AV196FerTipo = "nolaborable" ;
            }
            GXv_decimal21[0] = AV188LiqDPlus ;
            new web.getplusdebasedecalculo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV102PaiCod, AV35ConveCodigo, AV76LegClase, "feriado", AV195codigo1_palabra, httpContext.getMessage( "No trabajado", ""), GXv_decimal21) ;
            resuelveoperando.this.AV188LiqDPlus = GXv_decimal21[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "RemuneracionFeriadoNoTrabajado", "")) ;
            GXv_decimal21[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal17[0] = AV161cantidadCalculada ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.remuneracionferiadonotrabajado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV83LiqNro, AV227LiqRelNro, AV84LiqPeriodo, AV29ConCodigo, AV196FerTipo, AV144ProcesoLiquidacion, AV216llamador, AV146insertandoConceptos, GXv_decimal21, GXv_char14, GXv_int16, GXv_decimal17, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal17[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[descuento_adelanto]") == 0 )
         {
            GXv_decimal21[0] = AV58Importe ;
            GXv_decimal17[0] = AV161cantidadCalculada ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.descuento_adelanto_vacaciones2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV83LiqNro, AV84LiqPeriodo, AV29ConCodigo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal21, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[vacaciones_descuento]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[licencias_descuento]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{feriados_no_trabajados_descuento}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{no_laborables_descuento}") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[vacaciones_descuento]") == 0 )
            {
               AV207vacacionesEs = true ;
               AV208distintoEs = false ;
            }
            else
            {
               AV207vacacionesEs = false ;
               if ( GXutil.strcmp(AV57idOperando, "[licencias_descuento]") == 0 )
               {
                  AV208distintoEs = true ;
               }
               else
               {
                  AV208distintoEs = false ;
               }
            }
            if ( ( GXutil.strcmp(AV57idOperando, "[vacaciones_descuento]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[licencias_descuento]") == 0 ) )
            {
               AV209DConCondicion = "B1" ;
            }
            else
            {
               if ( GXutil.strcmp(AV57idOperando, "{feriados_no_trabajados_descuento}") == 0 )
               {
                  AV209DConCondicion = "B5" ;
               }
               else
               {
                  AV209DConCondicion = "B6" ;
               }
            }
            GXv_decimal21[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            new web.licencias_sin_plus2(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV84LiqPeriodo, AV209DConCondicion, AV144ProcesoLiquidacion, AV216llamador, AV207vacacionesEs, AV208distintoEs, GXv_decimal21, GXv_char14, GXv_char12, GXv_int16, GXv_int2) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[remuneracion_adelanto_vacaciones]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[remuneracion_vacaciones_no_gozadas]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[remuneracion_licencia]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[remuneracion_accidente_ART]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[remuneracion_accidente_empresa]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{vacaciones_no_gozadas_ant}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{feriado_trabajado_horas}") == 0 ) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "&legnumero ", "")+GXutil.trim( GXutil.str( AV78LegNumero, 8, 0))+httpContext.getMessage( " llama a remuneracion licencia ", "")+GXutil.trim( AV57idOperando)) ;
            GXv_decimal21[0] = AV58Importe ;
            GXv_decimal17[0] = AV161cantidadCalculada ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_decimal15[0] = AV188LiqDPlus ;
            GXv_decimal25[0] = DecimalUtil.doubleToDec(0) ;
            new web.remuneracionlicencia5(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV57idOperando, AV29ConCodigo, AV170LiqDCanti, AV206DAgeFecDes, false, AV144ProcesoLiquidacion, AV216llamador, AV146insertandoConceptos, GXv_decimal21, GXv_decimal17, GXv_int16, GXv_char14, GXv_char12, GXv_decimal15, GXv_decimal25) ;
            resuelveoperando.this.AV58Importe = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal17[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV188LiqDPlus = GXv_decimal15[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "&cantidadCalculada ", "")+GXutil.trim( GXutil.str( AV161cantidadCalculada, 14, 2))) ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
            if ( ( GXutil.strcmp(AV57idOperando, "{feriados_trabajados}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{feriado_trabajado_horas}") == 0 ) )
            {
               GXv_int2[0] = AV102PaiCod ;
               new web.empresagetpais(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, GXv_int2) ;
               resuelveoperando.this.AV102PaiCod = GXv_int2[0] ;
               GXv_char14[0] = AV35ConveCodigo ;
               new web.empleadogetconvenio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
               resuelveoperando.this.AV35ConveCodigo = GXv_char14[0] ;
               GXv_int16[0] = AV76LegClase ;
               new web.getlegajoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_int16) ;
               resuelveoperando.this.AV76LegClase = GXv_int16[0] ;
               GXt_char20 = AV195codigo1_palabra ;
               GXv_char14[0] = GXt_char20 ;
               new web.palabracod1feriadoobligatorio(remoteHandle, context).execute( AV24CliCod, GXv_char14) ;
               resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
               AV195codigo1_palabra = GXt_char20 ;
               AV196FerTipo = "" ;
               GXv_decimal25[0] = AV188LiqDPlus ;
               new web.getplusdebasedecalculo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV102PaiCod, AV35ConveCodigo, AV76LegClase, "feriado", AV195codigo1_palabra, httpContext.getMessage( "Trabajado", ""), GXv_decimal25) ;
               resuelveoperando.this.AV188LiqDPlus = GXv_decimal25[0] ;
            }
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[antiguedad]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[antiguedad_indemnizacion]") == 0 ) )
         {
            AV105Param = AV57idOperando ;
            GXv_int2[0] = (short)(AV19Cantidad) ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.antiguedad_anios(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, AV105Param, GXv_int2, GXv_char14) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[descuentos_sobre_gravados]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.descuentosdeleysobregravado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, false, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[dias_mes_egreso]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[dias_mes]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[dias_semestre]") == 0 ) )
         {
            AV169palabra = AV57idOperando ;
            if ( GXutil.strcmp(AV57idOperando, "[dias_mes_egreso]") == 0 )
            {
               GXv_char14[0] = "" ;
               GXv_date24[0] = AV200LegFecEgreso ;
               new web.empleadogetegreso(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14, GXv_date24) ;
               resuelveoperando.this.AV200LegFecEgreso = GXv_date24[0] ;
               AV203auxLiqPeriodo = AV200LegFecEgreso ;
            }
            else
            {
               AV203auxLiqPeriodo = AV84LiqPeriodo ;
            }
            GXv_int22[0] = AV19Cantidad ;
            new web.obtvalformulacdmycds(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV169palabra, AV203auxLiqPeriodo, AV155diasPosta, GXv_int22) ;
            resuelveoperando.this.AV19Cantidad = GXv_int22[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dias_trabajados_mes]") == 0 )
         {
            AV156restarFeriados = true ;
            AV165restarLicencias = true ;
            AV169palabra = AV57idOperando ;
            GXv_int22[0] = AV19Cantidad ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.obtvalformuladtmydts(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV169palabra, AV84LiqPeriodo, AV165restarLicencias, AV156restarFeriados, false, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_int22, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV19Cantidad = GXv_int22[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[cant_cuotas]") == 0 )
         {
            GXv_int2[0] = (short)(AV19Cantidad) ;
            new web.mesesanio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV84LiqPeriodo, GXv_int2) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[calculo_sac]") == 0 )
         {
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal25[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.calculo_sac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_int16, GXv_decimal25, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[nro_cuota]") == 0 )
         {
            GXv_int2[0] = (short)(AV19Cantidad) ;
            new web.mesesganancias(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, GXv_int2) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dias_remunerados_semestre]") == 0 )
         {
            AV169palabra = AV57idOperando ;
            GXv_int22[0] = AV19Cantidad ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.obtvalformuladtmydts(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV169palabra, AV84LiqPeriodo, true, true, true, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_int22, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV19Cantidad = GXv_int22[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[sueldo_bruto]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            new web.obtvalformulabruto(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, "", AV144ProcesoLiquidacion, AV146insertandoConceptos, AV57idOperando, GXv_decimal25, GXv_int16, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[ded_esp_inc]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_char12[0] = AV54error ;
            new web.deduccionespecialincrementada(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), AV144ProcesoLiquidacion, GXv_decimal25, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[importe_a_detraer]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal21[0] = AV171baseImportes ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.importeadetraer(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_decimal21, GXv_int2, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV171baseImportes = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dias_proporcionar_tope]") == 0 )
         {
            GXv_int2[0] = (short)(AV19Cantidad) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.diasproptope_sueldo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, AV216llamador, GXv_int2, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV19Cantidad = GXv_int2[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[dias_proporcionar_sac]") == 0 )
         {
            GXv_decimal25[0] = DecimalUtil.doubleToDec(AV19Cantidad) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.dias_proporcionar_sac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV19Cantidad = (int)(DecimalUtil.decToDouble(GXv_decimal25[0])) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV19Cantidad, 6, 0)) ;
            AV149OperandoNuevo2 = localUtil.format( DecimalUtil.doubleToDec(AV19Cantidad), "ZZZZZ9") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_sac]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal21[0] = AV171baseImportes ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.tope_imponible_sac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_decimal21, GXv_int2, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV171baseImportes = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_adelantoVac]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal21[0] = AV171baseImportes ;
            GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.tope_imponible_adelantovac(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal25, GXv_int16, GXv_decimal21, GXv_int2, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV171baseImportes = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{obra_social_diferencial}") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_decimal21[0] = AV171baseImportes ;
            GXv_decimal17[0] = AV161cantidadCalculada ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            new web.obra_social_diferencial(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_decimal21, GXv_decimal17, GXv_char14, GXv_char12, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV171baseImportes = GXv_decimal21[0] ;
            resuelveoperando.this.AV161cantidadCalculada = GXv_decimal17[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[base_imponible_1]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_2]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_3]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_4]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_5]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_6]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_7]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_8]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_imponible_9]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_dif_apo_OS_FSR]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[base_dif_con_OS_FSR]") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[base_imponible_1]") == 0 )
            {
               AV168baseImponibleNro = (short)(1) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_2]") == 0 )
            {
               AV168baseImponibleNro = (short)(2) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_3]") == 0 )
            {
               AV168baseImponibleNro = (short)(3) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_4]") == 0 )
            {
               AV168baseImponibleNro = (short)(4) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_5]") == 0 )
            {
               AV168baseImponibleNro = (short)(5) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_6]") == 0 )
            {
               AV168baseImponibleNro = (short)(6) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_7]") == 0 )
            {
               AV168baseImponibleNro = (short)(7) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_8]") == 0 )
            {
               AV168baseImponibleNro = (short)(8) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_imponible_9]") == 0 )
            {
               AV168baseImponibleNro = (short)(9) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_dif_apo_OS_FSR]") == 0 )
            {
               AV168baseImponibleNro = (short)(24) ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[base_dif_con_OS_FSR]") == 0 )
            {
               AV168baseImponibleNro = (short)(28) ;
            }
            if ( ( AV168baseImponibleNro != 24 ) && ( AV168baseImponibleNro != 28 ) )
            {
               GXv_decimal25[0] = AV58Importe ;
               GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
               GXv_decimal21[0] = AV171baseImportes ;
               GXv_int2[0] = (short)(DecimalUtil.decToDouble(AV161cantidadCalculada)) ;
               GXv_char14[0] = AV54error ;
               GXv_char12[0] = AV173LiqDLog ;
               new web.baseimponible_v3(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV84LiqPeriodo, AV168baseImponibleNro, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_decimal21, GXv_int2, GXv_char14, GXv_char12) ;
               resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
               resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
               resuelveoperando.this.AV171baseImportes = GXv_decimal21[0] ;
               resuelveoperando.this.AV161cantidadCalculada = DecimalUtil.doubleToDec(GXv_int2[0]) ;
               resuelveoperando.this.AV54error = GXv_char14[0] ;
               resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            }
            else
            {
               if ( AV168baseImponibleNro == 24 )
               {
                  GXt_char20 = AV197baseConCodigo ;
                  GXt_char19 = AV197baseConCodigo ;
                  GXv_char14[0] = GXt_char19 ;
                  new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).execute( GXv_char14) ;
                  resuelveoperando.this.GXt_char19 = GXv_char14[0] ;
                  GXv_char12[0] = GXt_char20 ;
                  new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char19, GXv_char12) ;
                  resuelveoperando.this.GXt_char20 = GXv_char12[0] ;
                  AV197baseConCodigo = GXt_char20 ;
               }
               else
               {
                  GXt_char20 = AV197baseConCodigo ;
                  GXt_char19 = AV197baseConCodigo ;
                  GXv_char14[0] = GXt_char19 ;
                  new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).execute( GXv_char14) ;
                  resuelveoperando.this.GXt_char19 = GXv_char14[0] ;
                  GXv_char12[0] = GXt_char20 ;
                  new web.getparametro(remoteHandle, context).execute( AV24CliCod, GXt_char19, GXv_char12) ;
                  resuelveoperando.this.GXt_char20 = GXv_char12[0] ;
                  AV197baseConCodigo = GXt_char20 ;
               }
               GXv_decimal25[0] = AV58Importe ;
               GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
               GXv_char14[0] = AV173LiqDLog ;
               GXv_char12[0] = AV54error ;
               new web.base_calculo_os_diferencial(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV197baseConCodigo, AV144ProcesoLiquidacion, GXv_decimal25, GXv_int16, GXv_char14, GXv_char12) ;
               resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
               resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
               resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
               resuelveoperando.this.AV54error = GXv_char12[0] ;
            }
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[tipoLiq]") == 0 )
         {
            GXt_char20 = AV229TLiqCodFor ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV229TLiqCodFor = GXt_char20 ;
            if ( (GXutil.strcmp("", AV229TLiqCodFor)==0) )
            {
               AV38dependenciaResuelta = false ;
               AV54error = httpContext.getMessage( "Falta parámetro en cálculo \"Tipo de liquidación\"", "") ;
               returnInSub = true;
               if (true) return;
            }
            GXv_char14[0] = AV187auxTLiqCod ;
            GXv_boolean13[0] = AV181existe ;
            new web.gettipoliqdepalabra(remoteHandle, context).execute( AV24CliCod, AV229TLiqCodFor, GXv_char14, GXv_boolean13) ;
            resuelveoperando.this.AV187auxTLiqCod = GXv_char14[0] ;
            resuelveoperando.this.AV181existe = GXv_boolean13[0] ;
            if ( ! AV181existe )
            {
               AV38dependenciaResuelta = false ;
               AV54error = httpContext.getMessage( "No existe tipo de liquidación para \"", "") + GXutil.trim( AV229TLiqCodFor) + "\"" ;
               returnInSub = true;
               if (true) return;
            }
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.liquidacionesdetipo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, GXutil.trim( AV187auxTLiqCod), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[mes_Periodo]") == 0 )
         {
            AV94OperandoNuevo = GXutil.str( GXutil.month( AV84LiqPeriodo), 10, 0) ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "[contr_jub_ali]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[contr_inssjyp_ali]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[contr_aaff_ali]") == 0 ) || ( GXutil.strcmp(AV57idOperando, "[contr_fne_ali]") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "[contr_jub_ali]") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "JUBILACION", "") ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[contr_inssjyp_ali]") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "PAMI", "") ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "[contr_aaff_ali]") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "AAFF", "") ;
            }
            else
            {
               AV141buscaPalabra = httpContext.getMessage( "FNE", "") ;
            }
            GXv_decimal25[0] = AV114porUnaje ;
            GXv_char14[0] = AV54error ;
            new web.getprccontrtipoempl(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV141buscaPalabra, AV84LiqPeriodo, AV144ProcesoLiquidacion, GXv_decimal25, GXv_char14) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal25[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "{contribucion_jubilacion}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{contribucion_inssjp}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{contribucion_fne}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{contribucion_aaff}") == 0 ) )
         {
            if ( GXutil.strcmp(AV57idOperando, "{contribucion_jubilacion}") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "JUBILACION", "") ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "{contribucion_inssjp}") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "PAMI", "") ;
            }
            else if ( GXutil.strcmp(AV57idOperando, "{contribucion_aaff}") == 0 )
            {
               AV141buscaPalabra = httpContext.getMessage( "AAFF", "") ;
            }
            else
            {
               AV141buscaPalabra = httpContext.getMessage( "FNE", "") ;
            }
            GXv_decimal25[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_char12[0] = AV54error ;
            new web.contribucion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV141buscaPalabra, GXv_decimal25, GXv_char14, GXv_int16, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char12[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[convenio]") == 0 )
         {
            GXt_char20 = AV35ConveCodigo ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV35ConveCodigo = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadoconvenio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXutil.trim( AV35ConveCodigo), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[categoria]") == 0 )
         {
            GXt_char20 = AV22CatCodigo ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV22CatCodigo = GXt_char20 ;
            GXt_char20 = AV35ConveCodigo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadogetconvenio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV35ConveCodigo = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadocategoria(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, GXutil.trim( AV22CatCodigo), AV35ConveCodigo, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[con_discapacidad]") == 0 )
         {
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadodiscapacidad(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[sexo]") == 0 )
         {
            GXt_char20 = AV230SexoCodFor ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV230SexoCodFor = GXt_char20 ;
            if ( (GXutil.strcmp("", AV230SexoCodFor)==0) )
            {
               AV38dependenciaResuelta = false ;
               AV54error = httpContext.getMessage( "Falta parámetro en cálculo \"Sexo del legajo\"", "") ;
               returnInSub = true;
               if (true) return;
            }
            GXv_int16[0] = AV231SexoId ;
            GXv_boolean13[0] = false ;
            new web.getsexoidporcodfor(remoteHandle, context).execute( AV102PaiCod, AV230SexoCodFor, GXv_int16, GXv_boolean13) ;
            resuelveoperando.this.AV231SexoId = GXv_int16[0] ;
            if ( (0==AV231SexoId) )
            {
               AV38dependenciaResuelta = false ;
               AV54error = httpContext.getMessage( "No existe sexo relacionado al código \"", "") + GXutil.trim( AV230SexoCodFor) + "\"" ;
               returnInSub = true;
               if (true) return;
            }
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadosexo(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV231SexoId, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[edad]") == 0 )
         {
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadoedad(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[area]") == 0 )
         {
            GXt_char20 = AV123SecCodigo ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV123SecCodigo = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadoseccion(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXutil.trim( AV123SecCodigo), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[motivo_egreso]") == 0 )
         {
            GXt_char20 = AV88MegCodigo ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV88MegCodigo = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadomotegr(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXutil.trim( AV88MegCodigo), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[clase]") == 0 )
         {
            GXt_char20 = AV23clase ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV23clase = GXt_char20 ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV23clase)), httpContext.getMessage( "M", "")) == 0 )
            {
               AV76LegClase = (byte)(1) ;
            }
            else
            {
               if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV23clase)), httpContext.getMessage( "Q", "")) == 0 )
               {
                  AV76LegClase = (byte)(2) ;
               }
               else
               {
                  if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV23clase)), httpContext.getMessage( "S", "")) == 0 )
                  {
                     AV76LegClase = (byte)(3) ;
                  }
                  else
                  {
                     AV76LegClase = (byte)(4) ;
                  }
               }
            }
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadoclase(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, AV76LegClase, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[sindicato]") == 0 )
         {
            GXt_char20 = AV125SinCod ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV125SinCod = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadosindicato(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXutil.trim( AV125SinCod), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[alicuota_sindical]") == 0 )
         {
            GXv_char14[0] = AV125SinCod ;
            new web.empleadogetsindicato(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXv_char14) ;
            resuelveoperando.this.AV125SinCod = GXv_char14[0] ;
            GXv_decimal25[0] = AV114porUnaje ;
            GXv_boolean13[0] = false ;
            new web.getsindicatocuota(remoteHandle, context).execute( AV24CliCod, AV125SinCod, GXv_decimal25, GXv_boolean13) ;
            resuelveoperando.this.AV114porUnaje = GXv_decimal25[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV114porUnaje, 6, 4)) ;
            AV149OperandoNuevo2 = localUtil.format( AV114porUnaje, "9.9999") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[obraSocial]") == 0 )
         {
            GXt_char20 = AV96OsoCod ;
            GXv_char14[0] = GXt_char20 ;
            new web.legoperandogetvalor(remoteHandle, context).execute( AV93Operando, GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV96OsoCod = GXt_char20 ;
            GXt_char20 = AV94OperandoNuevo ;
            GXv_char14[0] = GXt_char20 ;
            new web.empleadoobrasocial(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV78LegNumero, GXutil.trim( AV96OsoCod), GXv_char14) ;
            resuelveoperando.this.GXt_char20 = GXv_char14[0] ;
            AV94OperandoNuevo = GXt_char20 ;
            AV149OperandoNuevo2 = AV94OperandoNuevo ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[sueldo_bruto_promedio]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            new web.sueldo_bruto_promedio(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV175date, AV175date, AV29ConCodigo, AV144ProcesoLiquidacion, GXv_decimal25, GXv_int16, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[horas_extras_exentas]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.horasextrasexentas(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV29ConCodigo, AV84LiqPeriodo, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[descuentos_ley_ganancias]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            new web.gananciasdescuentosdeley(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, AV146insertandoConceptos, GXv_decimal25, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[pagos_a_cuenta_anteriores]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            new web.getpagosacuentaactualizado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, GXv_decimal25, GXv_int16) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "[descuentos_retencion]") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_int16[0] = (byte)((byte)((AV28conceptoResuelto)?1:0)) ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            new web.descuentosdeleysobregravado(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV78LegNumero, AV84LiqPeriodo, AV29ConCodigo, true, AV144ProcesoLiquidacion, AV146insertandoConceptos, GXv_decimal25, GXv_int16, GXv_char14, GXv_char12) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV28conceptoResuelto = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            AV38dependenciaResuelta = AV28conceptoResuelto ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( GXutil.strcmp(AV57idOperando, "{horas_nocturnas}") == 0 )
         {
            GXv_decimal25[0] = AV58Importe ;
            GXv_char14[0] = AV173LiqDLog ;
            new web.horas_nocturnas(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV78LegNumero, AV84LiqPeriodo, GXv_decimal25, GXv_char14) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char14[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else if ( ( GXutil.strcmp(AV57idOperando, "{extras_al_50}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{extras_nocturnas_al_50}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{extras_al_100}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{extras_nocturnas_al_100}") == 0 ) )
         {
            if ( ( GXutil.strcmp(AV57idOperando, "{extras_al_50}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{extras_al_100}") == 0 ) )
            {
               AV218recargoNocturno = false ;
            }
            else
            {
               AV218recargoNocturno = true ;
            }
            if ( ( GXutil.strcmp(AV57idOperando, "{extras_al_100}") == 0 ) || ( GXutil.strcmp(AV57idOperando, "{extras_nocturnas_al_100}") == 0 ) )
            {
               AV219extraordinaria = true ;
            }
            else
            {
               AV219extraordinaria = false ;
            }
            GXv_decimal25[0] = AV58Importe ;
            GXv_char14[0] = AV54error ;
            GXv_char12[0] = AV173LiqDLog ;
            GXv_int16[0] = (byte)((byte)((AV38dependenciaResuelta)?1:0)) ;
            GXv_decimal21[0] = AV188LiqDPlus ;
            new web.horas_extras(remoteHandle, context).execute( AV24CliCod, AV53EmpCod, AV83LiqNro, AV227LiqRelNro, AV102PaiCod, AV78LegNumero, AV84LiqPeriodo, AV170LiqDCanti, AV144ProcesoLiquidacion, AV128TLiqCod, AV218recargoNocturno, AV219extraordinaria, GXv_decimal25, GXv_char14, GXv_char12, GXv_int16, GXv_decimal21) ;
            resuelveoperando.this.AV58Importe = GXv_decimal25[0] ;
            resuelveoperando.this.AV54error = GXv_char14[0] ;
            resuelveoperando.this.AV173LiqDLog = GXv_char12[0] ;
            resuelveoperando.this.AV38dependenciaResuelta = (boolean)((GXv_int16[0]==0)?false:true) ;
            resuelveoperando.this.AV188LiqDPlus = GXv_decimal21[0] ;
            AV94OperandoNuevo = GXutil.trim( GXutil.str( AV58Importe, 14, 2)) ;
            AV149OperandoNuevo2 = localUtil.format( AV58Importe, "ZZ,ZZZ,ZZZ,ZZ9.99") ;
         }
         else
         {
            AV54error = httpContext.getMessage( "No se reconoce la palabra \"", "") + GXutil.trim( AV93Operando) + "\"" ;
            AV38dependenciaResuelta = false ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV247Pgmname, httpContext.getMessage( "entra por otherwise idoperando ", "")+AV57idOperando+httpContext.getMessage( " &Operando ", "")+GXutil.trim( AV93Operando)) ;
         }
         if ( ! (GXutil.strcmp("", AV54error)==0) )
         {
            if ( GXutil.strSearch( GXutil.upper( AV54error), httpContext.getMessage( "FALTA CALCULAR CONCEPTO", ""), 1) != 0 )
            {
               AV215dependenciaConceptoEs = true ;
            }
            if ( ! AV167simulacionEs )
            {
               returnInSub = true;
               if (true) return;
            }
         }
         AV94OperandoNuevo = GXutil.trim( AV94OperandoNuevo) ;
         AV149OperandoNuevo2 = GXutil.trim( AV149OperandoNuevo2) ;
      }
   }

   protected void cleanup( )
   {
      this.aP14[0] = resuelveoperando.this.AV122SDTOperandosItem;
      this.aP19[0] = resuelveoperando.this.AV38dependenciaResuelta;
      this.aP20[0] = resuelveoperando.this.AV54error;
      this.aP21[0] = resuelveoperando.this.AV152ConOpeEsCant;
      this.aP22[0] = resuelveoperando.this.AV204alicuotaEs;
      this.aP23[0] = resuelveoperando.this.AV161cantidadCalculada;
      this.aP24[0] = resuelveoperando.this.AV171baseImportes;
      this.aP25[0] = resuelveoperando.this.AV157doResuelveOperando;
      this.aP26[0] = resuelveoperando.this.AV173LiqDLog;
      this.aP27[0] = resuelveoperando.this.AV188LiqDPlus;
      this.aP28[0] = resuelveoperando.this.AV215dependenciaConceptoEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV54error = "" ;
      AV152ConOpeEsCant = DecimalUtil.ZERO ;
      AV161cantidadCalculada = DecimalUtil.ZERO ;
      AV171baseImportes = DecimalUtil.ZERO ;
      AV173LiqDLog = "" ;
      AV188LiqDPlus = DecimalUtil.ZERO ;
      AV94OperandoNuevo = "" ;
      AV149OperandoNuevo2 = "" ;
      AV40Descripcion = "" ;
      AV151Nombre = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV57idOperando = "" ;
      AV92OpeCliId = "" ;
      GXv_boolean10 = new boolean[1] ;
      AV158OperandoTipo = "" ;
      AV247Pgmname = "" ;
      AV136valorGenMismoConcepto = "" ;
      AV58Importe = DecimalUtil.ZERO ;
      AV169palabra = "" ;
      AV241tipo_tarifa = "" ;
      AV114porUnaje = DecimalUtil.ZERO ;
      AV200LegFecEgreso = GXutil.nullDate() ;
      AV194extraORecPalabra = "" ;
      AV141buscaPalabra = "" ;
      AV164busca2Palabra = "" ;
      AV193busca3Palabra = "" ;
      AV234nadaFecha = GXutil.nullDate() ;
      AV179LiqDImpCalcu = DecimalUtil.ZERO ;
      AV180principalConCodigo = "" ;
      AV232CondicionLiquidacion = "" ;
      AV210auxLiqDCanti = DecimalUtil.ZERO ;
      AV163quePalabra = "" ;
      AV211horasNormalesConCodigo = "" ;
      AV213ParmValue = "" ;
      AV192PaiDiaHoras = DecimalUtil.ZERO ;
      AV197baseConCodigo = "" ;
      AV199auxOpeCliId = "" ;
      AV240LegModTra = "" ;
      AV236base_imp_min = DecimalUtil.ZERO ;
      AV237base_imp_max = DecimalUtil.ZERO ;
      AV238LegSuelTipo = "" ;
      AV133totalPalabra = "" ;
      AV21cantidadPalabra = "" ;
      AV224cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      AV228ConOpeId = "" ;
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23 = new GXBaseCollection[1] ;
      AV36CriterioBusqueda = "" ;
      AV41Devolver = "" ;
      AV220Calculo = "" ;
      GXv_char11 = new String[1] ;
      AV222busquedaTLiqCod = "" ;
      GXv_char9 = new String[1] ;
      AV27ConceptoPar = "" ;
      GXv_char8 = new String[1] ;
      AV223TipoConCod = "" ;
      GXv_char7 = new String[1] ;
      AV225retroCatCodigo = "" ;
      GXv_char6 = new String[1] ;
      AV226retroSueldoBasico = DecimalUtil.ZERO ;
      AV61importePalabra = "" ;
      AV139valorUniPalabra = "" ;
      AV137valorGenPalabra = "" ;
      AV59Importe4dec = DecimalUtil.ZERO ;
      AV183AgeCanti = DecimalUtil.ZERO ;
      AV184basicoConCodigo = "" ;
      AV239auxImportes = DecimalUtil.ZERO ;
      AV182importeStr = "" ;
      AV175date = GXutil.nullDate() ;
      GXv_date18 = new java.util.Date[1] ;
      AV35ConveCodigo = "" ;
      AV195codigo1_palabra = "" ;
      AV196FerTipo = "" ;
      AV209DConCondicion = "" ;
      GXv_decimal15 = new java.math.BigDecimal[1] ;
      AV105Param = "" ;
      GXv_date24 = new java.util.Date[1] ;
      AV203auxLiqPeriodo = GXutil.nullDate() ;
      GXv_int22 = new int[1] ;
      GXv_decimal17 = new java.math.BigDecimal[1] ;
      GXv_int2 = new short[1] ;
      GXt_char19 = "" ;
      AV229TLiqCodFor = "" ;
      AV187auxTLiqCod = "" ;
      AV22CatCodigo = "" ;
      AV230SexoCodFor = "" ;
      AV123SecCodigo = "" ;
      AV88MegCodigo = "" ;
      AV23clase = "" ;
      AV125SinCod = "" ;
      GXv_boolean13 = new boolean[1] ;
      AV96OsoCod = "" ;
      GXt_char20 = "" ;
      GXv_decimal25 = new java.math.BigDecimal[1] ;
      GXv_char14 = new String[1] ;
      GXv_char12 = new String[1] ;
      GXv_int16 = new byte[1] ;
      GXv_decimal21 = new java.math.BigDecimal[1] ;
      AV247Pgmname = "ResuelveOperando" ;
      /* GeneXus formulas. */
      AV247Pgmname = "ResuelveOperando" ;
      Gx_err = (short)(0) ;
   }

   private byte AV76LegClase ;
   private byte AV235cantDiasMes ;
   private byte AV231SexoId ;
   private byte GXv_int16[] ;
   private short AV53EmpCod ;
   private short AV102PaiCod ;
   private short GXt_int1 ;
   private short AV145numero ;
   private short AV17cant ;
   private short AV244CliPaiConve ;
   private short AV185horas_mes ;
   private short AV168baseImponibleNro ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV24CliCod ;
   private int AV83LiqNro ;
   private int AV227LiqRelNro ;
   private int AV78LegNumero ;
   private int AV148ActualLiqNro ;
   private int AV19Cantidad ;
   private int AV202CliConveVer ;
   private int AV221periodoNum6 ;
   private int GXv_int22[] ;
   private java.math.BigDecimal AV170LiqDCanti ;
   private java.math.BigDecimal AV152ConOpeEsCant ;
   private java.math.BigDecimal AV161cantidadCalculada ;
   private java.math.BigDecimal AV171baseImportes ;
   private java.math.BigDecimal AV188LiqDPlus ;
   private java.math.BigDecimal AV58Importe ;
   private java.math.BigDecimal AV114porUnaje ;
   private java.math.BigDecimal AV179LiqDImpCalcu ;
   private java.math.BigDecimal AV210auxLiqDCanti ;
   private java.math.BigDecimal AV192PaiDiaHoras ;
   private java.math.BigDecimal AV236base_imp_min ;
   private java.math.BigDecimal AV237base_imp_max ;
   private java.math.BigDecimal AV226retroSueldoBasico ;
   private java.math.BigDecimal AV59Importe4dec ;
   private java.math.BigDecimal AV183AgeCanti ;
   private java.math.BigDecimal AV239auxImportes ;
   private java.math.BigDecimal GXv_decimal15[] ;
   private java.math.BigDecimal GXv_decimal17[] ;
   private java.math.BigDecimal GXv_decimal25[] ;
   private java.math.BigDecimal GXv_decimal21[] ;
   private String AV128TLiqCod ;
   private String AV29ConCodigo ;
   private String AV116primeraPalabra ;
   private String AV144ProcesoLiquidacion ;
   private String AV216llamador ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private String AV57idOperando ;
   private String AV92OpeCliId ;
   private String AV158OperandoTipo ;
   private String AV247Pgmname ;
   private String AV136valorGenMismoConcepto ;
   private String AV169palabra ;
   private String AV241tipo_tarifa ;
   private String AV194extraORecPalabra ;
   private String AV141buscaPalabra ;
   private String AV164busca2Palabra ;
   private String AV193busca3Palabra ;
   private String AV180principalConCodigo ;
   private String AV232CondicionLiquidacion ;
   private String AV163quePalabra ;
   private String AV211horasNormalesConCodigo ;
   private String AV197baseConCodigo ;
   private String AV199auxOpeCliId ;
   private String AV240LegModTra ;
   private String AV238LegSuelTipo ;
   private String AV133totalPalabra ;
   private String AV21cantidadPalabra ;
   private String AV228ConOpeId ;
   private String AV36CriterioBusqueda ;
   private String AV41Devolver ;
   private String AV220Calculo ;
   private String GXv_char11[] ;
   private String AV222busquedaTLiqCod ;
   private String GXv_char9[] ;
   private String AV27ConceptoPar ;
   private String GXv_char8[] ;
   private String AV223TipoConCod ;
   private String GXv_char7[] ;
   private String AV225retroCatCodigo ;
   private String GXv_char6[] ;
   private String AV61importePalabra ;
   private String AV139valorUniPalabra ;
   private String AV137valorGenPalabra ;
   private String AV184basicoConCodigo ;
   private String AV182importeStr ;
   private String AV35ConveCodigo ;
   private String AV195codigo1_palabra ;
   private String AV196FerTipo ;
   private String AV209DConCondicion ;
   private String AV105Param ;
   private String GXt_char19 ;
   private String AV229TLiqCodFor ;
   private String AV187auxTLiqCod ;
   private String AV22CatCodigo ;
   private String AV230SexoCodFor ;
   private String AV123SecCodigo ;
   private String AV88MegCodigo ;
   private String AV23clase ;
   private String AV125SinCod ;
   private String AV96OsoCod ;
   private String GXt_char20 ;
   private String GXv_char14[] ;
   private String GXv_char12[] ;
   private java.util.Date AV84LiqPeriodo ;
   private java.util.Date AV147ActualLiqPeriodo ;
   private java.util.Date AV206DAgeFecDes ;
   private java.util.Date AV200LegFecEgreso ;
   private java.util.Date AV234nadaFecha ;
   private java.util.Date AV175date ;
   private java.util.Date GXv_date18[] ;
   private java.util.Date GXv_date24[] ;
   private java.util.Date AV203auxLiqPeriodo ;
   private boolean AV146insertandoConceptos ;
   private boolean AV167simulacionEs ;
   private boolean AV38dependenciaResuelta ;
   private boolean AV204alicuotaEs ;
   private boolean AV157doResuelveOperando ;
   private boolean AV215dependenciaConceptoEs ;
   private boolean AV154cantidadEs ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean10[] ;
   private boolean returnInSub ;
   private boolean AV207vacacionesEs ;
   private boolean AV233valorBoolean ;
   private boolean AV190cambiarSigno ;
   private boolean AV165restarLicencias ;
   private boolean AV156restarFeriados ;
   private boolean AV212desglosa ;
   private boolean AV205cuotaSindicalEs ;
   private boolean AV55esLiqAnt ;
   private boolean AV28conceptoResuelto ;
   private boolean AV181existe ;
   private boolean AV208distintoEs ;
   private boolean AV155diasPosta ;
   private boolean GXv_boolean13[] ;
   private boolean AV218recargoNocturno ;
   private boolean AV219extraordinaria ;
   private String AV173LiqDLog ;
   private String AV213ParmValue ;
   private String AV93Operando ;
   private String AV54error ;
   private String AV94OperandoNuevo ;
   private String AV149OperandoNuevo2 ;
   private String AV40Descripcion ;
   private String AV151Nombre ;
   private boolean[] aP28 ;
   private web.SdtSDTOperandosFormula[] aP14 ;
   private boolean[] aP19 ;
   private String[] aP20 ;
   private java.math.BigDecimal[] aP21 ;
   private boolean[] aP22 ;
   private java.math.BigDecimal[] aP23 ;
   private java.math.BigDecimal[] aP24 ;
   private boolean[] aP25 ;
   private String[] aP26 ;
   private java.math.BigDecimal[] aP27 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV224cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem23[] ;
   private web.SdtSDTOperandosFormula AV122SDTOperandosItem ;
}

