package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultspervacaciones extends GXProcedure
{
   public defaultspervacaciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultspervacaciones.class ), "" );
   }

   public defaultspervacaciones( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( short aP0 ,
                                           byte[] aP1 ,
                                           byte[] aP2 )
   {
      defaultspervacaciones.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 ,
                        byte[] aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 ,
                             byte[] aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      defaultspervacaciones.this.AV11PaiCod = aP0;
      defaultspervacaciones.this.aP1 = aP1;
      defaultspervacaciones.this.aP2 = aP2;
      defaultspervacaciones.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8desdeMes = (byte)(10) ;
      AV9hastaMes = (byte)(4) ;
      AV12porUnaje = DecimalUtil.stringToDec("0.3333") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = defaultspervacaciones.this.AV8desdeMes;
      this.aP2[0] = defaultspervacaciones.this.AV9hastaMes;
      this.aP3[0] = defaultspervacaciones.this.AV12porUnaje;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12porUnaje = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8desdeMes ;
   private byte AV9hastaMes ;
   private short AV11PaiCod ;
   private short Gx_err ;
   private java.math.BigDecimal AV12porUnaje ;
   private java.math.BigDecimal[] aP3 ;
   private byte[] aP1 ;
   private byte[] aP2 ;
}

