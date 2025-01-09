package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class contarpdfs extends GXProcedure
{
   public contarpdfs( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( contarpdfs.class ), "" );
   }

   public contarpdfs( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 )
   {
      contarpdfs.this.aP3 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 )
   {
      contarpdfs.this.AV12CliCod = aP0;
      contarpdfs.this.AV11EmpCod = aP1;
      contarpdfs.this.AV10LiqNro = aP2;
      contarpdfs.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Optimized group. */
      /* Using cursor P02JU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV11EmpCod), Integer.valueOf(AV10LiqNro)});
      cV9count = P02JU2_AV9count[0] ;
      pr_default.close(0);
      AV9count = (short)(AV9count+cV9count*1) ;
      /* End optimized group. */
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = contarpdfs.this.AV9count;
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
      P02JU2_AV9count = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.contarpdfs__default(),
         new Object[] {
             new Object[] {
            P02JU2_AV9count
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV9count ;
   private short cV9count ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV10LiqNro ;
   private String scmdbuf ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P02JU2_AV9count ;
}

final  class contarpdfs__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02JU2", "SELECT COUNT(*) FROM LiquidacionLegajo WHERE (CliCod = ? and EmpCod = ? and LiqNro = ?) AND (Not (char_length(trim(trailing ' ' from LiqNombrePDF))=0) or Not (char_length(trim(trailing ' ' from LiqNombrePDFVertical))=0)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               return;
      }
   }

}

