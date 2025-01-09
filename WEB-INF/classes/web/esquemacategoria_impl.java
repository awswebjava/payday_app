package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class esquemacategoria_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICOD") == 0 )
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
         gx3asaclicod6P205( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
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
         gxload_16( A3CliCod, A1564CliPaiConve, A1565CliConvenio) ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel_valores") == 0 )
      {
         gxnrgridlevel_valores_newrow_invoke( ) ;
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
            AV8CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
            AV9CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CliConvenio", AV9CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
            AV10CatCodigo = httpContext.GetPar( "CatCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10CatCodigo", AV10CatCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10CatCodigo, ""))));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Esquema Categoria", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel_valores_newrow_invoke( )
   {
      nRC_GXsfl_51 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_51"))) ;
      nGXsfl_51_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_51_idx"))) ;
      sGXsfl_51_idx = httpContext.GetPar( "sGXsfl_51_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel_valores_newrow( ) ;
      /* End function gxnrGridlevel_valores_newrow_invoke */
   }

   public esquemacategoria_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public esquemacategoria_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esquemacategoria_impl.class ));
   }

   public esquemacategoria_impl( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbCatClase = new HTMLChoice();
      cmbCatTipoTarifa = new HTMLChoice();
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
      if ( cmbCatClase.getItemCount() > 0 )
      {
         A1838CatClase = (byte)(GXutil.lval( cmbCatClase.getValidValue(GXutil.trim( GXutil.str( A1838CatClase, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCatClase.setValue( GXutil.trim( GXutil.str( A1838CatClase, 1, 0)) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Values", cmbCatClase.ToJavascriptSource(), true);
      }
      if ( cmbCatTipoTarifa.getItemCount() > 0 )
      {
         A2416CatTipoTarifa = cmbCatTipoTarifa.getValidValue(A2416CatTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbCatTipoTarifa.setValue( GXutil.rtrim( A2416CatTipoTarifa) );
         httpContext.ajax_rsp_assign_prop("", false, cmbCatTipoTarifa.getInternalname(), "Values", cmbCatTipoTarifa.ToJavascriptSource(), true);
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatCodigo_Internalname, GXutil.rtrim( A8CatCodigo), GXutil.rtrim( localUtil.format( A8CatCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatCodigo_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EsquemaCategoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatDescrip_Internalname, httpContext.getMessage( "Descripción", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCatDescrip_Internalname, A123CatDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtCatDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_EsquemaCategoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCatClase.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCatClase.getInternalname(), httpContext.getMessage( "Frecuencia de pago", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCatClase, cmbCatClase.getInternalname(), GXutil.trim( GXutil.str( A1838CatClase, 1, 0)), 1, cmbCatClase.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "int", "", 1, cmbCatClase.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", "", true, (byte)(0), "HLP_EsquemaCategoria.htm");
      cmbCatClase.setValue( GXutil.trim( GXutil.str( A1838CatClase, 1, 0)) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Values", cmbCatClase.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+cmbCatTipoTarifa.getInternalname()+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbCatTipoTarifa.getInternalname(), httpContext.getMessage( "Tipo de tarifa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbCatTipoTarifa, cmbCatTipoTarifa.getInternalname(), GXutil.rtrim( A2416CatTipoTarifa), 1, cmbCatTipoTarifa.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "char", "", 1, cmbCatTipoTarifa.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", "", true, (byte)(0), "HLP_EsquemaCategoria.htm");
      cmbCatTipoTarifa.setValue( GXutil.rtrim( A2416CatTipoTarifa) );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatTipoTarifa.getInternalname(), "Values", cmbCatTipoTarifa.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatFrecAct_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatFrecAct_Internalname, httpContext.getMessage( "Frecuencia de actualización (meses)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatFrecAct_Internalname, GXutil.ltrim( localUtil.ntoc( A1914CatFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtCatFrecAct_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A1914CatFrecAct), "Z9") : localUtil.format( DecimalUtil.doubleToDec(A1914CatFrecAct), "Z9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatFrecAct_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatFrecAct_Enabled, 0, "text", "1", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaCategoria.htm");
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
      httpContext.writeText( "<td class='CellMarginTop'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableleaflevel_valores_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 SectionGrid GridNoBorderCell", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol51( ) ;
      nGXsfl_51_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount206 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_206 = (short)(1) ;
            scanStart6P206( ) ;
            while ( RcdFound206 != 0 )
            {
               init_level_properties206( ) ;
               getByPrimaryKey6P206( ) ;
               addRow6P206( ) ;
               scanNext6P206( ) ;
            }
            scanEnd6P206( ) ;
            nBlankRcdCount206 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal6P206( ) ;
         standaloneModal6P206( ) ;
         sMode206 = Gx_mode ;
         while ( nGXsfl_51_idx < nRC_GXsfl_51 )
         {
            bGXsfl_51_Refreshing = true ;
            readRow6P206( ) ;
            edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_51_Refreshing);
            if ( ( nRcdExists_206 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal6P206( ) ;
            }
            sendRow6P206( ) ;
            bGXsfl_51_Refreshing = false ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount206 = (short)(5) ;
         nRcdExists_206 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart6P206( ) ;
            while ( RcdFound206 != 0 )
            {
               sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_51206( ) ;
               init_level_properties206( ) ;
               standaloneNotModal6P206( ) ;
               getByPrimaryKey6P206( ) ;
               standaloneModal6P206( ) ;
               addRow6P206( ) ;
               scanNext6P206( ) ;
            }
            scanEnd6P206( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode206 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_51206( ) ;
         initAll6P206( ) ;
         init_level_properties206( ) ;
         nRcdExists_206 = (short)(0) ;
         nIsMod_206 = (short)(0) ;
         nRcdDeleted_206 = (short)(0) ;
         nBlankRcdCount206 = (short)(nBlankRcdUsr206+nBlankRcdCount206) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount206 > 0 )
         {
            standaloneNotModal6P206( ) ;
            standaloneModal6P206( ) ;
            addRow6P206( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCatVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount206 = (short)(nBlankRcdCount206-1) ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel_valoresContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel_valores", Gridlevel_valoresContainer, subGridlevel_valores_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData", Gridlevel_valoresContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel_valoresContainerData"+"V", Gridlevel_valoresContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel_valoresContainerData"+"V"+"\" value='"+Gridlevel_valoresContainer.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 58,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaCategoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 60,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaCategoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_EsquemaCategoria.htm");
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 66,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,66);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_EsquemaCategoria.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliPaiConve_Internalname, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1564CliPaiConve), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliPaiConve_Jsonclick, 0, "Attribute", "", "", "", "", edtCliPaiConve_Visible, edtCliPaiConve_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_EsquemaCategoria.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 68,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliConvenio_Internalname, GXutil.rtrim( A1565CliConvenio), GXutil.rtrim( localUtil.format( A1565CliConvenio, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,68);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliConvenio_Jsonclick, 0, "Attribute", "", "", "", "", edtCliConvenio_Visible, edtCliConvenio_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_EsquemaCategoria.htm");
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
      e116P2 ();
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
            Z8CatCodigo = httpContext.cgiGet( "Z8CatCodigo") ;
            Z123CatDescrip = httpContext.cgiGet( "Z123CatDescrip") ;
            Z676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            Z1838CatClase = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1838CatClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2416CatTipoTarifa = httpContext.cgiGet( "Z2416CatTipoTarifa") ;
            Z1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1914CatFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_51 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_51"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV8CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV9CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV10CatCodigo = httpContext.cgiGet( "vCATCODIGO") ;
            A676CatDescripSinAc = httpContext.cgiGet( "CATDESCRIPSINAC") ;
            AV16Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            A8CatCodigo = httpContext.cgiGet( edtCatCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            A123CatDescrip = httpContext.cgiGet( edtCatDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
            cmbCatClase.setName( cmbCatClase.getInternalname() );
            cmbCatClase.setValue( httpContext.cgiGet( cmbCatClase.getInternalname()) );
            A1838CatClase = (byte)(GXutil.lval( httpContext.cgiGet( cmbCatClase.getInternalname()))) ;
            httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
            cmbCatTipoTarifa.setName( cmbCatTipoTarifa.getInternalname() );
            cmbCatTipoTarifa.setValue( httpContext.cgiGet( cmbCatTipoTarifa.getInternalname()) );
            A2416CatTipoTarifa = httpContext.cgiGet( cmbCatTipoTarifa.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CATFRECACT");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCatFrecAct_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1914CatFrecAct = (byte)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
            }
            else
            {
               A1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( edtCatFrecAct_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
            }
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
            forbiddenHiddens.add("hshsalt", "hsh"+"EsquemaCategoria");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("esquemacategoria:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
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
                  sMode205 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode205 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound205 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_6P0( ) ;
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
                        e116P2 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e126P2 ();
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
         e126P2 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll6P205( ) ;
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
         disableAttributes6P205( ) ;
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

   public void confirm_6P0( )
   {
      beforeValidate6P205( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls6P205( ) ;
         }
         else
         {
            checkExtendedTable6P205( ) ;
            closeExtendedTableCursors6P205( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode205 = Gx_mode ;
         confirm_6P206( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode205 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_6P206( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow6P206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            getKey6P206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               if ( RcdFound206 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate6P206( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable6P206( ) ;
                     closeExtendedTableCursors6P206( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CATVIGENCIA_" + sGXsfl_51_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatVigencia_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( nRcdDeleted_206 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey6P206( ) ;
                     load6P206( ) ;
                     beforeValidate6P206( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls6P206( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate6P206( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable6P206( ) ;
                           closeExtendedTableCursors6P206( ) ;
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
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_51_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption6P0( )
   {
   }

   public void e116P2( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV11WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV11WWPContext = GXv_SdtWWPContext1[0] ;
      AV12IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaCategoria_Insert", GXv_boolean3) ;
         esquemacategoria_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaCategoria_Update", GXv_boolean3) ;
         esquemacategoria_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV12IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWEsquemaCategoria_Delete", GXv_boolean3) ;
         esquemacategoria_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV12IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV12IsAuthorized", AV12IsAuthorized);
      }
      if ( ! AV12IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV16Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV14TrnContext.fromxml(AV15WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtCliPaiConve_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Visible), 5, 0), true);
      edtCliConvenio_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Visible), 5, 0), true);
   }

   public void e126P2( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm6P205( int GX_JID )
   {
      if ( ( GX_JID == 15 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z123CatDescrip = T006P5_A123CatDescrip[0] ;
            Z676CatDescripSinAc = T006P5_A676CatDescripSinAc[0] ;
            Z1838CatClase = T006P5_A1838CatClase[0] ;
            Z2416CatTipoTarifa = T006P5_A2416CatTipoTarifa[0] ;
            Z1914CatFrecAct = T006P5_A1914CatFrecAct[0] ;
         }
         else
         {
            Z123CatDescrip = A123CatDescrip ;
            Z676CatDescripSinAc = A676CatDescripSinAc ;
            Z1838CatClase = A1838CatClase ;
            Z2416CatTipoTarifa = A2416CatTipoTarifa ;
            Z1914CatFrecAct = A1914CatFrecAct ;
         }
      }
      if ( GX_JID == -15 )
      {
         Z8CatCodigo = A8CatCodigo ;
         Z123CatDescrip = A123CatDescrip ;
         Z676CatDescripSinAc = A676CatDescripSinAc ;
         Z1838CatClase = A1838CatClase ;
         Z2416CatTipoTarifa = A2416CatTipoTarifa ;
         Z1914CatFrecAct = A1914CatFrecAct ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
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
            esquemacategoria_impl.this.GXt_int4 = GXv_int5[0] ;
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
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         A8CatCodigo = AV10CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtCatCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV10CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
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
         AV16Pgmname = "EsquemaCategoria" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
   }

   public void load6P205( )
   {
      /* Using cursor T006P7 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A123CatDescrip = T006P7_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T006P7_A676CatDescripSinAc[0] ;
         A1838CatClase = T006P7_A1838CatClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
         A2416CatTipoTarifa = T006P7_A2416CatTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
         A1914CatFrecAct = T006P7_A1914CatFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
         zm6P205( -15) ;
      }
      pr_default.close(5);
      onLoadActions6P205( ) ;
   }

   public void onLoadActions6P205( )
   {
      AV16Pgmname = "EsquemaCategoria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
   }

   public void checkExtendedTable6P205( )
   {
      nIsDirty_205 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV16Pgmname = "EsquemaCategoria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      /* Using cursor T006P6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      if ( ! ( ( A1838CatClase == 1 ) || ( A1838CatClase == 2 ) || ( A1838CatClase == 3 ) || ( A1838CatClase == 4 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Frecuencia de pago", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CATCLASE");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCatClase.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! ( ( GXutil.strcmp(A2416CatTipoTarifa, "H") == 0 ) || ( GXutil.strcmp(A2416CatTipoTarifa, "P") == 0 ) ) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_OutOfRange", ""), httpContext.getMessage( "Tipo de tarifa", ""), "", "", "", "", "", "", "", ""), "OutOfRange", 1, "CATTIPOTARIFA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbCatTipoTarifa.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors6P205( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_16( int A3CliCod ,
                          short A1564CliPaiConve ,
                          String A1565CliConvenio )
   {
      /* Using cursor T006P8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey6P205( )
   {
      /* Using cursor T006P9 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound205 = (short)(1) ;
      }
      else
      {
         RcdFound205 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T006P5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm6P205( 15) ;
         RcdFound205 = (short)(1) ;
         A8CatCodigo = T006P5_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A123CatDescrip = T006P5_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T006P5_A676CatDescripSinAc[0] ;
         A1838CatClase = T006P5_A1838CatClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
         A2416CatTipoTarifa = T006P5_A2416CatTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
         A1914CatFrecAct = T006P5_A1914CatFrecAct[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
         A3CliCod = T006P5_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006P5_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006P5_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6P205( ) ;
         if ( AnyError == 1 )
         {
            RcdFound205 = (short)(0) ;
            initializeNonKey6P205( ) ;
         }
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound205 = (short)(0) ;
         initializeNonKey6P205( ) ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey6P205( ) ;
      if ( RcdFound205 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T006P10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T006P10_A3CliCod[0] < A3CliCod ) || ( T006P10_A3CliCod[0] == A3CliCod ) && ( T006P10_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T006P10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P10_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T006P10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006P10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P10_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T006P10_A3CliCod[0] > A3CliCod ) || ( T006P10_A3CliCod[0] == A3CliCod ) && ( T006P10_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T006P10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P10_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T006P10_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006P10_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P10_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P10_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            A3CliCod = T006P10_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T006P10_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T006P10_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A8CatCodigo = T006P10_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T006P11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T006P11_A3CliCod[0] > A3CliCod ) || ( T006P11_A3CliCod[0] == A3CliCod ) && ( T006P11_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T006P11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P11_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T006P11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006P11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P11_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T006P11_A3CliCod[0] < A3CliCod ) || ( T006P11_A3CliCod[0] == A3CliCod ) && ( T006P11_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T006P11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P11_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T006P11_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T006P11_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T006P11_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T006P11_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            A3CliCod = T006P11_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1564CliPaiConve = T006P11_A1564CliPaiConve[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
            A1565CliConvenio = T006P11_A1565CliConvenio[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
            A8CatCodigo = T006P11_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey6P205( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert6P205( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound205 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = Z8CatCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update6P205( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert6P205( ) ;
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
                  GX_FocusControl = edtCatCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert6P205( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = Z8CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency6P205( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006P4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z123CatDescrip, T006P4_A123CatDescrip[0]) != 0 ) || ( GXutil.strcmp(Z676CatDescripSinAc, T006P4_A676CatDescripSinAc[0]) != 0 ) || ( Z1838CatClase != T006P4_A1838CatClase[0] ) || ( GXutil.strcmp(Z2416CatTipoTarifa, T006P4_A2416CatTipoTarifa[0]) != 0 ) || ( Z1914CatFrecAct != T006P4_A1914CatFrecAct[0] ) )
         {
            if ( GXutil.strcmp(Z123CatDescrip, T006P4_A123CatDescrip[0]) != 0 )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"CatDescrip");
               GXutil.writeLogRaw("Old: ",Z123CatDescrip);
               GXutil.writeLogRaw("Current: ",T006P4_A123CatDescrip[0]);
            }
            if ( GXutil.strcmp(Z676CatDescripSinAc, T006P4_A676CatDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"CatDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z676CatDescripSinAc);
               GXutil.writeLogRaw("Current: ",T006P4_A676CatDescripSinAc[0]);
            }
            if ( Z1838CatClase != T006P4_A1838CatClase[0] )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"CatClase");
               GXutil.writeLogRaw("Old: ",Z1838CatClase);
               GXutil.writeLogRaw("Current: ",T006P4_A1838CatClase[0]);
            }
            if ( GXutil.strcmp(Z2416CatTipoTarifa, T006P4_A2416CatTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"CatTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2416CatTipoTarifa);
               GXutil.writeLogRaw("Current: ",T006P4_A2416CatTipoTarifa[0]);
            }
            if ( Z1914CatFrecAct != T006P4_A1914CatFrecAct[0] )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"CatFrecAct");
               GXutil.writeLogRaw("Old: ",Z1914CatFrecAct);
               GXutil.writeLogRaw("Current: ",T006P4_A1914CatFrecAct[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoria1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6P205( )
   {
      beforeValidate6P205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6P205( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6P205( 0) ;
         checkOptimisticConcurrency6P205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6P205( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6P205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006P12 */
                  pr_default.execute(10, new Object[] {A8CatCodigo, A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
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
                        processLevel6P205( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption6P0( ) ;
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
            load6P205( ) ;
         }
         endLevel6P205( ) ;
      }
      closeExtendedTableCursors6P205( ) ;
   }

   public void update6P205( )
   {
      beforeValidate6P205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6P205( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6P205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6P205( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate6P205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006P13 */
                  pr_default.execute(11, new Object[] {A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate6P205( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel6P205( ) ;
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
         endLevel6P205( ) ;
      }
      closeExtendedTableCursors6P205( ) ;
   }

   public void deferredUpdate6P205( )
   {
   }

   public void delete( )
   {
      beforeValidate6P205( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6P205( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6P205( ) ;
         afterConfirm6P205( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6P205( ) ;
            if ( AnyError == 0 )
            {
               scanStart6P206( ) ;
               while ( RcdFound206 != 0 )
               {
                  getByPrimaryKey6P206( ) ;
                  delete6P206( ) ;
                  scanNext6P206( ) ;
               }
               scanEnd6P206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006P14 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
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
      sMode205 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6P205( ) ;
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6P205( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV16Pgmname = "EsquemaCategoria" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV16Pgmname", AV16Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T006P15 */
         pr_default.execute(13, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(13) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "CategoriaProvincias", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(13);
         /* Using cursor T006P16 */
         pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(14) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionCategoria", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(14);
      }
   }

   public void processNestedLevel6P206( )
   {
      nGXsfl_51_idx = 0 ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         readRow6P206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            standaloneNotModal6P206( ) ;
            getKey6P206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert6P206( ) ;
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( ( nRcdDeleted_206 != 0 ) && ( nRcdExists_206 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete6P206( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update6P206( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_51_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_51_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_51_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll6P206( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_206 = (short)(0) ;
      nIsMod_206 = (short)(0) ;
      nRcdDeleted_206 = (short)(0) ;
   }

   public void processLevel6P205( )
   {
      /* Save parent mode. */
      sMode205 = Gx_mode ;
      processNestedLevel6P206( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel6P205( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete6P205( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "esquemacategoria");
         if ( AnyError == 0 )
         {
            confirmValues6P0( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "esquemacategoria");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart6P205( )
   {
      /* Scan By routine */
      /* Using cursor T006P17 */
      pr_default.execute(15);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T006P17_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006P17_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006P17_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = T006P17_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6P205( )
   {
      /* Scan next routine */
      pr_default.readNext(15);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T006P17_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = T006P17_A1564CliPaiConve[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = T006P17_A1565CliConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = T006P17_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
   }

   public void scanEnd6P205( )
   {
      pr_default.close(15);
   }

   public void afterConfirm6P205( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6P205( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6P205( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6P205( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6P205( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6P205( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6P205( )
   {
      edtCatCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      edtCatDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatDescrip_Enabled), 5, 0), true);
      cmbCatClase.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatClase.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCatClase.getEnabled(), 5, 0), true);
      cmbCatTipoTarifa.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbCatTipoTarifa.getInternalname(), "Enabled", GXutil.ltrimstr( cmbCatTipoTarifa.getEnabled(), 5, 0), true);
      edtCatFrecAct_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatFrecAct_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatFrecAct_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtCliPaiConve_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliPaiConve_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliPaiConve_Enabled), 5, 0), true);
      edtCliConvenio_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliConvenio_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliConvenio_Enabled), 5, 0), true);
   }

   public void zm6P206( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z1892EscBasico = T006P3_A1892EscBasico[0] ;
         }
         else
         {
            Z1892EscBasico = A1892EscBasico ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         Z1892EscBasico = A1892EscBasico ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal6P206( )
   {
   }

   public void standaloneModal6P206( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
      else
      {
         edtCatVigencia_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      }
   }

   public void load6P206( )
   {
      /* Using cursor T006P18 */
      pr_default.execute(16, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A1892EscBasico = T006P18_A1892EscBasico[0] ;
         zm6P206( -17) ;
      }
      pr_default.close(16);
      onLoadActions6P206( ) ;
   }

   public void onLoadActions6P206( )
   {
   }

   public void checkExtendedTable6P206( )
   {
      nIsDirty_206 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal6P206( ) ;
   }

   public void closeExtendedTableCursors6P206( )
   {
   }

   public void enableDisable6P206( )
   {
   }

   public void getKey6P206( )
   {
      /* Using cursor T006P19 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound206 = (short)(1) ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
      }
      pr_default.close(17);
   }

   public void getByPrimaryKey6P206( )
   {
      /* Using cursor T006P3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm6P206( 17) ;
         RcdFound206 = (short)(1) ;
         initializeNonKey6P206( ) ;
         A907CatVigencia = T006P3_A907CatVigencia[0] ;
         A1892EscBasico = T006P3_A1892EscBasico[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load6P206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound206 = (short)(0) ;
         initializeNonKey6P206( ) ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal6P206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes6P206( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency6P206( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T006P2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z1892EscBasico, T006P2_A1892EscBasico[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z1892EscBasico, T006P2_A1892EscBasico[0]) != 0 )
            {
               GXutil.writeLogln("esquemacategoria:[seudo value changed for attri]"+"EscBasico");
               GXutil.writeLogRaw("Old: ",Z1892EscBasico);
               GXutil.writeLogRaw("Current: ",T006P2_A1892EscBasico[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoriavalores1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert6P206( )
   {
      beforeValidate6P206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6P206( ) ;
      }
      if ( AnyError == 0 )
      {
         zm6P206( 0) ;
         checkOptimisticConcurrency6P206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm6P206( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert6P206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T006P20 */
                  pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, A907CatVigencia, A1892EscBasico, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(18) == 1) )
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
            load6P206( ) ;
         }
         endLevel6P206( ) ;
      }
      closeExtendedTableCursors6P206( ) ;
   }

   public void update6P206( )
   {
      beforeValidate6P206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable6P206( ) ;
      }
      if ( ( nIsMod_206 != 0 ) || ( nIsDirty_206 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency6P206( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm6P206( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate6P206( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T006P21 */
                     pr_default.execute(19, new Object[] {A1892EscBasico, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                     if ( (pr_default.getStatus(19) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate6P206( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey6P206( ) ;
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
            endLevel6P206( ) ;
         }
      }
      closeExtendedTableCursors6P206( ) ;
   }

   public void deferredUpdate6P206( )
   {
   }

   public void delete6P206( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate6P206( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency6P206( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls6P206( ) ;
         afterConfirm6P206( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete6P206( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T006P22 */
               pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
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
      sMode206 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel6P206( ) ;
      Gx_mode = sMode206 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls6P206( )
   {
      standaloneModal6P206( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel6P206( )
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

   public void scanStart6P206( )
   {
      /* Scan By routine */
      /* Using cursor T006P23 */
      pr_default.execute(21, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T006P23_A907CatVigencia[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext6P206( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T006P23_A907CatVigencia[0] ;
      }
   }

   public void scanEnd6P206( )
   {
      pr_default.close(21);
   }

   public void afterConfirm6P206( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert6P206( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate6P206( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete6P206( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete6P206( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate6P206( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes6P206( )
   {
      edtCatVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_51_Refreshing);
      edtEscBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void send_integrity_lvl_hashes6P206( )
   {
   }

   public void send_integrity_lvl_hashes6P205( )
   {
   }

   public void subsflControlProps_51206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_51_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_51_idx ;
   }

   public void subsflControlProps_fel_51206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_51_fel_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_51_fel_idx ;
   }

   public void addRow6P206( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51206( ) ;
      sendRow6P206( ) ;
   }

   public void sendRow6P206( )
   {
      Gridlevel_valoresRow = GXWebRow.GetNew(context) ;
      if ( subGridlevel_valores_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(0) ;
         subGridlevel_valores_Backcolor = subGridlevel_valores_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel_valores_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
         {
            subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
         }
         subGridlevel_valores_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel_valores_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel_valores_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_51_idx) % (2))) == 0 )
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel_valores_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel_valores_Class, "") != 0 )
            {
               subGridlevel_valores_Linesclass = subGridlevel_valores_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 52,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatVigencia_Internalname,localUtil.format(A907CatVigencia, "99/99/9999"),localUtil.format( A907CatVigencia, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,52);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatVigencia_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatVigencia_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_51_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 53,'',false,'" + sGXsfl_51_idx + "',51)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel_valoresRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtEscBasico_Enabled!=0) ? localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,53);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtEscBasico_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(51),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel_valoresRow);
      send_integrity_lvl_hashes6P206( ) ;
      GXCCtl = "Z907CatVigencia_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z907CatVigencia, 0, "/"));
      GXCCtl = "Z1892EscBasico_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_206_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_206_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9CliConvenio));
      GXCCtl = "vCATCODIGO_" + sGXsfl_51_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV10CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVIGENCIA_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ESCBASICO_"+sGXsfl_51_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel_valoresContainer.AddRow(Gridlevel_valoresRow);
   }

   public void readRow6P206( )
   {
      nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51206( ) ;
      edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_51_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtCatVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "CATVIGENCIA_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         wbErr = true ;
         A907CatVigencia = GXutil.nullDate() ;
      }
      else
      {
         A907CatVigencia = localUtil.ctod( httpContext.cgiGet( edtCatVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ESCBASICO_" + sGXsfl_51_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscBasico_Internalname ;
         wbErr = true ;
         A1892EscBasico = DecimalUtil.ZERO ;
      }
      else
      {
         A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
      }
      GXCCtl = "Z907CatVigencia_" + sGXsfl_51_idx ;
      Z907CatVigencia = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z1892EscBasico_" + sGXsfl_51_idx ;
      Z1892EscBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_51_idx ;
      nRcdDeleted_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_206_" + sGXsfl_51_idx ;
      nRcdExists_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_206_" + sGXsfl_51_idx ;
      nIsMod_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtCatVigencia_Enabled = edtCatVigencia_Enabled ;
   }

   public void confirmValues6P0( )
   {
      nGXsfl_51_idx = 0 ;
      sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_51206( ) ;
      while ( nGXsfl_51_idx < nRC_GXsfl_51 )
      {
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51206( ) ;
         httpContext.changePostValue( "Z907CatVigencia_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z907CatVigencia_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_51_idx) ;
         httpContext.changePostValue( "Z1892EscBasico_"+sGXsfl_51_idx, httpContext.cgiGet( "ZT_"+"Z1892EscBasico_"+sGXsfl_51_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_51_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.esquemacategoria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"EsquemaCategoria");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("esquemacategoria:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z8CatCodigo", GXutil.rtrim( Z8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z123CatDescrip", Z123CatDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z676CatDescripSinAc", Z676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1838CatClase", GXutil.ltrim( localUtil.ntoc( Z1838CatClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2416CatTipoTarifa", GXutil.rtrim( Z2416CatTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1914CatFrecAct", GXutil.ltrim( localUtil.ntoc( Z1914CatFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_51", GXutil.ltrim( localUtil.ntoc( nGXsfl_51_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV8CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV8CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV9CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATCODIGO", GXutil.rtrim( AV10CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV10CatCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CATDESCRIPSINAC", A676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV16Pgmname));
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
      return formatLink("web.esquemacategoria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV8CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV9CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV10CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "EsquemaCategoria" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Esquema Categoria", "") ;
   }

   public void initializeNonKey6P205( )
   {
      A123CatDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      A676CatDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A676CatDescripSinAc", A676CatDescripSinAc);
      A1838CatClase = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
      A2416CatTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
      A1914CatFrecAct = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z1838CatClase = (byte)(0) ;
      Z2416CatTipoTarifa = "" ;
      Z1914CatFrecAct = (byte)(0) ;
   }

   public void initAll6P205( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A8CatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      initializeNonKey6P205( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey6P206( )
   {
      A1892EscBasico = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
   }

   public void initAll6P206( )
   {
      A907CatVigencia = GXutil.nullDate() ;
      initializeNonKey6P206( ) ;
   }

   public void standaloneModalInsert6P206( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20251718313256", true, true);
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
      httpContext.AddJavascriptSource("esquemacategoria.js", "?20251718313256", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties206( )
   {
      edtCatVigencia_Enabled = defedtCatVigencia_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_51_Refreshing);
   }

   public void startgridcontrol51( )
   {
      Gridlevel_valoresContainer.AddObjectProperty("GridName", "Gridlevel_valores");
      Gridlevel_valoresContainer.AddObjectProperty("Header", subGridlevel_valores_Header);
      Gridlevel_valoresContainer.AddObjectProperty("Class", "WorkWith");
      Gridlevel_valoresContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("CmpContext", "");
      Gridlevel_valoresContainer.AddObjectProperty("InMasterPage", "false");
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", localUtil.format(A907CatVigencia, "99/99/9999"));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel_valoresColumn.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), ".", "")));
      Gridlevel_valoresColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddColumnProperties(Gridlevel_valoresColumn);
      Gridlevel_valoresContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel_valoresContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel_valores_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtCatCodigo_Internalname = "CATCODIGO" ;
      edtCatDescrip_Internalname = "CATDESCRIP" ;
      cmbCatClase.setInternalname( "CATCLASE" );
      cmbCatTipoTarifa.setInternalname( "CATTIPOTARIFA" );
      edtCatFrecAct_Internalname = "CATFRECACT" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      edtCatVigencia_Internalname = "CATVIGENCIA" ;
      edtEscBasico_Internalname = "ESCBASICO" ;
      divTableleaflevel_valores_Internalname = "TABLELEAFLEVEL_VALORES" ;
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
      subGridlevel_valores_Internalname = "GRIDLEVEL_VALORES" ;
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
      subGridlevel_valores_Allowcollapsing = (byte)(0) ;
      subGridlevel_valores_Allowselection = (byte)(0) ;
      subGridlevel_valores_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Esquema Categoria", "") );
      edtEscBasico_Jsonclick = "" ;
      edtCatVigencia_Jsonclick = "" ;
      subGridlevel_valores_Class = "WorkWith" ;
      subGridlevel_valores_Backcolorstyle = (byte)(0) ;
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
      edtEscBasico_Enabled = 1 ;
      edtCatVigencia_Enabled = 1 ;
      edtCatFrecAct_Jsonclick = "" ;
      edtCatFrecAct_Enabled = 1 ;
      cmbCatTipoTarifa.setJsonclick( "" );
      cmbCatTipoTarifa.setEnabled( 1 );
      cmbCatClase.setJsonclick( "" );
      cmbCatClase.setEnabled( 1 );
      edtCatDescrip_Enabled = 1 ;
      edtCatCodigo_Jsonclick = "" ;
      edtCatCodigo_Enabled = 1 ;
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

   public void gx3asaclicod6P205( int AV7CliCod )
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
            esquemacategoria_impl.this.GXt_int4 = GXv_int5[0] ;
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

   public void gxnrgridlevel_valores_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_51206( ) ;
      while ( nGXsfl_51_idx <= nRC_GXsfl_51 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal6P206( ) ;
         standaloneModal6P206( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow6P206( ) ;
         nGXsfl_51_idx = (int)(nGXsfl_51_idx+1) ;
         sGXsfl_51_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_51_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_51206( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel_valoresContainer)) ;
      /* End function gxnrGridlevel_valores_newrow */
   }

   public void init_web_controls( )
   {
      cmbCatClase.setName( "CATCLASE" );
      cmbCatClase.setWebtags( "" );
      cmbCatClase.addItem("1", httpContext.getMessage( "Mensual", ""), (short)(0));
      cmbCatClase.addItem("2", httpContext.getMessage( "Quincenal", ""), (short)(0));
      cmbCatClase.addItem("3", httpContext.getMessage( "Semanal", ""), (short)(0));
      cmbCatClase.addItem("4", httpContext.getMessage( "Diaria", ""), (short)(0));
      if ( cmbCatClase.getItemCount() > 0 )
      {
         A1838CatClase = (byte)(GXutil.lval( cmbCatClase.getValidValue(GXutil.trim( GXutil.str( A1838CatClase, 1, 0))))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
      }
      cmbCatTipoTarifa.setName( "CATTIPOTARIFA" );
      cmbCatTipoTarifa.setWebtags( "" );
      cmbCatTipoTarifa.addItem("H", httpContext.getMessage( "Por hora trabajada", ""), (short)(0));
      cmbCatTipoTarifa.addItem("P", httpContext.getMessage( "Por periodo trabajado", ""), (short)(0));
      if ( cmbCatTipoTarifa.getItemCount() > 0 )
      {
         A2416CatTipoTarifa = cmbCatTipoTarifa.getValidValue(A2416CatTipoTarifa) ;
         httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
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
      /* Using cursor T006P24 */
      pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(22) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(22);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV8CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV9CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV10CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'A676CatDescripSinAc',fld:'CATDESCRIPSINAC',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e126P2',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CATCLASE","{handler:'valid_Catclase',iparms:[]");
      setEventMetadata("VALID_CATCLASE",",oparms:[]}");
      setEventMetadata("VALID_CATTIPOTARIFA","{handler:'valid_Cattipotarifa',iparms:[]");
      setEventMetadata("VALID_CATTIPOTARIFA",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CLIPAICONVE","{handler:'valid_Clipaiconve',iparms:[]");
      setEventMetadata("VALID_CLIPAICONVE",",oparms:[]}");
      setEventMetadata("VALID_CLICONVENIO","{handler:'valid_Cliconvenio',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1564CliPaiConve',fld:'CLIPAICONVE',pic:'ZZZ9'},{av:'A1565CliConvenio',fld:'CLICONVENIO',pic:''}]");
      setEventMetadata("VALID_CLICONVENIO",",oparms:[]}");
      setEventMetadata("VALID_CATVIGENCIA","{handler:'valid_Catvigencia',iparms:[]");
      setEventMetadata("VALID_CATVIGENCIA",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Escbasico',iparms:[]");
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
      pr_default.close(22);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV9CliConvenio = "" ;
      wcpOAV10CatCodigo = "" ;
      Z1565CliConvenio = "" ;
      Z8CatCodigo = "" ;
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z2416CatTipoTarifa = "" ;
      Z907CatVigencia = GXutil.nullDate() ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A1565CliConvenio = "" ;
      Gx_mode = "" ;
      AV9CliConvenio = "" ;
      AV10CatCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A2416CatTipoTarifa = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A8CatCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A123CatDescrip = "" ;
      Gridlevel_valoresContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode206 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      A676CatDescripSinAc = "" ;
      AV16Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode205 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      AV11WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV14TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV15WebSession = httpContext.getWebSession();
      T006P7_A8CatCodigo = new String[] {""} ;
      T006P7_A123CatDescrip = new String[] {""} ;
      T006P7_A676CatDescripSinAc = new String[] {""} ;
      T006P7_A1838CatClase = new byte[1] ;
      T006P7_A2416CatTipoTarifa = new String[] {""} ;
      T006P7_A1914CatFrecAct = new byte[1] ;
      T006P7_A3CliCod = new int[1] ;
      T006P7_A1564CliPaiConve = new short[1] ;
      T006P7_A1565CliConvenio = new String[] {""} ;
      T006P6_A3CliCod = new int[1] ;
      T006P8_A3CliCod = new int[1] ;
      T006P9_A3CliCod = new int[1] ;
      T006P9_A1564CliPaiConve = new short[1] ;
      T006P9_A1565CliConvenio = new String[] {""} ;
      T006P9_A8CatCodigo = new String[] {""} ;
      T006P5_A8CatCodigo = new String[] {""} ;
      T006P5_A123CatDescrip = new String[] {""} ;
      T006P5_A676CatDescripSinAc = new String[] {""} ;
      T006P5_A1838CatClase = new byte[1] ;
      T006P5_A2416CatTipoTarifa = new String[] {""} ;
      T006P5_A1914CatFrecAct = new byte[1] ;
      T006P5_A3CliCod = new int[1] ;
      T006P5_A1564CliPaiConve = new short[1] ;
      T006P5_A1565CliConvenio = new String[] {""} ;
      T006P10_A3CliCod = new int[1] ;
      T006P10_A1564CliPaiConve = new short[1] ;
      T006P10_A1565CliConvenio = new String[] {""} ;
      T006P10_A8CatCodigo = new String[] {""} ;
      T006P11_A3CliCod = new int[1] ;
      T006P11_A1564CliPaiConve = new short[1] ;
      T006P11_A1565CliConvenio = new String[] {""} ;
      T006P11_A8CatCodigo = new String[] {""} ;
      T006P4_A8CatCodigo = new String[] {""} ;
      T006P4_A123CatDescrip = new String[] {""} ;
      T006P4_A676CatDescripSinAc = new String[] {""} ;
      T006P4_A1838CatClase = new byte[1] ;
      T006P4_A2416CatTipoTarifa = new String[] {""} ;
      T006P4_A1914CatFrecAct = new byte[1] ;
      T006P4_A3CliCod = new int[1] ;
      T006P4_A1564CliPaiConve = new short[1] ;
      T006P4_A1565CliConvenio = new String[] {""} ;
      T006P15_A3CliCod = new int[1] ;
      T006P15_A1564CliPaiConve = new short[1] ;
      T006P15_A1565CliConvenio = new String[] {""} ;
      T006P15_A8CatCodigo = new String[] {""} ;
      T006P15_A2200CatPaiCod = new short[1] ;
      T006P15_A2201CatProvCod = new short[1] ;
      T006P16_A3CliCod = new int[1] ;
      T006P16_A1EmpCod = new short[1] ;
      T006P16_A31LiqNro = new int[1] ;
      T006P16_A2142LiqPaiConve = new short[1] ;
      T006P16_A2143LiqConvenio = new String[] {""} ;
      T006P16_A2144LiqCatCodigo = new String[] {""} ;
      T006P17_A3CliCod = new int[1] ;
      T006P17_A1564CliPaiConve = new short[1] ;
      T006P17_A1565CliConvenio = new String[] {""} ;
      T006P17_A8CatCodigo = new String[] {""} ;
      T006P18_A3CliCod = new int[1] ;
      T006P18_A1565CliConvenio = new String[] {""} ;
      T006P18_A8CatCodigo = new String[] {""} ;
      T006P18_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T006P18_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006P18_A1564CliPaiConve = new short[1] ;
      T006P19_A3CliCod = new int[1] ;
      T006P19_A1564CliPaiConve = new short[1] ;
      T006P19_A1565CliConvenio = new String[] {""} ;
      T006P19_A8CatCodigo = new String[] {""} ;
      T006P19_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T006P3_A3CliCod = new int[1] ;
      T006P3_A1565CliConvenio = new String[] {""} ;
      T006P3_A8CatCodigo = new String[] {""} ;
      T006P3_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T006P3_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006P3_A1564CliPaiConve = new short[1] ;
      T006P2_A3CliCod = new int[1] ;
      T006P2_A1565CliConvenio = new String[] {""} ;
      T006P2_A8CatCodigo = new String[] {""} ;
      T006P2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T006P2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T006P2_A1564CliPaiConve = new short[1] ;
      T006P23_A3CliCod = new int[1] ;
      T006P23_A1564CliPaiConve = new short[1] ;
      T006P23_A1565CliConvenio = new String[] {""} ;
      T006P23_A8CatCodigo = new String[] {""} ;
      T006P23_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      Gridlevel_valoresRow = new com.genexus.webpanels.GXWebRow();
      subGridlevel_valores_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel_valoresColumn = new com.genexus.webpanels.GXWebColumn();
      GXv_int5 = new int[1] ;
      T006P24_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.esquemacategoria__default(),
         new Object[] {
             new Object[] {
            T006P2_A3CliCod, T006P2_A1565CliConvenio, T006P2_A8CatCodigo, T006P2_A907CatVigencia, T006P2_A1892EscBasico, T006P2_A1564CliPaiConve
            }
            , new Object[] {
            T006P3_A3CliCod, T006P3_A1565CliConvenio, T006P3_A8CatCodigo, T006P3_A907CatVigencia, T006P3_A1892EscBasico, T006P3_A1564CliPaiConve
            }
            , new Object[] {
            T006P4_A8CatCodigo, T006P4_A123CatDescrip, T006P4_A676CatDescripSinAc, T006P4_A1838CatClase, T006P4_A2416CatTipoTarifa, T006P4_A1914CatFrecAct, T006P4_A3CliCod, T006P4_A1564CliPaiConve, T006P4_A1565CliConvenio
            }
            , new Object[] {
            T006P5_A8CatCodigo, T006P5_A123CatDescrip, T006P5_A676CatDescripSinAc, T006P5_A1838CatClase, T006P5_A2416CatTipoTarifa, T006P5_A1914CatFrecAct, T006P5_A3CliCod, T006P5_A1564CliPaiConve, T006P5_A1565CliConvenio
            }
            , new Object[] {
            T006P6_A3CliCod
            }
            , new Object[] {
            T006P7_A8CatCodigo, T006P7_A123CatDescrip, T006P7_A676CatDescripSinAc, T006P7_A1838CatClase, T006P7_A2416CatTipoTarifa, T006P7_A1914CatFrecAct, T006P7_A3CliCod, T006P7_A1564CliPaiConve, T006P7_A1565CliConvenio
            }
            , new Object[] {
            T006P8_A3CliCod
            }
            , new Object[] {
            T006P9_A3CliCod, T006P9_A1564CliPaiConve, T006P9_A1565CliConvenio, T006P9_A8CatCodigo
            }
            , new Object[] {
            T006P10_A3CliCod, T006P10_A1564CliPaiConve, T006P10_A1565CliConvenio, T006P10_A8CatCodigo
            }
            , new Object[] {
            T006P11_A3CliCod, T006P11_A1564CliPaiConve, T006P11_A1565CliConvenio, T006P11_A8CatCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006P15_A3CliCod, T006P15_A1564CliPaiConve, T006P15_A1565CliConvenio, T006P15_A8CatCodigo, T006P15_A2200CatPaiCod, T006P15_A2201CatProvCod
            }
            , new Object[] {
            T006P16_A3CliCod, T006P16_A1EmpCod, T006P16_A31LiqNro, T006P16_A2142LiqPaiConve, T006P16_A2143LiqConvenio, T006P16_A2144LiqCatCodigo
            }
            , new Object[] {
            T006P17_A3CliCod, T006P17_A1564CliPaiConve, T006P17_A1565CliConvenio, T006P17_A8CatCodigo
            }
            , new Object[] {
            T006P18_A3CliCod, T006P18_A1565CliConvenio, T006P18_A8CatCodigo, T006P18_A907CatVigencia, T006P18_A1892EscBasico, T006P18_A1564CliPaiConve
            }
            , new Object[] {
            T006P19_A3CliCod, T006P19_A1564CliPaiConve, T006P19_A1565CliConvenio, T006P19_A8CatCodigo, T006P19_A907CatVigencia
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T006P23_A3CliCod, T006P23_A1564CliPaiConve, T006P23_A1565CliConvenio, T006P23_A8CatCodigo, T006P23_A907CatVigencia
            }
            , new Object[] {
            T006P24_A3CliCod
            }
         }
      );
      AV16Pgmname = "EsquemaCategoria" ;
   }

   private byte Z1838CatClase ;
   private byte Z1914CatFrecAct ;
   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private byte Gx_BScreen ;
   private byte subGridlevel_valores_Backcolorstyle ;
   private byte subGridlevel_valores_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel_valores_Allowselection ;
   private byte subGridlevel_valores_Allowhovering ;
   private byte subGridlevel_valores_Allowcollapsing ;
   private byte subGridlevel_valores_Collapsed ;
   private short wcpOAV8CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short nRcdDeleted_206 ;
   private short nRcdExists_206 ;
   private short nIsMod_206 ;
   private short A1564CliPaiConve ;
   private short AV8CliPaiConve ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount206 ;
   private short RcdFound206 ;
   private short nBlankRcdUsr206 ;
   private short RcdFound205 ;
   private short nIsDirty_205 ;
   private short nIsDirty_206 ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int nRC_GXsfl_51 ;
   private int nGXsfl_51_idx=1 ;
   private int AV7CliCod ;
   private int A3CliCod ;
   private int trnEnded ;
   private int edtCatCodigo_Enabled ;
   private int edtCatDescrip_Enabled ;
   private int edtCatFrecAct_Enabled ;
   private int edtCatVigencia_Enabled ;
   private int edtEscBasico_Enabled ;
   private int fRowAdded ;
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
   private int subGridlevel_valores_Backcolor ;
   private int subGridlevel_valores_Allbackcolor ;
   private int defedtCatVigencia_Enabled ;
   private int idxLst ;
   private int subGridlevel_valores_Selectedindex ;
   private int subGridlevel_valores_Selectioncolor ;
   private int subGridlevel_valores_Hoveringcolor ;
   private int GXt_int4 ;
   private int GXv_int5[] ;
   private long GRIDLEVEL_VALORES_nFirstRecordOnPage ;
   private java.math.BigDecimal Z1892EscBasico ;
   private java.math.BigDecimal A1892EscBasico ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV9CliConvenio ;
   private String wcpOAV10CatCodigo ;
   private String Z1565CliConvenio ;
   private String Z8CatCodigo ;
   private String Z2416CatTipoTarifa ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A1565CliConvenio ;
   private String Gx_mode ;
   private String AV9CliConvenio ;
   private String AV10CatCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCatCodigo_Internalname ;
   private String sGXsfl_51_idx="0001" ;
   private String A2416CatTipoTarifa ;
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
   private String A8CatCodigo ;
   private String edtCatCodigo_Jsonclick ;
   private String edtCatDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtCatFrecAct_Internalname ;
   private String edtCatFrecAct_Jsonclick ;
   private String divTableleaflevel_valores_Internalname ;
   private String sMode206 ;
   private String edtCatVigencia_Internalname ;
   private String edtEscBasico_Internalname ;
   private String subGridlevel_valores_Internalname ;
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
   private String AV16Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode205 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_51_fel_idx="0001" ;
   private String subGridlevel_valores_Class ;
   private String subGridlevel_valores_Linesclass ;
   private String ROClassString ;
   private String edtCatVigencia_Jsonclick ;
   private String edtEscBasico_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel_valores_Header ;
   private java.util.Date Z907CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_51_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV12IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private String Z123CatDescrip ;
   private String Z676CatDescripSinAc ;
   private String A123CatDescrip ;
   private String A676CatDescripSinAc ;
   private com.genexus.webpanels.GXWebGrid Gridlevel_valoresContainer ;
   private com.genexus.webpanels.GXWebRow Gridlevel_valoresRow ;
   private com.genexus.webpanels.GXWebColumn Gridlevel_valoresColumn ;
   private com.genexus.webpanels.WebSession AV15WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbCatClase ;
   private HTMLChoice cmbCatTipoTarifa ;
   private IDataStoreProvider pr_default ;
   private String[] T006P7_A8CatCodigo ;
   private String[] T006P7_A123CatDescrip ;
   private String[] T006P7_A676CatDescripSinAc ;
   private byte[] T006P7_A1838CatClase ;
   private String[] T006P7_A2416CatTipoTarifa ;
   private byte[] T006P7_A1914CatFrecAct ;
   private int[] T006P7_A3CliCod ;
   private short[] T006P7_A1564CliPaiConve ;
   private String[] T006P7_A1565CliConvenio ;
   private int[] T006P6_A3CliCod ;
   private int[] T006P8_A3CliCod ;
   private int[] T006P9_A3CliCod ;
   private short[] T006P9_A1564CliPaiConve ;
   private String[] T006P9_A1565CliConvenio ;
   private String[] T006P9_A8CatCodigo ;
   private String[] T006P5_A8CatCodigo ;
   private String[] T006P5_A123CatDescrip ;
   private String[] T006P5_A676CatDescripSinAc ;
   private byte[] T006P5_A1838CatClase ;
   private String[] T006P5_A2416CatTipoTarifa ;
   private byte[] T006P5_A1914CatFrecAct ;
   private int[] T006P5_A3CliCod ;
   private short[] T006P5_A1564CliPaiConve ;
   private String[] T006P5_A1565CliConvenio ;
   private int[] T006P10_A3CliCod ;
   private short[] T006P10_A1564CliPaiConve ;
   private String[] T006P10_A1565CliConvenio ;
   private String[] T006P10_A8CatCodigo ;
   private int[] T006P11_A3CliCod ;
   private short[] T006P11_A1564CliPaiConve ;
   private String[] T006P11_A1565CliConvenio ;
   private String[] T006P11_A8CatCodigo ;
   private String[] T006P4_A8CatCodigo ;
   private String[] T006P4_A123CatDescrip ;
   private String[] T006P4_A676CatDescripSinAc ;
   private byte[] T006P4_A1838CatClase ;
   private String[] T006P4_A2416CatTipoTarifa ;
   private byte[] T006P4_A1914CatFrecAct ;
   private int[] T006P4_A3CliCod ;
   private short[] T006P4_A1564CliPaiConve ;
   private String[] T006P4_A1565CliConvenio ;
   private int[] T006P15_A3CliCod ;
   private short[] T006P15_A1564CliPaiConve ;
   private String[] T006P15_A1565CliConvenio ;
   private String[] T006P15_A8CatCodigo ;
   private short[] T006P15_A2200CatPaiCod ;
   private short[] T006P15_A2201CatProvCod ;
   private int[] T006P16_A3CliCod ;
   private short[] T006P16_A1EmpCod ;
   private int[] T006P16_A31LiqNro ;
   private short[] T006P16_A2142LiqPaiConve ;
   private String[] T006P16_A2143LiqConvenio ;
   private String[] T006P16_A2144LiqCatCodigo ;
   private int[] T006P17_A3CliCod ;
   private short[] T006P17_A1564CliPaiConve ;
   private String[] T006P17_A1565CliConvenio ;
   private String[] T006P17_A8CatCodigo ;
   private int[] T006P18_A3CliCod ;
   private String[] T006P18_A1565CliConvenio ;
   private String[] T006P18_A8CatCodigo ;
   private java.util.Date[] T006P18_A907CatVigencia ;
   private java.math.BigDecimal[] T006P18_A1892EscBasico ;
   private short[] T006P18_A1564CliPaiConve ;
   private int[] T006P19_A3CliCod ;
   private short[] T006P19_A1564CliPaiConve ;
   private String[] T006P19_A1565CliConvenio ;
   private String[] T006P19_A8CatCodigo ;
   private java.util.Date[] T006P19_A907CatVigencia ;
   private int[] T006P3_A3CliCod ;
   private String[] T006P3_A1565CliConvenio ;
   private String[] T006P3_A8CatCodigo ;
   private java.util.Date[] T006P3_A907CatVigencia ;
   private java.math.BigDecimal[] T006P3_A1892EscBasico ;
   private short[] T006P3_A1564CliPaiConve ;
   private int[] T006P2_A3CliCod ;
   private String[] T006P2_A1565CliConvenio ;
   private String[] T006P2_A8CatCodigo ;
   private java.util.Date[] T006P2_A907CatVigencia ;
   private java.math.BigDecimal[] T006P2_A1892EscBasico ;
   private short[] T006P2_A1564CliPaiConve ;
   private int[] T006P23_A3CliCod ;
   private short[] T006P23_A1564CliPaiConve ;
   private String[] T006P23_A1565CliConvenio ;
   private String[] T006P23_A8CatCodigo ;
   private java.util.Date[] T006P23_A907CatVigencia ;
   private int[] T006P24_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private web.wwpbaseobjects.SdtWWPContext AV11WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV14TrnContext ;
}

final  class esquemacategoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T006P2", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, EscBasico, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P3", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, EscBasico, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P4", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  FOR UPDATE OF Categoria1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P5", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P6", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P7", "SELECT TM1.CatCodigo, TM1.CatDescrip, TM1.CatDescripSinAc, TM1.CatClase, TM1.CatTipoTarifa, TM1.CatFrecAct, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Categoria1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P8", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P9", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P10", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006P11", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CatCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T006P12", "SAVEPOINT gxupdate;INSERT INTO Categoria1(CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CliCod, CliPaiConve, CliConvenio, CatRelSec, CatRelRef, CatOld, CatAfipCod) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006P13", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatDescrip=?, CatDescripSinAc=?, CatClase=?, CatTipoTarifa=?, CatFrecAct=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006P14", "SAVEPOINT gxupdate;DELETE FROM Categoria1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006P15", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006P16", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio, LiqCatCodigo FROM LiquidacionCategoria WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ? AND LiqCatCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T006P17", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P18", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, EscBasico, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P19", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T006P20", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliConvenio, CatCodigo, CatVigencia, EscBasico, CliPaiConve, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscAdicional, CatSalRelSec, CatSalRelRef, CatSalOld) VALUES(?, ?, ?, ?, ?, ?, 0, 0, 0, 0, 0, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006P21", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET EscBasico=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T006P22", "SAVEPOINT gxupdate;DELETE FROM Categoriavalores1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T006P23", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T006P24", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getString(9, 20);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 14 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 21 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 22 :
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
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
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
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
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
               stmt.setString(10, (String)parms[9], 40);
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
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 10 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 1);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setInt(7, ((Number) parms[6]).intValue());
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setString(9, (String)parms[8], 20);
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setString(8, (String)parms[7], 20);
               stmt.setString(9, (String)parms[8], 40);
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 13 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 16 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[4], 2);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 19 :
               stmt.setBigDecimal(1, (java.math.BigDecimal)parms[0], 2);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 40);
               stmt.setDate(6, (java.util.Date)parms[5]);
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 21 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

