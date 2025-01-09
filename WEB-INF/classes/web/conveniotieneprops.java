package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniotieneprops extends GXProcedure
{
   public conveniotieneprops( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniotieneprops.class ), "" );
   }

   public conveniotieneprops( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( short aP0 ,
                              String aP1 )
   {
      conveniotieneprops.this.aP2 = new boolean[] {false};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        boolean[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             boolean[] aP2 )
   {
      conveniotieneprops.this.AV10PaiCod = aP0;
      conveniotieneprops.this.AV9ConveCodigo = aP1;
      conveniotieneprops.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P028S2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10PaiCod), AV9ConveCodigo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A9ConveCodigo = P028S2_A9ConveCodigo[0] ;
         A46PaiCod = P028S2_A46PaiCod[0] ;
         A2227propCod = P028S2_A2227propCod[0] ;
         AV8tiene = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = conveniotieneprops.this.AV8tiene;
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
      P028S2_A9ConveCodigo = new String[] {""} ;
      P028S2_A46PaiCod = new short[1] ;
      P028S2_A2227propCod = new String[] {""} ;
      A9ConveCodigo = "" ;
      A2227propCod = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.conveniotieneprops__default(),
         new Object[] {
             new Object[] {
            P028S2_A9ConveCodigo, P028S2_A46PaiCod, P028S2_A2227propCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9ConveCodigo ;
   private String scmdbuf ;
   private String A9ConveCodigo ;
   private String A2227propCod ;
   private boolean AV8tiene ;
   private boolean[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P028S2_A9ConveCodigo ;
   private short[] P028S2_A46PaiCod ;
   private String[] P028S2_A2227propCod ;
}

final  class conveniotieneprops__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028S2", "SELECT ConveCodigo, PaiCod, propCod FROM ConvenioPropiedadesAdicionales WHERE PaiCod = ? and ConveCodigo = ( ?) ORDER BY PaiCod, ConveCodigo  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
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

