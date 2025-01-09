package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class generarinterbanking extends GXProcedure
{
   public generarinterbanking( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( generarinterbanking.class ), "" );
   }

   public generarinterbanking( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        int aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             int aP1 )
   {
      generarinterbanking.this.AV10EmpCod = aP0;
      generarinterbanking.this.AV11LiqNro = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV9archivofullpath ;
      GXv_char2[0] = AV8archivo ;
      GXv_char3[0] = AV12error ;
      new web.genarchivotransfinterbanking(remoteHandle, context).execute( AV10EmpCod, AV11LiqNro, GXv_char1, GXv_char2, GXv_char3) ;
      generarinterbanking.this.AV9archivofullpath = GXv_char1[0] ;
      generarinterbanking.this.AV8archivo = GXv_char2[0] ;
      generarinterbanking.this.AV12error = GXv_char3[0] ;
      if ( (GXutil.strcmp("", AV12error)==0) )
      {
         httpContext.wjLoc = formatLink("web.adownload", new String[] {GXutil.URLEncode(GXutil.rtrim(httpContext.getMessage( "text/plain", ""))),GXutil.URLEncode(GXutil.rtrim(AV8archivo)),GXutil.URLEncode(GXutil.rtrim(AV9archivofullpath))}, new String[] {"contenttype","filename","filepath"})  ;
      }
      else
      {
         httpContext.GX_msglist.addItem(AV12error);
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9archivofullpath = "" ;
      GXv_char1 = new String[1] ;
      AV8archivo = "" ;
      GXv_char2 = new String[1] ;
      AV12error = "" ;
      GXv_char3 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV11LiqNro ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV9archivofullpath ;
   private String AV8archivo ;
   private String AV12error ;
}

