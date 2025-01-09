package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_art_sdt_artItem extends GxUserType
{
   public Sdtsdt_art_sdt_artItem( )
   {
      this(  new ModelContext(Sdtsdt_art_sdt_artItem.class));
   }

   public Sdtsdt_art_sdt_artItem( ModelContext context )
   {
      super( context, "Sdtsdt_art_sdt_artItem");
   }

   public Sdtsdt_art_sdt_artItem( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_art_sdt_artItem");
   }

   public Sdtsdt_art_sdt_artItem( StructSdtsdt_art_sdt_artItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ARTSec") )
            {
               gxTv_Sdtsdt_art_sdt_artItem_Artsec = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ARTNom") )
            {
               gxTv_Sdtsdt_art_sdt_artItem_Artnom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ARTAli") )
            {
               gxTv_Sdtsdt_art_sdt_artItem_Artali = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "sdt_art.sdt_artItem" ;
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
      oWriter.writeElement("ARTSec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_art_sdt_artItem_Artsec, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ARTNom", gxTv_Sdtsdt_art_sdt_artItem_Artnom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ARTAli", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_art_sdt_artItem_Artali, 6, 4)));
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
      AddObjectProperty("ARTSec", gxTv_Sdtsdt_art_sdt_artItem_Artsec, false, false);
      AddObjectProperty("ARTNom", gxTv_Sdtsdt_art_sdt_artItem_Artnom, false, false);
      AddObjectProperty("ARTAli", gxTv_Sdtsdt_art_sdt_artItem_Artali, false, false);
   }

   public short getgxTv_Sdtsdt_art_sdt_artItem_Artsec( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artsec ;
   }

   public void setgxTv_Sdtsdt_art_sdt_artItem_Artsec( short value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artsec = value ;
   }

   public String getgxTv_Sdtsdt_art_sdt_artItem_Artnom( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artnom ;
   }

   public void setgxTv_Sdtsdt_art_sdt_artItem_Artnom( String value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artnom = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_art_sdt_artItem_Artali( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_Artali ;
   }

   public void setgxTv_Sdtsdt_art_sdt_artItem_Artali( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(0) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artali = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_art_sdt_artItem_N = (byte)(1) ;
      gxTv_Sdtsdt_art_sdt_artItem_Artnom = "" ;
      gxTv_Sdtsdt_art_sdt_artItem_Artali = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_art_sdt_artItem_N ;
   }

   public web.Sdtsdt_art_sdt_artItem Clone( )
   {
      return (web.Sdtsdt_art_sdt_artItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_art_sdt_artItem struct )
   {
      setgxTv_Sdtsdt_art_sdt_artItem_Artsec(struct.getArtsec());
      setgxTv_Sdtsdt_art_sdt_artItem_Artnom(struct.getArtnom());
      setgxTv_Sdtsdt_art_sdt_artItem_Artali(struct.getArtali());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_art_sdt_artItem getStruct( )
   {
      web.StructSdtsdt_art_sdt_artItem struct = new web.StructSdtsdt_art_sdt_artItem ();
      struct.setArtsec(getgxTv_Sdtsdt_art_sdt_artItem_Artsec());
      struct.setArtnom(getgxTv_Sdtsdt_art_sdt_artItem_Artnom());
      struct.setArtali(getgxTv_Sdtsdt_art_sdt_artItem_Artali());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_art_sdt_artItem_N ;
   protected short gxTv_Sdtsdt_art_sdt_artItem_Artsec ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtsdt_art_sdt_artItem_Artali ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_art_sdt_artItem_Artnom ;
}

