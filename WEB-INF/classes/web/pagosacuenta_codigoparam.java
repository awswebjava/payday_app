package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class pagosacuenta_codigoparam extends GXProcedure
{
   public pagosacuenta_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( pagosacuenta_codigoparam.class ), "" );
   }

   public pagosacuenta_codigoparam( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      pagosacuenta_codigoparam.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      pagosacuenta_codigoparam.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ParmCod = httpContext.getMessage( "CONC_PAGOS_A_CUENTA", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = pagosacuenta_codigoparam.this.AV8ParmCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ParmCod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8ParmCod ;
   private String[] aP0 ;
}

