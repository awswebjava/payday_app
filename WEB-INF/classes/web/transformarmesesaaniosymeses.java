package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class transformarmesesaaniosymeses extends GXProcedure
{
   public transformarmesesaaniosymeses( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( transformarmesesaaniosymeses.class ), "" );
   }

   public transformarmesesaaniosymeses( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( short[] aP0 )
   {
      transformarmesesaaniosymeses.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short[] aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short[] aP0 ,
                             short[] aP1 )
   {
      transformarmesesaaniosymeses.this.AV8antiguedadMeses = aP0[0];
      this.aP0 = aP0;
      transformarmesesaaniosymeses.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8antiguedadMeses >= 12 )
      {
         if ( AV8antiguedadMeses == 12 )
         {
            AV9AntiguedadAnios = (short)(1) ;
            AV8antiguedadMeses = (short)(0) ;
         }
         else
         {
            AV9AntiguedadAnios = (short)(DecimalUtil.decToDouble(GXutil.truncDecimal( DecimalUtil.doubleToDec(AV8antiguedadMeses/ (double) (12)), 0))) ;
            AV10antiguedadMesesAux = AV8antiguedadMeses ;
            AV8antiguedadMeses = (short)(((int)((AV10antiguedadMesesAux) % (12)))) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = transformarmesesaaniosymeses.this.AV8antiguedadMeses;
      this.aP1[0] = transformarmesesaaniosymeses.this.AV9AntiguedadAnios;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8antiguedadMeses ;
   private short AV9AntiguedadAnios ;
   private short AV10antiguedadMesesAux ;
   private short Gx_err ;
   private short[] aP1 ;
   private short[] aP0 ;
}

