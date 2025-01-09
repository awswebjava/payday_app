package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class motivoegreso_impl extends GXDataArea
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
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1990MegRelSec = (int)(GXutil.lval( httpContext.GetPar( "MegRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_15_1336( Gx_mode, AV7CliCod, A1990MegRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action20") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1993MegSitRelSec = (int)(GXutil.lval( httpContext.GetPar( "MegSitRelSec"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_20_13220( Gx_mode, AV7CliCod, A1993MegSitRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MEGRELSEC") == 0 )
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
         gxdlamegrelsec1336( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"MEGSITREVISTA") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlamegsitrevista13220( ) ;
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
         gx1asaclicod1336( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel5"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"") == 0 )
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
         gxasa19901336( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel7"+"_"+"") == 0 )
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
         gxasa19931336( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_23") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_23( A3CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_25") == 0 )
      {
         A1601MegSitRevista = (short)(GXutil.lval( httpContext.GetPar( "MegSitRevista"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_25( A1601MegSitRevista) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
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
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV8MegCodigo = httpContext.GetPar( "MegCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8MegCodigo", AV8MegCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MegCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Motivo Egreso", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_40 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_40"))) ;
      nGXsfl_40_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_40_idx"))) ;
      sGXsfl_40_idx = httpContext.GetPar( "sGXsfl_40_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public motivoegreso_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public motivoegreso_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegreso_impl.class ));
   }

   public motivoegreso_impl( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynMegRelSec = new HTMLChoice();
      dynMegSitRevista = new HTMLChoice();
      chkMegSitRevDef = UIFactory.getCheckbox(this);
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
      if ( dynMegRelSec.getItemCount() > 0 )
      {
         A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValidValue(GXutil.trim( GXutil.str( A1990MegRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMegRelSec.setValue( GXutil.trim( GXutil.str( A1990MegRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynMegRelSec.getInternalname(), "Values", dynMegRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMegCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMegCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMegCodigo_Internalname, GXutil.rtrim( A11MegCodigo), GXutil.rtrim( localUtil.format( A11MegCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMegCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMegCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CodigoCaracter", "left", true, "", "HLP_MotivoEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMegDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMegDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMegDescrip_Internalname, A300MegDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtMegDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_MotivoEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divMegrelsec_cell_Internalname, 1, 0, "px", 0, "px", divMegrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynMegRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynMegRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynMegRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynMegRelSec, dynMegRelSec.getInternalname(), GXutil.trim( GXutil.str( A1990MegRelSec, 6, 0)), 1, dynMegRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynMegRelSec.getVisible(), dynMegRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_MotivoEgreso.htm");
      dynMegRelSec.setValue( GXutil.trim( GXutil.str( A1990MegRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynMegRelSec.getInternalname(), "Values", dynMegRelSec.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_sitrev.setProperty("Width", Dvpanel_sitrev_Width);
      ucDvpanel_sitrev.setProperty("AutoWidth", Dvpanel_sitrev_Autowidth);
      ucDvpanel_sitrev.setProperty("AutoHeight", Dvpanel_sitrev_Autoheight);
      ucDvpanel_sitrev.setProperty("Cls", Dvpanel_sitrev_Cls);
      ucDvpanel_sitrev.setProperty("Title", Dvpanel_sitrev_Title);
      ucDvpanel_sitrev.setProperty("Collapsible", Dvpanel_sitrev_Collapsible);
      ucDvpanel_sitrev.setProperty("Collapsed", Dvpanel_sitrev_Collapsed);
      ucDvpanel_sitrev.setProperty("ShowCollapseIcon", Dvpanel_sitrev_Showcollapseicon);
      ucDvpanel_sitrev.setProperty("IconPosition", Dvpanel_sitrev_Iconposition);
      ucDvpanel_sitrev.setProperty("AutoScroll", Dvpanel_sitrev_Autoscroll);
      ucDvpanel_sitrev.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_sitrev_Internalname, "DVPANEL_SITREVContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_SITREVContainer"+"SitRev"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divSitrev_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol40( ) ;
      nGXsfl_40_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount220 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_220 = (short)(1) ;
            scanStart13220( ) ;
            while ( RcdFound220 != 0 )
            {
               init_level_properties220( ) ;
               getByPrimaryKey13220( ) ;
               addRow13220( ) ;
               scanNext13220( ) ;
            }
            scanEnd13220( ) ;
            nBlankRcdCount220 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B300MegDescrip = A300MegDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         B11MegCodigo = A11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         standaloneNotModal13220( ) ;
         standaloneModal13220( ) ;
         sMode220 = Gx_mode ;
         while ( nGXsfl_40_idx < nRC_GXsfl_40 )
         {
            bGXsfl_40_Refreshing = true ;
            readRow13220( ) ;
            dynMegSitRevista.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITREVISTA_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegSitRevista.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
            chkMegSitRevDef.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITREVDEF_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "Enabled", GXutil.ltrimstr( chkMegSitRevDef.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
            edtMegSitRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITRELSEC_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMegSitRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRelSec_Enabled), 5, 0), !bGXsfl_40_Refreshing);
            edtMegSitRelSec_Visible = (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITRELSEC_"+sGXsfl_40_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMegSitRelSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRelSec_Visible), 5, 0), !bGXsfl_40_Refreshing);
            if ( ( nRcdExists_220 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal13220( ) ;
            }
            sendRow13220( ) ;
            bGXsfl_40_Refreshing = false ;
         }
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A300MegDescrip = B300MegDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         A11MegCodigo = B11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount220 = (short)(5) ;
         nRcdExists_220 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart13220( ) ;
            while ( RcdFound220 != 0 )
            {
               sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_40220( ) ;
               init_level_properties220( ) ;
               standaloneNotModal13220( ) ;
               getByPrimaryKey13220( ) ;
               standaloneModal13220( ) ;
               addRow13220( ) ;
               scanNext13220( ) ;
            }
            scanEnd13220( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode220 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_40220( ) ;
         initAll13220( ) ;
         init_level_properties220( ) ;
         B300MegDescrip = A300MegDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         B11MegCodigo = A11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         nRcdExists_220 = (short)(0) ;
         nIsMod_220 = (short)(0) ;
         nRcdDeleted_220 = (short)(0) ;
         nBlankRcdCount220 = (short)(nBlankRcdUsr220+nBlankRcdCount220) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount220 > 0 )
         {
            standaloneNotModal13220( ) ;
            standaloneModal13220( ) ;
            addRow13220( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = dynMegSitRevista.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount220 = (short)(nBlankRcdCount220-1) ;
         }
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A300MegDescrip = B300MegDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         A11MegCodigo = B11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
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
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgreso.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 55,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_MotivoEgreso.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_MotivoEgreso.htm");
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
      e11132 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z11MegCodigo = httpContext.cgiGet( "Z11MegCodigo") ;
            Z300MegDescrip = httpContext.cgiGet( "Z300MegDescrip") ;
            Z301MegHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z301MegHabilitado")) ;
            Z302MegRes551 = httpContext.cgiGet( "Z302MegRes551") ;
            n302MegRes551 = ((GXutil.strcmp("", A302MegRes551)==0) ? true : false) ;
            Z1990MegRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1990MegRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1991MegRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1991MegRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1992MegPadre = httpContext.cgiGet( "Z1992MegPadre") ;
            Z2017MegRelRef = httpContext.cgiGet( "Z2017MegRelRef") ;
            A301MegHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z301MegHabilitado")) ;
            A302MegRes551 = httpContext.cgiGet( "Z302MegRes551") ;
            n302MegRes551 = false ;
            n302MegRes551 = ((GXutil.strcmp("", A302MegRes551)==0) ? true : false) ;
            A1991MegRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1991MegRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1992MegPadre = httpContext.cgiGet( "Z1992MegPadre") ;
            A2017MegRelRef = httpContext.cgiGet( "Z2017MegRelRef") ;
            O300MegDescrip = httpContext.cgiGet( "O300MegDescrip") ;
            O11MegCodigo = httpContext.cgiGet( "O11MegCodigo") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_40 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_40"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8MegCodigo = httpContext.cgiGet( "vMEGCODIGO") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A301MegHabilitado = GXutil.strtobool( httpContext.cgiGet( "MEGHABILITADO")) ;
            AV14aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A302MegRes551 = httpContext.cgiGet( "MEGRES551") ;
            n302MegRes551 = ((GXutil.strcmp("", A302MegRes551)==0) ? true : false) ;
            A1991MegRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "MEGRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1992MegPadre = httpContext.cgiGet( "MEGPADRE") ;
            A2017MegRelRef = httpContext.cgiGet( "MEGRELREF") ;
            A2029MegOld = httpContext.cgiGet( "MEGOLD") ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A1994MegSitRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1995MegSitPadre = (short)(localUtil.ctol( httpContext.cgiGet( "MEGSITPADRE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2018MegSitRelRef = httpContext.cgiGet( "MEGSITRELREF") ;
            A2030MegSitOld = httpContext.cgiGet( "MEGSITOLD") ;
            A1604MegSitRevDescrip = httpContext.cgiGet( "MEGSITREVDESCRIP") ;
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
            Dvpanel_sitrev_Objectcall = httpContext.cgiGet( "DVPANEL_SITREV_Objectcall") ;
            Dvpanel_sitrev_Class = httpContext.cgiGet( "DVPANEL_SITREV_Class") ;
            Dvpanel_sitrev_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Enabled")) ;
            Dvpanel_sitrev_Width = httpContext.cgiGet( "DVPANEL_SITREV_Width") ;
            Dvpanel_sitrev_Height = httpContext.cgiGet( "DVPANEL_SITREV_Height") ;
            Dvpanel_sitrev_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Autowidth")) ;
            Dvpanel_sitrev_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Autoheight")) ;
            Dvpanel_sitrev_Cls = httpContext.cgiGet( "DVPANEL_SITREV_Cls") ;
            Dvpanel_sitrev_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Showheader")) ;
            Dvpanel_sitrev_Title = httpContext.cgiGet( "DVPANEL_SITREV_Title") ;
            Dvpanel_sitrev_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Collapsible")) ;
            Dvpanel_sitrev_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Collapsed")) ;
            Dvpanel_sitrev_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Showcollapseicon")) ;
            Dvpanel_sitrev_Iconposition = httpContext.cgiGet( "DVPANEL_SITREV_Iconposition") ;
            Dvpanel_sitrev_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Autoscroll")) ;
            Dvpanel_sitrev_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_SITREV_Visible")) ;
            Dvpanel_sitrev_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_SITREV_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A11MegCodigo = httpContext.cgiGet( edtMegCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            A300MegDescrip = httpContext.cgiGet( edtMegDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
            dynMegRelSec.setName( dynMegRelSec.getInternalname() );
            dynMegRelSec.setValue( httpContext.cgiGet( dynMegRelSec.getInternalname()) );
            A1990MegRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynMegRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
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
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"MotivoEgreso");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MegHabilitado", GXutil.booltostr( A301MegHabilitado));
            forbiddenHiddens.add("MegRes551", GXutil.rtrim( localUtil.format( A302MegRes551, "")));
            forbiddenHiddens.add("MegRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1991MegRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("MegPadre", GXutil.rtrim( localUtil.format( A1992MegPadre, "")));
            forbiddenHiddens.add("MegRelRef", GXutil.rtrim( localUtil.format( A2017MegRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("motivoegreso:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
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
               A11MegCodigo = httpContext.GetPar( "MegCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
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
                  sMode36 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode36 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound36 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_130( ) ;
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
                        e11132 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12132 ();
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
         e12132 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1336( ) ;
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
         disableAttributes1336( ) ;
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

   public void confirm_130( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1336( ) ;
         }
         else
         {
            checkExtendedTable1336( ) ;
            closeExtendedTableCursors1336( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode36 = Gx_mode ;
         confirm_13220( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode36 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode36 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_13220( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         readRow13220( ) ;
         if ( ( nRcdExists_220 != 0 ) || ( nIsMod_220 != 0 ) )
         {
            getKey13220( ) ;
            if ( ( nRcdExists_220 == 0 ) && ( nRcdDeleted_220 == 0 ) )
            {
               if ( RcdFound220 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate13220( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable13220( ) ;
                     closeExtendedTableCursors13220( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = dynMegSitRevista.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound220 != 0 )
               {
                  if ( nRcdDeleted_220 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey13220( ) ;
                     load13220( ) ;
                     beforeValidate13220( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls13220( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_220 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate13220( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable13220( ) ;
                           closeExtendedTableCursors13220( ) ;
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
                  if ( nRcdDeleted_220 == 0 )
                  {
                     GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = dynMegSitRevista.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( dynMegSitRevista.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( chkMegSitRevDef.getInternalname(), GXutil.booltostr( A1606MegSitRevDef)) ;
         httpContext.changePostValue( edtMegSitRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1601MegSitRevista_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1606MegSitRevDef_"+sGXsfl_40_idx, GXutil.booltostr( Z1606MegSitRevDef)) ;
         httpContext.changePostValue( "ZT_"+"Z1993MegSitRelSec_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1994MegSitRelSecCli_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1994MegSitRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1995MegSitPadre_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1995MegSitPadre, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2018MegSitRelRef_"+sGXsfl_40_idx, Z2018MegSitRelRef) ;
         httpContext.changePostValue( "T1601MegSitRevista_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( O1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1606MegSitRevDef_"+sGXsfl_40_idx, GXutil.booltostr( O1606MegSitRevDef)) ;
         httpContext.changePostValue( "nRcdDeleted_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_220 != 0 )
         {
            httpContext.changePostValue( "MEGSITREVISTA_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMegSitRevista.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITREVDEF_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMegSitRevDef.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITRELSEC_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITRELSEC_"+sGXsfl_40_idx+"Visible", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Visible, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption130( )
   {
   }

   public void e11132( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Insert", GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Update", GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso_Delete", GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      /* Execute user subroutine: 'ATTRIBUTESSECURITYCODE' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(5);
         pr_default.close(4);
         pr_default.close(2);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
   }

   public void e12132( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.motivoegresograbarrelref(remoteHandle, context).execute( A3CliCod) ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'ATTRIBUTESSECURITYCODE' Routine */
      returnInSub = false ;
      divMegrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
   }

   public void zm1336( int GX_JID )
   {
      if ( ( GX_JID == 22 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z300MegDescrip = T00136_A300MegDescrip[0] ;
            Z301MegHabilitado = T00136_A301MegHabilitado[0] ;
            Z302MegRes551 = T00136_A302MegRes551[0] ;
            Z1990MegRelSec = T00136_A1990MegRelSec[0] ;
            Z1991MegRelSecCli = T00136_A1991MegRelSecCli[0] ;
            Z1992MegPadre = T00136_A1992MegPadre[0] ;
            Z2017MegRelRef = T00136_A2017MegRelRef[0] ;
         }
         else
         {
            Z300MegDescrip = A300MegDescrip ;
            Z301MegHabilitado = A301MegHabilitado ;
            Z302MegRes551 = A302MegRes551 ;
            Z1990MegRelSec = A1990MegRelSec ;
            Z1991MegRelSecCli = A1991MegRelSecCli ;
            Z1992MegPadre = A1992MegPadre ;
            Z2017MegRelRef = A2017MegRelRef ;
         }
      }
      if ( GX_JID == -22 )
      {
         Z11MegCodigo = A11MegCodigo ;
         Z300MegDescrip = A300MegDescrip ;
         Z301MegHabilitado = A301MegHabilitado ;
         Z302MegRes551 = A302MegRes551 ;
         Z1990MegRelSec = A1990MegRelSec ;
         Z1991MegRelSecCli = A1991MegRelSecCli ;
         Z1992MegPadre = A1992MegPadre ;
         Z2017MegRelRef = A2017MegRelRef ;
         Z2029MegOld = A2029MegOld ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxamegrelsec_html1336( AV7CliCod) ;
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
            motivoegreso_impl.this.GXt_int4 = GXv_int5[0] ;
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
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynMegRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynMegRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynMegRelSec.getVisible(), 5, 0), true);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      edtMegSitRelSec_Visible = (!GXt_boolean2 ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegSitRelSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRelSec_Visible), 5, 0), !bGXsfl_40_Refreshing);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         A11MegCodigo = AV8MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtMegCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8MegCodigo)==0) )
      {
         edtMegCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
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
      if ( isIns( )  && (false==A301MegHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A301MegHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A301MegHabilitado", A301MegHabilitado);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV16Pgmname = "MotivoEgreso" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
   }

   public void load1336( )
   {
      /* Using cursor T00138 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A300MegDescrip = T00138_A300MegDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         A301MegHabilitado = T00138_A301MegHabilitado[0] ;
         A302MegRes551 = T00138_A302MegRes551[0] ;
         n302MegRes551 = T00138_n302MegRes551[0] ;
         A1990MegRelSec = T00138_A1990MegRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
         A1991MegRelSecCli = T00138_A1991MegRelSecCli[0] ;
         A1992MegPadre = T00138_A1992MegPadre[0] ;
         A2017MegRelRef = T00138_A2017MegRelRef[0] ;
         A2029MegOld = T00138_A2029MegOld[0] ;
         zm1336( -22) ;
      }
      pr_default.close(6);
      onLoadActions1336( ) ;
   }

   public void onLoadActions1336( )
   {
      AV16Pgmname = "MotivoEgreso" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) )
      {
         divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) )
         {
            divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
         }
      }
   }

   public void checkExtendedTable1336( )
   {
      nIsDirty_36 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV16Pgmname = "MotivoEgreso" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1990MegRelSec, GXv_boolean3) ;
         motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
      }
      /* Using cursor T00137 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(5);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) )
      {
         divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) )
         {
            divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A11MegCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Motivo", ""), "", "", "", "", "", "", "", ""), 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) && (0==A1990MegRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "MEGCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A300MegDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "MEGDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors1336( )
   {
      pr_default.close(5);
   }

   public void enableDisable( )
   {
   }

   public void gxload_23( int A3CliCod )
   {
      /* Using cursor T00139 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void getKey1336( )
   {
      /* Using cursor T001310 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound36 = (short)(1) ;
      }
      else
      {
         RcdFound36 = (short)(0) ;
      }
      pr_default.close(8);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00136 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm1336( 22) ;
         RcdFound36 = (short)(1) ;
         A11MegCodigo = T00136_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         A300MegDescrip = T00136_A300MegDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         A301MegHabilitado = T00136_A301MegHabilitado[0] ;
         A302MegRes551 = T00136_A302MegRes551[0] ;
         n302MegRes551 = T00136_n302MegRes551[0] ;
         A1990MegRelSec = T00136_A1990MegRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
         A1991MegRelSecCli = T00136_A1991MegRelSecCli[0] ;
         A1992MegPadre = T00136_A1992MegPadre[0] ;
         A2017MegRelRef = T00136_A2017MegRelRef[0] ;
         A2029MegOld = T00136_A2029MegOld[0] ;
         A3CliCod = T00136_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O300MegDescrip = A300MegDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
         O11MegCodigo = A11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1336( ) ;
         if ( AnyError == 1 )
         {
            RcdFound36 = (short)(0) ;
            initializeNonKey1336( ) ;
         }
         Gx_mode = sMode36 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound36 = (short)(0) ;
         initializeNonKey1336( ) ;
         sMode36 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode36 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey1336( ) ;
      if ( RcdFound36 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound36 = (short)(0) ;
      /* Using cursor T001311 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T001311_A3CliCod[0] < A3CliCod ) || ( T001311_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001311_A11MegCodigo[0], A11MegCodigo) < 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T001311_A3CliCod[0] > A3CliCod ) || ( T001311_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001311_A11MegCodigo[0], A11MegCodigo) > 0 ) ) )
         {
            A3CliCod = T001311_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T001311_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            RcdFound36 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void move_previous( )
   {
      RcdFound36 = (short)(0) ;
      /* Using cursor T001312 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A11MegCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T001312_A3CliCod[0] > A3CliCod ) || ( T001312_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001312_A11MegCodigo[0], A11MegCodigo) > 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T001312_A3CliCod[0] < A3CliCod ) || ( T001312_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T001312_A11MegCodigo[0], A11MegCodigo) < 0 ) ) )
         {
            A3CliCod = T001312_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A11MegCodigo = T001312_A11MegCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
            RcdFound36 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1336( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1336( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound36 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A11MegCodigo = Z11MegCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMegCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1336( ) ;
               GX_FocusControl = edtMegCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtMegCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1336( ) ;
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
                  GX_FocusControl = edtMegCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1336( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A11MegCodigo, Z11MegCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = Z11MegCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMegCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1336( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00135 */
         pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgreso"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( GXutil.strcmp(Z300MegDescrip, T00135_A300MegDescrip[0]) != 0 ) || ( Z301MegHabilitado != T00135_A301MegHabilitado[0] ) || ( GXutil.strcmp(Z302MegRes551, T00135_A302MegRes551[0]) != 0 ) || ( Z1990MegRelSec != T00135_A1990MegRelSec[0] ) || ( Z1991MegRelSecCli != T00135_A1991MegRelSecCli[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1992MegPadre, T00135_A1992MegPadre[0]) != 0 ) || ( GXutil.strcmp(Z2017MegRelRef, T00135_A2017MegRelRef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z300MegDescrip, T00135_A300MegDescrip[0]) != 0 )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegDescrip");
               GXutil.writeLogRaw("Old: ",Z300MegDescrip);
               GXutil.writeLogRaw("Current: ",T00135_A300MegDescrip[0]);
            }
            if ( Z301MegHabilitado != T00135_A301MegHabilitado[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegHabilitado");
               GXutil.writeLogRaw("Old: ",Z301MegHabilitado);
               GXutil.writeLogRaw("Current: ",T00135_A301MegHabilitado[0]);
            }
            if ( GXutil.strcmp(Z302MegRes551, T00135_A302MegRes551[0]) != 0 )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegRes551");
               GXutil.writeLogRaw("Old: ",Z302MegRes551);
               GXutil.writeLogRaw("Current: ",T00135_A302MegRes551[0]);
            }
            if ( Z1990MegRelSec != T00135_A1990MegRelSec[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegRelSec");
               GXutil.writeLogRaw("Old: ",Z1990MegRelSec);
               GXutil.writeLogRaw("Current: ",T00135_A1990MegRelSec[0]);
            }
            if ( Z1991MegRelSecCli != T00135_A1991MegRelSecCli[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1991MegRelSecCli);
               GXutil.writeLogRaw("Current: ",T00135_A1991MegRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z1992MegPadre, T00135_A1992MegPadre[0]) != 0 )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegPadre");
               GXutil.writeLogRaw("Old: ",Z1992MegPadre);
               GXutil.writeLogRaw("Current: ",T00135_A1992MegPadre[0]);
            }
            if ( GXutil.strcmp(Z2017MegRelRef, T00135_A2017MegRelRef[0]) != 0 )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegRelRef");
               GXutil.writeLogRaw("Old: ",Z2017MegRelRef);
               GXutil.writeLogRaw("Current: ",T00135_A2017MegRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MotivoEgreso"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1336( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1336( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1336( 0) ;
         checkOptimisticConcurrency1336( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1336( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1336( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001313 */
                  pr_default.execute(11, new Object[] {A11MegCodigo, A300MegDescrip, Boolean.valueOf(A301MegHabilitado), Boolean.valueOf(n302MegRes551), A302MegRes551, Integer.valueOf(A1990MegRelSec), Integer.valueOf(A1991MegRelSecCli), A1992MegPadre, A2017MegRelRef, A2029MegOld, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
                  if ( (pr_default.getStatus(11) == 1) )
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
                        processLevel1336( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption130( ) ;
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
            load1336( ) ;
         }
         endLevel1336( ) ;
      }
      closeExtendedTableCursors1336( ) ;
   }

   public void update1336( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1336( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1336( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1336( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1336( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001314 */
                  pr_default.execute(12, new Object[] {A300MegDescrip, Boolean.valueOf(A301MegHabilitado), Boolean.valueOf(n302MegRes551), A302MegRes551, Integer.valueOf(A1990MegRelSec), Integer.valueOf(A1991MegRelSecCli), A1992MegPadre, A2017MegRelRef, A2029MegOld, Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
                  if ( (pr_default.getStatus(12) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgreso"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1336( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel1336( ) ;
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
         endLevel1336( ) ;
      }
      closeExtendedTableCursors1336( ) ;
   }

   public void deferredUpdate1336( )
   {
   }

   public void delete( )
   {
      beforeValidate1336( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1336( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1336( ) ;
         afterConfirm1336( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1336( ) ;
            if ( AnyError == 0 )
            {
               scanStart13220( ) ;
               while ( RcdFound220 != 0 )
               {
                  getByPrimaryKey13220( ) ;
                  delete13220( ) ;
                  scanNext13220( ) ;
               }
               scanEnd13220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001315 */
                  pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
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
      sMode36 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1336( ) ;
      Gx_mode = sMode36 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1336( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV14aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1990MegRelSec, GXv_boolean3) ;
            motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
         }
         AV16Pgmname = "MotivoEgreso" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) )
         {
            divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean2 = false ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
            motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) )
            {
               divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
            }
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001316 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "legajo_permanencia", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
         /* Using cursor T001317 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {""}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
         /* Using cursor T001318 */
         pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Motivo Egreso Tipos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T001319 */
         pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
      }
   }

   public void processNestedLevel13220( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         readRow13220( ) ;
         if ( ( nRcdExists_220 != 0 ) || ( nIsMod_220 != 0 ) )
         {
            standaloneNotModal13220( ) ;
            getKey13220( ) ;
            if ( ( nRcdExists_220 == 0 ) && ( nRcdDeleted_220 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert13220( ) ;
            }
            else
            {
               if ( RcdFound220 != 0 )
               {
                  if ( ( nRcdDeleted_220 != 0 ) && ( nRcdExists_220 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete13220( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_220 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update13220( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_220 == 0 )
                  {
                     GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = dynMegSitRevista.getInternalname() ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( dynMegSitRevista.getInternalname(), GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( chkMegSitRevDef.getInternalname(), GXutil.booltostr( A1606MegSitRevDef)) ;
         httpContext.changePostValue( edtMegSitRelSec_Internalname, GXutil.ltrim( localUtil.ntoc( A1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1601MegSitRevista_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1606MegSitRevDef_"+sGXsfl_40_idx, GXutil.booltostr( Z1606MegSitRevDef)) ;
         httpContext.changePostValue( "ZT_"+"Z1993MegSitRelSec_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1994MegSitRelSecCli_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1994MegSitRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1995MegSitPadre_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z1995MegSitPadre, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2018MegSitRelRef_"+sGXsfl_40_idx, Z2018MegSitRelRef) ;
         httpContext.changePostValue( "T1601MegSitRevista_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( O1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "T1606MegSitRevDef_"+sGXsfl_40_idx, GXutil.booltostr( O1606MegSitRevDef)) ;
         httpContext.changePostValue( "nRcdDeleted_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_220_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_220 != 0 )
         {
            httpContext.changePostValue( "MEGSITREVISTA_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMegSitRevista.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITREVDEF_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMegSitRevDef.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITRELSEC_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MEGSITRELSEC_"+sGXsfl_40_idx+"Visible", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Visible, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll13220( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_220 = (short)(0) ;
      nIsMod_220 = (short)(0) ;
      nRcdDeleted_220 = (short)(0) ;
   }

   public void processLevel1336( )
   {
      /* Save parent mode. */
      sMode36 = Gx_mode ;
      processNestedLevel13220( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode36 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel1336( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1336( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "motivoegreso");
         if ( AnyError == 0 )
         {
            confirmValues130( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "motivoegreso");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1336( )
   {
      /* Scan By routine */
      /* Using cursor T001320 */
      pr_default.execute(18);
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A3CliCod = T001320_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T001320_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1336( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound36 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound36 = (short)(1) ;
         A3CliCod = T001320_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A11MegCodigo = T001320_A11MegCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      }
   }

   public void scanEnd1336( )
   {
      pr_default.close(18);
   }

   public void afterConfirm1336( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV14aplicadoHay ) && ! (0==A1990MegRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "MegRelSec", 1, "MEGRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert1336( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1336( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1336( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1336( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1336( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1336( )
   {
      edtMegCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegCodigo_Enabled), 5, 0), true);
      edtMegDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegDescrip_Enabled), 5, 0), true);
      dynMegRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynMegRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void zm13220( int GX_JID )
   {
      if ( ( GX_JID == 24 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1606MegSitRevDef = T00133_A1606MegSitRevDef[0] ;
            Z1993MegSitRelSec = T00133_A1993MegSitRelSec[0] ;
            Z1994MegSitRelSecCli = T00133_A1994MegSitRelSecCli[0] ;
            Z1995MegSitPadre = T00133_A1995MegSitPadre[0] ;
            Z2018MegSitRelRef = T00133_A2018MegSitRelRef[0] ;
         }
         else
         {
            Z1606MegSitRevDef = A1606MegSitRevDef ;
            Z1993MegSitRelSec = A1993MegSitRelSec ;
            Z1994MegSitRelSecCli = A1994MegSitRelSecCli ;
            Z1995MegSitPadre = A1995MegSitPadre ;
            Z2018MegSitRelRef = A2018MegSitRelRef ;
         }
      }
      if ( GX_JID == -24 )
      {
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1606MegSitRevDef = A1606MegSitRevDef ;
         Z1993MegSitRelSec = A1993MegSitRelSec ;
         Z1994MegSitRelSecCli = A1994MegSitRelSecCli ;
         Z1995MegSitPadre = A1995MegSitPadre ;
         Z2018MegSitRelRef = A2018MegSitRelRef ;
         Z2030MegSitOld = A2030MegSitOld ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         Z1604MegSitRevDescrip = A1604MegSitRevDescrip ;
      }
   }

   public void standaloneNotModal13220( )
   {
      gxamegsitrevista_html13220( ) ;
   }

   public void standaloneModal13220( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         dynMegSitRevista.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegSitRevista.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      }
      else
      {
         dynMegSitRevista.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegSitRevista.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T00134 */
         pr_default.execute(2, new Object[] {Short.valueOf(A1601MegSitRevista)});
         A1604MegSitRevDescrip = T00134_A1604MegSitRevDescrip[0] ;
         pr_default.close(2);
      }
   }

   public void load13220( )
   {
      /* Using cursor T001321 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1604MegSitRevDescrip = T001321_A1604MegSitRevDescrip[0] ;
         A1606MegSitRevDef = T001321_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = T001321_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = T001321_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = T001321_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = T001321_A2018MegSitRelRef[0] ;
         A2030MegSitOld = T001321_A2030MegSitOld[0] ;
         zm13220( -24) ;
      }
      pr_default.close(19);
      onLoadActions13220( ) ;
   }

   public void onLoadActions13220( )
   {
   }

   public void checkExtendedTable13220( )
   {
      nIsDirty_220 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal13220( ) ;
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1993MegSitRelSec, GXv_boolean3) ;
         motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
      }
      /* Using cursor T00134 */
      pr_default.execute(2, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegSitRevista.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1604MegSitRevDescrip = T00134_A1604MegSitRevDescrip[0] ;
      pr_default.close(2);
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( A1601MegSitRevista != O1601MegSitRevista ) || ( A1606MegSitRevDef != O1606MegSitRevDef ) ) ) && (0==A1993MegSitRelSec) )
      {
         GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegSitRevista.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors13220( )
   {
      pr_default.close(2);
   }

   public void enableDisable13220( )
   {
   }

   public void gxload_25( short A1601MegSitRevista )
   {
      /* Using cursor T001322 */
      pr_default.execute(20, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegSitRevista.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A1604MegSitRevDescrip = T001322_A1604MegSitRevDescrip[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A1604MegSitRevDescrip)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(20) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(20);
   }

   public void getKey13220( )
   {
      /* Using cursor T001323 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound220 = (short)(1) ;
      }
      else
      {
         RcdFound220 = (short)(0) ;
      }
      pr_default.close(21);
   }

   public void getByPrimaryKey13220( )
   {
      /* Using cursor T00133 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm13220( 24) ;
         RcdFound220 = (short)(1) ;
         initializeNonKey13220( ) ;
         A1606MegSitRevDef = T00133_A1606MegSitRevDef[0] ;
         A1993MegSitRelSec = T00133_A1993MegSitRelSec[0] ;
         A1994MegSitRelSecCli = T00133_A1994MegSitRelSecCli[0] ;
         A1995MegSitPadre = T00133_A1995MegSitPadre[0] ;
         A2018MegSitRelRef = T00133_A2018MegSitRelRef[0] ;
         A2030MegSitOld = T00133_A2030MegSitOld[0] ;
         A1601MegSitRevista = T00133_A1601MegSitRevista[0] ;
         O1601MegSitRevista = A1601MegSitRevista ;
         O1606MegSitRevDef = A1606MegSitRevDef ;
         Z3CliCod = A3CliCod ;
         Z11MegCodigo = A11MegCodigo ;
         Z1601MegSitRevista = A1601MegSitRevista ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load13220( ) ;
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound220 = (short)(0) ;
         initializeNonKey13220( ) ;
         sMode220 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal13220( ) ;
         Gx_mode = sMode220 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes13220( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency13220( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00132 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( Z1606MegSitRevDef != T00132_A1606MegSitRevDef[0] ) || ( Z1993MegSitRelSec != T00132_A1993MegSitRelSec[0] ) || ( Z1994MegSitRelSecCli != T00132_A1994MegSitRelSecCli[0] ) || ( Z1995MegSitPadre != T00132_A1995MegSitPadre[0] ) || ( GXutil.strcmp(Z2018MegSitRelRef, T00132_A2018MegSitRelRef[0]) != 0 ) )
         {
            if ( Z1606MegSitRevDef != T00132_A1606MegSitRevDef[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegSitRevDef");
               GXutil.writeLogRaw("Old: ",Z1606MegSitRevDef);
               GXutil.writeLogRaw("Current: ",T00132_A1606MegSitRevDef[0]);
            }
            if ( Z1993MegSitRelSec != T00132_A1993MegSitRelSec[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegSitRelSec");
               GXutil.writeLogRaw("Old: ",Z1993MegSitRelSec);
               GXutil.writeLogRaw("Current: ",T00132_A1993MegSitRelSec[0]);
            }
            if ( Z1994MegSitRelSecCli != T00132_A1994MegSitRelSecCli[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegSitRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1994MegSitRelSecCli);
               GXutil.writeLogRaw("Current: ",T00132_A1994MegSitRelSecCli[0]);
            }
            if ( Z1995MegSitPadre != T00132_A1995MegSitPadre[0] )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegSitPadre");
               GXutil.writeLogRaw("Old: ",Z1995MegSitPadre);
               GXutil.writeLogRaw("Current: ",T00132_A1995MegSitPadre[0]);
            }
            if ( GXutil.strcmp(Z2018MegSitRelRef, T00132_A2018MegSitRelRef[0]) != 0 )
            {
               GXutil.writeLogln("motivoegreso:[seudo value changed for attri]"+"MegSitRelRef");
               GXutil.writeLogRaw("Old: ",Z2018MegSitRelRef);
               GXutil.writeLogRaw("Current: ",T00132_A2018MegSitRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert13220( )
   {
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable13220( ) ;
      }
      if ( AnyError == 0 )
      {
         zm13220( 0) ;
         checkOptimisticConcurrency13220( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm13220( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert13220( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001324 */
                  pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A1993MegSitRelSec), Integer.valueOf(A1994MegSitRelSecCli), Short.valueOf(A1995MegSitPadre), A2018MegSitRelRef, A2030MegSitOld, Short.valueOf(A1601MegSitRevista)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
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
            load13220( ) ;
         }
         endLevel13220( ) ;
      }
      closeExtendedTableCursors13220( ) ;
   }

   public void update13220( )
   {
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable13220( ) ;
      }
      if ( ( nIsMod_220 != 0 ) || ( nIsDirty_220 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency13220( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm13220( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate13220( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T001325 */
                     pr_default.execute(23, new Object[] {Boolean.valueOf(A1606MegSitRevDef), Integer.valueOf(A1993MegSitRelSec), Integer.valueOf(A1994MegSitRelSecCli), Short.valueOf(A1995MegSitPadre), A2018MegSitRelRef, A2030MegSitOld, Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
                     if ( (pr_default.getStatus(23) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"MotivoEgresoRevistaAfip"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate13220( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey13220( ) ;
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
            endLevel13220( ) ;
         }
      }
      closeExtendedTableCursors13220( ) ;
   }

   public void deferredUpdate13220( )
   {
   }

   public void delete13220( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate13220( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency13220( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls13220( ) ;
         afterConfirm13220( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete13220( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001326 */
               pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo, Short.valueOf(A1601MegSitRevista)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgresoRevistaAfip");
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
      sMode220 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel13220( ) ;
      Gx_mode = sMode220 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls13220( )
   {
      standaloneModal13220( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV14aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1993MegSitRelSec, GXv_boolean3) ;
            motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
         }
         /* Using cursor T001327 */
         pr_default.execute(25, new Object[] {Short.valueOf(A1601MegSitRevista)});
         A1604MegSitRevDescrip = T001327_A1604MegSitRevDescrip[0] ;
         pr_default.close(25);
      }
   }

   public void endLevel13220( )
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

   public void scanStart13220( )
   {
      /* Scan By routine */
      /* Using cursor T001328 */
      pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A11MegCodigo});
      RcdFound220 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1601MegSitRevista = T001328_A1601MegSitRevista[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext13220( )
   {
      /* Scan next routine */
      pr_default.readNext(26);
      RcdFound220 = (short)(0) ;
      if ( (pr_default.getStatus(26) != 101) )
      {
         RcdFound220 = (short)(1) ;
         A1601MegSitRevista = T001328_A1601MegSitRevista[0] ;
      }
   }

   public void scanEnd13220( )
   {
      pr_default.close(26);
   }

   public void afterConfirm13220( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV14aplicadoHay ) && ! (0==A1993MegSitRelSec) )
      {
         GXCCtl = "MEGSITRELSEC_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "MegSitRelSec", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRelSec_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
      if ( ( isIns( )  || isUpd( )  ) && ( AV14aplicadoHay ) && ! (0==A1990MegRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "MegRelSec", 1, "MEGRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert13220( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate13220( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete13220( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete13220( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate13220( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes13220( )
   {
      dynMegSitRevista.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegSitRevista.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      chkMegSitRevDef.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "Enabled", GXutil.ltrimstr( chkMegSitRevDef.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
      edtMegSitRelSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegSitRelSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRelSec_Enabled), 5, 0), !bGXsfl_40_Refreshing);
   }

   public void send_integrity_lvl_hashes13220( )
   {
   }

   public void send_integrity_lvl_hashes1336( )
   {
   }

   public void subsflControlProps_40220( )
   {
      dynMegSitRevista.setInternalname( "MEGSITREVISTA_"+sGXsfl_40_idx );
      chkMegSitRevDef.setInternalname( "MEGSITREVDEF_"+sGXsfl_40_idx );
      edtMegSitRelSec_Internalname = "MEGSITRELSEC_"+sGXsfl_40_idx ;
   }

   public void subsflControlProps_fel_40220( )
   {
      dynMegSitRevista.setInternalname( "MEGSITREVISTA_"+sGXsfl_40_fel_idx );
      chkMegSitRevDef.setInternalname( "MEGSITREVDEF_"+sGXsfl_40_fel_idx );
      edtMegSitRelSec_Internalname = "MEGSITRELSEC_"+sGXsfl_40_fel_idx ;
   }

   public void addRow13220( )
   {
      nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40220( ) ;
      sendRow13220( ) ;
   }

   public void sendRow13220( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_40_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      gxamegsitrevista_html13220( ) ;
      /* Subfile cell */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_220_" + sGXsfl_40_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 41,'',false,'" + sGXsfl_40_idx + "',40)\"" ;
      GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
      dynMegSitRevista.setName( GXCCtl );
      dynMegSitRevista.setWebtags( "" );
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {dynMegSitRevista,dynMegSitRevista.getInternalname(),GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0)),Integer.valueOf(1),dynMegSitRevista.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","int","",Integer.valueOf(-1),Integer.valueOf(dynMegSitRevista.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,41);\"","",Boolean.valueOf(true),Integer.valueOf(0)});
      dynMegSitRevista.setValue( GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Values", dynMegSitRevista.ToJavascriptSource(), !bGXsfl_40_Refreshing);
      /* Subfile cell */
      /* Check box */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_220_" + sGXsfl_40_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_40_idx + "',40)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      GXCCtl = "MEGSITREVDEF_" + sGXsfl_40_idx ;
      chkMegSitRevDef.setName( GXCCtl );
      chkMegSitRevDef.setWebtags( "" );
      chkMegSitRevDef.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "TitleCaption", chkMegSitRevDef.getCaption(), !bGXsfl_40_Refreshing);
      chkMegSitRevDef.setCheckedValue( "false" );
      A1606MegSitRevDef = GXutil.strtobool( GXutil.booltostr( A1606MegSitRevDef)) ;
      Gridlevel1Row.AddColumnProperties("checkbox", 1, isAjaxCallMode( ), new Object[] {chkMegSitRevDef.getInternalname(),GXutil.booltostr( A1606MegSitRevDef),"","",Integer.valueOf(-1),Integer.valueOf(chkMegSitRevDef.getEnabled()),"true","",StyleString,ClassString,"TrnColumn","",TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_220_" + sGXsfl_40_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 43,'',false,'" + sGXsfl_40_idx + "',40)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMegSitRelSec_Internalname,GXutil.ltrim( localUtil.ntoc( A1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtMegSitRelSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1993MegSitRelSec), "ZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A1993MegSitRelSec), "ZZZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,43);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMegSitRelSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(edtMegSitRelSec_Visible),Integer.valueOf(edtMegSitRelSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes13220( ) ;
      GXCCtl = "Z1601MegSitRevista_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1606MegSitRevDef_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, Z1606MegSitRevDef);
      GXCCtl = "Z1993MegSitRelSec_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1993MegSitRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1994MegSitRelSecCli_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1994MegSitRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1995MegSitPadre_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1995MegSitPadre, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2018MegSitRelRef_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2018MegSitRelRef);
      GXCCtl = "O1601MegSitRevista_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( O1601MegSitRevista, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "O1606MegSitRevDef_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, O1606MegSitRevDef);
      GXCCtl = "nRcdDeleted_220_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_220_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_220_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_220, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMEGCODIGO_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV8MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITREVISTA_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( dynMegSitRevista.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITREVDEF_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( chkMegSitRevDef.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITRELSEC_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITRELSEC_"+sGXsfl_40_idx+"Visible", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Visible, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow13220( )
   {
      nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40220( ) ;
      dynMegSitRevista.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITREVISTA_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      chkMegSitRevDef.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITREVDEF_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      edtMegSitRelSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITRELSEC_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMegSitRelSec_Visible = (int)(localUtil.ctol( httpContext.cgiGet( "MEGSITRELSEC_"+sGXsfl_40_idx+"Visible"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      dynMegSitRevista.setName( dynMegSitRevista.getInternalname() );
      dynMegSitRevista.setValue( httpContext.cgiGet( dynMegSitRevista.getInternalname()) );
      A1601MegSitRevista = (short)(GXutil.lval( httpContext.cgiGet( dynMegSitRevista.getInternalname()))) ;
      A1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( chkMegSitRevDef.getInternalname())) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMegSitRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMegSitRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
      {
         GXCCtl = "MEGSITRELSEC_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRelSec_Internalname ;
         wbErr = true ;
         A1993MegSitRelSec = 0 ;
      }
      else
      {
         A1993MegSitRelSec = (int)(localUtil.ctol( httpContext.cgiGet( edtMegSitRelSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z1601MegSitRevista_" + sGXsfl_40_idx ;
      Z1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1606MegSitRevDef_" + sGXsfl_40_idx ;
      Z1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1993MegSitRelSec_" + sGXsfl_40_idx ;
      Z1993MegSitRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1994MegSitRelSecCli_" + sGXsfl_40_idx ;
      Z1994MegSitRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1995MegSitPadre_" + sGXsfl_40_idx ;
      Z1995MegSitPadre = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2018MegSitRelRef_" + sGXsfl_40_idx ;
      Z2018MegSitRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z1994MegSitRelSecCli_" + sGXsfl_40_idx ;
      A1994MegSitRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z1995MegSitPadre_" + sGXsfl_40_idx ;
      A1995MegSitPadre = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2018MegSitRelRef_" + sGXsfl_40_idx ;
      A2018MegSitRelRef = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "O1601MegSitRevista_" + sGXsfl_40_idx ;
      O1601MegSitRevista = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "O1606MegSitRevDef_" + sGXsfl_40_idx ;
      O1606MegSitRevDef = GXutil.strtobool( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_220_" + sGXsfl_40_idx ;
      nRcdDeleted_220 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_220_" + sGXsfl_40_idx ;
      nRcdExists_220 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_220_" + sGXsfl_40_idx ;
      nIsMod_220 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defdynMegSitRevista_Enabled = dynMegSitRevista.getEnabled() ;
   }

   public void confirmValues130( )
   {
      nGXsfl_40_idx = 0 ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40220( ) ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_40220( ) ;
         httpContext.changePostValue( "Z1601MegSitRevista_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z1601MegSitRevista_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1601MegSitRevista_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z1606MegSitRevDef_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z1606MegSitRevDef_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1606MegSitRevDef_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z1993MegSitRelSec_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z1993MegSitRelSec_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1993MegSitRelSec_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z1994MegSitRelSecCli_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z1994MegSitRelSecCli_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1994MegSitRelSecCli_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z1995MegSitPadre_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z1995MegSitPadre_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1995MegSitPadre_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z2018MegSitRelRef_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z2018MegSitRelRef_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2018MegSitRelRef_"+sGXsfl_40_idx) ;
      }
      httpContext.changePostValue( "O1601MegSitRevista", httpContext.cgiGet( "T1601MegSitRevista")) ;
      httpContext.deletePostValue( "T1601MegSitRevista") ;
      httpContext.changePostValue( "O1606MegSitRevDef", httpContext.cgiGet( "T1606MegSitRevDef")) ;
      httpContext.deletePostValue( "T1606MegSitRevDef") ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.motivoegreso", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8MegCodigo))}, new String[] {"Gx_mode","CliCod","MegCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"MotivoEgreso");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MegHabilitado", GXutil.booltostr( A301MegHabilitado));
      forbiddenHiddens.add("MegRes551", GXutil.rtrim( localUtil.format( A302MegRes551, "")));
      forbiddenHiddens.add("MegRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1991MegRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("MegPadre", GXutil.rtrim( localUtil.format( A1992MegPadre, "")));
      forbiddenHiddens.add("MegRelRef", GXutil.rtrim( localUtil.format( A2017MegRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("motivoegreso:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z11MegCodigo", GXutil.rtrim( Z11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z300MegDescrip", Z300MegDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z301MegHabilitado", Z301MegHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z302MegRes551", GXutil.rtrim( Z302MegRes551));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1990MegRelSec", GXutil.ltrim( localUtil.ntoc( Z1990MegRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1991MegRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1991MegRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1992MegPadre", GXutil.rtrim( Z1992MegPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2017MegRelRef", Z2017MegRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "O300MegDescrip", O300MegDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O11MegCodigo", GXutil.rtrim( O11MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_40", GXutil.ltrim( localUtil.ntoc( nGXsfl_40_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMEGCODIGO", GXutil.rtrim( AV8MegCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMEGCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8MegCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MEGHABILITADO", A301MegHabilitado);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV14aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "MEGRES551", GXutil.rtrim( A302MegRes551));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1991MegRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGPADRE", GXutil.rtrim( A1992MegPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGRELREF", A2017MegRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "MEGOLD", A2029MegOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1994MegSitRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITPADRE", GXutil.ltrim( localUtil.ntoc( A1995MegSitPadre, (byte)(3), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITRELREF", A2018MegSitRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITOLD", A2030MegSitOld);
      web.GxWebStd.gx_hidden_field( httpContext, "MEGSITREVDESCRIP", A1604MegSitRevDescrip);
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
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Objectcall", GXutil.rtrim( Dvpanel_sitrev_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Enabled", GXutil.booltostr( Dvpanel_sitrev_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Width", GXutil.rtrim( Dvpanel_sitrev_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Autowidth", GXutil.booltostr( Dvpanel_sitrev_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Autoheight", GXutil.booltostr( Dvpanel_sitrev_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Cls", GXutil.rtrim( Dvpanel_sitrev_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Title", GXutil.rtrim( Dvpanel_sitrev_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Collapsible", GXutil.booltostr( Dvpanel_sitrev_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Collapsed", GXutil.booltostr( Dvpanel_sitrev_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Showcollapseicon", GXutil.booltostr( Dvpanel_sitrev_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Iconposition", GXutil.rtrim( Dvpanel_sitrev_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_SITREV_Autoscroll", GXutil.booltostr( Dvpanel_sitrev_Autoscroll));
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
      return formatLink("web.motivoegreso", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8MegCodigo))}, new String[] {"Gx_mode","CliCod","MegCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "MotivoEgreso" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Motivo Egreso", "") ;
   }

   public void initializeNonKey1336( )
   {
      AV14aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
      A300MegDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
      A302MegRes551 = "" ;
      n302MegRes551 = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A302MegRes551", A302MegRes551);
      A1990MegRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1990MegRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1990MegRelSec), 6, 0));
      A1991MegRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1991MegRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1991MegRelSecCli), 6, 0));
      A1992MegPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1992MegPadre", A1992MegPadre);
      A2017MegRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2017MegRelRef", A2017MegRelRef);
      A2029MegOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2029MegOld", A2029MegOld);
      A301MegHabilitado = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A301MegHabilitado", A301MegHabilitado);
      O300MegDescrip = A300MegDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A300MegDescrip", A300MegDescrip);
      Z300MegDescrip = "" ;
      Z301MegHabilitado = false ;
      Z302MegRes551 = "" ;
      Z1990MegRelSec = 0 ;
      Z1991MegRelSecCli = 0 ;
      Z1992MegPadre = "" ;
      Z2017MegRelRef = "" ;
   }

   public void initAll1336( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A11MegCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11MegCodigo", A11MegCodigo);
      initializeNonKey1336( ) ;
   }

   public void standaloneModalInsert( )
   {
      A301MegHabilitado = i301MegHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A301MegHabilitado", A301MegHabilitado);
   }

   public void initializeNonKey13220( )
   {
      A1604MegSitRevDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1604MegSitRevDescrip", A1604MegSitRevDescrip);
      A1606MegSitRevDef = false ;
      A1993MegSitRelSec = 0 ;
      A1994MegSitRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1994MegSitRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1994MegSitRelSecCli), 6, 0));
      A1995MegSitPadre = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1995MegSitPadre", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1995MegSitPadre), 3, 0));
      A2018MegSitRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2018MegSitRelRef", A2018MegSitRelRef);
      A2030MegSitOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2030MegSitOld", A2030MegSitOld);
      O1606MegSitRevDef = A1606MegSitRevDef ;
      Z1606MegSitRevDef = false ;
      Z1993MegSitRelSec = 0 ;
      Z1994MegSitRelSecCli = 0 ;
      Z1995MegSitPadre = (short)(0) ;
      Z2018MegSitRelRef = "" ;
   }

   public void initAll13220( )
   {
      A1601MegSitRevista = (short)(0) ;
      initializeNonKey13220( ) ;
   }

   public void standaloneModalInsert13220( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713544787", true, true);
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
      httpContext.AddJavascriptSource("motivoegreso.js", "?20251713544787", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties220( )
   {
      dynMegSitRevista.setEnabled( defdynMegSitRevista_Enabled );
      httpContext.ajax_rsp_assign_prop("", false, dynMegSitRevista.getInternalname(), "Enabled", GXutil.ltrimstr( dynMegSitRevista.getEnabled(), 5, 0), !bGXsfl_40_Refreshing);
   }

   public void startgridcontrol40( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1601MegSitRevista, (byte)(3), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( dynMegSitRevista.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.booltostr( A1606MegSitRevDef));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( chkMegSitRevDef.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1993MegSitRelSec, (byte)(6), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Visible", GXutil.ltrim( localUtil.ntoc( edtMegSitRelSec_Visible, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtMegCodigo_Internalname = "MEGCODIGO" ;
      edtMegDescrip_Internalname = "MEGDESCRIP" ;
      dynMegRelSec.setInternalname( "MEGRELSEC" );
      divMegrelsec_cell_Internalname = "MEGRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      dynMegSitRevista.setInternalname( "MEGSITREVISTA" );
      chkMegSitRevDef.setInternalname( "MEGSITREVDEF" );
      edtMegSitRelSec_Internalname = "MEGSITRELSEC" ;
      divSitrev_Internalname = "SITREV" ;
      Dvpanel_sitrev_Internalname = "DVPANEL_SITREV" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Motivo Egreso", "") );
      edtMegSitRelSec_Jsonclick = "" ;
      chkMegSitRevDef.setCaption( "" );
      dynMegSitRevista.setJsonclick( "" );
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtMegSitRelSec_Visible = -1 ;
      edtMegSitRelSec_Enabled = 1 ;
      chkMegSitRevDef.setEnabled( 1 );
      dynMegSitRevista.setEnabled( 1 );
      Dvpanel_sitrev_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_sitrev_Iconposition = "Right" ;
      Dvpanel_sitrev_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_sitrev_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_sitrev_Collapsible = GXutil.toBoolean( -1) ;
      Dvpanel_sitrev_Title = httpContext.getMessage( "Situaciones de revista AFIP relacionadas", "") ;
      Dvpanel_sitrev_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_sitrev_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_sitrev_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_sitrev_Width = "100%" ;
      dynMegRelSec.setJsonclick( "" );
      dynMegRelSec.setEnabled( 1 );
      dynMegRelSec.setVisible( 1 );
      divMegrelsec_cell_Class = "col-xs-12" ;
      edtMegDescrip_Enabled = 1 ;
      edtMegCodigo_Jsonclick = "" ;
      edtMegCodigo_Enabled = 1 ;
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

   public void gxdlamegrelsec1336( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamegrelsec_data1336( AV7CliCod) ;
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

   public void gxamegrelsec_html1336( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlamegrelsec_data1336( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMegRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynMegRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamegrelsec_data1336( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T001329 */
      pr_default.execute(27, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(27) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001329_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001329_A1880CliReDTChar[0]);
         pr_default.readNext(27);
      }
      pr_default.close(27);
   }

   public void gxdlamegsitrevista13220( )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlamegsitrevista_data13220( ) ;
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

   public void gxamegsitrevista_html13220( )
   {
      short gxdynajaxvalue;
      gxdlamegsitrevista_data13220( ) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynMegSitRevista.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (short)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynMegSitRevista.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 3, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlamegsitrevista_data13220( )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T001330 */
      pr_default.execute(28);
      while ( (pr_default.getStatus(28) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T001330_A1601MegSitRevista[0], (byte)(3), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T001330_A1604MegSitRevDescrip[0]);
         pr_default.readNext(28);
      }
      pr_default.close(28);
   }

   public void gx1asaclicod1336( int AV7CliCod )
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
            motivoegreso_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxasa19901336( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynMegRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynMegRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynMegRelSec.getVisible(), 5, 0), true);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxasa19931336( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      edtMegSitRelSec_Visible = (!GXt_boolean2 ? 1 : 0) ;
      httpContext.ajax_rsp_assign_prop("", false, edtMegSitRelSec_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMegSitRelSec_Visible), 5, 0), !bGXsfl_40_Refreshing);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_15_1336( String Gx_mode ,
                           int AV7CliCod ,
                           int A1990MegRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1990MegRelSec, GXv_boolean3) ;
         AV14aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV14aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_20_13220( String Gx_mode ,
                            int AV7CliCod ,
                            int A1993MegSitRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1993MegSitRelSec, GXv_boolean3) ;
         AV14aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV14aplicadoHay))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_40220( ) ;
      while ( nGXsfl_40_idx <= nRC_GXsfl_40 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal13220( ) ;
         standaloneModal13220( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow13220( ) ;
         nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_40220( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      dynMegRelSec.setName( "MEGRELSEC" );
      dynMegRelSec.setWebtags( "" );
      GXCCtl = "MEGSITREVISTA_" + sGXsfl_40_idx ;
      dynMegSitRevista.setName( GXCCtl );
      dynMegSitRevista.setWebtags( "" );
      GXCCtl = "MEGSITREVDEF_" + sGXsfl_40_idx ;
      chkMegSitRevDef.setName( GXCCtl );
      chkMegSitRevDef.setWebtags( "" );
      chkMegSitRevDef.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkMegSitRevDef.getInternalname(), "TitleCaption", chkMegSitRevDef.getCaption(), !bGXsfl_40_Refreshing);
      chkMegSitRevDef.setCheckedValue( "false" );
      A1606MegSitRevDef = GXutil.strtobool( GXutil.booltostr( A1606MegSitRevDef)) ;
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
      A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValue())) ;
      A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValue())) ;
      /* Using cursor T001331 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(29);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Megdescrip( )
   {
      A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValue())) ;
      A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValue())) ;
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) )
      {
         divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         motivoegreso_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) )
         {
            divMegrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      if ( (GXutil.strcmp("", A300MegDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Descripción", ""), "", "", "", "", "", "", "", ""), 1, "MEGDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divMegrelsec_cell_Internalname, "Class", divMegrelsec_cell_Class, true);
   }

   public void valid_Megrelsec( )
   {
      A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValue())) ;
      A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A11MegCodigo, O11MegCodigo) != 0 ) || ( GXutil.strcmp(A300MegDescrip, O300MegDescrip) != 0 ) ) ) && (0==A1990MegRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "MEGRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1990MegRelSec, GXv_boolean3) ;
         motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
         AV14aplicadoHay = this.AV14aplicadoHay ;
      }
      O300MegDescrip = A300MegDescrip ;
      O11MegCodigo = A11MegCodigo ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
   }

   public void valid_Megsitrevista( )
   {
      A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValue())) ;
      A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValue())) ;
      /* Using cursor T001332 */
      pr_default.execute(30, new Object[] {Short.valueOf(A1601MegSitRevista)});
      if ( (pr_default.getStatus(30) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Motivo Egreso Revista Grp", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "MEGSITREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = dynMegSitRevista.getInternalname() ;
      }
      A1604MegSitRevDescrip = T001332_A1604MegSitRevDescrip[0] ;
      pr_default.close(30);
      dynload_actions( ) ;
      if ( dynMegSitRevista.getItemCount() > 0 )
      {
         A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValidValue(GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMegSitRevista.setValue( GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A1604MegSitRevDescrip", A1604MegSitRevDescrip);
   }

   public void valid_Megsitrelsec( )
   {
      A1990MegRelSec = (int)(GXutil.lval( dynMegRelSec.getValue())) ;
      A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( A1601MegSitRevista != O1601MegSitRevista ) || ( A1606MegSitRevDef != O1606MegSitRevDef ) ) ) && (0==A1993MegSitRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "MEGSITRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMegSitRelSec_Internalname ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV14aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1993MegSitRelSec, GXv_boolean3) ;
         motivoegreso_impl.this.AV14aplicadoHay = GXv_boolean3[0] ;
         AV14aplicadoHay = this.AV14aplicadoHay ;
      }
      O1601MegSitRevista = A1601MegSitRevista ;
      O1606MegSitRevDef = A1606MegSitRevDef ;
      dynload_actions( ) ;
      if ( dynMegSitRevista.getItemCount() > 0 )
      {
         A1601MegSitRevista = (short)(GXutil.lval( dynMegSitRevista.getValidValue(GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0))))) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynMegSitRevista.setValue( GXutil.trim( GXutil.str( A1601MegSitRevista, 3, 0)) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV14aplicadoHay", AV14aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8MegCodigo',fld:'vMEGCODIGO',pic:'',hsh:true},{av:'A301MegHabilitado',fld:'MEGHABILITADO',pic:''},{av:'A302MegRes551',fld:'MEGRES551',pic:''},{av:'A1991MegRelSecCli',fld:'MEGRELSECCLI',pic:'ZZZZZ9'},{av:'A1992MegPadre',fld:'MEGPADRE',pic:''},{av:'A2017MegRelRef',fld:'MEGRELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("AFTER TRN","{handler:'e12132',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGCODIGO","{handler:'valid_Megcodigo',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGCODIGO",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGDESCRIP","{handler:'valid_Megdescrip',iparms:[{av:'O300MegDescrip'},{av:'O11MegCodigo'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A300MegDescrip',fld:'MEGDESCRIP',pic:''},{av:'dynMegSitRevista'},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGDESCRIP",",oparms:[{av:'divMegrelsec_cell_Class',ctrl:'MEGRELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGRELSEC","{handler:'valid_Megrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O300MegDescrip'},{av:'O11MegCodigo'},{av:'A11MegCodigo',fld:'MEGCODIGO',pic:''},{av:'A300MegDescrip',fld:'MEGDESCRIP',pic:''},{av:'dynMegSitRevista'},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'AV14aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGRELSEC",",oparms:[{av:'AV14aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'dynMegSitRevista'},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGSITREVISTA","{handler:'valid_Megsitrevista',iparms:[{av:'dynMegSitRevista'},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'A1604MegSitRevDescrip',fld:'MEGSITREVDESCRIP',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGSITREVISTA",",oparms:[{av:'A1604MegSitRevDescrip',fld:'MEGSITREVDESCRIP',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGSITREVDEF","{handler:'valid_Megsitrevdef',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGSITREVDEF",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
      setEventMetadata("VALID_MEGSITRELSEC","{handler:'valid_Megsitrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!'},{av:'O1606MegSitRevDef'},{av:'O1601MegSitRevista'},{av:'A1606MegSitRevDef',fld:'MEGSITREVDEF',pic:''},{av:'A1993MegSitRelSec',fld:'MEGSITRELSEC',pic:'ZZZZZ9'},{av:'dynMegSitRevista'},{av:'A1601MegSitRevista',fld:'MEGSITREVISTA',pic:'ZZ9'},{av:'AV14aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]");
      setEventMetadata("VALID_MEGSITRELSEC",",oparms:[{av:'AV14aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'dynMegRelSec'},{av:'A1990MegRelSec',fld:'MEGRELSEC',pic:'ZZZZZ9'}]}");
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
      return "motivoegreso_Execute";
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
      pr_default.close(30);
      pr_default.close(25);
      pr_default.close(29);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8MegCodigo = "" ;
      Z11MegCodigo = "" ;
      Z300MegDescrip = "" ;
      Z302MegRes551 = "" ;
      Z1992MegPadre = "" ;
      Z2017MegRelRef = "" ;
      O300MegDescrip = "" ;
      O11MegCodigo = "" ;
      Z2018MegSitRelRef = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      AV8MegCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A11MegCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A300MegDescrip = "" ;
      ucDvpanel_sitrev = new com.genexus.webpanels.GXUserControl();
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      B300MegDescrip = "" ;
      B11MegCodigo = "" ;
      sMode220 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A302MegRes551 = "" ;
      A1992MegPadre = "" ;
      A2017MegRelRef = "" ;
      A2029MegOld = "" ;
      AV16Pgmname = "" ;
      A2018MegSitRelRef = "" ;
      A2030MegSitOld = "" ;
      A1604MegSitRevDescrip = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Dvpanel_sitrev_Objectcall = "" ;
      Dvpanel_sitrev_Class = "" ;
      Dvpanel_sitrev_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode36 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z2029MegOld = "" ;
      T00138_A11MegCodigo = new String[] {""} ;
      T00138_A300MegDescrip = new String[] {""} ;
      T00138_A301MegHabilitado = new boolean[] {false} ;
      T00138_A302MegRes551 = new String[] {""} ;
      T00138_n302MegRes551 = new boolean[] {false} ;
      T00138_A1990MegRelSec = new int[1] ;
      T00138_A1991MegRelSecCli = new int[1] ;
      T00138_A1992MegPadre = new String[] {""} ;
      T00138_A2017MegRelRef = new String[] {""} ;
      T00138_A2029MegOld = new String[] {""} ;
      T00138_A3CliCod = new int[1] ;
      T00137_A3CliCod = new int[1] ;
      T00139_A3CliCod = new int[1] ;
      T001310_A3CliCod = new int[1] ;
      T001310_A11MegCodigo = new String[] {""} ;
      T00136_A11MegCodigo = new String[] {""} ;
      T00136_A300MegDescrip = new String[] {""} ;
      T00136_A301MegHabilitado = new boolean[] {false} ;
      T00136_A302MegRes551 = new String[] {""} ;
      T00136_n302MegRes551 = new boolean[] {false} ;
      T00136_A1990MegRelSec = new int[1] ;
      T00136_A1991MegRelSecCli = new int[1] ;
      T00136_A1992MegPadre = new String[] {""} ;
      T00136_A2017MegRelRef = new String[] {""} ;
      T00136_A2029MegOld = new String[] {""} ;
      T00136_A3CliCod = new int[1] ;
      T001311_A3CliCod = new int[1] ;
      T001311_A11MegCodigo = new String[] {""} ;
      T001312_A3CliCod = new int[1] ;
      T001312_A11MegCodigo = new String[] {""} ;
      T00135_A11MegCodigo = new String[] {""} ;
      T00135_A300MegDescrip = new String[] {""} ;
      T00135_A301MegHabilitado = new boolean[] {false} ;
      T00135_A302MegRes551 = new String[] {""} ;
      T00135_n302MegRes551 = new boolean[] {false} ;
      T00135_A1990MegRelSec = new int[1] ;
      T00135_A1991MegRelSecCli = new int[1] ;
      T00135_A1992MegPadre = new String[] {""} ;
      T00135_A2017MegRelRef = new String[] {""} ;
      T00135_A2029MegOld = new String[] {""} ;
      T00135_A3CliCod = new int[1] ;
      T001316_A3CliCod = new int[1] ;
      T001316_A1EmpCod = new short[1] ;
      T001316_A6LegNumero = new int[1] ;
      T001316_A2253LegHisFecIng = new java.util.Date[] {GXutil.nullDate()} ;
      T001317_A3CliCod = new int[1] ;
      T001317_A26ConCodigo = new String[] {""} ;
      T001317_A11MegCodigo = new String[] {""} ;
      T001317_A2077ConMegSec = new short[1] ;
      T001318_A3CliCod = new int[1] ;
      T001318_A11MegCodigo = new String[] {""} ;
      T001318_A1525MegTipo = new String[] {""} ;
      T001319_A3CliCod = new int[1] ;
      T001319_A1EmpCod = new short[1] ;
      T001319_A6LegNumero = new int[1] ;
      T001320_A3CliCod = new int[1] ;
      T001320_A11MegCodigo = new String[] {""} ;
      Z2030MegSitOld = "" ;
      Z1604MegSitRevDescrip = "" ;
      T00134_A1604MegSitRevDescrip = new String[] {""} ;
      T001321_A3CliCod = new int[1] ;
      T001321_A11MegCodigo = new String[] {""} ;
      T001321_A1604MegSitRevDescrip = new String[] {""} ;
      T001321_A1606MegSitRevDef = new boolean[] {false} ;
      T001321_A1993MegSitRelSec = new int[1] ;
      T001321_A1994MegSitRelSecCli = new int[1] ;
      T001321_A1995MegSitPadre = new short[1] ;
      T001321_A2018MegSitRelRef = new String[] {""} ;
      T001321_A2030MegSitOld = new String[] {""} ;
      T001321_A1601MegSitRevista = new short[1] ;
      T001322_A1604MegSitRevDescrip = new String[] {""} ;
      T001323_A3CliCod = new int[1] ;
      T001323_A11MegCodigo = new String[] {""} ;
      T001323_A1601MegSitRevista = new short[1] ;
      T00133_A3CliCod = new int[1] ;
      T00133_A11MegCodigo = new String[] {""} ;
      T00133_A1606MegSitRevDef = new boolean[] {false} ;
      T00133_A1993MegSitRelSec = new int[1] ;
      T00133_A1994MegSitRelSecCli = new int[1] ;
      T00133_A1995MegSitPadre = new short[1] ;
      T00133_A2018MegSitRelRef = new String[] {""} ;
      T00133_A2030MegSitOld = new String[] {""} ;
      T00133_A1601MegSitRevista = new short[1] ;
      T00132_A3CliCod = new int[1] ;
      T00132_A11MegCodigo = new String[] {""} ;
      T00132_A1606MegSitRevDef = new boolean[] {false} ;
      T00132_A1993MegSitRelSec = new int[1] ;
      T00132_A1994MegSitRelSecCli = new int[1] ;
      T00132_A1995MegSitPadre = new short[1] ;
      T00132_A2018MegSitRelRef = new String[] {""} ;
      T00132_A2030MegSitOld = new String[] {""} ;
      T00132_A1601MegSitRevista = new short[1] ;
      T001327_A1604MegSitRevDescrip = new String[] {""} ;
      T001328_A3CliCod = new int[1] ;
      T001328_A11MegCodigo = new String[] {""} ;
      T001328_A1601MegSitRevista = new short[1] ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T001329_A3CliCod = new int[1] ;
      T001329_A1885CliRelSec = new int[1] ;
      T001329_A1880CliReDTChar = new String[] {""} ;
      T001330_A1601MegSitRevista = new short[1] ;
      T001330_A1604MegSitRevDescrip = new String[] {""} ;
      T001330_A1597SitRevEsBaja = new boolean[] {false} ;
      T001330_n1597SitRevEsBaja = new boolean[] {false} ;
      GXv_int5 = new int[1] ;
      T001331_A3CliCod = new int[1] ;
      T001332_A1604MegSitRevDescrip = new String[] {""} ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegreso__default(),
         new Object[] {
             new Object[] {
            T00132_A3CliCod, T00132_A11MegCodigo, T00132_A1606MegSitRevDef, T00132_A1993MegSitRelSec, T00132_A1994MegSitRelSecCli, T00132_A1995MegSitPadre, T00132_A2018MegSitRelRef, T00132_A2030MegSitOld, T00132_A1601MegSitRevista
            }
            , new Object[] {
            T00133_A3CliCod, T00133_A11MegCodigo, T00133_A1606MegSitRevDef, T00133_A1993MegSitRelSec, T00133_A1994MegSitRelSecCli, T00133_A1995MegSitPadre, T00133_A2018MegSitRelRef, T00133_A2030MegSitOld, T00133_A1601MegSitRevista
            }
            , new Object[] {
            T00134_A1604MegSitRevDescrip
            }
            , new Object[] {
            T00135_A11MegCodigo, T00135_A300MegDescrip, T00135_A301MegHabilitado, T00135_A302MegRes551, T00135_n302MegRes551, T00135_A1990MegRelSec, T00135_A1991MegRelSecCli, T00135_A1992MegPadre, T00135_A2017MegRelRef, T00135_A2029MegOld,
            T00135_A3CliCod
            }
            , new Object[] {
            T00136_A11MegCodigo, T00136_A300MegDescrip, T00136_A301MegHabilitado, T00136_A302MegRes551, T00136_n302MegRes551, T00136_A1990MegRelSec, T00136_A1991MegRelSecCli, T00136_A1992MegPadre, T00136_A2017MegRelRef, T00136_A2029MegOld,
            T00136_A3CliCod
            }
            , new Object[] {
            T00137_A3CliCod
            }
            , new Object[] {
            T00138_A11MegCodigo, T00138_A300MegDescrip, T00138_A301MegHabilitado, T00138_A302MegRes551, T00138_n302MegRes551, T00138_A1990MegRelSec, T00138_A1991MegRelSecCli, T00138_A1992MegPadre, T00138_A2017MegRelRef, T00138_A2029MegOld,
            T00138_A3CliCod
            }
            , new Object[] {
            T00139_A3CliCod
            }
            , new Object[] {
            T001310_A3CliCod, T001310_A11MegCodigo
            }
            , new Object[] {
            T001311_A3CliCod, T001311_A11MegCodigo
            }
            , new Object[] {
            T001312_A3CliCod, T001312_A11MegCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001316_A3CliCod, T001316_A1EmpCod, T001316_A6LegNumero, T001316_A2253LegHisFecIng
            }
            , new Object[] {
            T001317_A3CliCod, T001317_A26ConCodigo, T001317_A11MegCodigo, T001317_A2077ConMegSec
            }
            , new Object[] {
            T001318_A3CliCod, T001318_A11MegCodigo, T001318_A1525MegTipo
            }
            , new Object[] {
            T001319_A3CliCod, T001319_A1EmpCod, T001319_A6LegNumero
            }
            , new Object[] {
            T001320_A3CliCod, T001320_A11MegCodigo
            }
            , new Object[] {
            T001321_A3CliCod, T001321_A11MegCodigo, T001321_A1604MegSitRevDescrip, T001321_A1606MegSitRevDef, T001321_A1993MegSitRelSec, T001321_A1994MegSitRelSecCli, T001321_A1995MegSitPadre, T001321_A2018MegSitRelRef, T001321_A2030MegSitOld, T001321_A1601MegSitRevista
            }
            , new Object[] {
            T001322_A1604MegSitRevDescrip
            }
            , new Object[] {
            T001323_A3CliCod, T001323_A11MegCodigo, T001323_A1601MegSitRevista
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001327_A1604MegSitRevDescrip
            }
            , new Object[] {
            T001328_A3CliCod, T001328_A11MegCodigo, T001328_A1601MegSitRevista
            }
            , new Object[] {
            T001329_A3CliCod, T001329_A1885CliRelSec, T001329_A1880CliReDTChar
            }
            , new Object[] {
            T001330_A1601MegSitRevista, T001330_A1604MegSitRevDescrip, T001330_A1597SitRevEsBaja, T001330_n1597SitRevEsBaja
            }
            , new Object[] {
            T001331_A3CliCod
            }
            , new Object[] {
            T001332_A1604MegSitRevDescrip
            }
         }
      );
      AV16Pgmname = "MotivoEgreso" ;
      Z301MegHabilitado = true ;
      A301MegHabilitado = true ;
      i301MegHabilitado = true ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short Z1601MegSitRevista ;
   private short Z1995MegSitPadre ;
   private short O1601MegSitRevista ;
   private short nRcdDeleted_220 ;
   private short nRcdExists_220 ;
   private short nIsMod_220 ;
   private short A1601MegSitRevista ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount220 ;
   private short RcdFound220 ;
   private short nBlankRcdUsr220 ;
   private short A1995MegSitPadre ;
   private short RcdFound36 ;
   private short T1601MegSitRevista ;
   private short nIsDirty_36 ;
   private short nIsDirty_220 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1990MegRelSec ;
   private int Z1991MegRelSecCli ;
   private int nRC_GXsfl_40 ;
   private int nGXsfl_40_idx=1 ;
   private int Z1993MegSitRelSec ;
   private int Z1994MegSitRelSecCli ;
   private int AV7CliCod ;
   private int A1990MegRelSec ;
   private int A1993MegSitRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtMegCodigo_Enabled ;
   private int edtMegDescrip_Enabled ;
   private int edtMegSitRelSec_Enabled ;
   private int edtMegSitRelSec_Visible ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1991MegRelSecCli ;
   private int A1994MegSitRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Dvpanel_sitrev_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defdynMegSitRevista_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8MegCodigo ;
   private String Z11MegCodigo ;
   private String Z302MegRes551 ;
   private String Z1992MegPadre ;
   private String O11MegCodigo ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV8MegCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMegCodigo_Internalname ;
   private String sGXsfl_40_idx="0001" ;
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
   private String A11MegCodigo ;
   private String edtMegCodigo_Jsonclick ;
   private String edtMegDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divMegrelsec_cell_Internalname ;
   private String divMegrelsec_cell_Class ;
   private String Dvpanel_sitrev_Width ;
   private String Dvpanel_sitrev_Cls ;
   private String Dvpanel_sitrev_Title ;
   private String Dvpanel_sitrev_Iconposition ;
   private String Dvpanel_sitrev_Internalname ;
   private String divSitrev_Internalname ;
   private String B11MegCodigo ;
   private String sMode220 ;
   private String edtMegSitRelSec_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A302MegRes551 ;
   private String A1992MegPadre ;
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Dvpanel_sitrev_Objectcall ;
   private String Dvpanel_sitrev_Class ;
   private String Dvpanel_sitrev_Height ;
   private String hsh ;
   private String sMode36 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_40_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtMegSitRelSec_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String gxwrpcisep ;
   private boolean Z301MegHabilitado ;
   private boolean Z1606MegSitRevDef ;
   private boolean O1606MegSitRevDef ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_sitrev_Autowidth ;
   private boolean Dvpanel_sitrev_Autoheight ;
   private boolean Dvpanel_sitrev_Collapsible ;
   private boolean Dvpanel_sitrev_Collapsed ;
   private boolean Dvpanel_sitrev_Showcollapseicon ;
   private boolean Dvpanel_sitrev_Autoscroll ;
   private boolean bGXsfl_40_Refreshing=false ;
   private boolean n302MegRes551 ;
   private boolean A301MegHabilitado ;
   private boolean AV14aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Dvpanel_sitrev_Enabled ;
   private boolean Dvpanel_sitrev_Showheader ;
   private boolean Dvpanel_sitrev_Visible ;
   private boolean A1606MegSitRevDef ;
   private boolean T1606MegSitRevDef ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Gx_longc ;
   private boolean i301MegHabilitado ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean ZV14aplicadoHay ;
   private boolean GXv_boolean3[] ;
   private String A2029MegOld ;
   private String A2030MegSitOld ;
   private String Z2029MegOld ;
   private String Z2030MegSitOld ;
   private String Z300MegDescrip ;
   private String Z2017MegRelRef ;
   private String O300MegDescrip ;
   private String Z2018MegSitRelRef ;
   private String A300MegDescrip ;
   private String B300MegDescrip ;
   private String A2017MegRelRef ;
   private String A2018MegSitRelRef ;
   private String A1604MegSitRevDescrip ;
   private String Z1604MegSitRevDescrip ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_sitrev ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynMegRelSec ;
   private HTMLChoice dynMegSitRevista ;
   private ICheckbox chkMegSitRevDef ;
   private IDataStoreProvider pr_default ;
   private String[] T00138_A11MegCodigo ;
   private String[] T00138_A300MegDescrip ;
   private boolean[] T00138_A301MegHabilitado ;
   private String[] T00138_A302MegRes551 ;
   private boolean[] T00138_n302MegRes551 ;
   private int[] T00138_A1990MegRelSec ;
   private int[] T00138_A1991MegRelSecCli ;
   private String[] T00138_A1992MegPadre ;
   private String[] T00138_A2017MegRelRef ;
   private String[] T00138_A2029MegOld ;
   private int[] T00138_A3CliCod ;
   private int[] T00137_A3CliCod ;
   private int[] T00139_A3CliCod ;
   private int[] T001310_A3CliCod ;
   private String[] T001310_A11MegCodigo ;
   private String[] T00136_A11MegCodigo ;
   private String[] T00136_A300MegDescrip ;
   private boolean[] T00136_A301MegHabilitado ;
   private String[] T00136_A302MegRes551 ;
   private boolean[] T00136_n302MegRes551 ;
   private int[] T00136_A1990MegRelSec ;
   private int[] T00136_A1991MegRelSecCli ;
   private String[] T00136_A1992MegPadre ;
   private String[] T00136_A2017MegRelRef ;
   private String[] T00136_A2029MegOld ;
   private int[] T00136_A3CliCod ;
   private int[] T001311_A3CliCod ;
   private String[] T001311_A11MegCodigo ;
   private int[] T001312_A3CliCod ;
   private String[] T001312_A11MegCodigo ;
   private String[] T00135_A11MegCodigo ;
   private String[] T00135_A300MegDescrip ;
   private boolean[] T00135_A301MegHabilitado ;
   private String[] T00135_A302MegRes551 ;
   private boolean[] T00135_n302MegRes551 ;
   private int[] T00135_A1990MegRelSec ;
   private int[] T00135_A1991MegRelSecCli ;
   private String[] T00135_A1992MegPadre ;
   private String[] T00135_A2017MegRelRef ;
   private String[] T00135_A2029MegOld ;
   private int[] T00135_A3CliCod ;
   private int[] T001316_A3CliCod ;
   private short[] T001316_A1EmpCod ;
   private int[] T001316_A6LegNumero ;
   private java.util.Date[] T001316_A2253LegHisFecIng ;
   private int[] T001317_A3CliCod ;
   private String[] T001317_A26ConCodigo ;
   private String[] T001317_A11MegCodigo ;
   private short[] T001317_A2077ConMegSec ;
   private int[] T001318_A3CliCod ;
   private String[] T001318_A11MegCodigo ;
   private String[] T001318_A1525MegTipo ;
   private int[] T001319_A3CliCod ;
   private short[] T001319_A1EmpCod ;
   private int[] T001319_A6LegNumero ;
   private int[] T001320_A3CliCod ;
   private String[] T001320_A11MegCodigo ;
   private String[] T00134_A1604MegSitRevDescrip ;
   private int[] T001321_A3CliCod ;
   private String[] T001321_A11MegCodigo ;
   private String[] T001321_A1604MegSitRevDescrip ;
   private boolean[] T001321_A1606MegSitRevDef ;
   private int[] T001321_A1993MegSitRelSec ;
   private int[] T001321_A1994MegSitRelSecCli ;
   private short[] T001321_A1995MegSitPadre ;
   private String[] T001321_A2018MegSitRelRef ;
   private String[] T001321_A2030MegSitOld ;
   private short[] T001321_A1601MegSitRevista ;
   private String[] T001322_A1604MegSitRevDescrip ;
   private int[] T001323_A3CliCod ;
   private String[] T001323_A11MegCodigo ;
   private short[] T001323_A1601MegSitRevista ;
   private int[] T00133_A3CliCod ;
   private String[] T00133_A11MegCodigo ;
   private boolean[] T00133_A1606MegSitRevDef ;
   private int[] T00133_A1993MegSitRelSec ;
   private int[] T00133_A1994MegSitRelSecCli ;
   private short[] T00133_A1995MegSitPadre ;
   private String[] T00133_A2018MegSitRelRef ;
   private String[] T00133_A2030MegSitOld ;
   private short[] T00133_A1601MegSitRevista ;
   private int[] T00132_A3CliCod ;
   private String[] T00132_A11MegCodigo ;
   private boolean[] T00132_A1606MegSitRevDef ;
   private int[] T00132_A1993MegSitRelSec ;
   private int[] T00132_A1994MegSitRelSecCli ;
   private short[] T00132_A1995MegSitPadre ;
   private String[] T00132_A2018MegSitRelRef ;
   private String[] T00132_A2030MegSitOld ;
   private short[] T00132_A1601MegSitRevista ;
   private String[] T001327_A1604MegSitRevDescrip ;
   private int[] T001328_A3CliCod ;
   private String[] T001328_A11MegCodigo ;
   private short[] T001328_A1601MegSitRevista ;
   private int[] T001329_A3CliCod ;
   private int[] T001329_A1885CliRelSec ;
   private String[] T001329_A1880CliReDTChar ;
   private short[] T001330_A1601MegSitRevista ;
   private String[] T001330_A1604MegSitRevDescrip ;
   private boolean[] T001330_A1597SitRevEsBaja ;
   private boolean[] T001330_n1597SitRevEsBaja ;
   private int[] T001331_A3CliCod ;
   private String[] T001332_A1604MegSitRevDescrip ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class motivoegreso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00132", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?  FOR UPDATE OF MotivoEgresoRevistaAfip NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00133", "SELECT CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00134", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00135", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ?  FOR UPDATE OF MotivoEgreso NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00136", "SELECT MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00137", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00138", "SELECT TM1.MegCodigo, TM1.MegDescrip, TM1.MegHabilitado, TM1.MegRes551, TM1.MegRelSec, TM1.MegRelSecCli, TM1.MegPadre, TM1.MegRelRef, TM1.MegOld, TM1.CliCod FROM MotivoEgreso TM1 WHERE TM1.CliCod = ? and TM1.MegCodigo = ( ?) ORDER BY TM1.CliCod, TM1.MegCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00139", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001310", "SELECT CliCod, MegCodigo FROM MotivoEgreso WHERE CliCod = ? AND MegCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001311", "SELECT CliCod, MegCodigo FROM MotivoEgreso WHERE ( CliCod > ? or CliCod = ? and MegCodigo > ( ?)) ORDER BY CliCod, MegCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001312", "SELECT CliCod, MegCodigo FROM MotivoEgreso WHERE ( CliCod < ? or CliCod = ? and MegCodigo < ( ?)) ORDER BY CliCod DESC, MegCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001313", "SAVEPOINT gxupdate;INSERT INTO MotivoEgreso(MegCodigo, MegDescrip, MegHabilitado, MegRes551, MegRelSec, MegRelSecCli, MegPadre, MegRelRef, MegOld, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001314", "SAVEPOINT gxupdate;UPDATE MotivoEgreso SET MegDescrip=?, MegHabilitado=?, MegRes551=?, MegRelSec=?, MegRelSecCli=?, MegPadre=?, MegRelRef=?, MegOld=?  WHERE CliCod = ? AND MegCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001315", "SAVEPOINT gxupdate;DELETE FROM MotivoEgreso  WHERE CliCod = ? AND MegCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001316", "SELECT CliCod, EmpCod, LegNumero, LegHisFecIng FROM legajo_permanencia WHERE CliCod = ? AND LegHisMotCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001317", "SELECT CliCod, ConCodigo, MegCodigo, ConMegSec FROM ConceptoMotivosEgreso WHERE CliCod = ? AND MegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001318", "SELECT CliCod, MegCodigo, MegTipo FROM MotivoEgresoTipos WHERE CliCod = ? AND MegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001319", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegMegCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001320", "SELECT CliCod, MegCodigo FROM MotivoEgreso ORDER BY CliCod, MegCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001321", "SELECT T1.CliCod, T1.MegCodigo, T2.SitRevDescrip AS MegSitRevDescrip, T1.MegSitRevDef, T1.MegSitRelSec, T1.MegSitRelSecCli, T1.MegSitPadre, T1.MegSitRelRef, T1.MegSitOld, T1.MegSitRevista AS MegSitRevista FROM (MotivoEgresoRevistaAfip T1 INNER JOIN SituacionRevistaAFIP T2 ON T2.SitRevCodigo = T1.MegSitRevista) WHERE T1.CliCod = ? and T1.MegCodigo = ( ?) and T1.MegSitRevista = ? ORDER BY T1.CliCod, T1.MegCodigo, T1.MegSitRevista ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001322", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001323", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T001324", "SAVEPOINT gxupdate;INSERT INTO MotivoEgresoRevistaAfip(CliCod, MegCodigo, MegSitRevDef, MegSitRelSec, MegSitRelSecCli, MegSitPadre, MegSitRelRef, MegSitOld, MegSitRevista) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001325", "SAVEPOINT gxupdate;UPDATE MotivoEgresoRevistaAfip SET MegSitRevDef=?, MegSitRelSec=?, MegSitRelSecCli=?, MegSitPadre=?, MegSitRelRef=?, MegSitOld=?  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001326", "SAVEPOINT gxupdate;DELETE FROM MotivoEgresoRevistaAfip  WHERE CliCod = ? AND MegCodigo = ? AND MegSitRevista = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001327", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001328", "SELECT CliCod, MegCodigo, MegSitRevista FROM MotivoEgresoRevistaAfip WHERE CliCod = ? and MegCodigo = ( ?) ORDER BY CliCod, MegCodigo, MegSitRevista ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001329", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001330", "SELECT SitRevCodigo AS MegSitRevista, SitRevDescrip AS MegSitRevDescrip, SitRevEsBaja FROM SituacionRevistaAFIP WHERE SitRevEsBaja = TRUE ORDER BY SitRevDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001331", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001332", "SELECT SitRevDescrip AS MegSitRevDescrip FROM SituacionRevistaAFIP WHERE SitRevCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 20 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 25 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 26 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 27 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 28 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 11 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 20);
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 20);
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               stmt.setInt(10, ((Number) parms[10]).intValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setBoolean(2, ((Boolean) parms[1]).booleanValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(3, (String)parms[3], 20);
               }
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setString(6, (String)parms[6], 20);
               stmt.setVarchar(7, (String)parms[7], 40, false);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               stmt.setInt(9, ((Number) parms[9]).intValue());
               stmt.setString(10, (String)parms[10], 20);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 23 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setNLongVarchar(6, (String)parms[5], false);
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 27 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

