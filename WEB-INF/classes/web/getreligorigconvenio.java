package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getreligorigconvenio extends GXProcedure
{
   public getreligorigconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getreligorigconvenio.class ), "" );
   }

   public getreligorigconvenio( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              short aP3 ,
                              String[] aP4 ,
                              String[] aP5 ,
                              String[] aP6 ,
                              boolean[] aP7 ,
                              boolean[] aP8 )
   {
      getreligorigconvenio.this.aP9 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        boolean[] aP7 ,
                        boolean[] aP8 ,
                        boolean[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             boolean[] aP7 ,
                             boolean[] aP8 ,
                             boolean[] aP9 )
   {
      getreligorigconvenio.this.AV11CliCod = aP0;
      getreligorigconvenio.this.AV12empcod = aP1;
      getreligorigconvenio.this.AV8LegNumero = aP2;
      getreligorigconvenio.this.AV16PaiCod = aP3;
      getreligorigconvenio.this.aP4 = aP4;
      getreligorigconvenio.this.aP5 = aP5;
      getreligorigconvenio.this.aP6 = aP6;
      getreligorigconvenio.this.aP7 = aP7;
      getreligorigconvenio.this.aP8 = aP8;
      getreligorigconvenio.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01BF2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12empcod), Integer.valueOf(AV8LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A6LegNumero = P01BF2_A6LegNumero[0] ;
         A1EmpCod = P01BF2_A1EmpCod[0] ;
         A3CliCod = P01BF2_A3CliCod[0] ;
         A937LegConveCodigo = P01BF2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P01BF2_n937LegConveCodigo[0] ;
         A1236LegOrigen = P01BF2_A1236LegOrigen[0] ;
         n1236LegOrigen = P01BF2_n1236LegOrigen[0] ;
         A1235LegReligion = P01BF2_A1235LegReligion[0] ;
         n1235LegReligion = P01BF2_n1235LegReligion[0] ;
         AV10ConveCodigo = A937LegConveCodigo ;
         AV14OrigId = A1236LegOrigen ;
         AV13ReligId = A1235LegReligion ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXt_char1 = AV15PaiReligDefault ;
      GXv_char2[0] = GXt_char1 ;
      new web.getpairelig(remoteHandle, context).execute( AV16PaiCod, GXv_char2) ;
      getreligorigconvenio.this.GXt_char1 = GXv_char2[0] ;
      AV15PaiReligDefault = GXt_char1 ;
      if ( (GXutil.strcmp("", AV13ReligId)==0) && ! (GXutil.strcmp("", AV15PaiReligDefault)==0) )
      {
         AV13ReligId = AV15PaiReligDefault ;
      }
      GXv_int3[0] = (short)((byte)((AV18empresaliquidaReligion)?1:0)) ;
      GXv_boolean4[0] = AV19empresaliquidaOrigen ;
      GXv_boolean5[0] = AV20empresaliquidaConvenio ;
      new web.getempreligorigconvenio(remoteHandle, context).execute( AV11CliCod, AV12empcod, AV13ReligId, AV14OrigId, AV10ConveCodigo, GXv_int3, GXv_boolean4, GXv_boolean5) ;
      getreligorigconvenio.this.AV18empresaliquidaReligion = (boolean)((GXv_int3[0]==0)?false:true) ;
      getreligorigconvenio.this.AV19empresaliquidaOrigen = GXv_boolean4[0] ;
      getreligorigconvenio.this.AV20empresaliquidaConvenio = GXv_boolean5[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getreligorigconvenio.this.AV10ConveCodigo;
      this.aP5[0] = getreligorigconvenio.this.AV13ReligId;
      this.aP6[0] = getreligorigconvenio.this.AV14OrigId;
      this.aP7[0] = getreligorigconvenio.this.AV18empresaliquidaReligion;
      this.aP8[0] = getreligorigconvenio.this.AV19empresaliquidaOrigen;
      this.aP9[0] = getreligorigconvenio.this.AV20empresaliquidaConvenio;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10ConveCodigo = "" ;
      AV13ReligId = "" ;
      AV14OrigId = "" ;
      scmdbuf = "" ;
      P01BF2_A6LegNumero = new int[1] ;
      P01BF2_A1EmpCod = new short[1] ;
      P01BF2_A3CliCod = new int[1] ;
      P01BF2_A937LegConveCodigo = new String[] {""} ;
      P01BF2_n937LegConveCodigo = new boolean[] {false} ;
      P01BF2_A1236LegOrigen = new String[] {""} ;
      P01BF2_n1236LegOrigen = new boolean[] {false} ;
      P01BF2_A1235LegReligion = new String[] {""} ;
      P01BF2_n1235LegReligion = new boolean[] {false} ;
      A937LegConveCodigo = "" ;
      A1236LegOrigen = "" ;
      A1235LegReligion = "" ;
      AV15PaiReligDefault = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      GXv_int3 = new short[1] ;
      GXv_boolean4 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getreligorigconvenio__default(),
         new Object[] {
             new Object[] {
            P01BF2_A6LegNumero, P01BF2_A1EmpCod, P01BF2_A3CliCod, P01BF2_A937LegConveCodigo, P01BF2_n937LegConveCodigo, P01BF2_A1236LegOrigen, P01BF2_n1236LegOrigen, P01BF2_A1235LegReligion, P01BF2_n1235LegReligion
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV12empcod ;
   private short AV16PaiCod ;
   private short A1EmpCod ;
   private short GXv_int3[] ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV8LegNumero ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private String AV10ConveCodigo ;
   private String AV13ReligId ;
   private String AV14OrigId ;
   private String scmdbuf ;
   private String A937LegConveCodigo ;
   private String A1236LegOrigen ;
   private String A1235LegReligion ;
   private String AV15PaiReligDefault ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private boolean AV18empresaliquidaReligion ;
   private boolean AV19empresaliquidaOrigen ;
   private boolean AV20empresaliquidaConvenio ;
   private boolean n937LegConveCodigo ;
   private boolean n1236LegOrigen ;
   private boolean n1235LegReligion ;
   private boolean GXv_boolean4[] ;
   private boolean GXv_boolean5[] ;
   private boolean[] aP9 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private boolean[] aP7 ;
   private boolean[] aP8 ;
   private IDataStoreProvider pr_default ;
   private int[] P01BF2_A6LegNumero ;
   private short[] P01BF2_A1EmpCod ;
   private int[] P01BF2_A3CliCod ;
   private String[] P01BF2_A937LegConveCodigo ;
   private boolean[] P01BF2_n937LegConveCodigo ;
   private String[] P01BF2_A1236LegOrigen ;
   private boolean[] P01BF2_n1236LegOrigen ;
   private String[] P01BF2_A1235LegReligion ;
   private boolean[] P01BF2_n1235LegReligion ;
}

final  class getreligorigconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01BF2", "SELECT LegNumero, EmpCod, CliCod, LegConveCodigo, LegOrigen, LegReligion FROM Legajo WHERE CliCod = ? and EmpCod = ? and LegNumero = ? ORDER BY CliCod, EmpCod, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getString(6, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
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

