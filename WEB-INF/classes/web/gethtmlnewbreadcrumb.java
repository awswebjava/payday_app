package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethtmlnewbreadcrumb extends GXProcedure
{
   public gethtmlnewbreadcrumb( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethtmlnewbreadcrumb.class ), "" );
   }

   public gethtmlnewbreadcrumb( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             long aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 )
   {
      gethtmlnewbreadcrumb.this.aP7 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        byte aP1 ,
                        byte aP2 ,
                        long aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             byte aP1 ,
                             byte aP2 ,
                             long aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 )
   {
      gethtmlnewbreadcrumb.this.AV12MenuOpcCod = aP0;
      gethtmlnewbreadcrumb.this.AV18RolId = aP1;
      gethtmlnewbreadcrumb.this.AV19PerfilId = aP2;
      gethtmlnewbreadcrumb.this.AV20MenuverId = aP3;
      gethtmlnewbreadcrumb.this.aP4 = aP4;
      gethtmlnewbreadcrumb.this.aP5 = aP5;
      gethtmlnewbreadcrumb.this.aP6 = aP6;
      gethtmlnewbreadcrumb.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[0] = AV9sdt_breadCrumb ;
      GXv_char2[0] = AV15primeroMenuOpcCod ;
      GXv_char3[0] = AV16headTitle ;
      new web.getbreadcrumb(remoteHandle, context).execute( AV12MenuOpcCod, AV18RolId, AV19PerfilId, AV20MenuverId, GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1, GXv_char2, GXv_char3) ;
      AV9sdt_breadCrumb = GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[0] ;
      gethtmlnewbreadcrumb.this.AV15primeroMenuOpcCod = GXv_char2[0] ;
      gethtmlnewbreadcrumb.this.AV16headTitle = GXv_char3[0] ;
      if ( AV9sdt_breadCrumb.size() == 0 )
      {
         if ( ! (GXutil.strcmp("", AV16headTitle)==0) )
         {
            AV8html = httpContext.getMessage( "Home / ", "") ;
         }
         AV8html += httpContext.getMessage( "<span class=\"NewTextBlockTitleWWP\" id=\"TEXTBLOCKTITLE\">", "") + GXutil.trim( AV16headTitle) + httpContext.getMessage( "</span>", "") ;
         AV21opciones = (short)(1) ;
      }
      else
      {
         AV8html = httpContext.getMessage( "<ul class=\"NewBreadcrumb\">", "") ;
         AV11b = (short)(0) ;
         AV8html += httpContext.getMessage( "<li>Home</li>", "") ;
         AV25GXV1 = 1 ;
         while ( AV25GXV1 <= AV9sdt_breadCrumb.size() )
         {
            AV10itemBreadCrumb = (web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)((web.Sdtsdt_breadCrumb_sdt_breadCrumbItem)AV9sdt_breadCrumb.elementAt(-1+AV25GXV1));
            AV11b = (short)(AV11b+1) ;
            AV8html += httpContext.getMessage( "<li>", "") ;
            if ( ! (GXutil.strcmp("", AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url())==0) )
            {
               AV8html += httpContext.getMessage( "<a href=\"", "") + GXutil.trim( AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url()) + "\">" ;
            }
            AV8html += GXutil.trim( AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo()) ;
            if ( AV11b < AV9sdt_breadCrumb.size() )
            {
               if ( ! (GXutil.strcmp("", AV17text)==0) )
               {
                  AV17text += " / " ;
               }
               AV17text += GXutil.trim( AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Menuopctitulo()) ;
               AV21opciones = (short)(AV21opciones+1) ;
            }
            if ( ! (GXutil.strcmp("", AV10itemBreadCrumb.getgxTv_Sdtsdt_breadCrumb_sdt_breadCrumbItem_Url())==0) )
            {
               AV8html += httpContext.getMessage( "</a>", "") ;
            }
            AV8html += httpContext.getMessage( "</li>", "") ;
            AV25GXV1 = (int)(AV25GXV1+1) ;
         }
         AV8html += httpContext.getMessage( "</ul>", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gethtmlnewbreadcrumb.this.AV8html;
      this.aP5[0] = gethtmlnewbreadcrumb.this.AV15primeroMenuOpcCod;
      this.aP6[0] = gethtmlnewbreadcrumb.this.AV16headTitle;
      this.aP7[0] = gethtmlnewbreadcrumb.this.AV17text;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8html = "" ;
      AV15primeroMenuOpcCod = "" ;
      AV16headTitle = "" ;
      AV17text = "" ;
      AV9sdt_breadCrumb = new GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem>(web.Sdtsdt_breadCrumb_sdt_breadCrumbItem.class, "sdt_breadCrumbItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1 = new GXBaseCollection[1] ;
      GXv_char2 = new String[1] ;
      GXv_char3 = new String[1] ;
      AV10itemBreadCrumb = new web.Sdtsdt_breadCrumb_sdt_breadCrumbItem(remoteHandle, context);
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18RolId ;
   private byte AV19PerfilId ;
   private short AV21opciones ;
   private short AV11b ;
   private short Gx_err ;
   private int AV25GXV1 ;
   private long AV20MenuverId ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV8html ;
   private String AV12MenuOpcCod ;
   private String AV15primeroMenuOpcCod ;
   private String AV16headTitle ;
   private String AV17text ;
   private String[] aP7 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem> AV9sdt_breadCrumb ;
   private GXBaseCollection<web.Sdtsdt_breadCrumb_sdt_breadCrumbItem> GXv_objcol_Sdtsdt_breadCrumb_sdt_breadCrumbItem1[] ;
   private web.Sdtsdt_breadCrumb_sdt_breadCrumbItem AV10itemBreadCrumb ;
}

