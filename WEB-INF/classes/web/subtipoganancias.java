package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class subtipoganancias extends GXProcedure
{
   public subtipoganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( subtipoganancias.class ), "" );
   }

   public subtipoganancias( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      subtipoganancias.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      subtipoganancias.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8SubTipoConCod1 = "810008" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = subtipoganancias.this.AV8SubTipoConCod1;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SubTipoConCod1 = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8SubTipoConCod1 ;
   private String[] aP0 ;
}
