package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getcantdetcalculado extends GXProcedure
{
   public getcantdetcalculado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getcantdetcalculado.class ), "" );
   }

   public getcantdetcalculado( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            String aP3 )
   {
      getcantdetcalculado.this.aP4 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        short[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             short[] aP4 )
   {
      getcantdetcalculado.this.AV9CliCod = aP0;
      getcantdetcalculado.this.AV11EmpCod = aP1;
      getcantdetcalculado.this.AV10LiqNro = aP2;
      getcantdetcalculado.this.AV12DConCodigo = aP3;
      getcantdetcalculado.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8cantPrin = (short)(0) ;
      /* Optimized group. */
      /* Using cursor P02JT2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LiqNro), AV12DConCodigo});
      cV8cantPrin = P02JT2_AV8cantPrin[0] ;
      pr_default.close(0);
      AV8cantPrin = (short)(AV8cantPrin+cV8cantPrin*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getcantdetcalculado.this.AV8cantPrin;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      P02JT2_AV8cantPrin = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getcantdetcalculado__default(),
         new Object[] {
             new Object[] {
            P02JT2_AV8cantPrin
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV8cantPrin ;
   private short cV8cantPrin ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LiqNro ;
   private String AV12DConCodigo ;
   private String scmdbuf ;
   private short[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P02JT2_AV8cantPrin ;
}

final  class getcantdetcalculado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JT2", "SELECT COUNT(*) FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (DConCodigo = ( ?)) AND (LiqDCalculado = 1) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
      }
   }

}

