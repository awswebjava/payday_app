package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class uploadhtmlas3 extends GXProcedure
{
   public uploadhtmlas3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( uploadhtmlas3.class ), "" );
   }

   public uploadhtmlas3( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 )
   {
      uploadhtmlas3.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean aP3 ,
                             String[] aP4 )
   {
      uploadhtmlas3.this.AV9CliCod = aP0;
      uploadhtmlas3.this.AV10metodoPdfPalabra = aP1;
      uploadhtmlas3.this.AV11imprimirLiqLeg = aP2;
      uploadhtmlas3.this.AV12grabarHtmlDB = aP3;
      uploadhtmlas3.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, httpContext.getMessage( "&metodoPdfPalabra \"", "")+AV10metodoPdfPalabra+httpContext.getMessage( "\" &imprimirLiqLeg \"", "")+AV11imprimirLiqLeg+"\"") ;
      if ( GXutil.strcmp(AV10metodoPdfPalabra, httpContext.getMessage( "DIRECTA", "")) == 0 )
      {
         if ( AV12grabarHtmlDB )
         {
            AV8palabra = httpContext.getMessage( "processHTMLtoPDFandS3FromDB_sync", "") ;
         }
         else
         {
            if ( GXutil.strcmp(AV11imprimirLiqLeg, httpContext.getMessage( "MASIVO", "")) == 0 )
            {
               AV8palabra = httpContext.getMessage( "uploadHTMLaS3", "") ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, "1") ;
            }
            else
            {
               AV8palabra = httpContext.getMessage( "processHTMLtoPDFandS3_sync", "") ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, "2") ;
            }
         }
      }
      else
      {
         if ( AV12grabarHtmlDB )
         {
            AV8palabra = httpContext.getMessage( "processHTMLtoPDFandS3FromDB_async", "") ;
         }
         else
         {
            if ( GXutil.strcmp(AV10metodoPdfPalabra, httpContext.getMessage( "TRIGGER", "")) == 0 )
            {
               AV8palabra = httpContext.getMessage( "uploadHTMLaS3_async", "") ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, "3") ;
            }
            else
            {
               AV8palabra = httpContext.getMessage( "processHTMLtoPDFandS3", "") ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, "4") ;
            }
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV15Pgmname, httpContext.getMessage( "&palabra ", "")+AV8palabra) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = uploadhtmlas3.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      AV15Pgmname = "" ;
      AV15Pgmname = "uploadHTMLaS3" ;
      /* GeneXus formulas. */
      AV15Pgmname = "uploadHTMLaS3" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV10metodoPdfPalabra ;
   private String AV11imprimirLiqLeg ;
   private String AV8palabra ;
   private String AV15Pgmname ;
   private boolean AV12grabarHtmlDB ;
   private String[] aP4 ;
}

