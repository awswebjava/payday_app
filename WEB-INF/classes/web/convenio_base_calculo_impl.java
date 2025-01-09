package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_base_calculo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action57") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A2060ConveBaseRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveBaseRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_57_41210( Gx_mode, AV7CliCod, A2060ConveBaseRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEBASERELSEC") == 0 )
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
         gxdlaconvebaserelsec41210( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"CONVEBASEC1TXT") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1455ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = httpContext.GetPar( "ConveBaseCod1") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx5asaconvebasec1txt41210( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"CLICOD") == 0 )
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
         gx6asaclicod41210( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_60") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_60( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
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
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "ConveBaseClaseLeg"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ConveBaseClaseLeg", GXutil.str( AV10ConveBaseClaseLeg, 1, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ConveBaseClaseLeg), "9")));
            AV11ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ConveBaseTipo", AV11ConveBaseTipo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConveBaseTipo, ""))));
            AV12ConveBaseCod1 = httpContext.GetPar( "ConveBaseCod1") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12ConveBaseCod1", AV12ConveBaseCod1);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ConveBaseCod1, ""))));
            AV13ConveBaseCod2 = httpContext.GetPar( "ConveBaseCod2") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV13ConveBaseCod2", AV13ConveBaseCod2);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13ConveBaseCod2, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio_base_calculo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public convenio_base_calculo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_base_calculo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_base_calculo_impl.class ));
   }

   public convenio_base_calculo_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConveBaseClaseLeg = new HTMLChoice();
      cmbConveBaseTipo = new HTMLChoice();
      cmbConveLicDMes = new HTMLChoice();
      chkConveLicAdju = UIFactory.getCheckbox(this);
      chkConveLicAdjuObl = UIFactory.getCheckbox(this);
      chkConveLicNecAut = UIFactory.getCheckbox(this);
      chkConveLicIngMot = UIFactory.getCheckbox(this);
      chkConveLicMotObl = UIFactory.getCheckbox(this);
      cmbConveBasePromTCnt = new HTMLChoice();
      dynConveBaseRelSec = new HTMLChoice();
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
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Values", cmbConveBaseClaseLeg.ToJavascriptSource(), true);
      }
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Values", cmbConveBaseTipo.ToJavascriptSource(), true);
      }
      if ( cmbConveLicDMes.getItemCount() > 0 )
      {
         A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValidValue(GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveLicDMes.setValue( GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Values", cmbConveLicDMes.ToJavascriptSource(), true);
      }
      A1615ConveLicAdju = GXutil.strtobool( GXutil.booltostr( A1615ConveLicAdju)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
      A1616ConveLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1616ConveLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
      A1617ConveLicNecAut = GXutil.strtobool( GXutil.booltostr( A1617ConveLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
      A1618ConveLicIngMot = GXutil.strtobool( GXutil.booltostr( A1618ConveLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
      A1619ConveLicMotObl = GXutil.strtobool( GXutil.booltostr( A1619ConveLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
      if ( cmbConveBasePromTCnt.getItemCount() > 0 )
      {
         A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValidValue(A1467ConveBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBasePromTCnt.setValue( GXutil.rtrim( A1467ConveBasePromTCnt) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBasePromTCnt.getInternalname(), "Values", cmbConveBasePromTCnt.ToJavascriptSource(), true);
      }
      if ( dynConveBaseRelSec.getItemCount() > 0 )
      {
         A2060ConveBaseRelSec = (int)(GXutil.lval( dynConveBaseRelSec.getValidValue(GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveBaseRelSec.setValue( GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveBaseRelSec.getInternalname(), "Values", dynConveBaseRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBaseClaseLeg.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveBaseClaseLeg.getInternalname(), httpContext.getMessage( "Clase de legajo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBaseClaseLeg, cmbConveBaseClaseLeg.getInternalname(), GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)), 1, cmbConveBaseClaseLeg.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbConveBaseClaseLeg.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Convenio_base_calculo.htm");
      cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Values", cmbConveBaseClaseLeg.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBaseTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveBaseTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBaseTipo, cmbConveBaseTipo.getInternalname(), GXutil.rtrim( A1455ConveBaseTipo), 1, cmbConveBaseTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveBaseTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_Convenio_base_calculo.htm");
      cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Values", cmbConveBaseTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvebasecod1_cell_Internalname, 1, 0, "px", 0, "px", divConvebasecod1_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveBaseCod1_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBaseCod1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveBaseCod1_Internalname, httpContext.getMessage( "Código 1", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveBaseCod1_Internalname, GXutil.rtrim( A1456ConveBaseCod1), GXutil.rtrim( localUtil.format( A1456ConveBaseCod1, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBaseCod1_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBaseCod1_Visible, edtConveBaseCod1_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvebasecod2_cell_Internalname, 1, 0, "px", 0, "px", divConvebasecod2_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveBaseCod2_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBaseCod2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveBaseCod2_Internalname, httpContext.getMessage( "Código 2", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveBaseCod2_Internalname, GXutil.rtrim( A1457ConveBaseCod2), GXutil.rtrim( localUtil.format( A1457ConveBaseCod2, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBaseCod2_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBaseCod2_Visible, edtConveBaseCod2_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvebaseplus_cell_Internalname, 1, 0, "px", 0, "px", divConvebaseplus_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveBasePlus_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePlus_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveBasePlus_Internalname, httpContext.getMessage( "Porcentaje para plus", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePlus_Internalname, GXutil.ltrim( localUtil.ntoc( A1458ConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePlus_Enabled!=0) ? localUtil.format( A1458ConveBasePlus, "9.9999") : localUtil.format( A1458ConveBasePlus, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePlus_Jsonclick, 0, "Attribute", "", "", "", "", edtConveBasePlus_Visible, edtConveBasePlus_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicdlim_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdlim_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDLim_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDLim_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveLicDLim_Internalname, httpContext.getMessage( "Cantidad de días permitidos por licencia", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDLim_Internalname, GXutil.ltrim( localUtil.ntoc( A1610ConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDLim_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1610ConveLicDLim), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1610ConveLicDLim), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDLim_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDLim_Visible, edtConveLicDLim_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicdseman_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdseman_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDSeman_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDSeman_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveLicDSeman_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semana", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDSeman_Internalname, GXutil.ltrim( localUtil.ntoc( A1611ConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDSeman_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1611ConveLicDSeman), "9") : localUtil.format( DecimalUtil.doubleToDec(A1611ConveLicDSeman), "9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDSeman_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDSeman_Visible, edtConveLicDSeman_Enabled, 0, "text", "1", 1, "chr", 1, "row", 1, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicdmes_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdmes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", cmbConveLicDMes.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveLicDMes.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveLicDMes.getInternalname(), httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveLicDMes, cmbConveLicDMes.getInternalname(), GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)), 1, cmbConveLicDMes.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", cmbConveLicDMes.getVisible(), cmbConveLicDMes.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_Convenio_base_calculo.htm");
      cmbConveLicDMes.setValue( GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Values", cmbConveLicDMes.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicdsemes_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdsemes_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDSemes_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDSemes_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveLicDSemes_Internalname, httpContext.getMessage( "Cantidad de días permitidos por semestre", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDSemes_Internalname, GXutil.ltrim( localUtil.ntoc( A1613ConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDSemes_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1613ConveLicDSemes), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1613ConveLicDSemes), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDSemes_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDSemes_Visible, edtConveLicDSemes_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicdanual_cell_Internalname, 1, 0, "px", 0, "px", divConvelicdanual_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", edtConveLicDAnual_Visible, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveLicDAnual_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveLicDAnual_Internalname, httpContext.getMessage( "Cantidad de días permitidos por año", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveLicDAnual_Internalname, GXutil.ltrim( localUtil.ntoc( A1614ConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveLicDAnual_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1614ConveLicDAnual), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1614ConveLicDAnual), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveLicDAnual_Jsonclick, 0, "Attribute", "", "", "", "", edtConveLicDAnual_Visible, edtConveLicDAnual_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicadju_cell_Internalname, 1, 0, "px", 0, "px", divConvelicadju_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConveLicAdju.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicAdju.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveLicAdju.getInternalname(), httpContext.getMessage( "Permite adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicAdju.getInternalname(), GXutil.booltostr( A1615ConveLicAdju), "", httpContext.getMessage( "Permite adjuntar documento", ""), chkConveLicAdju.getVisible(), chkConveLicAdju.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(72, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,72);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicadjuobl_cell_Internalname, 1, 0, "px", 0, "px", divConvelicadjuobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConveLicAdjuObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicAdjuObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveLicAdjuObl.getInternalname(), httpContext.getMessage( "Obliga a adjuntar documento", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicAdjuObl.getInternalname(), GXutil.booltostr( A1616ConveLicAdjuObl), "", httpContext.getMessage( "Obliga a adjuntar documento", ""), chkConveLicAdjuObl.getVisible(), chkConveLicAdjuObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(77, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,77);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicnecaut_cell_Internalname, 1, 0, "px", 0, "px", divConvelicnecaut_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConveLicNecAut.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicNecAut.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveLicNecAut.getInternalname(), httpContext.getMessage( "Necesita autorización", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicNecAut.getInternalname(), GXutil.booltostr( A1617ConveLicNecAut), "", httpContext.getMessage( "Necesita autorización", ""), chkConveLicNecAut.getVisible(), chkConveLicNecAut.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(82, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,82);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicingmot_cell_Internalname, 1, 0, "px", 0, "px", divConvelicingmot_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConveLicIngMot.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicIngMot.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveLicIngMot.getInternalname(), httpContext.getMessage( "Permite ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicIngMot.getInternalname(), GXutil.booltostr( A1618ConveLicIngMot), "", httpContext.getMessage( "Permite ingresar motivo", ""), chkConveLicIngMot.getVisible(), chkConveLicIngMot.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(87, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,87);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvelicmotobl_cell_Internalname, 1, 0, "px", 0, "px", divConvelicmotobl_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", chkConveLicMotObl.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkConveLicMotObl.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkConveLicMotObl.getInternalname(), httpContext.getMessage( "Obliga a ingresar motivo", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkConveLicMotObl.getInternalname(), GXutil.booltostr( A1619ConveLicMotObl), "", httpContext.getMessage( "Obliga a ingresar motivo", ""), chkConveLicMotObl.getVisible(), chkConveLicMotObl.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(92, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,92);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePromCnt1_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveBasePromCnt1_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 97,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePromCnt1_Internalname, GXutil.ltrim( localUtil.ntoc( A1465ConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePromCnt1_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,97);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePromCnt1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveBasePromCnt1_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveBasePromCnt2_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveBasePromCnt2_Internalname, httpContext.getMessage( "Cantidad de días/meses a promediar segunda alternativa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveBasePromCnt2_Internalname, GXutil.ltrim( localUtil.ntoc( A1466ConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveBasePromCnt2_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), "ZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), "ZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,102);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveBasePromCnt2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveBasePromCnt2_Enabled, 0, "text", "1", 3, "chr", 1, "row", 3, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveBasePromTCnt.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveBasePromTCnt.getInternalname(), httpContext.getMessage( "Días o Meses", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveBasePromTCnt, cmbConveBasePromTCnt.getInternalname(), GXutil.rtrim( A1467ConveBasePromTCnt), 1, cmbConveBasePromTCnt.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveBasePromTCnt.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,107);\"", "", true, (byte)(0), "HLP_Convenio_base_calculo.htm");
      cmbConveBasePromTCnt.setValue( GXutil.rtrim( A1467ConveBasePromTCnt) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBasePromTCnt.getInternalname(), "Values", cmbConveBasePromTCnt.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvebaserelsec_cell_Internalname, 1, 0, "px", 0, "px", divConvebaserelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveBaseRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveBaseRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 112,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveBaseRelSec, dynConveBaseRelSec.getInternalname(), GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)), 1, dynConveBaseRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveBaseRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,112);\"", "", true, (byte)(0), "HLP_Convenio_base_calculo.htm");
      dynConveBaseRelSec.setValue( GXutil.trim( GXutil.str( A2060ConveBaseRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveBaseRelSec.getInternalname(), "Values", dynConveBaseRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 120,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 122,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_base_calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 124,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio_base_calculo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 128,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,128);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio_base_calculo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 129,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,129);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Convenio_base_calculo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 130,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,130);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio_base_calculo.htm");
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
      e11412 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z1454ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1454ConveBaseClaseLeg"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1455ConveBaseTipo = httpContext.cgiGet( "Z1455ConveBaseTipo") ;
            Z1456ConveBaseCod1 = httpContext.cgiGet( "Z1456ConveBaseCod1") ;
            Z1457ConveBaseCod2 = httpContext.cgiGet( "Z1457ConveBaseCod2") ;
            Z1458ConveBasePlus = localUtil.ctond( httpContext.cgiGet( "Z1458ConveBasePlus")) ;
            Z1610ConveLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( "Z1610ConveLicDLim"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1611ConveLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1611ConveLicDSeman"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1612ConveLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1612ConveLicDMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1613ConveLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( "Z1613ConveLicDSemes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1614ConveLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( "Z1614ConveLicDAnual"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1615ConveLicAdju = GXutil.strtobool( httpContext.cgiGet( "Z1615ConveLicAdju")) ;
            Z1616ConveLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( "Z1616ConveLicAdjuObl")) ;
            Z1617ConveLicNecAut = GXutil.strtobool( httpContext.cgiGet( "Z1617ConveLicNecAut")) ;
            Z1618ConveLicIngMot = GXutil.strtobool( httpContext.cgiGet( "Z1618ConveLicIngMot")) ;
            Z1619ConveLicMotObl = GXutil.strtobool( httpContext.cgiGet( "Z1619ConveLicMotObl")) ;
            Z1465ConveBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1465ConveBasePromCnt1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1466ConveBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( "Z1466ConveBasePromCnt2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1467ConveBasePromTCnt = httpContext.cgiGet( "Z1467ConveBasePromTCnt") ;
            Z2060ConveBaseRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z2060ConveBaseRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2061ConveBaseRelRef = httpContext.cgiGet( "Z2061ConveBaseRelRef") ;
            A2061ConveBaseRelRef = httpContext.cgiGet( "Z2061ConveBaseRelRef") ;
            O1467ConveBasePromTCnt = httpContext.cgiGet( "O1467ConveBasePromTCnt") ;
            O1466ConveBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( "O1466ConveBasePromCnt2"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1465ConveBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( "O1465ConveBasePromCnt1"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1619ConveLicMotObl = GXutil.strtobool( httpContext.cgiGet( "O1619ConveLicMotObl")) ;
            O1618ConveLicIngMot = GXutil.strtobool( httpContext.cgiGet( "O1618ConveLicIngMot")) ;
            O1617ConveLicNecAut = GXutil.strtobool( httpContext.cgiGet( "O1617ConveLicNecAut")) ;
            O1616ConveLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( "O1616ConveLicAdjuObl")) ;
            O1615ConveLicAdju = GXutil.strtobool( httpContext.cgiGet( "O1615ConveLicAdju")) ;
            O1614ConveLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( "O1614ConveLicDAnual"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1613ConveLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( "O1613ConveLicDSemes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1612ConveLicDMes = (byte)(localUtil.ctol( httpContext.cgiGet( "O1612ConveLicDMes"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1611ConveLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( "O1611ConveLicDSeman"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1610ConveLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( "O1610ConveLicDLim"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1458ConveBasePlus = localUtil.ctond( httpContext.cgiGet( "O1458ConveBasePlus")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            A1609ConveBaseC2Txt = httpContext.cgiGet( "CONVEBASEC2TXT") ;
            A1608ConveBaseC1Txt = httpContext.cgiGet( "CONVEBASEC1TXT") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10ConveBaseClaseLeg = (byte)(localUtil.ctol( httpContext.cgiGet( "vCONVEBASECLASELEG"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV11ConveBaseTipo = httpContext.cgiGet( "vCONVEBASETIPO") ;
            AV12ConveBaseCod1 = httpContext.cgiGet( "vCONVEBASECOD1") ;
            AV13ConveBaseCod2 = httpContext.cgiGet( "vCONVEBASECOD2") ;
            AV25aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2061ConveBaseRelRef = httpContext.cgiGet( "CONVEBASERELREF") ;
            A2062ConveBaseOld = httpContext.cgiGet( "CONVEBASEOLD") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            cmbConveBaseClaseLeg.setValue( httpContext.cgiGet( cmbConveBaseClaseLeg.getInternalname()) );
            A1454ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveBaseClaseLeg.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
            cmbConveBaseTipo.setValue( httpContext.cgiGet( cmbConveBaseTipo.getInternalname()) );
            A1455ConveBaseTipo = httpContext.cgiGet( cmbConveBaseTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
            A1456ConveBaseCod1 = httpContext.cgiGet( edtConveBaseCod1_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
            A1457ConveBaseCod2 = httpContext.cgiGet( edtConveBaseCod2_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveBasePlus_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveBasePlus_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEBASEPLUS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveBasePlus_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1458ConveBasePlus = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
            }
            else
            {
               A1458ConveBasePlus = localUtil.ctond( httpContext.cgiGet( edtConveBasePlus_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVELICDLIM");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveLicDLim_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1610ConveLicDLim = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
            }
            else
            {
               A1610ConveLicDLim = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDLim_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVELICDSEMAN");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveLicDSeman_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1611ConveLicDSeman = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
            }
            else
            {
               A1611ConveLicDSeman = (byte)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSeman_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
            }
            cmbConveLicDMes.setValue( httpContext.cgiGet( cmbConveLicDMes.getInternalname()) );
            A1612ConveLicDMes = (byte)(GXutil.lval( httpContext.cgiGet( cmbConveLicDMes.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVELICDSEMES");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveLicDSemes_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1613ConveLicDSemes = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
            }
            else
            {
               A1613ConveLicDSemes = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDSemes_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVELICDANUAL");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveLicDAnual_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1614ConveLicDAnual = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
            }
            else
            {
               A1614ConveLicDAnual = (short)(localUtil.ctol( httpContext.cgiGet( edtConveLicDAnual_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
            }
            A1615ConveLicAdju = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdju.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
            A1616ConveLicAdjuObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicAdjuObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
            A1617ConveLicNecAut = GXutil.strtobool( httpContext.cgiGet( chkConveLicNecAut.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
            A1618ConveLicIngMot = GXutil.strtobool( httpContext.cgiGet( chkConveLicIngMot.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
            A1619ConveLicMotObl = GXutil.strtobool( httpContext.cgiGet( chkConveLicMotObl.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEBASEPROMCNT1");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveBasePromCnt1_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1465ConveBasePromCnt1 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
            }
            else
            {
               A1465ConveBasePromCnt1 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt1_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEBASEPROMCNT2");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveBasePromCnt2_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1466ConveBasePromCnt2 = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
            }
            else
            {
               A1466ConveBasePromCnt2 = (short)(localUtil.ctol( httpContext.cgiGet( edtConveBasePromCnt2_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
            }
            cmbConveBasePromTCnt.setValue( httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) );
            A1467ConveBasePromTCnt = httpContext.cgiGet( cmbConveBasePromTCnt.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
            dynConveBaseRelSec.setValue( httpContext.cgiGet( dynConveBaseRelSec.getInternalname()) );
            A2060ConveBaseRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveBaseRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
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
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLIPAICONVE");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliPaiConve_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1564CliPaiConve = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            else
            {
               A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( edtCliPaiConve_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            }
            A1565CliConvenio = httpContext.cgiGet( edtCliConvenio_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_base_calculo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveBaseRelRef", GXutil.rtrim( localUtil.format( A2061ConveBaseRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1454ConveBaseClaseLeg != Z1454ConveBaseClaseLeg ) || ( GXutil.strcmp(A1455ConveBaseTipo, Z1455ConveBaseTipo) != 0 ) || ( GXutil.strcmp(A1456ConveBaseCod1, Z1456ConveBaseCod1) != 0 ) || ( GXutil.strcmp(A1457ConveBaseCod2, Z1457ConveBaseCod2) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio_base_calculo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1454ConveBaseClaseLeg = (byte)(GXutil.lval( httpContext.GetPar( "ConveBaseClaseLeg"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
               A1455ConveBaseTipo = httpContext.GetPar( "ConveBaseTipo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
               A1456ConveBaseCod1 = httpContext.GetPar( "ConveBaseCod1") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
               A1457ConveBaseCod2 = httpContext.GetPar( "ConveBaseCod2") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode210 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode210 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound210 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_410( ) ;
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
                        e11412 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12412 ();
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
         e12412 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll41210( ) ;
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
         disableAttributes41210( ) ;
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

   public void confirm_410( )
   {
      beforeValidate41210( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls41210( ) ;
         }
         else
         {
            checkExtendedTable41210( ) ;
            closeExtendedTableCursors41210( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption410( )
   {
   }

   public void e11412( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( false )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "asdfd", ""));
      }
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV14WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV14WWPContext = GXv_SdtWWPContext1[0] ;
      AV15IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Insert", GXv_boolean3) ;
         convenio_base_calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Update", GXv_boolean3) ;
         convenio_base_calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV15IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_base_calculo_Delete", GXv_boolean3) ;
         convenio_base_calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV15IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV15IsAuthorized", AV15IsAuthorized);
      }
      if ( ! AV15IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
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
      AV17TrnContext.fromxml(AV18WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
   }

   public void e12412( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.convenio_basecalculograbarrelref(remoteHandle, context).execute( AV7CliCod) ;
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
      edtConveBaseCod1_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Visible), 5, 0), true);
      divConvebasecod1_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvebasecod1_cell_Internalname, "Class", divConvebasecod1_cell_Class, true);
      edtConveBaseCod2_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Visible), 5, 0), true);
      divConvebasecod2_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvebasecod2_cell_Internalname, "Class", divConvebasecod2_cell_Class, true);
      edtConveBasePlus_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Visible), 5, 0), true);
      divConvebaseplus_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvebaseplus_cell_Internalname, "Class", divConvebaseplus_cell_Class, true);
      edtConveLicDLim_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Visible), 5, 0), true);
      divConvelicdlim_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicdlim_cell_Internalname, "Class", divConvelicdlim_cell_Class, true);
      edtConveLicDSeman_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Visible), 5, 0), true);
      divConvelicdseman_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicdseman_cell_Internalname, "Class", divConvelicdseman_cell_Class, true);
      cmbConveLicDMes.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveLicDMes.getVisible(), 5, 0), true);
      divConvelicdmes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicdmes_cell_Internalname, "Class", divConvelicdmes_cell_Class, true);
      edtConveLicDSemes_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Visible), 5, 0), true);
      divConvelicdsemes_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicdsemes_cell_Internalname, "Class", divConvelicdsemes_cell_Class, true);
      edtConveLicDAnual_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Visible), 5, 0), true);
      divConvelicdanual_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicdanual_cell_Internalname, "Class", divConvelicdanual_cell_Class, true);
      chkConveLicAdju.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdju.getVisible(), 5, 0), true);
      divConvelicadju_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicadju_cell_Internalname, "Class", divConvelicadju_cell_Class, true);
      chkConveLicAdjuObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdjuObl.getVisible(), 5, 0), true);
      divConvelicadjuobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicadjuobl_cell_Internalname, "Class", divConvelicadjuobl_cell_Class, true);
      chkConveLicNecAut.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicNecAut.getVisible(), 5, 0), true);
      divConvelicnecaut_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicnecaut_cell_Internalname, "Class", divConvelicnecaut_cell_Class, true);
      chkConveLicIngMot.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicIngMot.getVisible(), 5, 0), true);
      divConvelicingmot_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicingmot_cell_Internalname, "Class", divConvelicingmot_cell_Class, true);
      chkConveLicMotObl.setVisible( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicMotObl.getVisible(), 5, 0), true);
      divConvelicmotobl_cell_Class = "Invisible" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvelicmotobl_cell_Internalname, "Class", divConvelicmotobl_cell_Class, true);
      divConvebaserelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
   }

   public void zm41210( int GX_JID )
   {
      if ( ( GX_JID == 59 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1458ConveBasePlus = T00413_A1458ConveBasePlus[0] ;
            Z1610ConveLicDLim = T00413_A1610ConveLicDLim[0] ;
            Z1611ConveLicDSeman = T00413_A1611ConveLicDSeman[0] ;
            Z1612ConveLicDMes = T00413_A1612ConveLicDMes[0] ;
            Z1613ConveLicDSemes = T00413_A1613ConveLicDSemes[0] ;
            Z1614ConveLicDAnual = T00413_A1614ConveLicDAnual[0] ;
            Z1615ConveLicAdju = T00413_A1615ConveLicAdju[0] ;
            Z1616ConveLicAdjuObl = T00413_A1616ConveLicAdjuObl[0] ;
            Z1617ConveLicNecAut = T00413_A1617ConveLicNecAut[0] ;
            Z1618ConveLicIngMot = T00413_A1618ConveLicIngMot[0] ;
            Z1619ConveLicMotObl = T00413_A1619ConveLicMotObl[0] ;
            Z1465ConveBasePromCnt1 = T00413_A1465ConveBasePromCnt1[0] ;
            Z1466ConveBasePromCnt2 = T00413_A1466ConveBasePromCnt2[0] ;
            Z1467ConveBasePromTCnt = T00413_A1467ConveBasePromTCnt[0] ;
            Z2060ConveBaseRelSec = T00413_A2060ConveBaseRelSec[0] ;
            Z2061ConveBaseRelRef = T00413_A2061ConveBaseRelRef[0] ;
         }
         else
         {
            Z1458ConveBasePlus = A1458ConveBasePlus ;
            Z1610ConveLicDLim = A1610ConveLicDLim ;
            Z1611ConveLicDSeman = A1611ConveLicDSeman ;
            Z1612ConveLicDMes = A1612ConveLicDMes ;
            Z1613ConveLicDSemes = A1613ConveLicDSemes ;
            Z1614ConveLicDAnual = A1614ConveLicDAnual ;
            Z1615ConveLicAdju = A1615ConveLicAdju ;
            Z1616ConveLicAdjuObl = A1616ConveLicAdjuObl ;
            Z1617ConveLicNecAut = A1617ConveLicNecAut ;
            Z1618ConveLicIngMot = A1618ConveLicIngMot ;
            Z1619ConveLicMotObl = A1619ConveLicMotObl ;
            Z1465ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
            Z1466ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
            Z1467ConveBasePromTCnt = A1467ConveBasePromTCnt ;
            Z2060ConveBaseRelSec = A2060ConveBaseRelSec ;
            Z2061ConveBaseRelRef = A2061ConveBaseRelRef ;
         }
      }
      if ( GX_JID == -59 )
      {
         Z1454ConveBaseClaseLeg = A1454ConveBaseClaseLeg ;
         Z1455ConveBaseTipo = A1455ConveBaseTipo ;
         Z1456ConveBaseCod1 = A1456ConveBaseCod1 ;
         Z1457ConveBaseCod2 = A1457ConveBaseCod2 ;
         Z1458ConveBasePlus = A1458ConveBasePlus ;
         Z1610ConveLicDLim = A1610ConveLicDLim ;
         Z1611ConveLicDSeman = A1611ConveLicDSeman ;
         Z1612ConveLicDMes = A1612ConveLicDMes ;
         Z1613ConveLicDSemes = A1613ConveLicDSemes ;
         Z1614ConveLicDAnual = A1614ConveLicDAnual ;
         Z1615ConveLicAdju = A1615ConveLicAdju ;
         Z1616ConveLicAdjuObl = A1616ConveLicAdjuObl ;
         Z1617ConveLicNecAut = A1617ConveLicNecAut ;
         Z1618ConveLicIngMot = A1618ConveLicIngMot ;
         Z1619ConveLicMotObl = A1619ConveLicMotObl ;
         Z1465ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
         Z1466ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
         Z1467ConveBasePromTCnt = A1467ConveBasePromTCnt ;
         Z2060ConveBaseRelSec = A2060ConveBaseRelSec ;
         Z2061ConveBaseRelRef = A2061ConveBaseRelRef ;
         Z2062ConveBaseOld = A2062ConveBaseOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( true )
      {
         cmbConveBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
      }
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconvebaserelsec_html41210( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            convenio_base_calculo_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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
      if ( ! (0==AV8CliPaiConve) )
      {
         A1564CliPaiConve = AV8CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV8CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (0==AV10ConveBaseClaseLeg) )
      {
         A1454ConveBaseClaseLeg = AV10ConveBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      }
      if ( ! (0==AV10ConveBaseClaseLeg) )
      {
         cmbConveBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
      }
      else
      {
         if ( true )
         {
            cmbConveBaseClaseLeg.setEnabled( 0 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
         }
         else
         {
            cmbConveBaseClaseLeg.setEnabled( 1 );
            httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
         }
      }
      if ( ! (0==AV10ConveBaseClaseLeg) )
      {
         cmbConveBaseClaseLeg.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11ConveBaseTipo)==0) )
      {
         A1455ConveBaseTipo = AV11ConveBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      }
      if ( ! (GXutil.strcmp("", AV11ConveBaseTipo)==0) )
      {
         cmbConveBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseTipo.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbConveBaseTipo.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseTipo.getEnabled(), 5, 0), true);
      }
      edtConveBaseCod1_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 ) ) )
      {
         divConvebasecod1_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvebasecod1_cell_Internalname, "Class", divConvebasecod1_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 )
         {
            divConvebasecod1_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebasecod1_cell_Internalname, "Class", divConvebasecod1_cell_Class, true);
         }
      }
      edtConveBaseCod2_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 ) ) )
      {
         divConvebasecod2_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvebasecod2_cell_Internalname, "Class", divConvebasecod2_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 )
         {
            divConvebasecod2_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebasecod2_cell_Internalname, "Class", divConvebasecod2_cell_Class, true);
         }
      }
      edtConveBasePlus_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "horaNormal")!=0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePlus_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 ) ) )
      {
         divConvebaseplus_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvebaseplus_cell_Internalname, "Class", divConvebaseplus_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "horaNormal") != 0 )
         {
            divConvebaseplus_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebaseplus_cell_Internalname, "Class", divConvebaseplus_cell_Class, true);
         }
      }
      edtConveLicDLim_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDLim_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicdlim_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicdlim_cell_Internalname, "Class", divConvelicdlim_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicdlim_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicdlim_cell_Internalname, "Class", divConvelicdlim_cell_Class, true);
         }
      }
      edtConveLicDSeman_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSeman_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicdseman_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicdseman_cell_Internalname, "Class", divConvelicdseman_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicdseman_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicdseman_cell_Internalname, "Class", divConvelicdseman_cell_Class, true);
         }
      }
      cmbConveLicDMes.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Visible", GXutil.ltrimstr( cmbConveLicDMes.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicdmes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicdmes_cell_Internalname, "Class", divConvelicdmes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicdmes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicdmes_cell_Internalname, "Class", divConvelicdmes_cell_Class, true);
         }
      }
      edtConveLicDSemes_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSemes_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicdsemes_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicdsemes_cell_Internalname, "Class", divConvelicdsemes_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicdsemes_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicdsemes_cell_Internalname, "Class", divConvelicdsemes_cell_Class, true);
         }
      }
      edtConveLicDAnual_Visible = ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDAnual_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Visible), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicdanual_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicdanual_cell_Internalname, "Class", divConvelicdanual_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicdanual_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicdanual_cell_Internalname, "Class", divConvelicdanual_cell_Class, true);
         }
      }
      chkConveLicAdju.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdju.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicadju_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicadju_cell_Internalname, "Class", divConvelicadju_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicadju_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicadju_cell_Internalname, "Class", divConvelicadju_cell_Class, true);
         }
      }
      chkConveLicAdjuObl.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicAdjuObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicadjuobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicadjuobl_cell_Internalname, "Class", divConvelicadjuobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicadjuobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicadjuobl_cell_Internalname, "Class", divConvelicadjuobl_cell_Class, true);
         }
      }
      chkConveLicNecAut.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicNecAut.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicnecaut_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicnecaut_cell_Internalname, "Class", divConvelicnecaut_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicnecaut_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicnecaut_cell_Internalname, "Class", divConvelicnecaut_cell_Class, true);
         }
      }
      chkConveLicIngMot.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicIngMot.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicingmot_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicingmot_cell_Internalname, "Class", divConvelicingmot_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicingmot_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicingmot_cell_Internalname, "Class", divConvelicingmot_cell_Class, true);
         }
      }
      chkConveLicMotObl.setVisible( ((GXutil.strcmp(AV11ConveBaseTipo, "licencia")==0) ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "Visible", GXutil.ltrimstr( chkConveLicMotObl.getVisible(), 5, 0), true);
      if ( ! ( ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 ) ) )
      {
         divConvelicmotobl_cell_Class = httpContext.getMessage( "Invisible", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvelicmotobl_cell_Internalname, "Class", divConvelicmotobl_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(AV11ConveBaseTipo, "licencia") == 0 )
         {
            divConvelicmotobl_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvelicmotobl_cell_Internalname, "Class", divConvelicmotobl_cell_Class, true);
         }
      }
      if ( ! (GXutil.strcmp("", AV11ConveBaseTipo)==0) )
      {
         cmbConveBaseTipo.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseTipo.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV12ConveBaseCod1)==0) )
      {
         A1456ConveBaseCod1 = AV12ConveBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
      }
      if ( ! (GXutil.strcmp("", AV12ConveBaseCod1)==0) )
      {
         edtConveBaseCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Enabled), 5, 0), true);
      }
      else
      {
         edtConveBaseCod1_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV12ConveBaseCod1)==0) )
      {
         edtConveBaseCod1_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV13ConveBaseCod2)==0) )
      {
         A1457ConveBaseCod2 = AV13ConveBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      }
      if ( ! (GXutil.strcmp("", AV13ConveBaseCod2)==0) )
      {
         edtConveBaseCod2_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Enabled), 5, 0), true);
      }
      else
      {
         edtConveBaseCod2_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV13ConveBaseCod2)==0) )
      {
         edtConveBaseCod2_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Enabled), 5, 0), true);
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
         AV26Pgmname = "Convenio_base_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         GXt_char6 = A1608ConveBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
         convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1608ConveBaseC1Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
      }
   }

   public void load41210( )
   {
      /* Using cursor T00415 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound210 = (short)(1) ;
         A1458ConveBasePlus = T00415_A1458ConveBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
         A1610ConveLicDLim = T00415_A1610ConveLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
         A1611ConveLicDSeman = T00415_A1611ConveLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
         A1612ConveLicDMes = T00415_A1612ConveLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
         A1613ConveLicDSemes = T00415_A1613ConveLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
         A1614ConveLicDAnual = T00415_A1614ConveLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
         A1615ConveLicAdju = T00415_A1615ConveLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
         A1616ConveLicAdjuObl = T00415_A1616ConveLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
         A1617ConveLicNecAut = T00415_A1617ConveLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
         A1618ConveLicIngMot = T00415_A1618ConveLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
         A1619ConveLicMotObl = T00415_A1619ConveLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
         A1465ConveBasePromCnt1 = T00415_A1465ConveBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
         A1466ConveBasePromCnt2 = T00415_A1466ConveBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
         A1467ConveBasePromTCnt = T00415_A1467ConveBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
         A2060ConveBaseRelSec = T00415_A2060ConveBaseRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
         A2061ConveBaseRelRef = T00415_A2061ConveBaseRelRef[0] ;
         A2062ConveBaseOld = T00415_A2062ConveBaseOld[0] ;
         zm41210( -59) ;
      }
      pr_default.close(3);
      onLoadActions41210( ) ;
   }

   public void onLoadActions41210( )
   {
      AV26Pgmname = "Convenio_base_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      GXt_char6 = A1608ConveBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
      convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1608ConveBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
      if ( ! ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) ) )
      {
         divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) )
         {
            divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable41210( )
   {
      nIsDirty_210 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV26Pgmname = "Convenio_base_calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2060ConveBaseRelSec, GXv_boolean3) ;
         convenio_base_calculo_impl.this.AV25aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      }
      /* Using cursor T00414 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( A1454ConveBaseClaseLeg == 1 ) || ( A1454ConveBaseClaseLeg == 2 ) || ( A1454ConveBaseClaseLeg == 3 ) || ( A1454ConveBaseClaseLeg == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Clase de legajo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEBASECLASELEG");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1455ConveBaseTipo, "licencia") == 0 ) || ( GXutil.strcmp(A1455ConveBaseTipo, "feriado") == 0 ) || ( GXutil.strcmp(A1455ConveBaseTipo, "horaNormal") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEBASETIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveBaseTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_210 = (short)(1) ;
      GXt_char6 = A1608ConveBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
      convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1608ConveBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
      if ( ! ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) ) )
      {
         divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
      }
      else
      {
         if ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) )
         {
            divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
         }
      }
      if ( ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) ) && (0==A2060ConveBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEBASEPLUS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveBasePlus_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1467ConveBasePromTCnt, "dias") == 0 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, "meses") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Días o Meses", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEBASEPROMTCNT");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveBasePromTCnt.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors41210( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_60( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T00416 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
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

   public void getKey41210( )
   {
      /* Using cursor T00417 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound210 = (short)(1) ;
      }
      else
      {
         RcdFound210 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00413 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm41210( 59) ;
         RcdFound210 = (short)(1) ;
         A1454ConveBaseClaseLeg = T00413_A1454ConveBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
         A1455ConveBaseTipo = T00413_A1455ConveBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = T00413_A1456ConveBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         A1457ConveBaseCod2 = T00413_A1457ConveBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
         A1458ConveBasePlus = T00413_A1458ConveBasePlus[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
         A1610ConveLicDLim = T00413_A1610ConveLicDLim[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
         A1611ConveLicDSeman = T00413_A1611ConveLicDSeman[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
         A1612ConveLicDMes = T00413_A1612ConveLicDMes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
         A1613ConveLicDSemes = T00413_A1613ConveLicDSemes[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
         A1614ConveLicDAnual = T00413_A1614ConveLicDAnual[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
         A1615ConveLicAdju = T00413_A1615ConveLicAdju[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
         A1616ConveLicAdjuObl = T00413_A1616ConveLicAdjuObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
         A1617ConveLicNecAut = T00413_A1617ConveLicNecAut[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
         A1618ConveLicIngMot = T00413_A1618ConveLicIngMot[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
         A1619ConveLicMotObl = T00413_A1619ConveLicMotObl[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
         A1465ConveBasePromCnt1 = T00413_A1465ConveBasePromCnt1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
         A1466ConveBasePromCnt2 = T00413_A1466ConveBasePromCnt2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
         A1467ConveBasePromTCnt = T00413_A1467ConveBasePromTCnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
         A2060ConveBaseRelSec = T00413_A2060ConveBaseRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
         A2061ConveBaseRelRef = T00413_A2061ConveBaseRelRef[0] ;
         A2062ConveBaseOld = T00413_A2062ConveBaseOld[0] ;
         A3CliCod = T00413_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T00413_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T00413_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         O1467ConveBasePromTCnt = A1467ConveBasePromTCnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
         O1466ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
         O1465ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
         O1619ConveLicMotObl = A1619ConveLicMotObl ;
         httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
         O1618ConveLicIngMot = A1618ConveLicIngMot ;
         httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
         O1617ConveLicNecAut = A1617ConveLicNecAut ;
         httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
         O1616ConveLicAdjuObl = A1616ConveLicAdjuObl ;
         httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
         O1615ConveLicAdju = A1615ConveLicAdju ;
         httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
         O1614ConveLicDAnual = A1614ConveLicDAnual ;
         httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
         O1613ConveLicDSemes = A1613ConveLicDSemes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
         O1612ConveLicDMes = A1612ConveLicDMes ;
         httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
         O1611ConveLicDSeman = A1611ConveLicDSeman ;
         httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
         O1610ConveLicDLim = A1610ConveLicDLim ;
         httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
         O1458ConveBasePlus = A1458ConveBasePlus ;
         httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1454ConveBaseClaseLeg = A1454ConveBaseClaseLeg ;
         Z1455ConveBaseTipo = A1455ConveBaseTipo ;
         Z1456ConveBaseCod1 = A1456ConveBaseCod1 ;
         Z1457ConveBaseCod2 = A1457ConveBaseCod2 ;
         sMode210 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load41210( ) ;
         if ( AnyError == 1 )
         {
            RcdFound210 = (short)(0) ;
            initializeNonKey41210( ) ;
         }
         Gx_mode = sMode210 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound210 = (short)(0) ;
         initializeNonKey41210( ) ;
         sMode210 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode210 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey41210( ) ;
      if ( RcdFound210 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound210 = (short)(0) ;
      /* Using cursor T00418 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Byte.valueOf(A1454ConveBaseClaseLeg), Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1455ConveBaseTipo, A1455ConveBaseTipo, Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1456ConveBaseCod1, A1456ConveBaseCod1, A1455ConveBaseTipo, Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1457ConveBaseCod2});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00418_A3CliCod[0] < A3CliCod ) || ( T00418_A3CliCod[0] == A3CliCod ) && ( T00418_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( T00418_A1454ConveBaseClaseLeg[0] < A1454ConveBaseClaseLeg ) || ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) < 0 ) || ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1456ConveBaseCod1[0], A1456ConveBaseCod1) < 0 ) || ( GXutil.strcmp(T00418_A1456ConveBaseCod1[0], A1456ConveBaseCod1) == 0 ) && ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1457ConveBaseCod2[0], A1457ConveBaseCod2) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00418_A3CliCod[0] > A3CliCod ) || ( T00418_A3CliCod[0] == A3CliCod ) && ( T00418_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( T00418_A1454ConveBaseClaseLeg[0] > A1454ConveBaseClaseLeg ) || ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) > 0 ) || ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1456ConveBaseCod1[0], A1456ConveBaseCod1) > 0 ) || ( GXutil.strcmp(T00418_A1456ConveBaseCod1[0], A1456ConveBaseCod1) == 0 ) && ( GXutil.strcmp(T00418_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00418_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00418_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00418_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00418_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00418_A1457ConveBaseCod2[0], A1457ConveBaseCod2) > 0 ) ) )
         {
            A3CliCod = T00418_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T00418_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T00418_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1454ConveBaseClaseLeg = T00418_A1454ConveBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
            A1455ConveBaseTipo = T00418_A1455ConveBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
            A1456ConveBaseCod1 = T00418_A1456ConveBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
            A1457ConveBaseCod2 = T00418_A1457ConveBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
            RcdFound210 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound210 = (short)(0) ;
      /* Using cursor T00419 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Byte.valueOf(A1454ConveBaseClaseLeg), Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1455ConveBaseTipo, A1455ConveBaseTipo, Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1456ConveBaseCod1, A1456ConveBaseCod1, A1455ConveBaseTipo, Byte.valueOf(A1454ConveBaseClaseLeg), A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1457ConveBaseCod2});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00419_A3CliCod[0] > A3CliCod ) || ( T00419_A3CliCod[0] == A3CliCod ) && ( T00419_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( T00419_A1454ConveBaseClaseLeg[0] > A1454ConveBaseClaseLeg ) || ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) > 0 ) || ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1456ConveBaseCod1[0], A1456ConveBaseCod1) > 0 ) || ( GXutil.strcmp(T00419_A1456ConveBaseCod1[0], A1456ConveBaseCod1) == 0 ) && ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1457ConveBaseCod2[0], A1457ConveBaseCod2) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00419_A3CliCod[0] < A3CliCod ) || ( T00419_A3CliCod[0] == A3CliCod ) && ( T00419_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( T00419_A1454ConveBaseClaseLeg[0] < A1454ConveBaseClaseLeg ) || ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) < 0 ) || ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1456ConveBaseCod1[0], A1456ConveBaseCod1) < 0 ) || ( GXutil.strcmp(T00419_A1456ConveBaseCod1[0], A1456ConveBaseCod1) == 0 ) && ( GXutil.strcmp(T00419_A1455ConveBaseTipo[0], A1455ConveBaseTipo) == 0 ) && ( T00419_A1454ConveBaseClaseLeg[0] == A1454ConveBaseClaseLeg ) && ( GXutil.strcmp(T00419_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T00419_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T00419_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00419_A1457ConveBaseCod2[0], A1457ConveBaseCod2) < 0 ) ) )
         {
            A3CliCod = T00419_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T00419_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T00419_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1454ConveBaseClaseLeg = T00419_A1454ConveBaseClaseLeg[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
            A1455ConveBaseTipo = T00419_A1455ConveBaseTipo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
            A1456ConveBaseCod1 = T00419_A1456ConveBaseCod1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
            A1457ConveBaseCod2 = T00419_A1457ConveBaseCod2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
            RcdFound210 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey41210( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert41210( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound210 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1454ConveBaseClaseLeg != Z1454ConveBaseClaseLeg ) || ( GXutil.strcmp(A1455ConveBaseTipo, Z1455ConveBaseTipo) != 0 ) || ( GXutil.strcmp(A1456ConveBaseCod1, Z1456ConveBaseCod1) != 0 ) || ( GXutil.strcmp(A1457ConveBaseCod2, Z1457ConveBaseCod2) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1454ConveBaseClaseLeg = Z1454ConveBaseClaseLeg ;
               httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
               A1455ConveBaseTipo = Z1455ConveBaseTipo ;
               httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
               A1456ConveBaseCod1 = Z1456ConveBaseCod1 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
               A1457ConveBaseCod2 = Z1457ConveBaseCod2 ;
               httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update41210( ) ;
               GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1454ConveBaseClaseLeg != Z1454ConveBaseClaseLeg ) || ( GXutil.strcmp(A1455ConveBaseTipo, Z1455ConveBaseTipo) != 0 ) || ( GXutil.strcmp(A1456ConveBaseCod1, Z1456ConveBaseCod1) != 0 ) || ( GXutil.strcmp(A1457ConveBaseCod2, Z1457ConveBaseCod2) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert41210( ) ;
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
                  GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert41210( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( A1454ConveBaseClaseLeg != Z1454ConveBaseClaseLeg ) || ( GXutil.strcmp(A1455ConveBaseTipo, Z1455ConveBaseTipo) != 0 ) || ( GXutil.strcmp(A1456ConveBaseCod1, Z1456ConveBaseCod1) != 0 ) || ( GXutil.strcmp(A1457ConveBaseCod2, Z1457ConveBaseCod2) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1454ConveBaseClaseLeg = Z1454ConveBaseClaseLeg ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
         A1455ConveBaseTipo = Z1455ConveBaseTipo ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = Z1456ConveBaseCod1 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         A1457ConveBaseCod2 = Z1457ConveBaseCod2 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbConveBaseClaseLeg.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency41210( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00412 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio_base_calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1458ConveBasePlus, T00412_A1458ConveBasePlus[0]) != 0 ) || ( Z1610ConveLicDLim != T00412_A1610ConveLicDLim[0] ) || ( Z1611ConveLicDSeman != T00412_A1611ConveLicDSeman[0] ) || ( Z1612ConveLicDMes != T00412_A1612ConveLicDMes[0] ) || ( Z1613ConveLicDSemes != T00412_A1613ConveLicDSemes[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1614ConveLicDAnual != T00412_A1614ConveLicDAnual[0] ) || ( Z1615ConveLicAdju != T00412_A1615ConveLicAdju[0] ) || ( Z1616ConveLicAdjuObl != T00412_A1616ConveLicAdjuObl[0] ) || ( Z1617ConveLicNecAut != T00412_A1617ConveLicNecAut[0] ) || ( Z1618ConveLicIngMot != T00412_A1618ConveLicIngMot[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1619ConveLicMotObl != T00412_A1619ConveLicMotObl[0] ) || ( Z1465ConveBasePromCnt1 != T00412_A1465ConveBasePromCnt1[0] ) || ( Z1466ConveBasePromCnt2 != T00412_A1466ConveBasePromCnt2[0] ) || ( GXutil.strcmp(Z1467ConveBasePromTCnt, T00412_A1467ConveBasePromTCnt[0]) != 0 ) || ( Z2060ConveBaseRelSec != T00412_A2060ConveBaseRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2061ConveBaseRelRef, T00412_A2061ConveBaseRelRef[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1458ConveBasePlus, T00412_A1458ConveBasePlus[0]) != 0 )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBasePlus");
               GXutil.writeLogRaw("Old: ",Z1458ConveBasePlus);
               GXutil.writeLogRaw("Current: ",T00412_A1458ConveBasePlus[0]);
            }
            if ( Z1610ConveLicDLim != T00412_A1610ConveLicDLim[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicDLim");
               GXutil.writeLogRaw("Old: ",Z1610ConveLicDLim);
               GXutil.writeLogRaw("Current: ",T00412_A1610ConveLicDLim[0]);
            }
            if ( Z1611ConveLicDSeman != T00412_A1611ConveLicDSeman[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicDSeman");
               GXutil.writeLogRaw("Old: ",Z1611ConveLicDSeman);
               GXutil.writeLogRaw("Current: ",T00412_A1611ConveLicDSeman[0]);
            }
            if ( Z1612ConveLicDMes != T00412_A1612ConveLicDMes[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicDMes");
               GXutil.writeLogRaw("Old: ",Z1612ConveLicDMes);
               GXutil.writeLogRaw("Current: ",T00412_A1612ConveLicDMes[0]);
            }
            if ( Z1613ConveLicDSemes != T00412_A1613ConveLicDSemes[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicDSemes");
               GXutil.writeLogRaw("Old: ",Z1613ConveLicDSemes);
               GXutil.writeLogRaw("Current: ",T00412_A1613ConveLicDSemes[0]);
            }
            if ( Z1614ConveLicDAnual != T00412_A1614ConveLicDAnual[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicDAnual");
               GXutil.writeLogRaw("Old: ",Z1614ConveLicDAnual);
               GXutil.writeLogRaw("Current: ",T00412_A1614ConveLicDAnual[0]);
            }
            if ( Z1615ConveLicAdju != T00412_A1615ConveLicAdju[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicAdju");
               GXutil.writeLogRaw("Old: ",Z1615ConveLicAdju);
               GXutil.writeLogRaw("Current: ",T00412_A1615ConveLicAdju[0]);
            }
            if ( Z1616ConveLicAdjuObl != T00412_A1616ConveLicAdjuObl[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicAdjuObl");
               GXutil.writeLogRaw("Old: ",Z1616ConveLicAdjuObl);
               GXutil.writeLogRaw("Current: ",T00412_A1616ConveLicAdjuObl[0]);
            }
            if ( Z1617ConveLicNecAut != T00412_A1617ConveLicNecAut[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicNecAut");
               GXutil.writeLogRaw("Old: ",Z1617ConveLicNecAut);
               GXutil.writeLogRaw("Current: ",T00412_A1617ConveLicNecAut[0]);
            }
            if ( Z1618ConveLicIngMot != T00412_A1618ConveLicIngMot[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicIngMot");
               GXutil.writeLogRaw("Old: ",Z1618ConveLicIngMot);
               GXutil.writeLogRaw("Current: ",T00412_A1618ConveLicIngMot[0]);
            }
            if ( Z1619ConveLicMotObl != T00412_A1619ConveLicMotObl[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveLicMotObl");
               GXutil.writeLogRaw("Old: ",Z1619ConveLicMotObl);
               GXutil.writeLogRaw("Current: ",T00412_A1619ConveLicMotObl[0]);
            }
            if ( Z1465ConveBasePromCnt1 != T00412_A1465ConveBasePromCnt1[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBasePromCnt1");
               GXutil.writeLogRaw("Old: ",Z1465ConveBasePromCnt1);
               GXutil.writeLogRaw("Current: ",T00412_A1465ConveBasePromCnt1[0]);
            }
            if ( Z1466ConveBasePromCnt2 != T00412_A1466ConveBasePromCnt2[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBasePromCnt2");
               GXutil.writeLogRaw("Old: ",Z1466ConveBasePromCnt2);
               GXutil.writeLogRaw("Current: ",T00412_A1466ConveBasePromCnt2[0]);
            }
            if ( GXutil.strcmp(Z1467ConveBasePromTCnt, T00412_A1467ConveBasePromTCnt[0]) != 0 )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBasePromTCnt");
               GXutil.writeLogRaw("Old: ",Z1467ConveBasePromTCnt);
               GXutil.writeLogRaw("Current: ",T00412_A1467ConveBasePromTCnt[0]);
            }
            if ( Z2060ConveBaseRelSec != T00412_A2060ConveBaseRelSec[0] )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBaseRelSec");
               GXutil.writeLogRaw("Old: ",Z2060ConveBaseRelSec);
               GXutil.writeLogRaw("Current: ",T00412_A2060ConveBaseRelSec[0]);
            }
            if ( GXutil.strcmp(Z2061ConveBaseRelRef, T00412_A2061ConveBaseRelRef[0]) != 0 )
            {
               GXutil.writeLogln("convenio_base_calculo:[seudo value changed for attri]"+"ConveBaseRelRef");
               GXutil.writeLogRaw("Old: ",Z2061ConveBaseRelRef);
               GXutil.writeLogRaw("Current: ",T00412_A2061ConveBaseRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Convenio_base_calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert41210( )
   {
      beforeValidate41210( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable41210( ) ;
      }
      if ( AnyError == 0 )
      {
         zm41210( 0) ;
         checkOptimisticConcurrency41210( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm41210( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert41210( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004110 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2, A1458ConveBasePlus, Short.valueOf(A1610ConveLicDLim), Byte.valueOf(A1611ConveLicDSeman), Byte.valueOf(A1612ConveLicDMes), Short.valueOf(A1613ConveLicDSemes), Short.valueOf(A1614ConveLicDAnual), Boolean.valueOf(A1615ConveLicAdju), Boolean.valueOf(A1616ConveLicAdjuObl), Boolean.valueOf(A1617ConveLicNecAut), Boolean.valueOf(A1618ConveLicIngMot), Boolean.valueOf(A1619ConveLicMotObl), Short.valueOf(A1465ConveBasePromCnt1), Short.valueOf(A1466ConveBasePromCnt2), A1467ConveBasePromTCnt, Integer.valueOf(A2060ConveBaseRelSec), A2061ConveBaseRelRef, A2062ConveBaseOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
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
                        resetCaption410( ) ;
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
            load41210( ) ;
         }
         endLevel41210( ) ;
      }
      closeExtendedTableCursors41210( ) ;
   }

   public void update41210( )
   {
      beforeValidate41210( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable41210( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency41210( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm41210( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate41210( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T004111 */
                  pr_default.execute(9, new Object[] {A1458ConveBasePlus, Short.valueOf(A1610ConveLicDLim), Byte.valueOf(A1611ConveLicDSeman), Byte.valueOf(A1612ConveLicDMes), Short.valueOf(A1613ConveLicDSemes), Short.valueOf(A1614ConveLicDAnual), Boolean.valueOf(A1615ConveLicAdju), Boolean.valueOf(A1616ConveLicAdjuObl), Boolean.valueOf(A1617ConveLicNecAut), Boolean.valueOf(A1618ConveLicIngMot), Boolean.valueOf(A1619ConveLicMotObl), Short.valueOf(A1465ConveBasePromCnt1), Short.valueOf(A1466ConveBasePromCnt2), A1467ConveBasePromTCnt, Integer.valueOf(A2060ConveBaseRelSec), A2061ConveBaseRelRef, A2062ConveBaseOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio_base_calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate41210( ) ;
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
         endLevel41210( ) ;
      }
      closeExtendedTableCursors41210( ) ;
   }

   public void deferredUpdate41210( )
   {
   }

   public void delete( )
   {
      beforeValidate41210( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency41210( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls41210( ) ;
         afterConfirm41210( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete41210( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T004112 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Byte.valueOf(A1454ConveBaseClaseLeg), A1455ConveBaseTipo, A1456ConveBaseCod1, A1457ConveBaseCod2});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio_base_calculo");
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
      sMode210 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel41210( ) ;
      Gx_mode = sMode210 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls41210( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV25aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2060ConveBaseRelSec, GXv_boolean3) ;
            convenio_base_calculo_impl.this.AV25aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
         }
         AV26Pgmname = "Convenio_base_calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         GXt_char6 = A1608ConveBaseC1Txt ;
         GXv_char7[0] = GXt_char6 ;
         new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
         convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
         A1608ConveBaseC1Txt = GXt_char6 ;
         httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
         if ( ! ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) ) )
         {
            divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
         }
         else
         {
            if ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) )
            {
               divConvebaserelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConvebaserelsec_cell_Internalname, "Class", divConvebaserelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel41210( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete41210( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio_base_calculo");
         if ( AnyError == 0 )
         {
            confirmValues410( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_base_calculo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart41210( )
   {
      /* Scan By routine */
      /* Using cursor T004113 */
      pr_default.execute(11);
      RcdFound210 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound210 = (short)(1) ;
         A3CliCod = T004113_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004113_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004113_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1454ConveBaseClaseLeg = T004113_A1454ConveBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
         A1455ConveBaseTipo = T004113_A1455ConveBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = T004113_A1456ConveBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         A1457ConveBaseCod2 = T004113_A1457ConveBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext41210( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound210 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound210 = (short)(1) ;
         A3CliCod = T004113_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T004113_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T004113_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1454ConveBaseClaseLeg = T004113_A1454ConveBaseClaseLeg[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
         A1455ConveBaseTipo = T004113_A1455ConveBaseTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
         A1456ConveBaseCod1 = T004113_A1456ConveBaseCod1[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
         A1457ConveBaseCod2 = T004113_A1457ConveBaseCod2[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      }
   }

   public void scanEnd41210( )
   {
      pr_default.close(11);
   }

   public void afterConfirm41210( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV25aplicadoHay ) && ! (0==A2060ConveBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveBaseRelSec", 1, "CONVEBASERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveBaseRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert41210( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate41210( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete41210( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete41210( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate41210( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes41210( )
   {
      cmbConveBaseClaseLeg.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseClaseLeg.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseClaseLeg.getEnabled(), 5, 0), true);
      cmbConveBaseTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBaseTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBaseTipo.getEnabled(), 5, 0), true);
      edtConveBaseCod1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod1_Enabled), 5, 0), true);
      edtConveBaseCod2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBaseCod2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBaseCod2_Enabled), 5, 0), true);
      edtConveBasePlus_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePlus_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePlus_Enabled), 5, 0), true);
      edtConveLicDLim_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDLim_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDLim_Enabled), 5, 0), true);
      edtConveLicDSeman_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSeman_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSeman_Enabled), 5, 0), true);
      cmbConveLicDMes.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveLicDMes.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveLicDMes.getEnabled(), 5, 0), true);
      edtConveLicDSemes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDSemes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDSemes_Enabled), 5, 0), true);
      edtConveLicDAnual_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveLicDAnual_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveLicDAnual_Enabled), 5, 0), true);
      chkConveLicAdju.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveLicAdju.getEnabled(), 5, 0), true);
      chkConveLicAdjuObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveLicAdjuObl.getEnabled(), 5, 0), true);
      chkConveLicNecAut.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveLicNecAut.getEnabled(), 5, 0), true);
      chkConveLicIngMot.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveLicIngMot.getEnabled(), 5, 0), true);
      chkConveLicMotObl.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "Enabled", GXutil.ltrimstr( chkConveLicMotObl.getEnabled(), 5, 0), true);
      edtConveBasePromCnt1_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePromCnt1_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePromCnt1_Enabled), 5, 0), true);
      edtConveBasePromCnt2_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveBasePromCnt2_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveBasePromCnt2_Enabled), 5, 0), true);
      cmbConveBasePromTCnt.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveBasePromTCnt.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveBasePromTCnt.getEnabled(), 5, 0), true);
      dynConveBaseRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveBaseRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveBaseRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes41210( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues410( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(AV10ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV11ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV12ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV13ConveBaseCod2))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Convenio_base_calculo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveBaseRelRef", GXutil.rtrim( localUtil.format( A2061ConveBaseRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio_base_calculo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1454ConveBaseClaseLeg", GXutil.ltrim( localUtil.ntoc( Z1454ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1455ConveBaseTipo", GXutil.rtrim( Z1455ConveBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1456ConveBaseCod1", GXutil.rtrim( Z1456ConveBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1457ConveBaseCod2", GXutil.rtrim( Z1457ConveBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1458ConveBasePlus", GXutil.ltrim( localUtil.ntoc( Z1458ConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1610ConveLicDLim", GXutil.ltrim( localUtil.ntoc( Z1610ConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1611ConveLicDSeman", GXutil.ltrim( localUtil.ntoc( Z1611ConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1612ConveLicDMes", GXutil.ltrim( localUtil.ntoc( Z1612ConveLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1613ConveLicDSemes", GXutil.ltrim( localUtil.ntoc( Z1613ConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1614ConveLicDAnual", GXutil.ltrim( localUtil.ntoc( Z1614ConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1615ConveLicAdju", Z1615ConveLicAdju);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1616ConveLicAdjuObl", Z1616ConveLicAdjuObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1617ConveLicNecAut", Z1617ConveLicNecAut);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1618ConveLicIngMot", Z1618ConveLicIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1619ConveLicMotObl", Z1619ConveLicMotObl);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1465ConveBasePromCnt1", GXutil.ltrim( localUtil.ntoc( Z1465ConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1466ConveBasePromCnt2", GXutil.ltrim( localUtil.ntoc( Z1466ConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1467ConveBasePromTCnt", GXutil.rtrim( Z1467ConveBasePromTCnt));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2060ConveBaseRelSec", GXutil.ltrim( localUtil.ntoc( Z2060ConveBaseRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2061ConveBaseRelRef", Z2061ConveBaseRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1467ConveBasePromTCnt", GXutil.rtrim( O1467ConveBasePromTCnt));
      web.GxWebStd.gx_hidden_field( httpContext, "O1466ConveBasePromCnt2", GXutil.ltrim( localUtil.ntoc( O1466ConveBasePromCnt2, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1465ConveBasePromCnt1", GXutil.ltrim( localUtil.ntoc( O1465ConveBasePromCnt1, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1619ConveLicMotObl", O1619ConveLicMotObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1618ConveLicIngMot", O1618ConveLicIngMot);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1617ConveLicNecAut", O1617ConveLicNecAut);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1616ConveLicAdjuObl", O1616ConveLicAdjuObl);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O1615ConveLicAdju", O1615ConveLicAdju);
      web.GxWebStd.gx_hidden_field( httpContext, "O1614ConveLicDAnual", GXutil.ltrim( localUtil.ntoc( O1614ConveLicDAnual, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1613ConveLicDSemes", GXutil.ltrim( localUtil.ntoc( O1613ConveLicDSemes, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1612ConveLicDMes", GXutil.ltrim( localUtil.ntoc( O1612ConveLicDMes, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1611ConveLicDSeman", GXutil.ltrim( localUtil.ntoc( O1611ConveLicDSeman, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1610ConveLicDLim", GXutil.ltrim( localUtil.ntoc( O1610ConveLicDLim, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1458ConveBasePlus", GXutil.ltrim( localUtil.ntoc( O1458ConveBasePlus, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASEC2TXT", A1609ConveBaseC2Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASEC1TXT", A1608ConveBaseC1Txt);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASECLASELEG", GXutil.ltrim( localUtil.ntoc( AV10ConveBaseClaseLeg, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECLASELEG", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV10ConveBaseClaseLeg), "9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASETIPO", GXutil.rtrim( AV11ConveBaseTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASETIPO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConveBaseTipo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASECOD1", GXutil.rtrim( AV12ConveBaseCod1));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECOD1", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV12ConveBaseCod1, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEBASECOD2", GXutil.rtrim( AV13ConveBaseCod2));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEBASECOD2", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV13ConveBaseCod2, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV25aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASERELREF", A2061ConveBaseRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEBASEOLD", A2062ConveBaseOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
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
      return formatLink("web.convenio_base_calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.ltrimstr(AV10ConveBaseClaseLeg,1,0)),GXutil.URLEncode(GXutil.rtrim(AV11ConveBaseTipo)),GXutil.URLEncode(GXutil.rtrim(AV12ConveBaseCod1)),GXutil.URLEncode(GXutil.rtrim(AV13ConveBaseCod2))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveBaseClaseLeg","ConveBaseTipo","ConveBaseCod1","ConveBaseCod2"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio_base_calculo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio_base_calculo", "") ;
   }

   public void initializeNonKey41210( )
   {
      AV25aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      A1608ConveBaseC1Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
      A1609ConveBaseC2Txt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1609ConveBaseC2Txt", A1609ConveBaseC2Txt);
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
      A1610ConveLicDLim = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
      A1611ConveLicDSeman = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
      A1612ConveLicDMes = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
      A1613ConveLicDSemes = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
      A1614ConveLicDAnual = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
      A1615ConveLicAdju = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
      A1616ConveLicAdjuObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
      A1617ConveLicNecAut = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
      A1618ConveLicIngMot = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
      A1619ConveLicMotObl = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
      A1465ConveBasePromCnt1 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
      A1466ConveBasePromCnt2 = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
      A1467ConveBasePromTCnt = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
      A2060ConveBaseRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A2060ConveBaseRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2060ConveBaseRelSec), 6, 0));
      A2061ConveBaseRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2061ConveBaseRelRef", A2061ConveBaseRelRef);
      A2062ConveBaseOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2062ConveBaseOld", A2062ConveBaseOld);
      O1467ConveBasePromTCnt = A1467ConveBasePromTCnt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
      O1466ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1466ConveBasePromCnt2", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1466ConveBasePromCnt2), 3, 0));
      O1465ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1465ConveBasePromCnt1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1465ConveBasePromCnt1), 3, 0));
      O1619ConveLicMotObl = A1619ConveLicMotObl ;
      httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
      O1618ConveLicIngMot = A1618ConveLicIngMot ;
      httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
      O1617ConveLicNecAut = A1617ConveLicNecAut ;
      httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
      O1616ConveLicAdjuObl = A1616ConveLicAdjuObl ;
      httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
      O1615ConveLicAdju = A1615ConveLicAdju ;
      httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
      O1614ConveLicDAnual = A1614ConveLicDAnual ;
      httpContext.ajax_rsp_assign_attri("", false, "A1614ConveLicDAnual", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1614ConveLicDAnual), 3, 0));
      O1613ConveLicDSemes = A1613ConveLicDSemes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1613ConveLicDSemes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1613ConveLicDSemes), 3, 0));
      O1612ConveLicDMes = A1612ConveLicDMes ;
      httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
      O1611ConveLicDSeman = A1611ConveLicDSeman ;
      httpContext.ajax_rsp_assign_attri("", false, "A1611ConveLicDSeman", GXutil.str( A1611ConveLicDSeman, 1, 0));
      O1610ConveLicDLim = A1610ConveLicDLim ;
      httpContext.ajax_rsp_assign_attri("", false, "A1610ConveLicDLim", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1610ConveLicDLim), 3, 0));
      O1458ConveBasePlus = A1458ConveBasePlus ;
      httpContext.ajax_rsp_assign_attri("", false, "A1458ConveBasePlus", GXutil.ltrimstr( A1458ConveBasePlus, 6, 4));
      Z1458ConveBasePlus = DecimalUtil.ZERO ;
      Z1610ConveLicDLim = (short)(0) ;
      Z1611ConveLicDSeman = (byte)(0) ;
      Z1612ConveLicDMes = (byte)(0) ;
      Z1613ConveLicDSemes = (short)(0) ;
      Z1614ConveLicDAnual = (short)(0) ;
      Z1615ConveLicAdju = false ;
      Z1616ConveLicAdjuObl = false ;
      Z1617ConveLicNecAut = false ;
      Z1618ConveLicIngMot = false ;
      Z1619ConveLicMotObl = false ;
      Z1465ConveBasePromCnt1 = (short)(0) ;
      Z1466ConveBasePromCnt2 = (short)(0) ;
      Z1467ConveBasePromTCnt = "" ;
      Z2060ConveBaseRelSec = 0 ;
      Z2061ConveBaseRelRef = "" ;
   }

   public void initAll41210( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1454ConveBaseClaseLeg = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      A1455ConveBaseTipo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      A1456ConveBaseCod1 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1456ConveBaseCod1", A1456ConveBaseCod1);
      A1457ConveBaseCod2 = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1457ConveBaseCod2", A1457ConveBaseCod2);
      initializeNonKey41210( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025131830211", true, true);
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
      httpContext.AddJavascriptSource("convenio_base_calculo.js", "?2025131830211", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbConveBaseClaseLeg.setInternalname( "CONVEBASECLASELEG" );
      cmbConveBaseTipo.setInternalname( "CONVEBASETIPO" );
      edtConveBaseCod1_Internalname = "CONVEBASECOD1" ;
      divConvebasecod1_cell_Internalname = "CONVEBASECOD1_CELL" ;
      edtConveBaseCod2_Internalname = "CONVEBASECOD2" ;
      divConvebasecod2_cell_Internalname = "CONVEBASECOD2_CELL" ;
      edtConveBasePlus_Internalname = "CONVEBASEPLUS" ;
      divConvebaseplus_cell_Internalname = "CONVEBASEPLUS_CELL" ;
      edtConveLicDLim_Internalname = "CONVELICDLIM" ;
      divConvelicdlim_cell_Internalname = "CONVELICDLIM_CELL" ;
      edtConveLicDSeman_Internalname = "CONVELICDSEMAN" ;
      divConvelicdseman_cell_Internalname = "CONVELICDSEMAN_CELL" ;
      cmbConveLicDMes.setInternalname( "CONVELICDMES" );
      divConvelicdmes_cell_Internalname = "CONVELICDMES_CELL" ;
      edtConveLicDSemes_Internalname = "CONVELICDSEMES" ;
      divConvelicdsemes_cell_Internalname = "CONVELICDSEMES_CELL" ;
      edtConveLicDAnual_Internalname = "CONVELICDANUAL" ;
      divConvelicdanual_cell_Internalname = "CONVELICDANUAL_CELL" ;
      chkConveLicAdju.setInternalname( "CONVELICADJU" );
      divConvelicadju_cell_Internalname = "CONVELICADJU_CELL" ;
      chkConveLicAdjuObl.setInternalname( "CONVELICADJUOBL" );
      divConvelicadjuobl_cell_Internalname = "CONVELICADJUOBL_CELL" ;
      chkConveLicNecAut.setInternalname( "CONVELICNECAUT" );
      divConvelicnecaut_cell_Internalname = "CONVELICNECAUT_CELL" ;
      chkConveLicIngMot.setInternalname( "CONVELICINGMOT" );
      divConvelicingmot_cell_Internalname = "CONVELICINGMOT_CELL" ;
      chkConveLicMotObl.setInternalname( "CONVELICMOTOBL" );
      divConvelicmotobl_cell_Internalname = "CONVELICMOTOBL_CELL" ;
      edtConveBasePromCnt1_Internalname = "CONVEBASEPROMCNT1" ;
      edtConveBasePromCnt2_Internalname = "CONVEBASEPROMCNT2" ;
      cmbConveBasePromTCnt.setInternalname( "CONVEBASEPROMTCNT" );
      dynConveBaseRelSec.setInternalname( "CONVEBASERELSEC" );
      divConvebaserelsec_cell_Internalname = "CONVEBASERELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
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
      Form.setCaption( httpContext.getMessage( "Convenio_base_calculo", "") );
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynConveBaseRelSec.setJsonclick( "" );
      dynConveBaseRelSec.setEnabled( 1 );
      divConvebaserelsec_cell_Class = "col-xs-12" ;
      cmbConveBasePromTCnt.setJsonclick( "" );
      cmbConveBasePromTCnt.setEnabled( 1 );
      edtConveBasePromCnt2_Jsonclick = "" ;
      edtConveBasePromCnt2_Enabled = 1 ;
      edtConveBasePromCnt1_Jsonclick = "" ;
      edtConveBasePromCnt1_Enabled = 1 ;
      chkConveLicMotObl.setEnabled( 1 );
      chkConveLicMotObl.setVisible( 1 );
      divConvelicmotobl_cell_Class = "col-xs-12" ;
      chkConveLicIngMot.setEnabled( 1 );
      chkConveLicIngMot.setVisible( 1 );
      divConvelicingmot_cell_Class = "col-xs-12" ;
      chkConveLicNecAut.setEnabled( 1 );
      chkConveLicNecAut.setVisible( 1 );
      divConvelicnecaut_cell_Class = "col-xs-12" ;
      chkConveLicAdjuObl.setEnabled( 1 );
      chkConveLicAdjuObl.setVisible( 1 );
      divConvelicadjuobl_cell_Class = "col-xs-12" ;
      chkConveLicAdju.setEnabled( 1 );
      chkConveLicAdju.setVisible( 1 );
      divConvelicadju_cell_Class = "col-xs-12" ;
      edtConveLicDAnual_Jsonclick = "" ;
      edtConveLicDAnual_Enabled = 1 ;
      edtConveLicDAnual_Visible = 1 ;
      divConvelicdanual_cell_Class = "col-xs-12" ;
      edtConveLicDSemes_Jsonclick = "" ;
      edtConveLicDSemes_Enabled = 1 ;
      edtConveLicDSemes_Visible = 1 ;
      divConvelicdsemes_cell_Class = "col-xs-12" ;
      cmbConveLicDMes.setJsonclick( "" );
      cmbConveLicDMes.setEnabled( 1 );
      cmbConveLicDMes.setVisible( 1 );
      divConvelicdmes_cell_Class = "col-xs-12" ;
      edtConveLicDSeman_Jsonclick = "" ;
      edtConveLicDSeman_Enabled = 1 ;
      edtConveLicDSeman_Visible = 1 ;
      divConvelicdseman_cell_Class = "col-xs-12" ;
      edtConveLicDLim_Jsonclick = "" ;
      edtConveLicDLim_Enabled = 1 ;
      edtConveLicDLim_Visible = 1 ;
      divConvelicdlim_cell_Class = "col-xs-12" ;
      edtConveBasePlus_Jsonclick = "" ;
      edtConveBasePlus_Enabled = 1 ;
      edtConveBasePlus_Visible = 1 ;
      divConvebaseplus_cell_Class = "col-xs-12" ;
      edtConveBaseCod2_Jsonclick = "" ;
      edtConveBaseCod2_Enabled = 1 ;
      edtConveBaseCod2_Visible = 1 ;
      divConvebasecod2_cell_Class = "col-xs-12" ;
      edtConveBaseCod1_Jsonclick = "" ;
      edtConveBaseCod1_Enabled = 1 ;
      edtConveBaseCod1_Visible = 1 ;
      divConvebasecod1_cell_Class = "col-xs-12" ;
      cmbConveBaseTipo.setJsonclick( "" );
      cmbConveBaseTipo.setEnabled( 1 );
      cmbConveBaseClaseLeg.setJsonclick( "" );
      cmbConveBaseClaseLeg.setEnabled( 1 );
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

   public void gxdlaconvebaserelsec41210( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvebaserelsec_data41210( AV7CliCod) ;
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

   public void gxaconvebaserelsec_html41210( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconvebaserelsec_data41210( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveBaseRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveBaseRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvebaserelsec_data41210( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T004114 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T004114_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T004114_A1880CliReDTChar[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gx5asaconvebasec1txt41210( int A3CliCod ,
                                          String A1455ConveBaseTipo ,
                                          String A1456ConveBaseCod1 )
   {
      GXt_char6 = A1608ConveBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
      convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1608ConveBaseC1Txt = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1608ConveBaseC1Txt)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx6asaclicod41210( int AV7CliCod )
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
            GXt_int4 = A3CliCod ;
            GXv_int5[0] = GXt_int4 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int5) ;
            convenio_base_calculo_impl.this.GXt_int4 = GXv_int5[0] ;
            A3CliCod = GXt_int4 ;
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

   public void xc_57_41210( String Gx_mode ,
                            int AV7CliCod ,
                            int A2060ConveBaseRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2060ConveBaseRelSec, GXv_boolean3) ;
         AV25aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV25aplicadoHay))+"\"") ;
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
      cmbConveBaseClaseLeg.setName( "CONVEBASECLASELEG" );
      cmbConveBaseClaseLeg.setWebtags( "" );
      cmbConveBaseClaseLeg.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbConveBaseClaseLeg.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1454ConveBaseClaseLeg", GXutil.str( A1454ConveBaseClaseLeg, 1, 0));
      }
      cmbConveBaseTipo.setName( "CONVEBASETIPO" );
      cmbConveBaseTipo.setWebtags( "" );
      cmbConveBaseTipo.addItem("licencia", httpContext.getMessage( "Licencia", ""), (short)(0));
      cmbConveBaseTipo.addItem("feriado", httpContext.getMessage( "Feriado/No laborable", ""), (short)(0));
      cmbConveBaseTipo.addItem("horaNormal", httpContext.getMessage( "Hora Normal", ""), (short)(0));
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1455ConveBaseTipo", A1455ConveBaseTipo);
      }
      cmbConveLicDMes.setName( "CONVELICDMES" );
      cmbConveLicDMes.setWebtags( "" );
      if ( cmbConveLicDMes.getItemCount() > 0 )
      {
         A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValidValue(GXutil.trim( GXutil.str( A1612ConveLicDMes, 2, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1612ConveLicDMes", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1612ConveLicDMes), 2, 0));
      }
      chkConveLicAdju.setName( "CONVELICADJU" );
      chkConveLicAdju.setWebtags( "" );
      chkConveLicAdju.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdju.getInternalname(), "TitleCaption", chkConveLicAdju.getCaption(), true);
      chkConveLicAdju.setCheckedValue( "false" );
      A1615ConveLicAdju = GXutil.strtobool( GXutil.booltostr( A1615ConveLicAdju)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1615ConveLicAdju", A1615ConveLicAdju);
      chkConveLicAdjuObl.setName( "CONVELICADJUOBL" );
      chkConveLicAdjuObl.setWebtags( "" );
      chkConveLicAdjuObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicAdjuObl.getInternalname(), "TitleCaption", chkConveLicAdjuObl.getCaption(), true);
      chkConveLicAdjuObl.setCheckedValue( "false" );
      A1616ConveLicAdjuObl = GXutil.strtobool( GXutil.booltostr( A1616ConveLicAdjuObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1616ConveLicAdjuObl", A1616ConveLicAdjuObl);
      chkConveLicNecAut.setName( "CONVELICNECAUT" );
      chkConveLicNecAut.setWebtags( "" );
      chkConveLicNecAut.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicNecAut.getInternalname(), "TitleCaption", chkConveLicNecAut.getCaption(), true);
      chkConveLicNecAut.setCheckedValue( "false" );
      A1617ConveLicNecAut = GXutil.strtobool( GXutil.booltostr( A1617ConveLicNecAut)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1617ConveLicNecAut", A1617ConveLicNecAut);
      chkConveLicIngMot.setName( "CONVELICINGMOT" );
      chkConveLicIngMot.setWebtags( "" );
      chkConveLicIngMot.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicIngMot.getInternalname(), "TitleCaption", chkConveLicIngMot.getCaption(), true);
      chkConveLicIngMot.setCheckedValue( "false" );
      A1618ConveLicIngMot = GXutil.strtobool( GXutil.booltostr( A1618ConveLicIngMot)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1618ConveLicIngMot", A1618ConveLicIngMot);
      chkConveLicMotObl.setName( "CONVELICMOTOBL" );
      chkConveLicMotObl.setWebtags( "" );
      chkConveLicMotObl.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkConveLicMotObl.getInternalname(), "TitleCaption", chkConveLicMotObl.getCaption(), true);
      chkConveLicMotObl.setCheckedValue( "false" );
      A1619ConveLicMotObl = GXutil.strtobool( GXutil.booltostr( A1619ConveLicMotObl)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1619ConveLicMotObl", A1619ConveLicMotObl);
      cmbConveBasePromTCnt.setName( "CONVEBASEPROMTCNT" );
      cmbConveBasePromTCnt.setWebtags( "" );
      cmbConveBasePromTCnt.addItem("dias", httpContext.getMessage( "días", ""), (short)(0));
      cmbConveBasePromTCnt.addItem("meses", httpContext.getMessage( "meses", ""), (short)(0));
      if ( cmbConveBasePromTCnt.getItemCount() > 0 )
      {
         A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValidValue(A1467ConveBasePromTCnt) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1467ConveBasePromTCnt", A1467ConveBasePromTCnt);
      }
      dynConveBaseRelSec.setName( "CONVEBASERELSEC" );
      dynConveBaseRelSec.setWebtags( "" );
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
      A1455ConveBaseTipo = cmbConveBaseTipo.getValue() ;
      A2060ConveBaseRelSec = (int)(GXutil.lval( dynConveBaseRelSec.getValue())) ;
      GXt_char6 = A1608ConveBaseC1Txt ;
      GXv_char7[0] = GXt_char6 ;
      new web.gettxtbasecod1(remoteHandle, context).execute( A3CliCod, A1455ConveBaseTipo, A1456ConveBaseCod1, GXv_char7) ;
      convenio_base_calculo_impl.this.GXt_char6 = GXv_char7[0] ;
      A1608ConveBaseC1Txt = GXt_char6 ;
      dynload_actions( ) ;
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
      }
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1608ConveBaseC1Txt", A1608ConveBaseC1Txt);
   }

   public void valid_Cliconvenio( )
   {
      A2060ConveBaseRelSec = (int)(GXutil.lval( dynConveBaseRelSec.getValue())) ;
      /* Using cursor T004115 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
      }
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
      }
      /*  Sending validation outputs */
   }

   public void valid_Convebaserelsec( )
   {
      A1612ConveLicDMes = (byte)(GXutil.lval( cmbConveLicDMes.getValue())) ;
      A1467ConveBasePromTCnt = cmbConveBasePromTCnt.getValue() ;
      A2060ConveBaseRelSec = (int)(GXutil.lval( dynConveBaseRelSec.getValue())) ;
      if ( ( ( DecimalUtil.compareTo(A1458ConveBasePlus, O1458ConveBasePlus) != 0 ) || ( A1610ConveLicDLim != O1610ConveLicDLim ) || ( A1611ConveLicDSeman != O1611ConveLicDSeman ) || ( A1612ConveLicDMes != O1612ConveLicDMes ) || ( A1613ConveLicDSemes != O1613ConveLicDSemes ) || ( A1614ConveLicDAnual != O1614ConveLicDAnual ) || ( A1615ConveLicAdju != O1615ConveLicAdju ) || ( A1616ConveLicAdjuObl != O1616ConveLicAdjuObl ) || ( A1617ConveLicNecAut != O1617ConveLicNecAut ) || ( A1618ConveLicIngMot != O1618ConveLicIngMot ) || ( A1619ConveLicMotObl != O1619ConveLicMotObl ) || ( A1465ConveBasePromCnt1 != O1465ConveBasePromCnt1 ) || ( A1466ConveBasePromCnt2 != O1466ConveBasePromCnt2 ) || ( GXutil.strcmp(A1467ConveBasePromTCnt, O1467ConveBasePromTCnt) != 0 ) ) && (0==A2060ConveBaseRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEBASERELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveBaseRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV25aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A2060ConveBaseRelSec, GXv_boolean3) ;
         convenio_base_calculo_impl.this.AV25aplicadoHay = GXv_boolean3[0] ;
         AV25aplicadoHay = this.AV25aplicadoHay ;
      }
      O1467ConveBasePromTCnt = A1467ConveBasePromTCnt ;
      O1466ConveBasePromCnt2 = A1466ConveBasePromCnt2 ;
      O1465ConveBasePromCnt1 = A1465ConveBasePromCnt1 ;
      O1619ConveLicMotObl = A1619ConveLicMotObl ;
      O1618ConveLicIngMot = A1618ConveLicIngMot ;
      O1617ConveLicNecAut = A1617ConveLicNecAut ;
      O1616ConveLicAdjuObl = A1616ConveLicAdjuObl ;
      O1615ConveLicAdju = A1615ConveLicAdju ;
      O1614ConveLicDAnual = A1614ConveLicDAnual ;
      O1613ConveLicDSemes = A1613ConveLicDSemes ;
      O1612ConveLicDMes = A1612ConveLicDMes ;
      O1611ConveLicDSeman = A1611ConveLicDSeman ;
      O1610ConveLicDLim = A1610ConveLicDLim ;
      O1458ConveBasePlus = A1458ConveBasePlus ;
      dynload_actions( ) ;
      if ( cmbConveBaseClaseLeg.getItemCount() > 0 )
      {
         A1454ConveBaseClaseLeg = (byte)(GXutil.lval( cmbConveBaseClaseLeg.getValidValue(GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseClaseLeg.setValue( GXutil.trim( GXutil.str( A1454ConveBaseClaseLeg, 1, 0)) );
      }
      if ( cmbConveBaseTipo.getItemCount() > 0 )
      {
         A1455ConveBaseTipo = cmbConveBaseTipo.getValidValue(A1455ConveBaseTipo) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveBaseTipo.setValue( GXutil.rtrim( A1455ConveBaseTipo) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV25aplicadoHay", AV25aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV11ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV12ConveBaseCod1',fld:'vCONVEBASECOD1',pic:'',hsh:true},{av:'AV13ConveBaseCod2',fld:'vCONVEBASECOD2',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10ConveBaseClaseLeg',fld:'vCONVEBASECLASELEG',pic:'9',hsh:true},{av:'AV11ConveBaseTipo',fld:'vCONVEBASETIPO',pic:'',hsh:true},{av:'AV12ConveBaseCod1',fld:'vCONVEBASECOD1',pic:'',hsh:true},{av:'AV13ConveBaseCod2',fld:'vCONVEBASECOD2',pic:'',hsh:true},{av:'A2061ConveBaseRelRef',fld:'CONVEBASERELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12412',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASECLASELEG","{handler:'valid_Convebaseclaseleg',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASECLASELEG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASETIPO","{handler:'valid_Convebasetipo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASETIPO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASECOD1","{handler:'valid_Convebasecod1',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASECOD1",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASECOD2","{handler:'valid_Convebasecod2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASECOD2",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASEPLUS","{handler:'valid_Convebaseplus',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASEPLUS",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICDLIM","{handler:'valid_Convelicdlim',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICDLIM",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICDSEMAN","{handler:'valid_Convelicdseman',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICDSEMAN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICDMES","{handler:'valid_Convelicdmes',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICDMES",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICDSEMES","{handler:'valid_Convelicdsemes',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICDSEMES",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICDANUAL","{handler:'valid_Convelicdanual',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICDANUAL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICADJU","{handler:'valid_Convelicadju',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICADJU",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICADJUOBL","{handler:'valid_Convelicadjuobl',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICADJUOBL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICNECAUT","{handler:'valid_Convelicnecaut',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICNECAUT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICINGMOT","{handler:'valid_Convelicingmot',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICINGMOT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVELICMOTOBL","{handler:'valid_Convelicmotobl',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVELICMOTOBL",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASEPROMCNT1","{handler:'valid_Convebasepromcnt1',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASEPROMCNT1",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASEPROMCNT2","{handler:'valid_Convebasepromcnt2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASEPROMCNT2",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASEPROMTCNT","{handler:'valid_Convebasepromtcnt',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASEPROMTCNT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CONVEBASERELSEC","{handler:'valid_Convebaserelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1467ConveBasePromTCnt'},{av:'O1466ConveBasePromCnt2'},{av:'O1465ConveBasePromCnt1'},{av:'O1619ConveLicMotObl'},{av:'O1618ConveLicIngMot'},{av:'O1617ConveLicNecAut'},{av:'O1616ConveLicAdjuObl'},{av:'O1615ConveLicAdju'},{av:'O1614ConveLicDAnual'},{av:'O1613ConveLicDSemes'},{av:'O1612ConveLicDMes'},{av:'O1611ConveLicDSeman'},{av:'O1610ConveLicDLim'},{av:'O1458ConveBasePlus'},{av:'A1458ConveBasePlus',fld:'CONVEBASEPLUS',pic:'9.9999'},{av:'A1610ConveLicDLim',fld:'CONVELICDLIM',pic:'ZZ9'},{av:'A1611ConveLicDSeman',fld:'CONVELICDSEMAN',pic:'9'},{av:'cmbConveLicDMes'},{av:'A1612ConveLicDMes',fld:'CONVELICDMES',pic:'Z9'},{av:'A1613ConveLicDSemes',fld:'CONVELICDSEMES',pic:'ZZ9'},{av:'A1614ConveLicDAnual',fld:'CONVELICDANUAL',pic:'ZZ9'},{av:'A1465ConveBasePromCnt1',fld:'CONVEBASEPROMCNT1',pic:'ZZ9'},{av:'A1466ConveBasePromCnt2',fld:'CONVEBASEPROMCNT2',pic:'ZZ9'},{av:'cmbConveBasePromTCnt'},{av:'A1467ConveBasePromTCnt',fld:'CONVEBASEPROMTCNT',pic:''},{av:'AV25aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CONVEBASERELSEC",",oparms:[{av:'AV25aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'cmbConveBaseTipo'},{av:'A1455ConveBaseTipo',fld:'CONVEBASETIPO',pic:''},{av:'A1456ConveBaseCod1',fld:'CONVEBASECOD1',pic:''},{av:'A1608ConveBaseC1Txt',fld:'CONVEBASEC1TXT',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'A1608ConveBaseC1Txt',fld:'CONVEBASEC1TXT',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveBaseRelSec'},{av:'A2060ConveBaseRelSec',fld:'CONVEBASERELSEC',pic:'ZZZZZ9'},{av:'A1615ConveLicAdju',fld:'CONVELICADJU',pic:''},{av:'A1616ConveLicAdjuObl',fld:'CONVELICADJUOBL',pic:''},{av:'A1617ConveLicNecAut',fld:'CONVELICNECAUT',pic:''},{av:'A1618ConveLicIngMot',fld:'CONVELICINGMOT',pic:''},{av:'A1619ConveLicMotObl',fld:'CONVELICMOTOBL',pic:''}]}");
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
      wcpOAV9CliConvenio = "" ;
      wcpOAV11ConveBaseTipo = "" ;
      wcpOAV12ConveBaseCod1 = "" ;
      wcpOAV13ConveBaseCod2 = "" ;
      Z1565CliConvenio = "" ;
      Z1455ConveBaseTipo = "" ;
      Z1456ConveBaseCod1 = "" ;
      Z1457ConveBaseCod2 = "" ;
      Z1458ConveBasePlus = DecimalUtil.ZERO ;
      Z1467ConveBasePromTCnt = "" ;
      Z2061ConveBaseRelRef = "" ;
      O1467ConveBasePromTCnt = "" ;
      O1458ConveBasePlus = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1455ConveBaseTipo = "" ;
      A1456ConveBaseCod1 = "" ;
      A1565CliConvenio = "" ;
      AV9CliConvenio = "" ;
      AV11ConveBaseTipo = "" ;
      AV12ConveBaseCod1 = "" ;
      AV13ConveBaseCod2 = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1467ConveBasePromTCnt = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A1457ConveBaseCod2 = "" ;
      A1458ConveBasePlus = DecimalUtil.ZERO ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2061ConveBaseRelRef = "" ;
      A1609ConveBaseC2Txt = "" ;
      A1608ConveBaseC1Txt = "" ;
      A2062ConveBaseOld = "" ;
      AV26Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode210 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV14WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV17TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV18WebSession = httpContext.getWebSession();
      Z2062ConveBaseOld = "" ;
      T00415_A1454ConveBaseClaseLeg = new byte[1] ;
      T00415_A1455ConveBaseTipo = new String[] {""} ;
      T00415_A1456ConveBaseCod1 = new String[] {""} ;
      T00415_A1457ConveBaseCod2 = new String[] {""} ;
      T00415_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00415_A1610ConveLicDLim = new short[1] ;
      T00415_A1611ConveLicDSeman = new byte[1] ;
      T00415_A1612ConveLicDMes = new byte[1] ;
      T00415_A1613ConveLicDSemes = new short[1] ;
      T00415_A1614ConveLicDAnual = new short[1] ;
      T00415_A1615ConveLicAdju = new boolean[] {false} ;
      T00415_A1616ConveLicAdjuObl = new boolean[] {false} ;
      T00415_A1617ConveLicNecAut = new boolean[] {false} ;
      T00415_A1618ConveLicIngMot = new boolean[] {false} ;
      T00415_A1619ConveLicMotObl = new boolean[] {false} ;
      T00415_A1465ConveBasePromCnt1 = new short[1] ;
      T00415_A1466ConveBasePromCnt2 = new short[1] ;
      T00415_A1467ConveBasePromTCnt = new String[] {""} ;
      T00415_A2060ConveBaseRelSec = new int[1] ;
      T00415_A2061ConveBaseRelRef = new String[] {""} ;
      T00415_A2062ConveBaseOld = new String[] {""} ;
      T00415_A3CliCod = new int[1] ;
      T00415_A1564CliPaiConve = new short[1] ;
      T00415_A1565CliConvenio = new String[] {""} ;
      T00414_A3CliCod = new int[1] ;
      T00416_A3CliCod = new int[1] ;
      T00417_A3CliCod = new int[1] ;
      T00417_A1564CliPaiConve = new short[1] ;
      T00417_A1565CliConvenio = new String[] {""} ;
      T00417_A1454ConveBaseClaseLeg = new byte[1] ;
      T00417_A1455ConveBaseTipo = new String[] {""} ;
      T00417_A1456ConveBaseCod1 = new String[] {""} ;
      T00417_A1457ConveBaseCod2 = new String[] {""} ;
      T00413_A1454ConveBaseClaseLeg = new byte[1] ;
      T00413_A1455ConveBaseTipo = new String[] {""} ;
      T00413_A1456ConveBaseCod1 = new String[] {""} ;
      T00413_A1457ConveBaseCod2 = new String[] {""} ;
      T00413_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00413_A1610ConveLicDLim = new short[1] ;
      T00413_A1611ConveLicDSeman = new byte[1] ;
      T00413_A1612ConveLicDMes = new byte[1] ;
      T00413_A1613ConveLicDSemes = new short[1] ;
      T00413_A1614ConveLicDAnual = new short[1] ;
      T00413_A1615ConveLicAdju = new boolean[] {false} ;
      T00413_A1616ConveLicAdjuObl = new boolean[] {false} ;
      T00413_A1617ConveLicNecAut = new boolean[] {false} ;
      T00413_A1618ConveLicIngMot = new boolean[] {false} ;
      T00413_A1619ConveLicMotObl = new boolean[] {false} ;
      T00413_A1465ConveBasePromCnt1 = new short[1] ;
      T00413_A1466ConveBasePromCnt2 = new short[1] ;
      T00413_A1467ConveBasePromTCnt = new String[] {""} ;
      T00413_A2060ConveBaseRelSec = new int[1] ;
      T00413_A2061ConveBaseRelRef = new String[] {""} ;
      T00413_A2062ConveBaseOld = new String[] {""} ;
      T00413_A3CliCod = new int[1] ;
      T00413_A1564CliPaiConve = new short[1] ;
      T00413_A1565CliConvenio = new String[] {""} ;
      T00418_A3CliCod = new int[1] ;
      T00418_A1564CliPaiConve = new short[1] ;
      T00418_A1565CliConvenio = new String[] {""} ;
      T00418_A1454ConveBaseClaseLeg = new byte[1] ;
      T00418_A1455ConveBaseTipo = new String[] {""} ;
      T00418_A1456ConveBaseCod1 = new String[] {""} ;
      T00418_A1457ConveBaseCod2 = new String[] {""} ;
      T00419_A3CliCod = new int[1] ;
      T00419_A1564CliPaiConve = new short[1] ;
      T00419_A1565CliConvenio = new String[] {""} ;
      T00419_A1454ConveBaseClaseLeg = new byte[1] ;
      T00419_A1455ConveBaseTipo = new String[] {""} ;
      T00419_A1456ConveBaseCod1 = new String[] {""} ;
      T00419_A1457ConveBaseCod2 = new String[] {""} ;
      T00412_A1454ConveBaseClaseLeg = new byte[1] ;
      T00412_A1455ConveBaseTipo = new String[] {""} ;
      T00412_A1456ConveBaseCod1 = new String[] {""} ;
      T00412_A1457ConveBaseCod2 = new String[] {""} ;
      T00412_A1458ConveBasePlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00412_A1610ConveLicDLim = new short[1] ;
      T00412_A1611ConveLicDSeman = new byte[1] ;
      T00412_A1612ConveLicDMes = new byte[1] ;
      T00412_A1613ConveLicDSemes = new short[1] ;
      T00412_A1614ConveLicDAnual = new short[1] ;
      T00412_A1615ConveLicAdju = new boolean[] {false} ;
      T00412_A1616ConveLicAdjuObl = new boolean[] {false} ;
      T00412_A1617ConveLicNecAut = new boolean[] {false} ;
      T00412_A1618ConveLicIngMot = new boolean[] {false} ;
      T00412_A1619ConveLicMotObl = new boolean[] {false} ;
      T00412_A1465ConveBasePromCnt1 = new short[1] ;
      T00412_A1466ConveBasePromCnt2 = new short[1] ;
      T00412_A1467ConveBasePromTCnt = new String[] {""} ;
      T00412_A2060ConveBaseRelSec = new int[1] ;
      T00412_A2061ConveBaseRelRef = new String[] {""} ;
      T00412_A2062ConveBaseOld = new String[] {""} ;
      T00412_A3CliCod = new int[1] ;
      T00412_A1564CliPaiConve = new short[1] ;
      T00412_A1565CliConvenio = new String[] {""} ;
      T004113_A3CliCod = new int[1] ;
      T004113_A1564CliPaiConve = new short[1] ;
      T004113_A1565CliConvenio = new String[] {""} ;
      T004113_A1454ConveBaseClaseLeg = new byte[1] ;
      T004113_A1455ConveBaseTipo = new String[] {""} ;
      T004113_A1456ConveBaseCod1 = new String[] {""} ;
      T004113_A1457ConveBaseCod2 = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T004114_A3CliCod = new int[1] ;
      T004114_A1885CliRelSec = new int[1] ;
      T004114_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      Z1608ConveBaseC1Txt = "" ;
      T004115_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_base_calculo__default(),
         new Object[] {
             new Object[] {
            T00412_A1454ConveBaseClaseLeg, T00412_A1455ConveBaseTipo, T00412_A1456ConveBaseCod1, T00412_A1457ConveBaseCod2, T00412_A1458ConveBasePlus, T00412_A1610ConveLicDLim, T00412_A1611ConveLicDSeman, T00412_A1612ConveLicDMes, T00412_A1613ConveLicDSemes, T00412_A1614ConveLicDAnual,
            T00412_A1615ConveLicAdju, T00412_A1616ConveLicAdjuObl, T00412_A1617ConveLicNecAut, T00412_A1618ConveLicIngMot, T00412_A1619ConveLicMotObl, T00412_A1465ConveBasePromCnt1, T00412_A1466ConveBasePromCnt2, T00412_A1467ConveBasePromTCnt, T00412_A2060ConveBaseRelSec, T00412_A2061ConveBaseRelRef,
            T00412_A2062ConveBaseOld, T00412_A3CliCod, T00412_A1564CliPaiConve, T00412_A1565CliConvenio
            }
            , new Object[] {
            T00413_A1454ConveBaseClaseLeg, T00413_A1455ConveBaseTipo, T00413_A1456ConveBaseCod1, T00413_A1457ConveBaseCod2, T00413_A1458ConveBasePlus, T00413_A1610ConveLicDLim, T00413_A1611ConveLicDSeman, T00413_A1612ConveLicDMes, T00413_A1613ConveLicDSemes, T00413_A1614ConveLicDAnual,
            T00413_A1615ConveLicAdju, T00413_A1616ConveLicAdjuObl, T00413_A1617ConveLicNecAut, T00413_A1618ConveLicIngMot, T00413_A1619ConveLicMotObl, T00413_A1465ConveBasePromCnt1, T00413_A1466ConveBasePromCnt2, T00413_A1467ConveBasePromTCnt, T00413_A2060ConveBaseRelSec, T00413_A2061ConveBaseRelRef,
            T00413_A2062ConveBaseOld, T00413_A3CliCod, T00413_A1564CliPaiConve, T00413_A1565CliConvenio
            }
            , new Object[] {
            T00414_A3CliCod
            }
            , new Object[] {
            T00415_A1454ConveBaseClaseLeg, T00415_A1455ConveBaseTipo, T00415_A1456ConveBaseCod1, T00415_A1457ConveBaseCod2, T00415_A1458ConveBasePlus, T00415_A1610ConveLicDLim, T00415_A1611ConveLicDSeman, T00415_A1612ConveLicDMes, T00415_A1613ConveLicDSemes, T00415_A1614ConveLicDAnual,
            T00415_A1615ConveLicAdju, T00415_A1616ConveLicAdjuObl, T00415_A1617ConveLicNecAut, T00415_A1618ConveLicIngMot, T00415_A1619ConveLicMotObl, T00415_A1465ConveBasePromCnt1, T00415_A1466ConveBasePromCnt2, T00415_A1467ConveBasePromTCnt, T00415_A2060ConveBaseRelSec, T00415_A2061ConveBaseRelRef,
            T00415_A2062ConveBaseOld, T00415_A3CliCod, T00415_A1564CliPaiConve, T00415_A1565CliConvenio
            }
            , new Object[] {
            T00416_A3CliCod
            }
            , new Object[] {
            T00417_A3CliCod, T00417_A1564CliPaiConve, T00417_A1565CliConvenio, T00417_A1454ConveBaseClaseLeg, T00417_A1455ConveBaseTipo, T00417_A1456ConveBaseCod1, T00417_A1457ConveBaseCod2
            }
            , new Object[] {
            T00418_A3CliCod, T00418_A1564CliPaiConve, T00418_A1565CliConvenio, T00418_A1454ConveBaseClaseLeg, T00418_A1455ConveBaseTipo, T00418_A1456ConveBaseCod1, T00418_A1457ConveBaseCod2
            }
            , new Object[] {
            T00419_A3CliCod, T00419_A1564CliPaiConve, T00419_A1565CliConvenio, T00419_A1454ConveBaseClaseLeg, T00419_A1455ConveBaseTipo, T00419_A1456ConveBaseCod1, T00419_A1457ConveBaseCod2
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T004113_A3CliCod, T004113_A1564CliPaiConve, T004113_A1565CliConvenio, T004113_A1454ConveBaseClaseLeg, T004113_A1455ConveBaseTipo, T004113_A1456ConveBaseCod1, T004113_A1457ConveBaseCod2
            }
            , new Object[] {
            T004114_A3CliCod, T004114_A1885CliRelSec, T004114_A1880CliReDTChar
            }
            , new Object[] {
            T004115_A3CliCod
            }
         }
      );
      AV26Pgmname = "Convenio_base_calculo" ;
   }

   private byte wcpOAV10ConveBaseClaseLeg ;
   private byte Z1454ConveBaseClaseLeg ;
   private byte Z1611ConveLicDSeman ;
   private byte Z1612ConveLicDMes ;
   private byte O1612ConveLicDMes ;
   private byte O1611ConveLicDSeman ;
   private byte GxWebError ;
   private byte AV10ConveBaseClaseLeg ;
   private byte nKeyPressed ;
   private byte A1454ConveBaseClaseLeg ;
   private byte A1612ConveLicDMes ;
   private byte A1611ConveLicDSeman ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short Z1610ConveLicDLim ;
   private short Z1613ConveLicDSemes ;
   private short Z1614ConveLicDAnual ;
   private short Z1465ConveBasePromCnt1 ;
   private short Z1466ConveBasePromCnt2 ;
   private short O1466ConveBasePromCnt2 ;
   private short O1465ConveBasePromCnt1 ;
   private short O1614ConveLicDAnual ;
   private short O1613ConveLicDSemes ;
   private short O1610ConveLicDLim ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A1610ConveLicDLim ;
   private short A1613ConveLicDSemes ;
   private short A1614ConveLicDAnual ;
   private short A1465ConveBasePromCnt1 ;
   private short A1466ConveBasePromCnt2 ;
   private short RcdFound210 ;
   private short nIsDirty_210 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z2060ConveBaseRelSec ;
   private int AV7CliCod ;
   private int A2060ConveBaseRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveBaseCod1_Visible ;
   private int edtConveBaseCod1_Enabled ;
   private int edtConveBaseCod2_Visible ;
   private int edtConveBaseCod2_Enabled ;
   private int edtConveBasePlus_Visible ;
   private int edtConveBasePlus_Enabled ;
   private int edtConveLicDLim_Visible ;
   private int edtConveLicDLim_Enabled ;
   private int edtConveLicDSeman_Visible ;
   private int edtConveLicDSeman_Enabled ;
   private int edtConveLicDSemes_Visible ;
   private int edtConveLicDSemes_Enabled ;
   private int edtConveLicDAnual_Visible ;
   private int edtConveLicDAnual_Enabled ;
   private int edtConveBasePromCnt1_Enabled ;
   private int edtConveBasePromCnt2_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int edtCliConvenio_Visible ;
   private int edtCliConvenio_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private java.math.BigDecimal Z1458ConveBasePlus ;
   private java.math.BigDecimal O1458ConveBasePlus ;
   private java.math.BigDecimal A1458ConveBasePlus ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV11ConveBaseTipo ;
   private String wcpOAV12ConveBaseCod1 ;
   private String wcpOAV13ConveBaseCod2 ;
   private String Z1565CliConvenio ;
   private String Z1455ConveBaseTipo ;
   private String Z1456ConveBaseCod1 ;
   private String Z1457ConveBaseCod2 ;
   private String Z1467ConveBasePromTCnt ;
   private String O1467ConveBasePromTCnt ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1455ConveBaseTipo ;
   private String A1456ConveBaseCod1 ;
   private String A1565CliConvenio ;
   private String AV9CliConvenio ;
   private String AV11ConveBaseTipo ;
   private String AV12ConveBaseCod1 ;
   private String AV13ConveBaseCod2 ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String A1467ConveBasePromTCnt ;
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
   private String divConvebasecod1_cell_Internalname ;
   private String divConvebasecod1_cell_Class ;
   private String edtConveBaseCod1_Internalname ;
   private String edtConveBaseCod1_Jsonclick ;
   private String divConvebasecod2_cell_Internalname ;
   private String divConvebasecod2_cell_Class ;
   private String edtConveBaseCod2_Internalname ;
   private String A1457ConveBaseCod2 ;
   private String edtConveBaseCod2_Jsonclick ;
   private String divConvebaseplus_cell_Internalname ;
   private String divConvebaseplus_cell_Class ;
   private String edtConveBasePlus_Internalname ;
   private String edtConveBasePlus_Jsonclick ;
   private String divConvelicdlim_cell_Internalname ;
   private String divConvelicdlim_cell_Class ;
   private String edtConveLicDLim_Internalname ;
   private String edtConveLicDLim_Jsonclick ;
   private String divConvelicdseman_cell_Internalname ;
   private String divConvelicdseman_cell_Class ;
   private String edtConveLicDSeman_Internalname ;
   private String edtConveLicDSeman_Jsonclick ;
   private String divConvelicdmes_cell_Internalname ;
   private String divConvelicdmes_cell_Class ;
   private String divConvelicdsemes_cell_Internalname ;
   private String divConvelicdsemes_cell_Class ;
   private String edtConveLicDSemes_Internalname ;
   private String edtConveLicDSemes_Jsonclick ;
   private String divConvelicdanual_cell_Internalname ;
   private String divConvelicdanual_cell_Class ;
   private String edtConveLicDAnual_Internalname ;
   private String edtConveLicDAnual_Jsonclick ;
   private String divConvelicadju_cell_Internalname ;
   private String divConvelicadju_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String divConvelicadjuobl_cell_Internalname ;
   private String divConvelicadjuobl_cell_Class ;
   private String divConvelicnecaut_cell_Internalname ;
   private String divConvelicnecaut_cell_Class ;
   private String divConvelicingmot_cell_Internalname ;
   private String divConvelicingmot_cell_Class ;
   private String divConvelicmotobl_cell_Internalname ;
   private String divConvelicmotobl_cell_Class ;
   private String edtConveBasePromCnt1_Internalname ;
   private String edtConveBasePromCnt1_Jsonclick ;
   private String edtConveBasePromCnt2_Internalname ;
   private String edtConveBasePromCnt2_Jsonclick ;
   private String divConvebaserelsec_cell_Internalname ;
   private String divConvebaserelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String AV26Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode210 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z1615ConveLicAdju ;
   private boolean Z1616ConveLicAdjuObl ;
   private boolean Z1617ConveLicNecAut ;
   private boolean Z1618ConveLicIngMot ;
   private boolean Z1619ConveLicMotObl ;
   private boolean O1619ConveLicMotObl ;
   private boolean O1618ConveLicIngMot ;
   private boolean O1617ConveLicNecAut ;
   private boolean O1616ConveLicAdjuObl ;
   private boolean O1615ConveLicAdju ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A1615ConveLicAdju ;
   private boolean A1616ConveLicAdjuObl ;
   private boolean A1617ConveLicNecAut ;
   private boolean A1618ConveLicIngMot ;
   private boolean A1619ConveLicMotObl ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV25aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV15IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean Gx_longc ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean3[] ;
   private boolean ZV25aplicadoHay ;
   private String A2062ConveBaseOld ;
   private String Z2062ConveBaseOld ;
   private String Z2061ConveBaseRelRef ;
   private String A2061ConveBaseRelRef ;
   private String A1609ConveBaseC2Txt ;
   private String A1608ConveBaseC1Txt ;
   private String Z1608ConveBaseC1Txt ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV18WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConveBaseClaseLeg ;
   private HTMLChoice cmbConveBaseTipo ;
   private HTMLChoice cmbConveLicDMes ;
   private ICheckbox chkConveLicAdju ;
   private ICheckbox chkConveLicAdjuObl ;
   private ICheckbox chkConveLicNecAut ;
   private ICheckbox chkConveLicIngMot ;
   private ICheckbox chkConveLicMotObl ;
   private HTMLChoice cmbConveBasePromTCnt ;
   private HTMLChoice dynConveBaseRelSec ;
   private IDataStoreProvider pr_default ;
   private byte[] T00415_A1454ConveBaseClaseLeg ;
   private String[] T00415_A1455ConveBaseTipo ;
   private String[] T00415_A1456ConveBaseCod1 ;
   private String[] T00415_A1457ConveBaseCod2 ;
   private java.math.BigDecimal[] T00415_A1458ConveBasePlus ;
   private short[] T00415_A1610ConveLicDLim ;
   private byte[] T00415_A1611ConveLicDSeman ;
   private byte[] T00415_A1612ConveLicDMes ;
   private short[] T00415_A1613ConveLicDSemes ;
   private short[] T00415_A1614ConveLicDAnual ;
   private boolean[] T00415_A1615ConveLicAdju ;
   private boolean[] T00415_A1616ConveLicAdjuObl ;
   private boolean[] T00415_A1617ConveLicNecAut ;
   private boolean[] T00415_A1618ConveLicIngMot ;
   private boolean[] T00415_A1619ConveLicMotObl ;
   private short[] T00415_A1465ConveBasePromCnt1 ;
   private short[] T00415_A1466ConveBasePromCnt2 ;
   private String[] T00415_A1467ConveBasePromTCnt ;
   private int[] T00415_A2060ConveBaseRelSec ;
   private String[] T00415_A2061ConveBaseRelRef ;
   private String[] T00415_A2062ConveBaseOld ;
   private int[] T00415_A3CliCod ;
   private short[] T00415_A1564CliPaiConve ;
   private String[] T00415_A1565CliConvenio ;
   private int[] T00414_A3CliCod ;
   private int[] T00416_A3CliCod ;
   private int[] T00417_A3CliCod ;
   private short[] T00417_A1564CliPaiConve ;
   private String[] T00417_A1565CliConvenio ;
   private byte[] T00417_A1454ConveBaseClaseLeg ;
   private String[] T00417_A1455ConveBaseTipo ;
   private String[] T00417_A1456ConveBaseCod1 ;
   private String[] T00417_A1457ConveBaseCod2 ;
   private byte[] T00413_A1454ConveBaseClaseLeg ;
   private String[] T00413_A1455ConveBaseTipo ;
   private String[] T00413_A1456ConveBaseCod1 ;
   private String[] T00413_A1457ConveBaseCod2 ;
   private java.math.BigDecimal[] T00413_A1458ConveBasePlus ;
   private short[] T00413_A1610ConveLicDLim ;
   private byte[] T00413_A1611ConveLicDSeman ;
   private byte[] T00413_A1612ConveLicDMes ;
   private short[] T00413_A1613ConveLicDSemes ;
   private short[] T00413_A1614ConveLicDAnual ;
   private boolean[] T00413_A1615ConveLicAdju ;
   private boolean[] T00413_A1616ConveLicAdjuObl ;
   private boolean[] T00413_A1617ConveLicNecAut ;
   private boolean[] T00413_A1618ConveLicIngMot ;
   private boolean[] T00413_A1619ConveLicMotObl ;
   private short[] T00413_A1465ConveBasePromCnt1 ;
   private short[] T00413_A1466ConveBasePromCnt2 ;
   private String[] T00413_A1467ConveBasePromTCnt ;
   private int[] T00413_A2060ConveBaseRelSec ;
   private String[] T00413_A2061ConveBaseRelRef ;
   private String[] T00413_A2062ConveBaseOld ;
   private int[] T00413_A3CliCod ;
   private short[] T00413_A1564CliPaiConve ;
   private String[] T00413_A1565CliConvenio ;
   private int[] T00418_A3CliCod ;
   private short[] T00418_A1564CliPaiConve ;
   private String[] T00418_A1565CliConvenio ;
   private byte[] T00418_A1454ConveBaseClaseLeg ;
   private String[] T00418_A1455ConveBaseTipo ;
   private String[] T00418_A1456ConveBaseCod1 ;
   private String[] T00418_A1457ConveBaseCod2 ;
   private int[] T00419_A3CliCod ;
   private short[] T00419_A1564CliPaiConve ;
   private String[] T00419_A1565CliConvenio ;
   private byte[] T00419_A1454ConveBaseClaseLeg ;
   private String[] T00419_A1455ConveBaseTipo ;
   private String[] T00419_A1456ConveBaseCod1 ;
   private String[] T00419_A1457ConveBaseCod2 ;
   private byte[] T00412_A1454ConveBaseClaseLeg ;
   private String[] T00412_A1455ConveBaseTipo ;
   private String[] T00412_A1456ConveBaseCod1 ;
   private String[] T00412_A1457ConveBaseCod2 ;
   private java.math.BigDecimal[] T00412_A1458ConveBasePlus ;
   private short[] T00412_A1610ConveLicDLim ;
   private byte[] T00412_A1611ConveLicDSeman ;
   private byte[] T00412_A1612ConveLicDMes ;
   private short[] T00412_A1613ConveLicDSemes ;
   private short[] T00412_A1614ConveLicDAnual ;
   private boolean[] T00412_A1615ConveLicAdju ;
   private boolean[] T00412_A1616ConveLicAdjuObl ;
   private boolean[] T00412_A1617ConveLicNecAut ;
   private boolean[] T00412_A1618ConveLicIngMot ;
   private boolean[] T00412_A1619ConveLicMotObl ;
   private short[] T00412_A1465ConveBasePromCnt1 ;
   private short[] T00412_A1466ConveBasePromCnt2 ;
   private String[] T00412_A1467ConveBasePromTCnt ;
   private int[] T00412_A2060ConveBaseRelSec ;
   private String[] T00412_A2061ConveBaseRelRef ;
   private String[] T00412_A2062ConveBaseOld ;
   private int[] T00412_A3CliCod ;
   private short[] T00412_A1564CliPaiConve ;
   private String[] T00412_A1565CliConvenio ;
   private int[] T004113_A3CliCod ;
   private short[] T004113_A1564CliPaiConve ;
   private String[] T004113_A1565CliConvenio ;
   private byte[] T004113_A1454ConveBaseClaseLeg ;
   private String[] T004113_A1455ConveBaseTipo ;
   private String[] T004113_A1456ConveBaseCod1 ;
   private String[] T004113_A1457ConveBaseCod2 ;
   private int[] T004114_A3CliCod ;
   private int[] T004114_A1885CliRelSec ;
   private String[] T004114_A1880CliReDTChar ;
   private int[] T004115_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV14WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV17TrnContext ;
}

final  class convenio_base_calculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00412", "SELECT ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBasePlus, ConveLicDLim, ConveLicDSeman, ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt, ConveBaseRelSec, ConveBaseRelRef, ConveBaseOld, CliCod, CliPaiConve, CliConvenio FROM Convenio_base_calculo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ?  FOR UPDATE OF Convenio_base_calculo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00413", "SELECT ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBasePlus, ConveLicDLim, ConveLicDSeman, ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt, ConveBaseRelSec, ConveBaseRelRef, ConveBaseOld, CliCod, CliPaiConve, CliConvenio FROM Convenio_base_calculo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00414", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00415", "SELECT TM1.ConveBaseClaseLeg, TM1.ConveBaseTipo, TM1.ConveBaseCod1, TM1.ConveBaseCod2, TM1.ConveBasePlus, TM1.ConveLicDLim, TM1.ConveLicDSeman, TM1.ConveLicDMes, TM1.ConveLicDSemes, TM1.ConveLicDAnual, TM1.ConveLicAdju, TM1.ConveLicAdjuObl, TM1.ConveLicNecAut, TM1.ConveLicIngMot, TM1.ConveLicMotObl, TM1.ConveBasePromCnt1, TM1.ConveBasePromCnt2, TM1.ConveBasePromTCnt, TM1.ConveBaseRelSec, TM1.ConveBaseRelRef, TM1.ConveBaseOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Convenio_base_calculo TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveBaseClaseLeg = ? and TM1.ConveBaseTipo = ( ?) and TM1.ConveBaseCod1 = ( ?) and TM1.ConveBaseCod2 = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveBaseClaseLeg, TM1.ConveBaseTipo, TM1.ConveBaseCod1, TM1.ConveBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00416", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00417", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00418", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseClaseLeg > ? or ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseTipo > ( ?) or ConveBaseTipo = ( ?) and ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseCod1 > ( ?) or ConveBaseCod1 = ( ?) and ConveBaseTipo = ( ?) and ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseCod2 > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00419", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseClaseLeg < ? or ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseTipo < ( ?) or ConveBaseTipo = ( ?) and ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseCod1 < ( ?) or ConveBaseCod1 = ( ?) and ConveBaseTipo = ( ?) and ConveBaseClaseLeg = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveBaseCod2 < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveBaseClaseLeg DESC, ConveBaseTipo DESC, ConveBaseCod1 DESC, ConveBaseCod2 DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T004110", "SAVEPOINT gxupdate;INSERT INTO Convenio_base_calculo(ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2, ConveBasePlus, ConveLicDLim, ConveLicDSeman, ConveLicDMes, ConveLicDSemes, ConveLicDAnual, ConveLicAdju, ConveLicAdjuObl, ConveLicNecAut, ConveLicIngMot, ConveLicMotObl, ConveBasePromCnt1, ConveBasePromCnt2, ConveBasePromTCnt, ConveBaseRelSec, ConveBaseRelRef, ConveBaseOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004111", "SAVEPOINT gxupdate;UPDATE Convenio_base_calculo SET ConveBasePlus=?, ConveLicDLim=?, ConveLicDSeman=?, ConveLicDMes=?, ConveLicDSemes=?, ConveLicDAnual=?, ConveLicAdju=?, ConveLicAdjuObl=?, ConveLicNecAut=?, ConveLicIngMot=?, ConveLicMotObl=?, ConveBasePromCnt1=?, ConveBasePromCnt2=?, ConveBasePromTCnt=?, ConveBaseRelSec=?, ConveBaseRelRef=?, ConveBaseOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T004112", "SAVEPOINT gxupdate;DELETE FROM Convenio_base_calculo  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveBaseClaseLeg = ? AND ConveBaseTipo = ? AND ConveBaseCod1 = ? AND ConveBaseCod2 = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T004113", "SELECT CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 FROM Convenio_base_calculo ORDER BY CliCod, CliPaiConve, CliConvenio, ConveBaseClaseLeg, ConveBaseTipo, ConveBaseCod1, ConveBaseCod2 ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004114", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T004115", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(21);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(21);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
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
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               ((boolean[]) buf[13])[0] = rslt.getBoolean(14);
               ((boolean[]) buf[14])[0] = rslt.getBoolean(15);
               ((short[]) buf[15])[0] = rslt.getShort(16);
               ((short[]) buf[16])[0] = rslt.getShort(17);
               ((String[]) buf[17])[0] = rslt.getString(18, 20);
               ((int[]) buf[18])[0] = rslt.getInt(19);
               ((String[]) buf[19])[0] = rslt.getVarchar(20);
               ((String[]) buf[20])[0] = rslt.getLongVarchar(21);
               ((int[]) buf[21])[0] = rslt.getInt(22);
               ((short[]) buf[22])[0] = rslt.getShort(23);
               ((String[]) buf[23])[0] = rslt.getString(24, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
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
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setString(16, (String)parms[15], 20);
               stmt.setByte(17, ((Number) parms[16]).byteValue());
               stmt.setString(18, (String)parms[17], 20);
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setString(22, (String)parms[21], 20);
               stmt.setString(23, (String)parms[22], 20);
               stmt.setByte(24, ((Number) parms[23]).byteValue());
               stmt.setString(25, (String)parms[24], 20);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setString(28, (String)parms[27], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setByte(11, ((Number) parms[10]).byteValue());
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 20);
               stmt.setString(16, (String)parms[15], 20);
               stmt.setByte(17, ((Number) parms[16]).byteValue());
               stmt.setString(18, (String)parms[17], 20);
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setInt(20, ((Number) parms[19]).intValue());
               stmt.setString(21, (String)parms[20], 20);
               stmt.setString(22, (String)parms[21], 20);
               stmt.setString(23, (String)parms[22], 20);
               stmt.setByte(24, ((Number) parms[23]).byteValue());
               stmt.setString(25, (String)parms[24], 20);
               stmt.setShort(26, ((Number) parms[25]).shortValue());
               stmt.setInt(27, ((Number) parms[26]).intValue());
               stmt.setString(28, (String)parms[27], 20);
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 4);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setBoolean(12, ((Boolean) parms[11]).booleanValue());
               stmt.setBoolean(13, ((Boolean) parms[12]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[13]).booleanValue());
               stmt.setBoolean(15, ((Boolean) parms[14]).booleanValue());
               stmt.setShort(16, ((Number) parms[15]).shortValue());
               stmt.setShort(17, ((Number) parms[16]).shortValue());
               stmt.setString(18, (String)parms[17], 20);
               stmt.setInt(19, ((Number) parms[18]).intValue());
               stmt.setVarchar(20, (String)parms[19], 40, false);
               stmt.setNLongVarchar(21, (String)parms[20], false);
               stmt.setInt(22, ((Number) parms[21]).intValue());
               stmt.setShort(23, ((Number) parms[22]).shortValue());
               stmt.setString(24, (String)parms[23], 20);
               return;
            case 9 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 4);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[7]).booleanValue());
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(10, ((Boolean) parms[9]).booleanValue());
               stmt.setBoolean(11, ((Boolean) parms[10]).booleanValue());
               stmt.setShort(12, ((Number) parms[11]).shortValue());
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setString(14, (String)parms[13], 20);
               stmt.setInt(15, ((Number) parms[14]).intValue());
               stmt.setVarchar(16, (String)parms[15], 40, false);
               stmt.setNLongVarchar(17, (String)parms[16], false);
               stmt.setInt(18, ((Number) parms[17]).intValue());
               stmt.setShort(19, ((Number) parms[18]).shortValue());
               stmt.setString(20, (String)parms[19], 20);
               stmt.setByte(21, ((Number) parms[20]).byteValue());
               stmt.setString(22, (String)parms[21], 20);
               stmt.setString(23, (String)parms[22], 20);
               stmt.setString(24, (String)parms[23], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

