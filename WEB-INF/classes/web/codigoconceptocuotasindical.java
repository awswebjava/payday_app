package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoconceptocuotasindical extends GXProcedure
{
   public codigoconceptocuotasindical( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoconceptocuotasindical.class ), "" );
   }

   public codigoconceptocuotasindical( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      codigoconceptocuotasindical.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      codigoconceptocuotasindical.this.AV9CliCod = aP0;
      codigoconceptocuotasindical.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ConCodigo = httpContext.getMessage( "DES009", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = codigoconceptocuotasindical.this.AV8ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ConCodigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private String AV8ConCodigo ;
   private String[] aP1 ;
}

