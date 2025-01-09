package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newlegajo extends GXProcedure
{
   public newlegajo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newlegajo.class ), "" );
   }

   public newlegajo( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.util.Date aP8 ,
                        long aP9 ,
                        String aP10 ,
                        java.util.Date aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        byte aP15 ,
                        byte aP16 ,
                        String aP17 ,
                        String aP18 ,
                        String aP19 ,
                        String aP20 ,
                        String aP21 ,
                        String aP22 ,
                        String aP23 ,
                        String aP24 ,
                        short aP25 ,
                        String aP26 ,
                        String aP27 ,
                        java.math.BigDecimal aP28 ,
                        String aP29 ,
                        String aP30 ,
                        String aP31 ,
                        String aP32 ,
                        boolean aP33 ,
                        java.util.Date aP34 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30, aP31, aP32, aP33, aP34);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.util.Date aP8 ,
                             long aP9 ,
                             String aP10 ,
                             java.util.Date aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             byte aP15 ,
                             byte aP16 ,
                             String aP17 ,
                             String aP18 ,
                             String aP19 ,
                             String aP20 ,
                             String aP21 ,
                             String aP22 ,
                             String aP23 ,
                             String aP24 ,
                             short aP25 ,
                             String aP26 ,
                             String aP27 ,
                             java.math.BigDecimal aP28 ,
                             String aP29 ,
                             String aP30 ,
                             String aP31 ,
                             String aP32 ,
                             boolean aP33 ,
                             java.util.Date aP34 )
   {
      newlegajo.this.AV8CliCod = aP0;
      newlegajo.this.AV9EmpCod = aP1;
      newlegajo.this.AV10LegNumero = aP2;
      newlegajo.this.AV41LegSexo = aP3;
      newlegajo.this.AV11LegApellido = aP4;
      newlegajo.this.AV12LegNombre = aP5;
      newlegajo.this.AV13LegId = aP6;
      newlegajo.this.AV14LegNumDoc = aP7;
      newlegajo.this.AV15LegFecNac = aP8;
      newlegajo.this.AV16LegCUIL = aP9;
      newlegajo.this.AV17LegDomici = aP10;
      newlegajo.this.AV19LegFecIngreso = aP11;
      newlegajo.this.AV20CatCodigo = aP12;
      newlegajo.this.AV21SecCodigo = aP13;
      newlegajo.this.AV22LpgCodigo = aP14;
      newlegajo.this.AV23LegClase = aP15;
      newlegajo.this.AV24LegFormaPago = aP16;
      newlegajo.this.AV25BanCod = aP17;
      newlegajo.this.AV26LegBanSuc = aP18;
      newlegajo.this.AV27SinCod = aP19;
      newlegajo.this.AV28OsoCod = aP20;
      newlegajo.this.AV29PmedCod = aP21;
      newlegajo.this.AV30LegActCodigo = aP22;
      newlegajo.this.AV31ZonCod = aP23;
      newlegajo.this.AV32SitCodigo = aP24;
      newlegajo.this.AV33CondiCodigo = aP25;
      newlegajo.this.AV34SinieCodigo = aP26;
      newlegajo.this.AV35ConveCodigo = aP27;
      newlegajo.this.AV36LegSueldoFuera = aP28;
      newlegajo.this.AV37LegCBU = aP29;
      newlegajo.this.AV38UriFoto = aP30;
      newlegajo.this.AV42LegFotoNom = aP31;
      newlegajo.this.AV43LegFotoExt = aP32;
      newlegajo.this.AV39LegAgenReten = aP33;
      newlegajo.this.AV40LegFecEgreso = aP34;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV50PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV8CliCod, GXv_int2) ;
      newlegajo.this.GXt_int1 = GXv_int2[0] ;
      AV50PaiCod = GXt_int1 ;
      /* Using cursor P00FX2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV50PaiCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1747EstaCivilPais = P00FX2_A1747EstaCivilPais[0] ;
         A1748EstaCivilCod = P00FX2_A1748EstaCivilCod[0] ;
         AV49LegEstadoCivil = A1748EstaCivilCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "ini", "")) ;
      /*
         INSERT RECORD ON TABLE Legajo

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A6LegNumero = AV10LegNumero ;
      A230LegApellido = AV11LegApellido ;
      A251LegNombre = AV12LegNombre ;
      A93LegId = GXutil.trim( AV13LegId) ;
      n93LegId = false ;
      A591LegNomApe = GXutil.trim( AV11LegApellido) + ", " + GXutil.trim( AV12LegNombre) ;
      A250LegIdNomApe = GXutil.trim( AV13LegId) + " - " + GXutil.trim( AV12LegNombre) + " " + GXutil.trim( AV11LegApellido) ;
      A1818LegEstado = (byte)(1) ;
      A249LegFoto = "" ;
      n249LegFoto = false ;
      A266LegTipDoc = (byte)(0) ;
      A257LegNumDoc = AV14LegNumDoc ;
      A246LegFecNac = AV15LegFecNac ;
      A263LegSexo = AV41LegSexo ;
      n263LegSexo = false ;
      A243LegEstadoCivil = AV49LegEstadoCivil ;
      n243LegEstadoCivil = false ;
      GXt_char3 = "" ;
      GXv_char4[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, httpContext.getMessage( "PAI_DEF", ""), GXv_char4) ;
      newlegajo.this.GXt_char3 = GXv_char4[0] ;
      A21LegNacionCod = (short)(GXutil.lval( GXt_char3)) ;
      n21LegNacionCod = false ;
      A239LegCUIL = AV16LegCUIL ;
      A241LegDiscapacidad = (byte)(0) ;
      A242LegDomici = AV17LegDomici ;
      A236LegCodPos = "" ;
      A22LegPaiCod = AV50PaiCod ;
      n22LegPaiCod = false ;
      A23LegProvCod = (short)(0) ;
      n23LegProvCod = false ;
      n23LegProvCod = true ;
      A24LegLocCod = (short)(0) ;
      n24LegLocCod = false ;
      n24LegLocCod = true ;
      if ( ! (GXutil.strcmp("", AV35ConveCodigo)==0) )
      {
         A937LegConveCodigo = AV35ConveCodigo ;
         n937LegConveCodigo = false ;
      }
      else
      {
         A937LegConveCodigo = "" ;
         n937LegConveCodigo = false ;
         n937LegConveCodigo = true ;
      }
      A265LegTelefono = "11321321" ;
      n265LegTelefono = false ;
      A245LegFecIngreso = AV19LegFecIngreso ;
      A244LegFecEgreso = AV40LegFecEgreso ;
      n244LegFecEgreso = false ;
      A1583LegMegCodigo = "" ;
      n1583LegMegCodigo = false ;
      n1583LegMegCodigo = true ;
      if ( ! (GXutil.strcmp("", AV20CatCodigo)==0) )
      {
         A939LegCatCodigo = AV20CatCodigo ;
         n939LegCatCodigo = false ;
         GXv_int5[0] = AV48LegConveVersionCli ;
         new web.getversiondeconvenio(remoteHandle, context).execute( AV8CliCod, A22LegPaiCod, A937LegConveCodigo, GXv_int5) ;
         newlegajo.this.AV48LegConveVersionCli = GXv_int5[0] ;
         A1576LegConveVersionCli = AV48LegConveVersionCli ;
         n1576LegConveVersionCli = false ;
      }
      else
      {
         A939LegCatCodigo = "" ;
         n939LegCatCodigo = false ;
         n939LegCatCodigo = true ;
         A264LegSueldoFuera = AV36LegSueldoFuera ;
         A1576LegConveVersionCli = 0 ;
         n1576LegConveVersionCli = false ;
         n1576LegConveVersionCli = true ;
      }
      A1579LegSecCodigo = AV21SecCodigo ;
      n1579LegSecCodigo = false ;
      if ( ! (GXutil.strcmp("", AV22LpgCodigo)==0) )
      {
         A1581LegLpgCodigo = AV22LpgCodigo ;
         n1581LegLpgCodigo = false ;
      }
      else
      {
         A1581LegLpgCodigo = "" ;
         n1581LegLpgCodigo = false ;
         n1581LegLpgCodigo = true ;
      }
      A235LegClase = AV23LegClase ;
      A2404LegModTra = "E" ;
      A248LegFormaPago = AV24LegFormaPago ;
      if ( ! (GXutil.strcmp("", AV25BanCod)==0) )
      {
         A1582LegBanCod = AV25BanCod ;
         n1582LegBanCod = false ;
      }
      else
      {
         A1582LegBanCod = "" ;
         n1582LegBanCod = false ;
         n1582LegBanCod = true ;
      }
      A231LegBanSuc = AV26LegBanSuc ;
      n231LegBanSuc = false ;
      A232LegBanTipCuen = "" ;
      n232LegBanTipCuen = false ;
      if ( ! (GXutil.strcmp("", AV27SinCod)==0) )
      {
         A910LegSinCod = AV27SinCod ;
         n910LegSinCod = false ;
      }
      else
      {
         A910LegSinCod = "" ;
         n910LegSinCod = false ;
         n910LegSinCod = true ;
      }
      A1580LegOsoCod = AV28OsoCod ;
      n1580LegOsoCod = false ;
      A15LegActCodigo = AV30LegActCodigo ;
      n15LegActCodigo = false ;
      GXt_char3 = A18MprCod ;
      GXt_char6 = A18MprCod ;
      GXv_char4[0] = GXt_char6 ;
      new web.modalidad_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      newlegajo.this.GXt_char6 = GXv_char4[0] ;
      GXv_char7[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char6, GXv_char7) ;
      newlegajo.this.GXt_char3 = GXv_char7[0] ;
      A18MprCod = GXt_char3 ;
      n18MprCod = false ;
      A247LegFecUltMod = GXutil.resetTime(GXutil.serverNow( context, remoteHandle, pr_default)) ;
      A238LegCuentaBanc = "" ;
      n238LegCuentaBanc = false ;
      A253LegLicInicio = GXutil.nullDate() ;
      n253LegLicInicio = false ;
      A252LegLicFinal = GXutil.nullDate() ;
      n252LegLicFinal = false ;
      new web.msgdebug6(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "&ZonCod ", "")+GXutil.trim( AV31ZonCod)) ;
      A20ZonCod = GXutil.trim( AV31ZonCod) ;
      n20ZonCod = false ;
      A234LegCBU = AV37LegCBU ;
      n234LegCBU = false ;
      A237LegConvenio = false ;
      A262LegSCVO = true ;
      A17CondiCodigo = AV33CondiCodigo ;
      n17CondiCodigo = false ;
      A19SinieCodigo = AV34SinieCodigo ;
      n19SinieCodigo = false ;
      A1603LegSitRevEgreso = (short)(0) ;
      n1603LegSitRevEgreso = false ;
      n1603LegSitRevEgreso = true ;
      A877LegAgenReten = AV39LegAgenReten ;
      A879LegContinua = "" ;
      if ( ! (GXutil.strcmp("", AV38UriFoto)==0) )
      {
         A249LegFoto = AV38UriFoto ;
         n249LegFoto = false ;
      }
      A1031LegFotoExt = AV43LegFotoExt ;
      A1030LegFotoNom = AV42LegFotoNom ;
      AV47LegTipoTra.add("diurno", 0);
      GXv_decimal8[0] = AV44LegHorasSem ;
      new web.gethorassemananormal(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, 0, A22LegPaiCod, A937LegConveCodigo, AV47LegTipoTra, GXv_decimal8) ;
      newlegajo.this.AV44LegHorasSem = GXv_decimal8[0] ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV44LegHorasSem)==0) )
      {
         AV44LegHorasSem = DecimalUtil.doubleToDec(48) ;
      }
      A1268LegHorasSem = AV44LegHorasSem ;
      A1235LegReligion = "" ;
      n1235LegReligion = false ;
      n1235LegReligion = true ;
      A1236LegOrigen = "" ;
      n1236LegOrigen = false ;
      n1236LegOrigen = true ;
      A1578LegPuesCodigo = "" ;
      n1578LegPuesCodigo = false ;
      n1578LegPuesCodigo = true ;
      A1577LegSucCodigo = "" ;
      n1577LegSucCodigo = false ;
      n1577LegSucCodigo = true ;
      A1251LegTrabDo = false ;
      A1248LegTrabJue = true ;
      A1245LegTrabLun = true ;
      A1246LegTrabMar = true ;
      A1247LegTrabMie = true ;
      A1250LegTrabSa = false ;
      A1249LegTrabVie = true ;
      A1523LegVacPend = (short)(0) ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      A479LegEmail = "" ;
      A228LegActivo = false ;
      A515LegObs = "" ;
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      A942LegRecalcLiq = false ;
      A1016LegJubilado = false ;
      A1023LegHorasDia = DecimalUtil.ZERO ;
      A1759LegPromDias = "" ;
      A1804LegTitulo = "" ;
      /* Using cursor P00FX3 */
      A1030LegFotoNom = com.genexus.util.GXFile.getgxFilename( A249LegFoto) ;
      A1031LegFotoExt = com.genexus.util.GXFile.getgxFileext( A249LegFoto) ;
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A230LegApellido, A251LegNombre, Boolean.valueOf(n249LegFoto), A249LegFoto, Byte.valueOf(A266LegTipDoc), A257LegNumDoc, A246LegFecNac, Boolean.valueOf(n263LegSexo), Byte.valueOf(A263LegSexo), Boolean.valueOf(n243LegEstadoCivil), Short.valueOf(A243LegEstadoCivil), Boolean.valueOf(n21LegNacionCod), Short.valueOf(A21LegNacionCod), Long.valueOf(A239LegCUIL), Byte.valueOf(A241LegDiscapacidad), A242LegDomici, A479LegEmail, A236LegCodPos, Boolean.valueOf(n22LegPaiCod), Short.valueOf(A22LegPaiCod), Boolean.valueOf(n23LegProvCod), Short.valueOf(A23LegProvCod), Boolean.valueOf(n24LegLocCod), Short.valueOf(A24LegLocCod), Boolean.valueOf(n265LegTelefono), A265LegTelefono, A245LegFecIngreso, Boolean.valueOf(n244LegFecEgreso), A244LegFecEgreso, Byte.valueOf(A235LegClase), Byte.valueOf(A248LegFormaPago), Boolean.valueOf(n231LegBanSuc), A231LegBanSuc, Boolean.valueOf(n232LegBanTipCuen), A232LegBanTipCuen, Boolean.valueOf(n15LegActCodigo), A15LegActCodigo, Boolean.valueOf(n18MprCod), A18MprCod, A247LegFecUltMod, Boolean.valueOf(n238LegCuentaBanc), A238LegCuentaBanc, Boolean.valueOf(n253LegLicInicio), A253LegLicInicio, Boolean.valueOf(n252LegLicFinal), A252LegLicFinal, Boolean.valueOf(n20ZonCod), A20ZonCod, Boolean.valueOf(n234LegCBU), A234LegCBU, Boolean.valueOf(A237LegConvenio), Boolean.valueOf(A262LegSCVO), Boolean.valueOf(n17CondiCodigo), Short.valueOf(A17CondiCodigo), Boolean.valueOf(n19SinieCodigo), A19SinieCodigo, Boolean.valueOf(A228LegActivo), A264LegSueldoFuera, Boolean.valueOf(n93LegId), A93LegId, A250LegIdNomApe, A515LegObs, A591LegNomApe, A630LegFecImportacion, Boolean.valueOf(A877LegAgenReten), A879LegContinua, Boolean.valueOf(n910LegSinCod), A910LegSinCod, Boolean.valueOf(n937LegConveCodigo), A937LegConveCodigo, Boolean.valueOf(n939LegCatCodigo), A939LegCatCodigo, Boolean.valueOf(A942LegRecalcLiq), Boolean.valueOf(A1016LegJubilado), A1023LegHorasDia, A1030LegFotoNom, A1031LegFotoExt, Boolean.valueOf(n1235LegReligion), A1235LegReligion, Boolean.valueOf(n1236LegOrigen), A1236LegOrigen, Boolean.valueOf(A1245LegTrabLun), Boolean.valueOf(A1246LegTrabMar), Boolean.valueOf(A1247LegTrabMie), Boolean.valueOf(A1248LegTrabJue), Boolean.valueOf(A1249LegTrabVie), Boolean.valueOf(A1250LegTrabSa), Boolean.valueOf(A1251LegTrabDo), A1268LegHorasSem, Short.valueOf(A1523LegVacPend), A1531LegFecPreAviso, Boolean.valueOf(n1576LegConveVersionCli), Integer.valueOf(A1576LegConveVersionCli), Boolean.valueOf(n1581LegLpgCodigo), A1581LegLpgCodigo, Boolean.valueOf(n1582LegBanCod), A1582LegBanCod, Boolean.valueOf(n1580LegOsoCod), A1580LegOsoCod, Boolean.valueOf(n1578LegPuesCodigo), A1578LegPuesCodigo, Boolean.valueOf(n1577LegSucCodigo), A1577LegSucCodigo, Boolean.valueOf(n1579LegSecCodigo), A1579LegSecCodigo, Boolean.valueOf(n1583LegMegCodigo), A1583LegMegCodigo, Boolean.valueOf(n1603LegSitRevEgreso), Short.valueOf(A1603LegSitRevEgreso), A1759LegPromDias, A1804LegTitulo, Byte.valueOf(A1818LegEstado), A2404LegModTra});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajo");
      if ( (pr_default.getStatus(1) == 1) )
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
      /*
         INSERT RECORD ON TABLE Legajotipos_de_trabajo

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A6LegNumero = AV10LegNumero ;
      A1319LegTipoTra = "diurno" ;
      /* Using cursor P00FX4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A6LegNumero), A1319LegTipoTra});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Legajotipos_de_trabajo");
      if ( (pr_default.getStatus(2) == 1) )
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
      new web.newlegajo_sueldo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV19LegFecIngreso, AV36LegSueldoFuera.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN), "Bruto") ;
      new web.newlegajo_sueldo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXutil.addyr( AV19LegFecIngreso, (short)(1)), AV36LegSueldoFuera, "Bruto") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV54Pgmname, httpContext.getMessage( "fin", "")) ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newlegajo");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXv_int2 = new short[1] ;
      scmdbuf = "" ;
      P00FX2_A1747EstaCivilPais = new short[1] ;
      P00FX2_A1748EstaCivilCod = new short[1] ;
      AV54Pgmname = "" ;
      A230LegApellido = "" ;
      A251LegNombre = "" ;
      A93LegId = "" ;
      A591LegNomApe = "" ;
      A250LegIdNomApe = "" ;
      A249LegFoto = "" ;
      A257LegNumDoc = "" ;
      A246LegFecNac = GXutil.nullDate() ;
      A242LegDomici = "" ;
      A236LegCodPos = "" ;
      A937LegConveCodigo = "" ;
      A265LegTelefono = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A244LegFecEgreso = GXutil.nullDate() ;
      A1583LegMegCodigo = "" ;
      A939LegCatCodigo = "" ;
      GXv_int5 = new int[1] ;
      A264LegSueldoFuera = DecimalUtil.ZERO ;
      A1579LegSecCodigo = "" ;
      A1581LegLpgCodigo = "" ;
      A2404LegModTra = "" ;
      A1582LegBanCod = "" ;
      A231LegBanSuc = "" ;
      A232LegBanTipCuen = "" ;
      A910LegSinCod = "" ;
      A1580LegOsoCod = "" ;
      A15LegActCodigo = "" ;
      A18MprCod = "" ;
      GXt_char3 = "" ;
      GXt_char6 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char7 = new String[1] ;
      A247LegFecUltMod = GXutil.nullDate() ;
      A238LegCuentaBanc = "" ;
      A253LegLicInicio = GXutil.nullDate() ;
      A252LegLicFinal = GXutil.nullDate() ;
      A20ZonCod = "" ;
      A234LegCBU = "" ;
      A19SinieCodigo = "" ;
      A879LegContinua = "" ;
      A1031LegFotoExt = "" ;
      A1030LegFotoNom = "" ;
      AV47LegTipoTra = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44LegHorasSem = DecimalUtil.ZERO ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      A1268LegHorasSem = DecimalUtil.ZERO ;
      A1235LegReligion = "" ;
      A1236LegOrigen = "" ;
      A1578LegPuesCodigo = "" ;
      A1577LegSucCodigo = "" ;
      A1531LegFecPreAviso = GXutil.nullDate() ;
      A479LegEmail = "" ;
      A515LegObs = "" ;
      A630LegFecImportacion = GXutil.resetTime( GXutil.nullDate() );
      A1023LegHorasDia = DecimalUtil.ZERO ;
      A1759LegPromDias = "" ;
      A1804LegTitulo = "" ;
      Gx_emsg = "" ;
      A1319LegTipoTra = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newlegajo__default(),
         new Object[] {
             new Object[] {
            P00FX2_A1747EstaCivilPais, P00FX2_A1748EstaCivilCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV54Pgmname = "newLegajo" ;
      /* GeneXus formulas. */
      AV54Pgmname = "newLegajo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV41LegSexo ;
   private byte AV23LegClase ;
   private byte AV24LegFormaPago ;
   private byte A1818LegEstado ;
   private byte A266LegTipDoc ;
   private byte A263LegSexo ;
   private byte A241LegDiscapacidad ;
   private byte A235LegClase ;
   private byte A248LegFormaPago ;
   private short AV9EmpCod ;
   private short AV33CondiCodigo ;
   private short AV50PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1747EstaCivilPais ;
   private short A1748EstaCivilCod ;
   private short AV49LegEstadoCivil ;
   private short A1EmpCod ;
   private short A243LegEstadoCivil ;
   private short A21LegNacionCod ;
   private short A22LegPaiCod ;
   private short A23LegProvCod ;
   private short A24LegLocCod ;
   private short A17CondiCodigo ;
   private short A1603LegSitRevEgreso ;
   private short A1523LegVacPend ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LegNumero ;
   private int GX_INS23 ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int AV48LegConveVersionCli ;
   private int GXv_int5[] ;
   private int A1576LegConveVersionCli ;
   private int GX_INS170 ;
   private long AV16LegCUIL ;
   private long A239LegCUIL ;
   private java.math.BigDecimal AV36LegSueldoFuera ;
   private java.math.BigDecimal A264LegSueldoFuera ;
   private java.math.BigDecimal AV44LegHorasSem ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private java.math.BigDecimal A1268LegHorasSem ;
   private java.math.BigDecimal A1023LegHorasDia ;
   private String AV13LegId ;
   private String AV20CatCodigo ;
   private String AV21SecCodigo ;
   private String AV22LpgCodigo ;
   private String AV25BanCod ;
   private String AV27SinCod ;
   private String AV28OsoCod ;
   private String AV29PmedCod ;
   private String AV30LegActCodigo ;
   private String AV31ZonCod ;
   private String AV32SitCodigo ;
   private String AV34SinieCodigo ;
   private String AV35ConveCodigo ;
   private String AV43LegFotoExt ;
   private String scmdbuf ;
   private String AV54Pgmname ;
   private String A93LegId ;
   private String A236LegCodPos ;
   private String A937LegConveCodigo ;
   private String A1583LegMegCodigo ;
   private String A939LegCatCodigo ;
   private String A1579LegSecCodigo ;
   private String A1581LegLpgCodigo ;
   private String A2404LegModTra ;
   private String A1582LegBanCod ;
   private String A232LegBanTipCuen ;
   private String A910LegSinCod ;
   private String A1580LegOsoCod ;
   private String A15LegActCodigo ;
   private String A18MprCod ;
   private String GXt_char3 ;
   private String GXt_char6 ;
   private String GXv_char4[] ;
   private String GXv_char7[] ;
   private String A20ZonCod ;
   private String A19SinieCodigo ;
   private String A879LegContinua ;
   private String A1031LegFotoExt ;
   private String A1235LegReligion ;
   private String A1236LegOrigen ;
   private String A1578LegPuesCodigo ;
   private String A1577LegSucCodigo ;
   private String A1804LegTitulo ;
   private String Gx_emsg ;
   private String A1319LegTipoTra ;
   private java.util.Date A630LegFecImportacion ;
   private java.util.Date AV15LegFecNac ;
   private java.util.Date AV19LegFecIngreso ;
   private java.util.Date AV40LegFecEgreso ;
   private java.util.Date A246LegFecNac ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date A244LegFecEgreso ;
   private java.util.Date A247LegFecUltMod ;
   private java.util.Date A253LegLicInicio ;
   private java.util.Date A252LegLicFinal ;
   private java.util.Date A1531LegFecPreAviso ;
   private boolean AV39LegAgenReten ;
   private boolean n93LegId ;
   private boolean n249LegFoto ;
   private boolean n263LegSexo ;
   private boolean n243LegEstadoCivil ;
   private boolean n21LegNacionCod ;
   private boolean n22LegPaiCod ;
   private boolean n23LegProvCod ;
   private boolean n24LegLocCod ;
   private boolean n937LegConveCodigo ;
   private boolean n265LegTelefono ;
   private boolean n244LegFecEgreso ;
   private boolean n1583LegMegCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n1576LegConveVersionCli ;
   private boolean n1579LegSecCodigo ;
   private boolean n1581LegLpgCodigo ;
   private boolean n1582LegBanCod ;
   private boolean n231LegBanSuc ;
   private boolean n232LegBanTipCuen ;
   private boolean n910LegSinCod ;
   private boolean n1580LegOsoCod ;
   private boolean n15LegActCodigo ;
   private boolean n18MprCod ;
   private boolean n238LegCuentaBanc ;
   private boolean n253LegLicInicio ;
   private boolean n252LegLicFinal ;
   private boolean n20ZonCod ;
   private boolean n234LegCBU ;
   private boolean A237LegConvenio ;
   private boolean A262LegSCVO ;
   private boolean n17CondiCodigo ;
   private boolean n19SinieCodigo ;
   private boolean n1603LegSitRevEgreso ;
   private boolean A877LegAgenReten ;
   private boolean n1235LegReligion ;
   private boolean n1236LegOrigen ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1577LegSucCodigo ;
   private boolean A1251LegTrabDo ;
   private boolean A1248LegTrabJue ;
   private boolean A1245LegTrabLun ;
   private boolean A1246LegTrabMar ;
   private boolean A1247LegTrabMie ;
   private boolean A1250LegTrabSa ;
   private boolean A1249LegTrabVie ;
   private boolean A228LegActivo ;
   private boolean A942LegRecalcLiq ;
   private boolean A1016LegJubilado ;
   private String A515LegObs ;
   private String A249LegFoto ;
   private String AV11LegApellido ;
   private String AV12LegNombre ;
   private String AV14LegNumDoc ;
   private String AV17LegDomici ;
   private String AV26LegBanSuc ;
   private String AV37LegCBU ;
   private String AV38UriFoto ;
   private String AV42LegFotoNom ;
   private String A230LegApellido ;
   private String A251LegNombre ;
   private String A591LegNomApe ;
   private String A250LegIdNomApe ;
   private String A257LegNumDoc ;
   private String A242LegDomici ;
   private String A265LegTelefono ;
   private String A231LegBanSuc ;
   private String A238LegCuentaBanc ;
   private String A234LegCBU ;
   private String A1030LegFotoNom ;
   private String A479LegEmail ;
   private String A1759LegPromDias ;
   private IDataStoreProvider pr_default ;
   private short[] P00FX2_A1747EstaCivilPais ;
   private short[] P00FX2_A1748EstaCivilCod ;
   private GXSimpleCollection<String> AV47LegTipoTra ;
}

