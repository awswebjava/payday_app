package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconcepto_old extends GxUserType
{
   public Sdtconcepto_old( )
   {
      this(  new ModelContext(Sdtconcepto_old.class));
   }

   public Sdtconcepto_old( ModelContext context )
   {
      super( context, "Sdtconcepto_old");
   }

   public Sdtconcepto_old( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "Sdtconcepto_old");
   }

   public Sdtconcepto_old( StructSdtconcepto_old struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLic") )
            {
               gxTv_Sdtconcepto_old_Conbaselic = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLicProm") )
            {
               gxTv_Sdtconcepto_old_Conbaselicprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFer") )
            {
               gxTv_Sdtconcepto_old_Conbasefer = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFerProm") )
            {
               gxTv_Sdtconcepto_old_Conbaseferprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExt") )
            {
               gxTv_Sdtconcepto_old_Conbasehorext = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExtProm") )
            {
               gxTv_Sdtconcepto_old_Conbasehorextprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBasePres") )
            {
               gxTv_Sdtconcepto_old_Conbasepres = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAnt") )
            {
               gxTv_Sdtconcepto_old_Conbaseant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseOSDif") )
            {
               gxTv_Sdtconcepto_old_Conbaseosdif = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_Sdtconcepto_old_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAus") )
            {
               gxTv_Sdtconcepto_old_Conbaseaus = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAusProm") )
            {
               gxTv_Sdtconcepto_old_Conbaseausprom = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "concepto_old" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("ConBaseLic", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaselic, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseLicProm", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaselicprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFer", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbasefer, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFerProm", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaseferprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExt", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbasehorext, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExtProm", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbasehorextprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBasePres", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbasepres, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAnt", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaseant, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseOSDif", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaseosdif, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_Sdtconcepto_old_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAus", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaseaus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAusProm", GXutil.trim( GXutil.str( gxTv_Sdtconcepto_old_Conbaseausprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
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
      AddObjectProperty("ConBaseLic", gxTv_Sdtconcepto_old_Conbaselic, false, false);
      AddObjectProperty("ConBaseLicProm", gxTv_Sdtconcepto_old_Conbaselicprom, false, false);
      AddObjectProperty("ConBaseFer", gxTv_Sdtconcepto_old_Conbasefer, false, false);
      AddObjectProperty("ConBaseFerProm", gxTv_Sdtconcepto_old_Conbaseferprom, false, false);
      AddObjectProperty("ConBaseHorExt", gxTv_Sdtconcepto_old_Conbasehorext, false, false);
      AddObjectProperty("ConBaseHorExtProm", gxTv_Sdtconcepto_old_Conbasehorextprom, false, false);
      AddObjectProperty("ConBasePres", gxTv_Sdtconcepto_old_Conbasepres, false, false);
      AddObjectProperty("ConBaseAnt", gxTv_Sdtconcepto_old_Conbaseant, false, false);
      AddObjectProperty("ConBaseOSDif", gxTv_Sdtconcepto_old_Conbaseosdif, false, false);
      AddObjectProperty("ConDescrip", gxTv_Sdtconcepto_old_Condescrip, false, false);
      AddObjectProperty("ConBaseAus", gxTv_Sdtconcepto_old_Conbaseaus, false, false);
      AddObjectProperty("ConBaseAusProm", gxTv_Sdtconcepto_old_Conbaseausprom, false, false);
   }

   public byte getgxTv_Sdtconcepto_old_Conbaselic( )
   {
      return gxTv_Sdtconcepto_old_Conbaselic ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaselic( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaselic = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaselicprom( )
   {
      return gxTv_Sdtconcepto_old_Conbaselicprom ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaselicprom( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaselicprom = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbasefer( )
   {
      return gxTv_Sdtconcepto_old_Conbasefer ;
   }

   public void setgxTv_Sdtconcepto_old_Conbasefer( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbasefer = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaseferprom( )
   {
      return gxTv_Sdtconcepto_old_Conbaseferprom ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaseferprom( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaseferprom = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbasehorext( )
   {
      return gxTv_Sdtconcepto_old_Conbasehorext ;
   }

   public void setgxTv_Sdtconcepto_old_Conbasehorext( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbasehorext = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbasehorextprom( )
   {
      return gxTv_Sdtconcepto_old_Conbasehorextprom ;
   }

   public void setgxTv_Sdtconcepto_old_Conbasehorextprom( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbasehorextprom = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbasepres( )
   {
      return gxTv_Sdtconcepto_old_Conbasepres ;
   }

   public void setgxTv_Sdtconcepto_old_Conbasepres( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbasepres = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaseant( )
   {
      return gxTv_Sdtconcepto_old_Conbaseant ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaseant( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaseant = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaseosdif( )
   {
      return gxTv_Sdtconcepto_old_Conbaseosdif ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaseosdif( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaseosdif = value ;
   }

   public String getgxTv_Sdtconcepto_old_Condescrip( )
   {
      return gxTv_Sdtconcepto_old_Condescrip ;
   }

   public void setgxTv_Sdtconcepto_old_Condescrip( String value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Condescrip = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaseaus( )
   {
      return gxTv_Sdtconcepto_old_Conbaseaus ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaseaus( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaseaus = value ;
   }

   public byte getgxTv_Sdtconcepto_old_Conbaseausprom( )
   {
      return gxTv_Sdtconcepto_old_Conbaseausprom ;
   }

   public void setgxTv_Sdtconcepto_old_Conbaseausprom( byte value )
   {
      gxTv_Sdtconcepto_old_N = (byte)(0) ;
      gxTv_Sdtconcepto_old_Conbaseausprom = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtconcepto_old_N = (byte)(1) ;
      gxTv_Sdtconcepto_old_Condescrip = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconcepto_old_N ;
   }

   public web.Sdtconcepto_old Clone( )
   {
      return (web.Sdtconcepto_old)(clone()) ;
   }

   public void setStruct( web.StructSdtconcepto_old struct )
   {
      setgxTv_Sdtconcepto_old_Conbaselic(struct.getConbaselic());
      setgxTv_Sdtconcepto_old_Conbaselicprom(struct.getConbaselicprom());
      setgxTv_Sdtconcepto_old_Conbasefer(struct.getConbasefer());
      setgxTv_Sdtconcepto_old_Conbaseferprom(struct.getConbaseferprom());
      setgxTv_Sdtconcepto_old_Conbasehorext(struct.getConbasehorext());
      setgxTv_Sdtconcepto_old_Conbasehorextprom(struct.getConbasehorextprom());
      setgxTv_Sdtconcepto_old_Conbasepres(struct.getConbasepres());
      setgxTv_Sdtconcepto_old_Conbaseant(struct.getConbaseant());
      setgxTv_Sdtconcepto_old_Conbaseosdif(struct.getConbaseosdif());
      setgxTv_Sdtconcepto_old_Condescrip(struct.getCondescrip());
      setgxTv_Sdtconcepto_old_Conbaseaus(struct.getConbaseaus());
      setgxTv_Sdtconcepto_old_Conbaseausprom(struct.getConbaseausprom());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconcepto_old getStruct( )
   {
      web.StructSdtconcepto_old struct = new web.StructSdtconcepto_old ();
      struct.setConbaselic(getgxTv_Sdtconcepto_old_Conbaselic());
      struct.setConbaselicprom(getgxTv_Sdtconcepto_old_Conbaselicprom());
      struct.setConbasefer(getgxTv_Sdtconcepto_old_Conbasefer());
      struct.setConbaseferprom(getgxTv_Sdtconcepto_old_Conbaseferprom());
      struct.setConbasehorext(getgxTv_Sdtconcepto_old_Conbasehorext());
      struct.setConbasehorextprom(getgxTv_Sdtconcepto_old_Conbasehorextprom());
      struct.setConbasepres(getgxTv_Sdtconcepto_old_Conbasepres());
      struct.setConbaseant(getgxTv_Sdtconcepto_old_Conbaseant());
      struct.setConbaseosdif(getgxTv_Sdtconcepto_old_Conbaseosdif());
      struct.setCondescrip(getgxTv_Sdtconcepto_old_Condescrip());
      struct.setConbaseaus(getgxTv_Sdtconcepto_old_Conbaseaus());
      struct.setConbaseausprom(getgxTv_Sdtconcepto_old_Conbaseausprom());
      return struct ;
   }

   protected byte gxTv_Sdtconcepto_old_Conbaselic ;
   protected byte gxTv_Sdtconcepto_old_N ;
   protected byte gxTv_Sdtconcepto_old_Conbaselicprom ;
   protected byte gxTv_Sdtconcepto_old_Conbasefer ;
   protected byte gxTv_Sdtconcepto_old_Conbaseferprom ;
   protected byte gxTv_Sdtconcepto_old_Conbasehorext ;
   protected byte gxTv_Sdtconcepto_old_Conbasehorextprom ;
   protected byte gxTv_Sdtconcepto_old_Conbasepres ;
   protected byte gxTv_Sdtconcepto_old_Conbaseant ;
   protected byte gxTv_Sdtconcepto_old_Conbaseosdif ;
   protected byte gxTv_Sdtconcepto_old_Conbaseaus ;
   protected byte gxTv_Sdtconcepto_old_Conbaseausprom ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtconcepto_old_Condescrip ;
}

