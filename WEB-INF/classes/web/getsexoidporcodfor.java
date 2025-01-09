package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getsexoidporcodfor extends GXProcedure
{
   public getsexoidporcodfor( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getsexoidporcodfor.class ), "" );
   }

   public getsexoidporcodfor( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 ,
                              byte[] aP2 )
   {
      getsexoidporcodfor.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        byte[] aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             byte[] aP2 ,
                             boolean[] aP3 )
   {
      getsexoidporcodfor.this.AV9SexoPaiCod = aP0;
      getsexoidporcodfor.this.AV10SexoCodFor = aP1;
      getsexoidporcodfor.this.aP2 = aP2;
      getsexoidporcodfor.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01ZO2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV9SexoPaiCod), AV10SexoCodFor});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2092SexoCodFor = P01ZO2_A2092SexoCodFor[0] ;
         A1742SexoPaiCod = P01ZO2_A1742SexoPaiCod[0] ;
         A1743SexoId = P01ZO2_A1743SexoId[0] ;
         AV8SexoId = A1743SexoId ;
         AV11existe = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getsexoidporcodfor.this.AV8SexoId;
      this.aP3[0] = getsexoidporcodfor.this.AV11existe;
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
      P01ZO2_A2092SexoCodFor = new String[] {""} ;
      P01ZO2_A1742SexoPaiCod = new short[1] ;
      P01ZO2_A1743SexoId = new byte[1] ;
      A2092SexoCodFor = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getsexoidporcodfor__default(),
         new Object[] {
             new Object[] {
            P01ZO2_A2092SexoCodFor, P01ZO2_A1742SexoPaiCod, P01ZO2_A1743SexoId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8SexoId ;
   private byte A1743SexoId ;
   private short AV9SexoPaiCod ;
   private short A1742SexoPaiCod ;
   private short Gx_err ;
   private String AV10SexoCodFor ;
   private String scmdbuf ;
   private String A2092SexoCodFor ;
   private boolean AV11existe ;
   private boolean[] aP3 ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01ZO2_A2092SexoCodFor ;
   private short[] P01ZO2_A1742SexoPaiCod ;
   private byte[] P01ZO2_A1743SexoId ;
}

final  class getsexoidporcodfor__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZO2", "SELECT SexoCodFor, SexoPaiCod, SexoId FROM Sexos WHERE SexoPaiCod = ? and SexoCodFor = ( ?) ORDER BY SexoPaiCod, SexoCodFor  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               return;
      }
   }

}

