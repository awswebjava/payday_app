package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getreligyorignombres extends GXProcedure
{
   public getreligyorignombres( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getreligyorignombres.class ), "" );
   }

   public getreligyorignombres( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             String aP1 ,
                             String[] aP2 )
   {
      getreligyorignombres.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      getreligyorignombres.this.AV8PaiCod = aP0;
      getreligyorignombres.this.AV9FerId = aP1;
      getreligyorignombres.this.aP2 = aP2;
      getreligyorignombres.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01MM2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), AV9FerId});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1223FerId = P01MM2_A1223FerId[0] ;
         A46PaiCod = P01MM2_A46PaiCod[0] ;
         A1230FerReligId = P01MM2_A1230FerReligId[0] ;
         n1230FerReligId = P01MM2_n1230FerReligId[0] ;
         A1232FerOrigId = P01MM2_A1232FerOrigId[0] ;
         n1232FerOrigId = P01MM2_n1232FerOrigId[0] ;
         AV10FerReligId = A1230FerReligId ;
         AV11FerOrigId = A1232FerOrigId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P01MM3 */
      pr_default.execute(1, new Object[] {AV10FerReligId});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1229ReligId = P01MM3_A1229ReligId[0] ;
         A1283ReligNombre = P01MM3_A1283ReligNombre[0] ;
         AV13ReligNombre = A1283ReligNombre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      /* Using cursor P01MM4 */
      pr_default.execute(2, new Object[] {AV11FerOrigId});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A1231OrigId = P01MM4_A1231OrigId[0] ;
         A1284OrigNombre = P01MM4_A1284OrigNombre[0] ;
         AV14OrigNombre = A1284OrigNombre ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getreligyorignombres.this.AV13ReligNombre;
      this.aP3[0] = getreligyorignombres.this.AV14OrigNombre;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ReligNombre = "" ;
      AV14OrigNombre = "" ;
      scmdbuf = "" ;
      P01MM2_A1223FerId = new String[] {""} ;
      P01MM2_A46PaiCod = new short[1] ;
      P01MM2_A1230FerReligId = new String[] {""} ;
      P01MM2_n1230FerReligId = new boolean[] {false} ;
      P01MM2_A1232FerOrigId = new String[] {""} ;
      P01MM2_n1232FerOrigId = new boolean[] {false} ;
      A1223FerId = "" ;
      A1230FerReligId = "" ;
      A1232FerOrigId = "" ;
      AV10FerReligId = "" ;
      AV11FerOrigId = "" ;
      P01MM3_A1229ReligId = new String[] {""} ;
      P01MM3_A1283ReligNombre = new String[] {""} ;
      A1229ReligId = "" ;
      A1283ReligNombre = "" ;
      P01MM4_A1231OrigId = new String[] {""} ;
      P01MM4_A1284OrigNombre = new String[] {""} ;
      A1231OrigId = "" ;
      A1284OrigNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getreligyorignombres__default(),
         new Object[] {
             new Object[] {
            P01MM2_A1223FerId, P01MM2_A46PaiCod, P01MM2_A1230FerReligId, P01MM2_n1230FerReligId, P01MM2_A1232FerOrigId, P01MM2_n1232FerOrigId
            }
            , new Object[] {
            P01MM3_A1229ReligId, P01MM3_A1283ReligNombre
            }
            , new Object[] {
            P01MM4_A1231OrigId, P01MM4_A1284OrigNombre
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private String AV9FerId ;
   private String scmdbuf ;
   private String A1223FerId ;
   private String A1230FerReligId ;
   private String A1232FerOrigId ;
   private String AV10FerReligId ;
   private String AV11FerOrigId ;
   private String A1229ReligId ;
   private String A1231OrigId ;
   private boolean n1230FerReligId ;
   private boolean n1232FerOrigId ;
   private String AV13ReligNombre ;
   private String AV14OrigNombre ;
   private String A1283ReligNombre ;
   private String A1284OrigNombre ;
   private String[] aP3 ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P01MM2_A1223FerId ;
   private short[] P01MM2_A46PaiCod ;
   private String[] P01MM2_A1230FerReligId ;
   private boolean[] P01MM2_n1230FerReligId ;
   private String[] P01MM2_A1232FerOrigId ;
   private boolean[] P01MM2_n1232FerOrigId ;
   private String[] P01MM3_A1229ReligId ;
   private String[] P01MM3_A1283ReligNombre ;
   private String[] P01MM4_A1231OrigId ;
   private String[] P01MM4_A1284OrigNombre ;
}

final  class getreligyorignombres__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01MM2", "SELECT FerId, PaiCod, FerReligId, FerOrigId FROM feriado WHERE PaiCod = ? and FerId = ( ?) ORDER BY PaiCod, FerId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01MM3", "SELECT ReligId, ReligNombre FROM Religion WHERE ReligId = ( ?) ORDER BY ReligId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01MM4", "SELECT OrigId, OrigNombre FROM Origen WHERE OrigId = ( ?) ORDER BY OrigId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
               stmt.setString(2, (String)parms[1], 40);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               return;
      }
   }

}

