package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptoafipadelantovacaciones extends GXProcedure
{
   public conceptoafipadelantovacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptoafipadelantovacaciones.class ), "" );
   }

   public conceptoafipadelantovacaciones( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      conceptoafipadelantovacaciones.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      conceptoafipadelantovacaciones.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8SubTipoConCod2 = "150000" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = conceptoafipadelantovacaciones.this.AV8SubTipoConCod2;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SubTipoConCod2 = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SubTipoConCod2 ;
   private String[] aP0 ;
}

