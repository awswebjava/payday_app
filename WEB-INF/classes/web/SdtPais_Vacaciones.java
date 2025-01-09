package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_Vacaciones extends GxSilentTrnSdt
{
   public SdtPais_Vacaciones( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_Vacaciones.class));
   }

   public SdtPais_Vacaciones( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_Vacaciones");
      initialize( remoteHandle) ;
   }

   public SdtPais_Vacaciones( int remoteHandle ,
                              StructSdtPais_Vacaciones struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_Vacaciones( )
   {
      super( new ModelContext(SdtPais_Vacaciones.class), "SdtPais_Vacaciones");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"PaiVacDesAnt", byte.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Vacaciones");
      metadata.set("BT", "PaisVacaciones");
      metadata.set("PK", "[ \"PaiVacDesAnt\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacDesAnt") )
            {
               gxTv_SdtPais_Vacaciones_Paivacdesant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacHasAnt") )
            {
               gxTv_SdtPais_Vacaciones_Paivachasant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacDias") )
            {
               gxTv_SdtPais_Vacaciones_Paivacdias = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_Vacaciones_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_Vacaciones_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_Vacaciones_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacDesAnt_Z") )
            {
               gxTv_SdtPais_Vacaciones_Paivacdesant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacHasAnt_Z") )
            {
               gxTv_SdtPais_Vacaciones_Paivachasant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiVacDias_Z") )
            {
               gxTv_SdtPais_Vacaciones_Paivacdias_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "Pais.Vacaciones" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("PaiVacDesAnt", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivacdesant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiVacHasAnt", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivachasant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiVacDias", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivacdias, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_Vacaciones_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiVacDesAnt_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivacdesant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiVacHasAnt_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivachasant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiVacDias_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_Vacaciones_Paivacdias_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("PaiVacDesAnt", gxTv_SdtPais_Vacaciones_Paivacdesant, false, includeNonInitialized);
      AddObjectProperty("PaiVacHasAnt", gxTv_SdtPais_Vacaciones_Paivachasant, false, includeNonInitialized);
      AddObjectProperty("PaiVacDias", gxTv_SdtPais_Vacaciones_Paivacdias, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_Vacaciones_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_Vacaciones_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_Vacaciones_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiVacDesAnt_Z", gxTv_SdtPais_Vacaciones_Paivacdesant_Z, false, includeNonInitialized);
         AddObjectProperty("PaiVacHasAnt_Z", gxTv_SdtPais_Vacaciones_Paivachasant_Z, false, includeNonInitialized);
         AddObjectProperty("PaiVacDias_Z", gxTv_SdtPais_Vacaciones_Paivacdias_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_Vacaciones sdt )
   {
      if ( sdt.IsDirty("PaiVacDesAnt") )
      {
         gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
         gxTv_SdtPais_Vacaciones_Paivacdesant = sdt.getgxTv_SdtPais_Vacaciones_Paivacdesant() ;
      }
      if ( sdt.IsDirty("PaiVacHasAnt") )
      {
         gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
         gxTv_SdtPais_Vacaciones_Paivachasant = sdt.getgxTv_SdtPais_Vacaciones_Paivachasant() ;
      }
      if ( sdt.IsDirty("PaiVacDias") )
      {
         gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
         gxTv_SdtPais_Vacaciones_Paivacdias = sdt.getgxTv_SdtPais_Vacaciones_Paivacdias() ;
      }
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivacdesant( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdesant ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdesant( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivacdesant");
      gxTv_SdtPais_Vacaciones_Paivacdesant = value ;
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivachasant( )
   {
      return gxTv_SdtPais_Vacaciones_Paivachasant ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivachasant( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivachasant");
      gxTv_SdtPais_Vacaciones_Paivachasant = value ;
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivacdias( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdias ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdias( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivacdias");
      gxTv_SdtPais_Vacaciones_Paivacdias = value ;
   }

   public String getgxTv_SdtPais_Vacaciones_Mode( )
   {
      return gxTv_SdtPais_Vacaciones_Mode ;
   }

   public void setgxTv_SdtPais_Vacaciones_Mode( String value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_Vacaciones_Mode = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Mode_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Vacaciones_Modified( )
   {
      return gxTv_SdtPais_Vacaciones_Modified ;
   }

   public void setgxTv_SdtPais_Vacaciones_Modified( short value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_Vacaciones_Modified = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Modified_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_Vacaciones_Initialized( )
   {
      return gxTv_SdtPais_Vacaciones_Initialized ;
   }

   public void setgxTv_SdtPais_Vacaciones_Initialized( short value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_Vacaciones_Initialized = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Initialized_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Initialized_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivacdesant_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdesant_Z ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdesant_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivacdesant_Z");
      gxTv_SdtPais_Vacaciones_Paivacdesant_Z = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdesant_Z_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Paivacdesant_Z = (byte)(0) ;
      SetDirty("Paivacdesant_Z");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Paivacdesant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivachasant_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivachasant_Z ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivachasant_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivachasant_Z");
      gxTv_SdtPais_Vacaciones_Paivachasant_Z = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivachasant_Z_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Paivachasant_Z = (byte)(0) ;
      SetDirty("Paivachasant_Z");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Paivachasant_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_Vacaciones_Paivacdias_Z( )
   {
      return gxTv_SdtPais_Vacaciones_Paivacdias_Z ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdias_Z( byte value )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(0) ;
      gxTv_SdtPais_Vacaciones_Modified = (short)(1) ;
      SetDirty("Paivacdias_Z");
      gxTv_SdtPais_Vacaciones_Paivacdias_Z = value ;
   }

   public void setgxTv_SdtPais_Vacaciones_Paivacdias_Z_SetNull( )
   {
      gxTv_SdtPais_Vacaciones_Paivacdias_Z = (byte)(0) ;
      SetDirty("Paivacdias_Z");
   }

   public boolean getgxTv_SdtPais_Vacaciones_Paivacdias_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_Vacaciones_N = (byte)(1) ;
      gxTv_SdtPais_Vacaciones_Mode = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_Vacaciones_N ;
   }

   public web.SdtPais_Vacaciones Clone( )
   {
      return (web.SdtPais_Vacaciones)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_Vacaciones struct )
   {
      setgxTv_SdtPais_Vacaciones_Paivacdesant(struct.getPaivacdesant());
      setgxTv_SdtPais_Vacaciones_Paivachasant(struct.getPaivachasant());
      setgxTv_SdtPais_Vacaciones_Paivacdias(struct.getPaivacdias());
      setgxTv_SdtPais_Vacaciones_Mode(struct.getMode());
      setgxTv_SdtPais_Vacaciones_Modified(struct.getModified());
      setgxTv_SdtPais_Vacaciones_Initialized(struct.getInitialized());
      setgxTv_SdtPais_Vacaciones_Paivacdesant_Z(struct.getPaivacdesant_Z());
      setgxTv_SdtPais_Vacaciones_Paivachasant_Z(struct.getPaivachasant_Z());
      setgxTv_SdtPais_Vacaciones_Paivacdias_Z(struct.getPaivacdias_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_Vacaciones getStruct( )
   {
      web.StructSdtPais_Vacaciones struct = new web.StructSdtPais_Vacaciones ();
      struct.setPaivacdesant(getgxTv_SdtPais_Vacaciones_Paivacdesant());
      struct.setPaivachasant(getgxTv_SdtPais_Vacaciones_Paivachasant());
      struct.setPaivacdias(getgxTv_SdtPais_Vacaciones_Paivacdias());
      struct.setMode(getgxTv_SdtPais_Vacaciones_Mode());
      struct.setModified(getgxTv_SdtPais_Vacaciones_Modified());
      struct.setInitialized(getgxTv_SdtPais_Vacaciones_Initialized());
      struct.setPaivacdesant_Z(getgxTv_SdtPais_Vacaciones_Paivacdesant_Z());
      struct.setPaivachasant_Z(getgxTv_SdtPais_Vacaciones_Paivachasant_Z());
      struct.setPaivacdias_Z(getgxTv_SdtPais_Vacaciones_Paivacdias_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_Vacaciones_Paivacdesant ;
   private byte gxTv_SdtPais_Vacaciones_N ;
   private byte gxTv_SdtPais_Vacaciones_Paivachasant ;
   private byte gxTv_SdtPais_Vacaciones_Paivacdias ;
   private byte gxTv_SdtPais_Vacaciones_Paivacdesant_Z ;
   private byte gxTv_SdtPais_Vacaciones_Paivachasant_Z ;
   private byte gxTv_SdtPais_Vacaciones_Paivacdias_Z ;
   private short gxTv_SdtPais_Vacaciones_Modified ;
   private short gxTv_SdtPais_Vacaciones_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_Vacaciones_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

