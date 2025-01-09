package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class legajoasignarbc extends GXProcedure
{
   public legajoasignarbc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( legajoasignarbc.class ), "" );
   }

   public legajoasignarbc( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 ,
                          int aP1 ,
                          short aP2 ,
                          java.util.Date aP3 ,
                          String aP4 ,
                          String aP5 ,
                          String aP6 ,
                          java.util.Date aP7 ,
                          byte aP8 ,
                          short aP9 ,
                          long aP10 ,
                          byte aP11 ,
                          String aP12 ,
                          String aP13 ,
                          String aP14 ,
                          String aP15 ,
                          java.util.Date aP16 ,
                          String aP17 ,
                          String aP18 ,
                          String aP19 ,
                          String aP20 ,
                          byte aP21 ,
                          String aP22 ,
                          java.math.BigDecimal aP23 ,
                          byte aP24 ,
                          String aP25 ,
                          String aP26 ,
                          String aP27 ,
                          String aP28 ,
                          String aP29 ,
                          String aP30 ,
                          String aP31 ,
                          String aP32 ,
                          String aP33 ,
                          String aP34 ,
                          String aP35 ,
                          boolean aP36 ,
                          String aP37 ,
                          String aP38 ,
                          short aP39 ,
                          String aP40 ,
                          String aP41 ,
                          String aP42 ,
                          String aP43 ,
                          String aP44 ,
                          int aP45 ,
                          String aP46 ,
                          String aP47 ,
                          java.math.BigDecimal aP48 ,
                          GXSimpleCollection<String>[] aP49 )
   {
      legajoasignarbc.this.aP50 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34, aP35, aP36, aP37, aP38, aP39, aP40, aP41, aP42, aP43, aP44, aP45, aP46, aP47, aP48, aP49, aP50);
      return aP50[0];
   }

   public void execute( short aP0 ,
                        int aP1 ,
                        short aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        byte aP8 ,
                        short aP9 ,
                        long aP10 ,
                        byte aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        java.util.Date aP16 ,
                        String aP17 ,
                        String aP18 ,
                        String aP19 ,
                        String aP20 ,
                        byte aP21 ,
                        String aP22 ,
                        java.math.BigDecimal aP23 ,
                        byte aP24 ,
                        String aP25 ,
                        String aP26 ,
                        String aP27 ,
                        String aP28 ,
                        String aP29 ,
                        String aP30 ,
                        String aP31 ,
                        String aP32 ,
                        String aP33 ,
                        String aP34 ,
                        String aP35 ,
                        boolean aP36 ,
                        String aP37 ,
                        String aP38 ,
                        short aP39 ,
                        String aP40 ,
                        String aP41 ,
                        String aP42 ,
                        String aP43 ,
                        String aP44 ,
                        int aP45 ,
                        String aP46 ,
                        String aP47 ,
                        java.math.BigDecimal aP48 ,
                        GXSimpleCollection<String>[] aP49 ,
                        int[] aP50 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34, aP35, aP36, aP37, aP38, aP39, aP40, aP41, aP42, aP43, aP44, aP45, aP46, aP47, aP48, aP49, aP50);
   }

   private void execute_int( short aP0 ,
                             int aP1 ,
                             short aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             byte aP8 ,
                             short aP9 ,
                             long aP10 ,
                             byte aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             java.util.Date aP16 ,
                             String aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 ,
                             byte aP21 ,
                             String aP22 ,
                             java.math.BigDecimal aP23 ,
                             byte aP24 ,
                             String aP25 ,
                             String aP26 ,
                             String aP27 ,
                             String aP28 ,
                             String aP29 ,
                             String aP30 ,
                             String aP31 ,
                             String aP32 ,
                             String aP33 ,
                             String aP34 ,
                             String aP35 ,
                             boolean aP36 ,
                             String aP37 ,
                             String aP38 ,
                             short aP39 ,
                             String aP40 ,
                             String aP41 ,
                             String aP42 ,
                             String aP43 ,
                             String aP44 ,
                             int aP45 ,
                             String aP46 ,
                             String aP47 ,
                             java.math.BigDecimal aP48 ,
                             GXSimpleCollection<String>[] aP49 ,
                             int[] aP50 )
   {
      legajoasignarbc.this.AV54validarExistencia = aP0;
      legajoasignarbc.this.AV9CliCod = aP1;
      legajoasignarbc.this.AV10EmpCod = aP2;
      legajoasignarbc.this.AV64Periodo = aP3;
      legajoasignarbc.this.AV67MigrSueldos = aP4;
      legajoasignarbc.this.AV18LegApellido = aP5;
      legajoasignarbc.this.AV19LegNombre = aP6;
      legajoasignarbc.this.AV20LegFecNac = aP7;
      legajoasignarbc.this.AV15LegSexo = aP8;
      legajoasignarbc.this.AV21LegEstadoCivil = aP9;
      legajoasignarbc.this.AV22LegCUIL = aP10;
      legajoasignarbc.this.AV23LegDiscapacidad = aP11;
      legajoasignarbc.this.AV24LegDomici = aP12;
      legajoasignarbc.this.AV25LegEmail = aP13;
      legajoasignarbc.this.AV26LegCodPos = aP14;
      legajoasignarbc.this.AV27LegTelefono = aP15;
      legajoasignarbc.this.AV28LegFecIngreso = aP16;
      legajoasignarbc.this.AV29catcodigo = aP17;
      legajoasignarbc.this.AV16SecCodigo = aP18;
      legajoasignarbc.this.AV31LpgCodigo = aP19;
      legajoasignarbc.this.AV80LegModTra = aP20;
      legajoasignarbc.this.AV17LegClase = aP21;
      legajoasignarbc.this.AV81LegTipoTarifa = aP22;
      legajoasignarbc.this.AV32LegBasico = aP23;
      legajoasignarbc.this.AV33LegFormaPago = aP24;
      legajoasignarbc.this.AV34BanCod = aP25;
      legajoasignarbc.this.AV35LegBanSuc = aP26;
      legajoasignarbc.this.AV36LegBanTipCuen = aP27;
      legajoasignarbc.this.AV37SinCod = aP28;
      legajoasignarbc.this.AV38OsoCod = aP29;
      legajoasignarbc.this.AV39PmedCod = aP30;
      legajoasignarbc.this.AV40LegActCodigo = aP31;
      legajoasignarbc.this.AV41MprCod = aP32;
      legajoasignarbc.this.AV42LegCuentaBanc = aP33;
      legajoasignarbc.this.AV43ZonCod = aP34;
      legajoasignarbc.this.AV44LegCBU = aP35;
      legajoasignarbc.this.AV45LegSCVO = aP36;
      legajoasignarbc.this.AV46SitCodigo = aP37;
      legajoasignarbc.this.AV47ConveCodigo = aP38;
      legajoasignarbc.this.AV48CondiCodigo = aP39;
      legajoasignarbc.this.AV49SinieCodigo = aP40;
      legajoasignarbc.this.AV50legid = aP41;
      legajoasignarbc.this.AV51LegObs = aP42;
      legajoasignarbc.this.AV71MigrPuesto = aP43;
      legajoasignarbc.this.AV72MigrLegErrores = aP44;
      legajoasignarbc.this.AV75LegActClasNro = aP45;
      legajoasignarbc.this.AV76LegPueAfiCod = aP46;
      legajoasignarbc.this.AV78LegMigrWarn = aP47;
      legajoasignarbc.this.AV57LegHorasSem = aP48;
      legajoasignarbc.this.AV55errores = aP49[0];
      this.aP49 = aP49;
      legajoasignarbc.this.aP50 = aP50;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV84Pgmname, httpContext.getMessage( "&LegSexo ", "")+GXutil.trim( GXutil.str( AV15LegSexo, 2, 0))) ;
      GXt_int1 = AV62PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV9CliCod, GXv_int2) ;
      legajoasignarbc.this.GXt_int1 = GXv_int2[0] ;
      AV62PaiCod = GXt_int1 ;
      AV8Legajo.setgxTv_SdtLegajo_Clicod( AV9CliCod );
      AV8Legajo.setgxTv_SdtLegajo_Empcod( AV10EmpCod );
      GXt_int3 = 0 ;
      GXv_int4[0] = GXt_int3 ;
      new web.obtienesiguientelegajo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, GXv_int4) ;
      legajoasignarbc.this.GXt_int3 = GXv_int4[0] ;
      AV8Legajo.setgxTv_SdtLegajo_Legnumero( GXt_int3 );
      AV8Legajo.setgxTv_SdtLegajo_Legestado( (byte)(1) );
      AV8Legajo.setgxTv_SdtLegajo_Legsuccodigo_SetNull();
      if ( ! (0==AV75LegActClasNro) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legactclasnro( AV75LegActClasNro );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legactclasnro_SetNull();
      }
      if ( ! (GXutil.strcmp("", AV76LegPueAfiCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legpueaficod( AV76LegPueAfiCod );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legpueaficod_SetNull();
      }
      AV8Legajo.setgxTv_SdtLegajo_Legapellido( AV18LegApellido );
      AV8Legajo.setgxTv_SdtLegajo_Legnombre( AV19LegNombre );
      AV8Legajo.setgxTv_SdtLegajo_Legfecnac( AV20LegFecNac );
      if ( ! (0==AV15LegSexo) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legsexo( AV15LegSexo );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legsexo_SetNull();
      }
      AV8Legajo.setgxTv_SdtLegajo_Legestadocivil( AV21LegEstadoCivil );
      AV8Legajo.setgxTv_SdtLegajo_Legcuil( AV22LegCUIL );
      AV8Legajo.setgxTv_SdtLegajo_Legdiscapacidad( AV23LegDiscapacidad );
      AV8Legajo.setgxTv_SdtLegajo_Legdomici( AV24LegDomici );
      AV8Legajo.setgxTv_SdtLegajo_Legemail( AV25LegEmail );
      AV8Legajo.setgxTv_SdtLegajo_Legcodpos( AV26LegCodPos );
      AV8Legajo.setgxTv_SdtLegajo_Legtelefono( AV27LegTelefono );
      AV8Legajo.setgxTv_SdtLegajo_Legfecingreso( AV28LegFecIngreso );
      AV8Legajo.setgxTv_SdtLegajo_Legsitrevegreso_SetNull();
      if ( (GXutil.strcmp("", AV29catcodigo)==0) || (GXutil.strcmp("", AV47ConveCodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legcatcodigo_SetNull();
         AV30tieneCategoria = false ;
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legcatcodigo( AV29catcodigo );
         AV30tieneCategoria = true ;
      }
      if ( ! (GXutil.strcmp("", AV16SecCodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legseccodigo( AV16SecCodigo );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legseccodigo_SetNull();
      }
      if ( (GXutil.strcmp("", AV31LpgCodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Leglpgcodigo_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Leglpgcodigo( AV31LpgCodigo );
      }
      AV8Legajo.setgxTv_SdtLegajo_Legclase( AV17LegClase );
      AV8Legajo.setgxTv_SdtLegajo_Legmodtra( AV80LegModTra );
      AV8Legajo.setgxTv_SdtLegajo_Legtipotarifa( AV81LegTipoTarifa );
      if ( ! AV30tieneCategoria )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legsueldofuera( AV32LegBasico );
      }
      AV8Legajo.setgxTv_SdtLegajo_Legformapago( AV33LegFormaPago );
      new web.msgdebug7(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "&LegFormaPago ", "")+GXutil.trim( GXutil.str( AV33LegFormaPago, 1, 0))) ;
      if ( (GXutil.strcmp("", AV34BanCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legbancod_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legbancod( AV34BanCod );
      }
      AV8Legajo.setgxTv_SdtLegajo_Legbansuc( AV35LegBanSuc );
      AV8Legajo.setgxTv_SdtLegajo_Legbantipcuen( AV36LegBanTipCuen );
      new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "&sincod ", "")+GXutil.trim( AV37SinCod)) ;
      if ( (GXutil.strcmp("", AV37SinCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legsincod_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legsincod( AV37SinCod );
         new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "asigna &sincod ", "")+GXutil.trim( AV37SinCod)) ;
      }
      GXv_char5[0] = AV70EmpOsoCod ;
      new web.getemposopredet(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, true, GXv_char5) ;
      legajoasignarbc.this.AV70EmpOsoCod = GXv_char5[0] ;
      if ( (GXutil.strcmp("", AV38OsoCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legosocod( AV70EmpOsoCod );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legosocod( AV38OsoCod );
      }
      if ( (GXutil.strcmp("", AV40LegActCodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legactcodigo_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legactcodigo( AV40LegActCodigo );
      }
      if ( (GXutil.strcmp("", AV41MprCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Mprcod_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Mprcod( AV41MprCod );
      }
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV9CliCod, GXv_dtime7) ;
      legajoasignarbc.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV8Legajo.setgxTv_SdtLegajo_Legfecultmod( GXt_dtime6 );
      AV8Legajo.setgxTv_SdtLegajo_Legcuentabanc( AV42LegCuentaBanc );
      if ( (GXutil.strcmp("", AV43ZonCod)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Zoncod_SetNull();
         AV8Legajo.setgxTv_SdtLegajo_Legprovcod_SetNull();
         AV8Legajo.setgxTv_SdtLegajo_Legloccod_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Zoncod( AV43ZonCod );
         GXv_int2[0] = AV74ProvCod ;
         GXv_int8[0] = AV73LocCod ;
         new web.getprovylocdezonaafip(remoteHandle, context).execute( AV62PaiCod, AV43ZonCod, GXv_int2, GXv_int8) ;
         legajoasignarbc.this.AV74ProvCod = GXv_int2[0] ;
         legajoasignarbc.this.AV73LocCod = GXv_int8[0] ;
         if ( ! (0==AV74ProvCod) )
         {
            AV8Legajo.setgxTv_SdtLegajo_Legprovcod( AV74ProvCod );
         }
         else
         {
            AV8Legajo.setgxTv_SdtLegajo_Legprovcod_SetNull();
         }
         if ( ! (0==AV73LocCod) )
         {
            AV8Legajo.setgxTv_SdtLegajo_Legloccod( AV73LocCod );
         }
         else
         {
            AV8Legajo.setgxTv_SdtLegajo_Legloccod_SetNull();
         }
      }
      AV8Legajo.setgxTv_SdtLegajo_Legcbu( AV44LegCBU );
      AV8Legajo.setgxTv_SdtLegajo_Legscvo( AV45LegSCVO );
      if ( (GXutil.strcmp("", AV47ConveCodigo)==0) || (GXutil.strcmp("", AV29catcodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legconvecodigo_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legconvecodigo( AV47ConveCodigo );
         GXv_int4[0] = AV63CliConveVer ;
         new web.getversiondeconvenio(remoteHandle, context).execute( AV9CliCod, AV62PaiCod, AV47ConveCodigo, GXv_int4) ;
         legajoasignarbc.this.AV63CliConveVer = GXv_int4[0] ;
         AV8Legajo.setgxTv_SdtLegajo_Legconveversioncli( AV63CliConveVer );
      }
      if ( ! (GXutil.strcmp("", GXutil.trim( AV71MigrPuesto))==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legpuescodigo( GXutil.trim( AV71MigrPuesto) );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legpuescodigo_SetNull();
      }
      if ( (0==AV48CondiCodigo) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Condicodigo_SetNull();
         AV8Legajo.setgxTv_SdtLegajo_Legjubilado( false );
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Condicodigo( AV48CondiCodigo );
         if ( AV48CondiCodigo == new web.condicionjubiladoafip(remoteHandle, context).executeUdp( ) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            AV8Legajo.setgxTv_SdtLegajo_Legjubilado( true );
         }
         else
         {
            AV8Legajo.setgxTv_SdtLegajo_Legjubilado( false );
         }
      }
      if ( (GXutil.strcmp("", AV49SinieCodigo)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Siniecodigo_SetNull();
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Siniecodigo( AV49SinieCodigo );
      }
      AV8Legajo.setgxTv_SdtLegajo_Legid( AV50legid );
      AV8Legajo.setgxTv_SdtLegajo_Legobs( AV51LegObs );
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime7[0] = GXt_dtime6 ;
      new web.getahora(remoteHandle, context).execute( AV9CliCod, GXv_dtime7) ;
      legajoasignarbc.this.GXt_dtime6 = GXv_dtime7[0] ;
      AV8Legajo.setgxTv_SdtLegajo_Legfecimportacion( GXt_dtime6 );
      AV8Legajo.setgxTv_SdtLegajo_Legagenreten( false );
      AV8Legajo.setgxTv_SdtLegajo_Legmegcodigo_SetNull();
      GXt_int1 = (short)(0) ;
      GXv_int8[0] = GXt_int1 ;
      new web.getpaicod(remoteHandle, context).execute( AV9CliCod, GXv_int8) ;
      legajoasignarbc.this.GXt_int1 = GXv_int8[0] ;
      AV8Legajo.setgxTv_SdtLegajo_Legnacioncod( GXt_int1 );
      AV8Legajo.setgxTv_SdtLegajo_Legpaicod( AV62PaiCod );
      new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "&LegMigrWarn ", "")+AV78LegMigrWarn) ;
      if ( ! (GXutil.strcmp("", AV78LegMigrWarn)==0) )
      {
         AV8Legajo.setgxTv_SdtLegajo_Legmigrwarn( AV78LegMigrWarn );
         AV8Legajo.setgxTv_SdtLegajo_Legincompleto( true );
         new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "ASIGNA LegIncompleto = true", "")) ;
      }
      else
      {
         AV8Legajo.setgxTv_SdtLegajo_Legincompleto( false );
         AV8Legajo.setgxTv_SdtLegajo_Legmigrwarn_SetNull();
      }
      AV8Legajo.setgxTv_SdtLegajo_Leghorassem( AV57LegHorasSem );
      AV61item = (web.SdtLegajo_tipos_de_trabajo)new web.SdtLegajo_tipos_de_trabajo( remoteHandle, context);
      AV61item.setgxTv_SdtLegajo_tipos_de_trabajo_Legtipotra( "diurno" );
      AV8Legajo.getgxTv_SdtLegajo_Tipos_de_trabajo().add(AV61item, 0);
      AV8Legajo.setgxTv_SdtLegajo_Legtrabdo( false );
      AV8Legajo.setgxTv_SdtLegajo_Legtrabjue( true );
      AV8Legajo.setgxTv_SdtLegajo_Legtrablun( true );
      AV8Legajo.setgxTv_SdtLegajo_Legtrabmar( true );
      AV8Legajo.setgxTv_SdtLegajo_Legtrabmie( true );
      AV8Legajo.setgxTv_SdtLegajo_Legtrabsa( false );
      AV8Legajo.setgxTv_SdtLegajo_Legtrabvie( true );
      AV8Legajo.Save();
      AV56LegNumero = AV8Legajo.getgxTv_SdtLegajo_Legnumero() ;
      AV52messages = AV8Legajo.GetMessages() ;
      if ( AV8Legajo.Fail() )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "fallo", "")) ;
         AV85GXV1 = 1 ;
         while ( AV85GXV1 <= AV52messages.size() )
         {
            AV53message = (com.genexus.SdtMessages_Message)((com.genexus.SdtMessages_Message)AV52messages.elementAt(-1+AV85GXV1));
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV84Pgmname, httpContext.getMessage( "&message ", "")+GXutil.trim( AV53message.getgxTv_SdtMessages_Message_Description())+httpContext.getMessage( " &Legajo.LegPaiCod!! ", "")+GXutil.str( AV8Legajo.getgxTv_SdtLegajo_Legpaicod(), 4, 0)+httpContext.getMessage( " nacioncod ", "")+GXutil.trim( GXutil.str( AV8Legajo.getgxTv_SdtLegajo_Legnacioncod(), 4, 0))) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV84Pgmname, httpContext.getMessage( "&index ", "")+GXutil.str( GXutil.strSearch( GXutil.upper( AV53message.getgxTv_SdtMessages_Message_Description()), httpContext.getMessage( "NO EXISTE", ""), 1), 10, 0)) ;
            if ( ( AV54validarExistencia == ( 1 )) || ( ( GXutil.strSearch( GXutil.upper( AV53message.getgxTv_SdtMessages_Message_Description()), httpContext.getMessage( "NO EXISTE", ""), 1) == 0 ) && ( GXutil.strSearch( GXutil.upper( AV53message.getgxTv_SdtMessages_Message_Description()), httpContext.getMessage( "C3992", ""), 1) == 0 ) && ( GXutil.strSearch( GXutil.upper( AV53message.getgxTv_SdtMessages_Message_Description()), httpContext.getMessage( "FUERA DE RANGO", ""), 1) == 0 ) ) )
            {
               if ( GXutil.strSearch( AV72MigrLegErrores, AV53message.getgxTv_SdtMessages_Message_Description(), 1) == 0 )
               {
                  AV55errores.add(AV53message.getgxTv_SdtMessages_Message_Description(), 0);
               }
            }
            AV85GXV1 = (int)(AV85GXV1+1) ;
         }
      }
      else
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV84Pgmname, httpContext.getMessage( "success 1 &Legajo.LegNumero ", "")+GXutil.trim( GXutil.str( AV8Legajo.getgxTv_SdtLegajo_Legnumero(), 8, 0))) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV32LegBasico)==0) && ( AV54validarExistencia == ( 1 )) )
         {
            if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV64Periodo)) )
            {
               AV65LegSuelFecha = localUtil.ymdtod( GXutil.year( AV8Legajo.getgxTv_SdtLegajo_Legfecingreso()), GXutil.month( AV8Legajo.getgxTv_SdtLegajo_Legfecingreso()), 1) ;
            }
            else
            {
               AV65LegSuelFecha = AV64Periodo ;
            }
            if ( ! (GXutil.strcmp("", AV67MigrSueldos)==0) )
            {
               AV66migracion_sueldos.fromJSonString(AV67MigrSueldos, null);
               AV68i = (short)(1) ;
               AV66migracion_sueldos.sort(httpContext.getMessage( "fecha,(sueldo)", ""));
               while ( AV68i <= AV66migracion_sueldos.size() )
               {
                  if ( !( GXutil.dateCompare(GXutil.resetTime(((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV66migracion_sueldos.elementAt(-1+AV68i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha()), GXutil.resetTime(AV69ultFecha)) ) )
                  {
                     new web.newlegajo_sueldo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV8Legajo.getgxTv_SdtLegajo_Legnumero(), ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV66migracion_sueldos.elementAt(-1+AV68i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha(), ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV66migracion_sueldos.elementAt(-1+AV68i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Sueldo(), "Bruto") ;
                  }
                  AV69ultFecha = ((web.Sdtmigracion_sueldos_migracion_sueldosItem)AV66migracion_sueldos.elementAt(-1+AV68i)).getgxTv_Sdtmigracion_sueldos_migracion_sueldosItem_Fecha() ;
                  AV68i = (short)(AV68i+1) ;
               }
            }
            else
            {
               new web.newlegajo_sueldo(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV8Legajo.getgxTv_SdtLegajo_Legnumero(), AV65LegSuelFecha, AV32LegBasico, "Bruto") ;
            }
         }
         if ( ! (GXutil.strcmp("", AV47ConveCodigo)==0) && ( AV54validarExistencia == ( 1 )) )
         {
            /* Using cursor P00LF2 */
            pr_default.execute(0, new Object[] {Short.valueOf(AV62PaiCod), AV47ConveCodigo});
            while ( (pr_default.getStatus(0) != 101) )
            {
               A9ConveCodigo = P00LF2_A9ConveCodigo[0] ;
               A46PaiCod = P00LF2_A46PaiCod[0] ;
               A2227propCod = P00LF2_A2227propCod[0] ;
               A2229propTipoDato = P00LF2_A2229propTipoDato[0] ;
               A2262ConvePropPredet = P00LF2_A2262ConvePropPredet[0] ;
               A2229propTipoDato = P00LF2_A2229propTipoDato[0] ;
               AV77LegajoPropiedades = (web.SdtLegajo_Propiedades)new web.SdtLegajo_Propiedades( remoteHandle, context);
               AV77LegajoPropiedades.setgxTv_SdtLegajo_Propiedades_Legpropcod( A2227propCod );
               if ( GXutil.strcmp(A2229propTipoDato, "BOOL") == 0 )
               {
                  AV77LegajoPropiedades.setgxTv_SdtLegajo_Propiedades_Legpropvalbool( GXutil.boolval( A2262ConvePropPredet) );
               }
               else if ( GXutil.strcmp(A2229propTipoDato, "DATE") == 0 )
               {
                  AV77LegajoPropiedades.setgxTv_SdtLegajo_Propiedades_Legpropvaldate( localUtil.ctod( A2262ConvePropPredet, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) );
               }
               else if ( GXutil.strcmp(A2229propTipoDato, "STR") == 0 )
               {
                  AV77LegajoPropiedades.setgxTv_SdtLegajo_Propiedades_Legpropvalstr( A2262ConvePropPredet );
               }
               else if ( GXutil.strcmp(A2229propTipoDato, "NUM") == 0 )
               {
                  AV77LegajoPropiedades.setgxTv_SdtLegajo_Propiedades_Legpropvalnum( CommonUtil.decimalVal( A2262ConvePropPredet, ".") );
               }
               else
               {
                  /* Exit For each command. Update data (if necessary), close cursors & exit. */
                  if (true) break;
               }
               AV8Legajo.getgxTv_SdtLegajo_Propiedades().add(AV77LegajoPropiedades, 0);
               pr_default.readNext(0);
            }
            pr_default.close(0);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV84Pgmname, httpContext.getMessage( "success 2 &Legajo.LegNumero ", "")+GXutil.trim( GXutil.str( AV8Legajo.getgxTv_SdtLegajo_Legnumero(), 8, 0))) ;
         new web.new_legajo_permanencia(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV8Legajo.getgxTv_SdtLegajo_Legnumero(), AV8Legajo.getgxTv_SdtLegajo_Legfecingreso(), AV8Legajo.getgxTv_SdtLegajo_Legfecegreso(), AV79vaciaDate, AV8Legajo.getgxTv_SdtLegajo_Legmegcodigo(), true, "", true) ;
         new web.inicializarperiodoscclic(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV8Legajo.getgxTv_SdtLegajo_Legnumero(), (short)(0)) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP49[0] = legajoasignarbc.this.AV55errores;
      this.aP50[0] = legajoasignarbc.this.AV56LegNumero;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV84Pgmname = "" ;
      AV8Legajo = new web.SdtLegajo(remoteHandle);
      AV70EmpOsoCod = "" ;
      GXv_char5 = new String[1] ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      GXt_dtime6 = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime7 = new java.util.Date[1] ;
      GXv_int8 = new short[1] ;
      AV61item = new web.SdtLegajo_tipos_de_trabajo(remoteHandle);
      AV52messages = new GXBaseCollection<com.genexus.SdtMessages_Message>(com.genexus.SdtMessages_Message.class, "Message", "GeneXus", remoteHandle);
      AV53message = new com.genexus.SdtMessages_Message(remoteHandle, context);
      AV65LegSuelFecha = GXutil.nullDate() ;
      AV66migracion_sueldos = new GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem>(web.Sdtmigracion_sueldos_migracion_sueldosItem.class, "migracion_sueldosItem", "PayDay", remoteHandle);
      AV69ultFecha = GXutil.nullDate() ;
      scmdbuf = "" ;
      P00LF2_A9ConveCodigo = new String[] {""} ;
      P00LF2_A46PaiCod = new short[1] ;
      P00LF2_A2227propCod = new String[] {""} ;
      P00LF2_A2229propTipoDato = new String[] {""} ;
      P00LF2_A2262ConvePropPredet = new String[] {""} ;
      A9ConveCodigo = "" ;
      A2227propCod = "" ;
      A2229propTipoDato = "" ;
      A2262ConvePropPredet = "" ;
      AV77LegajoPropiedades = new web.SdtLegajo_Propiedades(remoteHandle);
      AV79vaciaDate = GXutil.nullDate() ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.legajoasignarbc__default(),
         new Object[] {
             new Object[] {
            P00LF2_A9ConveCodigo, P00LF2_A46PaiCod, P00LF2_A2227propCod, P00LF2_A2229propTipoDato, P00LF2_A2262ConvePropPredet
            }
         }
      );
      AV84Pgmname = "LegajoAsignarBC" ;
      /* GeneXus formulas. */
      AV84Pgmname = "LegajoAsignarBC" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LegSexo ;
   private byte AV23LegDiscapacidad ;
   private byte AV17LegClase ;
   private byte AV33LegFormaPago ;
   private short AV54validarExistencia ;
   private short AV10EmpCod ;
   private short AV21LegEstadoCivil ;
   private short AV48CondiCodigo ;
   private short AV62PaiCod ;
   private short AV74ProvCod ;
   private short GXv_int2[] ;
   private short AV73LocCod ;
   private short GXt_int1 ;
   private short GXv_int8[] ;
   private short AV68i ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV75LegActClasNro ;
   private int AV56LegNumero ;
   private int GXt_int3 ;
   private int AV63CliConveVer ;
   private int GXv_int4[] ;
   private int AV85GXV1 ;
   private long AV22LegCUIL ;
   private java.math.BigDecimal AV32LegBasico ;
   private java.math.BigDecimal AV57LegHorasSem ;
   private String AV26LegCodPos ;
   private String AV29catcodigo ;
   private String AV16SecCodigo ;
   private String AV31LpgCodigo ;
   private String AV80LegModTra ;
   private String AV81LegTipoTarifa ;
   private String AV34BanCod ;
   private String AV36LegBanTipCuen ;
   private String AV37SinCod ;
   private String AV38OsoCod ;
   private String AV39PmedCod ;
   private String AV40LegActCodigo ;
   private String AV41MprCod ;
   private String AV43ZonCod ;
   private String AV46SitCodigo ;
   private String AV47ConveCodigo ;
   private String AV49SinieCodigo ;
   private String AV50legid ;
   private String AV76LegPueAfiCod ;
   private String AV84Pgmname ;
   private String AV70EmpOsoCod ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private String A2227propCod ;
   private String A2229propTipoDato ;
   private String A2262ConvePropPredet ;
   private java.util.Date GXt_dtime6 ;
   private java.util.Date GXv_dtime7[] ;
   private java.util.Date AV64Periodo ;
   private java.util.Date AV20LegFecNac ;
   private java.util.Date AV28LegFecIngreso ;
   private java.util.Date AV65LegSuelFecha ;
   private java.util.Date AV69ultFecha ;
   private java.util.Date AV79vaciaDate ;
   private boolean AV45LegSCVO ;
   private boolean AV30tieneCategoria ;
   private boolean Cond_result ;
   private String AV67MigrSueldos ;
   private String AV51LegObs ;
   private String AV72MigrLegErrores ;
   private String AV78LegMigrWarn ;
   private String AV18LegApellido ;
   private String AV19LegNombre ;
   private String AV24LegDomici ;
   private String AV25LegEmail ;
   private String AV27LegTelefono ;
   private String AV35LegBanSuc ;
   private String AV42LegCuentaBanc ;
   private String AV44LegCBU ;
   private String AV71MigrPuesto ;
   private web.SdtLegajo AV8Legajo ;
   private int[] aP50 ;
   private GXSimpleCollection<String>[] aP49 ;
   private IDataStoreProvider pr_default ;
   private String[] P00LF2_A9ConveCodigo ;
   private short[] P00LF2_A46PaiCod ;
   private String[] P00LF2_A2227propCod ;
   private String[] P00LF2_A2229propTipoDato ;
   private String[] P00LF2_A2262ConvePropPredet ;
   private GXSimpleCollection<String> AV55errores ;
   private GXBaseCollection<com.genexus.SdtMessages_Message> AV52messages ;
   private GXBaseCollection<web.Sdtmigracion_sueldos_migracion_sueldosItem> AV66migracion_sueldos ;
   private com.genexus.SdtMessages_Message AV53message ;
   private web.SdtLegajo_tipos_de_trabajo AV61item ;
   private web.SdtLegajo_Propiedades AV77LegajoPropiedades ;
}

final  class legajoasignarbc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00LF2", "SELECT T1.ConveCodigo, T1.PaiCod, T1.propCod, T2.propTipoDato, T1.ConvePropPredet FROM (ConvenioPropiedadesAdicionales T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.propCod) WHERE T1.PaiCod = ? and T1.ConveCodigo = ( ?) ORDER BY T1.PaiCod, T1.ConveCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

