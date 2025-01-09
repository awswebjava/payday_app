package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descripdescuentoadelantovacaciones extends GXProcedure
{
   public descripdescuentoadelantovacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descripdescuentoadelantovacaciones.class ), "" );
   }

   public descripdescuentoadelantovacaciones( int remoteHandle ,
                                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      descripdescuentoadelantovacaciones.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      descripdescuentoadelantovacaciones.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ConDescrip = httpContext.getMessage( "DESCUENTO POR ADELANTO DE VACACIONES", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = descripdescuentoadelantovacaciones.this.AV8ConDescrip;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConDescrip = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ConDescrip ;
   private String[] aP0 ;
}

