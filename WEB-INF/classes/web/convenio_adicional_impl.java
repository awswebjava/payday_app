package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_adicional_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action15") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
         A1901ConveAdiRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiRelSec"))) ;
         n1901ConveAdiRelSec = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_15_2W207( Gx_mode, AV30CliCod, A1901ConveAdiRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action18") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
         A1898ConveAdiSitCanRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiSitCanRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_18_2W245( Gx_mode, AV30CliCod, A1898ConveAdiSitCanRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action21") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
         A1899ConveAdiImpRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiImpRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_21_2W208( Gx_mode, AV30CliCod, A1899ConveAdiImpRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action24") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
         A1900ConveAdiOpcRelSec = (int)(GXutil.lval( httpContext.GetPar( "ConveAdiOpcRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_24_2W209( Gx_mode, AV30CliCod, A1900ConveAdiOpcRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
      {
         AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaclicod2W207( AV30CliCod) ;
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
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_27( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_29") == 0 )
      {
         A1824ConveAdiSitCancela = httpContext.GetPar( "ConveAdiSitCancela") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_29( A1824ConveAdiSitCancela) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_importes") == 0 )
      {
         gxnrgridlevel_importes_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_alicuotas") == 0 )
      {
         gxnrgridlevel_alicuotas_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_cancela") == 0 )
      {
         gxnrgridlevel_cancela_newrow_invoke( ) ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV30CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV30CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
            AV31CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV31CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV31CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31CliPaiConve), "ZZZ9")));
            AV32CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV32CliConvenio", AV32CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV32CliConvenio, ""))));
            AV9ConveAdicod = httpContext.GetPar( "ConveAdicod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9ConveAdicod", AV9ConveAdicod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveAdicod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "convenio_adicional", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_importes_newrow_invoke( )
   {
      nRC_GXsfl_61 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_61"))) ;
      nGXsfl_61_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_61_idx"))) ;
      sGXsfl_61_idx = httpContext.GetPar( "sGXsfl_61_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_importes_newrow( ) ;
      /* End function gxnrGridlevel_importes_newrow_invoke */
   }

   public void gxnrgridlevel_alicuotas_newrow_invoke( )
   {
      nRC_GXsfl_75 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_75"))) ;
      nGXsfl_75_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_75_idx"))) ;
      sGXsfl_75_idx = httpContext.GetPar( "sGXsfl_75_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_alicuotas_newrow( ) ;
      /* End function gxnrGridlevel_alicuotas_newrow_invoke */
   }

   public void gxnrgridlevel_cancela_newrow_invoke( )
   {
      nRC_GXsfl_91 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_91"))) ;
      nGXsfl_91_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_91_idx"))) ;
      sGXsfl_91_idx = httpContext.GetPar( "sGXsfl_91_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_cancela_newrow( ) ;
      /* End function gxnrGridlevel_cancela_newrow_invoke */
   }

   public convenio_adicional_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_adicional_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_adicional_impl.class ));
   }

   public convenio_adicional_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbConveAdiTipo = new HTMLChoice();
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
      if ( cmbConveAdiTipo.getItemCount() > 0 )
      {
         A1803ConveAdiTipo = cmbConveAdiTipo.getValidValue(A1803ConveAdiTipo) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConveAdiTipo.setValue( GXutil.rtrim( A1803ConveAdiTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConveAdiTipo.getInternalname(), "Values", cmbConveAdiTipo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdicod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdicod_Internalname, httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdicod_Internalname, GXutil.rtrim( A996ConveAdicod), GXutil.rtrim( localUtil.format( A996ConveAdicod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdicod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveAdicod_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiDescri_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiDescri_Internalname, httpContext.getMessage( "Adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConveAdiDescri_Internalname, A997ConveAdiDescri, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtConveAdiDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiAli_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiAli_Internalname, httpContext.getMessage( "Alícuota", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdiAli_Internalname, GXutil.ltrim( localUtil.ntoc( A998ConveAdiAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveAdiAli_Enabled!=0) ? localUtil.format( A998ConveAdiAli, "9.9999") : localUtil.format( A998ConveAdiAli, "9.9999"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,32);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdiAli_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveAdiAli_Enabled, 0, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "porUnaje", "right", false, "", "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiInfo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiInfo_Internalname, httpContext.getMessage( "Información adicional", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConveAdiInfo_Internalname, A1019ConveAdiInfo, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtConveAdiInfo_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConveAdiTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConveAdiTipo.getInternalname(), httpContext.getMessage( "Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConveAdiTipo, cmbConveAdiTipo.getInternalname(), GXutil.rtrim( A1803ConveAdiTipo), 1, cmbConveAdiTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConveAdiTipo.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "", true, (byte)(0), "HLP_convenio_adicional.htm");
      cmbConveAdiTipo.setValue( GXutil.rtrim( A1803ConveAdiTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveAdiTipo.getInternalname(), "Values", cmbConveAdiTipo.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveAdiRelSec_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveAdiRelSec_Internalname, httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveAdiRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1901ConveAdiRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveAdiRelSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), "ZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveAdiRelSec_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveAdiRelSec_Enabled, 0, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_convenio_adicional.htm");
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
      /* User Defined Control */
      ucDvpanel_unnamedtable1.setProperty("Width", Dvpanel_unnamedtable1_Width);
      ucDvpanel_unnamedtable1.setProperty("AutoWidth", Dvpanel_unnamedtable1_Autowidth);
      ucDvpanel_unnamedtable1.setProperty("AutoHeight", Dvpanel_unnamedtable1_Autoheight);
      ucDvpanel_unnamedtable1.setProperty("Cls", Dvpanel_unnamedtable1_Cls);
      ucDvpanel_unnamedtable1.setProperty("Title", Dvpanel_unnamedtable1_Title);
      ucDvpanel_unnamedtable1.setProperty("Collapsible", Dvpanel_unnamedtable1_Collapsible);
      ucDvpanel_unnamedtable1.setProperty("Collapsed", Dvpanel_unnamedtable1_Collapsed);
      ucDvpanel_unnamedtable1.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable1_Showcollapseicon);
      ucDvpanel_unnamedtable1.setProperty("IconPosition", Dvpanel_unnamedtable1_Iconposition);
      ucDvpanel_unnamedtable1.setProperty("AutoScroll", Dvpanel_unnamedtable1_Autoscroll);
      ucDvpanel_unnamedtable1.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable1_Internalname, "DVPANEL_UNNAMEDTABLE1Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE1Container"+"UnnamedTable1"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable1_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_importes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol61( ) ;
      nGXsfl_61_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount208 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_208 = (short)(1) ;
            scanStart2W208( ) ;
            while ( RcdFound208 != 0 )
            {
               init_level_properties208( ) ;
               getByPrimaryKey2W208( ) ;
               addRow2W208( ) ;
               scanNext2W208( ) ;
            }
            scanEnd2W208( ) ;
            nBlankRcdCount208 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal2W208( ) ;
         standaloneModal2W208( ) ;
         sMode208 = Gx_mode ;
         while ( nGXsfl_61_idx < nRC_GXsfl_61 )
         {
            bGXsfl_61_Refreshing = true ;
            readRow2W208( ) ;
            edtConveAdiVig_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIVIG_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), !bGXsfl_61_Refreshing);
            edtConveAdiImporte_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIIMPORTE_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiImporte_Enabled), 5, 0), !bGXsfl_61_Refreshing);
            edtConveAdiImpRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIIMPRELSEC_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiImpRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiImpRelSec_Enabled), 5, 0), !bGXsfl_61_Refreshing);
            if ( ( nRcdExists_208 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2W208( ) ;
            }
            sendRow2W208( ) ;
            bGXsfl_61_Refreshing = false ;
         }
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount208 = (short)(5) ;
         nRcdExists_208 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2W208( ) ;
            while ( RcdFound208 != 0 )
            {
               sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_61208( ) ;
               init_level_properties208( ) ;
               standaloneNotModal2W208( ) ;
               getByPrimaryKey2W208( ) ;
               standaloneModal2W208( ) ;
               addRow2W208( ) ;
               scanNext2W208( ) ;
            }
            scanEnd2W208( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode208 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_61208( ) ;
         initAll2W208( ) ;
         init_level_properties208( ) ;
         nRcdExists_208 = (short)(0) ;
         nIsMod_208 = (short)(0) ;
         nRcdDeleted_208 = (short)(0) ;
         nBlankRcdCount208 = (short)(nBlankRcdUsr208+nBlankRcdCount208) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount208 > 0 )
         {
            standaloneNotModal2W208( ) ;
            standaloneModal2W208( ) ;
            addRow2W208( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtConveAdiVig_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount208 = (short)(nBlankRcdCount208-1) ;
         }
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_importesContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_importes", Gridlevel_importesContainer, subGridlevel_importes_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData", Gridlevel_importesContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_importesContainerData"+"V", Gridlevel_importesContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_importesContainerData"+"V"+"\" value='"+Gridlevel_importesContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* User Defined Control */
      ucDvpanel_unnamedtable2.setProperty("Width", Dvpanel_unnamedtable2_Width);
      ucDvpanel_unnamedtable2.setProperty("AutoWidth", Dvpanel_unnamedtable2_Autowidth);
      ucDvpanel_unnamedtable2.setProperty("AutoHeight", Dvpanel_unnamedtable2_Autoheight);
      ucDvpanel_unnamedtable2.setProperty("Cls", Dvpanel_unnamedtable2_Cls);
      ucDvpanel_unnamedtable2.setProperty("Title", Dvpanel_unnamedtable2_Title);
      ucDvpanel_unnamedtable2.setProperty("Collapsible", Dvpanel_unnamedtable2_Collapsible);
      ucDvpanel_unnamedtable2.setProperty("Collapsed", Dvpanel_unnamedtable2_Collapsed);
      ucDvpanel_unnamedtable2.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable2_Showcollapseicon);
      ucDvpanel_unnamedtable2.setProperty("IconPosition", Dvpanel_unnamedtable2_Iconposition);
      ucDvpanel_unnamedtable2.setProperty("AutoScroll", Dvpanel_unnamedtable2_Autoscroll);
      ucDvpanel_unnamedtable2.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable2_Internalname, "DVPANEL_UNNAMEDTABLE2Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE2Container"+"UnnamedTable2"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable2_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_alicuotas_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol75( ) ;
      nGXsfl_75_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount209 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_209 = (short)(1) ;
            scanStart2W209( ) ;
            while ( RcdFound209 != 0 )
            {
               init_level_properties209( ) ;
               getByPrimaryKey2W209( ) ;
               addRow2W209( ) ;
               scanNext2W209( ) ;
            }
            scanEnd2W209( ) ;
            nBlankRcdCount209 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal2W209( ) ;
         standaloneModal2W209( ) ;
         sMode209 = Gx_mode ;
         while ( nGXsfl_75_idx < nRC_GXsfl_75 )
         {
            bGXsfl_75_Refreshing = true ;
            readRow2W209( ) ;
            edtConveAdiOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCCOD_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcCod_Enabled), 5, 0), !bGXsfl_75_Refreshing);
            edtConveAdiOpcFor_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCFOR_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcFor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcFor_Enabled), 5, 0), !bGXsfl_75_Refreshing);
            edtConveAdiOpcDes_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCDES_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcDes_Enabled), 5, 0), !bGXsfl_75_Refreshing);
            edtConveAdiOpcAli_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCALI_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcAli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcAli_Enabled), 5, 0), !bGXsfl_75_Refreshing);
            edtConveAdiOpcRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCRELSEC_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcRelSec_Enabled), 5, 0), !bGXsfl_75_Refreshing);
            if ( ( nRcdExists_209 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2W209( ) ;
            }
            sendRow2W209( ) ;
            bGXsfl_75_Refreshing = false ;
         }
         Gx_mode = sMode209 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount209 = (short)(5) ;
         nRcdExists_209 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2W209( ) ;
            while ( RcdFound209 != 0 )
            {
               sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_75209( ) ;
               init_level_properties209( ) ;
               standaloneNotModal2W209( ) ;
               getByPrimaryKey2W209( ) ;
               standaloneModal2W209( ) ;
               addRow2W209( ) ;
               scanNext2W209( ) ;
            }
            scanEnd2W209( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode209 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_75209( ) ;
         initAll2W209( ) ;
         init_level_properties209( ) ;
         nRcdExists_209 = (short)(0) ;
         nIsMod_209 = (short)(0) ;
         nRcdDeleted_209 = (short)(0) ;
         nBlankRcdCount209 = (short)(nBlankRcdUsr209+nBlankRcdCount209) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount209 > 0 )
         {
            standaloneNotModal2W209( ) ;
            standaloneModal2W209( ) ;
            addRow2W209( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtConveAdiOpcCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount209 = (short)(nBlankRcdCount209-1) ;
         }
         Gx_mode = sMode209 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_alicuotasContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_alicuotas", Gridlevel_alicuotasContainer, subGridlevel_alicuotas_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_alicuotasContainerData", Gridlevel_alicuotasContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_alicuotasContainerData"+"V", Gridlevel_alicuotasContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_alicuotasContainerData"+"V"+"\" value='"+Gridlevel_alicuotasContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* User Defined Control */
      ucDvpanel_unnamedtable3.setProperty("Width", Dvpanel_unnamedtable3_Width);
      ucDvpanel_unnamedtable3.setProperty("AutoWidth", Dvpanel_unnamedtable3_Autowidth);
      ucDvpanel_unnamedtable3.setProperty("AutoHeight", Dvpanel_unnamedtable3_Autoheight);
      ucDvpanel_unnamedtable3.setProperty("Cls", Dvpanel_unnamedtable3_Cls);
      ucDvpanel_unnamedtable3.setProperty("Title", Dvpanel_unnamedtable3_Title);
      ucDvpanel_unnamedtable3.setProperty("Collapsible", Dvpanel_unnamedtable3_Collapsible);
      ucDvpanel_unnamedtable3.setProperty("Collapsed", Dvpanel_unnamedtable3_Collapsed);
      ucDvpanel_unnamedtable3.setProperty("ShowCollapseIcon", Dvpanel_unnamedtable3_Showcollapseicon);
      ucDvpanel_unnamedtable3.setProperty("IconPosition", Dvpanel_unnamedtable3_Iconposition);
      ucDvpanel_unnamedtable3.setProperty("AutoScroll", Dvpanel_unnamedtable3_Autoscroll);
      ucDvpanel_unnamedtable3.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_unnamedtable3_Internalname, "DVPANEL_UNNAMEDTABLE3Container");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_UNNAMEDTABLE3Container"+"UnnamedTable3"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divUnnamedtable3_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 CellMarginTop", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_cancela_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol91( ) ;
      nGXsfl_91_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount245 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_245 = (short)(1) ;
            scanStart2W245( ) ;
            while ( RcdFound245 != 0 )
            {
               init_level_properties245( ) ;
               getByPrimaryKey2W245( ) ;
               addRow2W245( ) ;
               scanNext2W245( ) ;
            }
            scanEnd2W245( ) ;
            nBlankRcdCount245 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal2W245( ) ;
         standaloneModal2W245( ) ;
         sMode245 = Gx_mode ;
         while ( nGXsfl_91_idx < nRC_GXsfl_91 )
         {
            bGXsfl_91_Refreshing = true ;
            readRow2W245( ) ;
            edtConveAdiSitCancela_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADISITCANCELA_"+sGXsfl_91_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), !bGXsfl_91_Refreshing);
            edtConveAdiSitCanRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADISITCANRELSEC_"+sGXsfl_91_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCanRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCanRelSec_Enabled), 5, 0), !bGXsfl_91_Refreshing);
            if ( ( nRcdExists_245 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal2W245( ) ;
            }
            sendRow2W245( ) ;
            bGXsfl_91_Refreshing = false ;
         }
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount245 = (short)(5) ;
         nRcdExists_245 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart2W245( ) ;
            while ( RcdFound245 != 0 )
            {
               sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_91245( ) ;
               init_level_properties245( ) ;
               standaloneNotModal2W245( ) ;
               getByPrimaryKey2W245( ) ;
               standaloneModal2W245( ) ;
               addRow2W245( ) ;
               scanNext2W245( ) ;
            }
            scanEnd2W245( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode245 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_91245( ) ;
         initAll2W245( ) ;
         init_level_properties245( ) ;
         nRcdExists_245 = (short)(0) ;
         nIsMod_245 = (short)(0) ;
         nRcdDeleted_245 = (short)(0) ;
         nBlankRcdCount245 = (short)(nBlankRcdUsr245+nBlankRcdCount245) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount245 > 0 )
         {
            standaloneNotModal2W245( ) ;
            standaloneModal2W245( ) ;
            addRow2W245( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtConveAdiSitCancela_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount245 = (short)(nBlankRcdCount245-1) ;
         }
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_cancelaContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_cancela", Gridlevel_cancelaContainer, subGridlevel_cancela_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_cancelaContainerData", Gridlevel_cancelaContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_cancelaContainerData"+"V", Gridlevel_cancelaContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_cancelaContainerData"+"V"+"\" value='"+Gridlevel_cancelaContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 98,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 100,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicional.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 102,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_convenio_adicional.htm");
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
      /* User Defined Control */
      ucCombo_conveadisitcancela.setProperty("Caption", Combo_conveadisitcancela_Caption);
      ucCombo_conveadisitcancela.setProperty("Cls", Combo_conveadisitcancela_Cls);
      ucCombo_conveadisitcancela.setProperty("IsGridItem", Combo_conveadisitcancela_Isgriditem);
      ucCombo_conveadisitcancela.setProperty("HasDescription", Combo_conveadisitcancela_Hasdescription);
      ucCombo_conveadisitcancela.setProperty("DataListProc", Combo_conveadisitcancela_Datalistproc);
      ucCombo_conveadisitcancela.setProperty("DataListProcParametersPrefix", Combo_conveadisitcancela_Datalistprocparametersprefix);
      ucCombo_conveadisitcancela.setProperty("EmptyItem", Combo_conveadisitcancela_Emptyitem);
      ucCombo_conveadisitcancela.setProperty("DropDownOptionsTitleSettingsIcons", AV16DDO_TitleSettingsIcons);
      ucCombo_conveadisitcancela.setProperty("DropDownOptionsData", AV37ConveAdiSitCancela_Data);
      ucCombo_conveadisitcancela.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_conveadisitcancela_Internalname, "COMBO_CONVEADISITCANCELAContainer");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 107,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,107);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_convenio_adicional.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 108,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,108);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_convenio_adicional.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 109,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,109);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_convenio_adicional.htm");
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
      e112W2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV16DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCONVEADISITCANCELA_DATA"), AV37ConveAdiSitCancela_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z996ConveAdicod = httpContext.cgiGet( "Z996ConveAdicod") ;
            Z997ConveAdiDescri = httpContext.cgiGet( "Z997ConveAdiDescri") ;
            Z998ConveAdiAli = localUtil.ctond( httpContext.cgiGet( "Z998ConveAdiAli")) ;
            Z1803ConveAdiTipo = httpContext.cgiGet( "Z1803ConveAdiTipo") ;
            Z1901ConveAdiRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1901ConveAdiRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1901ConveAdiRelSec = ((0==A1901ConveAdiRelSec) ? true : false) ;
            Z2046ConveAdiRelRef = httpContext.cgiGet( "Z2046ConveAdiRelRef") ;
            A2046ConveAdiRelRef = httpContext.cgiGet( "Z2046ConveAdiRelRef") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_91 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_91"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_61 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_61"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_75 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_75"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV31CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV32CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV9ConveAdicod = httpContext.cgiGet( "vCONVEADICOD") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV36aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A2046ConveAdiRelRef = httpContext.cgiGet( "CONVEADIRELREF") ;
            A2047ConveAdiOld = httpContext.cgiGet( "CONVEADIOLD") ;
            AV41Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A1825ConveAdiSitCancDes = httpContext.cgiGet( "CONVEADISITCANCDES") ;
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
            Dvpanel_unnamedtable1_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Objectcall") ;
            Dvpanel_unnamedtable1_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Class") ;
            Dvpanel_unnamedtable1_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Enabled")) ;
            Dvpanel_unnamedtable1_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Width") ;
            Dvpanel_unnamedtable1_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Height") ;
            Dvpanel_unnamedtable1_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autowidth")) ;
            Dvpanel_unnamedtable1_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoheight")) ;
            Dvpanel_unnamedtable1_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Cls") ;
            Dvpanel_unnamedtable1_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showheader")) ;
            Dvpanel_unnamedtable1_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Title") ;
            Dvpanel_unnamedtable1_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsible")) ;
            Dvpanel_unnamedtable1_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Collapsed")) ;
            Dvpanel_unnamedtable1_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Showcollapseicon")) ;
            Dvpanel_unnamedtable1_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Iconposition") ;
            Dvpanel_unnamedtable1_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Autoscroll")) ;
            Dvpanel_unnamedtable1_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Visible")) ;
            Dvpanel_unnamedtable1_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE1_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_unnamedtable2_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Objectcall") ;
            Dvpanel_unnamedtable2_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Class") ;
            Dvpanel_unnamedtable2_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Enabled")) ;
            Dvpanel_unnamedtable2_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Width") ;
            Dvpanel_unnamedtable2_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Height") ;
            Dvpanel_unnamedtable2_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autowidth")) ;
            Dvpanel_unnamedtable2_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoheight")) ;
            Dvpanel_unnamedtable2_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Cls") ;
            Dvpanel_unnamedtable2_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showheader")) ;
            Dvpanel_unnamedtable2_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Title") ;
            Dvpanel_unnamedtable2_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsible")) ;
            Dvpanel_unnamedtable2_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Collapsed")) ;
            Dvpanel_unnamedtable2_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Showcollapseicon")) ;
            Dvpanel_unnamedtable2_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Iconposition") ;
            Dvpanel_unnamedtable2_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Autoscroll")) ;
            Dvpanel_unnamedtable2_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Visible")) ;
            Dvpanel_unnamedtable2_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE2_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Dvpanel_unnamedtable3_Objectcall = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Objectcall") ;
            Dvpanel_unnamedtable3_Class = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Class") ;
            Dvpanel_unnamedtable3_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Enabled")) ;
            Dvpanel_unnamedtable3_Width = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Width") ;
            Dvpanel_unnamedtable3_Height = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Height") ;
            Dvpanel_unnamedtable3_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autowidth")) ;
            Dvpanel_unnamedtable3_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoheight")) ;
            Dvpanel_unnamedtable3_Cls = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Cls") ;
            Dvpanel_unnamedtable3_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Showheader")) ;
            Dvpanel_unnamedtable3_Title = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Title") ;
            Dvpanel_unnamedtable3_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsible")) ;
            Dvpanel_unnamedtable3_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Collapsed")) ;
            Dvpanel_unnamedtable3_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Showcollapseicon")) ;
            Dvpanel_unnamedtable3_Iconposition = httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Iconposition") ;
            Dvpanel_unnamedtable3_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Autoscroll")) ;
            Dvpanel_unnamedtable3_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Visible")) ;
            Dvpanel_unnamedtable3_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_UNNAMEDTABLE3_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
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
            /* Read variables values. */
            A996ConveAdicod = httpContext.cgiGet( edtConveAdicod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            A997ConveAdiDescri = httpContext.cgiGet( edtConveAdiDescri_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A997ConveAdiDescri", A997ConveAdiDescri);
            if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveAdiAli_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiAli_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEADIALI");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveAdiAli_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A998ConveAdiAli = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A998ConveAdiAli", GXutil.ltrimstr( A998ConveAdiAli, 6, 4));
            }
            else
            {
               A998ConveAdiAli = localUtil.ctond( httpContext.cgiGet( edtConveAdiAli_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A998ConveAdiAli", GXutil.ltrimstr( A998ConveAdiAli, 6, 4));
            }
            A1019ConveAdiInfo = httpContext.cgiGet( edtConveAdiInfo_Internalname) ;
            n1019ConveAdiInfo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1019ConveAdiInfo", A1019ConveAdiInfo);
            n1019ConveAdiInfo = ((GXutil.strcmp("", A1019ConveAdiInfo)==0) ? true : false) ;
            cmbConveAdiTipo.setName( cmbConveAdiTipo.getInternalname() );
            cmbConveAdiTipo.setValue( httpContext.cgiGet( cmbConveAdiTipo.getInternalname()) );
            A1803ConveAdiTipo = httpContext.cgiGet( cmbConveAdiTipo.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEADIRELSEC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveAdiRelSec_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1901ConveAdiRelSec = 0 ;
               n1901ConveAdiRelSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
            }
            else
            {
               A1901ConveAdiRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveAdiRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               n1901ConveAdiRelSec = false ;
               httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
            }
            n1901ConveAdiRelSec = ((0==A1901ConveAdiRelSec) ? true : false) ;
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
            forbiddenHiddens.add("hshsalt", "hsh"+"convenio_adicional");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveAdiRelRef", GXutil.rtrim( localUtil.format( A2046ConveAdiRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio_adicional:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
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
                  sMode207 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode207 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound207 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_2W0( ) ;
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
                        e112W2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e122W2 ();
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
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
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
         e122W2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll2W207( ) ;
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
         disableAttributes2W207( ) ;
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

   public void confirm_2W0( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls2W207( ) ;
         }
         else
         {
            checkExtendedTable2W207( ) ;
            closeExtendedTableCursors2W207( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode207 = Gx_mode ;
         confirm_2W245( ) ;
         if ( AnyError == 0 )
         {
            confirm_2W208( ) ;
            if ( AnyError == 0 )
            {
               confirm_2W209( ) ;
               if ( AnyError == 0 )
               {
                  /* Restore parent mode. */
                  Gx_mode = sMode207 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  IsConfirmed = (short)(1) ;
                  httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
               }
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode207 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_2W209( )
   {
      nGXsfl_75_idx = 0 ;
      while ( nGXsfl_75_idx < nRC_GXsfl_75 )
      {
         readRow2W209( ) ;
         if ( ( nRcdExists_209 != 0 ) || ( nIsMod_209 != 0 ) )
         {
            getKey2W209( ) ;
            if ( ( nRcdExists_209 == 0 ) && ( nRcdDeleted_209 == 0 ) )
            {
               if ( RcdFound209 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2W209( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W209( ) ;
                     closeExtendedTableCursors2W209( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CONVEADIOPCCOD_" + sGXsfl_75_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtConveAdiOpcCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound209 != 0 )
               {
                  if ( nRcdDeleted_209 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2W209( ) ;
                     load2W209( ) ;
                     beforeValidate2W209( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W209( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_209 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2W209( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W209( ) ;
                           closeExtendedTableCursors2W209( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_209 == 0 )
                  {
                     GXCCtl = "CONVEADIOPCCOD_" + sGXsfl_75_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiOpcCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiOpcFor_Internalname, GXutil.rtrim( A1021ConveAdiOpcFor)) ;
         httpContext.changePostValue( edtConveAdiOpcDes_Internalname, A1012ConveAdiOpcDes) ;
         httpContext.changePostValue( edtConveAdiOpcAli_Internalname, GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiOpcRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1011ConveAdiOpcCod_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1021ConveAdiOpcFor_"+sGXsfl_75_idx, GXutil.rtrim( Z1021ConveAdiOpcFor)) ;
         httpContext.changePostValue( "ZT_"+"Z1012ConveAdiOpcDes_"+sGXsfl_75_idx, Z1012ConveAdiOpcDes) ;
         httpContext.changePostValue( "ZT_"+"Z1013ConveAdiOpcAli_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1900ConveAdiOpcRelSec_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_209 != 0 )
         {
            httpContext.changePostValue( "CONVEADIOPCCOD_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCFOR_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcFor_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCDES_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcDes_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCALI_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcAli_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCRELSEC_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_2W208( )
   {
      nGXsfl_61_idx = 0 ;
      while ( nGXsfl_61_idx < nRC_GXsfl_61 )
      {
         readRow2W208( ) ;
         if ( ( nRcdExists_208 != 0 ) || ( nIsMod_208 != 0 ) )
         {
            getKey2W208( ) ;
            if ( ( nRcdExists_208 == 0 ) && ( nRcdDeleted_208 == 0 ) )
            {
               if ( RcdFound208 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2W208( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W208( ) ;
                     closeExtendedTableCursors2W208( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CONVEADIVIG_" + sGXsfl_61_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtConveAdiVig_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound208 != 0 )
               {
                  if ( nRcdDeleted_208 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2W208( ) ;
                     load2W208( ) ;
                     beforeValidate2W208( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W208( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_208 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2W208( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W208( ) ;
                           closeExtendedTableCursors2W208( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_208 == 0 )
                  {
                     GXCCtl = "CONVEADIVIG_" + sGXsfl_61_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiVig_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiVig_Internalname, localUtil.format(A999ConveAdiVig, "99/99/99")) ;
         httpContext.changePostValue( edtConveAdiImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiImpRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z999ConveAdiVig_"+sGXsfl_61_idx, localUtil.dtoc( Z999ConveAdiVig, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1000ConveAdiImporte_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( Z1000ConveAdiImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1899ConveAdiImpRelSec_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( Z1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_208 != 0 )
         {
            httpContext.changePostValue( "CONVEADIVIG_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiVig_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIIMPORTE_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImporte_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIIMPRELSEC_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImpRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_2W245( )
   {
      nGXsfl_91_idx = 0 ;
      while ( nGXsfl_91_idx < nRC_GXsfl_91 )
      {
         readRow2W245( ) ;
         if ( ( nRcdExists_245 != 0 ) || ( nIsMod_245 != 0 ) )
         {
            getKey2W245( ) ;
            if ( ( nRcdExists_245 == 0 ) && ( nRcdDeleted_245 == 0 ) )
            {
               if ( RcdFound245 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate2W245( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable2W245( ) ;
                     closeExtendedTableCursors2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CONVEADISITCANCELA_" + sGXsfl_91_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtConveAdiSitCancela_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound245 != 0 )
               {
                  if ( nRcdDeleted_245 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey2W245( ) ;
                     load2W245( ) ;
                     beforeValidate2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls2W245( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_245 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate2W245( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable2W245( ) ;
                           closeExtendedTableCursors2W245( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_245 == 0 )
                  {
                     GXCCtl = "CONVEADISITCANCELA_" + sGXsfl_91_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiSitCancela_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiSitCancela_Internalname, GXutil.rtrim( A1824ConveAdiSitCancela)) ;
         httpContext.changePostValue( edtConveAdiSitCanRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1824ConveAdiSitCancela_"+sGXsfl_91_idx, GXutil.rtrim( Z1824ConveAdiSitCancela)) ;
         httpContext.changePostValue( "ZT_"+"Z1898ConveAdiSitCanRelSec_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( Z1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_245 != 0 )
         {
            httpContext.changePostValue( "CONVEADISITCANCELA_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCancela_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADISITCANRELSEC_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCanRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption2W0( )
   {
   }

   public void e112W2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV10WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV16DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV16DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      Combo_conveadisitcancela_Titlecontrolidtoreplace = edtConveAdiSitCancela_Internalname ;
      ucCombo_conveadisitcancela.sendProperty(context, "", false, Combo_conveadisitcancela_Internalname, "TitleControlIdToReplace", Combo_conveadisitcancela_Titlecontrolidtoreplace);
      AV11IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Insert", GXv_boolean5) ;
         convenio_adicional_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Update", GXv_boolean5) ;
         convenio_adicional_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV11IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWconvenio_adicional_Delete", GXv_boolean5) ;
         convenio_adicional_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV11IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11IsAuthorized", AV11IsAuthorized);
      }
      if ( ! AV11IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV41Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV13TrnContext.fromxml(AV14WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
      GXt_boolean4 = AV42Essistemaconceptosdefault ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      convenio_adicional_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      AV42Essistemaconceptosdefault = GXt_boolean4 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV42Essistemaconceptosdefault", AV42Essistemaconceptosdefault);
      GXv_boolean5[0] = AV35ClienteConveniador ;
      new web.getclienteconveniador(remoteHandle, context).execute( AV30CliCod, GXv_boolean5) ;
      convenio_adicional_impl.this.AV35ClienteConveniador = GXv_boolean5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV35ClienteConveniador", AV35ClienteConveniador);
   }

   public void e122W2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(9);
      pr_default.close(8);
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm2W207( int GX_JID )
   {
      if ( ( GX_JID == 26 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z997ConveAdiDescri = T002W10_A997ConveAdiDescri[0] ;
            Z998ConveAdiAli = T002W10_A998ConveAdiAli[0] ;
            Z1803ConveAdiTipo = T002W10_A1803ConveAdiTipo[0] ;
            Z1901ConveAdiRelSec = T002W10_A1901ConveAdiRelSec[0] ;
            Z2046ConveAdiRelRef = T002W10_A2046ConveAdiRelRef[0] ;
         }
         else
         {
            Z997ConveAdiDescri = A997ConveAdiDescri ;
            Z998ConveAdiAli = A998ConveAdiAli ;
            Z1803ConveAdiTipo = A1803ConveAdiTipo ;
            Z1901ConveAdiRelSec = A1901ConveAdiRelSec ;
            Z2046ConveAdiRelRef = A2046ConveAdiRelRef ;
         }
      }
      if ( GX_JID == -26 )
      {
         Z996ConveAdicod = A996ConveAdicod ;
         Z997ConveAdiDescri = A997ConveAdiDescri ;
         Z998ConveAdiAli = A998ConveAdiAli ;
         Z1019ConveAdiInfo = A1019ConveAdiInfo ;
         Z1803ConveAdiTipo = A1803ConveAdiTipo ;
         Z1901ConveAdiRelSec = A1901ConveAdiRelSec ;
         Z2046ConveAdiRelRef = A2046ConveAdiRelRef ;
         Z2047ConveAdiOld = A2047ConveAdiOld ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV30CliCod) )
      {
         A3CliCod = AV30CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            convenio_adicional_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV30CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV30CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV31CliPaiConve) )
      {
         A1564CliPaiConve = AV31CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      if ( ! (0==AV31CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      else
      {
         edtCliPaiConve_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (0==AV31CliPaiConve) )
      {
         edtCliPaiConve_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV32CliConvenio)==0) )
      {
         A1565CliConvenio = AV32CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      if ( ! (GXutil.strcmp("", AV32CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      else
      {
         edtCliConvenio_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV32CliConvenio)==0) )
      {
         edtCliConvenio_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9ConveAdicod)==0) )
      {
         A996ConveAdicod = AV9ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
      if ( ! (GXutil.strcmp("", AV9ConveAdicod)==0) )
      {
         edtConveAdicod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      }
      else
      {
         edtConveAdicod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9ConveAdicod)==0) )
      {
         edtConveAdicod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
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
      if ( isIns( )  && (GXutil.strcmp("", A1803ConveAdiTipo)==0) && ( Gx_BScreen == 0 ) )
      {
         A1803ConveAdiTipo = "otros" ;
         httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV41Pgmname = "convenio_adicional" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
      }
   }

   public void load2W207( )
   {
      /* Using cursor T002W12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(10) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A997ConveAdiDescri = T002W12_A997ConveAdiDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A997ConveAdiDescri", A997ConveAdiDescri);
         A998ConveAdiAli = T002W12_A998ConveAdiAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A998ConveAdiAli", GXutil.ltrimstr( A998ConveAdiAli, 6, 4));
         A1019ConveAdiInfo = T002W12_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = T002W12_n1019ConveAdiInfo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1019ConveAdiInfo", A1019ConveAdiInfo);
         A1803ConveAdiTipo = T002W12_A1803ConveAdiTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
         A1901ConveAdiRelSec = T002W12_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = T002W12_n1901ConveAdiRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
         A2046ConveAdiRelRef = T002W12_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = T002W12_A2047ConveAdiOld[0] ;
         zm2W207( -26) ;
      }
      pr_default.close(10);
      onLoadActions2W207( ) ;
   }

   public void onLoadActions2W207( )
   {
      AV41Pgmname = "convenio_adicional" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
   }

   public void checkExtendedTable2W207( )
   {
      nIsDirty_207 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV41Pgmname = "convenio_adicional" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1901ConveAdiRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      /* Using cursor T002W11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(9) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(9);
      if ( ! ( ( GXutil.strcmp(A1803ConveAdiTipo, "titulo") == 0 ) || ( GXutil.strcmp(A1803ConveAdiTipo, "otros") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVEADITIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConveAdiTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors2W207( )
   {
      pr_default.close(9);
   }

   public void enableDisable( )
   {
   }

   public void gxload_27( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T002W13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(11) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(11) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(11);
   }

   public void getKey2W207( )
   {
      /* Using cursor T002W14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound207 = (short)(1) ;
      }
      else
      {
         RcdFound207 = (short)(0) ;
      }
      pr_default.close(12);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T002W10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      if ( (pr_default.getStatus(8) != 101) )
      {
         zm2W207( 26) ;
         RcdFound207 = (short)(1) ;
         A996ConveAdicod = T002W10_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         A997ConveAdiDescri = T002W10_A997ConveAdiDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A997ConveAdiDescri", A997ConveAdiDescri);
         A998ConveAdiAli = T002W10_A998ConveAdiAli[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A998ConveAdiAli", GXutil.ltrimstr( A998ConveAdiAli, 6, 4));
         A1019ConveAdiInfo = T002W10_A1019ConveAdiInfo[0] ;
         n1019ConveAdiInfo = T002W10_n1019ConveAdiInfo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1019ConveAdiInfo", A1019ConveAdiInfo);
         A1803ConveAdiTipo = T002W10_A1803ConveAdiTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
         A1901ConveAdiRelSec = T002W10_A1901ConveAdiRelSec[0] ;
         n1901ConveAdiRelSec = T002W10_n1901ConveAdiRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
         A2046ConveAdiRelRef = T002W10_A2046ConveAdiRelRef[0] ;
         A2047ConveAdiOld = T002W10_A2047ConveAdiOld[0] ;
         A3CliCod = T002W10_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T002W10_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T002W10_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         sMode207 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2W207( ) ;
         if ( AnyError == 1 )
         {
            RcdFound207 = (short)(0) ;
            initializeNonKey2W207( ) ;
         }
         Gx_mode = sMode207 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound207 = (short)(0) ;
         initializeNonKey2W207( ) ;
         sMode207 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode207 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(8);
   }

   public void getEqualNoModal( )
   {
      getKey2W207( ) ;
      if ( RcdFound207 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound207 = (short)(0) ;
      /* Using cursor T002W15 */
      pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod});
      if ( (pr_default.getStatus(13) != 101) )
      {
         while ( (pr_default.getStatus(13) != 101) && ( ( T002W15_A3CliCod[0] < A3CliCod ) || ( T002W15_A3CliCod[0] == A3CliCod ) && ( T002W15_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T002W15_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W15_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W15_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T002W15_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002W15_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W15_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W15_A996ConveAdicod[0], A996ConveAdicod) < 0 ) ) )
         {
            pr_default.readNext(13);
         }
         if ( (pr_default.getStatus(13) != 101) && ( ( T002W15_A3CliCod[0] > A3CliCod ) || ( T002W15_A3CliCod[0] == A3CliCod ) && ( T002W15_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T002W15_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W15_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W15_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T002W15_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002W15_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W15_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W15_A996ConveAdicod[0], A996ConveAdicod) > 0 ) ) )
         {
            A3CliCod = T002W15_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T002W15_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T002W15_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T002W15_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            RcdFound207 = (short)(1) ;
         }
      }
      pr_default.close(13);
   }

   public void move_previous( )
   {
      RcdFound207 = (short)(0) ;
      /* Using cursor T002W16 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A996ConveAdicod});
      if ( (pr_default.getStatus(14) != 101) )
      {
         while ( (pr_default.getStatus(14) != 101) && ( ( T002W16_A3CliCod[0] > A3CliCod ) || ( T002W16_A3CliCod[0] == A3CliCod ) && ( T002W16_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T002W16_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W16_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W16_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T002W16_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002W16_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W16_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W16_A996ConveAdicod[0], A996ConveAdicod) > 0 ) ) )
         {
            pr_default.readNext(14);
         }
         if ( (pr_default.getStatus(14) != 101) && ( ( T002W16_A3CliCod[0] < A3CliCod ) || ( T002W16_A3CliCod[0] == A3CliCod ) && ( T002W16_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T002W16_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W16_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W16_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T002W16_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T002W16_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T002W16_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T002W16_A996ConveAdicod[0], A996ConveAdicod) < 0 ) ) )
         {
            A3CliCod = T002W16_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T002W16_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T002W16_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A996ConveAdicod = T002W16_A996ConveAdicod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
            RcdFound207 = (short)(1) ;
         }
      }
      pr_default.close(14);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey2W207( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert2W207( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound207 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A996ConveAdicod = Z996ConveAdicod ;
               httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update2W207( ) ;
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtConveAdicod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert2W207( ) ;
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
                  GX_FocusControl = edtConveAdicod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert2W207( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A996ConveAdicod, Z996ConveAdicod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = Z996ConveAdicod ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConveAdicod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency2W207( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002W9 */
         pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicional"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z997ConveAdiDescri, T002W9_A997ConveAdiDescri[0]) != 0 ) || ( DecimalUtil.compareTo(Z998ConveAdiAli, T002W9_A998ConveAdiAli[0]) != 0 ) || ( GXutil.strcmp(Z1803ConveAdiTipo, T002W9_A1803ConveAdiTipo[0]) != 0 ) || ( Z1901ConveAdiRelSec != T002W9_A1901ConveAdiRelSec[0] ) || ( GXutil.strcmp(Z2046ConveAdiRelRef, T002W9_A2046ConveAdiRelRef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z997ConveAdiDescri, T002W9_A997ConveAdiDescri[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiDescri");
               GXutil.writeLogRaw("Old: ",Z997ConveAdiDescri);
               GXutil.writeLogRaw("Current: ",T002W9_A997ConveAdiDescri[0]);
            }
            if ( DecimalUtil.compareTo(Z998ConveAdiAli, T002W9_A998ConveAdiAli[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiAli");
               GXutil.writeLogRaw("Old: ",Z998ConveAdiAli);
               GXutil.writeLogRaw("Current: ",T002W9_A998ConveAdiAli[0]);
            }
            if ( GXutil.strcmp(Z1803ConveAdiTipo, T002W9_A1803ConveAdiTipo[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiTipo");
               GXutil.writeLogRaw("Old: ",Z1803ConveAdiTipo);
               GXutil.writeLogRaw("Current: ",T002W9_A1803ConveAdiTipo[0]);
            }
            if ( Z1901ConveAdiRelSec != T002W9_A1901ConveAdiRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiRelSec");
               GXutil.writeLogRaw("Old: ",Z1901ConveAdiRelSec);
               GXutil.writeLogRaw("Current: ",T002W9_A1901ConveAdiRelSec[0]);
            }
            if ( GXutil.strcmp(Z2046ConveAdiRelRef, T002W9_A2046ConveAdiRelRef[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiRelRef");
               GXutil.writeLogRaw("Old: ",Z2046ConveAdiRelRef);
               GXutil.writeLogRaw("Current: ",T002W9_A2046ConveAdiRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicional"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W207( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W207( 0) ;
         checkOptimisticConcurrency2W207( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W207( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W207( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W17 */
                  pr_default.execute(15, new Object[] {A996ConveAdicod, A997ConveAdiDescri, A998ConveAdiAli, Boolean.valueOf(n1019ConveAdiInfo), A1019ConveAdiInfo, A1803ConveAdiTipo, Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A2046ConveAdiRelRef, A2047ConveAdiOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
                  if ( (pr_default.getStatus(15) == 1) )
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
                        processLevel2W207( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption2W0( ) ;
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
         else
         {
            load2W207( ) ;
         }
         endLevel2W207( ) ;
      }
      closeExtendedTableCursors2W207( ) ;
   }

   public void update2W207( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W207( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W207( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate2W207( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W18 */
                  pr_default.execute(16, new Object[] {A997ConveAdiDescri, A998ConveAdiAli, Boolean.valueOf(n1019ConveAdiInfo), A1019ConveAdiInfo, A1803ConveAdiTipo, Boolean.valueOf(n1901ConveAdiRelSec), Integer.valueOf(A1901ConveAdiRelSec), A2046ConveAdiRelRef, A2047ConveAdiOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
                  if ( (pr_default.getStatus(16) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicional"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate2W207( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel2W207( ) ;
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
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel2W207( ) ;
      }
      closeExtendedTableCursors2W207( ) ;
   }

   public void deferredUpdate2W207( )
   {
   }

   public void delete( )
   {
      beforeValidate2W207( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W207( ) ;
         afterConfirm2W207( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W207( ) ;
            if ( AnyError == 0 )
            {
               scanStart2W245( ) ;
               while ( RcdFound245 != 0 )
               {
                  getByPrimaryKey2W245( ) ;
                  delete2W245( ) ;
                  scanNext2W245( ) ;
               }
               scanEnd2W245( ) ;
               scanStart2W209( ) ;
               while ( RcdFound209 != 0 )
               {
                  getByPrimaryKey2W209( ) ;
                  delete2W209( ) ;
                  scanNext2W209( ) ;
               }
               scanEnd2W209( ) ;
               scanStart2W208( ) ;
               while ( RcdFound208 != 0 )
               {
                  getByPrimaryKey2W208( ) ;
                  delete2W208( ) ;
                  scanNext2W208( ) ;
               }
               scanEnd2W208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W19 */
                  pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicional");
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
      }
      sMode207 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2W207( ) ;
      Gx_mode = sMode207 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2W207( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV36aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1901ConveAdiRelSec, GXv_boolean5) ;
            convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
         }
         AV41Pgmname = "convenio_adicional" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV41Pgmname", AV41Pgmname);
      }
   }

   public void processNestedLevel2W245( )
   {
      nGXsfl_91_idx = 0 ;
      while ( nGXsfl_91_idx < nRC_GXsfl_91 )
      {
         readRow2W245( ) ;
         if ( ( nRcdExists_245 != 0 ) || ( nIsMod_245 != 0 ) )
         {
            standaloneNotModal2W245( ) ;
            getKey2W245( ) ;
            if ( ( nRcdExists_245 == 0 ) && ( nRcdDeleted_245 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2W245( ) ;
            }
            else
            {
               if ( RcdFound245 != 0 )
               {
                  if ( ( nRcdDeleted_245 != 0 ) && ( nRcdExists_245 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2W245( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_245 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2W245( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_245 == 0 )
                  {
                     GXCCtl = "CONVEADISITCANCELA_" + sGXsfl_91_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiSitCancela_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiSitCancela_Internalname, GXutil.rtrim( A1824ConveAdiSitCancela)) ;
         httpContext.changePostValue( edtConveAdiSitCanRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1824ConveAdiSitCancela_"+sGXsfl_91_idx, GXutil.rtrim( Z1824ConveAdiSitCancela)) ;
         httpContext.changePostValue( "ZT_"+"Z1898ConveAdiSitCanRelSec_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( Z1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_245_"+sGXsfl_91_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_245 != 0 )
         {
            httpContext.changePostValue( "CONVEADISITCANCELA_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCancela_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADISITCANRELSEC_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCanRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W245( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_245 = (short)(0) ;
      nIsMod_245 = (short)(0) ;
      nRcdDeleted_245 = (short)(0) ;
   }

   public void processNestedLevel2W208( )
   {
      nGXsfl_61_idx = 0 ;
      while ( nGXsfl_61_idx < nRC_GXsfl_61 )
      {
         readRow2W208( ) ;
         if ( ( nRcdExists_208 != 0 ) || ( nIsMod_208 != 0 ) )
         {
            standaloneNotModal2W208( ) ;
            getKey2W208( ) ;
            if ( ( nRcdExists_208 == 0 ) && ( nRcdDeleted_208 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2W208( ) ;
            }
            else
            {
               if ( RcdFound208 != 0 )
               {
                  if ( ( nRcdDeleted_208 != 0 ) && ( nRcdExists_208 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2W208( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_208 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2W208( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_208 == 0 )
                  {
                     GXCCtl = "CONVEADIVIG_" + sGXsfl_61_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiVig_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiVig_Internalname, localUtil.format(A999ConveAdiVig, "99/99/99")) ;
         httpContext.changePostValue( edtConveAdiImporte_Internalname, GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiImpRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z999ConveAdiVig_"+sGXsfl_61_idx, localUtil.dtoc( Z999ConveAdiVig, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1000ConveAdiImporte_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( Z1000ConveAdiImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1899ConveAdiImpRelSec_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( Z1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_208_"+sGXsfl_61_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_208 != 0 )
         {
            httpContext.changePostValue( "CONVEADIVIG_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiVig_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIIMPORTE_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImporte_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIIMPRELSEC_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImpRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W208( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_208 = (short)(0) ;
      nIsMod_208 = (short)(0) ;
      nRcdDeleted_208 = (short)(0) ;
   }

   public void processNestedLevel2W209( )
   {
      nGXsfl_75_idx = 0 ;
      while ( nGXsfl_75_idx < nRC_GXsfl_75 )
      {
         readRow2W209( ) ;
         if ( ( nRcdExists_209 != 0 ) || ( nIsMod_209 != 0 ) )
         {
            standaloneNotModal2W209( ) ;
            getKey2W209( ) ;
            if ( ( nRcdExists_209 == 0 ) && ( nRcdDeleted_209 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert2W209( ) ;
            }
            else
            {
               if ( RcdFound209 != 0 )
               {
                  if ( ( nRcdDeleted_209 != 0 ) && ( nRcdExists_209 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete2W209( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_209 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update2W209( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_209 == 0 )
                  {
                     GXCCtl = "CONVEADIOPCCOD_" + sGXsfl_75_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveAdiOpcCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtConveAdiOpcCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiOpcFor_Internalname, GXutil.rtrim( A1021ConveAdiOpcFor)) ;
         httpContext.changePostValue( edtConveAdiOpcDes_Internalname, A1012ConveAdiOpcDes) ;
         httpContext.changePostValue( edtConveAdiOpcAli_Internalname, GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtConveAdiOpcRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1011ConveAdiOpcCod_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1021ConveAdiOpcFor_"+sGXsfl_75_idx, GXutil.rtrim( Z1021ConveAdiOpcFor)) ;
         httpContext.changePostValue( "ZT_"+"Z1012ConveAdiOpcDes_"+sGXsfl_75_idx, Z1012ConveAdiOpcDes) ;
         httpContext.changePostValue( "ZT_"+"Z1013ConveAdiOpcAli_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1900ConveAdiOpcRelSec_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( Z1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_209_"+sGXsfl_75_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_209 != 0 )
         {
            httpContext.changePostValue( "CONVEADIOPCCOD_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCFOR_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcFor_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCDES_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcDes_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCALI_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcAli_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CONVEADIOPCRELSEC_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll2W209( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_209 = (short)(0) ;
      nIsMod_209 = (short)(0) ;
      nRcdDeleted_209 = (short)(0) ;
   }

   public void processLevel2W207( )
   {
      /* Save parent mode. */
      sMode207 = Gx_mode ;
      processNestedLevel2W245( ) ;
      processNestedLevel2W208( ) ;
      processNestedLevel2W209( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode207 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel2W207( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete2W207( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio_adicional");
         if ( AnyError == 0 )
         {
            confirmValues2W0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio_adicional");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2W207( )
   {
      /* Scan By routine */
      /* Using cursor T002W20 */
      pr_default.execute(18);
      RcdFound207 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A3CliCod = T002W20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T002W20_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T002W20_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T002W20_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2W207( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound207 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound207 = (short)(1) ;
         A3CliCod = T002W20_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T002W20_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T002W20_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A996ConveAdicod = T002W20_A996ConveAdicod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      }
   }

   public void scanEnd2W207( )
   {
      pr_default.close(18);
   }

   public void afterConfirm2W207( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1901ConveAdiRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiRelSec", 1, "CONVEADIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2W207( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W207( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W207( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W207( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W207( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W207( )
   {
      edtConveAdicod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdicod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdicod_Enabled), 5, 0), true);
      edtConveAdiDescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiDescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiDescri_Enabled), 5, 0), true);
      edtConveAdiAli_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiAli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiAli_Enabled), 5, 0), true);
      edtConveAdiInfo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiInfo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiInfo_Enabled), 5, 0), true);
      cmbConveAdiTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConveAdiTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConveAdiTipo.getEnabled(), 5, 0), true);
      edtConveAdiRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiRelSec_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void zm2W245( int GX_JID )
   {
      if ( ( GX_JID == 28 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1898ConveAdiSitCanRelSec = T002W7_A1898ConveAdiSitCanRelSec[0] ;
         }
         else
         {
            Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
         }
      }
      if ( GX_JID == -28 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1898ConveAdiSitCanRelSec = A1898ConveAdiSitCanRelSec ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1825ConveAdiSitCancDes = A1825ConveAdiSitCancDes ;
      }
   }

   public void standaloneNotModal2W245( )
   {
   }

   public void standaloneModal2W245( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtConveAdiSitCancela_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), !bGXsfl_91_Refreshing);
      }
      else
      {
         edtConveAdiSitCancela_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), !bGXsfl_91_Refreshing);
      }
   }

   public void load2W245( )
   {
      /* Using cursor T002W21 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1825ConveAdiSitCancDes = T002W21_A1825ConveAdiSitCancDes[0] ;
         A1898ConveAdiSitCanRelSec = T002W21_A1898ConveAdiSitCanRelSec[0] ;
         zm2W245( -28) ;
      }
      pr_default.close(19);
      onLoadActions2W245( ) ;
   }

   public void onLoadActions2W245( )
   {
   }

   public void checkExtendedTable2W245( )
   {
      nIsDirty_245 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal2W245( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      /* Using cursor T002W8 */
      pr_default.execute(6, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(6) == 101) )
      {
         GXCCtl = "CONVEADISITCANCELA_" + sGXsfl_91_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1825ConveAdiSitCancDes = T002W8_A1825ConveAdiSitCancDes[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors2W245( )
   {
      pr_default.close(6);
   }

   public void enableDisable2W245( )
   {
   }

   public void gxload_29( String A1824ConveAdiSitCancela )
   {
      /* Using cursor T002W22 */
      pr_default.execute(20, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(20) == 101) )
      {
         GXCCtl = "CONVEADISITCANCELA_" + sGXsfl_91_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1825ConveAdiSitCancDes = T002W22_A1825ConveAdiSitCancDes[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1825ConveAdiSitCancDes)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(20) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(20);
   }

   public void getKey2W245( )
   {
      /* Using cursor T002W23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound245 = (short)(1) ;
      }
      else
      {
         RcdFound245 = (short)(0) ;
      }
      pr_default.close(21);
   }

   public void getByPrimaryKey2W245( )
   {
      /* Using cursor T002W7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(5) != 101) )
      {
         zm2W245( 28) ;
         RcdFound245 = (short)(1) ;
         initializeNonKey2W245( ) ;
         A1898ConveAdiSitCanRelSec = T002W7_A1898ConveAdiSitCanRelSec[0] ;
         A1824ConveAdiSitCancela = T002W7_A1824ConveAdiSitCancela[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1824ConveAdiSitCancela = A1824ConveAdiSitCancela ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2W245( ) ;
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound245 = (short)(0) ;
         initializeNonKey2W245( ) ;
         sMode245 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2W245( ) ;
         Gx_mode = sMode245 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W245( ) ;
      }
      pr_default.close(5);
   }

   public void checkOptimisticConcurrency2W245( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002W6 */
         pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
         if ( (pr_default.getStatus(4) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(4) == 101) || ( Z1898ConveAdiSitCanRelSec != T002W6_A1898ConveAdiSitCanRelSec[0] ) )
         {
            if ( Z1898ConveAdiSitCanRelSec != T002W6_A1898ConveAdiSitCanRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiSitCanRelSec");
               GXutil.writeLogRaw("Old: ",Z1898ConveAdiSitCanRelSec);
               GXutil.writeLogRaw("Current: ",T002W6_A1898ConveAdiSitCanRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalCancela"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W245( )
   {
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W245( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W245( 0) ;
         checkOptimisticConcurrency2W245( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W245( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W245( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W24 */
                  pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, Integer.valueOf(A1898ConveAdiSitCanRelSec), A1824ConveAdiSitCancela, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                  if ( (pr_default.getStatus(22) == 1) )
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
            load2W245( ) ;
         }
         endLevel2W245( ) ;
      }
      closeExtendedTableCursors2W245( ) ;
   }

   public void update2W245( )
   {
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W245( ) ;
      }
      if ( ( nIsMod_245 != 0 ) || ( nIsDirty_245 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2W245( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2W245( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2W245( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002W25 */
                     pr_default.execute(23, new Object[] {Integer.valueOf(A1898ConveAdiSitCanRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
                     if ( (pr_default.getStatus(23) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalCancela"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2W245( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2W245( ) ;
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
            endLevel2W245( ) ;
         }
      }
      closeExtendedTableCursors2W245( ) ;
   }

   public void deferredUpdate2W245( )
   {
   }

   public void delete2W245( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2W245( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W245( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W245( ) ;
         afterConfirm2W245( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W245( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002W26 */
               pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A1824ConveAdiSitCancela});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalCancela");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
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
      endLevel2W245( ) ;
      Gx_mode = sMode245 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2W245( )
   {
      standaloneModal2W245( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV36aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
            convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
         }
         /* Using cursor T002W27 */
         pr_default.execute(25, new Object[] {A1824ConveAdiSitCancela});
         A1825ConveAdiSitCancDes = T002W27_A1825ConveAdiSitCancDes[0] ;
         pr_default.close(25);
      }
   }

   public void endLevel2W245( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(4);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2W245( )
   {
      /* Scan By routine */
      /* Using cursor T002W28 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound245 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1824ConveAdiSitCancela = T002W28_A1824ConveAdiSitCancela[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2W245( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound245 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound245 = (short)(1) ;
         A1824ConveAdiSitCancela = T002W28_A1824ConveAdiSitCancela[0] ;
      }
   }

   public void scanEnd2W245( )
   {
      pr_default.close(26);
   }

   public void afterConfirm2W245( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1898ConveAdiSitCanRelSec) )
      {
         GXCCtl = "CONVEADISITCANRELSEC_" + sGXsfl_91_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiSitCanRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCanRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1901ConveAdiRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiRelSec", 1, "CONVEADIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2W245( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W245( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W245( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W245( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W245( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W245( )
   {
      edtConveAdiSitCancela_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), !bGXsfl_91_Refreshing);
      edtConveAdiSitCanRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCanRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCanRelSec_Enabled), 5, 0), !bGXsfl_91_Refreshing);
   }

   public void send_integrity_lvl_hashes2W245( )
   {
   }

   public void zm2W208( int GX_JID )
   {
      if ( ( GX_JID == 30 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1000ConveAdiImporte = T002W5_A1000ConveAdiImporte[0] ;
            Z1899ConveAdiImpRelSec = T002W5_A1899ConveAdiImpRelSec[0] ;
         }
         else
         {
            Z1000ConveAdiImporte = A1000ConveAdiImporte ;
            Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
         }
      }
      if ( GX_JID == -30 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z999ConveAdiVig = A999ConveAdiVig ;
         Z1000ConveAdiImporte = A1000ConveAdiImporte ;
         Z1899ConveAdiImpRelSec = A1899ConveAdiImpRelSec ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2W208( )
   {
   }

   public void standaloneModal2W208( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtConveAdiVig_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), !bGXsfl_61_Refreshing);
      }
      else
      {
         edtConveAdiVig_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), !bGXsfl_61_Refreshing);
      }
   }

   public void load2W208( )
   {
      /* Using cursor T002W29 */
      pr_default.execute(27, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(27) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A1000ConveAdiImporte = T002W29_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = T002W29_A1899ConveAdiImpRelSec[0] ;
         zm2W208( -30) ;
      }
      pr_default.close(27);
      onLoadActions2W208( ) ;
   }

   public void onLoadActions2W208( )
   {
   }

   public void checkExtendedTable2W208( )
   {
      nIsDirty_208 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal2W208( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
   }

   public void closeExtendedTableCursors2W208( )
   {
   }

   public void enableDisable2W208( )
   {
   }

   public void getKey2W208( )
   {
      /* Using cursor T002W30 */
      pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(28) != 101) )
      {
         RcdFound208 = (short)(1) ;
      }
      else
      {
         RcdFound208 = (short)(0) ;
      }
      pr_default.close(28);
   }

   public void getByPrimaryKey2W208( )
   {
      /* Using cursor T002W5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm2W208( 30) ;
         RcdFound208 = (short)(1) ;
         initializeNonKey2W208( ) ;
         A999ConveAdiVig = T002W5_A999ConveAdiVig[0] ;
         A1000ConveAdiImporte = T002W5_A1000ConveAdiImporte[0] ;
         A1899ConveAdiImpRelSec = T002W5_A1899ConveAdiImpRelSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z999ConveAdiVig = A999ConveAdiVig ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2W208( ) ;
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound208 = (short)(0) ;
         initializeNonKey2W208( ) ;
         sMode208 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2W208( ) ;
         Gx_mode = sMode208 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W208( ) ;
      }
      pr_default.close(3);
   }

   public void checkOptimisticConcurrency2W208( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002W4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( DecimalUtil.compareTo(Z1000ConveAdiImporte, T002W4_A1000ConveAdiImporte[0]) != 0 ) || ( Z1899ConveAdiImpRelSec != T002W4_A1899ConveAdiImpRelSec[0] ) )
         {
            if ( DecimalUtil.compareTo(Z1000ConveAdiImporte, T002W4_A1000ConveAdiImporte[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiImporte");
               GXutil.writeLogRaw("Old: ",Z1000ConveAdiImporte);
               GXutil.writeLogRaw("Current: ",T002W4_A1000ConveAdiImporte[0]);
            }
            if ( Z1899ConveAdiImpRelSec != T002W4_A1899ConveAdiImpRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiImpRelSec");
               GXutil.writeLogRaw("Old: ",Z1899ConveAdiImpRelSec);
               GXutil.writeLogRaw("Current: ",T002W4_A1899ConveAdiImpRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalimportes"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W208( )
   {
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W208( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W208( 0) ;
         checkOptimisticConcurrency2W208( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W208( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W208( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W31 */
                  pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig, A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
                  if ( (pr_default.getStatus(29) == 1) )
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
            load2W208( ) ;
         }
         endLevel2W208( ) ;
      }
      closeExtendedTableCursors2W208( ) ;
   }

   public void update2W208( )
   {
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W208( ) ;
      }
      if ( ( nIsMod_208 != 0 ) || ( nIsDirty_208 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2W208( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2W208( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2W208( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002W32 */
                     pr_default.execute(30, new Object[] {A1000ConveAdiImporte, Integer.valueOf(A1899ConveAdiImpRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
                     if ( (pr_default.getStatus(30) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalimportes"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2W208( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2W208( ) ;
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
            endLevel2W208( ) ;
         }
      }
      closeExtendedTableCursors2W208( ) ;
   }

   public void deferredUpdate2W208( )
   {
   }

   public void delete2W208( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2W208( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W208( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W208( ) ;
         afterConfirm2W208( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W208( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002W33 */
               pr_default.execute(31, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, A999ConveAdiVig});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalimportes");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode208 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2W208( ) ;
      Gx_mode = sMode208 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2W208( )
   {
      standaloneModal2W208( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV36aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
            convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
         }
      }
   }

   public void endLevel2W208( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2W208( )
   {
      /* Scan By routine */
      /* Using cursor T002W34 */
      pr_default.execute(32, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound208 = (short)(0) ;
      if ( (pr_default.getStatus(32) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A999ConveAdiVig = T002W34_A999ConveAdiVig[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2W208( )
   {
      /* Scan next routine */
      pr_default.readNext(32);
      RcdFound208 = (short)(0) ;
      if ( (pr_default.getStatus(32) != 101) )
      {
         RcdFound208 = (short)(1) ;
         A999ConveAdiVig = T002W34_A999ConveAdiVig[0] ;
      }
   }

   public void scanEnd2W208( )
   {
      pr_default.close(32);
   }

   public void afterConfirm2W208( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1899ConveAdiImpRelSec) )
      {
         GXCCtl = "CONVEADIIMPRELSEC_" + sGXsfl_61_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiImpRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiImpRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1901ConveAdiRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiRelSec", 1, "CONVEADIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2W208( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W208( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W208( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W208( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W208( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W208( )
   {
      edtConveAdiVig_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), !bGXsfl_61_Refreshing);
      edtConveAdiImporte_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiImporte_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiImporte_Enabled), 5, 0), !bGXsfl_61_Refreshing);
      edtConveAdiImpRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiImpRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiImpRelSec_Enabled), 5, 0), !bGXsfl_61_Refreshing);
   }

   public void send_integrity_lvl_hashes2W208( )
   {
   }

   public void zm2W209( int GX_JID )
   {
      if ( ( GX_JID == 31 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1021ConveAdiOpcFor = T002W3_A1021ConveAdiOpcFor[0] ;
            Z1012ConveAdiOpcDes = T002W3_A1012ConveAdiOpcDes[0] ;
            Z1013ConveAdiOpcAli = T002W3_A1013ConveAdiOpcAli[0] ;
            Z1900ConveAdiOpcRelSec = T002W3_A1900ConveAdiOpcRelSec[0] ;
         }
         else
         {
            Z1021ConveAdiOpcFor = A1021ConveAdiOpcFor ;
            Z1012ConveAdiOpcDes = A1012ConveAdiOpcDes ;
            Z1013ConveAdiOpcAli = A1013ConveAdiOpcAli ;
            Z1900ConveAdiOpcRelSec = A1900ConveAdiOpcRelSec ;
         }
      }
      if ( GX_JID == -31 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
         Z1021ConveAdiOpcFor = A1021ConveAdiOpcFor ;
         Z1012ConveAdiOpcDes = A1012ConveAdiOpcDes ;
         Z1013ConveAdiOpcAli = A1013ConveAdiOpcAli ;
         Z1900ConveAdiOpcRelSec = A1900ConveAdiOpcRelSec ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal2W209( )
   {
   }

   public void standaloneModal2W209( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtConveAdiOpcCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcCod_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      }
      else
      {
         edtConveAdiOpcCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcCod_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      }
   }

   public void load2W209( )
   {
      /* Using cursor T002W35 */
      pr_default.execute(33, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(33) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1021ConveAdiOpcFor = T002W35_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = T002W35_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = T002W35_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = T002W35_A1900ConveAdiOpcRelSec[0] ;
         zm2W209( -31) ;
      }
      pr_default.close(33);
      onLoadActions2W209( ) ;
   }

   public void onLoadActions2W209( )
   {
   }

   public void checkExtendedTable2W209( )
   {
      nIsDirty_209 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal2W209( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1900ConveAdiOpcRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
   }

   public void closeExtendedTableCursors2W209( )
   {
   }

   public void enableDisable2W209( )
   {
   }

   public void getKey2W209( )
   {
      /* Using cursor T002W36 */
      pr_default.execute(34, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(34) != 101) )
      {
         RcdFound209 = (short)(1) ;
      }
      else
      {
         RcdFound209 = (short)(0) ;
      }
      pr_default.close(34);
   }

   public void getByPrimaryKey2W209( )
   {
      /* Using cursor T002W3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm2W209( 31) ;
         RcdFound209 = (short)(1) ;
         initializeNonKey2W209( ) ;
         A1011ConveAdiOpcCod = T002W3_A1011ConveAdiOpcCod[0] ;
         A1021ConveAdiOpcFor = T002W3_A1021ConveAdiOpcFor[0] ;
         A1012ConveAdiOpcDes = T002W3_A1012ConveAdiOpcDes[0] ;
         A1013ConveAdiOpcAli = T002W3_A1013ConveAdiOpcAli[0] ;
         A1900ConveAdiOpcRelSec = T002W3_A1900ConveAdiOpcRelSec[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z996ConveAdicod = A996ConveAdicod ;
         Z1011ConveAdiOpcCod = A1011ConveAdiOpcCod ;
         sMode209 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load2W209( ) ;
         Gx_mode = sMode209 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound209 = (short)(0) ;
         initializeNonKey2W209( ) ;
         sMode209 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal2W209( ) ;
         Gx_mode = sMode209 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes2W209( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency2W209( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T002W2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalalicuotas"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z1021ConveAdiOpcFor, T002W2_A1021ConveAdiOpcFor[0]) != 0 ) || ( GXutil.strcmp(Z1012ConveAdiOpcDes, T002W2_A1012ConveAdiOpcDes[0]) != 0 ) || ( DecimalUtil.compareTo(Z1013ConveAdiOpcAli, T002W2_A1013ConveAdiOpcAli[0]) != 0 ) || ( Z1900ConveAdiOpcRelSec != T002W2_A1900ConveAdiOpcRelSec[0] ) )
         {
            if ( GXutil.strcmp(Z1021ConveAdiOpcFor, T002W2_A1021ConveAdiOpcFor[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiOpcFor");
               GXutil.writeLogRaw("Old: ",Z1021ConveAdiOpcFor);
               GXutil.writeLogRaw("Current: ",T002W2_A1021ConveAdiOpcFor[0]);
            }
            if ( GXutil.strcmp(Z1012ConveAdiOpcDes, T002W2_A1012ConveAdiOpcDes[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiOpcDes");
               GXutil.writeLogRaw("Old: ",Z1012ConveAdiOpcDes);
               GXutil.writeLogRaw("Current: ",T002W2_A1012ConveAdiOpcDes[0]);
            }
            if ( DecimalUtil.compareTo(Z1013ConveAdiOpcAli, T002W2_A1013ConveAdiOpcAli[0]) != 0 )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiOpcAli");
               GXutil.writeLogRaw("Old: ",Z1013ConveAdiOpcAli);
               GXutil.writeLogRaw("Current: ",T002W2_A1013ConveAdiOpcAli[0]);
            }
            if ( Z1900ConveAdiOpcRelSec != T002W2_A1900ConveAdiOpcRelSec[0] )
            {
               GXutil.writeLogln("convenio_adicional:[seudo value changed for attri]"+"ConveAdiOpcRelSec");
               GXutil.writeLogRaw("Old: ",Z1900ConveAdiOpcRelSec);
               GXutil.writeLogRaw("Current: ",T002W2_A1900ConveAdiOpcRelSec[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"convenio_adicionalalicuotas"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert2W209( )
   {
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W209( ) ;
      }
      if ( AnyError == 0 )
      {
         zm2W209( 0) ;
         checkOptimisticConcurrency2W209( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm2W209( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert2W209( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T002W37 */
                  pr_default.execute(35, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod), A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A1900ConveAdiOpcRelSec), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
                  if ( (pr_default.getStatus(35) == 1) )
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
            load2W209( ) ;
         }
         endLevel2W209( ) ;
      }
      closeExtendedTableCursors2W209( ) ;
   }

   public void update2W209( )
   {
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable2W209( ) ;
      }
      if ( ( nIsMod_209 != 0 ) || ( nIsDirty_209 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency2W209( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm2W209( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate2W209( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T002W38 */
                     pr_default.execute(36, new Object[] {A1021ConveAdiOpcFor, A1012ConveAdiOpcDes, A1013ConveAdiOpcAli, Integer.valueOf(A1900ConveAdiOpcRelSec), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
                     if ( (pr_default.getStatus(36) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"convenio_adicionalalicuotas"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate2W209( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey2W209( ) ;
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
            endLevel2W209( ) ;
         }
      }
      closeExtendedTableCursors2W209( ) ;
   }

   public void deferredUpdate2W209( )
   {
   }

   public void delete2W209( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate2W209( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency2W209( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls2W209( ) ;
         afterConfirm2W209( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete2W209( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T002W39 */
               pr_default.execute(37, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod, Short.valueOf(A1011ConveAdiOpcCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("convenio_adicionalalicuotas");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode209 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel2W209( ) ;
      Gx_mode = sMode209 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls2W209( )
   {
      standaloneModal2W209( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean5[0] = AV36aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1900ConveAdiOpcRelSec, GXv_boolean5) ;
            convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
         }
      }
   }

   public void endLevel2W209( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart2W209( )
   {
      /* Scan By routine */
      /* Using cursor T002W40 */
      pr_default.execute(38, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A996ConveAdicod});
      RcdFound209 = (short)(0) ;
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1011ConveAdiOpcCod = T002W40_A1011ConveAdiOpcCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext2W209( )
   {
      /* Scan next routine */
      pr_default.readNext(38);
      RcdFound209 = (short)(0) ;
      if ( (pr_default.getStatus(38) != 101) )
      {
         RcdFound209 = (short)(1) ;
         A1011ConveAdiOpcCod = T002W40_A1011ConveAdiOpcCod[0] ;
      }
   }

   public void scanEnd2W209( )
   {
      pr_default.close(38);
   }

   public void afterConfirm2W209( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1900ConveAdiOpcRelSec) )
      {
         GXCCtl = "CONVEADIOPCRELSEC_" + sGXsfl_75_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiOpcRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiOpcRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV36aplicadoHay ) && ! (0==A1901ConveAdiRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV30CliCod), "ConveAdiRelSec", 1, "CONVEADIRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert2W209( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate2W209( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete2W209( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete2W209( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate2W209( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes2W209( )
   {
      edtConveAdiOpcCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcCod_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtConveAdiOpcFor_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcFor_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcFor_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtConveAdiOpcDes_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcDes_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcDes_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtConveAdiOpcAli_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcAli_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcAli_Enabled), 5, 0), !bGXsfl_75_Refreshing);
      edtConveAdiOpcRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcRelSec_Enabled), 5, 0), !bGXsfl_75_Refreshing);
   }

   public void send_integrity_lvl_hashes2W209( )
   {
   }

   public void send_integrity_lvl_hashes2W207( )
   {
   }

   public void subsflControlProps_91245( )
   {
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA_"+sGXsfl_91_idx ;
      edtConveAdiSitCanRelSec_Internalname = "CONVEADISITCANRELSEC_"+sGXsfl_91_idx ;
   }

   public void subsflControlProps_fel_91245( )
   {
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA_"+sGXsfl_91_fel_idx ;
      edtConveAdiSitCanRelSec_Internalname = "CONVEADISITCANRELSEC_"+sGXsfl_91_fel_idx ;
   }

   public void addRow2W245( )
   {
      nGXsfl_91_idx = (int)(nGXsfl_91_idx+1) ;
      sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_91245( ) ;
      sendRow2W245( ) ;
   }

   public void sendRow2W245( )
   {
      Gridlevel_cancelaRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_cancela_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_cancela_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_cancela_Class, "") != 0 )
         {
            subGridlevel_cancela_Linesclass = subGridlevel_cancela_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_cancela_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_cancela_Backstyle = (byte)(0) ;
         subGridlevel_cancela_Backcolor = subGridlevel_cancela_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_cancela_Class, "") != 0 )
         {
            subGridlevel_cancela_Linesclass = subGridlevel_cancela_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_cancela_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_cancela_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_cancela_Class, "") != 0 )
         {
            subGridlevel_cancela_Linesclass = subGridlevel_cancela_Class+"Odd" ;
         }
         subGridlevel_cancela_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_cancela_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_cancela_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_91_idx) % (2))) == 0 )
         {
            subGridlevel_cancela_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_cancela_Class, "") != 0 )
            {
               subGridlevel_cancela_Linesclass = subGridlevel_cancela_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_cancela_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_cancela_Class, "") != 0 )
            {
               subGridlevel_cancela_Linesclass = subGridlevel_cancela_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_245_" + sGXsfl_91_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 92,'',false,'" + sGXsfl_91_idx + "',91)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_cancelaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiSitCancela_Internalname,GXutil.rtrim( A1824ConveAdiSitCancela),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiSitCancela_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiSitCancela_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(91),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_245_" + sGXsfl_91_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 93,'',false,'" + sGXsfl_91_idx + "',91)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_cancelaRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiSitCanRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConveAdiSitCanRelSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1898ConveAdiSitCanRelSec), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,93);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiSitCanRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiSitCanRelSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(91),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_cancelaRow);
      send_integrity_lvl_hashes2W245( ) ;
      GXCCtl = "Z1824ConveAdiSitCancela_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1824ConveAdiSitCancela));
      GXCCtl = "Z1898ConveAdiSitCanRelSec_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_245_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_245_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_245_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_245, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV30CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV31CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV32CliConvenio));
      GXCCtl = "vCONVEADICOD_" + sGXsfl_91_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANCELA_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCancela_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANRELSEC_"+sGXsfl_91_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCanRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_cancelaContainer.AddRow(Gridlevel_cancelaRow);
   }

   public void readRow2W245( )
   {
      nGXsfl_91_idx = (int)(nGXsfl_91_idx+1) ;
      sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_91245( ) ;
      edtConveAdiSitCancela_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADISITCANCELA_"+sGXsfl_91_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiSitCanRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADISITCANRELSEC_"+sGXsfl_91_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A1824ConveAdiSitCancela = httpContext.cgiGet( edtConveAdiSitCancela_Internalname) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiSitCanRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiSitCanRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
      {
         GXCCtl = "CONVEADISITCANRELSEC_" + sGXsfl_91_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCanRelSec_Internalname ;
         wbErr = true ;
         A1898ConveAdiSitCanRelSec = 0 ;
      }
      else
      {
         A1898ConveAdiSitCanRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveAdiSitCanRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z1824ConveAdiSitCancela_" + sGXsfl_91_idx ;
      Z1824ConveAdiSitCancela = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1898ConveAdiSitCanRelSec_" + sGXsfl_91_idx ;
      Z1898ConveAdiSitCanRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_245_" + sGXsfl_91_idx ;
      nRcdDeleted_245 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_245_" + sGXsfl_91_idx ;
      nRcdExists_245 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_245_" + sGXsfl_91_idx ;
      nIsMod_245 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_61208( )
   {
      edtConveAdiVig_Internalname = "CONVEADIVIG_"+sGXsfl_61_idx ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE_"+sGXsfl_61_idx ;
      edtConveAdiImpRelSec_Internalname = "CONVEADIIMPRELSEC_"+sGXsfl_61_idx ;
   }

   public void subsflControlProps_fel_61208( )
   {
      edtConveAdiVig_Internalname = "CONVEADIVIG_"+sGXsfl_61_fel_idx ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE_"+sGXsfl_61_fel_idx ;
      edtConveAdiImpRelSec_Internalname = "CONVEADIIMPRELSEC_"+sGXsfl_61_fel_idx ;
   }

   public void addRow2W208( )
   {
      nGXsfl_61_idx = (int)(nGXsfl_61_idx+1) ;
      sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_61208( ) ;
      sendRow2W208( ) ;
   }

   public void sendRow2W208( )
   {
      Gridlevel_importesRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_importes_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_importes_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
         {
            subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_importes_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_importes_Backstyle = (byte)(0) ;
         subGridlevel_importes_Backcolor = subGridlevel_importes_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
         {
            subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_importes_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_importes_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
         {
            subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
         }
         subGridlevel_importes_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_importes_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_importes_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_61_idx) % (2))) == 0 )
         {
            subGridlevel_importes_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_importes_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_importes_Class, "") != 0 )
            {
               subGridlevel_importes_Linesclass = subGridlevel_importes_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_208_" + sGXsfl_61_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 62,'',false,'" + sGXsfl_61_idx + "',61)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel_importesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiVig_Internalname,localUtil.format(A999ConveAdiVig, "99/99/99"),localUtil.format( A999ConveAdiVig, "99/99/99"),TempTags+" onchange=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 8,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,62);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiVig_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiVig_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(8),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(61),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_208_" + sGXsfl_61_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 63,'',false,'" + sGXsfl_61_idx + "',61)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_importesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiImporte_Internalname,GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConveAdiImporte_Enabled!=0) ? localUtil.format( A1000ConveAdiImporte, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1000ConveAdiImporte, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,63);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiImporte_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiImporte_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(61),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_208_" + sGXsfl_61_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 64,'',false,'" + sGXsfl_61_idx + "',61)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_importesRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiImpRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConveAdiImpRelSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1899ConveAdiImpRelSec), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,64);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiImpRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiImpRelSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(61),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_importesRow);
      send_integrity_lvl_hashes2W208( ) ;
      GXCCtl = "Z999ConveAdiVig_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z999ConveAdiVig, 0, "/"));
      GXCCtl = "Z1000ConveAdiImporte_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1000ConveAdiImporte, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1899ConveAdiImpRelSec_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1899ConveAdiImpRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_208_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_208_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_208_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_208, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV30CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV31CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV32CliConvenio));
      GXCCtl = "vCONVEADICOD_" + sGXsfl_61_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIVIG_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiVig_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIIMPORTE_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImporte_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIIMPRELSEC_"+sGXsfl_61_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImpRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_importesContainer.AddRow(Gridlevel_importesRow);
   }

   public void readRow2W208( )
   {
      nGXsfl_61_idx = (int)(nGXsfl_61_idx+1) ;
      sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_61208( ) ;
      edtConveAdiVig_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIVIG_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiImporte_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIIMPORTE_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiImpRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIIMPRELSEC_"+sGXsfl_61_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtConveAdiVig_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "CONVEADIVIG_" + sGXsfl_61_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiVig_Internalname ;
         wbErr = true ;
         A999ConveAdiVig = GXutil.nullDate() ;
      }
      else
      {
         A999ConveAdiVig = localUtil.ctod( httpContext.cgiGet( edtConveAdiVig_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "CONVEADIIMPORTE_" + sGXsfl_61_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiImporte_Internalname ;
         wbErr = true ;
         A1000ConveAdiImporte = DecimalUtil.ZERO ;
      }
      else
      {
         A1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( edtConveAdiImporte_Internalname)) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiImpRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiImpRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
      {
         GXCCtl = "CONVEADIIMPRELSEC_" + sGXsfl_61_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiImpRelSec_Internalname ;
         wbErr = true ;
         A1899ConveAdiImpRelSec = 0 ;
      }
      else
      {
         A1899ConveAdiImpRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveAdiImpRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z999ConveAdiVig_" + sGXsfl_61_idx ;
      Z999ConveAdiVig = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z1000ConveAdiImporte_" + sGXsfl_61_idx ;
      Z1000ConveAdiImporte = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1899ConveAdiImpRelSec_" + sGXsfl_61_idx ;
      Z1899ConveAdiImpRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_208_" + sGXsfl_61_idx ;
      nRcdDeleted_208 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_208_" + sGXsfl_61_idx ;
      nRcdExists_208 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_208_" + sGXsfl_61_idx ;
      nIsMod_208 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_75209( )
   {
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD_"+sGXsfl_75_idx ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR_"+sGXsfl_75_idx ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES_"+sGXsfl_75_idx ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI_"+sGXsfl_75_idx ;
      edtConveAdiOpcRelSec_Internalname = "CONVEADIOPCRELSEC_"+sGXsfl_75_idx ;
   }

   public void subsflControlProps_fel_75209( )
   {
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD_"+sGXsfl_75_fel_idx ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR_"+sGXsfl_75_fel_idx ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES_"+sGXsfl_75_fel_idx ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI_"+sGXsfl_75_fel_idx ;
      edtConveAdiOpcRelSec_Internalname = "CONVEADIOPCRELSEC_"+sGXsfl_75_fel_idx ;
   }

   public void addRow2W209( )
   {
      nGXsfl_75_idx = (int)(nGXsfl_75_idx+1) ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_75209( ) ;
      sendRow2W209( ) ;
   }

   public void sendRow2W209( )
   {
      Gridlevel_alicuotasRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_alicuotas_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_alicuotas_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_alicuotas_Class, "") != 0 )
         {
            subGridlevel_alicuotas_Linesclass = subGridlevel_alicuotas_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_alicuotas_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_alicuotas_Backstyle = (byte)(0) ;
         subGridlevel_alicuotas_Backcolor = subGridlevel_alicuotas_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_alicuotas_Class, "") != 0 )
         {
            subGridlevel_alicuotas_Linesclass = subGridlevel_alicuotas_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_alicuotas_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_alicuotas_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_alicuotas_Class, "") != 0 )
         {
            subGridlevel_alicuotas_Linesclass = subGridlevel_alicuotas_Class+"Odd" ;
         }
         subGridlevel_alicuotas_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_alicuotas_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_alicuotas_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_75_idx) % (2))) == 0 )
         {
            subGridlevel_alicuotas_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_alicuotas_Class, "") != 0 )
            {
               subGridlevel_alicuotas_Linesclass = subGridlevel_alicuotas_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_alicuotas_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_alicuotas_Class, "") != 0 )
            {
               subGridlevel_alicuotas_Linesclass = subGridlevel_alicuotas_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_209_" + sGXsfl_75_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 76,'',false,'" + sGXsfl_75_idx + "',75)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_alicuotasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcCod_Internalname,GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1011ConveAdiOpcCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,76);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiOpcCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_209_" + sGXsfl_75_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 77,'',false,'" + sGXsfl_75_idx + "',75)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_alicuotasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcFor_Internalname,GXutil.rtrim( A1021ConveAdiOpcFor),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiOpcFor_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_209_" + sGXsfl_75_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 78,'',false,'" + sGXsfl_75_idx + "',75)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_alicuotasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcDes_Internalname,A1012ConveAdiOpcDes,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,78);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcDes_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiOpcDes_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_209_" + sGXsfl_75_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 79,'',false,'" + sGXsfl_75_idx + "',75)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_alicuotasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcAli_Internalname,GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConveAdiOpcAli_Enabled!=0) ? localUtil.format( A1013ConveAdiOpcAli, "9.9999") : localUtil.format( A1013ConveAdiOpcAli, "9.9999"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,79);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcAli_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiOpcAli_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_209_" + sGXsfl_75_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 80,'',false,'" + sGXsfl_75_idx + "',75)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_alicuotasRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConveAdiOpcRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtConveAdiOpcRelSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1900ConveAdiOpcRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1900ConveAdiOpcRelSec), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,80);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtConveAdiOpcRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtConveAdiOpcRelSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(75),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_alicuotasRow);
      send_integrity_lvl_hashes2W209( ) ;
      GXCCtl = "Z1011ConveAdiOpcCod_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1011ConveAdiOpcCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1021ConveAdiOpcFor_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z1021ConveAdiOpcFor));
      GXCCtl = "Z1012ConveAdiOpcDes_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z1012ConveAdiOpcDes);
      GXCCtl = "Z1013ConveAdiOpcAli_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1013ConveAdiOpcAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1900ConveAdiOpcRelSec_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_209_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_209_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_209_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_209, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV30CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV31CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV32CliConvenio));
      GXCCtl = "vCONVEADICOD_" + sGXsfl_75_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOPCCOD_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOPCFOR_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcFor_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOPCDES_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcDes_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOPCALI_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcAli_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOPCRELSEC_"+sGXsfl_75_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_alicuotasContainer.AddRow(Gridlevel_alicuotasRow);
   }

   public void readRow2W209( )
   {
      nGXsfl_75_idx = (int)(nGXsfl_75_idx+1) ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_75209( ) ;
      edtConveAdiOpcCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCCOD_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiOpcFor_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCFOR_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiOpcDes_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCDES_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiOpcAli_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCALI_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtConveAdiOpcRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CONVEADIOPCRELSEC_"+sGXsfl_75_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CONVEADIOPCCOD_" + sGXsfl_75_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiOpcCod_Internalname ;
         wbErr = true ;
         A1011ConveAdiOpcCod = (short)(0) ;
      }
      else
      {
         A1011ConveAdiOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      A1021ConveAdiOpcFor = httpContext.cgiGet( edtConveAdiOpcFor_Internalname) ;
      A1012ConveAdiOpcDes = httpContext.cgiGet( edtConveAdiOpcDes_Internalname) ;
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtConveAdiOpcAli_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtConveAdiOpcAli_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
      {
         GXCCtl = "CONVEADIOPCALI_" + sGXsfl_75_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiOpcAli_Internalname ;
         wbErr = true ;
         A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      }
      else
      {
         A1013ConveAdiOpcAli = localUtil.ctond( httpContext.cgiGet( edtConveAdiOpcAli_Internalname)) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
      {
         GXCCtl = "CONVEADIOPCRELSEC_" + sGXsfl_75_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiOpcRelSec_Internalname ;
         wbErr = true ;
         A1900ConveAdiOpcRelSec = 0 ;
      }
      else
      {
         A1900ConveAdiOpcRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtConveAdiOpcRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z1011ConveAdiOpcCod_" + sGXsfl_75_idx ;
      Z1011ConveAdiOpcCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1021ConveAdiOpcFor_" + sGXsfl_75_idx ;
      Z1021ConveAdiOpcFor = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1012ConveAdiOpcDes_" + sGXsfl_75_idx ;
      Z1012ConveAdiOpcDes = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1013ConveAdiOpcAli_" + sGXsfl_75_idx ;
      Z1013ConveAdiOpcAli = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1900ConveAdiOpcRelSec_" + sGXsfl_75_idx ;
      Z1900ConveAdiOpcRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdDeleted_209_" + sGXsfl_75_idx ;
      nRcdDeleted_209 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_209_" + sGXsfl_75_idx ;
      nRcdExists_209 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_209_" + sGXsfl_75_idx ;
      nIsMod_209 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtConveAdiSitCancela_Enabled = edtConveAdiSitCancela_Enabled ;
      defedtConveAdiOpcCod_Enabled = edtConveAdiOpcCod_Enabled ;
      defedtConveAdiVig_Enabled = edtConveAdiVig_Enabled ;
   }

   public void confirmValues2W0( )
   {
      nGXsfl_61_idx = 0 ;
      sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_61208( ) ;
      while ( nGXsfl_61_idx < nRC_GXsfl_61 )
      {
         nGXsfl_61_idx = (int)(nGXsfl_61_idx+1) ;
         sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_61208( ) ;
         httpContext.changePostValue( "Z999ConveAdiVig_"+sGXsfl_61_idx, httpContext.cgiGet( "ZT_"+"Z999ConveAdiVig_"+sGXsfl_61_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z999ConveAdiVig_"+sGXsfl_61_idx) ;
         httpContext.changePostValue( "Z1000ConveAdiImporte_"+sGXsfl_61_idx, httpContext.cgiGet( "ZT_"+"Z1000ConveAdiImporte_"+sGXsfl_61_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1000ConveAdiImporte_"+sGXsfl_61_idx) ;
         httpContext.changePostValue( "Z1899ConveAdiImpRelSec_"+sGXsfl_61_idx, httpContext.cgiGet( "ZT_"+"Z1899ConveAdiImpRelSec_"+sGXsfl_61_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1899ConveAdiImpRelSec_"+sGXsfl_61_idx) ;
      }
      nGXsfl_75_idx = 0 ;
      sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_75209( ) ;
      while ( nGXsfl_75_idx < nRC_GXsfl_75 )
      {
         nGXsfl_75_idx = (int)(nGXsfl_75_idx+1) ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_75209( ) ;
         httpContext.changePostValue( "Z1011ConveAdiOpcCod_"+sGXsfl_75_idx, httpContext.cgiGet( "ZT_"+"Z1011ConveAdiOpcCod_"+sGXsfl_75_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1011ConveAdiOpcCod_"+sGXsfl_75_idx) ;
         httpContext.changePostValue( "Z1021ConveAdiOpcFor_"+sGXsfl_75_idx, httpContext.cgiGet( "ZT_"+"Z1021ConveAdiOpcFor_"+sGXsfl_75_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1021ConveAdiOpcFor_"+sGXsfl_75_idx) ;
         httpContext.changePostValue( "Z1012ConveAdiOpcDes_"+sGXsfl_75_idx, httpContext.cgiGet( "ZT_"+"Z1012ConveAdiOpcDes_"+sGXsfl_75_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1012ConveAdiOpcDes_"+sGXsfl_75_idx) ;
         httpContext.changePostValue( "Z1013ConveAdiOpcAli_"+sGXsfl_75_idx, httpContext.cgiGet( "ZT_"+"Z1013ConveAdiOpcAli_"+sGXsfl_75_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1013ConveAdiOpcAli_"+sGXsfl_75_idx) ;
         httpContext.changePostValue( "Z1900ConveAdiOpcRelSec_"+sGXsfl_75_idx, httpContext.cgiGet( "ZT_"+"Z1900ConveAdiOpcRelSec_"+sGXsfl_75_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1900ConveAdiOpcRelSec_"+sGXsfl_75_idx) ;
      }
      nGXsfl_91_idx = 0 ;
      sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_91245( ) ;
      while ( nGXsfl_91_idx < nRC_GXsfl_91 )
      {
         nGXsfl_91_idx = (int)(nGXsfl_91_idx+1) ;
         sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_91245( ) ;
         httpContext.changePostValue( "Z1824ConveAdiSitCancela_"+sGXsfl_91_idx, httpContext.cgiGet( "ZT_"+"Z1824ConveAdiSitCancela_"+sGXsfl_91_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1824ConveAdiSitCancela_"+sGXsfl_91_idx) ;
         httpContext.changePostValue( "Z1898ConveAdiSitCanRelSec_"+sGXsfl_91_idx, httpContext.cgiGet( "ZT_"+"Z1898ConveAdiSitCanRelSec_"+sGXsfl_91_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1898ConveAdiSitCanRelSec_"+sGXsfl_91_idx) ;
      }
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio_adicional", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV31CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV32CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV9ConveAdicod))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"convenio_adicional");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveAdiRelRef", GXutil.rtrim( localUtil.format( A2046ConveAdiRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio_adicional:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
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
      web.GxWebStd.gx_hidden_field( httpContext, "Z997ConveAdiDescri", Z997ConveAdiDescri);
      web.GxWebStd.gx_hidden_field( httpContext, "Z998ConveAdiAli", GXutil.ltrim( localUtil.ntoc( Z998ConveAdiAli, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1803ConveAdiTipo", GXutil.rtrim( Z1803ConveAdiTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1901ConveAdiRelSec", GXutil.ltrim( localUtil.ntoc( Z1901ConveAdiRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2046ConveAdiRelRef", Z2046ConveAdiRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_91", GXutil.ltrim( localUtil.ntoc( nGXsfl_91_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_61", GXutil.ltrim( localUtil.ntoc( nGXsfl_61_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_75", GXutil.ltrim( localUtil.ntoc( nGXsfl_75_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV16DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCONVEADISITCANCELA_DATA", AV37ConveAdiSitCancela_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCONVEADISITCANCELA_DATA", AV37ConveAdiSitCancela_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV30CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV30CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV31CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV31CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV32CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV32CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVEADICOD", GXutil.rtrim( AV9ConveAdicod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVEADICOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9ConveAdicod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV36aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIRELREF", A2046ConveAdiRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADIOLD", A2047ConveAdiOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV41Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEADISITCANCDES", A1825ConveAdiSitCancDes);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable1_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Enabled", GXutil.booltostr( Dvpanel_unnamedtable1_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Width", GXutil.rtrim( Dvpanel_unnamedtable1_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable1_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable1_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Cls", GXutil.rtrim( Dvpanel_unnamedtable1_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Title", GXutil.rtrim( Dvpanel_unnamedtable1_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable1_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable1_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable1_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE1_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable1_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable2_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Enabled", GXutil.booltostr( Dvpanel_unnamedtable2_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Width", GXutil.rtrim( Dvpanel_unnamedtable2_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable2_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable2_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Cls", GXutil.rtrim( Dvpanel_unnamedtable2_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Title", GXutil.rtrim( Dvpanel_unnamedtable2_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable2_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable2_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable2_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE2_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable2_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Objectcall", GXutil.rtrim( Dvpanel_unnamedtable3_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Enabled", GXutil.booltostr( Dvpanel_unnamedtable3_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Width", GXutil.rtrim( Dvpanel_unnamedtable3_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autowidth", GXutil.booltostr( Dvpanel_unnamedtable3_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoheight", GXutil.booltostr( Dvpanel_unnamedtable3_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Cls", GXutil.rtrim( Dvpanel_unnamedtable3_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Title", GXutil.rtrim( Dvpanel_unnamedtable3_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsible", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Collapsed", GXutil.booltostr( Dvpanel_unnamedtable3_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Showcollapseicon", GXutil.booltostr( Dvpanel_unnamedtable3_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Iconposition", GXutil.rtrim( Dvpanel_unnamedtable3_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_UNNAMEDTABLE3_Autoscroll", GXutil.booltostr( Dvpanel_unnamedtable3_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Objectcall", GXutil.rtrim( Combo_conveadisitcancela_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Cls", GXutil.rtrim( Combo_conveadisitcancela_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Enabled", GXutil.booltostr( Combo_conveadisitcancela_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Titlecontrolidtoreplace", GXutil.rtrim( Combo_conveadisitcancela_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Isgriditem", GXutil.booltostr( Combo_conveadisitcancela_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Hasdescription", GXutil.booltostr( Combo_conveadisitcancela_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Datalistproc", GXutil.rtrim( Combo_conveadisitcancela_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Datalistprocparametersprefix", GXutil.rtrim( Combo_conveadisitcancela_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CONVEADISITCANCELA_Emptyitem", GXutil.booltostr( Combo_conveadisitcancela_Emptyitem));
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
      return formatLink("web.convenio_adicional", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV30CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV31CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV32CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV9ConveAdicod))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","ConveAdicod"})  ;
   }

   public String getPgmname( )
   {
      return "convenio_adicional" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "convenio_adicional", "") ;
   }

   public void initializeNonKey2W207( )
   {
      AV36aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      A997ConveAdiDescri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A997ConveAdiDescri", A997ConveAdiDescri);
      A998ConveAdiAli = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A998ConveAdiAli", GXutil.ltrimstr( A998ConveAdiAli, 6, 4));
      A1019ConveAdiInfo = "" ;
      n1019ConveAdiInfo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1019ConveAdiInfo", A1019ConveAdiInfo);
      n1019ConveAdiInfo = ((GXutil.strcmp("", A1019ConveAdiInfo)==0) ? true : false) ;
      A1901ConveAdiRelSec = 0 ;
      n1901ConveAdiRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1901ConveAdiRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1901ConveAdiRelSec), 6, 0));
      n1901ConveAdiRelSec = ((0==A1901ConveAdiRelSec) ? true : false) ;
      A2046ConveAdiRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2046ConveAdiRelRef", A2046ConveAdiRelRef);
      A2047ConveAdiOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2047ConveAdiOld", A2047ConveAdiOld);
      A1803ConveAdiTipo = "otros" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
      Z997ConveAdiDescri = "" ;
      Z998ConveAdiAli = DecimalUtil.ZERO ;
      Z1803ConveAdiTipo = "" ;
      Z1901ConveAdiRelSec = 0 ;
      Z2046ConveAdiRelRef = "" ;
   }

   public void initAll2W207( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A996ConveAdicod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A996ConveAdicod", A996ConveAdicod);
      initializeNonKey2W207( ) ;
   }

   public void standaloneModalInsert( )
   {
      A1803ConveAdiTipo = i1803ConveAdiTipo ;
      httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
   }

   public void initializeNonKey2W245( )
   {
      A1825ConveAdiSitCancDes = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1825ConveAdiSitCancDes", A1825ConveAdiSitCancDes);
      A1898ConveAdiSitCanRelSec = 0 ;
      Z1898ConveAdiSitCanRelSec = 0 ;
   }

   public void initAll2W245( )
   {
      A1824ConveAdiSitCancela = "" ;
      initializeNonKey2W245( ) ;
   }

   public void standaloneModalInsert2W245( )
   {
   }

   public void initializeNonKey2W208( )
   {
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      A1899ConveAdiImpRelSec = 0 ;
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z1899ConveAdiImpRelSec = 0 ;
   }

   public void initAll2W208( )
   {
      A999ConveAdiVig = GXutil.nullDate() ;
      initializeNonKey2W208( ) ;
   }

   public void standaloneModalInsert2W208( )
   {
   }

   public void initializeNonKey2W209( )
   {
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A1900ConveAdiOpcRelSec = 0 ;
      Z1021ConveAdiOpcFor = "" ;
      Z1012ConveAdiOpcDes = "" ;
      Z1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      Z1900ConveAdiOpcRelSec = 0 ;
   }

   public void initAll2W209( )
   {
      A1011ConveAdiOpcCod = (short)(0) ;
      initializeNonKey2W209( ) ;
   }

   public void standaloneModalInsert2W209( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171333092", true, true);
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
      httpContext.AddJavascriptSource("convenio_adicional.js", "?2025171333092", false, true);
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
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties245( )
   {
      edtConveAdiSitCancela_Enabled = defedtConveAdiSitCancela_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiSitCancela_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiSitCancela_Enabled), 5, 0), !bGXsfl_91_Refreshing);
   }

   public void init_level_properties208( )
   {
      edtConveAdiVig_Enabled = defedtConveAdiVig_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiVig_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiVig_Enabled), 5, 0), !bGXsfl_61_Refreshing);
   }

   public void init_level_properties209( )
   {
      edtConveAdiOpcCod_Enabled = defedtConveAdiOpcCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveAdiOpcCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveAdiOpcCod_Enabled), 5, 0), !bGXsfl_75_Refreshing);
   }

   public void startgridcontrol61( )
   {
      Gridlevel_importesContainer.AddObjectProperty("GridName", "Gridlevel_importes");
      Gridlevel_importesContainer.AddObjectProperty("Header", subGridlevel_importes_Header);
      Gridlevel_importesContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_importesContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_importesContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesColumn.AddObjectProperty("Value", localUtil.format(A999ConveAdiVig, "99/99/99"));
      Gridlevel_importesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiVig_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
      Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1000ConveAdiImporte, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_importesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImporte_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
      Gridlevel_importesColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_importesColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1899ConveAdiImpRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_importesColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiImpRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddColumnProperties(Gridlevel_importesColumn);
      Gridlevel_importesContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_importesContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_importes_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol75( )
   {
      Gridlevel_alicuotasContainer.AddObjectProperty("GridName", "Gridlevel_alicuotas");
      Gridlevel_alicuotasContainer.AddObjectProperty("Header", subGridlevel_alicuotas_Header);
      Gridlevel_alicuotasContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_alicuotasContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_alicuotasContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_alicuotasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_alicuotasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1011ConveAdiOpcCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_alicuotasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddColumnProperties(Gridlevel_alicuotasColumn);
      Gridlevel_alicuotasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_alicuotasColumn.AddObjectProperty("Value", GXutil.rtrim( A1021ConveAdiOpcFor));
      Gridlevel_alicuotasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcFor_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddColumnProperties(Gridlevel_alicuotasColumn);
      Gridlevel_alicuotasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_alicuotasColumn.AddObjectProperty("Value", A1012ConveAdiOpcDes);
      Gridlevel_alicuotasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcDes_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddColumnProperties(Gridlevel_alicuotasColumn);
      Gridlevel_alicuotasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_alicuotasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1013ConveAdiOpcAli, (byte)(6), (byte)(4), ".", "")));
      Gridlevel_alicuotasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcAli_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddColumnProperties(Gridlevel_alicuotasColumn);
      Gridlevel_alicuotasColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_alicuotasColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1900ConveAdiOpcRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_alicuotasColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiOpcRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddColumnProperties(Gridlevel_alicuotasColumn);
      Gridlevel_alicuotasContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_alicuotasContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_alicuotas_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol91( )
   {
      Gridlevel_cancelaContainer.AddObjectProperty("GridName", "Gridlevel_cancela");
      Gridlevel_cancelaContainer.AddObjectProperty("Header", subGridlevel_cancela_Header);
      Gridlevel_cancelaContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_cancelaContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_cancelaContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_cancelaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_cancelaColumn.AddObjectProperty("Value", GXutil.rtrim( A1824ConveAdiSitCancela));
      Gridlevel_cancelaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCancela_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddColumnProperties(Gridlevel_cancelaColumn);
      Gridlevel_cancelaColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_cancelaColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1898ConveAdiSitCanRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel_cancelaColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtConveAdiSitCanRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddColumnProperties(Gridlevel_cancelaColumn);
      Gridlevel_cancelaContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_cancelaContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_cancela_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtConveAdicod_Internalname = "CONVEADICOD" ;
      edtConveAdiDescri_Internalname = "CONVEADIDESCRI" ;
      edtConveAdiAli_Internalname = "CONVEADIALI" ;
      edtConveAdiInfo_Internalname = "CONVEADIINFO" ;
      cmbConveAdiTipo.setInternalname( "CONVEADITIPO" );
      edtConveAdiRelSec_Internalname = "CONVEADIRELSEC" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtConveAdiVig_Internalname = "CONVEADIVIG" ;
      edtConveAdiImporte_Internalname = "CONVEADIIMPORTE" ;
      edtConveAdiImpRelSec_Internalname = "CONVEADIIMPRELSEC" ;
      divTableleaflevel_importes_Internalname = "TABLELEAFLEVEL_IMPORTES" ;
      divUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      Dvpanel_unnamedtable1_Internalname = "DVPANEL_UNNAMEDTABLE1" ;
      edtConveAdiOpcCod_Internalname = "CONVEADIOPCCOD" ;
      edtConveAdiOpcFor_Internalname = "CONVEADIOPCFOR" ;
      edtConveAdiOpcDes_Internalname = "CONVEADIOPCDES" ;
      edtConveAdiOpcAli_Internalname = "CONVEADIOPCALI" ;
      edtConveAdiOpcRelSec_Internalname = "CONVEADIOPCRELSEC" ;
      divTableleaflevel_alicuotas_Internalname = "TABLELEAFLEVEL_ALICUOTAS" ;
      divUnnamedtable2_Internalname = "UNNAMEDTABLE2" ;
      Dvpanel_unnamedtable2_Internalname = "DVPANEL_UNNAMEDTABLE2" ;
      edtConveAdiSitCancela_Internalname = "CONVEADISITCANCELA" ;
      edtConveAdiSitCanRelSec_Internalname = "CONVEADISITCANRELSEC" ;
      divTableleaflevel_cancela_Internalname = "TABLELEAFLEVEL_CANCELA" ;
      divUnnamedtable3_Internalname = "UNNAMEDTABLE3" ;
      Dvpanel_unnamedtable3_Internalname = "DVPANEL_UNNAMEDTABLE3" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_conveadisitcancela_Internalname = "COMBO_CONVEADISITCANCELA" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtCliPaiConve_Internalname = "CLIPAICONVE" ;
      edtCliConvenio_Internalname = "CLICONVENIO" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel_importes_Internalname = "GRIDLEVEL_IMPORTES" ;
      subGridlevel_alicuotas_Internalname = "GRIDLEVEL_ALICUOTAS" ;
      subGridlevel_cancela_Internalname = "GRIDLEVEL_CANCELA" ;
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
      subGridlevel_cancela_Allowcollapsing = (byte)(0) ;
      subGridlevel_cancela_Allowselection = (byte)(0) ;
      subGridlevel_cancela_Header = "" ;
      subGridlevel_alicuotas_Allowcollapsing = (byte)(0) ;
      subGridlevel_alicuotas_Allowselection = (byte)(0) ;
      subGridlevel_alicuotas_Header = "" ;
      subGridlevel_importes_Allowcollapsing = (byte)(0) ;
      subGridlevel_importes_Allowselection = (byte)(0) ;
      subGridlevel_importes_Header = "" ;
      Combo_conveadisitcancela_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "convenio_adicional", "") );
      edtConveAdiOpcRelSec_Jsonclick = "" ;
      edtConveAdiOpcAli_Jsonclick = "" ;
      edtConveAdiOpcDes_Jsonclick = "" ;
      edtConveAdiOpcFor_Jsonclick = "" ;
      edtConveAdiOpcCod_Jsonclick = "" ;
      subGridlevel_alicuotas_Class = "WorkWith" ;
      subGridlevel_alicuotas_Backcolorstyle = (byte)(0) ;
      edtConveAdiImpRelSec_Jsonclick = "" ;
      edtConveAdiImporte_Jsonclick = "" ;
      edtConveAdiVig_Jsonclick = "" ;
      subGridlevel_importes_Class = "WorkWith" ;
      subGridlevel_importes_Backcolorstyle = (byte)(0) ;
      edtConveAdiSitCanRelSec_Jsonclick = "" ;
      edtConveAdiSitCancela_Jsonclick = "" ;
      subGridlevel_cancela_Class = "WorkWith" ;
      subGridlevel_cancela_Backcolorstyle = (byte)(0) ;
      Combo_conveadisitcancela_Titlecontrolidtoreplace = "" ;
      edtCliConvenio_Jsonclick = "" ;
      edtCliConvenio_Enabled = 1 ;
      edtCliConvenio_Visible = 1 ;
      edtCliPaiConve_Jsonclick = "" ;
      edtCliPaiConve_Enabled = 1 ;
      edtCliPaiConve_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      Combo_conveadisitcancela_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_conveadisitcancela_Datalistprocparametersprefix = " \"ComboName\": \"ConveAdiSitCancela\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"ConveAdicod\": \"\"" ;
      Combo_conveadisitcancela_Datalistproc = "convenio_adicionalLoadDVCombo" ;
      Combo_conveadisitcancela_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_conveadisitcancela_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_conveadisitcancela_Cls = "ExtendedCombo" ;
      Combo_conveadisitcancela_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtConveAdiSitCanRelSec_Enabled = 1 ;
      edtConveAdiSitCancela_Enabled = 1 ;
      Dvpanel_unnamedtable3_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Iconposition = "Right" ;
      Dvpanel_unnamedtable3_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Title = httpContext.getMessage( "Estados que lo cancelan", "") ;
      Dvpanel_unnamedtable3_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable3_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable3_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable3_Width = "100%" ;
      edtConveAdiOpcRelSec_Enabled = 1 ;
      edtConveAdiOpcAli_Enabled = 1 ;
      edtConveAdiOpcDes_Enabled = 1 ;
      edtConveAdiOpcFor_Enabled = 1 ;
      edtConveAdiOpcCod_Enabled = 1 ;
      Dvpanel_unnamedtable2_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Iconposition = "Right" ;
      Dvpanel_unnamedtable2_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Title = httpContext.getMessage( "Opciones", "") ;
      Dvpanel_unnamedtable2_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable2_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable2_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable2_Width = "100%" ;
      edtConveAdiImpRelSec_Enabled = 1 ;
      edtConveAdiImporte_Enabled = 1 ;
      edtConveAdiVig_Enabled = 1 ;
      Dvpanel_unnamedtable1_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Iconposition = "Right" ;
      Dvpanel_unnamedtable1_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Title = httpContext.getMessage( "Importes", "") ;
      Dvpanel_unnamedtable1_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_unnamedtable1_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_unnamedtable1_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_unnamedtable1_Width = "100%" ;
      edtConveAdiRelSec_Jsonclick = "" ;
      edtConveAdiRelSec_Enabled = 1 ;
      cmbConveAdiTipo.setJsonclick( "" );
      cmbConveAdiTipo.setEnabled( 1 );
      edtConveAdiInfo_Enabled = 1 ;
      edtConveAdiAli_Jsonclick = "" ;
      edtConveAdiAli_Enabled = 1 ;
      edtConveAdiDescri_Enabled = 1 ;
      edtConveAdicod_Jsonclick = "" ;
      edtConveAdicod_Enabled = 1 ;
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

   public void gx2asaclicod2W207( int AV30CliCod )
   {
      if ( ! (0==AV30CliCod) )
      {
         A3CliCod = AV30CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            convenio_adicional_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
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

   public void xc_15_2W207( String Gx_mode ,
                            int AV30CliCod ,
                            int A1901ConveAdiRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1901ConveAdiRelSec, GXv_boolean5) ;
         AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV36aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_18_2W245( String Gx_mode ,
                            int AV30CliCod ,
                            int A1898ConveAdiSitCanRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV36aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_21_2W208( String Gx_mode ,
                            int AV30CliCod ,
                            int A1899ConveAdiImpRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV36aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_24_2W209( String Gx_mode ,
                            int AV30CliCod ,
                            int A1900ConveAdiOpcRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1900ConveAdiOpcRelSec, GXv_boolean5) ;
         AV36aplicadoHay = GXv_boolean5[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV36aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel_cancela_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_91245( ) ;
      while ( nGXsfl_91_idx <= nRC_GXsfl_91 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2W245( ) ;
         standaloneModal2W245( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2W245( ) ;
         nGXsfl_91_idx = (int)(nGXsfl_91_idx+1) ;
         sGXsfl_91_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_91_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_91245( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_cancelaContainer)) ;
      /* End function gxnrGridlevel_cancela_newrow */
   }

   public void gxnrgridlevel_importes_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_61208( ) ;
      while ( nGXsfl_61_idx <= nRC_GXsfl_61 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2W208( ) ;
         standaloneModal2W208( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2W208( ) ;
         nGXsfl_61_idx = (int)(nGXsfl_61_idx+1) ;
         sGXsfl_61_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_61_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_61208( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_importesContainer)) ;
      /* End function gxnrGridlevel_importes_newrow */
   }

   public void gxnrgridlevel_alicuotas_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_75209( ) ;
      while ( nGXsfl_75_idx <= nRC_GXsfl_75 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal2W209( ) ;
         standaloneModal2W209( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow2W209( ) ;
         nGXsfl_75_idx = (int)(nGXsfl_75_idx+1) ;
         sGXsfl_75_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_75_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_75209( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_alicuotasContainer)) ;
      /* End function gxnrGridlevel_alicuotas_newrow */
   }

   public void init_web_controls( )
   {
      cmbConveAdiTipo.setName( "CONVEADITIPO" );
      cmbConveAdiTipo.setWebtags( "" );
      cmbConveAdiTipo.addItem("titulo", httpContext.getMessage( "Tìtulo", ""), (short)(0));
      cmbConveAdiTipo.addItem("otros", httpContext.getMessage( "Otros", ""), (short)(0));
      if ( cmbConveAdiTipo.getItemCount() > 0 )
      {
         if ( isIns( ) && (GXutil.strcmp("", A1803ConveAdiTipo)==0) )
         {
            A1803ConveAdiTipo = "otros" ;
            httpContext.ajax_rsp_assign_attri("", false, "A1803ConveAdiTipo", A1803ConveAdiTipo);
         }
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

   public void valid_Cliconvenio( )
   {
      /* Using cursor T002W41 */
      pr_default.execute(39, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(39) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(39);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Conveadirelsec( )
   {
      n1901ConveAdiRelSec = false ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1901ConveAdiRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         AV36aplicadoHay = this.AV36aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
   }

   public void valid_Conveadisitcancela( )
   {
      /* Using cursor T002W27 */
      pr_default.execute(25, new Object[] {A1824ConveAdiSitCancela});
      if ( (pr_default.getStatus(25) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Adi No Adicional", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVEADISITCANCELA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveAdiSitCancela_Internalname ;
      }
      A1825ConveAdiSitCancDes = T002W27_A1825ConveAdiSitCancDes[0] ;
      pr_default.close(25);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1825ConveAdiSitCancDes", A1825ConveAdiSitCancDes);
   }

   public void valid_Conveadisitcanrelsec( )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1898ConveAdiSitCanRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         AV36aplicadoHay = this.AV36aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
   }

   public void valid_Conveadiimprelsec( )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1899ConveAdiImpRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         AV36aplicadoHay = this.AV36aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
   }

   public void valid_Conveadiopcrelsec( )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean5[0] = AV36aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV30CliCod, A1900ConveAdiOpcRelSec, GXv_boolean5) ;
         convenio_adicional_impl.this.AV36aplicadoHay = GXv_boolean5[0] ;
         AV36aplicadoHay = this.AV36aplicadoHay ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV36aplicadoHay", AV36aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV32CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV9ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV31CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV32CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV9ConveAdicod',fld:'vCONVEADICOD',pic:'',hsh:true},{av:'A2046ConveAdiRelRef',fld:'CONVEADIRELREF',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e122W2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CONVEADICOD","{handler:'valid_Conveadicod',iparms:[]");
      setEventMetadata("VALID_CONVEADICOD",",oparms:[]}");
      setEventMetadata("VALID_CONVEADITIPO","{handler:'valid_Conveaditipo',iparms:[]");
      setEventMetadata("VALID_CONVEADITIPO",",oparms:[]}");
      setEventMetadata("VALID_CONVEADIRELSEC","{handler:'valid_Conveadirelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1901ConveAdiRelSec',fld:'CONVEADIRELSEC',pic:'ZZZZZ9'},{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]");
      setEventMetadata("VALID_CONVEADIRELSEC",",oparms:[{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[]}");
      setEventMetadata("VALID_CONVEADIVIG","{handler:'valid_Conveadivig',iparms:[]");
      setEventMetadata("VALID_CONVEADIVIG",",oparms:[]}");
      setEventMetadata("VALID_CONVEADIIMPRELSEC","{handler:'valid_Conveadiimprelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1899ConveAdiImpRelSec',fld:'CONVEADIIMPRELSEC',pic:'ZZZZZ9'},{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]");
      setEventMetadata("VALID_CONVEADIIMPRELSEC",",oparms:[{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]}");
      setEventMetadata("VALID_CONVEADIOPCCOD","{handler:'valid_Conveadiopccod',iparms:[]");
      setEventMetadata("VALID_CONVEADIOPCCOD",",oparms:[]}");
      setEventMetadata("VALID_CONVEADIOPCRELSEC","{handler:'valid_Conveadiopcrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1900ConveAdiOpcRelSec',fld:'CONVEADIOPCRELSEC',pic:'ZZZZZ9'},{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]");
      setEventMetadata("VALID_CONVEADIOPCRELSEC",",oparms:[{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]}");
      setEventMetadata("VALID_CONVEADISITCANCELA","{handler:'valid_Conveadisitcancela',iparms:[{av:'A1824ConveAdiSitCancela',fld:'CONVEADISITCANCELA',pic:''},{av:'A1825ConveAdiSitCancDes',fld:'CONVEADISITCANCDES',pic:'@!'}]");
      setEventMetadata("VALID_CONVEADISITCANCELA",",oparms:[{av:'A1825ConveAdiSitCancDes',fld:'CONVEADISITCANCDES',pic:'@!'}]}");
      setEventMetadata("VALID_CONVEADISITCANRELSEC","{handler:'valid_Conveadisitcanrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'AV30CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'A1898ConveAdiSitCanRelSec',fld:'CONVEADISITCANRELSEC',pic:'ZZZZZ9'},{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]");
      setEventMetadata("VALID_CONVEADISITCANRELSEC",",oparms:[{av:'AV36aplicadoHay',fld:'vAPLICADOHAY',pic:''}]}");
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
      pr_default.close(25);
      pr_default.close(39);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV32CliConvenio = "" ;
      wcpOAV9ConveAdicod = "" ;
      Z1565CliConvenio = "" ;
      Z996ConveAdicod = "" ;
      Z997ConveAdiDescri = "" ;
      Z998ConveAdiAli = DecimalUtil.ZERO ;
      Z1803ConveAdiTipo = "" ;
      Z2046ConveAdiRelRef = "" ;
      Z1824ConveAdiSitCancela = "" ;
      Z999ConveAdiVig = GXutil.nullDate() ;
      Z1000ConveAdiImporte = DecimalUtil.ZERO ;
      Z1021ConveAdiOpcFor = "" ;
      Z1012ConveAdiOpcDes = "" ;
      Z1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A1565CliConvenio = "" ;
      A1824ConveAdiSitCancela = "" ;
      AV32CliConvenio = "" ;
      AV9ConveAdicod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1803ConveAdiTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A996ConveAdicod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A997ConveAdiDescri = "" ;
      A998ConveAdiAli = DecimalUtil.ZERO ;
      A1019ConveAdiInfo = "" ;
      ucDvpanel_unnamedtable1 = new com.genexus.webpanels.GXUserControl();
      Gridlevel_importesContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode208 = "" ;
      ucDvpanel_unnamedtable2 = new com.genexus.webpanels.GXUserControl();
      Gridlevel_alicuotasContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode209 = "" ;
      ucDvpanel_unnamedtable3 = new com.genexus.webpanels.GXUserControl();
      Gridlevel_cancelaContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode245 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_conveadisitcancela = new com.genexus.webpanels.GXUserControl();
      AV16DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV37ConveAdiSitCancela_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A2046ConveAdiRelRef = "" ;
      A2047ConveAdiOld = "" ;
      AV41Pgmname = "" ;
      A1825ConveAdiSitCancDes = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_unnamedtable1_Objectcall = "" ;
      Dvpanel_unnamedtable1_Class = "" ;
      Dvpanel_unnamedtable1_Height = "" ;
      Dvpanel_unnamedtable2_Objectcall = "" ;
      Dvpanel_unnamedtable2_Class = "" ;
      Dvpanel_unnamedtable2_Height = "" ;
      Dvpanel_unnamedtable3_Objectcall = "" ;
      Dvpanel_unnamedtable3_Class = "" ;
      Dvpanel_unnamedtable3_Height = "" ;
      Combo_conveadisitcancela_Objectcall = "" ;
      Combo_conveadisitcancela_Class = "" ;
      Combo_conveadisitcancela_Icontype = "" ;
      Combo_conveadisitcancela_Icon = "" ;
      Combo_conveadisitcancela_Tooltip = "" ;
      Combo_conveadisitcancela_Selectedvalue_set = "" ;
      Combo_conveadisitcancela_Selectedvalue_get = "" ;
      Combo_conveadisitcancela_Selectedtext_set = "" ;
      Combo_conveadisitcancela_Selectedtext_get = "" ;
      Combo_conveadisitcancela_Gamoauthtoken = "" ;
      Combo_conveadisitcancela_Ddointernalname = "" ;
      Combo_conveadisitcancela_Titlecontrolalign = "" ;
      Combo_conveadisitcancela_Dropdownoptionstype = "" ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode207 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A1021ConveAdiOpcFor = "" ;
      A1012ConveAdiOpcDes = "" ;
      A1013ConveAdiOpcAli = DecimalUtil.ZERO ;
      A999ConveAdiVig = GXutil.nullDate() ;
      A1000ConveAdiImporte = DecimalUtil.ZERO ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV13TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV14WebSession = httpContext.getWebSession();
      Z1019ConveAdiInfo = "" ;
      Z2047ConveAdiOld = "" ;
      T002W12_A996ConveAdicod = new String[] {""} ;
      T002W12_A997ConveAdiDescri = new String[] {""} ;
      T002W12_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W12_A1019ConveAdiInfo = new String[] {""} ;
      T002W12_n1019ConveAdiInfo = new boolean[] {false} ;
      T002W12_A1803ConveAdiTipo = new String[] {""} ;
      T002W12_A1901ConveAdiRelSec = new int[1] ;
      T002W12_n1901ConveAdiRelSec = new boolean[] {false} ;
      T002W12_A2046ConveAdiRelRef = new String[] {""} ;
      T002W12_A2047ConveAdiOld = new String[] {""} ;
      T002W12_A3CliCod = new int[1] ;
      T002W12_A1564CliPaiConve = new short[1] ;
      T002W12_A1565CliConvenio = new String[] {""} ;
      T002W11_A3CliCod = new int[1] ;
      T002W13_A3CliCod = new int[1] ;
      T002W14_A3CliCod = new int[1] ;
      T002W14_A1564CliPaiConve = new short[1] ;
      T002W14_A1565CliConvenio = new String[] {""} ;
      T002W14_A996ConveAdicod = new String[] {""} ;
      T002W10_A996ConveAdicod = new String[] {""} ;
      T002W10_A997ConveAdiDescri = new String[] {""} ;
      T002W10_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W10_A1019ConveAdiInfo = new String[] {""} ;
      T002W10_n1019ConveAdiInfo = new boolean[] {false} ;
      T002W10_A1803ConveAdiTipo = new String[] {""} ;
      T002W10_A1901ConveAdiRelSec = new int[1] ;
      T002W10_n1901ConveAdiRelSec = new boolean[] {false} ;
      T002W10_A2046ConveAdiRelRef = new String[] {""} ;
      T002W10_A2047ConveAdiOld = new String[] {""} ;
      T002W10_A3CliCod = new int[1] ;
      T002W10_A1564CliPaiConve = new short[1] ;
      T002W10_A1565CliConvenio = new String[] {""} ;
      T002W15_A3CliCod = new int[1] ;
      T002W15_A1564CliPaiConve = new short[1] ;
      T002W15_A1565CliConvenio = new String[] {""} ;
      T002W15_A996ConveAdicod = new String[] {""} ;
      T002W16_A3CliCod = new int[1] ;
      T002W16_A1564CliPaiConve = new short[1] ;
      T002W16_A1565CliConvenio = new String[] {""} ;
      T002W16_A996ConveAdicod = new String[] {""} ;
      T002W9_A996ConveAdicod = new String[] {""} ;
      T002W9_A997ConveAdiDescri = new String[] {""} ;
      T002W9_A998ConveAdiAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W9_A1019ConveAdiInfo = new String[] {""} ;
      T002W9_n1019ConveAdiInfo = new boolean[] {false} ;
      T002W9_A1803ConveAdiTipo = new String[] {""} ;
      T002W9_A1901ConveAdiRelSec = new int[1] ;
      T002W9_n1901ConveAdiRelSec = new boolean[] {false} ;
      T002W9_A2046ConveAdiRelRef = new String[] {""} ;
      T002W9_A2047ConveAdiOld = new String[] {""} ;
      T002W9_A3CliCod = new int[1] ;
      T002W9_A1564CliPaiConve = new short[1] ;
      T002W9_A1565CliConvenio = new String[] {""} ;
      T002W20_A3CliCod = new int[1] ;
      T002W20_A1564CliPaiConve = new short[1] ;
      T002W20_A1565CliConvenio = new String[] {""} ;
      T002W20_A996ConveAdicod = new String[] {""} ;
      Z1825ConveAdiSitCancDes = "" ;
      T002W21_A3CliCod = new int[1] ;
      T002W21_A1565CliConvenio = new String[] {""} ;
      T002W21_A996ConveAdicod = new String[] {""} ;
      T002W21_A1825ConveAdiSitCancDes = new String[] {""} ;
      T002W21_A1898ConveAdiSitCanRelSec = new int[1] ;
      T002W21_A1824ConveAdiSitCancela = new String[] {""} ;
      T002W21_A1564CliPaiConve = new short[1] ;
      T002W8_A1825ConveAdiSitCancDes = new String[] {""} ;
      T002W22_A1825ConveAdiSitCancDes = new String[] {""} ;
      T002W23_A3CliCod = new int[1] ;
      T002W23_A1564CliPaiConve = new short[1] ;
      T002W23_A1565CliConvenio = new String[] {""} ;
      T002W23_A996ConveAdicod = new String[] {""} ;
      T002W23_A1824ConveAdiSitCancela = new String[] {""} ;
      T002W7_A3CliCod = new int[1] ;
      T002W7_A1565CliConvenio = new String[] {""} ;
      T002W7_A996ConveAdicod = new String[] {""} ;
      T002W7_A1898ConveAdiSitCanRelSec = new int[1] ;
      T002W7_A1824ConveAdiSitCancela = new String[] {""} ;
      T002W7_A1564CliPaiConve = new short[1] ;
      T002W6_A3CliCod = new int[1] ;
      T002W6_A1565CliConvenio = new String[] {""} ;
      T002W6_A996ConveAdicod = new String[] {""} ;
      T002W6_A1898ConveAdiSitCanRelSec = new int[1] ;
      T002W6_A1824ConveAdiSitCancela = new String[] {""} ;
      T002W6_A1564CliPaiConve = new short[1] ;
      T002W27_A1825ConveAdiSitCancDes = new String[] {""} ;
      T002W28_A3CliCod = new int[1] ;
      T002W28_A1564CliPaiConve = new short[1] ;
      T002W28_A1565CliConvenio = new String[] {""} ;
      T002W28_A996ConveAdicod = new String[] {""} ;
      T002W28_A1824ConveAdiSitCancela = new String[] {""} ;
      T002W29_A3CliCod = new int[1] ;
      T002W29_A1565CliConvenio = new String[] {""} ;
      T002W29_A996ConveAdicod = new String[] {""} ;
      T002W29_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002W29_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W29_A1899ConveAdiImpRelSec = new int[1] ;
      T002W29_A1564CliPaiConve = new short[1] ;
      T002W30_A3CliCod = new int[1] ;
      T002W30_A1564CliPaiConve = new short[1] ;
      T002W30_A1565CliConvenio = new String[] {""} ;
      T002W30_A996ConveAdicod = new String[] {""} ;
      T002W30_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002W5_A3CliCod = new int[1] ;
      T002W5_A1565CliConvenio = new String[] {""} ;
      T002W5_A996ConveAdicod = new String[] {""} ;
      T002W5_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002W5_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W5_A1899ConveAdiImpRelSec = new int[1] ;
      T002W5_A1564CliPaiConve = new short[1] ;
      T002W4_A3CliCod = new int[1] ;
      T002W4_A1565CliConvenio = new String[] {""} ;
      T002W4_A996ConveAdicod = new String[] {""} ;
      T002W4_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002W4_A1000ConveAdiImporte = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W4_A1899ConveAdiImpRelSec = new int[1] ;
      T002W4_A1564CliPaiConve = new short[1] ;
      T002W34_A3CliCod = new int[1] ;
      T002W34_A1564CliPaiConve = new short[1] ;
      T002W34_A1565CliConvenio = new String[] {""} ;
      T002W34_A996ConveAdicod = new String[] {""} ;
      T002W34_A999ConveAdiVig = new java.util.Date[] {GXutil.nullDate()} ;
      T002W35_A3CliCod = new int[1] ;
      T002W35_A1565CliConvenio = new String[] {""} ;
      T002W35_A996ConveAdicod = new String[] {""} ;
      T002W35_A1011ConveAdiOpcCod = new short[1] ;
      T002W35_A1021ConveAdiOpcFor = new String[] {""} ;
      T002W35_A1012ConveAdiOpcDes = new String[] {""} ;
      T002W35_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W35_A1900ConveAdiOpcRelSec = new int[1] ;
      T002W35_A1564CliPaiConve = new short[1] ;
      T002W36_A3CliCod = new int[1] ;
      T002W36_A1564CliPaiConve = new short[1] ;
      T002W36_A1565CliConvenio = new String[] {""} ;
      T002W36_A996ConveAdicod = new String[] {""} ;
      T002W36_A1011ConveAdiOpcCod = new short[1] ;
      T002W3_A3CliCod = new int[1] ;
      T002W3_A1565CliConvenio = new String[] {""} ;
      T002W3_A996ConveAdicod = new String[] {""} ;
      T002W3_A1011ConveAdiOpcCod = new short[1] ;
      T002W3_A1021ConveAdiOpcFor = new String[] {""} ;
      T002W3_A1012ConveAdiOpcDes = new String[] {""} ;
      T002W3_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W3_A1900ConveAdiOpcRelSec = new int[1] ;
      T002W3_A1564CliPaiConve = new short[1] ;
      T002W2_A3CliCod = new int[1] ;
      T002W2_A1565CliConvenio = new String[] {""} ;
      T002W2_A996ConveAdicod = new String[] {""} ;
      T002W2_A1011ConveAdiOpcCod = new short[1] ;
      T002W2_A1021ConveAdiOpcFor = new String[] {""} ;
      T002W2_A1012ConveAdiOpcDes = new String[] {""} ;
      T002W2_A1013ConveAdiOpcAli = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T002W2_A1900ConveAdiOpcRelSec = new int[1] ;
      T002W2_A1564CliPaiConve = new short[1] ;
      T002W40_A3CliCod = new int[1] ;
      T002W40_A1564CliPaiConve = new short[1] ;
      T002W40_A1565CliConvenio = new String[] {""} ;
      T002W40_A996ConveAdicod = new String[] {""} ;
      T002W40_A1011ConveAdiOpcCod = new short[1] ;
      Gridlevel_cancelaRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_cancela_Linesclass = "" ;
      ROClassString = "" ;
      Gridlevel_importesRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_importes_Linesclass = "" ;
      Gridlevel_alicuotasRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_alicuotas_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      i1803ConveAdiTipo = "" ;
      Gridlevel_importesColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_alicuotasColumn = new com.genexus.webpanels.GXWebColumn();
      Gridlevel_cancelaColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int7 = new int[1] ;
      T002W41_A3CliCod = new int[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio_adicional__default(),
         new Object[] {
             new Object[] {
            T002W2_A3CliCod, T002W2_A1565CliConvenio, T002W2_A996ConveAdicod, T002W2_A1011ConveAdiOpcCod, T002W2_A1021ConveAdiOpcFor, T002W2_A1012ConveAdiOpcDes, T002W2_A1013ConveAdiOpcAli, T002W2_A1900ConveAdiOpcRelSec, T002W2_A1564CliPaiConve
            }
            , new Object[] {
            T002W3_A3CliCod, T002W3_A1565CliConvenio, T002W3_A996ConveAdicod, T002W3_A1011ConveAdiOpcCod, T002W3_A1021ConveAdiOpcFor, T002W3_A1012ConveAdiOpcDes, T002W3_A1013ConveAdiOpcAli, T002W3_A1900ConveAdiOpcRelSec, T002W3_A1564CliPaiConve
            }
            , new Object[] {
            T002W4_A3CliCod, T002W4_A1565CliConvenio, T002W4_A996ConveAdicod, T002W4_A999ConveAdiVig, T002W4_A1000ConveAdiImporte, T002W4_A1899ConveAdiImpRelSec, T002W4_A1564CliPaiConve
            }
            , new Object[] {
            T002W5_A3CliCod, T002W5_A1565CliConvenio, T002W5_A996ConveAdicod, T002W5_A999ConveAdiVig, T002W5_A1000ConveAdiImporte, T002W5_A1899ConveAdiImpRelSec, T002W5_A1564CliPaiConve
            }
            , new Object[] {
            T002W6_A3CliCod, T002W6_A1565CliConvenio, T002W6_A996ConveAdicod, T002W6_A1898ConveAdiSitCanRelSec, T002W6_A1824ConveAdiSitCancela, T002W6_A1564CliPaiConve
            }
            , new Object[] {
            T002W7_A3CliCod, T002W7_A1565CliConvenio, T002W7_A996ConveAdicod, T002W7_A1898ConveAdiSitCanRelSec, T002W7_A1824ConveAdiSitCancela, T002W7_A1564CliPaiConve
            }
            , new Object[] {
            T002W8_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T002W9_A996ConveAdicod, T002W9_A997ConveAdiDescri, T002W9_A998ConveAdiAli, T002W9_A1019ConveAdiInfo, T002W9_n1019ConveAdiInfo, T002W9_A1803ConveAdiTipo, T002W9_A1901ConveAdiRelSec, T002W9_n1901ConveAdiRelSec, T002W9_A2046ConveAdiRelRef, T002W9_A2047ConveAdiOld,
            T002W9_A3CliCod, T002W9_A1564CliPaiConve, T002W9_A1565CliConvenio
            }
            , new Object[] {
            T002W10_A996ConveAdicod, T002W10_A997ConveAdiDescri, T002W10_A998ConveAdiAli, T002W10_A1019ConveAdiInfo, T002W10_n1019ConveAdiInfo, T002W10_A1803ConveAdiTipo, T002W10_A1901ConveAdiRelSec, T002W10_n1901ConveAdiRelSec, T002W10_A2046ConveAdiRelRef, T002W10_A2047ConveAdiOld,
            T002W10_A3CliCod, T002W10_A1564CliPaiConve, T002W10_A1565CliConvenio
            }
            , new Object[] {
            T002W11_A3CliCod
            }
            , new Object[] {
            T002W12_A996ConveAdicod, T002W12_A997ConveAdiDescri, T002W12_A998ConveAdiAli, T002W12_A1019ConveAdiInfo, T002W12_n1019ConveAdiInfo, T002W12_A1803ConveAdiTipo, T002W12_A1901ConveAdiRelSec, T002W12_n1901ConveAdiRelSec, T002W12_A2046ConveAdiRelRef, T002W12_A2047ConveAdiOld,
            T002W12_A3CliCod, T002W12_A1564CliPaiConve, T002W12_A1565CliConvenio
            }
            , new Object[] {
            T002W13_A3CliCod
            }
            , new Object[] {
            T002W14_A3CliCod, T002W14_A1564CliPaiConve, T002W14_A1565CliConvenio, T002W14_A996ConveAdicod
            }
            , new Object[] {
            T002W15_A3CliCod, T002W15_A1564CliPaiConve, T002W15_A1565CliConvenio, T002W15_A996ConveAdicod
            }
            , new Object[] {
            T002W16_A3CliCod, T002W16_A1564CliPaiConve, T002W16_A1565CliConvenio, T002W16_A996ConveAdicod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002W20_A3CliCod, T002W20_A1564CliPaiConve, T002W20_A1565CliConvenio, T002W20_A996ConveAdicod
            }
            , new Object[] {
            T002W21_A3CliCod, T002W21_A1565CliConvenio, T002W21_A996ConveAdicod, T002W21_A1825ConveAdiSitCancDes, T002W21_A1898ConveAdiSitCanRelSec, T002W21_A1824ConveAdiSitCancela, T002W21_A1564CliPaiConve
            }
            , new Object[] {
            T002W22_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T002W23_A3CliCod, T002W23_A1564CliPaiConve, T002W23_A1565CliConvenio, T002W23_A996ConveAdicod, T002W23_A1824ConveAdiSitCancela
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002W27_A1825ConveAdiSitCancDes
            }
            , new Object[] {
            T002W28_A3CliCod, T002W28_A1564CliPaiConve, T002W28_A1565CliConvenio, T002W28_A996ConveAdicod, T002W28_A1824ConveAdiSitCancela
            }
            , new Object[] {
            T002W29_A3CliCod, T002W29_A1565CliConvenio, T002W29_A996ConveAdicod, T002W29_A999ConveAdiVig, T002W29_A1000ConveAdiImporte, T002W29_A1899ConveAdiImpRelSec, T002W29_A1564CliPaiConve
            }
            , new Object[] {
            T002W30_A3CliCod, T002W30_A1564CliPaiConve, T002W30_A1565CliConvenio, T002W30_A996ConveAdicod, T002W30_A999ConveAdiVig
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002W34_A3CliCod, T002W34_A1564CliPaiConve, T002W34_A1565CliConvenio, T002W34_A996ConveAdicod, T002W34_A999ConveAdiVig
            }
            , new Object[] {
            T002W35_A3CliCod, T002W35_A1565CliConvenio, T002W35_A996ConveAdicod, T002W35_A1011ConveAdiOpcCod, T002W35_A1021ConveAdiOpcFor, T002W35_A1012ConveAdiOpcDes, T002W35_A1013ConveAdiOpcAli, T002W35_A1900ConveAdiOpcRelSec, T002W35_A1564CliPaiConve
            }
            , new Object[] {
            T002W36_A3CliCod, T002W36_A1564CliPaiConve, T002W36_A1565CliConvenio, T002W36_A996ConveAdicod, T002W36_A1011ConveAdiOpcCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T002W40_A3CliCod, T002W40_A1564CliPaiConve, T002W40_A1565CliConvenio, T002W40_A996ConveAdicod, T002W40_A1011ConveAdiOpcCod
            }
            , new Object[] {
            T002W41_A3CliCod
            }
         }
      );
      AV41Pgmname = "convenio_adicional" ;
      Z1803ConveAdiTipo = "otros" ;
      A1803ConveAdiTipo = "otros" ;
      i1803ConveAdiTipo = "otros" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel_cancela_Backcolorstyle ;
   private byte subGridlevel_cancela_Backstyle ;
   private byte subGridlevel_importes_Backcolorstyle ;
   private byte subGridlevel_importes_Backstyle ;
   private byte subGridlevel_alicuotas_Backcolorstyle ;
   private byte subGridlevel_alicuotas_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_importes_Allowselection ;
   private byte subGridlevel_importes_Allowhovering ;
   private byte subGridlevel_importes_Allowcollapsing ;
   private byte subGridlevel_importes_Collapsed ;
   private byte subGridlevel_alicuotas_Allowselection ;
   private byte subGridlevel_alicuotas_Allowhovering ;
   private byte subGridlevel_alicuotas_Allowcollapsing ;
   private byte subGridlevel_alicuotas_Collapsed ;
   private byte subGridlevel_cancela_Allowselection ;
   private byte subGridlevel_cancela_Allowhovering ;
   private byte subGridlevel_cancela_Allowcollapsing ;
   private byte subGridlevel_cancela_Collapsed ;
   private short wcpOAV31CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short nRcdDeleted_245 ;
   private short nRcdExists_245 ;
   private short nIsMod_245 ;
   private short nRcdDeleted_208 ;
   private short nRcdExists_208 ;
   private short nIsMod_208 ;
   private short Z1011ConveAdiOpcCod ;
   private short nRcdDeleted_209 ;
   private short nRcdExists_209 ;
   private short nIsMod_209 ;
   private short A1564CliPaiConve ;
   private short AV31CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount208 ;
   private short RcdFound208 ;
   private short nBlankRcdUsr208 ;
   private short nBlankRcdCount209 ;
   private short RcdFound209 ;
   private short nBlankRcdUsr209 ;
   private short nBlankRcdCount245 ;
   private short RcdFound245 ;
   private short nBlankRcdUsr245 ;
   private short RcdFound207 ;
   private short A1011ConveAdiOpcCod ;
   private short nIsDirty_207 ;
   private short nIsDirty_245 ;
   private short nIsDirty_208 ;
   private short nIsDirty_209 ;
   private int wcpOAV30CliCod ;
   private int Z3CliCod ;
   private int Z1901ConveAdiRelSec ;
   private int nRC_GXsfl_91 ;
   private int nGXsfl_91_idx=1 ;
   private int nRC_GXsfl_61 ;
   private int nGXsfl_61_idx=1 ;
   private int nRC_GXsfl_75 ;
   private int nGXsfl_75_idx=1 ;
   private int Z1898ConveAdiSitCanRelSec ;
   private int Z1899ConveAdiImpRelSec ;
   private int Z1900ConveAdiOpcRelSec ;
   private int AV30CliCod ;
   private int A1901ConveAdiRelSec ;
   private int A1898ConveAdiSitCanRelSec ;
   private int A1899ConveAdiImpRelSec ;
   private int A1900ConveAdiOpcRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtConveAdicod_Enabled ;
   private int edtConveAdiDescri_Enabled ;
   private int edtConveAdiAli_Enabled ;
   private int edtConveAdiInfo_Enabled ;
   private int edtConveAdiRelSec_Enabled ;
   private int edtConveAdiVig_Enabled ;
   private int edtConveAdiImporte_Enabled ;
   private int edtConveAdiImpRelSec_Enabled ;
   private int fRowAdded ;
   private int edtConveAdiOpcCod_Enabled ;
   private int edtConveAdiOpcFor_Enabled ;
   private int edtConveAdiOpcDes_Enabled ;
   private int edtConveAdiOpcAli_Enabled ;
   private int edtConveAdiOpcRelSec_Enabled ;
   private int edtConveAdiSitCancela_Enabled ;
   private int edtConveAdiSitCanRelSec_Enabled ;
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
   private int Dvpanel_unnamedtable1_Gxcontroltype ;
   private int Dvpanel_unnamedtable2_Gxcontroltype ;
   private int Dvpanel_unnamedtable3_Gxcontroltype ;
   private int Combo_conveadisitcancela_Datalistupdateminimumcharacters ;
   private int Combo_conveadisitcancela_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel_cancela_Backcolor ;
   private int subGridlevel_cancela_Allbackcolor ;
   private int subGridlevel_importes_Backcolor ;
   private int subGridlevel_importes_Allbackcolor ;
   private int subGridlevel_alicuotas_Backcolor ;
   private int subGridlevel_alicuotas_Allbackcolor ;
   private int defedtConveAdiSitCancela_Enabled ;
   private int defedtConveAdiOpcCod_Enabled ;
   private int defedtConveAdiVig_Enabled ;
   private int idxLst ;
   private int subGridlevel_importes_Selectedindex ;
   private int subGridlevel_importes_Selectioncolor ;
   private int subGridlevel_importes_Hoveringcolor ;
   private int subGridlevel_alicuotas_Selectedindex ;
   private int subGridlevel_alicuotas_Selectioncolor ;
   private int subGridlevel_alicuotas_Hoveringcolor ;
   private int subGridlevel_cancela_Selectedindex ;
   private int subGridlevel_cancela_Selectioncolor ;
   private int subGridlevel_cancela_Hoveringcolor ;
   private int GXt_int6 ;
   private int GXv_int7[] ;
   private long GRIDLEVEL_CANCELA_nFirstRecordOnPage ;
   private long GRIDLEVEL_IMPORTES_nFirstRecordOnPage ;
   private long GRIDLEVEL_ALICUOTAS_nFirstRecordOnPage ;
   private java.math.BigDecimal Z998ConveAdiAli ;
   private java.math.BigDecimal Z1000ConveAdiImporte ;
   private java.math.BigDecimal Z1013ConveAdiOpcAli ;
   private java.math.BigDecimal A998ConveAdiAli ;
   private java.math.BigDecimal A1013ConveAdiOpcAli ;
   private java.math.BigDecimal A1000ConveAdiImporte ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV32CliConvenio ;
   private String wcpOAV9ConveAdicod ;
   private String Z1565CliConvenio ;
   private String Z996ConveAdicod ;
   private String Z1803ConveAdiTipo ;
   private String Z1824ConveAdiSitCancela ;
   private String Z1021ConveAdiOpcFor ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String A1565CliConvenio ;
   private String A1824ConveAdiSitCancela ;
   private String AV32CliConvenio ;
   private String AV9ConveAdicod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtConveAdicod_Internalname ;
   private String sGXsfl_61_idx="0001" ;
   private String sGXsfl_75_idx="0001" ;
   private String sGXsfl_91_idx="0001" ;
   private String A1803ConveAdiTipo ;
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
   private String A996ConveAdicod ;
   private String edtConveAdicod_Jsonclick ;
   private String edtConveAdiDescri_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtConveAdiAli_Internalname ;
   private String edtConveAdiAli_Jsonclick ;
   private String edtConveAdiInfo_Internalname ;
   private String edtConveAdiRelSec_Internalname ;
   private String edtConveAdiRelSec_Jsonclick ;
   private String Dvpanel_unnamedtable1_Width ;
   private String Dvpanel_unnamedtable1_Cls ;
   private String Dvpanel_unnamedtable1_Title ;
   private String Dvpanel_unnamedtable1_Iconposition ;
   private String Dvpanel_unnamedtable1_Internalname ;
   private String divUnnamedtable1_Internalname ;
   private String divTableleaflevel_importes_Internalname ;
   private String sMode208 ;
   private String edtConveAdiVig_Internalname ;
   private String edtConveAdiImporte_Internalname ;
   private String edtConveAdiImpRelSec_Internalname ;
   private String subGridlevel_importes_Internalname ;
   private String Dvpanel_unnamedtable2_Width ;
   private String Dvpanel_unnamedtable2_Cls ;
   private String Dvpanel_unnamedtable2_Title ;
   private String Dvpanel_unnamedtable2_Iconposition ;
   private String Dvpanel_unnamedtable2_Internalname ;
   private String divUnnamedtable2_Internalname ;
   private String divTableleaflevel_alicuotas_Internalname ;
   private String sMode209 ;
   private String edtConveAdiOpcCod_Internalname ;
   private String edtConveAdiOpcFor_Internalname ;
   private String edtConveAdiOpcDes_Internalname ;
   private String edtConveAdiOpcAli_Internalname ;
   private String edtConveAdiOpcRelSec_Internalname ;
   private String subGridlevel_alicuotas_Internalname ;
   private String Dvpanel_unnamedtable3_Width ;
   private String Dvpanel_unnamedtable3_Cls ;
   private String Dvpanel_unnamedtable3_Title ;
   private String Dvpanel_unnamedtable3_Iconposition ;
   private String Dvpanel_unnamedtable3_Internalname ;
   private String divUnnamedtable3_Internalname ;
   private String divTableleaflevel_cancela_Internalname ;
   private String sMode245 ;
   private String edtConveAdiSitCancela_Internalname ;
   private String edtConveAdiSitCanRelSec_Internalname ;
   private String subGridlevel_cancela_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_conveadisitcancela_Caption ;
   private String Combo_conveadisitcancela_Cls ;
   private String Combo_conveadisitcancela_Datalistproc ;
   private String Combo_conveadisitcancela_Datalistprocparametersprefix ;
   private String Combo_conveadisitcancela_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtCliPaiConve_Internalname ;
   private String edtCliPaiConve_Jsonclick ;
   private String edtCliConvenio_Internalname ;
   private String edtCliConvenio_Jsonclick ;
   private String AV41Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_unnamedtable1_Objectcall ;
   private String Dvpanel_unnamedtable1_Class ;
   private String Dvpanel_unnamedtable1_Height ;
   private String Dvpanel_unnamedtable2_Objectcall ;
   private String Dvpanel_unnamedtable2_Class ;
   private String Dvpanel_unnamedtable2_Height ;
   private String Dvpanel_unnamedtable3_Objectcall ;
   private String Dvpanel_unnamedtable3_Class ;
   private String Dvpanel_unnamedtable3_Height ;
   private String Combo_conveadisitcancela_Objectcall ;
   private String Combo_conveadisitcancela_Class ;
   private String Combo_conveadisitcancela_Icontype ;
   private String Combo_conveadisitcancela_Icon ;
   private String Combo_conveadisitcancela_Tooltip ;
   private String Combo_conveadisitcancela_Selectedvalue_set ;
   private String Combo_conveadisitcancela_Selectedvalue_get ;
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
   private String hsh ;
   private String sMode207 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A1021ConveAdiOpcFor ;
   private String sGXsfl_91_fel_idx="0001" ;
   private String subGridlevel_cancela_Class ;
   private String subGridlevel_cancela_Linesclass ;
   private String ROClassString ;
   private String edtConveAdiSitCancela_Jsonclick ;
   private String edtConveAdiSitCanRelSec_Jsonclick ;
   private String sGXsfl_61_fel_idx="0001" ;
   private String subGridlevel_importes_Class ;
   private String subGridlevel_importes_Linesclass ;
   private String edtConveAdiVig_Jsonclick ;
   private String edtConveAdiImporte_Jsonclick ;
   private String edtConveAdiImpRelSec_Jsonclick ;
   private String sGXsfl_75_fel_idx="0001" ;
   private String subGridlevel_alicuotas_Class ;
   private String subGridlevel_alicuotas_Linesclass ;
   private String edtConveAdiOpcCod_Jsonclick ;
   private String edtConveAdiOpcFor_Jsonclick ;
   private String edtConveAdiOpcDes_Jsonclick ;
   private String edtConveAdiOpcAli_Jsonclick ;
   private String edtConveAdiOpcRelSec_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String i1803ConveAdiTipo ;
   private String subGridlevel_importes_Header ;
   private String subGridlevel_alicuotas_Header ;
   private String subGridlevel_cancela_Header ;
   private java.util.Date Z999ConveAdiVig ;
   private java.util.Date A999ConveAdiVig ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n1901ConveAdiRelSec ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_unnamedtable1_Autowidth ;
   private boolean Dvpanel_unnamedtable1_Autoheight ;
   private boolean Dvpanel_unnamedtable1_Collapsible ;
   private boolean Dvpanel_unnamedtable1_Collapsed ;
   private boolean Dvpanel_unnamedtable1_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable1_Autoscroll ;
   private boolean bGXsfl_61_Refreshing=false ;
   private boolean Dvpanel_unnamedtable2_Autowidth ;
   private boolean Dvpanel_unnamedtable2_Autoheight ;
   private boolean Dvpanel_unnamedtable2_Collapsible ;
   private boolean Dvpanel_unnamedtable2_Collapsed ;
   private boolean Dvpanel_unnamedtable2_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable2_Autoscroll ;
   private boolean bGXsfl_75_Refreshing=false ;
   private boolean Dvpanel_unnamedtable3_Autowidth ;
   private boolean Dvpanel_unnamedtable3_Autoheight ;
   private boolean Dvpanel_unnamedtable3_Collapsible ;
   private boolean Dvpanel_unnamedtable3_Collapsed ;
   private boolean Dvpanel_unnamedtable3_Showcollapseicon ;
   private boolean Dvpanel_unnamedtable3_Autoscroll ;
   private boolean bGXsfl_91_Refreshing=false ;
   private boolean Combo_conveadisitcancela_Isgriditem ;
   private boolean Combo_conveadisitcancela_Hasdescription ;
   private boolean Combo_conveadisitcancela_Emptyitem ;
   private boolean AV36aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_unnamedtable1_Enabled ;
   private boolean Dvpanel_unnamedtable1_Showheader ;
   private boolean Dvpanel_unnamedtable1_Visible ;
   private boolean Dvpanel_unnamedtable2_Enabled ;
   private boolean Dvpanel_unnamedtable2_Showheader ;
   private boolean Dvpanel_unnamedtable2_Visible ;
   private boolean Dvpanel_unnamedtable3_Enabled ;
   private boolean Dvpanel_unnamedtable3_Showheader ;
   private boolean Dvpanel_unnamedtable3_Visible ;
   private boolean Combo_conveadisitcancela_Enabled ;
   private boolean Combo_conveadisitcancela_Visible ;
   private boolean Combo_conveadisitcancela_Allowmultipleselection ;
   private boolean Combo_conveadisitcancela_Includeonlyselectedoption ;
   private boolean Combo_conveadisitcancela_Includeselectalloption ;
   private boolean Combo_conveadisitcancela_Includeaddnewoption ;
   private boolean n1019ConveAdiInfo ;
   private boolean returnInSub ;
   private boolean AV11IsAuthorized ;
   private boolean AV42Essistemaconceptosdefault ;
   private boolean GXt_boolean4 ;
   private boolean AV35ClienteConveniador ;
   private boolean ZV36aplicadoHay ;
   private boolean GXv_boolean5[] ;
   private String A1019ConveAdiInfo ;
   private String A2047ConveAdiOld ;
   private String Z1019ConveAdiInfo ;
   private String Z2047ConveAdiOld ;
   private String Z997ConveAdiDescri ;
   private String Z2046ConveAdiRelRef ;
   private String Z1012ConveAdiOpcDes ;
   private String A997ConveAdiDescri ;
   private String A2046ConveAdiRelRef ;
   private String A1825ConveAdiSitCancDes ;
   private String A1012ConveAdiOpcDes ;
   private String Z1825ConveAdiSitCancDes ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_importesContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_alicuotasContainer ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_cancelaContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_cancelaRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_importesRow ;
   private com.genexus.webpanels.GXWebRow Gridlevel_alicuotasRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_importesColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_alicuotasColumn ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_cancelaColumn ;
   private com.genexus.webpanels.WebSession AV14WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable1 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable2 ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_unnamedtable3 ;
   private com.genexus.webpanels.GXUserControl ucCombo_conveadisitcancela ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbConveAdiTipo ;
   private IDataStoreProvider pr_default ;
   private String[] T002W12_A996ConveAdicod ;
   private String[] T002W12_A997ConveAdiDescri ;
   private java.math.BigDecimal[] T002W12_A998ConveAdiAli ;
   private String[] T002W12_A1019ConveAdiInfo ;
   private boolean[] T002W12_n1019ConveAdiInfo ;
   private String[] T002W12_A1803ConveAdiTipo ;
   private int[] T002W12_A1901ConveAdiRelSec ;
   private boolean[] T002W12_n1901ConveAdiRelSec ;
   private String[] T002W12_A2046ConveAdiRelRef ;
   private String[] T002W12_A2047ConveAdiOld ;
   private int[] T002W12_A3CliCod ;
   private short[] T002W12_A1564CliPaiConve ;
   private String[] T002W12_A1565CliConvenio ;
   private int[] T002W11_A3CliCod ;
   private int[] T002W13_A3CliCod ;
   private int[] T002W14_A3CliCod ;
   private short[] T002W14_A1564CliPaiConve ;
   private String[] T002W14_A1565CliConvenio ;
   private String[] T002W14_A996ConveAdicod ;
   private String[] T002W10_A996ConveAdicod ;
   private String[] T002W10_A997ConveAdiDescri ;
   private java.math.BigDecimal[] T002W10_A998ConveAdiAli ;
   private String[] T002W10_A1019ConveAdiInfo ;
   private boolean[] T002W10_n1019ConveAdiInfo ;
   private String[] T002W10_A1803ConveAdiTipo ;
   private int[] T002W10_A1901ConveAdiRelSec ;
   private boolean[] T002W10_n1901ConveAdiRelSec ;
   private String[] T002W10_A2046ConveAdiRelRef ;
   private String[] T002W10_A2047ConveAdiOld ;
   private int[] T002W10_A3CliCod ;
   private short[] T002W10_A1564CliPaiConve ;
   private String[] T002W10_A1565CliConvenio ;
   private int[] T002W15_A3CliCod ;
   private short[] T002W15_A1564CliPaiConve ;
   private String[] T002W15_A1565CliConvenio ;
   private String[] T002W15_A996ConveAdicod ;
   private int[] T002W16_A3CliCod ;
   private short[] T002W16_A1564CliPaiConve ;
   private String[] T002W16_A1565CliConvenio ;
   private String[] T002W16_A996ConveAdicod ;
   private String[] T002W9_A996ConveAdicod ;
   private String[] T002W9_A997ConveAdiDescri ;
   private java.math.BigDecimal[] T002W9_A998ConveAdiAli ;
   private String[] T002W9_A1019ConveAdiInfo ;
   private boolean[] T002W9_n1019ConveAdiInfo ;
   private String[] T002W9_A1803ConveAdiTipo ;
   private int[] T002W9_A1901ConveAdiRelSec ;
   private boolean[] T002W9_n1901ConveAdiRelSec ;
   private String[] T002W9_A2046ConveAdiRelRef ;
   private String[] T002W9_A2047ConveAdiOld ;
   private int[] T002W9_A3CliCod ;
   private short[] T002W9_A1564CliPaiConve ;
   private String[] T002W9_A1565CliConvenio ;
   private int[] T002W20_A3CliCod ;
   private short[] T002W20_A1564CliPaiConve ;
   private String[] T002W20_A1565CliConvenio ;
   private String[] T002W20_A996ConveAdicod ;
   private int[] T002W21_A3CliCod ;
   private String[] T002W21_A1565CliConvenio ;
   private String[] T002W21_A996ConveAdicod ;
   private String[] T002W21_A1825ConveAdiSitCancDes ;
   private int[] T002W21_A1898ConveAdiSitCanRelSec ;
   private String[] T002W21_A1824ConveAdiSitCancela ;
   private short[] T002W21_A1564CliPaiConve ;
   private String[] T002W8_A1825ConveAdiSitCancDes ;
   private String[] T002W22_A1825ConveAdiSitCancDes ;
   private int[] T002W23_A3CliCod ;
   private short[] T002W23_A1564CliPaiConve ;
   private String[] T002W23_A1565CliConvenio ;
   private String[] T002W23_A996ConveAdicod ;
   private String[] T002W23_A1824ConveAdiSitCancela ;
   private int[] T002W7_A3CliCod ;
   private String[] T002W7_A1565CliConvenio ;
   private String[] T002W7_A996ConveAdicod ;
   private int[] T002W7_A1898ConveAdiSitCanRelSec ;
   private String[] T002W7_A1824ConveAdiSitCancela ;
   private short[] T002W7_A1564CliPaiConve ;
   private int[] T002W6_A3CliCod ;
   private String[] T002W6_A1565CliConvenio ;
   private String[] T002W6_A996ConveAdicod ;
   private int[] T002W6_A1898ConveAdiSitCanRelSec ;
   private String[] T002W6_A1824ConveAdiSitCancela ;
   private short[] T002W6_A1564CliPaiConve ;
   private String[] T002W27_A1825ConveAdiSitCancDes ;
   private int[] T002W28_A3CliCod ;
   private short[] T002W28_A1564CliPaiConve ;
   private String[] T002W28_A1565CliConvenio ;
   private String[] T002W28_A996ConveAdicod ;
   private String[] T002W28_A1824ConveAdiSitCancela ;
   private int[] T002W29_A3CliCod ;
   private String[] T002W29_A1565CliConvenio ;
   private String[] T002W29_A996ConveAdicod ;
   private java.util.Date[] T002W29_A999ConveAdiVig ;
   private java.math.BigDecimal[] T002W29_A1000ConveAdiImporte ;
   private int[] T002W29_A1899ConveAdiImpRelSec ;
   private short[] T002W29_A1564CliPaiConve ;
   private int[] T002W30_A3CliCod ;
   private short[] T002W30_A1564CliPaiConve ;
   private String[] T002W30_A1565CliConvenio ;
   private String[] T002W30_A996ConveAdicod ;
   private java.util.Date[] T002W30_A999ConveAdiVig ;
   private int[] T002W5_A3CliCod ;
   private String[] T002W5_A1565CliConvenio ;
   private String[] T002W5_A996ConveAdicod ;
   private java.util.Date[] T002W5_A999ConveAdiVig ;
   private java.math.BigDecimal[] T002W5_A1000ConveAdiImporte ;
   private int[] T002W5_A1899ConveAdiImpRelSec ;
   private short[] T002W5_A1564CliPaiConve ;
   private int[] T002W4_A3CliCod ;
   private String[] T002W4_A1565CliConvenio ;
   private String[] T002W4_A996ConveAdicod ;
   private java.util.Date[] T002W4_A999ConveAdiVig ;
   private java.math.BigDecimal[] T002W4_A1000ConveAdiImporte ;
   private int[] T002W4_A1899ConveAdiImpRelSec ;
   private short[] T002W4_A1564CliPaiConve ;
   private int[] T002W34_A3CliCod ;
   private short[] T002W34_A1564CliPaiConve ;
   private String[] T002W34_A1565CliConvenio ;
   private String[] T002W34_A996ConveAdicod ;
   private java.util.Date[] T002W34_A999ConveAdiVig ;
   private int[] T002W35_A3CliCod ;
   private String[] T002W35_A1565CliConvenio ;
   private String[] T002W35_A996ConveAdicod ;
   private short[] T002W35_A1011ConveAdiOpcCod ;
   private String[] T002W35_A1021ConveAdiOpcFor ;
   private String[] T002W35_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] T002W35_A1013ConveAdiOpcAli ;
   private int[] T002W35_A1900ConveAdiOpcRelSec ;
   private short[] T002W35_A1564CliPaiConve ;
   private int[] T002W36_A3CliCod ;
   private short[] T002W36_A1564CliPaiConve ;
   private String[] T002W36_A1565CliConvenio ;
   private String[] T002W36_A996ConveAdicod ;
   private short[] T002W36_A1011ConveAdiOpcCod ;
   private int[] T002W3_A3CliCod ;
   private String[] T002W3_A1565CliConvenio ;
   private String[] T002W3_A996ConveAdicod ;
   private short[] T002W3_A1011ConveAdiOpcCod ;
   private String[] T002W3_A1021ConveAdiOpcFor ;
   private String[] T002W3_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] T002W3_A1013ConveAdiOpcAli ;
   private int[] T002W3_A1900ConveAdiOpcRelSec ;
   private short[] T002W3_A1564CliPaiConve ;
   private int[] T002W2_A3CliCod ;
   private String[] T002W2_A1565CliConvenio ;
   private String[] T002W2_A996ConveAdicod ;
   private short[] T002W2_A1011ConveAdiOpcCod ;
   private String[] T002W2_A1021ConveAdiOpcFor ;
   private String[] T002W2_A1012ConveAdiOpcDes ;
   private java.math.BigDecimal[] T002W2_A1013ConveAdiOpcAli ;
   private int[] T002W2_A1900ConveAdiOpcRelSec ;
   private short[] T002W2_A1564CliPaiConve ;
   private int[] T002W40_A3CliCod ;
   private short[] T002W40_A1564CliPaiConve ;
   private String[] T002W40_A1565CliConvenio ;
   private String[] T002W40_A996ConveAdicod ;
   private short[] T002W40_A1011ConveAdiOpcCod ;
   private int[] T002W41_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV37ConveAdiSitCancela_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV13TrnContext ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV16DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class convenio_adicional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T002W2", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?  FOR UPDATE OF convenio_adicionalalicuotas NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W3", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W4", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?  FOR UPDATE OF convenio_adicionalimportes NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W5", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W6", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?  FOR UPDATE OF convenio_adicionalCancela NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W7", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W8", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W9", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?  FOR UPDATE OF convenio_adicional NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W10", "SELECT ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W11", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W12", "SELECT TM1.ConveAdicod, TM1.ConveAdiDescri, TM1.ConveAdiAli, TM1.ConveAdiInfo, TM1.ConveAdiTipo, TM1.ConveAdiRelSec, TM1.ConveAdiRelRef, TM1.ConveAdiOld, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM convenio_adicional TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.ConveAdicod = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.ConveAdicod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W13", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W14", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W15", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T002W16", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and ConveAdicod < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, ConveAdicod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T002W17", "SAVEPOINT gxupdate;INSERT INTO convenio_adicional(ConveAdicod, ConveAdiDescri, ConveAdiAli, ConveAdiInfo, ConveAdiTipo, ConveAdiRelSec, ConveAdiRelRef, ConveAdiOld, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W18", "SAVEPOINT gxupdate;UPDATE convenio_adicional SET ConveAdiDescri=?, ConveAdiAli=?, ConveAdiInfo=?, ConveAdiTipo=?, ConveAdiRelSec=?, ConveAdiRelRef=?, ConveAdiOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W19", "SAVEPOINT gxupdate;DELETE FROM convenio_adicional  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002W20", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod FROM convenio_adicional ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W21", "SELECT T1.CliCod, T1.CliConvenio, T1.ConveAdicod, T2.SitDescrip AS ConveAdiSitCancDes, T1.ConveAdiSitCanRelSec, T1.ConveAdiSitCancela AS ConveAdiSitCancela, T1.CliPaiConve FROM (convenio_adicionalCancela T1 INNER JOIN Estado T2 ON T2.SitCodigo = T1.ConveAdiSitCancela) WHERE T1.CliCod = ? and T1.CliPaiConve = ? and T1.CliConvenio = ( ?) and T1.ConveAdicod = ( ?) and T1.ConveAdiSitCancela = ( ?) ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio, T1.ConveAdicod, T1.ConveAdiSitCancela ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W22", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W23", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002W24", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalCancela(CliCod, CliConvenio, ConveAdicod, ConveAdiSitCanRelSec, ConveAdiSitCancela, CliPaiConve, ConveAdiSitCanRelRef, ConveAdiSitCanOld) VALUES(?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W25", "SAVEPOINT gxupdate;UPDATE convenio_adicionalCancela SET ConveAdiSitCanRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W26", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalCancela  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiSitCancela = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002W27", "SELECT SitDescrip AS ConveAdiSitCancDes FROM Estado WHERE SitCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W28", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela FROM convenio_adicionalCancela WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiSitCancela ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W29", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiVig = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W30", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002W31", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalimportes(CliCod, CliConvenio, ConveAdicod, ConveAdiVig, ConveAdiImporte, ConveAdiImpRelSec, CliPaiConve, ConveAdiImpRelRef, ConveAdiImpOld) VALUES(?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W32", "SAVEPOINT gxupdate;UPDATE convenio_adicionalimportes SET ConveAdiImporte=?, ConveAdiImpRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W33", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalimportes  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiVig = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002W34", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig FROM convenio_adicionalimportes WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiVig ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W35", "SELECT CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) and ConveAdiOpcCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W36", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T002W37", "SAVEPOINT gxupdate;INSERT INTO convenio_adicionalalicuotas(CliCod, CliConvenio, ConveAdicod, ConveAdiOpcCod, ConveAdiOpcFor, ConveAdiOpcDes, ConveAdiOpcAli, ConveAdiOpcRelSec, CliPaiConve, ConveAdiOpcRelRef, ConveAdiOpcOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W38", "SAVEPOINT gxupdate;UPDATE convenio_adicionalalicuotas SET ConveAdiOpcFor=?, ConveAdiOpcDes=?, ConveAdiOpcAli=?, ConveAdiOpcRelSec=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T002W39", "SAVEPOINT gxupdate;DELETE FROM convenio_adicionalalicuotas  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND ConveAdicod = ? AND ConveAdiOpcCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T002W40", "SELECT CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod FROM convenio_adicionalalicuotas WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and ConveAdicod = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, ConveAdicod, ConveAdiOpcCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T002W41", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 10 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,4);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(8);
               ((int[]) buf[10])[0] = rslt.getInt(9);
               ((short[]) buf[11])[0] = rslt.getShort(10);
               ((String[]) buf[12])[0] = rslt.getString(11, 20);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 4);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 4);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 28 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 32 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 33 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,4);
               ((int[]) buf[7])[0] = rslt.getInt(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 34 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 38 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               return;
            case 39 :
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
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
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
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 6 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 13 :
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
               return;
            case 14 :
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
               return;
            case 15 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(4, (String)parms[4]);
               }
               stmt.setString(5, (String)parms[5], 20);
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(6, ((Number) parms[7]).intValue());
               }
               stmt.setVarchar(7, (String)parms[8], 40, false);
               stmt.setNLongVarchar(8, (String)parms[9], false);
               stmt.setInt(9, ((Number) parms[10]).intValue());
               stmt.setShort(10, ((Number) parms[11]).shortValue());
               stmt.setString(11, (String)parms[12], 20);
               return;
            case 16 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[1], 4);
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[3]);
               }
               stmt.setString(4, (String)parms[4], 20);
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(5, ((Number) parms[6]).intValue());
               }
               stmt.setVarchar(6, (String)parms[7], 40, false);
               stmt.setNLongVarchar(7, (String)parms[8], false);
               stmt.setInt(8, ((Number) parms[9]).intValue());
               stmt.setShort(9, ((Number) parms[10]).shortValue());
               stmt.setString(10, (String)parms[11], 20);
               stmt.setString(11, (String)parms[12], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 20 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 4);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 4);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 4);
               return;
            case 25 :
               stmt.setString(1, (String)parms[0], 4);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setString(6, (String)parms[5], 20);
               stmt.setDate(7, (java.util.Date)parms[6]);
               return;
            case 31 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 32 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 33 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 34 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 35 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setBigDecimal(7, (java.math.BigDecimal)parms[6], 4);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 36 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 37 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 38 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 39 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

