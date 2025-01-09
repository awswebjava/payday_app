package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class calculo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action8") == 0 )
      {
         A74idOperando = httpContext.GetPar( "idOperando") ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_8_1S62( A74idOperando) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_10") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_10( A46PaiCod) ;
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
            AV7PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
            AV8idOperando = httpContext.GetPar( "idOperando") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8idOperando", AV8idOperando);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8idOperando, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Calculo", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = cmbidOperando.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public calculo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public calculo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_impl.class ));
   }

   public calculo_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbidOperando = new HTMLChoice();
      chkOpeEsCant = UIFactory.getCheckbox(this);
      chkOpeAliEs = UIFactory.getCheckbox(this);
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
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      }
      A932OpeEsCant = GXutil.strtobool( GXutil.booltostr( A932OpeEsCant)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
      A1032OpeAliEs = GXutil.strtobool( GXutil.booltostr( A1032OpeAliEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbidOperando.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbidOperando.getInternalname(), httpContext.getMessage( "Cálculo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbidOperando, cmbidOperando.getInternalname(), GXutil.rtrim( A74idOperando), 1, cmbidOperando.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbidOperando.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "", true, (byte)(0), "HLP_Calculo.htm");
      cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Values", cmbidOperando.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeCodFormula_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeCodFormula_Internalname, httpContext.getMessage( "Fórmula", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtOpeCodFormula_Internalname, GXutil.rtrim( A473OpeCodFormula), GXutil.rtrim( localUtil.format( A473OpeCodFormula, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtOpeCodFormula_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtOpeCodFormula_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtOpeDescripcion_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtOpeDescripcion_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtOpeDescripcion_Internalname, A474OpeDescripcion, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtOpeDescripcion_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeEsCant.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOpeEsCant.getInternalname(), httpContext.getMessage( "Determina cantidad", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeEsCant.getInternalname(), GXutil.booltostr( A932OpeEsCant), "", httpContext.getMessage( "Determina cantidad", ""), 1, chkOpeEsCant.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(37, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,37);\"");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+chkOpeAliEs.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, chkOpeAliEs.getInternalname(), httpContext.getMessage( "Es alícuota", ""), "col-sm-3 AttributeCheckBoxLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Check box */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "AttributeCheckBox" ;
      StyleString = "" ;
      web.GxWebStd.gx_checkbox_ctrl( httpContext, chkOpeAliEs.getInternalname(), GXutil.booltostr( A1032OpeAliEs), "", httpContext.getMessage( "Es alícuota", ""), 1, chkOpeAliEs.getEnabled(), "true", "", StyleString, ClassString, "", "", TempTags+" onclick="+"\"gx.fn.checkboxClick(42, this, 'true', 'false',"+"''"+");"+"gx.evt.onchange(this, event);\""+" onblur=\""+""+";gx.evt.onblur(this,42);\"");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Calculo.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A46PaiCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,58);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtPaiCod_Jsonclick, 0, "Attribute", "", "", "", "", edtPaiCod_Visible, edtPaiCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_Calculo.htm");
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
      e111S2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z74idOperando = httpContext.cgiGet( "Z74idOperando") ;
            Z473OpeCodFormula = httpContext.cgiGet( "Z473OpeCodFormula") ;
            Z474OpeDescripcion = httpContext.cgiGet( "Z474OpeDescripcion") ;
            Z537OpeCodForMay = httpContext.cgiGet( "Z537OpeCodForMay") ;
            Z932OpeEsCant = GXutil.strtobool( httpContext.cgiGet( "Z932OpeEsCant")) ;
            Z1032OpeAliEs = GXutil.strtobool( httpContext.cgiGet( "Z1032OpeAliEs")) ;
            Z1607OpeProcedure = httpContext.cgiGet( "Z1607OpeProcedure") ;
            Z2138OpeDetail = httpContext.cgiGet( "Z2138OpeDetail") ;
            A537OpeCodForMay = httpContext.cgiGet( "Z537OpeCodForMay") ;
            A1607OpeProcedure = httpContext.cgiGet( "Z1607OpeProcedure") ;
            A2138OpeDetail = httpContext.cgiGet( "Z2138OpeDetail") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            AV7PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV21auxPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vAUXPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8idOperando = httpContext.cgiGet( "vIDOPERANDO") ;
            AV20OpeCodForMay = httpContext.cgiGet( "vOPECODFORMAY") ;
            A537OpeCodForMay = httpContext.cgiGet( "OPECODFORMAY") ;
            A1607OpeProcedure = httpContext.cgiGet( "OPEPROCEDURE") ;
            A2073OpeHelp = httpContext.cgiGet( "OPEHELP") ;
            A2138OpeDetail = httpContext.cgiGet( "OPEDETAIL") ;
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
            cmbidOperando.setValue( httpContext.cgiGet( cmbidOperando.getInternalname()) );
            A74idOperando = httpContext.cgiGet( cmbidOperando.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            A473OpeCodFormula = httpContext.cgiGet( edtOpeCodFormula_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A473OpeCodFormula", A473OpeCodFormula);
            A474OpeDescripcion = httpContext.cgiGet( edtOpeDescripcion_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A474OpeDescripcion", A474OpeDescripcion);
            A932OpeEsCant = GXutil.strtobool( httpContext.cgiGet( chkOpeEsCant.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
            A1032OpeAliEs = GXutil.strtobool( httpContext.cgiGet( chkOpeAliEs.getInternalname())) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A46PaiCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            else
            {
               A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Calculo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("OpeProcedure", GXutil.rtrim( localUtil.format( A1607OpeProcedure, "")));
            forbiddenHiddens.add("OpeDetail", GXutil.rtrim( localUtil.format( A2138OpeDetail, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("calculo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A74idOperando = httpContext.GetPar( "idOperando") ;
               httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
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
                  sMode62 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode62 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound62 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_1S0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "PAICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtPaiCod_Internalname ;
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
                        e111S2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e121S2 ();
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
         e121S2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll1S62( ) ;
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
         disableAttributes1S62( ) ;
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

   public void confirm_1S0( )
   {
      beforeValidate1S62( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls1S62( ) ;
         }
         else
         {
            checkExtendedTable1S62( ) ;
            closeExtendedTableCursors1S62( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption1S0( )
   {
   }

   public void e111S2( )
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
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Insert", GXv_boolean3) ;
         calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Update", GXv_boolean3) ;
         calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV10IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWOperando_Delete", GXv_boolean3) ;
         calculo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV10IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV23Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      edtPaiCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Visible), 5, 0), true);
      GXv_int4[0] = AV22CliCod ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      calculo_impl.this.AV22CliCod = GXv_int4[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV22CliCod), 6, 0));
      GXv_int5[0] = AV21auxPaiCod ;
      new web.clientegetpais(remoteHandle, context).execute( AV22CliCod, GXv_int5) ;
      calculo_impl.this.AV21auxPaiCod = GXv_int5[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV21auxPaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV21auxPaiCod), 4, 0));
   }

   public void e121S2( )
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

   public void zm1S62( int GX_JID )
   {
      if ( ( GX_JID == 9 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z473OpeCodFormula = T001S3_A473OpeCodFormula[0] ;
            Z474OpeDescripcion = T001S3_A474OpeDescripcion[0] ;
            Z537OpeCodForMay = T001S3_A537OpeCodForMay[0] ;
            Z932OpeEsCant = T001S3_A932OpeEsCant[0] ;
            Z1032OpeAliEs = T001S3_A1032OpeAliEs[0] ;
            Z1607OpeProcedure = T001S3_A1607OpeProcedure[0] ;
            Z2138OpeDetail = T001S3_A2138OpeDetail[0] ;
         }
         else
         {
            Z473OpeCodFormula = A473OpeCodFormula ;
            Z474OpeDescripcion = A474OpeDescripcion ;
            Z537OpeCodForMay = A537OpeCodForMay ;
            Z932OpeEsCant = A932OpeEsCant ;
            Z1032OpeAliEs = A1032OpeAliEs ;
            Z1607OpeProcedure = A1607OpeProcedure ;
            Z2138OpeDetail = A2138OpeDetail ;
         }
      }
      if ( GX_JID == -9 )
      {
         Z74idOperando = A74idOperando ;
         Z473OpeCodFormula = A473OpeCodFormula ;
         Z474OpeDescripcion = A474OpeDescripcion ;
         Z537OpeCodForMay = A537OpeCodForMay ;
         Z932OpeEsCant = A932OpeEsCant ;
         Z1032OpeAliEs = A1032OpeAliEs ;
         Z1607OpeProcedure = A1607OpeProcedure ;
         Z2073OpeHelp = A2073OpeHelp ;
         Z2138OpeDetail = A2138OpeDetail ;
         Z46PaiCod = A46PaiCod ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      else
      {
         edtPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         edtPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8idOperando)==0) )
      {
         A74idOperando = AV8idOperando ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      if ( ! (GXutil.strcmp("", AV8idOperando)==0) )
      {
         cmbidOperando.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbidOperando.getEnabled(), 5, 0), true);
      }
      else
      {
         cmbidOperando.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbidOperando.getEnabled(), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8idOperando)==0) )
      {
         cmbidOperando.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbidOperando.getEnabled(), 5, 0), true);
      }
      if ( ! (0==AV7PaiCod) )
      {
         A46PaiCod = AV7PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      else
      {
         A46PaiCod = AV21auxPaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
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
         AV23Pgmname = "Calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
         A537OpeCodForMay = AV20OpeCodForMay ;
         httpContext.ajax_rsp_assign_attri("", false, "A537OpeCodForMay", A537OpeCodForMay);
      }
   }

   public void load1S62( )
   {
      /* Using cursor T001S5 */
      pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(3) != 101) )
      {
         RcdFound62 = (short)(1) ;
         A473OpeCodFormula = T001S5_A473OpeCodFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A473OpeCodFormula", A473OpeCodFormula);
         A474OpeDescripcion = T001S5_A474OpeDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A474OpeDescripcion", A474OpeDescripcion);
         A537OpeCodForMay = T001S5_A537OpeCodForMay[0] ;
         A932OpeEsCant = T001S5_A932OpeEsCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
         A1032OpeAliEs = T001S5_A1032OpeAliEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
         A1607OpeProcedure = T001S5_A1607OpeProcedure[0] ;
         A2073OpeHelp = T001S5_A2073OpeHelp[0] ;
         A2138OpeDetail = T001S5_A2138OpeDetail[0] ;
         zm1S62( -9) ;
      }
      pr_default.close(3);
      onLoadActions1S62( ) ;
   }

   public void onLoadActions1S62( )
   {
      AV23Pgmname = "Calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      A537OpeCodForMay = AV20OpeCodForMay ;
      httpContext.ajax_rsp_assign_attri("", false, "A537OpeCodForMay", A537OpeCodForMay);
   }

   public void checkExtendedTable1S62( )
   {
      nIsDirty_62 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV23Pgmname = "Calculo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      /* Using cursor T001S4 */
      pr_default.execute(2, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(2);
      GXv_char6[0] = AV20OpeCodForMay ;
      new web.convertircalculomayus(remoteHandle, context).execute( A74idOperando, GXv_char6) ;
      calculo_impl.this.AV20OpeCodForMay = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCodForMay", AV20OpeCodForMay);
      nIsDirty_62 = (short)(1) ;
      A537OpeCodForMay = AV20OpeCodForMay ;
      httpContext.ajax_rsp_assign_attri("", false, "A537OpeCodForMay", A537OpeCodForMay);
   }

   public void closeExtendedTableCursors1S62( )
   {
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_10( short A46PaiCod )
   {
      /* Using cursor T001S6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
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

   public void getKey1S62( )
   {
      /* Using cursor T001S7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound62 = (short)(1) ;
      }
      else
      {
         RcdFound62 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T001S3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm1S62( 9) ;
         RcdFound62 = (short)(1) ;
         A74idOperando = T001S3_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         A473OpeCodFormula = T001S3_A473OpeCodFormula[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A473OpeCodFormula", A473OpeCodFormula);
         A474OpeDescripcion = T001S3_A474OpeDescripcion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A474OpeDescripcion", A474OpeDescripcion);
         A537OpeCodForMay = T001S3_A537OpeCodForMay[0] ;
         A932OpeEsCant = T001S3_A932OpeEsCant[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
         A1032OpeAliEs = T001S3_A1032OpeAliEs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
         A1607OpeProcedure = T001S3_A1607OpeProcedure[0] ;
         A2073OpeHelp = T001S3_A2073OpeHelp[0] ;
         A2138OpeDetail = T001S3_A2138OpeDetail[0] ;
         A46PaiCod = T001S3_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         Z46PaiCod = A46PaiCod ;
         Z74idOperando = A74idOperando ;
         sMode62 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load1S62( ) ;
         if ( AnyError == 1 )
         {
            RcdFound62 = (short)(0) ;
            initializeNonKey1S62( ) ;
         }
         Gx_mode = sMode62 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound62 = (short)(0) ;
         initializeNonKey1S62( ) ;
         sMode62 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode62 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey1S62( ) ;
      if ( RcdFound62 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound62 = (short)(0) ;
      /* Using cursor T001S8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T001S8_A46PaiCod[0] < A46PaiCod ) || ( T001S8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001S8_A74idOperando[0], A74idOperando) < 0 ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T001S8_A46PaiCod[0] > A46PaiCod ) || ( T001S8_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001S8_A74idOperando[0], A74idOperando) > 0 ) ) )
         {
            A46PaiCod = T001S8_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = T001S8_A74idOperando[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            RcdFound62 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound62 = (short)(0) ;
      /* Using cursor T001S9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A74idOperando});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T001S9_A46PaiCod[0] > A46PaiCod ) || ( T001S9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001S9_A74idOperando[0], A74idOperando) > 0 ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T001S9_A46PaiCod[0] < A46PaiCod ) || ( T001S9_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T001S9_A74idOperando[0], A74idOperando) < 0 ) ) )
         {
            A46PaiCod = T001S9_A46PaiCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
            A74idOperando = T001S9_A74idOperando[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
            RcdFound62 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey1S62( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = cmbidOperando.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert1S62( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound62 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A74idOperando = Z74idOperando ;
               httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "PAICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = cmbidOperando.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update1S62( ) ;
               GX_FocusControl = cmbidOperando.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = cmbidOperando.getInternalname() ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert1S62( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "PAICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = cmbidOperando.getInternalname() ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert1S62( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A74idOperando, Z74idOperando) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = Z74idOperando ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = cmbidOperando.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency1S62( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T001S2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"calculo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z473OpeCodFormula, T001S2_A473OpeCodFormula[0]) != 0 ) || ( GXutil.strcmp(Z474OpeDescripcion, T001S2_A474OpeDescripcion[0]) != 0 ) || ( GXutil.strcmp(Z537OpeCodForMay, T001S2_A537OpeCodForMay[0]) != 0 ) || ( Z932OpeEsCant != T001S2_A932OpeEsCant[0] ) || ( Z1032OpeAliEs != T001S2_A1032OpeAliEs[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1607OpeProcedure, T001S2_A1607OpeProcedure[0]) != 0 ) || ( GXutil.strcmp(Z2138OpeDetail, T001S2_A2138OpeDetail[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z473OpeCodFormula, T001S2_A473OpeCodFormula[0]) != 0 )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeCodFormula");
               GXutil.writeLogRaw("Old: ",Z473OpeCodFormula);
               GXutil.writeLogRaw("Current: ",T001S2_A473OpeCodFormula[0]);
            }
            if ( GXutil.strcmp(Z474OpeDescripcion, T001S2_A474OpeDescripcion[0]) != 0 )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeDescripcion");
               GXutil.writeLogRaw("Old: ",Z474OpeDescripcion);
               GXutil.writeLogRaw("Current: ",T001S2_A474OpeDescripcion[0]);
            }
            if ( GXutil.strcmp(Z537OpeCodForMay, T001S2_A537OpeCodForMay[0]) != 0 )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeCodForMay");
               GXutil.writeLogRaw("Old: ",Z537OpeCodForMay);
               GXutil.writeLogRaw("Current: ",T001S2_A537OpeCodForMay[0]);
            }
            if ( Z932OpeEsCant != T001S2_A932OpeEsCant[0] )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeEsCant");
               GXutil.writeLogRaw("Old: ",Z932OpeEsCant);
               GXutil.writeLogRaw("Current: ",T001S2_A932OpeEsCant[0]);
            }
            if ( Z1032OpeAliEs != T001S2_A1032OpeAliEs[0] )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeAliEs");
               GXutil.writeLogRaw("Old: ",Z1032OpeAliEs);
               GXutil.writeLogRaw("Current: ",T001S2_A1032OpeAliEs[0]);
            }
            if ( GXutil.strcmp(Z1607OpeProcedure, T001S2_A1607OpeProcedure[0]) != 0 )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeProcedure");
               GXutil.writeLogRaw("Old: ",Z1607OpeProcedure);
               GXutil.writeLogRaw("Current: ",T001S2_A1607OpeProcedure[0]);
            }
            if ( GXutil.strcmp(Z2138OpeDetail, T001S2_A2138OpeDetail[0]) != 0 )
            {
               GXutil.writeLogln("calculo:[seudo value changed for attri]"+"OpeDetail");
               GXutil.writeLogRaw("Old: ",Z2138OpeDetail);
               GXutil.writeLogRaw("Current: ",T001S2_A2138OpeDetail[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"calculo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert1S62( )
   {
      beforeValidate1S62( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1S62( ) ;
      }
      if ( AnyError == 0 )
      {
         zm1S62( 0) ;
         checkOptimisticConcurrency1S62( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1S62( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert1S62( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001S10 */
                  pr_default.execute(8, new Object[] {A74idOperando, A473OpeCodFormula, A474OpeDescripcion, A537OpeCodForMay, Boolean.valueOf(A932OpeEsCant), Boolean.valueOf(A1032OpeAliEs), A1607OpeProcedure, A2073OpeHelp, A2138OpeDetail, Short.valueOf(A46PaiCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("calculo");
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
                        resetCaption1S0( ) ;
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
            load1S62( ) ;
         }
         endLevel1S62( ) ;
      }
      closeExtendedTableCursors1S62( ) ;
   }

   public void update1S62( )
   {
      beforeValidate1S62( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable1S62( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1S62( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm1S62( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate1S62( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T001S11 */
                  pr_default.execute(9, new Object[] {A473OpeCodFormula, A474OpeDescripcion, A537OpeCodForMay, Boolean.valueOf(A932OpeEsCant), Boolean.valueOf(A1032OpeAliEs), A1607OpeProcedure, A2073OpeHelp, A2138OpeDetail, Short.valueOf(A46PaiCod), A74idOperando});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("calculo");
                  if ( (pr_default.getStatus(9) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"calculo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate1S62( ) ;
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
         endLevel1S62( ) ;
      }
      closeExtendedTableCursors1S62( ) ;
   }

   public void deferredUpdate1S62( )
   {
   }

   public void delete( )
   {
      beforeValidate1S62( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency1S62( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls1S62( ) ;
         afterConfirm1S62( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete1S62( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T001S12 */
               pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("calculo");
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
      sMode62 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel1S62( ) ;
      Gx_mode = sMode62 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls1S62( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV23Pgmname = "Calculo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV23Pgmname", AV23Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T001S13 */
         pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod), A74idOperando});
         if ( (pr_default.getStatus(11) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Calculo_parametros", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(11);
      }
   }

   public void endLevel1S62( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete1S62( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "calculo");
         if ( AnyError == 0 )
         {
            confirmValues1S0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "calculo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart1S62( )
   {
      /* Scan By routine */
      /* Using cursor T001S14 */
      pr_default.execute(12);
      RcdFound62 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound62 = (short)(1) ;
         A46PaiCod = T001S14_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = T001S14_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext1S62( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound62 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound62 = (short)(1) ;
         A46PaiCod = T001S14_A46PaiCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A74idOperando = T001S14_A74idOperando[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
   }

   public void scanEnd1S62( )
   {
      pr_default.close(12);
   }

   public void afterConfirm1S62( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert1S62( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate1S62( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete1S62( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete1S62( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate1S62( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes1S62( )
   {
      cmbidOperando.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbidOperando.getInternalname(), "Enabled", GXutil.ltrimstr( cmbidOperando.getEnabled(), 5, 0), true);
      edtOpeCodFormula_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeCodFormula_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeCodFormula_Enabled), 5, 0), true);
      edtOpeDescripcion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtOpeDescripcion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtOpeDescripcion_Enabled), 5, 0), true);
      chkOpeEsCant.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeEsCant.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeEsCant.getEnabled(), 5, 0), true);
      chkOpeAliEs.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeAliEs.getInternalname(), "Enabled", GXutil.ltrimstr( chkOpeAliEs.getEnabled(), 5, 0), true);
      edtPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtPaiCod_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes1S62( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues1S0( )
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8idOperando))}, new String[] {"Gx_mode","PaiCod","idOperando"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Calculo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("OpeProcedure", GXutil.rtrim( localUtil.format( A1607OpeProcedure, "")));
      forbiddenHiddens.add("OpeDetail", GXutil.rtrim( localUtil.format( A2138OpeDetail, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("calculo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z74idOperando", GXutil.rtrim( Z74idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "Z473OpeCodFormula", GXutil.rtrim( Z473OpeCodFormula));
      web.GxWebStd.gx_hidden_field( httpContext, "Z474OpeDescripcion", Z474OpeDescripcion);
      web.GxWebStd.gx_hidden_field( httpContext, "Z537OpeCodForMay", GXutil.rtrim( Z537OpeCodForMay));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z932OpeEsCant", Z932OpeEsCant);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1032OpeAliEs", Z1032OpeAliEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1607OpeProcedure", Z1607OpeProcedure);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2138OpeDetail", Z2138OpeDetail);
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV7PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXPAICOD", GXutil.ltrim( localUtil.ntoc( AV21auxPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vIDOPERANDO", GXutil.rtrim( AV8idOperando));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vIDOPERANDO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8idOperando, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vOPECODFORMAY", GXutil.rtrim( AV20OpeCodForMay));
      web.GxWebStd.gx_hidden_field( httpContext, "OPECODFORMAY", GXutil.rtrim( A537OpeCodForMay));
      web.GxWebStd.gx_hidden_field( httpContext, "OPEPROCEDURE", A1607OpeProcedure);
      web.GxWebStd.gx_hidden_field( httpContext, "OPEHELP", A2073OpeHelp);
      web.GxWebStd.gx_hidden_field( httpContext, "OPEDETAIL", A2138OpeDetail);
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
      return formatLink("web.calculo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8idOperando))}, new String[] {"Gx_mode","PaiCod","idOperando"})  ;
   }

   public String getPgmname( )
   {
      return "Calculo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Calculo", "") ;
   }

   public void initializeNonKey1S62( )
   {
      AV20OpeCodForMay = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCodForMay", AV20OpeCodForMay);
      A473OpeCodFormula = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A473OpeCodFormula", A473OpeCodFormula);
      A474OpeDescripcion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A474OpeDescripcion", A474OpeDescripcion);
      A537OpeCodForMay = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A537OpeCodForMay", A537OpeCodForMay);
      A932OpeEsCant = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
      A1032OpeAliEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
      A1607OpeProcedure = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1607OpeProcedure", A1607OpeProcedure);
      A2073OpeHelp = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2073OpeHelp", A2073OpeHelp);
      A2138OpeDetail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2138OpeDetail", A2138OpeDetail);
      Z473OpeCodFormula = "" ;
      Z474OpeDescripcion = "" ;
      Z537OpeCodForMay = "" ;
      Z932OpeEsCant = false ;
      Z1032OpeAliEs = false ;
      Z1607OpeProcedure = "" ;
      Z2138OpeDetail = "" ;
   }

   public void initAll1S62( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A74idOperando = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      initializeNonKey1S62( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412201942266", true, true);
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
      httpContext.AddJavascriptSource("calculo.js", "?202412201942266", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      cmbidOperando.setInternalname( "IDOPERANDO" );
      edtOpeCodFormula_Internalname = "OPECODFORMULA" ;
      edtOpeDescripcion_Internalname = "OPEDESCRIPCION" ;
      chkOpeEsCant.setInternalname( "OPEESCANT" );
      chkOpeAliEs.setInternalname( "OPEALIES" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtPaiCod_Internalname = "PAICOD" ;
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
      Form.setCaption( httpContext.getMessage( "Calculo", "") );
      edtPaiCod_Jsonclick = "" ;
      edtPaiCod_Enabled = 1 ;
      edtPaiCod_Visible = 1 ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      chkOpeAliEs.setEnabled( 1 );
      chkOpeEsCant.setEnabled( 1 );
      edtOpeDescripcion_Enabled = 1 ;
      edtOpeCodFormula_Jsonclick = "" ;
      edtOpeCodFormula_Enabled = 1 ;
      cmbidOperando.setJsonclick( "" );
      cmbidOperando.setEnabled( 1 );
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

   public void xc_8_1S62( String A74idOperando )
   {
      GXv_char6[0] = AV20OpeCodForMay ;
      new web.convertircalculomayus(remoteHandle, context).execute( A74idOperando, GXv_char6) ;
      AV20OpeCodForMay = GXv_char6[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCodForMay", AV20OpeCodForMay);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( AV20OpeCodForMay))+"\"") ;
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
      cmbidOperando.setName( "IDOPERANDO" );
      cmbidOperando.setWebtags( "" );
      cmbidOperando.addItem("[antiguedad]", httpContext.getMessage( "Antiguedad en años", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_indemnizacion]", httpContext.getMessage( "Antig. fracción 3 meses = 1 año", ""), (short)(0));
      cmbidOperando.addItem("{concepto}", httpContext.getMessage( "Concepto", ""), (short)(0));
      cmbidOperando.addItem("{conceptos}", httpContext.getMessage( "Conceptos", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes]", httpContext.getMessage( "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.", ""), (short)(0));
      cmbidOperando.addItem("[dias_semestre]", httpContext.getMessage( "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.", ""), (short)(0));
      cmbidOperando.addItem("[dias_trabajados_mes]", httpContext.getMessage( "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[dias_remunerados_semestre]", httpContext.getMessage( "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.", ""), (short)(0));
      cmbidOperando.addItem("[plan_medico]", httpContext.getMessage( "Plan Médico", ""), (short)(0));
      cmbidOperando.addItem("[remu_var]", httpContext.getMessage( "Remuneraciones Variables", ""), (short)(0));
      cmbidOperando.addItem("[basico_mensual]", httpContext.getMessage( "Sueldo Básico Mensual", ""), (short)(0));
      cmbidOperando.addItem("[contr_OS_ali]", httpContext.getMessage( "Alícuota para contribución patronal destinada a obra social", ""), (short)(0));
      cmbidOperando.addItem("[contr_FSR_ali]", httpContext.getMessage( "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)", ""), (short)(0));
      cmbidOperando.addItem("[apo_Dif]", httpContext.getMessage( "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales", ""), (short)(0));
      cmbidOperando.addItem("[tipoLiq]", httpContext.getMessage( "Tipo de Liquidación", ""), (short)(0));
      cmbidOperando.addItem("[mes_Periodo]", httpContext.getMessage( "Mes Periodo", ""), (short)(0));
      cmbidOperando.addItem("[novedad_cantidad]", httpContext.getMessage( "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[novedad_importe]", httpContext.getMessage( "Importe informado en agenda de novedades", ""), (short)(0));
      cmbidOperando.addItem("[ART_ali]", httpContext.getMessage( "Alícuota de Contribución Patronal ART según Empresa", ""), (short)(0));
      cmbidOperando.addItem("[gan_cuotas]", httpContext.getMessage( "Ganancias - Cantidad de cuotas faltantes", ""), (short)(0));
      cmbidOperando.addItem("[con_discapacidad]", httpContext.getMessage( "Legajo con Discapacidad", ""), (short)(0));
      cmbidOperando.addItem("[sexo]", httpContext.getMessage( "Legajo Sexo", ""), (short)(0));
      cmbidOperando.addItem("[motivo_egreso]", httpContext.getMessage( "Legajo Motivo de Egreso", ""), (short)(0));
      cmbidOperando.addItem("[area]", httpContext.getMessage( "Legajo Area", ""), (short)(0));
      cmbidOperando.addItem("[categoria]", httpContext.getMessage( "Legajo Categoria", ""), (short)(0));
      cmbidOperando.addItem("[convenio]", httpContext.getMessage( "Legajo Convenio", ""), (short)(0));
      cmbidOperando.addItem("[clase]", httpContext.getMessage( "Legajo Clase", ""), (short)(0));
      cmbidOperando.addItem("[sindicato]", httpContext.getMessage( "Legajo Sindicato", ""), (short)(0));
      cmbidOperando.addItem("[obraSocial]", httpContext.getMessage( "Obra Social_", ""), (short)(0));
      cmbidOperando.addItem("[edad]", httpContext.getMessage( "Edad", ""), (short)(0));
      cmbidOperando.addItem("[monto_siradig]", httpContext.getMessage( "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.", ""), (short)(0));
      cmbidOperando.addItem("[hora_basica]", httpContext.getMessage( "Valor hora básico", ""), (short)(0));
      cmbidOperando.addItem("[horas_extras_exentas]", httpContext.getMessage( "Horas extras exentas.", ""), (short)(0));
      cmbidOperando.addItem("[exentas]", httpContext.getMessage( "Ganancias - remuneraciones totalmente exentas.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_ley_ganancias]", httpContext.getMessage( "Ganancias - Descuentos de ley sobre remuneración bruta", ""), (short)(0));
      cmbidOperando.addItem("[deduce_conyuge]", httpContext.getMessage( "Ganancias - Deduce conyuge", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos]", httpContext.getMessage( "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[cant_hijos_incap]", httpContext.getMessage( "Cantidad de hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[prc_ded_hijos_incap]", httpContext.getMessage( "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo", ""), (short)(0));
      cmbidOperando.addItem("[ded_esp_inc]", httpContext.getMessage( "Deduccion especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_anticipo_sac]", httpContext.getMessage( "Descuentos de ley sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[pagos_a_cuenta_anteriores]", httpContext.getMessage( "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_ley]", httpContext.getMessage( "Alicuota total descuentos de ley según legajo", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto_promedio]", httpContext.getMessage( "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado", ""), (short)(0));
      cmbidOperando.addItem("[nro_cuota]", httpContext.getMessage( "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.", ""), (short)(0));
      cmbidOperando.addItem("[agente_retencion]", httpContext.getMessage( "Empresa es agente de retención para el empleado", ""), (short)(0));
      cmbidOperando.addItem("[mni_zona]", httpContext.getMessage( "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_hijo_incap_zona]", httpContext.getMessage( "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_cony_zona]", httpContext.getMessage( "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[ded_especial_zona]", httpContext.getMessage( "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.", ""), (short)(0));
      cmbidOperando.addItem("[cant_cuotas]", httpContext.getMessage( "Cantidad de cuotas a retener ganancias", ""), (short)(0));
      cmbidOperando.addItem("[f1357_saldo]", httpContext.getMessage( "Saldo de F1357 del año anterior. Aplica en el mes de abril.", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_retencion]", httpContext.getMessage( "Descuentos de Ley más descuentos sobre anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[os_cantidad_adherentes]", httpContext.getMessage( "Cantidad de adherentes adicionales a la obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_mes]", httpContext.getMessage( "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default", ""), (short)(0));
      cmbidOperando.addItem("[os_apo_adic]", httpContext.getMessage( "Aporte adicional obra social", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornal]", httpContext.getMessage( "Horas por día que trabaja el empleado", ""), (short)(0));
      cmbidOperando.addItem("[dias_vacaciones]", httpContext.getMessage( "Cantidad de días de vacaciones del periodo", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_licencia]", httpContext.getMessage( "Càlculo de remuneraciòn por la licencia paga", ""), (short)(0));
      cmbidOperando.addItem("[viaticos]", httpContext.getMessage( "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[materiales_didacticos]", httpContext.getMessage( "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo", ""), (short)(0));
      cmbidOperando.addItem("[descuentos_sobre_gravados]", httpContext.getMessage( "Descuentos de ley sobre impuesto gravado", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_vacaciones_no_gozadas]", httpContext.getMessage( "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.", ""), (short)(0));
      cmbidOperando.addItem("[tope_indemnizatorio]", httpContext.getMessage( "Tope Indemnizatorio del convenio", ""), (short)(0));
      cmbidOperando.addItem("[alicuota_sindical]", httpContext.getMessage( "Alícuota de cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[adelanto_retencion]", httpContext.getMessage( "Adelanto de retencion de ganancias", ""), (short)(0));
      cmbidOperando.addItem("[adicional_convenio]", httpContext.getMessage( "Adicional por convenio", ""), (short)(0));
      cmbidOperando.addItem("[horas_jornada_completa]", httpContext.getMessage( "Cantidad de horas de la jornada completa", ""), (short)(0));
      cmbidOperando.addItem("[valor_categoria]", httpContext.getMessage( "Sueldo Categoria", ""), (short)(0));
      cmbidOperando.addItem("{feriado_trabajado_horas}", httpContext.getMessage( "Horas feriado trabajado", ""), (short)(0));
      cmbidOperando.addItem("[feriados_no_trabajados]", httpContext.getMessage( "Feriados no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_5]", httpContext.getMessage( "Base imponible 5 -Aportes INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_2]", httpContext.getMessage( "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_3]", httpContext.getMessage( "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_4]", httpContext.getMessage( "Base imponible 4 - APORTES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_apo_OS_FSR]", httpContext.getMessage( "base Diferencial - Aportes OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_dif_con_OS_FSR]", httpContext.getMessage( "Base diferencial - Contribuciones OS y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_8]", httpContext.getMessage( "base Imponible 8  -  CONTRIBUCIONES OS Y FSR", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_9]", httpContext.getMessage( "base Imponible 9 - CONTRIBUCIONES LRT", ""), (short)(0));
      cmbidOperando.addItem("[importe_a_detraer]", httpContext.getMessage( "Importe a detraer", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_6]", httpContext.getMessage( "Base imponible 6 - APORTES DIFERENCIALES", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_7]", httpContext.getMessage( "base Imponible 7 - APORTES ESPECIALES", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_adelanto_vacaciones]", httpContext.getMessage( "Remuneracion adelanto de vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_bruto]", httpContext.getMessage( "Sueldo Bruto", ""), (short)(0));
      cmbidOperando.addItem("[descuento_adelanto]", httpContext.getMessage( "Descuento por adelanto", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_tope]", httpContext.getMessage( "Días para proporcionar tope para cálculo de máximo imponible de sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1_sueldo]", httpContext.getMessage( "Tope para base imponible 1 sueldo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_sac]", httpContext.getMessage( "Tope para base imponible para SAC", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_adelantoVac]", httpContext.getMessage( "Tope para base imponible para adelanto de vacaciones de mes próximo", ""), (short)(0));
      cmbidOperando.addItem("[base_imponible_1]", httpContext.getMessage( "Base imponible 1 - Aportes SIPA", ""), (short)(0));
      cmbidOperando.addItem("[sueldo_basico]", httpContext.getMessage( "Sueldo básico", ""), (short)(0));
      cmbidOperando.addItem("[calculo_sac]", httpContext.getMessage( "Cálculo SAC", ""), (short)(0));
      cmbidOperando.addItem("[haberes_sac]", httpContext.getMessage( "Haberes Sac", ""), (short)(0));
      cmbidOperando.addItem("[anticipo_sac]", httpContext.getMessage( "Anticipo de SAC", ""), (short)(0));
      cmbidOperando.addItem("[sac_estimado]", httpContext.getMessage( "Estimación de próximo SAC", ""), (short)(0));
      cmbidOperando.addItem("[total_exentos_sin_sac]", httpContext.getMessage( "Total Exentos Sin Sac", ""), (short)(0));
      cmbidOperando.addItem("[cuotas_prorrateo]", httpContext.getMessage( "Cuotas prorrateos", ""), (short)(0));
      cmbidOperando.addItem("[prorrateables]", httpContext.getMessage( "Prorrateables", ""), (short)(0));
      cmbidOperando.addItem("[exento_concepto]", httpContext.getMessage( "Cálculo exento", ""), (short)(0));
      cmbidOperando.addItem("[deduccion]", httpContext.getMessage( "Calculo Deduccion", ""), (short)(0));
      cmbidOperando.addItem("[retencion_ganancias]", httpContext.getMessage( "Retención ganancias", ""), (short)(0));
      cmbidOperando.addItem("[empresa_antiguedad]", httpContext.getMessage( "Importe o alícuota para antiguedad por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[empresa_presentismo]", httpContext.getMessage( "Importe o alícuota para presentismo por empresa (fuera de convenio)", ""), (short)(0));
      cmbidOperando.addItem("[asistencia_perfecta]", httpContext.getMessage( "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1", ""), (short)(0));
      cmbidOperando.addItem("[es_primera_quincena]", httpContext.getMessage( "Es primera quincena", ""), (short)(0));
      cmbidOperando.addItem("[ART_fijo]", httpContext.getMessage( "Importe fijo de ART", ""), (short)(0));
      cmbidOperando.addItem("[contr_jub_ali]", httpContext.getMessage( "Alìcuota de contribuciòn dej ubilaciòn", ""), (short)(0));
      cmbidOperando.addItem("[contr_inssjyp_ali]", httpContext.getMessage( "Alìcuota de contribución PAMI", ""), (short)(0));
      cmbidOperando.addItem("[contr_aaff_ali]", httpContext.getMessage( "Alìcuota de contribuciòn asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("[contr_fne_ali]", httpContext.getMessage( "Alìcuota de contribuciòn fondo nacional de empleo", ""), (short)(0));
      cmbidOperando.addItem("[obligacion]", httpContext.getMessage( "Obligación", ""), (short)(0));
      cmbidOperando.addItem("[liquidar_sac]", httpContext.getMessage( "liquidar_sac", ""), (short)(0));
      cmbidOperando.addItem("[plus_vacacional]", httpContext.getMessage( "Plus Vacacional", ""), (short)(0));
      cmbidOperando.addItem("[no_laborables]", httpContext.getMessage( "Días no laborables no trabajados", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_descuento]", httpContext.getMessage( "Ausencias injustificadas", ""), (short)(0));
      cmbidOperando.addItem("[dias_proporcionar_sac]", httpContext.getMessage( "Cantidad de días para proporcionar SAC", ""), (short)(0));
      cmbidOperando.addItem("[hora_normal]", httpContext.getMessage( "Valor de hora normal", ""), (short)(0));
      cmbidOperando.addItem("[extra]", httpContext.getMessage( "Aumento de hora extra sobre hora normal", ""), (short)(0));
      cmbidOperando.addItem("[recargo]", httpContext.getMessage( "Recargo por tipo de trabajo (por ejemplo nocturno)", ""), (short)(0));
      cmbidOperando.addItem("[jubilacion]", httpContext.getMessage( "Jubilación", ""), (short)(0));
      cmbidOperando.addItem("[obra_social]", httpContext.getMessage( "Obra Social", ""), (short)(0));
      cmbidOperando.addItem("[ley_19032]", httpContext.getMessage( "Ley 19032", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_empresa]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de la empresa", ""), (short)(0));
      cmbidOperando.addItem("[remuneracion_accidente_ART]", httpContext.getMessage( "Incapacidad laboral temporaria a cargo de ART", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes]", httpContext.getMessage( "Ultimo día del mes", ""), (short)(0));
      cmbidOperando.addItem("[dia_fecha_egreso]", httpContext.getMessage( "Día de fecha de egreso", ""), (short)(0));
      cmbidOperando.addItem("[indemnizacion_antiguedad]", httpContext.getMessage( "Indemnización por antiguedad", ""), (short)(0));
      cmbidOperando.addItem("[proporcion_antiguedad_motivo]", httpContext.getMessage( "Proporción según antiguedad y motivo de egreso definido en el concepto", ""), (short)(0));
      cmbidOperando.addItem("[reintegro_guarderia]", httpContext.getMessage( "Reintegro por gastos de guardería", ""), (short)(0));
      cmbidOperando.addItem("[beneficio_guarderia]", httpContext.getMessage( "Beneficio Guarderia", ""), (short)(0));
      cmbidOperando.addItem("[ultimo_dia_mes_egreso]", httpContext.getMessage( "Ultimo día del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[dias_mes_egreso]", httpContext.getMessage( "Cantidad de días del mes de egreso", ""), (short)(0));
      cmbidOperando.addItem("[cuota_sindical]", httpContext.getMessage( "Cuota sindical", ""), (short)(0));
      cmbidOperando.addItem("[obra_social_adherentes]", httpContext.getMessage( "Obra Social Adherentes", ""), (short)(0));
      cmbidOperando.addItem("[antiguedad_importe]", httpContext.getMessage( "Antiguedad importe", ""), (short)(0));
      cmbidOperando.addItem("[presentismo_importe]", httpContext.getMessage( "Presentismo importe", ""), (short)(0));
      cmbidOperando.addItem("{sueldo}", httpContext.getMessage( "Sueldo", ""), (short)(0));
      cmbidOperando.addItem("{hora_completa}", httpContext.getMessage( "Hora básica más adicional", ""), (short)(0));
      cmbidOperando.addItem("{feriados_trabajados}", httpContext.getMessage( "Feriados trabajados", ""), (short)(0));
      cmbidOperando.addItem("[vacaciones_descuento]", httpContext.getMessage( "Descuento por días no trabajados por vacaciones", ""), (short)(0));
      cmbidOperando.addItem("[licencias_descuento]", httpContext.getMessage( "Descuento por días no trabajados por licencias", ""), (short)(0));
      cmbidOperando.addItem("{feriados_no_trabajados_descuento}", httpContext.getMessage( "Descuento por días no trabajados feriados", ""), (short)(0));
      cmbidOperando.addItem("{no_laborables_descuento}", httpContext.getMessage( "Descuento por días no trabajados no laborables", ""), (short)(0));
      cmbidOperando.addItem("{sac}", httpContext.getMessage( "Sueldo anual complementario", ""), (short)(0));
      cmbidOperando.addItem("{sac_proporcional}", httpContext.getMessage( "SAC Proporcional", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_adicional}", httpContext.getMessage( "Sueldo Adicional", ""), (short)(0));
      cmbidOperando.addItem("{vacaciones_no_gozadas_ant}", httpContext.getMessage( "Vacaciones no gozadas de año anterior", ""), (short)(0));
      cmbidOperando.addItem("{egreso_descuento}", httpContext.getMessage( "Descuento por días no trabajados por egreso", ""), (short)(0));
      cmbidOperando.addItem("{obra_social_diferencial}", httpContext.getMessage( "Obra social diferencial", ""), (short)(0));
      cmbidOperando.addItem("{dias_HastaFinSemestre}", httpContext.getMessage( "Dias faltantes hasta el fin del semestre", ""), (short)(0));
      cmbidOperando.addItem("{tratamiento_exencion}", httpContext.getMessage( "Cálculo exento por tratamiento de exención de IIGG", ""), (short)(0));
      cmbidOperando.addItem("{horas_nocturnas}", httpContext.getMessage( "Adicional por horas nocturna", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_50}", httpContext.getMessage( "Horas extras al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_50}", httpContext.getMessage( "Horas extras nocturnas al 50%", ""), (short)(0));
      cmbidOperando.addItem("{extras_nocturnas_al_100}", httpContext.getMessage( "Horas extras nocturnas al 100%", ""), (short)(0));
      cmbidOperando.addItem("{extras_al_100}", httpContext.getMessage( "Horas extras al 100%", ""), (short)(0));
      cmbidOperando.addItem("{retroactivo}", httpContext.getMessage( "Recálculo de liquidaciones anteriores para calcular valores retroactivos", ""), (short)(0));
      cmbidOperando.addItem("{fondo_cese}", httpContext.getMessage( "Fondo de cese laboral", ""), (short)(0));
      cmbidOperando.addItem("{plus_licencia}", httpContext.getMessage( "Plus Licencia", ""), (short)(0));
      cmbidOperando.addItem("{redondeo}", httpContext.getMessage( "Redondeo", ""), (short)(0));
      cmbidOperando.addItem("{leg_prop_adi}", httpContext.getMessage( "Propiedad adicional de legajo", ""), (short)(0));
      cmbidOperando.addItem("{ded_art_30}", httpContext.getMessage( "Deducciones artículo 30", ""), (short)(0));
      cmbidOperando.addItem("{devolucion_ganancias}", httpContext.getMessage( "Devolución ganancias", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_men}", httpContext.getMessage( "Deducciones generales mensuales", ""), (short)(0));
      cmbidOperando.addItem("{ded_gen_anu}", httpContext.getMessage( "Deducciones generales anuales", ""), (short)(0));
      cmbidOperando.addItem("{rem_gravada_gan}", httpContext.getMessage( "Remuneración gravada en ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta}", httpContext.getMessage( "Ganancia neta para impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gnsi_sin_dei}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada", ""), (short)(0));
      cmbidOperando.addItem("{gnsi}", httpContext.getMessage( "Ganancia neta sujeta a impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{gan_neta_topes}", httpContext.getMessage( "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{calculo_iigg_neto}", httpContext.getMessage( "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores", ""), (short)(0));
      cmbidOperando.addItem("{importe_iigg}", httpContext.getMessage( "Importe a retener de impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("[calculo_iigg]", httpContext.getMessage( "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_ganancias}", httpContext.getMessage( "Sueldo Bruto más sueldo bruto de otros empleos", ""), (short)(0));
      cmbidOperando.addItem("{sueldo_bruto_menos_ley}", httpContext.getMessage( "Sueldo bruto menos descuentos de ley", ""), (short)(0));
      cmbidOperando.addItem("{alcanza_ganancias}", httpContext.getMessage( "Empleado es alcanzado por impuesto a las ganancias", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_jubilacion}", httpContext.getMessage( "Contribución jubilación", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_inssjp}", httpContext.getMessage( "Contribución  ley 19032", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_aaff}", httpContext.getMessage( "Contribución asignaciones familiares", ""), (short)(0));
      cmbidOperando.addItem("{contribucion_fne}", httpContext.getMessage( "Contribución FNE", ""), (short)(0));
      cmbidOperando.addItem("{grossing_up}", httpContext.getMessage( "Grossing up", ""), (short)(0));
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
         httpContext.ajax_rsp_assign_attri("", false, "A74idOperando", A74idOperando);
      }
      chkOpeEsCant.setName( "OPEESCANT" );
      chkOpeEsCant.setWebtags( "" );
      chkOpeEsCant.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeEsCant.getInternalname(), "TitleCaption", chkOpeEsCant.getCaption(), true);
      chkOpeEsCant.setCheckedValue( "false" );
      A932OpeEsCant = GXutil.strtobool( GXutil.booltostr( A932OpeEsCant)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A932OpeEsCant", A932OpeEsCant);
      chkOpeAliEs.setName( "OPEALIES" );
      chkOpeAliEs.setWebtags( "" );
      chkOpeAliEs.setCaption( "" );
      httpContext.ajax_rsp_assign_prop("", false, chkOpeAliEs.getInternalname(), "TitleCaption", chkOpeAliEs.getCaption(), true);
      chkOpeAliEs.setCheckedValue( "false" );
      A1032OpeAliEs = GXutil.strtobool( GXutil.booltostr( A1032OpeAliEs)) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1032OpeAliEs", A1032OpeAliEs);
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

   public void valid_Idoperando( )
   {
      A74idOperando = cmbidOperando.getValue() ;
      GXv_char6[0] = AV20OpeCodForMay ;
      new web.convertircalculomayus(remoteHandle, context).execute( A74idOperando, GXv_char6) ;
      calculo_impl.this.AV20OpeCodForMay = GXv_char6[0] ;
      AV20OpeCodForMay = this.AV20OpeCodForMay ;
      A537OpeCodForMay = AV20OpeCodForMay ;
      dynload_actions( ) ;
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A537OpeCodForMay", GXutil.rtrim( A537OpeCodForMay));
      httpContext.ajax_rsp_assign_attri("", false, "AV20OpeCodForMay", GXutil.rtrim( AV20OpeCodForMay));
   }

   public void valid_Paicod( )
   {
      /* Using cursor T001S15 */
      pr_default.execute(13, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(13) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtPaiCod_Internalname ;
      }
      pr_default.close(13);
      dynload_actions( ) ;
      if ( cmbidOperando.getItemCount() > 0 )
      {
         A74idOperando = cmbidOperando.getValidValue(A74idOperando) ;
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbidOperando.setValue( GXutil.rtrim( A74idOperando) );
      }
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8idOperando',fld:'vIDOPERANDO',pic:'',hsh:true},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'AV8idOperando',fld:'vIDOPERANDO',pic:'',hsh:true},{av:'A1607OpeProcedure',fld:'OPEPROCEDURE',pic:''},{av:'A2138OpeDetail',fld:'OPEDETAIL',pic:''},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e121S2',iparms:[{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]}");
      setEventMetadata("VALID_IDOPERANDO","{handler:'valid_Idoperando',iparms:[{av:'cmbidOperando'},{av:'A74idOperando',fld:'IDOPERANDO',pic:''},{av:'AV20OpeCodForMay',fld:'vOPECODFORMAY',pic:''},{av:'A537OpeCodForMay',fld:'OPECODFORMAY',pic:''},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("VALID_IDOPERANDO",",oparms:[{av:'A537OpeCodForMay',fld:'OPECODFORMAY',pic:''},{av:'AV20OpeCodForMay',fld:'vOPECODFORMAY',pic:''},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]}");
      setEventMetadata("VALID_PAICOD","{handler:'valid_Paicod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]");
      setEventMetadata("VALID_PAICOD",",oparms:[{av:'A932OpeEsCant',fld:'OPEESCANT',pic:''},{av:'A1032OpeAliEs',fld:'OPEALIES',pic:''}]}");
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
      wcpOAV8idOperando = "" ;
      Z74idOperando = "" ;
      Z473OpeCodFormula = "" ;
      Z474OpeDescripcion = "" ;
      Z537OpeCodForMay = "" ;
      Z1607OpeProcedure = "" ;
      Z2138OpeDetail = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A74idOperando = "" ;
      Gx_mode = "" ;
      AV8idOperando = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A473OpeCodFormula = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A474OpeDescripcion = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A537OpeCodForMay = "" ;
      A1607OpeProcedure = "" ;
      A2138OpeDetail = "" ;
      AV20OpeCodForMay = "" ;
      A2073OpeHelp = "" ;
      AV23Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode62 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      GXv_int4 = new int[1] ;
      GXv_int5 = new short[1] ;
      Z2073OpeHelp = "" ;
      T001S5_A74idOperando = new String[] {""} ;
      T001S5_A473OpeCodFormula = new String[] {""} ;
      T001S5_A474OpeDescripcion = new String[] {""} ;
      T001S5_A537OpeCodForMay = new String[] {""} ;
      T001S5_A932OpeEsCant = new boolean[] {false} ;
      T001S5_A1032OpeAliEs = new boolean[] {false} ;
      T001S5_A1607OpeProcedure = new String[] {""} ;
      T001S5_A2073OpeHelp = new String[] {""} ;
      T001S5_A2138OpeDetail = new String[] {""} ;
      T001S5_A46PaiCod = new short[1] ;
      T001S4_A46PaiCod = new short[1] ;
      T001S6_A46PaiCod = new short[1] ;
      T001S7_A46PaiCod = new short[1] ;
      T001S7_A74idOperando = new String[] {""} ;
      T001S3_A74idOperando = new String[] {""} ;
      T001S3_A473OpeCodFormula = new String[] {""} ;
      T001S3_A474OpeDescripcion = new String[] {""} ;
      T001S3_A537OpeCodForMay = new String[] {""} ;
      T001S3_A932OpeEsCant = new boolean[] {false} ;
      T001S3_A1032OpeAliEs = new boolean[] {false} ;
      T001S3_A1607OpeProcedure = new String[] {""} ;
      T001S3_A2073OpeHelp = new String[] {""} ;
      T001S3_A2138OpeDetail = new String[] {""} ;
      T001S3_A46PaiCod = new short[1] ;
      T001S8_A46PaiCod = new short[1] ;
      T001S8_A74idOperando = new String[] {""} ;
      T001S9_A46PaiCod = new short[1] ;
      T001S9_A74idOperando = new String[] {""} ;
      T001S2_A74idOperando = new String[] {""} ;
      T001S2_A473OpeCodFormula = new String[] {""} ;
      T001S2_A474OpeDescripcion = new String[] {""} ;
      T001S2_A537OpeCodForMay = new String[] {""} ;
      T001S2_A932OpeEsCant = new boolean[] {false} ;
      T001S2_A1032OpeAliEs = new boolean[] {false} ;
      T001S2_A1607OpeProcedure = new String[] {""} ;
      T001S2_A2073OpeHelp = new String[] {""} ;
      T001S2_A2138OpeDetail = new String[] {""} ;
      T001S2_A46PaiCod = new short[1] ;
      T001S13_A46PaiCod = new short[1] ;
      T001S13_A74idOperando = new String[] {""} ;
      T001S13_A2098CalParId = new String[] {""} ;
      T001S14_A46PaiCod = new short[1] ;
      T001S14_A74idOperando = new String[] {""} ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXv_char6 = new String[1] ;
      ZV20OpeCodForMay = "" ;
      T001S15_A46PaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calculo__default(),
         new Object[] {
             new Object[] {
            T001S2_A74idOperando, T001S2_A473OpeCodFormula, T001S2_A474OpeDescripcion, T001S2_A537OpeCodForMay, T001S2_A932OpeEsCant, T001S2_A1032OpeAliEs, T001S2_A1607OpeProcedure, T001S2_A2073OpeHelp, T001S2_A2138OpeDetail, T001S2_A46PaiCod
            }
            , new Object[] {
            T001S3_A74idOperando, T001S3_A473OpeCodFormula, T001S3_A474OpeDescripcion, T001S3_A537OpeCodForMay, T001S3_A932OpeEsCant, T001S3_A1032OpeAliEs, T001S3_A1607OpeProcedure, T001S3_A2073OpeHelp, T001S3_A2138OpeDetail, T001S3_A46PaiCod
            }
            , new Object[] {
            T001S4_A46PaiCod
            }
            , new Object[] {
            T001S5_A74idOperando, T001S5_A473OpeCodFormula, T001S5_A474OpeDescripcion, T001S5_A537OpeCodForMay, T001S5_A932OpeEsCant, T001S5_A1032OpeAliEs, T001S5_A1607OpeProcedure, T001S5_A2073OpeHelp, T001S5_A2138OpeDetail, T001S5_A46PaiCod
            }
            , new Object[] {
            T001S6_A46PaiCod
            }
            , new Object[] {
            T001S7_A46PaiCod, T001S7_A74idOperando
            }
            , new Object[] {
            T001S8_A46PaiCod, T001S8_A74idOperando
            }
            , new Object[] {
            T001S9_A46PaiCod, T001S9_A74idOperando
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T001S13_A46PaiCod, T001S13_A74idOperando, T001S13_A2098CalParId
            }
            , new Object[] {
            T001S14_A46PaiCod, T001S14_A74idOperando
            }
            , new Object[] {
            T001S15_A46PaiCod
            }
         }
      );
      AV23Pgmname = "Calculo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte gxajaxcallmode ;
   private short wcpOAV7PaiCod ;
   private short Z46PaiCod ;
   private short A46PaiCod ;
   private short AV7PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short AV21auxPaiCod ;
   private short RcdFound62 ;
   private short GXv_int5[] ;
   private short nIsDirty_62 ;
   private int trnEnded ;
   private int edtOpeCodFormula_Enabled ;
   private int edtOpeDescripcion_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int edtPaiCod_Visible ;
   private int edtPaiCod_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int AV22CliCod ;
   private int GXv_int4[] ;
   private int GX_JID ;
   private int idxLst ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8idOperando ;
   private String Z74idOperando ;
   private String Z473OpeCodFormula ;
   private String Z537OpeCodForMay ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A74idOperando ;
   private String Gx_mode ;
   private String AV8idOperando ;
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
   private String edtOpeCodFormula_Internalname ;
   private String A473OpeCodFormula ;
   private String edtOpeCodFormula_Jsonclick ;
   private String edtOpeDescripcion_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtPaiCod_Internalname ;
   private String edtPaiCod_Jsonclick ;
   private String A537OpeCodForMay ;
   private String AV20OpeCodForMay ;
   private String AV23Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode62 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXv_char6[] ;
   private String ZV20OpeCodForMay ;
   private boolean Z932OpeEsCant ;
   private boolean Z1032OpeAliEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A932OpeEsCant ;
   private boolean A1032OpeAliEs ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String A2073OpeHelp ;
   private String Z2073OpeHelp ;
   private String Z474OpeDescripcion ;
   private String Z1607OpeProcedure ;
   private String Z2138OpeDetail ;
   private String A474OpeDescripcion ;
   private String A1607OpeProcedure ;
   private String A2138OpeDetail ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbidOperando ;
   private ICheckbox chkOpeEsCant ;
   private ICheckbox chkOpeAliEs ;
   private IDataStoreProvider pr_default ;
   private String[] T001S5_A74idOperando ;
   private String[] T001S5_A473OpeCodFormula ;
   private String[] T001S5_A474OpeDescripcion ;
   private String[] T001S5_A537OpeCodForMay ;
   private boolean[] T001S5_A932OpeEsCant ;
   private boolean[] T001S5_A1032OpeAliEs ;
   private String[] T001S5_A1607OpeProcedure ;
   private String[] T001S5_A2073OpeHelp ;
   private String[] T001S5_A2138OpeDetail ;
   private short[] T001S5_A46PaiCod ;
   private short[] T001S4_A46PaiCod ;
   private short[] T001S6_A46PaiCod ;
   private short[] T001S7_A46PaiCod ;
   private String[] T001S7_A74idOperando ;
   private String[] T001S3_A74idOperando ;
   private String[] T001S3_A473OpeCodFormula ;
   private String[] T001S3_A474OpeDescripcion ;
   private String[] T001S3_A537OpeCodForMay ;
   private boolean[] T001S3_A932OpeEsCant ;
   private boolean[] T001S3_A1032OpeAliEs ;
   private String[] T001S3_A1607OpeProcedure ;
   private String[] T001S3_A2073OpeHelp ;
   private String[] T001S3_A2138OpeDetail ;
   private short[] T001S3_A46PaiCod ;
   private short[] T001S8_A46PaiCod ;
   private String[] T001S8_A74idOperando ;
   private short[] T001S9_A46PaiCod ;
   private String[] T001S9_A74idOperando ;
   private String[] T001S2_A74idOperando ;
   private String[] T001S2_A473OpeCodFormula ;
   private String[] T001S2_A474OpeDescripcion ;
   private String[] T001S2_A537OpeCodForMay ;
   private boolean[] T001S2_A932OpeEsCant ;
   private boolean[] T001S2_A1032OpeAliEs ;
   private String[] T001S2_A1607OpeProcedure ;
   private String[] T001S2_A2073OpeHelp ;
   private String[] T001S2_A2138OpeDetail ;
   private short[] T001S2_A46PaiCod ;
   private short[] T001S13_A46PaiCod ;
   private String[] T001S13_A74idOperando ;
   private String[] T001S13_A2098CalParId ;
   private short[] T001S14_A46PaiCod ;
   private String[] T001S14_A74idOperando ;
   private short[] T001S15_A46PaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
}

final  class calculo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T001S2", "SELECT idOperando, OpeCodFormula, OpeDescripcion, OpeCodForMay, OpeEsCant, OpeAliEs, OpeProcedure, OpeHelp, OpeDetail, PaiCod FROM calculo WHERE PaiCod = ? AND idOperando = ?  FOR UPDATE OF calculo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S3", "SELECT idOperando, OpeCodFormula, OpeDescripcion, OpeCodForMay, OpeEsCant, OpeAliEs, OpeProcedure, OpeHelp, OpeDetail, PaiCod FROM calculo WHERE PaiCod = ? AND idOperando = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S4", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S5", "SELECT TM1.idOperando, TM1.OpeCodFormula, TM1.OpeDescripcion, TM1.OpeCodForMay, TM1.OpeEsCant, TM1.OpeAliEs, TM1.OpeProcedure, TM1.OpeHelp, TM1.OpeDetail, TM1.PaiCod FROM calculo TM1 WHERE TM1.PaiCod = ? and TM1.idOperando = ( ?) ORDER BY TM1.PaiCod, TM1.idOperando ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S6", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S7", "SELECT PaiCod, idOperando FROM calculo WHERE PaiCod = ? AND idOperando = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S8", "SELECT PaiCod, idOperando FROM calculo WHERE ( PaiCod > ? or PaiCod = ? and idOperando > ( ?)) ORDER BY PaiCod, idOperando  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001S9", "SELECT PaiCod, idOperando FROM calculo WHERE ( PaiCod < ? or PaiCod = ? and idOperando < ( ?)) ORDER BY PaiCod DESC, idOperando DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T001S10", "SAVEPOINT gxupdate;INSERT INTO calculo(idOperando, OpeCodFormula, OpeDescripcion, OpeCodForMay, OpeEsCant, OpeAliEs, OpeProcedure, OpeHelp, OpeDetail, PaiCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001S11", "SAVEPOINT gxupdate;UPDATE calculo SET OpeCodFormula=?, OpeDescripcion=?, OpeCodForMay=?, OpeEsCant=?, OpeAliEs=?, OpeProcedure=?, OpeHelp=?, OpeDetail=?  WHERE PaiCod = ? AND idOperando = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T001S12", "SAVEPOINT gxupdate;DELETE FROM calculo  WHERE PaiCod = ? AND idOperando = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T001S13", "SELECT PaiCod, idOperando, CalParId FROM Calculo_parametros WHERE PaiCod = ? AND idOperando = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T001S14", "SELECT PaiCod, idOperando FROM calculo ORDER BY PaiCod, idOperando ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T001S15", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getLongVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 40);
               return;
            case 8 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setString(2, (String)parms[1], 40);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[5]).booleanValue());
               stmt.setVarchar(7, (String)parms[6], 40, false);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setVarchar(9, (String)parms[8], 400, false);
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               return;
            case 9 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setNLongVarchar(7, (String)parms[6], false);
               stmt.setVarchar(8, (String)parms[7], 400, false);
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

