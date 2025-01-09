package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class banco_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action17") == 0 )
      {
         Gx_mode = httpContext.GetPar( "Mode") ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         A1978BanRelSec = (int)(GXutil.lval( httpContext.GetPar( "BanRelSec"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_17_074( Gx_mode, AV7CliCod, A1978BanRelSec) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"BANRELSEC") == 0 )
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
         gxdlabanrelsec074( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"BANDESCRIPSINAC") == 0 )
      {
         A117BanDescrip = httpContext.GetPar( "BanDescrip") ;
         httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asabandescripsinac074( A117BanDescrip) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLICOD") == 0 )
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
         gx2asaclicod074( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel8"+"_"+"") == 0 )
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
         gxasa1978074( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A3CliCod) ;
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
            AV8BanCod = httpContext.GetPar( "BanCod") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8BanCod", AV8BanCod);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBANCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8BanCod, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Banco", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public banco_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public banco_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( banco_impl.class ));
   }

   public banco_impl( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      chkBanHabilitado = UIFactory.getCheckbox(this);
      dynBanRelSec = new HTMLChoice();
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
      A118BanHabilitado = GXutil.strtobool( GXutil.booltostr( A118BanHabilitado)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
      if ( dynBanRelSec.getItemCount() > 0 )
      {
         A1978BanRelSec = (int)(GXutil.lval( dynBanRelSec.getValidValue(GXutil.trim( GXutil.str( A1978BanRelSec, 6, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynBanRelSec.setValue( GXutil.trim( GXutil.str( A1978BanRelSec, 6, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, dynBanRelSec.getInternalname(), "Values", dynBanRelSec.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtBanCod_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtBanCod_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtBanCod_Internalname, GXutil.rtrim( A7BanCod), GXutil.rtrim( localUtil.format( A7BanCod, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtBanCod_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtBanCod_Enabled, 1, "text", "", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Banco.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtBanDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtBanDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtBanDescrip_Internalname, A117BanDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtBanDescrip_Enabled, 1, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Banco.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkBanHabilitado.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkBanHabilitado.getInternalname(), httpContext.getMessage( "Habilitado", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkBanHabilitado.getInternalname(), GXutil.booltostr( A118BanHabilitado), "", httpContext.getMessage( "Habilitado", ""), 1, chkBanHabilitado.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(32, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,32);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divBanrelsec_cell_Internalname, 1, 0, "px", 0, "px", divBanrelsec_cell_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", dynBanRelSec.getVisible(), 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynBanRelSec.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynBanRelSec.getInternalname(), httpContext.getMessage( "Liberación", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynBanRelSec, dynBanRelSec.getInternalname(), GXutil.trim( GXutil.str( A1978BanRelSec, 6, 0)), 1, dynBanRelSec.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", dynBanRelSec.getVisible(), dynBanRelSec.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_Banco.htm");
      dynBanRelSec.setValue( GXutil.trim( GXutil.str( A1978BanRelSec, 6, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, dynBanRelSec.getInternalname(), "Values", dynBanRelSec.ToJavascriptSource(), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 45,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Banco.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Banco.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Banco.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 53,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,53);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Banco.htm");
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
      e11072 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z7BanCod = httpContext.cgiGet( "Z7BanCod") ;
            Z679BanDescripSinAc = httpContext.cgiGet( "Z679BanDescripSinAc") ;
            Z117BanDescrip = httpContext.cgiGet( "Z117BanDescrip") ;
            Z118BanHabilitado = GXutil.strtobool( httpContext.cgiGet( "Z118BanHabilitado")) ;
            Z116BanCUIT = httpContext.cgiGet( "Z116BanCUIT") ;
            n116BanCUIT = ((GXutil.strcmp("", A116BanCUIT)==0) ? true : false) ;
            Z1978BanRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "Z1978BanRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1979BanRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1979BanRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1980BancodPadre = httpContext.cgiGet( "Z1980BancodPadre") ;
            Z2012BancoRelRef = httpContext.cgiGet( "Z2012BancoRelRef") ;
            A679BanDescripSinAc = httpContext.cgiGet( "Z679BanDescripSinAc") ;
            A116BanCUIT = httpContext.cgiGet( "Z116BanCUIT") ;
            n116BanCUIT = false ;
            n116BanCUIT = ((GXutil.strcmp("", A116BanCUIT)==0) ? true : false) ;
            A1979BanRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "Z1979BanRelSecCli"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1980BancodPadre = httpContext.cgiGet( "Z1980BancodPadre") ;
            A2012BancoRelRef = httpContext.cgiGet( "Z2012BancoRelRef") ;
            O118BanHabilitado = GXutil.strtobool( httpContext.cgiGet( "O118BanHabilitado")) ;
            O117BanDescrip = httpContext.cgiGet( "O117BanDescrip") ;
            O7BanCod = httpContext.cgiGet( "O7BanCod") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N117BanDescrip = httpContext.cgiGet( "N117BanDescrip") ;
            A679BanDescripSinAc = httpContext.cgiGet( "BANDESCRIPSINAC") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8BanCod = httpContext.cgiGet( "vBANCOD") ;
            A1980BancodPadre = httpContext.cgiGet( "BANCODPADRE") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV21aplicadoHay = GXutil.strtobool( httpContext.cgiGet( "vAPLICADOHAY")) ;
            A116BanCUIT = httpContext.cgiGet( "BANCUIT") ;
            n116BanCUIT = ((GXutil.strcmp("", A116BanCUIT)==0) ? true : false) ;
            A1979BanRelSecCli = (int)(localUtil.ctol( httpContext.cgiGet( "BANRELSECCLI"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2012BancoRelRef = httpContext.cgiGet( "BANCORELREF") ;
            A2024BancoOld = httpContext.cgiGet( "BANCOOLD") ;
            AV23Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A7BanCod = httpContext.cgiGet( edtBanCod_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
            A117BanDescrip = httpContext.cgiGet( edtBanDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
            A118BanHabilitado = GXutil.strtobool( httpContext.cgiGet( chkBanHabilitado.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
            dynBanRelSec.setValue( httpContext.cgiGet( dynBanRelSec.getInternalname()) );
            A1978BanRelSec = (int)(GXutil.lval( httpContext.cgiGet( dynBanRelSec.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
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
            forbiddenHiddens.add("hshsalt", "hsh"+"Banco");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("BanCUIT", GXutil.rtrim( localUtil.format( A116BanCUIT, "")));
            forbiddenHiddens.add("BanRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1979BanRelSecCli), "ZZZZZ9"));
            forbiddenHiddens.add("BancodPadre", GXutil.rtrim( localUtil.format( A1980BancodPadre, "")));
            forbiddenHiddens.add("BancoRelRef", GXutil.rtrim( localUtil.format( A2012BancoRelRef, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A7BanCod, Z7BanCod) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("banco:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A7BanCod = httpContext.GetPar( "BanCod") ;
               httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
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
                  sMode4 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode4 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound4 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_070( ) ;
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
                        e11072 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12072 ();
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
         e12072 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll074( ) ;
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
         disableAttributes074( ) ;
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

   public void confirm_070( )
   {
      beforeValidate074( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls074( ) ;
         }
         else
         {
            checkExtendedTable074( ) ;
            closeExtendedTableCursors074( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption070( )
   {
   }

   public void e11072( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWBanco_Insert", GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWBanco_Update", GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWBanco_Delete", GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV23Pgmname))}, new String[] {"GxObject"}) );
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
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "start", "")) ;
   }

   public void e12072( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.bancograbarrelref(remoteHandle, context).execute( A3CliCod) ;
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
      divBanrelsec_cell_Class = "col-xs-12 DataContentCell" ;
      httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
   }

   public void zm074( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z679BanDescripSinAc = T00073_A679BanDescripSinAc[0] ;
            Z117BanDescrip = T00073_A117BanDescrip[0] ;
            Z118BanHabilitado = T00073_A118BanHabilitado[0] ;
            Z116BanCUIT = T00073_A116BanCUIT[0] ;
            Z1978BanRelSec = T00073_A1978BanRelSec[0] ;
            Z1979BanRelSecCli = T00073_A1979BanRelSecCli[0] ;
            Z1980BancodPadre = T00073_A1980BancodPadre[0] ;
            Z2012BancoRelRef = T00073_A2012BancoRelRef[0] ;
         }
         else
         {
            Z679BanDescripSinAc = A679BanDescripSinAc ;
            Z117BanDescrip = A117BanDescrip ;
            Z118BanHabilitado = A118BanHabilitado ;
            Z116BanCUIT = A116BanCUIT ;
            Z1978BanRelSec = A1978BanRelSec ;
            Z1979BanRelSecCli = A1979BanRelSecCli ;
            Z1980BancodPadre = A1980BancodPadre ;
            Z2012BancoRelRef = A2012BancoRelRef ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z679BanDescripSinAc = A679BanDescripSinAc ;
         Z7BanCod = A7BanCod ;
         Z117BanDescrip = A117BanDescrip ;
         Z118BanHabilitado = A118BanHabilitado ;
         Z116BanCUIT = A116BanCUIT ;
         Z1978BanRelSec = A1978BanRelSec ;
         Z1979BanRelSecCli = A1979BanRelSecCli ;
         Z1980BancodPadre = A1980BancodPadre ;
         Z2012BancoRelRef = A2012BancoRelRef ;
         Z2024BancoOld = A2024BancoOld ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxabanrelsec_html074( AV7CliCod) ;
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
            banco_impl.this.GXt_int4 = GXv_int5[0] ;
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
      banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynBanRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynBanRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynBanRelSec.getVisible(), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8BanCod)==0) )
      {
         A7BanCod = AV8BanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
      }
      if ( ! (GXutil.strcmp("", AV8BanCod)==0) )
      {
         edtBanCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanCod_Enabled), 5, 0), true);
      }
      else
      {
         edtBanCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8BanCod)==0) )
      {
         edtBanCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanCod_Enabled), 5, 0), true);
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
      if ( isIns( )  && (false==A118BanHabilitado) && ( Gx_BScreen == 0 ) )
      {
         A118BanHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV23Pgmname = "Banco" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      }
   }

   public void load074( )
   {
      /* Using cursor T00075 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A679BanDescripSinAc = T00075_A679BanDescripSinAc[0] ;
         A117BanDescrip = T00075_A117BanDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
         A118BanHabilitado = T00075_A118BanHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
         A116BanCUIT = T00075_A116BanCUIT[0] ;
         n116BanCUIT = T00075_n116BanCUIT[0] ;
         A1978BanRelSec = T00075_A1978BanRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
         A1979BanRelSecCli = T00075_A1979BanRelSecCli[0] ;
         A1980BancodPadre = T00075_A1980BancodPadre[0] ;
         A2012BancoRelRef = T00075_A2012BancoRelRef[0] ;
         A2024BancoOld = T00075_A2024BancoOld[0] ;
         zm074( -19) ;
      }
      pr_default.close(3);
      onLoadActions074( ) ;
   }

   public void onLoadActions074( )
   {
      AV23Pgmname = "Banco" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) )
      {
         divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) )
         {
            divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
         }
      }
      GXt_char6 = A679BanDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char7) ;
      banco_impl.this.GXt_char6 = GXv_char7[0] ;
      A679BanDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A679BanDescripSinAc", A679BanDescripSinAc);
      if ( ! (GXutil.strcmp("", A1980BancodPadre)==0) )
      {
         edtBanDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtBanDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
      }
   }

   public void checkExtendedTable074( )
   {
      nIsDirty_4 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV23Pgmname = "Banco" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV21aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1978BanRelSec, GXv_boolean3) ;
         banco_impl.this.AV21aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21aplicadoHay", AV21aplicadoHay);
      }
      /* Using cursor T00074 */
      pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) )
      {
         divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
         httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) )
         {
            divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
         }
      }
      if ( (GXutil.strcmp("", A7BanCod)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Banco", ""), "", "", "", "", "", "", "", ""), 1, "BANCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) && (0==A1978BanRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "BANCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_4 = (short)(1) ;
      GXt_char6 = A679BanDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char7) ;
      banco_impl.this.GXt_char6 = GXv_char7[0] ;
      A679BanDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A679BanDescripSinAc", A679BanDescripSinAc);
      if ( (GXutil.strcmp("", A117BanDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Banco", ""), "", "", "", "", "", "", "", ""), 1, "BANDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (GXutil.strcmp("", A1980BancodPadre)==0) )
      {
         edtBanDescrip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
      }
      else
      {
         edtBanDescrip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
      }
   }

   public void closeExtendedTableCursors074( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_20( int A3CliCod )
   {
      /* Using cursor T00076 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
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

   public void getKey074( )
   {
      /* Using cursor T00077 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound4 = (short)(1) ;
      }
      else
      {
         RcdFound4 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00073 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm074( 19) ;
         RcdFound4 = (short)(1) ;
         A679BanDescripSinAc = T00073_A679BanDescripSinAc[0] ;
         A7BanCod = T00073_A7BanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
         A117BanDescrip = T00073_A117BanDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
         A118BanHabilitado = T00073_A118BanHabilitado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
         A116BanCUIT = T00073_A116BanCUIT[0] ;
         n116BanCUIT = T00073_n116BanCUIT[0] ;
         A1978BanRelSec = T00073_A1978BanRelSec[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
         A1979BanRelSecCli = T00073_A1979BanRelSecCli[0] ;
         A1980BancodPadre = T00073_A1980BancodPadre[0] ;
         A2012BancoRelRef = T00073_A2012BancoRelRef[0] ;
         A2024BancoOld = T00073_A2024BancoOld[0] ;
         A3CliCod = T00073_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         O118BanHabilitado = A118BanHabilitado ;
         httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
         O117BanDescrip = A117BanDescrip ;
         httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
         O7BanCod = A7BanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
         Z3CliCod = A3CliCod ;
         Z7BanCod = A7BanCod ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load074( ) ;
         if ( AnyError == 1 )
         {
            RcdFound4 = (short)(0) ;
            initializeNonKey074( ) ;
         }
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound4 = (short)(0) ;
         initializeNonKey074( ) ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey074( ) ;
      if ( RcdFound4 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00078 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A7BanCod});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00078_A3CliCod[0] < A3CliCod ) || ( T00078_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00078_A7BanCod[0], A7BanCod) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00078_A3CliCod[0] > A3CliCod ) || ( T00078_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00078_A7BanCod[0], A7BanCod) > 0 ) ) )
         {
            A3CliCod = T00078_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A7BanCod = T00078_A7BanCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00079 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), A7BanCod});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00079_A3CliCod[0] > A3CliCod ) || ( T00079_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00079_A7BanCod[0], A7BanCod) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00079_A3CliCod[0] < A3CliCod ) || ( T00079_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T00079_A7BanCod[0], A7BanCod) < 0 ) ) )
         {
            A3CliCod = T00079_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A7BanCod = T00079_A7BanCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey074( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert074( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound4 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A7BanCod, Z7BanCod) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A7BanCod = Z7BanCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update074( ) ;
               GX_FocusControl = edtBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A7BanCod, Z7BanCod) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtBanCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert074( ) ;
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
                  GX_FocusControl = edtBanCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert074( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( GXutil.strcmp(A7BanCod, Z7BanCod) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A7BanCod = Z7BanCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtBanCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency074( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00072 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Banco"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z679BanDescripSinAc, T00072_A679BanDescripSinAc[0]) != 0 ) || ( GXutil.strcmp(Z117BanDescrip, T00072_A117BanDescrip[0]) != 0 ) || ( Z118BanHabilitado != T00072_A118BanHabilitado[0] ) || ( GXutil.strcmp(Z116BanCUIT, T00072_A116BanCUIT[0]) != 0 ) || ( Z1978BanRelSec != T00072_A1978BanRelSec[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1979BanRelSecCli != T00072_A1979BanRelSecCli[0] ) || ( GXutil.strcmp(Z1980BancodPadre, T00072_A1980BancodPadre[0]) != 0 ) || ( GXutil.strcmp(Z2012BancoRelRef, T00072_A2012BancoRelRef[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z679BanDescripSinAc, T00072_A679BanDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z679BanDescripSinAc);
               GXutil.writeLogRaw("Current: ",T00072_A679BanDescripSinAc[0]);
            }
            if ( GXutil.strcmp(Z117BanDescrip, T00072_A117BanDescrip[0]) != 0 )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanDescrip");
               GXutil.writeLogRaw("Old: ",Z117BanDescrip);
               GXutil.writeLogRaw("Current: ",T00072_A117BanDescrip[0]);
            }
            if ( Z118BanHabilitado != T00072_A118BanHabilitado[0] )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanHabilitado");
               GXutil.writeLogRaw("Old: ",Z118BanHabilitado);
               GXutil.writeLogRaw("Current: ",T00072_A118BanHabilitado[0]);
            }
            if ( GXutil.strcmp(Z116BanCUIT, T00072_A116BanCUIT[0]) != 0 )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanCUIT");
               GXutil.writeLogRaw("Old: ",Z116BanCUIT);
               GXutil.writeLogRaw("Current: ",T00072_A116BanCUIT[0]);
            }
            if ( Z1978BanRelSec != T00072_A1978BanRelSec[0] )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanRelSec");
               GXutil.writeLogRaw("Old: ",Z1978BanRelSec);
               GXutil.writeLogRaw("Current: ",T00072_A1978BanRelSec[0]);
            }
            if ( Z1979BanRelSecCli != T00072_A1979BanRelSecCli[0] )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BanRelSecCli");
               GXutil.writeLogRaw("Old: ",Z1979BanRelSecCli);
               GXutil.writeLogRaw("Current: ",T00072_A1979BanRelSecCli[0]);
            }
            if ( GXutil.strcmp(Z1980BancodPadre, T00072_A1980BancodPadre[0]) != 0 )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BancodPadre");
               GXutil.writeLogRaw("Old: ",Z1980BancodPadre);
               GXutil.writeLogRaw("Current: ",T00072_A1980BancodPadre[0]);
            }
            if ( GXutil.strcmp(Z2012BancoRelRef, T00072_A2012BancoRelRef[0]) != 0 )
            {
               GXutil.writeLogln("banco:[seudo value changed for attri]"+"BancoRelRef");
               GXutil.writeLogRaw("Old: ",Z2012BancoRelRef);
               GXutil.writeLogRaw("Current: ",T00072_A2012BancoRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Banco"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert074( )
   {
      beforeValidate074( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable074( ) ;
      }
      if ( AnyError == 0 )
      {
         zm074( 0) ;
         checkOptimisticConcurrency074( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm074( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert074( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000710 */
                  pr_default.execute(8, new Object[] {A679BanDescripSinAc, A7BanCod, A117BanDescrip, Boolean.valueOf(A118BanHabilitado), Boolean.valueOf(n116BanCUIT), A116BanCUIT, Integer.valueOf(A1978BanRelSec), Integer.valueOf(A1979BanRelSecCli), A1980BancodPadre, A2012BancoRelRef, A2024BancoOld, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
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
                        resetCaption070( ) ;
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
            load074( ) ;
         }
         endLevel074( ) ;
      }
      closeExtendedTableCursors074( ) ;
   }

   public void update074( )
   {
      beforeValidate074( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable074( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency074( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm074( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate074( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000711 */
                  pr_default.execute(9, new Object[] {A679BanDescripSinAc, A117BanDescrip, Boolean.valueOf(A118BanHabilitado), Boolean.valueOf(n116BanCUIT), A116BanCUIT, Integer.valueOf(A1978BanRelSec), Integer.valueOf(A1979BanRelSecCli), A1980BancodPadre, A2012BancoRelRef, A2024BancoOld, Integer.valueOf(A3CliCod), A7BanCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Banco"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate074( ) ;
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
         endLevel074( ) ;
      }
      closeExtendedTableCursors074( ) ;
   }

   public void deferredUpdate074( )
   {
   }

   public void delete( )
   {
      beforeValidate074( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency074( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls074( ) ;
         afterConfirm074( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete074( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000712 */
               pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Banco");
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
      sMode4 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel074( ) ;
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls074( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         if ( isIns( )  || isUpd( )  )
         {
            GXv_boolean3[0] = AV21aplicadoHay ;
            new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1978BanRelSec, GXv_boolean3) ;
            banco_impl.this.AV21aplicadoHay = GXv_boolean3[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "AV21aplicadoHay", AV21aplicadoHay);
         }
         AV23Pgmname = "Banco" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) )
         {
            divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
            httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
         }
         else
         {
            GXt_boolean2 = false ;
            GXv_boolean3[0] = GXt_boolean2 ;
            new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
            banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
            if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) )
            {
               divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
               httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
            }
         }
         if ( ! (GXutil.strcmp("", A1980BancodPadre)==0) )
         {
            edtBanDescrip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
         }
         else
         {
            edtBanDescrip_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
         }
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000713 */
         pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "EmpresaBancos", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
         /* Using cursor T000714 */
         pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Liquidacion", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
         /* Using cursor T000715 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), A7BanCod});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Legajo", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
      }
   }

   public void endLevel074( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete074( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "banco");
         if ( AnyError == 0 )
         {
            confirmValues070( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "banco");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart074( )
   {
      /* Scan By routine */
      /* Using cursor T000716 */
      pr_default.execute(14);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A3CliCod = T000716_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A7BanCod = T000716_A7BanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext074( )
   {
      /* Scan next routine */
      pr_default.readNext(14);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A3CliCod = T000716_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A7BanCod = T000716_A7BanCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
      }
   }

   public void scanEnd074( )
   {
      pr_default.close(14);
   }

   public void afterConfirm074( )
   {
      /* After Confirm Rules */
      if ( ( isIns( )  || isUpd( )  ) && ( AV21aplicadoHay ) && ! (0==A1978BanRelSec) )
      {
         httpContext.GX_msglist.addItem(new web.txterrorrelease(remoteHandle, context).executeUdp( AV7CliCod), "BanRelSec", 1, "BANRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynBanRelSec.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         return  ;
      }
   }

   public void beforeInsert074( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate074( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete074( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete074( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate074( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes074( )
   {
      edtBanCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanCod_Enabled), 5, 0), true);
      edtBanDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtBanDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtBanDescrip_Enabled), 5, 0), true);
      chkBanHabilitado.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkBanHabilitado.getInternalname(), "Enabled", GXutil.ltrimstr( chkBanHabilitado.getEnabled(), 5, 0), true);
      dynBanRelSec.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynBanRelSec.getInternalname(), "Enabled", GXutil.ltrimstr( dynBanRelSec.getEnabled(), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes074( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues070( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.banco", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8BanCod))}, new String[] {"Gx_mode","CliCod","BanCod"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Banco");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("BanCUIT", GXutil.rtrim( localUtil.format( A116BanCUIT, "")));
      forbiddenHiddens.add("BanRelSecCli", localUtil.format( DecimalUtil.doubleToDec(A1979BanRelSecCli), "ZZZZZ9"));
      forbiddenHiddens.add("BancodPadre", GXutil.rtrim( localUtil.format( A1980BancodPadre, "")));
      forbiddenHiddens.add("BancoRelRef", GXutil.rtrim( localUtil.format( A2012BancoRelRef, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("banco:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z7BanCod", GXutil.rtrim( Z7BanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "Z679BanDescripSinAc", Z679BanDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z117BanDescrip", Z117BanDescrip);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z118BanHabilitado", Z118BanHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z116BanCUIT", GXutil.rtrim( Z116BanCUIT));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1978BanRelSec", GXutil.ltrim( localUtil.ntoc( Z1978BanRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1979BanRelSecCli", GXutil.ltrim( localUtil.ntoc( Z1979BanRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1980BancodPadre", GXutil.rtrim( Z1980BancodPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2012BancoRelRef", Z2012BancoRelRef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "O118BanHabilitado", O118BanHabilitado);
      web.GxWebStd.gx_hidden_field( httpContext, "O117BanDescrip", O117BanDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "O7BanCod", GXutil.rtrim( O7BanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "N117BanDescrip", A117BanDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "BANDESCRIPSINAC", A679BanDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vBANCOD", GXutil.rtrim( AV8BanCod));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vBANCOD", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8BanCod, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "BANCODPADRE", GXutil.rtrim( A1980BancodPadre));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "vAPLICADOHAY", AV21aplicadoHay);
      web.GxWebStd.gx_hidden_field( httpContext, "BANCUIT", GXutil.rtrim( A116BanCUIT));
      web.GxWebStd.gx_hidden_field( httpContext, "BANRELSECCLI", GXutil.ltrim( localUtil.ntoc( A1979BanRelSecCli, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "BANCORELREF", A2012BancoRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "BANCOOLD", A2024BancoOld);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV23Pgmname));
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
      return formatLink("web.banco", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.rtrim(AV8BanCod))}, new String[] {"Gx_mode","CliCod","BanCod"})  ;
   }

   public String getPgmname( )
   {
      return "Banco" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Banco", "") ;
   }

   public void initializeNonKey074( )
   {
      AV21aplicadoHay = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21aplicadoHay", AV21aplicadoHay);
      A679BanDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A679BanDescripSinAc", A679BanDescripSinAc);
      A117BanDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
      A116BanCUIT = "" ;
      n116BanCUIT = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A116BanCUIT", A116BanCUIT);
      A1978BanRelSec = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1978BanRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1978BanRelSec), 6, 0));
      A1979BanRelSecCli = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A1979BanRelSecCli", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1979BanRelSecCli), 6, 0));
      A1980BancodPadre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1980BancodPadre", A1980BancodPadre);
      A2012BancoRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2012BancoRelRef", A2012BancoRelRef);
      A2024BancoOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2024BancoOld", A2024BancoOld);
      A118BanHabilitado = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
      O118BanHabilitado = A118BanHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
      O117BanDescrip = A117BanDescrip ;
      httpContext.ajax_rsp_assign_attri("", false, "A117BanDescrip", A117BanDescrip);
      Z679BanDescripSinAc = "" ;
      Z117BanDescrip = "" ;
      Z118BanHabilitado = false ;
      Z116BanCUIT = "" ;
      Z1978BanRelSec = 0 ;
      Z1979BanRelSecCli = 0 ;
      Z1980BancodPadre = "" ;
      Z2012BancoRelRef = "" ;
   }

   public void initAll074( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A7BanCod = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A7BanCod", A7BanCod);
      initializeNonKey074( ) ;
   }

   public void standaloneModalInsert( )
   {
      A118BanHabilitado = i118BanHabilitado ;
      httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251713253110", true, true);
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
      httpContext.AddJavascriptSource("banco.js", "?20251713253110", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtBanCod_Internalname = "BANCOD" ;
      edtBanDescrip_Internalname = "BANDESCRIP" ;
      chkBanHabilitado.setInternalname( "BANHABILITADO" );
      dynBanRelSec.setInternalname( "BANRELSEC" );
      divBanrelsec_cell_Internalname = "BANRELSEC_CELL" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
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
      Form.setCaption( httpContext.getMessage( "Banco", "") );
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      dynBanRelSec.setJsonclick( "" );
      dynBanRelSec.setEnabled( 1 );
      dynBanRelSec.setVisible( 1 );
      divBanrelsec_cell_Class = "col-xs-12" ;
      chkBanHabilitado.setEnabled( 1 );
      edtBanDescrip_Enabled = 1 ;
      edtBanCod_Jsonclick = "" ;
      edtBanCod_Enabled = 1 ;
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

   public void gxdlabanrelsec074( int AV7CliCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlabanrelsec_data074( AV7CliCod) ;
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

   public void gxabanrelsec_html074( int AV7CliCod )
   {
      int gxdynajaxvalue;
      gxdlabanrelsec_data074( AV7CliCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynBanRelSec.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = (int)(GXutil.lval( gxdynajaxctrlcodr.item(gxdynajaxindex))) ;
         dynBanRelSec.addItem(GXutil.trim( GXutil.str( gxdynajaxvalue, 6, 0)), gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlabanrelsec_data074( int AV7CliCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      gxdynajaxctrlcodr.add(GXutil.ltrimstr( DecimalUtil.doubleToDec(0), 9, 0));
      gxdynajaxctrldescr.add(httpContext.getMessage( "GX_EmptyItemText", ""));
      /* Using cursor T000717 */
      pr_default.execute(15, new Object[] {Integer.valueOf(AV7CliCod)});
      while ( (pr_default.getStatus(15) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.ltrim( localUtil.ntoc( T000717_A1885CliRelSec[0], (byte)(6), (byte)(0), ".", "")));
         gxdynajaxctrldescr.add(T000717_A1880CliReDTChar[0]);
         pr_default.readNext(15);
      }
      pr_default.close(15);
   }

   public void gx1asabandescripsinac074( String A117BanDescrip )
   {
      GXt_char6 = A679BanDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char7) ;
      banco_impl.this.GXt_char6 = GXv_char7[0] ;
      A679BanDescripSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A679BanDescripSinAc", A679BanDescripSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A679BanDescripSinAc)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx2asaclicod074( int AV7CliCod )
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
            banco_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxasa1978074( int AV7CliCod )
   {
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      dynBanRelSec.setVisible( (!GXt_boolean2 ? 1 : 0) );
      httpContext.ajax_rsp_assign_prop("", false, dynBanRelSec.getInternalname(), "Visible", GXutil.ltrimstr( dynBanRelSec.getVisible(), 5, 0), true);
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

   public void xc_17_074( String Gx_mode ,
                          int AV7CliCod ,
                          int A1978BanRelSec )
   {
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV21aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1978BanRelSec, GXv_boolean3) ;
         AV21aplicadoHay = GXv_boolean3[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "AV21aplicadoHay", AV21aplicadoHay);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.booltostr( AV21aplicadoHay))+"\"") ;
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
      chkBanHabilitado.setName( "BANHABILITADO" );
      chkBanHabilitado.setWebtags( "" );
      chkBanHabilitado.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkBanHabilitado.getInternalname(), "TitleCaption", chkBanHabilitado.getCaption(), true);
      chkBanHabilitado.setCheckedValue( "false" );
      if ( isIns( ) && (false==A118BanHabilitado) )
      {
         A118BanHabilitado = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A118BanHabilitado", A118BanHabilitado);
      }
      dynBanRelSec.setName( "BANRELSEC" );
      dynBanRelSec.setWebtags( "" );
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
      A1978BanRelSec = (int)(GXutil.lval( dynBanRelSec.getValue())) ;
      /* Using cursor T000718 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod)});
      if ( (pr_default.getStatus(16) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(16);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Bandescrip( )
   {
      A1978BanRelSec = (int)(GXutil.lval( dynBanRelSec.getValue())) ;
      GXt_char6 = A679BanDescripSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A117BanDescrip, GXv_char7) ;
      banco_impl.this.GXt_char6 = GXv_char7[0] ;
      A679BanDescripSinAc = GXt_char6 ;
      if ( (GXutil.strcmp("", A117BanDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Banco", ""), "", "", "", "", "", "", "", ""), 1, "BANDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtBanDescrip_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A679BanDescripSinAc", A679BanDescripSinAc);
   }

   public void valid_Banhabilitado( )
   {
      A1978BanRelSec = (int)(GXutil.lval( dynBanRelSec.getValue())) ;
      GXt_boolean2 = false ;
      GXv_boolean3[0] = GXt_boolean2 ;
      new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
      banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
      if ( ! ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) )
      {
         divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 DataContentCell", "") ;
      }
      else
      {
         GXt_boolean2 = false ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).execute( AV7CliCod, GXv_boolean3) ;
         banco_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         if ( ! GXt_boolean2 && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) )
         {
            divBanrelsec_cell_Class = httpContext.getMessage( "col-xs-12 RequiredDataContentCell", "") ;
         }
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_prop("", false, divBanrelsec_cell_Internalname, "Class", divBanrelsec_cell_Class, true);
   }

   public void valid_Banrelsec( )
   {
      A1978BanRelSec = (int)(GXutil.lval( dynBanRelSec.getValue())) ;
      if ( ( ! new web.wwpbaseobjects.esclienteusuario(remoteHandle, context).executeUdp( AV7CliCod) && ( ( GXutil.strcmp(A7BanCod, O7BanCod) != 0 ) || ( GXutil.strcmp(A117BanDescrip, O117BanDescrip) != 0 ) || ( A118BanHabilitado != O118BanHabilitado ) ) ) && (0==A1978BanRelSec) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Liberación", ""), "", "", "", "", "", "", "", ""), 1, "BANRELSEC");
         AnyError = (short)(1) ;
         GX_FocusControl = dynBanRelSec.getInternalname() ;
      }
      if ( isIns( )  || isUpd( )  )
      {
         GXv_boolean3[0] = AV21aplicadoHay ;
         new web.validarfecharelease(remoteHandle, context).execute( AV7CliCod, A1978BanRelSec, GXv_boolean3) ;
         banco_impl.this.AV21aplicadoHay = GXv_boolean3[0] ;
         AV21aplicadoHay = this.AV21aplicadoHay ;
      }
      O118BanHabilitado = A118BanHabilitado ;
      O117BanDescrip = A117BanDescrip ;
      O7BanCod = A7BanCod ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV21aplicadoHay", AV21aplicadoHay);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8BanCod',fld:'vBANCOD',pic:'',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8BanCod',fld:'vBANCOD',pic:'',hsh:true},{av:'A116BanCUIT',fld:'BANCUIT',pic:''},{av:'A1979BanRelSecCli',fld:'BANRELSECCLI',pic:'ZZZZZ9'},{av:'A1980BancodPadre',fld:'BANCODPADRE',pic:''},{av:'A2012BancoRelRef',fld:'BANCORELREF',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e12072',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("VALID_BANCOD","{handler:'valid_Bancod',iparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("VALID_BANCOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("VALID_BANDESCRIP","{handler:'valid_Bandescrip',iparms:[{av:'A117BanDescrip',fld:'BANDESCRIP',pic:''},{av:'A679BanDescripSinAc',fld:'BANDESCRIPSINAC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("VALID_BANDESCRIP",",oparms:[{av:'A679BanDescripSinAc',fld:'BANDESCRIPSINAC',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("VALID_BANHABILITADO","{handler:'valid_Banhabilitado',iparms:[{av:'O118BanHabilitado'},{av:'O117BanDescrip'},{av:'O7BanCod'},{av:'A7BanCod',fld:'BANCOD',pic:''},{av:'A117BanDescrip',fld:'BANDESCRIP',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("VALID_BANHABILITADO",",oparms:[{av:'divBanrelsec_cell_Class',ctrl:'BANRELSEC_CELL',prop:'Class'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("VALID_BANRELSEC","{handler:'valid_Banrelsec',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'O118BanHabilitado'},{av:'O117BanDescrip'},{av:'O7BanCod'},{av:'A7BanCod',fld:'BANCOD',pic:''},{av:'A117BanDescrip',fld:'BANDESCRIP',pic:''},{av:'AV21aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("VALID_BANRELSEC",",oparms:[{av:'AV21aplicadoHay',fld:'vAPLICADOHAY',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]");
      setEventMetadata("VALID_CLICOD",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'dynBanRelSec'},{av:'A1978BanRelSec',fld:'BANRELSEC',pic:'ZZZZZ9'},{av:'A118BanHabilitado',fld:'BANHABILITADO',pic:''}]}");
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
      return "banco_Execute";
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
      pr_default.close(16);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8BanCod = "" ;
      Z7BanCod = "" ;
      Z679BanDescripSinAc = "" ;
      Z117BanDescrip = "" ;
      Z116BanCUIT = "" ;
      Z1980BancodPadre = "" ;
      Z2012BancoRelRef = "" ;
      O117BanDescrip = "" ;
      O7BanCod = "" ;
      N117BanDescrip = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      A117BanDescrip = "" ;
      AV8BanCod = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A7BanCod = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A116BanCUIT = "" ;
      A679BanDescripSinAc = "" ;
      A1980BancodPadre = "" ;
      A2012BancoRelRef = "" ;
      A2024BancoOld = "" ;
      AV23Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode4 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      Z2024BancoOld = "" ;
      T00075_A679BanDescripSinAc = new String[] {""} ;
      T00075_A7BanCod = new String[] {""} ;
      T00075_A117BanDescrip = new String[] {""} ;
      T00075_A118BanHabilitado = new boolean[] {false} ;
      T00075_A116BanCUIT = new String[] {""} ;
      T00075_n116BanCUIT = new boolean[] {false} ;
      T00075_A1978BanRelSec = new int[1] ;
      T00075_A1979BanRelSecCli = new int[1] ;
      T00075_A1980BancodPadre = new String[] {""} ;
      T00075_A2012BancoRelRef = new String[] {""} ;
      T00075_A2024BancoOld = new String[] {""} ;
      T00075_A3CliCod = new int[1] ;
      T00074_A3CliCod = new int[1] ;
      T00076_A3CliCod = new int[1] ;
      T00077_A3CliCod = new int[1] ;
      T00077_A7BanCod = new String[] {""} ;
      T00073_A679BanDescripSinAc = new String[] {""} ;
      T00073_A7BanCod = new String[] {""} ;
      T00073_A117BanDescrip = new String[] {""} ;
      T00073_A118BanHabilitado = new boolean[] {false} ;
      T00073_A116BanCUIT = new String[] {""} ;
      T00073_n116BanCUIT = new boolean[] {false} ;
      T00073_A1978BanRelSec = new int[1] ;
      T00073_A1979BanRelSecCli = new int[1] ;
      T00073_A1980BancodPadre = new String[] {""} ;
      T00073_A2012BancoRelRef = new String[] {""} ;
      T00073_A2024BancoOld = new String[] {""} ;
      T00073_A3CliCod = new int[1] ;
      T00078_A3CliCod = new int[1] ;
      T00078_A7BanCod = new String[] {""} ;
      T00079_A3CliCod = new int[1] ;
      T00079_A7BanCod = new String[] {""} ;
      T00072_A679BanDescripSinAc = new String[] {""} ;
      T00072_A7BanCod = new String[] {""} ;
      T00072_A117BanDescrip = new String[] {""} ;
      T00072_A118BanHabilitado = new boolean[] {false} ;
      T00072_A116BanCUIT = new String[] {""} ;
      T00072_n116BanCUIT = new boolean[] {false} ;
      T00072_A1978BanRelSec = new int[1] ;
      T00072_A1979BanRelSecCli = new int[1] ;
      T00072_A1980BancodPadre = new String[] {""} ;
      T00072_A2012BancoRelRef = new String[] {""} ;
      T00072_A2024BancoOld = new String[] {""} ;
      T00072_A3CliCod = new int[1] ;
      T000713_A3CliCod = new int[1] ;
      T000713_A1EmpCod = new short[1] ;
      T000713_A1966EmpBanCod = new String[] {""} ;
      T000714_A3CliCod = new int[1] ;
      T000714_A1EmpCod = new short[1] ;
      T000714_A31LiqNro = new int[1] ;
      T000715_A3CliCod = new int[1] ;
      T000715_A1EmpCod = new short[1] ;
      T000715_A6LegNumero = new int[1] ;
      T000716_A3CliCod = new int[1] ;
      T000716_A7BanCod = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      gxdynajaxctrlcodr = new com.genexus.internet.StringCollection();
      gxdynajaxctrldescr = new com.genexus.internet.StringCollection();
      gxwrpcisep = "" ;
      T000717_A3CliCod = new int[1] ;
      T000717_A1885CliRelSec = new int[1] ;
      T000717_A1880CliReDTChar = new String[] {""} ;
      GXv_int5 = new int[1] ;
      T000718_A3CliCod = new int[1] ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean3 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.banco__default(),
         new Object[] {
             new Object[] {
            T00072_A679BanDescripSinAc, T00072_A7BanCod, T00072_A117BanDescrip, T00072_A118BanHabilitado, T00072_A116BanCUIT, T00072_n116BanCUIT, T00072_A1978BanRelSec, T00072_A1979BanRelSecCli, T00072_A1980BancodPadre, T00072_A2012BancoRelRef,
            T00072_A2024BancoOld, T00072_A3CliCod
            }
            , new Object[] {
            T00073_A679BanDescripSinAc, T00073_A7BanCod, T00073_A117BanDescrip, T00073_A118BanHabilitado, T00073_A116BanCUIT, T00073_n116BanCUIT, T00073_A1978BanRelSec, T00073_A1979BanRelSecCli, T00073_A1980BancodPadre, T00073_A2012BancoRelRef,
            T00073_A2024BancoOld, T00073_A3CliCod
            }
            , new Object[] {
            T00074_A3CliCod
            }
            , new Object[] {
            T00075_A679BanDescripSinAc, T00075_A7BanCod, T00075_A117BanDescrip, T00075_A118BanHabilitado, T00075_A116BanCUIT, T00075_n116BanCUIT, T00075_A1978BanRelSec, T00075_A1979BanRelSecCli, T00075_A1980BancodPadre, T00075_A2012BancoRelRef,
            T00075_A2024BancoOld, T00075_A3CliCod
            }
            , new Object[] {
            T00076_A3CliCod
            }
            , new Object[] {
            T00077_A3CliCod, T00077_A7BanCod
            }
            , new Object[] {
            T00078_A3CliCod, T00078_A7BanCod
            }
            , new Object[] {
            T00079_A3CliCod, T00079_A7BanCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000713_A3CliCod, T000713_A1EmpCod, T000713_A1966EmpBanCod
            }
            , new Object[] {
            T000714_A3CliCod, T000714_A1EmpCod, T000714_A31LiqNro
            }
            , new Object[] {
            T000715_A3CliCod, T000715_A1EmpCod, T000715_A6LegNumero
            }
            , new Object[] {
            T000716_A3CliCod, T000716_A7BanCod
            }
            , new Object[] {
            T000717_A3CliCod, T000717_A1885CliRelSec, T000717_A1880CliReDTChar
            }
            , new Object[] {
            T000718_A3CliCod
            }
         }
      );
      AV23Pgmname = "Banco" ;
      Z118BanHabilitado = true ;
      O118BanHabilitado = true ;
      A118BanHabilitado = true ;
      i118BanHabilitado = true ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short RcdFound4 ;
   private short nIsDirty_4 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int Z1978BanRelSec ;
   private int Z1979BanRelSecCli ;
   private int AV7CliCod ;
   private int A1978BanRelSec ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtBanCod_Enabled ;
   private int edtBanDescrip_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int A1979BanRelSecCli ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int idxLst ;
   private int gxdynajaxindex ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8BanCod ;
   private String Z7BanCod ;
   private String Z116BanCUIT ;
   private String Z1980BancodPadre ;
   private String O7BanCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String AV8BanCod ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtBanCod_Internalname ;
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
   private String A7BanCod ;
   private String edtBanCod_Jsonclick ;
   private String edtBanDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divBanrelsec_cell_Internalname ;
   private String divBanrelsec_cell_Class ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String A116BanCUIT ;
   private String A1980BancodPadre ;
   private String AV23Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode4 ;
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
   private boolean Z118BanHabilitado ;
   private boolean O118BanHabilitado ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A118BanHabilitado ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean n116BanCUIT ;
   private boolean AV21aplicadoHay ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean Gx_longc ;
   private boolean i118BanHabilitado ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean ZV21aplicadoHay ;
   private String A2024BancoOld ;
   private String Z2024BancoOld ;
   private String Z679BanDescripSinAc ;
   private String Z117BanDescrip ;
   private String Z2012BancoRelRef ;
   private String O117BanDescrip ;
   private String N117BanDescrip ;
   private String A117BanDescrip ;
   private String A679BanDescripSinAc ;
   private String A2012BancoRelRef ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private ICheckbox chkBanHabilitado ;
   private HTMLChoice dynBanRelSec ;
   private IDataStoreProvider pr_default ;
   private String[] T00075_A679BanDescripSinAc ;
   private String[] T00075_A7BanCod ;
   private String[] T00075_A117BanDescrip ;
   private boolean[] T00075_A118BanHabilitado ;
   private String[] T00075_A116BanCUIT ;
   private boolean[] T00075_n116BanCUIT ;
   private int[] T00075_A1978BanRelSec ;
   private int[] T00075_A1979BanRelSecCli ;
   private String[] T00075_A1980BancodPadre ;
   private String[] T00075_A2012BancoRelRef ;
   private String[] T00075_A2024BancoOld ;
   private int[] T00075_A3CliCod ;
   private int[] T00074_A3CliCod ;
   private int[] T00076_A3CliCod ;
   private int[] T00077_A3CliCod ;
   private String[] T00077_A7BanCod ;
   private String[] T00073_A679BanDescripSinAc ;
   private String[] T00073_A7BanCod ;
   private String[] T00073_A117BanDescrip ;
   private boolean[] T00073_A118BanHabilitado ;
   private String[] T00073_A116BanCUIT ;
   private boolean[] T00073_n116BanCUIT ;
   private int[] T00073_A1978BanRelSec ;
   private int[] T00073_A1979BanRelSecCli ;
   private String[] T00073_A1980BancodPadre ;
   private String[] T00073_A2012BancoRelRef ;
   private String[] T00073_A2024BancoOld ;
   private int[] T00073_A3CliCod ;
   private int[] T00078_A3CliCod ;
   private String[] T00078_A7BanCod ;
   private int[] T00079_A3CliCod ;
   private String[] T00079_A7BanCod ;
   private String[] T00072_A679BanDescripSinAc ;
   private String[] T00072_A7BanCod ;
   private String[] T00072_A117BanDescrip ;
   private boolean[] T00072_A118BanHabilitado ;
   private String[] T00072_A116BanCUIT ;
   private boolean[] T00072_n116BanCUIT ;
   private int[] T00072_A1978BanRelSec ;
   private int[] T00072_A1979BanRelSecCli ;
   private String[] T00072_A1980BancodPadre ;
   private String[] T00072_A2012BancoRelRef ;
   private String[] T00072_A2024BancoOld ;
   private int[] T00072_A3CliCod ;
   private int[] T000713_A3CliCod ;
   private short[] T000713_A1EmpCod ;
   private String[] T000713_A1966EmpBanCod ;
   private int[] T000714_A3CliCod ;
   private short[] T000714_A1EmpCod ;
   private int[] T000714_A31LiqNro ;
   private int[] T000715_A3CliCod ;
   private short[] T000715_A1EmpCod ;
   private int[] T000715_A6LegNumero ;
   private int[] T000716_A3CliCod ;
   private String[] T000716_A7BanCod ;
   private int[] T000717_A3CliCod ;
   private int[] T000717_A1885CliRelSec ;
   private String[] T000717_A1880CliReDTChar ;
   private int[] T000718_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class banco__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00072", "SELECT BanDescripSinAc, BanCod, BanDescrip, BanHabilitado, BanCUIT, BanRelSec, BanRelSecCli, BancodPadre, BancoRelRef, BancoOld, CliCod FROM Banco WHERE CliCod = ? AND BanCod = ?  FOR UPDATE OF Banco NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00073", "SELECT BanDescripSinAc, BanCod, BanDescrip, BanHabilitado, BanCUIT, BanRelSec, BanRelSecCli, BancodPadre, BancoRelRef, BancoOld, CliCod FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00074", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00075", "SELECT TM1.BanDescripSinAc, TM1.BanCod, TM1.BanDescrip, TM1.BanHabilitado, TM1.BanCUIT, TM1.BanRelSec, TM1.BanRelSecCli, TM1.BancodPadre, TM1.BancoRelRef, TM1.BancoOld, TM1.CliCod FROM Banco TM1 WHERE TM1.CliCod = ? and TM1.BanCod = ( ?) ORDER BY TM1.CliCod, TM1.BanCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00076", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00077", "SELECT CliCod, BanCod FROM Banco WHERE CliCod = ? AND BanCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00078", "SELECT CliCod, BanCod FROM Banco WHERE ( CliCod > ? or CliCod = ? and BanCod > ( ?)) ORDER BY CliCod, BanCod  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00079", "SELECT CliCod, BanCod FROM Banco WHERE ( CliCod < ? or CliCod = ? and BanCod < ( ?)) ORDER BY CliCod DESC, BanCod DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000710", "SAVEPOINT gxupdate;INSERT INTO Banco(BanDescripSinAc, BanCod, BanDescrip, BanHabilitado, BanCUIT, BanRelSec, BanRelSecCli, BancodPadre, BancoRelRef, BancoOld, CliCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000711", "SAVEPOINT gxupdate;UPDATE Banco SET BanDescripSinAc=?, BanDescrip=?, BanHabilitado=?, BanCUIT=?, BanRelSec=?, BanRelSecCli=?, BancodPadre=?, BancoRelRef=?, BancoOld=?  WHERE CliCod = ? AND BanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000712", "SAVEPOINT gxupdate;DELETE FROM Banco  WHERE CliCod = ? AND BanCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000713", "SELECT CliCod, EmpCod, EmpBanCod FROM EmpresaBancos WHERE CliCod = ? AND EmpBanCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000714", "SELECT CliCod, EmpCod, LiqNro FROM Liquidacion WHERE CliCod = ? AND LiqDepBanCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000715", "SELECT CliCod, EmpCod, LegNumero FROM Legajo WHERE CliCod = ? AND LegBanCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000716", "SELECT CliCod, BanCod FROM Banco ORDER BY CliCod, BanCod ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000717", "SELECT CliCod, CliRelSec, CliReDTChar FROM Cliente_Release WHERE CliCod = ? ORDER BY CliReDTChar ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000718", "SELECT CliCod FROM Cliente WHERE CliCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 13);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 6);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 13);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 6);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 13);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((String[]) buf[8])[0] = rslt.getString(8, 6);
               ((String[]) buf[9])[0] = rslt.getVarchar(9);
               ((String[]) buf[10])[0] = rslt.getLongVarchar(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 6);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 6);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 16 :
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
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 6);
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 6);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(5, (String)parms[5], 13);
               }
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setString(8, (String)parms[8], 6);
               stmt.setVarchar(9, (String)parms[9], 40, false);
               stmt.setNLongVarchar(10, (String)parms[10], false);
               stmt.setInt(11, ((Number) parms[11]).intValue());
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(4, (String)parms[4], 13);
               }
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setInt(6, ((Number) parms[6]).intValue());
               stmt.setString(7, (String)parms[7], 6);
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               stmt.setInt(10, ((Number) parms[10]).intValue());
               stmt.setString(11, (String)parms[11], 6);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 6);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
      }
   }

}

