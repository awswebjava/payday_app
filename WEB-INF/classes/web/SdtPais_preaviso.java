package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_preaviso extends GxSilentTrnSdt
{
   public SdtPais_preaviso( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_preaviso.class));
   }

   public SdtPais_preaviso( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_preaviso");
      initialize( remoteHandle) ;
   }

   public SdtPais_preaviso( int remoteHandle ,
                            StructSdtPais_preaviso struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_preaviso( )
   {
      super( new ModelContext(SdtPais_preaviso.class), "SdtPais_preaviso");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiAntMayCant", byte.class}, new Object[]{"PaiAntMayDur", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "preaviso");
      metadata.set("BT", "Paispreaviso");
      metadata.set("PK", "[ \"PaiAntMayCant\",\"PaiAntMayDur\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiAntMayCant") )
            {
               gxTv_SdtPais_preaviso_Paiantmaycant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiAntMayDur") )
            {
               gxTv_SdtPais_preaviso_Paiantmaydur = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPreAviCant") )
            {
               gxTv_SdtPais_preaviso_Paipreavicant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPreAviDur") )
            {
               gxTv_SdtPais_preaviso_Paipreavidur = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_preaviso_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_preaviso_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_preaviso_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiAntMayCant_Z") )
            {
               gxTv_SdtPais_preaviso_Paiantmaycant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiAntMayDur_Z") )
            {
               gxTv_SdtPais_preaviso_Paiantmaydur_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPreAviCant_Z") )
            {
               gxTv_SdtPais_preaviso_Paipreavicant_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiPreAviDur_Z") )
            {
               gxTv_SdtPais_preaviso_Paipreavidur_Z = oReader.getValue() ;
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
         sName = "Pais.preaviso" ;
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
      oWriter.writeElement("PaiAntMayCant", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Paiantmaycant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiAntMayDur", gxTv_SdtPais_preaviso_Paiantmaydur);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPreAviCant", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Paipreavicant, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiPreAviDur", gxTv_SdtPais_preaviso_Paipreavidur);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_preaviso_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiAntMayCant_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Paiantmaycant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiAntMayDur_Z", gxTv_SdtPais_preaviso_Paiantmaydur_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPreAviCant_Z", GXutil.trim( GXutil.str( gxTv_SdtPais_preaviso_Paipreavicant_Z, 2, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiPreAviDur_Z", gxTv_SdtPais_preaviso_Paipreavidur_Z);
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
      AddObjectProperty("PaiAntMayCant", gxTv_SdtPais_preaviso_Paiantmaycant, false, includeNonInitialized);
      AddObjectProperty("PaiAntMayDur", gxTv_SdtPais_preaviso_Paiantmaydur, false, includeNonInitialized);
      AddObjectProperty("PaiPreAviCant", gxTv_SdtPais_preaviso_Paipreavicant, false, includeNonInitialized);
      AddObjectProperty("PaiPreAviDur", gxTv_SdtPais_preaviso_Paipreavidur, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_preaviso_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_preaviso_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_preaviso_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiAntMayCant_Z", gxTv_SdtPais_preaviso_Paiantmaycant_Z, false, includeNonInitialized);
         AddObjectProperty("PaiAntMayDur_Z", gxTv_SdtPais_preaviso_Paiantmaydur_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPreAviCant_Z", gxTv_SdtPais_preaviso_Paipreavicant_Z, false, includeNonInitialized);
         AddObjectProperty("PaiPreAviDur_Z", gxTv_SdtPais_preaviso_Paipreavidur_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_preaviso sdt )
   {
      if ( sdt.IsDirty("PaiAntMayCant") )
      {
         gxTv_SdtPais_preaviso_N = (byte)(0) ;
         gxTv_SdtPais_preaviso_Paiantmaycant = sdt.getgxTv_SdtPais_preaviso_Paiantmaycant() ;
      }
      if ( sdt.IsDirty("PaiAntMayDur") )
      {
         gxTv_SdtPais_preaviso_N = (byte)(0) ;
         gxTv_SdtPais_preaviso_Paiantmaydur = sdt.getgxTv_SdtPais_preaviso_Paiantmaydur() ;
      }
      if ( sdt.IsDirty("PaiPreAviCant") )
      {
         gxTv_SdtPais_preaviso_N = (byte)(0) ;
         gxTv_SdtPais_preaviso_Paipreavicant = sdt.getgxTv_SdtPais_preaviso_Paipreavicant() ;
      }
      if ( sdt.IsDirty("PaiPreAviDur") )
      {
         gxTv_SdtPais_preaviso_N = (byte)(0) ;
         gxTv_SdtPais_preaviso_Paipreavidur = sdt.getgxTv_SdtPais_preaviso_Paipreavidur() ;
      }
   }

   public byte getgxTv_SdtPais_preaviso_Paiantmaycant( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaycant ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaycant( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paiantmaycant");
      gxTv_SdtPais_preaviso_Paiantmaycant = value ;
   }

   public String getgxTv_SdtPais_preaviso_Paiantmaydur( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaydur ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaydur( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paiantmaydur");
      gxTv_SdtPais_preaviso_Paiantmaydur = value ;
   }

   public byte getgxTv_SdtPais_preaviso_Paipreavicant( )
   {
      return gxTv_SdtPais_preaviso_Paipreavicant ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavicant( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paipreavicant");
      gxTv_SdtPais_preaviso_Paipreavicant = value ;
   }

   public String getgxTv_SdtPais_preaviso_Paipreavidur( )
   {
      return gxTv_SdtPais_preaviso_Paipreavidur ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavidur( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paipreavidur");
      gxTv_SdtPais_preaviso_Paipreavidur = value ;
   }

   public String getgxTv_SdtPais_preaviso_Mode( )
   {
      return gxTv_SdtPais_preaviso_Mode ;
   }

   public void setgxTv_SdtPais_preaviso_Mode( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_preaviso_Mode = value ;
   }

   public void setgxTv_SdtPais_preaviso_Mode_SetNull( )
   {
      gxTv_SdtPais_preaviso_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_preaviso_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_preaviso_Modified( )
   {
      return gxTv_SdtPais_preaviso_Modified ;
   }

   public void setgxTv_SdtPais_preaviso_Modified( short value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_preaviso_Modified = value ;
   }

   public void setgxTv_SdtPais_preaviso_Modified_SetNull( )
   {
      gxTv_SdtPais_preaviso_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_preaviso_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_preaviso_Initialized( )
   {
      return gxTv_SdtPais_preaviso_Initialized ;
   }

   public void setgxTv_SdtPais_preaviso_Initialized( short value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_preaviso_Initialized = value ;
   }

   public void setgxTv_SdtPais_preaviso_Initialized_SetNull( )
   {
      gxTv_SdtPais_preaviso_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_preaviso_Initialized_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_preaviso_Paiantmaycant_Z( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaycant_Z ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaycant_Z( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paiantmaycant_Z");
      gxTv_SdtPais_preaviso_Paiantmaycant_Z = value ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaycant_Z_SetNull( )
   {
      gxTv_SdtPais_preaviso_Paiantmaycant_Z = (byte)(0) ;
      SetDirty("Paiantmaycant_Z");
   }

   public boolean getgxTv_SdtPais_preaviso_Paiantmaycant_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_preaviso_Paiantmaydur_Z( )
   {
      return gxTv_SdtPais_preaviso_Paiantmaydur_Z ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaydur_Z( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paiantmaydur_Z");
      gxTv_SdtPais_preaviso_Paiantmaydur_Z = value ;
   }

   public void setgxTv_SdtPais_preaviso_Paiantmaydur_Z_SetNull( )
   {
      gxTv_SdtPais_preaviso_Paiantmaydur_Z = "" ;
      SetDirty("Paiantmaydur_Z");
   }

   public boolean getgxTv_SdtPais_preaviso_Paiantmaydur_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_preaviso_Paipreavicant_Z( )
   {
      return gxTv_SdtPais_preaviso_Paipreavicant_Z ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavicant_Z( byte value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paipreavicant_Z");
      gxTv_SdtPais_preaviso_Paipreavicant_Z = value ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavicant_Z_SetNull( )
   {
      gxTv_SdtPais_preaviso_Paipreavicant_Z = (byte)(0) ;
      SetDirty("Paipreavicant_Z");
   }

   public boolean getgxTv_SdtPais_preaviso_Paipreavicant_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_preaviso_Paipreavidur_Z( )
   {
      return gxTv_SdtPais_preaviso_Paipreavidur_Z ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavidur_Z( String value )
   {
      gxTv_SdtPais_preaviso_N = (byte)(0) ;
      gxTv_SdtPais_preaviso_Modified = (short)(1) ;
      SetDirty("Paipreavidur_Z");
      gxTv_SdtPais_preaviso_Paipreavidur_Z = value ;
   }

   public void setgxTv_SdtPais_preaviso_Paipreavidur_Z_SetNull( )
   {
      gxTv_SdtPais_preaviso_Paipreavidur_Z = "" ;
      SetDirty("Paipreavidur_Z");
   }

   public boolean getgxTv_SdtPais_preaviso_Paipreavidur_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_preaviso_N = (byte)(1) ;
      gxTv_SdtPais_preaviso_Paiantmaydur = "" ;
      gxTv_SdtPais_preaviso_Paipreavidur = "" ;
      gxTv_SdtPais_preaviso_Mode = "" ;
      gxTv_SdtPais_preaviso_Paiantmaydur_Z = "" ;
      gxTv_SdtPais_preaviso_Paipreavidur_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_preaviso_N ;
   }

   public web.SdtPais_preaviso Clone( )
   {
      return (web.SdtPais_preaviso)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_preaviso struct )
   {
      setgxTv_SdtPais_preaviso_Paiantmaycant(struct.getPaiantmaycant());
      setgxTv_SdtPais_preaviso_Paiantmaydur(struct.getPaiantmaydur());
      setgxTv_SdtPais_preaviso_Paipreavicant(struct.getPaipreavicant());
      setgxTv_SdtPais_preaviso_Paipreavidur(struct.getPaipreavidur());
      setgxTv_SdtPais_preaviso_Mode(struct.getMode());
      setgxTv_SdtPais_preaviso_Modified(struct.getModified());
      setgxTv_SdtPais_preaviso_Initialized(struct.getInitialized());
      setgxTv_SdtPais_preaviso_Paiantmaycant_Z(struct.getPaiantmaycant_Z());
      setgxTv_SdtPais_preaviso_Paiantmaydur_Z(struct.getPaiantmaydur_Z());
      setgxTv_SdtPais_preaviso_Paipreavicant_Z(struct.getPaipreavicant_Z());
      setgxTv_SdtPais_preaviso_Paipreavidur_Z(struct.getPaipreavidur_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_preaviso getStruct( )
   {
      web.StructSdtPais_preaviso struct = new web.StructSdtPais_preaviso ();
      struct.setPaiantmaycant(getgxTv_SdtPais_preaviso_Paiantmaycant());
      struct.setPaiantmaydur(getgxTv_SdtPais_preaviso_Paiantmaydur());
      struct.setPaipreavicant(getgxTv_SdtPais_preaviso_Paipreavicant());
      struct.setPaipreavidur(getgxTv_SdtPais_preaviso_Paipreavidur());
      struct.setMode(getgxTv_SdtPais_preaviso_Mode());
      struct.setModified(getgxTv_SdtPais_preaviso_Modified());
      struct.setInitialized(getgxTv_SdtPais_preaviso_Initialized());
      struct.setPaiantmaycant_Z(getgxTv_SdtPais_preaviso_Paiantmaycant_Z());
      struct.setPaiantmaydur_Z(getgxTv_SdtPais_preaviso_Paiantmaydur_Z());
      struct.setPaipreavicant_Z(getgxTv_SdtPais_preaviso_Paipreavicant_Z());
      struct.setPaipreavidur_Z(getgxTv_SdtPais_preaviso_Paipreavidur_Z());
      return struct ;
   }

   private byte gxTv_SdtPais_preaviso_Paiantmaycant ;
   private byte gxTv_SdtPais_preaviso_N ;
   private byte gxTv_SdtPais_preaviso_Paipreavicant ;
   private byte gxTv_SdtPais_preaviso_Paiantmaycant_Z ;
   private byte gxTv_SdtPais_preaviso_Paipreavicant_Z ;
   private short gxTv_SdtPais_preaviso_Modified ;
   private short gxTv_SdtPais_preaviso_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtPais_preaviso_Paiantmaydur ;
   private String gxTv_SdtPais_preaviso_Paipreavidur ;
   private String gxTv_SdtPais_preaviso_Mode ;
   private String gxTv_SdtPais_preaviso_Paiantmaydur_Z ;
   private String gxTv_SdtPais_preaviso_Paipreavidur_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

