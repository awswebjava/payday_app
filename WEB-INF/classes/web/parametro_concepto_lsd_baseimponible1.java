package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parametro_concepto_lsd_baseimponible1 extends GXProcedure
{
   public parametro_concepto_lsd_baseimponible1( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parametro_concepto_lsd_baseimponible1.class ), "" );
   }

   public parametro_concepto_lsd_baseimponible1( int remoteHandle ,
                                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      parametro_concepto_lsd_baseimponible1.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      parametro_concepto_lsd_baseimponible1.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10ParmCod = httpContext.getMessage( "CONC_LSDBASE1", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = parametro_concepto_lsd_baseimponible1.this.AV10ParmCod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ParmCod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV10ParmCod ;
   private String[] aP0 ;
}

