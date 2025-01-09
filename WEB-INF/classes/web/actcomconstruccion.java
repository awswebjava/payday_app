package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actcomconstruccion extends GXProcedure
{
   public actcomconstruccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actcomconstruccion.class ), "" );
   }

   public actcomconstruccion( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      actcomconstruccion.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      actcomconstruccion.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ActComCodigo = httpContext.getMessage( "CONSTRUCCION", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = actcomconstruccion.this.AV8ActComCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ActComCodigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ActComCodigo ;
   private String[] aP0 ;
}

