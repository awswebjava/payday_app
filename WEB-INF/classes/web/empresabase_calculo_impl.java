package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class empresabase_calculo_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"EMPCOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaempcod4E191( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel4"+"_"+"EMPBASEC2TXT") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1429EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx4asaempbasec2txt4E191( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"EMPBASEC1TXT") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1429EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaempbasec1txt4E191( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx8asaclicod4E191( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_52") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_52( A3CliCod, A1EmpCod) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
            AV9EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9EmpBaseClaseLeg", GXutil.str( AV9EmpBaseClaseLeg, 1, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpBaseClaseLeg), "9")));
            AV10EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10EmpBaseTipo", AV10EmpBaseTipo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10EmpBaseTipo, ""))));
            AV11EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11EmpBaseCod1", AV11EmpBaseCod1);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11EmpBaseCod1, ""))));
            AV12EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12EmpBaseCod2", AV12EmpBaseCod2);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12EmpBaseCod2, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public empresabase_calculo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public empresabase_calculo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresabase_calculo_impl.class ));
   }

   public empresabase_calculo_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynEmpCod = new HTMLChoice();
      cmbEmpBaseClaseLeg = new HTMLChoice();
      cmbEmpBaseTipo = new HTMLChoice();
      cmbEmpBaseCod1 = new HTMLChoice();
      cmbEmpBaseCod2 = new HTMLChoice();
      cmbEmpLicDMes = new HTMLChoice();
      chkEmpLicAdju = UIFactory.getCheckbox(this);
      chkEmpLicAdjuObl = UIFactory.getCheckbox(this);
      chkEmpLicNecAut = UIFactory.getCheckbox(this);
      chkEmpLicIngMot = UIFactory.getCheckbox(this);
      chkEmpLicMotObl = UIFactory.getCheckbox(this);
      cmbEmpBasePromTCnt = new HTMLChoice();
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Values", cmbEmpBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
         A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Values", cmbEmpBaseTipo.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseCod1.getItemCount() > 0 )
      {
         A1430EmpBaseCod1 = cmbEmpBaseCod1.getValidValue(A1430EmpBaseCod1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod1.setValue( GXutil.rtrim( A1430EmpBaseCod1) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Values", cmbEmpBaseCod1.ToJavascriptSource(), true);
      }
      if ( cmbEmpBaseCod2.getItemCount() > 0 )
      {
         A1431EmpBaseCod2 = cmbEmpBaseCod2.getValidValue(A1431EmpBaseCod2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod2.setValue( GXutil.rtrim( A1431EmpBaseCod2) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Values", cmbEmpBaseCod2.ToJavascriptSource(), true);
      }
      if ( cmbEmpLicDMes.getItemCount() > 0 )
      {
         A1504EmpLicDMes = (byte)(GXutil.lval( cmbEmpLicDMes.getValidValue(GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0))))) ;
         n1504EmpLicDMes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpLicDMes.setValue( GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Values", cmbEmpLicDMes.ToJavascriptSource(), true);
      }
      A1507EmpLicAdju = GXutil.strtobool( GXutil.booltostr( A1507EmpLicAdju)) ;
      n1507EmpLicAdju = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
      A1508EmpLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1508EmpLicAdjuObl)) ;
      n1508EmpLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
      A1509EmpLicNecAut = GXutil.strtobool( GXutil.booltostr( A1509EmpLicNecAut)) ;
      n1509EmpLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
      A1510EmpLicIngMot = GXutil.strtobool( GXutil.booltostr( A1510EmpLicIngMot)) ;
      n1510EmpLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
      A1511EmpLicMotObl = GXutil.strtobool( GXutil.booltostr( A1511EmpLicMotObl)) ;
      n1511EmpLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
      if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
      {
         A1439EmpBasePromTCnt = cmbEmpBasePromTCnt.getValidValue(A1439EmpBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBasePromTCnt.setValue( GXutil.rtrim( A1439EmpBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBasePromTCnt.getInternalname(), "Values", cmbEmpBasePromTCnt.ToJavascriptSource(), true);
      }
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
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
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynEmpCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynEmpCod.getInternalname(), httpContext.getMessage( "Empresa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynEmpCod, dynEmpCod.getInternalname(), GXutil.trim( GXutil.str( A1EmpCod, 4, 0)), 1, dynEmpCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynEmpCod.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Values", dynEmpCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseClaseLeg.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseClaseLeg, cmbEmpBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)), 1, cmbEmpBaseClaseLeg.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbEmpBaseClaseLeg.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", "", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Values", cmbEmpBaseClaseLeg.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseTipo, cmbEmpBaseTipo.getInternalname(), GXutil.rtrim( A1429EmpBaseTipo), 1, cmbEmpBaseTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpBaseTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Values", cmbEmpBaseTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmpbasecod1_cell_Internalname, 1, 0, "px", 0, "px", divEmpbasecod1_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", cmbEmpBaseCod1.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseCod1.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseCod1.getInternalname(), httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseCod1, cmbEmpBaseCod1.getInternalname(), GXutil.rtrim( A1430EmpBaseCod1), 1, cmbEmpBaseCod1.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbEmpBaseCod1.getVisible(), cmbEmpBaseCod1.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpBaseCod1.setValue( GXutil.rtrim( A1430EmpBaseCod1) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Values", cmbEmpBaseCod1.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmpbasecod2_cell_Internalname, 1, 0, "px", 0, "px", divEmpbasecod2_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", cmbEmpBaseCod2.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBaseCod2.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBaseCod2.getInternalname(), httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBaseCod2, cmbEmpBaseCod2.getInternalname(), GXutil.rtrim( A1431EmpBaseCod2), 1, cmbEmpBaseCod2.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", cmbEmpBaseCod2.getVisible(), cmbEmpBaseCod2.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpBaseCod2.setValue( GXutil.rtrim( A1431EmpBaseCod2) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Values", cmbEmpBaseCod2.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmpbaseplus_cell_Internalname, 1, 0, "px", 0, "px", divEmpbaseplus_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpBasePlus_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePlus_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1432EmpBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePlus_Enabled!=0) ? localUtil.format( A1432EmpBasePlus, "9.9999") : localUtil.format( A1432EmpBasePlus, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpBasePlus_Visible, edtEmpBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdmin_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdmin_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDMin_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDMin_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpLicDMin_Internalname, httpContext.getMessage( "Cantidad mínima de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDMin_Internalname, GXutil.ltrim( localUtil.ntoc( A1517EmpLicDMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDMin_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1517EmpLicDMin), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1517EmpLicDMin), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDMin_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDMin_Visible, edtEmpLicDMin_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdlim_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdlim_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDLim_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1502EmpLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1502EmpLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1502EmpLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDLim_Visible, edtEmpLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdseman_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdseman_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDSeman_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1503EmpLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1503EmpLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1503EmpLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDSeman_Visible, edtEmpLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdmes_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdmes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", cmbEmpLicDMes.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpLicDMes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpLicDMes.getInternalname(), httpContext.getMessage( "Cantidad de días permitidos por mes", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpLicDMes, cmbEmpLicDMes.getInternalname(), GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)), 1, cmbEmpLicDMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbEmpLicDMes.getVisible(), cmbEmpLicDMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpLicDMes.setValue( GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Values", cmbEmpLicDMes.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdsemes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDSemes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1505EmpLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1505EmpLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1505EmpLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,72);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDSemes_Visible, edtEmpLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicdanual_cell_Internalname, 1, 0, "px", 0, "px", divEmplicdanual_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtEmpLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpLicDAnual_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1506EmpLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1506EmpLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1506EmpLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,77);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpLicDAnual_Visible, edtEmpLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicadju_cell_Internalname, 1, 0, "px", 0, "px", divEmplicadju_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicAdju.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicAdju.getInternalname(), GXutil.booltostr( A1507EmpLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkEmpLicAdju.getVisible(), chkEmpLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(82, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,82);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divEmplicadjuobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicAdjuObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicAdjuObl.getInternalname(), GXutil.booltostr( A1508EmpLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkEmpLicAdjuObl.getVisible(), chkEmpLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(87, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,87);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divEmplicnecaut_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicNecAut.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicNecAut.getInternalname(), GXutil.booltostr( A1509EmpLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkEmpLicNecAut.getVisible(), chkEmpLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(92, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,92);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicingmot_cell_Internalname, 1, 0, "px", 0, "px", divEmplicingmot_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicIngMot.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicIngMot.getInternalname(), GXutil.booltostr( A1510EmpLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkEmpLicIngMot.getVisible(), chkEmpLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(97, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,97);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divEmplicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divEmplicmotobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkEmpLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkEmpLicMotObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkEmpLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkEmpLicMotObl.getInternalname(), GXutil.booltostr( A1511EmpLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkEmpLicMotObl.getVisible(), chkEmpLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(102, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,102);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePromCnt1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1437EmpBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtEmpBasePromCnt2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtEmpBasePromCnt2_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1438EmpBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,112);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtEmpBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbEmpBasePromTCnt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbEmpBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 117,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbEmpBasePromTCnt, cmbEmpBasePromTCnt.getInternalname(), GXutil.rtrim( A1439EmpBasePromTCnt), 1, cmbEmpBasePromTCnt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbEmpBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,117);\"", "", true, (byte)(0), "HLP_Empresabase_calculo.htm");
      cmbEmpBasePromTCnt.setValue( GXutil.rtrim( A1439EmpBasePromTCnt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBasePromTCnt.getInternalname(), "Values", cmbEmpBasePromTCnt.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
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
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 125,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 127,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 133,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,133);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 134,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpBaseOrd_Internalname, GXutil.ltrim( localUtil.ntoc( A1518EmpBaseOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtEmpBaseOrd_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1518EmpBaseOrd), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1518EmpBaseOrd), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,134);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpBaseOrd_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpBaseOrd_Visible, edtEmpBaseOrd_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Empresabase_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e114E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1427EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1427EmpBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1429EmpBaseTipo = httpContext.cgiGet( "Z1429EmpBaseTipo") ;
            Z1430EmpBaseCod1 = httpContext.cgiGet( "Z1430EmpBaseCod1") ;
            Z1431EmpBaseCod2 = httpContext.cgiGet( "Z1431EmpBaseCod2") ;
            Z1432EmpBasePlus = localUtil.ctond( httpContext.cgiGet( "Z1432EmpBasePlus")) ;
            Z1517EmpLicDMin = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1517EmpLicDMin"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1517EmpLicDMin = ((0==A1517EmpLicDMin) ? true : false) ;
            Z1502EmpLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( "Z1502EmpLicDLim"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1502EmpLicDLim = ((0==A1502EmpLicDLim) ? true : false) ;
            Z1503EmpLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1503EmpLicDSeman"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1503EmpLicDSeman = ((0==A1503EmpLicDSeman) ? true : false) ;
            Z1504EmpLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1504EmpLicDMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1504EmpLicDMes = ((0==A1504EmpLicDMes) ? true : false) ;
            Z1505EmpLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( "Z1505EmpLicDSemes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1505EmpLicDSemes = ((0==A1505EmpLicDSemes) ? true : false) ;
            Z1506EmpLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( "Z1506EmpLicDAnual"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1506EmpLicDAnual = ((0==A1506EmpLicDAnual) ? true : false) ;
            Z1507EmpLicAdju = GXutil.strtobool( httpContext.cgiGet( "Z1507EmpLicAdju")) ;
            n1507EmpLicAdju = ((false==A1507EmpLicAdju) ? true : false) ;
            Z1508EmpLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( "Z1508EmpLicAdjuObl")) ;
            n1508EmpLicAdjuObl = ((false==A1508EmpLicAdjuObl) ? true : false) ;
            Z1509EmpLicNecAut = GXutil.strtobool( httpContext.cgiGet( "Z1509EmpLicNecAut")) ;
            n1509EmpLicNecAut = ((false==A1509EmpLicNecAut) ? true : false) ;
            Z1510EmpLicIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1510EmpLicIngMot")) ;
            n1510EmpLicIngMot = ((false==A1510EmpLicIngMot) ? true : false) ;
            Z1511EmpLicMotObl = GXutil.strtobool( httpContext.cgiGet( "Z1511EmpLicMotObl")) ;
            n1511EmpLicMotObl = ((false==A1511EmpLicMotObl) ? true : false) ;
            Z1518EmpBaseOrd = (short)(localUtil.ctol( httpContext.cgiGet( "Z1518EmpBaseOrd"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1518EmpBaseOrd = ((0==A1518EmpBaseOrd) ? true : false) ;
            Z1437EmpBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1437EmpBasePromCnt1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1438EmpBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1438EmpBasePromCnt2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1439EmpBasePromTCnt = httpContext.cgiGet( "Z1439EmpBasePromTCnt") ;
            Z2003EmpBaseRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2003EmpBaseRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2003EmpBaseRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2003EmpBaseRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1516EmpBaseC2Txt = httpContext.cgiGet( "EMPBASEC2TXT") ;
            A1515EmpBaseC1Txt = httpContext.cgiGet( "EMPBASEC1TXT") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9EmpBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vEMPBASECLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV10EmpBaseTipo = httpContext.cgiGet( "vEMPBASETIPO") ;
            AV11EmpBaseCod1 = httpContext.cgiGet( "vEMPBASECOD1") ;
            AV12EmpBaseCod2 = httpContext.cgiGet( "vEMPBASECOD2") ;
            A2003EmpBaseRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "EMPBASERELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV41Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            dynEmpCod.setValue( httpContext.cgiGet( dynEmpCod.getInternalname()) );
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            cmbEmpBaseClaseLeg.setValue( httpContext.cgiGet( cmbEmpBaseClaseLeg.getInternalname()) );
            A1427EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpBaseClaseLeg.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
            cmbEmpBaseTipo.setValue( httpContext.cgiGet( cmbEmpBaseTipo.getInternalname()) );
            A1429EmpBaseTipo = httpContext.cgiGet( cmbEmpBaseTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
            cmbEmpBaseCod1.setValue( httpContext.cgiGet( cmbEmpBaseCod1.getInternalname()) );
            A1430EmpBaseCod1 = httpContext.cgiGet( cmbEmpBaseCod1.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
            cmbEmpBaseCod2.setValue( httpContext.cgiGet( cmbEmpBaseCod2.getInternalname()) );
            A1431EmpBaseCod2 = httpContext.cgiGet( cmbEmpBaseCod2.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtEmpBasePlus_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEmpBasePlus_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPBASEPLUS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpBasePlus_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1432EmpBasePlus = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
            }
            else
            {
               A1432EmpBasePlus = localUtil.ctond( httpContext.cgiGet( edtEmpBasePlus_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPLICDMIN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpLicDMin_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1517EmpLicDMin = (byte)(0) ;
               n1517EmpLicDMin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
            }
            else
            {
               A1517EmpLicDMin = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDMin_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1517EmpLicDMin = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
            }
            n1517EmpLicDMin = ((0==A1517EmpLicDMin) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPLICDLIM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpLicDLim_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1502EmpLicDLim = (short)(0) ;
               n1502EmpLicDLim = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
            }
            else
            {
               A1502EmpLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1502EmpLicDLim = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
            }
            n1502EmpLicDLim = ((0==A1502EmpLicDLim) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPLICDSEMAN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpLicDSeman_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1503EmpLicDSeman = (byte)(0) ;
               n1503EmpLicDSeman = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
            }
            else
            {
               A1503EmpLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1503EmpLicDSeman = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
            }
            n1503EmpLicDSeman = ((0==A1503EmpLicDSeman) ? true : false) ;
            cmbEmpLicDMes.setValue( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()) );
            A1504EmpLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbEmpLicDMes.getInternalname()))) ;
            n1504EmpLicDMes = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
            n1504EmpLicDMes = ((0==A1504EmpLicDMes) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPLICDSEMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpLicDSemes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1505EmpLicDSemes = (short)(0) ;
               n1505EmpLicDSemes = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
            }
            else
            {
               A1505EmpLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1505EmpLicDSemes = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
            }
            n1505EmpLicDSemes = ((0==A1505EmpLicDSemes) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPLICDANUAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpLicDAnual_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1506EmpLicDAnual = (short)(0) ;
               n1506EmpLicDAnual = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
            }
            else
            {
               A1506EmpLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1506EmpLicDAnual = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
            }
            n1506EmpLicDAnual = ((0==A1506EmpLicDAnual) ? true : false) ;
            A1507EmpLicAdju = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdju.getInternalname())) ;
            n1507EmpLicAdju = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
            n1507EmpLicAdju = ((false==A1507EmpLicAdju) ? true : false) ;
            A1508EmpLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicAdjuObl.getInternalname())) ;
            n1508EmpLicAdjuObl = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
            n1508EmpLicAdjuObl = ((false==A1508EmpLicAdjuObl) ? true : false) ;
            A1509EmpLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkEmpLicNecAut.getInternalname())) ;
            n1509EmpLicNecAut = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
            n1509EmpLicNecAut = ((false==A1509EmpLicNecAut) ? true : false) ;
            A1510EmpLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkEmpLicIngMot.getInternalname())) ;
            n1510EmpLicIngMot = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
            n1510EmpLicIngMot = ((false==A1510EmpLicIngMot) ? true : false) ;
            A1511EmpLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkEmpLicMotObl.getInternalname())) ;
            n1511EmpLicMotObl = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
            n1511EmpLicMotObl = ((false==A1511EmpLicMotObl) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPBASEPROMCNT1");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpBasePromCnt1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1437EmpBasePromCnt1 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
            }
            else
            {
               A1437EmpBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPBASEPROMCNT2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpBasePromCnt2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1438EmpBasePromCnt2 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
            }
            else
            {
               A1438EmpBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
            }
            cmbEmpBasePromTCnt.setValue( httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) );
            A1439EmpBasePromTCnt = httpContext.cgiGet( cmbEmpBasePromTCnt.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBaseOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpBaseOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPBASEORD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpBaseOrd_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1518EmpBaseOrd = (short)(0) ;
               n1518EmpBaseOrd = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
            }
            else
            {
               A1518EmpBaseOrd = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpBaseOrd_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1518EmpBaseOrd = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
            }
            n1518EmpBaseOrd = ((0==A1518EmpBaseOrd) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Empresabase_calculo");
            A1EmpCod = (short)(GXutil.lval( httpContext.cgiGet( dynEmpCod.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("EmpBaseRelSec", localUtil.format( DecimalUtil.doubleToDec(A2003EmpBaseRelSec), "ZZZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("empresabase_calculo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1427EmpBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "EmpBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
               A1429EmpBaseTipo = httpContext.GetPar( "EmpBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
               A1430EmpBaseCod1 = httpContext.GetPar( "EmpBaseCod1") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
               A1431EmpBaseCod2 = httpContext.GetPar( "EmpBaseCod2") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
               getEqualNoModal( ) ;
               gxaempcod_html4E191( AV7CliCod) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode191 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxaempcod_html4E191( AV7CliCod) ;
                  Gx_mode = sMode191 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound191 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_4E0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e114E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e124E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e124E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll4E191( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes4E191( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_4E0( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls4E191( ) ;
         }
         else
         {
            checkExtendedTable4E191( ) ;
            closeExtendedTableCursors4E191( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption4E0( )
   {
   }

   public void e114E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") == 0 )
      {
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "feriado") == 0 )
         {
            cmbEmpBaseCod1.addItem(new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV7CliCod), new web.palabracod1feriadoobligatorio(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
            cmbEmpBaseCod1.addItem(new web.palabracod1nolaborableopcional(remoteHandle, context).executeUdp( AV7CliCod), new web.palabracod1nolaborableopcional(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
            cmbEmpBaseCod2.addItem(new web.palabracod2feriadotrabajado(remoteHandle, context).executeUdp( AV7CliCod), new web.palabracod2feriadotrabajado(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
            cmbEmpBaseCod2.addItem(new web.palabracod2feriadonotrabajado(remoteHandle, context).executeUdp( AV7CliCod), new web.palabracod2feriadonotrabajado(remoteHandle, context).executeUdp( AV7CliCod), (short)(0));
         }
         else
         {
            GXt_int1 = AV20PaiCod ;
            GXv_int2[0] = GXt_int1 ;
            new web.empresagetpais(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_int2) ;
            empresabase_calculo_impl.this.GXt_int1 = GXv_int2[0] ;
            AV20PaiCod = GXt_int1 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV20PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV20PaiCod), 4, 0));
            GXv_objcol_char3[0] = AV37collection_EmpBaseCod1 ;
            new web.devuelvelicenciasparacalculo(remoteHandle, context).execute( AV7CliCod, AV20PaiCod, GXv_objcol_char3) ;
            AV37collection_EmpBaseCod1 = GXv_objcol_char3[0] ;
            AV38i = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV38i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38i), 4, 0));
            while ( AV38i <= AV37collection_EmpBaseCod1.size() )
            {
               AV39SitCodigo = (String)AV37collection_EmpBaseCod1.elementAt(-1+AV38i) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV39SitCodigo", AV39SitCodigo);
               GXv_char4[0] = AV40SitDescrip ;
               new web.getsituaciondescrip(remoteHandle, context).execute( AV39SitCodigo, GXv_char4) ;
               empresabase_calculo_impl.this.AV40SitDescrip = GXv_char4[0] ;
               httpContext.ajax_rsp_assign_attri("", false, "AV40SitDescrip", AV40SitDescrip);
               cmbEmpBaseCod1.addItem(AV39SitCodigo, AV40SitDescrip, (short)(0));
               AV38i = (short)(AV38i+1) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV38i", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV38i), 4, 0));
            }
         }
      }
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext5[0] = AV13WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext5) ;
      AV13WWPContext = GXv_SdtWWPContext5[0] ;
      AV14IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV14IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Insert", GXv_boolean7) ;
         empresabase_calculo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV14IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV14IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Update", GXv_boolean7) ;
         empresabase_calculo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV14IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV14IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEmpresabase_calculo_Delete", GXv_boolean7) ;
         empresabase_calculo_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV14IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14IsAuthorized", AV14IsAuthorized);
      }
      if ( ! AV14IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV41Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV16TrnContext.fromxml(AV17WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpBaseOrd_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBaseOrd_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBaseOrd_Visible), 5, 0), true);
   }

   public void e124E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      cmbEmpBaseCod1.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod1.getVisible(), 5, 0), true);
      divEmpbasecod1_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod1_cell_Internalname, "Class", divEmpbasecod1_cell_Class, true);
      cmbEmpBaseCod2.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod2.getVisible(), 5, 0), true);
      divEmpbasecod2_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod2_cell_Internalname, "Class", divEmpbasecod2_cell_Class, true);
      edtEmpBasePlus_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Visible), 5, 0), true);
      divEmpbaseplus_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmpbaseplus_cell_Internalname, "Class", divEmpbaseplus_cell_Class, true);
      edtEmpLicDMin_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Visible), 5, 0), true);
      divEmplicdmin_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdmin_cell_Internalname, "Class", divEmplicdmin_cell_Class, true);
      edtEmpLicDLim_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Visible), 5, 0), true);
      divEmplicdlim_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdlim_cell_Internalname, "Class", divEmplicdlim_cell_Class, true);
      edtEmpLicDSeman_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Visible), 5, 0), true);
      divEmplicdseman_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdseman_cell_Internalname, "Class", divEmplicdseman_cell_Class, true);
      cmbEmpLicDMes.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpLicDMes.getVisible(), 5, 0), true);
      divEmplicdmes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdmes_cell_Internalname, "Class", divEmplicdmes_cell_Class, true);
      edtEmpLicDSemes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Visible), 5, 0), true);
      divEmplicdsemes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdsemes_cell_Internalname, "Class", divEmplicdsemes_cell_Class, true);
      edtEmpLicDAnual_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Visible), 5, 0), true);
      divEmplicdanual_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicdanual_cell_Internalname, "Class", divEmplicdanual_cell_Class, true);
      chkEmpLicAdju.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdju.getVisible(), 5, 0), true);
      divEmplicadju_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicadju_cell_Internalname, "Class", divEmplicadju_cell_Class, true);
      chkEmpLicAdjuObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdjuObl.getVisible(), 5, 0), true);
      divEmplicadjuobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicadjuobl_cell_Internalname, "Class", divEmplicadjuobl_cell_Class, true);
      chkEmpLicNecAut.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicNecAut.getVisible(), 5, 0), true);
      divEmplicnecaut_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicnecaut_cell_Internalname, "Class", divEmplicnecaut_cell_Class, true);
      chkEmpLicIngMot.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicIngMot.getVisible(), 5, 0), true);
      divEmplicingmot_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicingmot_cell_Internalname, "Class", divEmplicingmot_cell_Class, true);
      chkEmpLicMotObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicMotObl.getVisible(), 5, 0), true);
      divEmplicmotobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divEmplicmotobl_cell_Internalname, "Class", divEmplicmotobl_cell_Class, true);
   }

   public void zm4E191( int GX_JID )
   {
      if ( ( GX_JID == 51 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1432EmpBasePlus = T004E3_A1432EmpBasePlus[0] ;
            Z1517EmpLicDMin = T004E3_A1517EmpLicDMin[0] ;
            Z1502EmpLicDLim = T004E3_A1502EmpLicDLim[0] ;
            Z1503EmpLicDSeman = T004E3_A1503EmpLicDSeman[0] ;
            Z1504EmpLicDMes = T004E3_A1504EmpLicDMes[0] ;
            Z1505EmpLicDSemes = T004E3_A1505EmpLicDSemes[0] ;
            Z1506EmpLicDAnual = T004E3_A1506EmpLicDAnual[0] ;
            Z1507EmpLicAdju = T004E3_A1507EmpLicAdju[0] ;
            Z1508EmpLicAdjuObl = T004E3_A1508EmpLicAdjuObl[0] ;
            Z1509EmpLicNecAut = T004E3_A1509EmpLicNecAut[0] ;
            Z1510EmpLicIngMot = T004E3_A1510EmpLicIngMot[0] ;
            Z1511EmpLicMotObl = T004E3_A1511EmpLicMotObl[0] ;
            Z1518EmpBaseOrd = T004E3_A1518EmpBaseOrd[0] ;
            Z1437EmpBasePromCnt1 = T004E3_A1437EmpBasePromCnt1[0] ;
            Z1438EmpBasePromCnt2 = T004E3_A1438EmpBasePromCnt2[0] ;
            Z1439EmpBasePromTCnt = T004E3_A1439EmpBasePromTCnt[0] ;
            Z2003EmpBaseRelSec = T004E3_A2003EmpBaseRelSec[0] ;
         }
         else
         {
            Z1432EmpBasePlus = A1432EmpBasePlus ;
            Z1517EmpLicDMin = A1517EmpLicDMin ;
            Z1502EmpLicDLim = A1502EmpLicDLim ;
            Z1503EmpLicDSeman = A1503EmpLicDSeman ;
            Z1504EmpLicDMes = A1504EmpLicDMes ;
            Z1505EmpLicDSemes = A1505EmpLicDSemes ;
            Z1506EmpLicDAnual = A1506EmpLicDAnual ;
            Z1507EmpLicAdju = A1507EmpLicAdju ;
            Z1508EmpLicAdjuObl = A1508EmpLicAdjuObl ;
            Z1509EmpLicNecAut = A1509EmpLicNecAut ;
            Z1510EmpLicIngMot = A1510EmpLicIngMot ;
            Z1511EmpLicMotObl = A1511EmpLicMotObl ;
            Z1518EmpBaseOrd = A1518EmpBaseOrd ;
            Z1437EmpBasePromCnt1 = A1437EmpBasePromCnt1 ;
            Z1438EmpBasePromCnt2 = A1438EmpBasePromCnt2 ;
            Z1439EmpBasePromTCnt = A1439EmpBasePromTCnt ;
            Z2003EmpBaseRelSec = A2003EmpBaseRelSec ;
         }
      }
      if ( GX_JID == -51 )
      {
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         Z1432EmpBasePlus = A1432EmpBasePlus ;
         Z1517EmpLicDMin = A1517EmpLicDMin ;
         Z1502EmpLicDLim = A1502EmpLicDLim ;
         Z1503EmpLicDSeman = A1503EmpLicDSeman ;
         Z1504EmpLicDMes = A1504EmpLicDMes ;
         Z1505EmpLicDSemes = A1505EmpLicDSemes ;
         Z1506EmpLicDAnual = A1506EmpLicDAnual ;
         Z1507EmpLicAdju = A1507EmpLicAdju ;
         Z1508EmpLicAdjuObl = A1508EmpLicAdjuObl ;
         Z1509EmpLicNecAut = A1509EmpLicNecAut ;
         Z1510EmpLicIngMot = A1510EmpLicIngMot ;
         Z1511EmpLicMotObl = A1511EmpLicMotObl ;
         Z1518EmpBaseOrd = A1518EmpBaseOrd ;
         Z1437EmpBasePromCnt1 = A1437EmpBasePromCnt1 ;
         Z1438EmpBasePromCnt2 = A1438EmpBasePromCnt2 ;
         Z1439EmpBasePromTCnt = A1439EmpBasePromTCnt ;
         Z2003EmpBaseRelSec = A2003EmpBaseRelSec ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      cmbEmpBaseClaseLeg.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseClaseLeg.getEnabled(), 5, 0), true);
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      cmbEmpBaseClaseLeg.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseClaseLeg.getEnabled(), 5, 0), true);
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaempcod_html4E191( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int8 = A3CliCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
            empresabase_calculo_impl.this.GXt_int8 = GXv_int9[0] ;
            A3CliCod = GXt_int8 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8EmpCod) )
      {
         A1EmpCod = AV8EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      if ( ! (0==AV9EmpBaseClaseLeg) )
      {
         A1427EmpBaseClaseLeg = AV9EmpBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      }
      if ( ! (GXutil.strcmp("", AV10EmpBaseTipo)==0) )
      {
         A1429EmpBaseTipo = AV10EmpBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      }
      if ( ! (GXutil.strcmp("", AV10EmpBaseTipo)==0) )
      {
         cmbEmpBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbEmpBaseTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseTipo.getEnabled(), 5, 0), true);
      }
      cmbEmpBaseCod1.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "horaNormal")!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod1.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 ) ) )
      {
         divEmpbasecod1_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod1_cell_Internalname, "Class", divEmpbasecod1_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 )
         {
            divEmpbasecod1_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod1_cell_Internalname, "Class", divEmpbasecod1_cell_Class, true);
         }
      }
      cmbEmpBaseCod2.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "horaNormal")!=0)&&(GXutil.strcmp(AV10EmpBaseTipo, "licencia")!=0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpBaseCod2.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 ) && ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") != 0 ) ) )
      {
         divEmpbasecod2_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod2_cell_Internalname, "Class", divEmpbasecod2_cell_Class, true);
      }
      else
      {
         if ( ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 ) && ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") != 0 ) )
         {
            divEmpbasecod2_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmpbasecod2_cell_Internalname, "Class", divEmpbasecod2_cell_Class, true);
         }
      }
      edtEmpBasePlus_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 ) ) )
      {
         divEmpbaseplus_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmpbaseplus_cell_Internalname, "Class", divEmpbaseplus_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "horaNormal") != 0 )
         {
            divEmpbaseplus_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmpbaseplus_cell_Internalname, "Class", divEmpbaseplus_cell_Class, true);
         }
      }
      edtEmpLicDMin_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDMin_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdmin_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdmin_cell_Internalname, "Class", divEmplicdmin_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdmin_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdmin_cell_Internalname, "Class", divEmplicdmin_cell_Class, true);
         }
      }
      edtEmpLicDLim_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdlim_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdlim_cell_Internalname, "Class", divEmplicdlim_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdlim_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdlim_cell_Internalname, "Class", divEmplicdlim_cell_Class, true);
         }
      }
      edtEmpLicDSeman_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdseman_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdseman_cell_Internalname, "Class", divEmplicdseman_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdseman_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdseman_cell_Internalname, "Class", divEmplicdseman_cell_Class, true);
         }
      }
      cmbEmpLicDMes.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbEmpLicDMes.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdmes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdmes_cell_Internalname, "Class", divEmplicdmes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdmes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdmes_cell_Internalname, "Class", divEmplicdmes_cell_Class, true);
         }
      }
      edtEmpLicDSemes_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdsemes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdsemes_cell_Internalname, "Class", divEmplicdsemes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdsemes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdsemes_cell_Internalname, "Class", divEmplicdsemes_cell_Class, true);
         }
      }
      edtEmpLicDAnual_Visible = ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicdanual_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicdanual_cell_Internalname, "Class", divEmplicdanual_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicdanual_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicdanual_cell_Internalname, "Class", divEmplicdanual_cell_Class, true);
         }
      }
      chkEmpLicAdju.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdju.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicadju_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicadju_cell_Internalname, "Class", divEmplicadju_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicadju_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicadju_cell_Internalname, "Class", divEmplicadju_cell_Class, true);
         }
      }
      chkEmpLicAdjuObl.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicAdjuObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicadjuobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicadjuobl_cell_Internalname, "Class", divEmplicadjuobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicadjuobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicadjuobl_cell_Internalname, "Class", divEmplicadjuobl_cell_Class, true);
         }
      }
      chkEmpLicNecAut.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicNecAut.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicnecaut_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicnecaut_cell_Internalname, "Class", divEmplicnecaut_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicnecaut_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicnecaut_cell_Internalname, "Class", divEmplicnecaut_cell_Class, true);
         }
      }
      chkEmpLicIngMot.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicIngMot.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicingmot_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicingmot_cell_Internalname, "Class", divEmplicingmot_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicingmot_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicingmot_cell_Internalname, "Class", divEmplicingmot_cell_Class, true);
         }
      }
      chkEmpLicMotObl.setVisible( ((GXutil.strcmp(AV10EmpBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkEmpLicMotObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 ) ) )
      {
         divEmplicmotobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divEmplicmotobl_cell_Internalname, "Class", divEmplicmotobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV10EmpBaseTipo, "licencia") == 0 )
         {
            divEmplicmotobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divEmplicmotobl_cell_Internalname, "Class", divEmplicmotobl_cell_Class, true);
         }
      }
      if ( ! (GXutil.strcmp("", AV10EmpBaseTipo)==0) )
      {
         cmbEmpBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11EmpBaseCod1)==0) )
      {
         A1430EmpBaseCod1 = AV11EmpBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      }
      if ( ! (GXutil.strcmp("", AV11EmpBaseCod1)==0) )
      {
         cmbEmpBaseCod1.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod1.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbEmpBaseCod1.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod1.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11EmpBaseCod1)==0) )
      {
         cmbEmpBaseCod1.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod1.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV12EmpBaseCod2)==0) )
      {
         A1431EmpBaseCod2 = AV12EmpBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      if ( ! (GXutil.strcmp("", AV12EmpBaseCod2)==0) )
      {
         cmbEmpBaseCod2.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod2.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbEmpBaseCod2.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod2.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV12EmpBaseCod2)==0) )
      {
         cmbEmpBaseCod2.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod2.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV41Pgmname = "Empresabase_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
         GXt_char10 = A1515EmpBaseC1Txt ;
         GXv_char4[0] = GXt_char10 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
         empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
         A1515EmpBaseC1Txt = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
         GXt_char10 = A1516EmpBaseC2Txt ;
         GXv_char4[0] = GXt_char10 ;
         new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
         empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
         A1516EmpBaseC2Txt = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      }
   }

   public void load4E191( )
   {
      /* Using cursor T004E5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A1432EmpBasePlus = T004E5_A1432EmpBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
         A1517EmpLicDMin = T004E5_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = T004E5_n1517EmpLicDMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
         A1502EmpLicDLim = T004E5_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = T004E5_n1502EmpLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
         A1503EmpLicDSeman = T004E5_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = T004E5_n1503EmpLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
         A1504EmpLicDMes = T004E5_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = T004E5_n1504EmpLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
         A1505EmpLicDSemes = T004E5_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = T004E5_n1505EmpLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
         A1506EmpLicDAnual = T004E5_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = T004E5_n1506EmpLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
         A1507EmpLicAdju = T004E5_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = T004E5_n1507EmpLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
         A1508EmpLicAdjuObl = T004E5_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = T004E5_n1508EmpLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
         A1509EmpLicNecAut = T004E5_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = T004E5_n1509EmpLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
         A1510EmpLicIngMot = T004E5_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = T004E5_n1510EmpLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
         A1511EmpLicMotObl = T004E5_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = T004E5_n1511EmpLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
         A1518EmpBaseOrd = T004E5_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = T004E5_n1518EmpBaseOrd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
         A1437EmpBasePromCnt1 = T004E5_A1437EmpBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
         A1438EmpBasePromCnt2 = T004E5_A1438EmpBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
         A1439EmpBasePromTCnt = T004E5_A1439EmpBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
         A2003EmpBaseRelSec = T004E5_A2003EmpBaseRelSec[0] ;
         zm4E191( -51) ;
      }
      pr_default.close(3);
      onLoadActions4E191( ) ;
   }

   public void onLoadActions4E191( )
   {
      AV41Pgmname = "Empresabase_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
      GXt_char10 = A1515EmpBaseC1Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1515EmpBaseC1Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
      GXt_char10 = A1516EmpBaseC2Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1516EmpBaseC2Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
   }

   public void checkExtendedTable4E191( )
   {
      nIsDirty_191 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV41Pgmname = "Empresabase_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
      /* Using cursor T004E4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A1427EmpBaseClaseLeg == 1 ) || ( A1427EmpBaseClaseLeg == 2 ) || ( A1427EmpBaseClaseLeg == 3 ) || ( A1427EmpBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "");
         AnyError = (short)(1) ;
      }
      if ( ! ( ( GXutil.strcmp(A1429EmpBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1429EmpBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPBASETIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_191 = (short)(1) ;
      GXt_char10 = A1515EmpBaseC1Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1515EmpBaseC1Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
      nIsDirty_191 = (short)(1) ;
      GXt_char10 = A1516EmpBaseC2Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1516EmpBaseC2Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      if ( ! ( ( GXutil.strcmp(A1439EmpBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1439EmpBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "EMPBASEPROMTCNT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbEmpBasePromTCnt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors4E191( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_52( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T004E6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(4) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(4);
   }

   public void getKey4E191( )
   {
      /* Using cursor T004E7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound191 = (short)(1) ;
      }
      else
      {
         RcdFound191 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T004E3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm4E191( 51) ;
         RcdFound191 = (short)(1) ;
         A1427EmpBaseClaseLeg = T004E3_A1427EmpBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
         A1429EmpBaseTipo = T004E3_A1429EmpBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = T004E3_A1430EmpBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = T004E3_A1431EmpBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
         A1432EmpBasePlus = T004E3_A1432EmpBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
         A1517EmpLicDMin = T004E3_A1517EmpLicDMin[0] ;
         n1517EmpLicDMin = T004E3_n1517EmpLicDMin[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
         A1502EmpLicDLim = T004E3_A1502EmpLicDLim[0] ;
         n1502EmpLicDLim = T004E3_n1502EmpLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
         A1503EmpLicDSeman = T004E3_A1503EmpLicDSeman[0] ;
         n1503EmpLicDSeman = T004E3_n1503EmpLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
         A1504EmpLicDMes = T004E3_A1504EmpLicDMes[0] ;
         n1504EmpLicDMes = T004E3_n1504EmpLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
         A1505EmpLicDSemes = T004E3_A1505EmpLicDSemes[0] ;
         n1505EmpLicDSemes = T004E3_n1505EmpLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
         A1506EmpLicDAnual = T004E3_A1506EmpLicDAnual[0] ;
         n1506EmpLicDAnual = T004E3_n1506EmpLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
         A1507EmpLicAdju = T004E3_A1507EmpLicAdju[0] ;
         n1507EmpLicAdju = T004E3_n1507EmpLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
         A1508EmpLicAdjuObl = T004E3_A1508EmpLicAdjuObl[0] ;
         n1508EmpLicAdjuObl = T004E3_n1508EmpLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
         A1509EmpLicNecAut = T004E3_A1509EmpLicNecAut[0] ;
         n1509EmpLicNecAut = T004E3_n1509EmpLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
         A1510EmpLicIngMot = T004E3_A1510EmpLicIngMot[0] ;
         n1510EmpLicIngMot = T004E3_n1510EmpLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
         A1511EmpLicMotObl = T004E3_A1511EmpLicMotObl[0] ;
         n1511EmpLicMotObl = T004E3_n1511EmpLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
         A1518EmpBaseOrd = T004E3_A1518EmpBaseOrd[0] ;
         n1518EmpBaseOrd = T004E3_n1518EmpBaseOrd[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
         A1437EmpBasePromCnt1 = T004E3_A1437EmpBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
         A1438EmpBasePromCnt2 = T004E3_A1438EmpBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
         A1439EmpBasePromTCnt = T004E3_A1439EmpBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
         A2003EmpBaseRelSec = T004E3_A2003EmpBaseRelSec[0] ;
         A3CliCod = T004E3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004E3_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z1427EmpBaseClaseLeg = A1427EmpBaseClaseLeg ;
         Z1429EmpBaseTipo = A1429EmpBaseTipo ;
         Z1430EmpBaseCod1 = A1430EmpBaseCod1 ;
         Z1431EmpBaseCod2 = A1431EmpBaseCod2 ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load4E191( ) ;
         if ( AnyError == 1 )
         {
            RcdFound191 = (short)(0) ;
            initializeNonKey4E191( ) ;
         }
         Gx_mode = sMode191 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound191 = (short)(0) ;
         initializeNonKey4E191( ) ;
         sMode191 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode191 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey4E191( ) ;
      if ( RcdFound191 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound191 = (short)(0) ;
      /* Using cursor T004E8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A1427EmpBaseClaseLeg), Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1429EmpBaseTipo, A1429EmpBaseTipo, Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1430EmpBaseCod1, A1430EmpBaseCod1, A1429EmpBaseTipo, Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1431EmpBaseCod2});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T004E8_A3CliCod[0] < A3CliCod ) || ( T004E8_A3CliCod[0] == A3CliCod ) && ( T004E8_A1EmpCod[0] < A1EmpCod ) || ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( T004E8_A1427EmpBaseClaseLeg[0] < A1427EmpBaseClaseLeg ) || ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) < 0 ) || ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1430EmpBaseCod1[0], A1430EmpBaseCod1) < 0 ) || ( GXutil.strcmp(T004E8_A1430EmpBaseCod1[0], A1430EmpBaseCod1) == 0 ) && ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1431EmpBaseCod2[0], A1431EmpBaseCod2) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T004E8_A3CliCod[0] > A3CliCod ) || ( T004E8_A3CliCod[0] == A3CliCod ) && ( T004E8_A1EmpCod[0] > A1EmpCod ) || ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( T004E8_A1427EmpBaseClaseLeg[0] > A1427EmpBaseClaseLeg ) || ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) > 0 ) || ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1430EmpBaseCod1[0], A1430EmpBaseCod1) > 0 ) || ( GXutil.strcmp(T004E8_A1430EmpBaseCod1[0], A1430EmpBaseCod1) == 0 ) && ( GXutil.strcmp(T004E8_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E8_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E8_A1EmpCod[0] == A1EmpCod ) && ( T004E8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E8_A1431EmpBaseCod2[0], A1431EmpBaseCod2) > 0 ) ) )
         {
            A3CliCod = T004E8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004E8_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1427EmpBaseClaseLeg = T004E8_A1427EmpBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
            A1429EmpBaseTipo = T004E8_A1429EmpBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
            A1430EmpBaseCod1 = T004E8_A1430EmpBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
            A1431EmpBaseCod2 = T004E8_A1431EmpBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
            RcdFound191 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound191 = (short)(0) ;
      /* Using cursor T004E9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Byte.valueOf(A1427EmpBaseClaseLeg), Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1429EmpBaseTipo, A1429EmpBaseTipo, Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1430EmpBaseCod1, A1430EmpBaseCod1, A1429EmpBaseTipo, Byte.valueOf(A1427EmpBaseClaseLeg), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), A1431EmpBaseCod2});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T004E9_A3CliCod[0] > A3CliCod ) || ( T004E9_A3CliCod[0] == A3CliCod ) && ( T004E9_A1EmpCod[0] > A1EmpCod ) || ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( T004E9_A1427EmpBaseClaseLeg[0] > A1427EmpBaseClaseLeg ) || ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) > 0 ) || ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1430EmpBaseCod1[0], A1430EmpBaseCod1) > 0 ) || ( GXutil.strcmp(T004E9_A1430EmpBaseCod1[0], A1430EmpBaseCod1) == 0 ) && ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1431EmpBaseCod2[0], A1431EmpBaseCod2) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T004E9_A3CliCod[0] < A3CliCod ) || ( T004E9_A3CliCod[0] == A3CliCod ) && ( T004E9_A1EmpCod[0] < A1EmpCod ) || ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( T004E9_A1427EmpBaseClaseLeg[0] < A1427EmpBaseClaseLeg ) || ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) < 0 ) || ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1430EmpBaseCod1[0], A1430EmpBaseCod1) < 0 ) || ( GXutil.strcmp(T004E9_A1430EmpBaseCod1[0], A1430EmpBaseCod1) == 0 ) && ( GXutil.strcmp(T004E9_A1429EmpBaseTipo[0], A1429EmpBaseTipo) == 0 ) && ( T004E9_A1427EmpBaseClaseLeg[0] == A1427EmpBaseClaseLeg ) && ( T004E9_A1EmpCod[0] == A1EmpCod ) && ( T004E9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T004E9_A1431EmpBaseCod2[0], A1431EmpBaseCod2) < 0 ) ) )
         {
            A3CliCod = T004E9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T004E9_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A1427EmpBaseClaseLeg = T004E9_A1427EmpBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
            A1429EmpBaseTipo = T004E9_A1429EmpBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
            A1430EmpBaseCod1 = T004E9_A1430EmpBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
            A1431EmpBaseCod2 = T004E9_A1431EmpBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
            RcdFound191 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey4E191( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert4E191( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound191 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A1427EmpBaseClaseLeg = Z1427EmpBaseClaseLeg ;
               httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
               A1429EmpBaseTipo = Z1429EmpBaseTipo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
               A1430EmpBaseCod1 = Z1430EmpBaseCod1 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
               A1431EmpBaseCod2 = Z1431EmpBaseCod2 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update4E191( ) ;
               GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert4E191( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert4E191( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A1427EmpBaseClaseLeg != Z1427EmpBaseClaseLeg ) || ( GXutil.strcmp(A1429EmpBaseTipo, Z1429EmpBaseTipo) != 0 ) || ( GXutil.strcmp(A1430EmpBaseCod1, Z1430EmpBaseCod1) != 0 ) || ( GXutil.strcmp(A1431EmpBaseCod2, Z1431EmpBaseCod2) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1427EmpBaseClaseLeg = Z1427EmpBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
         A1429EmpBaseTipo = Z1429EmpBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = Z1430EmpBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = Z1431EmpBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbEmpBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency4E191( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T004E2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1432EmpBasePlus, T004E2_A1432EmpBasePlus[0]) != 0 ) || ( Z1517EmpLicDMin != T004E2_A1517EmpLicDMin[0] ) || ( Z1502EmpLicDLim != T004E2_A1502EmpLicDLim[0] ) || ( Z1503EmpLicDSeman != T004E2_A1503EmpLicDSeman[0] ) || ( Z1504EmpLicDMes != T004E2_A1504EmpLicDMes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1505EmpLicDSemes != T004E2_A1505EmpLicDSemes[0] ) || ( Z1506EmpLicDAnual != T004E2_A1506EmpLicDAnual[0] ) || ( Z1507EmpLicAdju != T004E2_A1507EmpLicAdju[0] ) || ( Z1508EmpLicAdjuObl != T004E2_A1508EmpLicAdjuObl[0] ) || ( Z1509EmpLicNecAut != T004E2_A1509EmpLicNecAut[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1510EmpLicIngMot != T004E2_A1510EmpLicIngMot[0] ) || ( Z1511EmpLicMotObl != T004E2_A1511EmpLicMotObl[0] ) || ( Z1518EmpBaseOrd != T004E2_A1518EmpBaseOrd[0] ) || ( Z1437EmpBasePromCnt1 != T004E2_A1437EmpBasePromCnt1[0] ) || ( Z1438EmpBasePromCnt2 != T004E2_A1438EmpBasePromCnt2[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1439EmpBasePromTCnt, T004E2_A1439EmpBasePromTCnt[0]) != 0 ) || ( Z2003EmpBaseRelSec != T004E2_A2003EmpBaseRelSec[0] ) )
         {
            if ( DecimalUtil.compareTo(Z1432EmpBasePlus, T004E2_A1432EmpBasePlus[0]) != 0 )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBasePlus");
               GXutil.writeLogRaw("Old: ",Z1432EmpBasePlus);
               GXutil.writeLogRaw("Current: ",T004E2_A1432EmpBasePlus[0]);
            }
            if ( Z1517EmpLicDMin != T004E2_A1517EmpLicDMin[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDMin");
               GXutil.writeLogRaw("Old: ",Z1517EmpLicDMin);
               GXutil.writeLogRaw("Current: ",T004E2_A1517EmpLicDMin[0]);
            }
            if ( Z1502EmpLicDLim != T004E2_A1502EmpLicDLim[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDLim");
               GXutil.writeLogRaw("Old: ",Z1502EmpLicDLim);
               GXutil.writeLogRaw("Current: ",T004E2_A1502EmpLicDLim[0]);
            }
            if ( Z1503EmpLicDSeman != T004E2_A1503EmpLicDSeman[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDSeman");
               GXutil.writeLogRaw("Old: ",Z1503EmpLicDSeman);
               GXutil.writeLogRaw("Current: ",T004E2_A1503EmpLicDSeman[0]);
            }
            if ( Z1504EmpLicDMes != T004E2_A1504EmpLicDMes[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDMes");
               GXutil.writeLogRaw("Old: ",Z1504EmpLicDMes);
               GXutil.writeLogRaw("Current: ",T004E2_A1504EmpLicDMes[0]);
            }
            if ( Z1505EmpLicDSemes != T004E2_A1505EmpLicDSemes[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDSemes");
               GXutil.writeLogRaw("Old: ",Z1505EmpLicDSemes);
               GXutil.writeLogRaw("Current: ",T004E2_A1505EmpLicDSemes[0]);
            }
            if ( Z1506EmpLicDAnual != T004E2_A1506EmpLicDAnual[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicDAnual");
               GXutil.writeLogRaw("Old: ",Z1506EmpLicDAnual);
               GXutil.writeLogRaw("Current: ",T004E2_A1506EmpLicDAnual[0]);
            }
            if ( Z1507EmpLicAdju != T004E2_A1507EmpLicAdju[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicAdju");
               GXutil.writeLogRaw("Old: ",Z1507EmpLicAdju);
               GXutil.writeLogRaw("Current: ",T004E2_A1507EmpLicAdju[0]);
            }
            if ( Z1508EmpLicAdjuObl != T004E2_A1508EmpLicAdjuObl[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicAdjuObl");
               GXutil.writeLogRaw("Old: ",Z1508EmpLicAdjuObl);
               GXutil.writeLogRaw("Current: ",T004E2_A1508EmpLicAdjuObl[0]);
            }
            if ( Z1509EmpLicNecAut != T004E2_A1509EmpLicNecAut[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicNecAut");
               GXutil.writeLogRaw("Old: ",Z1509EmpLicNecAut);
               GXutil.writeLogRaw("Current: ",T004E2_A1509EmpLicNecAut[0]);
            }
            if ( Z1510EmpLicIngMot != T004E2_A1510EmpLicIngMot[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicIngMot");
               GXutil.writeLogRaw("Old: ",Z1510EmpLicIngMot);
               GXutil.writeLogRaw("Current: ",T004E2_A1510EmpLicIngMot[0]);
            }
            if ( Z1511EmpLicMotObl != T004E2_A1511EmpLicMotObl[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpLicMotObl");
               GXutil.writeLogRaw("Old: ",Z1511EmpLicMotObl);
               GXutil.writeLogRaw("Current: ",T004E2_A1511EmpLicMotObl[0]);
            }
            if ( Z1518EmpBaseOrd != T004E2_A1518EmpBaseOrd[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBaseOrd");
               GXutil.writeLogRaw("Old: ",Z1518EmpBaseOrd);
               GXutil.writeLogRaw("Current: ",T004E2_A1518EmpBaseOrd[0]);
            }
            if ( Z1437EmpBasePromCnt1 != T004E2_A1437EmpBasePromCnt1[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBasePromCnt1");
               GXutil.writeLogRaw("Old: ",Z1437EmpBasePromCnt1);
               GXutil.writeLogRaw("Current: ",T004E2_A1437EmpBasePromCnt1[0]);
            }
            if ( Z1438EmpBasePromCnt2 != T004E2_A1438EmpBasePromCnt2[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBasePromCnt2");
               GXutil.writeLogRaw("Old: ",Z1438EmpBasePromCnt2);
               GXutil.writeLogRaw("Current: ",T004E2_A1438EmpBasePromCnt2[0]);
            }
            if ( GXutil.strcmp(Z1439EmpBasePromTCnt, T004E2_A1439EmpBasePromTCnt[0]) != 0 )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBasePromTCnt");
               GXutil.writeLogRaw("Old: ",Z1439EmpBasePromTCnt);
               GXutil.writeLogRaw("Current: ",T004E2_A1439EmpBasePromTCnt[0]);
            }
            if ( Z2003EmpBaseRelSec != T004E2_A2003EmpBaseRelSec[0] )
            {
               GXutil.writeLogln("empresabase_calculo:[seudo value changed for attri]"+"EmpBaseRelSec");
               GXutil.writeLogRaw("Old: ",Z2003EmpBaseRelSec);
               GXutil.writeLogRaw("Current: ",T004E2_A2003EmpBaseRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Empresabase_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert4E191( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         zm4E191( 0) ;
         checkOptimisticConcurrency4E191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4E191( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert4E191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004E10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, A1432EmpBasePlus, Boolean.valueOf(n1517EmpLicDMin), Byte.valueOf(A1517EmpLicDMin), Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Boolean.valueOf(n1518EmpBaseOrd), Short.valueOf(A1518EmpBaseOrd), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
                  if ( (pr_default.getStatus(8) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption4E0( ) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load4E191( ) ;
         }
         endLevel4E191( ) ;
      }
      closeExtendedTableCursors4E191( ) ;
   }

   public void update4E191( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4E191( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm4E191( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate4E191( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004E11 */
                  pr_default.execute(9, new Object[] {A1432EmpBasePlus, Boolean.valueOf(n1517EmpLicDMin), Byte.valueOf(A1517EmpLicDMin), Boolean.valueOf(n1502EmpLicDLim), Short.valueOf(A1502EmpLicDLim), Boolean.valueOf(n1503EmpLicDSeman), Byte.valueOf(A1503EmpLicDSeman), Boolean.valueOf(n1504EmpLicDMes), Byte.valueOf(A1504EmpLicDMes), Boolean.valueOf(n1505EmpLicDSemes), Short.valueOf(A1505EmpLicDSemes), Boolean.valueOf(n1506EmpLicDAnual), Short.valueOf(A1506EmpLicDAnual), Boolean.valueOf(n1507EmpLicAdju), Boolean.valueOf(A1507EmpLicAdju), Boolean.valueOf(n1508EmpLicAdjuObl), Boolean.valueOf(A1508EmpLicAdjuObl), Boolean.valueOf(n1509EmpLicNecAut), Boolean.valueOf(A1509EmpLicNecAut), Boolean.valueOf(n1510EmpLicIngMot), Boolean.valueOf(A1510EmpLicIngMot), Boolean.valueOf(n1511EmpLicMotObl), Boolean.valueOf(A1511EmpLicMotObl), Boolean.valueOf(n1518EmpBaseOrd), Short.valueOf(A1518EmpBaseOrd), Short.valueOf(A1437EmpBasePromCnt1), Short.valueOf(A1438EmpBasePromCnt2), A1439EmpBasePromTCnt, Integer.valueOf(A2003EmpBaseRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Empresabase_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate4E191( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel4E191( ) ;
      }
      closeExtendedTableCursors4E191( ) ;
   }

   public void deferredUpdate4E191( )
   {
   }

   public void delete( )
   {
      beforeValidate4E191( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls4E191( ) ;
         afterConfirm4E191( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete4E191( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004E12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A1427EmpBaseClaseLeg), A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Empresabase_calculo");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
                  if ( AnyError == 0 )
                  {
                     if ( isUpd( ) || isDlt( ) )
                     {
                        if ( AnyError == 0 )
                        {
                           httpContext.nUserReturn = (byte)(1) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode191 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel4E191( ) ;
      Gx_mode = sMode191 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls4E191( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV41Pgmname = "Empresabase_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
         GXt_char10 = A1515EmpBaseC1Txt ;
         GXv_char4[0] = GXt_char10 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
         empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
         A1515EmpBaseC1Txt = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
         GXt_char10 = A1516EmpBaseC2Txt ;
         GXv_char4[0] = GXt_char10 ;
         new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
         empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
         A1516EmpBaseC2Txt = GXt_char10 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      }
   }

   public void endLevel4E191( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete4E191( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "empresabase_calculo");
         if ( AnyError == 0 )
         {
            confirmValues4E0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "empresabase_calculo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart4E191( )
   {
      /* Scan By routine */
      /* Using cursor T004E13 */
      pr_default.execute(11);
      RcdFound191 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A3CliCod = T004E13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004E13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1427EmpBaseClaseLeg = T004E13_A1427EmpBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
         A1429EmpBaseTipo = T004E13_A1429EmpBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = T004E13_A1430EmpBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = T004E13_A1431EmpBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext4E191( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound191 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound191 = (short)(1) ;
         A3CliCod = T004E13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T004E13_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A1427EmpBaseClaseLeg = T004E13_A1427EmpBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
         A1429EmpBaseTipo = T004E13_A1429EmpBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
         A1430EmpBaseCod1 = T004E13_A1430EmpBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
         A1431EmpBaseCod2 = T004E13_A1431EmpBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
   }

   public void scanEnd4E191( )
   {
      pr_default.close(11);
   }

   public void afterConfirm4E191( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert4E191( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate4E191( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete4E191( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete4E191( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate4E191( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes4E191( )
   {
      dynEmpCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynEmpCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynEmpCod.getEnabled(), 5, 0), true);
      cmbEmpBaseClaseLeg.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseClaseLeg.getEnabled(), 5, 0), true);
      cmbEmpBaseTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseTipo.getEnabled(), 5, 0), true);
      cmbEmpBaseCod1.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod1.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod1.getEnabled(), 5, 0), true);
      cmbEmpBaseCod2.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBaseCod2.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBaseCod2.getEnabled(), 5, 0), true);
      edtEmpBasePlus_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePlus_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePlus_Enabled), 5, 0), true);
      edtEmpLicDMin_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDMin_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDMin_Enabled), 5, 0), true);
      edtEmpLicDLim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDLim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDLim_Enabled), 5, 0), true);
      edtEmpLicDSeman_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSeman_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSeman_Enabled), 5, 0), true);
      cmbEmpLicDMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpLicDMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpLicDMes.getEnabled(), 5, 0), true);
      edtEmpLicDSemes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDSemes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDSemes_Enabled), 5, 0), true);
      edtEmpLicDAnual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpLicDAnual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpLicDAnual_Enabled), 5, 0), true);
      chkEmpLicAdju.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpLicAdju.getEnabled(), 5, 0), true);
      chkEmpLicAdjuObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpLicAdjuObl.getEnabled(), 5, 0), true);
      chkEmpLicNecAut.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpLicNecAut.getEnabled(), 5, 0), true);
      chkEmpLicIngMot.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpLicIngMot.getEnabled(), 5, 0), true);
      chkEmpLicMotObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkEmpLicMotObl.getEnabled(), 5, 0), true);
      edtEmpBasePromCnt1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePromCnt1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePromCnt1_Enabled), 5, 0), true);
      edtEmpBasePromCnt2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBasePromCnt2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBasePromCnt2_Enabled), 5, 0), true);
      cmbEmpBasePromTCnt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbEmpBasePromTCnt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbEmpBasePromTCnt.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpBaseOrd_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpBaseOrd_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpBaseOrd_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes4E191( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues4E0( )
   {
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
      MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.empresabase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV10EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV11EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV12EmpBaseCod2))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Empresabase_calculo");
      forbiddenHiddens.add("EmpCod", localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9"));
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("EmpBaseRelSec", localUtil.format( DecimalUtil.doubleToDec(A2003EmpBaseRelSec), "ZZZZZ9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("empresabase_calculo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1427EmpBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( Z1427EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1429EmpBaseTipo", GXutil.rtrim( Z1429EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1430EmpBaseCod1", GXutil.rtrim( Z1430EmpBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1431EmpBaseCod2", GXutil.rtrim( Z1431EmpBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1432EmpBasePlus", GXutil.ltrim( localUtil.ntoc( Z1432EmpBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1517EmpLicDMin", GXutil.ltrim( localUtil.ntoc( Z1517EmpLicDMin, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1502EmpLicDLim", GXutil.ltrim( localUtil.ntoc( Z1502EmpLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1503EmpLicDSeman", GXutil.ltrim( localUtil.ntoc( Z1503EmpLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1504EmpLicDMes", GXutil.ltrim( localUtil.ntoc( Z1504EmpLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1505EmpLicDSemes", GXutil.ltrim( localUtil.ntoc( Z1505EmpLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1506EmpLicDAnual", GXutil.ltrim( localUtil.ntoc( Z1506EmpLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1507EmpLicAdju", Z1507EmpLicAdju);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1508EmpLicAdjuObl", Z1508EmpLicAdjuObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1509EmpLicNecAut", Z1509EmpLicNecAut);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1510EmpLicIngMot", Z1510EmpLicIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1511EmpLicMotObl", Z1511EmpLicMotObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1518EmpBaseOrd", GXutil.ltrim( localUtil.ntoc( Z1518EmpBaseOrd, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1437EmpBasePromCnt1", GXutil.ltrim( localUtil.ntoc( Z1437EmpBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1438EmpBasePromCnt2", GXutil.ltrim( localUtil.ntoc( Z1438EmpBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1439EmpBasePromTCnt", GXutil.rtrim( Z1439EmpBasePromTCnt));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2003EmpBaseRelSec", GXutil.ltrim( localUtil.ntoc( Z2003EmpBaseRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPBASEC2TXT", A1516EmpBaseC2Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "EMPBASEC1TXT", A1515EmpBaseC1Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV9EmpBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV9EmpBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASETIPO", GXutil.rtrim( AV10EmpBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10EmpBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD1", GXutil.rtrim( AV11EmpBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11EmpBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPBASECOD2", GXutil.rtrim( AV12EmpBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12EmpBaseCod2, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPBASERELSEC", GXutil.ltrim( localUtil.ntoc( A2003EmpBaseRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV41Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.empresabase_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV9EmpBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV10EmpBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV11EmpBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV12EmpBaseCod2))}, new String[] {"Gx_mode","CliCod","EmpCod","EmpBaseClaseLeg","EmpBaseTipo","EmpBaseCod1","EmpBaseCod2"})  ;
   }

   public String getPgmname( )
   {
      return "Empresabase_calculo" ;
   }

   public String getPgmdesc( )
   {
      return "" ;
   }

   public void initializeNonKey4E191( )
   {
      A1515EmpBaseC1Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
      A1516EmpBaseC2Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1432EmpBasePlus", GXutil.ltrimstr( A1432EmpBasePlus, 6, 4));
      A1517EmpLicDMin = (byte)(0) ;
      n1517EmpLicDMin = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1517EmpLicDMin", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1517EmpLicDMin), 2, 0));
      n1517EmpLicDMin = ((0==A1517EmpLicDMin) ? true : false) ;
      A1502EmpLicDLim = (short)(0) ;
      n1502EmpLicDLim = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1502EmpLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1502EmpLicDLim), 3, 0));
      n1502EmpLicDLim = ((0==A1502EmpLicDLim) ? true : false) ;
      A1503EmpLicDSeman = (byte)(0) ;
      n1503EmpLicDSeman = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1503EmpLicDSeman", GXutil.str( A1503EmpLicDSeman, 1, 0));
      n1503EmpLicDSeman = ((0==A1503EmpLicDSeman) ? true : false) ;
      A1504EmpLicDMes = (byte)(0) ;
      n1504EmpLicDMes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
      n1504EmpLicDMes = ((0==A1504EmpLicDMes) ? true : false) ;
      A1505EmpLicDSemes = (short)(0) ;
      n1505EmpLicDSemes = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1505EmpLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1505EmpLicDSemes), 3, 0));
      n1505EmpLicDSemes = ((0==A1505EmpLicDSemes) ? true : false) ;
      A1506EmpLicDAnual = (short)(0) ;
      n1506EmpLicDAnual = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1506EmpLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1506EmpLicDAnual), 3, 0));
      n1506EmpLicDAnual = ((0==A1506EmpLicDAnual) ? true : false) ;
      A1507EmpLicAdju = false ;
      n1507EmpLicAdju = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
      n1507EmpLicAdju = ((false==A1507EmpLicAdju) ? true : false) ;
      A1508EmpLicAdjuObl = false ;
      n1508EmpLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
      n1508EmpLicAdjuObl = ((false==A1508EmpLicAdjuObl) ? true : false) ;
      A1509EmpLicNecAut = false ;
      n1509EmpLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
      n1509EmpLicNecAut = ((false==A1509EmpLicNecAut) ? true : false) ;
      A1510EmpLicIngMot = false ;
      n1510EmpLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
      n1510EmpLicIngMot = ((false==A1510EmpLicIngMot) ? true : false) ;
      A1511EmpLicMotObl = false ;
      n1511EmpLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
      n1511EmpLicMotObl = ((false==A1511EmpLicMotObl) ? true : false) ;
      A1518EmpBaseOrd = (short)(0) ;
      n1518EmpBaseOrd = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1518EmpBaseOrd", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1518EmpBaseOrd), 4, 0));
      n1518EmpBaseOrd = ((0==A1518EmpBaseOrd) ? true : false) ;
      A1437EmpBasePromCnt1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1437EmpBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1437EmpBasePromCnt1), 3, 0));
      A1438EmpBasePromCnt2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1438EmpBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1438EmpBasePromCnt2), 3, 0));
      A1439EmpBasePromTCnt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
      A2003EmpBaseRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2003EmpBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2003EmpBaseRelSec), 6, 0));
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1517EmpLicDMin = (byte)(0) ;
      Z1502EmpLicDLim = (short)(0) ;
      Z1503EmpLicDSeman = (byte)(0) ;
      Z1504EmpLicDMes = (byte)(0) ;
      Z1505EmpLicDSemes = (short)(0) ;
      Z1506EmpLicDAnual = (short)(0) ;
      Z1507EmpLicAdju = false ;
      Z1508EmpLicAdjuObl = false ;
      Z1509EmpLicNecAut = false ;
      Z1510EmpLicIngMot = false ;
      Z1511EmpLicMotObl = false ;
      Z1518EmpBaseOrd = (short)(0) ;
      Z1437EmpBasePromCnt1 = (short)(0) ;
      Z1438EmpBasePromCnt2 = (short)(0) ;
      Z1439EmpBasePromTCnt = "" ;
      Z2003EmpBaseRelSec = 0 ;
   }

   public void initAll4E191( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A1427EmpBaseClaseLeg = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      A1429EmpBaseTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      A1430EmpBaseCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      A1431EmpBaseCod2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      initializeNonKey4E191( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251316514213", true, true);
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
      httpContext.AddJavascriptSource("empresabase_calculo.js", "?20251316514214", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynEmpCod.setInternalname( "EMPCOD" );
      cmbEmpBaseClaseLeg.setInternalname( "EMPBASECLASELEG" );
      cmbEmpBaseTipo.setInternalname( "EMPBASETIPO" );
      cmbEmpBaseCod1.setInternalname( "EMPBASECOD1" );
      divEmpbasecod1_cell_Internalname = "EMPBASECOD1_CELL" ;
      cmbEmpBaseCod2.setInternalname( "EMPBASECOD2" );
      divEmpbasecod2_cell_Internalname = "EMPBASECOD2_CELL" ;
      edtEmpBasePlus_Internalname = "EMPBASEPLUS" ;
      divEmpbaseplus_cell_Internalname = "EMPBASEPLUS_CELL" ;
      edtEmpLicDMin_Internalname = "EMPLICDMIN" ;
      divEmplicdmin_cell_Internalname = "EMPLICDMIN_CELL" ;
      edtEmpLicDLim_Internalname = "EMPLICDLIM" ;
      divEmplicdlim_cell_Internalname = "EMPLICDLIM_CELL" ;
      edtEmpLicDSeman_Internalname = "EMPLICDSEMAN" ;
      divEmplicdseman_cell_Internalname = "EMPLICDSEMAN_CELL" ;
      cmbEmpLicDMes.setInternalname( "EMPLICDMES" );
      divEmplicdmes_cell_Internalname = "EMPLICDMES_CELL" ;
      edtEmpLicDSemes_Internalname = "EMPLICDSEMES" ;
      divEmplicdsemes_cell_Internalname = "EMPLICDSEMES_CELL" ;
      edtEmpLicDAnual_Internalname = "EMPLICDANUAL" ;
      divEmplicdanual_cell_Internalname = "EMPLICDANUAL_CELL" ;
      chkEmpLicAdju.setInternalname( "EMPLICADJU" );
      divEmplicadju_cell_Internalname = "EMPLICADJU_CELL" ;
      chkEmpLicAdjuObl.setInternalname( "EMPLICADJUOBL" );
      divEmplicadjuobl_cell_Internalname = "EMPLICADJUOBL_CELL" ;
      chkEmpLicNecAut.setInternalname( "EMPLICNECAUT" );
      divEmplicnecaut_cell_Internalname = "EMPLICNECAUT_CELL" ;
      chkEmpLicIngMot.setInternalname( "EMPLICINGMOT" );
      divEmplicingmot_cell_Internalname = "EMPLICINGMOT_CELL" ;
      chkEmpLicMotObl.setInternalname( "EMPLICMOTOBL" );
      divEmplicmotobl_cell_Internalname = "EMPLICMOTOBL_CELL" ;
      edtEmpBasePromCnt1_Internalname = "EMPBASEPROMCNT1" ;
      edtEmpBasePromCnt2_Internalname = "EMPBASEPROMCNT2" ;
      cmbEmpBasePromTCnt.setInternalname( "EMPBASEPROMTCNT" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpBaseOrd_Internalname = "EMPBASEORD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "" );
      edtEmpBaseOrd_Jsonclick = "" ;
      edtEmpBaseOrd_Enabled = 1 ;
      edtEmpBaseOrd_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbEmpBasePromTCnt.setJsonclick( "" );
      cmbEmpBasePromTCnt.setEnabled( 1 );
      edtEmpBasePromCnt2_Jsonclick = "" ;
      edtEmpBasePromCnt2_Enabled = 1 ;
      edtEmpBasePromCnt1_Jsonclick = "" ;
      edtEmpBasePromCnt1_Enabled = 1 ;
      chkEmpLicMotObl.setEnabled( 1 );
      chkEmpLicMotObl.setVisible( 1 );
      divEmplicmotobl_cell_Class = "col-xs-12" ;
      chkEmpLicIngMot.setEnabled( 1 );
      chkEmpLicIngMot.setVisible( 1 );
      divEmplicingmot_cell_Class = "col-xs-12" ;
      chkEmpLicNecAut.setEnabled( 1 );
      chkEmpLicNecAut.setVisible( 1 );
      divEmplicnecaut_cell_Class = "col-xs-12" ;
      chkEmpLicAdjuObl.setEnabled( 1 );
      chkEmpLicAdjuObl.setVisible( 1 );
      divEmplicadjuobl_cell_Class = "col-xs-12" ;
      chkEmpLicAdju.setEnabled( 1 );
      chkEmpLicAdju.setVisible( 1 );
      divEmplicadju_cell_Class = "col-xs-12" ;
      edtEmpLicDAnual_Jsonclick = "" ;
      edtEmpLicDAnual_Enabled = 1 ;
      edtEmpLicDAnual_Visible = 1 ;
      divEmplicdanual_cell_Class = "col-xs-12" ;
      edtEmpLicDSemes_Jsonclick = "" ;
      edtEmpLicDSemes_Enabled = 1 ;
      edtEmpLicDSemes_Visible = 1 ;
      divEmplicdsemes_cell_Class = "col-xs-12" ;
      cmbEmpLicDMes.setJsonclick( "" );
      cmbEmpLicDMes.setEnabled( 1 );
      cmbEmpLicDMes.setVisible( 1 );
      divEmplicdmes_cell_Class = "col-xs-12" ;
      edtEmpLicDSeman_Jsonclick = "" ;
      edtEmpLicDSeman_Enabled = 1 ;
      edtEmpLicDSeman_Visible = 1 ;
      divEmplicdseman_cell_Class = "col-xs-12" ;
      edtEmpLicDLim_Jsonclick = "" ;
      edtEmpLicDLim_Enabled = 1 ;
      edtEmpLicDLim_Visible = 1 ;
      divEmplicdlim_cell_Class = "col-xs-12" ;
      edtEmpLicDMin_Jsonclick = "" ;
      edtEmpLicDMin_Enabled = 1 ;
      edtEmpLicDMin_Visible = 1 ;
      divEmplicdmin_cell_Class = "col-xs-12" ;
      edtEmpBasePlus_Jsonclick = "" ;
      edtEmpBasePlus_Enabled = 1 ;
      edtEmpBasePlus_Visible = 1 ;
      divEmpbaseplus_cell_Class = "col-xs-12" ;
      cmbEmpBaseCod2.setJsonclick( "" );
      cmbEmpBaseCod2.setEnabled( 1 );
      cmbEmpBaseCod2.setVisible( 1 );
      divEmpbasecod2_cell_Class = "col-xs-12" ;
      cmbEmpBaseCod1.setJsonclick( "" );
      cmbEmpBaseCod1.setEnabled( 1 );
      cmbEmpBaseCod1.setVisible( 1 );
      divEmpbasecod1_cell_Class = "col-xs-12" ;
      cmbEmpBaseTipo.setJsonclick( "" );
      cmbEmpBaseTipo.setEnabled( 1 );
      cmbEmpBaseClaseLeg.setJsonclick( "" );
      cmbEmpBaseClaseLeg.setEnabled( 0 );
      dynEmpCod.setJsonclick( "" );
      dynEmpCod.setEnabled( 0 );
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxdlaempcod4E191( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaempcod_data4E191( AV7CliCod) ;
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

   public void gxaempcod_html4E191( int AV7CliCod )
   {
      short gxdynajaxvalue;
      gxdlaempcod_data4E191( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynEmpCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynEmpCod.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 4, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaempcod_data4E191( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T004E14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004E14_A1EmpCod[0], (byte)(4), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004E14_A2EmpNom[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx4asaempbasec2txt4E191( int A3CliCod ,
                                        String A1429EmpBaseTipo ,
                                        String A1430EmpBaseCod1 ,
                                        String A1431EmpBaseCod2 )
   {
      GXt_char10 = A1516EmpBaseC2Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1516EmpBaseC2Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1516EmpBaseC2Txt)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx5asaempbasec1txt4E191( int A3CliCod ,
                                        String A1429EmpBaseTipo ,
                                        String A1430EmpBaseCod1 )
   {
      GXt_char10 = A1515EmpBaseC1Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1515EmpBaseC1Txt = GXt_char10 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1515EmpBaseC1Txt)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx8asaclicod4E191( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int8 = A3CliCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
            empresabase_calculo_impl.this.GXt_int8 = GXv_int9[0] ;
            A3CliCod = GXt_int8 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void init_web_controls( )
   {
      dynEmpCod.setName( "EMPCOD" );
      dynEmpCod.setWebtags( "" );
      cmbEmpBaseClaseLeg.setName( "EMPBASECLASELEG" );
      cmbEmpBaseClaseLeg.setWebtags( "" );
      cmbEmpBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbEmpBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1427EmpBaseClaseLeg", GXutil.str( A1427EmpBaseClaseLeg, 1, 0));
      }
      cmbEmpBaseTipo.setName( "EMPBASETIPO" );
      cmbEmpBaseTipo.setWebtags( "" );
      cmbEmpBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbEmpBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbEmpBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
         A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1429EmpBaseTipo", A1429EmpBaseTipo);
      }
      cmbEmpBaseCod1.setName( "EMPBASECOD1" );
      cmbEmpBaseCod1.setWebtags( "" );
      if ( cmbEmpBaseCod1.getItemCount() > 0 )
      {
         A1430EmpBaseCod1 = cmbEmpBaseCod1.getValidValue(A1430EmpBaseCod1) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1430EmpBaseCod1", A1430EmpBaseCod1);
      }
      cmbEmpBaseCod2.setName( "EMPBASECOD2" );
      cmbEmpBaseCod2.setWebtags( "" );
      if ( cmbEmpBaseCod2.getItemCount() > 0 )
      {
         A1431EmpBaseCod2 = cmbEmpBaseCod2.getValidValue(A1431EmpBaseCod2) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1431EmpBaseCod2", A1431EmpBaseCod2);
      }
      cmbEmpLicDMes.setName( "EMPLICDMES" );
      cmbEmpLicDMes.setWebtags( "" );
      if ( cmbEmpLicDMes.getItemCount() > 0 )
      {
         A1504EmpLicDMes = (byte)(GXutil.lval( cmbEmpLicDMes.getValidValue(GXutil.trim( GXutil.str( A1504EmpLicDMes, 2, 0))))) ;
         n1504EmpLicDMes = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1504EmpLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1504EmpLicDMes), 2, 0));
      }
      chkEmpLicAdju.setName( "EMPLICADJU" );
      chkEmpLicAdju.setWebtags( "" );
      chkEmpLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdju.getInternalname(), "TitleCaption", chkEmpLicAdju.getCaption(), true);
      chkEmpLicAdju.setCheckedValue( "false" );
      A1507EmpLicAdju = GXutil.strtobool( GXutil.booltostr( A1507EmpLicAdju)) ;
      n1507EmpLicAdju = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1507EmpLicAdju", A1507EmpLicAdju);
      chkEmpLicAdjuObl.setName( "EMPLICADJUOBL" );
      chkEmpLicAdjuObl.setWebtags( "" );
      chkEmpLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicAdjuObl.getInternalname(), "TitleCaption", chkEmpLicAdjuObl.getCaption(), true);
      chkEmpLicAdjuObl.setCheckedValue( "false" );
      A1508EmpLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1508EmpLicAdjuObl)) ;
      n1508EmpLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1508EmpLicAdjuObl", A1508EmpLicAdjuObl);
      chkEmpLicNecAut.setName( "EMPLICNECAUT" );
      chkEmpLicNecAut.setWebtags( "" );
      chkEmpLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicNecAut.getInternalname(), "TitleCaption", chkEmpLicNecAut.getCaption(), true);
      chkEmpLicNecAut.setCheckedValue( "false" );
      A1509EmpLicNecAut = GXutil.strtobool( GXutil.booltostr( A1509EmpLicNecAut)) ;
      n1509EmpLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1509EmpLicNecAut", A1509EmpLicNecAut);
      chkEmpLicIngMot.setName( "EMPLICINGMOT" );
      chkEmpLicIngMot.setWebtags( "" );
      chkEmpLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicIngMot.getInternalname(), "TitleCaption", chkEmpLicIngMot.getCaption(), true);
      chkEmpLicIngMot.setCheckedValue( "false" );
      A1510EmpLicIngMot = GXutil.strtobool( GXutil.booltostr( A1510EmpLicIngMot)) ;
      n1510EmpLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1510EmpLicIngMot", A1510EmpLicIngMot);
      chkEmpLicMotObl.setName( "EMPLICMOTOBL" );
      chkEmpLicMotObl.setWebtags( "" );
      chkEmpLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkEmpLicMotObl.getInternalname(), "TitleCaption", chkEmpLicMotObl.getCaption(), true);
      chkEmpLicMotObl.setCheckedValue( "false" );
      A1511EmpLicMotObl = GXutil.strtobool( GXutil.booltostr( A1511EmpLicMotObl)) ;
      n1511EmpLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1511EmpLicMotObl", A1511EmpLicMotObl);
      cmbEmpBasePromTCnt.setName( "EMPBASEPROMTCNT" );
      cmbEmpBasePromTCnt.setWebtags( "" );
      cmbEmpBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbEmpBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbEmpBasePromTCnt.getItemCount() > 0 )
      {
         A1439EmpBasePromTCnt = cmbEmpBasePromTCnt.getValidValue(A1439EmpBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1439EmpBasePromTCnt", A1439EmpBasePromTCnt);
      }
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Clicod( )
   {
      A1429EmpBaseTipo = cmbEmpBaseTipo.getValue() ;
      A1430EmpBaseCod1 = cmbEmpBaseCod1.getValue() ;
      A1431EmpBaseCod2 = cmbEmpBaseCod2.getValue() ;
      A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValue())) ;
      /* Using cursor T004E15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      GXt_char10 = A1516EmpBaseC2Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod2(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, A1431EmpBaseCod2, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1516EmpBaseC2Txt = GXt_char10 ;
      GXt_char10 = A1515EmpBaseC1Txt ;
      GXv_char4[0] = GXt_char10 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1429EmpBaseTipo, A1430EmpBaseCod1, GXv_char4) ;
      empresabase_calculo_impl.this.GXt_char10 = GXv_char4[0] ;
      A1515EmpBaseC1Txt = GXt_char10 ;
      dynload_actions( ) ;
      if ( dynEmpCod.getItemCount() > 0 )
      {
         A1EmpCod = (short)(GXutil.lval( dynEmpCod.getValidValue(GXutil.trim( GXutil.str( A1EmpCod, 4, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynEmpCod.setValue( GXutil.trim( GXutil.str( A1EmpCod, 4, 0)) );
      }
      if ( cmbEmpBaseClaseLeg.getItemCount() > 0 )
      {
         A1427EmpBaseClaseLeg = (byte)(GXutil.lval( cmbEmpBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1427EmpBaseClaseLeg, 1, 0)) );
      }
      if ( cmbEmpBaseTipo.getItemCount() > 0 )
      {
         A1429EmpBaseTipo = cmbEmpBaseTipo.getValidValue(A1429EmpBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseTipo.setValue( GXutil.rtrim( A1429EmpBaseTipo) );
      }
      if ( cmbEmpBaseCod1.getItemCount() > 0 )
      {
         A1430EmpBaseCod1 = cmbEmpBaseCod1.getValidValue(A1430EmpBaseCod1) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod1.setValue( GXutil.rtrim( A1430EmpBaseCod1) );
      }
      if ( cmbEmpBaseCod2.getItemCount() > 0 )
      {
         A1431EmpBaseCod2 = cmbEmpBaseCod2.getValidValue(A1431EmpBaseCod2) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbEmpBaseCod2.setValue( GXutil.rtrim( A1431EmpBaseCod2) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1516EmpBaseC2Txt", A1516EmpBaseC2Txt);
      httpContext.ajax_rsp_assign_attri("", false, "A1515EmpBaseC1Txt", A1515EmpBaseC1Txt);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV10EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV11EmpBaseCod1',fld:'vEMPBASECOD1',pic:'',hsh:true},{av:'AV12EmpBaseCod2',fld:'vEMPBASECOD2',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV9EmpBaseClaseLeg',fld:'vEMPBASECLASELEG',pic:'9',hsh:true},{av:'AV10EmpBaseTipo',fld:'vEMPBASETIPO',pic:'',hsh:true},{av:'AV11EmpBaseCod1',fld:'vEMPBASECOD1',pic:'',hsh:true},{av:'AV12EmpBaseCod2',fld:'vEMPBASECOD2',pic:'',hsh:true},{av:'A2003EmpBaseRelSec',fld:'EMPBASERELSEC',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e124E2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPBASECLASELEG","{handler:'valid_Empbaseclaseleg',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPBASECLASELEG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPBASETIPO","{handler:'valid_Empbasetipo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPBASETIPO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPBASECOD1","{handler:'valid_Empbasecod1',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPBASECOD1",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPBASECOD2","{handler:'valid_Empbasecod2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPBASECOD2",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_EMPBASEPROMTCNT","{handler:'valid_Empbasepromtcnt',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_EMPBASEPROMTCNT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'cmbEmpBaseTipo'},{av:'A1429EmpBaseTipo',fld:'EMPBASETIPO',pic:''},{av:'cmbEmpBaseCod1'},{av:'A1430EmpBaseCod1',fld:'EMPBASECOD1',pic:''},{av:'cmbEmpBaseCod2'},{av:'A1431EmpBaseCod2',fld:'EMPBASECOD2',pic:''},{av:'A1516EmpBaseC2Txt',fld:'EMPBASEC2TXT',pic:''},{av:'A1515EmpBaseC1Txt',fld:'EMPBASEC1TXT',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1516EmpBaseC2Txt',fld:'EMPBASEC2TXT',pic:''},{av:'A1515EmpBaseC1Txt',fld:'EMPBASEC1TXT',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynEmpCod'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A1507EmpLicAdju',fld:'EMPLICADJU',pic:''},{av:'A1508EmpLicAdjuObl',fld:'EMPLICADJUOBL',pic:''},{av:'A1509EmpLicNecAut',fld:'EMPLICNECAUT',pic:''},{av:'A1510EmpLicIngMot',fld:'EMPLICINGMOT',pic:''},{av:'A1511EmpLicMotObl',fld:'EMPLICMOTOBL',pic:''}]}");
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
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV10EmpBaseTipo = "" ;
      wcpOAV11EmpBaseCod1 = "" ;
      wcpOAV12EmpBaseCod2 = "" ;
      Z1429EmpBaseTipo = "" ;
      Z1430EmpBaseCod1 = "" ;
      Z1431EmpBaseCod2 = "" ;
      Z1432EmpBasePlus = DecimalUtil.ZERO ;
      Z1439EmpBasePromTCnt = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1429EmpBaseTipo = "" ;
      A1430EmpBaseCod1 = "" ;
      A1431EmpBaseCod2 = "" ;
      Gx_mode = "" ;
      AV10EmpBaseTipo = "" ;
      AV11EmpBaseCod1 = "" ;
      AV12EmpBaseCod2 = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1439EmpBasePromTCnt = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1432EmpBasePlus = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A1516EmpBaseC2Txt = "" ;
      A1515EmpBaseC1Txt = "" ;
      AV41Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode191 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXv_int2 = new short[1] ;
      AV37collection_EmpBaseCod1 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char3 = new GXSimpleCollection[1] ;
      AV39SitCodigo = "" ;
      AV40SitDescrip = "" ;
      AV13WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext5 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV16TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV17WebSession = httpContext.getWebSession();
      T004E5_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E5_A1429EmpBaseTipo = new String[] {""} ;
      T004E5_A1430EmpBaseCod1 = new String[] {""} ;
      T004E5_A1431EmpBaseCod2 = new String[] {""} ;
      T004E5_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004E5_A1517EmpLicDMin = new byte[1] ;
      T004E5_n1517EmpLicDMin = new boolean[] {false} ;
      T004E5_A1502EmpLicDLim = new short[1] ;
      T004E5_n1502EmpLicDLim = new boolean[] {false} ;
      T004E5_A1503EmpLicDSeman = new byte[1] ;
      T004E5_n1503EmpLicDSeman = new boolean[] {false} ;
      T004E5_A1504EmpLicDMes = new byte[1] ;
      T004E5_n1504EmpLicDMes = new boolean[] {false} ;
      T004E5_A1505EmpLicDSemes = new short[1] ;
      T004E5_n1505EmpLicDSemes = new boolean[] {false} ;
      T004E5_A1506EmpLicDAnual = new short[1] ;
      T004E5_n1506EmpLicDAnual = new boolean[] {false} ;
      T004E5_A1507EmpLicAdju = new boolean[] {false} ;
      T004E5_n1507EmpLicAdju = new boolean[] {false} ;
      T004E5_A1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E5_n1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E5_A1509EmpLicNecAut = new boolean[] {false} ;
      T004E5_n1509EmpLicNecAut = new boolean[] {false} ;
      T004E5_A1510EmpLicIngMot = new boolean[] {false} ;
      T004E5_n1510EmpLicIngMot = new boolean[] {false} ;
      T004E5_A1511EmpLicMotObl = new boolean[] {false} ;
      T004E5_n1511EmpLicMotObl = new boolean[] {false} ;
      T004E5_A1518EmpBaseOrd = new short[1] ;
      T004E5_n1518EmpBaseOrd = new boolean[] {false} ;
      T004E5_A1437EmpBasePromCnt1 = new short[1] ;
      T004E5_A1438EmpBasePromCnt2 = new short[1] ;
      T004E5_A1439EmpBasePromTCnt = new String[] {""} ;
      T004E5_A2003EmpBaseRelSec = new int[1] ;
      T004E5_A3CliCod = new int[1] ;
      T004E5_A1EmpCod = new short[1] ;
      T004E4_A3CliCod = new int[1] ;
      T004E6_A3CliCod = new int[1] ;
      T004E7_A3CliCod = new int[1] ;
      T004E7_A1EmpCod = new short[1] ;
      T004E7_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E7_A1429EmpBaseTipo = new String[] {""} ;
      T004E7_A1430EmpBaseCod1 = new String[] {""} ;
      T004E7_A1431EmpBaseCod2 = new String[] {""} ;
      T004E3_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E3_A1429EmpBaseTipo = new String[] {""} ;
      T004E3_A1430EmpBaseCod1 = new String[] {""} ;
      T004E3_A1431EmpBaseCod2 = new String[] {""} ;
      T004E3_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004E3_A1517EmpLicDMin = new byte[1] ;
      T004E3_n1517EmpLicDMin = new boolean[] {false} ;
      T004E3_A1502EmpLicDLim = new short[1] ;
      T004E3_n1502EmpLicDLim = new boolean[] {false} ;
      T004E3_A1503EmpLicDSeman = new byte[1] ;
      T004E3_n1503EmpLicDSeman = new boolean[] {false} ;
      T004E3_A1504EmpLicDMes = new byte[1] ;
      T004E3_n1504EmpLicDMes = new boolean[] {false} ;
      T004E3_A1505EmpLicDSemes = new short[1] ;
      T004E3_n1505EmpLicDSemes = new boolean[] {false} ;
      T004E3_A1506EmpLicDAnual = new short[1] ;
      T004E3_n1506EmpLicDAnual = new boolean[] {false} ;
      T004E3_A1507EmpLicAdju = new boolean[] {false} ;
      T004E3_n1507EmpLicAdju = new boolean[] {false} ;
      T004E3_A1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E3_n1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E3_A1509EmpLicNecAut = new boolean[] {false} ;
      T004E3_n1509EmpLicNecAut = new boolean[] {false} ;
      T004E3_A1510EmpLicIngMot = new boolean[] {false} ;
      T004E3_n1510EmpLicIngMot = new boolean[] {false} ;
      T004E3_A1511EmpLicMotObl = new boolean[] {false} ;
      T004E3_n1511EmpLicMotObl = new boolean[] {false} ;
      T004E3_A1518EmpBaseOrd = new short[1] ;
      T004E3_n1518EmpBaseOrd = new boolean[] {false} ;
      T004E3_A1437EmpBasePromCnt1 = new short[1] ;
      T004E3_A1438EmpBasePromCnt2 = new short[1] ;
      T004E3_A1439EmpBasePromTCnt = new String[] {""} ;
      T004E3_A2003EmpBaseRelSec = new int[1] ;
      T004E3_A3CliCod = new int[1] ;
      T004E3_A1EmpCod = new short[1] ;
      T004E8_A3CliCod = new int[1] ;
      T004E8_A1EmpCod = new short[1] ;
      T004E8_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E8_A1429EmpBaseTipo = new String[] {""} ;
      T004E8_A1430EmpBaseCod1 = new String[] {""} ;
      T004E8_A1431EmpBaseCod2 = new String[] {""} ;
      T004E9_A3CliCod = new int[1] ;
      T004E9_A1EmpCod = new short[1] ;
      T004E9_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E9_A1429EmpBaseTipo = new String[] {""} ;
      T004E9_A1430EmpBaseCod1 = new String[] {""} ;
      T004E9_A1431EmpBaseCod2 = new String[] {""} ;
      T004E2_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E2_A1429EmpBaseTipo = new String[] {""} ;
      T004E2_A1430EmpBaseCod1 = new String[] {""} ;
      T004E2_A1431EmpBaseCod2 = new String[] {""} ;
      T004E2_A1432EmpBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T004E2_A1517EmpLicDMin = new byte[1] ;
      T004E2_n1517EmpLicDMin = new boolean[] {false} ;
      T004E2_A1502EmpLicDLim = new short[1] ;
      T004E2_n1502EmpLicDLim = new boolean[] {false} ;
      T004E2_A1503EmpLicDSeman = new byte[1] ;
      T004E2_n1503EmpLicDSeman = new boolean[] {false} ;
      T004E2_A1504EmpLicDMes = new byte[1] ;
      T004E2_n1504EmpLicDMes = new boolean[] {false} ;
      T004E2_A1505EmpLicDSemes = new short[1] ;
      T004E2_n1505EmpLicDSemes = new boolean[] {false} ;
      T004E2_A1506EmpLicDAnual = new short[1] ;
      T004E2_n1506EmpLicDAnual = new boolean[] {false} ;
      T004E2_A1507EmpLicAdju = new boolean[] {false} ;
      T004E2_n1507EmpLicAdju = new boolean[] {false} ;
      T004E2_A1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E2_n1508EmpLicAdjuObl = new boolean[] {false} ;
      T004E2_A1509EmpLicNecAut = new boolean[] {false} ;
      T004E2_n1509EmpLicNecAut = new boolean[] {false} ;
      T004E2_A1510EmpLicIngMot = new boolean[] {false} ;
      T004E2_n1510EmpLicIngMot = new boolean[] {false} ;
      T004E2_A1511EmpLicMotObl = new boolean[] {false} ;
      T004E2_n1511EmpLicMotObl = new boolean[] {false} ;
      T004E2_A1518EmpBaseOrd = new short[1] ;
      T004E2_n1518EmpBaseOrd = new boolean[] {false} ;
      T004E2_A1437EmpBasePromCnt1 = new short[1] ;
      T004E2_A1438EmpBasePromCnt2 = new short[1] ;
      T004E2_A1439EmpBasePromTCnt = new String[] {""} ;
      T004E2_A2003EmpBaseRelSec = new int[1] ;
      T004E2_A3CliCod = new int[1] ;
      T004E2_A1EmpCod = new short[1] ;
      T004E13_A3CliCod = new int[1] ;
      T004E13_A1EmpCod = new short[1] ;
      T004E13_A1427EmpBaseClaseLeg = new byte[1] ;
      T004E13_A1429EmpBaseTipo = new String[] {""} ;
      T004E13_A1430EmpBaseCod1 = new String[] {""} ;
      T004E13_A1431EmpBaseCod2 = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004E14_A3CliCod = new int[1] ;
      T004E14_A1EmpCod = new short[1] ;
      T004E14_A2EmpNom = new String[] {""} ;
      GXv_int9 = new int[1] ;
      T004E15_A3CliCod = new int[1] ;
      GXt_char10 = "" ;
      GXv_char4 = new String[1] ;
      Z1516EmpBaseC2Txt = "" ;
      Z1515EmpBaseC1Txt = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresabase_calculo__default(),
         new Object[] {
             new Object[] {
            T004E2_A1427EmpBaseClaseLeg, T004E2_A1429EmpBaseTipo, T004E2_A1430EmpBaseCod1, T004E2_A1431EmpBaseCod2, T004E2_A1432EmpBasePlus, T004E2_A1517EmpLicDMin, T004E2_n1517EmpLicDMin, T004E2_A1502EmpLicDLim, T004E2_n1502EmpLicDLim, T004E2_A1503EmpLicDSeman,
            T004E2_n1503EmpLicDSeman, T004E2_A1504EmpLicDMes, T004E2_n1504EmpLicDMes, T004E2_A1505EmpLicDSemes, T004E2_n1505EmpLicDSemes, T004E2_A1506EmpLicDAnual, T004E2_n1506EmpLicDAnual, T004E2_A1507EmpLicAdju, T004E2_n1507EmpLicAdju, T004E2_A1508EmpLicAdjuObl,
            T004E2_n1508EmpLicAdjuObl, T004E2_A1509EmpLicNecAut, T004E2_n1509EmpLicNecAut, T004E2_A1510EmpLicIngMot, T004E2_n1510EmpLicIngMot, T004E2_A1511EmpLicMotObl, T004E2_n1511EmpLicMotObl, T004E2_A1518EmpBaseOrd, T004E2_n1518EmpBaseOrd, T004E2_A1437EmpBasePromCnt1,
            T004E2_A1438EmpBasePromCnt2, T004E2_A1439EmpBasePromTCnt, T004E2_A2003EmpBaseRelSec, T004E2_A3CliCod, T004E2_A1EmpCod
            }
            , new Object[] {
            T004E3_A1427EmpBaseClaseLeg, T004E3_A1429EmpBaseTipo, T004E3_A1430EmpBaseCod1, T004E3_A1431EmpBaseCod2, T004E3_A1432EmpBasePlus, T004E3_A1517EmpLicDMin, T004E3_n1517EmpLicDMin, T004E3_A1502EmpLicDLim, T004E3_n1502EmpLicDLim, T004E3_A1503EmpLicDSeman,
            T004E3_n1503EmpLicDSeman, T004E3_A1504EmpLicDMes, T004E3_n1504EmpLicDMes, T004E3_A1505EmpLicDSemes, T004E3_n1505EmpLicDSemes, T004E3_A1506EmpLicDAnual, T004E3_n1506EmpLicDAnual, T004E3_A1507EmpLicAdju, T004E3_n1507EmpLicAdju, T004E3_A1508EmpLicAdjuObl,
            T004E3_n1508EmpLicAdjuObl, T004E3_A1509EmpLicNecAut, T004E3_n1509EmpLicNecAut, T004E3_A1510EmpLicIngMot, T004E3_n1510EmpLicIngMot, T004E3_A1511EmpLicMotObl, T004E3_n1511EmpLicMotObl, T004E3_A1518EmpBaseOrd, T004E3_n1518EmpBaseOrd, T004E3_A1437EmpBasePromCnt1,
            T004E3_A1438EmpBasePromCnt2, T004E3_A1439EmpBasePromTCnt, T004E3_A2003EmpBaseRelSec, T004E3_A3CliCod, T004E3_A1EmpCod
            }
            , new Object[] {
            T004E4_A3CliCod
            }
            , new Object[] {
            T004E5_A1427EmpBaseClaseLeg, T004E5_A1429EmpBaseTipo, T004E5_A1430EmpBaseCod1, T004E5_A1431EmpBaseCod2, T004E5_A1432EmpBasePlus, T004E5_A1517EmpLicDMin, T004E5_n1517EmpLicDMin, T004E5_A1502EmpLicDLim, T004E5_n1502EmpLicDLim, T004E5_A1503EmpLicDSeman,
            T004E5_n1503EmpLicDSeman, T004E5_A1504EmpLicDMes, T004E5_n1504EmpLicDMes, T004E5_A1505EmpLicDSemes, T004E5_n1505EmpLicDSemes, T004E5_A1506EmpLicDAnual, T004E5_n1506EmpLicDAnual, T004E5_A1507EmpLicAdju, T004E5_n1507EmpLicAdju, T004E5_A1508EmpLicAdjuObl,
            T004E5_n1508EmpLicAdjuObl, T004E5_A1509EmpLicNecAut, T004E5_n1509EmpLicNecAut, T004E5_A1510EmpLicIngMot, T004E5_n1510EmpLicIngMot, T004E5_A1511EmpLicMotObl, T004E5_n1511EmpLicMotObl, T004E5_A1518EmpBaseOrd, T004E5_n1518EmpBaseOrd, T004E5_A1437EmpBasePromCnt1,
            T004E5_A1438EmpBasePromCnt2, T004E5_A1439EmpBasePromTCnt, T004E5_A2003EmpBaseRelSec, T004E5_A3CliCod, T004E5_A1EmpCod
            }
            , new Object[] {
            T004E6_A3CliCod
            }
            , new Object[] {
            T004E7_A3CliCod, T004E7_A1EmpCod, T004E7_A1427EmpBaseClaseLeg, T004E7_A1429EmpBaseTipo, T004E7_A1430EmpBaseCod1, T004E7_A1431EmpBaseCod2
            }
            , new Object[] {
            T004E8_A3CliCod, T004E8_A1EmpCod, T004E8_A1427EmpBaseClaseLeg, T004E8_A1429EmpBaseTipo, T004E8_A1430EmpBaseCod1, T004E8_A1431EmpBaseCod2
            }
            , new Object[] {
            T004E9_A3CliCod, T004E9_A1EmpCod, T004E9_A1427EmpBaseClaseLeg, T004E9_A1429EmpBaseTipo, T004E9_A1430EmpBaseCod1, T004E9_A1431EmpBaseCod2
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004E13_A3CliCod, T004E13_A1EmpCod, T004E13_A1427EmpBaseClaseLeg, T004E13_A1429EmpBaseTipo, T004E13_A1430EmpBaseCod1, T004E13_A1431EmpBaseCod2
            }
            , new Object[] {
            T004E14_A3CliCod, T004E14_A1EmpCod, T004E14_A2EmpNom
            }
            , new Object[] {
            T004E15_A3CliCod
            }
         }
      );
      AV41Pgmname = "Empresabase_calculo" ;
   }

   private byte wcpOAV9EmpBaseClaseLeg ;
   private byte Z1427EmpBaseClaseLeg ;
   private byte Z1517EmpLicDMin ;
   private byte Z1503EmpLicDSeman ;
   private byte Z1504EmpLicDMes ;
   private byte GxWebError ;
   private byte AV9EmpBaseClaseLeg ;
   private byte nKeyPressed ;
   private byte A1427EmpBaseClaseLeg ;
   private byte A1504EmpLicDMes ;
   private byte A1517EmpLicDMin ;
   private byte A1503EmpLicDSeman ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8EmpCod ;
   private short Z1EmpCod ;
   private short Z1502EmpLicDLim ;
   private short Z1505EmpLicDSemes ;
   private short Z1506EmpLicDAnual ;
   private short Z1518EmpBaseOrd ;
   private short Z1437EmpBasePromCnt1 ;
   private short Z1438EmpBasePromCnt2 ;
   private short A1EmpCod ;
   private short AV8EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1502EmpLicDLim ;
   private short A1505EmpLicDSemes ;
   private short A1506EmpLicDAnual ;
   private short A1437EmpBasePromCnt1 ;
   private short A1438EmpBasePromCnt2 ;
   private short A1518EmpBaseOrd ;
   private short RcdFound191 ;
   private short AV20PaiCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV38i ;
   private short nIsDirty_191 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2003EmpBaseRelSec ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtEmpBasePlus_Visible ;
   private int edtEmpBasePlus_Enabled ;
   private int edtEmpLicDMin_Visible ;
   private int edtEmpLicDMin_Enabled ;
   private int edtEmpLicDLim_Visible ;
   private int edtEmpLicDLim_Enabled ;
   private int edtEmpLicDSeman_Visible ;
   private int edtEmpLicDSeman_Enabled ;
   private int edtEmpLicDSemes_Visible ;
   private int edtEmpLicDSemes_Enabled ;
   private int edtEmpLicDAnual_Visible ;
   private int edtEmpLicDAnual_Enabled ;
   private int edtEmpBasePromCnt1_Enabled ;
   private int edtEmpBasePromCnt2_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpBaseOrd_Enabled ;
   private int edtEmpBaseOrd_Visible ;
   private int A2003EmpBaseRelSec ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int8 ;
   private int GXv_int9[] ;
   private java.math.BigDecimal Z1432EmpBasePlus ;
   private java.math.BigDecimal A1432EmpBasePlus ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV10EmpBaseTipo ;
   private String wcpOAV11EmpBaseCod1 ;
   private String wcpOAV12EmpBaseCod2 ;
   private String Z1429EmpBaseTipo ;
   private String Z1430EmpBaseCod1 ;
   private String Z1431EmpBaseCod2 ;
   private String Z1439EmpBasePromTCnt ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1429EmpBaseTipo ;
   private String A1430EmpBaseCod1 ;
   private String A1431EmpBaseCod2 ;
   private String Gx_mode ;
   private String AV10EmpBaseTipo ;
   private String AV11EmpBaseCod1 ;
   private String AV12EmpBaseCod2 ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A1439EmpBasePromTCnt ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String divEmpbasecod1_cell_Internalname ;
   private String divEmpbasecod1_cell_Class ;
   private String divEmpbasecod2_cell_Internalname ;
   private String divEmpbasecod2_cell_Class ;
   private String divEmpbaseplus_cell_Internalname ;
   private String divEmpbaseplus_cell_Class ;
   private String edtEmpBasePlus_Internalname ;
   private String edtEmpBasePlus_Jsonclick ;
   private String divEmplicdmin_cell_Internalname ;
   private String divEmplicdmin_cell_Class ;
   private String edtEmpLicDMin_Internalname ;
   private String edtEmpLicDMin_Jsonclick ;
   private String divEmplicdlim_cell_Internalname ;
   private String divEmplicdlim_cell_Class ;
   private String edtEmpLicDLim_Internalname ;
   private String edtEmpLicDLim_Jsonclick ;
   private String divEmplicdseman_cell_Internalname ;
   private String divEmplicdseman_cell_Class ;
   private String edtEmpLicDSeman_Internalname ;
   private String edtEmpLicDSeman_Jsonclick ;
   private String divEmplicdmes_cell_Internalname ;
   private String divEmplicdmes_cell_Class ;
   private String divEmplicdsemes_cell_Internalname ;
   private String divEmplicdsemes_cell_Class ;
   private String edtEmpLicDSemes_Internalname ;
   private String edtEmpLicDSemes_Jsonclick ;
   private String divEmplicdanual_cell_Internalname ;
   private String divEmplicdanual_cell_Class ;
   private String edtEmpLicDAnual_Internalname ;
   private String edtEmpLicDAnual_Jsonclick ;
   private String divEmplicadju_cell_Internalname ;
   private String divEmplicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divEmplicadjuobl_cell_Internalname ;
   private String divEmplicadjuobl_cell_Class ;
   private String divEmplicnecaut_cell_Internalname ;
   private String divEmplicnecaut_cell_Class ;
   private String divEmplicingmot_cell_Internalname ;
   private String divEmplicingmot_cell_Class ;
   private String divEmplicmotobl_cell_Internalname ;
   private String divEmplicmotobl_cell_Class ;
   private String edtEmpBasePromCnt1_Internalname ;
   private String edtEmpBasePromCnt1_Jsonclick ;
   private String edtEmpBasePromCnt2_Internalname ;
   private String edtEmpBasePromCnt2_Jsonclick ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpBaseOrd_Internalname ;
   private String edtEmpBaseOrd_Jsonclick ;
   private String AV41Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode191 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String AV39SitCodigo ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String GXt_char10 ;
   private String GXv_char4[] ;
   private boolean Z1507EmpLicAdju ;
   private boolean Z1508EmpLicAdjuObl ;
   private boolean Z1509EmpLicNecAut ;
   private boolean Z1510EmpLicIngMot ;
   private boolean Z1511EmpLicMotObl ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean n1504EmpLicDMes ;
   private boolean A1507EmpLicAdju ;
   private boolean n1507EmpLicAdju ;
   private boolean A1508EmpLicAdjuObl ;
   private boolean n1508EmpLicAdjuObl ;
   private boolean A1509EmpLicNecAut ;
   private boolean n1509EmpLicNecAut ;
   private boolean A1510EmpLicIngMot ;
   private boolean n1510EmpLicIngMot ;
   private boolean A1511EmpLicMotObl ;
   private boolean n1511EmpLicMotObl ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n1517EmpLicDMin ;
   private boolean n1502EmpLicDLim ;
   private boolean n1503EmpLicDSeman ;
   private boolean n1505EmpLicDSemes ;
   private boolean n1506EmpLicDAnual ;
   private boolean n1518EmpBaseOrd ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV14IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private String A1516EmpBaseC2Txt ;
   private String A1515EmpBaseC1Txt ;
   private String AV40SitDescrip ;
   private String Z1516EmpBaseC2Txt ;
   private String Z1515EmpBaseC1Txt ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV17WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynEmpCod ;
   private HTMLChoice cmbEmpBaseClaseLeg ;
   private HTMLChoice cmbEmpBaseTipo ;
   private HTMLChoice cmbEmpBaseCod1 ;
   private HTMLChoice cmbEmpBaseCod2 ;
   private HTMLChoice cmbEmpLicDMes ;
   private ICheckbox chkEmpLicAdju ;
   private ICheckbox chkEmpLicAdjuObl ;
   private ICheckbox chkEmpLicNecAut ;
   private ICheckbox chkEmpLicIngMot ;
   private ICheckbox chkEmpLicMotObl ;
   private HTMLChoice cmbEmpBasePromTCnt ;
   private IDataStoreProvider pr_default ;
   private byte[] T004E5_A1427EmpBaseClaseLeg ;
   private String[] T004E5_A1429EmpBaseTipo ;
   private String[] T004E5_A1430EmpBaseCod1 ;
   private String[] T004E5_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] T004E5_A1432EmpBasePlus ;
   private byte[] T004E5_A1517EmpLicDMin ;
   private boolean[] T004E5_n1517EmpLicDMin ;
   private short[] T004E5_A1502EmpLicDLim ;
   private boolean[] T004E5_n1502EmpLicDLim ;
   private byte[] T004E5_A1503EmpLicDSeman ;
   private boolean[] T004E5_n1503EmpLicDSeman ;
   private byte[] T004E5_A1504EmpLicDMes ;
   private boolean[] T004E5_n1504EmpLicDMes ;
   private short[] T004E5_A1505EmpLicDSemes ;
   private boolean[] T004E5_n1505EmpLicDSemes ;
   private short[] T004E5_A1506EmpLicDAnual ;
   private boolean[] T004E5_n1506EmpLicDAnual ;
   private boolean[] T004E5_A1507EmpLicAdju ;
   private boolean[] T004E5_n1507EmpLicAdju ;
   private boolean[] T004E5_A1508EmpLicAdjuObl ;
   private boolean[] T004E5_n1508EmpLicAdjuObl ;
   private boolean[] T004E5_A1509EmpLicNecAut ;
   private boolean[] T004E5_n1509EmpLicNecAut ;
   private boolean[] T004E5_A1510EmpLicIngMot ;
   private boolean[] T004E5_n1510EmpLicIngMot ;
   private boolean[] T004E5_A1511EmpLicMotObl ;
   private boolean[] T004E5_n1511EmpLicMotObl ;
   private short[] T004E5_A1518EmpBaseOrd ;
   private boolean[] T004E5_n1518EmpBaseOrd ;
   private short[] T004E5_A1437EmpBasePromCnt1 ;
   private short[] T004E5_A1438EmpBasePromCnt2 ;
   private String[] T004E5_A1439EmpBasePromTCnt ;
   private int[] T004E5_A2003EmpBaseRelSec ;
   private int[] T004E5_A3CliCod ;
   private short[] T004E5_A1EmpCod ;
   private int[] T004E4_A3CliCod ;
   private int[] T004E6_A3CliCod ;
   private int[] T004E7_A3CliCod ;
   private short[] T004E7_A1EmpCod ;
   private byte[] T004E7_A1427EmpBaseClaseLeg ;
   private String[] T004E7_A1429EmpBaseTipo ;
   private String[] T004E7_A1430EmpBaseCod1 ;
   private String[] T004E7_A1431EmpBaseCod2 ;
   private byte[] T004E3_A1427EmpBaseClaseLeg ;
   private String[] T004E3_A1429EmpBaseTipo ;
   private String[] T004E3_A1430EmpBaseCod1 ;
   private String[] T004E3_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] T004E3_A1432EmpBasePlus ;
   private byte[] T004E3_A1517EmpLicDMin ;
   private boolean[] T004E3_n1517EmpLicDMin ;
   private short[] T004E3_A1502EmpLicDLim ;
   private boolean[] T004E3_n1502EmpLicDLim ;
   private byte[] T004E3_A1503EmpLicDSeman ;
   private boolean[] T004E3_n1503EmpLicDSeman ;
   private byte[] T004E3_A1504EmpLicDMes ;
   private boolean[] T004E3_n1504EmpLicDMes ;
   private short[] T004E3_A1505EmpLicDSemes ;
   private boolean[] T004E3_n1505EmpLicDSemes ;
   private short[] T004E3_A1506EmpLicDAnual ;
   private boolean[] T004E3_n1506EmpLicDAnual ;
   private boolean[] T004E3_A1507EmpLicAdju ;
   private boolean[] T004E3_n1507EmpLicAdju ;
   private boolean[] T004E3_A1508EmpLicAdjuObl ;
   private boolean[] T004E3_n1508EmpLicAdjuObl ;
   private boolean[] T004E3_A1509EmpLicNecAut ;
   private boolean[] T004E3_n1509EmpLicNecAut ;
   private boolean[] T004E3_A1510EmpLicIngMot ;
   private boolean[] T004E3_n1510EmpLicIngMot ;
   private boolean[] T004E3_A1511EmpLicMotObl ;
   private boolean[] T004E3_n1511EmpLicMotObl ;
   private short[] T004E3_A1518EmpBaseOrd ;
   private boolean[] T004E3_n1518EmpBaseOrd ;
   private short[] T004E3_A1437EmpBasePromCnt1 ;
   private short[] T004E3_A1438EmpBasePromCnt2 ;
   private String[] T004E3_A1439EmpBasePromTCnt ;
   private int[] T004E3_A2003EmpBaseRelSec ;
   private int[] T004E3_A3CliCod ;
   private short[] T004E3_A1EmpCod ;
   private int[] T004E8_A3CliCod ;
   private short[] T004E8_A1EmpCod ;
   private byte[] T004E8_A1427EmpBaseClaseLeg ;
   private String[] T004E8_A1429EmpBaseTipo ;
   private String[] T004E8_A1430EmpBaseCod1 ;
   private String[] T004E8_A1431EmpBaseCod2 ;
   private int[] T004E9_A3CliCod ;
   private short[] T004E9_A1EmpCod ;
   private byte[] T004E9_A1427EmpBaseClaseLeg ;
   private String[] T004E9_A1429EmpBaseTipo ;
   private String[] T004E9_A1430EmpBaseCod1 ;
   private String[] T004E9_A1431EmpBaseCod2 ;
   private byte[] T004E2_A1427EmpBaseClaseLeg ;
   private String[] T004E2_A1429EmpBaseTipo ;
   private String[] T004E2_A1430EmpBaseCod1 ;
   private String[] T004E2_A1431EmpBaseCod2 ;
   private java.math.BigDecimal[] T004E2_A1432EmpBasePlus ;
   private byte[] T004E2_A1517EmpLicDMin ;
   private boolean[] T004E2_n1517EmpLicDMin ;
   private short[] T004E2_A1502EmpLicDLim ;
   private boolean[] T004E2_n1502EmpLicDLim ;
   private byte[] T004E2_A1503EmpLicDSeman ;
   private boolean[] T004E2_n1503EmpLicDSeman ;
   private byte[] T004E2_A1504EmpLicDMes ;
   private boolean[] T004E2_n1504EmpLicDMes ;
   private short[] T004E2_A1505EmpLicDSemes ;
   private boolean[] T004E2_n1505EmpLicDSemes ;
   private short[] T004E2_A1506EmpLicDAnual ;
   private boolean[] T004E2_n1506EmpLicDAnual ;
   private boolean[] T004E2_A1507EmpLicAdju ;
   private boolean[] T004E2_n1507EmpLicAdju ;
   private boolean[] T004E2_A1508EmpLicAdjuObl ;
   private boolean[] T004E2_n1508EmpLicAdjuObl ;
   private boolean[] T004E2_A1509EmpLicNecAut ;
   private boolean[] T004E2_n1509EmpLicNecAut ;
   private boolean[] T004E2_A1510EmpLicIngMot ;
   private boolean[] T004E2_n1510EmpLicIngMot ;
   private boolean[] T004E2_A1511EmpLicMotObl ;
   private boolean[] T004E2_n1511EmpLicMotObl ;
   private short[] T004E2_A1518EmpBaseOrd ;
   private boolean[] T004E2_n1518EmpBaseOrd ;
   private short[] T004E2_A1437EmpBasePromCnt1 ;
   private short[] T004E2_A1438EmpBasePromCnt2 ;
   private String[] T004E2_A1439EmpBasePromTCnt ;
   private int[] T004E2_A2003EmpBaseRelSec ;
   private int[] T004E2_A3CliCod ;
   private short[] T004E2_A1EmpCod ;
   private int[] T004E13_A3CliCod ;
   private short[] T004E13_A1EmpCod ;
   private byte[] T004E13_A1427EmpBaseClaseLeg ;
   private String[] T004E13_A1429EmpBaseTipo ;
   private String[] T004E13_A1430EmpBaseCod1 ;
   private String[] T004E13_A1431EmpBaseCod2 ;
   private int[] T004E14_A3CliCod ;
   private short[] T004E14_A1EmpCod ;
   private String[] T004E14_A2EmpNom ;
   private int[] T004E15_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV37collection_EmpBaseCod1 ;
   private GXSimpleCollection<String> GXv_objcol_char3[] ;
   private web.wwpbaseobjects.SdtWWPContext AV13WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV16TrnContext ;
}

final  class empresabase_calculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T004E2", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?  FOR UPDATE OF Empresabase_calculo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E3", "SELECT EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E4", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E5", "SELECT TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2, TM1.EmpBasePlus, TM1.EmpLicDMin, TM1.EmpLicDLim, TM1.EmpLicDSeman, TM1.EmpLicDMes, TM1.EmpLicDSemes, TM1.EmpLicDAnual, TM1.EmpLicAdju, TM1.EmpLicAdjuObl, TM1.EmpLicNecAut, TM1.EmpLicIngMot, TM1.EmpLicMotObl, TM1.EmpBaseOrd, TM1.EmpBasePromCnt1, TM1.EmpBasePromCnt2, TM1.EmpBasePromTCnt, TM1.EmpBaseRelSec, TM1.CliCod, TM1.EmpCod FROM Empresabase_calculo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.EmpBaseClaseLeg = ? and TM1.EmpBaseTipo = ( ?) and TM1.EmpBaseCod1 = ( ?) and TM1.EmpBaseCod2 = ( ?) ORDER BY TM1.CliCod, TM1.EmpCod, TM1.EmpBaseClaseLeg, TM1.EmpBaseTipo, TM1.EmpBaseCod1, TM1.EmpBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E6", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E7", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E8", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and EmpBaseClaseLeg > ? or EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseTipo > ( ?) or EmpBaseTipo = ( ?) and EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseCod1 > ( ?) or EmpBaseCod1 = ( ?) and EmpBaseTipo = ( ?) and EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseCod2 > ( ?)) ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T004E9", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and EmpBaseClaseLeg < ? or EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseTipo < ( ?) or EmpBaseTipo = ( ?) and EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseCod1 < ( ?) or EmpBaseCod1 = ( ?) and EmpBaseTipo = ( ?) and EmpBaseClaseLeg = ? and EmpCod = ? and CliCod = ? and EmpBaseCod2 < ( ?)) ORDER BY CliCod DESC, EmpCod DESC, EmpBaseClaseLeg DESC, EmpBaseTipo DESC, EmpBaseCod1 DESC, EmpBaseCod2 DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004E10", "SAVEPOINT gxupdate;INSERT INTO Empresabase_calculo(EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2, EmpBasePlus, EmpLicDMin, EmpLicDLim, EmpLicDSeman, EmpLicDMes, EmpLicDSemes, EmpLicDAnual, EmpLicAdju, EmpLicAdjuObl, EmpLicNecAut, EmpLicIngMot, EmpLicMotObl, EmpBaseOrd, EmpBasePromCnt1, EmpBasePromCnt2, EmpBasePromTCnt, EmpBaseRelSec, CliCod, EmpCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004E11", "SAVEPOINT gxupdate;UPDATE Empresabase_calculo SET EmpBasePlus=?, EmpLicDMin=?, EmpLicDLim=?, EmpLicDSeman=?, EmpLicDMes=?, EmpLicDSemes=?, EmpLicDAnual=?, EmpLicAdju=?, EmpLicAdjuObl=?, EmpLicNecAut=?, EmpLicIngMot=?, EmpLicMotObl=?, EmpBaseOrd=?, EmpBasePromCnt1=?, EmpBasePromCnt2=?, EmpBasePromTCnt=?, EmpBaseRelSec=?  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004E12", "SAVEPOINT gxupdate;DELETE FROM Empresabase_calculo  WHERE CliCod = ? AND EmpCod = ? AND EmpBaseClaseLeg = ? AND EmpBaseTipo = ? AND EmpBaseCod1 = ? AND EmpBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004E13", "SELECT CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 FROM Empresabase_calculo ORDER BY CliCod, EmpCod, EmpBaseClaseLeg, EmpBaseTipo, EmpBaseCod1, EmpBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E14", "SELECT CliCod, EmpCod, EmpNom FROM Empresa WHERE CliCod = ? ORDER BY EmpNom ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004E15", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((short[]) buf[7])[0] = rslt.getShort(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((byte[]) buf[11])[0] = rslt.getByte(9);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(10);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((boolean[]) buf[17])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((boolean[]) buf[19])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[20])[0] = rslt.wasNull();
               ((boolean[]) buf[21])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[22])[0] = rslt.wasNull();
               ((boolean[]) buf[23])[0] = rslt.getBoolean(15);
               ((boolean[]) buf[24])[0] = rslt.wasNull();
               ((boolean[]) buf[25])[0] = rslt.getBoolean(16);
               ((boolean[]) buf[26])[0] = rslt.wasNull();
               ((short[]) buf[27])[0] = rslt.getShort(17);
               ((boolean[]) buf[28])[0] = rslt.wasNull();
               ((short[]) buf[29])[0] = rslt.getShort(18);
               ((short[]) buf[30])[0] = rslt.getShort(19);
               ((String[]) buf[31])[0] = rslt.getString(20, 20);
               ((int[]) buf[32])[0] = rslt.getInt(21);
               ((int[]) buf[33])[0] = rslt.getInt(22);
               ((short[]) buf[34])[0] = rslt.getShort(23);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setString(16, (String)parms[15], 20);
               stmt.setString(17, (String)parms[16], 20);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setString(16, (String)parms[15], 20);
               stmt.setString(17, (String)parms[16], 20);
               stmt.setByte(18, ((Number) parms[17]).byteValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(6, ((Number) parms[6]).byteValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[8]).shortValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(8, ((Number) parms[10]).byteValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(9, ((Number) parms[12]).byteValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(10, ((Number) parms[14]).shortValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(11, ((Number) parms[16]).shortValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(12, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(13, ((Boolean) parms[20]).booleanValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 14 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(14, ((Boolean) parms[22]).booleanValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 15 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(15, ((Boolean) parms[24]).booleanValue());
               }
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 16 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(16, ((Boolean) parms[26]).booleanValue());
               }
               if ( ((Boolean) parms[27]).booleanValue() )
               {
                  stmt.setNull( 17 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(17, ((Number) parms[28]).shortValue());
               }
               stmt.setShort(18, ((Number) parms[29]).shortValue());
               stmt.setShort(19, ((Number) parms[30]).shortValue());
               stmt.setString(20, (String)parms[31], 20);
               stmt.setInt(21, ((Number) parms[32]).intValue());
               stmt.setInt(22, ((Number) parms[33]).intValue());
               stmt.setShort(23, ((Number) parms[34]).shortValue());
               return;
            case 9 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(2, ((Number) parms[2]).byteValue());
               }
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(3, ((Number) parms[4]).shortValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(4, ((Number) parms[6]).byteValue());
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(5, ((Number) parms[8]).byteValue());
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[10]).shortValue());
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[12]).shortValue());
               }
               if ( ((Boolean) parms[13]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(8, ((Boolean) parms[14]).booleanValue());
               }
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(9, ((Boolean) parms[16]).booleanValue());
               }
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(10, ((Boolean) parms[18]).booleanValue());
               }
               if ( ((Boolean) parms[19]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(11, ((Boolean) parms[20]).booleanValue());
               }
               if ( ((Boolean) parms[21]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(12, ((Boolean) parms[22]).booleanValue());
               }
               if ( ((Boolean) parms[23]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(13, ((Number) parms[24]).shortValue());
               }
               stmt.setShort(14, ((Number) parms[25]).shortValue());
               stmt.setShort(15, ((Number) parms[26]).shortValue());
               stmt.setString(16, (String)parms[27], 20);
               stmt.setInt(17, ((Number) parms[28]).intValue());
               stmt.setInt(18, ((Number) parms[29]).intValue());
               stmt.setShort(19, ((Number) parms[30]).shortValue());
               stmt.setByte(20, ((Number) parms[31]).byteValue());
               stmt.setString(21, (String)parms[32], 20);
               stmt.setString(22, (String)parms[33], 20);
               stmt.setString(23, (String)parms[34], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