final  class newlegajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00FX2", "SELECT EstaCivilPais, EstaCivilCod FROM Estados_civiles WHERE EstaCivilPais = ? ORDER BY EstaCivilPais  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00FX3", "SAVEPOINT gxupdate;INSERT INTO Legajo(CliCod, EmpCod, LegNumero, LegApellido, LegNombre, LegFoto, LegTipDoc, LegNumDoc, LegFecNac, LegSexo, LegEstadoCivil, LegNacionCod, LegCUIL, LegDiscapacidad, LegDomici, LegEmail, LegCodPos, LegPaiCod, LegProvCod, LegLocCod, LegTelefono, LegFecIngreso, LegFecEgreso, LegClase, LegFormaPago, LegBanSuc, LegBanTipCuen, LegActCodigo, MprCod, LegFecUltMod, LegCuentaBanc, LegLicInicio, LegLicFinal, ZonCod, LegCBU, LegConvenio, LegSCVO, CondiCodigo, SinieCodigo, LegActivo, LegSueldoFuera, LegId, LegIdNomApe, LegObs, LegNomApe, LegFecImportacion, LegAgenReten, LegContinua, LegSinCod, LegConveCodigo, LegCatCodigo, LegRecalcLiq, LegJubilado, LegHorasDia, LegFotoNom, LegFotoExt, LegReligion, LegOrigen, LegTrabLun, LegTrabMar, LegTrabMie, LegTrabJue, LegTrabVie, LegTrabSa, LegTrabDo, LegHorasSem, LegVacPend, LegFecPreAviso, LegConveVersionCli, LegLpgCodigo, LegBanCod, LegOsoCod, LegPuesCodigo, LegSucCodigo, LegSecCodigo, LegMegCodigo, LegSitRevEgreso, LegPromDias, LegTitulo, LegEstado, LegModTra, LegCatPueCod, LegActClasNro, LegPueAfiCod, LegMigrWarn, LegIncompleto, LegLiqApo, LegTipoTarifa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0, '', '', FALSE, FALSE, '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00FX4", "SAVEPOINT gxupdate;INSERT INTO Legajotipos_de_trabajo(CliCod, EmpCod, LegNumero, LegTipoTra) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 30, false);
               stmt.setVarchar(5, (String)parms[4], 30, false);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.LONGVARBINARY );
               }
               else
               {
                  stmt.setBLOBFile(6, (String)parms[6]);
               }
               stmt.setByte(7, ((Number) parms[7]).byteValue());
               stmt.setVarchar(8, (String)parms[8], 20, false);
               stmt.setDate(9, (java.util.Date)parms[9]);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(10, ((Number) parms[11]).byteValue());
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[13]).shortValue());
               }
               if ( ((Boolean) parms[14]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(12, ((Number) parms[15]).shortValue());
               }
               stmt.setLong(13, ((Number) parms[16]).longValue());
               stmt.setByte(14, ((Number) parms[17]).byteValue());
               stmt.setVarchar(15, (String)parms[18], 4000, false);
               stmt.setVarchar(16, (String)parms[19], 100, false);
               stmt.setString(17, (String)parms[20], 20);
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 18 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(18, ((Number) parms[22]).shortValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 19 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(19, ((Number) parms[24]).shortValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 20 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(20, ((Number) parms[26]).shortValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 21 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(21, (String)parms[28], 30);
               }
               stmt.setDate(22, (java.util.Date)parms[29]);
               if ( ((Boolean) parms[30]).booleanValue() )
               {
                  stmt.setNull( 23 , Types.DATE );
               }
               else
               {
                  stmt.setDate(23, (java.util.Date)parms[31]);
               }
               stmt.setByte(24, ((Number) parms[32]).byteValue());
               stmt.setByte(25, ((Number) parms[33]).byteValue());
               if ( ((Boolean) parms[34]).booleanValue() )
               {
                  stmt.setNull( 26 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(26, (String)parms[35], 30);
               }
               if ( ((Boolean) parms[36]).booleanValue() )
               {
                  stmt.setNull( 27 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(27, (String)parms[37], 20);
               }
               if ( ((Boolean) parms[38]).booleanValue() )
               {
                  stmt.setNull( 28 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(28, (String)parms[39], 8);
               }
               if ( ((Boolean) parms[40]).booleanValue() )
               {
                  stmt.setNull( 29 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(29, (String)parms[41], 20);
               }
               stmt.setDate(30, (java.util.Date)parms[42]);
               if ( ((Boolean) parms[43]).booleanValue() )
               {
                  stmt.setNull( 31 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(31, (String)parms[44], 20);
               }
               if ( ((Boolean) parms[45]).booleanValue() )
               {
                  stmt.setNull( 32 , Types.DATE );
               }
               else
               {
                  stmt.setDate(32, (java.util.Date)parms[46]);
               }
               if ( ((Boolean) parms[47]).booleanValue() )
               {
                  stmt.setNull( 33 , Types.DATE );
               }
               else
               {
                  stmt.setDate(33, (java.util.Date)parms[48]);
               }
               if ( ((Boolean) parms[49]).booleanValue() )
               {
                  stmt.setNull( 34 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(34, (String)parms[50], 20);
               }
               if ( ((Boolean) parms[51]).booleanValue() )
               {
                  stmt.setNull( 35 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(35, (String)parms[52], 22);
               }
               stmt.setBoolean(36, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(37, ((Boolean) parms[54]).booleanValue());
               if ( ((Boolean) parms[55]).booleanValue() )
               {
                  stmt.setNull( 38 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(38, ((Number) parms[56]).shortValue());
               }
               if ( ((Boolean) parms[57]).booleanValue() )
               {
                  stmt.setNull( 39 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(39, (String)parms[58], 4);
               }
               stmt.setBoolean(40, ((Boolean) parms[59]).booleanValue());
               stmt.setBigDecimal(41, (java.math.BigDecimal)parms[60], 2);
               if ( ((Boolean) parms[61]).booleanValue() )
               {
                  stmt.setNull( 42 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(42, (String)parms[62], 20);
               }
               stmt.setVarchar(43, (String)parms[63], 100, false);
               stmt.setNLongVarchar(44, (String)parms[64], false);
               stmt.setVarchar(45, (String)parms[65], 100, false);
               stmt.setDateTime(46, (java.util.Date)parms[66], false);
               stmt.setBoolean(47, ((Boolean) parms[67]).booleanValue());
               stmt.setString(48, (String)parms[68], 2);
               if ( ((Boolean) parms[69]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(49, (String)parms[70], 20);
               }
               if ( ((Boolean) parms[71]).booleanValue() )
               {
                  stmt.setNull( 50 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(50, (String)parms[72], 20);
               }
               if ( ((Boolean) parms[73]).booleanValue() )
               {
                  stmt.setNull( 51 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(51, (String)parms[74], 40);
               }
               stmt.setBoolean(52, ((Boolean) parms[75]).booleanValue());
               stmt.setBoolean(53, ((Boolean) parms[76]).booleanValue());
               stmt.setBigDecimal(54, (java.math.BigDecimal)parms[77], 1);
               stmt.setVarchar(55, (String)parms[78], 1000, false);
               stmt.setString(56, (String)parms[79], 20);
               if ( ((Boolean) parms[80]).booleanValue() )
               {
                  stmt.setNull( 57 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(57, (String)parms[81], 20);
               }
               if ( ((Boolean) parms[82]).booleanValue() )
               {
                  stmt.setNull( 58 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(58, (String)parms[83], 20);
               }
               stmt.setBoolean(59, ((Boolean) parms[84]).booleanValue());
               stmt.setBoolean(60, ((Boolean) parms[85]).booleanValue());
               stmt.setBoolean(61, ((Boolean) parms[86]).booleanValue());
               stmt.setBoolean(62, ((Boolean) parms[87]).booleanValue());
               stmt.setBoolean(63, ((Boolean) parms[88]).booleanValue());
               stmt.setBoolean(64, ((Boolean) parms[89]).booleanValue());
               stmt.setBoolean(65, ((Boolean) parms[90]).booleanValue());
               stmt.setBigDecimal(66, (java.math.BigDecimal)parms[91], 1);
               stmt.setShort(67, ((Number) parms[92]).shortValue());
               stmt.setDate(68, (java.util.Date)parms[93]);
               if ( ((Boolean) parms[94]).booleanValue() )
               {
                  stmt.setNull( 69 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(69, ((Number) parms[95]).intValue());
               }
               if ( ((Boolean) parms[96]).booleanValue() )
               {
                  stmt.setNull( 70 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(70, (String)parms[97], 20);
               }
               if ( ((Boolean) parms[98]).booleanValue() )
               {
                  stmt.setNull( 71 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(71, (String)parms[99], 6);
               }
               if ( ((Boolean) parms[100]).booleanValue() )
               {
                  stmt.setNull( 72 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(72, (String)parms[101], 20);
               }
               if ( ((Boolean) parms[102]).booleanValue() )
               {
                  stmt.setNull( 73 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(73, (String)parms[103], 20);
               }
               if ( ((Boolean) parms[104]).booleanValue() )
               {
                  stmt.setNull( 74 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(74, (String)parms[105], 20);
               }
               if ( ((Boolean) parms[106]).booleanValue() )
               {
                  stmt.setNull( 75 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(75, (String)parms[107], 20);
               }
               if ( ((Boolean) parms[108]).booleanValue() )
               {
                  stmt.setNull( 76 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(76, (String)parms[109], 20);
               }
               if ( ((Boolean) parms[110]).booleanValue() )
               {
                  stmt.setNull( 77 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(77, ((Number) parms[111]).shortValue());
               }
               stmt.setVarchar(78, (String)parms[112], 4000, false);
               stmt.setString(79, (String)parms[113], 20);
               stmt.setByte(80, ((Number) parms[114]).byteValue());
               stmt.setString(81, (String)parms[115], 1);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

