package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paqueteprefijo extends GXProcedure
{
   public paqueteprefijo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paqueteprefijo.class ), "" );
   }

   public paqueteprefijo( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      paqueteprefijo.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      paqueteprefijo.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "com.paga.", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = paqueteprefijo.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8texto ;
   private String[] aP0 ;
}

