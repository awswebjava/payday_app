package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class auto_imprimir_pdfliq_codigoparam extends GXProcedure
{
   public auto_imprimir_pdfliq_codigoparam( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( auto_imprimir_pdfliq_codigoparam.class ), "" );
   }

   public auto_imprimir_pdfliq_codigoparam( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      auto_imprimir_pdfliq_codigoparam.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      auto_imprimir_pdfliq_codigoparam.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8parmcod = httpContext.getMessage( "auto_imprimir_PDF_Liq", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = auto_imprimir_pdfliq_codigoparam.this.AV8parmcod;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8parmcod = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8parmcod ;
   private String[] aP0 ;
}

