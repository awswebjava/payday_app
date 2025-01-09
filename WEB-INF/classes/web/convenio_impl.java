package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class convenio_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxCallCrl"+"_"+"CONVESINCOD") == 0 )
      {
         AV17PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV17PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PaiCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17PaiCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxdlaconvesincod0E106( AV17PaiCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel6"+"_"+"CONVEDESCRISINAC") == 0 )
      {
         A160ConveDescri = httpContext.GetPar( "ConveDescri") ;
         httpContext.ajax_rsp_assign_attri("", false, "A160ConveDescri", A160ConveDescri);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx6asaconvedescrisinac0E106( A160ConveDescri) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel12"+"_"+"") == 0 )
      {
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_22") == 0 )
      {
         A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A935ConveSinCod = httpContext.GetPar( "ConveSinCod") ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_22( A46PaiCod, A935ConveSinCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_24") == 0 )
      {
         A2227propCod = httpContext.GetPar( "propCod") ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_24( A2227propCod) ;
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
            AV17PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV17PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV17PaiCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17PaiCod), "ZZZ9")));
            AV8ConveCodigo = httpContext.GetPar( "ConveCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8ConveCodigo", AV8ConveCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVECODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConveCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Convenio", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtConveCodigo_Internalname ;
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
      nRC_GXsfl_65 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_65"))) ;
      nGXsfl_65_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_65_idx"))) ;
      sGXsfl_65_idx = httpContext.GetPar( "sGXsfl_65_idx") ;
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

   public convenio_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public convenio_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convenio_impl.class ));
   }

   public convenio_impl( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      dynConveSinCod = new HTMLChoice();
      cmbConvScrapTDoc = new HTMLChoice();
      cmbConvScrapTipo = new HTMLChoice();
      cmbpropTipoDato = new HTMLChoice();
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
      if ( dynConveSinCod.getItemCount() > 0 )
      {
         A935ConveSinCod = dynConveSinCod.getValidValue(A935ConveSinCod) ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         dynConveSinCod.setValue( GXutil.rtrim( A935ConveSinCod) );
         httpContext.ajax_rsp_assign_prop("", false, dynConveSinCod.getInternalname(), "Values", dynConveSinCod.ToJavascriptSource(), true);
      }
      if ( cmbConvScrapTDoc.getItemCount() > 0 )
      {
         A1919ConvScrapTDoc = cmbConvScrapTDoc.getValidValue(A1919ConvScrapTDoc) ;
         n1919ConvScrapTDoc = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConvScrapTDoc.setValue( GXutil.rtrim( A1919ConvScrapTDoc) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTDoc.getInternalname(), "Values", cmbConvScrapTDoc.ToJavascriptSource(), true);
      }
      if ( cmbConvScrapTipo.getItemCount() > 0 )
      {
         A1918ConvScrapTipo = cmbConvScrapTipo.getValidValue(A1918ConvScrapTipo) ;
         n1918ConvScrapTipo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbConvScrapTipo.setValue( GXutil.rtrim( A1918ConvScrapTipo) );
         httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTipo.getInternalname(), "Values", cmbConvScrapTipo.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveCodigo_Internalname, GXutil.rtrim( A9ConveCodigo), GXutil.rtrim( localUtil.format( A9ConveCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveCodigo_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveDescri_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveDescri_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtConveDescri_Internalname, A160ConveDescri, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtConveDescri_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+dynConveSinCod.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, dynConveSinCod.getInternalname(), httpContext.getMessage( "Sindicato", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, dynConveSinCod, dynConveSinCod.getInternalname(), GXutil.rtrim( A935ConveSinCod), 1, dynConveSinCod.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, dynConveSinCod.getEnabled(), 1, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_Convenio.htm");
      dynConveSinCod.setValue( GXutil.rtrim( A935ConveSinCod) );
      httpContext.ajax_rsp_assign_prop("", false, dynConveSinCod.getInternalname(), "Values", dynConveSinCod.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConveEscFrecAct_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConveEscFrecAct_Internalname, httpContext.getMessage( "Frecuenca de actualización (meses) de escalas salariales", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConveEscFrecAct_Internalname, GXutil.ltrim( localUtil.ntoc( A2131ConveEscFrecAct, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtConveEscFrecAct_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,37);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConveEscFrecAct_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConveEscFrecAct_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBusGoogle_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConvBusGoogle_Internalname, httpContext.getMessage( "Bus Google", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConvBusGoogle_Internalname, A1915ConvBusGoogle, GXutil.rtrim( localUtil.format( A1915ConvBusGoogle, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConvBusGoogle_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBusGoogle_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBusWeb_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConvBusWeb_Internalname, httpContext.getMessage( "Bus Web", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConvBusWeb_Internalname, A1916ConvBusWeb, GXutil.rtrim( localUtil.format( A1916ConvBusWeb, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtConvBusWeb_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBusWeb_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtConvBaseURL_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtConvBaseURL_Internalname, httpContext.getMessage( "Base URL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtConvBaseURL_Internalname, A1917ConvBaseURL, GXutil.rtrim( localUtil.format( A1917ConvBaseURL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", "'"+""+"'"+",false,"+"'"+""+"'", A1917ConvBaseURL, "_blank", "", "", edtConvBaseURL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtConvBaseURL_Enabled, 0, "url", "", 80, "chr", 1, "row", 1000, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "GeneXus\\Url", "left", true, "", "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConvScrapTDoc.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConvScrapTDoc.getInternalname(), httpContext.getMessage( "Scrap TDoc", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConvScrapTDoc, cmbConvScrapTDoc.getInternalname(), GXutil.rtrim( A1919ConvScrapTDoc), 1, cmbConvScrapTDoc.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConvScrapTDoc.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,57);\"", "", true, (byte)(0), "HLP_Convenio.htm");
      cmbConvScrapTDoc.setValue( GXutil.rtrim( A1919ConvScrapTDoc) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTDoc.getInternalname(), "Values", cmbConvScrapTDoc.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbConvScrapTipo.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbConvScrapTipo.getInternalname(), httpContext.getMessage( "Scrap Tipo", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbConvScrapTipo, cmbConvScrapTipo.getInternalname(), GXutil.rtrim( A1918ConvScrapTipo), 1, cmbConvScrapTipo.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbConvScrapTipo.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,62);\"", "", true, (byte)(0), "HLP_Convenio.htm");
      cmbConvScrapTipo.setValue( GXutil.rtrim( A1918ConvScrapTipo) );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTipo.getInternalname(), "Values", cmbConvScrapTipo.ToJavascriptSource(), true);
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
      /*  Grid Control  */
      startgridcontrol65( ) ;
      nGXsfl_65_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount275 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_275 = (short)(1) ;
            scanStart0E275( ) ;
            while ( RcdFound275 != 0 )
            {
               init_level_properties275( ) ;
               getByPrimaryKey0E275( ) ;
               addRow0E275( ) ;
               scanNext0E275( ) ;
            }
            scanEnd0E275( ) ;
            nBlankRcdCount275 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0E275( ) ;
         standaloneModal0E275( ) ;
         sMode275 = Gx_mode ;
         while ( nGXsfl_65_idx < nRC_GXsfl_65 )
         {
            bGXsfl_65_Refreshing = true ;
            readRow0E275( ) ;
            edtpropCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PROPCOD_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtpropCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropCod_Enabled), 5, 0), !bGXsfl_65_Refreshing);
            edtpropDesc_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PROPDESC_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtpropDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropDesc_Enabled), 5, 0), !bGXsfl_65_Refreshing);
            cmbpropTipoDato.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PROPTIPODATO_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
            httpContext.ajax_rsp_assign_prop("", false, cmbpropTipoDato.getInternalname(), "Enabled", GXutil.ltrimstr( cmbpropTipoDato.getEnabled(), 5, 0), !bGXsfl_65_Refreshing);
            if ( ( nRcdExists_275 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0E275( ) ;
            }
            sendRow0E275( ) ;
            bGXsfl_65_Refreshing = false ;
         }
         Gx_mode = sMode275 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount275 = (short)(5) ;
         nRcdExists_275 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0E275( ) ;
            while ( RcdFound275 != 0 )
            {
               sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_65275( ) ;
               init_level_properties275( ) ;
               standaloneNotModal0E275( ) ;
               getByPrimaryKey0E275( ) ;
               standaloneModal0E275( ) ;
               addRow0E275( ) ;
               scanNext0E275( ) ;
            }
            scanEnd0E275( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode275 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_65275( ) ;
         initAll0E275( ) ;
         init_level_properties275( ) ;
         nRcdExists_275 = (short)(0) ;
         nIsMod_275 = (short)(0) ;
         nRcdDeleted_275 = (short)(0) ;
         nBlankRcdCount275 = (short)(nBlankRcdUsr275+nBlankRcdCount275) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount275 > 0 )
         {
            standaloneNotModal0E275( ) ;
            standaloneModal0E275( ) ;
            addRow0E275( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtpropCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount275 = (short)(nBlankRcdCount275-1) ;
         }
         Gx_mode = sMode275 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 80,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Convenio.htm");
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
      ucCombo_propcod.setProperty("Caption", Combo_propcod_Caption);
      ucCombo_propcod.setProperty("Cls", Combo_propcod_Cls);
      ucCombo_propcod.setProperty("IsGridItem", Combo_propcod_Isgriditem);
      ucCombo_propcod.setProperty("HasDescription", Combo_propcod_Hasdescription);
      ucCombo_propcod.setProperty("DataListProc", Combo_propcod_Datalistproc);
      ucCombo_propcod.setProperty("DataListProcParametersPrefix", Combo_propcod_Datalistprocparametersprefix);
      ucCombo_propcod.setProperty("EmptyItem", Combo_propcod_Emptyitem);
      ucCombo_propcod.setProperty("DropDownOptionsTitleSettingsIcons", AV21DDO_TitleSettingsIcons);
      ucCombo_propcod.setProperty("DropDownOptionsData", AV20propCod_Data);
      ucCombo_propcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_propcod_Internalname, "COMBO_PROPCODContainer");
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
      e110E2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV21DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vPROPCOD_DATA"), AV20propCod_Data);
            /* Read saved values. */
            Z46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z46PaiCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z9ConveCodigo = httpContext.cgiGet( "Z9ConveCodigo") ;
            Z687ConveDescriSinAc = httpContext.cgiGet( "Z687ConveDescriSinAc") ;
            Z160ConveDescri = httpContext.cgiGet( "Z160ConveDescri") ;
            Z161ConveHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z161ConveHabilitada")) ;
            Z1915ConvBusGoogle = httpContext.cgiGet( "Z1915ConvBusGoogle") ;
            n1915ConvBusGoogle = ((GXutil.strcmp("", A1915ConvBusGoogle)==0) ? true : false) ;
            Z1916ConvBusWeb = httpContext.cgiGet( "Z1916ConvBusWeb") ;
            n1916ConvBusWeb = ((GXutil.strcmp("", A1916ConvBusWeb)==0) ? true : false) ;
            Z1917ConvBaseURL = httpContext.cgiGet( "Z1917ConvBaseURL") ;
            n1917ConvBaseURL = ((GXutil.strcmp("", A1917ConvBaseURL)==0) ? true : false) ;
            Z1918ConvScrapTipo = httpContext.cgiGet( "Z1918ConvScrapTipo") ;
            n1918ConvScrapTipo = ((GXutil.strcmp("", A1918ConvScrapTipo)==0) ? true : false) ;
            Z1919ConvScrapTDoc = httpContext.cgiGet( "Z1919ConvScrapTDoc") ;
            n1919ConvScrapTDoc = ((GXutil.strcmp("", A1919ConvScrapTDoc)==0) ? true : false) ;
            Z2131ConveEscFrecAct = (short)(localUtil.ctol( httpContext.cgiGet( "Z2131ConveEscFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2428ConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "Z2428ConveEsquemaEs")) ;
            Z935ConveSinCod = httpContext.cgiGet( "Z935ConveSinCod") ;
            n935ConveSinCod = ((GXutil.strcmp("", A935ConveSinCod)==0) ? true : false) ;
            A687ConveDescriSinAc = httpContext.cgiGet( "Z687ConveDescriSinAc") ;
            A161ConveHabilitada = GXutil.strtobool( httpContext.cgiGet( "Z161ConveHabilitada")) ;
            A2428ConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "Z2428ConveEsquemaEs")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_65 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_65"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N935ConveSinCod = httpContext.cgiGet( "N935ConveSinCod") ;
            n935ConveSinCod = ((GXutil.strcmp("", A935ConveSinCod)==0) ? true : false) ;
            A687ConveDescriSinAc = httpContext.cgiGet( "CONVEDESCRISINAC") ;
            AV17PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "vPAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A46PaiCod = (short)(localUtil.ctol( httpContext.cgiGet( "PAICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8ConveCodigo = httpContext.cgiGet( "vCONVECODIGO") ;
            AV18Insert_ConveSinCod = httpContext.cgiGet( "vINSERT_CONVESINCOD") ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A161ConveHabilitada = GXutil.strtobool( httpContext.cgiGet( "CONVEHABILITADA")) ;
            A2428ConveEsquemaEs = GXutil.strtobool( httpContext.cgiGet( "CONVEESQUEMAES")) ;
            A936ConveSinDesc = httpContext.cgiGet( "CONVESINDESC") ;
            AV26Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A2262ConvePropPredet = httpContext.cgiGet( "CONVEPROPPREDET") ;
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
            Combo_propcod_Objectcall = httpContext.cgiGet( "COMBO_PROPCOD_Objectcall") ;
            Combo_propcod_Class = httpContext.cgiGet( "COMBO_PROPCOD_Class") ;
            Combo_propcod_Icontype = httpContext.cgiGet( "COMBO_PROPCOD_Icontype") ;
            Combo_propcod_Icon = httpContext.cgiGet( "COMBO_PROPCOD_Icon") ;
            Combo_propcod_Caption = httpContext.cgiGet( "COMBO_PROPCOD_Caption") ;
            Combo_propcod_Tooltip = httpContext.cgiGet( "COMBO_PROPCOD_Tooltip") ;
            Combo_propcod_Cls = httpContext.cgiGet( "COMBO_PROPCOD_Cls") ;
            Combo_propcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_PROPCOD_Selectedvalue_set") ;
            Combo_propcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_PROPCOD_Selectedvalue_get") ;
            Combo_propcod_Selectedtext_set = httpContext.cgiGet( "COMBO_PROPCOD_Selectedtext_set") ;
            Combo_propcod_Selectedtext_get = httpContext.cgiGet( "COMBO_PROPCOD_Selectedtext_get") ;
            Combo_propcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_PROPCOD_Gamoauthtoken") ;
            Combo_propcod_Ddointernalname = httpContext.cgiGet( "COMBO_PROPCOD_Ddointernalname") ;
            Combo_propcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_PROPCOD_Titlecontrolalign") ;
            Combo_propcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_PROPCOD_Dropdownoptionstype") ;
            Combo_propcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Enabled")) ;
            Combo_propcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Visible")) ;
            Combo_propcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_PROPCOD_Titlecontrolidtoreplace") ;
            Combo_propcod_Datalisttype = httpContext.cgiGet( "COMBO_PROPCOD_Datalisttype") ;
            Combo_propcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Allowmultipleselection")) ;
            Combo_propcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_PROPCOD_Datalistfixedvalues") ;
            Combo_propcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Isgriditem")) ;
            Combo_propcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Hasdescription")) ;
            Combo_propcod_Datalistproc = httpContext.cgiGet( "COMBO_PROPCOD_Datalistproc") ;
            Combo_propcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_PROPCOD_Datalistprocparametersprefix") ;
            Combo_propcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_PROPCOD_Remoteservicesparameters") ;
            Combo_propcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROPCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_propcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Includeonlyselectedoption")) ;
            Combo_propcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Includeselectalloption")) ;
            Combo_propcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Emptyitem")) ;
            Combo_propcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_PROPCOD_Includeaddnewoption")) ;
            Combo_propcod_Htmltemplate = httpContext.cgiGet( "COMBO_PROPCOD_Htmltemplate") ;
            Combo_propcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_PROPCOD_Multiplevaluestype") ;
            Combo_propcod_Loadingdata = httpContext.cgiGet( "COMBO_PROPCOD_Loadingdata") ;
            Combo_propcod_Noresultsfound = httpContext.cgiGet( "COMBO_PROPCOD_Noresultsfound") ;
            Combo_propcod_Emptyitemtext = httpContext.cgiGet( "COMBO_PROPCOD_Emptyitemtext") ;
            Combo_propcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_PROPCOD_Onlyselectedvalues") ;
            Combo_propcod_Selectalltext = httpContext.cgiGet( "COMBO_PROPCOD_Selectalltext") ;
            Combo_propcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_PROPCOD_Multiplevaluesseparator") ;
            Combo_propcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_PROPCOD_Addnewoptiontext") ;
            Combo_propcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_PROPCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A9ConveCodigo = httpContext.cgiGet( edtConveCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
            A160ConveDescri = httpContext.cgiGet( edtConveDescri_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A160ConveDescri", A160ConveDescri);
            dynConveSinCod.setName( dynConveSinCod.getInternalname() );
            dynConveSinCod.setValue( httpContext.cgiGet( dynConveSinCod.getInternalname()) );
            A935ConveSinCod = httpContext.cgiGet( dynConveSinCod.getInternalname()) ;
            n935ConveSinCod = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
            n935ConveSinCod = ((GXutil.strcmp("", A935ConveSinCod)==0) ? true : false) ;
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtConveEscFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtConveEscFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CONVEESCFRECACT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveEscFrecAct_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A2131ConveEscFrecAct = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
            }
            else
            {
               A2131ConveEscFrecAct = (short)(localUtil.ctol( httpContext.cgiGet( edtConveEscFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
            }
            A1915ConvBusGoogle = httpContext.cgiGet( edtConvBusGoogle_Internalname) ;
            n1915ConvBusGoogle = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
            n1915ConvBusGoogle = ((GXutil.strcmp("", A1915ConvBusGoogle)==0) ? true : false) ;
            A1916ConvBusWeb = httpContext.cgiGet( edtConvBusWeb_Internalname) ;
            n1916ConvBusWeb = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1916ConvBusWeb", A1916ConvBusWeb);
            n1916ConvBusWeb = ((GXutil.strcmp("", A1916ConvBusWeb)==0) ? true : false) ;
            A1917ConvBaseURL = httpContext.cgiGet( edtConvBaseURL_Internalname) ;
            n1917ConvBaseURL = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1917ConvBaseURL", A1917ConvBaseURL);
            n1917ConvBaseURL = ((GXutil.strcmp("", A1917ConvBaseURL)==0) ? true : false) ;
            cmbConvScrapTDoc.setName( cmbConvScrapTDoc.getInternalname() );
            cmbConvScrapTDoc.setValue( httpContext.cgiGet( cmbConvScrapTDoc.getInternalname()) );
            A1919ConvScrapTDoc = httpContext.cgiGet( cmbConvScrapTDoc.getInternalname()) ;
            n1919ConvScrapTDoc = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
            n1919ConvScrapTDoc = ((GXutil.strcmp("", A1919ConvScrapTDoc)==0) ? true : false) ;
            cmbConvScrapTipo.setName( cmbConvScrapTipo.getInternalname() );
            cmbConvScrapTipo.setValue( httpContext.cgiGet( cmbConvScrapTipo.getInternalname()) );
            A1918ConvScrapTipo = httpContext.cgiGet( cmbConvScrapTipo.getInternalname()) ;
            n1918ConvScrapTipo = false ;
            httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
            n1918ConvScrapTipo = ((GXutil.strcmp("", A1918ConvScrapTipo)==0) ? true : false) ;
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Convenio");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("ConveHabilitada", GXutil.booltostr( A161ConveHabilitada));
            forbiddenHiddens.add("ConveEsquemaEs", GXutil.booltostr( A2428ConveEsquemaEs));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("convenio:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A46PaiCod = (short)(GXutil.lval( httpContext.GetPar( "PaiCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A9ConveCodigo = httpContext.GetPar( "ConveCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
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
                  sMode106 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode106 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound106 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_0E0( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CONVECODIGO");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtConveCodigo_Internalname ;
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
                        e110E2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e120E2 ();
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
         e120E2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0E106( ) ;
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
         disableAttributes0E106( ) ;
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

   public void confirm_0E0( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0E106( ) ;
         }
         else
         {
            checkExtendedTable0E106( ) ;
            closeExtendedTableCursors0E106( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode106 = Gx_mode ;
         confirm_0E275( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode106 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode106 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0E275( )
   {
      nGXsfl_65_idx = 0 ;
      while ( nGXsfl_65_idx < nRC_GXsfl_65 )
      {
         readRow0E275( ) ;
         if ( ( nRcdExists_275 != 0 ) || ( nIsMod_275 != 0 ) )
         {
            getKey0E275( ) ;
            if ( ( nRcdExists_275 == 0 ) && ( nRcdDeleted_275 == 0 ) )
            {
               if ( RcdFound275 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0E275( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0E275( ) ;
                     closeExtendedTableCursors0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "PROPCOD_" + sGXsfl_65_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtpropCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound275 != 0 )
               {
                  if ( nRcdDeleted_275 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0E275( ) ;
                     load0E275( ) ;
                     beforeValidate0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0E275( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_275 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0E275( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0E275( ) ;
                           closeExtendedTableCursors0E275( ) ;
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
                  if ( nRcdDeleted_275 == 0 )
                  {
                     GXCCtl = "PROPCOD_" + sGXsfl_65_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtpropCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtpropCod_Internalname, GXutil.rtrim( A2227propCod)) ;
         httpContext.changePostValue( edtpropDesc_Internalname, A2228propDesc) ;
         httpContext.changePostValue( cmbpropTipoDato.getInternalname(), GXutil.rtrim( A2229propTipoDato)) ;
         httpContext.changePostValue( "ZT_"+"Z2227propCod_"+sGXsfl_65_idx, GXutil.rtrim( Z2227propCod)) ;
         httpContext.changePostValue( "ZT_"+"Z2262ConvePropPredet_"+sGXsfl_65_idx, GXutil.rtrim( Z2262ConvePropPredet)) ;
         httpContext.changePostValue( "nRcdDeleted_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_275 != 0 )
         {
            httpContext.changePostValue( "PROPCOD_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PROPDESC_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropDesc_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PROPTIPODATO_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbpropTipoDato.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption0E0( )
   {
   }

   public void e110E2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV9WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV9WWPContext = GXv_SdtWWPContext1[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = AV21DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[0] ;
      AV21DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2;
      Combo_propcod_Titlecontrolidtoreplace = edtpropCod_Internalname ;
      ucCombo_propcod.sendProperty(context, "", false, Combo_propcod_Internalname, "TitleControlIdToReplace", Combo_propcod_Titlecontrolidtoreplace);
      AV10IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Insert", GXv_boolean5) ;
         convenio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Update", GXv_boolean5) ;
         convenio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean4 = AV10IsAuthorized ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWConvenio_Delete", GXv_boolean5) ;
         convenio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         AV10IsAuthorized = GXt_boolean4 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV10IsAuthorized", AV10IsAuthorized);
      }
      if ( ! AV10IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV26Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV12TrnContext.fromxml(AV13WebSession.getValue("TrnContext"), null, null);
      if ( ( GXutil.strcmp(AV12TrnContext.getgxTv_SdtWWPTransactionContext_Transactionname(), AV26Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV27GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         while ( AV27GXV1 <= AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().size() )
         {
            AV15TrnContextAtt = (web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)((web.wwpbaseobjects.SdtWWPTransactionContext_Attribute)AV12TrnContext.getgxTv_SdtWWPTransactionContext_Attributes().elementAt(-1+AV27GXV1));
            if ( GXutil.strcmp(AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributename(), "ConveSinCod") == 0 )
            {
               AV18Insert_ConveSinCod = AV15TrnContextAtt.getgxTv_SdtWWPTransactionContext_Attribute_Attributevalue() ;
               httpContext.ajax_rsp_assign_attri("", false, "AV18Insert_ConveSinCod", AV18Insert_ConveSinCod);
            }
            AV27GXV1 = (int)(AV27GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV27GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV27GXV1), 8, 0));
         }
      }
   }

   public void e120E2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(6);
      pr_default.close(5);
      pr_default.close(4);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0E106( int GX_JID )
   {
      if ( ( GX_JID == 20 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z687ConveDescriSinAc = T000E6_A687ConveDescriSinAc[0] ;
            Z160ConveDescri = T000E6_A160ConveDescri[0] ;
            Z161ConveHabilitada = T000E6_A161ConveHabilitada[0] ;
            Z1915ConvBusGoogle = T000E6_A1915ConvBusGoogle[0] ;
            Z1916ConvBusWeb = T000E6_A1916ConvBusWeb[0] ;
            Z1917ConvBaseURL = T000E6_A1917ConvBaseURL[0] ;
            Z1918ConvScrapTipo = T000E6_A1918ConvScrapTipo[0] ;
            Z1919ConvScrapTDoc = T000E6_A1919ConvScrapTDoc[0] ;
            Z2131ConveEscFrecAct = T000E6_A2131ConveEscFrecAct[0] ;
            Z2428ConveEsquemaEs = T000E6_A2428ConveEsquemaEs[0] ;
            Z935ConveSinCod = T000E6_A935ConveSinCod[0] ;
         }
         else
         {
            Z687ConveDescriSinAc = A687ConveDescriSinAc ;
            Z160ConveDescri = A160ConveDescri ;
            Z161ConveHabilitada = A161ConveHabilitada ;
            Z1915ConvBusGoogle = A1915ConvBusGoogle ;
            Z1916ConvBusWeb = A1916ConvBusWeb ;
            Z1917ConvBaseURL = A1917ConvBaseURL ;
            Z1918ConvScrapTipo = A1918ConvScrapTipo ;
            Z1919ConvScrapTDoc = A1919ConvScrapTDoc ;
            Z2131ConveEscFrecAct = A2131ConveEscFrecAct ;
            Z2428ConveEsquemaEs = A2428ConveEsquemaEs ;
            Z935ConveSinCod = A935ConveSinCod ;
         }
      }
      if ( GX_JID == -20 )
      {
         Z687ConveDescriSinAc = A687ConveDescriSinAc ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z160ConveDescri = A160ConveDescri ;
         Z161ConveHabilitada = A161ConveHabilitada ;
         Z1915ConvBusGoogle = A1915ConvBusGoogle ;
         Z1916ConvBusWeb = A1916ConvBusWeb ;
         Z1917ConvBaseURL = A1917ConvBaseURL ;
         Z1918ConvScrapTipo = A1918ConvScrapTipo ;
         Z1919ConvScrapTDoc = A1919ConvScrapTDoc ;
         Z2131ConveEscFrecAct = A2131ConveEscFrecAct ;
         Z2428ConveEsquemaEs = A2428ConveEsquemaEs ;
         Z46PaiCod = A46PaiCod ;
         Z935ConveSinCod = A935ConveSinCod ;
         Z936ConveSinDesc = A936ConveSinDesc ;
      }
   }

   public void standaloneNotModal( )
   {
      GXt_boolean4 = false ;
      GXv_boolean5[0] = GXt_boolean4 ;
      new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
      convenio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
      if ( GXt_boolean4 )
      {
         bttBtntrn_delete_Visible = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      }
      else
      {
         GXt_boolean4 = false ;
         GXv_boolean5[0] = GXt_boolean4 ;
         new web.esconceptosdefault(remoteHandle, context).execute( GXv_boolean5) ;
         convenio_impl.this.GXt_boolean4 = GXv_boolean5[0] ;
         if ( ! ( GXt_boolean4 ) )
         {
            bttBtntrn_delete_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         }
      }
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      gxaconvesincod_html0E106( AV17PaiCod) ;
      if ( ! (0==AV17PaiCod) )
      {
         A46PaiCod = AV17PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      }
      /* Using cursor T000E7 */
      pr_default.execute(5, new Object[] {Short.valueOf(A46PaiCod)});
      if ( (pr_default.getStatus(5) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Pais", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PAICOD");
         AnyError = (short)(1) ;
      }
      pr_default.close(5);
      if ( ! (GXutil.strcmp("", AV8ConveCodigo)==0) )
      {
         A9ConveCodigo = AV8ConveCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
      }
      if ( ! (GXutil.strcmp("", AV8ConveCodigo)==0) )
      {
         edtConveCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtConveCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV8ConveCodigo)==0) )
      {
         edtConveCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveCodigo_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV18Insert_ConveSinCod)==0) )
      {
         dynConveSinCod.setEnabled( 0 );
         httpContext.ajax_rsp_assign_prop("", false, dynConveSinCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveSinCod.getEnabled(), 5, 0), true);
      }
      else
      {
         dynConveSinCod.setEnabled( 1 );
         httpContext.ajax_rsp_assign_prop("", false, dynConveSinCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveSinCod.getEnabled(), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (GXutil.strcmp("", AV18Insert_ConveSinCod)==0) )
      {
         A935ConveSinCod = AV18Insert_ConveSinCod ;
         n935ConveSinCod = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
      }
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
      if ( isIns( )  && (false==A161ConveHabilitada) && ( Gx_BScreen == 0 ) )
      {
         A161ConveHabilitada = true ;
         httpContext.ajax_rsp_assign_attri("", false, "A161ConveHabilitada", A161ConveHabilitada);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         /* Using cursor T000E8 */
         pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
         A936ConveSinDesc = T000E8_A936ConveSinDesc[0] ;
         pr_default.close(6);
         AV26Pgmname = "Convenio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      }
   }

   public void load0E106( )
   {
      /* Using cursor T000E9 */
      pr_default.execute(7, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = T000E9_A687ConveDescriSinAc[0] ;
         A160ConveDescri = T000E9_A160ConveDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A160ConveDescri", A160ConveDescri);
         A161ConveHabilitada = T000E9_A161ConveHabilitada[0] ;
         A936ConveSinDesc = T000E9_A936ConveSinDesc[0] ;
         A1915ConvBusGoogle = T000E9_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = T000E9_n1915ConvBusGoogle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
         A1916ConvBusWeb = T000E9_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = T000E9_n1916ConvBusWeb[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1916ConvBusWeb", A1916ConvBusWeb);
         A1917ConvBaseURL = T000E9_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = T000E9_n1917ConvBaseURL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1917ConvBaseURL", A1917ConvBaseURL);
         A1918ConvScrapTipo = T000E9_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = T000E9_n1918ConvScrapTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
         A1919ConvScrapTDoc = T000E9_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = T000E9_n1919ConvScrapTDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
         A2131ConveEscFrecAct = T000E9_A2131ConveEscFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
         A2428ConveEsquemaEs = T000E9_A2428ConveEsquemaEs[0] ;
         A935ConveSinCod = T000E9_A935ConveSinCod[0] ;
         n935ConveSinCod = T000E9_n935ConveSinCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
         zm0E106( -20) ;
      }
      pr_default.close(7);
      onLoadActions0E106( ) ;
   }

   public void onLoadActions0E106( )
   {
      AV26Pgmname = "Convenio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      GXt_char6 = A687ConveDescriSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char7) ;
      convenio_impl.this.GXt_char6 = GXv_char7[0] ;
      A687ConveDescriSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A687ConveDescriSinAc", A687ConveDescriSinAc);
   }

   public void checkExtendedTable0E106( )
   {
      nIsDirty_106 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV26Pgmname = "Convenio" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
      if ( (GXutil.strcmp("", A9ConveCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "CONVECODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      nIsDirty_106 = (short)(1) ;
      GXt_char6 = A687ConveDescriSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char7) ;
      convenio_impl.this.GXt_char6 = GXv_char7[0] ;
      A687ConveDescriSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A687ConveDescriSinAc", A687ConveDescriSinAc);
      if ( (GXutil.strcmp("", A160ConveDescri)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "CONVEDESCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveDescri_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( GxRegex.IsMatch(A1917ConvBaseURL,"^((?:[a-zA-Z]+:(//)?)?((?:(?:[a-zA-Z]([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*)(?:\\.(?:([a-zA-Z0-9$\\-_@&+!*\"'(),]|%[0-9a-fA-F]{2})*))*)|(?:(\\d{1,3}\\.){3}\\d{1,3}))(?::\\d+)?(?:/([a-zA-Z0-9$\\-_@.&+!*\"'(),=;: ]|%[0-9a-fA-F]{2})+)*/?(?:[#?](?:[a-zA-Z0-9$\\-_@.&+!*\"'(),=;: /]|%[0-9a-fA-F]{2})*)?)?\\s*$") || (GXutil.strcmp("", A1917ConvBaseURL)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXM_DoesNotMatchRegExp", ""), httpContext.getMessage( "Conv Base URL", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVBASEURL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConvBaseURL_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1918ConvScrapTipo, "Tabla") == 0 ) || ( GXutil.strcmp(A1918ConvScrapTipo, "Texto") == 0 ) || ( GXutil.strcmp(A1918ConvScrapTipo, "Imagen") == 0 ) || (GXutil.strcmp("", A1918ConvScrapTipo)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conv Scrap Tipo", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVSCRAPTIPO");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConvScrapTipo.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A1919ConvScrapTDoc, "HTML") == 0 ) || ( GXutil.strcmp(A1919ConvScrapTDoc, "PDF") == 0 ) || (GXutil.strcmp("", A1919ConvScrapTDoc)==0) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Conv Scrap TDoc", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CONVSCRAPTDOC");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbConvScrapTDoc.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      /* Using cursor T000E8 */
      pr_default.execute(6, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
      if ( (pr_default.getStatus(6) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A935ConveSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Sindicato Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVESINCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynConveSinCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A936ConveSinDesc = T000E8_A936ConveSinDesc[0] ;
      pr_default.close(6);
   }

   public void closeExtendedTableCursors0E106( )
   {
      pr_default.close(6);
   }

   public void enableDisable( )
   {
   }

   public void gxload_22( short A46PaiCod ,
                          String A935ConveSinCod )
   {
      /* Using cursor T000E10 */
      pr_default.execute(8, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
      if ( (pr_default.getStatus(8) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A935ConveSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Sindicato Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVESINCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynConveSinCod.getInternalname() ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      A936ConveSinDesc = T000E10_A936ConveSinDesc[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A936ConveSinDesc)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey0E106( )
   {
      /* Using cursor T000E11 */
      pr_default.execute(9, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound106 = (short)(1) ;
      }
      else
      {
         RcdFound106 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T000E6 */
      pr_default.execute(4, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(4) != 101) )
      {
         zm0E106( 20) ;
         RcdFound106 = (short)(1) ;
         A687ConveDescriSinAc = T000E6_A687ConveDescriSinAc[0] ;
         A9ConveCodigo = T000E6_A9ConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
         A160ConveDescri = T000E6_A160ConveDescri[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A160ConveDescri", A160ConveDescri);
         A161ConveHabilitada = T000E6_A161ConveHabilitada[0] ;
         A1915ConvBusGoogle = T000E6_A1915ConvBusGoogle[0] ;
         n1915ConvBusGoogle = T000E6_n1915ConvBusGoogle[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
         A1916ConvBusWeb = T000E6_A1916ConvBusWeb[0] ;
         n1916ConvBusWeb = T000E6_n1916ConvBusWeb[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1916ConvBusWeb", A1916ConvBusWeb);
         A1917ConvBaseURL = T000E6_A1917ConvBaseURL[0] ;
         n1917ConvBaseURL = T000E6_n1917ConvBaseURL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1917ConvBaseURL", A1917ConvBaseURL);
         A1918ConvScrapTipo = T000E6_A1918ConvScrapTipo[0] ;
         n1918ConvScrapTipo = T000E6_n1918ConvScrapTipo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
         A1919ConvScrapTDoc = T000E6_A1919ConvScrapTDoc[0] ;
         n1919ConvScrapTDoc = T000E6_n1919ConvScrapTDoc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
         A2131ConveEscFrecAct = T000E6_A2131ConveEscFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
         A2428ConveEsquemaEs = T000E6_A2428ConveEsquemaEs[0] ;
         A46PaiCod = T000E6_A46PaiCod[0] ;
         A935ConveSinCod = T000E6_A935ConveSinCod[0] ;
         n935ConveSinCod = T000E6_n935ConveSinCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         sMode106 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0E106( ) ;
         if ( AnyError == 1 )
         {
            RcdFound106 = (short)(0) ;
            initializeNonKey0E106( ) ;
         }
         Gx_mode = sMode106 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound106 = (short)(0) ;
         initializeNonKey0E106( ) ;
         sMode106 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode106 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(4);
   }

   public void getEqualNoModal( )
   {
      getKey0E106( ) ;
      if ( RcdFound106 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound106 = (short)(0) ;
      /* Using cursor T000E12 */
      pr_default.execute(10, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000E12_A46PaiCod[0] < A46PaiCod ) || ( T000E12_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T000E12_A9ConveCodigo[0], A9ConveCodigo) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000E12_A46PaiCod[0] > A46PaiCod ) || ( T000E12_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T000E12_A9ConveCodigo[0], A9ConveCodigo) > 0 ) ) )
         {
            A46PaiCod = T000E12_A46PaiCod[0] ;
            A9ConveCodigo = T000E12_A9ConveCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
            RcdFound106 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound106 = (short)(0) ;
      /* Using cursor T000E13 */
      pr_default.execute(11, new Object[] {Short.valueOf(A46PaiCod), Short.valueOf(A46PaiCod), A9ConveCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000E13_A46PaiCod[0] > A46PaiCod ) || ( T000E13_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T000E13_A9ConveCodigo[0], A9ConveCodigo) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000E13_A46PaiCod[0] < A46PaiCod ) || ( T000E13_A46PaiCod[0] == A46PaiCod ) && ( GXutil.strcmp(T000E13_A9ConveCodigo[0], A9ConveCodigo) < 0 ) ) )
         {
            A46PaiCod = T000E13_A46PaiCod[0] ;
            A9ConveCodigo = T000E13_A9ConveCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
            RcdFound106 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0E106( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtConveCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0E106( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound106 == 1 )
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
            {
               A46PaiCod = Z46PaiCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
               A9ConveCodigo = Z9ConveCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CONVECODIGO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtConveCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtConveCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0E106( ) ;
               GX_FocusControl = edtConveCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtConveCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0E106( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CONVECODIGO");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtConveCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtConveCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0E106( ) ;
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
      if ( ( A46PaiCod != Z46PaiCod ) || ( GXutil.strcmp(A9ConveCodigo, Z9ConveCodigo) != 0 ) )
      {
         A46PaiCod = Z46PaiCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
         A9ConveCodigo = Z9ConveCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CONVECODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtConveCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0E106( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000E5 */
         pr_default.execute(3, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(3) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(3) == 101) || ( GXutil.strcmp(Z687ConveDescriSinAc, T000E5_A687ConveDescriSinAc[0]) != 0 ) || ( GXutil.strcmp(Z160ConveDescri, T000E5_A160ConveDescri[0]) != 0 ) || ( Z161ConveHabilitada != T000E5_A161ConveHabilitada[0] ) || ( GXutil.strcmp(Z1915ConvBusGoogle, T000E5_A1915ConvBusGoogle[0]) != 0 ) || ( GXutil.strcmp(Z1916ConvBusWeb, T000E5_A1916ConvBusWeb[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1917ConvBaseURL, T000E5_A1917ConvBaseURL[0]) != 0 ) || ( GXutil.strcmp(Z1918ConvScrapTipo, T000E5_A1918ConvScrapTipo[0]) != 0 ) || ( GXutil.strcmp(Z1919ConvScrapTDoc, T000E5_A1919ConvScrapTDoc[0]) != 0 ) || ( Z2131ConveEscFrecAct != T000E5_A2131ConveEscFrecAct[0] ) || ( Z2428ConveEsquemaEs != T000E5_A2428ConveEsquemaEs[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z935ConveSinCod, T000E5_A935ConveSinCod[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z687ConveDescriSinAc, T000E5_A687ConveDescriSinAc[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveDescriSinAc");
               GXutil.writeLogRaw("Old: ",Z687ConveDescriSinAc);
               GXutil.writeLogRaw("Current: ",T000E5_A687ConveDescriSinAc[0]);
            }
            if ( GXutil.strcmp(Z160ConveDescri, T000E5_A160ConveDescri[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveDescri");
               GXutil.writeLogRaw("Old: ",Z160ConveDescri);
               GXutil.writeLogRaw("Current: ",T000E5_A160ConveDescri[0]);
            }
            if ( Z161ConveHabilitada != T000E5_A161ConveHabilitada[0] )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveHabilitada");
               GXutil.writeLogRaw("Old: ",Z161ConveHabilitada);
               GXutil.writeLogRaw("Current: ",T000E5_A161ConveHabilitada[0]);
            }
            if ( GXutil.strcmp(Z1915ConvBusGoogle, T000E5_A1915ConvBusGoogle[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvBusGoogle");
               GXutil.writeLogRaw("Old: ",Z1915ConvBusGoogle);
               GXutil.writeLogRaw("Current: ",T000E5_A1915ConvBusGoogle[0]);
            }
            if ( GXutil.strcmp(Z1916ConvBusWeb, T000E5_A1916ConvBusWeb[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvBusWeb");
               GXutil.writeLogRaw("Old: ",Z1916ConvBusWeb);
               GXutil.writeLogRaw("Current: ",T000E5_A1916ConvBusWeb[0]);
            }
            if ( GXutil.strcmp(Z1917ConvBaseURL, T000E5_A1917ConvBaseURL[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvBaseURL");
               GXutil.writeLogRaw("Old: ",Z1917ConvBaseURL);
               GXutil.writeLogRaw("Current: ",T000E5_A1917ConvBaseURL[0]);
            }
            if ( GXutil.strcmp(Z1918ConvScrapTipo, T000E5_A1918ConvScrapTipo[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvScrapTipo");
               GXutil.writeLogRaw("Old: ",Z1918ConvScrapTipo);
               GXutil.writeLogRaw("Current: ",T000E5_A1918ConvScrapTipo[0]);
            }
            if ( GXutil.strcmp(Z1919ConvScrapTDoc, T000E5_A1919ConvScrapTDoc[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvScrapTDoc");
               GXutil.writeLogRaw("Old: ",Z1919ConvScrapTDoc);
               GXutil.writeLogRaw("Current: ",T000E5_A1919ConvScrapTDoc[0]);
            }
            if ( Z2131ConveEscFrecAct != T000E5_A2131ConveEscFrecAct[0] )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveEscFrecAct");
               GXutil.writeLogRaw("Old: ",Z2131ConveEscFrecAct);
               GXutil.writeLogRaw("Current: ",T000E5_A2131ConveEscFrecAct[0]);
            }
            if ( Z2428ConveEsquemaEs != T000E5_A2428ConveEsquemaEs[0] )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveEsquemaEs");
               GXutil.writeLogRaw("Old: ",Z2428ConveEsquemaEs);
               GXutil.writeLogRaw("Current: ",T000E5_A2428ConveEsquemaEs[0]);
            }
            if ( GXutil.strcmp(Z935ConveSinCod, T000E5_A935ConveSinCod[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConveSinCod");
               GXutil.writeLogRaw("Old: ",Z935ConveSinCod);
               GXutil.writeLogRaw("Current: ",T000E5_A935ConveSinCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Convenio"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E106( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E106( 0) ;
         checkOptimisticConcurrency0E106( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E106( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E106( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E14 */
                  pr_default.execute(12, new Object[] {A687ConveDescriSinAc, A9ConveCodigo, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct), Boolean.valueOf(A2428ConveEsquemaEs), Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
                  if ( (pr_default.getStatus(12) == 1) )
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
                        processLevel0E106( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption0E0( ) ;
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
            load0E106( ) ;
         }
         endLevel0E106( ) ;
      }
      closeExtendedTableCursors0E106( ) ;
   }

   public void update0E106( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E106( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E106( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0E106( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E15 */
                  pr_default.execute(13, new Object[] {A687ConveDescriSinAc, A160ConveDescri, Boolean.valueOf(A161ConveHabilitada), Boolean.valueOf(n1915ConvBusGoogle), A1915ConvBusGoogle, Boolean.valueOf(n1916ConvBusWeb), A1916ConvBusWeb, Boolean.valueOf(n1917ConvBaseURL), A1917ConvBaseURL, Boolean.valueOf(n1918ConvScrapTipo), A1918ConvScrapTipo, Boolean.valueOf(n1919ConvScrapTDoc), A1919ConvScrapTDoc, Short.valueOf(A2131ConveEscFrecAct), Boolean.valueOf(A2428ConveEsquemaEs), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod, Short.valueOf(A46PaiCod), A9ConveCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Convenio"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0E106( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0E106( ) ;
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
         endLevel0E106( ) ;
      }
      closeExtendedTableCursors0E106( ) ;
   }

   public void deferredUpdate0E106( )
   {
   }

   public void delete( )
   {
      beforeValidate0E106( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E106( ) ;
         afterConfirm0E106( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E106( ) ;
            if ( AnyError == 0 )
            {
               scanStart0E275( ) ;
               while ( RcdFound275 != 0 )
               {
                  getByPrimaryKey0E275( ) ;
                  delete0E275( ) ;
                  scanNext0E275( ) ;
               }
               scanEnd0E275( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E16 */
                  pr_default.execute(14, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
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
      sMode106 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0E106( ) ;
      Gx_mode = sMode106 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0E106( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV26Pgmname = "Convenio" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV26Pgmname", AV26Pgmname);
         /* Using cursor T000E17 */
         pr_default.execute(15, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
         A936ConveSinDesc = T000E17_A936ConveSinDesc[0] ;
         pr_default.close(15);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000E18 */
         pr_default.execute(16, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(16) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Concepto", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(16);
         /* Using cursor T000E19 */
         pr_default.execute(17, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(17) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")+" ("+httpContext.getMessage( "Cliente Conve Versiones", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(17);
         /* Using cursor T000E20 */
         pr_default.execute(18, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(18) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Cliente Convenios", "")+" ("+httpContext.getMessage( "Cliente Conve Versiones", "")+")"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(18);
         /* Using cursor T000E21 */
         pr_default.execute(19, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Empresa Convenios", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
         /* Using cursor T000E22 */
         pr_default.execute(20, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "feriado", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
         /* Using cursor T000E23 */
         pr_default.execute(21, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "Dias de vacaciones por antiguedad", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
      }
   }

   public void processNestedLevel0E275( )
   {
      nGXsfl_65_idx = 0 ;
      while ( nGXsfl_65_idx < nRC_GXsfl_65 )
      {
         readRow0E275( ) ;
         if ( ( nRcdExists_275 != 0 ) || ( nIsMod_275 != 0 ) )
         {
            standaloneNotModal0E275( ) ;
            getKey0E275( ) ;
            if ( ( nRcdExists_275 == 0 ) && ( nRcdDeleted_275 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0E275( ) ;
            }
            else
            {
               if ( RcdFound275 != 0 )
               {
                  if ( ( nRcdDeleted_275 != 0 ) && ( nRcdExists_275 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0E275( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_275 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0E275( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_275 == 0 )
                  {
                     GXCCtl = "PROPCOD_" + sGXsfl_65_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtpropCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtpropCod_Internalname, GXutil.rtrim( A2227propCod)) ;
         httpContext.changePostValue( edtpropDesc_Internalname, A2228propDesc) ;
         httpContext.changePostValue( cmbpropTipoDato.getInternalname(), GXutil.rtrim( A2229propTipoDato)) ;
         httpContext.changePostValue( "ZT_"+"Z2227propCod_"+sGXsfl_65_idx, GXutil.rtrim( Z2227propCod)) ;
         httpContext.changePostValue( "ZT_"+"Z2262ConvePropPredet_"+sGXsfl_65_idx, GXutil.rtrim( Z2262ConvePropPredet)) ;
         httpContext.changePostValue( "nRcdDeleted_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_275_"+sGXsfl_65_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_275 != 0 )
         {
            httpContext.changePostValue( "PROPCOD_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PROPDESC_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropDesc_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "PROPTIPODATO_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbpropTipoDato.getEnabled(), (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0E275( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_275 = (short)(0) ;
      nIsMod_275 = (short)(0) ;
      nRcdDeleted_275 = (short)(0) ;
   }

   public void processLevel0E106( )
   {
      /* Save parent mode. */
      sMode106 = Gx_mode ;
      processNestedLevel0E275( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode106 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0E106( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(3);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0E106( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "convenio");
         if ( AnyError == 0 )
         {
            confirmValues0E0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "convenio");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0E106( )
   {
      /* Scan By routine */
      /* Using cursor T000E24 */
      pr_default.execute(22);
      RcdFound106 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A46PaiCod = T000E24_A46PaiCod[0] ;
         A9ConveCodigo = T000E24_A9ConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0E106( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound106 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound106 = (short)(1) ;
         A46PaiCod = T000E24_A46PaiCod[0] ;
         A9ConveCodigo = T000E24_A9ConveCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
      }
   }

   public void scanEnd0E106( )
   {
      pr_default.close(22);
   }

   public void afterConfirm0E106( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E106( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E106( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E106( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E106( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E106( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E106( )
   {
      edtConveCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveCodigo_Enabled), 5, 0), true);
      edtConveDescri_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveDescri_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveDescri_Enabled), 5, 0), true);
      dynConveSinCod.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, dynConveSinCod.getInternalname(), "Enabled", GXutil.ltrimstr( dynConveSinCod.getEnabled(), 5, 0), true);
      edtConveEscFrecAct_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConveEscFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConveEscFrecAct_Enabled), 5, 0), true);
      edtConvBusGoogle_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConvBusGoogle_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConvBusGoogle_Enabled), 5, 0), true);
      edtConvBusWeb_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConvBusWeb_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConvBusWeb_Enabled), 5, 0), true);
      edtConvBaseURL_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtConvBaseURL_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtConvBaseURL_Enabled), 5, 0), true);
      cmbConvScrapTDoc.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTDoc.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConvScrapTDoc.getEnabled(), 5, 0), true);
      cmbConvScrapTipo.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbConvScrapTipo.getInternalname(), "Enabled", GXutil.ltrimstr( cmbConvScrapTipo.getEnabled(), 5, 0), true);
   }

   public void zm0E275( int GX_JID )
   {
      if ( ( GX_JID == 23 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2262ConvePropPredet = T000E3_A2262ConvePropPredet[0] ;
         }
         else
         {
            Z2262ConvePropPredet = A2262ConvePropPredet ;
         }
      }
      if ( GX_JID == -23 )
      {
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z2262ConvePropPredet = A2262ConvePropPredet ;
         Z2227propCod = A2227propCod ;
         Z2228propDesc = A2228propDesc ;
         Z2229propTipoDato = A2229propTipoDato ;
      }
   }

   public void standaloneNotModal0E275( )
   {
   }

   public void standaloneModal0E275( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtpropCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtpropCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropCod_Enabled), 5, 0), !bGXsfl_65_Refreshing);
      }
      else
      {
         edtpropCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtpropCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropCod_Enabled), 5, 0), !bGXsfl_65_Refreshing);
      }
   }

   public void load0E275( )
   {
      /* Using cursor T000E25 */
      pr_default.execute(23, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2228propDesc = T000E25_A2228propDesc[0] ;
         A2229propTipoDato = T000E25_A2229propTipoDato[0] ;
         A2262ConvePropPredet = T000E25_A2262ConvePropPredet[0] ;
         zm0E275( -23) ;
      }
      pr_default.close(23);
      onLoadActions0E275( ) ;
   }

   public void onLoadActions0E275( )
   {
   }

   public void checkExtendedTable0E275( )
   {
      nIsDirty_275 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal0E275( ) ;
      /* Using cursor T000E4 */
      pr_default.execute(2, new Object[] {A2227propCod});
      if ( (pr_default.getStatus(2) == 101) )
      {
         GXCCtl = "PROPCOD_" + sGXsfl_65_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "propiedades_adicionales", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtpropCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2228propDesc = T000E4_A2228propDesc[0] ;
      A2229propTipoDato = T000E4_A2229propTipoDato[0] ;
      pr_default.close(2);
   }

   public void closeExtendedTableCursors0E275( )
   {
      pr_default.close(2);
   }

   public void enableDisable0E275( )
   {
   }

   public void gxload_24( String A2227propCod )
   {
      /* Using cursor T000E26 */
      pr_default.execute(24, new Object[] {A2227propCod});
      if ( (pr_default.getStatus(24) == 101) )
      {
         GXCCtl = "PROPCOD_" + sGXsfl_65_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "propiedades_adicionales", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtpropCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A2228propDesc = T000E26_A2228propDesc[0] ;
      A2229propTipoDato = T000E26_A2229propTipoDato[0] ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A2228propDesc)+"\""+","+"\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A2229propTipoDato))+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(24) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(24);
   }

   public void getKey0E275( )
   {
      /* Using cursor T000E27 */
      pr_default.execute(25, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound275 = (short)(1) ;
      }
      else
      {
         RcdFound275 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey0E275( )
   {
      /* Using cursor T000E3 */
      pr_default.execute(1, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0E275( 23) ;
         RcdFound275 = (short)(1) ;
         initializeNonKey0E275( ) ;
         A2262ConvePropPredet = T000E3_A2262ConvePropPredet[0] ;
         A2227propCod = T000E3_A2227propCod[0] ;
         Z46PaiCod = A46PaiCod ;
         Z9ConveCodigo = A9ConveCodigo ;
         Z2227propCod = A2227propCod ;
         sMode275 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0E275( ) ;
         Gx_mode = sMode275 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound275 = (short)(0) ;
         initializeNonKey0E275( ) ;
         sMode275 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0E275( ) ;
         Gx_mode = sMode275 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0E275( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0E275( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T000E2 */
         pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2262ConvePropPredet, T000E2_A2262ConvePropPredet[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z2262ConvePropPredet, T000E2_A2262ConvePropPredet[0]) != 0 )
            {
               GXutil.writeLogln("convenio:[seudo value changed for attri]"+"ConvePropPredet");
               GXutil.writeLogRaw("Old: ",Z2262ConvePropPredet);
               GXutil.writeLogRaw("Current: ",T000E2_A2262ConvePropPredet[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0E275( )
   {
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E275( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0E275( 0) ;
         checkOptimisticConcurrency0E275( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0E275( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0E275( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000E28 */
                  pr_default.execute(26, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2262ConvePropPredet, A2227propCod});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
                  if ( (pr_default.getStatus(26) == 1) )
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
            load0E275( ) ;
         }
         endLevel0E275( ) ;
      }
      closeExtendedTableCursors0E275( ) ;
   }

   public void update0E275( )
   {
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0E275( ) ;
      }
      if ( ( nIsMod_275 != 0 ) || ( nIsDirty_275 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0E275( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0E275( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0E275( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000E29 */
                     pr_default.execute(27, new Object[] {A2262ConvePropPredet, Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
                     if ( (pr_default.getStatus(27) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"ConvenioPropiedadesAdicionales"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0E275( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0E275( ) ;
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
            endLevel0E275( ) ;
         }
      }
      closeExtendedTableCursors0E275( ) ;
   }

   public void deferredUpdate0E275( )
   {
   }

   public void delete0E275( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0E275( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0E275( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0E275( ) ;
         afterConfirm0E275( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0E275( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000E30 */
               pr_default.execute(28, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
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
      sMode275 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0E275( ) ;
      Gx_mode = sMode275 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0E275( )
   {
      standaloneModal0E275( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor T000E31 */
         pr_default.execute(29, new Object[] {A2227propCod});
         A2228propDesc = T000E31_A2228propDesc[0] ;
         A2229propTipoDato = T000E31_A2229propTipoDato[0] ;
         pr_default.close(29);
      }
   }

   public void endLevel0E275( )
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

   public void scanStart0E275( )
   {
      /* Scan By routine */
      /* Using cursor T000E32 */
      pr_default.execute(30, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo});
      RcdFound275 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2227propCod = T000E32_A2227propCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0E275( )
   {
      /* Scan next routine */
      pr_default.readNext(30);
      RcdFound275 = (short)(0) ;
      if ( (pr_default.getStatus(30) != 101) )
      {
         RcdFound275 = (short)(1) ;
         A2227propCod = T000E32_A2227propCod[0] ;
      }
   }

   public void scanEnd0E275( )
   {
      pr_default.close(30);
   }

   public void afterConfirm0E275( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0E275( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0E275( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0E275( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0E275( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0E275( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0E275( )
   {
      edtpropCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtpropCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropCod_Enabled), 5, 0), !bGXsfl_65_Refreshing);
      edtpropDesc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtpropDesc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropDesc_Enabled), 5, 0), !bGXsfl_65_Refreshing);
      cmbpropTipoDato.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbpropTipoDato.getInternalname(), "Enabled", GXutil.ltrimstr( cmbpropTipoDato.getEnabled(), 5, 0), !bGXsfl_65_Refreshing);
   }

   public void send_integrity_lvl_hashes0E275( )
   {
   }

   public void send_integrity_lvl_hashes0E106( )
   {
   }

   public void subsflControlProps_65275( )
   {
      edtpropCod_Internalname = "PROPCOD_"+sGXsfl_65_idx ;
      edtpropDesc_Internalname = "PROPDESC_"+sGXsfl_65_idx ;
      cmbpropTipoDato.setInternalname( "PROPTIPODATO_"+sGXsfl_65_idx );
   }

   public void subsflControlProps_fel_65275( )
   {
      edtpropCod_Internalname = "PROPCOD_"+sGXsfl_65_fel_idx ;
      edtpropDesc_Internalname = "PROPDESC_"+sGXsfl_65_fel_idx ;
      cmbpropTipoDato.setInternalname( "PROPTIPODATO_"+sGXsfl_65_fel_idx );
   }

   public void addRow0E275( )
   {
      nGXsfl_65_idx = (int)(nGXsfl_65_idx+1) ;
      sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_65275( ) ;
      sendRow0E275( ) ;
   }

   public void sendRow0E275( )
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
         if ( ((int)((nGXsfl_65_idx) % (2))) == 0 )
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
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_275_" + sGXsfl_65_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 66,'',false,'" + sGXsfl_65_idx + "',65)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtpropCod_Internalname,GXutil.rtrim( A2227propCod),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,66);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtpropCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtpropCod_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(65),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodigoCaracter","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtpropDesc_Internalname,A2228propDesc,"","","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtpropDesc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtpropDesc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(65),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      GXCCtl = "PROPTIPODATO_" + sGXsfl_65_idx ;
      cmbpropTipoDato.setName( GXCCtl );
      cmbpropTipoDato.setWebtags( "" );
      cmbpropTipoDato.addItem("NUM", httpContext.getMessage( "Numérico", ""), (short)(0));
      cmbpropTipoDato.addItem("STR", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbpropTipoDato.addItem("BOOL", httpContext.getMessage( "Boolean", ""), (short)(0));
      cmbpropTipoDato.addItem("DATE", httpContext.getMessage( "Fecha", ""), (short)(0));
      if ( cmbpropTipoDato.getItemCount() > 0 )
      {
         A2229propTipoDato = cmbpropTipoDato.getValidValue(A2229propTipoDato) ;
      }
      /* ComboBox */
      Gridlevel1Row.AddColumnProperties("combobox", 2, isAjaxCallMode( ), new Object[] {cmbpropTipoDato,cmbpropTipoDato.getInternalname(),GXutil.rtrim( A2229propTipoDato),Integer.valueOf(1),cmbpropTipoDato.getJsonclick(),Integer.valueOf(0),"'"+""+"'"+",false,"+"'"+""+"'","char","",Integer.valueOf(-1),Integer.valueOf(cmbpropTipoDato.getEnabled()),Integer.valueOf(1),Integer.valueOf(0),Integer.valueOf(0),"px",Integer.valueOf(0),"px","","Attribute","TrnColumn","","","",Boolean.valueOf(true),Integer.valueOf(0)});
      cmbpropTipoDato.setValue( GXutil.rtrim( A2229propTipoDato) );
      httpContext.ajax_rsp_assign_prop("", false, cmbpropTipoDato.getInternalname(), "Values", cmbpropTipoDato.ToJavascriptSource(), !bGXsfl_65_Refreshing);
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes0E275( ) ;
      GXCCtl = "Z2227propCod_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2227propCod));
      GXCCtl = "Z2262ConvePropPredet_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2262ConvePropPredet));
      GXCCtl = "nRcdDeleted_275_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_275_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_275_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_275, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vPAICOD_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV17PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCONVECODIGO_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV8ConveCodigo));
      GXCCtl = "PAICOD_" + sGXsfl_65_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PROPCOD_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PROPDESC_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtpropDesc_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "PROPTIPODATO_"+sGXsfl_65_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( cmbpropTipoDato.getEnabled(), (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow0E275( )
   {
      nGXsfl_65_idx = (int)(nGXsfl_65_idx+1) ;
      sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_65275( ) ;
      edtpropCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PROPCOD_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtpropDesc_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "PROPDESC_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      cmbpropTipoDato.setEnabled( (int)(localUtil.ctol( httpContext.cgiGet( "PROPTIPODATO_"+sGXsfl_65_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) );
      A2227propCod = httpContext.cgiGet( edtpropCod_Internalname) ;
      A2228propDesc = httpContext.cgiGet( edtpropDesc_Internalname) ;
      cmbpropTipoDato.setName( cmbpropTipoDato.getInternalname() );
      cmbpropTipoDato.setValue( httpContext.cgiGet( cmbpropTipoDato.getInternalname()) );
      A2229propTipoDato = httpContext.cgiGet( cmbpropTipoDato.getInternalname()) ;
      GXCCtl = "Z2227propCod_" + sGXsfl_65_idx ;
      Z2227propCod = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2262ConvePropPredet_" + sGXsfl_65_idx ;
      Z2262ConvePropPredet = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2262ConvePropPredet_" + sGXsfl_65_idx ;
      A2262ConvePropPredet = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_275_" + sGXsfl_65_idx ;
      nRcdDeleted_275 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_275_" + sGXsfl_65_idx ;
      nRcdExists_275 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_275_" + sGXsfl_65_idx ;
      nIsMod_275 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtpropCod_Enabled = edtpropCod_Enabled ;
   }

   public void confirmValues0E0( )
   {
      nGXsfl_65_idx = 0 ;
      sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_65275( ) ;
      while ( nGXsfl_65_idx < nRC_GXsfl_65 )
      {
         nGXsfl_65_idx = (int)(nGXsfl_65_idx+1) ;
         sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_65275( ) ;
         httpContext.changePostValue( "Z2227propCod_"+sGXsfl_65_idx, httpContext.cgiGet( "ZT_"+"Z2227propCod_"+sGXsfl_65_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2227propCod_"+sGXsfl_65_idx) ;
         httpContext.changePostValue( "Z2262ConvePropPredet_"+sGXsfl_65_idx, httpContext.cgiGet( "ZT_"+"Z2262ConvePropPredet_"+sGXsfl_65_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2262ConvePropPredet_"+sGXsfl_65_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.convenio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV17PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConveCodigo))}, new String[] {"Gx_mode","PaiCod","ConveCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Convenio");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("ConveHabilitada", GXutil.booltostr( A161ConveHabilitada));
      forbiddenHiddens.add("ConveEsquemaEs", GXutil.booltostr( A2428ConveEsquemaEs));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("convenio:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z46PaiCod", GXutil.ltrim( localUtil.ntoc( Z46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z9ConveCodigo", GXutil.rtrim( Z9ConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z687ConveDescriSinAc", Z687ConveDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z160ConveDescri", Z160ConveDescri);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z161ConveHabilitada", Z161ConveHabilitada);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1915ConvBusGoogle", Z1915ConvBusGoogle);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1916ConvBusWeb", Z1916ConvBusWeb);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1917ConvBaseURL", Z1917ConvBaseURL);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1918ConvScrapTipo", GXutil.rtrim( Z1918ConvScrapTipo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1919ConvScrapTDoc", GXutil.rtrim( Z1919ConvScrapTDoc));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2131ConveEscFrecAct", GXutil.ltrim( localUtil.ntoc( Z2131ConveEscFrecAct, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2428ConveEsquemaEs", Z2428ConveEsquemaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "Z935ConveSinCod", GXutil.rtrim( Z935ConveSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_65", GXutil.ltrim( localUtil.ntoc( nGXsfl_65_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N935ConveSinCod", GXutil.rtrim( A935ConveSinCod));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV21DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vPROPCOD_DATA", AV20propCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vPROPCOD_DATA", AV20propCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEDESCRISINAC", A687ConveDescriSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPAICOD", GXutil.ltrim( localUtil.ntoc( AV17PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vPAICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV17PaiCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "PAICOD", GXutil.ltrim( localUtil.ntoc( A46PaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCONVECODIGO", GXutil.rtrim( AV8ConveCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCONVECODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV8ConveCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CONVESINCOD", GXutil.rtrim( AV18Insert_ConveSinCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONVEHABILITADA", A161ConveHabilitada);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "CONVEESQUEMAES", A2428ConveEsquemaEs);
      web.GxWebStd.gx_hidden_field( httpContext, "CONVESINDESC", A936ConveSinDesc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV26Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CONVEPROPPREDET", GXutil.rtrim( A2262ConvePropPredet));
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
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Objectcall", GXutil.rtrim( Combo_propcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Cls", GXutil.rtrim( Combo_propcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Enabled", GXutil.booltostr( Combo_propcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Titlecontrolidtoreplace", GXutil.rtrim( Combo_propcod_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Isgriditem", GXutil.booltostr( Combo_propcod_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Hasdescription", GXutil.booltostr( Combo_propcod_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Datalistproc", GXutil.rtrim( Combo_propcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_propcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_PROPCOD_Emptyitem", GXutil.booltostr( Combo_propcod_Emptyitem));
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
      return formatLink("web.convenio", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV17PaiCod,4,0)),GXutil.URLEncode(GXutil.rtrim(AV8ConveCodigo))}, new String[] {"Gx_mode","PaiCod","ConveCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Convenio" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Convenio", "") ;
   }

   public void initializeNonKey0E106( )
   {
      A935ConveSinCod = "" ;
      n935ConveSinCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A935ConveSinCod", A935ConveSinCod);
      n935ConveSinCod = ((GXutil.strcmp("", A935ConveSinCod)==0) ? true : false) ;
      A687ConveDescriSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A687ConveDescriSinAc", A687ConveDescriSinAc);
      A160ConveDescri = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A160ConveDescri", A160ConveDescri);
      A936ConveSinDesc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A936ConveSinDesc", A936ConveSinDesc);
      A1915ConvBusGoogle = "" ;
      n1915ConvBusGoogle = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1915ConvBusGoogle", A1915ConvBusGoogle);
      n1915ConvBusGoogle = ((GXutil.strcmp("", A1915ConvBusGoogle)==0) ? true : false) ;
      A1916ConvBusWeb = "" ;
      n1916ConvBusWeb = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1916ConvBusWeb", A1916ConvBusWeb);
      n1916ConvBusWeb = ((GXutil.strcmp("", A1916ConvBusWeb)==0) ? true : false) ;
      A1917ConvBaseURL = "" ;
      n1917ConvBaseURL = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1917ConvBaseURL", A1917ConvBaseURL);
      n1917ConvBaseURL = ((GXutil.strcmp("", A1917ConvBaseURL)==0) ? true : false) ;
      A1918ConvScrapTipo = "" ;
      n1918ConvScrapTipo = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
      n1918ConvScrapTipo = ((GXutil.strcmp("", A1918ConvScrapTipo)==0) ? true : false) ;
      A1919ConvScrapTDoc = "" ;
      n1919ConvScrapTDoc = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
      n1919ConvScrapTDoc = ((GXutil.strcmp("", A1919ConvScrapTDoc)==0) ? true : false) ;
      A2131ConveEscFrecAct = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A2131ConveEscFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2131ConveEscFrecAct), 4, 0));
      A2428ConveEsquemaEs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2428ConveEsquemaEs", A2428ConveEsquemaEs);
      A161ConveHabilitada = true ;
      httpContext.ajax_rsp_assign_attri("", false, "A161ConveHabilitada", A161ConveHabilitada);
      Z687ConveDescriSinAc = "" ;
      Z160ConveDescri = "" ;
      Z161ConveHabilitada = false ;
      Z1915ConvBusGoogle = "" ;
      Z1916ConvBusWeb = "" ;
      Z1917ConvBaseURL = "" ;
      Z1918ConvScrapTipo = "" ;
      Z1919ConvScrapTDoc = "" ;
      Z2131ConveEscFrecAct = (short)(0) ;
      Z2428ConveEsquemaEs = false ;
      Z935ConveSinCod = "" ;
   }

   public void initAll0E106( )
   {
      A46PaiCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A46PaiCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A46PaiCod), 4, 0));
      A9ConveCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A9ConveCodigo", A9ConveCodigo);
      initializeNonKey0E106( ) ;
   }

   public void standaloneModalInsert( )
   {
      A161ConveHabilitada = i161ConveHabilitada ;
      httpContext.ajax_rsp_assign_attri("", false, "A161ConveHabilitada", A161ConveHabilitada);
   }

   public void initializeNonKey0E275( )
   {
      A2228propDesc = "" ;
      A2229propTipoDato = "" ;
      A2262ConvePropPredet = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2262ConvePropPredet", A2262ConvePropPredet);
      Z2262ConvePropPredet = "" ;
   }

   public void initAll0E275( )
   {
      A2227propCod = "" ;
      initializeNonKey0E275( ) ;
   }

   public void standaloneModalInsert0E275( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202518721172", true, true);
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
      httpContext.AddJavascriptSource("convenio.js", "?202518721173", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties275( )
   {
      edtpropCod_Enabled = defedtpropCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtpropCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtpropCod_Enabled), 5, 0), !bGXsfl_65_Refreshing);
   }

   public void startgridcontrol65( )
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
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A2227propCod));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtpropCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2228propDesc);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtpropDesc_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A2229propTipoDato));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( cmbpropTipoDato.getEnabled(), (byte)(5), (byte)(0), ".", "")));
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
      edtConveCodigo_Internalname = "CONVECODIGO" ;
      edtConveDescri_Internalname = "CONVEDESCRI" ;
      dynConveSinCod.setInternalname( "CONVESINCOD" );
      edtConveEscFrecAct_Internalname = "CONVEESCFRECACT" ;
      edtConvBusGoogle_Internalname = "CONVBUSGOOGLE" ;
      edtConvBusWeb_Internalname = "CONVBUSWEB" ;
      edtConvBaseURL_Internalname = "CONVBASEURL" ;
      cmbConvScrapTDoc.setInternalname( "CONVSCRAPTDOC" );
      cmbConvScrapTipo.setInternalname( "CONVSCRAPTIPO" );
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtpropCod_Internalname = "PROPCOD" ;
      edtpropDesc_Internalname = "PROPDESC" ;
      cmbpropTipoDato.setInternalname( "PROPTIPODATO" );
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_propcod_Internalname = "COMBO_PROPCOD" ;
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
      Combo_propcod_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Convenio", "") );
      cmbpropTipoDato.setJsonclick( "" );
      edtpropDesc_Jsonclick = "" ;
      edtpropCod_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      Combo_propcod_Titlecontrolidtoreplace = "" ;
      Combo_propcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_propcod_Datalistprocparametersprefix = " \"ComboName\": \"propCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"PaiCod\": 0, \"ConveCodigo\": \"\"" ;
      Combo_propcod_Datalistproc = "ConvenioLoadDVCombo" ;
      Combo_propcod_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_propcod_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_propcod_Cls = "ExtendedCombo" ;
      Combo_propcod_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      cmbpropTipoDato.setEnabled( 0 );
      edtpropDesc_Enabled = 0 ;
      edtpropCod_Enabled = 1 ;
      cmbConvScrapTipo.setJsonclick( "" );
      cmbConvScrapTipo.setEnabled( 1 );
      cmbConvScrapTDoc.setJsonclick( "" );
      cmbConvScrapTDoc.setEnabled( 1 );
      edtConvBaseURL_Jsonclick = "" ;
      edtConvBaseURL_Enabled = 1 ;
      edtConvBusWeb_Jsonclick = "" ;
      edtConvBusWeb_Enabled = 1 ;
      edtConvBusGoogle_Jsonclick = "" ;
      edtConvBusGoogle_Enabled = 1 ;
      edtConveEscFrecAct_Jsonclick = "" ;
      edtConveEscFrecAct_Enabled = 1 ;
      dynConveSinCod.setJsonclick( "" );
      dynConveSinCod.setEnabled( 1 );
      edtConveDescri_Enabled = 1 ;
      edtConveCodigo_Jsonclick = "" ;
      edtConveCodigo_Enabled = 1 ;
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

   public void gxdlaconvesincod0E106( short AV17PaiCod )
   {
      if ( ! httpContext.isAjaxRequest( ) )
      {
         httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
      }
      addString( "[[") ;
      gxdlaconvesincod_data0E106( AV17PaiCod) ;
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

   public void gxaconvesincod_html0E106( short AV17PaiCod )
   {
      String gxdynajaxvalue;
      gxdlaconvesincod_data0E106( AV17PaiCod) ;
      gxdynajaxindex = 1 ;
      if ( ! ( gxdyncontrolsrefreshing && httpContext.isAjaxRequest( ) ) )
      {
         dynConveSinCod.removeAllItems();
      }
      while ( gxdynajaxindex <= gxdynajaxctrlcodr.getCount() )
      {
         gxdynajaxvalue = gxdynajaxctrlcodr.item(gxdynajaxindex) ;
         dynConveSinCod.addItem(gxdynajaxvalue, gxdynajaxctrldescr.item(gxdynajaxindex), (short)(0));
         gxdynajaxindex = (int)(gxdynajaxindex+1) ;
      }
   }

   protected void gxdlaconvesincod_data0E106( short AV17PaiCod )
   {
      gxdynajaxctrlcodr.removeAllItems();
      gxdynajaxctrldescr.removeAllItems();
      /* Using cursor T000E33 */
      pr_default.execute(31, new Object[] {Short.valueOf(AV17PaiCod)});
      while ( (pr_default.getStatus(31) != 101) )
      {
         gxdynajaxctrlcodr.add(GXutil.rtrim( T000E33_A14SinCod[0]));
         gxdynajaxctrldescr.add(T000E33_A331SinDescrip[0]);
         pr_default.readNext(31);
      }
      pr_default.close(31);
   }

   public void gx6asaconvedescrisinac0E106( String A160ConveDescri )
   {
      GXt_char6 = A687ConveDescriSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char7) ;
      convenio_impl.this.GXt_char6 = GXv_char7[0] ;
      A687ConveDescriSinAc = GXt_char6 ;
      httpContext.ajax_rsp_assign_attri("", false, "A687ConveDescriSinAc", A687ConveDescriSinAc);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A687ConveDescriSinAc)+"\"") ;
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
      subsflControlProps_65275( ) ;
      while ( nGXsfl_65_idx <= nRC_GXsfl_65 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0E275( ) ;
         standaloneModal0E275( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0E275( ) ;
         nGXsfl_65_idx = (int)(nGXsfl_65_idx+1) ;
         sGXsfl_65_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_65_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_65275( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      dynConveSinCod.setName( "CONVESINCOD" );
      dynConveSinCod.setWebtags( "" );
      cmbConvScrapTDoc.setName( "CONVSCRAPTDOC" );
      cmbConvScrapTDoc.setWebtags( "" );
      cmbConvScrapTDoc.addItem("HTML", httpContext.getMessage( "Html", ""), (short)(0));
      cmbConvScrapTDoc.addItem("PDF", httpContext.getMessage( "PDF", ""), (short)(0));
      if ( cmbConvScrapTDoc.getItemCount() > 0 )
      {
         A1919ConvScrapTDoc = cmbConvScrapTDoc.getValidValue(A1919ConvScrapTDoc) ;
         n1919ConvScrapTDoc = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1919ConvScrapTDoc", A1919ConvScrapTDoc);
      }
      cmbConvScrapTipo.setName( "CONVSCRAPTIPO" );
      cmbConvScrapTipo.setWebtags( "" );
      cmbConvScrapTipo.addItem("Tabla", httpContext.getMessage( "Tabla", ""), (short)(0));
      cmbConvScrapTipo.addItem("Texto", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbConvScrapTipo.addItem("Imagen", httpContext.getMessage( "Imagen", ""), (short)(0));
      if ( cmbConvScrapTipo.getItemCount() > 0 )
      {
         A1918ConvScrapTipo = cmbConvScrapTipo.getValidValue(A1918ConvScrapTipo) ;
         n1918ConvScrapTipo = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A1918ConvScrapTipo", A1918ConvScrapTipo);
      }
      GXCCtl = "PROPTIPODATO_" + sGXsfl_65_idx ;
      cmbpropTipoDato.setName( GXCCtl );
      cmbpropTipoDato.setWebtags( "" );
      cmbpropTipoDato.addItem("NUM", httpContext.getMessage( "Numérico", ""), (short)(0));
      cmbpropTipoDato.addItem("STR", httpContext.getMessage( "Texto", ""), (short)(0));
      cmbpropTipoDato.addItem("BOOL", httpContext.getMessage( "Boolean", ""), (short)(0));
      cmbpropTipoDato.addItem("DATE", httpContext.getMessage( "Fecha", ""), (short)(0));
      if ( cmbpropTipoDato.getItemCount() > 0 )
      {
         A2229propTipoDato = cmbpropTipoDato.getValidValue(A2229propTipoDato) ;
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

   public void valid_Convedescri( )
   {
      n935ConveSinCod = false ;
      A935ConveSinCod = dynConveSinCod.getValue() ;
      n935ConveSinCod = false ;
      GXt_char6 = A687ConveDescriSinAc ;
      GXv_char7[0] = GXt_char6 ;
      new web.sacaracentos2(remoteHandle, context).execute( A160ConveDescri, GXv_char7) ;
      convenio_impl.this.GXt_char6 = GXv_char7[0] ;
      A687ConveDescriSinAc = GXt_char6 ;
      if ( (GXutil.strcmp("", A160ConveDescri)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Convenio", ""), "", "", "", "", "", "", "", ""), 1, "CONVEDESCRI");
         AnyError = (short)(1) ;
         GX_FocusControl = edtConveDescri_Internalname ;
      }
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A687ConveDescriSinAc", A687ConveDescriSinAc);
   }

   public void valid_Convesincod( )
   {
      n935ConveSinCod = false ;
      A935ConveSinCod = dynConveSinCod.getValue() ;
      n935ConveSinCod = false ;
      /* Using cursor T000E34 */
      pr_default.execute(32, new Object[] {Short.valueOf(A46PaiCod), Boolean.valueOf(n935ConveSinCod), A935ConveSinCod});
      if ( (pr_default.getStatus(32) == 101) )
      {
         if ( ! ( (0==A46PaiCod) || (GXutil.strcmp("", A935ConveSinCod)==0) ) )
         {
            httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Convenio Sindicato Group", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CONVESINCOD");
            AnyError = (short)(1) ;
            GX_FocusControl = dynConveSinCod.getInternalname() ;
         }
      }
      A936ConveSinDesc = T000E34_A936ConveSinDesc[0] ;
      pr_default.close(32);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A936ConveSinDesc", A936ConveSinDesc);
   }

   public void valid_Propcod( )
   {
      n935ConveSinCod = false ;
      A935ConveSinCod = dynConveSinCod.getValue() ;
      n935ConveSinCod = false ;
      A2229propTipoDato = cmbpropTipoDato.getValue() ;
      cmbpropTipoDato.setValue( A2229propTipoDato );
      /* Using cursor T000E31 */
      pr_default.execute(29, new Object[] {A2227propCod});
      if ( (pr_default.getStatus(29) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "propiedades_adicionales", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "PROPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtpropCod_Internalname ;
      }
      A2228propDesc = T000E31_A2228propDesc[0] ;
      A2229propTipoDato = T000E31_A2229propTipoDato[0] ;
      cmbpropTipoDato.setValue( A2229propTipoDato );
      pr_default.close(29);
      dynload_actions( ) ;
      if ( cmbpropTipoDato.getItemCount() > 0 )
      {
         A2229propTipoDato = cmbpropTipoDato.getValidValue(A2229propTipoDato) ;
         cmbpropTipoDato.setValue( A2229propTipoDato );
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbpropTipoDato.setValue( GXutil.rtrim( A2229propTipoDato) );
      }
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A2228propDesc", A2228propDesc);
      httpContext.ajax_rsp_assign_attri("", false, "A2229propTipoDato", GXutil.rtrim( A2229propTipoDato));
      cmbpropTipoDato.setValue( GXutil.rtrim( A2229propTipoDato) );
      httpContext.ajax_rsp_assign_prop("", false, cmbpropTipoDato.getInternalname(), "Values", cmbpropTipoDato.ToJavascriptSource(), true);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8ConveCodigo',fld:'vCONVECODIGO',pic:'',hsh:true},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV8ConveCodigo',fld:'vCONVECODIGO',pic:'',hsh:true},{av:'A161ConveHabilitada',fld:'CONVEHABILITADA',pic:''},{av:'A2428ConveEsquemaEs',fld:'CONVEESQUEMAES',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("AFTER TRN","{handler:'e120E2',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("AFTER TRN",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVECODIGO","{handler:'valid_Convecodigo',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVECODIGO",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVEDESCRI","{handler:'valid_Convedescri',iparms:[{av:'A160ConveDescri',fld:'CONVEDESCRI',pic:''},{av:'A687ConveDescriSinAc',fld:'CONVEDESCRISINAC',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVEDESCRI",",oparms:[{av:'A687ConveDescriSinAc',fld:'CONVEDESCRISINAC',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVESINCOD","{handler:'valid_Convesincod',iparms:[{av:'A46PaiCod',fld:'PAICOD',pic:'ZZZ9'},{av:'A936ConveSinDesc',fld:'CONVESINDESC',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVESINCOD",",oparms:[{av:'A936ConveSinDesc',fld:'CONVESINDESC',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVBASEURL","{handler:'valid_Convbaseurl',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVBASEURL",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVSCRAPTDOC","{handler:'valid_Convscraptdoc',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVSCRAPTDOC",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_CONVSCRAPTIPO","{handler:'valid_Convscraptipo',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_CONVSCRAPTIPO",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("VALID_PROPCOD","{handler:'valid_Propcod',iparms:[{av:'A2227propCod',fld:'PROPCOD',pic:''},{av:'A2228propDesc',fld:'PROPDESC',pic:''},{av:'cmbpropTipoDato'},{av:'A2229propTipoDato',fld:'PROPTIPODATO',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("VALID_PROPCOD",",oparms:[{av:'A2228propDesc',fld:'PROPDESC',pic:''},{av:'cmbpropTipoDato'},{av:'A2229propTipoDato',fld:'PROPTIPODATO',pic:''},{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9'},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
      setEventMetadata("NULL","{handler:'valid_Proptipodato',iparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]");
      setEventMetadata("NULL",",oparms:[{av:'AV17PaiCod',fld:'vPAICOD',pic:'ZZZ9',hsh:true},{av:'dynConveSinCod'},{av:'A935ConveSinCod',fld:'CONVESINCOD',pic:''}]}");
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
      pr_default.close(29);
      pr_default.close(32);
      pr_default.close(15);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV8ConveCodigo = "" ;
      Z9ConveCodigo = "" ;
      Z687ConveDescriSinAc = "" ;
      Z160ConveDescri = "" ;
      Z1915ConvBusGoogle = "" ;
      Z1916ConvBusWeb = "" ;
      Z1917ConvBaseURL = "" ;
      Z1918ConvScrapTipo = "" ;
      Z1919ConvScrapTDoc = "" ;
      Z935ConveSinCod = "" ;
      N935ConveSinCod = "" ;
      Z2227propCod = "" ;
      Z2262ConvePropPredet = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A160ConveDescri = "" ;
      A935ConveSinCod = "" ;
      A2227propCod = "" ;
      Gx_mode = "" ;
      AV8ConveCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A1919ConvScrapTDoc = "" ;
      A1918ConvScrapTipo = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A9ConveCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A1915ConvBusGoogle = "" ;
      A1916ConvBusWeb = "" ;
      A1917ConvBaseURL = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode275 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_propcod = new com.genexus.webpanels.GXUserControl();
      AV21DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV20propCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A687ConveDescriSinAc = "" ;
      AV18Insert_ConveSinCod = "" ;
      A936ConveSinDesc = "" ;
      AV26Pgmname = "" ;
      A2262ConvePropPredet = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_propcod_Objectcall = "" ;
      Combo_propcod_Class = "" ;
      Combo_propcod_Icontype = "" ;
      Combo_propcod_Icon = "" ;
      Combo_propcod_Tooltip = "" ;
      Combo_propcod_Selectedvalue_set = "" ;
      Combo_propcod_Selectedvalue_get = "" ;
      Combo_propcod_Selectedtext_set = "" ;
      Combo_propcod_Selectedtext_get = "" ;
      Combo_propcod_Gamoauthtoken = "" ;
      Combo_propcod_Ddointernalname = "" ;
      Combo_propcod_Titlecontrolalign = "" ;
      Combo_propcod_Dropdownoptionstype = "" ;
      Combo_propcod_Datalisttype = "" ;
      Combo_propcod_Datalistfixedvalues = "" ;
      Combo_propcod_Remoteservicesparameters = "" ;
      Combo_propcod_Htmltemplate = "" ;
      Combo_propcod_Multiplevaluestype = "" ;
      Combo_propcod_Loadingdata = "" ;
      Combo_propcod_Noresultsfound = "" ;
      Combo_propcod_Emptyitemtext = "" ;
      Combo_propcod_Onlyselectedvalues = "" ;
      Combo_propcod_Selectalltext = "" ;
      Combo_propcod_Multiplevaluesseparator = "" ;
      Combo_propcod_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode106 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A2228propDesc = "" ;
      A2229propTipoDato = "" ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      AV12TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV13WebSession = httpContext.getWebSession();
      AV15TrnContextAtt = new web.wwpbaseobjects.SdtWWPTransactionContext_Attribute(remoteHandle, context);
      Z936ConveSinDesc = "" ;
      GXv_boolean5 = new boolean[1] ;
      T000E7_A46PaiCod = new short[1] ;
      T000E8_A936ConveSinDesc = new String[] {""} ;
      T000E9_A687ConveDescriSinAc = new String[] {""} ;
      T000E9_A9ConveCodigo = new String[] {""} ;
      T000E9_A160ConveDescri = new String[] {""} ;
      T000E9_A161ConveHabilitada = new boolean[] {false} ;
      T000E9_A936ConveSinDesc = new String[] {""} ;
      T000E9_A1915ConvBusGoogle = new String[] {""} ;
      T000E9_n1915ConvBusGoogle = new boolean[] {false} ;
      T000E9_A1916ConvBusWeb = new String[] {""} ;
      T000E9_n1916ConvBusWeb = new boolean[] {false} ;
      T000E9_A1917ConvBaseURL = new String[] {""} ;
      T000E9_n1917ConvBaseURL = new boolean[] {false} ;
      T000E9_A1918ConvScrapTipo = new String[] {""} ;
      T000E9_n1918ConvScrapTipo = new boolean[] {false} ;
      T000E9_A1919ConvScrapTDoc = new String[] {""} ;
      T000E9_n1919ConvScrapTDoc = new boolean[] {false} ;
      T000E9_A2131ConveEscFrecAct = new short[1] ;
      T000E9_A2428ConveEsquemaEs = new boolean[] {false} ;
      T000E9_A46PaiCod = new short[1] ;
      T000E9_A935ConveSinCod = new String[] {""} ;
      T000E9_n935ConveSinCod = new boolean[] {false} ;
      T000E10_A936ConveSinDesc = new String[] {""} ;
      T000E11_A46PaiCod = new short[1] ;
      T000E11_A9ConveCodigo = new String[] {""} ;
      T000E6_A687ConveDescriSinAc = new String[] {""} ;
      T000E6_A9ConveCodigo = new String[] {""} ;
      T000E6_A160ConveDescri = new String[] {""} ;
      T000E6_A161ConveHabilitada = new boolean[] {false} ;
      T000E6_A1915ConvBusGoogle = new String[] {""} ;
      T000E6_n1915ConvBusGoogle = new boolean[] {false} ;
      T000E6_A1916ConvBusWeb = new String[] {""} ;
      T000E6_n1916ConvBusWeb = new boolean[] {false} ;
      T000E6_A1917ConvBaseURL = new String[] {""} ;
      T000E6_n1917ConvBaseURL = new boolean[] {false} ;
      T000E6_A1918ConvScrapTipo = new String[] {""} ;
      T000E6_n1918ConvScrapTipo = new boolean[] {false} ;
      T000E6_A1919ConvScrapTDoc = new String[] {""} ;
      T000E6_n1919ConvScrapTDoc = new boolean[] {false} ;
      T000E6_A2131ConveEscFrecAct = new short[1] ;
      T000E6_A2428ConveEsquemaEs = new boolean[] {false} ;
      T000E6_A46PaiCod = new short[1] ;
      T000E6_A935ConveSinCod = new String[] {""} ;
      T000E6_n935ConveSinCod = new boolean[] {false} ;
      T000E12_A46PaiCod = new short[1] ;
      T000E12_A9ConveCodigo = new String[] {""} ;
      T000E13_A46PaiCod = new short[1] ;
      T000E13_A9ConveCodigo = new String[] {""} ;
      T000E5_A687ConveDescriSinAc = new String[] {""} ;
      T000E5_A9ConveCodigo = new String[] {""} ;
      T000E5_A160ConveDescri = new String[] {""} ;
      T000E5_A161ConveHabilitada = new boolean[] {false} ;
      T000E5_A1915ConvBusGoogle = new String[] {""} ;
      T000E5_n1915ConvBusGoogle = new boolean[] {false} ;
      T000E5_A1916ConvBusWeb = new String[] {""} ;
      T000E5_n1916ConvBusWeb = new boolean[] {false} ;
      T000E5_A1917ConvBaseURL = new String[] {""} ;
      T000E5_n1917ConvBaseURL = new boolean[] {false} ;
      T000E5_A1918ConvScrapTipo = new String[] {""} ;
      T000E5_n1918ConvScrapTipo = new boolean[] {false} ;
      T000E5_A1919ConvScrapTDoc = new String[] {""} ;
      T000E5_n1919ConvScrapTDoc = new boolean[] {false} ;
      T000E5_A2131ConveEscFrecAct = new short[1] ;
      T000E5_A2428ConveEsquemaEs = new boolean[] {false} ;
      T000E5_A46PaiCod = new short[1] ;
      T000E5_A935ConveSinCod = new String[] {""} ;
      T000E5_n935ConveSinCod = new boolean[] {false} ;
      T000E17_A936ConveSinDesc = new String[] {""} ;
      T000E18_A3CliCod = new int[1] ;
      T000E18_A26ConCodigo = new String[] {""} ;
      T000E19_A3CliCod = new int[1] ;
      T000E19_A1564CliPaiConve = new short[1] ;
      T000E19_A1565CliConvenio = new String[] {""} ;
      T000E20_A3CliCod = new int[1] ;
      T000E20_A1564CliPaiConve = new short[1] ;
      T000E20_A1565CliConvenio = new String[] {""} ;
      T000E21_A3CliCod = new int[1] ;
      T000E21_A1EmpCod = new short[1] ;
      T000E21_A1562EmpConvePai = new short[1] ;
      T000E21_A1561EmpConveCod = new String[] {""} ;
      T000E22_A46PaiCod = new short[1] ;
      T000E22_A1223FerId = new String[] {""} ;
      T000E23_A46PaiCod = new short[1] ;
      T000E23_A9ConveCodigo = new String[] {""} ;
      T000E23_A1048ConveVacDesdeAnti = new byte[1] ;
      T000E24_A46PaiCod = new short[1] ;
      T000E24_A9ConveCodigo = new String[] {""} ;
      Z2228propDesc = "" ;
      Z2229propTipoDato = "" ;
      T000E25_A46PaiCod = new short[1] ;
      T000E25_A9ConveCodigo = new String[] {""} ;
      T000E25_A2228propDesc = new String[] {""} ;
      T000E25_A2229propTipoDato = new String[] {""} ;
      T000E25_A2262ConvePropPredet = new String[] {""} ;
      T000E25_A2227propCod = new String[] {""} ;
      T000E4_A2228propDesc = new String[] {""} ;
      T000E4_A2229propTipoDato = new String[] {""} ;
      T000E26_A2228propDesc = new String[] {""} ;
      T000E26_A2229propTipoDato = new String[] {""} ;
      T000E27_A46PaiCod = new short[1] ;
      T000E27_A9ConveCodigo = new String[] {""} ;
      T000E27_A2227propCod = new String[] {""} ;
      T000E3_A46PaiCod = new short[1] ;
      T000E3_A9ConveCodigo = new String[] {""} ;
      T000E3_A2262ConvePropPredet = new String[] {""} ;
      T000E3_A2227propCod = new String[] {""} ;
      T000E2_A46PaiCod = new short[1] ;
      T000E2_A9ConveCodigo = new String[] {""} ;
      T000E2_A2262ConvePropPredet = new String[] {""} ;
      T000E2_A2227propCod = new String[] {""} ;
      T000E31_A2228propDesc = new String[] {""} ;
      T000E31_A2229propTipoDato = new String[] {""} ;
      T000E32_A46PaiCod = new short[1] ;
      T000E32_A9ConveCodigo = new String[] {""} ;
      T000E32_A2227propCod = new String[] {""} ;
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
      T000E33_A46PaiCod = new short[1] ;
      T000E33_A14SinCod = new String[] {""} ;
      T000E33_A331SinDescrip = new String[] {""} ;
      GXt_char6 = "" ;
      GXv_char7 = new String[1] ;
      T000E34_A936ConveSinDesc = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.convenio__default(),
         new Object[] {
             new Object[] {
            T000E2_A46PaiCod, T000E2_A9ConveCodigo, T000E2_A2262ConvePropPredet, T000E2_A2227propCod
            }
            , new Object[] {
            T000E3_A46PaiCod, T000E3_A9ConveCodigo, T000E3_A2262ConvePropPredet, T000E3_A2227propCod
            }
            , new Object[] {
            T000E4_A2228propDesc, T000E4_A2229propTipoDato
            }
            , new Object[] {
            T000E5_A687ConveDescriSinAc, T000E5_A9ConveCodigo, T000E5_A160ConveDescri, T000E5_A161ConveHabilitada, T000E5_A1915ConvBusGoogle, T000E5_n1915ConvBusGoogle, T000E5_A1916ConvBusWeb, T000E5_n1916ConvBusWeb, T000E5_A1917ConvBaseURL, T000E5_n1917ConvBaseURL,
            T000E5_A1918ConvScrapTipo, T000E5_n1918ConvScrapTipo, T000E5_A1919ConvScrapTDoc, T000E5_n1919ConvScrapTDoc, T000E5_A2131ConveEscFrecAct, T000E5_A2428ConveEsquemaEs, T000E5_A46PaiCod, T000E5_A935ConveSinCod, T000E5_n935ConveSinCod
            }
            , new Object[] {
            T000E6_A687ConveDescriSinAc, T000E6_A9ConveCodigo, T000E6_A160ConveDescri, T000E6_A161ConveHabilitada, T000E6_A1915ConvBusGoogle, T000E6_n1915ConvBusGoogle, T000E6_A1916ConvBusWeb, T000E6_n1916ConvBusWeb, T000E6_A1917ConvBaseURL, T000E6_n1917ConvBaseURL,
            T000E6_A1918ConvScrapTipo, T000E6_n1918ConvScrapTipo, T000E6_A1919ConvScrapTDoc, T000E6_n1919ConvScrapTDoc, T000E6_A2131ConveEscFrecAct, T000E6_A2428ConveEsquemaEs, T000E6_A46PaiCod, T000E6_A935ConveSinCod, T000E6_n935ConveSinCod
            }
            , new Object[] {
            T000E7_A46PaiCod
            }
            , new Object[] {
            T000E8_A936ConveSinDesc
            }
            , new Object[] {
            T000E9_A687ConveDescriSinAc, T000E9_A9ConveCodigo, T000E9_A160ConveDescri, T000E9_A161ConveHabilitada, T000E9_A936ConveSinDesc, T000E9_A1915ConvBusGoogle, T000E9_n1915ConvBusGoogle, T000E9_A1916ConvBusWeb, T000E9_n1916ConvBusWeb, T000E9_A1917ConvBaseURL,
            T000E9_n1917ConvBaseURL, T000E9_A1918ConvScrapTipo, T000E9_n1918ConvScrapTipo, T000E9_A1919ConvScrapTDoc, T000E9_n1919ConvScrapTDoc, T000E9_A2131ConveEscFrecAct, T000E9_A2428ConveEsquemaEs, T000E9_A46PaiCod, T000E9_A935ConveSinCod, T000E9_n935ConveSinCod
            }
            , new Object[] {
            T000E10_A936ConveSinDesc
            }
            , new Object[] {
            T000E11_A46PaiCod, T000E11_A9ConveCodigo
            }
            , new Object[] {
            T000E12_A46PaiCod, T000E12_A9ConveCodigo
            }
            , new Object[] {
            T000E13_A46PaiCod, T000E13_A9ConveCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000E17_A936ConveSinDesc
            }
            , new Object[] {
            T000E18_A3CliCod, T000E18_A26ConCodigo
            }
            , new Object[] {
            T000E19_A3CliCod, T000E19_A1564CliPaiConve, T000E19_A1565CliConvenio
            }
            , new Object[] {
            T000E20_A3CliCod, T000E20_A1564CliPaiConve, T000E20_A1565CliConvenio
            }
            , new Object[] {
            T000E21_A3CliCod, T000E21_A1EmpCod, T000E21_A1562EmpConvePai, T000E21_A1561EmpConveCod
            }
            , new Object[] {
            T000E22_A46PaiCod, T000E22_A1223FerId
            }
            , new Object[] {
            T000E23_A46PaiCod, T000E23_A9ConveCodigo, T000E23_A1048ConveVacDesdeAnti
            }
            , new Object[] {
            T000E24_A46PaiCod, T000E24_A9ConveCodigo
            }
            , new Object[] {
            T000E25_A46PaiCod, T000E25_A9ConveCodigo, T000E25_A2228propDesc, T000E25_A2229propTipoDato, T000E25_A2262ConvePropPredet, T000E25_A2227propCod
            }
            , new Object[] {
            T000E26_A2228propDesc, T000E26_A2229propTipoDato
            }
            , new Object[] {
            T000E27_A46PaiCod, T000E27_A9ConveCodigo, T000E27_A2227propCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000E31_A2228propDesc, T000E31_A2229propTipoDato
            }
            , new Object[] {
            T000E32_A46PaiCod, T000E32_A9ConveCodigo, T000E32_A2227propCod
            }
            , new Object[] {
            T000E33_A46PaiCod, T000E33_A14SinCod, T000E33_A331SinDescrip
            }
            , new Object[] {
            T000E34_A936ConveSinDesc
            }
         }
      );
      AV26Pgmname = "Convenio" ;
      Z161ConveHabilitada = true ;
      A161ConveHabilitada = true ;
      i161ConveHabilitada = true ;
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
   private short wcpOAV17PaiCod ;
   private short Z46PaiCod ;
   private short Z2131ConveEscFrecAct ;
   private short nRcdDeleted_275 ;
   private short nRcdExists_275 ;
   private short nIsMod_275 ;
   private short AV17PaiCod ;
   private short A46PaiCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A2131ConveEscFrecAct ;
   private short nBlankRcdCount275 ;
   private short RcdFound275 ;
   private short nBlankRcdUsr275 ;
   private short RcdFound106 ;
   private short nIsDirty_106 ;
   private short nIsDirty_275 ;
   private int nRC_GXsfl_65 ;
   private int nGXsfl_65_idx=1 ;
   private int trnEnded ;
   private int edtConveCodigo_Enabled ;
   private int edtConveDescri_Enabled ;
   private int edtConveEscFrecAct_Enabled ;
   private int edtConvBusGoogle_Enabled ;
   private int edtConvBusWeb_Enabled ;
   private int edtConvBaseURL_Enabled ;
   private int edtpropCod_Enabled ;
   private int edtpropDesc_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Combo_propcod_Datalistupdateminimumcharacters ;
   private int Combo_propcod_Gxcontroltype ;
   private int AV27GXV1 ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtpropCod_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int gxdynajaxindex ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV8ConveCodigo ;
   private String Z9ConveCodigo ;
   private String Z1918ConvScrapTipo ;
   private String Z1919ConvScrapTDoc ;
   private String Z935ConveSinCod ;
   private String N935ConveSinCod ;
   private String Z2227propCod ;
   private String Z2262ConvePropPredet ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A935ConveSinCod ;
   private String A2227propCod ;
   private String Gx_mode ;
   private String AV8ConveCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtConveCodigo_Internalname ;
   private String sGXsfl_65_idx="0001" ;
   private String A1919ConvScrapTDoc ;
   private String A1918ConvScrapTipo ;
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
   private String A9ConveCodigo ;
   private String edtConveCodigo_Jsonclick ;
   private String edtConveDescri_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtConveEscFrecAct_Internalname ;
   private String edtConveEscFrecAct_Jsonclick ;
   private String edtConvBusGoogle_Internalname ;
   private String edtConvBusGoogle_Jsonclick ;
   private String edtConvBusWeb_Internalname ;
   private String edtConvBusWeb_Jsonclick ;
   private String edtConvBaseURL_Internalname ;
   private String edtConvBaseURL_Jsonclick ;
   private String sMode275 ;
   private String edtpropCod_Internalname ;
   private String edtpropDesc_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_propcod_Caption ;
   private String Combo_propcod_Cls ;
   private String Combo_propcod_Datalistproc ;
   private String Combo_propcod_Datalistprocparametersprefix ;
   private String Combo_propcod_Internalname ;
   private String AV18Insert_ConveSinCod ;
   private String AV26Pgmname ;
   private String A2262ConvePropPredet ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_propcod_Objectcall ;
   private String Combo_propcod_Class ;
   private String Combo_propcod_Icontype ;
   private String Combo_propcod_Icon ;
   private String Combo_propcod_Tooltip ;
   private String Combo_propcod_Selectedvalue_set ;
   private String Combo_propcod_Selectedvalue_get ;
   private String Combo_propcod_Selectedtext_set ;
   private String Combo_propcod_Selectedtext_get ;
   private String Combo_propcod_Gamoauthtoken ;
   private String Combo_propcod_Ddointernalname ;
   private String Combo_propcod_Titlecontrolalign ;
   private String Combo_propcod_Dropdownoptionstype ;
   private String Combo_propcod_Titlecontrolidtoreplace ;
   private String Combo_propcod_Datalisttype ;
   private String Combo_propcod_Datalistfixedvalues ;
   private String Combo_propcod_Remoteservicesparameters ;
   private String Combo_propcod_Htmltemplate ;
   private String Combo_propcod_Multiplevaluestype ;
   private String Combo_propcod_Loadingdata ;
   private String Combo_propcod_Noresultsfound ;
   private String Combo_propcod_Emptyitemtext ;
   private String Combo_propcod_Onlyselectedvalues ;
   private String Combo_propcod_Selectalltext ;
   private String Combo_propcod_Multiplevaluesseparator ;
   private String Combo_propcod_Addnewoptiontext ;
   private String hsh ;
   private String sMode106 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String A2229propTipoDato ;
   private String Z2229propTipoDato ;
   private String sGXsfl_65_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtpropCod_Jsonclick ;
   private String edtpropDesc_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String gxwrpcisep ;
   private String GXt_char6 ;
   private String GXv_char7[] ;
   private boolean Z161ConveHabilitada ;
   private boolean Z2428ConveEsquemaEs ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean n935ConveSinCod ;
   private boolean wbErr ;
   private boolean n1919ConvScrapTDoc ;
   private boolean n1918ConvScrapTipo ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_65_Refreshing=false ;
   private boolean Combo_propcod_Isgriditem ;
   private boolean Combo_propcod_Hasdescription ;
   private boolean Combo_propcod_Emptyitem ;
   private boolean n1915ConvBusGoogle ;
   private boolean n1916ConvBusWeb ;
   private boolean n1917ConvBaseURL ;
   private boolean A161ConveHabilitada ;
   private boolean A2428ConveEsquemaEs ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_propcod_Enabled ;
   private boolean Combo_propcod_Visible ;
   private boolean Combo_propcod_Allowmultipleselection ;
   private boolean Combo_propcod_Includeonlyselectedoption ;
   private boolean Combo_propcod_Includeselectalloption ;
   private boolean Combo_propcod_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV10IsAuthorized ;
   private boolean GXt_boolean4 ;
   private boolean GXv_boolean5[] ;
   private boolean Gx_longc ;
   private boolean i161ConveHabilitada ;
   private boolean gxdyncontrolsrefreshing ;
   private String Z687ConveDescriSinAc ;
   private String Z160ConveDescri ;
   private String Z1915ConvBusGoogle ;
   private String Z1916ConvBusWeb ;
   private String Z1917ConvBaseURL ;
   private String A160ConveDescri ;
   private String A1915ConvBusGoogle ;
   private String A1916ConvBusWeb ;
   private String A1917ConvBaseURL ;
   private String A687ConveDescriSinAc ;
   private String A936ConveSinDesc ;
   private String A2228propDesc ;
   private String Z936ConveSinDesc ;
   private String Z2228propDesc ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.internet.StringCollection gxdynajaxctrlcodr ;
   private com.genexus.internet.StringCollection gxdynajaxctrldescr ;
   private com.genexus.webpanels.WebSession AV13WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_propcod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice dynConveSinCod ;
   private HTMLChoice cmbConvScrapTDoc ;
   private HTMLChoice cmbConvScrapTipo ;
   private HTMLChoice cmbpropTipoDato ;
   private IDataStoreProvider pr_default ;
   private short[] T000E7_A46PaiCod ;
   private String[] T000E8_A936ConveSinDesc ;
   private String[] T000E9_A687ConveDescriSinAc ;
   private String[] T000E9_A9ConveCodigo ;
   private String[] T000E9_A160ConveDescri ;
   private boolean[] T000E9_A161ConveHabilitada ;
   private String[] T000E9_A936ConveSinDesc ;
   private String[] T000E9_A1915ConvBusGoogle ;
   private boolean[] T000E9_n1915ConvBusGoogle ;
   private String[] T000E9_A1916ConvBusWeb ;
   private boolean[] T000E9_n1916ConvBusWeb ;
   private String[] T000E9_A1917ConvBaseURL ;
   private boolean[] T000E9_n1917ConvBaseURL ;
   private String[] T000E9_A1918ConvScrapTipo ;
   private boolean[] T000E9_n1918ConvScrapTipo ;
   private String[] T000E9_A1919ConvScrapTDoc ;
   private boolean[] T000E9_n1919ConvScrapTDoc ;
   private short[] T000E9_A2131ConveEscFrecAct ;
   private boolean[] T000E9_A2428ConveEsquemaEs ;
   private short[] T000E9_A46PaiCod ;
   private String[] T000E9_A935ConveSinCod ;
   private boolean[] T000E9_n935ConveSinCod ;
   private String[] T000E10_A936ConveSinDesc ;
   private short[] T000E11_A46PaiCod ;
   private String[] T000E11_A9ConveCodigo ;
   private String[] T000E6_A687ConveDescriSinAc ;
   private String[] T000E6_A9ConveCodigo ;
   private String[] T000E6_A160ConveDescri ;
   private boolean[] T000E6_A161ConveHabilitada ;
   private String[] T000E6_A1915ConvBusGoogle ;
   private boolean[] T000E6_n1915ConvBusGoogle ;
   private String[] T000E6_A1916ConvBusWeb ;
   private boolean[] T000E6_n1916ConvBusWeb ;
   private String[] T000E6_A1917ConvBaseURL ;
   private boolean[] T000E6_n1917ConvBaseURL ;
   private String[] T000E6_A1918ConvScrapTipo ;
   private boolean[] T000E6_n1918ConvScrapTipo ;
   private String[] T000E6_A1919ConvScrapTDoc ;
   private boolean[] T000E6_n1919ConvScrapTDoc ;
   private short[] T000E6_A2131ConveEscFrecAct ;
   private boolean[] T000E6_A2428ConveEsquemaEs ;
   private short[] T000E6_A46PaiCod ;
   private String[] T000E6_A935ConveSinCod ;
   private boolean[] T000E6_n935ConveSinCod ;
   private short[] T000E12_A46PaiCod ;
   private String[] T000E12_A9ConveCodigo ;
   private short[] T000E13_A46PaiCod ;
   private String[] T000E13_A9ConveCodigo ;
   private String[] T000E5_A687ConveDescriSinAc ;
   private String[] T000E5_A9ConveCodigo ;
   private String[] T000E5_A160ConveDescri ;
   private boolean[] T000E5_A161ConveHabilitada ;
   private String[] T000E5_A1915ConvBusGoogle ;
   private boolean[] T000E5_n1915ConvBusGoogle ;
   private String[] T000E5_A1916ConvBusWeb ;
   private boolean[] T000E5_n1916ConvBusWeb ;
   private String[] T000E5_A1917ConvBaseURL ;
   private boolean[] T000E5_n1917ConvBaseURL ;
   private String[] T000E5_A1918ConvScrapTipo ;
   private boolean[] T000E5_n1918ConvScrapTipo ;
   private String[] T000E5_A1919ConvScrapTDoc ;
   private boolean[] T000E5_n1919ConvScrapTDoc ;
   private short[] T000E5_A2131ConveEscFrecAct ;
   private boolean[] T000E5_A2428ConveEsquemaEs ;
   private short[] T000E5_A46PaiCod ;
   private String[] T000E5_A935ConveSinCod ;
   private boolean[] T000E5_n935ConveSinCod ;
   private String[] T000E17_A936ConveSinDesc ;
   private int[] T000E18_A3CliCod ;
   private String[] T000E18_A26ConCodigo ;
   private int[] T000E19_A3CliCod ;
   private short[] T000E19_A1564CliPaiConve ;
   private String[] T000E19_A1565CliConvenio ;
   private int[] T000E20_A3CliCod ;
   private short[] T000E20_A1564CliPaiConve ;
   private String[] T000E20_A1565CliConvenio ;
   private int[] T000E21_A3CliCod ;
   private short[] T000E21_A1EmpCod ;
   private short[] T000E21_A1562EmpConvePai ;
   private String[] T000E21_A1561EmpConveCod ;
   private short[] T000E22_A46PaiCod ;
   private String[] T000E22_A1223FerId ;
   private short[] T000E23_A46PaiCod ;
   private String[] T000E23_A9ConveCodigo ;
   private byte[] T000E23_A1048ConveVacDesdeAnti ;
   private short[] T000E24_A46PaiCod ;
   private String[] T000E24_A9ConveCodigo ;
   private short[] T000E25_A46PaiCod ;
   private String[] T000E25_A9ConveCodigo ;
   private String[] T000E25_A2228propDesc ;
   private String[] T000E25_A2229propTipoDato ;
   private String[] T000E25_A2262ConvePropPredet ;
   private String[] T000E25_A2227propCod ;
   private String[] T000E4_A2228propDesc ;
   private String[] T000E4_A2229propTipoDato ;
   private String[] T000E26_A2228propDesc ;
   private String[] T000E26_A2229propTipoDato ;
   private short[] T000E27_A46PaiCod ;
   private String[] T000E27_A9ConveCodigo ;
   private String[] T000E27_A2227propCod ;
   private short[] T000E3_A46PaiCod ;
   private String[] T000E3_A9ConveCodigo ;
   private String[] T000E3_A2262ConvePropPredet ;
   private String[] T000E3_A2227propCod ;
   private short[] T000E2_A46PaiCod ;
   private String[] T000E2_A9ConveCodigo ;
   private String[] T000E2_A2262ConvePropPredet ;
   private String[] T000E2_A2227propCod ;
   private String[] T000E31_A2228propDesc ;
   private String[] T000E31_A2229propTipoDato ;
   private short[] T000E32_A46PaiCod ;
   private String[] T000E32_A9ConveCodigo ;
   private String[] T000E32_A2227propCod ;
   private short[] T000E33_A46PaiCod ;
   private String[] T000E33_A14SinCod ;
   private String[] T000E33_A331SinDescrip ;
   private String[] T000E34_A936ConveSinDesc ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV20propCod_Data ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV12TrnContext ;
   private web.wwpbaseobjects.SdtWWPTransactionContext_Attribute AV15TrnContextAtt ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV21DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons2 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons3[] ;
}

final  class convenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T000E2", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?  FOR UPDATE OF ConvenioPropiedadesAdicionales NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E3", "SELECT PaiCod, ConveCodigo, ConvePropPredet, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E4", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E5", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ?  FOR UPDATE OF Convenio NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E6", "SELECT ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E7", "SELECT PaiCod FROM Pais WHERE PaiCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E8", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E9", "SELECT TM1.ConveDescriSinAc, TM1.ConveCodigo, TM1.ConveDescri, TM1.ConveHabilitada, T2.SinDescrip AS ConveSinDesc, TM1.ConvBusGoogle, TM1.ConvBusWeb, TM1.ConvBaseURL, TM1.ConvScrapTipo, TM1.ConvScrapTDoc, TM1.ConveEscFrecAct, TM1.ConveEsquemaEs, TM1.PaiCod, TM1.ConveSinCod AS ConveSinCod FROM (Convenio TM1 LEFT JOIN Sindicato T2 ON T2.PaiCod = TM1.PaiCod AND T2.SinCod = TM1.ConveSinCod) WHERE TM1.PaiCod = ? and TM1.ConveCodigo = ( ?) ORDER BY TM1.PaiCod, TM1.ConveCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E10", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E11", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE PaiCod = ? AND ConveCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E12", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE ( PaiCod > ? or PaiCod = ? and ConveCodigo > ( ?)) ORDER BY PaiCod, ConveCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E13", "SELECT PaiCod, ConveCodigo FROM Convenio WHERE ( PaiCod < ? or PaiCod = ? and ConveCodigo < ( ?)) ORDER BY PaiCod DESC, ConveCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000E14", "SAVEPOINT gxupdate;INSERT INTO Convenio(ConveDescriSinAc, ConveCodigo, ConveDescri, ConveHabilitada, ConvBusGoogle, ConvBusWeb, ConvBaseURL, ConvScrapTipo, ConvScrapTDoc, ConveEscFrecAct, ConveEsquemaEs, PaiCod, ConveSinCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000E15", "SAVEPOINT gxupdate;UPDATE Convenio SET ConveDescriSinAc=?, ConveDescri=?, ConveHabilitada=?, ConvBusGoogle=?, ConvBusWeb=?, ConvBaseURL=?, ConvScrapTipo=?, ConvScrapTDoc=?, ConveEscFrecAct=?, ConveEsquemaEs=?, ConveSinCod=?  WHERE PaiCod = ? AND ConveCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000E16", "SAVEPOINT gxupdate;DELETE FROM Convenio  WHERE PaiCod = ? AND ConveCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000E17", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E18", "SELECT CliCod, ConCodigo FROM Concepto WHERE ConceptoPais = ? AND ConceptoConveCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E19", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E20", "SELECT CliCod, CliPaiConve, CliConvenio FROM ClienteConvenios WHERE CliPaiConve = ? AND CliConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E21", "SELECT CliCod, EmpCod, EmpConvePai, EmpConveCod FROM EmpresaConvenios WHERE EmpConvePai = ? AND EmpConveCod = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E22", "SELECT PaiCod, FerId FROM feriado WHERE PaiCod = ? AND FeriadoConvenio = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E23", "SELECT PaiCod, ConveCodigo, ConveVacDesdeAnti FROM ConveVacaciones WHERE PaiCod = ? AND ConveCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000E24", "SELECT PaiCod, ConveCodigo FROM Convenio ORDER BY PaiCod, ConveCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E25", "SELECT T1.PaiCod, T1.ConveCodigo, T2.propDesc, T2.propTipoDato, T1.ConvePropPredet, T1.propCod FROM (ConvenioPropiedadesAdicionales T1 INNER JOIN propiedades_adicionales T2 ON T2.propCod = T1.propCod) WHERE T1.PaiCod = ? and T1.ConveCodigo = ( ?) and T1.propCod = ( ?) ORDER BY T1.PaiCod, T1.ConveCodigo, T1.propCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E26", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E27", "SELECT PaiCod, ConveCodigo, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000E28", "SAVEPOINT gxupdate;INSERT INTO ConvenioPropiedadesAdicionales(PaiCod, ConveCodigo, ConvePropPredet, propCod) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000E29", "SAVEPOINT gxupdate;UPDATE ConvenioPropiedadesAdicionales SET ConvePropPredet=?  WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000E30", "SAVEPOINT gxupdate;DELETE FROM ConvenioPropiedadesAdicionales  WHERE PaiCod = ? AND ConveCodigo = ? AND propCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000E31", "SELECT propDesc, propTipoDato FROM propiedades_adicionales WHERE propCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E32", "SELECT PaiCod, ConveCodigo, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo, propCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E33", "SELECT PaiCod, SinCod, SinDescrip FROM Sindicato WHERE PaiCod = ? ORDER BY SinDescrip ",true, GX_NOMASK, false, this,0, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000E34", "SELECT SinDescrip AS ConveSinDesc FROM Sindicato WHERE PaiCod = ? AND SinCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((String[]) buf[6])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((String[]) buf[10])[0] = rslt.getString(8, 20);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((short[]) buf[14])[0] = rslt.getShort(10);
               ((boolean[]) buf[15])[0] = rslt.getBoolean(11);
               ((short[]) buf[16])[0] = rslt.getShort(12);
               ((String[]) buf[17])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(7);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getVarchar(8);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(10, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(11);
               ((boolean[]) buf[16])[0] = rslt.getBoolean(12);
               ((short[]) buf[17])[0] = rslt.getShort(13);
               ((String[]) buf[18])[0] = rslt.getString(14, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 18 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 23 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               return;
            case 24 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               return;
            case 25 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 29 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
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
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 31 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 32 :
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setString(2, (String)parms[1], 20);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[5], 100);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[7], 100);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(7, (String)parms[9], 1000);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[11], 20);
               }
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[13], 20);
               }
               stmt.setShort(10, ((Number) parms[14]).shortValue());
               stmt.setBoolean(11, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(12, ((Number) parms[16]).shortValue());
               if ( ((Boolean) parms[17]).booleanValue() )
               {
                  stmt.setNull( 13 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(13, (String)parms[18], 20);
               }
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setBoolean(3, ((Boolean) parms[2]).booleanValue());
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(4, (String)parms[4], 100);
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 100);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(6, (String)parms[8], 1000);
               }
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(7, (String)parms[10], 20);
               }
               if ( ((Boolean) parms[11]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(8, (String)parms[12], 20);
               }
               stmt.setShort(9, ((Number) parms[13]).shortValue());
               stmt.setBoolean(10, ((Boolean) parms[14]).booleanValue());
               if ( ((Boolean) parms[15]).booleanValue() )
               {
                  stmt.setNull( 11 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(11, (String)parms[16], 20);
               }
               stmt.setShort(12, ((Number) parms[17]).shortValue());
               stmt.setString(13, (String)parms[18], 20);
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 23 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 24 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 25 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 26 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 27 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
            case 28 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 29 :
               stmt.setString(1, (String)parms[0], 20);
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
               stmt.setString(2, (String)parms[1], 20);
               return;
            case 31 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 32 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               if ( ((Boolean) parms[1]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(2, (String)parms[2], 20);
               }
               return;
      }
   }

}

