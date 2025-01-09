package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class convertirnum6afecha extends GXProcedure
{
   public convertirnum6afecha( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( convertirnum6afecha.class ), "" );
   }

   public convertirnum6afecha( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short[] aP1 ,
                                     byte[] aP2 ,
                                     byte[] aP3 )
   {
      convertirnum6afecha.this.aP4 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 ,
                        byte[] aP2 ,
                        byte[] aP3 ,
                        java.util.Date[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 ,
                             byte[] aP2 ,
                             byte[] aP3 ,
                             java.util.Date[] aP4 )
   {
      convertirnum6afecha.this.AV9AAAAMM = aP0;
      convertirnum6afecha.this.aP1 = aP1;
      convertirnum6afecha.this.aP2 = aP2;
      convertirnum6afecha.this.aP3 = aP3;
      convertirnum6afecha.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqPerAno = (short)(GXutil.lval( GXutil.substring( GXutil.str( AV9AAAAMM, 6, 0), 1, 4))) ;
      AV10mesNro = (byte)(GXutil.lval( GXutil.substring( GXutil.str( AV9AAAAMM, 6, 0), 5, 2))) ;
      AV11LiqPerMes = AV10mesNro ;
      AV12LiqPeriodo = localUtil.ymdtod( AV8LiqPerAno, AV10mesNro, 1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV12LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &liqperano ", "")+GXutil.trim( GXutil.str( AV8LiqPerAno, 4, 0))+httpContext.getMessage( " &LiqPerMes ", "")+GXutil.trim( GXutil.str( AV11LiqPerMes, 2, 0))+httpContext.getMessage( " &AAAAMM ", "")+GXutil.trim( GXutil.str( AV9AAAAMM, 6, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = convertirnum6afecha.this.AV8LiqPerAno;
      this.aP2[0] = convertirnum6afecha.this.AV11LiqPerMes;
      this.aP3[0] = convertirnum6afecha.this.AV10mesNro;
      this.aP4[0] = convertirnum6afecha.this.AV12LiqPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqPeriodo = GXutil.nullDate() ;
      AV15Pgmname = "" ;
      AV15Pgmname = "ConvertirNum6AFecha" ;
      /* GeneXus formulas. */
      AV15Pgmname = "ConvertirNum6AFecha" ;
      Gx_err = (short)(0) ;
   }

   private byte AV11LiqPerMes ;
   private byte AV10mesNro ;
   private short AV8LiqPerAno ;
   private short Gx_err ;
   private int AV9AAAAMM ;
   private String AV15Pgmname ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date[] aP4 ;
   private short[] aP1 ;
   private byte[] aP2 ;
   private byte[] aP3 ;
}

