package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdefaultpath extends GXProcedure
{
   public getdefaultpath( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdefaultpath.class ), "" );
   }

   public getdefaultpath( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      getdefaultpath.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      getdefaultpath.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* User Code */
       AV8rutaAplicacion = httpContext.getDefaultPath() ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV11Pgmname, AV8rutaAplicacion) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = getdefaultpath.this.AV8rutaAplicacion;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8rutaAplicacion = "" ;
      AV11Pgmname = "" ;
      AV11Pgmname = "getDefaultPath" ;
      /* GeneXus formulas. */
      AV11Pgmname = "getDefaultPath" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV11Pgmname ;
   private String AV8rutaAplicacion ;
   private String[] aP0 ;
}

