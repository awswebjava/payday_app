package web ;
import com.genexus.*;

public final  class StructSdtConceptoAFIP implements Cloneable, java.io.Serializable
{
   public StructSdtConceptoAFIP( )
   {
      this( -1, new ModelContext( StructSdtConceptoAFIP.class ));
   }

   public StructSdtConceptoAFIP( int remoteHandle ,
                                 ModelContext context )
   {
      gxTv_SdtConceptoAFIP_Concodpropio = "" ;
      gxTv_SdtConceptoAFIP_Conafipconcepto = "" ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipacont = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont = "" ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = "" ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipregespapo = "" ;
      gxTv_SdtConceptoAFIP_Conafipestado = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipo = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1 = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2 = "" ;
      gxTv_SdtConceptoAFIP_Conafipdesc = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipodef = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def = "" ;
      gxTv_SdtConceptoAFIP_Mode = "" ;
      gxTv_SdtConceptoAFIP_Concodpropio_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipconcepto_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsipacont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipregespapo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipestado_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipo_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipdesc_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafiptipodef_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = "" ;
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(1) ;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   public int getClicod( )
   {
      return gxTv_SdtConceptoAFIP_Clicod ;
   }

   public void setClicod( int value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Clicod = value ;
   }

   public String getConcodpropio( )
   {
      return gxTv_SdtConceptoAFIP_Concodpropio ;
   }

   public void setConcodpropio( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Concodpropio = value ;
   }

   public String getConafipconcepto( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto ;
   }

   public void setConafipconcepto( String value )
   {
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipconcepto = value ;
   }

   public String getConafipmarcarep( )
   {
      return gxTv_SdtConceptoAFIP_Conafipmarcarep ;
   }

   public void setConafipmarcarep( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep = value ;
   }

   public String getConafipsipaapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipaapo ;
   }

