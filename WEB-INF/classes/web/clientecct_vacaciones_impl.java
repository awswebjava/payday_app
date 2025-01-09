package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class clientecct_vacaciones_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action23") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1902ConveVacRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveVacRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_23_5B239( Gx_mode, AV7CliCod, A1902ConveVacRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVENIO") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlacliconvenio5B239( AV7CliCod, AV8CliPaiConve) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CLICONVEVIG") == 0 )
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
         gxdlacliconvevig5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVEVACRELSEC") == 0 )
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
         gxdlaconvevacrelsec5B239( AV7CliCod) ;
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
         gx1asaclicod5B239( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_26") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_26( A3CliCod, A1564CliPaiConve, A1565CliConvenio, A1575CliConveVig) ;
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
            AV10CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CliConveVig", localUtil.format(AV10CliConveVig, "99/99/99"));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
            AV11CliConveVacDesAnt = (byte)(GXutil.lval( httpContext.GetPar( "CliConveVacDesAnt"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11CliConveVacDesAnt), 2, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVACDESANT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliConveVacDesAnt), "Z9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Cliente CCT_vacaciones", ""), (short)(0)) ;
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

   public clientecct_vacaciones_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public clientecct_vacaciones_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clientecct_vacaciones_impl.class ));
   }

   public clientecct_vacaciones_impl( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynCliConvenio = new HTMLChoice();
      dynCliConveVig = new HTMLChoice();
      dynConveVacRelSec = new HTMLChoice();
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
      if ( dynCliConveVig.getItemCount() > 0 )
      {
         A1575CliConveVig = localUtil.ctod( dynCliConveVig.getValidValue(localUtil.dtoc( A1575CliConveVig, 0, "/")), 0) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveVig.setValue( localUtil.dtoc( A1575CliConveVig, 0, "/") );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Values", dynCliConveVig.ToJavascriptSource(), true);
      }
      if ( dynConveVacRelSec.getItemCount() > 0 )
      {
         A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValidValue(GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveVacRelSec.setValue( GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Values", dynConveVacRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConvenio.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConvenio.getInternalname(), httpContext.getMessage( "Convenio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConvenio, dynCliConvenio.getInternalname(), GXutil.rtrim( A1565CliConvenio), 1, dynCliConvenio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynCliConvenio.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_ClienteCCT_vacaciones.htm");
      dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Values", dynCliConvenio.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynCliConveVig.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynCliConveVig.getInternalname(), httpContext.getMessage( "Fecha de vigencia", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynCliConveVig, dynCliConveVig.getInternalname(), localUtil.dtoc( A1575CliConveVig, 0, "/"), 1, dynCliConveVig.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "date", "", 1, dynCliConveVig.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "AttributeDate", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "", true, (byte)(0), "HLP_ClienteCCT_vacaciones.htm");
      dynCliConveVig.setValue( localUtil.dtoc( A1575CliConveVig, 0, "/") );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Values", dynCliConveVig.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveVacDesAnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveVacDesAnt_Internalname, httpContext.getMessage( "Años de antiguedad desde", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVacDesAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), "Z9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVacDesAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveVacDesAnt_Enabled, 1, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteCCT_vacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveVacHasAnt_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveVacHasAnt_Internalname, httpContext.getMessage( "Años de antiguedad hasta", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVacHasAnt_Internalname, GXutil.ltrim( localUtil.ntoc( A1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveVacHasAnt_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVacHasAnt_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveVacHasAnt_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteCCT_vacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCliConveVacDias_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCliConveVacDias_Internalname, httpContext.getMessage( "Días de vacaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConveVacDias_Internalname, GXutil.ltrim( localUtil.ntoc( A1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCliConveVacDias_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1763CliConveVacDias), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1763CliConveVacDias), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConveVacDias_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCliConveVacDias_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteCCT_vacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divConvevacrelsec_cell_Internalname, 1, 0, "px", 0, "px", divConvevacrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveVacRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveVacRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveVacRelSec, dynConveVacRelSec.getInternalname(), GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0)), 1, dynConveVacRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, dynConveVacRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "", true, (byte)(0), "HLP_ClienteCCT_vacaciones.htm");
      dynConveVacRelSec.setValue( GXutil.trim( GXutil.str( A1902ConveVacRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Values", dynConveVacRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteCCT_vacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteCCT_vacaciones.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_ClienteCCT_vacaciones.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 63,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,63);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ClienteCCT_vacaciones.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 64,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_ClienteCCT_vacaciones.htm");
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
      e115B2 ();
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
            Z1575CliConveVig = localUtil.ctod( httpContext.cgiGet( "Z1575CliConveVig"), 0) ;
            Z1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1761CliConveVacDesAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1762CliConveVacHasAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1763CliConveVacDias"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1902ConveVacRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1902ConveVacRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2038ConveVacRelRef = httpContext.cgiGet( "Z2038ConveVacRelRef") ;
            A2038ConveVacRelRef = httpContext.cgiGet( "Z2038ConveVacRelRef") ;
            O1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( "O1763CliConveVacDias"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "O1762CliConveVacHasAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "O1761CliConveVacDesAnt"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            O1565CliConvenio = httpContext.cgiGet( "O1565CliConvenio") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CliConveVig = localUtil.ctod( httpContext.cgiGet( "vCLICONVEVIG"), 0) ;
            AV11CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( "vCLICONVEVACDESANT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV23aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2038ConveVacRelRef = httpContext.cgiGet( "CONVEVACRELREF") ;
            A2039ConveVacOld = httpContext.cgiGet( "CONVEVACOLD") ;
            AV24Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            dynCliConveVig.setValue( httpContext.cgiGet( dynCliConveVig.getInternalname()) );
            A1575CliConveVig = localUtil.ctod( httpContext.cgiGet( dynCliConveVig.getInternalname()), 0) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEVACDESANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVacDesAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1761CliConveVacDesAnt = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
            }
            else
            {
               A1761CliConveVacDesAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDesAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEVACHASANT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVacHasAnt_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1762CliConveVacHasAnt = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
            }
            else
            {
               A1762CliConveVacHasAnt = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacHasAnt_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICONVEVACDIAS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliConveVacDias_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1763CliConveVacDias = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
            }
            else
            {
               A1763CliConveVacDias = (byte)(localUtil.ctol( httpContext.cgiGet( edtCliConveVacDias_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
            }
            dynConveVacRelSec.setValue( httpContext.cgiGet( dynConveVacRelSec.getInternalname()) );
            A1902ConveVacRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynConveVacRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"ClienteCCT_vacaciones");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveVacRelRef", GXutil.rtrim( localUtil.format( A2038ConveVacRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A1761CliConveVacDesAnt != Z1761CliConveVacDesAnt ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("clientecct_vacaciones:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1575CliConveVig = localUtil.parseDateParm( httpContext.GetPar( "CliConveVig")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               A1761CliConveVacDesAnt = (byte)(GXutil.lval( httpContext.GetPar( "CliConveVacDesAnt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
               getEqualNoModal( ) ;
               gxacliconvenio_html5B239( AV7CliCod, AV8CliPaiConve) ;
               gxacliconvevig_html5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode239 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  gxacliconvenio_html5B239( AV7CliCod, AV8CliPaiConve) ;
                  gxacliconvevig_html5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
                  Gx_mode = sMode239 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound239 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_5B0( ) ;
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
                        e115B2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e125B2 ();
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
         e125B2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll5B239( ) ;
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
         disableAttributes5B239( ) ;
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

   public void confirm_5B0( )
   {
      beforeValidate5B239( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls5B239( ) ;
         }
         else
         {
            checkExtendedTable5B239( ) ;
            closeExtendedTableCursors5B239( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption5B0( )
   {
   }

   public void e115B2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV12WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV12WWPContext = GXv_SdtWWPContext1[0] ;
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteCCT_vacaciones_Insert", GXv_boolean3) ;
         clientecct_vacaciones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteCCT_vacaciones_Update", GXv_boolean3) ;
         clientecct_vacaciones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV13IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteCCT_vacaciones_Delete", GXv_boolean3) ;
         clientecct_vacaciones_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV13IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV24Pgmname))}, new String[] {"GxObject"}) );
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
      AV15TrnContext.fromxml(AV16WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
   }

   public void e125B2( )
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
      divConvevacrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
   }

   public void zm5B239( int GX_JID )
   {
      if ( ( GX_JID == 25 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1762CliConveVacHasAnt = T005B3_A1762CliConveVacHasAnt[0] ;
            Z1763CliConveVacDias = T005B3_A1763CliConveVacDias[0] ;
            Z1902ConveVacRelSec = T005B3_A1902ConveVacRelSec[0] ;
            Z2038ConveVacRelRef = T005B3_A2038ConveVacRelRef[0] ;
         }
         else
         {
            Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
            Z1763CliConveVacDias = A1763CliConveVacDias ;
            Z1902ConveVacRelSec = A1902ConveVacRelSec ;
            Z2038ConveVacRelRef = A2038ConveVacRelRef ;
         }
      }
      if ( GX_JID == -25 )
      {
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         Z1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         Z1763CliConveVacDias = A1763CliConveVacDias ;
         Z1902ConveVacRelSec = A1902ConveVacRelSec ;
         Z2038ConveVacRelRef = A2038ConveVacRelRef ;
         Z2039ConveVacOld = A2039ConveVacOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconvevacrelsec_html5B239( AV7CliCod) ;
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
            clientecct_vacaciones_impl.this.GXt_int4 = GXv_int5[0] ;
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
      gxacliconvenio_html5B239( AV7CliCod, AV8CliPaiConve) ;
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
      gxacliconvevig_html5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
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
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         A1575CliConveVig = AV10CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         dynCliConveVig.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveVig.getEnabled(), 5, 0), true);
      }
      else
      {
         dynCliConveVig.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveVig.getEnabled(), 5, 0), true);
      }
      if ( ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV10CliConveVig)) )
      {
         dynCliConveVig.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveVig.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV11CliConveVacDesAnt) )
      {
         A1761CliConveVacDesAnt = AV11CliConveVacDesAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
      }
      if ( ! (0==AV11CliConveVacDesAnt) )
      {
         edtCliConveVacDesAnt_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConveVacDesAnt_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), true);
      }
      if ( ! (0==AV11CliConveVacDesAnt) )
      {
         edtCliConveVacDesAnt_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), true);
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
         AV24Pgmname = "ClienteCCT_vacaciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      }
   }

   public void load5B239( )
   {
      /* Using cursor T005B5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A1762CliConveVacHasAnt = T005B5_A1762CliConveVacHasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
         A1763CliConveVacDias = T005B5_A1763CliConveVacDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
         A1902ConveVacRelSec = T005B5_A1902ConveVacRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
         A2038ConveVacRelRef = T005B5_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = T005B5_A2039ConveVacOld[0] ;
         zm5B239( -25) ;
      }
      pr_default.close(3);
      onLoadActions5B239( ) ;
   }

   public void onLoadActions5B239( )
   {
      AV24Pgmname = "ClienteCCT_vacaciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      if ( ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) )
      {
         divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
      }
      else
      {
         if ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) )
         {
            divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable5B239( )
   {
      nIsDirty_239 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV24Pgmname = "ClienteCCT_vacaciones" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean3) ;
         clientecct_vacaciones_impl.this.AV23aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      /* Using cursor T005B4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      if ( ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) )
      {
         divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
      }
      else
      {
         if ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) )
         {
            divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
         }
      }
      if ( ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) && (0==A1902ConveVacRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (0==A1762CliConveVacHasAnt) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Años de antiguedad hasta", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEVACHASANT");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacHasAnt_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (0==A1763CliConveVacDias) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Días de vacaciones", ""), "", "", "", "", "", "", "", ""), 1, "CLICONVEVACDIAS");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliConveVacDias_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors5B239( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_26( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio ,
                          java.util.Date A1575CliConveVig )
   {
      /* Using cursor T005B6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
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

   public void getKey5B239( )
   {
      /* Using cursor T005B7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound239 = (short)(1) ;
      }
      else
      {
         RcdFound239 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T005B3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm5B239( 25) ;
         RcdFound239 = (short)(1) ;
         A1761CliConveVacDesAnt = T005B3_A1761CliConveVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
         A1762CliConveVacHasAnt = T005B3_A1762CliConveVacHasAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
         A1763CliConveVacDias = T005B3_A1763CliConveVacDias[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
         A1902ConveVacRelSec = T005B3_A1902ConveVacRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
         A2038ConveVacRelRef = T005B3_A2038ConveVacRelRef[0] ;
         A2039ConveVacOld = T005B3_A2039ConveVacOld[0] ;
         A3CliCod = T005B3_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005B3_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005B3_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T005B3_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         O1763CliConveVacDias = A1763CliConveVacDias ;
         httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
         O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
         O1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
         O1565CliConvenio = A1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z1575CliConveVig = A1575CliConveVig ;
         Z1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load5B239( ) ;
         if ( AnyError == 1 )
         {
            RcdFound239 = (short)(0) ;
            initializeNonKey5B239( ) ;
         }
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound239 = (short)(0) ;
         initializeNonKey5B239( ) ;
         sMode239 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode239 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey5B239( ) ;
      if ( RcdFound239 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound239 = (short)(0) ;
      /* Using cursor T005B8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig, A1575CliConveVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T005B8_A3CliCod[0] < A3CliCod ) || ( T005B8_A3CliCod[0] == A3CliCod ) && ( T005B8_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T005B8_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T005B8_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && ( T005B8_A1761CliConveVacDesAnt[0] < A1761CliConveVacDesAnt ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T005B8_A3CliCod[0] > A3CliCod ) || ( T005B8_A3CliCod[0] == A3CliCod ) && ( T005B8_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T005B8_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T005B8_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T005B8_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B8_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B8_A3CliCod[0] == A3CliCod ) && ( T005B8_A1761CliConveVacDesAnt[0] > A1761CliConveVacDesAnt ) ) )
         {
            A3CliCod = T005B8_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T005B8_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T005B8_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T005B8_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            A1761CliConveVacDesAnt = T005B8_A1761CliConveVacDesAnt[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
            RcdFound239 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound239 = (short)(0) ;
      /* Using cursor T005B9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1575CliConveVig, A1575CliConveVig, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), Byte.valueOf(A1761CliConveVacDesAnt)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T005B9_A3CliCod[0] > A3CliCod ) || ( T005B9_A3CliCod[0] == A3CliCod ) && ( T005B9_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T005B9_A1575CliConveVig[0]).after( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T005B9_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && ( T005B9_A1761CliConveVacDesAnt[0] > A1761CliConveVacDesAnt ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T005B9_A3CliCod[0] < A3CliCod ) || ( T005B9_A3CliCod[0] == A3CliCod ) && ( T005B9_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && GXutil.resetTime(T005B9_A1575CliConveVig[0]).before( GXutil.resetTime( A1575CliConveVig )) || GXutil.dateCompare(GXutil.resetTime(T005B9_A1575CliConveVig[0]), GXutil.resetTime(A1575CliConveVig)) && ( GXutil.strcmp(T005B9_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T005B9_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T005B9_A3CliCod[0] == A3CliCod ) && ( T005B9_A1761CliConveVacDesAnt[0] < A1761CliConveVacDesAnt ) ) )
         {
            A3CliCod = T005B9_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T005B9_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T005B9_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A1575CliConveVig = T005B9_A1575CliConveVig[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
            A1761CliConveVacDesAnt = T005B9_A1761CliConveVacDesAnt[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
            RcdFound239 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey5B239( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = dynCliConvenio.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert5B239( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound239 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A1761CliConveVacDesAnt != Z1761CliConveVacDesAnt ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A1575CliConveVig = Z1575CliConveVig ;
               httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
               A1761CliConveVacDesAnt = Z1761CliConveVacDesAnt ;
               httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
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
               update5B239( ) ;
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A1761CliConveVacDesAnt != Z1761CliConveVacDesAnt ) )
            {
               /* Insert record */
               GX_FocusControl = dynCliConvenio.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert5B239( ) ;
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
                  insert5B239( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(A1575CliConveVig), GXutil.resetTime(Z1575CliConveVig)) ) || ( A1761CliConveVacDesAnt != Z1761CliConveVacDesAnt ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = Z1575CliConveVig ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A1761CliConveVacDesAnt = Z1761CliConveVacDesAnt ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
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

   public void checkOptimisticConcurrency5B239( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T005B2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1762CliConveVacHasAnt != T005B2_A1762CliConveVacHasAnt[0] ) || ( Z1763CliConveVacDias != T005B2_A1763CliConveVacDias[0] ) || ( Z1902ConveVacRelSec != T005B2_A1902ConveVacRelSec[0] ) || ( GXutil.strcmp(Z2038ConveVacRelRef, T005B2_A2038ConveVacRelRef[0]) != 0 ) )
         {
            if ( Z1762CliConveVacHasAnt != T005B2_A1762CliConveVacHasAnt[0] )
            {
               GXutil.writeLogln("clientecct_vacaciones:[seudo value changed for attri]"+"CliConveVacHasAnt");
               GXutil.writeLogRaw("Old: ",Z1762CliConveVacHasAnt);
               GXutil.writeLogRaw("Current: ",T005B2_A1762CliConveVacHasAnt[0]);
            }
            if ( Z1763CliConveVacDias != T005B2_A1763CliConveVacDias[0] )
            {
               GXutil.writeLogln("clientecct_vacaciones:[seudo value changed for attri]"+"CliConveVacDias");
               GXutil.writeLogRaw("Old: ",Z1763CliConveVacDias);
               GXutil.writeLogRaw("Current: ",T005B2_A1763CliConveVacDias[0]);
            }
            if ( Z1902ConveVacRelSec != T005B2_A1902ConveVacRelSec[0] )
            {
               GXutil.writeLogln("clientecct_vacaciones:[seudo value changed for attri]"+"ConveVacRelSec");
               GXutil.writeLogRaw("Old: ",Z1902ConveVacRelSec);
               GXutil.writeLogRaw("Current: ",T005B2_A1902ConveVacRelSec[0]);
            }
            if ( GXutil.strcmp(Z2038ConveVacRelRef, T005B2_A2038ConveVacRelRef[0]) != 0 )
            {
               GXutil.writeLogln("clientecct_vacaciones:[seudo value changed for attri]"+"ConveVacRelRef");
               GXutil.writeLogRaw("Old: ",Z2038ConveVacRelRef);
               GXutil.writeLogRaw("Current: ",T005B2_A2038ConveVacRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert5B239( )
   {
      beforeValidate5B239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5B239( ) ;
      }
      if ( AnyError == 0 )
      {
         zm5B239( 0) ;
         checkOptimisticConcurrency5B239( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5B239( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert5B239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005B10 */
                  pr_default.execute(8, new Object[] {Byte.valueOf(A1761CliConveVacDesAnt), Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
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
                        resetCaption5B0( ) ;
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
            load5B239( ) ;
         }
         endLevel5B239( ) ;
      }
      closeExtendedTableCursors5B239( ) ;
   }

   public void update5B239( )
   {
      beforeValidate5B239( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable5B239( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5B239( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm5B239( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate5B239( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T005B11 */
                  pr_default.execute(9, new Object[] {Byte.valueOf(A1762CliConveVacHasAnt), Byte.valueOf(A1763CliConveVacDias), Integer.valueOf(A1902ConveVacRelSec), A2038ConveVacRelRef, A2039ConveVacOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ClienteConvenio_ParticularidadesVacacion"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate5B239( ) ;
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
         endLevel5B239( ) ;
      }
      closeExtendedTableCursors5B239( ) ;
   }

   public void deferredUpdate5B239( )
   {
   }

   public void delete( )
   {
      beforeValidate5B239( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency5B239( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls5B239( ) ;
         afterConfirm5B239( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete5B239( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T005B12 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Byte.valueOf(A1761CliConveVacDesAnt)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_ParticularidadesVacacion");
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
      sMode239 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel5B239( ) ;
      Gx_mode = sMode239 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls5B239( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV23aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean3) ;
            clientecct_vacaciones_impl.this.AV23aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
         }
         AV24Pgmname = "ClienteCCT_vacaciones" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV24Pgmname", AV24Pgmname);
         if ( ! ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) )
         {
            divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
         }
         else
         {
            if ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) )
            {
               divConvevacrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divConvevacrelsec_cell_Internalname, "Class", divConvevacrelsec_cell_Class, true);
            }
         }
      }
   }

   public void endLevel5B239( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete5B239( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "clientecct_vacaciones");
         if ( AnyError == 0 )
         {
            confirmValues5B0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "clientecct_vacaciones");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart5B239( )
   {
      /* Scan By routine */
      /* Using cursor T005B13 */
      pr_default.execute(11);
      RcdFound239 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A3CliCod = T005B13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005B13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005B13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T005B13_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A1761CliConveVacDesAnt = T005B13_A1761CliConveVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext5B239( )
   {
      /* Scan next routine */
      pr_default.readNext(11);
      RcdFound239 = (short)(0) ;
      if ( (pr_default.getStatus(11) != 101) )
      {
         RcdFound239 = (short)(1) ;
         A3CliCod = T005B13_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T005B13_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T005B13_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A1575CliConveVig = T005B13_A1575CliConveVig[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
         A1761CliConveVacDesAnt = T005B13_A1761CliConveVacDesAnt[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
      }
   }

   public void scanEnd5B239( )
   {
      pr_default.close(11);
   }

   public void afterConfirm5B239( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV23aplicadoHay ) && ! (0==A1902ConveVacRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "ConveVacRelSec", 1, "CONVEVACRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveVacRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert5B239( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate5B239( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete5B239( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete5B239( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate5B239( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes5B239( )
   {
      dynCliConvenio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConvenio.getEnabled(), 5, 0), true);
      dynCliConveVig.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynCliConveVig.getInternalname(), "Enabled", GXutil.ltrimstr( dynCliConveVig.getEnabled(), 5, 0), true);
      edtCliConveVacDesAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDesAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDesAnt_Enabled), 5, 0), true);
      edtCliConveVacHasAnt_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacHasAnt_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacHasAnt_Enabled), 5, 0), true);
      edtCliConveVacDias_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConveVacDias_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConveVacDias_Enabled), 5, 0), true);
      dynConveVacRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveVacRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveVacRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes5B239( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues5B0( )
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.clientecct_vacaciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliConveVacDesAnt,2,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveVacDesAnt"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"ClienteCCT_vacaciones");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveVacRelRef", GXutil.rtrim( localUtil.format( A2038ConveVacRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("clientecct_vacaciones:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1575CliConveVig", localUtil.dtoc( Z1575CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1761CliConveVacDesAnt", GXutil.ltrim( localUtil.ntoc( Z1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1762CliConveVacHasAnt", GXutil.ltrim( localUtil.ntoc( Z1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1763CliConveVacDias", GXutil.ltrim( localUtil.ntoc( Z1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1902ConveVacRelSec", GXutil.ltrim( localUtil.ntoc( Z1902ConveVacRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2038ConveVacRelRef", Z2038ConveVacRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O1763CliConveVacDias", GXutil.ltrim( localUtil.ntoc( O1763CliConveVacDias, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1762CliConveVacHasAnt", GXutil.ltrim( localUtil.ntoc( O1762CliConveVacHasAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1761CliConveVacDesAnt", GXutil.ltrim( localUtil.ntoc( O1761CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O1565CliConvenio", GXutil.rtrim( O1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEVIG", localUtil.dtoc( AV10CliConveVig, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVIG", getSecureSignedToken( "", AV10CliConveVig));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVEVACDESANT", GXutil.ltrim( localUtil.ntoc( AV11CliConveVacDesAnt, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVEVACDESANT", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV11CliConveVacDesAnt), "Z9")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV23aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACRELREF", A2038ConveVacRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEVACOLD", A2039ConveVacOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV24Pgmname));
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
      return formatLink("web.clientecct_vacaciones", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.formatDateParm(AV10CliConveVig)),GXutil.URLEncode(GXutil.ltrimstr(AV11CliConveVacDesAnt,2,0))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CliConveVig","CliConveVacDesAnt"})  ;
   }

   public String getPgmname( )
   {
      return "ClienteCCT_vacaciones" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Cliente CCT_vacaciones", "") ;
   }

   public void initializeNonKey5B239( )
   {
      AV23aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      A1762CliConveVacHasAnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
      A1763CliConveVacDias = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
      A1902ConveVacRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1902ConveVacRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1902ConveVacRelSec), 6, 0));
      A2038ConveVacRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2038ConveVacRelRef", A2038ConveVacRelRef);
      A2039ConveVacOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2039ConveVacOld", A2039ConveVacOld);
      O1763CliConveVacDias = A1763CliConveVacDias ;
      httpContext.ajax_rsp_assign_attri("", false, "A1763CliConveVacDias", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1763CliConveVacDias), 2, 0));
      O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
      httpContext.ajax_rsp_assign_attri("", false, "A1762CliConveVacHasAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1762CliConveVacHasAnt), 2, 0));
      Z1762CliConveVacHasAnt = (byte)(0) ;
      Z1763CliConveVacDias = (byte)(0) ;
      Z1902ConveVacRelSec = 0 ;
      Z2038ConveVacRelRef = "" ;
   }

   public void initAll5B239( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A1575CliConveVig = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1575CliConveVig", localUtil.format(A1575CliConveVig, "99/99/99"));
      A1761CliConveVacDesAnt = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1761CliConveVacDesAnt", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1761CliConveVacDesAnt), 2, 0));
      initializeNonKey5B239( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void define_styles( )
   {
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025187182239", true, true);
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
      httpContext.AddJavascriptSource("clientecct_vacaciones.js", "?2025187182240", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      dynCliConvenio.setInternalname( "CLICONVENIO" );
      dynCliConveVig.setInternalname( "CLICONVEVIG" );
      edtCliConveVacDesAnt_Internalname = "CLICONVEVACDESANT" ;
      edtCliConveVacHasAnt_Internalname = "CLICONVEVACHASANT" ;
      edtCliConveVacDias_Internalname = "CLICONVEVACDIAS" ;
      dynConveVacRelSec.setInternalname( "CONVEVACRELSEC" );
      divConvevacrelsec_cell_Internalname = "CONVEVACRELSEC_CELL" ;
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
      Form.setCaption( httpContext.getMessage( "Cliente CCT_vacaciones", "") );
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
      dynConveVacRelSec.setJsonclick( "" );
      dynConveVacRelSec.setEnabled( 1 );
      divConvevacrelsec_cell_Class = "col-xs-12" ;
      edtCliConveVacDias_Jsonclick = "" ;
      edtCliConveVacDias_Enabled = 1 ;
      edtCliConveVacHasAnt_Jsonclick = "" ;
      edtCliConveVacHasAnt_Enabled = 1 ;
      edtCliConveVacDesAnt_Jsonclick = "" ;
      edtCliConveVacDesAnt_Enabled = 1 ;
      dynCliConveVig.setJsonclick( "" );
      dynCliConveVig.setEnabled( 1 );
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
      /* End function dynload_actions */
   }

   public void gxdlacliconvenio5B239( int AV7CliCod ,
                                      short AV8CliPaiConve )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvenio_data5B239( AV7CliCod, AV8CliPaiConve) ;
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

   public void gxacliconvenio_html5B239( int AV7CliCod ,
                                         short AV8CliPaiConve )
   {
      String gxdynajaxvalue;
      gxdlacliconvenio_data5B239( AV7CliCod, AV8CliPaiConve) ;
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

   protected void gxdlacliconvenio_data5B239( int AV7CliCod ,
                                              short AV8CliPaiConve )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005B14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8CliPaiConve)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T005B14_A1565CliConvenio[0]));
         gxdynajaxctrldescr.add(T005B14_A1567CliConvenioDescrip[0]);
         pr_default.readNext(12);
      }
      pr_default.close(12);
   }

   public void gxdlacliconvevig5B239( int AV7CliCod ,
                                      short AV8CliPaiConve ,
                                      String AV9CliConvenio )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlacliconvevig_data5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
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

   public void gxacliconvevig_html5B239( int AV7CliCod ,
                                         short AV8CliPaiConve ,
                                         String AV9CliConvenio )
   {
      java.util.Date gxdynajaxvalue;
      gxdlacliconvevig_data5B239( AV7CliCod, AV8CliPaiConve, AV9CliConvenio) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynCliConveVig.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = localUtil.ctod( gxdynajaxctrlcodr.item(gxdynajaxindex), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
         dynCliConveVig.addItem(localUtil.dtoc( gxdynajaxvalue, 0, "/"), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlacliconvevig_data5B239( int AV7CliCod ,
                                              short AV8CliPaiConve ,
                                              String AV9CliConvenio )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T005B15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(AV7CliCod), Short.valueOf(AV8CliPaiConve), AV9CliConvenio});
      while ( (pr_default.getStatus(13) != 101) )
      {
         gxdynajaxctrlcodr.add(localUtil.format(T005B15_A1575CliConveVig[0], "99/99/99"));
         gxdynajaxctrldescr.add(localUtil.format(T005B15_A1575CliConveVig[0], "99/99/99"));
         pr_default.readNext(13);
      }
      pr_default.close(13);
   }

   public void gxdlaconvevacrelsec5B239( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvevacrelsec_data5B239( AV7CliCod) ;
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

   public void gxaconvevacrelsec_html5B239( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlaconvevacrelsec_data5B239( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveVacRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynConveVacRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvevacrelsec_data5B239( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T005B16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(14) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T005B16_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T005B16_A1880CliReDTChar[0]);
         pr_default.readNext(14);
      }
      pr_default.close(14);
   }

   public void gx1asaclicod5B239( int AV7CliCod )
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
            clientecct_vacaciones_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void xc_23_5B239( String Gx_mode ,
                            int AV7CliCod ,
                            int A1902ConveVacRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean3) ;
         AV23aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV23aplicadoHay))+"\"") ;
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
      dynCliConveVig.setName( "CLICONVEVIG" );
      dynCliConveVig.setWebtags( "" );
      dynConveVacRelSec.setName( "CONVEVACRELSEC" );
      dynConveVacRelSec.setWebtags( "" );
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

   public void valid_Clipaiconve( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      A1575CliConveVig = localUtil.ctod( dynCliConveVig.getValue(), 0) ;
      A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValue())) ;
      /* Using cursor T005B17 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenio_Particularidades", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVEVIG");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(15);
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      if ( dynCliConveVig.getItemCount() > 0 )
      {
         A1575CliConveVig = localUtil.ctod( dynCliConveVig.getValidValue(localUtil.dtoc( A1575CliConveVig, 0, "/")), 0) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveVig.setValue( localUtil.dtoc( A1575CliConveVig, 0, "/") );
      }
      /*  Sending validation outputs */
   }

   public void valid_Convevacrelsec( )
   {
      A1565CliConvenio = dynCliConvenio.getValue() ;
      A1575CliConveVig = localUtil.ctod( dynCliConveVig.getValue(), 0) ;
      A1902ConveVacRelSec = (int)(GXutil.lval( dynConveVacRelSec.getValue())) ;
      if ( ( ( GXutil.strcmp(A1565CliConvenio, O1565CliConvenio) != 0 ) || ( A1761CliConveVacDesAnt != O1761CliConveVacDesAnt ) || ( A1762CliConveVacHasAnt != O1762CliConveVacHasAnt ) || ( A1763CliConveVacDias != O1763CliConveVacDias ) ) && (0==A1902ConveVacRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "CONVEVACRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynConveVacRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV23aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1902ConveVacRelSec, GXv_boolean3) ;
         clientecct_vacaciones_impl.this.AV23aplicadoHay = GXv_boolean3[0] ;
         AV23aplicadoHay = this.AV23aplicadoHay ;
      }
      O1763CliConveVacDias = A1763CliConveVacDias ;
      O1762CliConveVacHasAnt = A1762CliConveVacHasAnt ;
      O1761CliConveVacDesAnt = A1761CliConveVacDesAnt ;
      O1565CliConvenio = A1565CliConvenio ;
      dynload_actions( ) ;
      if ( dynCliConvenio.getItemCount() > 0 )
      {
         A1565CliConvenio = dynCliConvenio.getValidValue(A1565CliConvenio) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConvenio.setValue( GXutil.rtrim( A1565CliConvenio) );
      }
      if ( dynCliConveVig.getItemCount() > 0 )
      {
         A1575CliConveVig = localUtil.ctod( dynCliConveVig.getValidValue(localUtil.dtoc( A1575CliConveVig, 0, "/")), 0) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynCliConveVig.setValue( localUtil.dtoc( A1575CliConveVig, 0, "/") );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV23aplicadoHay", AV23aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11CliConveVacDesAnt',fld:'vCLICONVEVACDESANT',pic:'Z9',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV10CliConveVig',fld:'vCLICONVEVIG',pic:'',hsh:true},{av:'AV11CliConveVacDesAnt',fld:'vCLICONVEVACDESANT',pic:'Z9',hsh:true},{av:'A2038ConveVacRelRef',fld:'CONVEVACRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e125B2',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVIG","{handler:'valid_Cliconvevig',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICONVEVIG",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACDESANT","{handler:'valid_Cliconvevacdesant',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACDESANT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACHASANT","{handler:'valid_Cliconvevachasant',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACHASANT",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICONVEVACDIAS","{handler:'valid_Cliconvevacdias',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICONVEVACDIAS",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CONVEVACRELSEC","{handler:'valid_Convevacrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O1763CliConveVacDias'},{av:'O1762CliConveVacHasAnt'},{av:'O1761CliConveVacDesAnt'},{av:'O1565CliConvenio'},{av:'A1761CliConveVacDesAnt',fld:'CLICONVEVACDESANT',pic:'Z9'},{av:'A1762CliConveVacHasAnt',fld:'CLICONVEVACHASANT',pic:'Z9'},{av:'A1763CliConveVacDias',fld:'CLICONVEVACDIAS',pic:'Z9'},{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CONVEVACRELSEC",",oparms:[{av:'AV23aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynConveVacRelSec'},{av:'A1902ConveVacRelSec',fld:'CONVEVACRELSEC',pic:'ZZZZZ9'},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'dynCliConvenio'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'dynCliConveVig'},{av:'A1575CliConveVig',fld:'CLICONVEVIG',pic:''}]}");
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
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10CliConveVig = GXutil.nullDate() ;
      Z1565CliConvenio = "" ;
      Z1575CliConveVig = GXutil.nullDate() ;
      Z2038ConveVacRelRef = "" ;
      O1565CliConvenio = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      A1565CliConvenio = "" ;
      A1575CliConveVig = GXutil.nullDate() ;
      AV10CliConveVig = GXutil.nullDate() ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A2038ConveVacRelRef = "" ;
      A2039ConveVacOld = "" ;
      AV24Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode239 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV12WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV15TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV16WebSession = httpContext.getWebSession();
      Z2039ConveVacOld = "" ;
      T005B5_A1761CliConveVacDesAnt = new byte[1] ;
      T005B5_A1762CliConveVacHasAnt = new byte[1] ;
      T005B5_A1763CliConveVacDias = new byte[1] ;
      T005B5_A1902ConveVacRelSec = new int[1] ;
      T005B5_A2038ConveVacRelRef = new String[] {""} ;
      T005B5_A2039ConveVacOld = new String[] {""} ;
      T005B5_A3CliCod = new int[1] ;
      T005B5_A1564CliPaiConve = new short[1] ;
      T005B5_A1565CliConvenio = new String[] {""} ;
      T005B5_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B4_A3CliCod = new int[1] ;
      T005B6_A3CliCod = new int[1] ;
      T005B7_A3CliCod = new int[1] ;
      T005B7_A1564CliPaiConve = new short[1] ;
      T005B7_A1565CliConvenio = new String[] {""} ;
      T005B7_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B7_A1761CliConveVacDesAnt = new byte[1] ;
      T005B3_A1761CliConveVacDesAnt = new byte[1] ;
      T005B3_A1762CliConveVacHasAnt = new byte[1] ;
      T005B3_A1763CliConveVacDias = new byte[1] ;
      T005B3_A1902ConveVacRelSec = new int[1] ;
      T005B3_A2038ConveVacRelRef = new String[] {""} ;
      T005B3_A2039ConveVacOld = new String[] {""} ;
      T005B3_A3CliCod = new int[1] ;
      T005B3_A1564CliPaiConve = new short[1] ;
      T005B3_A1565CliConvenio = new String[] {""} ;
      T005B3_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B8_A3CliCod = new int[1] ;
      T005B8_A1564CliPaiConve = new short[1] ;
      T005B8_A1565CliConvenio = new String[] {""} ;
      T005B8_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B8_A1761CliConveVacDesAnt = new byte[1] ;
      T005B9_A3CliCod = new int[1] ;
      T005B9_A1564CliPaiConve = new short[1] ;
      T005B9_A1565CliConvenio = new String[] {""} ;
      T005B9_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B9_A1761CliConveVacDesAnt = new byte[1] ;
      T005B2_A1761CliConveVacDesAnt = new byte[1] ;
      T005B2_A1762CliConveVacHasAnt = new byte[1] ;
      T005B2_A1763CliConveVacDias = new byte[1] ;
      T005B2_A1902ConveVacRelSec = new int[1] ;
      T005B2_A2038ConveVacRelRef = new String[] {""} ;
      T005B2_A2039ConveVacOld = new String[] {""} ;
      T005B2_A3CliCod = new int[1] ;
      T005B2_A1564CliPaiConve = new short[1] ;
      T005B2_A1565CliConvenio = new String[] {""} ;
      T005B2_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B13_A3CliCod = new int[1] ;
      T005B13_A1564CliPaiConve = new short[1] ;
      T005B13_A1565CliConvenio = new String[] {""} ;
      T005B13_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B13_A1761CliConveVacDesAnt = new byte[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T005B14_A3CliCod = new int[1] ;
      T005B14_A1564CliPaiConve = new short[1] ;
      T005B14_A1565CliConvenio = new String[] {""} ;
      T005B14_A1567CliConvenioDescrip = new String[] {""} ;
      T005B15_A3CliCod = new int[1] ;
      T005B15_A1564CliPaiConve = new short[1] ;
      T005B15_A1565CliConvenio = new String[] {""} ;
      T005B15_A1575CliConveVig = new java.util.Date[] {GXutil.nullDate()} ;
      T005B16_A3CliCod = new int[1] ;
      T005B16_A1885CliRelSec = new int[1] ;
      T005B16_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T005B17_A3CliCod = new int[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clientecct_vacaciones__default(),
         new Object[] {
             new Object[] {
            T005B2_A1761CliConveVacDesAnt, T005B2_A1762CliConveVacHasAnt, T005B2_A1763CliConveVacDias, T005B2_A1902ConveVacRelSec, T005B2_A2038ConveVacRelRef, T005B2_A2039ConveVacOld, T005B2_A3CliCod, T005B2_A1564CliPaiConve, T005B2_A1565CliConvenio, T005B2_A1575CliConveVig
            }
            , new Object[] {
            T005B3_A1761CliConveVacDesAnt, T005B3_A1762CliConveVacHasAnt, T005B3_A1763CliConveVacDias, T005B3_A1902ConveVacRelSec, T005B3_A2038ConveVacRelRef, T005B3_A2039ConveVacOld, T005B3_A3CliCod, T005B3_A1564CliPaiConve, T005B3_A1565CliConvenio, T005B3_A1575CliConveVig
            }
            , new Object[] {
            T005B4_A3CliCod
            }
            , new Object[] {
            T005B5_A1761CliConveVacDesAnt, T005B5_A1762CliConveVacHasAnt, T005B5_A1763CliConveVacDias, T005B5_A1902ConveVacRelSec, T005B5_A2038ConveVacRelRef, T005B5_A2039ConveVacOld, T005B5_A3CliCod, T005B5_A1564CliPaiConve, T005B5_A1565CliConvenio, T005B5_A1575CliConveVig
            }
            , new Object[] {
            T005B6_A3CliCod
            }
            , new Object[] {
            T005B7_A3CliCod, T005B7_A1564CliPaiConve, T005B7_A1565CliConvenio, T005B7_A1575CliConveVig, T005B7_A1761CliConveVacDesAnt
            }
            , new Object[] {
            T005B8_A3CliCod, T005B8_A1564CliPaiConve, T005B8_A1565CliConvenio, T005B8_A1575CliConveVig, T005B8_A1761CliConveVacDesAnt
            }
            , new Object[] {
            T005B9_A3CliCod, T005B9_A1564CliPaiConve, T005B9_A1565CliConvenio, T005B9_A1575CliConveVig, T005B9_A1761CliConveVacDesAnt
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T005B13_A3CliCod, T005B13_A1564CliPaiConve, T005B13_A1565CliConvenio, T005B13_A1575CliConveVig, T005B13_A1761CliConveVacDesAnt
            }
            , new Object[] {
            T005B14_A3CliCod, T005B14_A1564CliPaiConve, T005B14_A1565CliConvenio, T005B14_A1567CliConvenioDescrip
            }
            , new Object[] {
            T005B15_A3CliCod, T005B15_A1564CliPaiConve, T005B15_A1565CliConvenio, T005B15_A1575CliConveVig
            }
            , new Object[] {
            T005B16_A3CliCod, T005B16_A1885CliRelSec, T005B16_A1880CliReDTChar
            }
            , new Object[] {
            T005B17_A3CliCod
            }
         }
      );
      AV24Pgmname = "ClienteCCT_vacaciones" ;
   }

   private byte wcpOAV11CliConveVacDesAnt ;
   private byte Z1761CliConveVacDesAnt ;
   private byte Z1762CliConveVacHasAnt ;
   private byte Z1763CliConveVacDias ;
   private byte O1763CliConveVacDias ;
   private byte O1762CliConveVacHasAnt ;
   private byte O1761CliConveVacDesAnt ;
   private byte GxWebError ;
   private byte AV11CliConveVacDesAnt ;
   private byte nKeyPressed ;
   private byte A1761CliConveVacDesAnt ;
   private byte A1762CliConveVacHasAnt ;
   private byte A1763CliConveVacDias ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short A1564CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound239 ;
   private short nIsDirty_239 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1902ConveVacRelSec ;
   private int AV7CliCod ;
   private int A1902ConveVacRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCliConveVacDesAnt_Enabled ;
   private int edtCliConveVacHasAnt_Enabled ;
   private int edtCliConveVacDias_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtCliPaiConve_Visible ;
   private int edtCliPaiConve_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String Z1565CliConvenio ;
   private String O1565CliConvenio ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String A1565CliConvenio ;
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
   private String edtCliConveVacDesAnt_Internalname ;
   private String edtCliConveVacDesAnt_Jsonclick ;
   private String edtCliConveVacHasAnt_Internalname ;
   private String edtCliConveVacHasAnt_Jsonclick ;
   private String edtCliConveVacDias_Internalname ;
   private String edtCliConveVacDias_Jsonclick ;
   private String divConvevacrelsec_cell_Internalname ;
   private String divConvevacrelsec_cell_Class ;
   private String ClassString ;
   private String StyleString ;
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
   private String AV24Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode239 ;
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
   private java.util.Date wcpOAV10CliConveVig ;
   private java.util.Date Z1575CliConveVig ;
   private java.util.Date A1575CliConveVig ;
   private java.util.Date AV10CliConveVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean AV23aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXv_boolean3[] ;
   private boolean ZV23aplicadoHay ;
   private String A2039ConveVacOld ;
   private String Z2039ConveVacOld ;
   private String Z2038ConveVacRelRef ;
   private String A2038ConveVacRelRef ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV16WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynCliConvenio ;
   private HTMLChoice dynCliConveVig ;
   private HTMLChoice dynConveVacRelSec ;
   private IDataStoreProvider pr_default ;
   private byte[] T005B5_A1761CliConveVacDesAnt ;
   private byte[] T005B5_A1762CliConveVacHasAnt ;
   private byte[] T005B5_A1763CliConveVacDias ;
   private int[] T005B5_A1902ConveVacRelSec ;
   private String[] T005B5_A2038ConveVacRelRef ;
   private String[] T005B5_A2039ConveVacOld ;
   private int[] T005B5_A3CliCod ;
   private short[] T005B5_A1564CliPaiConve ;
   private String[] T005B5_A1565CliConvenio ;
   private java.util.Date[] T005B5_A1575CliConveVig ;
   private int[] T005B4_A3CliCod ;
   private int[] T005B6_A3CliCod ;
   private int[] T005B7_A3CliCod ;
   private short[] T005B7_A1564CliPaiConve ;
   private String[] T005B7_A1565CliConvenio ;
   private java.util.Date[] T005B7_A1575CliConveVig ;
   private byte[] T005B7_A1761CliConveVacDesAnt ;
   private byte[] T005B3_A1761CliConveVacDesAnt ;
   private byte[] T005B3_A1762CliConveVacHasAnt ;
   private byte[] T005B3_A1763CliConveVacDias ;
   private int[] T005B3_A1902ConveVacRelSec ;
   private String[] T005B3_A2038ConveVacRelRef ;
   private String[] T005B3_A2039ConveVacOld ;
   private int[] T005B3_A3CliCod ;
   private short[] T005B3_A1564CliPaiConve ;
   private String[] T005B3_A1565CliConvenio ;
   private java.util.Date[] T005B3_A1575CliConveVig ;
   private int[] T005B8_A3CliCod ;
   private short[] T005B8_A1564CliPaiConve ;
   private String[] T005B8_A1565CliConvenio ;
   private java.util.Date[] T005B8_A1575CliConveVig ;
   private byte[] T005B8_A1761CliConveVacDesAnt ;
   private int[] T005B9_A3CliCod ;
   private short[] T005B9_A1564CliPaiConve ;
   private String[] T005B9_A1565CliConvenio ;
   private java.util.Date[] T005B9_A1575CliConveVig ;
   private byte[] T005B9_A1761CliConveVacDesAnt ;
   private byte[] T005B2_A1761CliConveVacDesAnt ;
   private byte[] T005B2_A1762CliConveVacHasAnt ;
   private byte[] T005B2_A1763CliConveVacDias ;
   private int[] T005B2_A1902ConveVacRelSec ;
   private String[] T005B2_A2038ConveVacRelRef ;
   private String[] T005B2_A2039ConveVacOld ;
   private int[] T005B2_A3CliCod ;
   private short[] T005B2_A1564CliPaiConve ;
   private String[] T005B2_A1565CliConvenio ;
   private java.util.Date[] T005B2_A1575CliConveVig ;
   private int[] T005B13_A3CliCod ;
   private short[] T005B13_A1564CliPaiConve ;
   private String[] T005B13_A1565CliConvenio ;
   private java.util.Date[] T005B13_A1575CliConveVig ;
   private byte[] T005B13_A1761CliConveVacDesAnt ;
   private int[] T005B14_A3CliCod ;
   private short[] T005B14_A1564CliPaiConve ;
   private String[] T005B14_A1565CliConvenio ;
   private String[] T005B14_A1567CliConvenioDescrip ;
   private int[] T005B15_A3CliCod ;
   private short[] T005B15_A1564CliPaiConve ;
   private String[] T005B15_A1565CliConvenio ;
   private java.util.Date[] T005B15_A1575CliConveVig ;
   private int[] T005B16_A3CliCod ;
   private int[] T005B16_A1885CliRelSec ;
   private String[] T005B16_A1880CliReDTChar ;
   private int[] T005B17_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV12WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV15TrnContext ;
}

final  class clientecct_vacaciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T005B2", "SELECT CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?  FOR UPDATE OF ClienteConvenio_ParticularidadesVacacion NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B3", "SELECT CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B4", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B5", "SELECT TM1.CliConveVacDesAnt, TM1.CliConveVacHasAnt, TM1.CliConveVacDias, TM1.ConveVacRelSec, TM1.ConveVacRelRef, TM1.ConveVacOld, TM1.CliCod, TM1.CliPaiConve AS CliPaiConve, TM1.CliConvenio AS CliConvenio, TM1.CliConveVig FROM ClienteConvenio_ParticularidadesVacacion TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CliConveVig = ? and TM1.CliConveVacDesAnt = ? ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CliConveVig, TM1.CliConveVacDesAnt ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B6", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B7", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B8", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig > ? or CliConveVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVacDesAnt > ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T005B9", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVig < ? or CliConveVig = ? and CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CliConveVacDesAnt < ?) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CliConveVig DESC, CliConveVacDesAnt DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T005B10", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_ParticularidadesVacacion(CliConveVacDesAnt, CliConveVacHasAnt, CliConveVacDias, ConveVacRelSec, ConveVacRelRef, ConveVacOld, CliCod, CliPaiConve, CliConvenio, CliConveVig) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005B11", "SAVEPOINT gxupdate;UPDATE ClienteConvenio_ParticularidadesVacacion SET CliConveVacHasAnt=?, CliConveVacDias=?, ConveVacRelSec=?, ConveVacRelRef=?, ConveVacOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T005B12", "SAVEPOINT gxupdate;DELETE FROM ClienteConvenio_ParticularidadesVacacion  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? AND CliConveVacDesAnt = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T005B13", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt FROM ClienteConvenio_ParticularidadesVacacion ORDER BY CliCod, CliPaiConve, CliConvenio, CliConveVig, CliConveVacDesAnt ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B14", "SELECT T1.CliCod, T1.CliPaiConve AS CliPaiConve, T1.CliConvenio AS CliConvenio, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio) WHERE (T1.CliCod = ?) AND (T1.CliPaiConve = ?) ORDER BY T2.ConveDescri ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B15", "SELECT CliCod, CliPaiConve, CliConvenio, CliConveVig FROM ClienteConvenio_Particularidades WHERE (CliCod = ?) AND (CliPaiConve = ?) AND (CliConvenio = ( ?)) ORDER BY CliConveVig ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B16", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T005B17", "SELECT CliCod FROM ClienteConvenio_Particularidades WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CliConveVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               return;
            case 1 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((byte[]) buf[0])[0] = rslt.getByte(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getLongVarchar(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 15 :
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
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
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
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
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
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setDate(11, (java.util.Date)parms[10]);
               stmt.setString(12, (String)parms[11], 20);
               stmt.setShort(13, ((Number) parms[12]).shortValue());
               stmt.setInt(14, ((Number) parms[13]).intValue());
               stmt.setByte(15, ((Number) parms[14]).byteValue());
               return;
            case 8 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               stmt.setDate(10, (java.util.Date)parms[9]);
               return;
            case 9 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setNLongVarchar(5, (String)parms[4], false);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setDate(9, (java.util.Date)parms[8]);
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               return;
      }
   }

}

