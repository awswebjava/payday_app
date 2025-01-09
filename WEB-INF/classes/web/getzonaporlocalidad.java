package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getzonaporlocalidad extends GXProcedure
{
   public getzonaporlocalidad( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getzonaporlocalidad.class ), "" );
   }

   public getzonaporlocalidad( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( short aP0 ,
                             short aP1 ,
                             short aP2 )
   {
      getzonaporlocalidad.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        short aP1 ,
                        short aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             short aP1 ,
                             short aP2 ,
                             String[] aP3 )
   {
      getzonaporlocalidad.this.AV8PaiCod = aP0;
      getzonaporlocalidad.this.AV9ProvCod = aP1;
      getzonaporlocalidad.this.AV10LocCod = aP2;
      getzonaporlocalidad.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Short.valueOf(AV10LocCod) ,
                                           Short.valueOf(A48LocCod) ,
                                           A2207LocaZona ,
                                           Short.valueOf(AV8PaiCod) ,
                                           Short.valueOf(AV9ProvCod) ,
                                           Short.valueOf(A46PaiCod) ,
                                           Short.valueOf(A47ProvCod) } ,
                                           new int[]{
                                           TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P02562 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8PaiCod), Short.valueOf(AV9ProvCod), Short.valueOf(AV10LocCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2207LocaZona = P02562_A2207LocaZona[0] ;
         n2207LocaZona = P02562_n2207LocaZona[0] ;
         A48LocCod = P02562_A48LocCod[0] ;
         A47ProvCod = P02562_A47ProvCod[0] ;
         A46PaiCod = P02562_A46PaiCod[0] ;
         AV11LocaZona = A2207LocaZona ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&PaiCod: ", "")+GXutil.trim( GXutil.str( AV8PaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&ProvCod: ", "")+GXutil.trim( GXutil.str( AV9ProvCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&LocCod: ", "")+GXutil.trim( GXutil.str( AV10LocCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV15Pgmname, httpContext.getMessage( "&LocaZona: ", "")+GXutil.trim( AV11LocaZona)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getzonaporlocalidad.this.AV11LocaZona;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11LocaZona = "" ;
      scmdbuf = "" ;
      A2207LocaZona = "" ;
      P02562_A2207LocaZona = new String[] {""} ;
      P02562_n2207LocaZona = new boolean[] {false} ;
      P02562_A48LocCod = new short[1] ;
      P02562_A47ProvCod = new short[1] ;
      P02562_A46PaiCod = new short[1] ;
      AV15Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getzonaporlocalidad__default(),
         new Object[] {
             new Object[] {
            P02562_A2207LocaZona, P02562_n2207LocaZona, P02562_A48LocCod, P02562_A47ProvCod, P02562_A46PaiCod
            }
         }
      );
      AV15Pgmname = "getZonaPorLocalidad" ;
      /* GeneXus formulas. */
      AV15Pgmname = "getZonaPorLocalidad" ;
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short AV9ProvCod ;
   private short AV10LocCod ;
   private short A48LocCod ;
   private short A46PaiCod ;
   private short A47ProvCod ;
   private short Gx_err ;
   private String AV11LocaZona ;
   private String scmdbuf ;
   private String A2207LocaZona ;
   private String AV15Pgmname ;
   private boolean n2207LocaZona ;
   private String[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P02562_A2207LocaZona ;
   private boolean[] P02562_n2207LocaZona ;
   private short[] P02562_A48LocCod ;
   private short[] P02562_A47ProvCod ;
   private short[] P02562_A46PaiCod ;
}

final  class getzonaporlocalidad__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02562( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          short AV10LocCod ,
                                          short A48LocCod ,
                                          String A2207LocaZona ,
                                          short AV8PaiCod ,
                                          short AV9ProvCod ,
                                          short A46PaiCod ,
                                          short A47ProvCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[3];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT LocaZona, LocCod, ProvCod, PaiCod FROM Localidad" ;
      addWhere(sWhereString, "(PaiCod = ? and ProvCod = ?)");
      addWhere(sWhereString, "(Not (char_length(trim(trailing ' ' from LocaZona))=0))");
      if ( ! (0==AV10LocCod) )
      {
         addWhere(sWhereString, "(LocCod = ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod, ProvCod" ;
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
                  return conditional_P02562(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).shortValue() , ((Number) dynConstraints[1]).shortValue() , (String)dynConstraints[2] , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02562", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[2])[0] = rslt.getShort(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
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
                  stmt.setShort(sIdx, ((Number) parms[3]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

