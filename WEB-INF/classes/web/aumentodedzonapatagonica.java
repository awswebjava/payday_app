package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class aumentodedzonapatagonica extends GXProcedure
{
   public aumentodedzonapatagonica( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( aumentodedzonapatagonica.class ), "" );
   }

   public aumentodedzonapatagonica( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 )
   {
      aumentodedzonapatagonica.this.aP1 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        java.math.BigDecimal[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             java.math.BigDecimal[] aP1 )
   {
      aumentodedzonapatagonica.this.AV9CliCod = aP0;
      aumentodedzonapatagonica.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8ZonPorcAumenDed = DecimalUtil.stringToDec("1.22") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = aumentodedzonapatagonica.this.AV8ZonPorcAumenDed;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8ZonPorcAumenDed = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9CliCod ;
   private java.math.BigDecimal AV8ZonPorcAumenDed ;
   private java.math.BigDecimal[] aP1 ;
}