   public void setConafipsipaapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo = value ;
   }

   public String getConafipsipacont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipacont ;
   }

   public void setConafipsipacont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsipacont = value ;
   }

   public String getConafipinssjypapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypapo ;
   }

   public void setConafipinssjypapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo = value ;
   }

   public String getConafipinssjypcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypcont ;
   }

   public void setConafipinssjypcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont = value ;
   }

   public String getConafipobrasocapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasocapo ;
   }

   public void setConafipobrasocapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo = value ;
   }

   public String getConafipobrasoccont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasoccont ;
   }

   public void setConafipobrasoccont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont = value ;
   }

   public String getConafipfonsolredapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredapo ;
   }

   public void setConafipfonsolredapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo = value ;
   }

   public String getConafipfonsolredcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredcont ;
   }

   public void setConafipfonsolredcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont = value ;
   }

   public String getConafiprenateaapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateaapo ;
   }

   public void setConafiprenateaapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo = value ;
   }

   public String getConafiprenateacont( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateacont ;
   }

   public void setConafiprenateacont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont = value ;
   }

   public String getConafipasigfamcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipasigfamcont ;
   }

   public void setConafipasigfamcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont = value ;
   }

   public String getConafipfonnacempcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonnacempcont ;
   }

   public void setConafipfonnacempcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont = value ;
   }

   public String getConafipleyrietrabcont( )
   {
      return gxTv_SdtConceptoAFIP_Conafipleyrietrabcont ;
   }

   public void setConafipleyrietrabcont( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont = value ;
   }

   public String getConafipregdifapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregdifapo ;
   }

   public void setConafipregdifapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo = value ;
   }

   public String getConafipregespapo( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregespapo ;
   }

   public void setConafipregespapo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipregespapo = value ;
   }

   public String getConafipestado( )
   {
      return gxTv_SdtConceptoAFIP_Conafipestado ;
   }

   public void setConafipestado( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipestado = value ;
   }

   public String getConafiptipo( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipo ;
   }

   public void setConafiptipo( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiptipo = value ;
   }

   public String getConafipsubt1( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1 ;
   }

   public void setConafipsubt1( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt1 = value ;
   }

   public String getConafipsubt2( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2 ;
   }

   public void setConafipsubt2( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt2 = value ;
   }

   public String getConafipdesc( )
   {
      return gxTv_SdtConceptoAFIP_Conafipdesc ;
   }

   public void setConafipdesc( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipdesc = value ;
   }

   public String getConafiptipodef( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipodef ;
   }

   public void setConafiptipodef( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiptipodef = value ;
   }

   public String getConafipsubt1def( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1def ;
   }

   public void setConafipsubt1def( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def = value ;
   }

   public String getConafipsubt2def( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2def ;
   }

   public void setConafipsubt2def( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def = value ;
   }

   public boolean getConafipliquidado( )
   {
      return gxTv_SdtConceptoAFIP_Conafipliquidado ;
   }

   public void setConafipliquidado( boolean value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipliquidado = value ;
   }

   public String getMode( )
   {
      return gxTv_SdtConceptoAFIP_Mode ;
   }

   public void setMode( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Mode = value ;
   }

   public short getInitialized( )
   {
      return gxTv_SdtConceptoAFIP_Initialized ;
   }

   public void setInitialized( short value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Initialized = value ;
   }

   public int getClicod_Z( )
   {
      return gxTv_SdtConceptoAFIP_Clicod_Z ;
   }

   public void setClicod_Z( int value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Clicod_Z = value ;
   }

   public String getConcodpropio_Z( )
   {
      return gxTv_SdtConceptoAFIP_Concodpropio_Z ;
   }

   public void setConcodpropio_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Concodpropio_Z = value ;
   }

   public String getConafipconcepto_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto_Z ;
   }

   public void setConafipconcepto_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipconcepto_Z = value ;
   }

   public String getConafipmarcarep_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipmarcarep_Z ;
   }

   public void setConafipmarcarep_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipmarcarep_Z = value ;
   }

   public String getConafipsipaapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipaapo_Z ;
   }

   public void setConafipsipaapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsipaapo_Z = value ;
   }

   public String getConafipsipacont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsipacont_Z ;
   }

   public void setConafipsipacont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsipacont_Z = value ;
   }

   public String getConafipinssjypapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z ;
   }

   public void setConafipinssjypapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z = value ;
   }

   public String getConafipinssjypcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z ;
   }

   public void setConafipinssjypcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z = value ;
   }

   public String getConafipobrasocapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z ;
   }

   public void setConafipobrasocapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z = value ;
   }

   public String getConafipobrasoccont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z ;
   }

   public void setConafipobrasoccont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z = value ;
   }

   public String getConafipfonsolredapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z ;
   }

   public void setConafipfonsolredapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z = value ;
   }

   public String getConafipfonsolredcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z ;
   }

   public void setConafipfonsolredcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z = value ;
   }

   public String getConafiprenateaapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z ;
   }

   public void setConafiprenateaapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z = value ;
   }

   public String getConafiprenateacont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiprenateacont_Z ;
   }

   public void setConafiprenateacont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiprenateacont_Z = value ;
   }

   public String getConafipasigfamcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z ;
   }

   public void setConafipasigfamcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z = value ;
   }

   public String getConafipfonnacempcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z ;
   }

   public void setConafipfonnacempcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z = value ;
   }

   public String getConafipleyrietrabcont_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z ;
   }

   public void setConafipleyrietrabcont_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z = value ;
   }

   public String getConafipregdifapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregdifapo_Z ;
   }

   public void setConafipregdifapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipregdifapo_Z = value ;
   }

   public String getConafipregespapo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipregespapo_Z ;
   }

   public void setConafipregespapo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipregespapo_Z = value ;
   }

   public String getConafipestado_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipestado_Z ;
   }

   public void setConafipestado_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipestado_Z = value ;
   }

   public String getConafiptipo_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipo_Z ;
   }

   public void setConafiptipo_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiptipo_Z = value ;
   }

   public String getConafipsubt1_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1_Z ;
   }

   public void setConafipsubt1_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt1_Z = value ;
   }

   public String getConafipsubt2_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2_Z ;
   }

   public void setConafipsubt2_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt2_Z = value ;
   }

   public String getConafipdesc_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipdesc_Z ;
   }

   public void setConafipdesc_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipdesc_Z = value ;
   }

   public String getConafiptipodef_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafiptipodef_Z ;
   }

   public void setConafiptipodef_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafiptipodef_Z = value ;
   }

   public String getConafipsubt1def_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt1def_Z ;
   }

   public void setConafipsubt1def_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt1def_Z = value ;
   }

   public String getConafipsubt2def_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipsubt2def_Z ;
   }

   public void setConafipsubt2def_Z( String value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipsubt2def_Z = value ;
   }

   public boolean getConafipliquidado_Z( )
   {
      return gxTv_SdtConceptoAFIP_Conafipliquidado_Z ;
   }

   public void setConafipliquidado_Z( boolean value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipliquidado_Z = value ;
   }

   public byte getConafipconcepto_N( )
   {
      return gxTv_SdtConceptoAFIP_Conafipconcepto_N ;
   }

   public void setConafipconcepto_N( byte value )
   {
      gxTv_SdtConceptoAFIP_N = (byte)(0) ;
      gxTv_SdtConceptoAFIP_Conafipconcepto_N = value ;
   }

   protected byte gxTv_SdtConceptoAFIP_Conafipconcepto_N ;
   private byte gxTv_SdtConceptoAFIP_N ;
   protected short gxTv_SdtConceptoAFIP_Initialized ;
   protected int gxTv_SdtConceptoAFIP_Clicod ;
   protected int gxTv_SdtConceptoAFIP_Clicod_Z ;
   protected String gxTv_SdtConceptoAFIP_Concodpropio ;
   protected String gxTv_SdtConceptoAFIP_Conafipconcepto ;
   protected String gxTv_SdtConceptoAFIP_Conafipmarcarep ;
   protected String gxTv_SdtConceptoAFIP_Conafipsipaapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipsipacont ;
   protected String gxTv_SdtConceptoAFIP_Conafipinssjypapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipinssjypcont ;
   protected String gxTv_SdtConceptoAFIP_Conafipobrasocapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipobrasoccont ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonsolredapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonsolredcont ;
   protected String gxTv_SdtConceptoAFIP_Conafiprenateaapo ;
   protected String gxTv_SdtConceptoAFIP_Conafiprenateacont ;
   protected String gxTv_SdtConceptoAFIP_Conafipasigfamcont ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonnacempcont ;
   protected String gxTv_SdtConceptoAFIP_Conafipleyrietrabcont ;
   protected String gxTv_SdtConceptoAFIP_Conafipregdifapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipregespapo ;
   protected String gxTv_SdtConceptoAFIP_Conafipestado ;
   protected String gxTv_SdtConceptoAFIP_Conafiptipo ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt1 ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt2 ;
   protected String gxTv_SdtConceptoAFIP_Conafiptipodef ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt1def ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt2def ;
   protected String gxTv_SdtConceptoAFIP_Mode ;
   protected String gxTv_SdtConceptoAFIP_Concodpropio_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipconcepto_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipmarcarep_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsipaapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsipacont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipinssjypapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipinssjypcont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipobrasocapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipobrasoccont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonsolredapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonsolredcont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafiprenateaapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafiprenateacont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipasigfamcont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipfonnacempcont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipleyrietrabcont_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipregdifapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipregespapo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipestado_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafiptipo_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt1_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt2_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafiptipodef_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt1def_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipsubt2def_Z ;
   protected boolean gxTv_SdtConceptoAFIP_Conafipliquidado ;
   protected boolean gxTv_SdtConceptoAFIP_Conafipliquidado_Z ;
   protected String gxTv_SdtConceptoAFIP_Conafipdesc ;
   protected String gxTv_SdtConceptoAFIP_Conafipdesc_Z ;
}

