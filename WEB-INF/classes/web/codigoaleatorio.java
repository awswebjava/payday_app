package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class codigoaleatorio extends GXProcedure
{
   public codigoaleatorio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( codigoaleatorio.class ), "" );
   }

   public codigoaleatorio( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 )
   {
      codigoaleatorio.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             String[] aP1 )
   {
      codigoaleatorio.this.AV9largo = aP0;
      codigoaleatorio.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12multiplicaNumChar = "1" ;
      AV13i = (short)(1) ;
      while ( AV13i <= AV9largo )
      {
         AV12multiplicaNumChar += "0" ;
         AV13i = (short)(AV13i+1) ;
      }
      AV10Random = (int)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GXutil.random( )).multiply(CommonUtil.decimalVal( AV12multiplicaNumChar, ".")))) ;
      AV8palabra = GXutil.trim( GXutil.str( AV10Random, 8, 0)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = codigoaleatorio.this.AV8palabra;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8palabra = "" ;
      AV12multiplicaNumChar = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9largo ;
   private short AV13i ;
   private short Gx_err ;
   private int AV10Random ;
   private String AV8palabra ;
   private String AV12multiplicaNumChar ;
   private String[] aP1 ;
}

