package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class almacenaarchivobase64 extends GXProcedure
{
   public almacenaarchivobase64( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( almacenaarchivobase64.class ), "" );
   }

   public almacenaarchivobase64( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      almacenaarchivobase64.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      almacenaarchivobase64.this.AV9base64String = aP0;
      almacenaarchivobase64.this.AV10archivoNombre = aP1;
      almacenaarchivobase64.this.aP2 = aP2;
      almacenaarchivobase64.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8File.setSource( "uploads_img/"+GXutil.trim( AV10archivoNombre) );
      AV8File.create();
      AV8File.fromBase64(AV9base64String);
      AV12rutaAbsoluta = AV8File.getAbsoluteName() ;
      AV8File.close();
      if ( AV8File.getErrCode() != 0 )
      {
         AV11error = AV8File.getErrDescription() ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = almacenaarchivobase64.this.AV12rutaAbsoluta;
      this.aP3[0] = almacenaarchivobase64.this.AV11error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12rutaAbsoluta = "" ;
      AV11error = "" ;
      AV8File = new com.genexus.util.GXFile();
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9base64String ;
   private String AV10archivoNombre ;
   private String AV12rutaAbsoluta ;
   private String AV11error ;
   private com.genexus.util.GXFile AV8File ;
   private String[] aP3 ;
   private String[] aP2 ;
}

