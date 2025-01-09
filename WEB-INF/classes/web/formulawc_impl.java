package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class formulawc_impl extends GXDataArea
{
   public formulawc_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public formulawc_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( formulawc_impl.class ));
   }

   public formulawc_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbavConrelsec = new HTMLChoice();
      dynavLegnumero = new HTMLChoice();
      dynavLiqnro = new HTMLChoice();
      cmbavIdoperando = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vLEGNUMERO") == 0 )
         {
            AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
            AV16EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvlegnumero7D2( AV6CliCod, AV16EmpCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"vLIQNRO") == 0 )
         {
            AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
            AV16EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxdlvvliqnro7D2( AV6CliCod, AV16EmpCod) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "MenuOpcCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdt_conceptoss") == 0 )
         {
            gxnrgridsdt_conceptoss_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdt_conceptoss") == 0 )
         {
            gxgrgridsdt_conceptoss_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsdt_conceptoss2") == 0 )
         {
            gxnrgridsdt_conceptoss2_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsdt_conceptoss2") == 0 )
         {
            gxgrgridsdt_conceptoss2_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            gxnrgrid1_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
         {
            gxgrgrid1_refresh_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridsnippets") == 0 )
         {
            gxnrgridsnippets_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Gridsnippets") == 0 )
         {
            gxgrgridsnippets_refresh_invoke( ) ;
            return  ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            AV147MenuOpcCod = gxfirstwebparm ;
            httpContext.ajax_rsp_assign_attri("", false, "AV147MenuOpcCod", AV147MenuOpcCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV147MenuOpcCod, ""))));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV10ConCodigo = httpContext.GetPar( "ConCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV10ConCodigo", AV10ConCodigo);
               AV115parmLiqNro = (int)(GXutil.lval( httpContext.GetPar( "parmLiqNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV115parmLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV115parmLiqNro), 8, 0));
               AV114parmLegNumero = (int)(GXutil.lval( httpContext.GetPar( "parmLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV114parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV114parmLegNumero), 8, 0));
               AV83llamador = httpContext.GetPar( "llamador") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV83llamador", AV83llamador);
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridsdt_conceptoss_newrow_invoke( )
   {
      nRC_GXsfl_106 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_106"))) ;
      nGXsfl_106_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_106_idx"))) ;
      sGXsfl_106_idx = httpContext.GetPar( "sGXsfl_106_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsdt_conceptoss_newrow( ) ;
      /* End function gxnrGridsdt_conceptoss_newrow_invoke */
   }

   public void gxgrgridsdt_conceptoss_refresh_invoke( )
   {
      subGridsdt_conceptoss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss_Rows"))) ;
      subGridsdt_conceptoss2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss2_Rows"))) ;
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      subGridsnippets_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsnippets_Rows"))) ;
      AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV8Concepto = httpContext.GetPar( "Concepto") ;
      AV161Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66sdt_conceptos);
      AV98PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV134LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      AV139date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      AV138clienteNucleoPais_CliCod = (int)(GXutil.lval( httpContext.GetPar( "clienteNucleoPais_CliCod"))) ;
      AV142ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV17esConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esConceptosDefault")) ;
      AV147MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsdt_conceptoss_refresh_invoke */
   }

   public void gxnrgridsdt_conceptoss2_newrow_invoke( )
   {
      nRC_GXsfl_115 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_115"))) ;
      nGXsfl_115_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_115_idx"))) ;
      sGXsfl_115_idx = httpContext.GetPar( "sGXsfl_115_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsdt_conceptoss2_newrow( ) ;
      /* End function gxnrGridsdt_conceptoss2_newrow_invoke */
   }

   public void gxgrgridsdt_conceptoss2_refresh_invoke( )
   {
      subGridsdt_conceptoss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss_Rows"))) ;
      subGridsdt_conceptoss2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss2_Rows"))) ;
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      subGridsnippets_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsnippets_Rows"))) ;
      AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV8Concepto = httpContext.GetPar( "Concepto") ;
      AV161Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV84sdt_conceptos2);
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66sdt_conceptos);
      AV98PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV134LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      AV139date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      AV138clienteNucleoPais_CliCod = (int)(GXutil.lval( httpContext.GetPar( "clienteNucleoPais_CliCod"))) ;
      AV142ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV17esConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esConceptosDefault")) ;
      AV147MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsdt_conceptoss2_refresh_invoke */
   }

   public void gxnrgrid1_newrow_invoke( )
   {
      nRC_GXsfl_131 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_131"))) ;
      nGXsfl_131_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_131_idx"))) ;
      sGXsfl_131_idx = httpContext.GetPar( "sGXsfl_131_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid1_newrow( ) ;
      /* End function gxnrGrid1_newrow_invoke */
   }

   public void gxgrgrid1_refresh_invoke( )
   {
      subGridsdt_conceptoss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss_Rows"))) ;
      subGridsdt_conceptoss2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss2_Rows"))) ;
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      subGridsnippets_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsnippets_Rows"))) ;
      AV10ConCodigo = httpContext.GetPar( "ConCodigo") ;
      AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV8Concepto = httpContext.GetPar( "Concepto") ;
      AV161Pgmname = httpContext.GetPar( "Pgmname") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66sdt_conceptos);
      AV98PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV134LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      AV139date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      AV138clienteNucleoPais_CliCod = (int)(GXutil.lval( httpContext.GetPar( "clienteNucleoPais_CliCod"))) ;
      AV142ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV17esConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esConceptosDefault")) ;
      AV147MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid1_refresh_invoke */
   }

   public void gxnrgridsnippets_newrow_invoke( )
   {
      nRC_GXsfl_159 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_159"))) ;
      nGXsfl_159_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_159_idx"))) ;
      sGXsfl_159_idx = httpContext.GetPar( "sGXsfl_159_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridsnippets_newrow( ) ;
      /* End function gxnrGridsnippets_newrow_invoke */
   }

   public void gxgrgridsnippets_refresh_invoke( )
   {
      subGridsdt_conceptoss_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss_Rows"))) ;
      subGridsdt_conceptoss2_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsdt_conceptoss2_Rows"))) ;
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      subGridsnippets_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGridsnippets_Rows"))) ;
      AV6CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV8Concepto = httpContext.GetPar( "Concepto") ;
      AV161Pgmname = httpContext.GetPar( "Pgmname") ;
      dynavLiqnro.fromJSonString( httpContext.GetNextPar( ));
      AV51LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      AV16EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      A82OpeCliId = httpContext.GetPar( "OpeCliId") ;
      A534OpeCliDescrip = httpContext.GetPar( "OpeCliDescrip") ;
      AV89searchSnippets = httpContext.GetPar( "searchSnippets") ;
      A549OpeCliCodFormula = httpContext.GetPar( "OpeCliCodFormula") ;
      AV61num = (short)(GXutil.lval( httpContext.GetPar( "num"))) ;
      A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      AV98PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
      A473OpeCodFormula = httpContext.GetPar( "OpeCodFormula") ;
      A474OpeDescripcion = httpContext.GetPar( "OpeDescripcion") ;
      A74idOperando = httpContext.GetPar( "idOperando") ;
      dynavLegnumero.fromJSonString( httpContext.GetNextPar( ));
      AV48LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
      AV134LiqPeriodo = localUtil.parseDateParm( httpContext.GetPar( "LiqPeriodo")) ;
      AV10ConCodigo = httpContext.GetPar( "ConCodigo") ;
      AV139date = localUtil.parseDateParm( httpContext.GetPar( "date")) ;
      AV138clienteNucleoPais_CliCod = (int)(GXutil.lval( httpContext.GetPar( "clienteNucleoPais_CliCod"))) ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV66sdt_conceptos);
      AV142ClienteConveniador = GXutil.strtobool( httpContext.GetPar( "ClienteConveniador")) ;
      AV17esConceptosDefault = GXutil.strtobool( httpContext.GetPar( "esConceptosDefault")) ;
      AV147MenuOpcCod = httpContext.GetPar( "MenuOpcCod") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGridsnippets_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa7D2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start7D2( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LMonacoEditor2Render.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.formulawc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV147MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV10ConCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV115parmLiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV114parmLegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV83llamador))}, new String[] {"MenuOpcCod","ConCodigo","parmLiqNro","parmLegNumero","llamador"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV134LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV139date));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTENUCLEOPAIS_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV138clienteNucleoPais_CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_CONCEPTOS", getSecureSignedToken( "", AV66sdt_conceptos));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV142ClienteConveniador));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESCONCEPTOSDEFAULT", getSecureSignedToken( "", AV17esConceptosDefault));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV147MenuOpcCod, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdt_conceptos", AV66sdt_conceptos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdt_conceptos", AV66sdt_conceptos);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Sdt_conceptos", getSecureSignedToken( "", AV66sdt_conceptos));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "Sdt_conceptos2", AV84sdt_conceptos2);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("Sdt_conceptos2", AV84sdt_conceptos2);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_106", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_106, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_115", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_115, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_131", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_131, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_159", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_159, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONCEPTO_DATA", AV9Concepto_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONCEPTO_DATA", AV9Concepto_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDSNIPPETSPAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV96GridSnippetsPageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGRIDSNIPPETSAPPLIEDFILTERS", AV97GridSnippetsAppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV161Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIID", GXutil.rtrim( A82OpeCliId));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLIDESCRIP", A534OpeCliDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "OPECLICODFORMULA", GXutil.rtrim( A549OpeCliCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV98PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECODFORMULA", GXutil.rtrim( A473OpeCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "OPEDESCRIPCION", A474OpeDescripcion);
      web.GxWebStd.gx_hidden_field( httpContext, "IDOPERANDO", GXutil.rtrim( A74idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQPERIODO", localUtil.dtoc( AV134LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV134LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONCODIGO", GXutil.rtrim( AV10ConCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV139date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV139date));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIENTENUCLEOPAIS_CLICOD", GXutil.ltrim( localUtil.ntoc( AV138clienteNucleoPais_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTENUCLEOPAIS_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV138clienteNucleoPais_CliCod), "ZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_CONCEPTOS2", AV84sdt_conceptos2);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_CONCEPTOS2", AV84sdt_conceptos2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_CONCEPTOS", AV66sdt_conceptos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_CONCEPTOS", AV66sdt_conceptos);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_CONCEPTOS", getSecureSignedToken( "", AV66sdt_conceptos));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vFORMOK", AV19FormOK);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV142ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV142ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESCONCEPTOSDEFAULT", AV17esConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESCONCEPTOSDEFAULT", getSecureSignedToken( "", AV17esConceptosDefault));
      web.GxWebStd.gx_hidden_field( httpContext, "vPARMLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV114parmLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMENUOPCCOD", AV147MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV147MenuOpcCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPARMLIQNRO", GXutil.ltrim( localUtil.ntoc( AV115parmLiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vSTART", AV78start);
      web.GxWebStd.gx_hidden_field( httpContext, "vLLAMADOR", GXutil.rtrim( AV83llamador));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCEPTO_Cls", GXutil.rtrim( Combo_concepto_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCEPTO_Selectedvalue_set", GXutil.rtrim( Combo_concepto_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCEPTO_Emptyitem", GXutil.booltostr( Combo_concepto_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_editor_id", GXutil.rtrim( Monacoeditor1_Monaco_editor_id));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Nombrelenguaje", GXutil.rtrim( Monacoeditor1_Nombrelenguaje));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_brackets", GXutil.rtrim( Monacoeditor1_Monaco_brackets));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_tokens", GXutil.rtrim( Monacoeditor1_Monaco_tokens));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_tokens_style", GXutil.rtrim( Monacoeditor1_Monaco_tokens_style));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_foreground", GXutil.rtrim( Monacoeditor1_Monaco_foreground));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_url_sug", GXutil.rtrim( Monacoeditor1_Monaco_url_sug));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Valorinicial", GXutil.rtrim( Monacoeditor1_Valorinicial));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_linenumbers", GXutil.rtrim( Monacoeditor1_Monaco_linenumbers));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_wordwrap", GXutil.rtrim( Monacoeditor1_Monaco_wordwrap));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_columns", GXutil.rtrim( Monacoeditor1_Monaco_columns));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_readonly", GXutil.rtrim( Monacoeditor1_Monaco_readonly));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Monaco_minimap", GXutil.rtrim( Monacoeditor1_Monaco_minimap));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Variable_asociada", GXutil.rtrim( Monacoeditor1_Variable_asociada));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Permitidos", GXutil.rtrim( Monacoeditor1_Permitidos));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Palabra_concepto", GXutil.rtrim( Monacoeditor1_Palabra_concepto));
      web.GxWebStd.gx_hidden_field( httpContext, "MONACOEDITOR1_Url_sug_querystring", GXutil.rtrim( Monacoeditor1_Url_sug_querystring));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Width", GXutil.rtrim( Dvpanel_explpanel_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Autowidth", GXutil.booltostr( Dvpanel_explpanel_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Autoheight", GXutil.booltostr( Dvpanel_explpanel_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Cls", GXutil.rtrim( Dvpanel_explpanel_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Title", GXutil.rtrim( Dvpanel_explpanel_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Collapsible", GXutil.booltostr( Dvpanel_explpanel_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Collapsed", GXutil.booltostr( Dvpanel_explpanel_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Showcollapseicon", GXutil.booltostr( Dvpanel_explpanel_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Iconposition", GXutil.rtrim( Dvpanel_explpanel_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_EXPLPANEL_Autoscroll", GXutil.booltostr( Dvpanel_explpanel_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Width", GXutil.rtrim( Dvpanel_panelprobar_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Autowidth", GXutil.booltostr( Dvpanel_panelprobar_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Autoheight", GXutil.booltostr( Dvpanel_panelprobar_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Cls", GXutil.rtrim( Dvpanel_panelprobar_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Title", GXutil.rtrim( Dvpanel_panelprobar_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Collapsible", GXutil.booltostr( Dvpanel_panelprobar_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Collapsed", GXutil.booltostr( Dvpanel_panelprobar_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Showcollapseicon", GXutil.booltostr( Dvpanel_panelprobar_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Iconposition", GXutil.rtrim( Dvpanel_panelprobar_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELPROBAR_Autoscroll", GXutil.booltostr( Dvpanel_panelprobar_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Width", GXutil.rtrim( Dvpanel_panelseusa_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Autowidth", GXutil.booltostr( Dvpanel_panelseusa_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Autoheight", GXutil.booltostr( Dvpanel_panelseusa_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Cls", GXutil.rtrim( Dvpanel_panelseusa_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Title", GXutil.rtrim( Dvpanel_panelseusa_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Collapsible", GXutil.booltostr( Dvpanel_panelseusa_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Collapsed", GXutil.booltostr( Dvpanel_panelseusa_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Showcollapseicon", GXutil.booltostr( Dvpanel_panelseusa_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Iconposition", GXutil.rtrim( Dvpanel_panelseusa_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELSEUSA_Autoscroll", GXutil.booltostr( Dvpanel_panelseusa_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Width", GXutil.rtrim( Dvpanel_panelusa_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Autowidth", GXutil.booltostr( Dvpanel_panelusa_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Autoheight", GXutil.booltostr( Dvpanel_panelusa_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Cls", GXutil.rtrim( Dvpanel_panelusa_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Title", GXutil.rtrim( Dvpanel_panelusa_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Collapsible", GXutil.booltostr( Dvpanel_panelusa_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Collapsed", GXutil.booltostr( Dvpanel_panelusa_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Showcollapseicon", GXutil.booltostr( Dvpanel_panelusa_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Iconposition", GXutil.rtrim( Dvpanel_panelusa_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSA_Autoscroll", GXutil.booltostr( Dvpanel_panelusa_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Width", GXutil.rtrim( Dvpanel_paneluso_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Autowidth", GXutil.booltostr( Dvpanel_paneluso_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Autoheight", GXutil.booltostr( Dvpanel_paneluso_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Cls", GXutil.rtrim( Dvpanel_paneluso_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Title", GXutil.rtrim( Dvpanel_paneluso_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Collapsible", GXutil.booltostr( Dvpanel_paneluso_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Collapsed", GXutil.booltostr( Dvpanel_paneluso_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Showcollapseicon", GXutil.booltostr( Dvpanel_paneluso_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Iconposition", GXutil.rtrim( Dvpanel_paneluso_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELUSO_Autoscroll", GXutil.booltostr( Dvpanel_paneluso_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Width", GXutil.rtrim( Dvpanel_panelhis_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Autowidth", GXutil.booltostr( Dvpanel_panelhis_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Autoheight", GXutil.booltostr( Dvpanel_panelhis_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Cls", GXutil.rtrim( Dvpanel_panelhis_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Title", GXutil.rtrim( Dvpanel_panelhis_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Collapsible", GXutil.booltostr( Dvpanel_panelhis_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Collapsed", GXutil.booltostr( Dvpanel_panelhis_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelhis_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Iconposition", GXutil.rtrim( Dvpanel_panelhis_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELHIS_Autoscroll", GXutil.booltostr( Dvpanel_panelhis_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Class", GXutil.rtrim( Gridsnippetspaginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Showfirst", GXutil.booltostr( Gridsnippetspaginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Showprevious", GXutil.booltostr( Gridsnippetspaginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Shownext", GXutil.booltostr( Gridsnippetspaginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Showlast", GXutil.booltostr( Gridsnippetspaginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Gridsnippetspaginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Gridsnippetspaginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Gridsnippetspaginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Emptygridclass", GXutil.rtrim( Gridsnippetspaginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Gridsnippetspaginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsnippetspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Gridsnippetspaginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Previous", GXutil.rtrim( Gridsnippetspaginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Next", GXutil.rtrim( Gridsnippetspaginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Caption", GXutil.rtrim( Gridsnippetspaginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Gridsnippetspaginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Gridsnippetspaginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Width", GXutil.rtrim( Dvpanel_panelcodgos_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Autowidth", GXutil.booltostr( Dvpanel_panelcodgos_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Autoheight", GXutil.booltostr( Dvpanel_panelcodgos_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Cls", GXutil.rtrim( Dvpanel_panelcodgos_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Title", GXutil.rtrim( Dvpanel_panelcodgos_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Collapsible", GXutil.booltostr( Dvpanel_panelcodgos_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Collapsed", GXutil.booltostr( Dvpanel_panelcodgos_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Showcollapseicon", GXutil.booltostr( Dvpanel_panelcodgos_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Iconposition", GXutil.rtrim( Dvpanel_panelcodgos_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_PANELCODGOS_Autoscroll", GXutil.booltostr( Dvpanel_panelcodgos_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOEXPL_Iteminternalname", GXutil.rtrim( Popover_iconoexpl_Iteminternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOEXPL_Triggerelement", GXutil.rtrim( Popover_iconoexpl_Triggerelement));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOEXPL_Popoverwidth", GXutil.ltrim( localUtil.ntoc( Popover_iconoexpl_Popoverwidth, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOEXPL_Html", GXutil.rtrim( Popover_iconoexpl_Html));
      web.GxWebStd.gx_hidden_field( httpContext, "POPOVER_ICONOEXPL_Position", GXutil.rtrim( Popover_iconoexpl_Position));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsnippets_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid1_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_EMPOWERER_Infinitescrolling", GXutil.rtrim( Grid1_empowerer_Infinitescrolling));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdt_conceptoss2_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_EMPOWERER_Gridinternalname", GXutil.rtrim( Gridsdt_conceptoss_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsnippetspaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsnippetspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONCEPTO_Selectedvalue_get", GXutil.rtrim( Combo_concepto_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Selectedpage", GXutil.rtrim( Gridsnippetspaginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Gridsnippetspaginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we7D2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt7D2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.formulawc", new String[] {GXutil.URLEncode(GXutil.rtrim(AV147MenuOpcCod)),GXutil.URLEncode(GXutil.rtrim(AV10ConCodigo)),GXutil.URLEncode(GXutil.ltrimstr(AV115parmLiqNro,8,0)),GXutil.URLEncode(GXutil.ltrimstr(AV114parmLegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(AV83llamador))}, new String[] {"MenuOpcCod","ConCodigo","parmLiqNro","parmLegNumero","llamador"})  ;
   }

   public String getPgmname( )
   {
      return "FormulaWC" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Editar Fórmula", "") ;
   }

   public void wb7D0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
         wb_table1_9_7D2( true) ;
      }
      else
      {
         wb_table1_9_7D2( false) ;
      }
      return  ;
   }

   public void wb_table1_9_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 176,'',false,'',0)\"" ;
         ClassString = "ButtonColorFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnconfirmar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 106, 3, 0)+","+"null"+");", httpContext.getMessage( "Guardar Cambios", ""), bttBtnconfirmar_Jsonclick, 5, httpContext.getMessage( "Guardar Cambios", ""), "", StyleString, ClassString, bttBtnconfirmar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOCONFIRMAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 178,'',false,'',0)\"" ;
         ClassString = "ButtonColorNotFilled" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtncancelar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 106, 3, 0)+","+"null"+");", httpContext.getMessage( "Cancelar", ""), bttBtncancelar_Jsonclick, 7, httpContext.getMessage( "Cancelar", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e117d1_client"+"'", TempTags, "", 2, "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblJs_Internalname, lblJs_Caption, "", "", lblJs_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", edtavAcopiar_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavAcopiar_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavAcopiar_Internalname, httpContext.getMessage( "aCopiar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 186,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavAcopiar_Internalname, GXutil.rtrim( AV5aCopiar), GXutil.rtrim( localUtil.format( AV5aCopiar, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,186);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavAcopiar_Jsonclick, 0, "Attribute", "", "", "", "", edtavAcopiar_Visible, edtavAcopiar_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "palabra", "left", true, "", "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblJs2_Internalname, " ", "", "", lblJs2_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(1), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 193,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavConcepto_Internalname, GXutil.rtrim( AV8Concepto), GXutil.rtrim( localUtil.format( AV8Concepto, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,193);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavConcepto_Jsonclick, 0, "Attribute", "", "", "", "", edtavConcepto_Visible, 1, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormulaWC.htm");
         /* User Defined Control */
         ucPopover_iconoexpl.setProperty("TriggerElement", Popover_iconoexpl_Triggerelement);
         ucPopover_iconoexpl.setProperty("PopoverWidth", Popover_iconoexpl_Popoverwidth);
         ucPopover_iconoexpl.setProperty("HTML", Popover_iconoexpl_Html);
         ucPopover_iconoexpl.setProperty("Position", Popover_iconoexpl_Position);
         ucPopover_iconoexpl.render(context, "dvelop.wwppopover", Popover_iconoexpl_Internalname, "POPOVER_ICONOEXPLContainer");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 195,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGridsnippetscurrentpage_Internalname, GXutil.ltrim( localUtil.ntoc( AV95GridSnippetsCurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,195);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGridsnippetscurrentpage_Jsonclick, 0, "Attribute", "", "", "", "", edtavGridsnippetscurrentpage_Visible, 1, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaWC.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavClicod_Internalname, GXutil.ltrim( localUtil.ntoc( AV6CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV6CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,196);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavClicod_Jsonclick, 0, "Attribute", "", "", "", "", edtavClicod_Visible, 1, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaWC.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 197,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavEmpcod_Internalname, GXutil.ltrim( localUtil.ntoc( AV16EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV16EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,197);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavEmpcod_Jsonclick, 0, "Attribute", "", "", "", "", edtavEmpcod_Visible, 1, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_FormulaWC.htm");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 198,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFormula_Internalname, AV20Formula, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,198);\"", (short)(0), edtavFormula_Visible, edtavFormula_Enabled, 1, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaWC.htm");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 199,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavModover_Internalname, GXutil.rtrim( AV127ModoVer), GXutil.rtrim( localUtil.format( AV127ModoVer, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,199);\"", "'"+""+"'"+",false,"+"'"+"EVMODOVER.CLICK."+"'", "", "", "", "", edtavModover_Jsonclick, 5, "Attribute", "", "", "", "", edtavModover_Visible, 1, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormulaWC.htm");
         /* User Defined Control */
         ucGridsnippets_empowerer.render(context, "wwp.gridempowerer", Gridsnippets_empowerer_Internalname, "GRIDSNIPPETS_EMPOWERERContainer");
         /* User Defined Control */
         ucGrid1_empowerer.setProperty("InfiniteScrolling", Grid1_empowerer_Infinitescrolling);
         ucGrid1_empowerer.render(context, "wwp.gridempowerer", Grid1_empowerer_Internalname, "GRID1_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdt_conceptoss2_empowerer.render(context, "wwp.gridempowerer", Gridsdt_conceptoss2_empowerer_Internalname, "GRIDSDT_CONCEPTOSS2_EMPOWERERContainer");
         /* User Defined Control */
         ucGridsdt_conceptoss_empowerer.render(context, "wwp.gridempowerer", Gridsdt_conceptoss_empowerer_Internalname, "GRIDSDT_CONCEPTOSS_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 106 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nEOF", GRIDSDT_CONCEPTOSS_nEOF);
               Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS_nFirstRecordOnPage);
               AV155GXV1 = nGXsfl_106_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridsdt_conceptossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_conceptoss", Gridsdt_conceptossContainer, subGridsdt_conceptoss_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptossContainerData", Gridsdt_conceptossContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptossContainerData"+"V", Gridsdt_conceptossContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_conceptossContainerData"+"V"+"\" value='"+Gridsdt_conceptossContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 115 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Gridsdt_conceptoss2Container.AddObjectProperty("GRIDSDT_CONCEPTOSS2_nEOF", GRIDSDT_CONCEPTOSS2_nEOF);
               Gridsdt_conceptoss2Container.AddObjectProperty("GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage);
               AV158GXV4 = nGXsfl_115_idx ;
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Gridsdt_conceptoss2Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_conceptoss2", Gridsdt_conceptoss2Container, subGridsdt_conceptoss2_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptoss2ContainerData", Gridsdt_conceptoss2Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptoss2ContainerData"+"V", Gridsdt_conceptoss2Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_conceptoss2ContainerData"+"V"+"\" value='"+Gridsdt_conceptoss2Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 131 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
               Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      if ( wbEnd == 159 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridsnippetsContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridsnippetsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Gridsnippets", GridsnippetsContainer, subGridsnippets_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridsnippetsContainerData", GridsnippetsContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridsnippetsContainerData"+"V", GridsnippetsContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsnippetsContainerData"+"V"+"\" value='"+GridsnippetsContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start7D2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Editar Fórmula", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup7D0( ) ;
   }

   public void ws7D2( )
   {
      start7D2( ) ;
      evt7D2( ) ;
   }

   public void evt7D2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSNIPPETSPAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e127D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSNIPPETSPAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e137D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOCONFIRMAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoConfirmar' */
                           e147D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOVERTODOSUSA'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoVerTodosUsa' */
                           e157D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "'DOACTUALIZAR'") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: 'DoActualizar' */
                           e167D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VMODOVER.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e177D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VICONOEXPL.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e187D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VLIQNRO.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e197D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "VLEGNUMERO.CLICK") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e207D2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDT_CONCEPTOSSPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDSDT_CONCEPTOSSPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridsdt_conceptoss_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridsdt_conceptoss_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridsdt_conceptoss_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridsdt_conceptoss_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDSDT_CONCEPTOSS2PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRIDSDT_CONCEPTOSS2PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgridsdt_conceptoss2_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgridsdt_conceptoss2_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgridsdt_conceptoss2_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgridsdt_conceptoss2_lastpage( ) ;
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRID1PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid1_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid1_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid1_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid1_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 23), "GRIDSDT_CONCEPTOSS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 12), "'DONOUSADOS'") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_106_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1062( ) ;
                           AV155GXV1 = (int)(nGXsfl_106_idx+GRIDSDT_CONCEPTOSS_nFirstRecordOnPage) ;
                           if ( ( AV66sdt_conceptos.size() >= AV155GXV1 ) && ( AV155GXV1 > 0 ) )
                           {
                              AV66sdt_conceptos.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV66sdt_conceptos.elementAt(-1+AV155GXV1)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e217D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e227D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRIDSDT_CONCEPTOSS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e237D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "'DONOUSADOS'") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: 'DoNOUSADOS' */
                                 e247D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    if ( ! Rfr0gs )
                                    {
                                    }
                                    dynload_actions( ) ;
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 24), "GRIDSDT_CONCEPTOSS2.LOAD") == 0 )
                        {
                           nGXsfl_115_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1157( ) ;
                           AV158GXV4 = (int)(nGXsfl_115_idx+GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage) ;
                           if ( ( AV84sdt_conceptos2.size() >= AV158GXV4 ) && ( AV158GXV4 > 0 ) )
                           {
                              AV84sdt_conceptos2.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)) );
                           }
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSDT_CONCEPTOSS2.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e257D7 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 )
                        {
                           nGXsfl_131_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_131_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_131_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1316( ) ;
                           A223ForHisFecha = localUtil.ctot( httpContext.cgiGet( edtForHisFecha_Internalname), 0) ;
                           A224ForHisUsuario = httpContext.cgiGet( edtForHisUsuario_Internalname) ;
                           A222ForHisDespues = httpContext.cgiGet( edtForHisDespues_Internalname) ;
                           A51ForHisNum = (short)(localUtil.ctol( httpContext.cgiGet( edtForHisNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A52ImpSec = localUtil.ctol( httpContext.cgiGet( edtImpSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
                           n52ImpSec = false ;
                           A221ForHisAntes = httpContext.cgiGet( edtForHisAntes_Internalname) ;
                           n221ForHisAntes = false ;
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e267D6 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                        else if ( ( GXutil.strcmp(GXutil.left( sEvt, 17), "GRIDSNIPPETS.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VCOPYSNIPPET.CLICK") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 18), "VCOPYSNIPPET.CLICK") == 0 ) )
                        {
                           nGXsfl_159_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_159_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_159_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_1593( ) ;
                           AV94OpeCodFormula = httpContext.cgiGet( edtavOpecodformula_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOpecodformula_Internalname, AV94OpeCodFormula);
                           web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, GXutil.rtrim( localUtil.format( AV94OpeCodFormula, ""))));
                           AV14copySnippet = httpContext.cgiGet( edtavCopysnippet_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavCopysnippet_Internalname, AV14copySnippet);
                           if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
                           {
                              httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vNUM");
                              GX_FocusControl = edtavNum_Internalname ;
                              httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                              wbErr = true ;
                              AV61num = (short)(0) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavNum_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61num), 4, 0));
                              web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
                           }
                           else
                           {
                              AV61num = (short)(localUtil.ctol( httpContext.cgiGet( edtavNum_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                              httpContext.ajax_rsp_assign_attri("", false, edtavNum_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61num), 4, 0));
                              web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
                           }
                           AV102entidad = httpContext.cgiGet( edtavEntidad_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavEntidad_Internalname, AV102entidad);
                           AV116OpeCliId = httpContext.cgiGet( edtavOpecliid_Internalname) ;
                           httpContext.ajax_rsp_assign_attri("", false, edtavOpecliid_Internalname, AV116OpeCliId);
                           cmbavIdoperando.setName( cmbavIdoperando.getInternalname() );
                           cmbavIdoperando.setValue( httpContext.cgiGet( cmbavIdoperando.getInternalname()) );
                           AV117idOperando = httpContext.cgiGet( cmbavIdoperando.getInternalname()) ;
                           httpContext.ajax_rsp_assign_attri("", false, cmbavIdoperando.getInternalname(), AV117idOperando);
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "GRIDSNIPPETS.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e277D3 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "VCOPYSNIPPET.CLICK") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e287D2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we7D2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa7D2( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = cmbavConrelsec.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      gxvvlegnumero_html7D2( AV6CliCod, AV16EmpCod) ;
      gxvvliqnro_html7D2( AV6CliCod, AV16EmpCod) ;
      /* End function dynload_actions */
   }

   public void gxdlvvlegnumero7D2( int AV6CliCod ,
                                   short AV16EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvlegnumero_data7D2( AV6CliCod, AV16EmpCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvlegnumero_html7D2( int AV6CliCod ,
                                      short AV16EmpCod )
   {
      int gxdynajaxvalue;
      gxdlvvlegnumero_data7D2( AV6CliCod, AV16EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLegnumero.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavLegnumero.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlvvlegnumero_data7D2( int AV6CliCod ,
                                           short AV16EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor H007D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV6CliCod), Short.valueOf(AV16EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H007D2_A6LegNumero[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H007D2_A250LegIdNomApe[0]);
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void gxdlvvliqnro7D2( int AV6CliCod ,
                                short AV16EmpCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlvvliqnro_data7D2( AV6CliCod, AV16EmpCod) ;
      gxdynajaxindex = 1 ;
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         addString( gxwrpcisep+"{\"c\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrlcodr.item(gxdynajaxindex))+"\",\"d\":\""+PrivateUtilities.encodeJSConstant( gxdynajaxctrldescr.item(gxdynajaxindex))+"\"}") ;
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
         gxwrpcisep = "," ;
      }
      addString( "]") ;
      if ( gxdynajaxctrlcodr.getCount() == 0 )
      {
         addString( ",101") ;
      }
      addString( "]") ;
   }

   public void gxvvliqnro_html7D2( int AV6CliCod ,
                                   short AV16EmpCod )
   {
      int gxdynajaxvalue;
      gxdlvvliqnro_data7D2( AV6CliCod, AV16EmpCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynavLiqnro.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynavLiqnro.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 8, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
      if ( dynavLiqnro.getItemCount() > 0 )
      {
         AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValidValue(GXutil.trim( GXutil.str( AV51LiqNro, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51LiqNro), 8, 0));
      }
   }

   protected void gxdlvvliqnro_data7D2( int AV6CliCod ,
                                        short AV16EmpCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor H007D3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV6CliCod), Short.valueOf(AV16EmpCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( H007D3_A31LiqNro[0], (byte)(8), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(H007D3_A874LiqNombre[0]);
         pr_default.readNext(1);
      }
      pr_default.close(1);
   }

   public void gxnrgridsdt_conceptoss_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1062( ) ;
      while ( nGXsfl_106_idx <= nRC_GXsfl_106 )
      {
         sendrow_1062( ) ;
         nGXsfl_106_idx = ((subGridsdt_conceptoss_Islastpage==1)&&(nGXsfl_106_idx+1>subgridsdt_conceptoss_fnc_recordsperpage( )) ? 1 : nGXsfl_106_idx+1) ;
         sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1062( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridsdt_conceptossContainer)) ;
      /* End function gxnrGridsdt_conceptoss_newrow */
   }

   public void gxnrgridsnippets_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1593( ) ;
      while ( nGXsfl_159_idx <= nRC_GXsfl_159 )
      {
         sendrow_1593( ) ;
         nGXsfl_159_idx = ((subGridsnippets_Islastpage==1)&&(nGXsfl_159_idx+1>subgridsnippets_fnc_recordsperpage( )) ? 1 : nGXsfl_159_idx+1) ;
         sGXsfl_159_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_159_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1593( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridsnippetsContainer)) ;
      /* End function gxnrGridsnippets_newrow */
   }

   public void gxnrgrid1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1316( ) ;
      while ( nGXsfl_131_idx <= nRC_GXsfl_131 )
      {
         sendrow_1316( ) ;
         nGXsfl_131_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_131_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_131_idx+1) ;
         sGXsfl_131_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_131_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1316( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxnrgridsdt_conceptoss2_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_1157( ) ;
      while ( nGXsfl_115_idx <= nRC_GXsfl_115 )
      {
         sendrow_1157( ) ;
         nGXsfl_115_idx = ((subGridsdt_conceptoss2_Islastpage==1)&&(nGXsfl_115_idx+1>subgridsdt_conceptoss2_fnc_recordsperpage( )) ? 1 : nGXsfl_115_idx+1) ;
         sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1157( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridsdt_conceptoss2Container)) ;
      /* End function gxnrGridsdt_conceptoss2_newrow */
   }

   public void gxgrgridsdt_conceptoss_refresh( int subGridsdt_conceptoss_Rows ,
                                               int subGridsdt_conceptoss2_Rows ,
                                               int subGrid1_Rows ,
                                               int subGridsnippets_Rows ,
                                               int AV6CliCod ,
                                               String AV8Concepto ,
                                               String AV161Pgmname ,
                                               GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV66sdt_conceptos ,
                                               short AV98PaiCod ,
                                               java.util.Date AV134LiqPeriodo ,
                                               java.util.Date AV139date ,
                                               int AV138clienteNucleoPais_CliCod ,
                                               boolean AV142ClienteConveniador ,
                                               boolean AV17esConceptosDefault ,
                                               String AV147MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e227D2 ();
      GRIDSDT_CONCEPTOSS_nCurrentRecord = 0 ;
      rf7D2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdt_conceptoss_refresh */
   }

   public void gxgrgridsdt_conceptoss2_refresh( int subGridsdt_conceptoss_Rows ,
                                                int subGridsdt_conceptoss2_Rows ,
                                                int subGrid1_Rows ,
                                                int subGridsnippets_Rows ,
                                                int AV6CliCod ,
                                                String AV8Concepto ,
                                                String AV161Pgmname ,
                                                GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV84sdt_conceptos2 ,
                                                GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV66sdt_conceptos ,
                                                short AV98PaiCod ,
                                                java.util.Date AV134LiqPeriodo ,
                                                java.util.Date AV139date ,
                                                int AV138clienteNucleoPais_CliCod ,
                                                boolean AV142ClienteConveniador ,
                                                boolean AV17esConceptosDefault ,
                                                String AV147MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e227D2 ();
      GRIDSDT_CONCEPTOSS2_nCurrentRecord = 0 ;
      rf7D7( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsdt_conceptoss2_refresh */
   }

   public void gxgrgrid1_refresh( int subGridsdt_conceptoss_Rows ,
                                  int subGridsdt_conceptoss2_Rows ,
                                  int subGrid1_Rows ,
                                  int subGridsnippets_Rows ,
                                  String AV10ConCodigo ,
                                  int AV6CliCod ,
                                  String AV8Concepto ,
                                  String AV161Pgmname ,
                                  GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV66sdt_conceptos ,
                                  short AV98PaiCod ,
                                  java.util.Date AV134LiqPeriodo ,
                                  java.util.Date AV139date ,
                                  int AV138clienteNucleoPais_CliCod ,
                                  boolean AV142ClienteConveniador ,
                                  boolean AV17esConceptosDefault ,
                                  String AV147MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e227D2 ();
      GRID1_nCurrentRecord = 0 ;
      rf7D6( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void gxgrgridsnippets_refresh( int subGridsdt_conceptoss_Rows ,
                                         int subGridsdt_conceptoss2_Rows ,
                                         int subGrid1_Rows ,
                                         int subGridsnippets_Rows ,
                                         int AV6CliCod ,
                                         String AV8Concepto ,
                                         String AV161Pgmname ,
                                         int AV51LiqNro ,
                                         short AV16EmpCod ,
                                         int A3CliCod ,
                                         String A82OpeCliId ,
                                         String A534OpeCliDescrip ,
                                         String AV89searchSnippets ,
                                         String A549OpeCliCodFormula ,
                                         short AV61num ,
                                         short A46PaiCod ,
                                         short AV98PaiCod ,
                                         String A473OpeCodFormula ,
                                         String A474OpeDescripcion ,
                                         String A74idOperando ,
                                         int AV48LegNumero ,
                                         java.util.Date AV134LiqPeriodo ,
                                         String AV10ConCodigo ,
                                         java.util.Date AV139date ,
                                         int AV138clienteNucleoPais_CliCod ,
                                         GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV66sdt_conceptos ,
                                         boolean AV142ClienteConveniador ,
                                         boolean AV17esConceptosDefault ,
                                         String AV147MenuOpcCod )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e227D2 ();
      GRIDSNIPPETS_nCurrentRecord = 0 ;
      rf7D3( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGridsnippets_refresh */
   }

   public void send_integrity_hashes( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vNUM", GXutil.ltrim( localUtil.ntoc( AV61num, (byte)(4), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV94OpeCodFormula, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECODFORMULA", GXutil.rtrim( AV94OpeCodFormula));
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
      if ( cmbavConrelsec.getItemCount() > 0 )
      {
         AV146ConRelSec = (int)(GXutil.lval( cmbavConrelsec.getValidValue(GXutil.trim( GXutil.str( AV146ConRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV146ConRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV146ConRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavConrelsec.setValue( GXutil.trim( GXutil.str( AV146ConRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConrelsec.getInternalname(), "Values", cmbavConrelsec.ToJavascriptSource(), true);
      }
      if ( dynavLegnumero.getItemCount() > 0 )
      {
         AV48LegNumero = (int)(GXutil.lval( dynavLegnumero.getValidValue(GXutil.trim( GXutil.str( AV48LegNumero, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48LegNumero), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegnumero.getInternalname(), "Values", dynavLegnumero.ToJavascriptSource(), true);
      }
      if ( dynavLiqnro.getItemCount() > 0 )
      {
         AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValidValue(GXutil.trim( GXutil.str( AV51LiqNro, 8, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51LiqNro), 8, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLiqnro.getInternalname(), "Values", dynavLiqnro.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      GRID1_nCurrentRecord = 0 ;
      GXCCtl = "GRID1_nFirstRecordOnPage_" + sGXsfl_131_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      send_integrity_hashes( ) ;
      rf7D2( ) ;
      rf7D7( ) ;
      rf7D6( ) ;
      rf7D3( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV161Pgmname = "FormulaWC" ;
      Gx_err = (short)(0) ;
      edtavFormulacondescripciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormulacondescripciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulacondescripciones_Enabled), 5, 0), true);
      edtavConformulaexpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConformulaexpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConformulaexpl_Enabled), 5, 0), true);
      edtavIconoexpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoexpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoexpl_Enabled), 5, 0), true);
      edtavFormulaaux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormulaaux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulaaux_Enabled), 5, 0), true);
      edtavResultado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavResultado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResultado_Enabled), 5, 0), true);
      edtavSdt_conceptos__concodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos__concodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos__concodigo_Enabled), 5, 0), !bGXsfl_106_Refreshing);
      edtavSdt_conceptos__condescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos__condescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos__condescrip_Enabled), 5, 0), !bGXsfl_106_Refreshing);
      edtavSdt_conceptos2__concodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos2__concodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos2__concodigo_Enabled), 5, 0), !bGXsfl_115_Refreshing);
      edtavSdt_conceptos2__condescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos2__condescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos2__condescrip_Enabled), 5, 0), !bGXsfl_115_Refreshing);
      edtavOpecodformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpecodformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpecodformula_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavCopysnippet_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCopysnippet_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCopysnippet_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavNum_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNum_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNum_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavEntidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEntidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEntidad_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavOpecliid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpecliid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpecliid_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      cmbavIdoperando.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavIdoperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavIdoperando.getEnabled(), 5, 0), !bGXsfl_159_Refreshing);
      edtavAcopiar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAcopiar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAcopiar_Enabled), 5, 0), true);
   }

   public void rf7D2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridsdt_conceptossContainer.ClearRows();
      }
      wbStart = (short)(106) ;
      /* Execute user event: Refresh */
      e227D2 ();
      nGXsfl_106_idx = 1 ;
      sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1062( ) ;
      bGXsfl_106_Refreshing = true ;
      Gridsdt_conceptossContainer.AddObjectProperty("GridName", "Gridsdt_conceptoss");
      Gridsdt_conceptossContainer.AddObjectProperty("CmpContext", "");
      Gridsdt_conceptossContainer.AddObjectProperty("InMasterPage", "false");
      Gridsdt_conceptossContainer.AddObjectProperty("Class", "WorkWith");
      Gridsdt_conceptossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_conceptossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_conceptossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridsdt_conceptossContainer.setPageSize( subgridsdt_conceptoss_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1062( ) ;
         e237D2 ();
         if ( ( GRIDSDT_CONCEPTOSS_nCurrentRecord > 0 ) && ( GRIDSDT_CONCEPTOSS_nGridOutOfScope == 0 ) && ( nGXsfl_106_idx == 1 ) )
         {
            GRIDSDT_CONCEPTOSS_nCurrentRecord = 0 ;
            GRIDSDT_CONCEPTOSS_nGridOutOfScope = 1 ;
            subgridsdt_conceptoss_firstpage( ) ;
            e237D2 ();
         }
         wbEnd = (short)(106) ;
         wb7D0( ) ;
      }
      bGXsfl_106_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes7D2( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV161Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV161Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV98PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQPERIODO", localUtil.dtoc( AV134LiqPeriodo, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQPERIODO", getSecureSignedToken( "", AV134LiqPeriodo));
      web.GxWebStd.gx_hidden_field( httpContext, "vDATE", localUtil.dtoc( AV139date, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vDATE", getSecureSignedToken( "", AV139date));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIENTENUCLEOPAIS_CLICOD", GXutil.ltrim( localUtil.ntoc( AV138clienteNucleoPais_CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTENUCLEOPAIS_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV138clienteNucleoPais_CliCod), "ZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vSDT_CONCEPTOS", AV66sdt_conceptos);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vSDT_CONCEPTOS", AV66sdt_conceptos);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vSDT_CONCEPTOS", getSecureSignedToken( "", AV66sdt_conceptos));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vCLIENTECONVENIADOR", AV142ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV142ClienteConveniador));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vESCONCEPTOSDEFAULT", AV17esConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESCONCEPTOSDEFAULT", getSecureSignedToken( "", AV17esConceptosDefault));
   }

   public void rf7D3( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridsnippetsContainer.ClearRows();
      }
      wbStart = (short)(159) ;
      nGXsfl_159_idx = 1 ;
      sGXsfl_159_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_159_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1593( ) ;
      bGXsfl_159_Refreshing = true ;
      GridsnippetsContainer.AddObjectProperty("GridName", "Gridsnippets");
      GridsnippetsContainer.AddObjectProperty("CmpContext", "");
      GridsnippetsContainer.AddObjectProperty("InMasterPage", "false");
      GridsnippetsContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      GridsnippetsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridsnippetsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridsnippetsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridsnippetsContainer.setPageSize( subgridsnippets_fnc_recordsperpage( ) );
      if ( subGridsdt_conceptoss_Islastpage != 0 )
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(subgridsdt_conceptoss_fnc_recordcount( )-subgridsdt_conceptoss_fnc_recordsperpage( )) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS_nFirstRecordOnPage);
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1593( ) ;
         e277D3 ();
         if ( ( GRIDSNIPPETS_nCurrentRecord > 0 ) && ( GRIDSNIPPETS_nGridOutOfScope == 0 ) && ( nGXsfl_159_idx == 1 ) )
         {
            GRIDSNIPPETS_nCurrentRecord = 0 ;
            GRIDSNIPPETS_nGridOutOfScope = 1 ;
            subgridsnippets_firstpage( ) ;
            e277D3 ();
         }
         wbEnd = (short)(159) ;
         wb7D0( ) ;
      }
      bGXsfl_159_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes7D3( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, GXutil.rtrim( localUtil.format( AV94OpeCodFormula, ""))));
   }

   public void rf7D6( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(131) ;
      nGXsfl_131_idx = (int)(1+GRID1_nFirstRecordOnPage) ;
      sGXsfl_131_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_131_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1316( ) ;
      bGXsfl_131_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "WorkWith");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1316( ) ;
         GXPagingFrom6 = (int)(((subGrid1_Rows==0) ? 0 : GRID1_nFirstRecordOnPage)) ;
         GXPagingTo6 = ((subGrid1_Rows==0) ? 10000 : subgrid1_fnc_recordsperpage( )+1) ;
         /* Using cursor H007D4 */
         pr_default.execute(2, new Object[] {Short.valueOf(AV18ForHisNum), AV10ConCodigo, Integer.valueOf(GXPagingFrom6), Integer.valueOf(GXPagingTo6), Integer.valueOf(GXPagingTo6)});
         nGXsfl_131_idx = (int)(1+GRID1_nFirstRecordOnPage) ;
         sGXsfl_131_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_131_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1316( ) ;
         while ( ( (pr_default.getStatus(2) != 101) ) && ( ( ( subGrid1_Rows == 0 ) || ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) ) )
         {
            A26ConCodigo = H007D4_A26ConCodigo[0] ;
            A221ForHisAntes = H007D4_A221ForHisAntes[0] ;
            n221ForHisAntes = H007D4_n221ForHisAntes[0] ;
            A52ImpSec = H007D4_A52ImpSec[0] ;
            n52ImpSec = H007D4_n52ImpSec[0] ;
            A51ForHisNum = H007D4_A51ForHisNum[0] ;
            A222ForHisDespues = H007D4_A222ForHisDespues[0] ;
            A224ForHisUsuario = H007D4_A224ForHisUsuario[0] ;
            A223ForHisFecha = H007D4_A223ForHisFecha[0] ;
            A3CliCod = H007D4_A3CliCod[0] ;
            e267D6 ();
            pr_default.readNext(2);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(2) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(2);
         wbEnd = (short)(131) ;
         wb7D0( ) ;
      }
      bGXsfl_131_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes7D6( )
   {
   }

   public void rf7D7( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Gridsdt_conceptoss2Container.ClearRows();
      }
      wbStart = (short)(115) ;
      nGXsfl_115_idx = 1 ;
      sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_1157( ) ;
      bGXsfl_115_Refreshing = true ;
      Gridsdt_conceptoss2Container.AddObjectProperty("GridName", "Gridsdt_conceptoss2");
      Gridsdt_conceptoss2Container.AddObjectProperty("CmpContext", "");
      Gridsdt_conceptoss2Container.AddObjectProperty("InMasterPage", "false");
      Gridsdt_conceptoss2Container.AddObjectProperty("Class", "WorkWith");
      Gridsdt_conceptoss2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_conceptoss2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridsdt_conceptoss2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridsdt_conceptoss2Container.setPageSize( subgridsdt_conceptoss2_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_1157( ) ;
         e257D7 ();
         if ( ( GRIDSDT_CONCEPTOSS2_nCurrentRecord > 0 ) && ( GRIDSDT_CONCEPTOSS2_nGridOutOfScope == 0 ) && ( nGXsfl_115_idx == 1 ) )
         {
            GRIDSDT_CONCEPTOSS2_nCurrentRecord = 0 ;
            GRIDSDT_CONCEPTOSS2_nGridOutOfScope = 1 ;
            subgridsdt_conceptoss2_firstpage( ) ;
            e257D7 ();
         }
         wbEnd = (short)(115) ;
         wb7D0( ) ;
      }
      bGXsfl_115_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes7D7( )
   {
   }

   public int subgridsdt_conceptoss_fnc_pagecount( )
   {
      GRIDSDT_CONCEPTOSS_nRecordCount = subgridsdt_conceptoss_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDT_CONCEPTOSS_nRecordCount) % (subgridsdt_conceptoss_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS_nRecordCount/ (double) (subgridsdt_conceptoss_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS_nRecordCount/ (double) (subgridsdt_conceptoss_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdt_conceptoss_fnc_recordcount( )
   {
      return AV66sdt_conceptos.size() ;
   }

   public int subgridsdt_conceptoss_fnc_recordsperpage( )
   {
      if ( subGridsdt_conceptoss_Rows > 0 )
      {
         return subGridsdt_conceptoss_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdt_conceptoss_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage/ (double) (subgridsdt_conceptoss_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdt_conceptoss_firstpage( )
   {
      GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_conceptoss_nextpage( )
   {
      GRIDSDT_CONCEPTOSS_nRecordCount = subgridsdt_conceptoss_fnc_recordcount( ) ;
      if ( ( GRIDSDT_CONCEPTOSS_nRecordCount >= subgridsdt_conceptoss_fnc_recordsperpage( ) ) && ( GRIDSDT_CONCEPTOSS_nEOF == 0 ) )
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS_nFirstRecordOnPage+subgridsdt_conceptoss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDT_CONCEPTOSS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdt_conceptoss_previouspage( )
   {
      if ( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage >= subgridsdt_conceptoss_fnc_recordsperpage( ) )
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS_nFirstRecordOnPage-subgridsdt_conceptoss_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_conceptoss_lastpage( )
   {
      GRIDSDT_CONCEPTOSS_nRecordCount = subgridsdt_conceptoss_fnc_recordcount( ) ;
      if ( GRIDSDT_CONCEPTOSS_nRecordCount > subgridsdt_conceptoss_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDT_CONCEPTOSS_nRecordCount) % (subgridsdt_conceptoss_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS_nRecordCount-subgridsdt_conceptoss_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS_nRecordCount-((int)((GRIDSDT_CONCEPTOSS_nRecordCount) % (subgridsdt_conceptoss_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdt_conceptoss_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = (long)(subgridsdt_conceptoss_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsnippets_fnc_pagecount( )
   {
      return -1 ;
   }

   public int subgridsnippets_fnc_recordcount( )
   {
      return (int)(((subGridsnippets_Recordcount==0) ? GRIDSNIPPETS_nFirstRecordOnPage+1 : subGridsnippets_Recordcount)) ;
   }

   public int subgridsnippets_fnc_recordsperpage( )
   {
      if ( subGridsnippets_Rows > 0 )
      {
         return subGridsnippets_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsnippets_fnc_currentpage( )
   {
      return (int)(((subGridsnippets_Islastpage==1) ? subgridsnippets_fnc_recordcount( )/ (double) (subgridsnippets_fnc_recordsperpage( ))+((((int)((subgridsnippets_fnc_recordcount( )) % (subgridsnippets_fnc_recordsperpage( ))))==0) ? 0 : 1) : GXutil.Int( GRIDSNIPPETS_nFirstRecordOnPage/ (double) (subgridsnippets_fnc_recordsperpage( )))+1)) ;
   }

   public short subgridsnippets_firstpage( )
   {
      GRIDSNIPPETS_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsnippets_nextpage( )
   {
      if ( GRIDSNIPPETS_nEOF == 0 )
      {
         GRIDSNIPPETS_nFirstRecordOnPage = (long)(GRIDSNIPPETS_nFirstRecordOnPage+subgridsnippets_fnc_recordsperpage( )) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridsnippetsContainer.AddObjectProperty("GRIDSNIPPETS_nFirstRecordOnPage", GRIDSNIPPETS_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSNIPPETS_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsnippets_previouspage( )
   {
      if ( GRIDSNIPPETS_nFirstRecordOnPage >= subgridsnippets_fnc_recordsperpage( ) )
      {
         GRIDSNIPPETS_nFirstRecordOnPage = (long)(GRIDSNIPPETS_nFirstRecordOnPage-subgridsnippets_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsnippets_lastpage( )
   {
      subGridsnippets_Islastpage = 1 ;
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsnippets_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSNIPPETS_nFirstRecordOnPage = (long)(subgridsnippets_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSNIPPETS_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsnippets_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV51LiqNro, AV16EmpCod, A3CliCod, A82OpeCliId, A534OpeCliDescrip, AV89searchSnippets, A549OpeCliCodFormula, AV61num, A46PaiCod, AV98PaiCod, A473OpeCodFormula, A474OpeDescripcion, A74idOperando, AV48LegNumero, AV134LiqPeriodo, AV10ConCodigo, AV139date, AV138clienteNucleoPais_CliCod, AV66sdt_conceptos, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgrid1_fnc_pagecount( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      /* Using cursor H007D5 */
      pr_default.execute(3, new Object[] {Short.valueOf(AV18ForHisNum), AV10ConCodigo});
      GRID1_nRecordCount = H007D5_AGRID1_nRecordCount[0] ;
      pr_default.close(3);
      return (int)(GRID1_nRecordCount) ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      if ( subGrid1_Rows > 0 )
      {
         return subGrid1_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid1_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID1_nFirstRecordOnPage/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid1_firstpage( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_nextpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ( GRID1_nRecordCount >= subgrid1_fnc_recordsperpage( ) ) && ( GRID1_nEOF == 0 ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage+subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      if ( GRID1_nEOF == 1 )
      {
         GRID1_nFirstRecordOnPage = GRID1_nCurrentRecord ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID1_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid1_previouspage( )
   {
      if ( GRID1_nFirstRecordOnPage >= subgrid1_fnc_recordsperpage( ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage-subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_lastpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( GRID1_nRecordCount > subgrid1_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-subgrid1_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid1_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID1_nFirstRecordOnPage = (long)(subgrid1_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV10ConCodigo, AV6CliCod, AV8Concepto, AV161Pgmname, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public int subgridsdt_conceptoss2_fnc_pagecount( )
   {
      GRIDSDT_CONCEPTOSS2_nRecordCount = subgridsdt_conceptoss2_fnc_recordcount( ) ;
      if ( ((int)((GRIDSDT_CONCEPTOSS2_nRecordCount) % (subgridsdt_conceptoss2_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS2_nRecordCount/ (double) (subgridsdt_conceptoss2_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS2_nRecordCount/ (double) (subgridsdt_conceptoss2_fnc_recordsperpage( )))+1) ;
   }

   public int subgridsdt_conceptoss2_fnc_recordcount( )
   {
      return AV84sdt_conceptos2.size() ;
   }

   public int subgridsdt_conceptoss2_fnc_recordsperpage( )
   {
      if ( subGridsdt_conceptoss2_Rows > 0 )
      {
         return subGridsdt_conceptoss2_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgridsdt_conceptoss2_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage/ (double) (subgridsdt_conceptoss2_fnc_recordsperpage( )))+1) ;
   }

   public short subgridsdt_conceptoss2_firstpage( )
   {
      GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_conceptoss2_nextpage( )
   {
      GRIDSDT_CONCEPTOSS2_nRecordCount = subgridsdt_conceptoss2_fnc_recordcount( ) ;
      if ( ( GRIDSDT_CONCEPTOSS2_nRecordCount >= subgridsdt_conceptoss2_fnc_recordsperpage( ) ) && ( GRIDSDT_CONCEPTOSS2_nEOF == 0 ) )
      {
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage+subgridsdt_conceptoss2_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Gridsdt_conceptoss2Container.AddObjectProperty("GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRIDSDT_CONCEPTOSS2_nEOF==0) ? 0 : 2)) ;
   }

   public short subgridsdt_conceptoss2_previouspage( )
   {
      if ( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage >= subgridsdt_conceptoss2_fnc_recordsperpage( ) )
      {
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage-subgridsdt_conceptoss2_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgridsdt_conceptoss2_lastpage( )
   {
      GRIDSDT_CONCEPTOSS2_nRecordCount = subgridsdt_conceptoss2_fnc_recordcount( ) ;
      if ( GRIDSDT_CONCEPTOSS2_nRecordCount > subgridsdt_conceptoss2_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRIDSDT_CONCEPTOSS2_nRecordCount) % (subgridsdt_conceptoss2_fnc_recordsperpage( )))) == 0 )
         {
            GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS2_nRecordCount-subgridsdt_conceptoss2_fnc_recordsperpage( )) ;
         }
         else
         {
            GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = (long)(GRIDSDT_CONCEPTOSS2_nRecordCount-((int)((GRIDSDT_CONCEPTOSS2_nRecordCount) % (subgridsdt_conceptoss2_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgridsdt_conceptoss2_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = (long)(subgridsdt_conceptoss2_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV161Pgmname = "FormulaWC" ;
      Gx_err = (short)(0) ;
      edtavFormulacondescripciones_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormulacondescripciones_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulacondescripciones_Enabled), 5, 0), true);
      edtavConformulaexpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConformulaexpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConformulaexpl_Enabled), 5, 0), true);
      edtavIconoexpl_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavIconoexpl_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavIconoexpl_Enabled), 5, 0), true);
      edtavFormulaaux_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormulaaux_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulaaux_Enabled), 5, 0), true);
      edtavResultado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavResultado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavResultado_Enabled), 5, 0), true);
      edtavSdt_conceptos__concodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos__concodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos__concodigo_Enabled), 5, 0), !bGXsfl_106_Refreshing);
      edtavSdt_conceptos__condescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos__condescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos__condescrip_Enabled), 5, 0), !bGXsfl_106_Refreshing);
      edtavSdt_conceptos2__concodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos2__concodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos2__concodigo_Enabled), 5, 0), !bGXsfl_115_Refreshing);
      edtavSdt_conceptos2__condescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavSdt_conceptos2__condescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavSdt_conceptos2__condescrip_Enabled), 5, 0), !bGXsfl_115_Refreshing);
      edtavOpecodformula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpecodformula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpecodformula_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavCopysnippet_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavCopysnippet_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavCopysnippet_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavNum_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavNum_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavNum_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavEntidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEntidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEntidad_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      edtavOpecliid_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavOpecliid_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavOpecliid_Enabled), 5, 0), !bGXsfl_159_Refreshing);
      cmbavIdoperando.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbavIdoperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbavIdoperando.getEnabled(), 5, 0), !bGXsfl_159_Refreshing);
      edtavAcopiar_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAcopiar_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAcopiar_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strup7D0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e217D2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdt_conceptos"), AV66sdt_conceptos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "Sdt_conceptos2"), AV84sdt_conceptos2);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONCEPTO_DATA"), AV9Concepto_Data);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDT_CONCEPTOS"), AV66sdt_conceptos);
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vSDT_CONCEPTOS2"), AV84sdt_conceptos2);
         /* Read saved values. */
         nRC_GXsfl_106 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_106"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_115 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_115"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_131 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_131"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_159 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_159"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV96GridSnippetsPageCount = localUtil.ctol( httpContext.cgiGet( "vGRIDSNIPPETSPAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV97GridSnippetsAppliedFilters = httpContext.cgiGet( "vGRIDSNIPPETSAPPLIEDFILTERS") ;
         AV115parmLiqNro = (int)(localUtil.ctol( httpContext.cgiGet( "vPARMLIQNRO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV147MenuOpcCod = httpContext.cgiGet( "vMENUOPCCOD") ;
         AV114parmLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vPARMLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDSDT_CONCEPTOSS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDSNIPPETS_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETS_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRIDSDT_CONCEPTOSS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDSDT_CONCEPTOSS2_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS2_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRIDSNIPPETS_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETS_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGridsdt_conceptoss_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsdt_conceptoss2_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSDT_CONCEPTOSS2_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Rows, (byte)(6), (byte)(0), ".", "")));
         subGrid1_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID1_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
         subGridsnippets_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETS_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Rows, (byte)(6), (byte)(0), ".", "")));
         Combo_concepto_Cls = httpContext.cgiGet( "COMBO_CONCEPTO_Cls") ;
         Combo_concepto_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONCEPTO_Selectedvalue_set") ;
         Combo_concepto_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONCEPTO_Emptyitem")) ;
         Monacoeditor1_Monaco_editor_id = httpContext.cgiGet( "MONACOEDITOR1_Monaco_editor_id") ;
         Monacoeditor1_Nombrelenguaje = httpContext.cgiGet( "MONACOEDITOR1_Nombrelenguaje") ;
         Monacoeditor1_Monaco_brackets = httpContext.cgiGet( "MONACOEDITOR1_Monaco_brackets") ;
         Monacoeditor1_Monaco_tokens = httpContext.cgiGet( "MONACOEDITOR1_Monaco_tokens") ;
         Monacoeditor1_Monaco_tokens_style = httpContext.cgiGet( "MONACOEDITOR1_Monaco_tokens_style") ;
         Monacoeditor1_Monaco_foreground = httpContext.cgiGet( "MONACOEDITOR1_Monaco_foreground") ;
         Monacoeditor1_Monaco_url_sug = httpContext.cgiGet( "MONACOEDITOR1_Monaco_url_sug") ;
         Monacoeditor1_Valorinicial = httpContext.cgiGet( "MONACOEDITOR1_Valorinicial") ;
         Monacoeditor1_Monaco_linenumbers = httpContext.cgiGet( "MONACOEDITOR1_Monaco_linenumbers") ;
         Monacoeditor1_Monaco_wordwrap = httpContext.cgiGet( "MONACOEDITOR1_Monaco_wordwrap") ;
         Monacoeditor1_Monaco_columns = httpContext.cgiGet( "MONACOEDITOR1_Monaco_columns") ;
         Monacoeditor1_Monaco_readonly = httpContext.cgiGet( "MONACOEDITOR1_Monaco_readonly") ;
         Monacoeditor1_Monaco_minimap = httpContext.cgiGet( "MONACOEDITOR1_Monaco_minimap") ;
         Monacoeditor1_Variable_asociada = httpContext.cgiGet( "MONACOEDITOR1_Variable_asociada") ;
         Monacoeditor1_Permitidos = httpContext.cgiGet( "MONACOEDITOR1_Permitidos") ;
         Monacoeditor1_Palabra_concepto = httpContext.cgiGet( "MONACOEDITOR1_Palabra_concepto") ;
         Monacoeditor1_Url_sug_querystring = httpContext.cgiGet( "MONACOEDITOR1_Url_sug_querystring") ;
         Dvpanel_explpanel_Width = httpContext.cgiGet( "DVPANEL_EXPLPANEL_Width") ;
         Dvpanel_explpanel_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Autowidth")) ;
         Dvpanel_explpanel_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Autoheight")) ;
         Dvpanel_explpanel_Cls = httpContext.cgiGet( "DVPANEL_EXPLPANEL_Cls") ;
         Dvpanel_explpanel_Title = httpContext.cgiGet( "DVPANEL_EXPLPANEL_Title") ;
         Dvpanel_explpanel_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Collapsible")) ;
         Dvpanel_explpanel_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Collapsed")) ;
         Dvpanel_explpanel_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Showcollapseicon")) ;
         Dvpanel_explpanel_Iconposition = httpContext.cgiGet( "DVPANEL_EXPLPANEL_Iconposition") ;
         Dvpanel_explpanel_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_EXPLPANEL_Autoscroll")) ;
         Dvpanel_panelprobar_Width = httpContext.cgiGet( "DVPANEL_PANELPROBAR_Width") ;
         Dvpanel_panelprobar_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Autowidth")) ;
         Dvpanel_panelprobar_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Autoheight")) ;
         Dvpanel_panelprobar_Cls = httpContext.cgiGet( "DVPANEL_PANELPROBAR_Cls") ;
         Dvpanel_panelprobar_Title = httpContext.cgiGet( "DVPANEL_PANELPROBAR_Title") ;
         Dvpanel_panelprobar_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Collapsible")) ;
         Dvpanel_panelprobar_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Collapsed")) ;
         Dvpanel_panelprobar_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Showcollapseicon")) ;
         Dvpanel_panelprobar_Iconposition = httpContext.cgiGet( "DVPANEL_PANELPROBAR_Iconposition") ;
         Dvpanel_panelprobar_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELPROBAR_Autoscroll")) ;
         Dvpanel_panelseusa_Width = httpContext.cgiGet( "DVPANEL_PANELSEUSA_Width") ;
         Dvpanel_panelseusa_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Autowidth")) ;
         Dvpanel_panelseusa_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Autoheight")) ;
         Dvpanel_panelseusa_Cls = httpContext.cgiGet( "DVPANEL_PANELSEUSA_Cls") ;
         Dvpanel_panelseusa_Title = httpContext.cgiGet( "DVPANEL_PANELSEUSA_Title") ;
         Dvpanel_panelseusa_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Collapsible")) ;
         Dvpanel_panelseusa_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Collapsed")) ;
         Dvpanel_panelseusa_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Showcollapseicon")) ;
         Dvpanel_panelseusa_Iconposition = httpContext.cgiGet( "DVPANEL_PANELSEUSA_Iconposition") ;
         Dvpanel_panelseusa_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELSEUSA_Autoscroll")) ;
         Dvpanel_panelusa_Width = httpContext.cgiGet( "DVPANEL_PANELUSA_Width") ;
         Dvpanel_panelusa_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Autowidth")) ;
         Dvpanel_panelusa_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Autoheight")) ;
         Dvpanel_panelusa_Cls = httpContext.cgiGet( "DVPANEL_PANELUSA_Cls") ;
         Dvpanel_panelusa_Title = httpContext.cgiGet( "DVPANEL_PANELUSA_Title") ;
         Dvpanel_panelusa_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Collapsible")) ;
         Dvpanel_panelusa_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Collapsed")) ;
         Dvpanel_panelusa_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Showcollapseicon")) ;
         Dvpanel_panelusa_Iconposition = httpContext.cgiGet( "DVPANEL_PANELUSA_Iconposition") ;
         Dvpanel_panelusa_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSA_Autoscroll")) ;
         Dvpanel_paneluso_Width = httpContext.cgiGet( "DVPANEL_PANELUSO_Width") ;
         Dvpanel_paneluso_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Autowidth")) ;
         Dvpanel_paneluso_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Autoheight")) ;
         Dvpanel_paneluso_Cls = httpContext.cgiGet( "DVPANEL_PANELUSO_Cls") ;
         Dvpanel_paneluso_Title = httpContext.cgiGet( "DVPANEL_PANELUSO_Title") ;
         Dvpanel_paneluso_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Collapsible")) ;
         Dvpanel_paneluso_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Collapsed")) ;
         Dvpanel_paneluso_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Showcollapseicon")) ;
         Dvpanel_paneluso_Iconposition = httpContext.cgiGet( "DVPANEL_PANELUSO_Iconposition") ;
         Dvpanel_paneluso_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELUSO_Autoscroll")) ;
         Dvpanel_panelhis_Width = httpContext.cgiGet( "DVPANEL_PANELHIS_Width") ;
         Dvpanel_panelhis_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Autowidth")) ;
         Dvpanel_panelhis_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Autoheight")) ;
         Dvpanel_panelhis_Cls = httpContext.cgiGet( "DVPANEL_PANELHIS_Cls") ;
         Dvpanel_panelhis_Title = httpContext.cgiGet( "DVPANEL_PANELHIS_Title") ;
         Dvpanel_panelhis_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Collapsible")) ;
         Dvpanel_panelhis_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Collapsed")) ;
         Dvpanel_panelhis_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Showcollapseicon")) ;
         Dvpanel_panelhis_Iconposition = httpContext.cgiGet( "DVPANEL_PANELHIS_Iconposition") ;
         Dvpanel_panelhis_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELHIS_Autoscroll")) ;
         Gridsnippetspaginationbar_Class = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Class") ;
         Gridsnippetspaginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Showfirst")) ;
         Gridsnippetspaginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Showprevious")) ;
         Gridsnippetspaginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Shownext")) ;
         Gridsnippetspaginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Showlast")) ;
         Gridsnippetspaginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridsnippetspaginationbar_Pagingbuttonsposition = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Pagingbuttonsposition") ;
         Gridsnippetspaginationbar_Pagingcaptionposition = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Pagingcaptionposition") ;
         Gridsnippetspaginationbar_Emptygridclass = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Emptygridclass") ;
         Gridsnippetspaginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselector")) ;
         Gridsnippetspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Gridsnippetspaginationbar_Rowsperpageoptions = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageoptions") ;
         Gridsnippetspaginationbar_Previous = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Previous") ;
         Gridsnippetspaginationbar_Next = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Next") ;
         Gridsnippetspaginationbar_Caption = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Caption") ;
         Gridsnippetspaginationbar_Emptygridcaption = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Emptygridcaption") ;
         Gridsnippetspaginationbar_Rowsperpagecaption = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Rowsperpagecaption") ;
         Dvpanel_panelcodgos_Width = httpContext.cgiGet( "DVPANEL_PANELCODGOS_Width") ;
         Dvpanel_panelcodgos_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Autowidth")) ;
         Dvpanel_panelcodgos_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Autoheight")) ;
         Dvpanel_panelcodgos_Cls = httpContext.cgiGet( "DVPANEL_PANELCODGOS_Cls") ;
         Dvpanel_panelcodgos_Title = httpContext.cgiGet( "DVPANEL_PANELCODGOS_Title") ;
         Dvpanel_panelcodgos_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Collapsible")) ;
         Dvpanel_panelcodgos_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Collapsed")) ;
         Dvpanel_panelcodgos_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Showcollapseicon")) ;
         Dvpanel_panelcodgos_Iconposition = httpContext.cgiGet( "DVPANEL_PANELCODGOS_Iconposition") ;
         Dvpanel_panelcodgos_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_PANELCODGOS_Autoscroll")) ;
         Popover_iconoexpl_Iteminternalname = httpContext.cgiGet( "POPOVER_ICONOEXPL_Iteminternalname") ;
         Popover_iconoexpl_Triggerelement = httpContext.cgiGet( "POPOVER_ICONOEXPL_Triggerelement") ;
         Popover_iconoexpl_Popoverwidth = (int)(localUtil.ctol( httpContext.cgiGet( "POPOVER_ICONOEXPL_Popoverwidth"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Popover_iconoexpl_Html = httpContext.cgiGet( "POPOVER_ICONOEXPL_Html") ;
         Popover_iconoexpl_Position = httpContext.cgiGet( "POPOVER_ICONOEXPL_Position") ;
         Gridsnippets_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSNIPPETS_EMPOWERER_Gridinternalname") ;
         Grid1_empowerer_Gridinternalname = httpContext.cgiGet( "GRID1_EMPOWERER_Gridinternalname") ;
         Grid1_empowerer_Infinitescrolling = httpContext.cgiGet( "GRID1_EMPOWERER_Infinitescrolling") ;
         Gridsdt_conceptoss2_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDT_CONCEPTOSS2_EMPOWERER_Gridinternalname") ;
         Gridsdt_conceptoss_empowerer_Gridinternalname = httpContext.cgiGet( "GRIDSDT_CONCEPTOSS_EMPOWERER_Gridinternalname") ;
         Gridsnippetspaginationbar_Selectedpage = httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Selectedpage") ;
         Gridsnippetspaginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( "GRIDSNIPPETSPAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nRC_GXsfl_106 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_106"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_106_fel_idx = 0 ;
         while ( nGXsfl_106_fel_idx < nRC_GXsfl_106 )
         {
            nGXsfl_106_fel_idx = ((subGridsdt_conceptoss_Islastpage==1)&&(nGXsfl_106_fel_idx+1>subgridsdt_conceptoss_fnc_recordsperpage( )) ? 1 : nGXsfl_106_fel_idx+1) ;
            sGXsfl_106_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1062( ) ;
            AV155GXV1 = (int)(nGXsfl_106_fel_idx+GRIDSDT_CONCEPTOSS_nFirstRecordOnPage) ;
            if ( ( AV66sdt_conceptos.size() >= AV155GXV1 ) && ( AV155GXV1 > 0 ) )
            {
               AV66sdt_conceptos.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV66sdt_conceptos.elementAt(-1+AV155GXV1)) );
            }
         }
         if ( nGXsfl_106_fel_idx == 0 )
         {
            nGXsfl_106_idx = 1 ;
            sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1062( ) ;
         }
         nGXsfl_106_fel_idx = 1 ;
         nRC_GXsfl_115 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_115"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         nGXsfl_115_fel_idx = 0 ;
         while ( nGXsfl_115_fel_idx < nRC_GXsfl_115 )
         {
            nGXsfl_115_fel_idx = ((subGridsdt_conceptoss2_Islastpage==1)&&(nGXsfl_115_fel_idx+1>subgridsdt_conceptoss2_fnc_recordsperpage( )) ? 1 : nGXsfl_115_fel_idx+1) ;
            sGXsfl_115_fel_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_fel_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_fel_1157( ) ;
            AV158GXV4 = (int)(nGXsfl_115_fel_idx+GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage) ;
            if ( ( AV84sdt_conceptos2.size() >= AV158GXV4 ) && ( AV158GXV4 > 0 ) )
            {
               AV84sdt_conceptos2.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)) );
            }
         }
         if ( nGXsfl_115_fel_idx == 0 )
         {
            nGXsfl_115_idx = 1 ;
            sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
            subsflControlProps_1157( ) ;
         }
         nGXsfl_115_fel_idx = 1 ;
         /* Read variables values. */
         cmbavConrelsec.setName( cmbavConrelsec.getInternalname() );
         cmbavConrelsec.setValue( httpContext.cgiGet( cmbavConrelsec.getInternalname()) );
         AV146ConRelSec = (int)(GXutil.lval( httpContext.cgiGet( cmbavConrelsec.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV146ConRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV146ConRelSec), 6, 0));
         AV126formulaConDescripciones = httpContext.cgiGet( edtavFormulacondescripciones_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV126formulaConDescripciones", AV126formulaConDescripciones);
         AV119ConFormulaExpl = httpContext.cgiGet( edtavConformulaexpl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV119ConFormulaExpl", AV119ConFormulaExpl);
         AV122IconoExpl = httpContext.cgiGet( edtavIconoexpl_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV122IconoExpl", AV122IconoExpl);
         dynavLegnumero.setName( dynavLegnumero.getInternalname() );
         dynavLegnumero.setValue( httpContext.cgiGet( dynavLegnumero.getInternalname()) );
         AV48LegNumero = (int)(GXutil.lval( httpContext.cgiGet( dynavLegnumero.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48LegNumero), 8, 0));
         dynavLiqnro.setName( dynavLiqnro.getInternalname() );
         dynavLiqnro.setValue( httpContext.cgiGet( dynavLiqnro.getInternalname()) );
         AV51LiqNro = (int)(GXutil.lval( httpContext.cgiGet( dynavLiqnro.getInternalname()))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51LiqNro), 8, 0));
         AV21FormulaAux = httpContext.cgiGet( edtavFormulaaux_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FormulaAux", AV21FormulaAux);
         if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavResultado_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtavResultado_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vRESULTADO");
            GX_FocusControl = edtavResultado_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV65Resultado = DecimalUtil.ZERO ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65Resultado", GXutil.ltrimstr( AV65Resultado, 14, 2));
         }
         else
         {
            AV65Resultado = localUtil.ctond( httpContext.cgiGet( edtavResultado_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV65Resultado", GXutil.ltrimstr( AV65Resultado, 14, 2));
         }
         AV89searchSnippets = httpContext.cgiGet( edtavSearchsnippets_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV89searchSnippets", AV89searchSnippets);
         AV5aCopiar = httpContext.cgiGet( edtavAcopiar_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV5aCopiar", AV5aCopiar);
         AV8Concepto = httpContext.cgiGet( edtavConcepto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8Concepto", AV8Concepto);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGridsnippetscurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGridsnippetscurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGRIDSNIPPETSCURRENTPAGE");
            GX_FocusControl = edtavGridsnippetscurrentpage_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV95GridSnippetsCurrentPage = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
         }
         else
         {
            AV95GridSnippetsCurrentPage = localUtil.ctol( httpContext.cgiGet( edtavGridsnippetscurrentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavClicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavClicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCLICOD");
            GX_FocusControl = edtavClicod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6CliCod = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
         }
         else
         {
            AV6CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtavClicod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavEmpcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vEMPCOD");
            GX_FocusControl = edtavEmpcod_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV16EmpCod = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
         }
         else
         {
            AV16EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtavEmpcod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
         }
         AV20Formula = httpContext.cgiGet( edtavFormula_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV20Formula", AV20Formula);
         AV127ModoVer = httpContext.cgiGet( edtavModover_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV127ModoVer", AV127ModoVer);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e217D2 ();
      if (returnInSub) return;
   }

   public void e217D2( )
   {
      /* Start Routine */
      returnInSub = false ;
      edtavFormulacondescripciones_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormulacondescripciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulacondescripciones_Visible), 5, 0), true);
      edtavAcopiar_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavAcopiar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavAcopiar_Visible), 5, 0), true);
      GXt_int1 = AV16EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      formulawc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV16EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      GXt_int3 = AV6CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      formulawc_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      AV8Concepto = AV10ConCodigo ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8Concepto", AV8Concepto);
      AV78start = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78start", AV78start);
      GXv_int4[0] = AV138clienteNucleoPais_CliCod ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV98PaiCod, GXv_int4) ;
      formulawc_impl.this.AV138clienteNucleoPais_CliCod = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV138clienteNucleoPais_CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV138clienteNucleoPais_CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTENUCLEOPAIS_CLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV138clienteNucleoPais_CliCod), "ZZZZZ9")));
      GXv_boolean5[0] = AV142ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV6CliCod, GXv_boolean5) ;
      formulawc_impl.this.AV142ClienteConveniador = GXv_boolean5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV142ClienteConveniador", AV142ClienteConveniador);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIENTECONVENIADOR", getSecureSignedToken( "", AV142ClienteConveniador));
      GXt_boolean6 = AV141esSistemaConceptosDefault ;
      GXv_boolean5[0] = GXt_boolean6 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      formulawc_impl.this.GXt_boolean6 = GXv_boolean5[0] ;
      AV141esSistemaConceptosDefault = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV141esSistemaConceptosDefault", AV141esSistemaConceptosDefault);
      if ( ( AV142ClienteConveniador ) || ( AV141esSistemaConceptosDefault ) )
      {
         cmbavConrelsec.setVisible( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConrelsec.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConrelsec.getVisible(), 5, 0), true);
         lblTextblockconrelsec_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockconrelsec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockconrelsec_Visible), 5, 0), true);
      }
      else
      {
         cmbavConrelsec.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConrelsec.getInternalname(), "Visible", GXutil.ltrimstr( cmbavConrelsec.getVisible(), 5, 0), true);
         lblTextblockconrelsec_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblTextblockconrelsec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblTextblockconrelsec_Visible), 5, 0), true);
      }
      GXt_char7 = AV99codigoOpeConcepto ;
      GXv_char8[0] = GXt_char7 ;
      new web.codigoopeformula(remoteHandle, context).execute( AV6CliCod, "{concepto}", false, false, GXv_char8) ;
      formulawc_impl.this.GXt_char7 = GXv_char8[0] ;
      AV99codigoOpeConcepto = GXt_char7 ;
      GXt_char7 = AV100codigoOpeRemuVar ;
      GXv_char8[0] = GXt_char7 ;
      new web.codigoopeformula(remoteHandle, context).execute( AV6CliCod, "[remu_var]", false, false, GXv_char8) ;
      formulawc_impl.this.GXt_char7 = GXv_char8[0] ;
      AV100codigoOpeRemuVar = GXt_char7 ;
      AV127ModoVer = httpContext.getMessage( "codigo", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV127ModoVer", AV127ModoVer);
      /* Execute user subroutine: 'INSTANCIAR CONCEPTO' */
      S112 ();
      if (returnInSub) return;
      AV122IconoExpl = httpContext.getMessage( "<i class=\"fa fa-pen\"></i>", "") ;
      httpContext.ajax_rsp_assign_attri("", false, "AV122IconoExpl", AV122IconoExpl);
      GXt_int3 = AV6CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      formulawc_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      Popover_iconoexpl_Iteminternalname = edtavIconoexpl_Internalname ;
      ucPopover_iconoexpl.sendProperty(context, "", false, Popover_iconoexpl_Internalname, "ItemInternalName", Popover_iconoexpl_Iteminternalname);
      edtavConcepto_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavConcepto_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavConcepto_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONCEPTO' */
      S122 ();
      if (returnInSub) return;
      edtavClicod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavClicod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavClicod_Visible), 5, 0), true);
      edtavEmpcod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavEmpcod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavEmpcod_Visible), 5, 0), true);
      edtavFormula_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormula_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormula_Visible), 5, 0), true);
      edtavModover_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavModover_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavModover_Visible), 5, 0), true);
      Gridsnippets_empowerer_Gridinternalname = subGridsnippets_Internalname ;
      ucGridsnippets_empowerer.sendProperty(context, "", false, Gridsnippets_empowerer_Internalname, "GridInternalName", Gridsnippets_empowerer_Gridinternalname);
      subGridsnippets_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Rows, (byte)(6), (byte)(0), ".", "")));
      AV95GridSnippetsCurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
      edtavGridsnippetscurrentpage_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavGridsnippetscurrentpage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGridsnippetscurrentpage_Visible), 5, 0), true);
      AV96GridSnippetsPageCount = -1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV96GridSnippetsPageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV96GridSnippetsPageCount), 10, 0));
      Grid1_empowerer_Gridinternalname = subGrid1_Internalname ;
      ucGrid1_empowerer.sendProperty(context, "", false, Grid1_empowerer_Internalname, "GridInternalName", Grid1_empowerer_Gridinternalname);
      subGrid1_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdt_conceptoss2_empowerer_Gridinternalname = subGridsdt_conceptoss2_Internalname ;
      ucGridsdt_conceptoss2_empowerer.sendProperty(context, "", false, Gridsdt_conceptoss2_empowerer_Internalname, "GridInternalName", Gridsdt_conceptoss2_empowerer_Gridinternalname);
      subGridsdt_conceptoss2_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsdt_conceptoss_empowerer_Gridinternalname = subGridsdt_conceptoss_Internalname ;
      ucGridsdt_conceptoss_empowerer.sendProperty(context, "", false, Gridsdt_conceptoss_empowerer_Internalname, "GridInternalName", Gridsdt_conceptoss_empowerer_Gridinternalname);
      subGridsdt_conceptoss_Rows = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Rows, (byte)(6), (byte)(0), ".", "")));
      Gridsnippetspaginationbar_Rowsperpageselectedvalue = subGridsnippets_Rows ;
      ucGridsnippetspaginationbar.sendProperty(context, "", false, Gridsnippetspaginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Gridsnippetspaginationbar_Rowsperpageselectedvalue), 9, 0));
      new web.setopcionmenusesion(remoteHandle, context).execute( AV147MenuOpcCod, "", "") ;
      GXt_int1 = AV98PaiCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientegetpais(remoteHandle, context).execute( AV6CliCod, GXv_int2) ;
      formulawc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV98PaiCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV98PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV98PaiCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV98PaiCod), "ZZZ9")));
      GXt_boolean6 = AV152historicoHay ;
      GXv_boolean5[0] = GXt_boolean6 ;
      new web.hayhistorico(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_boolean5) ;
      formulawc_impl.this.GXt_boolean6 = GXv_boolean5[0] ;
      AV152historicoHay = GXt_boolean6 ;
   }

   public void e227D2( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_char8[0] = "" ;
      GXv_char9[0] = "NRE_ARG" ;
      GXv_char10[0] = "" ;
      GXv_boolean5[0] = false ;
      GXv_boolean11[0] = false ;
      GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char13[0] = "" ;
      GXv_char14[0] = "" ;
      GXv_char15[0] = "" ;
      GXv_char16[0] = "" ;
      GXv_int4[0] = 0 ;
      GXv_int17[0] = 0 ;
      GXv_char18[0] = AV119ConFormulaExpl ;
      GXv_int19[0] = AV133ConVigencia ;
      GXv_boolean20[0] = false ;
      GXv_boolean21[0] = false ;
      new web.getdatosconcepto(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_char8, GXv_char9, GXv_char10, GXv_boolean5, GXv_boolean11, GXv_decimal12, GXv_char13, GXv_char14, GXv_char15, GXv_char16, GXv_int4, GXv_int17, GXv_char18, GXv_int19, GXv_boolean20, GXv_boolean21) ;
      formulawc_impl.this.AV119ConFormulaExpl = GXv_char18[0] ;
      formulawc_impl.this.AV133ConVigencia = GXv_int19[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV119ConFormulaExpl", AV119ConFormulaExpl);
      new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "refres 1 &ConFormulaExpl ", "")+AV119ConFormulaExpl) ;
      AV61num = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavNum_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61num), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
      GXt_int1 = AV18ForHisNum ;
      GXv_int2[0] = GXt_int1 ;
      new web.getulthis(remoteHandle, context).execute( AV8Concepto, GXv_int2) ;
      formulawc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV18ForHisNum = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18ForHisNum), 4, 0));
      AV18ForHisNum = (short)(AV18ForHisNum-1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18ForHisNum", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18ForHisNum), 4, 0));
      GXt_int3 = AV6CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      formulawc_impl.this.GXt_int3 = GXv_int4[0] ;
      AV6CliCod = GXt_int3 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6CliCod), 6, 0));
      new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "refres 2", "")) ;
      /*  Sending Event outputs  */
   }

   private void e237D2( )
   {
      /* Gridsdt_conceptoss_Load Routine */
      returnInSub = false ;
      AV155GXV1 = 1 ;
      while ( AV155GXV1 <= AV66sdt_conceptos.size() )
      {
         AV66sdt_conceptos.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV66sdt_conceptos.elementAt(-1+AV155GXV1)) );
         if ( ((web.Sdtsdt_conceptos_sdt_conceptosItem)(AV66sdt_conceptos.currentItem())).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto() )
         {
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(106) ;
         }
         if ( ( subGridsdt_conceptoss_Islastpage == 1 ) || ( subGridsdt_conceptoss_Rows == 0 ) || ( ( GRIDSDT_CONCEPTOSS_nCurrentRecord >= GRIDSDT_CONCEPTOSS_nFirstRecordOnPage ) && ( GRIDSDT_CONCEPTOSS_nCurrentRecord < GRIDSDT_CONCEPTOSS_nFirstRecordOnPage + subgridsdt_conceptoss_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1062( ) ;
            GRIDSDT_CONCEPTOSS_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDT_CONCEPTOSS_nCurrentRecord + 1 >= subgridsdt_conceptoss_fnc_recordcount( ) )
            {
               GRIDSDT_CONCEPTOSS_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDT_CONCEPTOSS_nCurrentRecord = (long)(GRIDSDT_CONCEPTOSS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_106_Refreshing )
         {
            httpContext.doAjaxLoad(106, Gridsdt_conceptossRow);
         }
         AV155GXV1 = (int)(AV155GXV1+1) ;
      }
   }

   public void e127D2( )
   {
      /* Gridsnippetspaginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Gridsnippetspaginationbar_Selectedpage, "Previous") == 0 )
      {
         AV95GridSnippetsCurrentPage = (long)(AV95GridSnippetsCurrentPage-1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
         subgridsnippets_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Gridsnippetspaginationbar_Selectedpage, "Next") == 0 )
      {
         AV95GridSnippetsCurrentPage = (long)(AV95GridSnippetsCurrentPage+1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
         subgridsnippets_nextpage( ) ;
      }
      else
      {
         AV63PageToGo = (int)(GXutil.lval( Gridsnippetspaginationbar_Selectedpage)) ;
         AV95GridSnippetsCurrentPage = AV63PageToGo ;
         httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
         subgridsnippets_gotopage( AV63PageToGo) ;
      }
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e137D2( )
   {
      /* Gridsnippetspaginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGridsnippets_Rows = Gridsnippetspaginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_Rows", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Rows, (byte)(6), (byte)(0), ".", "")));
      AV95GridSnippetsCurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV95GridSnippetsCurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV95GridSnippetsCurrentPage), 10, 0));
      subgridsnippets_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   public void e147D2( )
   {
      /* 'DoConfirmar' Routine */
      returnInSub = false ;
      if ( ! new web.permitemodificacionformula(remoteHandle, context).executeUdp( AV6CliCod, AV8Concepto) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Modificación no permitida", "")) ;
      }
      else
      {
         /* Execute user subroutine: 'U_VERIFICAR' */
         S132 ();
         if (returnInSub) return;
         if ( AV19FormOK )
         {
            new web.actformulaconcepto2(remoteHandle, context).execute( AV6CliCod, AV8Concepto, AV20Formula, AV146ConRelSec) ;
            callWebObject(formatLink("web.conceptoww", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "Conceptos", "")))}, new String[] {"MenuOpcCod"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
      }
      /*  Sending Event outputs  */
   }

   public void e157D2( )
   {
      AV158GXV4 = (int)(nGXsfl_115_idx+GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage) ;
      if ( ( AV158GXV4 > 0 ) && ( AV84sdt_conceptos2.size() >= AV158GXV4 ) )
      {
         AV84sdt_conceptos2.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)) );
      }
      /* 'DoVerTodosUsa' Routine */
      returnInSub = false ;
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] = AV84sdt_conceptos2 ;
      new web.queconceptosusa(remoteHandle, context).execute( AV6CliCod, AV10ConCodigo, true, true, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22) ;
      AV84sdt_conceptos2 = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] ;
      gx_BV115 = true ;
      gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
      /*  Sending Event outputs  */
      if ( gx_BV115 )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "AV84sdt_conceptos2", AV84sdt_conceptos2);
         nGXsfl_115_bak_idx = nGXsfl_115_idx ;
         gxgrgridsdt_conceptoss2_refresh( subGridsdt_conceptoss_Rows, subGridsdt_conceptoss2_Rows, subGrid1_Rows, subGridsnippets_Rows, AV6CliCod, AV8Concepto, AV161Pgmname, AV84sdt_conceptos2, AV66sdt_conceptos, AV98PaiCod, AV134LiqPeriodo, AV139date, AV138clienteNucleoPais_CliCod, AV142ClienteConveniador, AV17esConceptosDefault, AV147MenuOpcCod) ;
         nGXsfl_115_idx = nGXsfl_115_bak_idx ;
         sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1157( ) ;
      }
   }

   public void e167D2( )
   {
      /* 'DoActualizar' Routine */
      returnInSub = false ;
      AV78start = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV78start", AV78start);
      /* Execute user subroutine: 'INSTANCIAR FORMULA' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void S122( )
   {
      /* 'LOADCOMBOCONCEPTO' Routine */
      returnInSub = false ;
      /* Using cursor H007D6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV6CliCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A3CliCod = H007D6_A3CliCod[0] ;
         A26ConCodigo = H007D6_A26ConCodigo[0] ;
         A42ConCodYDesc = H007D6_A42ConCodYDesc[0] ;
         n42ConCodYDesc = H007D6_n42ConCodYDesc[0] ;
         AV7Combo_DataItem = (web.wwpbaseobjects.SdtDVB_SDTComboData_Item)new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Id( A26ConCodigo );
         AV7Combo_DataItem.setgxTv_SdtDVB_SDTComboData_Item_Title( A42ConCodYDesc );
         AV9Concepto_Data.add(AV7Combo_DataItem, 0);
         pr_default.readNext(4);
      }
      pr_default.close(4);
      Combo_concepto_Selectedvalue_set = AV8Concepto ;
      ucCombo_concepto.sendProperty(context, "", false, Combo_concepto_Internalname, "SelectedValue_set", Combo_concepto_Selectedvalue_set);
   }

   public void e177D2( )
   {
      /* Modover_Click Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV127ModoVer, httpContext.getMessage( "descripciones", "")) == 0 )
      {
         edtavFormulacondescripciones_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFormulacondescripciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulacondescripciones_Visible), 5, 0), true);
         bttBtnconfirmar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
         tblTablemonaco_Class = httpContext.getMessage( "Invi", "") ;
         httpContext.ajax_rsp_assign_prop("", false, tblTablemonaco_Internalname, "Class", tblTablemonaco_Class, true);
      }
      else
      {
         edtavFormulacondescripciones_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtavFormulacondescripciones_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormulacondescripciones_Visible), 5, 0), true);
         tblTablemonaco_Class = "" ;
         httpContext.ajax_rsp_assign_prop("", false, tblTablemonaco_Internalname, "Class", tblTablemonaco_Class, true);
         GXv_boolean21[0] = AV150permiteModificacion ;
         new web.permitemodificacionformula(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_boolean21) ;
         formulawc_impl.this.AV150permiteModificacion = GXv_boolean21[0] ;
         bttBtnconfirmar_Visible = (AV150permiteModificacion ? 1 : 0) ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
      }
      /*  Sending Event outputs  */
   }

   public void e187D2( )
   {
      /* Iconoexpl_Click Routine */
      returnInSub = false ;
      httpContext.popup(formatLink("web.editarformulaexpl", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "UPD", ""))),GXutil.URLEncode(GXutil.ltrimstr(AV6CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8Concepto))}, new String[] {"TrnMode","CliCod","ConCodigo"}) , new Object[] {});
      httpContext.doAjaxRefresh();
      /*  Sending Event outputs  */
   }

   public void e197D2( )
   {
      /* Liqnro_Click Routine */
      returnInSub = false ;
      GXt_char7 = AV108queryString ;
      GXv_char18[0] = GXt_char7 ;
      new web.getquerystring(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV51LiqNro, AV48LegNumero, AV10ConCodigo, GXv_char18) ;
      formulawc_impl.this.GXt_char7 = GXv_char18[0] ;
      AV108queryString = GXt_char7 ;
      lblJs_Caption = httpContext.getMessage( "<script>setMonacoEditor(false, '", "")+GXutil.trim( AV108queryString)+httpContext.getMessage( "');</script>", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
      /* Execute user subroutine: 'INSTANCIAR FORMULA' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e207D2( )
   {
      /* Legnumero_Click Routine */
      returnInSub = false ;
      bttBtnactualizar_Visible = 1 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnactualizar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnactualizar_Visible), 5, 0), true);
      GXt_char7 = AV108queryString ;
      GXv_char18[0] = GXt_char7 ;
      new web.getquerystring(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV51LiqNro, AV48LegNumero, AV10ConCodigo, GXv_char18) ;
      formulawc_impl.this.GXt_char7 = GXv_char18[0] ;
      AV108queryString = GXt_char7 ;
      lblJs_Caption = httpContext.getMessage( "<script>setMonacoEditor(false, '", "")+GXutil.trim( AV108queryString)+httpContext.getMessage( "');</script>", "") ;
      httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
      /* Execute user subroutine: 'INSTANCIAR FORMULA' */
      S142 ();
      if (returnInSub) return;
      /*  Sending Event outputs  */
   }

   public void e247D2( )
   {
      /* 'DoNOUSADOS' Routine */
      returnInSub = false ;
      new web.reportarconceptosnousados(remoteHandle, context).execute( AV6CliCod) ;
   }

   public void e287D2( )
   {
      /* Copysnippet_Click Routine */
      returnInSub = false ;
      AV5aCopiar = AV94OpeCodFormula ;
      httpContext.ajax_rsp_assign_attri("", false, "AV5aCopiar", AV5aCopiar);
      GXt_char7 = "" ;
      GXv_char18[0] = GXt_char7 ;
      new web.jscopytoclipboard(remoteHandle, context).execute( edtavAcopiar_Internalname, GXv_char18) ;
      formulawc_impl.this.GXt_char7 = GXv_char18[0] ;
      lblJs_Caption = GXt_char7 ;
      httpContext.ajax_rsp_assign_prop("", false, lblJs_Internalname, "Caption", lblJs_Caption, true);
      AV14copySnippet = "<i class=\"fas fa-clipboard-check\"></i>" ;
      httpContext.ajax_rsp_assign_attri("", false, edtavCopysnippet_Internalname, AV14copySnippet);
      /*  Sending Event outputs  */
   }

   public void S132( )
   {
      /* 'U_VERIFICAR' Routine */
      returnInSub = false ;
      AV19FormOK = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
      GXv_char18[0] = AV20Formula ;
      new web.corregirespaciosformula(remoteHandle, context).execute( AV6CliCod, GXv_char18) ;
      formulawc_impl.this.AV20Formula = GXv_char18[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Formula", AV20Formula);
      if ( ( AV142ClienteConveniador ) || ( AV17esConceptosDefault ) )
      {
         if ( (0==AV146ConRelSec) )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Debe ingresar liberación de actualización", "")) ;
            AV19FormOK = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
         }
         else
         {
            GXv_boolean21[0] = AV145aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV6CliCod, AV146ConRelSec, GXv_boolean21) ;
            formulawc_impl.this.AV145aplicadoHay = GXv_boolean21[0] ;
            if ( AV145aplicadoHay )
            {
               new web.alert(remoteHandle, context).execute( "error", new web.txterrorrelease(remoteHandle, context).executeUdp( AV6CliCod)) ;
               AV19FormOK = false ;
               httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
            }
         }
      }
      if ( (GXutil.strcmp("", AV20Formula)==0) )
      {
         new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Ingrese fórmula", "")) ;
         AV19FormOK = false ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
      }
      else
      {
         GXv_char18[0] = AV137mensualTLiqCod ;
         new web.getparametro(remoteHandle, context).execute( AV6CliCod, new web.tipoliqmensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char18) ;
         formulawc_impl.this.AV137mensualTLiqCod = GXv_char18[0] ;
         GXv_char18[0] = AV123error ;
         new web.formulavalidarsintaxiscalculos(remoteHandle, context).execute( AV6CliCod, AV8Concepto, AV20Formula, GXv_char18) ;
         formulawc_impl.this.AV123error = GXv_char18[0] ;
         if ( ! (GXutil.strcmp("", AV123error)==0) )
         {
            AV19FormOK = false ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
         }
         else
         {
            GXv_boolean21[0] = AV143formulaOK ;
            GXv_char18[0] = AV123error ;
            GXv_char16[0] = "" ;
            GXv_char15[0] = "" ;
            GXv_char14[0] = "" ;
            GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean20[0] = false ;
            GXv_decimal23[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean11[0] = false ;
            GXv_decimal24[0] = DecimalUtil.doubleToDec(0) ;
            GXv_decimal25[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean5[0] = false ;
            GXv_char13[0] = "" ;
            GXv_decimal26[0] = DecimalUtil.doubleToDec(0) ;
            GXv_boolean27[0] = false ;
            new web.resolverformula(remoteHandle, context).execute( AV6CliCod, AV8Concepto, AV20Formula, "", (short)(0), 0, 0, 0, 0, AV137mensualTLiqCod, AV134LiqPeriodo, httpContext.getMessage( "EDITOR", ""), "Calculo", true, DecimalUtil.doubleToDec(0), AV139date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean21, GXv_char18, GXv_char16, GXv_char15, GXv_char14, GXv_decimal12, GXv_boolean20, GXv_decimal23, GXv_boolean11, GXv_decimal24, GXv_decimal25, GXv_boolean5, GXv_char13, GXv_decimal26, GXv_boolean27) ;
            formulawc_impl.this.AV143formulaOK = GXv_boolean21[0] ;
            formulawc_impl.this.AV123error = GXv_char18[0] ;
            if ( ! AV143formulaOK )
            {
               AV19FormOK = false ;
               httpContext.ajax_rsp_assign_attri("", false, "AV19FormOK", AV19FormOK);
            }
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "&error ", "")+AV123error) ;
         if ( AV19FormOK )
         {
            new web.alert(remoteHandle, context).execute( "success", httpContext.getMessage( "Sintaxis de Formula Correcta", "")) ;
         }
         else
         {
            httpContext.GX_msglist.addItem(httpContext.getMessage( "error: ", "")+AV123error);
         }
      }
   }

   public void S142( )
   {
      /* 'INSTANCIAR FORMULA' Routine */
      returnInSub = false ;
      new web.limpiarsesionliquidacion(remoteHandle, context).execute( ) ;
      new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "instanciar formula 4", "")) ;
      if ( (GXutil.strcmp("", AV20Formula)==0) )
      {
         new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "instanciar formula 5", "")) ;
         if ( ! AV78start )
         {
            new web.alert(remoteHandle, context).execute( "error", httpContext.getMessage( "Ingrese fórmula!!", "")) ;
         }
      }
      else
      {
         new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "instanciar formula 6", "")) ;
         AV21FormulaAux = "" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FormulaAux", AV21FormulaAux);
         new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "instanciar formula 7", "")) ;
         AV65Resultado = DecimalUtil.ZERO ;
         httpContext.ajax_rsp_assign_attri("", false, "AV65Resultado", GXutil.ltrimstr( AV65Resultado, 14, 2));
         new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV51LiqNro, 8, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV48LegNumero, 8, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV16EmpCod, 4, 0))) ;
         GXv_boolean27[0] = AV62ok ;
         GXv_char18[0] = AV57msgInstanciar ;
         GXv_char16[0] = AV124formulaError ;
         GXv_char15[0] = AV21FormulaAux ;
         GXv_char14[0] = AV126formulaConDescripciones ;
         GXv_decimal26[0] = AV65Resultado ;
         GXv_boolean21[0] = AV125dependenciasResueltas ;
         GXv_decimal25[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean20[0] = false ;
         GXv_decimal24[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal23[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean11[0] = false ;
         GXv_char13[0] = "" ;
         GXv_decimal12[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean5[0] = false ;
         new web.resolverformula(remoteHandle, context).execute( AV6CliCod, AV8Concepto, AV20Formula, AV20Formula, AV16EmpCod, AV51LiqNro, 0, AV51LiqNro, AV48LegNumero, "", AV134LiqPeriodo, httpContext.getMessage( "EDITOR", ""), "Calculo", true, DecimalUtil.doubleToDec(0), AV139date, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_boolean27, GXv_char18, GXv_char16, GXv_char15, GXv_char14, GXv_decimal26, GXv_boolean21, GXv_decimal25, GXv_boolean20, GXv_decimal24, GXv_decimal23, GXv_boolean11, GXv_char13, GXv_decimal12, GXv_boolean5) ;
         formulawc_impl.this.AV62ok = GXv_boolean27[0] ;
         formulawc_impl.this.AV57msgInstanciar = GXv_char18[0] ;
         formulawc_impl.this.AV124formulaError = GXv_char16[0] ;
         formulawc_impl.this.AV21FormulaAux = GXv_char15[0] ;
         formulawc_impl.this.AV126formulaConDescripciones = GXv_char14[0] ;
         formulawc_impl.this.AV65Resultado = GXv_decimal26[0] ;
         formulawc_impl.this.AV125dependenciasResueltas = GXv_boolean21[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21FormulaAux", AV21FormulaAux);
         httpContext.ajax_rsp_assign_attri("", false, "AV126formulaConDescripciones", AV126formulaConDescripciones);
         httpContext.ajax_rsp_assign_attri("", false, "AV65Resultado", GXutil.ltrimstr( AV65Resultado, 14, 2));
         new web.msgdebug2(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "&FormulaAux ", "")+AV21FormulaAux) ;
         if ( ! AV62ok && ! (0==AV48LegNumero) )
         {
            new web.alert(remoteHandle, context).execute( "error", AV57msgInstanciar) ;
            if ( ! (GXutil.strcmp("", AV124formulaError)==0) )
            {
               AV21FormulaAux = AV124formulaError ;
               httpContext.ajax_rsp_assign_attri("", false, "AV21FormulaAux", AV21FormulaAux);
            }
            else
            {
               if ( ! AV125dependenciasResueltas )
               {
                  GXt_char7 = AV21FormulaAux ;
                  GXv_char18[0] = GXt_char7 ;
                  new web.descripcionerrordependencia(remoteHandle, context).execute( AV6CliCod, GXv_char18) ;
                  formulawc_impl.this.GXt_char7 = GXv_char18[0] ;
                  AV21FormulaAux = GXt_char7 ;
                  httpContext.ajax_rsp_assign_attri("", false, "AV21FormulaAux", AV21FormulaAux);
               }
            }
         }
      }
   }

   public void S112( )
   {
      /* 'INSTANCIAR CONCEPTO' Routine */
      returnInSub = false ;
      if ( ( AV142ClienteConveniador ) || ( AV141esSistemaConceptosDefault ) )
      {
         cmbavConrelsec.removeAllItems();
         cmbavConrelsec.addItem("0", httpContext.getMessage( "Seleccionar", ""), (short)(0));
         /* Using cursor H007D7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(AV6CliCod)});
         while ( (pr_default.getStatus(5) != 101) )
         {
            A3CliCod = H007D7_A3CliCod[0] ;
            A1880CliReDTChar = H007D7_A1880CliReDTChar[0] ;
            A1885CliRelSec = H007D7_A1885CliRelSec[0] ;
            cmbavConrelsec.addItem(GXutil.trim( GXutil.str( A1885CliRelSec, 6, 0)), A1880CliReDTChar, (short)(0));
            pr_default.readNext(5);
         }
         pr_default.close(5);
      }
      GXt_boolean6 = AV17esConceptosDefault ;
      GXv_boolean27[0] = GXt_boolean6 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean27) ;
      formulawc_impl.this.GXt_boolean6 = GXv_boolean27[0] ;
      AV17esConceptosDefault = GXt_boolean6 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV17esConceptosDefault", AV17esConceptosDefault);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vESCONCEPTOSDEFAULT", getSecureSignedToken( "", AV17esConceptosDefault));
      GXv_char18[0] = AV12ConDescrip ;
      GXv_char16[0] = "NRE_ARG" ;
      GXv_char15[0] = AV107ConFormula ;
      GXv_boolean27[0] = AV13ConForEditable ;
      GXv_boolean21[0] = false ;
      GXv_decimal26[0] = DecimalUtil.doubleToDec(0) ;
      GXv_char14[0] = "" ;
      GXv_char13[0] = "" ;
      GXv_char10[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_int4[0] = 0 ;
      GXv_int17[0] = 0 ;
      GXv_char8[0] = AV119ConFormulaExpl ;
      GXv_int19[0] = AV133ConVigencia ;
      GXv_boolean20[0] = false ;
      GXv_boolean11[0] = false ;
      new web.getdatosconcepto(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_char18, GXv_char16, GXv_char15, GXv_boolean27, GXv_boolean21, GXv_decimal26, GXv_char14, GXv_char13, GXv_char10, GXv_char9, GXv_int4, GXv_int17, GXv_char8, GXv_int19, GXv_boolean20, GXv_boolean11) ;
      formulawc_impl.this.AV12ConDescrip = GXv_char18[0] ;
      formulawc_impl.this.AV107ConFormula = GXv_char15[0] ;
      formulawc_impl.this.AV13ConForEditable = GXv_boolean27[0] ;
      formulawc_impl.this.AV119ConFormulaExpl = GXv_char8[0] ;
      formulawc_impl.this.AV133ConVigencia = GXv_int19[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV119ConFormulaExpl", AV119ConFormulaExpl);
      GXv_char18[0] = AV149ConPadre ;
      new web.getconpadre(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_char18) ;
      formulawc_impl.this.AV149ConPadre = GXv_char18[0] ;
      GXv_int4[0] = AV146ConRelSec ;
      new web.getconceptorelease(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_int4) ;
      formulawc_impl.this.AV146ConRelSec = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV146ConRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV146ConRelSec), 6, 0));
      new web.msgdebug_prod(remoteHandle, context).execute( AV161Pgmname, httpContext.getMessage( "&ConFormulaExpl ", "")+AV119ConFormulaExpl) ;
      AV20Formula = AV107ConFormula ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20Formula", AV20Formula);
      GXt_int1 = AV16EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      formulawc_impl.this.GXt_int1 = GXv_int2[0] ;
      AV16EmpCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16EmpCod), 4, 0));
      if ( ! (0==AV114parmLegNumero) )
      {
         AV48LegNumero = AV114parmLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "AV48LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV48LegNumero), 8, 0));
      }
      if ( (0==AV115parmLiqNro) )
      {
         GXt_int3 = AV51LiqNro ;
         GXv_int4[0] = GXt_int3 ;
         new web.getultliq(remoteHandle, context).execute( AV16EmpCod, AV48LegNumero, GXv_int4) ;
         formulawc_impl.this.GXt_int3 = GXv_int4[0] ;
         AV51LiqNro = GXt_int3 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51LiqNro), 8, 0));
      }
      else
      {
         AV51LiqNro = AV115parmLiqNro ;
         httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV51LiqNro), 8, 0));
      }
      GXv_boolean27[0] = false ;
      GXv_boolean21[0] = false ;
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] = AV66sdt_conceptos ;
      GXv_boolean20[0] = false ;
      new web.analizarconceptosuso(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, 0, 0, AV8Concepto, AV135TipoConCod, httpContext.getMessage( "TODOS", ""), true, false, false, GXv_boolean27, GXv_boolean21, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22, GXv_boolean20) ;
      AV66sdt_conceptos = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] ;
      gx_BV106 = true ;
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] = AV84sdt_conceptos2 ;
      new web.queconceptosusa(remoteHandle, context).execute( AV6CliCod, AV8Concepto, false, true, GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22) ;
      AV84sdt_conceptos2 = GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[0] ;
      gx_BV115 = true ;
      edtavFormula_Enabled = ((GXutil.strcmp("", AV149ConPadre)==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtavFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavFormula_Enabled), 5, 0), true);
      GXv_boolean27[0] = AV150permiteModificacion ;
      new web.permitemodificacionformula(remoteHandle, context).execute( AV6CliCod, AV8Concepto, GXv_boolean27) ;
      formulawc_impl.this.AV150permiteModificacion = GXv_boolean27[0] ;
      bttBtnconfirmar_Visible = (AV150permiteModificacion ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtnconfirmar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnconfirmar_Visible), 5, 0), true);
      GXv_char18[0] = AV50lineNumbers_OnOff ;
      GXv_char16[0] = AV81wordWrap ;
      GXv_char15[0] = AV82wordWrapColumn ;
      GXv_char14[0] = AV52monaco_foreground ;
      GXv_char13[0] = AV53monaco_minimap ;
      GXv_char10[0] = AV64readonly ;
      GXv_char9[0] = AV55monacoTokens ;
      GXv_char8[0] = AV56monacoTokensStyle ;
      GXv_char28[0] = AV80urlSugerencias ;
      GXv_char29[0] = AV58nombreLenguaje ;
      GXv_char30[0] = AV54monacoBrackets ;
      GXv_char31[0] = AV75sistema ;
      new web.getparametrosmonacoeditor(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV51LiqNro, AV48LegNumero, AV8Concepto, GXv_char18, GXv_char16, GXv_char15, GXv_char14, GXv_char13, GXv_char10, GXv_char9, GXv_char8, GXv_char28, GXv_char29, GXv_char30, GXv_char31) ;
      formulawc_impl.this.AV50lineNumbers_OnOff = GXv_char18[0] ;
      formulawc_impl.this.AV81wordWrap = GXv_char16[0] ;
      formulawc_impl.this.AV82wordWrapColumn = GXv_char15[0] ;
      formulawc_impl.this.AV52monaco_foreground = GXv_char14[0] ;
      formulawc_impl.this.AV53monaco_minimap = GXv_char13[0] ;
      formulawc_impl.this.AV64readonly = GXv_char10[0] ;
      formulawc_impl.this.AV55monacoTokens = GXv_char9[0] ;
      formulawc_impl.this.AV56monacoTokensStyle = GXv_char8[0] ;
      formulawc_impl.this.AV80urlSugerencias = GXv_char28[0] ;
      formulawc_impl.this.AV58nombreLenguaje = GXv_char29[0] ;
      formulawc_impl.this.AV54monacoBrackets = GXv_char30[0] ;
      formulawc_impl.this.AV75sistema = GXv_char31[0] ;
      tblTblparm_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, tblTblparm_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblparm_Visible), 5, 0), true);
      /* Execute user subroutine: 'INSTANCIAR FORMULA' */
      S142 ();
      if (returnInSub) return;
      AV151monacoConFormula = GXutil.strReplace( AV20Formula, GXutil.chr( (short)(13)), httpContext.getMessage( "\\r", "")) ;
      AV151monacoConFormula = GXutil.strReplace( AV151monacoConFormula, GXutil.chr( (short)(10)), httpContext.getMessage( "\\n", "")) ;
      Monacoeditor1_Monaco_editor_id = httpContext.getMessage( "monaco_edit", "") ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_editor_id", Monacoeditor1_Monaco_editor_id);
      Monacoeditor1_Monaco_brackets = AV54monacoBrackets ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_brackets", Monacoeditor1_Monaco_brackets);
      Monacoeditor1_Monaco_columns = AV82wordWrapColumn ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_Columns", Monacoeditor1_Monaco_columns);
      Monacoeditor1_Monaco_foreground = AV52monaco_foreground ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_foreground", Monacoeditor1_Monaco_foreground);
      Monacoeditor1_Monaco_linenumbers = AV50lineNumbers_OnOff ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_lineNumbers", Monacoeditor1_Monaco_linenumbers);
      Monacoeditor1_Monaco_minimap = AV53monaco_minimap ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_miniMap", Monacoeditor1_Monaco_minimap);
      Monacoeditor1_Monaco_readonly = AV64readonly ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_readOnly", Monacoeditor1_Monaco_readonly);
      Monacoeditor1_Monaco_tokens = AV55monacoTokens ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_tokens", Monacoeditor1_Monaco_tokens);
      Monacoeditor1_Monaco_tokens_style = AV56monacoTokensStyle ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_tokens_style", Monacoeditor1_Monaco_tokens_style);
      Monacoeditor1_Monaco_url_sug = AV80urlSugerencias ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_url_sug", Monacoeditor1_Monaco_url_sug);
      Monacoeditor1_Monaco_wordwrap = AV81wordWrap ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "monaco_wordWrap", Monacoeditor1_Monaco_wordwrap);
      Monacoeditor1_Nombrelenguaje = AV58nombreLenguaje ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "nombreLenguaje", Monacoeditor1_Nombrelenguaje);
      Monacoeditor1_Valorinicial = GXutil.trim( AV151monacoConFormula) ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "valorInicial", Monacoeditor1_Valorinicial);
      Monacoeditor1_Variable_asociada = edtavFormula_Internalname ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "variable_asociada", Monacoeditor1_Variable_asociada);
      GXt_char7 = "" ;
      GXv_char31[0] = GXt_char7 ;
      new web.codigoopeformula(remoteHandle, context).execute( AV6CliCod, "{concepto}", true, true, GXv_char31) ;
      formulawc_impl.this.GXt_char7 = GXv_char31[0] ;
      Monacoeditor1_Palabra_concepto = GXt_char7 ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "palabra_concepto", Monacoeditor1_Palabra_concepto);
      GXt_char7 = "" ;
      GXv_char31[0] = GXt_char7 ;
      new web.getquerystring(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV115parmLiqNro, AV114parmLegNumero, AV10ConCodigo, GXv_char31) ;
      formulawc_impl.this.GXt_char7 = GXv_char31[0] ;
      Monacoeditor1_Url_sug_querystring = GXt_char7 ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "url_sug_QueryString", Monacoeditor1_Url_sug_querystring);
      Monacoeditor1_Permitidos = httpContext.getMessage( "['ABS(','INT(','FRAC(','SQRT(','POW(','ROUND(','FLOOR(','MAX(', 'MIN(', 'SI(', ',', '*', '/', '+', '-', '>', '<', '(', ')', ' Y ', ' O ']", "") ;
      ucMonacoeditor1.sendProperty(context, "", false, Monacoeditor1_Internalname, "permitidos", Monacoeditor1_Permitidos);
      GXv_boolean27[0] = AV120hayLiquidaciones ;
      new web.hayliquidaciones(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, GXv_boolean27) ;
      formulawc_impl.this.AV120hayLiquidaciones = GXv_boolean27[0] ;
      tblTblprobar_Visible = ((!AV17esConceptosDefault&&AV120hayLiquidaciones) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, tblTblprobar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(tblTblprobar_Visible), 5, 0), true);
      if ( ! (0==AV114parmLegNumero) )
      {
      }
      else
      {
         bttBtnactualizar_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtnactualizar_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtnactualizar_Visible), 5, 0), true);
      }
   }

   private void e277D3( )
   {
      /* Gridsnippets_Load Routine */
      returnInSub = false ;
      if ( (0==AV51LiqNro) )
      {
         AV132OpeCliVig = GXutil.serverDate( context, remoteHandle, pr_default) ;
      }
      else
      {
         GXv_date32[0] = AV132OpeCliVig ;
         new web.getperiodoliquidacion(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV51LiqNro, GXv_date32) ;
         formulawc_impl.this.AV132OpeCliVig = GXv_date32[0] ;
      }
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           AV89searchSnippets ,
                                           A82OpeCliId ,
                                           A534OpeCliDescrip ,
                                           Integer.valueOf(AV6CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV89searchSnippets = GXutil.padr( GXutil.rtrim( AV89searchSnippets), 20, "%") ;
      lV89searchSnippets = GXutil.padr( GXutil.rtrim( AV89searchSnippets), 20, "%") ;
      /* Using cursor H007D8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV6CliCod), lV89searchSnippets, lV89searchSnippets});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A534OpeCliDescrip = H007D8_A534OpeCliDescrip[0] ;
         A82OpeCliId = H007D8_A82OpeCliId[0] ;
         A3CliCod = H007D8_A3CliCod[0] ;
         A549OpeCliCodFormula = H007D8_A549OpeCliCodFormula[0] ;
         AV117idOperando = "" ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavIdoperando.getInternalname(), AV117idOperando);
         AV116OpeCliId = A82OpeCliId ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOpecliid_Internalname, AV116OpeCliId);
         AV94OpeCodFormula = GXutil.trim( A549OpeCliCodFormula) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOpecodformula_Internalname, AV94OpeCodFormula);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, GXutil.rtrim( localUtil.format( AV94OpeCodFormula, ""))));
         AV14copySnippet = "<i class=\"far fa-clone\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCopysnippet_Internalname, AV14copySnippet);
         AV61num = (short)(AV61num+1) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavNum_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61num), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
         AV136ProcesoLiquidacion = "Calculo" ;
         GXv_char31[0] = AV131OpeCliValor ;
         GXv_char30[0] = "" ;
         new web.getopeclivalor(remoteHandle, context).execute( AV6CliCod, A82OpeCliId, AV132OpeCliVig, AV136ProcesoLiquidacion, GXv_char31, GXv_char30) ;
         formulawc_impl.this.AV131OpeCliValor = GXv_char31[0] ;
         edtavOpecodformula_Tooltiptext = GXutil.trim( A534OpeCliDescrip)+" = "+GXutil.trim( AV131OpeCliValor) ;
         AV102entidad = httpContext.getMessage( "CLIENTE", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavEntidad_Internalname, AV102entidad);
         AV112editarSnippet = "<i class=\"fas fa-edit fas fa-edit\"></i>" ;
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(159) ;
         }
         if ( ( subGridsnippets_Islastpage == 1 ) || ( subGridsnippets_Rows == 0 ) || ( ( GRIDSNIPPETS_nCurrentRecord >= GRIDSNIPPETS_nFirstRecordOnPage ) && ( GRIDSNIPPETS_nCurrentRecord < GRIDSNIPPETS_nFirstRecordOnPage + subgridsnippets_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1593( ) ;
            GRIDSNIPPETS_nEOF = (byte)(1) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGridsnippets_Islastpage == 1 ) && ( ((int)((GRIDSNIPPETS_nCurrentRecord) % (subgridsnippets_fnc_recordsperpage( )))) == 0 ) )
            {
               GRIDSNIPPETS_nFirstRecordOnPage = GRIDSNIPPETS_nCurrentRecord ;
            }
         }
         if ( GRIDSNIPPETS_nCurrentRecord >= GRIDSNIPPETS_nFirstRecordOnPage + subgridsnippets_fnc_recordsperpage( ) )
         {
            GRIDSNIPPETS_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRIDSNIPPETS_nCurrentRecord = (long)(GRIDSNIPPETS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_159_Refreshing )
         {
            httpContext.doAjaxLoad(159, GridsnippetsRow);
         }
         pr_default.readNext(6);
      }
      pr_default.close(6);
      pr_default.dynParam(7, new Object[]{ new Object[]{
                                           AV89searchSnippets ,
                                           A473OpeCodFormula ,
                                           A474OpeDescripcion ,
                                           Short.valueOf(AV98PaiCod) ,
                                           Short.valueOf(A46PaiCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV89searchSnippets = GXutil.padr( GXutil.rtrim( AV89searchSnippets), 20, "%") ;
      lV89searchSnippets = GXutil.padr( GXutil.rtrim( AV89searchSnippets), 20, "%") ;
      /* Using cursor H007D9 */
      pr_default.execute(7, new Object[] {Short.valueOf(AV98PaiCod), lV89searchSnippets, lV89searchSnippets});
      while ( (pr_default.getStatus(7) != 101) )
      {
         A474OpeDescripcion = H007D9_A474OpeDescripcion[0] ;
         A473OpeCodFormula = H007D9_A473OpeCodFormula[0] ;
         A46PaiCod = H007D9_A46PaiCod[0] ;
         A74idOperando = H007D9_A74idOperando[0] ;
         AV94OpeCodFormula = GXutil.trim( A473OpeCodFormula) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOpecodformula_Internalname, AV94OpeCodFormula);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vOPECODFORMULA"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, GXutil.rtrim( localUtil.format( AV94OpeCodFormula, ""))));
         AV116OpeCliId = A74idOperando ;
         httpContext.ajax_rsp_assign_attri("", false, edtavOpecliid_Internalname, AV116OpeCliId);
         AV117idOperando = A74idOperando ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavIdoperando.getInternalname(), AV117idOperando);
         AV14copySnippet = "<i class=\"far fa-clone\"></i>" ;
         httpContext.ajax_rsp_assign_attri("", false, edtavCopysnippet_Internalname, AV14copySnippet);
         if ( false )
         {
            edtavCopysnippet_Class = "Attribute" ;
         }
         else
         {
            edtavCopysnippet_Class = "Invisible" ;
         }
         AV61num = (short)(AV61num+1) ;
         httpContext.ajax_rsp_assign_attri("", false, edtavNum_Internalname, GXutil.ltrimstr( DecimalUtil.doubleToDec(AV61num), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vNUM"+"_"+sGXsfl_159_idx, getSecureSignedToken( sGXsfl_159_idx, localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")));
         GXv_objcol_SdtSDTOperandosFormula33[0] = AV110SDTOperandosFormula ;
         new web.armaroperandosolo(remoteHandle, context).execute( AV6CliCod, A473OpeCodFormula, GXv_objcol_SdtSDTOperandosFormula33) ;
         AV110SDTOperandosFormula = GXv_objcol_SdtSDTOperandosFormula33[0] ;
         GXv_char31[0] = AV137mensualTLiqCod ;
         new web.getparametro(remoteHandle, context).execute( AV6CliCod, new web.tipoliqmensual_codigoparam(remoteHandle, context).executeUdp( ), GXv_char31) ;
         formulawc_impl.this.AV137mensualTLiqCod = GXv_char31[0] ;
         GXv_objcol_SdtSDTOperandosFormula33[0] = AV110SDTOperandosFormula ;
         GXv_boolean27[0] = false ;
         GXv_char31[0] = "" ;
         GXv_decimal26[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean21[0] = false ;
         GXv_decimal25[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal24[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean20[0] = false ;
         GXv_char30[0] = "" ;
         GXv_decimal23[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean11[0] = false ;
         new web.resuelveoperandos2(remoteHandle, context).execute( AV6CliCod, AV16EmpCod, AV51LiqNro, 0, AV48LegNumero, AV137mensualTLiqCod, AV134LiqPeriodo, AV51LiqNro, AV10ConCodigo, "Calculo", AV161Pgmname, false, true, DecimalUtil.doubleToDec(0), AV139date, GXv_objcol_SdtSDTOperandosFormula33, GXv_boolean27, GXv_char31, GXv_decimal26, GXv_boolean21, GXv_decimal25, GXv_decimal24, GXv_boolean20, GXv_char30, GXv_decimal23, GXv_boolean11) ;
         AV110SDTOperandosFormula = GXv_objcol_SdtSDTOperandosFormula33[0] ;
         if ( AV6CliCod == AV138clienteNucleoPais_CliCod )
         {
            edtavOpecodformula_Tooltiptext = GXutil.trim( A474OpeDescripcion) ;
         }
         else
         {
            edtavOpecodformula_Tooltiptext = GXutil.trim( A474OpeDescripcion)+" = "+GXutil.trim( ((web.SdtSDTOperandosFormula)AV110SDTOperandosFormula.elementAt(-1+1)).getgxTv_SdtSDTOperandosFormula_Operandocambiado()) ;
         }
         AV102entidad = httpContext.getMessage( "Cálculo", "") ;
         httpContext.ajax_rsp_assign_attri("", false, edtavEntidad_Internalname, AV102entidad);
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(159) ;
         }
         if ( ( subGridsnippets_Islastpage == 1 ) || ( subGridsnippets_Rows == 0 ) || ( ( GRIDSNIPPETS_nCurrentRecord >= GRIDSNIPPETS_nFirstRecordOnPage ) && ( GRIDSNIPPETS_nCurrentRecord < GRIDSNIPPETS_nFirstRecordOnPage + subgridsnippets_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1593( ) ;
            GRIDSNIPPETS_nEOF = (byte)(1) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( ( subGridsnippets_Islastpage == 1 ) && ( ((int)((GRIDSNIPPETS_nCurrentRecord) % (subgridsnippets_fnc_recordsperpage( )))) == 0 ) )
            {
               GRIDSNIPPETS_nFirstRecordOnPage = GRIDSNIPPETS_nCurrentRecord ;
            }
         }
         if ( GRIDSNIPPETS_nCurrentRecord >= GRIDSNIPPETS_nFirstRecordOnPage + subgridsnippets_fnc_recordsperpage( ) )
         {
            GRIDSNIPPETS_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSNIPPETS_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSNIPPETS_nEOF, (byte)(1), (byte)(0), ".", "")));
         }
         GRIDSNIPPETS_nCurrentRecord = (long)(GRIDSNIPPETS_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_159_Refreshing )
         {
            httpContext.doAjaxLoad(159, GridsnippetsRow);
         }
         pr_default.readNext(7);
      }
      pr_default.close(7);
      /*  Sending Event outputs  */
      cmbavIdoperando.setValue( GXutil.rtrim( AV117idOperando) );
   }

   private void e267D6( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(131) ;
      }
      sendrow_1316( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_131_Refreshing )
      {
         httpContext.doAjaxLoad(131, Grid1Row);
      }
   }

   private void e257D7( )
   {
      /* Gridsdt_conceptoss2_Load Routine */
      returnInSub = false ;
      AV158GXV4 = 1 ;
      while ( AV158GXV4 <= AV84sdt_conceptos2.size() )
      {
         AV84sdt_conceptos2.currentItem( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)) );
         if ( ((web.Sdtsdt_conceptos_sdt_conceptosItem)(AV84sdt_conceptos2.currentItem())).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Esconcepto() )
         {
         }
         /* Load Method */
         if ( wbStart != -1 )
         {
            wbStart = (short)(115) ;
         }
         if ( ( subGridsdt_conceptoss2_Islastpage == 1 ) || ( subGridsdt_conceptoss2_Rows == 0 ) || ( ( GRIDSDT_CONCEPTOSS2_nCurrentRecord >= GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage ) && ( GRIDSDT_CONCEPTOSS2_nCurrentRecord < GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage + subgridsdt_conceptoss2_fnc_recordsperpage( ) ) ) )
         {
            sendrow_1157( ) ;
            GRIDSDT_CONCEPTOSS2_nEOF = (byte)(0) ;
            web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nEOF, (byte)(1), (byte)(0), ".", "")));
            if ( GRIDSDT_CONCEPTOSS2_nCurrentRecord + 1 >= subgridsdt_conceptoss2_fnc_recordcount( ) )
            {
               GRIDSDT_CONCEPTOSS2_nEOF = (byte)(1) ;
               web.GxWebStd.gx_hidden_field( httpContext, "GRIDSDT_CONCEPTOSS2_nEOF", GXutil.ltrim( localUtil.ntoc( GRIDSDT_CONCEPTOSS2_nEOF, (byte)(1), (byte)(0), ".", "")));
            }
         }
         GRIDSDT_CONCEPTOSS2_nCurrentRecord = (long)(GRIDSDT_CONCEPTOSS2_nCurrentRecord+1) ;
         if ( isFullAjaxMode( ) && ! bGXsfl_115_Refreshing )
         {
            httpContext.doAjaxLoad(115, Gridsdt_conceptoss2Row);
         }
         AV158GXV4 = (int)(AV158GXV4+1) ;
      }
   }

   public void wb_table1_9_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "p30", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-11", "left", "top", "", "", "div");
         wb_table2_15_7D2( true) ;
      }
      else
      {
         wb_table2_15_7D2( false) ;
      }
      return  ;
   }

   public void wb_table2_15_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-1", "left", "top", "", "", "div");
         wb_table3_140_7D2( true) ;
      }
      else
      {
         wb_table3_140_7D2( false) ;
      }
      return  ;
   }

   public void wb_table3_140_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table1_9_7D2e( true) ;
      }
      else
      {
         wb_table1_9_7D2e( false) ;
      }
   }

   public void wb_table3_140_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblparm_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblparm_Internalname, tblTblparm_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table4_143_7D2( true) ;
      }
      else
      {
         wb_table4_143_7D2( false) ;
      }
      return  ;
   }

   public void wb_table4_143_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table3_140_7D2e( true) ;
      }
      else
      {
         wb_table3_140_7D2e( false) ;
      }
   }

   public void wb_table4_143_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTblvar_Internalname, tblTblvar_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelcodgos.setProperty("Width", Dvpanel_panelcodgos_Width);
         ucDvpanel_panelcodgos.setProperty("AutoWidth", Dvpanel_panelcodgos_Autowidth);
         ucDvpanel_panelcodgos.setProperty("AutoHeight", Dvpanel_panelcodgos_Autoheight);
         ucDvpanel_panelcodgos.setProperty("Cls", Dvpanel_panelcodgos_Cls);
         ucDvpanel_panelcodgos.setProperty("Title", Dvpanel_panelcodgos_Title);
         ucDvpanel_panelcodgos.setProperty("Collapsible", Dvpanel_panelcodgos_Collapsible);
         ucDvpanel_panelcodgos.setProperty("Collapsed", Dvpanel_panelcodgos_Collapsed);
         ucDvpanel_panelcodgos.setProperty("ShowCollapseIcon", Dvpanel_panelcodgos_Showcollapseicon);
         ucDvpanel_panelcodgos.setProperty("IconPosition", Dvpanel_panelcodgos_Iconposition);
         ucDvpanel_panelcodgos.setProperty("AutoScroll", Dvpanel_panelcodgos_Autoscroll);
         ucDvpanel_panelcodgos.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelcodgos_Internalname, "DVPANEL_PANELCODGOSContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELCODGOSContainer"+"PanelCodgos"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelcodgos_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavSearchsnippets_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavSearchsnippets_Internalname, httpContext.getMessage( "Buscar", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavSearchsnippets_Internalname, GXutil.rtrim( AV89searchSnippets), GXutil.rtrim( localUtil.format( AV89searchSnippets, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,153);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavSearchsnippets_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavSearchsnippets_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGridsnippetstablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridsnippetsContainer.SetWrapped(nGXWrapped);
         startgridcontrol159( ) ;
      }
      if ( wbEnd == 159 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_159 = (int)(nGXsfl_159_idx-1) ;
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridsnippetsContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsnippets", GridsnippetsContainer, subGridsnippets_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridsnippetsContainerData", GridsnippetsContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridsnippetsContainerData"+"V", GridsnippetsContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridsnippetsContainerData"+"V"+"\" value='"+GridsnippetsContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGridsnippetspaginationbar.setProperty("Class", Gridsnippetspaginationbar_Class);
         ucGridsnippetspaginationbar.setProperty("ShowFirst", Gridsnippetspaginationbar_Showfirst);
         ucGridsnippetspaginationbar.setProperty("ShowPrevious", Gridsnippetspaginationbar_Showprevious);
         ucGridsnippetspaginationbar.setProperty("ShowNext", Gridsnippetspaginationbar_Shownext);
         ucGridsnippetspaginationbar.setProperty("ShowLast", Gridsnippetspaginationbar_Showlast);
         ucGridsnippetspaginationbar.setProperty("PagesToShow", Gridsnippetspaginationbar_Pagestoshow);
         ucGridsnippetspaginationbar.setProperty("PagingButtonsPosition", Gridsnippetspaginationbar_Pagingbuttonsposition);
         ucGridsnippetspaginationbar.setProperty("PagingCaptionPosition", Gridsnippetspaginationbar_Pagingcaptionposition);
         ucGridsnippetspaginationbar.setProperty("EmptyGridClass", Gridsnippetspaginationbar_Emptygridclass);
         ucGridsnippetspaginationbar.setProperty("RowsPerPageSelector", Gridsnippetspaginationbar_Rowsperpageselector);
         ucGridsnippetspaginationbar.setProperty("RowsPerPageOptions", Gridsnippetspaginationbar_Rowsperpageoptions);
         ucGridsnippetspaginationbar.setProperty("Previous", Gridsnippetspaginationbar_Previous);
         ucGridsnippetspaginationbar.setProperty("Next", Gridsnippetspaginationbar_Next);
         ucGridsnippetspaginationbar.setProperty("Caption", Gridsnippetspaginationbar_Caption);
         ucGridsnippetspaginationbar.setProperty("EmptyGridCaption", Gridsnippetspaginationbar_Emptygridcaption);
         ucGridsnippetspaginationbar.setProperty("RowsPerPageCaption", Gridsnippetspaginationbar_Rowsperpagecaption);
         ucGridsnippetspaginationbar.setProperty("CurrentPage", AV95GridSnippetsCurrentPage);
         ucGridsnippetspaginationbar.setProperty("PageCount", AV96GridSnippetsPageCount);
         ucGridsnippetspaginationbar.setProperty("AppliedFilters", AV97GridSnippetsAppliedFilters);
         ucGridsnippetspaginationbar.render(context, "dvelop.dvpaginationbar", Gridsnippetspaginationbar_Internalname, "GRIDSNIPPETSPAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table4_143_7D2e( true) ;
      }
      else
      {
         wb_table4_143_7D2e( false) ;
      }
   }

   public void wb_table2_15_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTableleft_Internalname, tblTableleft_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table5_18_7D2( true) ;
      }
      else
      {
         wb_table5_18_7D2( false) ;
      }
      return  ;
   }

   public void wb_table5_18_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_explpanel.setProperty("Width", Dvpanel_explpanel_Width);
         ucDvpanel_explpanel.setProperty("AutoWidth", Dvpanel_explpanel_Autowidth);
         ucDvpanel_explpanel.setProperty("AutoHeight", Dvpanel_explpanel_Autoheight);
         ucDvpanel_explpanel.setProperty("Cls", Dvpanel_explpanel_Cls);
         ucDvpanel_explpanel.setProperty("Title", Dvpanel_explpanel_Title);
         ucDvpanel_explpanel.setProperty("Collapsible", Dvpanel_explpanel_Collapsible);
         ucDvpanel_explpanel.setProperty("Collapsed", Dvpanel_explpanel_Collapsed);
         ucDvpanel_explpanel.setProperty("ShowCollapseIcon", Dvpanel_explpanel_Showcollapseicon);
         ucDvpanel_explpanel.setProperty("IconPosition", Dvpanel_explpanel_Iconposition);
         ucDvpanel_explpanel.setProperty("AutoScroll", Dvpanel_explpanel_Autoscroll);
         ucDvpanel_explpanel.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_explpanel_Internalname, "DVPANEL_EXPLPANELContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_EXPLPANELContainer"+"ExplPanel"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divExplpanel_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavConformulaexpl_Internalname, httpContext.getMessage( "Con Formula Expl", ""), "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavConformulaexpl_Internalname, AV119ConFormulaExpl, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", (short)(0), 1, edtavConformulaexpl_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavIconoexpl_Internalname+"\"", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavIconoexpl_Internalname, GXutil.rtrim( AV122IconoExpl), GXutil.rtrim( localUtil.format( AV122IconoExpl, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+"EVICONOEXPL.CLICK."+"'", "", "", "", "", edtavIconoexpl_Jsonclick, 5, "Attribute", "", "", "", "", 1, edtavIconoexpl_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(1), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table6_64_7D2( true) ;
      }
      else
      {
         wb_table6_64_7D2( false) ;
      }
      return  ;
   }

   public void wb_table6_64_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table7_93_7D2( true) ;
      }
      else
      {
         wb_table7_93_7D2( false) ;
      }
      return  ;
   }

   public void wb_table7_93_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table8_123_7D2( true) ;
      }
      else
      {
         wb_table8_123_7D2( false) ;
      }
      return  ;
   }

   public void wb_table8_123_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table2_15_7D2e( true) ;
      }
      else
      {
         wb_table2_15_7D2e( false) ;
      }
   }

   public void wb_table8_123_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTblhist_Internalname, tblTblhist_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelhis.setProperty("Width", Dvpanel_panelhis_Width);
         ucDvpanel_panelhis.setProperty("AutoWidth", Dvpanel_panelhis_Autowidth);
         ucDvpanel_panelhis.setProperty("AutoHeight", Dvpanel_panelhis_Autoheight);
         ucDvpanel_panelhis.setProperty("Cls", Dvpanel_panelhis_Cls);
         ucDvpanel_panelhis.setProperty("Title", Dvpanel_panelhis_Title);
         ucDvpanel_panelhis.setProperty("Collapsible", Dvpanel_panelhis_Collapsible);
         ucDvpanel_panelhis.setProperty("Collapsed", Dvpanel_panelhis_Collapsed);
         ucDvpanel_panelhis.setProperty("ShowCollapseIcon", Dvpanel_panelhis_Showcollapseicon);
         ucDvpanel_panelhis.setProperty("IconPosition", Dvpanel_panelhis_Iconposition);
         ucDvpanel_panelhis.setProperty("AutoScroll", Dvpanel_panelhis_Autoscroll);
         ucDvpanel_panelhis.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelhis_Internalname, "DVPANEL_PANELHISContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELHISContainer"+"PanelHis"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelhis_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol131( ) ;
      }
      if ( wbEnd == 131 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_131 = (int)(nGXsfl_131_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
            Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table8_123_7D2e( true) ;
      }
      else
      {
         wb_table8_123_7D2e( false) ;
      }
   }

   public void wb_table7_93_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTbluso_Internalname, tblTbluso_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_paneluso.setProperty("Width", Dvpanel_paneluso_Width);
         ucDvpanel_paneluso.setProperty("AutoWidth", Dvpanel_paneluso_Autowidth);
         ucDvpanel_paneluso.setProperty("AutoHeight", Dvpanel_paneluso_Autoheight);
         ucDvpanel_paneluso.setProperty("Cls", Dvpanel_paneluso_Cls);
         ucDvpanel_paneluso.setProperty("Title", Dvpanel_paneluso_Title);
         ucDvpanel_paneluso.setProperty("Collapsible", Dvpanel_paneluso_Collapsible);
         ucDvpanel_paneluso.setProperty("Collapsed", Dvpanel_paneluso_Collapsed);
         ucDvpanel_paneluso.setProperty("ShowCollapseIcon", Dvpanel_paneluso_Showcollapseicon);
         ucDvpanel_paneluso.setProperty("IconPosition", Dvpanel_paneluso_Iconposition);
         ucDvpanel_paneluso.setProperty("AutoScroll", Dvpanel_paneluso_Autoscroll);
         ucDvpanel_paneluso.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_paneluso_Internalname, "DVPANEL_PANELUSOContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELUSOContainer"+"PanelUso"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPaneluso_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelseusa.setProperty("Width", Dvpanel_panelseusa_Width);
         ucDvpanel_panelseusa.setProperty("AutoWidth", Dvpanel_panelseusa_Autowidth);
         ucDvpanel_panelseusa.setProperty("AutoHeight", Dvpanel_panelseusa_Autoheight);
         ucDvpanel_panelseusa.setProperty("Cls", Dvpanel_panelseusa_Cls);
         ucDvpanel_panelseusa.setProperty("Title", Dvpanel_panelseusa_Title);
         ucDvpanel_panelseusa.setProperty("Collapsible", Dvpanel_panelseusa_Collapsible);
         ucDvpanel_panelseusa.setProperty("Collapsed", Dvpanel_panelseusa_Collapsed);
         ucDvpanel_panelseusa.setProperty("ShowCollapseIcon", Dvpanel_panelseusa_Showcollapseicon);
         ucDvpanel_panelseusa.setProperty("IconPosition", Dvpanel_panelseusa_Iconposition);
         ucDvpanel_panelseusa.setProperty("AutoScroll", Dvpanel_panelseusa_Autoscroll);
         ucDvpanel_panelseusa.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelseusa_Internalname, "DVPANEL_PANELSEUSAContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELSEUSAContainer"+"PanelSeUsa"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelseusa_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridsdt_conceptossContainer.SetWrapped(nGXWrapped);
         startgridcontrol106( ) ;
      }
      if ( wbEnd == 106 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_106 = (int)(nGXsfl_106_idx-1) ;
         if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nEOF", GRIDSDT_CONCEPTOSS_nEOF);
            Gridsdt_conceptossContainer.AddObjectProperty("GRIDSDT_CONCEPTOSS_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS_nFirstRecordOnPage);
            AV155GXV1 = nGXsfl_106_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridsdt_conceptossContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_conceptoss", Gridsdt_conceptossContainer, subGridsdt_conceptoss_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptossContainerData", Gridsdt_conceptossContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptossContainerData"+"V", Gridsdt_conceptossContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_conceptossContainerData"+"V"+"\" value='"+Gridsdt_conceptossContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* User Defined Control */
         ucDvpanel_panelusa.setProperty("Width", Dvpanel_panelusa_Width);
         ucDvpanel_panelusa.setProperty("AutoWidth", Dvpanel_panelusa_Autowidth);
         ucDvpanel_panelusa.setProperty("AutoHeight", Dvpanel_panelusa_Autoheight);
         ucDvpanel_panelusa.setProperty("Cls", Dvpanel_panelusa_Cls);
         ucDvpanel_panelusa.setProperty("Title", Dvpanel_panelusa_Title);
         ucDvpanel_panelusa.setProperty("Collapsible", Dvpanel_panelusa_Collapsible);
         ucDvpanel_panelusa.setProperty("Collapsed", Dvpanel_panelusa_Collapsed);
         ucDvpanel_panelusa.setProperty("ShowCollapseIcon", Dvpanel_panelusa_Showcollapseicon);
         ucDvpanel_panelusa.setProperty("IconPosition", Dvpanel_panelusa_Iconposition);
         ucDvpanel_panelusa.setProperty("AutoScroll", Dvpanel_panelusa_Autoscroll);
         ucDvpanel_panelusa.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelusa_Internalname, "DVPANEL_PANELUSAContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELUSAContainer"+"PanelUsa"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelusa_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         Gridsdt_conceptoss2Container.SetWrapped(nGXWrapped);
         startgridcontrol115( ) ;
      }
      if ( wbEnd == 115 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_115 = (int)(nGXsfl_115_idx-1) ;
         if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Gridsdt_conceptoss2Container.AddObjectProperty("GRIDSDT_CONCEPTOSS2_nEOF", GRIDSDT_CONCEPTOSS2_nEOF);
            Gridsdt_conceptoss2Container.AddObjectProperty("GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage", GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage);
            AV158GXV4 = nGXsfl_115_idx ;
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Gridsdt_conceptoss2Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Gridsdt_conceptoss2", Gridsdt_conceptoss2Container, subGridsdt_conceptoss2_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptoss2ContainerData", Gridsdt_conceptoss2Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "Gridsdt_conceptoss2ContainerData"+"V", Gridsdt_conceptoss2Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridsdt_conceptoss2ContainerData"+"V"+"\" value='"+Gridsdt_conceptoss2Container.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnvertodosusa_Internalname, "gx.evt.setGridEvt("+GXutil.str( 106, 3, 0)+","+"null"+");", httpContext.getMessage( "Ver Todos", ""), bttBtnvertodosusa_Jsonclick, 5, httpContext.getMessage( "Ver Todos", ""), "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOVERTODOSUSA\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table7_93_7D2e( true) ;
      }
      else
      {
         wb_table7_93_7D2e( false) ;
      }
   }

   public void wb_table6_64_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         if ( tblTblprobar_Visible == 0 )
         {
            sStyleString += "display:none;" ;
         }
         web.GxWebStd.gx_table_start( httpContext, tblTblprobar_Internalname, tblTblprobar_Internalname, "", "TableMain", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucDvpanel_panelprobar.setProperty("Width", Dvpanel_panelprobar_Width);
         ucDvpanel_panelprobar.setProperty("AutoWidth", Dvpanel_panelprobar_Autowidth);
         ucDvpanel_panelprobar.setProperty("AutoHeight", Dvpanel_panelprobar_Autoheight);
         ucDvpanel_panelprobar.setProperty("Cls", Dvpanel_panelprobar_Cls);
         ucDvpanel_panelprobar.setProperty("Title", Dvpanel_panelprobar_Title);
         ucDvpanel_panelprobar.setProperty("Collapsible", Dvpanel_panelprobar_Collapsible);
         ucDvpanel_panelprobar.setProperty("Collapsed", Dvpanel_panelprobar_Collapsed);
         ucDvpanel_panelprobar.setProperty("ShowCollapseIcon", Dvpanel_panelprobar_Showcollapseicon);
         ucDvpanel_panelprobar.setProperty("IconPosition", Dvpanel_panelprobar_Iconposition);
         ucDvpanel_panelprobar.setProperty("AutoScroll", Dvpanel_panelprobar_Autoscroll);
         ucDvpanel_panelprobar.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_panelprobar_Internalname, "DVPANEL_PANELPROBARContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_PANELPROBARContainer"+"PanelProbar"+"\" style=\"display:none;\">") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divPanelprobar_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavLegnumero.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLegnumero.getInternalname(), httpContext.getMessage( "Legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLegnumero, dynavLegnumero.getInternalname(), GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)), 1, dynavLegnumero.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVLEGNUMERO.CLICK."+"'", "int", "", 1, dynavLegnumero.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,74);\"", "", true, (byte)(0), "HLP_FormulaWC.htm");
         dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLegnumero.getInternalname(), "Values", dynavLegnumero.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynavLiqnro.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, dynavLiqnro.getInternalname(), httpContext.getMessage( "Liquidacion", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, dynavLiqnro, dynavLiqnro.getInternalname(), GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)), 1, dynavLiqnro.getJsonclick(), 5, "'"+""+"'"+",false,"+"'"+"EVLIQNRO.CLICK."+"'", "int", "", 1, dynavLiqnro.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"", "", true, (byte)(0), "HLP_FormulaWC.htm");
         dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynavLiqnro.getInternalname(), "Values", dynavLiqnro.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavFormulaaux_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavFormulaaux_Internalname, httpContext.getMessage( "Fórmula instanciada", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 83,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFormulaaux_Internalname, AV21FormulaAux, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,83);\"", (short)(1), 1, edtavFormulaaux_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2097152", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavResultado_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavResultado_Internalname, httpContext.getMessage( "Resultado", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavResultado_Internalname, GXutil.ltrim( localUtil.ntoc( AV65Resultado, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtavResultado_Enabled!=0) ? localUtil.format( AV65Resultado, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( AV65Resultado, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavResultado_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavResultado_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 90,'',false,'',0)\"" ;
         ClassString = "Button" ;
         StyleString = "" ;
         web.GxWebStd.gx_button_ctrl( httpContext, bttBtnactualizar_Internalname, "gx.evt.setGridEvt("+GXutil.str( 106, 3, 0)+","+"null"+");", httpContext.getMessage( "Actualizar fórmula instanciada", ""), bttBtnactualizar_Jsonclick, 5, httpContext.getMessage( "Actualizar fórmula instanciada", ""), "", StyleString, ClassString, bttBtnactualizar_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"E\\'DOACTUALIZAR\\'."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table6_64_7D2e( true) ;
      }
      else
      {
         wb_table6_64_7D2e( false) ;
      }
   }

   public void wb_table5_18_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTblconcepto_Internalname, tblTblconcepto_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DscTop ExtendedComboCell'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablesplittedconcepto_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockcombo_concepto_Internalname, httpContext.getMessage( "Concepto", ""), "", "", lblTextblockcombo_concepto_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucCombo_concepto.setProperty("Caption", Combo_concepto_Caption);
         ucCombo_concepto.setProperty("Cls", Combo_concepto_Cls);
         ucCombo_concepto.setProperty("EmptyItem", Combo_concepto_Emptyitem);
         ucCombo_concepto.setProperty("DropDownOptionsData", AV9Concepto_Data);
         ucCombo_concepto.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_concepto_Internalname, "COMBO_CONCEPTOContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td class='DscTop'>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divUnnamedtableconrelsec_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 MergeLabelCell", "left", "top", "", "", "div");
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconrelsec_Internalname, httpContext.getMessage( "Liberación", ""), "", "", lblTextblockconrelsec_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", lblTextblockconrelsec_Visible, 1, 0, (short)(0), "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavConrelsec.getInternalname(), httpContext.getMessage( "Con Rel Sec", ""), "col-sm-3 AttributeLabel", 0, true, "");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 35,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavConrelsec, cmbavConrelsec.getInternalname(), GXutil.trim( GXutil.str( AV146ConRelSec, 6, 0)), 1, cmbavConrelsec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbavConrelsec.getVisible(), cmbavConrelsec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,35);\"", "", true, (byte)(0), "HLP_FormulaWC.htm");
         cmbavConrelsec.setValue( GXutil.trim( GXutil.str( AV146ConRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavConrelsec.getInternalname(), "Values", cmbavConrelsec.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Text block */
         web.GxWebStd.gx_label_ctrl( httpContext, lblTextblock1_Internalname, httpContext.getMessage( "Fórmula", ""), "", "", lblTextblock1_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_FormulaWC.htm");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         wb_table9_41_7D2( true) ;
      }
      else
      {
         wb_table9_41_7D2( false) ;
      }
      return  ;
   }

   public void wb_table9_41_7D2e( boolean wbgen )
   {
      if ( wbgen )
      {
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavFormulacondescripciones_Internalname, httpContext.getMessage( "formula Con Descripciones", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 48,'',false,'" + sGXsfl_106_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavFormulacondescripciones_Internalname, AV126formulaConDescripciones, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,48);\"", (short)(0), edtavFormulacondescripciones_Visible, edtavFormulacondescripciones_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_FormulaWC.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table5_18_7D2e( true) ;
      }
      else
      {
         wb_table5_18_7D2e( false) ;
      }
   }

   public void wb_table9_41_7D2( boolean wbgen )
   {
      if ( wbgen )
      {
         /* Table start */
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, tblTablemonaco_Internalname, tblTablemonaco_Internalname, "", tblTablemonaco_Class, 0, "", "", 1, 2, sStyleString, "", "", 0);
         httpContext.writeText( "<tr>") ;
         httpContext.writeText( "<td>") ;
         /* User Defined Control */
         ucMonacoeditor1.render(context, "a3lmonacoeditor2", Monacoeditor1_Internalname, "MONACOEDITOR1Container");
         httpContext.writeText( "</td>") ;
         httpContext.writeText( "</tr>") ;
         /* End of table */
         httpContext.writeText( "</table>") ;
         wb_table9_41_7D2e( true) ;
      }
      else
      {
         wb_table9_41_7D2e( false) ;
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV147MenuOpcCod = (String)getParm(obj,0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV147MenuOpcCod", AV147MenuOpcCod);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMENUOPCCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV147MenuOpcCod, ""))));
      AV10ConCodigo = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10ConCodigo", AV10ConCodigo);
      AV115parmLiqNro = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV115parmLiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV115parmLiqNro), 8, 0));
      AV114parmLegNumero = ((Number) GXutil.testNumericType( getParm(obj,3), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV114parmLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV114parmLegNumero), 8, 0));
      AV83llamador = (String)getParm(obj,4) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV83llamador", AV83llamador);
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa7D2( ) ;
      ws7D2( ) ;
      we7D2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddStyleSheetFile("DVelop/Bootstrap/Shared/DVelopBootstrap.css", "");
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713401213", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("formulawc.js", "?20251713401213", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("UserControls/A3LMonacoEditor2Render.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Popover/WWPPopoverRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_1062( )
   {
      edtavSdt_conceptos__concodigo_Internalname = "SDT_CONCEPTOS__CONCODIGO_"+sGXsfl_106_idx ;
      edtavSdt_conceptos__condescrip_Internalname = "SDT_CONCEPTOS__CONDESCRIP_"+sGXsfl_106_idx ;
   }

   public void subsflControlProps_fel_1062( )
   {
      edtavSdt_conceptos__concodigo_Internalname = "SDT_CONCEPTOS__CONCODIGO_"+sGXsfl_106_fel_idx ;
      edtavSdt_conceptos__condescrip_Internalname = "SDT_CONCEPTOS__CONDESCRIP_"+sGXsfl_106_fel_idx ;
   }

   public void sendrow_1062( )
   {
      subsflControlProps_1062( ) ;
      wb7D0( ) ;
      if ( ( subGridsdt_conceptoss_Rows * 1 == 0 ) || ( nGXsfl_106_idx <= subgridsdt_conceptoss_fnc_recordsperpage( ) * 1 ) )
      {
         Gridsdt_conceptossRow = GXWebRow.GetNew(context,Gridsdt_conceptossContainer) ;
         if ( subGridsdt_conceptoss_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdt_conceptoss_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdt_conceptoss_Class, "") != 0 )
            {
               subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Odd" ;
            }
         }
         else if ( subGridsdt_conceptoss_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdt_conceptoss_Backstyle = (byte)(0) ;
            subGridsdt_conceptoss_Backcolor = subGridsdt_conceptoss_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdt_conceptoss_Class, "") != 0 )
            {
               subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Uniform" ;
            }
         }
         else if ( subGridsdt_conceptoss_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdt_conceptoss_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdt_conceptoss_Class, "") != 0 )
            {
               subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Odd" ;
            }
            subGridsdt_conceptoss_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdt_conceptoss_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdt_conceptoss_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_106_idx) % (2))) == 0 )
            {
               subGridsdt_conceptoss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_conceptoss_Class, "") != 0 )
               {
                  subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Even" ;
               }
            }
            else
            {
               subGridsdt_conceptoss_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_conceptoss_Class, "") != 0 )
               {
                  subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Odd" ;
               }
            }
         }
         if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_106_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_conceptossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_conceptos__concodigo_Internalname,GXutil.rtrim( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV66sdt_conceptos.elementAt(-1+AV155GXV1)).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo()),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_conceptos__concodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_conceptos__concodigo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(106),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_conceptossRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_conceptos__condescrip_Internalname,((web.Sdtsdt_conceptos_sdt_conceptosItem)AV66sdt_conceptos.elementAt(-1+AV155GXV1)).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_conceptos__condescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_conceptos__condescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(106),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes7D2( ) ;
         Gridsdt_conceptossContainer.AddRow(Gridsdt_conceptossRow);
         nGXsfl_106_idx = ((subGridsdt_conceptoss_Islastpage==1)&&(nGXsfl_106_idx+1>subgridsdt_conceptoss_fnc_recordsperpage( )) ? 1 : nGXsfl_106_idx+1) ;
         sGXsfl_106_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_106_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1062( ) ;
      }
      /* End function sendrow_1062 */
   }

   public void subsflControlProps_1157( )
   {
      edtavSdt_conceptos2__concodigo_Internalname = "SDT_CONCEPTOS2__CONCODIGO_"+sGXsfl_115_idx ;
      edtavSdt_conceptos2__condescrip_Internalname = "SDT_CONCEPTOS2__CONDESCRIP_"+sGXsfl_115_idx ;
   }

   public void subsflControlProps_fel_1157( )
   {
      edtavSdt_conceptos2__concodigo_Internalname = "SDT_CONCEPTOS2__CONCODIGO_"+sGXsfl_115_fel_idx ;
      edtavSdt_conceptos2__condescrip_Internalname = "SDT_CONCEPTOS2__CONDESCRIP_"+sGXsfl_115_fel_idx ;
   }

   public void sendrow_1157( )
   {
      subsflControlProps_1157( ) ;
      wb7D0( ) ;
      if ( ( subGridsdt_conceptoss2_Rows * 1 == 0 ) || ( nGXsfl_115_idx <= subgridsdt_conceptoss2_fnc_recordsperpage( ) * 1 ) )
      {
         Gridsdt_conceptoss2Row = GXWebRow.GetNew(context,Gridsdt_conceptoss2Container) ;
         if ( subGridsdt_conceptoss2_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsdt_conceptoss2_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsdt_conceptoss2_Class, "") != 0 )
            {
               subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Odd" ;
            }
         }
         else if ( subGridsdt_conceptoss2_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsdt_conceptoss2_Backstyle = (byte)(0) ;
            subGridsdt_conceptoss2_Backcolor = subGridsdt_conceptoss2_Allbackcolor ;
            if ( GXutil.strcmp(subGridsdt_conceptoss2_Class, "") != 0 )
            {
               subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Uniform" ;
            }
         }
         else if ( subGridsdt_conceptoss2_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsdt_conceptoss2_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsdt_conceptoss2_Class, "") != 0 )
            {
               subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Odd" ;
            }
            subGridsdt_conceptoss2_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsdt_conceptoss2_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsdt_conceptoss2_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_115_idx) % (2))) == 0 )
            {
               subGridsdt_conceptoss2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_conceptoss2_Class, "") != 0 )
               {
                  subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Even" ;
               }
            }
            else
            {
               subGridsdt_conceptoss2_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsdt_conceptoss2_Class, "") != 0 )
               {
                  subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Odd" ;
               }
            }
         }
         if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_115_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_conceptoss2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_conceptos2__concodigo_Internalname,GXutil.rtrim( ((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Concodigo()),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_conceptos2__concodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_conceptos2__concodigo_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(115),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Gridsdt_conceptoss2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavSdt_conceptos2__condescrip_Internalname,((web.Sdtsdt_conceptos_sdt_conceptosItem)AV84sdt_conceptos2.elementAt(-1+AV158GXV4)).getgxTv_Sdtsdt_conceptos_sdt_conceptosItem_Condescrip(),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavSdt_conceptos2__condescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavSdt_conceptos2__condescrip_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(115),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes7D7( ) ;
         Gridsdt_conceptoss2Container.AddRow(Gridsdt_conceptoss2Row);
         nGXsfl_115_idx = ((subGridsdt_conceptoss2_Islastpage==1)&&(nGXsfl_115_idx+1>subgridsdt_conceptoss2_fnc_recordsperpage( )) ? 1 : nGXsfl_115_idx+1) ;
         sGXsfl_115_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_115_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1157( ) ;
      }
      /* End function sendrow_1157 */
   }

   public void subsflControlProps_1316( )
   {
      edtForHisFecha_Internalname = "FORHISFECHA_"+sGXsfl_131_idx ;
      edtForHisUsuario_Internalname = "FORHISUSUARIO_"+sGXsfl_131_idx ;
      edtForHisDespues_Internalname = "FORHISDESPUES_"+sGXsfl_131_idx ;
      edtForHisNum_Internalname = "FORHISNUM_"+sGXsfl_131_idx ;
      edtImpSec_Internalname = "IMPSEC_"+sGXsfl_131_idx ;
      edtForHisAntes_Internalname = "FORHISANTES_"+sGXsfl_131_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_131_idx ;
   }

   public void subsflControlProps_fel_1316( )
   {
      edtForHisFecha_Internalname = "FORHISFECHA_"+sGXsfl_131_fel_idx ;
      edtForHisUsuario_Internalname = "FORHISUSUARIO_"+sGXsfl_131_fel_idx ;
      edtForHisDespues_Internalname = "FORHISDESPUES_"+sGXsfl_131_fel_idx ;
      edtForHisNum_Internalname = "FORHISNUM_"+sGXsfl_131_fel_idx ;
      edtImpSec_Internalname = "IMPSEC_"+sGXsfl_131_fel_idx ;
      edtForHisAntes_Internalname = "FORHISANTES_"+sGXsfl_131_fel_idx ;
      edtConCodigo_Internalname = "CONCODIGO_"+sGXsfl_131_fel_idx ;
   }

   public void sendrow_1316( )
   {
      subsflControlProps_1316( ) ;
      wb7D0( ) ;
      if ( ( subGrid1_Rows * 1 == 0 ) || ( nGXsfl_131_idx - GRID1_nFirstRecordOnPage <= subgrid1_fnc_recordsperpage( ) * 1 ) )
      {
         Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            subGrid1_Backcolor = subGrid1_Allbackcolor ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
            subGrid1_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid1_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_131_idx) % (2))) == 0 )
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Even" ;
               }
            }
            else
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Odd" ;
               }
            }
         }
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_131_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtForHisFecha_Internalname,localUtil.ttoc( A223ForHisFecha, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "),localUtil.format( A223ForHisFecha, "99/99/99 99:99"),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtForHisFecha_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(14),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtForHisUsuario_Internalname,A224ForHisUsuario,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtForHisUsuario_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"Usuario","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtForHisDespues_Internalname,A222ForHisDespues,A222ForHisDespues,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtForHisDespues_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(false),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtForHisNum_Internalname,GXutil.ltrim( localUtil.ntoc( A51ForHisNum, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A51ForHisNum), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtForHisNum_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtImpSec_Internalname,GXutil.ltrim( localUtil.ntoc( A52ImpSec, (byte)(18), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A52ImpSec), "ZZZZZZZZZZZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtImpSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(18),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(false),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtForHisAntes_Internalname,A221ForHisAntes,A221ForHisAntes,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtForHisAntes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2000),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(false),"Obs","left",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(131),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(false),"CodConcepto","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashes7D6( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_131_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_131_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_131_idx+1) ;
         sGXsfl_131_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_131_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1316( ) ;
      }
      /* End function sendrow_1316 */
   }

   public void subsflControlProps_1593( )
   {
      edtavOpecodformula_Internalname = "vOPECODFORMULA_"+sGXsfl_159_idx ;
      edtavCopysnippet_Internalname = "vCOPYSNIPPET_"+sGXsfl_159_idx ;
      edtavNum_Internalname = "vNUM_"+sGXsfl_159_idx ;
      edtavEntidad_Internalname = "vENTIDAD_"+sGXsfl_159_idx ;
      edtavOpecliid_Internalname = "vOPECLIID_"+sGXsfl_159_idx ;
      cmbavIdoperando.setInternalname( "vIDOPERANDO_"+sGXsfl_159_idx );
   }

   public void subsflControlProps_fel_1593( )
   {
      edtavOpecodformula_Internalname = "vOPECODFORMULA_"+sGXsfl_159_fel_idx ;
      edtavCopysnippet_Internalname = "vCOPYSNIPPET_"+sGXsfl_159_fel_idx ;
      edtavNum_Internalname = "vNUM_"+sGXsfl_159_fel_idx ;
      edtavEntidad_Internalname = "vENTIDAD_"+sGXsfl_159_fel_idx ;
      edtavOpecliid_Internalname = "vOPECLIID_"+sGXsfl_159_fel_idx ;
      cmbavIdoperando.setInternalname( "vIDOPERANDO_"+sGXsfl_159_fel_idx );
   }

   public void sendrow_1593( )
   {
      subsflControlProps_1593( ) ;
      wb7D0( ) ;
      if ( ( subGridsnippets_Rows * 1 == 0 ) || ( nGXsfl_159_idx <= subgridsnippets_fnc_recordsperpage( ) * 1 ) )
      {
         GridsnippetsRow = GXWebRow.GetNew(context,GridsnippetsContainer) ;
         if ( subGridsnippets_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGridsnippets_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGridsnippets_Class, "") != 0 )
            {
               subGridsnippets_Linesclass = subGridsnippets_Class+"Odd" ;
            }
         }
         else if ( subGridsnippets_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGridsnippets_Backstyle = (byte)(0) ;
            subGridsnippets_Backcolor = subGridsnippets_Allbackcolor ;
            if ( GXutil.strcmp(subGridsnippets_Class, "") != 0 )
            {
               subGridsnippets_Linesclass = subGridsnippets_Class+"Uniform" ;
            }
         }
         else if ( subGridsnippets_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGridsnippets_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGridsnippets_Class, "") != 0 )
            {
               subGridsnippets_Linesclass = subGridsnippets_Class+"Odd" ;
            }
            subGridsnippets_Backcolor = (int)(0x0) ;
         }
         else if ( subGridsnippets_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGridsnippets_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_159_idx) % (2))) == 0 )
            {
               subGridsnippets_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsnippets_Class, "") != 0 )
               {
                  subGridsnippets_Linesclass = subGridsnippets_Class+"Even" ;
               }
            }
            else
            {
               subGridsnippets_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGridsnippets_Class, "") != 0 )
               {
                  subGridsnippets_Linesclass = subGridsnippets_Class+"Odd" ;
               }
            }
         }
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_159_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavOpecodformula_Enabled!=0)&&(edtavOpecodformula_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 160,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsnippetsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavOpecodformula_Internalname,GXutil.rtrim( AV94OpeCodFormula),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavOpecodformula_Enabled!=0)&&(edtavOpecodformula_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,160);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","",edtavOpecodformula_Tooltiptext,"",edtavOpecodformula_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(edtavOpecodformula_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(159),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavCopysnippet_Enabled!=0)&&(edtavCopysnippet_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 161,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         ROClassString = edtavCopysnippet_Class ;
         GridsnippetsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavCopysnippet_Internalname,GXutil.rtrim( AV14copySnippet),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavCopysnippet_Enabled!=0)&&(edtavCopysnippet_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,161);\"" : " "),"'"+""+"'"+",false,"+"'"+"EVCOPYSNIPPET.CLICK."+sGXsfl_159_idx+"'","","","","",edtavCopysnippet_Jsonclick,Integer.valueOf(5),edtavCopysnippet_Class,"",ROClassString,"WWIconActionColumn","",Integer.valueOf(-1),Integer.valueOf(edtavCopysnippet_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(159),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavNum_Enabled!=0)&&(edtavNum_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 162,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsnippetsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavNum_Internalname,GXutil.ltrim( localUtil.ntoc( AV61num, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtavNum_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV61num), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+((edtavNum_Enabled!=0)&&(edtavNum_Visible!=0) ? " onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,162);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavNum_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavNum_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(159),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavEntidad_Enabled!=0)&&(edtavEntidad_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 163,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsnippetsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavEntidad_Internalname,GXutil.rtrim( AV102entidad),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavEntidad_Enabled!=0)&&(edtavEntidad_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,163);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavEntidad_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavEntidad_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(159),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         TempTags = " " + ((edtavOpecliid_Enabled!=0)&&(edtavOpecliid_Visible!=0) ? " onfocus=\"gx.evt.onfocus(this, 164,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         ROClassString = "Attribute" ;
         GridsnippetsRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtavOpecliid_Internalname,GXutil.rtrim( AV116OpeCliId),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((edtavOpecliid_Enabled!=0)&&(edtavOpecliid_Visible!=0) ? " onblur=\""+""+";gx.evt.onblur(this,164);\"" : " "),"'"+""+"'"+",false,"+"'"+""+"'","","","","",edtavOpecliid_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(edtavOpecliid_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(159),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridsnippetsContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         TempTags = " " + ((cmbavIdoperando.getEnabled()!=0)&&(cmbavIdoperando.getVisible()!=0) ? " onfocus=\"gx.evt.onfocus(this, 165,'',false,'"+sGXsfl_159_idx+"',159)\"" : " ") ;
         if ( ( cmbavIdoperando.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "vIDOPERANDO_" + sGXsfl_159_idx ;
            cmbavIdoperando.setName( GXCCtl );
            cmbavIdoperando.setWebtags( "" );
            cmbavIdoperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
            cmbavIdoperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
            cmbavIdoperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
            cmbavIdoperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
            cmbavIdoperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
            cmbavIdoperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
            cmbavIdoperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
            cmbavIdoperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
            cmbavIdoperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
            cmbavIdoperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
            cmbavIdoperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
            cmbavIdoperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
            cmbavIdoperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
            cmbavIdoperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
            cmbavIdoperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
            cmbavIdoperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
            cmbavIdoperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
            cmbavIdoperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
            cmbavIdoperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
            cmbavIdoperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
            cmbavIdoperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
            cmbavIdoperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
            cmbavIdoperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
            cmbavIdoperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
            cmbavIdoperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
            cmbavIdoperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
            cmbavIdoperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
            cmbavIdoperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
            cmbavIdoperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
            cmbavIdoperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
            cmbavIdoperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
            cmbavIdoperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
            cmbavIdoperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
            cmbavIdoperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
            cmbavIdoperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
            cmbavIdoperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
            cmbavIdoperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
            cmbavIdoperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
            cmbavIdoperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
            cmbavIdoperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
            cmbavIdoperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbavIdoperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbavIdoperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbavIdoperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbavIdoperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
            cmbavIdoperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
            cmbavIdoperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
            cmbavIdoperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
            cmbavIdoperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
            cmbavIdoperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
            cmbavIdoperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
            cmbavIdoperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
            cmbavIdoperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
            cmbavIdoperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
            cmbavIdoperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
            cmbavIdoperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
            cmbavIdoperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
            cmbavIdoperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
            cmbavIdoperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
            cmbavIdoperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
            cmbavIdoperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
            cmbavIdoperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
            cmbavIdoperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
            cmbavIdoperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
            cmbavIdoperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
            cmbavIdoperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
            cmbavIdoperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
            cmbavIdoperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
            cmbavIdoperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
            cmbavIdoperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
            cmbavIdoperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
            cmbavIdoperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
            cmbavIdoperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
            cmbavIdoperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
            cmbavIdoperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
            cmbavIdoperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
            cmbavIdoperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
            cmbavIdoperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
            cmbavIdoperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
            cmbavIdoperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
            cmbavIdoperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
            cmbavIdoperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
            cmbavIdoperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
            cmbavIdoperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
            cmbavIdoperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
            cmbavIdoperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
            cmbavIdoperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
            cmbavIdoperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
            cmbavIdoperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
            cmbavIdoperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
            cmbavIdoperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
            cmbavIdoperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
            cmbavIdoperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
            cmbavIdoperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
            cmbavIdoperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
            cmbavIdoperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
            cmbavIdoperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
            cmbavIdoperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
            cmbavIdoperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
            cmbavIdoperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
            cmbavIdoperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
            cmbavIdoperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
            cmbavIdoperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
            cmbavIdoperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
            cmbavIdoperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
            cmbavIdoperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
            cmbavIdoperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
            cmbavIdoperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
            cmbavIdoperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
            cmbavIdoperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
            cmbavIdoperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
            cmbavIdoperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
            cmbavIdoperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
            cmbavIdoperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
            cmbavIdoperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
            cmbavIdoperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
            cmbavIdoperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
            cmbavIdoperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
            cmbavIdoperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
            cmbavIdoperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
            cmbavIdoperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
            cmbavIdoperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
            cmbavIdoperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
            cmbavIdoperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
            cmbavIdoperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
            cmbavIdoperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
            cmbavIdoperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
            cmbavIdoperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
            cmbavIdoperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
            cmbavIdoperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
            cmbavIdoperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
            cmbavIdoperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
            cmbavIdoperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
            cmbavIdoperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
            cmbavIdoperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
            cmbavIdoperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
            cmbavIdoperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
            cmbavIdoperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
            cmbavIdoperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
            cmbavIdoperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
            cmbavIdoperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
            if ( cmbavIdoperando.getItemCount() > 0 )
            {
               AV117idOperando = cmbavIdoperando.getValidValue(AV117idOperando) ;
               httpContext.ajax_rsp_assign_attri("", false, cmbavIdoperando.getInternalname(), AV117idOperando);
            }
         }
         /* ComboBox */
         GridsnippetsRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbavIdoperando,cmbavIdoperando.getInternalname(),GXutil.rtrim( AV117idOperando),Integer.valueOf(1),cmbavIdoperando.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(0),Integer.valueOf(cmbavIdoperando.getEnabled()),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+((cmbavIdoperando.getEnabled()!=0)&&(cmbavIdoperando.getVisible()!=0) ? " onblur=\""+""+";gx.evt.onblur(this,165);\"" : " "),"",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbavIdoperando.setValue( GXutil.rtrim( AV117idOperando) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavIdoperando.getInternalname(), "Values", cmbavIdoperando.ToJavascriptSource(), !bGXsfl_159_Refreshing);
         send_integrity_lvl_hashes7D3( ) ;
         GridsnippetsContainer.AddRow(GridsnippetsRow);
         nGXsfl_159_idx = ((subGridsnippets_Islastpage==1)&&(nGXsfl_159_idx+1>subgridsnippets_fnc_recordsperpage( )) ? 1 : nGXsfl_159_idx+1) ;
         sGXsfl_159_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_159_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_1593( ) ;
      }
      /* End function sendrow_1593 */
   }

   public void startgridcontrol159( )
   {
      if ( GridsnippetsContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridsnippetsContainer"+"DivS\" data-gxgridid=\"159\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridsnippets_Internalname, subGridsnippets_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridsnippets_Backcolorstyle == 0 )
         {
            subGridsnippets_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridsnippets_Class) > 0 )
            {
               subGridsnippets_Linesclass = subGridsnippets_Class+"Title" ;
            }
         }
         else
         {
            subGridsnippets_Titlebackstyle = (byte)(1) ;
            if ( subGridsnippets_Backcolorstyle == 1 )
            {
               subGridsnippets_Titlebackcolor = subGridsnippets_Allbackcolor ;
               if ( GXutil.len( subGridsnippets_Class) > 0 )
               {
                  subGridsnippets_Linesclass = subGridsnippets_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridsnippets_Class) > 0 )
               {
                  subGridsnippets_Linesclass = subGridsnippets_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Constante/Variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+edtavCopysnippet_Class+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Id. de variable", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "id Operando", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridsnippetsContainer.AddObjectProperty("GridName", "Gridsnippets");
      }
      else
      {
         GridsnippetsContainer.AddObjectProperty("GridName", "Gridsnippets");
         GridsnippetsContainer.AddObjectProperty("Header", subGridsnippets_Header);
         GridsnippetsContainer.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         GridsnippetsContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("CmpContext", "");
         GridsnippetsContainer.AddObjectProperty("InMasterPage", "false");
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.rtrim( AV94OpeCodFormula));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOpecodformula_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsnippetsColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtavOpecodformula_Tooltiptext));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.rtrim( AV14copySnippet));
         GridsnippetsColumn.AddObjectProperty("Class", GXutil.rtrim( edtavCopysnippet_Class));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavCopysnippet_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( AV61num, (byte)(4), (byte)(0), ".", "")));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavNum_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.rtrim( AV102entidad));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavEntidad_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.rtrim( AV116OpeCliId));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavOpecliid_Enabled, (byte)(5), (byte)(0), ".", "")));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridsnippetsColumn.AddObjectProperty("Value", GXutil.rtrim( AV117idOperando));
         GridsnippetsColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbavIdoperando.getEnabled(), (byte)(5), (byte)(0), ".", "")));
         GridsnippetsContainer.AddColumnProperties(GridsnippetsColumn);
         GridsnippetsContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridsnippetsContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsnippets_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol131( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"131\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            subGrid1_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid1_Class) > 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Title" ;
            }
         }
         else
         {
            subGrid1_Titlebackstyle = (byte)(1) ;
            if ( subGrid1_Backcolorstyle == 1 )
            {
               subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fecha", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Usuario", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Fórmula", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "For His Num", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Imp Sec", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "For His Antes", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Grid1Container.Clear();
         }
         Grid1Container.SetWrapped(nGXWrapped);
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "WorkWith");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", "");
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", localUtil.ttoc( A223ForHisFecha, 10, 8, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A224ForHisUsuario);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A222ForHisDespues);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A51ForHisNum, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A52ImpSec, (byte)(18), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A221ForHisAntes);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol106( )
   {
      if ( Gridsdt_conceptossContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridsdt_conceptossContainer"+"DivS\" data-gxgridid=\"106\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridsdt_conceptoss_Internalname, subGridsdt_conceptoss_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridsdt_conceptoss_Backcolorstyle == 0 )
         {
            subGridsdt_conceptoss_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridsdt_conceptoss_Class) > 0 )
            {
               subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Title" ;
            }
         }
         else
         {
            subGridsdt_conceptoss_Titlebackstyle = (byte)(1) ;
            if ( subGridsdt_conceptoss_Backcolorstyle == 1 )
            {
               subGridsdt_conceptoss_Titlebackcolor = subGridsdt_conceptoss_Allbackcolor ;
               if ( GXutil.len( subGridsdt_conceptoss_Class) > 0 )
               {
                  subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridsdt_conceptoss_Class) > 0 )
               {
                  subGridsdt_conceptoss_Linesclass = subGridsdt_conceptoss_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridsdt_conceptossContainer.AddObjectProperty("GridName", "Gridsdt_conceptoss");
      }
      else
      {
         Gridsdt_conceptossContainer.AddObjectProperty("GridName", "Gridsdt_conceptoss");
         Gridsdt_conceptossContainer.AddObjectProperty("Header", subGridsdt_conceptoss_Header);
         Gridsdt_conceptossContainer.AddObjectProperty("Class", "WorkWith");
         Gridsdt_conceptossContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("CmpContext", "");
         Gridsdt_conceptossContainer.AddObjectProperty("InMasterPage", "false");
         Gridsdt_conceptossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_conceptossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_conceptos__concodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddColumnProperties(Gridsdt_conceptossColumn);
         Gridsdt_conceptossColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_conceptossColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_conceptos__condescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddColumnProperties(Gridsdt_conceptossColumn);
         Gridsdt_conceptossContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptossContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void startgridcontrol115( )
   {
      if ( Gridsdt_conceptoss2Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Gridsdt_conceptoss2Container"+"DivS\" data-gxgridid=\"115\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGridsdt_conceptoss2_Internalname, subGridsdt_conceptoss2_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGridsdt_conceptoss2_Backcolorstyle == 0 )
         {
            subGridsdt_conceptoss2_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGridsdt_conceptoss2_Class) > 0 )
            {
               subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Title" ;
            }
         }
         else
         {
            subGridsdt_conceptoss2_Titlebackstyle = (byte)(1) ;
            if ( subGridsdt_conceptoss2_Backcolorstyle == 1 )
            {
               subGridsdt_conceptoss2_Titlebackcolor = subGridsdt_conceptoss2_Allbackcolor ;
               if ( GXutil.len( subGridsdt_conceptoss2_Class) > 0 )
               {
                  subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGridsdt_conceptoss2_Class) > 0 )
               {
                  subGridsdt_conceptoss2_Linesclass = subGridsdt_conceptoss2_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Gridsdt_conceptoss2Container.AddObjectProperty("GridName", "Gridsdt_conceptoss2");
      }
      else
      {
         Gridsdt_conceptoss2Container.AddObjectProperty("GridName", "Gridsdt_conceptoss2");
         Gridsdt_conceptoss2Container.AddObjectProperty("Header", subGridsdt_conceptoss2_Header);
         Gridsdt_conceptoss2Container.AddObjectProperty("Class", "WorkWith");
         Gridsdt_conceptoss2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("CmpContext", "");
         Gridsdt_conceptoss2Container.AddObjectProperty("InMasterPage", "false");
         Gridsdt_conceptoss2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_conceptoss2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_conceptos2__concodigo_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddColumnProperties(Gridsdt_conceptoss2Column);
         Gridsdt_conceptoss2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Gridsdt_conceptoss2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtavSdt_conceptos2__condescrip_Enabled, (byte)(5), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddColumnProperties(Gridsdt_conceptoss2Column);
         Gridsdt_conceptoss2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Gridsdt_conceptoss2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridsdt_conceptoss2_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblTextblockcombo_concepto_Internalname = "TEXTBLOCKCOMBO_CONCEPTO" ;
      Combo_concepto_Internalname = "COMBO_CONCEPTO" ;
      divTablesplittedconcepto_Internalname = "TABLESPLITTEDCONCEPTO" ;
      lblTextblockconrelsec_Internalname = "TEXTBLOCKCONRELSEC" ;
      cmbavConrelsec.setInternalname( "vCONRELSEC" );
      divUnnamedtableconrelsec_Internalname = "UNNAMEDTABLECONRELSEC" ;
      lblTextblock1_Internalname = "TEXTBLOCK1" ;
      Monacoeditor1_Internalname = "MONACOEDITOR1" ;
      tblTablemonaco_Internalname = "TABLEMONACO" ;
      edtavFormulacondescripciones_Internalname = "vFORMULACONDESCRIPCIONES" ;
      tblTblconcepto_Internalname = "TBLCONCEPTO" ;
      edtavConformulaexpl_Internalname = "vCONFORMULAEXPL" ;
      edtavIconoexpl_Internalname = "vICONOEXPL" ;
      divExplpanel_Internalname = "EXPLPANEL" ;
      Dvpanel_explpanel_Internalname = "DVPANEL_EXPLPANEL" ;
      dynavLegnumero.setInternalname( "vLEGNUMERO" );
      dynavLiqnro.setInternalname( "vLIQNRO" );
      edtavFormulaaux_Internalname = "vFORMULAAUX" ;
      edtavResultado_Internalname = "vRESULTADO" ;
      bttBtnactualizar_Internalname = "BTNACTUALIZAR" ;
      divPanelprobar_Internalname = "PANELPROBAR" ;
      Dvpanel_panelprobar_Internalname = "DVPANEL_PANELPROBAR" ;
      tblTblprobar_Internalname = "TBLPROBAR" ;
      edtavSdt_conceptos__concodigo_Internalname = "SDT_CONCEPTOS__CONCODIGO" ;
      edtavSdt_conceptos__condescrip_Internalname = "SDT_CONCEPTOS__CONDESCRIP" ;
      divPanelseusa_Internalname = "PANELSEUSA" ;
      Dvpanel_panelseusa_Internalname = "DVPANEL_PANELSEUSA" ;
      edtavSdt_conceptos2__concodigo_Internalname = "SDT_CONCEPTOS2__CONCODIGO" ;
      edtavSdt_conceptos2__condescrip_Internalname = "SDT_CONCEPTOS2__CONDESCRIP" ;
      bttBtnvertodosusa_Internalname = "BTNVERTODOSUSA" ;
      divPanelusa_Internalname = "PANELUSA" ;
      Dvpanel_panelusa_Internalname = "DVPANEL_PANELUSA" ;
      divPaneluso_Internalname = "PANELUSO" ;
      Dvpanel_paneluso_Internalname = "DVPANEL_PANELUSO" ;
      tblTbluso_Internalname = "TBLUSO" ;
      edtForHisFecha_Internalname = "FORHISFECHA" ;
      edtForHisUsuario_Internalname = "FORHISUSUARIO" ;
      edtForHisDespues_Internalname = "FORHISDESPUES" ;
      edtForHisNum_Internalname = "FORHISNUM" ;
      edtImpSec_Internalname = "IMPSEC" ;
      edtForHisAntes_Internalname = "FORHISANTES" ;
      edtConCodigo_Internalname = "CONCODIGO" ;
      divPanelhis_Internalname = "PANELHIS" ;
      Dvpanel_panelhis_Internalname = "DVPANEL_PANELHIS" ;
      tblTblhist_Internalname = "TBLHIST" ;
      tblTableleft_Internalname = "TABLELEFT" ;
      edtavSearchsnippets_Internalname = "vSEARCHSNIPPETS" ;
      edtavOpecodformula_Internalname = "vOPECODFORMULA" ;
      edtavCopysnippet_Internalname = "vCOPYSNIPPET" ;
      edtavNum_Internalname = "vNUM" ;
      edtavEntidad_Internalname = "vENTIDAD" ;
      edtavOpecliid_Internalname = "vOPECLIID" ;
      cmbavIdoperando.setInternalname( "vIDOPERANDO" );
      Gridsnippetspaginationbar_Internalname = "GRIDSNIPPETSPAGINATIONBAR" ;
      divGridsnippetstablewithpaginationbar_Internalname = "GRIDSNIPPETSTABLEWITHPAGINATIONBAR" ;
      divPanelcodgos_Internalname = "PANELCODGOS" ;
      Dvpanel_panelcodgos_Internalname = "DVPANEL_PANELCODGOS" ;
      tblTblvar_Internalname = "TBLVAR" ;
      tblTblparm_Internalname = "TBLPARM" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      bttBtnconfirmar_Internalname = "BTNCONFIRMAR" ;
      bttBtncancelar_Internalname = "BTNCANCELAR" ;
      lblJs_Internalname = "JS" ;
      edtavAcopiar_Internalname = "vACOPIAR" ;
      lblJs2_Internalname = "JS2" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavConcepto_Internalname = "vCONCEPTO" ;
      Popover_iconoexpl_Internalname = "POPOVER_ICONOEXPL" ;
      edtavGridsnippetscurrentpage_Internalname = "vGRIDSNIPPETSCURRENTPAGE" ;
      edtavClicod_Internalname = "vCLICOD" ;
      edtavEmpcod_Internalname = "vEMPCOD" ;
      edtavFormula_Internalname = "vFORMULA" ;
      edtavModover_Internalname = "vMODOVER" ;
      Gridsnippets_empowerer_Internalname = "GRIDSNIPPETS_EMPOWERER" ;
      Grid1_empowerer_Internalname = "GRID1_EMPOWERER" ;
      Gridsdt_conceptoss2_empowerer_Internalname = "GRIDSDT_CONCEPTOSS2_EMPOWERER" ;
      Gridsdt_conceptoss_empowerer_Internalname = "GRIDSDT_CONCEPTOSS_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridsdt_conceptoss_Internalname = "GRIDSDT_CONCEPTOSS" ;
      subGridsdt_conceptoss2_Internalname = "GRIDSDT_CONCEPTOSS2" ;
      subGrid1_Internalname = "GRID1" ;
      subGridsnippets_Internalname = "GRIDSNIPPETS" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridsdt_conceptoss2_Allowcollapsing = (byte)(0) ;
      subGridsdt_conceptoss2_Allowselection = (byte)(0) ;
      subGridsdt_conceptoss2_Header = "" ;
      subGridsdt_conceptoss_Allowcollapsing = (byte)(0) ;
      subGridsdt_conceptoss_Allowselection = (byte)(0) ;
      subGridsdt_conceptoss_Header = "" ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      subGrid1_Header = "" ;
      subGridsnippets_Allowcollapsing = (byte)(0) ;
      subGridsnippets_Allowselection = (byte)(0) ;
      subGridsnippets_Header = "" ;
      cmbavIdoperando.setJsonclick( "" );
      cmbavIdoperando.setVisible( 0 );
      cmbavIdoperando.setEnabled( 1 );
      edtavOpecliid_Jsonclick = "" ;
      edtavOpecliid_Visible = 0 ;
      edtavOpecliid_Enabled = 1 ;
      edtavEntidad_Jsonclick = "" ;
      edtavEntidad_Visible = 0 ;
      edtavEntidad_Enabled = 1 ;
      edtavNum_Jsonclick = "" ;
      edtavNum_Visible = 0 ;
      edtavNum_Enabled = 1 ;
      edtavCopysnippet_Jsonclick = "" ;
      edtavCopysnippet_Class = "Attribute" ;
      edtavCopysnippet_Visible = -1 ;
      edtavCopysnippet_Enabled = 1 ;
      edtavOpecodformula_Jsonclick = "" ;
      edtavOpecodformula_Visible = -1 ;
      edtavOpecodformula_Tooltiptext = "" ;
      edtavOpecodformula_Enabled = 1 ;
      subGridsnippets_Class = "GridWithPaginationBar WorkWith" ;
      subGridsnippets_Backcolorstyle = (byte)(0) ;
      edtConCodigo_Jsonclick = "" ;
      edtForHisAntes_Jsonclick = "" ;
      edtImpSec_Jsonclick = "" ;
      edtForHisNum_Jsonclick = "" ;
      edtForHisDespues_Jsonclick = "" ;
      edtForHisUsuario_Jsonclick = "" ;
      edtForHisFecha_Jsonclick = "" ;
      subGrid1_Class = "WorkWith" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavSdt_conceptos2__condescrip_Jsonclick = "" ;
      edtavSdt_conceptos2__condescrip_Enabled = 0 ;
      edtavSdt_conceptos2__concodigo_Jsonclick = "" ;
      edtavSdt_conceptos2__concodigo_Enabled = 0 ;
      subGridsdt_conceptoss2_Class = "WorkWith" ;
      subGridsdt_conceptoss2_Backcolorstyle = (byte)(0) ;
      edtavSdt_conceptos__condescrip_Jsonclick = "" ;
      edtavSdt_conceptos__condescrip_Enabled = 0 ;
      edtavSdt_conceptos__concodigo_Jsonclick = "" ;
      edtavSdt_conceptos__concodigo_Enabled = 0 ;
      subGridsdt_conceptoss_Class = "WorkWith" ;
      subGridsdt_conceptoss_Backcolorstyle = (byte)(0) ;
      edtavFormulacondescripciones_Enabled = 1 ;
      cmbavConrelsec.setJsonclick( "" );
      cmbavConrelsec.setEnabled( 1 );
      lblTextblockconrelsec_Visible = 1 ;
      bttBtnactualizar_Visible = 1 ;
      edtavResultado_Jsonclick = "" ;
      edtavResultado_Enabled = 1 ;
      edtavFormulaaux_Enabled = 1 ;
      dynavLiqnro.setJsonclick( "" );
      dynavLiqnro.setEnabled( 1 );
      dynavLegnumero.setJsonclick( "" );
      dynavLegnumero.setEnabled( 1 );
      edtavIconoexpl_Jsonclick = "" ;
      edtavIconoexpl_Enabled = 1 ;
      edtavConformulaexpl_Enabled = 1 ;
      edtavSearchsnippets_Jsonclick = "" ;
      edtavSearchsnippets_Enabled = 1 ;
      tblTblprobar_Visible = 1 ;
      tblTblparm_Visible = 1 ;
      tblTablemonaco_Class = "" ;
      cmbavConrelsec.setVisible( 1 );
      edtavFormulacondescripciones_Visible = 1 ;
      edtavSdt_conceptos2__condescrip_Enabled = -1 ;
      edtavSdt_conceptos2__concodigo_Enabled = -1 ;
      edtavSdt_conceptos__condescrip_Enabled = -1 ;
      edtavSdt_conceptos__concodigo_Enabled = -1 ;
      edtavModover_Jsonclick = "" ;
      edtavModover_Visible = 1 ;
      edtavFormula_Enabled = 1 ;
      edtavFormula_Visible = 1 ;
      edtavEmpcod_Jsonclick = "" ;
      edtavEmpcod_Visible = 1 ;
      edtavClicod_Jsonclick = "" ;
      edtavClicod_Visible = 1 ;
      edtavGridsnippetscurrentpage_Jsonclick = "" ;
      edtavGridsnippetscurrentpage_Visible = 1 ;
      edtavConcepto_Jsonclick = "" ;
      edtavConcepto_Visible = 1 ;
      edtavAcopiar_Jsonclick = "" ;
      edtavAcopiar_Enabled = 1 ;
      edtavAcopiar_Visible = 1 ;
      lblJs_Caption = " " ;
      bttBtnconfirmar_Visible = 1 ;
      Grid1_empowerer_Infinitescrolling = "Form" ;
      Popover_iconoexpl_Position = "Bottom" ;
      Popover_iconoexpl_Html = "&ConFormulaExpl" ;
      Popover_iconoexpl_Popoverwidth = 400 ;
      Popover_iconoexpl_Triggerelement = "Value" ;
      Popover_iconoexpl_Iteminternalname = "" ;
      Dvpanel_panelcodgos_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelcodgos_Iconposition = "Right" ;
      Dvpanel_panelcodgos_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelcodgos_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelcodgos_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelcodgos_Title = httpContext.getMessage( "Parámetros", "") ;
      Dvpanel_panelcodgos_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelcodgos_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelcodgos_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelcodgos_Width = "100%" ;
      Gridsnippetspaginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Gridsnippetspaginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Gridsnippetspaginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Gridsnippetspaginationbar_Next = "WWP_PagingNextCaption" ;
      Gridsnippetspaginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Gridsnippetspaginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Gridsnippetspaginationbar_Rowsperpageselectedvalue = 10 ;
      Gridsnippetspaginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Gridsnippetspaginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Gridsnippetspaginationbar_Pagingcaptionposition = "Left" ;
      Gridsnippetspaginationbar_Pagingbuttonsposition = "Right" ;
      Gridsnippetspaginationbar_Pagestoshow = 5 ;
      Gridsnippetspaginationbar_Showlast = GXutil.toBoolean( 0) ;
      Gridsnippetspaginationbar_Shownext = GXutil.toBoolean( -1) ;
      Gridsnippetspaginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Gridsnippetspaginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Gridsnippetspaginationbar_Class = "PaginationBar" ;
      Dvpanel_panelhis_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelhis_Iconposition = "Right" ;
      Dvpanel_panelhis_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelhis_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_panelhis_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelhis_Title = httpContext.getMessage( "Ver Histórico de Cambios", "") ;
      Dvpanel_panelhis_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelhis_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelhis_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelhis_Width = "100%" ;
      Dvpanel_paneluso_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_paneluso_Iconposition = "Right" ;
      Dvpanel_paneluso_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_paneluso_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_paneluso_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_paneluso_Title = httpContext.getMessage( "Referencias a Conceptos", "") ;
      Dvpanel_paneluso_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_paneluso_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_paneluso_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_paneluso_Width = "100%" ;
      Dvpanel_panelusa_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelusa_Iconposition = "Right" ;
      Dvpanel_panelusa_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelusa_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelusa_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelusa_Title = httpContext.getMessage( "Usa", "") ;
      Dvpanel_panelusa_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelusa_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelusa_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelusa_Width = "100%" ;
      Dvpanel_panelseusa_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelseusa_Iconposition = "Right" ;
      Dvpanel_panelseusa_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelseusa_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelseusa_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelseusa_Title = httpContext.getMessage( "Se Usa En", "") ;
      Dvpanel_panelseusa_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelseusa_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelseusa_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelseusa_Width = "100%" ;
      Dvpanel_panelprobar_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_panelprobar_Iconposition = "Right" ;
      Dvpanel_panelprobar_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_panelprobar_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_panelprobar_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_panelprobar_Title = httpContext.getMessage( "Probar Fórmula", "") ;
      Dvpanel_panelprobar_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_panelprobar_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_panelprobar_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_panelprobar_Width = "100%" ;
      Dvpanel_explpanel_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_explpanel_Iconposition = "Right" ;
      Dvpanel_explpanel_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_explpanel_Collapsed = GXutil.toBoolean( 1) ;
      Dvpanel_explpanel_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_explpanel_Title = httpContext.getMessage( "Explicación", "") ;
      Dvpanel_explpanel_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_explpanel_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_explpanel_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_explpanel_Width = "100%" ;
      Monacoeditor1_Url_sug_querystring = "" ;
      Monacoeditor1_Palabra_concepto = "" ;
      Monacoeditor1_Permitidos = "" ;
      Monacoeditor1_Variable_asociada = "" ;
      Monacoeditor1_Monaco_minimap = "" ;
      Monacoeditor1_Monaco_readonly = "" ;
      Monacoeditor1_Monaco_columns = "" ;
      Monacoeditor1_Monaco_wordwrap = "" ;
      Monacoeditor1_Monaco_linenumbers = "" ;
      Monacoeditor1_Valorinicial = "" ;
      Monacoeditor1_Monaco_url_sug = "" ;
      Monacoeditor1_Monaco_foreground = "" ;
      Monacoeditor1_Monaco_tokens_style = "" ;
      Monacoeditor1_Monaco_tokens = "" ;
      Monacoeditor1_Monaco_brackets = "" ;
      Monacoeditor1_Nombrelenguaje = "" ;
      Monacoeditor1_Monaco_editor_id = "" ;
      Combo_concepto_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_concepto_Cls = "ExtendedCombo comboConceptos" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Editar Fórmula", "") );
      subGridsnippets_Rows = 0 ;
      subGrid1_Rows = 50 ;
      subGridsdt_conceptoss2_Rows = 0 ;
      subGridsdt_conceptoss_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      cmbavConrelsec.setName( "vCONRELSEC" );
      cmbavConrelsec.setWebtags( "" );
      if ( cmbavConrelsec.getItemCount() > 0 )
      {
         AV146ConRelSec = (int)(GXutil.lval( cmbavConrelsec.getValidValue(GXutil.trim( GXutil.str( AV146ConRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV146ConRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV146ConRelSec), 6, 0));
      }
      dynavLegnumero.setName( "vLEGNUMERO" );
      dynavLegnumero.setWebtags( "" );
      dynavLiqnro.setName( "vLIQNRO" );
      dynavLiqnro.setWebtags( "" );
      GXCCtl = "vIDOPERANDO_" + sGXsfl_159_idx ;
      cmbavIdoperando.setName( GXCCtl );
      cmbavIdoperando.setWebtags( "" );
      cmbavIdoperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbavIdoperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbavIdoperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbavIdoperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbavIdoperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbavIdoperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbavIdoperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbavIdoperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbavIdoperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbavIdoperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbavIdoperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbavIdoperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbavIdoperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbavIdoperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbavIdoperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbavIdoperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbavIdoperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbavIdoperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbavIdoperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbavIdoperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbavIdoperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbavIdoperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbavIdoperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbavIdoperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbavIdoperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbavIdoperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbavIdoperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbavIdoperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbavIdoperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbavIdoperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbavIdoperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbavIdoperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbavIdoperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbavIdoperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbavIdoperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbavIdoperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbavIdoperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbavIdoperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbavIdoperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbavIdoperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbavIdoperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbavIdoperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbavIdoperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbavIdoperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbavIdoperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbavIdoperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbavIdoperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbavIdoperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbavIdoperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbavIdoperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbavIdoperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbavIdoperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbavIdoperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbavIdoperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbavIdoperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbavIdoperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbavIdoperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbavIdoperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbavIdoperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbavIdoperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbavIdoperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbavIdoperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbavIdoperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbavIdoperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbavIdoperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbavIdoperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbavIdoperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbavIdoperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbavIdoperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbavIdoperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbavIdoperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbavIdoperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbavIdoperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbavIdoperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbavIdoperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbavIdoperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbavIdoperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbavIdoperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbavIdoperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbavIdoperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbavIdoperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbavIdoperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbavIdoperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbavIdoperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbavIdoperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbavIdoperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbavIdoperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbavIdoperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbavIdoperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbavIdoperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbavIdoperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbavIdoperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbavIdoperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbavIdoperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbavIdoperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbavIdoperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbavIdoperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbavIdoperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbavIdoperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbavIdoperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbavIdoperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbavIdoperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbavIdoperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbavIdoperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbavIdoperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbavIdoperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbavIdoperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbavIdoperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbavIdoperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbavIdoperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbavIdoperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbavIdoperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbavIdoperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbavIdoperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbavIdoperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbavIdoperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbavIdoperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbavIdoperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbavIdoperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbavIdoperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbavIdoperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbavIdoperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbavIdoperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbavIdoperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbavIdoperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbavIdoperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbavIdoperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbavIdoperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbavIdoperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbavIdoperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbavIdoperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbavIdoperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbavIdoperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbavIdoperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbavIdoperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbavIdoperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbavIdoperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbavIdoperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbavIdoperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbavIdoperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbavIdoperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbavIdoperando.getItemCount() > 0 )
      {
         AV117idOperando = cmbavIdoperando.getValidValue(AV117idOperando) ;
         httpContext.ajax_rsp_assign_attri("", false, cmbavIdoperando.getInternalname(), AV117idOperando);
      }
      /* End function init_web_controls */
   }

   public void validv_Clicod( )
   {
      AV48LegNumero = (int)(GXutil.lval( dynavLegnumero.getValue())) ;
      AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValue())) ;
      gxvvlegnumero_html7D2( AV6CliCod, AV16EmpCod) ;
      gxvvliqnro_html7D2( AV6CliCod, AV16EmpCod) ;
      dynload_actions( ) ;
      if ( dynavLegnumero.getItemCount() > 0 )
      {
         AV48LegNumero = (int)(GXutil.lval( dynavLegnumero.getValidValue(GXutil.trim( GXutil.str( AV48LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
      }
      if ( dynavLiqnro.getItemCount() > 0 )
      {
         AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValidValue(GXutil.trim( GXutil.str( AV51LiqNro, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV48LegNumero", GXutil.ltrim( localUtil.ntoc( AV48LegNumero, (byte)(8), (byte)(0), ".", "")));
      dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLegnumero.getInternalname(), "Values", dynavLegnumero.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrim( localUtil.ntoc( AV51LiqNro, (byte)(8), (byte)(0), ".", "")));
      dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLiqnro.getInternalname(), "Values", dynavLiqnro.ToJavascriptSource(), true);
   }

   public void validv_Empcod( )
   {
      AV48LegNumero = (int)(GXutil.lval( dynavLegnumero.getValue())) ;
      AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValue())) ;
      gxvvlegnumero_html7D2( AV6CliCod, AV16EmpCod) ;
      gxvvliqnro_html7D2( AV6CliCod, AV16EmpCod) ;
      dynload_actions( ) ;
      if ( dynavLegnumero.getItemCount() > 0 )
      {
         AV48LegNumero = (int)(GXutil.lval( dynavLegnumero.getValidValue(GXutil.trim( GXutil.str( AV48LegNumero, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
      }
      if ( dynavLiqnro.getItemCount() > 0 )
      {
         AV51LiqNro = (int)(GXutil.lval( dynavLiqnro.getValidValue(GXutil.trim( GXutil.str( AV51LiqNro, 8, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV48LegNumero", GXutil.ltrim( localUtil.ntoc( AV48LegNumero, (byte)(8), (byte)(0), ".", "")));
      dynavLegnumero.setValue( GXutil.trim( GXutil.str( AV48LegNumero, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLegnumero.getInternalname(), "Values", dynavLegnumero.ToJavascriptSource(), true);
      httpContext.ajax_rsp_assign_attri("", false, "AV51LiqNro", GXutil.ltrim( localUtil.ntoc( AV51LiqNro, (byte)(8), (byte)(0), ".", "")));
      dynavLiqnro.setValue( GXutil.trim( GXutil.str( AV51LiqNro, 8, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynavLiqnro.getInternalname(), "Values", dynavLiqnro.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'GRIDSNIPPETS_nFirstRecordOnPage'},{av:'GRIDSNIPPETS_nEOF'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSNIPPETS.LOAD","{handler:'e277D3',iparms:[{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true}]");
      setEventMetadata("GRIDSNIPPETS.LOAD",",oparms:[{av:'cmbavIdoperando'},{av:'AV117idOperando',fld:'vIDOPERANDO',pic:''},{av:'AV116OpeCliId',fld:'vOPECLIID',pic:''},{av:'AV94OpeCodFormula',fld:'vOPECODFORMULA',pic:'',hsh:true},{av:'AV14copySnippet',fld:'vCOPYSNIPPET',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'edtavOpecodformula_Tooltiptext',ctrl:'vOPECODFORMULA',prop:'Tooltiptext'},{av:'AV102entidad',fld:'vENTIDAD',pic:''},{av:'edtavCopysnippet_Class',ctrl:'vCOPYSNIPPET',prop:'Class'}]}");
      setEventMetadata("GRID1.LOAD","{handler:'e267D6',iparms:[]");
      setEventMetadata("GRID1.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS2.LOAD","{handler:'e257D7',iparms:[{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS2.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS.LOAD","{handler:'e237D2',iparms:[{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS.LOAD",",oparms:[]}");
      setEventMetadata("GRIDSNIPPETSPAGINATIONBAR.CHANGEPAGE","{handler:'e127D2',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'GRIDSNIPPETS_nFirstRecordOnPage'},{av:'GRIDSNIPPETS_nEOF'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'Gridsnippetspaginationbar_Selectedpage',ctrl:'GRIDSNIPPETSPAGINATIONBAR',prop:'SelectedPage'},{av:'AV95GridSnippetsCurrentPage',fld:'vGRIDSNIPPETSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSNIPPETSPAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'AV95GridSnippetsCurrentPage',fld:'vGRIDSNIPPETSCURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSNIPPETSPAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e137D2',iparms:[{av:'GRIDSNIPPETS_nFirstRecordOnPage'},{av:'GRIDSNIPPETS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'Gridsnippetspaginationbar_Rowsperpageselectedvalue',ctrl:'GRIDSNIPPETSPAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRIDSNIPPETSPAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV95GridSnippetsCurrentPage',fld:'vGRIDSNIPPETSCURRENTPAGE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("'DOCONFIRMAR'","{handler:'e147D2',iparms:[{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV19FormOK',fld:'vFORMOK',pic:''},{av:'AV20Formula',fld:'vFORMULA',pic:''},{av:'cmbavConrelsec'},{av:'AV146ConRelSec',fld:'vCONRELSEC',pic:'ZZZZZ9'},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("'DOCONFIRMAR'",",oparms:[{av:'AV19FormOK',fld:'vFORMOK',pic:''},{av:'AV20Formula',fld:'vFORMULA',pic:''}]}");
      setEventMetadata("'DOCANCELAR'","{handler:'e117D1',iparms:[{av:'AV114parmLegNumero',fld:'vPARMLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV115parmLiqNro',fld:'vPARMLIQNRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("'DOCANCELAR'",",oparms:[]}");
      setEventMetadata("'DOVERTODOSUSA'","{handler:'e157D2',iparms:[{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'GRIDSNIPPETS_nFirstRecordOnPage'},{av:'GRIDSNIPPETS_nEOF'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'}]");
      setEventMetadata("'DOVERTODOSUSA'",",oparms:[{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115},{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("'DOACTUALIZAR'","{handler:'e167D2',iparms:[{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20Formula',fld:'vFORMULA',pic:''},{av:'AV78start',fld:'vSTART',pic:''},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true}]");
      setEventMetadata("'DOACTUALIZAR'",",oparms:[{av:'AV78start',fld:'vSTART',pic:''},{av:'AV21FormulaAux',fld:'vFORMULAAUX',pic:''},{av:'AV65Resultado',fld:'vRESULTADO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV126formulaConDescripciones',fld:'vFORMULACONDESCRIPCIONES',pic:''}]}");
      setEventMetadata("VMODOVER.CLICK","{handler:'e177D2',iparms:[{av:'AV127ModoVer',fld:'vMODOVER',pic:''},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''}]");
      setEventMetadata("VMODOVER.CLICK",",oparms:[{av:'edtavFormulacondescripciones_Visible',ctrl:'vFORMULACONDESCRIPCIONES',prop:'Visible'},{ctrl:'BTNCONFIRMAR',prop:'Visible'},{av:'tblTablemonaco_Class',ctrl:'TABLEMONACO',prop:'Class'}]}");
      setEventMetadata("VICONOEXPL.CLICK","{handler:'e187D2',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'GRIDSNIPPETS_nFirstRecordOnPage'},{av:'GRIDSNIPPETS_nEOF'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A82OpeCliId',fld:'OPECLIID',pic:''},{av:'A534OpeCliDescrip',fld:'OPECLIDESCRIP',pic:''},{av:'AV89searchSnippets',fld:'vSEARCHSNIPPETS',pic:''},{av:'A549OpeCliCodFormula',fld:'OPECLICODFORMULA',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A473OpeCodFormula',fld:'OPECODFORMULA',pic:''},{av:'A474OpeDescripcion',fld:'OPEDESCRIPCION',pic:''},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("VICONOEXPL.CLICK",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("VLIQNRO.CLICK","{handler:'e197D2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20Formula',fld:'vFORMULA',pic:''},{av:'AV78start',fld:'vSTART',pic:''},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true}]");
      setEventMetadata("VLIQNRO.CLICK",",oparms:[{av:'lblJs_Caption',ctrl:'JS',prop:'Caption'},{av:'AV21FormulaAux',fld:'vFORMULAAUX',pic:''},{av:'AV65Resultado',fld:'vRESULTADO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV126formulaConDescripciones',fld:'vFORMULACONDESCRIPCIONES',pic:''}]}");
      setEventMetadata("VLEGNUMERO.CLICK","{handler:'e207D2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV20Formula',fld:'vFORMULA',pic:''},{av:'AV78start',fld:'vSTART',pic:''},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true}]");
      setEventMetadata("VLEGNUMERO.CLICK",",oparms:[{ctrl:'BTNACTUALIZAR',prop:'Visible'},{av:'lblJs_Caption',ctrl:'JS',prop:'Caption'},{av:'AV21FormulaAux',fld:'vFORMULAAUX',pic:''},{av:'AV65Resultado',fld:'vRESULTADO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV126formulaConDescripciones',fld:'vFORMULACONDESCRIPCIONES',pic:''}]}");
      setEventMetadata("'DONOUSADOS'","{handler:'e247D2',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]");
      setEventMetadata("'DONOUSADOS'",",oparms:[]}");
      setEventMetadata("VCOPYSNIPPET.CLICK","{handler:'e287D2',iparms:[{av:'AV94OpeCodFormula',fld:'vOPECODFORMULA',pic:'',hsh:true}]");
      setEventMetadata("VCOPYSNIPPET.CLICK",",oparms:[{av:'AV5aCopiar',fld:'vACOPIAR',pic:''},{av:'lblJs_Caption',ctrl:'JS',prop:'Caption'},{av:'AV14copySnippet',fld:'vCOPYSNIPPET',pic:''}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS_FIRSTPAGE","{handler:'subgridsdt_conceptoss_firstpage',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS_FIRSTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS_PREVPAGE","{handler:'subgridsdt_conceptoss_previouspage',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS_PREVPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS_NEXTPAGE","{handler:'subgridsdt_conceptoss_nextpage',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS_NEXTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS_LASTPAGE","{handler:'subgridsdt_conceptoss_lastpage',iparms:[{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS_LASTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV10ConCodigo',fld:'vCONCODIGO',pic:''},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_FIRSTPAGE","{handler:'subgridsdt_conceptoss2_firstpage',iparms:[{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_FIRSTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_PREVPAGE","{handler:'subgridsdt_conceptoss2_previouspage',iparms:[{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_PREVPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_NEXTPAGE","{handler:'subgridsdt_conceptoss2_nextpage',iparms:[{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_NEXTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_LASTPAGE","{handler:'subgridsdt_conceptoss2_lastpage',iparms:[{av:'GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage'},{av:'GRIDSDT_CONCEPTOSS2_nEOF'},{av:'subGridsdt_conceptoss_Rows',ctrl:'GRIDSDT_CONCEPTOSS',prop:'Rows'},{av:'subGridsdt_conceptoss2_Rows',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'Rows'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'subGridsnippets_Rows',ctrl:'GRIDSNIPPETS',prop:'Rows'},{av:'AV66sdt_conceptos',fld:'vSDT_CONCEPTOS',grid:106,pic:'',hsh:true},{av:'nGXsfl_106_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:106},{av:'GRIDSDT_CONCEPTOSS_nFirstRecordOnPage'},{av:'nRC_GXsfl_106',ctrl:'GRIDSDT_CONCEPTOSS',prop:'GridRC',grid:106},{av:'AV98PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV134LiqPeriodo',fld:'vLIQPERIODO',pic:'',hsh:true},{av:'AV139date',fld:'vDATE',pic:'',hsh:true},{av:'AV138clienteNucleoPais_CliCod',fld:'vCLIENTENUCLEOPAIS_CLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV142ClienteConveniador',fld:'vCLIENTECONVENIADOR',pic:'',hsh:true},{av:'AV17esConceptosDefault',fld:'vESCONCEPTOSDEFAULT',pic:'',hsh:true},{av:'AV147MenuOpcCod',fld:'vMENUOPCCOD',pic:'',hsh:true},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV8Concepto',fld:'vCONCEPTO',pic:''},{av:'AV161Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV84sdt_conceptos2',fld:'vSDT_CONCEPTOS2',grid:115,pic:''},{av:'nGXsfl_115_idx', ctrl: 'GRID', prop:'GridCurrRow', grid:115},{av:'nRC_GXsfl_115',ctrl:'GRIDSDT_CONCEPTOSS2',prop:'GridRC',grid:115}]");
      setEventMetadata("GRIDSDT_CONCEPTOSS2_LASTPAGE",",oparms:[{av:'AV119ConFormulaExpl',fld:'vCONFORMULAEXPL',pic:''},{av:'AV61num',fld:'vNUM',pic:'ZZZ9',hsh:true},{av:'AV18ForHisNum',fld:'vFORHISNUM',pic:'ZZZ9'},{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALIDV_CLICOD","{handler:'validv_Clicod',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALIDV_CLICOD",",oparms:[{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("VALIDV_EMPCOD","{handler:'validv_Empcod',iparms:[{av:'AV6CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'AV16EmpCod',fld:'vEMPCOD',pic:'ZZZ9'},{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("VALIDV_EMPCOD",",oparms:[{av:'dynavLegnumero'},{av:'AV48LegNumero',fld:'vLEGNUMERO',pic:'ZZZZZZZ9'},{av:'dynavLiqnro'},{av:'AV51LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9'}]}");
      setEventMetadata("NULL","{handler:'validv_Gxv3',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Gxv6',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("NULL","{handler:'validv_Idoperando',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOAV147MenuOpcCod = "" ;
      wcpOAV10ConCodigo = "" ;
      wcpOAV83llamador = "" ;
      Gridsnippetspaginationbar_Selectedpage = "" ;
      Combo_concepto_Selectedvalue_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV147MenuOpcCod = "" ;
      AV10ConCodigo = "" ;
      AV83llamador = "" ;
      AV8Concepto = "" ;
      AV161Pgmname = "" ;
      AV66sdt_conceptos = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      AV134LiqPeriodo = GXutil.nullDate() ;
      AV139date = GXutil.nullDate() ;
      AV84sdt_conceptos2 = new GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem>(web.Sdtsdt_conceptos_sdt_conceptosItem.class, "sdt_conceptosItem", "PayDay", remoteHandle);
      A82OpeCliId = "" ;
      A534OpeCliDescrip = "" ;
      AV89searchSnippets = "" ;
      A549OpeCliCodFormula = "" ;
      A473OpeCodFormula = "" ;
      A474OpeDescripcion = "" ;
      A74idOperando = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV9Concepto_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      AV97GridSnippetsAppliedFilters = "" ;
      Combo_concepto_Selectedvalue_set = "" ;
      Gridsnippets_empowerer_Gridinternalname = "" ;
      Grid1_empowerer_Gridinternalname = "" ;
      Gridsdt_conceptoss2_empowerer_Gridinternalname = "" ;
      Gridsdt_conceptoss_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtnconfirmar_Jsonclick = "" ;
      bttBtncancelar_Jsonclick = "" ;
      lblJs_Jsonclick = "" ;
      AV5aCopiar = "" ;
      lblJs2_Jsonclick = "" ;
      ucPopover_iconoexpl = new com.genexus.webpanels.GXUserControl();
      AV20Formula = "" ;
      AV127ModoVer = "" ;
      ucGridsnippets_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGrid1_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdt_conceptoss2_empowerer = new com.genexus.webpanels.GXUserControl();
      ucGridsdt_conceptoss_empowerer = new com.genexus.webpanels.GXUserControl();
      Gridsdt_conceptossContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      Gridsdt_conceptoss2Container = new com.genexus.webpanels.GXWebGrid(context);
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      GridsnippetsContainer = new com.genexus.webpanels.GXWebGrid(context);
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A223ForHisFecha = GXutil.resetTime( GXutil.nullDate() );
      A224ForHisUsuario = "" ;
      A222ForHisDespues = "" ;
      A221ForHisAntes = "" ;
      A26ConCodigo = "" ;
      AV94OpeCodFormula = "" ;
      AV14copySnippet = "" ;
      AV102entidad = "" ;
      AV116OpeCliId = "" ;
      AV117idOperando = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      scmdbuf = "" ;
      H007D2_A6LegNumero = new int[1] ;
      H007D2_A250LegIdNomApe = new String[] {""} ;
      H007D2_A3CliCod = new int[1] ;
      H007D2_A1EmpCod = new short[1] ;
      H007D3_A31LiqNro = new int[1] ;
      H007D3_A874LiqNombre = new String[] {""} ;
      H007D3_A3CliCod = new int[1] ;
      H007D3_A1EmpCod = new short[1] ;
      GXCCtl = "" ;
      H007D4_A26ConCodigo = new String[] {""} ;
      H007D4_A221ForHisAntes = new String[] {""} ;
      H007D4_n221ForHisAntes = new boolean[] {false} ;
      H007D4_A52ImpSec = new long[1] ;
      H007D4_n52ImpSec = new boolean[] {false} ;
      H007D4_A51ForHisNum = new short[1] ;
      H007D4_A222ForHisDespues = new String[] {""} ;
      H007D4_A224ForHisUsuario = new String[] {""} ;
      H007D4_A223ForHisFecha = new java.util.Date[] {GXutil.nullDate()} ;
      H007D4_A3CliCod = new int[1] ;
      H007D5_AGRID1_nRecordCount = new long[1] ;
      AV126formulaConDescripciones = "" ;
      AV119ConFormulaExpl = "" ;
      AV122IconoExpl = "" ;
      AV21FormulaAux = "" ;
      AV65Resultado = DecimalUtil.ZERO ;
      AV99codigoOpeConcepto = "" ;
      AV100codigoOpeRemuVar = "" ;
      ucGridsnippetspaginationbar = new com.genexus.webpanels.GXUserControl();
      Gridsdt_conceptossRow = new com.genexus.webpanels.GXWebRow();
      H007D6_A3CliCod = new int[1] ;
      H007D6_A26ConCodigo = new String[] {""} ;
      H007D6_A42ConCodYDesc = new String[] {""} ;
      H007D6_n42ConCodYDesc = new boolean[] {false} ;
      A42ConCodYDesc = "" ;
      AV7Combo_DataItem = new web.wwpbaseobjects.SdtDVB_SDTComboData_Item(remoteHandle, context);
      ucCombo_concepto = new com.genexus.webpanels.GXUserControl();
      AV108queryString = "" ;
      AV137mensualTLiqCod = "" ;
      AV123error = "" ;
      AV57msgInstanciar = "" ;
      AV124formulaError = "" ;
      GXv_decimal12 = new java.math.BigDecimal[1] ;
      GXv_boolean5 = new boolean[1] ;
      H007D7_A3CliCod = new int[1] ;
      H007D7_A1880CliReDTChar = new String[] {""} ;
      H007D7_A1885CliRelSec = new int[1] ;
      A1880CliReDTChar = "" ;
      AV12ConDescrip = "" ;
      AV107ConFormula = "" ;
      GXv_int17 = new long[1] ;
      GXv_int19 = new byte[1] ;
      AV149ConPadre = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV135TipoConCod = "" ;
      GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22 = new GXBaseCollection[1] ;
      AV50lineNumbers_OnOff = "" ;
      GXv_char18 = new String[1] ;
      AV81wordWrap = "" ;
      GXv_char16 = new String[1] ;
      AV82wordWrapColumn = "" ;
      GXv_char15 = new String[1] ;
      AV52monaco_foreground = "" ;
      GXv_char14 = new String[1] ;
      AV53monaco_minimap = "" ;
      GXv_char13 = new String[1] ;
      AV64readonly = "" ;
      GXv_char10 = new String[1] ;
      AV55monacoTokens = "" ;
      GXv_char9 = new String[1] ;
      AV56monacoTokensStyle = "" ;
      GXv_char8 = new String[1] ;
      AV80urlSugerencias = "" ;
      GXv_char28 = new String[1] ;
      AV58nombreLenguaje = "" ;
      GXv_char29 = new String[1] ;
      AV54monacoBrackets = "" ;
      AV75sistema = "" ;
      AV151monacoConFormula = "" ;
      ucMonacoeditor1 = new com.genexus.webpanels.GXUserControl();
      GXt_char7 = "" ;
      AV132OpeCliVig = GXutil.nullDate() ;
      GXv_date32 = new java.util.Date[1] ;
      lV89searchSnippets = "" ;
      H007D8_A534OpeCliDescrip = new String[] {""} ;
      H007D8_A82OpeCliId = new String[] {""} ;
      H007D8_A3CliCod = new int[1] ;
      H007D8_A549OpeCliCodFormula = new String[] {""} ;
      AV136ProcesoLiquidacion = "" ;
      AV131OpeCliValor = "" ;
      AV112editarSnippet = "" ;
      GridsnippetsRow = new com.genexus.webpanels.GXWebRow();
      H007D9_A474OpeDescripcion = new String[] {""} ;
      H007D9_A473OpeCodFormula = new String[] {""} ;
      H007D9_A46PaiCod = new short[1] ;
      H007D9_A74idOperando = new String[] {""} ;
      AV110SDTOperandosFormula = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_objcol_SdtSDTOperandosFormula33 = new GXBaseCollection[1] ;
      GXv_boolean27 = new boolean[1] ;
      GXv_char31 = new String[1] ;
      GXv_decimal26 = new java.math.BigDecimal[1] ;
      GXv_boolean21 = new boolean[1] ;
      GXv_decimal25 = new java.math.BigDecimal[1] ;
      GXv_decimal24 = new java.math.BigDecimal[1] ;
      GXv_boolean20 = new boolean[1] ;
      GXv_char30 = new String[1] ;
      GXv_decimal23 = new java.math.BigDecimal[1] ;
      GXv_boolean11 = new boolean[1] ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      Gridsdt_conceptoss2Row = new com.genexus.webpanels.GXWebRow();
      ucDvpanel_panelcodgos = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_explpanel = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelhis = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_paneluso = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelseusa = new com.genexus.webpanels.GXUserControl();
      ucDvpanel_panelusa = new com.genexus.webpanels.GXUserControl();
      bttBtnvertodosusa_Jsonclick = "" ;
      ucDvpanel_panelprobar = new com.genexus.webpanels.GXUserControl();
      bttBtnactualizar_Jsonclick = "" ;
      lblTextblockcombo_concepto_Jsonclick = "" ;
      Combo_concepto_Caption = "" ;
      lblTextblockconrelsec_Jsonclick = "" ;
      lblTextblock1_Jsonclick = "" ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGridsdt_conceptoss_Linesclass = "" ;
      ROClassString = "" ;
      subGridsdt_conceptoss2_Linesclass = "" ;
      subGrid1_Linesclass = "" ;
      subGridsnippets_Linesclass = "" ;
      GridsnippetsColumn = new com.genexus.webpanels.GXWebColumn();
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      Gridsdt_conceptossColumn = new com.genexus.webpanels.GXWebColumn();
      Gridsdt_conceptoss2Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.formulawc__default(),
         new Object[] {
             new Object[] {
            H007D2_A6LegNumero, H007D2_A250LegIdNomApe, H007D2_A3CliCod, H007D2_A1EmpCod
            }
            , new Object[] {
            H007D3_A31LiqNro, H007D3_A874LiqNombre, H007D3_A3CliCod, H007D3_A1EmpCod
            }
            , new Object[] {
            H007D4_A26ConCodigo, H007D4_A221ForHisAntes, H007D4_n221ForHisAntes, H007D4_A52ImpSec, H007D4_n52ImpSec, H007D4_A51ForHisNum, H007D4_A222ForHisDespues, H007D4_A224ForHisUsuario, H007D4_A223ForHisFecha, H007D4_A3CliCod
            }
            , new Object[] {
            H007D5_AGRID1_nRecordCount
            }
            , new Object[] {
            H007D6_A3CliCod, H007D6_A26ConCodigo, H007D6_A42ConCodYDesc, H007D6_n42ConCodYDesc
            }
            , new Object[] {
            H007D7_A3CliCod, H007D7_A1880CliReDTChar, H007D7_A1885CliRelSec
            }
            , new Object[] {
            H007D8_A534OpeCliDescrip, H007D8_A82OpeCliId, H007D8_A3CliCod, H007D8_A549OpeCliCodFormula
            }
            , new Object[] {
            H007D9_A474OpeDescripcion, H007D9_A473OpeCodFormula, H007D9_A46PaiCod, H007D9_A74idOperando
            }
         }
      );
      AV161Pgmname = "FormulaWC" ;
      /* GeneXus formulas. */
      AV161Pgmname = "FormulaWC" ;
      Gx_err = (short)(0) ;
      edtavFormulacondescripciones_Enabled = 0 ;
      edtavConformulaexpl_Enabled = 0 ;
      edtavIconoexpl_Enabled = 0 ;
      edtavFormulaaux_Enabled = 0 ;
      edtavResultado_Enabled = 0 ;
      edtavSdt_conceptos__concodigo_Enabled = 0 ;
      edtavSdt_conceptos__condescrip_Enabled = 0 ;
      edtavSdt_conceptos2__concodigo_Enabled = 0 ;
      edtavSdt_conceptos2__condescrip_Enabled = 0 ;
      edtavOpecodformula_Enabled = 0 ;
      edtavCopysnippet_Enabled = 0 ;
      edtavNum_Enabled = 0 ;
      edtavEntidad_Enabled = 0 ;
      edtavOpecliid_Enabled = 0 ;
      cmbavIdoperando.setEnabled( 0 );
      edtavAcopiar_Enabled = 0 ;
   }

   private byte GRIDSDT_CONCEPTOSS_nEOF ;
   private byte GRIDSDT_CONCEPTOSS2_nEOF ;
   private byte GRID1_nEOF ;
   private byte GRIDSNIPPETS_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGridsdt_conceptoss_Backcolorstyle ;
   private byte subGridsnippets_Backcolorstyle ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGridsdt_conceptoss2_Backcolorstyle ;
   private byte AV133ConVigencia ;
   private byte GXv_int19[] ;
   private byte nGXWrapped ;
   private byte subGridsdt_conceptoss_Backstyle ;
   private byte subGridsdt_conceptoss2_Backstyle ;
   private byte subGrid1_Backstyle ;
   private byte subGridsnippets_Backstyle ;
   private byte subGridsnippets_Titlebackstyle ;
   private byte subGridsnippets_Allowselection ;
   private byte subGridsnippets_Allowhovering ;
   private byte subGridsnippets_Allowcollapsing ;
   private byte subGridsnippets_Collapsed ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private byte subGridsdt_conceptoss_Titlebackstyle ;
   private byte subGridsdt_conceptoss_Allowselection ;
   private byte subGridsdt_conceptoss_Allowhovering ;
   private byte subGridsdt_conceptoss_Allowcollapsing ;
   private byte subGridsdt_conceptoss_Collapsed ;
   private byte subGridsdt_conceptoss2_Titlebackstyle ;
   private byte subGridsdt_conceptoss2_Allowselection ;
   private byte subGridsdt_conceptoss2_Allowhovering ;
   private byte subGridsdt_conceptoss2_Allowcollapsing ;
   private byte subGridsdt_conceptoss2_Collapsed ;
   private short nRcdExists_9 ;
   private short nIsMod_9 ;
   private short nRcdExists_8 ;
   private short nIsMod_8 ;
   private short nRcdExists_7 ;
   private short nIsMod_7 ;
   private short nRcdExists_6 ;
   private short nIsMod_6 ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short nRcdExists_5 ;
   private short nIsMod_5 ;
   private short nRcdExists_4 ;
   private short nIsMod_4 ;
   private short AV16EmpCod ;
   private short AV98PaiCod ;
   private short AV61num ;
   private short A46PaiCod ;
   private short wbEnd ;
   private short wbStart ;
   private short A51ForHisNum ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short AV18ForHisNum ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private int wcpOAV115parmLiqNro ;
   private int wcpOAV114parmLegNumero ;
   private int Gridsnippetspaginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_106 ;
   private int nRC_GXsfl_115 ;
   private int nRC_GXsfl_131 ;
   private int nRC_GXsfl_159 ;
   private int AV6CliCod ;
   private int subGridsdt_conceptoss_Rows ;
   private int subGridsdt_conceptoss2_Rows ;
   private int subGrid1_Rows ;
   private int subGridsnippets_Rows ;
   private int AV115parmLiqNro ;
   private int AV114parmLegNumero ;
   private int nGXsfl_106_idx=1 ;
   private int AV138clienteNucleoPais_CliCod ;
   private int nGXsfl_115_idx=1 ;
   private int nGXsfl_131_idx=1 ;
   private int nGXsfl_159_idx=1 ;
   private int AV51LiqNro ;
   private int A3CliCod ;
   private int AV48LegNumero ;
   private int Gridsnippetspaginationbar_Pagestoshow ;
   private int Popover_iconoexpl_Popoverwidth ;
   private int bttBtnconfirmar_Visible ;
   private int edtavAcopiar_Visible ;
   private int edtavAcopiar_Enabled ;
   private int edtavConcepto_Visible ;
   private int edtavGridsnippetscurrentpage_Visible ;
   private int edtavClicod_Visible ;
   private int edtavEmpcod_Visible ;
   private int edtavFormula_Visible ;
   private int edtavFormula_Enabled ;
   private int edtavModover_Visible ;
   private int AV155GXV1 ;
   private int AV158GXV4 ;
   private int gxdynajaxindex ;
   private int subGridsdt_conceptoss_Islastpage ;
   private int subGridsnippets_Islastpage ;
   private int subGrid1_Islastpage ;
   private int subGridsdt_conceptoss2_Islastpage ;
   private int AV146ConRelSec ;
   private int edtavFormulacondescripciones_Enabled ;
   private int edtavConformulaexpl_Enabled ;
   private int edtavIconoexpl_Enabled ;
   private int edtavFormulaaux_Enabled ;
   private int edtavResultado_Enabled ;
   private int edtavSdt_conceptos__concodigo_Enabled ;
   private int edtavSdt_conceptos__condescrip_Enabled ;
   private int edtavSdt_conceptos2__concodigo_Enabled ;
   private int edtavSdt_conceptos2__condescrip_Enabled ;
   private int edtavOpecodformula_Enabled ;
   private int edtavCopysnippet_Enabled ;
   private int edtavNum_Enabled ;
   private int edtavEntidad_Enabled ;
   private int edtavOpecliid_Enabled ;
   private int GRIDSDT_CONCEPTOSS_nGridOutOfScope ;
   private int GRIDSNIPPETS_nGridOutOfScope ;
   private int GXPagingFrom6 ;
   private int GXPagingTo6 ;
   private int GRIDSDT_CONCEPTOSS2_nGridOutOfScope ;
   private int subGridsnippets_Recordcount ;
   private int nGXsfl_106_fel_idx=1 ;
   private int nGXsfl_115_fel_idx=1 ;
   private int edtavFormulacondescripciones_Visible ;
   private int lblTextblockconrelsec_Visible ;
   private int AV63PageToGo ;
   private int nGXsfl_115_bak_idx=1 ;
   private int bttBtnactualizar_Visible ;
   private int A1885CliRelSec ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int tblTblparm_Visible ;
   private int tblTblprobar_Visible ;
   private int edtavSearchsnippets_Enabled ;
   private int idxLst ;
   private int subGridsdt_conceptoss_Backcolor ;
   private int subGridsdt_conceptoss_Allbackcolor ;
   private int subGridsdt_conceptoss2_Backcolor ;
   private int subGridsdt_conceptoss2_Allbackcolor ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int subGridsnippets_Backcolor ;
   private int subGridsnippets_Allbackcolor ;
   private int edtavOpecodformula_Visible ;
   private int edtavCopysnippet_Visible ;
   private int edtavNum_Visible ;
   private int edtavEntidad_Visible ;
   private int edtavOpecliid_Visible ;
   private int subGridsnippets_Titlebackcolor ;
   private int subGridsnippets_Selectedindex ;
   private int subGridsnippets_Selectioncolor ;
   private int subGridsnippets_Hoveringcolor ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private int subGridsdt_conceptoss_Titlebackcolor ;
   private int subGridsdt_conceptoss_Selectedindex ;
   private int subGridsdt_conceptoss_Selectioncolor ;
   private int subGridsdt_conceptoss_Hoveringcolor ;
   private int subGridsdt_conceptoss2_Titlebackcolor ;
   private int subGridsdt_conceptoss2_Selectedindex ;
   private int subGridsdt_conceptoss2_Selectioncolor ;
   private int subGridsdt_conceptoss2_Hoveringcolor ;
   private int ZV48LegNumero ;
   private int ZV51LiqNro ;
   private long GRIDSDT_CONCEPTOSS_nFirstRecordOnPage ;
   private long GRIDSDT_CONCEPTOSS2_nFirstRecordOnPage ;
   private long GRID1_nFirstRecordOnPage ;
   private long GRIDSNIPPETS_nFirstRecordOnPage ;
   private long AV96GridSnippetsPageCount ;
   private long AV95GridSnippetsCurrentPage ;
   private long A52ImpSec ;
   private long GRIDSDT_CONCEPTOSS_nCurrentRecord ;
   private long GRIDSDT_CONCEPTOSS2_nCurrentRecord ;
   private long GRID1_nCurrentRecord ;
   private long GRIDSNIPPETS_nCurrentRecord ;
   private long GRIDSDT_CONCEPTOSS_nRecordCount ;
   private long GRID1_nRecordCount ;
   private long GRIDSDT_CONCEPTOSS2_nRecordCount ;
   private long GXv_int17[] ;
   private java.math.BigDecimal AV65Resultado ;
   private java.math.BigDecimal GXv_decimal12[] ;
   private java.math.BigDecimal GXv_decimal26[] ;
   private java.math.BigDecimal GXv_decimal25[] ;
   private java.math.BigDecimal GXv_decimal24[] ;
   private java.math.BigDecimal GXv_decimal23[] ;
   private String wcpOAV10ConCodigo ;
   private String wcpOAV83llamador ;
   private String Gridsnippetspaginationbar_Selectedpage ;
   private String Combo_concepto_Selectedvalue_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV10ConCodigo ;
   private String AV83llamador ;
   private String sGXsfl_106_idx="0001" ;
   private String AV8Concepto ;
   private String AV161Pgmname ;
   private String sGXsfl_115_idx="0001" ;
   private String sGXsfl_131_idx="0001" ;
   private String sGXsfl_159_idx="0001" ;
   private String A82OpeCliId ;
   private String AV89searchSnippets ;
   private String A549OpeCliCodFormula ;
   private String A473OpeCodFormula ;
   private String A74idOperando ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Combo_concepto_Cls ;
   private String Combo_concepto_Selectedvalue_set ;
   private String Monacoeditor1_Monaco_editor_id ;
   private String Monacoeditor1_Nombrelenguaje ;
   private String Monacoeditor1_Monaco_brackets ;
   private String Monacoeditor1_Monaco_tokens ;
   private String Monacoeditor1_Monaco_tokens_style ;
   private String Monacoeditor1_Monaco_foreground ;
   private String Monacoeditor1_Monaco_url_sug ;
   private String Monacoeditor1_Valorinicial ;
   private String Monacoeditor1_Monaco_linenumbers ;
   private String Monacoeditor1_Monaco_wordwrap ;
   private String Monacoeditor1_Monaco_columns ;
   private String Monacoeditor1_Monaco_readonly ;
   private String Monacoeditor1_Monaco_minimap ;
   private String Monacoeditor1_Variable_asociada ;
   private String Monacoeditor1_Permitidos ;
   private String Monacoeditor1_Palabra_concepto ;
   private String Monacoeditor1_Url_sug_querystring ;
   private String Dvpanel_explpanel_Width ;
   private String Dvpanel_explpanel_Cls ;
   private String Dvpanel_explpanel_Title ;
   private String Dvpanel_explpanel_Iconposition ;
   private String Dvpanel_panelprobar_Width ;
   private String Dvpanel_panelprobar_Cls ;
   private String Dvpanel_panelprobar_Title ;
   private String Dvpanel_panelprobar_Iconposition ;
   private String Dvpanel_panelseusa_Width ;
   private String Dvpanel_panelseusa_Cls ;
   private String Dvpanel_panelseusa_Title ;
   private String Dvpanel_panelseusa_Iconposition ;
   private String Dvpanel_panelusa_Width ;
   private String Dvpanel_panelusa_Cls ;
   private String Dvpanel_panelusa_Title ;
   private String Dvpanel_panelusa_Iconposition ;
   private String Dvpanel_paneluso_Width ;
   private String Dvpanel_paneluso_Cls ;
   private String Dvpanel_paneluso_Title ;
   private String Dvpanel_paneluso_Iconposition ;
   private String Dvpanel_panelhis_Width ;
   private String Dvpanel_panelhis_Cls ;
   private String Dvpanel_panelhis_Title ;
   private String Dvpanel_panelhis_Iconposition ;
   private String Gridsnippetspaginationbar_Class ;
   private String Gridsnippetspaginationbar_Pagingbuttonsposition ;
   private String Gridsnippetspaginationbar_Pagingcaptionposition ;
   private String Gridsnippetspaginationbar_Emptygridclass ;
   private String Gridsnippetspaginationbar_Rowsperpageoptions ;
   private String Gridsnippetspaginationbar_Previous ;
   private String Gridsnippetspaginationbar_Next ;
   private String Gridsnippetspaginationbar_Caption ;
   private String Gridsnippetspaginationbar_Emptygridcaption ;
   private String Gridsnippetspaginationbar_Rowsperpagecaption ;
   private String Dvpanel_panelcodgos_Width ;
   private String Dvpanel_panelcodgos_Cls ;
   private String Dvpanel_panelcodgos_Title ;
   private String Dvpanel_panelcodgos_Iconposition ;
   private String Popover_iconoexpl_Iteminternalname ;
   private String Popover_iconoexpl_Triggerelement ;
   private String Popover_iconoexpl_Html ;
   private String Popover_iconoexpl_Position ;
   private String Gridsnippets_empowerer_Gridinternalname ;
   private String Grid1_empowerer_Gridinternalname ;
   private String Grid1_empowerer_Infinitescrolling ;
   private String Gridsdt_conceptoss2_empowerer_Gridinternalname ;
   private String Gridsdt_conceptoss_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtnconfirmar_Internalname ;
   private String bttBtnconfirmar_Jsonclick ;
   private String bttBtncancelar_Internalname ;
   private String bttBtncancelar_Jsonclick ;
   private String lblJs_Internalname ;
   private String lblJs_Caption ;
   private String lblJs_Jsonclick ;
   private String edtavAcopiar_Internalname ;
   private String AV5aCopiar ;
   private String edtavAcopiar_Jsonclick ;
   private String lblJs2_Internalname ;
   private String lblJs2_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtavConcepto_Internalname ;
   private String edtavConcepto_Jsonclick ;
   private String Popover_iconoexpl_Internalname ;
   private String edtavGridsnippetscurrentpage_Internalname ;
   private String edtavGridsnippetscurrentpage_Jsonclick ;
   private String edtavClicod_Internalname ;
   private String edtavClicod_Jsonclick ;
   private String edtavEmpcod_Internalname ;
   private String edtavEmpcod_Jsonclick ;
   private String edtavFormula_Internalname ;
   private String edtavModover_Internalname ;
   private String AV127ModoVer ;
   private String edtavModover_Jsonclick ;
   private String Gridsnippets_empowerer_Internalname ;
   private String Grid1_empowerer_Internalname ;
   private String Gridsdt_conceptoss2_empowerer_Internalname ;
   private String Gridsdt_conceptoss_empowerer_Internalname ;
   private String sStyleString ;
   private String subGridsdt_conceptoss_Internalname ;
   private String subGridsdt_conceptoss2_Internalname ;
   private String subGrid1_Internalname ;
   private String subGridsnippets_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtForHisFecha_Internalname ;
   private String edtForHisUsuario_Internalname ;
   private String edtForHisDespues_Internalname ;
   private String edtForHisNum_Internalname ;
   private String edtImpSec_Internalname ;
   private String edtForHisAntes_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String AV94OpeCodFormula ;
   private String edtavOpecodformula_Internalname ;
   private String AV14copySnippet ;
   private String edtavCopysnippet_Internalname ;
   private String edtavNum_Internalname ;
   private String AV102entidad ;
   private String edtavEntidad_Internalname ;
   private String AV116OpeCliId ;
   private String edtavOpecliid_Internalname ;
   private String AV117idOperando ;
   private String gxwrpcisep ;
   private String scmdbuf ;
   private String GXCCtl ;
   private String edtavFormulacondescripciones_Internalname ;
   private String edtavConformulaexpl_Internalname ;
   private String edtavIconoexpl_Internalname ;
   private String edtavFormulaaux_Internalname ;
   private String edtavResultado_Internalname ;
   private String edtavSdt_conceptos__concodigo_Internalname ;
   private String edtavSdt_conceptos__condescrip_Internalname ;
   private String edtavSdt_conceptos2__concodigo_Internalname ;
   private String edtavSdt_conceptos2__condescrip_Internalname ;
   private String sGXsfl_106_fel_idx="0001" ;
   private String sGXsfl_115_fel_idx="0001" ;
   private String AV122IconoExpl ;
   private String edtavSearchsnippets_Internalname ;
   private String lblTextblockconrelsec_Internalname ;
   private String AV99codigoOpeConcepto ;
   private String AV100codigoOpeRemuVar ;
   private String Gridsnippetspaginationbar_Internalname ;
   private String Combo_concepto_Internalname ;
   private String tblTablemonaco_Class ;
   private String tblTablemonaco_Internalname ;
   private String bttBtnactualizar_Internalname ;
   private String AV137mensualTLiqCod ;
   private String AV149ConPadre ;
   private String AV135TipoConCod ;
   private String AV50lineNumbers_OnOff ;
   private String GXv_char18[] ;
   private String AV81wordWrap ;
   private String GXv_char16[] ;
   private String AV82wordWrapColumn ;
   private String GXv_char15[] ;
   private String AV52monaco_foreground ;
   private String GXv_char14[] ;
   private String AV53monaco_minimap ;
   private String GXv_char13[] ;
   private String AV64readonly ;
   private String GXv_char10[] ;
   private String GXv_char9[] ;
   private String GXv_char8[] ;
   private String GXv_char28[] ;
   private String AV58nombreLenguaje ;
   private String GXv_char29[] ;
   private String AV75sistema ;
   private String tblTblparm_Internalname ;
   private String Monacoeditor1_Internalname ;
   private String GXt_char7 ;
   private String tblTblprobar_Internalname ;
   private String lV89searchSnippets ;
   private String AV136ProcesoLiquidacion ;
   private String edtavOpecodformula_Tooltiptext ;
   private String AV112editarSnippet ;
   private String edtavCopysnippet_Class ;
   private String GXv_char31[] ;
   private String GXv_char30[] ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String tblTblvar_Internalname ;
   private String Dvpanel_panelcodgos_Internalname ;
   private String divPanelcodgos_Internalname ;
   private String edtavSearchsnippets_Jsonclick ;
   private String divGridsnippetstablewithpaginationbar_Internalname ;
   private String tblTableleft_Internalname ;
   private String Dvpanel_explpanel_Internalname ;
   private String divExplpanel_Internalname ;
   private String edtavIconoexpl_Jsonclick ;
   private String tblTblhist_Internalname ;
   private String Dvpanel_panelhis_Internalname ;
   private String divPanelhis_Internalname ;
   private String tblTbluso_Internalname ;
   private String Dvpanel_paneluso_Internalname ;
   private String divPaneluso_Internalname ;
   private String Dvpanel_panelseusa_Internalname ;
   private String divPanelseusa_Internalname ;
   private String Dvpanel_panelusa_Internalname ;
   private String divPanelusa_Internalname ;
   private String bttBtnvertodosusa_Internalname ;
   private String bttBtnvertodosusa_Jsonclick ;
   private String Dvpanel_panelprobar_Internalname ;
   private String divPanelprobar_Internalname ;
   private String edtavResultado_Jsonclick ;
   private String bttBtnactualizar_Jsonclick ;
   private String tblTblconcepto_Internalname ;
   private String divTablesplittedconcepto_Internalname ;
   private String lblTextblockcombo_concepto_Internalname ;
   private String lblTextblockcombo_concepto_Jsonclick ;
   private String Combo_concepto_Caption ;
   private String divUnnamedtableconrelsec_Internalname ;
   private String lblTextblockconrelsec_Jsonclick ;
   private String lblTextblock1_Internalname ;
   private String lblTextblock1_Jsonclick ;
   private String subGridsdt_conceptoss_Class ;
   private String subGridsdt_conceptoss_Linesclass ;
   private String ROClassString ;
   private String edtavSdt_conceptos__concodigo_Jsonclick ;
   private String edtavSdt_conceptos__condescrip_Jsonclick ;
   private String subGridsdt_conceptoss2_Class ;
   private String subGridsdt_conceptoss2_Linesclass ;
   private String edtavSdt_conceptos2__concodigo_Jsonclick ;
   private String edtavSdt_conceptos2__condescrip_Jsonclick ;
   private String sGXsfl_131_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String edtForHisFecha_Jsonclick ;
   private String edtForHisUsuario_Jsonclick ;
   private String edtForHisDespues_Jsonclick ;
   private String edtForHisNum_Jsonclick ;
   private String edtImpSec_Jsonclick ;
   private String edtForHisAntes_Jsonclick ;
   private String edtConCodigo_Jsonclick ;
   private String sGXsfl_159_fel_idx="0001" ;
   private String subGridsnippets_Class ;
   private String subGridsnippets_Linesclass ;
   private String edtavOpecodformula_Jsonclick ;
   private String edtavCopysnippet_Jsonclick ;
   private String edtavNum_Jsonclick ;
   private String edtavEntidad_Jsonclick ;
   private String edtavOpecliid_Jsonclick ;
   private String subGridsnippets_Header ;
   private String subGrid1_Header ;
   private String subGridsdt_conceptoss_Header ;
   private String subGridsdt_conceptoss2_Header ;
   private java.util.Date A223ForHisFecha ;
   private java.util.Date AV134LiqPeriodo ;
   private java.util.Date AV139date ;
   private java.util.Date AV132OpeCliVig ;
   private java.util.Date GXv_date32[] ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV142ClienteConveniador ;
   private boolean AV17esConceptosDefault ;
   private boolean AV19FormOK ;
   private boolean AV78start ;
   private boolean Combo_concepto_Emptyitem ;
   private boolean Dvpanel_explpanel_Autowidth ;
   private boolean Dvpanel_explpanel_Autoheight ;
   private boolean Dvpanel_explpanel_Collapsible ;
   private boolean Dvpanel_explpanel_Collapsed ;
   private boolean Dvpanel_explpanel_Showcollapseicon ;
   private boolean Dvpanel_explpanel_Autoscroll ;
   private boolean Dvpanel_panelprobar_Autowidth ;
   private boolean Dvpanel_panelprobar_Autoheight ;
   private boolean Dvpanel_panelprobar_Collapsible ;
   private boolean Dvpanel_panelprobar_Collapsed ;
   private boolean Dvpanel_panelprobar_Showcollapseicon ;
   private boolean Dvpanel_panelprobar_Autoscroll ;
   private boolean Dvpanel_panelseusa_Autowidth ;
   private boolean Dvpanel_panelseusa_Autoheight ;
   private boolean Dvpanel_panelseusa_Collapsible ;
   private boolean Dvpanel_panelseusa_Collapsed ;
   private boolean Dvpanel_panelseusa_Showcollapseicon ;
   private boolean Dvpanel_panelseusa_Autoscroll ;
   private boolean Dvpanel_panelusa_Autowidth ;
   private boolean Dvpanel_panelusa_Autoheight ;
   private boolean Dvpanel_panelusa_Collapsible ;
   private boolean Dvpanel_panelusa_Collapsed ;
   private boolean Dvpanel_panelusa_Showcollapseicon ;
   private boolean Dvpanel_panelusa_Autoscroll ;
   private boolean Dvpanel_paneluso_Autowidth ;
   private boolean Dvpanel_paneluso_Autoheight ;
   private boolean Dvpanel_paneluso_Collapsible ;
   private boolean Dvpanel_paneluso_Collapsed ;
   private boolean Dvpanel_paneluso_Showcollapseicon ;
   private boolean Dvpanel_paneluso_Autoscroll ;
   private boolean Dvpanel_panelhis_Autowidth ;
   private boolean Dvpanel_panelhis_Autoheight ;
   private boolean Dvpanel_panelhis_Collapsible ;
   private boolean Dvpanel_panelhis_Collapsed ;
   private boolean Dvpanel_panelhis_Showcollapseicon ;
   private boolean Dvpanel_panelhis_Autoscroll ;
   private boolean Gridsnippetspaginationbar_Showfirst ;
   private boolean Gridsnippetspaginationbar_Showprevious ;
   private boolean Gridsnippetspaginationbar_Shownext ;
   private boolean Gridsnippetspaginationbar_Showlast ;
   private boolean Gridsnippetspaginationbar_Rowsperpageselector ;
   private boolean Dvpanel_panelcodgos_Autowidth ;
   private boolean Dvpanel_panelcodgos_Autoheight ;
   private boolean Dvpanel_panelcodgos_Collapsible ;
   private boolean Dvpanel_panelcodgos_Collapsed ;
   private boolean Dvpanel_panelcodgos_Showcollapseicon ;
   private boolean Dvpanel_panelcodgos_Autoscroll ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean n52ImpSec ;
   private boolean n221ForHisAntes ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean bGXsfl_106_Refreshing=false ;
   private boolean bGXsfl_115_Refreshing=false ;
   private boolean bGXsfl_159_Refreshing=false ;
   private boolean bGXsfl_131_Refreshing=false ;
   private boolean returnInSub ;
   private boolean AV141esSistemaConceptosDefault ;
   private boolean AV152historicoHay ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private boolean gx_BV115 ;
   private boolean n42ConCodYDesc ;
   private boolean AV150permiteModificacion ;
   private boolean AV145aplicadoHay ;
   private boolean AV143formulaOK ;
   private boolean AV62ok ;
   private boolean AV125dependenciasResueltas ;
   private boolean GXv_boolean5[] ;
   private boolean GXt_boolean6 ;
   private boolean AV13ConForEditable ;
   private boolean gx_BV106 ;
   private boolean AV120hayLiquidaciones ;
   private boolean GXv_boolean27[] ;
   private boolean GXv_boolean21[] ;
   private boolean GXv_boolean20[] ;
   private boolean GXv_boolean11[] ;
   private String AV20Formula ;
   private String A222ForHisDespues ;
   private String A221ForHisAntes ;
   private String AV126formulaConDescripciones ;
   private String AV119ConFormulaExpl ;
   private String AV21FormulaAux ;
   private String AV107ConFormula ;
   private String AV151monacoConFormula ;
   private String AV131OpeCliValor ;
   private String wcpOAV147MenuOpcCod ;
   private String AV147MenuOpcCod ;
   private String A534OpeCliDescrip ;
   private String A474OpeDescripcion ;
   private String AV97GridSnippetsAppliedFilters ;
   private String A224ForHisUsuario ;
   private String A42ConCodYDesc ;
   private String AV108queryString ;
   private String AV123error ;
   private String AV57msgInstanciar ;
   private String AV124formulaError ;
   private String A1880CliReDTChar ;
   private String AV12ConDescrip ;
   private String AV55monacoTokens ;
   private String AV56monacoTokensStyle ;
   private String AV80urlSugerencias ;
   private String AV54monacoBrackets ;
   private com.genexus.webpanels.GXWebGrid Gridsdt_conceptossContainer ;
   private com.genexus.webpanels.GXWebGrid Gridsdt_conceptoss2Container ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebGrid GridsnippetsContainer ;
   private com.genexus.webpanels.GXWebRow Gridsdt_conceptossRow ;
   private com.genexus.webpanels.GXWebRow GridsnippetsRow ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebRow Gridsdt_conceptoss2Row ;
   private com.genexus.webpanels.GXWebColumn GridsnippetsColumn ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.webpanels.GXWebColumn Gridsdt_conceptossColumn ;
   private com.genexus.webpanels.GXWebColumn Gridsdt_conceptoss2Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.GXUserControl ucPopover_iconoexpl ;
   private com.genexus.webpanels.GXUserControl ucGridsnippets_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGrid1_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdt_conceptoss2_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsdt_conceptoss_empowerer ;
   private com.genexus.webpanels.GXUserControl ucGridsnippetspaginationbar ;
   private com.genexus.webpanels.GXUserControl ucCombo_concepto ;
   private com.genexus.webpanels.GXUserControl ucMonacoeditor1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelcodgos ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_explpanel ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelhis ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_paneluso ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelseusa ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelusa ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_panelprobar ;
   private HTMLChoice cmbavConrelsec ;
   private HTMLChoice dynavLegnumero ;
   private HTMLChoice dynavLiqnro ;
   private HTMLChoice cmbavIdoperando ;
   private IDataStoreProvider pr_default ;
   private int[] H007D2_A6LegNumero ;
   private String[] H007D2_A250LegIdNomApe ;
   private int[] H007D2_A3CliCod ;
   private short[] H007D2_A1EmpCod ;
   private int[] H007D3_A31LiqNro ;
   private String[] H007D3_A874LiqNombre ;
   private int[] H007D3_A3CliCod ;
   private short[] H007D3_A1EmpCod ;
   private String[] H007D4_A26ConCodigo ;
   private String[] H007D4_A221ForHisAntes ;
   private boolean[] H007D4_n221ForHisAntes ;
   private long[] H007D4_A52ImpSec ;
   private boolean[] H007D4_n52ImpSec ;
   private short[] H007D4_A51ForHisNum ;
   private String[] H007D4_A222ForHisDespues ;
   private String[] H007D4_A224ForHisUsuario ;
   private java.util.Date[] H007D4_A223ForHisFecha ;
   private int[] H007D4_A3CliCod ;
   private long[] H007D5_AGRID1_nRecordCount ;
   private int[] H007D6_A3CliCod ;
   private String[] H007D6_A26ConCodigo ;
   private String[] H007D6_A42ConCodYDesc ;
   private boolean[] H007D6_n42ConCodYDesc ;
   private int[] H007D7_A3CliCod ;
   private String[] H007D7_A1880CliReDTChar ;
   private int[] H007D7_A1885CliRelSec ;
   private String[] H007D8_A534OpeCliDescrip ;
   private String[] H007D8_A82OpeCliId ;
   private int[] H007D8_A3CliCod ;
   private String[] H007D8_A549OpeCliCodFormula ;
   private String[] H007D9_A474OpeDescripcion ;
   private String[] H007D9_A473OpeCodFormula ;
   private short[] H007D9_A46PaiCod ;
   private String[] H007D9_A74idOperando ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV9Concepto_Data ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV66sdt_conceptos ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> AV84sdt_conceptos2 ;
   private GXBaseCollection<web.Sdtsdt_conceptos_sdt_conceptosItem> GXv_objcol_Sdtsdt_conceptos_sdt_conceptosItem22[] ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV110SDTOperandosFormula ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula33[] ;
   private web.wwpbaseobjects.SdtDVB_SDTComboData_Item AV7Combo_DataItem ;
}

final  class formulawc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H007D8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV89searchSnippets ,
                                          String A82OpeCliId ,
                                          String A534OpeCliDescrip ,
                                          int AV6CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int34 = new byte[3];
      Object[] GXv_Object35 = new Object[2];
      scmdbuf = "SELECT OpeCliDescrip, OpeCliId, CliCod, OpeCliCodFormula FROM Variable" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV89searchSnippets)==0) )
      {
         addWhere(sWhereString, "(OpeCliId like '%' || ? or OpeCliDescrip like '%' || ?)");
      }
      else
      {
         GXv_int34[1] = (byte)(1) ;
         GXv_int34[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object35[0] = scmdbuf ;
      GXv_Object35[1] = GXv_int34 ;
      return GXv_Object35 ;
   }

   protected Object[] conditional_H007D9( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV89searchSnippets ,
                                          String A473OpeCodFormula ,
                                          String A474OpeDescripcion ,
                                          short AV98PaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int36 = new byte[3];
      Object[] GXv_Object37 = new Object[2];
      scmdbuf = "SELECT OpeDescripcion, OpeCodFormula, PaiCod, idOperando FROM calculo" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      if ( ! (GXutil.strcmp("", AV89searchSnippets)==0) )
      {
         addWhere(sWhereString, "(OpeCodFormula like '%' || ? or OpeDescripcion like '%' || ?)");
      }
      else
      {
         GXv_int36[1] = (byte)(1) ;
         GXv_int36[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object37[0] = scmdbuf ;
      GXv_Object37[1] = GXv_int36 ;
      return GXv_Object37 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 6 :
                  return conditional_H007D8(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() );
            case 7 :
                  return conditional_H007D9(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H007D2", "SELECT LegNumero, LegIdNomApe, CliCod, EmpCod FROM Legajo WHERE (CliCod = ?) AND (EmpCod = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D3", "SELECT LiqNro, LiqNombre, CliCod, EmpCod FROM Liquidacion WHERE (CliCod = ?) AND (EmpCod = ?) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D4", "SELECT ConCodigo, ForHisAntes, ImpSec, ForHisNum, ForHisDespues, ForHisUsuario, ForHisFecha, CliCod FROM FormulaHistorico WHERE (ForHisNum >= 1) AND (ForHisNum <= ?) AND (ConCodigo = ( ?)) ORDER BY CliCod, ConCodigo, ForHisNum  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,51, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D5", "SELECT COUNT(*) FROM FormulaHistorico WHERE (ForHisNum >= 1) AND (ForHisNum <= ?) AND (ConCodigo = ( ?)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D6", "SELECT CliCod, ConCodigo, ConCodYDesc FROM Concepto WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D7", "SELECT CliCod, CliReDTChar, CliRelSec FROM Cliente_Release WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D8", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H007D9", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((long[]) buf[3])[0] = rslt.getLong(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((short[]) buf[5])[0] = rslt.getShort(4);
               ((String[]) buf[6])[0] = rslt.getLongVarchar(5);
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((java.util.Date[]) buf[8])[0] = rslt.getGXDateTime(7);
               ((int[]) buf[9])[0] = rslt.getInt(8);
               return;
            case 3 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 10);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               return;
            case 7 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               return;
      }
   }

}

