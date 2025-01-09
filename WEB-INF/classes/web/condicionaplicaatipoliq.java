package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class condicionaplicaatipoliq extends GXProcedure
{
   public condicionaplicaatipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( condicionaplicaatipoliq.class ), "" );
   }

   public condicionaplicaatipoliq( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              String aP1 ,
                              String aP2 )
   {
      condicionaplicaatipoliq.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        String aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             String aP2 ,
                             boolean[] aP3 )
   {
      condicionaplicaatipoliq.this.AV9CliCod = aP0;
      condicionaplicaatipoliq.this.AV10TLiqCod = aP1;
      condicionaplicaatipoliq.this.AV8ConTLCondicion = aP2;
      condicionaplicaatipoliq.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MZ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), AV10TLiqCod, AV8ConTLCondicion});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1410ConTLCondicion = P01MZ2_A1410ConTLCondicion[0] ;
         n1410ConTLCondicion = P01MZ2_n1410ConTLCondicion[0] ;
         A1470ConTLConHab = P01MZ2_A1470ConTLConHab[0] ;
         A32TLiqCod = P01MZ2_A32TLiqCod[0] ;
         A3CliCod = P01MZ2_A3CliCod[0] ;
         A26ConCodigo = P01MZ2_A26ConCodigo[0] ;
         AV11hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = condicionaplicaatipoliq.this.AV11hay;
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
      P01MZ2_A1410ConTLCondicion = new String[] {""} ;
      P01MZ2_n1410ConTLCondicion = new boolean[] {false} ;
      P01MZ2_A1470ConTLConHab = new byte[1] ;
      P01MZ2_A32TLiqCod = new String[] {""} ;
      P01MZ2_A3CliCod = new int[1] ;
      P01MZ2_A26ConCodigo = new String[] {""} ;
      A1410ConTLCondicion = "" ;
      A32TLiqCod = "" ;
      A26ConCodigo = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.condicionaplicaatipoliq__default(),
         new Object[] {
             new Object[] {
            P01MZ2_A1410ConTLCondicion, P01MZ2_n1410ConTLCondicion, P01MZ2_A1470ConTLConHab, P01MZ2_A32TLiqCod, P01MZ2_A3CliCod, P01MZ2_A26ConCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1470ConTLConHab ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private String AV10TLiqCod ;
   private String AV8ConTLCondicion ;
   private String scmdbuf ;
   private String A1410ConTLCondicion ;
   private String A32TLiqCod ;
   private String A26ConCodigo ;
   private boolean AV11hay ;
   private boolean n1410ConTLCondicion ;
   private boolean[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MZ2_A1410ConTLCondicion ;
   private boolean[] P01MZ2_n1410ConTLCondicion ;
   private byte[] P01MZ2_A1470ConTLConHab ;
   private String[] P01MZ2_A32TLiqCod ;
   private int[] P01MZ2_A3CliCod ;
   private String[] P01MZ2_A26ConCodigo ;
}

final  class condicionaplicaatipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MZ2", "SELECT ConTLCondicion, ConTLConHab, TLiqCod, CliCod, ConCodigo FROM ConceptoTipoLiquidacion WHERE (CliCod = ? and TLiqCod = ( ?) and ConTLCondicion = ( ?)) AND (ConTLConHab = 1) ORDER BY CliCod, TLiqCod, ConTLCondicion  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((byte[]) buf[2])[0] = rslt.getByte(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
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
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

