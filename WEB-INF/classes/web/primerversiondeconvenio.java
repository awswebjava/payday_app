package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class primerversiondeconvenio extends GXProcedure
{
   public primerversiondeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( primerversiondeconvenio.class ), "" );
   }

   public primerversiondeconvenio( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( short aP0 ,
                          String aP1 )
   {
      primerversiondeconvenio.this.aP2 = new int[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        int[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             int[] aP2 )
   {
      primerversiondeconvenio.this.AV10CliPaiConve = aP0;
      primerversiondeconvenio.this.AV11CliConvenio = aP1;
      primerversiondeconvenio.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV10CliPaiConve) ,
                                           AV11CliConvenio ,
                                           Short.valueOf(A1564CliPaiConve) ,
                                           A1565CliConvenio ,
                                           Integer.valueOf(A1566CliConveVer) ,
                                           Boolean.valueOf(A1639CliConveHab) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P01FR2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV10CliPaiConve), AV11CliConvenio});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1639CliConveHab = P01FR2_A1639CliConveHab[0] ;
         A1566CliConveVer = P01FR2_A1566CliConveVer[0] ;
         n1566CliConveVer = P01FR2_n1566CliConveVer[0] ;
         A1565CliConvenio = P01FR2_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01FR2_A1564CliPaiConve[0] ;
         A3CliCod = P01FR2_A3CliCod[0] ;
         AV9CliCod = A3CliCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = primerversiondeconvenio.this.AV9CliCod;
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
      A1565CliConvenio = "" ;
      P01FR2_A1639CliConveHab = new boolean[] {false} ;
      P01FR2_A1566CliConveVer = new int[1] ;
      P01FR2_n1566CliConveVer = new boolean[] {false} ;
      P01FR2_A1565CliConvenio = new String[] {""} ;
      P01FR2_A1564CliPaiConve = new short[1] ;
      P01FR2_A3CliCod = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.primerversiondeconvenio__default(),
         new Object[] {
             new Object[] {
            P01FR2_A1639CliConveHab, P01FR2_A1566CliConveVer, P01FR2_n1566CliConveVer, P01FR2_A1565CliConvenio, P01FR2_A1564CliPaiConve, P01FR2_A3CliCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10CliPaiConve ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A1566CliConveVer ;
   private int A3CliCod ;
   private String AV11CliConvenio ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private boolean A1639CliConveHab ;
   private boolean n1566CliConveVer ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01FR2_A1639CliConveHab ;
   private int[] P01FR2_A1566CliConveVer ;
   private boolean[] P01FR2_n1566CliConveVer ;
   private String[] P01FR2_A1565CliConvenio ;
   private short[] P01FR2_A1564CliPaiConve ;
   private int[] P01FR2_A3CliCod ;
}

final  class primerversiondeconvenio__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01FR2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV10CliPaiConve ,
                                          String AV11CliConvenio ,
                                          short A1564CliPaiConve ,
                                          String A1565CliConvenio ,
                                          int A1566CliConveVer ,
                                          boolean A1639CliConveHab )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[2];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT CliConveHab, CliConveVer, CliConvenio, CliPaiConve, CliCod FROM ClienteConvenios" ;
      addWhere(sWhereString, "(CliConveVer IS NULL)");
      addWhere(sWhereString, "(CliConveHab = TRUE)");
      if ( ! (0==AV10CliPaiConve) )
      {
         addWhere(sWhereString, "(CliPaiConve = ?)");
      }
      else
      {
         GXv_int1[0] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV11CliConvenio)==0) )
      {
         addWhere(sWhereString, "(CliConvenio = ( ?))");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, CliPaiConve, CliConvenio" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01FR2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , (String)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Boolean) dynConstraints[5]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FR2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[2]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               return;
      }
   }

}

