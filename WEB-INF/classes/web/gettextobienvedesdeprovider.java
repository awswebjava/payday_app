package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettextobienvedesdeprovider extends GXProcedure
{
   public gettextobienvedesdeprovider( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettextobienvedesdeprovider.class ), "" );
   }

   public gettextobienvedesdeprovider( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      gettextobienvedesdeprovider.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      gettextobienvedesdeprovider.this.AV13CliCod = aP0;
      gettextobienvedesdeprovider.this.AV10MenuItemId = aP1;
      gettextobienvedesdeprovider.this.aP2 = aP2;
      gettextobienvedesdeprovider.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 = AV8ini_bienvenida ;
      GXv_objcol_Sdtini_bienvenida_ini_bienvenidaItem2[0] = GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 ;
      new web.textosbienvepredeterminados(remoteHandle, context).execute( GXv_objcol_Sdtini_bienvenida_ini_bienvenidaItem2) ;
      GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 = GXv_objcol_Sdtini_bienvenida_ini_bienvenidaItem2[0] ;
      AV8ini_bienvenida = GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 ;
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV8ini_bienvenida.size() )
      {
         AV9item = (web.Sdtini_bienvenida_ini_bienvenidaItem)((web.Sdtini_bienvenida_ini_bienvenidaItem)AV8ini_bienvenida.elementAt(-1+AV16GXV1));
         if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV9item.getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Menuitemid())), GXutil.upper( GXutil.trim( AV10MenuItemId))) == 0 )
         {
            GXv_char3[0] = AV12MItemBienTitDef ;
            new web.capitalizartexto(remoteHandle, context).execute( GXutil.trim( AV9item.getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientitdef()), GXv_char3) ;
            gettextobienvedesdeprovider.this.AV12MItemBienTitDef = GXv_char3[0] ;
            AV12MItemBienTitDef = GXutil.strReplace( AV12MItemBienTitDef, httpContext.getMessage( "a.r.t.", ""), httpContext.getMessage( "A.R.T.", "")) ;
            AV12MItemBienTitDef = GXutil.strReplace( AV12MItemBienTitDef, httpContext.getMessage( "afip", ""), httpContext.getMessage( "AFIP", "")) ;
            AV12MItemBienTitDef = GXutil.strReplace( AV12MItemBienTitDef, httpContext.getMessage( "siradig", ""), httpContext.getMessage( "SIRADIG", "")) ;
            AV11MItemBienTextDef = GXutil.trim( AV9item.getgxTv_Sdtini_bienvenida_ini_bienvenidaItem_Mitembientextdef()) ;
            if (true) break;
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
      if ( (GXutil.strcmp("", AV12MItemBienTitDef)==0) )
      {
         AV12MItemBienTitDef = httpContext.getMessage( "Título", "") ;
         AV11MItemBienTextDef = httpContext.getMessage( "Texto", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = gettextobienvedesdeprovider.this.AV12MItemBienTitDef;
      this.aP3[0] = gettextobienvedesdeprovider.this.AV11MItemBienTextDef;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12MItemBienTitDef = "" ;
      AV11MItemBienTextDef = "" ;
      AV8ini_bienvenida = new GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>(web.Sdtini_bienvenida_ini_bienvenidaItem.class, "ini_bienvenidaItem", "PayDay", remoteHandle);
      GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 = new GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem>(web.Sdtini_bienvenida_ini_bienvenidaItem.class, "ini_bienvenidaItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtini_bienvenida_ini_bienvenidaItem2 = new GXBaseCollection[1] ;
      AV9item = new web.Sdtini_bienvenida_ini_bienvenidaItem(remoteHandle, context);
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV13CliCod ;
   private int AV16GXV1 ;
   private String GXv_char3[] ;
   private String AV11MItemBienTextDef ;
   private String AV10MenuItemId ;
   private String AV12MItemBienTitDef ;
   private String[] aP3 ;
   private String[] aP2 ;
   private GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem> AV8ini_bienvenida ;
   private GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem> GXt_objcol_Sdtini_bienvenida_ini_bienvenidaItem1 ;
   private GXBaseCollection<web.Sdtini_bienvenida_ini_bienvenidaItem> GXv_objcol_Sdtini_bienvenida_ini_bienvenidaItem2[] ;
   private web.Sdtini_bienvenida_ini_bienvenidaItem AV9item ;
}

