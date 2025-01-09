package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_adicionalcancela_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action24") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiSitCanRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_24_5H245( Gx_mode, AV7CliCod, A1898ConveAdiSitCanRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVENIO") == 0 )
      {
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacliconvenio5H245( A1564CliPaiConve, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEADICOD") == 0 )
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
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaconveadicod5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEADISITCANRELSEC") == 0 )
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
         gxdlaconveadisitcanrelsec5H245( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
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
         gx1asaclicod5H245( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_27") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A996ConveAdicod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_28") == 0 )
      {
         A1824ConveAdiSitCancela = httpContext.GetPar( "ConveAdiSitCancela") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_28( A1824ConveAdiSitCancela) ;
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
            AV10ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10ConveAdicod", AV10ConveAdicod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ConveAdicod, ""))));
            AV11ConveAdiSitCancela = httpContext.GetPar( "ConveAdiSitCancela") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11ConveAdiSitCancela", AV11ConveAdiSitCancela);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADISITCANCELA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConveAdiSitCancela, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "convenio_adicional Cancela", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public convenio_adicionalcancela_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_adicionalcancela_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicionalcancela_impl.class ));
   }

   public convenio_adicionalcancela_impl( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynCliConvenio = new HTMLChoice();
      dynConveAdicod = new HTMLChoice();
      dynConveAdiSitCanRelSec = new HTMLChoice();
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
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
      }
      if ( dynConveAdicod.getItemCount() > 0 )
      {
         A996ConveAdicod = dynConveAdicod.getValidValue(A996ConveAdicod) ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdicod.setValue( GXutil.rtrim( A996ConveAdicod) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Values", dynConveAdicod.ToJavascriptSource(), true);
      }
      if ( dynConveAdiSitCanRelSec.getItemCount() > 0 )
      {
         A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( dynConveAdiSitCanRelSec.getValidValue(GXutil.trim( GXutil.str( A1898ConveAdiSitCanRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdiSitCanRelSec.setValue( GXutil.trim( GXutil.str( A1898ConveAdiSitCanRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdiSitCanRelSec.getInternalname(), "Values", dynConveAdiSitCanRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConvenio.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConvenio.getInternalname(), httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConvenio, dynCliConvenio.getInternalname(), GXutil.rtrim( A1565CliConvenio), 1, dynCliConvenio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynCliConvenio.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_convenio_adicionalCancela.htm");
      dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveAdicod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveAdicod.getInternalname(), httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveAdicod, dynConveAdicod.getInternalname(), GXutil.rtrim( A996ConveAdicod), 1, dynConveAdicod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConveAdicod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_convenio_adicionalCancela.htm");
      dynConveAdicod.setValue( GXutil.rtrim( A996ConveAdicod) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Values", dynConveAdicod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell ExtendedComboCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedconveadisitcancela_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockconveadisitcancela_Internalname, httpContext.getMessage( "Situaciones de revista / Licencias", ""), "", "", lblTextblockconveadisitcancela_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_convenio_adicionalCancela.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucCombo_conveadisitcancela.setProperty("Caption", Combo_conveadisitcancela_Caption);
      ucCombo_conveadisitcancela.setProperty("Cls", Combo_conveadisitcancela_Cls);
      ucCombo_conveadisitcancela.setProperty("DataListProc", Combo_conveadisitcancela_Datalistproc);
      ucCombo_conveadisitcancela.setProperty("DataListProcParametersPrefix", Combo_conveadisitcancela_Datalistprocparametersprefix);
      ucCombo_conveadisitcancela.setProperty("EmptyItem", Combo_conveadisitcancela_Emptyitem);
      ucCombo_conveadisitcancela.setProperty("DropDownOptionsTitleSettingsIcons", AV18DDO_TitleSettingsIcons);
      ucCombo_conveadisitcancela.setProperty("DropDownOptionsData", AV26ConveAdiSitCancela_Data);
      ucCombo_conveadisitcancela.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_conveadisitcancela_Internalname, "COMBO_CONVEADISITCANCELAContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Invisible", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiSitCancela_Internalname, httpContext.getMessage( "Estado", ""), "col-sm-3 AttributeLabel", 0, true, "");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 38,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdiSitCancela_Internalname, GXutil.rtrim( A1824ConveAdiSitCancela), GXutil.rtrim( localUtil.format( A1824ConveAdiSitCancela, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,38);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdiSitCancela_Jsonclick, 0, "Attribute", "", "", "", "", edtConveAdiSitCancela_Visible, edtConveAdiSitCancela_Enabled, 1, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicionalCancela.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConveadisitcanrelsec_cell_Internalname, 1, 0, "px", 0, "px", divConveadisitcanrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveAdiSitCanRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveAdiSitCanRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 43,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveAdiSitCanRelSec, dynConveAdiSitCanRelSec.getInternalname(), GXutil.trim( GXutil.str( A1898ConveAdiSitCanRelSec, 6, 0)), 1, dynConveAdiSitCanRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveAdiSitCanRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,43);\"", "", true, (byte)(0), "HLP_convenio_adicionalCancela.htm");
      dynConveAdiSitCanRelSec.setValue( GXutil.trim( GXutil.str( A1898ConveAdiSitCanRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdiSitCanRelSec.getInternalname(), "Values", dynConveAdiSitCanRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 51,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicionalCancela.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicionalCancela.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicionalCancela.htm");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSectionattribute_conveadisitcancela_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
      /* Single line edit */
      web.GxWebStd.gx_single_line_edit( httpContext, edtavComboconveadisitcancela_Internalname, GXutil.rtrim( AV27ComboConveAdiSitCancela), GXutil.rtrim( localUtil.format( AV27ComboConveAdiSitCancela, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavComboconveadisitcancela_Jsonclick, 0, "Attribute", "", "", "", "", edtavComboconveadisitcancela_Visible, edtavComboconveadisitcancela_Enabled, 0, "text", "", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicionalCancela.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,61);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_convenio_adicionalCancela.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_convenio_adicionalCancela.htm");
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
      e115H2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV18DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONVEADISITCANCELA_DATA"), AV26ConveAdiSitCancela_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z996ConveAdicod = httpContext.cgiGet( "Z996ConveAdicod") ;
            Z1824ConveAdiSitCancela = httpContext.cgiGet( "Z1824ConveAdiSitCancela") ;
            Z1898ConveAdiSitCanRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1898ConveAdiSitCanRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2048ConveAdiSitCanRelRef = httpContext.cgiGet( "Z2048ConveAdiSitCanRelRef") ;
            A2048ConveAdiSitCanRelRef = httpContext.cgiGet( "Z2048ConveAdiSitCanRelRef") ;
            O1824ConveAdiSitCancela = httpContext.cgiGet( "O1824ConveAdiSitCancela") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10ConveAdicod = httpContext.cgiGet( "vCONVEADICOD") ;
            AV11ConveAdiSitCancela = httpContext.cgiGet( "vCONVEADISITCANCELA") ;
            AV29aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2048ConveAdiSitCanRelRef = httpContext.cgiGet( "CONVEADISITCANRELREF") ;
            A2050ConveAdiSitCanOld = httpContext.cgiGet( "CONVEADISITCANOLD") ;
            A1825ConveAdiSitCancDes = httpContext.cgiGet( "CONVEADISITCANCDES") ;
            AV30Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            Combo_conveadisitcancela_Objectcall = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Objectcall") ;
            Combo_conveadisitcancela_Class = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Class") ;
            Combo_conveadisitcancela_Icontype = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Icontype") ;
            Combo_conveadisitcancela_Icon = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Icon") ;
            Combo_conveadisitcancela_Caption = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Caption") ;
            Combo_conveadisitcancela_Tooltip = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Tooltip") ;
            Combo_conveadisitcancela_Cls = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Cls") ;
            Combo_conveadisitcancela_Selectedvalue_set = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Selectedvalue_set") ;
            Combo_conveadisitcancela_Selectedvalue_get = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Selectedvalue_get") ;
            Combo_conveadisitcancela_Selectedtext_set = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Selectedtext_set") ;
            Combo_conveadisitcancela_Selectedtext_get = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Selectedtext_get") ;
            Combo_conveadisitcancela_Gamoauthtoken = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Gamoauthtoken") ;
            Combo_conveadisitcancela_Ddointernalname = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Ddointernalname") ;
            Combo_conveadisitcancela_Titlecontrolalign = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Titlecontrolalign") ;
            Combo_conveadisitcancela_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Dropdownoptionstype") ;
            Combo_conveadisitcancela_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Enabled")) ;
            Combo_conveadisitcancela_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Visible")) ;
            Combo_conveadisitcancela_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Titlecontrolidtoreplace") ;
            Combo_conveadisitcancela_Datalisttype = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Datalisttype") ;
            Combo_conveadisitcancela_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Allowmultipleselection")) ;
            Combo_conveadisitcancela_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Datalistfixedvalues") ;
            Combo_conveadisitcancela_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Isgriditem")) ;
            Combo_conveadisitcancela_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Hasdescription")) ;
            Combo_conveadisitcancela_Datalistproc = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Datalistproc") ;
            Combo_conveadisitcancela_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Datalistprocparametersprefix") ;
            Combo_conveadisitcancela_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Remoteservicesparameters") ;
            Combo_conveadisitcancela_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_conveadisitcancela_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Includeonlyselectedoption")) ;
            Combo_conveadisitcancela_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Includeselectalloption")) ;
            Combo_conveadisitcancela_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Emptyitem")) ;
            Combo_conveadisitcancela_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Includeaddnewoption")) ;
            Combo_conveadisitcancela_Htmltemplate = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Htmltemplate") ;
            Combo_conveadisitcancela_Multiplevaluestype = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Multiplevaluestype") ;
            Combo_conveadisitcancela_Loadingdata = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Loadingdata") ;
            Combo_conveadisitcancela_Noresultsfound = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Noresultsfound") ;
            Combo_conveadisitcancela_Emptyitemtext = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Emptyitemtext") ;
            Combo_conveadisitcancela_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Onlyselectedvalues") ;
            Combo_conveadisitcancela_Selectalltext = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Selectalltext") ;
            Combo_conveadisitcancela_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Multiplevaluesseparator") ;
            Combo_conveadisitcancela_Addnewoptiontext = httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Addnewoptiontext") ;
            Combo_conveadisitcancela_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CONVEADISITCANCELA_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            dynCliConvenio.setValue( httpContext.cgiGet( dynCliConvenio.getInternalname()) );
            A1565CliConvenio = httpContext.cgiGet( dynCliConvenio.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            dynConveAdicod.setValue( httpContext.cgiGet( dynConveAdicod.getInternalname()) );
            A996ConveAdicod = httpContext.cgiGet( dynConveAdicod.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A1824ConveAdiSitCancela = httpContext.cgiGet( edtConveAdiSitCancela_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
            dynConveAdiSitCanRelSec.setValue( httpContext.cgiGet( dynConveAdiSitCanRelSec.getInternalname()) );
            A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveAdiSitCanRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
            AV27ComboConveAdiSitCancela = httpContext.cgiGet( edtavComboconveadisitcancela_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27ComboConveAdiSitCancela", AV27ComboConveAdiSitCancela);
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"convenio_adicionalCancela");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveAdiSitCanRelRef", GXutil.rtrim( localUtil.format( A2048ConveAdiSitCanRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || ( GXutil.strcmp(A1824ConveAdiSitCancela, Z1824ConveAdiSitCancela) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio_adicionalcancela:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A996ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
               A1824ConveAdiSitCancela = httpContext.GetPar( "ConveAdiSitCancela") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
               getEqualNoModal( ) ;
               gxaconveadicod_html5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode245 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxaconveadicod_html5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
                  Gx_mode = sMode245 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound245 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5H0( ) ;
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
                        e115H2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125H2 ();
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
         e125H2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5H245( ) ;
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
         disableAttributes5H245( ) ;
      }
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadisitcancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadisitcancela_Enabled), 5, 0), true);
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

   public void confirm_5H0( )
   {
      beforeValidate5H245( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5H245( ) ;
         }
         else
         {
            checkExtendedTable5H245( ) ;
            closeExtendedTableCursors5H245( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5H0( )
   {
   }

   public void e115H2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV18DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV18DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      edtConveAdiSitCancela_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Visible), 5, 0), true);
      AV27ComboConveAdiSitCancela = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboConveAdiSitCancela", AV27ComboConveAdiSitCancela);
      edtavComboconveadisitcancela_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadisitcancela_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadisitcancela_Visible), 5, 0), true);
      /* Execute user subroutine: 'LOADCOMBOCONVEADISITCANCELA' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela_Insert", GXv_boolean5) ;
         convenio_adicionalcancela_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela_Update", GXv_boolean5) ;
         convenio_adicionalcancela_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV13IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicionalCancela_Delete", GXv_boolean5) ;
         convenio_adicionalcancela_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV13IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV30Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S122 ();
      if ( returnInSub )
      {
         pr_default.close(3);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
   }

   public void e125H2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S122( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divConveadisitcanrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
   }

   public void S112( )
   {
      /* 'LOADCOMBOCONVEADISITCANCELA' Routine */
      returnInSub = false ;
      GXt_char6 = AV21Combo_DataJson ;
      GXv_char7[0] = AV19ComboSelectedValue ;
      GXv_char8[0] = AV20ComboSelectedText ;
      GXv_char9[0] = GXt_char6 ;
      new web.convenio_adicionalcancelaloaddvcombo(remoteHandle, context).execute( "ConveAdiSitCancela", Gx_mode, false, AV7CliCod, AV8CliPaiConve, AV9CliConvenio, AV10ConveAdicod, AV11ConveAdiSitCancela, "", GXv_char7, GXv_char8, GXv_char9) ;
      convenio_adicionalcancela_impl.this.AV19ComboSelectedValue = GXv_char7[0] ;
      convenio_adicionalcancela_impl.this.AV20ComboSelectedText = GXv_char8[0] ;
      convenio_adicionalcancela_impl.this.GXt_char6 = GXv_char9[0] ;
      AV21Combo_DataJson = GXt_char6 ;
      Combo_conveadisitcancela_Selectedvalue_set = AV19ComboSelectedValue ;
      ucCombo_conveadisitcancela.sendProperty(context, "", false, Combo_conveadisitcancela_Internalname, "SelectedValue_set", Combo_conveadisitcancela_Selectedvalue_set);
      Combo_conveadisitcancela_Selectedtext_set = AV20ComboSelectedText ;
      ucCombo_conveadisitcancela.sendProperty(context, "", false, Combo_conveadisitcancela_Internalname, "SelectedText_set", Combo_conveadisitcancela_Selectedtext_set);
      AV27ComboConveAdiSitCancela = AV19ComboSelectedValue ;
      httpContext.ajax_rsp_assign_attri("", false, "AV27ComboConveAdiSitCancela", AV27ComboConveAdiSitCancela);
      if ( ( GXutil.strcmp(Gx_mode, "INS") != 0 ) || ! (GXutil.strcmp("", AV11ConveAdiSitCancela)==0) )
      {
         Combo_conveadisitcancela_Enabled = false ;
         ucCombo_conveadisitcancela.sendProperty(context, "", false, Combo_conveadisitcancela_Internalname, "Enabled", GXutil.booltostr( Combo_conveadisitcancela_Enabled));
      }
   }

   public void zm5H245( int GX_JID )
   {
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1898ConveAdiSitCanRelSec = T005H3_A1898ConveAdiSitCanRelSec[0] ;
            Z2048ConveAdiSitCanRelRef = T005H3_A2048ConveAdiSitCanRelRef[0] ;
         }
         else
         {
            Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
            Z2048ConveAdiSitCanRelRef = A2048ConveAdiSitCanRelRef ;
         }
      }
      if ( GX_JID == -26 )
      {
         Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
         Z2048ConveAdiSitCanRelRef = A2048ConveAdiSitCanRelRef ;
         Z2050ConveAdiSitCanOld = A2050ConveAdiSitCanOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         Z1825ConveAdiSitCancDes = A1825ConveAdiSitCancDes ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconveadisitcanrelsec_html5H245( AV7CliCod) ;
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            convenio_adicionalcancela_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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
      gxaconveadicod_html5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         A1565CliConvenio = AV9CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         dynCliConvenio.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      else
      {
         dynCliConvenio.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CliConvenio)==0) )
      {
         dynCliConvenio.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         A996ConveAdicod = AV10ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         dynConveAdicod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdicod.getEnabled(), 5, 0), true);
      }
      else
      {
         dynConveAdicod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdicod.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10ConveAdicod)==0) )
      {
         dynConveAdicod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdicod.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11ConveAdiSitCancela)==0) )
      {
         edtConveAdiSitCancela_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), true);
      }
      else
      {
         edtConveAdiSitCancela_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11ConveAdiSitCancela)==0) )
      {
         edtConveAdiSitCancela_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV11ConveAdiSitCancela)==0) )
      {
         A1824ConveAdiSitCancela = AV11ConveAdiSitCancela ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
      }
      else
      {
         A1824ConveAdiSitCancela = AV27ComboConveAdiSitCancela ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
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
         AV30Pgmname = "convenio_adicionalCancela" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         /* Using cursor T005H5 */
         pr_default.execute(3, new Object[] {A1824ConveAdiSitCancela});
         A1825ConveAdiSitCancDes = T005H5_A1825ConveAdiSitCancDes[0] ;
         pr_default.close(3);
         if ( ! ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) )
         {
            divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 )
            {
               divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
            }
         }
         gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
      }
   }

   public void load5H245( )
   {
      /* Using cursor T005H6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1825ConveAdiSitCancDes = T005H6_A1825ConveAdiSitCancDes[0] ;
         A1898ConveAdiSitCanRelSec = T005H6_A1898ConveAdiSitCanRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
         A2048ConveAdiSitCanRelRef = T005H6_A2048ConveAdiSitCanRelRef[0] ;
         A2050ConveAdiSitCanOld = T005H6_A2050ConveAdiSitCanOld[0] ;
         zm5H245( -26) ;
      }
      pr_default.close(4);
      onLoadActions5H245( ) ;
   }

   public void onLoadActions5H245( )
   {
      AV30Pgmname = "convenio_adicionalCancela" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
      if ( ! ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) )
      {
         divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 )
         {
            divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable5H245( )
   {
      nIsDirty_245 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV30Pgmname = "convenio_adicionalCancela" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV29aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         convenio_adicionalcancela_impl.this.AV29aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29aplicadoHay", AV29aplicadoHay);
      }
      gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
      if ( (GXutil.strcmp("", A1565CliConvenio)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005H4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( (GXutil.strcmp("", A996ConveAdicod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Adicional", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveAdicod.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T005H5 */
      pr_default.execute(3, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1825ConveAdiSitCancDes = T005H5_A1825ConveAdiSitCancDes[0] ;
      pr_default.close(3);
      if ( ! ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) )
      {
         divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
      }
      else
      {
         if ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 )
         {
            divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A1824ConveAdiSitCancela)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) && (0==A1898ConveAdiSitCanRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5H245( )
   {
      pr_default.close(2);
      pr_default.close(3);
   }

   public void enableDisable( )
   {
   }

   public void gxload_27( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio ,
                          String A996ConveAdicod )
   {
      /* Using cursor T005H7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(5) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(5);
   }

   public void gxload_28( String A1824ConveAdiSitCancela )
   {
      /* Using cursor T005H8 */
      pr_default.execute(6, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1825ConveAdiSitCancDes = T005H8_A1825ConveAdiSitCancDes[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1825ConveAdiSitCancDes)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey5H245( )
   {
      /* Using cursor T005H9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound245 = (short)(1) ;
      }
      else
      {
         RcdFound245 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005H3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5H245( 26) ;
         RcdFound245 = (short)(1) ;
         A1898ConveAdiSitCanRelSec = T005H3_A1898ConveAdiSitCanRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
         A2048ConveAdiSitCanRelRef = T005H3_A2048ConveAdiSitCanRelRef[0] ;
         A2050ConveAdiSitCanOld = T005H3_A2050ConveAdiSitCanOld[0] ;
         A3CliCod = T005H3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005H3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005H3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T005H3_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A1824ConveAdiSitCancela = T005H3_A1824ConveAdiSitCancela[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
         O1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5H245( ) ;
         if ( AnyError == 1 )
         {
            RcdFound245 = (short)(0) ;
            initializeNonKey5H245( ) ;
         }
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound245 = (short)(0) ;
         initializeNonKey5H245( ) ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5H245( ) ;
      if ( RcdFound245 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound245 = (short)(0) ;
      /* Using cursor T005H10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod, A996ConveAdicod, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T005H10_A3CliCod[0] < A3CliCod ) || ( T005H10_A3CliCod[0] == A3CliCod ) && ( T005H10_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A996ConveAdicod[0], A996ConveAdicod) < 0 ) || ( GXutil.strcmp(T005H10_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T005H10_A3CliCod[0] > A3CliCod ) || ( T005H10_A3CliCod[0] == A3CliCod ) && ( T005H10_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A996ConveAdicod[0], A996ConveAdicod) > 0 ) || ( GXutil.strcmp(T005H10_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T005H10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H10_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) > 0 ) ) )
         {
            A3CliCod = T005H10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T005H10_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T005H10_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T005H10_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A1824ConveAdiSitCancela = T005H10_A1824ConveAdiSitCancela[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
            RcdFound245 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound245 = (short)(0) ;
      /* Using cursor T005H11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod, A996ConveAdicod, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T005H11_A3CliCod[0] > A3CliCod ) || ( T005H11_A3CliCod[0] == A3CliCod ) && ( T005H11_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A996ConveAdicod[0], A996ConveAdicod) > 0 ) || ( GXutil.strcmp(T005H11_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T005H11_A3CliCod[0] < A3CliCod ) || ( T005H11_A3CliCod[0] == A3CliCod ) && ( T005H11_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A996ConveAdicod[0], A996ConveAdicod) < 0 ) || ( GXutil.strcmp(T005H11_A996ConveAdicod[0], A996ConveAdicod) == 0 ) && ( GXutil.strcmp(T005H11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005H11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005H11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005H11_A1824ConveAdiSitCancela[0], A1824ConveAdiSitCancela) < 0 ) ) )
         {
            A3CliCod = T005H11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T005H11_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T005H11_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T005H11_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A1824ConveAdiSitCancela = T005H11_A1824ConveAdiSitCancela[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
            RcdFound245 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5H245( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5H245( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound245 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || ( GXutil.strcmp(A1824ConveAdiSitCancela, Z1824ConveAdiSitCancela) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A996ConveAdicod = Z996ConveAdicod ;
               httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
               A1824ConveAdiSitCancela = Z1824ConveAdiSitCancela ;
               httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update5H245( ) ;
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || ( GXutil.strcmp(A1824ConveAdiSitCancela, Z1824ConveAdiSitCancela) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5H245( ) ;
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
                  GX_FocusControl = dynCliConvenio.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert5H245( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) || ( GXutil.strcmp(A1824ConveAdiSitCancela, Z1824ConveAdiSitCancela) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = Z996ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A1824ConveAdiSitCancela = Z1824ConveAdiSitCancela ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency5H245( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005H2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1898ConveAdiSitCanRelSec != T005H2_A1898ConveAdiSitCanRelSec[0] ) || ( GXutil.strcmp(Z2048ConveAdiSitCanRelRef, T005H2_A2048ConveAdiSitCanRelRef[0]) != 0 ) )
         {
            if ( Z1898ConveAdiSitCanRelSec != T005H2_A1898ConveAdiSitCanRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicionalcancela:[seudo value changed for attri]"+"ConveAdiSitCanRelSec");
               GXutil.writeLogRaw("Old: ",Z1898ConveAdiSitCanRelSec);
               GXutil.writeLogRaw("Current: ",T005H2_A1898ConveAdiSitCanRelSec[0]);
            }
            if ( GXutil.strcmp(Z2048ConveAdiSitCanRelRef, T005H2_A2048ConveAdiSitCanRelRef[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicionalcancela:[seudo value changed for attri]"+"ConveAdiSitCanRelRef");
               GXutil.writeLogRaw("Old: ",Z2048ConveAdiSitCanRelRef);
               GXutil.writeLogRaw("Current: ",T005H2_A2048ConveAdiSitCanRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalCancela"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5H245( )
   {
      beforeValidate5H245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5H245( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5H245( 0) ;
         checkOptimisticConcurrency5H245( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5H245( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5H245( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005H12 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A1898ConveAdiSitCanRelSec), A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        resetCaption5H0( ) ;
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
            load5H245( ) ;
         }
         endLevel5H245( ) ;
      }
      closeExtendedTableCursors5H245( ) ;
   }

   public void update5H245( )
   {
      beforeValidate5H245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5H245( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5H245( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5H245( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5H245( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005H13 */
                  pr_default.execute(11, new Object[] {Integer.valueOf(A1898ConveAdiSitCanRelSec), A2048ConveAdiSitCanRelRef, A2050ConveAdiSitCanOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5H245( ) ;
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
         endLevel5H245( ) ;
      }
      closeExtendedTableCursors5H245( ) ;
   }

   public void deferredUpdate5H245( )
   {
   }

   public void delete( )
   {
      beforeValidate5H245( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5H245( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5H245( ) ;
         afterConfirm5H245( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5H245( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005H14 */
               pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
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
      sMode245 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5H245( ) ;
      Gx_mode = sMode245 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5H245( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV29aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
            convenio_adicionalcancela_impl.this.AV29aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29aplicadoHay", AV29aplicadoHay);
         }
         AV30Pgmname = "convenio_adicionalCancela" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30Pgmname", AV30Pgmname);
         gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
         /* Using cursor T005H15 */
         pr_default.execute(13, new Object[] {A1824ConveAdiSitCancela});
         A1825ConveAdiSitCancDes = T005H15_A1825ConveAdiSitCancDes[0] ;
         pr_default.close(13);
         if ( ! ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) )
         {
            divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
         }
         else
         {
            if ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 )
            {
               divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel5H245( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5H245( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio_adicionalcancela");
         if ( AnyError == 0 )
         {
            confirmValues5H0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_adicionalcancela");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5H245( )
   {
      /* Scan By routine */
      /* Using cursor T005H16 */
      pr_default.execute(14);
      RcdFound245 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A3CliCod = T005H16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005H16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005H16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T005H16_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A1824ConveAdiSitCancela = T005H16_A1824ConveAdiSitCancela[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5H245( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound245 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A3CliCod = T005H16_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005H16_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005H16_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T005H16_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A1824ConveAdiSitCancela = T005H16_A1824ConveAdiSitCancela[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
      }
   }

   public void scanEnd5H245( )
   {
      pr_default.close(14);
   }

   public void afterConfirm5H245( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV29aplicadoHay ) && ! (0==A1898ConveAdiSitCanRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveAdiSitCanRelSec", 1, "CONVEADISITCANRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveAdiSitCanRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert5H245( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5H245( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5H245( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5H245( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5H245( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5H245( )
   {
      dynCliConvenio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      dynConveAdicod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdicod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdicod.getEnabled(), 5, 0), true);
      edtConveAdiSitCancela_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), true);
      dynConveAdiSitCanRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveAdiSitCanRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveAdiSitCanRelSec.getEnabled(), 5, 0), true);
      edtavComboconveadisitcancela_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavComboconveadisitcancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavComboconveadisitcancela_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5H245( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5H0( )
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_adicionalcancela", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10ConveAdicod)),GXutil.URLEncode(GXutil.rtrim(AV11ConveAdiSitCancela))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiSitCancela"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"convenio_adicionalCancela");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveAdiSitCanRelRef", GXutil.rtrim( localUtil.format( A2048ConveAdiSitCanRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio_adicionalcancela:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z996ConveAdicod", GXutil.rtrim( Z996ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1824ConveAdiSitCancela", GXutil.rtrim( Z1824ConveAdiSitCancela));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1898ConveAdiSitCanRelSec", GXutil.ltrim( localUtil.ntoc( Z1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2048ConveAdiSitCanRelRef", Z2048ConveAdiSitCanRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1824ConveAdiSitCancela", GXutil.rtrim( O1824ConveAdiSitCancela));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV18DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONVEADISITCANCELA_DATA", AV26ConveAdiSitCancela_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONVEADISITCANCELA_DATA", AV26ConveAdiSitCancela_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEADICOD", GXutil.rtrim( AV10ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10ConveAdicod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEADISITCANCELA", GXutil.rtrim( AV11ConveAdiSitCancela));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADISITCANCELA", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV11ConveAdiSitCancela, ""))));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV29aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANRELREF", A2048ConveAdiSitCanRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANOLD", A2050ConveAdiSitCanOld);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANCDES", A1825ConveAdiSitCancDes);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV30Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Objectcall", GXutil.rtrim( Combo_conveadisitcancela_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Cls", GXutil.rtrim( Combo_conveadisitcancela_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Selectedvalue_set", GXutil.rtrim( Combo_conveadisitcancela_Selectedvalue_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Selectedtext_set", GXutil.rtrim( Combo_conveadisitcancela_Selectedtext_set));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Enabled", GXutil.booltostr( Combo_conveadisitcancela_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Datalistproc", GXutil.rtrim( Combo_conveadisitcancela_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Datalistprocparametersprefix", GXutil.rtrim( Combo_conveadisitcancela_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Emptyitem", GXutil.booltostr( Combo_conveadisitcancela_Emptyitem));
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
      return formatLink("web.convenio_adicionalcancela", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10ConveAdicod)),GXutil.URLEncode(GXutil.rtrim(AV11ConveAdiSitCancela))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod","ConveAdiSitCancela"})  ;
   }

   public String getPgmname( )
   {
      return "convenio_adicionalCancela" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "convenio_adicional Cancela", "") ;
   }

   public void initializeNonKey5H245( )
   {
      AV29aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV29aplicadoHay", AV29aplicadoHay);
      A1825ConveAdiSitCancDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1825ConveAdiSitCancDes", A1825ConveAdiSitCancDes);
      A1898ConveAdiSitCanRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1898ConveAdiSitCanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), 6, 0));
      A2048ConveAdiSitCanRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2048ConveAdiSitCanRelRef", A2048ConveAdiSitCanRelRef);
      A2050ConveAdiSitCanOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2050ConveAdiSitCanOld", A2050ConveAdiSitCanOld);
      Z1898ConveAdiSitCanRelSec = 0 ;
      Z2048ConveAdiSitCanRelRef = "" ;
   }

   public void initAll5H245( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A996ConveAdicod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      A1824ConveAdiSitCancela = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1824ConveAdiSitCancela", A1824ConveAdiSitCancela);
      initializeNonKey5H245( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187214050", true, true);
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
      httpContext.AddJavascriptSource("convenio_adicionalcancela.js", "?2025187214051", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynCliConvenio.setInternalname( "CLICONVENIO" );
      dynConveAdicod.setInternalname( "CONVEADICOD" );
      lblTextblockconveadisitcancela_Internalname = "TEXTBLOCKCONVEADISITCANCELA" ;
      Combo_conveadisitcancela_Internalname = "COMBO_CONVEADISITCANCELA" ;
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA" ;
      divTablesplittedconveadisitcancela_Internalname = "TABLESPLITTEDCONVEADISITCANCELA" ;
      dynConveAdiSitCanRelSec.setInternalname( "CONVEADISITCANRELSEC" );
      divConveadisitcanrelsec_cell_Internalname = "CONVEADISITCANRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtavComboconveadisitcancela_Internalname = "vCOMBOCONVEADISITCANCELA" ;
      divSectionattribute_conveadisitcancela_Internalname = "SECTIONATTRIBUTE_CONVEADISITCANCELA" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
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
      Form.setCaption( httpContext.getMessage( "convenio_adicional Cancela", "") );
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      edtavComboconveadisitcancela_Jsonclick = "" ;
      edtavComboconveadisitcancela_Enabled = 0 ;
      edtavComboconveadisitcancela_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynConveAdiSitCanRelSec.setJsonclick( "" );
      dynConveAdiSitCanRelSec.setEnabled( 1 );
      divConveadisitcanrelsec_cell_Class = "col-xs-12" ;
      edtConveAdiSitCancela_Jsonclick = "" ;
      edtConveAdiSitCancela_Enabled = 1 ;
      edtConveAdiSitCancela_Visible = 1 ;
      Combo_conveadisitcancela_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_conveadisitcancela_Datalistprocparametersprefix = " \"ComboName\": \"ConveAdiSitCancela\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"ConveAdicod\": \"\", \"ConveAdiSitCancela\": \"\"" ;
      Combo_conveadisitcancela_Datalistproc = "convenio_adicionalCancelaLoadDVCombo" ;
      Combo_conveadisitcancela_Cls = "ExtendedCombo Attribute" ;
      Combo_conveadisitcancela_Caption = "" ;
      Combo_conveadisitcancela_Enabled = GXutil.toBoolean( -1) ;
      dynConveAdicod.setJsonclick( "" );
      dynConveAdicod.setEnabled( 1 );
      dynCliConvenio.setJsonclick( "" );
      dynCliConvenio.setEnabled( 1 );
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
      gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
      /* End function dynload_actions */
   }

   public void gxdlacliconvenio5H245( short A1564CliPaiConve ,
                                      int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvenio_data5H245( A1564CliPaiConve, AV7CliCod) ;
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

   public void gxacliconvenio_html5H245( short A1564CliPaiConve ,
                                         int AV7CliCod )
   {
      String gxdynajaxvalue;
      gxdlacliconvenio_data5H245( A1564CliPaiConve, AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConvenio.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynCliConvenio.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconvenio_data5H245( short A1564CliPaiConve ,
                                              int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005H17 */
      pr_default.execute(15, new Object[] {Short.valueOf(A1564CliPaiConve), Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005H17_A1565CliConvenio[0]));
         gxdynajaxctrldescr.add(T005H17_A1567CliConvenioDescrip[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gxdlaconveadicod5H245( int AV7CliCod ,
                                      short AV8CliPaiConve ,
                                      String AV9CliConvenio )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconveadicod_data5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
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

   public void gxaconveadicod_html5H245( int AV7CliCod ,
                                         short AV8CliPaiConve ,
                                         String AV9CliConvenio )
   {
      String gxdynajaxvalue;
      gxdlaconveadicod_data5H245( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveAdicod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConveAdicod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconveadicod_data5H245( int AV7CliCod ,
                                              short AV8CliPaiConve ,
                                              String AV9CliConvenio )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005H18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(16) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005H18_A996ConveAdicod[0]));
         gxdynajaxctrldescr.add(T005H18_A997ConveAdiDescri[0]);
         pr_default.readNext(16);
      }
      pr_default.close(16);
   }

   public void gxdlaconveadisitcanrelsec5H245( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconveadisitcanrelsec_data5H245( AV7CliCod) ;
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

   public void gxaconveadisitcanrelsec_html5H245( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconveadisitcanrelsec_data5H245( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveAdiSitCanRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveAdiSitCanRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconveadisitcanrelsec_data5H245( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005H19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(17) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005H19_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005H19_A1880CliReDTChar[0]);
         pr_default.readNext(17);
      }
      pr_default.close(17);
   }

   public void gx1asaclicod5H245( int AV7CliCod )
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
            GXt_int10 = A3CliCod ;
            GXv_int11[0] = GXt_int10 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int11) ;
            convenio_adicionalcancela_impl.this.GXt_int10 = GXv_int11[0] ;
            A3CliCod = GXt_int10 ;
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

   public void xc_24_5H245( String Gx_mode ,
                            int AV7CliCod ,
                            int A1898ConveAdiSitCanRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV29aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         AV29aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29aplicadoHay", AV29aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV29aplicadoHay))+"\"") ;
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
      dynCliConvenio.setName( "CLICONVENIO" );
      dynCliConvenio.setWebtags( "" );
      dynConveAdicod.setName( "CONVEADICOD" );
      dynConveAdicod.setWebtags( "" );
      dynConveAdiSitCanRelSec.setName( "CONVEADISITCANRELSEC" );
      dynConveAdiSitCanRelSec.setWebtags( "" );
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

   public void valid_Conveadisitcancela( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      A996ConveAdicod = dynConveAdicod.getValue() ;
      A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( dynConveAdiSitCanRelSec.getValue())) ;
      /* Using cursor T005H20 */
      pr_default.execute(18, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
      }
      A1825ConveAdiSitCancDes = T005H20_A1825ConveAdiSitCancDes[0] ;
      pr_default.close(18);
      if ( ! ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) )
      {
         divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         if ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 )
         {
            divConveadisitcanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      if ( (GXutil.strcmp("", A1824ConveAdiSitCancela)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Estado", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
      }
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      if ( dynConveAdicod.getItemCount() > 0 )
      {
         A996ConveAdicod = dynConveAdicod.getValidValue(A996ConveAdicod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdicod.setValue( GXutil.rtrim( A996ConveAdicod) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1825ConveAdiSitCancDes", A1825ConveAdiSitCancDes);
      httpContext.ajax_rsp_assign_prop("", false, divConveadisitcanrelsec_cell_Internalname, "Class", divConveadisitcanrelsec_cell_Class, true);
   }

   public void valid_Clipaiconve( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      A996ConveAdicod = dynConveAdicod.getValue() ;
      A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( dynConveAdiSitCanRelSec.getValue())) ;
      /* Using cursor T005H21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "convenio_adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(19);
      gxacliconvenio_html5H245( A1564CliPaiConve, AV7CliCod) ;
      dynload_actions( ) ;
      if ( dynConveAdicod.getItemCount() > 0 )
      {
         A996ConveAdicod = dynConveAdicod.getValidValue(A996ConveAdicod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdicod.setValue( GXutil.rtrim( A996ConveAdicod) );
      }
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", GXutil.rtrim( A1565CliConvenio));
      dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
   }

   public void valid_Conveadisitcanrelsec( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      A996ConveAdicod = dynConveAdicod.getValue() ;
      A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( dynConveAdiSitCanRelSec.getValue())) ;
      if ( ( ( GXutil.strcmp(A1824ConveAdiSitCancela, O1824ConveAdiSitCancela) != 0 ) ) && (0==A1898ConveAdiSitCanRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEADISITCANRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveAdiSitCanRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV29aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         convenio_adicionalcancela_impl.this.AV29aplicadoHay = GXv_boolean5[0] ;
         AV29aplicadoHay = this.AV29aplicadoHay ;
      }
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      if ( dynConveAdicod.getItemCount() > 0 )
      {
         A996ConveAdicod = dynConveAdicod.getValidValue(A996ConveAdicod) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveAdicod.setValue( GXutil.rtrim( A996ConveAdicod) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV29aplicadoHay", AV29aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true},{av:'AV11ConveAdiSitCancela',fld:'vCONVEADISITCANCELA',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true},{av:'AV11ConveAdiSitCancela',fld:'vCONVEADISITCANCELA',pic:'',hsh:true},{av:'A2048ConveAdiSitCanRelRef',fld:'CONVEADISITCANRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125H2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CONVEADICOD","{handler:'valid_Conveadicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CONVEADICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CONVEADISITCANCELA","{handler:'valid_Conveadisitcancela',iparms:[{av:'O1824ConveAdiSitCancela'},{av:'A1824ConveAdiSitCancela',fld:'CONVEADISITCANCELA',pic:''},{av:'A1825ConveAdiSitCancDes',fld:'CONVEADISITCANCDES',pic:'@!'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CONVEADISITCANCELA",",oparms:[{av:'A1825ConveAdiSitCancDes',fld:'CONVEADISITCANCDES',pic:'@!'},{av:'divConveadisitcanrelsec_cell_Class',ctrl:'CONVEADISITCANRELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CONVEADISITCANRELSEC","{handler:'valid_Conveadisitcanrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1824ConveAdiSitCancela'},{av:'A1824ConveAdiSitCancela',fld:'CONVEADISITCANCELA',pic:''},{av:'AV29aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CONVEADISITCANRELSEC",",oparms:[{av:'AV29aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALIDV_COMBOCONVEADISITCANCELA","{handler:'validv_Comboconveadisitcancela',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALIDV_COMBOCONVEADISITCANCELA",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveAdiSitCanRelSec'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynConveAdicod'},{av:'A996ConveAdicod',fld:'CONVEADICOD',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(18);
      pr_default.close(13);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10ConveAdicod = "" ;
      wcpOAV11ConveAdiSitCancela = "" ;
      Z1565CliConvenio = "" ;
      Z996ConveAdicod = "" ;
      Z1824ConveAdiSitCancela = "" ;
      Z2048ConveAdiSitCanRelRef = "" ;
      O1824ConveAdiSitCancela = "" ;
      Combo_conveadisitcancela_Selectedvalue_get = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      A1565CliConvenio = "" ;
      A996ConveAdicod = "" ;
      A1824ConveAdiSitCancela = "" ;
      AV10ConveAdicod = "" ;
      AV11ConveAdiSitCancela = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      lblTextblockconveadisitcancela_Jsonclick = "" ;
      ucCombo_conveadisitcancela = new com.genexus.webpanels.GXUserControl();
      AV18DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV26ConveAdiSitCancela_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      AV27ComboConveAdiSitCancela = "" ;
      A2048ConveAdiSitCanRelRef = "" ;
      A2050ConveAdiSitCanOld = "" ;
      A1825ConveAdiSitCancDes = "" ;
      AV30Pgmname = "" ;
      Combo_conveadisitcancela_Objectcall = "" ;
      Combo_conveadisitcancela_Class = "" ;
      Combo_conveadisitcancela_Icontype = "" ;
      Combo_conveadisitcancela_Icon = "" ;
      Combo_conveadisitcancela_Tooltip = "" ;
      Combo_conveadisitcancela_Selectedvalue_set = "" ;
      Combo_conveadisitcancela_Selectedtext_set = "" ;
      Combo_conveadisitcancela_Selectedtext_get = "" ;
      Combo_conveadisitcancela_Gamoauthtoken = "" ;
      Combo_conveadisitcancela_Ddointernalname = "" ;
      Combo_conveadisitcancela_Titlecontrolalign = "" ;
      Combo_conveadisitcancela_Dropdownoptionstype = "" ;
      Combo_conveadisitcancela_Titlecontrolidtoreplace = "" ;
      Combo_conveadisitcancela_Datalisttype = "" ;
      Combo_conveadisitcancela_Datalistfixedvalues = "" ;
      Combo_conveadisitcancela_Remoteservicesparameters = "" ;
      Combo_conveadisitcancela_Htmltemplate = "" ;
      Combo_conveadisitcancela_Multiplevaluestype = "" ;
      Combo_conveadisitcancela_Loadingdata = "" ;
      Combo_conveadisitcancela_Noresultsfound = "" ;
      Combo_conveadisitcancela_Emptyitemtext = "" ;
      Combo_conveadisitcancela_Onlyselectedvalues = "" ;
      Combo_conveadisitcancela_Selectalltext = "" ;
      Combo_conveadisitcancela_Multiplevaluesseparator = "" ;
      Combo_conveadisitcancela_Addnewoptiontext = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode245 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      AV21Combo_DataJson = "" ;
      GXt_char6 = "" ;
      AV19ComboSelectedValue = "" ;
      GXv_char7 = new String[1] ;
      AV20ComboSelectedText = "" ;
      GXv_char8 = new String[1] ;
      GXv_char9 = new String[1] ;
      Z2050ConveAdiSitCanOld = "" ;
      Z1825ConveAdiSitCancDes = "" ;
      T005H5_A1825ConveAdiSitCancDes = new String[] {""} ;
      T005H6_A1825ConveAdiSitCancDes = new String[] {""} ;
      T005H6_A1898ConveAdiSitCanRelSec = new int[1] ;
      T005H6_A2048ConveAdiSitCanRelRef = new String[] {""} ;
      T005H6_A2050ConveAdiSitCanOld = new String[] {""} ;
      T005H6_A3CliCod = new int[1] ;
      T005H6_A1564CliPaiConve = new short[1] ;
      T005H6_A1565CliConvenio = new String[] {""} ;
      T005H6_A996ConveAdicod = new String[] {""} ;
      T005H6_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H4_A3CliCod = new int[1] ;
      T005H7_A3CliCod = new int[1] ;
      T005H8_A1825ConveAdiSitCancDes = new String[] {""} ;
      T005H9_A3CliCod = new int[1] ;
      T005H9_A1564CliPaiConve = new short[1] ;
      T005H9_A1565CliConvenio = new String[] {""} ;
      T005H9_A996ConveAdicod = new String[] {""} ;
      T005H9_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H3_A1898ConveAdiSitCanRelSec = new int[1] ;
      T005H3_A2048ConveAdiSitCanRelRef = new String[] {""} ;
      T005H3_A2050ConveAdiSitCanOld = new String[] {""} ;
      T005H3_A3CliCod = new int[1] ;
      T005H3_A1564CliPaiConve = new short[1] ;
      T005H3_A1565CliConvenio = new String[] {""} ;
      T005H3_A996ConveAdicod = new String[] {""} ;
      T005H3_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H10_A3CliCod = new int[1] ;
      T005H10_A1564CliPaiConve = new short[1] ;
      T005H10_A1565CliConvenio = new String[] {""} ;
      T005H10_A996ConveAdicod = new String[] {""} ;
      T005H10_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H11_A3CliCod = new int[1] ;
      T005H11_A1564CliPaiConve = new short[1] ;
      T005H11_A1565CliConvenio = new String[] {""} ;
      T005H11_A996ConveAdicod = new String[] {""} ;
      T005H11_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H2_A1898ConveAdiSitCanRelSec = new int[1] ;
      T005H2_A2048ConveAdiSitCanRelRef = new String[] {""} ;
      T005H2_A2050ConveAdiSitCanOld = new String[] {""} ;
      T005H2_A3CliCod = new int[1] ;
      T005H2_A1564CliPaiConve = new short[1] ;
      T005H2_A1565CliConvenio = new String[] {""} ;
      T005H2_A996ConveAdicod = new String[] {""} ;
      T005H2_A1824ConveAdiSitCancela = new String[] {""} ;
      T005H15_A1825ConveAdiSitCancDes = new String[] {""} ;
      T005H16_A3CliCod = new int[1] ;
      T005H16_A1564CliPaiConve = new short[1] ;
      T005H16_A1565CliConvenio = new String[] {""} ;
      T005H16_A996ConveAdicod = new String[] {""} ;
      T005H16_A1824ConveAdiSitCancela = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005H17_A3CliCod = new int[1] ;
      T005H17_A1564CliPaiConve = new short[1] ;
      T005H17_A1565CliConvenio = new String[] {""} ;
      T005H17_A1567CliConvenioDescrip = new String[] {""} ;
      T005H18_A3CliCod = new int[1] ;
      T005H18_A1564CliPaiConve = new short[1] ;
      T005H18_A1565CliConvenio = new String[] {""} ;
      T005H18_A996ConveAdicod = new String[] {""} ;
      T005H18_A997ConveAdiDescri = new String[] {""} ;
      T005H19_A3CliCod = new int[1] ;
      T005H19_A1885CliRelSec = new int[1] ;
      T005H19_A1880CliReDTChar = new String[] {""} ;
      GXv_int11 = new int[1] ;
      T005H20_A1825ConveAdiSitCancDes = new String[] {""} ;
      T005H21_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicionalcancela__default(),
         new Object[] {
             new Object[] {
            T005H2_A1898ConveAdiSitCanRelSec, T005H2_A2048ConveAdiSitCanRelRef, T005H2_A2050ConveAdiSitCanOld, T005H2_A3CliCod, T005H2_A1564CliPaiConve, T005H2_A1565CliConvenio, T005H2_A996ConveAdicod, T005H2_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H3_A1898ConveAdiSitCanRelSec, T005H3_A2048ConveAdiSitCanRelRef, T005H3_A2050ConveAdiSitCanOld, T005H3_A3CliCod, T005H3_A1564CliPaiConve, T005H3_A1565CliConvenio, T005H3_A996ConveAdicod, T005H3_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H4_A3CliCod
            }
            , new Object[] {
            T005H5_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T005H6_A1825ConveAdiSitCancDes, T005H6_A1898ConveAdiSitCanRelSec, T005H6_A2048ConveAdiSitCanRelRef, T005H6_A2050ConveAdiSitCanOld, T005H6_A3CliCod, T005H6_A1564CliPaiConve, T005H6_A1565CliConvenio, T005H6_A996ConveAdicod, T005H6_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H7_A3CliCod
            }
            , new Object[] {
            T005H8_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T005H9_A3CliCod, T005H9_A1564CliPaiConve, T005H9_A1565CliConvenio, T005H9_A996ConveAdicod, T005H9_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H10_A3CliCod, T005H10_A1564CliPaiConve, T005H10_A1565CliConvenio, T005H10_A996ConveAdicod, T005H10_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H11_A3CliCod, T005H11_A1564CliPaiConve, T005H11_A1565CliConvenio, T005H11_A996ConveAdicod, T005H11_A1824ConveAdiSitCancela
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005H15_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T005H16_A3CliCod, T005H16_A1564CliPaiConve, T005H16_A1565CliConvenio, T005H16_A996ConveAdicod, T005H16_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T005H17_A3CliCod, T005H17_A1564CliPaiConve, T005H17_A1565CliConvenio, T005H17_A1567CliConvenioDescrip
            }
            , new Object[] {
            T005H18_A3CliCod, T005H18_A1564CliPaiConve, T005H18_A1565CliConvenio, T005H18_A996ConveAdicod, T005H18_A997ConveAdiDescri
            }
            , new Object[] {
            T005H19_A3CliCod, T005H19_A1885CliRelSec, T005H19_A1880CliReDTChar
            }
            , new Object[] {
            T005H20_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T005H21_A3CliCod
            }
         }
      );
      AV30Pgmname = "convenio_adicionalCancela" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound245 ;
   private short nIsDirty_245 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1898ConveAdiSitCanRelSec ;
   private int AV7CliCod ;
   private int A1898ConveAdiSitCanRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveAdiSitCancela_Visible ;
   private int edtConveAdiSitCancela_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtavComboconveadisitcancela_Visible ;
   private int edtavComboconveadisitcancela_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int Combo_conveadisitcancela_Datalistupdateminimumcharacters ;
   private int Combo_conveadisitcancela_Gxcontroltype ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int10 ;
   private int GXv_int11[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV10ConveAdicod ;
   private String wcpOAV11ConveAdiSitCancela ;
   private String Z1565CliConvenio ;
   private String Z996ConveAdicod ;
   private String Z1824ConveAdiSitCancela ;
   private String O1824ConveAdiSitCancela ;
   private String Combo_conveadisitcancela_Selectedvalue_get ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String A1565CliConvenio ;
   private String A996ConveAdicod ;
   private String A1824ConveAdiSitCancela ;
   private String AV10ConveAdicod ;
   private String AV11ConveAdiSitCancela ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
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
   private String divTablesplittedconveadisitcancela_Internalname ;
   private String lblTextblockconveadisitcancela_Internalname ;
   private String lblTextblockconveadisitcancela_Jsonclick ;
   private String Combo_conveadisitcancela_Caption ;
   private String Combo_conveadisitcancela_Cls ;
   private String Combo_conveadisitcancela_Datalistproc ;
   private String Combo_conveadisitcancela_Datalistprocparametersprefix ;
   private String Combo_conveadisitcancela_Internalname ;
   private String edtConveAdiSitCancela_Internalname ;
   private String edtConveAdiSitCancela_Jsonclick ;
   private String divConveadisitcanrelsec_cell_Internalname ;
   private String divConveadisitcanrelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String divSectionattribute_conveadisitcancela_Internalname ;
   private String edtavComboconveadisitcancela_Internalname ;
   private String AV27ComboConveAdiSitCancela ;
   private String edtavComboconveadisitcancela_Jsonclick ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String AV30Pgmname ;
   private String Combo_conveadisitcancela_Objectcall ;
   private String Combo_conveadisitcancela_Class ;
   private String Combo_conveadisitcancela_Icontype ;
   private String Combo_conveadisitcancela_Icon ;
   private String Combo_conveadisitcancela_Tooltip ;
   private String Combo_conveadisitcancela_Selectedvalue_set ;
   private String Combo_conveadisitcancela_Selectedtext_set ;
   private String Combo_conveadisitcancela_Selectedtext_get ;
   private String Combo_conveadisitcancela_Gamoauthtoken ;
   private String Combo_conveadisitcancela_Ddointernalname ;
   private String Combo_conveadisitcancela_Titlecontrolalign ;
   private String Combo_conveadisitcancela_Dropdownoptionstype ;
   private String Combo_conveadisitcancela_Titlecontrolidtoreplace ;
   private String Combo_conveadisitcancela_Datalisttype ;
   private String Combo_conveadisitcancela_Datalistfixedvalues ;
   private String Combo_conveadisitcancela_Remoteservicesparameters ;
   private String Combo_conveadisitcancela_Htmltemplate ;
   private String Combo_conveadisitcancela_Multiplevaluestype ;
   private String Combo_conveadisitcancela_Loadingdata ;
   private String Combo_conveadisitcancela_Noresultsfound ;
   private String Combo_conveadisitcancela_Emptyitemtext ;
   private String Combo_conveadisitcancela_Onlyselectedvalues ;
   private String Combo_conveadisitcancela_Selectalltext ;
   private String Combo_conveadisitcancela_Multiplevaluesseparator ;
   private String Combo_conveadisitcancela_Addnewoptiontext ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode245 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private String GXv_char8[] ;
   private String GXv_char9[] ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String gxwrpcisep ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Combo_conveadisitcancela_Emptyitem ;
   private boolean AV29aplicadoHay ;
   private boolean Combo_conveadisitcancela_Enabled ;
   private boolean Combo_conveadisitcancela_Visible ;
   private boolean Combo_conveadisitcancela_Allowmultipleselection ;
   private boolean Combo_conveadisitcancela_Isgriditem ;
   private boolean Combo_conveadisitcancela_Hasdescription ;
   private boolean Combo_conveadisitcancela_Includeonlyselectedoption ;
   private boolean Combo_conveadisitcancela_Includeselectalloption ;
   private boolean Combo_conveadisitcancela_Includeaddnewoption ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean5[] ;
   private boolean ZV29aplicadoHay ;
   private String A2050ConveAdiSitCanOld ;
   private String AV21Combo_DataJson ;
   private String Z2050ConveAdiSitCanOld ;
   private String Z2048ConveAdiSitCanRelRef ;
   private String A2048ConveAdiSitCanRelRef ;
   private String A1825ConveAdiSitCancDes ;
   private String AV19ComboSelectedValue ;
   private String AV20ComboSelectedText ;
   private String Z1825ConveAdiSitCancDes ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_conveadisitcancela ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynCliConvenio ;
   private HTMLChoice dynConveAdicod ;
   private HTMLChoice dynConveAdiSitCanRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T005H5_A1825ConveAdiSitCancDes ;
   private String[] T005H6_A1825ConveAdiSitCancDes ;
   private int[] T005H6_A1898ConveAdiSitCanRelSec ;
   private String[] T005H6_A2048ConveAdiSitCanRelRef ;
   private String[] T005H6_A2050ConveAdiSitCanOld ;
   private int[] T005H6_A3CliCod ;
   private short[] T005H6_A1564CliPaiConve ;
   private String[] T005H6_A1565CliConvenio ;
   private String[] T005H6_A996ConveAdicod ;
   private String[] T005H6_A1824ConveAdiSitCancela ;
   private int[] T005H4_A3CliCod ;
   private int[] T005H7_A3CliCod ;
   private String[] T005H8_A1825ConveAdiSitCancDes ;
   private int[] T005H9_A3CliCod ;
   private short[] T005H9_A1564CliPaiConve ;
   private String[] T005H9_A1565CliConvenio ;
   private String[] T005H9_A996ConveAdicod ;
   private String[] T005H9_A1824ConveAdiSitCancela ;
   private int[] T005H3_A1898ConveAdiSitCanRelSec ;
   private String[] T005H3_A2048ConveAdiSitCanRelRef ;
   private String[] T005H3_A2050ConveAdiSitCanOld ;
   private int[] T005H3_A3CliCod ;
   private short[] T005H3_A1564CliPaiConve ;
   private String[] T005H3_A1565CliConvenio ;
   private String[] T005H3_A996ConveAdicod ;
   private String[] T005H3_A1824ConveAdiSitCancela ;
   private int[] T005H10_A3CliCod ;
   private short[] T005H10_A1564CliPaiConve ;
   private String[] T005H10_A1565CliConvenio ;
   private String[] T005H10_A996ConveAdicod ;
   private String[] T005H10_A1824ConveAdiSitCancela ;
   private int[] T005H11_A3CliCod ;
   private short[] T005H11_A1564CliPaiConve ;
   private String[] T005H11_A1565CliConvenio ;
   private String[] T005H11_A996ConveAdicod ;
   private String[] T005H11_A1824ConveAdiSitCancela ;
   private int[] T005H2_A1898ConveAdiSitCanRelSec ;
   private String[] T005H2_A2048ConveAdiSitCanRelRef ;
   private String[] T005H2_A2050ConveAdiSitCanOld ;
   private int[] T005H2_A3CliCod ;
   private short[] T005H2_A1564CliPaiConve ;
   private String[] T005H2_A1565CliConvenio ;
   private String[] T005H2_A996ConveAdicod ;
   private String[] T005H2_A1824ConveAdiSitCancela ;
   private String[] T005H15_A1825ConveAdiSitCancDes ;
   private int[] T005H16_A3CliCod ;
   private short[] T005H16_A1564CliPaiConve ;
   private String[] T005H16_A1565CliConvenio ;
   private String[] T005H16_A996ConveAdicod ;
   private String[] T005H16_A1824ConveAdiSitCancela ;
   private int[] T005H17_A3CliCod ;
   private short[] T005H17_A1564CliPaiConve ;
   private String[] T005H17_A1565CliConvenio ;
   private String[] T005H17_A1567CliConvenioDescrip ;
   private int[] T005H18_A3CliCod ;
   private short[] T005H18_A1564CliPaiConve ;
   private String[] T005H18_A1565CliConvenio ;
   private String[] T005H18_A996ConveAdicod ;
   private String[] T005H18_A997ConveAdiDescri ;
   private int[] T005H19_A3CliCod ;
   private int[] T005H19_A1885CliRelSec ;
   private String[] T005H19_A1880CliReDTChar ;
   private String[] T005H20_A1825ConveAdiSitCancDes ;
   private int[] T005H21_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV26ConveAdiSitCancela_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV18DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class convenio_adicionalcancela__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005H2", "SELECT ConveAdiSitCanRelSec, ConveAdiSitCanRelRef, ConveAdiSitCanOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?  FOR UPDATE OF convenio_adicionalCancela NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H3", "SELECT ConveAdiSitCanRelSec, ConveAdiSitCanRelRef, ConveAdiSitCanOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H4", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H5", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H6", "SELECT T2.SitDescrip AS ConveAdiSitCancDes, TM1.ConveAdiSitCanRelSec, TM1.ConveAdiSitCanRelRef, TM1.ConveAdiSitCanOld, TM1.CliCod, TM1.CliPaiConve AS CliPaiConve, TM1.CliConvenio AS CliConvenio, TM1.ConveAdicod, TM1.ConveAdiSitCancela AS ConveAdiSitCancela FROM (convenio_adicionalCancela TM1 INNER JOIN Estado T2 ON T2.SitCodigo = TM1.ConveAdiSitCancela) WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveAdicod = ( ?) and TM1.ConveAdiSitCancela = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod, TM1.ConveAdiSitCancela ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H7", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H8", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H9", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H10", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod > ( ?) or ConveAdicod = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdiSitCancela > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005H11", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod < ( ?) or ConveAdicod = ( ?) and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdiSitCancela < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC, ConveAdiSitCancela DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005H12", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(ConveAdiSitCanRelSec, ConveAdiSitCanRelRef, ConveAdiSitCanOld, CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela) VALUES(?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005H13", "SAVEPOINT gxupdate;UPDATE convenio_adicionalCancela SET ConveAdiSitCanRelSec=?, ConveAdiSitCanRelRef=?, ConveAdiSitCanOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005H14", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalCancela  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005H15", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H16", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H17", "SELECT T1.CliCod, T1.CliPaiConve AS CliPaiConve, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE (T1.CliPaiConve = ?) AND (T1.CliCod = ?) ORDER BY T2.ConveDescri ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H18", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiDescri FROM convenio_adicional WHERE (CliCod = ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY ConveAdiDescri ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H19", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H20", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005H21", "SELECT CliCod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 4);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getString(9, 4);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 13 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
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
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 4);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 20);
               stmt.setString(11, (String)parms[10], 20);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setString(15, (String)parms[14], 4);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 4);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setNLongVarchar(3, (String)parms[2], false);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 4);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 13 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 18 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

