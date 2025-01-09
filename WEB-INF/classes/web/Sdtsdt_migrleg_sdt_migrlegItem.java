package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_migrleg_sdt_migrlegItem extends GxUserType
{
   public Sdtsdt_migrleg_sdt_migrlegItem( )
   {
      this(  new ModelContext(Sdtsdt_migrleg_sdt_migrlegItem.class));
   }

   public Sdtsdt_migrleg_sdt_migrlegItem( ModelContext context )
   {
      super( context, "Sdtsdt_migrleg_sdt_migrlegItem");
   }

   public Sdtsdt_migrleg_sdt_migrlegItem( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_migrleg_sdt_migrlegItem");
   }

   public Sdtsdt_migrleg_sdt_migrlegItem( StructSdtsdt_migrleg_sdt_migrlegItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegNumero") )
            {
               gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MigrLegId") )
            {
               gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid = oReader.getValue() ;
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
         sName = "sdt_migrleg.sdt_migrlegItem" ;
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
      oWriter.writeElement("MigrLegNumero", GXutil.trim( GXutil.str( gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("MigrLegId", gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid);
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
      AddObjectProperty("MigrLegNumero", gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero, false, false);
      AddObjectProperty("MigrLegId", gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid, false, false);
   }

   public int getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero( )
   {
      return gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero ;
   }

   public void setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero( int value )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N = (byte)(0) ;
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero = value ;
   }

   public String getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid( )
   {
      return gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid ;
   }

   public void setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid( String value )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N = (byte)(0) ;
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N = (byte)(1) ;
      gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N ;
   }

   public web.Sdtsdt_migrleg_sdt_migrlegItem Clone( )
   {
      return (web.Sdtsdt_migrleg_sdt_migrlegItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_migrleg_sdt_migrlegItem struct )
   {
      setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero(struct.getMigrlegnumero());
      setgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid(struct.getMigrlegid());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_migrleg_sdt_migrlegItem getStruct( )
   {
      web.StructSdtsdt_migrleg_sdt_migrlegItem struct = new web.StructSdtsdt_migrleg_sdt_migrlegItem ();
      struct.setMigrlegnumero(getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero());
      struct.setMigrlegid(getgxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_migrleg_sdt_migrlegItem_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegnumero ;
   protected String gxTv_Sdtsdt_migrleg_sdt_migrlegItem_Migrlegid ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

