package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class verliqretro2_impl extends GXDataArea
{
   public verliqretro2_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public verliqretro2_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( verliqretro2_impl.class ));
   }

   public verliqretro2_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbDTipoConCod = new HTMLChoice();
      cmbavDtipoconcod = new HTMLChoice();
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid") == 0 )
         {
            gxnrgrid_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid") == 0 )
         {
            gxgrgrid_refresh_invoke( ) ;
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
            AV35CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV35CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35CliCod), "ZZZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV36EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV36EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36EmpCod), 4, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36EmpCod), "ZZZ9")));
               AV37LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV37LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37LiqNro), 8, 0));
               web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37LiqNro), "ZZZZZZZ9")));
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

   public void gxnrgrid_newrow_invoke( )
   {
      nRC_GXsfl_13 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_13"))) ;
      nGXsfl_13_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_13_idx"))) ;
      sGXsfl_13_idx = httpContext.GetPar( "sGXsfl_13_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid_newrow( ) ;
      /* End function gxnrGrid_newrow_invoke */
   }

   public void gxgrgrid_refresh_invoke( )
   {
      subGrid_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid_Rows"))) ;
      AV35CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      AV36EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
      AV37LiqNro = (int)(GXutil.lval( httpContext.GetPar( "LiqNro"))) ;
      cmbavDtipoconcod.fromJSonString( httpContext.GetNextPar( ));
      AV15DTipoConCod = httpContext.GetPar( "DTipoConCod") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV18TFDTipoConCod_Sels);
      AV20TFDConCodigo = httpContext.GetPar( "TFDConCodigo") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV21TFDConCodigo_Sels);
      AV23TFDConDescrip = httpContext.GetPar( "TFDConDescrip") ;
      httpContext.ajax_req_read_hidden_sdt(httpContext.GetNextPar( ), AV24TFDConDescrip_Sels);
      AV25TFLiqDImpReCalcu = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu"), ".") ;
      AV26TFLiqDImpReCalcu_To = CommonUtil.decimalVal( httpContext.GetPar( "TFLiqDImpReCalcu_To"), ".") ;
      AV52Pgmname = httpContext.GetPar( "Pgmname") ;
      AV13OrderedBy = (short)(GXutil.lval( httpContext.GetPar( "OrderedBy"))) ;
      AV14OrderedDsc = GXutil.strtobool( httpContext.GetPar( "OrderedDsc")) ;
      AV41Verliqretro2ds_1_clicod = (int)(GXutil.lval( httpContext.GetPar( "Verliqretro2ds_1_clicod"))) ;
      AV42Verliqretro2ds_2_empcod = (short)(GXutil.lval( httpContext.GetPar( "Verliqretro2ds_2_empcod"))) ;
      AV43Verliqretro2ds_3_liqnro = (int)(GXutil.lval( httpContext.GetPar( "Verliqretro2ds_3_liqnro"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageprompt");
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
      paM92( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         startM92( ) ;
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.verliqretro2", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV35CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV36EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV37LiqNro,8,0))}, new String[] {"CliCod","EmpCod","LiqNro"}) +"\">") ;
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
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV52Pgmname, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_13", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_13, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV30DDO_TitleSettingsIcons);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV35CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV36EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV37LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37LiqNro), "ZZZZZZZ9")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDTIPOCONCOD_SELS", AV18TFDTipoConCod_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDTIPOCONCOD_SELS", AV18TFDTipoConCod_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONCODIGO", GXutil.rtrim( AV20TFDConCodigo));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONCODIGO_SELS", AV21TFDConCodigo_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONCODIGO_SELS", AV21TFDConCodigo_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFDCONDESCRIP", AV23TFDConDescrip);
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTFDCONDESCRIP_SELS", AV24TFDConDescrip_Sels);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTFDCONDESCRIP_SELS", AV24TFDConDescrip_Sels);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU", GXutil.ltrim( localUtil.ntoc( AV25TFLiqDImpReCalcu, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vTFLIQDIMPRECALCU_TO", GXutil.ltrim( localUtil.ntoc( AV26TFLiqDImpReCalcu_To, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV52Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV52Pgmname, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vORDEREDBY", GXutil.ltrim( localUtil.ntoc( AV13OrderedBy, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vORDEREDDSC", AV14OrderedDsc);
      web.GxWebStd.gx_hidden_field( httpContext, "vVERLIQRETRO2DS_1_CLICOD", GXutil.ltrim( localUtil.ntoc( AV41Verliqretro2ds_1_clicod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vVERLIQRETRO2DS_2_EMPCOD", GXutil.ltrim( localUtil.ntoc( AV42Verliqretro2ds_2_empcod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vVERLIQRETRO2DS_3_LIQNRO", GXutil.ltrim( localUtil.ntoc( AV43Verliqretro2ds_3_liqnro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Caption", GXutil.rtrim( Ddo_grid_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_set", GXutil.rtrim( Ddo_grid_Filteredtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_set", GXutil.rtrim( Ddo_grid_Filteredtextto_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_set", GXutil.rtrim( Ddo_grid_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Gridinternalname", GXutil.rtrim( Ddo_grid_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnids", GXutil.rtrim( Ddo_grid_Columnids));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Columnssortvalues", GXutil.rtrim( Ddo_grid_Columnssortvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includesortasc", GXutil.rtrim( Ddo_grid_Includesortasc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Sortedstatus", GXutil.rtrim( Ddo_grid_Sortedstatus));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includefilter", GXutil.rtrim( Ddo_grid_Includefilter));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filtertype", GXutil.rtrim( Ddo_grid_Filtertype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filterisrange", GXutil.rtrim( Ddo_grid_Filterisrange));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Includedatalist", GXutil.rtrim( Ddo_grid_Includedatalist));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalisttype", GXutil.rtrim( Ddo_grid_Datalisttype));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Allowmultipleselection", GXutil.rtrim( Ddo_grid_Allowmultipleselection));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistfixedvalues", GXutil.rtrim( Ddo_grid_Datalistfixedvalues));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Datalistproc", GXutil.rtrim( Ddo_grid_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Format", GXutil.rtrim( Ddo_grid_Format));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_EMPOWERER_Hastitlesettings", GXutil.booltostr( Grid_empowerer_Hastitlesettings));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Activeeventkey", GXutil.rtrim( Ddo_grid_Activeeventkey));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedvalue_get", GXutil.rtrim( Ddo_grid_Selectedvalue_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Selectedcolumn", GXutil.rtrim( Ddo_grid_Selectedcolumn));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtext_get", GXutil.rtrim( Ddo_grid_Filteredtext_get));
      web.GxWebStd.gx_hidden_field( httpContext, "DDO_GRID_Filteredtextto_get", GXutil.rtrim( Ddo_grid_Filteredtextto_get));
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
         weM92( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evtM92( ) ;
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
      return formatLink("web.verliqretro2", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV35CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV36EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV37LiqNro,8,0))}, new String[] {"CliCod","EmpCod","LiqNro"})  ;
   }

   public String getPgmname( )
   {
      return "verLiqRetro2" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( " Liquidacion Detalle", "") ;
   }

   public void wbM90( )
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
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainWithShadow", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtavLiqnombre_Internalname, httpContext.getMessage( "Liquidación", ""), "col-sm-3 AttributeLabel", 0, true, "");
         /* Multiple line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 10,'',false,'" + sGXsfl_13_idx + "',0)\"" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         ClassString = "Attribute" ;
         StyleString = "" ;
         web.GxWebStd.gx_html_textarea( httpContext, edtavLiqnombre_Internalname, AV38LiqNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,10);\"", (short)(0), 1, edtavLiqnombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_verLiqRetro2.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell HasGridEmpowerer", "left", "top", "", "", "div");
         /*  Grid Control  */
         GridContainer.SetWrapped(nGXWrapped);
         startgridcontrol13( ) ;
      }
      if ( wbEnd == 13 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_13 = (int)(nGXsfl_13_idx-1) ;
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
            GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", cmbavDtipoconcod.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbavDtipoconcod.getInternalname()+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, cmbavDtipoconcod.getInternalname(), httpContext.getMessage( "DTipo Con Cod", ""), "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 28,'',false,'" + sGXsfl_13_idx + "',0)\"" ;
         /* ComboBox */
         web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbavDtipoconcod, cmbavDtipoconcod.getInternalname(), GXutil.rtrim( AV15DTipoConCod), 1, cmbavDtipoconcod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbavDtipoconcod.getVisible(), cmbavDtipoconcod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,28);\"", "", true, (byte)(0), "HLP_verLiqRetro2.htm");
         cmbavDtipoconcod.setValue( GXutil.rtrim( AV15DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDtipoconcod.getInternalname(), "Values", cmbavDtipoconcod.ToJavascriptSource(), true);
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
         /* User Defined Control */
         ucDdo_grid.setProperty("Caption", Ddo_grid_Caption);
         ucDdo_grid.setProperty("ColumnIds", Ddo_grid_Columnids);
         ucDdo_grid.setProperty("ColumnsSortValues", Ddo_grid_Columnssortvalues);
         ucDdo_grid.setProperty("IncludeSortASC", Ddo_grid_Includesortasc);
         ucDdo_grid.setProperty("IncludeFilter", Ddo_grid_Includefilter);
         ucDdo_grid.setProperty("FilterType", Ddo_grid_Filtertype);
         ucDdo_grid.setProperty("FilterIsRange", Ddo_grid_Filterisrange);
         ucDdo_grid.setProperty("IncludeDataList", Ddo_grid_Includedatalist);
         ucDdo_grid.setProperty("DataListType", Ddo_grid_Datalisttype);
         ucDdo_grid.setProperty("AllowMultipleSelection", Ddo_grid_Allowmultipleselection);
         ucDdo_grid.setProperty("DataListFixedValues", Ddo_grid_Datalistfixedvalues);
         ucDdo_grid.setProperty("DataListProc", Ddo_grid_Datalistproc);
         ucDdo_grid.setProperty("Format", Ddo_grid_Format);
         ucDdo_grid.setProperty("DropDownOptionsTitleSettingsIcons", AV30DDO_TitleSettingsIcons);
         ucDdo_grid.render(context, "dvelop.gxbootstrap.ddogridtitlesettingsm", Ddo_grid_Internalname, "DDO_GRIDContainer");
         /* User Defined Control */
         ucGrid_empowerer.setProperty("HasTitleSettings", Grid_empowerer_Hastitlesettings);
         ucGrid_empowerer.render(context, "wwp.gridempowerer", Grid_empowerer_Internalname, "GRID_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 13 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( GridContainer.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               GridContainer.AddObjectProperty("GRID_nEOF", GRID_nEOF);
               GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"GridContainer"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid", GridContainer, subGrid_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData", GridContainer.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, "GridContainerData"+"V", GridContainer.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"GridContainerData"+"V"+"\" value='"+GridContainer.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startM92( )
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
         Form.getMeta().addItem("description", httpContext.getMessage( " Liquidacion Detalle", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strupM90( ) ;
   }

   public void wsM92( )
   {
      startM92( ) ;
      evtM92( ) ;
   }

   public void evtM92( )
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
                        else if ( GXutil.strcmp(sEvt, "DDO_GRID.ONOPTIONCLICKED") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           e11M92 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRIDPAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           AV41Verliqretro2ds_1_clicod = AV35CliCod ;
                           AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
                           AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
                           AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
                           AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
                           AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
                           AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
                           AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
                           AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
                           AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
                           AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
                           sEvt = httpContext.cgiGet( "GRIDPAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 9), "GRID.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           nGXsfl_13_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_132( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A31LiqNro = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqNro_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A6LegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           A81LiqDSecuencial = (int)(localUtil.ctol( httpContext.cgiGet( edtLiqDSecuencial_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           cmbDTipoConCod.setName( cmbDTipoConCod.getInternalname() );
                           cmbDTipoConCod.setValue( httpContext.cgiGet( cmbDTipoConCod.getInternalname()) );
                           A464DTipoConCod = httpContext.cgiGet( cmbDTipoConCod.getInternalname()) ;
                           A394DConCodigo = httpContext.cgiGet( edtDConCodigo_Internalname) ;
                           A393DConDescrip = httpContext.cgiGet( edtDConDescrip_Internalname) ;
                           A764LiqDImpReCalcu = localUtil.ctond( httpContext.cgiGet( edtLiqDImpReCalcu_Internalname)) ;
                           A1070LiqDLog = httpContext.cgiGet( edtLiqDLog_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e12M92 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Refresh */
                                 e13M92 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID.LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 e14M92 ();
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
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weM92( )
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

   public void paM92( )
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
            GX_FocusControl = edtavLiqnombre_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_132( ) ;
      while ( nGXsfl_13_idx <= nRC_GXsfl_13 )
      {
         sendrow_132( ) ;
         nGXsfl_13_idx = ((subGrid_Islastpage==1)&&(nGXsfl_13_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_13_idx+1) ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
      }
      addString( httpContext.getJSONContainerResponse( GridContainer)) ;
      /* End function gxnrGrid_newrow */
   }

   public void gxgrgrid_refresh( int subGrid_Rows ,
                                 int AV35CliCod ,
                                 short AV36EmpCod ,
                                 int AV37LiqNro ,
                                 String AV15DTipoConCod ,
                                 GXSimpleCollection<String> AV18TFDTipoConCod_Sels ,
                                 String AV20TFDConCodigo ,
                                 GXSimpleCollection<String> AV21TFDConCodigo_Sels ,
                                 String AV23TFDConDescrip ,
                                 GXSimpleCollection<String> AV24TFDConDescrip_Sels ,
                                 java.math.BigDecimal AV25TFLiqDImpReCalcu ,
                                 java.math.BigDecimal AV26TFLiqDImpReCalcu_To ,
                                 String AV52Pgmname ,
                                 short AV13OrderedBy ,
                                 boolean AV14OrderedDsc ,
                                 int AV41Verliqretro2ds_1_clicod ,
                                 short AV42Verliqretro2ds_2_empcod ,
                                 int AV43Verliqretro2ds_3_liqnro )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e13M92 ();
      GRID_nCurrentRecord = 0 ;
      rfM92( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid_refresh */
   }

   public void send_integrity_hashes( )
   {
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
      if ( cmbavDtipoconcod.getItemCount() > 0 )
      {
         AV15DTipoConCod = cmbavDtipoconcod.getValidValue(AV15DTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15DTipoConCod", AV15DTipoConCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbavDtipoconcod.setValue( GXutil.rtrim( AV15DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDtipoconcod.getInternalname(), "Values", cmbavDtipoconcod.ToJavascriptSource(), true);
      }
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfM92( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV52Pgmname = "verLiqRetro2" ;
      Gx_err = (short)(0) ;
      edtavLiqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnombre_Enabled), 5, 0), true);
   }

   public void rfM92( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         GridContainer.ClearRows();
      }
      wbStart = (short)(13) ;
      /* Execute user event: Refresh */
      e13M92 ();
      nGXsfl_13_idx = 1 ;
      sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_132( ) ;
      bGXsfl_13_Refreshing = true ;
      GridContainer.AddObjectProperty("GridName", "Grid");
      GridContainer.AddObjectProperty("CmpContext", "");
      GridContainer.AddObjectProperty("InMasterPage", "false");
      GridContainer.AddObjectProperty("Class", "WorkWith");
      GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
      GridContainer.setPageSize( subgrid_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_132( ) ;
         GXPagingFrom2 = (int)(((subGrid_Rows==0) ? 0 : GRID_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid_Rows==0) ? 10000 : subgrid_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A464DTipoConCod ,
                                              AV45Verliqretro2ds_5_tfdtipoconcod_sels ,
                                              A394DConCodigo ,
                                              AV47Verliqretro2ds_7_tfdconcodigo_sels ,
                                              A393DConDescrip ,
                                              AV49Verliqretro2ds_9_tfdcondescrip_sels ,
                                              Integer.valueOf(AV45Verliqretro2ds_5_tfdtipoconcod_sels.size()) ,
                                              Integer.valueOf(AV47Verliqretro2ds_7_tfdconcodigo_sels.size()) ,
                                              AV46Verliqretro2ds_6_tfdconcodigo ,
                                              Integer.valueOf(AV49Verliqretro2ds_9_tfdcondescrip_sels.size()) ,
                                              AV48Verliqretro2ds_8_tfdcondescrip ,
                                              AV50Verliqretro2ds_10_tfliqdimprecalcu ,
                                              AV51Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                              A764LiqDImpReCalcu ,
                                              Short.valueOf(AV13OrderedBy) ,
                                              Boolean.valueOf(AV14OrderedDsc) ,
                                              Integer.valueOf(AV41Verliqretro2ds_1_clicod) ,
                                              Short.valueOf(AV42Verliqretro2ds_2_empcod) ,
                                              Integer.valueOf(AV43Verliqretro2ds_3_liqnro) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                              TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                              }
         });
         lV46Verliqretro2ds_6_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV46Verliqretro2ds_6_tfdconcodigo), 10, "%") ;
         lV48Verliqretro2ds_8_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV48Verliqretro2ds_8_tfdcondescrip), "%", "") ;
         /* Using cursor H00M92 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV41Verliqretro2ds_1_clicod), Short.valueOf(AV42Verliqretro2ds_2_empcod), Integer.valueOf(AV43Verliqretro2ds_3_liqnro), lV46Verliqretro2ds_6_tfdconcodigo, lV48Verliqretro2ds_8_tfdcondescrip, AV50Verliqretro2ds_10_tfliqdimprecalcu, AV51Verliqretro2ds_11_tfliqdimprecalcu_to, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_13_idx = 1 ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid_Rows == 0 ) || ( GRID_nCurrentRecord < subgrid_fnc_recordsperpage( ) ) ) ) )
         {
            A1134LiqDOrdVis = H00M92_A1134LiqDOrdVis[0] ;
            A502LiqDMostrar = H00M92_A502LiqDMostrar[0] ;
            A1070LiqDLog = H00M92_A1070LiqDLog[0] ;
            A764LiqDImpReCalcu = H00M92_A764LiqDImpReCalcu[0] ;
            A393DConDescrip = H00M92_A393DConDescrip[0] ;
            A394DConCodigo = H00M92_A394DConCodigo[0] ;
            A464DTipoConCod = H00M92_A464DTipoConCod[0] ;
            A81LiqDSecuencial = H00M92_A81LiqDSecuencial[0] ;
            A6LegNumero = H00M92_A6LegNumero[0] ;
            A31LiqNro = H00M92_A31LiqNro[0] ;
            A1EmpCod = H00M92_A1EmpCod[0] ;
            A3CliCod = H00M92_A3CliCod[0] ;
            e14M92 ();
            pr_default.readNext(0);
         }
         GRID_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_nEOF", GXutil.ltrim( localUtil.ntoc( GRID_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(13) ;
         wbM90( ) ;
      }
      bGXsfl_13_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesM92( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV35CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV36EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLIQNRO", GXutil.ltrim( localUtil.ntoc( AV37LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37LiqNro), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV52Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPGMNAME", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV52Pgmname, ""))));
   }

   public int subgrid_fnc_pagecount( )
   {
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID_nRecordCount/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid_fnc_recordcount( )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A464DTipoConCod ,
                                           AV45Verliqretro2ds_5_tfdtipoconcod_sels ,
                                           A394DConCodigo ,
                                           AV47Verliqretro2ds_7_tfdconcodigo_sels ,
                                           A393DConDescrip ,
                                           AV49Verliqretro2ds_9_tfdcondescrip_sels ,
                                           Integer.valueOf(AV45Verliqretro2ds_5_tfdtipoconcod_sels.size()) ,
                                           Integer.valueOf(AV47Verliqretro2ds_7_tfdconcodigo_sels.size()) ,
                                           AV46Verliqretro2ds_6_tfdconcodigo ,
                                           Integer.valueOf(AV49Verliqretro2ds_9_tfdcondescrip_sels.size()) ,
                                           AV48Verliqretro2ds_8_tfdcondescrip ,
                                           AV50Verliqretro2ds_10_tfliqdimprecalcu ,
                                           AV51Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                           A764LiqDImpReCalcu ,
                                           Short.valueOf(AV13OrderedBy) ,
                                           Boolean.valueOf(AV14OrderedDsc) ,
                                           Integer.valueOf(AV41Verliqretro2ds_1_clicod) ,
                                           Short.valueOf(AV42Verliqretro2ds_2_empcod) ,
                                           Integer.valueOf(AV43Verliqretro2ds_3_liqnro) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.DECIMAL,
                                           TypeConstants.DECIMAL, TypeConstants.SHORT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      lV46Verliqretro2ds_6_tfdconcodigo = GXutil.padr( GXutil.rtrim( AV46Verliqretro2ds_6_tfdconcodigo), 10, "%") ;
      lV48Verliqretro2ds_8_tfdcondescrip = GXutil.concat( GXutil.rtrim( AV48Verliqretro2ds_8_tfdcondescrip), "%", "") ;
      /* Using cursor H00M93 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41Verliqretro2ds_1_clicod), Short.valueOf(AV42Verliqretro2ds_2_empcod), Integer.valueOf(AV43Verliqretro2ds_3_liqnro), lV46Verliqretro2ds_6_tfdconcodigo, lV48Verliqretro2ds_8_tfdcondescrip, AV50Verliqretro2ds_10_tfliqdimprecalcu, AV51Verliqretro2ds_11_tfliqdimprecalcu_to});
      GRID_nRecordCount = H00M93_AGRID_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID_nRecordCount) ;
   }

   public int subgrid_fnc_recordsperpage( )
   {
      if ( subGrid_Rows > 0 )
      {
         return subGrid_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID_nFirstRecordOnPage/ (double) (subgrid_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid_firstpage( )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      GRID_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_nextpage( )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( ( GRID_nRecordCount >= subgrid_fnc_recordsperpage( ) ) && ( GRID_nEOF == 0 ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage+subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      GridContainer.AddObjectProperty("GRID_nFirstRecordOnPage", GRID_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid_previouspage( )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      if ( GRID_nFirstRecordOnPage >= subgrid_fnc_recordsperpage( ) )
      {
         GRID_nFirstRecordOnPage = (long)(GRID_nFirstRecordOnPage-subgrid_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid_lastpage( )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      GRID_nRecordCount = subgrid_fnc_recordcount( ) ;
      if ( GRID_nRecordCount > subgrid_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( )))) == 0 )
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-subgrid_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID_nFirstRecordOnPage = (long)(GRID_nRecordCount-((int)((GRID_nRecordCount) % (subgrid_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid_gotopage( int nPageNo )
   {
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      if ( nPageNo > 0 )
      {
         GRID_nFirstRecordOnPage = (long)(subgrid_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid_refresh( subGrid_Rows, AV35CliCod, AV36EmpCod, AV37LiqNro, AV15DTipoConCod, AV18TFDTipoConCod_Sels, AV20TFDConCodigo, AV21TFDConCodigo_Sels, AV23TFDConDescrip, AV24TFDConDescrip_Sels, AV25TFLiqDImpReCalcu, AV26TFLiqDImpReCalcu_To, AV52Pgmname, AV13OrderedBy, AV14OrderedDsc, AV41Verliqretro2ds_1_clicod, AV42Verliqretro2ds_2_empcod, AV43Verliqretro2ds_3_liqnro) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      AV52Pgmname = "verLiqRetro2" ;
      Gx_err = (short)(0) ;
      edtavLiqnombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavLiqnombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavLiqnombre_Enabled), 5, 0), true);
      fix_multi_value_controls( ) ;
   }

   public void strupM90( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e12M92 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV30DDO_TitleSettingsIcons);
         /* Read saved values. */
         nRC_GXsfl_13 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_13"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         GRID_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_grid_Caption = httpContext.cgiGet( "DDO_GRID_Caption") ;
         Ddo_grid_Filteredtext_set = httpContext.cgiGet( "DDO_GRID_Filteredtext_set") ;
         Ddo_grid_Filteredtextto_set = httpContext.cgiGet( "DDO_GRID_Filteredtextto_set") ;
         Ddo_grid_Selectedvalue_set = httpContext.cgiGet( "DDO_GRID_Selectedvalue_set") ;
         Ddo_grid_Gridinternalname = httpContext.cgiGet( "DDO_GRID_Gridinternalname") ;
         Ddo_grid_Columnids = httpContext.cgiGet( "DDO_GRID_Columnids") ;
         Ddo_grid_Columnssortvalues = httpContext.cgiGet( "DDO_GRID_Columnssortvalues") ;
         Ddo_grid_Includesortasc = httpContext.cgiGet( "DDO_GRID_Includesortasc") ;
         Ddo_grid_Sortedstatus = httpContext.cgiGet( "DDO_GRID_Sortedstatus") ;
         Ddo_grid_Includefilter = httpContext.cgiGet( "DDO_GRID_Includefilter") ;
         Ddo_grid_Filtertype = httpContext.cgiGet( "DDO_GRID_Filtertype") ;
         Ddo_grid_Filterisrange = httpContext.cgiGet( "DDO_GRID_Filterisrange") ;
         Ddo_grid_Includedatalist = httpContext.cgiGet( "DDO_GRID_Includedatalist") ;
         Ddo_grid_Datalisttype = httpContext.cgiGet( "DDO_GRID_Datalisttype") ;
         Ddo_grid_Allowmultipleselection = httpContext.cgiGet( "DDO_GRID_Allowmultipleselection") ;
         Ddo_grid_Datalistfixedvalues = httpContext.cgiGet( "DDO_GRID_Datalistfixedvalues") ;
         Ddo_grid_Datalistproc = httpContext.cgiGet( "DDO_GRID_Datalistproc") ;
         Ddo_grid_Format = httpContext.cgiGet( "DDO_GRID_Format") ;
         Grid_empowerer_Gridinternalname = httpContext.cgiGet( "GRID_EMPOWERER_Gridinternalname") ;
         Grid_empowerer_Hastitlesettings = GXutil.strtobool( httpContext.cgiGet( "GRID_EMPOWERER_Hastitlesettings")) ;
         subGrid_Rows = (int)(localUtil.ctol( httpContext.cgiGet( "GRID_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
         Ddo_grid_Activeeventkey = httpContext.cgiGet( "DDO_GRID_Activeeventkey") ;
         Ddo_grid_Selectedvalue_get = httpContext.cgiGet( "DDO_GRID_Selectedvalue_get") ;
         Ddo_grid_Selectedcolumn = httpContext.cgiGet( "DDO_GRID_Selectedcolumn") ;
         Ddo_grid_Filteredtext_get = httpContext.cgiGet( "DDO_GRID_Filteredtext_get") ;
         Ddo_grid_Filteredtextto_get = httpContext.cgiGet( "DDO_GRID_Filteredtextto_get") ;
         /* Read variables values. */
         AV38LiqNombre = httpContext.cgiGet( edtavLiqnombre_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38LiqNombre", AV38LiqNombre);
         cmbavDtipoconcod.setName( cmbavDtipoconcod.getInternalname() );
         cmbavDtipoconcod.setValue( httpContext.cgiGet( cmbavDtipoconcod.getInternalname()) );
         AV15DTipoConCod = httpContext.cgiGet( cmbavDtipoconcod.getInternalname()) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15DTipoConCod", AV15DTipoConCod);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
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
      e12M92 ();
      if (returnInSub) return;
   }

   public void e12M92( )
   {
      /* Start Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if (returnInSub) return;
      subGrid_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      Grid_empowerer_Gridinternalname = subGrid_Internalname ;
      ucGrid_empowerer.sendProperty(context, "", false, Grid_empowerer_Internalname, "GridInternalName", Grid_empowerer_Gridinternalname);
      Ddo_grid_Gridinternalname = subGrid_Internalname ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "GridInternalName", Ddo_grid_Gridinternalname);
      Form.setCaption( httpContext.getMessage( " Liquidacion Detalle", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      /* Execute user subroutine: 'PREPARETRANSACTION' */
      S122 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'LOADGRIDSTATE' */
      S132 ();
      if (returnInSub) return;
      if ( AV13OrderedBy < 1 )
      {
         AV13OrderedBy = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
      }
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = AV30DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[0] ;
      AV30DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1;
   }

   public void e13M92( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXv_SdtWWPContext3[0] = AV6WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV6WWPContext = GXv_SdtWWPContext3[0] ;
      /* Execute user subroutine: 'SAVEGRIDSTATE' */
      S152 ();
      if (returnInSub) return;
      GXv_char4[0] = AV38LiqNombre ;
      new web.getliqnombre(remoteHandle, context).execute( AV35CliCod, AV36EmpCod, AV37LiqNro, GXv_char4) ;
      verliqretro2_impl.this.AV38LiqNombre = GXv_char4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38LiqNombre", AV38LiqNombre);
      AV41Verliqretro2ds_1_clicod = AV35CliCod ;
      AV42Verliqretro2ds_2_empcod = AV36EmpCod ;
      AV43Verliqretro2ds_3_liqnro = AV37LiqNro ;
      AV44Verliqretro2ds_4_dtipoconcod = AV15DTipoConCod ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = AV18TFDTipoConCod_Sels ;
      AV46Verliqretro2ds_6_tfdconcodigo = AV20TFDConCodigo ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = AV21TFDConCodigo_Sels ;
      AV48Verliqretro2ds_8_tfdcondescrip = AV23TFDConDescrip ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = AV24TFDConDescrip_Sels ;
      AV50Verliqretro2ds_10_tfliqdimprecalcu = AV25TFLiqDImpReCalcu ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = AV26TFLiqDImpReCalcu_To ;
      /*  Sending Event outputs  */
   }

   public void e11M92( )
   {
      /* Ddo_grid_Onoptionclicked Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderASC#>") == 0 ) || ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>") == 0 ) )
      {
         AV13OrderedBy = (short)(GXutil.lval( Ddo_grid_Selectedvalue_get)) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
         AV14OrderedDsc = ((GXutil.strcmp(Ddo_grid_Activeeventkey, "<#OrderDSC#>")==0) ? true : false) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
         /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
         S142 ();
         if (returnInSub) return;
         subgrid_firstpage( ) ;
      }
      else if ( GXutil.strcmp(Ddo_grid_Activeeventkey, "<#Filter#>") == 0 )
      {
         if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DTipoConCod") == 0 )
         {
            AV17TFDTipoConCod_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17TFDTipoConCod_SelsJson", AV17TFDTipoConCod_SelsJson);
            AV18TFDTipoConCod_Sels.fromJSonString(AV17TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConCodigo") == 0 )
         {
            AV20TFDConCodigo = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20TFDConCodigo", AV20TFDConCodigo);
            AV19TFDConCodigo_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19TFDConCodigo_SelsJson", AV19TFDConCodigo_SelsJson);
            AV21TFDConCodigo_Sels.fromJSonString(AV19TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "DConDescrip") == 0 )
         {
            AV23TFDConDescrip = Ddo_grid_Filteredtext_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFDConDescrip", AV23TFDConDescrip);
            AV22TFDConDescrip_SelsJson = Ddo_grid_Selectedvalue_get ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFDConDescrip_SelsJson", AV22TFDConDescrip_SelsJson);
            AV24TFDConDescrip_Sels.fromJSonString(AV22TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(Ddo_grid_Selectedcolumn, "LiqDImpReCalcu") == 0 )
         {
            AV25TFLiqDImpReCalcu = CommonUtil.decimalVal( Ddo_grid_Filteredtext_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFLiqDImpReCalcu", GXutil.ltrimstr( AV25TFLiqDImpReCalcu, 14, 2));
            AV26TFLiqDImpReCalcu_To = CommonUtil.decimalVal( Ddo_grid_Filteredtextto_get, ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV26TFLiqDImpReCalcu_To, 14, 2));
         }
         subgrid_firstpage( ) ;
      }
      /*  Sending Event outputs  */
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV18TFDTipoConCod_Sels", AV18TFDTipoConCod_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV21TFDConCodigo_Sels", AV21TFDConCodigo_Sels);
      httpContext.ajax_rsp_assign_sdt_attri("", false, "AV24TFDConDescrip_Sels", AV24TFDConDescrip_Sels);
   }

   private void e14M92( )
   {
      /* Grid_Load Routine */
      returnInSub = false ;
      edtLiqDImpReCalcu_Tooltiptext = GXutil.trim( A1070LiqDLog) ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(13) ;
      }
      sendrow_132( ) ;
      GRID_nCurrentRecord = (long)(GRID_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_13_Refreshing )
      {
         httpContext.doAjaxLoad(13, GridRow);
      }
      /*  Sending Event outputs  */
   }

   public void S142( )
   {
      /* 'SETDDOSORTEDSTATUS' Routine */
      returnInSub = false ;
      Ddo_grid_Sortedstatus = GXutil.trim( GXutil.str( AV13OrderedBy, 4, 0))+":"+(AV14OrderedDsc ? "DSC" : "ASC") ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SortedStatus", Ddo_grid_Sortedstatus);
   }

   public void S132( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV16Session.getValue(AV52Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV52Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV16Session.getValue(AV52Pgmname+"GridState"), null, null);
      }
      AV13OrderedBy = AV11GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13OrderedBy", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13OrderedBy), 4, 0));
      AV14OrderedDsc = AV11GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14OrderedDsc", AV14OrderedDsc);
      /* Execute user subroutine: 'SETDDOSORTEDSTATUS' */
      S142 ();
      if (returnInSub) return;
      AV53GXV1 = 1 ;
      while ( AV53GXV1 <= AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV53GXV1));
         if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "DTIPOCONCOD") == 0 )
         {
            AV15DTipoConCod = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15DTipoConCod", AV15DTipoConCod);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDTIPOCONCOD_SEL") == 0 )
         {
            AV17TFDTipoConCod_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17TFDTipoConCod_SelsJson", AV17TFDTipoConCod_SelsJson);
            AV18TFDTipoConCod_Sels.fromJSonString(AV17TFDTipoConCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO") == 0 )
         {
            AV20TFDConCodigo = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20TFDConCodigo", AV20TFDConCodigo);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONCODIGO_SEL") == 0 )
         {
            AV19TFDConCodigo_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19TFDConCodigo_SelsJson", AV19TFDConCodigo_SelsJson);
            AV21TFDConCodigo_Sels.fromJSonString(AV19TFDConCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP") == 0 )
         {
            AV23TFDConDescrip = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23TFDConDescrip", AV23TFDConDescrip);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFDCONDESCRIP_SEL") == 0 )
         {
            AV22TFDConDescrip_SelsJson = AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            httpContext.ajax_rsp_assign_attri("", false, "AV22TFDConDescrip_SelsJson", AV22TFDConDescrip_SelsJson);
            AV24TFDConDescrip_Sels.fromJSonString(AV22TFDConDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFLIQDIMPRECALCU") == 0 )
         {
            AV25TFLiqDImpReCalcu = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25TFLiqDImpReCalcu", GXutil.ltrimstr( AV25TFLiqDImpReCalcu, 14, 2));
            AV26TFLiqDImpReCalcu_To = CommonUtil.decimalVal( AV12GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto(), ".") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV26TFLiqDImpReCalcu_To", GXutil.ltrimstr( AV26TFLiqDImpReCalcu_To, 14, 2));
         }
         AV53GXV1 = (int)(AV53GXV1+1) ;
      }
      GXt_char5 = "" ;
      GXv_char4[0] = GXt_char5 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV18TFDTipoConCod_Sels.size()==0), AV17TFDTipoConCod_SelsJson, GXv_char4) ;
      verliqretro2_impl.this.GXt_char5 = GXv_char4[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV21TFDConCodigo_Sels.size()==0), AV19TFDConCodigo_SelsJson, GXv_char7) ;
      verliqretro2_impl.this.GXt_char6 = GXv_char7[0] ;
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (AV24TFDConDescrip_Sels.size()==0), AV22TFDConDescrip_SelsJson, GXv_char9) ;
      verliqretro2_impl.this.GXt_char8 = GXv_char9[0] ;
      Ddo_grid_Selectedvalue_set = GXt_char5+"|"+GXt_char6+"|"+GXt_char8+"|" ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "SelectedValue_set", Ddo_grid_Selectedvalue_set);
      GXt_char8 = "" ;
      GXv_char9[0] = GXt_char8 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV20TFDConCodigo)==0), AV20TFDConCodigo, GXv_char9) ;
      verliqretro2_impl.this.GXt_char8 = GXv_char9[0] ;
      GXt_char6 = "" ;
      GXv_char7[0] = GXt_char6 ;
      new web.wwpbaseobjects.wwp_getfilterval(remoteHandle, context).execute( (GXutil.strcmp("", AV23TFDConDescrip)==0), AV23TFDConDescrip, GXv_char7) ;
      verliqretro2_impl.this.GXt_char6 = GXv_char7[0] ;
      Ddo_grid_Filteredtext_set = "|"+GXt_char8+"|"+GXt_char6+"|"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLiqDImpReCalcu)==0) ? "" : GXutil.str( AV25TFLiqDImpReCalcu, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredText_set", Ddo_grid_Filteredtext_set);
      Ddo_grid_Filteredtextto_set = "|||"+((DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLiqDImpReCalcu_To)==0) ? "" : GXutil.str( AV26TFLiqDImpReCalcu_To, 14, 2)) ;
      ucDdo_grid.sendProperty(context, "", false, Ddo_grid_Internalname, "FilteredTextTo_set", Ddo_grid_Filteredtextto_set);
      if ( ! (GXutil.strcmp("", GXutil.trim( AV11GridState.getgxTv_SdtWWPGridState_Pagesize()))==0) )
      {
         subGrid_Rows = (int)(GXutil.lval( AV11GridState.getgxTv_SdtWWPGridState_Pagesize())) ;
         web.GxWebStd.gx_hidden_field( httpContext, "GRID_Rows", GXutil.ltrim( localUtil.ntoc( subGrid_Rows, (byte)(6), (byte)(0), ".", "")));
      }
      subgrid_gotopage( AV11GridState.getgxTv_SdtWWPGridState_Currentpage()) ;
   }

   public void S152( )
   {
      /* 'SAVEGRIDSTATE' Routine */
      returnInSub = false ;
      AV11GridState.fromxml(AV16Session.getValue(AV52Pgmname+"GridState"), null, null);
      AV11GridState.setgxTv_SdtWWPGridState_Orderedby( AV13OrderedBy );
      AV11GridState.setgxTv_SdtWWPGridState_Ordereddsc( AV14OrderedDsc );
      AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().clear();
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "DTIPOCONCOD", "", !(GXutil.strcmp("", AV15DTipoConCod)==0), (short)(0), AV15DTipoConCod, "") ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFDTIPOCONCOD_SEL", "", !(AV18TFDTipoConCod_Sels.size()==0), (short)(0), AV18TFDTipoConCod_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFDCONCODIGO", "", !(GXutil.strcmp("", AV20TFDConCodigo)==0), (short)(0), AV20TFDConCodigo, "", !(AV21TFDConCodigo_Sels.size()==0), AV21TFDConCodigo_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalueandsel(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFDCONDESCRIP", "", !(GXutil.strcmp("", AV23TFDConDescrip)==0), (short)(0), AV23TFDConDescrip, "", !(AV24TFDConDescrip_Sels.size()==0), AV24TFDConDescrip_Sels.toJSonString(false), "") ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      GXv_SdtWWPGridState10[0] = AV11GridState;
      new web.wwpbaseobjects.wwp_gridstateaddfiltervalue(remoteHandle, context).execute( GXv_SdtWWPGridState10, "TFLIQDIMPRECALCU", "", !((DecimalUtil.compareTo(DecimalUtil.ZERO, AV25TFLiqDImpReCalcu)==0)&&(DecimalUtil.compareTo(DecimalUtil.ZERO, AV26TFLiqDImpReCalcu_To)==0)), (short)(0), GXutil.trim( GXutil.str( AV25TFLiqDImpReCalcu, 14, 2)), GXutil.trim( GXutil.str( AV26TFLiqDImpReCalcu_To, 14, 2))) ;
      AV11GridState = GXv_SdtWWPGridState10[0] ;
      if ( ! (0==AV35CliCod) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&CLICOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV35CliCod, 6, 0) );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      if ( ! (0==AV36EmpCod) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&EMPCOD" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV36EmpCod, 4, 0) );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      if ( ! (0==AV37LiqNro) )
      {
         AV12GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Name( "PARM_&LIQNRO" );
         AV12GridStateFilterValue.setgxTv_SdtWWPGridState_FilterValue_Value( GXutil.str( AV37LiqNro, 8, 0) );
         AV11GridState.getgxTv_SdtWWPGridState_Filtervalues().add(AV12GridStateFilterValue, 0);
      }
      AV11GridState.setgxTv_SdtWWPGridState_Pagesize( GXutil.str( subGrid_Rows, 10, 0) );
      AV11GridState.setgxTv_SdtWWPGridState_Currentpage( (short)(subgrid_fnc_currentpage( )) );
      new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV52Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
   }

   public void S122( )
   {
      /* 'PREPARETRANSACTION' Routine */
      returnInSub = false ;
      AV9TrnContext = (web.wwpbaseobjects.SdtWWPTransactionContext)new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerobject( AV52Pgmname );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerondelete( true );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Callerurl( AV8HTTPRequest.getScriptName()+"?"+AV8HTTPRequest.getQuerystring() );
      AV9TrnContext.setgxTv_SdtWWPTransactionContext_Transactionname( "LiquidacionDetalle" );
      AV10TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "CliCod" );
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV35CliCod, 6, 0) );
      AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV10TrnContextAtt, 0);
      AV10TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "EmpCod" );
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV36EmpCod, 4, 0) );
      AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV10TrnContextAtt, 0);
      AV10TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributename( "LiqNro" );
      AV10TrnContextAtt.setgxTv_SdtWWPTransactionContext_Attribute_Attributevalue( GXutil.str( AV37LiqNro, 8, 0) );
      AV9TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().add(AV10TrnContextAtt, 0);
      AV16Session.setValue("TrnContext", AV9TrnContext.toxml(false, true, "WWPTransactionContext", "PayDay"));
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV16Session.getValue(AV52Pgmname+"GridState"), "") == 0 )
      {
         AV11GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( AV52Pgmname+"GridState"), null, null);
      }
      else
      {
         AV11GridState.fromxml(AV16Session.getValue(AV52Pgmname+"GridState"), null, null);
      }
      if ( ! ( false ) )
      {
         cmbavDtipoconcod.setVisible( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbavDtipoconcod.getInternalname(), "Visible", GXutil.ltrimstr( cmbavDtipoconcod.getVisible(), 5, 0), true);
         GXv_SdtWWPGridState10[0] = AV11GridState;
         if ( new web.wwpbaseobjects.wwp_deletefilter(remoteHandle, context).executeUdp( GXv_SdtWWPGridState10, "DTIPOCONCOD", false) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         AV11GridState = GXv_SdtWWPGridState10[0] ;
         if ( Cond_result )
         {
            new web.wwpbaseobjects.savegridstate(remoteHandle, context).execute( AV52Pgmname+"GridState", AV11GridState.toxml(false, true, "WWPGridState", "PayDay")) ;
         }
      }
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV35CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV35CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV35CliCod), "ZZZZZ9")));
      AV36EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV36EmpCod), 4, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV36EmpCod), "ZZZ9")));
      AV37LiqNro = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV37LiqNro", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV37LiqNro), 8, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vLIQNRO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV37LiqNro), "ZZZZZZZ9")));
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
      paM92( ) ;
      wsM92( ) ;
      weM92( ) ;
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
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181784494", true, true);
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
      httpContext.AddJavascriptSource("verliqretro2.js", "?2025181784495", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_132( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_13_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_13_idx ;
      edtLiqNro_Internalname = "LIQNRO_"+sGXsfl_13_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_13_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_13_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_13_idx );
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_13_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_13_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_13_idx ;
      edtLiqDLog_Internalname = "LIQDLOG_"+sGXsfl_13_idx ;
   }

   public void subsflControlProps_fel_132( )
   {
      edtCliCod_Internalname = "CLICOD_"+sGXsfl_13_fel_idx ;
      edtEmpCod_Internalname = "EMPCOD_"+sGXsfl_13_fel_idx ;
      edtLiqNro_Internalname = "LIQNRO_"+sGXsfl_13_fel_idx ;
      edtLegNumero_Internalname = "LEGNUMERO_"+sGXsfl_13_fel_idx ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL_"+sGXsfl_13_fel_idx ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD_"+sGXsfl_13_fel_idx );
      edtDConCodigo_Internalname = "DCONCODIGO_"+sGXsfl_13_fel_idx ;
      edtDConDescrip_Internalname = "DCONDESCRIP_"+sGXsfl_13_fel_idx ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU_"+sGXsfl_13_fel_idx ;
      edtLiqDLog_Internalname = "LIQDLOG_"+sGXsfl_13_fel_idx ;
   }

   public void sendrow_132( )
   {
      subsflControlProps_132( ) ;
      wbM90( ) ;
      if ( ( subGrid_Rows * 1 == 0 ) || ( nGXsfl_13_idx <= subgrid_fnc_recordsperpage( ) * 1 ) )
      {
         GridRow = GXWebRow.GetNew(context,GridContainer) ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid_Backstyle = (byte)(0) ;
            subGrid_Backcolor = subGrid_Allbackcolor ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Uniform" ;
            }
         }
         else if ( subGrid_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid_Class, "") != 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Odd" ;
            }
            subGrid_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_13_idx) % (2))) == 0 )
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Even" ;
               }
            }
            else
            {
               subGrid_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid_Class, "") != 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Odd" ;
               }
            }
         }
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_13_idx+"\">") ;
         }
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEmpCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEmpCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqNro_Internalname,GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A31LiqNro), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqNro_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLegNumero_Internalname,GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A6LegNumero), "ZZZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLegNumero_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoMedio","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDSecuencial_Internalname,GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A81LiqDSecuencial), "ZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDSecuencial_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(5),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         if ( ( cmbDTipoConCod.getItemCount() == 0 ) && isAjaxCallMode( ) )
         {
            GXCCtl = "DTIPOCONCOD_" + sGXsfl_13_idx ;
            cmbDTipoConCod.setName( GXCCtl );
            cmbDTipoConCod.setWebtags( "" );
            cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
            cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
            cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
            if ( cmbDTipoConCod.getItemCount() > 0 )
            {
               A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
            }
         }
         /* ComboBox */
         GridRow.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbDTipoConCod,cmbDTipoConCod.getInternalname(),GXutil.rtrim( A464DTipoConCod),Integer.valueOf(1),cmbDTipoConCod.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","WWColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
         cmbDTipoConCod.setValue( GXutil.rtrim( A464DTipoConCod) );
         httpContext.ajax_rsp_assign_prop("", false, cmbDTipoConCod.getInternalname(), "Values", cmbDTipoConCod.ToJavascriptSource(), !bGXsfl_13_Refreshing);
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConCodigo_Internalname,GXutil.rtrim( A394DConCodigo),"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtDConDescrip_Internalname,A393DConDescrip,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtDConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDImpReCalcu_Internalname,GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( A764LiqDImpReCalcu, "ZZ,ZZZ,ZZZ,ZZ9.99")),"","'"+""+"'"+",false,"+"'"+""+"'","","",edtLiqDImpReCalcu_Tooltiptext,"",edtLiqDImpReCalcu_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"ImportesSigned","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( GridContainer.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         GridRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtLiqDLog_Internalname,A1070LiqDLog,A1070LiqDLog,"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtLiqDLog_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn hidden-xs","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(2097152),Integer.valueOf(0),Integer.valueOf(1),Integer.valueOf(13),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(false),""});
         send_integrity_lvl_hashesM92( ) ;
         GridContainer.AddRow(GridRow);
         nGXsfl_13_idx = ((subGrid_Islastpage==1)&&(nGXsfl_13_idx+1>subgrid_fnc_recordsperpage( )) ? 1 : nGXsfl_13_idx+1) ;
         sGXsfl_13_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_13_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_132( ) ;
      }
      /* End function sendrow_132 */
   }

   public void startgridcontrol13( )
   {
      if ( GridContainer.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"GridContainer"+"DivS\" data-gxgridid=\"13\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid_Internalname, subGrid_Internalname, "", "WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid_Backcolorstyle == 0 )
         {
            subGrid_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid_Class) > 0 )
            {
               subGrid_Linesclass = subGrid_Class+"Title" ;
            }
         }
         else
         {
            subGrid_Titlebackstyle = (byte)(1) ;
            if ( subGrid_Backcolorstyle == 1 )
            {
               subGrid_Titlebackcolor = subGrid_Allbackcolor ;
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid_Class) > 0 )
               {
                  subGrid_Linesclass = subGrid_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Empresa", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Liquidacion", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Legajo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "DSecuencial", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Tipo", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Importe", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Log", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         GridContainer.AddObjectProperty("GridName", "Grid");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            GridContainer = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            GridContainer.Clear();
         }
         GridContainer.SetWrapped(nGXWrapped);
         GridContainer.AddObjectProperty("GridName", "Grid");
         GridContainer.AddObjectProperty("Header", subGrid_Header);
         GridContainer.AddObjectProperty("Class", "WorkWith");
         GridContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Sortable", GXutil.ltrim( localUtil.ntoc( subGrid_Sortable, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("CmpContext", "");
         GridContainer.AddObjectProperty("InMasterPage", "false");
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A31LiqNro, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A81LiqDSecuencial, (byte)(5), (byte)(0), ".", "")));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A464DTipoConCod));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.rtrim( A394DConCodigo));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A393DConDescrip);
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A764LiqDImpReCalcu, (byte)(17), (byte)(2), ".", "")));
         GridColumn.AddObjectProperty("Tooltiptext", GXutil.rtrim( edtLiqDImpReCalcu_Tooltiptext));
         GridContainer.AddColumnProperties(GridColumn);
         GridColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         GridColumn.AddObjectProperty("Value", A1070LiqDLog);
         GridContainer.AddColumnProperties(GridColumn);
         GridContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid_Allowselection, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         GridContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtavLiqnombre_Internalname = "vLIQNOMBRE" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtLiqNro_Internalname = "LIQNRO" ;
      edtLegNumero_Internalname = "LEGNUMERO" ;
      edtLiqDSecuencial_Internalname = "LIQDSECUENCIAL" ;
      cmbDTipoConCod.setInternalname( "DTIPOCONCOD" );
      edtDConCodigo_Internalname = "DCONCODIGO" ;
      edtDConDescrip_Internalname = "DCONDESCRIP" ;
      edtLiqDImpReCalcu_Internalname = "LIQDIMPRECALCU" ;
      edtLiqDLog_Internalname = "LIQDLOG" ;
      cmbavDtipoconcod.setInternalname( "vDTIPOCONCOD" );
      divTablemain_Internalname = "TABLEMAIN" ;
      Ddo_grid_Internalname = "DDO_GRID" ;
      Grid_empowerer_Internalname = "GRID_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGrid_Internalname = "GRID" ;
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
      subGrid_Allowcollapsing = (byte)(0) ;
      subGrid_Allowselection = (byte)(0) ;
      subGrid_Header = "" ;
      edtLiqDLog_Jsonclick = "" ;
      edtLiqDImpReCalcu_Jsonclick = "" ;
      edtLiqDImpReCalcu_Tooltiptext = "" ;
      edtDConDescrip_Jsonclick = "" ;
      edtDConCodigo_Jsonclick = "" ;
      cmbDTipoConCod.setJsonclick( "" );
      edtLiqDSecuencial_Jsonclick = "" ;
      edtLegNumero_Jsonclick = "" ;
      edtLiqNro_Jsonclick = "" ;
      edtEmpCod_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid_Class = "WorkWith" ;
      subGrid_Backcolorstyle = (byte)(0) ;
      subGrid_Sortable = (byte)(0) ;
      cmbavDtipoconcod.setJsonclick( "" );
      cmbavDtipoconcod.setEnabled( 1 );
      cmbavDtipoconcod.setVisible( 1 );
      edtavLiqnombre_Enabled = 1 ;
      Grid_empowerer_Hastitlesettings = GXutil.toBoolean( -1) ;
      Ddo_grid_Format = "|||-14.2" ;
      Ddo_grid_Datalistproc = "verLiqRetro2GetFilterData" ;
      Ddo_grid_Datalistfixedvalues = "REM_ARG:Remunerativo,NRE_ARG:No Remunerativo,DES_ARG:Retención|||" ;
      Ddo_grid_Allowmultipleselection = "T|T|T|" ;
      Ddo_grid_Datalisttype = "FixedValues|Dynamic|Dynamic|" ;
      Ddo_grid_Includedatalist = "T|T|T|" ;
      Ddo_grid_Filterisrange = "|||T" ;
      Ddo_grid_Filtertype = "Character|Character|Character|Numeric" ;
      Ddo_grid_Includefilter = "T" ;
      Ddo_grid_Includesortasc = "T" ;
      Ddo_grid_Columnssortvalues = "2|3|4|5" ;
      Ddo_grid_Columnids = "5:DTipoConCod|6:DConCodigo|7:DConDescrip|8:LiqDImpReCalcu" ;
      Ddo_grid_Gridinternalname = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( " Liquidacion Detalle", "") );
      subGrid_Rows = 0 ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      GXCCtl = "DTIPOCONCOD_" + sGXsfl_13_idx ;
      cmbDTipoConCod.setName( GXCCtl );
      cmbDTipoConCod.setWebtags( "" );
      cmbDTipoConCod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbDTipoConCod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbDTipoConCod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbDTipoConCod.getItemCount() > 0 )
      {
         A464DTipoConCod = cmbDTipoConCod.getValidValue(A464DTipoConCod) ;
      }
      cmbavDtipoconcod.setName( "vDTIPOCONCOD" );
      cmbavDtipoconcod.setWebtags( "" );
      cmbavDtipoconcod.addItem("REM_ARG", httpContext.getMessage( "Remunerativo", ""), (short)(0));
      cmbavDtipoconcod.addItem("NRE_ARG", httpContext.getMessage( "No Remunerativo", ""), (short)(0));
      cmbavDtipoconcod.addItem("DES_ARG", httpContext.getMessage( "Retención", ""), (short)(0));
      cmbavDtipoconcod.addItem("CAL_ARG", httpContext.getMessage( "Cálculo", ""), (short)(0));
      if ( cmbavDtipoconcod.getItemCount() > 0 )
      {
         AV15DTipoConCod = cmbavDtipoconcod.getValidValue(AV15DTipoConCod) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15DTipoConCod", AV15DTipoConCod);
      }
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV38LiqNombre',fld:'vLIQNOMBRE',pic:''}]}");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED","{handler:'e11M92',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'Ddo_grid_Activeeventkey',ctrl:'DDO_GRID',prop:'ActiveEventKey'},{av:'Ddo_grid_Selectedvalue_get',ctrl:'DDO_GRID',prop:'SelectedValue_get'},{av:'Ddo_grid_Selectedcolumn',ctrl:'DDO_GRID',prop:'SelectedColumn'},{av:'Ddo_grid_Filteredtext_get',ctrl:'DDO_GRID',prop:'FilteredText_get'},{av:'Ddo_grid_Filteredtextto_get',ctrl:'DDO_GRID',prop:'FilteredTextTo_get'}]");
      setEventMetadata("DDO_GRID.ONOPTIONCLICKED",",oparms:[{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'AV17TFDTipoConCod_SelsJson',fld:'vTFDTIPOCONCOD_SELSJSON',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV19TFDConCodigo_SelsJson',fld:'vTFDCONCODIGO_SELSJSON',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV22TFDConDescrip_SelsJson',fld:'vTFDCONDESCRIP_SELSJSON',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'Ddo_grid_Sortedstatus',ctrl:'DDO_GRID',prop:'SortedStatus'}]}");
      setEventMetadata("GRID.LOAD","{handler:'e14M92',iparms:[{av:'A1070LiqDLog',fld:'LIQDLOG',pic:''}]");
      setEventMetadata("GRID.LOAD",",oparms:[{av:'edtLiqDImpReCalcu_Tooltiptext',ctrl:'LIQDIMPRECALCU',prop:'Tooltiptext'}]}");
      setEventMetadata("GRID_FIRSTPAGE","{handler:'subgrid_firstpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_FIRSTPAGE",",oparms:[{av:'AV38LiqNombre',fld:'vLIQNOMBRE',pic:''}]}");
      setEventMetadata("GRID_PREVPAGE","{handler:'subgrid_previouspage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_PREVPAGE",",oparms:[{av:'AV38LiqNombre',fld:'vLIQNOMBRE',pic:''}]}");
      setEventMetadata("GRID_NEXTPAGE","{handler:'subgrid_nextpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_NEXTPAGE",",oparms:[{av:'AV38LiqNombre',fld:'vLIQNOMBRE',pic:''}]}");
      setEventMetadata("GRID_LASTPAGE","{handler:'subgrid_lastpage',iparms:[{av:'GRID_nFirstRecordOnPage'},{av:'GRID_nEOF'},{av:'AV41Verliqretro2ds_1_clicod',fld:'vVERLIQRETRO2DS_1_CLICOD',pic:'ZZZZZ9'},{av:'AV42Verliqretro2ds_2_empcod',fld:'vVERLIQRETRO2DS_2_EMPCOD',pic:'ZZZ9'},{av:'AV43Verliqretro2ds_3_liqnro',fld:'vVERLIQRETRO2DS_3_LIQNRO',pic:'ZZZZZZZ9'},{av:'AV35CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV36EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV37LiqNro',fld:'vLIQNRO',pic:'ZZZZZZZ9',hsh:true},{av:'cmbavDtipoconcod'},{av:'AV15DTipoConCod',fld:'vDTIPOCONCOD',pic:''},{av:'AV18TFDTipoConCod_Sels',fld:'vTFDTIPOCONCOD_SELS',pic:''},{av:'AV20TFDConCodigo',fld:'vTFDCONCODIGO',pic:''},{av:'AV21TFDConCodigo_Sels',fld:'vTFDCONCODIGO_SELS',pic:''},{av:'AV23TFDConDescrip',fld:'vTFDCONDESCRIP',pic:''},{av:'AV24TFDConDescrip_Sels',fld:'vTFDCONDESCRIP_SELS',pic:''},{av:'AV25TFLiqDImpReCalcu',fld:'vTFLIQDIMPRECALCU',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV26TFLiqDImpReCalcu_To',fld:'vTFLIQDIMPRECALCU_TO',pic:'ZZ,ZZZ,ZZZ,ZZ9.99'},{av:'AV52Pgmname',fld:'vPGMNAME',pic:'',hsh:true},{av:'AV13OrderedBy',fld:'vORDEREDBY',pic:'ZZZ9'},{av:'AV14OrderedDsc',fld:'vORDEREDDSC',pic:''},{av:'subGrid_Rows',ctrl:'GRID',prop:'Rows'}]");
      setEventMetadata("GRID_LASTPAGE",",oparms:[{av:'AV38LiqNombre',fld:'vLIQNOMBRE',pic:''}]}");
      setEventMetadata("VALIDV_DTIPOCONCOD","{handler:'validv_Dtipoconcod',iparms:[]");
      setEventMetadata("VALIDV_DTIPOCONCOD",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Liqdlog',iparms:[]");
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
      Ddo_grid_Activeeventkey = "" ;
      Ddo_grid_Selectedvalue_get = "" ;
      Ddo_grid_Selectedcolumn = "" ;
      Ddo_grid_Filteredtext_get = "" ;
      Ddo_grid_Filteredtextto_get = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV15DTipoConCod = "" ;
      AV18TFDTipoConCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV20TFDConCodigo = "" ;
      AV21TFDConCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23TFDConDescrip = "" ;
      AV24TFDConDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25TFLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV26TFLiqDImpReCalcu_To = DecimalUtil.ZERO ;
      AV52Pgmname = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV30DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      Ddo_grid_Caption = "" ;
      Ddo_grid_Filteredtext_set = "" ;
      Ddo_grid_Filteredtextto_set = "" ;
      Ddo_grid_Selectedvalue_set = "" ;
      Ddo_grid_Sortedstatus = "" ;
      Grid_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      AV38LiqNombre = "" ;
      GridContainer = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucDdo_grid = new com.genexus.webpanels.GXUserControl();
      ucGrid_empowerer = new com.genexus.webpanels.GXUserControl();
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV44Verliqretro2ds_4_dtipoconcod = "" ;
      AV45Verliqretro2ds_5_tfdtipoconcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46Verliqretro2ds_6_tfdconcodigo = "" ;
      AV47Verliqretro2ds_7_tfdconcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV48Verliqretro2ds_8_tfdcondescrip = "" ;
      AV49Verliqretro2ds_9_tfdcondescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV50Verliqretro2ds_10_tfliqdimprecalcu = DecimalUtil.ZERO ;
      AV51Verliqretro2ds_11_tfliqdimprecalcu_to = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A1070LiqDLog = "" ;
      scmdbuf = "" ;
      lV46Verliqretro2ds_6_tfdconcodigo = "" ;
      lV48Verliqretro2ds_8_tfdcondescrip = "" ;
      H00M92_A1134LiqDOrdVis = new short[1] ;
      H00M92_A502LiqDMostrar = new byte[1] ;
      H00M92_A1070LiqDLog = new String[] {""} ;
      H00M92_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H00M92_A393DConDescrip = new String[] {""} ;
      H00M92_A394DConCodigo = new String[] {""} ;
      H00M92_A464DTipoConCod = new String[] {""} ;
      H00M92_A81LiqDSecuencial = new int[1] ;
      H00M92_A6LegNumero = new int[1] ;
      H00M92_A31LiqNro = new int[1] ;
      H00M92_A1EmpCod = new short[1] ;
      H00M92_A3CliCod = new int[1] ;
      H00M93_AGRID_nRecordCount = new long[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV6WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV17TFDTipoConCod_SelsJson = "" ;
      AV19TFDConCodigo_SelsJson = "" ;
      AV22TFDConDescrip_SelsJson = "" ;
      GridRow = new com.genexus.webpanels.GXWebRow();
      AV16Session = httpContext.getWebSession();
      AV11GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV12GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      GXt_char5 = "" ;
      GXv_char4 = new String[1] ;
      GXt_char8 = "" ;
      GXv_char9 = new String[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      AV9TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV8HTTPRequest = httpContext.getHttpRequest();
      AV10TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      GXv_SdtWWPGridState10 = new web.wwpbaseobjects.SdtWWPGridState[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      GridColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.verliqretro2__default(),
         new Object[] {
             new Object[] {
            H00M92_A1134LiqDOrdVis, H00M92_A502LiqDMostrar, H00M92_A1070LiqDLog, H00M92_A764LiqDImpReCalcu, H00M92_A393DConDescrip, H00M92_A394DConCodigo, H00M92_A464DTipoConCod, H00M92_A81LiqDSecuencial, H00M92_A6LegNumero, H00M92_A31LiqNro,
            H00M92_A1EmpCod, H00M92_A3CliCod
            }
            , new Object[] {
            H00M93_AGRID_nRecordCount
            }
         }
      );
      AV52Pgmname = "verLiqRetro2" ;
      /* GeneXus formulas. */
      AV52Pgmname = "verLiqRetro2" ;
      Gx_err = (short)(0) ;
      edtavLiqnombre_Enabled = 0 ;
   }

   private byte GRID_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid_Backcolorstyle ;
   private byte subGrid_Sortable ;
   private byte A502LiqDMostrar ;
   private byte nGXWrapped ;
   private byte subGrid_Backstyle ;
   private byte subGrid_Titlebackstyle ;
   private byte subGrid_Allowselection ;
   private byte subGrid_Allowhovering ;
   private byte subGrid_Allowcollapsing ;
   private byte subGrid_Collapsed ;
   private short wcpOAV36EmpCod ;
   private short AV36EmpCod ;
   private short AV13OrderedBy ;
   private short AV42Verliqretro2ds_2_empcod ;
   private short wbEnd ;
   private short wbStart ;
   private short A1EmpCod ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A1134LiqDOrdVis ;
   private int wcpOAV35CliCod ;
   private int wcpOAV37LiqNro ;
   private int subGrid_Rows ;
   private int nRC_GXsfl_13 ;
   private int AV35CliCod ;
   private int AV37LiqNro ;
   private int nGXsfl_13_idx=1 ;
   private int AV41Verliqretro2ds_1_clicod ;
   private int AV43Verliqretro2ds_3_liqnro ;
   private int edtavLiqnombre_Enabled ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private int subGrid_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int AV45Verliqretro2ds_5_tfdtipoconcod_sels_size ;
   private int AV47Verliqretro2ds_7_tfdconcodigo_sels_size ;
   private int AV49Verliqretro2ds_9_tfdcondescrip_sels_size ;
   private int AV53GXV1 ;
   private int idxLst ;
   private int subGrid_Backcolor ;
   private int subGrid_Allbackcolor ;
   private int subGrid_Titlebackcolor ;
   private int subGrid_Selectedindex ;
   private int subGrid_Selectioncolor ;
   private int subGrid_Hoveringcolor ;
   private long GRID_nFirstRecordOnPage ;
   private long GRID_nCurrentRecord ;
   private long GRID_nRecordCount ;
   private java.math.BigDecimal AV25TFLiqDImpReCalcu ;
   private java.math.BigDecimal AV26TFLiqDImpReCalcu_To ;
   private java.math.BigDecimal AV50Verliqretro2ds_10_tfliqdimprecalcu ;
   private java.math.BigDecimal AV51Verliqretro2ds_11_tfliqdimprecalcu_to ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String Ddo_grid_Activeeventkey ;
   private String Ddo_grid_Selectedvalue_get ;
   private String Ddo_grid_Selectedcolumn ;
   private String Ddo_grid_Filteredtext_get ;
   private String Ddo_grid_Filteredtextto_get ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_13_idx="0001" ;
   private String AV15DTipoConCod ;
   private String AV20TFDConCodigo ;
   private String AV52Pgmname ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Ddo_grid_Caption ;
   private String Ddo_grid_Filteredtext_set ;
   private String Ddo_grid_Filteredtextto_set ;
   private String Ddo_grid_Selectedvalue_set ;
   private String Ddo_grid_Gridinternalname ;
   private String Ddo_grid_Columnids ;
   private String Ddo_grid_Columnssortvalues ;
   private String Ddo_grid_Includesortasc ;
   private String Ddo_grid_Sortedstatus ;
   private String Ddo_grid_Includefilter ;
   private String Ddo_grid_Filtertype ;
   private String Ddo_grid_Filterisrange ;
   private String Ddo_grid_Includedatalist ;
   private String Ddo_grid_Datalisttype ;
   private String Ddo_grid_Allowmultipleselection ;
   private String Ddo_grid_Datalistfixedvalues ;
   private String Ddo_grid_Datalistproc ;
   private String Ddo_grid_Format ;
   private String Grid_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String edtavLiqnombre_Internalname ;
   private String TempTags ;
   private String ClassString ;
   private String StyleString ;
   private String sStyleString ;
   private String subGrid_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Ddo_grid_Internalname ;
   private String Grid_empowerer_Internalname ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV44Verliqretro2ds_4_dtipoconcod ;
   private String AV46Verliqretro2ds_6_tfdconcodigo ;
   private String edtCliCod_Internalname ;
   private String edtEmpCod_Internalname ;
   private String edtLiqNro_Internalname ;
   private String edtLegNumero_Internalname ;
   private String edtLiqDSecuencial_Internalname ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private String edtDConCodigo_Internalname ;
   private String edtDConDescrip_Internalname ;
   private String edtLiqDImpReCalcu_Internalname ;
   private String edtLiqDLog_Internalname ;
   private String scmdbuf ;
   private String lV46Verliqretro2ds_6_tfdconcodigo ;
   private String edtLiqDImpReCalcu_Tooltiptext ;
   private String GXt_char5 ;
   private String GXv_char4[] ;
   private String GXt_char8 ;
   private String GXv_char9[] ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String sGXsfl_13_fel_idx="0001" ;
   private String subGrid_Class ;
   private String subGrid_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Jsonclick ;
   private String edtLiqNro_Jsonclick ;
   private String edtLegNumero_Jsonclick ;
   private String edtLiqDSecuencial_Jsonclick ;
   private String GXCCtl ;
   private String edtDConCodigo_Jsonclick ;
   private String edtDConDescrip_Jsonclick ;
   private String edtLiqDImpReCalcu_Jsonclick ;
   private String edtLiqDLog_Jsonclick ;
   private String subGrid_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV14OrderedDsc ;
   private boolean Grid_empowerer_Hastitlesettings ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_13_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private boolean Cond_result ;
   private String A1070LiqDLog ;
   private String AV17TFDTipoConCod_SelsJson ;
   private String AV19TFDConCodigo_SelsJson ;
   private String AV22TFDConDescrip_SelsJson ;
   private String AV23TFDConDescrip ;
   private String AV38LiqNombre ;
   private String AV48Verliqretro2ds_8_tfdcondescrip ;
   private String A393DConDescrip ;
   private String lV48Verliqretro2ds_8_tfdcondescrip ;
   private com.genexus.webpanels.GXWebGrid GridContainer ;
   private com.genexus.webpanels.GXWebRow GridRow ;
   private com.genexus.webpanels.GXWebColumn GridColumn ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.internet.HttpRequest AV8HTTPRequest ;
   private com.genexus.webpanels.WebSession AV16Session ;
   private com.genexus.webpanels.GXUserControl ucDdo_grid ;
   private com.genexus.webpanels.GXUserControl ucGrid_empowerer ;
   private HTMLChoice cmbDTipoConCod ;
   private HTMLChoice cmbavDtipoconcod ;
   private IDataStoreProvider pr_default ;
   private short[] H00M92_A1134LiqDOrdVis ;
   private byte[] H00M92_A502LiqDMostrar ;
   private String[] H00M92_A1070LiqDLog ;
   private java.math.BigDecimal[] H00M92_A764LiqDImpReCalcu ;
   private String[] H00M92_A393DConDescrip ;
   private String[] H00M92_A394DConCodigo ;
   private String[] H00M92_A464DTipoConCod ;
   private int[] H00M92_A81LiqDSecuencial ;
   private int[] H00M92_A6LegNumero ;
   private int[] H00M92_A31LiqNro ;
   private short[] H00M92_A1EmpCod ;
   private int[] H00M92_A3CliCod ;
   private long[] H00M93_AGRID_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV18TFDTipoConCod_Sels ;
   private GXSimpleCollection<String> AV21TFDConCodigo_Sels ;
   private GXSimpleCollection<String> AV45Verliqretro2ds_5_tfdtipoconcod_sels ;
   private GXSimpleCollection<String> AV47Verliqretro2ds_7_tfdconcodigo_sels ;
   private GXSimpleCollection<String> AV24TFDConDescrip_Sels ;
   private GXSimpleCollection<String> AV49Verliqretro2ds_9_tfdcondescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV6WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV9TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV10TrnContextAtt ;
   private web.wwpbaseobjects.SdtWWPGridState AV11GridState ;
   private web.wwpbaseobjects.SdtWWPGridState GXv_SdtWWPGridState10[] ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV12GridStateFilterValue ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV30DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons1 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2[] ;
}

final  class verliqretro2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H00M92( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV45Verliqretro2ds_5_tfdtipoconcod_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV47Verliqretro2ds_7_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV49Verliqretro2ds_9_tfdcondescrip_sels ,
                                          int AV45Verliqretro2ds_5_tfdtipoconcod_sels_size ,
                                          int AV47Verliqretro2ds_7_tfdconcodigo_sels_size ,
                                          String AV46Verliqretro2ds_6_tfdconcodigo ,
                                          int AV49Verliqretro2ds_9_tfdcondescrip_sels_size ,
                                          String AV48Verliqretro2ds_8_tfdcondescrip ,
                                          java.math.BigDecimal AV50Verliqretro2ds_10_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV51Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV41Verliqretro2ds_1_clicod ,
                                          short AV42Verliqretro2ds_2_empcod ,
                                          int AV43Verliqretro2ds_3_liqnro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[10];
      Object[] GXv_Object12 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " LiqDOrdVis, LiqDMostrar, LiqDLog, LiqDImpReCalcu, DConDescrip, DConCodigo, DTipoConCod, LiqDSecuencial, LegNumero, LiqNro, EmpCod, CliCod" ;
      sFromString = " FROM LiquidacionDetalle" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "(DTipoConCod <> ( 'CAL_ARG'))");
      if ( AV45Verliqretro2ds_5_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Verliqretro2ds_5_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV47Verliqretro2ds_7_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Verliqretro2ds_6_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV47Verliqretro2ds_7_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Verliqretro2ds_7_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV49Verliqretro2ds_9_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Verliqretro2ds_8_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV49Verliqretro2ds_9_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Verliqretro2ds_9_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50Verliqretro2ds_10_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51Verliqretro2ds_11_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV13OrderedBy == 1 )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDMostrar DESC, LiqDOrdVis, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, DTipoConCod, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, DTipoConCod DESC, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, DConCodigo, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, DConCodigo DESC, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, DConDescrip, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, DConDescrip DESC, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, LiqDImpReCalcu, LegNumero, LiqDSecuencial" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         sOrderString += " ORDER BY CliCod DESC, EmpCod DESC, LiqNro DESC, LiqDImpReCalcu DESC, LegNumero, LiqDSecuencial" ;
      }
      else if ( true )
      {
         sOrderString += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, LiqDSecuencial" ;
      }
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_H00M93( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A464DTipoConCod ,
                                          GXSimpleCollection<String> AV45Verliqretro2ds_5_tfdtipoconcod_sels ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV47Verliqretro2ds_7_tfdconcodigo_sels ,
                                          String A393DConDescrip ,
                                          GXSimpleCollection<String> AV49Verliqretro2ds_9_tfdcondescrip_sels ,
                                          int AV45Verliqretro2ds_5_tfdtipoconcod_sels_size ,
                                          int AV47Verliqretro2ds_7_tfdconcodigo_sels_size ,
                                          String AV46Verliqretro2ds_6_tfdconcodigo ,
                                          int AV49Verliqretro2ds_9_tfdcondescrip_sels_size ,
                                          String AV48Verliqretro2ds_8_tfdcondescrip ,
                                          java.math.BigDecimal AV50Verliqretro2ds_10_tfliqdimprecalcu ,
                                          java.math.BigDecimal AV51Verliqretro2ds_11_tfliqdimprecalcu_to ,
                                          java.math.BigDecimal A764LiqDImpReCalcu ,
                                          short AV13OrderedBy ,
                                          boolean AV14OrderedDsc ,
                                          int AV41Verliqretro2ds_1_clicod ,
                                          short AV42Verliqretro2ds_2_empcod ,
                                          int AV43Verliqretro2ds_3_liqnro ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[7];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ?)");
      addWhere(sWhereString, "(DTipoConCod <> ( 'CAL_ARG'))");
      if ( AV45Verliqretro2ds_5_tfdtipoconcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV45Verliqretro2ds_5_tfdtipoconcod_sels, "DTipoConCod IN (", ")")+")");
      }
      if ( ( AV47Verliqretro2ds_7_tfdconcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV46Verliqretro2ds_6_tfdconcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV47Verliqretro2ds_7_tfdconcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV47Verliqretro2ds_7_tfdconcodigo_sels, "DConCodigo IN (", ")")+")");
      }
      if ( ( AV49Verliqretro2ds_9_tfdcondescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV48Verliqretro2ds_8_tfdcondescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(DConDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV49Verliqretro2ds_9_tfdcondescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV49Verliqretro2ds_9_tfdcondescrip_sels, "DConDescrip IN (", ")")+")");
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV50Verliqretro2ds_10_tfliqdimprecalcu)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu >= ?)");
      }
      else
      {
         GXv_int14[5] = (byte)(1) ;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV51Verliqretro2ds_11_tfliqdimprecalcu_to)==0) )
      {
         addWhere(sWhereString, "(LiqDImpReCalcu <= ?)");
      }
      else
      {
         GXv_int14[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( AV13OrderedBy == 1 )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 2 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 3 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 4 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ! AV14OrderedDsc )
      {
         scmdbuf += "" ;
      }
      else if ( ( AV13OrderedBy == 5 ) && ( AV14OrderedDsc ) )
      {
         scmdbuf += "" ;
      }
      else if ( true )
      {
         scmdbuf += "" ;
      }
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
                  return conditional_H00M92(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() );
            case 1 :
                  return conditional_H00M93(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , (java.math.BigDecimal)dynConstraints[11] , (java.math.BigDecimal)dynConstraints[12] , (java.math.BigDecimal)dynConstraints[13] , ((Number) dynConstraints[14]).shortValue() , ((Boolean) dynConstraints[15]).booleanValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00M92", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00M93", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((int[]) buf[8])[0] = rslt.getInt(9);
               ((int[]) buf[9])[0] = rslt.getInt(10);
               ((short[]) buf[10])[0] = rslt.getShort(11);
               ((int[]) buf[11])[0] = rslt.getInt(12);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[15], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[16], 2);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[17]).intValue());
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[19]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 400);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[12], 2);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setBigDecimal(sIdx, (java.math.BigDecimal)parms[13], 2);
               }
               return;
      }
   }

}

